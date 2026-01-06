package okBusinessLogic;

import java.util.List;

import okDataAccess.okPersonaTipoDAO;
import okDataAccess.okDTO.okPersonaTipoDTO;

public class okPersonaTipoBL {

    private okPersonaTipoDTO personaTipoDTO;
    private okPersonaTipoDAO personaTipoDAO = new okPersonaTipoDAO();
    
    public okPersonaTipoBL() {}

    public List<okPersonaTipoDTO> getAll() throws Exception {
        return personaTipoDAO.okreadAll();
    }

    public okPersonaTipoDTO getBy(int idReg) throws Exception {
        personaTipoDTO = personaTipoDAO.okreadBy(idReg);
        return personaTipoDTO;
    }

    public boolean okset(okPersonaTipoDTO regDTO) throws Exception {   // create == set == add == insert
        return personaTipoDAO.okcreate(regDTO);
    }

    public boolean okupdate(okPersonaTipoDTO regDTO) throws Exception {
        return personaTipoDAO.okupdate(regDTO);
    }

    public boolean okdelete(int idReg) throws Exception {
        return personaTipoDAO.okdelete(idReg);
    }

    public Integer okgetRowCount() throws Exception {
        return personaTipoDAO.okgetRowCount();
    }
}
