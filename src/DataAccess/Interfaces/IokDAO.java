package DataAccess.Interfaces;

import java.util.List;

import Infrastructure.okAppException;

public interface IokDAO<T> {
    List<T> okreadAll()            throws okAppException;
    T       okreadBy (Integer id)  throws okAppException;
    boolean okcreate (T entity)    throws okAppException;
    boolean okupdate (T entity)    throws okAppException;
    boolean okdelete (Integer id)  throws okAppException;
    Integer okgetCountReg()        throws okAppException;
    Integer okgetMinReg(String tableCelName) throws okAppException;
    Integer okgetMaxReg(String tableCelName) throws okAppException;
}
    