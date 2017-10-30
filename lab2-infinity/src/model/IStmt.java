package model;

import Exceptions.StmtExceptions;

public interface IStmt {
	
	public PrgState execute(PrgState state) throws StmtExceptions;

}
