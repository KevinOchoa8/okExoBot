package DataAccess.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

import DataAccess.DTOs.okPersonaTipoDTO;
import DataAccess.Helpers.okDataHelperSQLiteDAO;
import Infrastructure.okAppException;


public class okPersonaTipoDAO extends okDataHelperSQLiteDAO<okPersonaTipoDTO> {

    public okPersonaTipoDAO() throws okAppException {
        super(okPersonaTipoDTO.class, "Catalogo", "idCatalogo");
    }

    @Override
    public boolean okcreate(okPersonaTipoDTO entity) throws okAppException {
        //1              ,'Soldado'         ,'tipos de personas del ejercito'
        String query = "INSERT INTO Catalogo (idCatalogoTipo, nombre, descripcion) VALUES (?, ?, ?)";
        try {
            Connection         conn  = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 1);
            pstmt.setString(2, entity.getNombre());
            pstmt.setString(3, entity.getDescripcion());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            throw new okAppException(e.getMessage());
        }
    }

    @Override
    public List<okPersonaTipoDTO> okreadAll() throws okAppException {
        List <okPersonaTipoDTO> Lst = new ArrayList<>();
        String query =" SELECT IdCatalogo    " 
                     +" ,IdCatalogoTipo      "
                     +" ,Nombre              "
                     +" ,Descripcion         "
                     +" ,Estado              " 
                     +" ,FechaCreacion       "
                     +" ,FechaModifica       "
                     +" FROM Catalogo        "
                     +" WHERE Estado = 'A'   "
                     +" AND IdCatalogoTipo = 1";
        try {
            Connection        conn  = openConnection();
            Statement         stmt  = conn.createStatement();
            ResultSet         rs    = stmt.executeQuery(query);
            while (rs.next()) {
                okPersonaTipoDTO s = new okPersonaTipoDTO(rs.getInt (1) 
                                           ,rs.getInt (2)
                                           ,rs.getString (3)
                                           ,rs.getString (4)
                                           ,rs.getString (5)
                                           ,rs.getString (6)
                                           ,rs.getString (7));
                Lst.add(s);
            }
        }
        catch (SQLException e) {
            throw new okAppException(e.getMessage());
        }
        return Lst;
   }

    @Override
    public boolean okupdate(okPersonaTipoDTO entity) throws okAppException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Catalogo SET nombre = ? , descripcion = ? , fechaModifica = ? WHERE idCatalogo = ?";
        try {
            Connection         conn  = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getDescripcion());
            pstmt.setString(3, dtf.format(now));
            pstmt.setInt   (4, entity.getIdCatalogo());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            throw new okAppException(e.getMessage());
        }
    }

    @Override
    public boolean okdelete(Integer id) throws okAppException {
        String query = "UPDATE Catalogo SET estado = 'I' WHERE idCatalogo = ?";
        try {
            Connection         conn  = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            throw new okAppException(e.getMessage());
        }
    }

    @Override
    public okPersonaTipoDTO okreadBy(Integer id) throws okAppException {
        okPersonaTipoDTO s = new okPersonaTipoDTO();
        String query =" SELECT IdCatalogo    " 
                     +" ,IdCatalogoTipo      "
                     +" ,Nombre              "
                     +" ,Descripcion         "
                     +" ,Estado              " 
                     +" ,FechaCreacion       "
                     +" ,FechaModifica       "
                     +" FROM Catalogo        "
                     +" WHERE  Estado = 'A'   "
                     +" AND    IdCatalogoTipo = 1"
                     +" AND    IdCatalogo = " + id.toString();
        try {
            Connection        conn  = openConnection();
            Statement         stmt  = conn.createStatement();
            ResultSet         rs    = stmt.executeQuery(query);
            while (rs.next()) {
                s = new okPersonaTipoDTO(rs.getInt (1) 
                                           ,rs.getInt (2)
                                           ,rs.getString (3)
                                           ,rs.getString (4)
                                           ,rs.getString (5)
                                           ,rs.getString (6)
                                           ,rs.getString (7));
              
            }
        }
        catch (SQLException e) {
            throw new okAppException(e.getMessage());
        }
        return s;
        
    }

    public Integer okgetRowCount() throws Exception {
        String query =" SELECT COUNT(*) TotalReg " 
                     +" FROM Catalogo            "
                     +" WHERE Estado = 'A'       "
                     +" AND IdCatalogoTipo = 1";
        try {
            Connection        conn  = openConnection(); 
            Statement         stmt  = conn.createStatement();
            ResultSet         rs    = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1);         //TotalReg
            }
        }
        catch (SQLException e) {
            throw new okAppException(e.getMessage());
        }
        return 0;
    }

}