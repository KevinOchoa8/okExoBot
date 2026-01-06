package okBusinessLogic;

import okDataAccess.okDTO.okSexoDTO;
import okDataAccess.okSexoDAO;

import java.util.List;


public class okSexoBL {

    private okSexoDTO sexoDTO;
    private okSexoDAO sexoDAO = new okSexoDAO();
    
    public okSexoBL() {}

    public List<okSexoDTO> getAll() throws Exception {
        List<okSexoDTO> Lst = sexoDAO.okreadAll(); 
        for (okSexoDTO sexoDTO : Lst) 
            sexoDTO.setNombre(sexoDTO.getNombre().toUpperCase());
        return Lst;
    }

    public okSexoDTO getBy(int idSexo) throws Exception {
        sexoDTO = sexoDAO.okreadBy(idSexo);
        return sexoDTO;
    }

    public boolean okset(okSexoDTO sexoDTO) throws Exception {   // create == set == add == insert
        return sexoDAO.okcreate(sexoDTO);
    }

    public boolean okupdate(okSexoDTO sexoDTO) throws Exception {
        return sexoDAO.okupdate(sexoDTO);
    }

    public boolean okdelete(int idSexo) throws Exception {
        return sexoDAO.okdelete(idSexo);
    }

    public Integer okgetRowCount() throws Exception {
        return sexoDAO.okgetRowCount();
    }

}


