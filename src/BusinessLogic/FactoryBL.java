package BusinessLogic;

import java.util.List;

import DataAccess.Interfaces.IokDAO;
import Infrastructure.okAppException;

public class FactoryBL<T>  {
    private final IokDAO<T> oDAO;

    public FactoryBL(Class<? extends IokDAO<T>> classDAO) {
        try {
            this.oDAO = classDAO.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            okAppException er = new okAppException("Error al instanciar classDAO<T>", e, getClass(), "FactoryBL(<T>)");
            throw new RuntimeException(er);
        }
    }

    // Constructor que usa un Supplier para crear la instancia de T
    // public FactoryBL(Supplier<IDAO<T>> supplier) {
    //     this.oDAO = supplier.get(); 
    // }
 
    public List<T> getAll() throws okAppException {
         return oDAO.okreadAll();
    }

    public T getBy(Integer id) throws okAppException {
        return oDAO.okreadBy(id);
    }

    public boolean add(T oT) throws okAppException {
        return oDAO.okcreate(oT);
    }

    public boolean upd(T oT) throws okAppException {
        return oDAO.okupdate(oT);
    }

    public boolean del(Integer id) throws okAppException {
        return oDAO.okdelete(id);
    }

    public Integer getMaxReg(String cellName) throws okAppException{
        return oDAO.okgetMaxReg(cellName);
    }

    public Integer getMinReg(String cellName) throws okAppException{
        return oDAO.okgetMinReg(cellName);
    }

    public Integer getCountReg() throws Exception{
        return oDAO.okgetCountReg();
    }
}
