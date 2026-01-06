package okBusinessLogic;

import java.util.List;

import okDataAccess.okEstadoCivilDAO;
import okDataAccess.okDTO.okEstadoCivilDTO;


public class okEstadoCivilBL {

    private okEstadoCivilDTO eCivilDTO;
    private okEstadoCivilDAO eCivilDAO = new okEstadoCivilDAO();
    
    public okEstadoCivilBL() {}

    public List<okEstadoCivilDTO> getAll() throws Exception {
        List<okEstadoCivilDTO> Lst = eCivilDAO.okreadAll(); 
        for (okEstadoCivilDTO eCivilDTO : Lst) 
            eCivilDTO.setNombre(eCivilDTO.getNombre().toUpperCase());
        return Lst;
    }

    public okEstadoCivilDTO getBy(int idReg) throws Exception {
        eCivilDTO = eCivilDAO.okreadBy(idReg);
        return eCivilDTO;
    }

    public boolean okset(okEstadoCivilDTO regDTO) throws Exception {   // create == set == add == insert
        return eCivilDAO.okcreate(regDTO);
    }

    public boolean okupdate(okEstadoCivilDTO regDTO) throws Exception {
        return eCivilDAO.okupdate(regDTO);
    }

    public boolean okdelete(int idReg) throws Exception {
        return eCivilDAO.okdelete(idReg);
    }

    public Integer okgetRowCount() throws Exception {
        return eCivilDAO.okgetRowCount();
    }
}
