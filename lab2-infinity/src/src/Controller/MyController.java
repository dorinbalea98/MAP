package Controller;


import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import Exceptions.ControllerExceptions;

import Exceptions.RepoExceptions;

import Repository.MyIRepository;

import Statements.PrgState;

public class MyController implements MyIController{

	private MyIRepository repo;
	ExecutorService executor;
	Map<Integer,Integer> conservativeGarbageCollector(Collection<Integer> symTableValues,
			Map<Integer,Integer> heap){
			return heap.entrySet().stream()
			 .filter(e->symTableValues.contains(e.getKey()))
			 .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));}
	public MyController(MyIRepository r)
	{
		repo=r;
	}
	@Override
	public void allSteps() throws ControllerExceptions {
		executor = Executors.newFixedThreadPool(2);
		List<PrgState> prgList = removeCompletedPrg(repo.getPrgList());
		while(prgList.size() > 0){
			oneStepForAllPrg(prgList);
			prgList= removeCompletedPrg(repo.getPrgList());
		}
		executor.shutdownNow();
		repo.setPrgList(prgList);
		
	}
	@Override
	public void setLogPath(String log) {
		this.repo.setLogPath(log);
	}
	@Override
	public List<PrgState> removeCompletedPrg(List<PrgState> prgList) {
		return prgList.stream()
				.filter(p->p.isNotCompleted())
				.collect(Collectors.toList());
	}
	@Override
	public void oneStepForAllPrg(List<PrgState> prgList) {
		
		prgList.forEach(prg->{
			try {
				repo.logPrgStateExec(prg);
			} catch (RepoExceptions e) {
				System.out.println(e.getMessage());
			}
		});
		
		
		
		List<Callable<PrgState>> callList = prgList.stream()
				.map((PrgState p) -> (Callable<PrgState>)(() -> {return p.oneStep();}))
				.collect(Collectors.toList());
		
		List<PrgState> newPrgList;
		try {
			newPrgList = executor.invokeAll(callList).stream()
					.map(future->  { 
					try {
							return future.get();
					} catch (Exception e) {
						return null;
					}})
					.filter(p -> p!=null)
					.collect(Collectors.toList());
			
			prgList.addAll(newPrgList);
			prgList.forEach(prg->{
				try {
					repo.logPrgStateExec(prg);
				} catch (RepoExceptions e) {
					System.out.println(e.getMessage());
				}
			});
			repo.setPrgList(prgList);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		
	}


}
