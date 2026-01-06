package okDataAccess;

import java.util.List;

public interface okIDAO<T> {  // obligatorio implementar los metodos CRUD en los DAO
    
    boolean okcreate(T entity)    throws Exception;
    List<T> okreadAll()           throws Exception;
    boolean okupdate(T entity)    throws Exception;
    boolean okdelete(Integer id)  throws Exception;
    
    T       okreadBy(Integer id)  throws Exception;
    Integer okgetRowCount()       throws Exception;
}
