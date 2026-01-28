package DataAccess.DAOs;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

import DataAccess.DTOs.okSexoDTO;
import DataAccess.Helpers.okDataHelperSQLiteDAO;
import Infrastructure.okAppException;

public class okSexoDAO extends okDataHelperSQLiteDAO<okSexoDTO> {

    public okSexoDAO() throws okAppException {
        super(okSexoDTO.class, "Catalogo", "IdCatalogo");
    }

    @Override
    public boolean okcreate(okSexoDTO entity) throws okAppException {
        //2              ,'Masculino'       ,'tipos de sexualidad'
        String query = "INSERT INTO Catalogo (IdCatalogoTipo, Nombre, Descripcion) VALUES (?, ?, ?)";
        try {
            Connection         conn  = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 2);
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
    public List<okSexoDTO> okreadAll() throws okAppException {
        List <okSexoDTO> Lst = new ArrayList<>();
        String query =" SELECT IdCatalogo    " 
                     +" ,IdCatalogoTipo      "
                     +" ,Nombre              "
                     +" ,Descripcion         "
                     +" ,Estado              " 
                     +" ,FechaCreacion       "
                     +" ,FechaModifica       "
                     +" FROM Catalogo        "
                     +" WHERE Estado = 'A'   "
                     +" AND IdCatalogoTipo = 2";
        try {
            Connection        conn  = openConnection();
            Statement         stmt  = conn.createStatement();
            ResultSet         rs    = stmt.executeQuery(query);
            while (rs.next()) {
                okSexoDTO s = new okSexoDTO(rs.getInt (1) 
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

    public boolean okupdate(okSexoDTO entity) throws okAppException {
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

    public okSexoDTO okreadBy(Integer id) throws okAppException {
        okSexoDTO s = new okSexoDTO();
        String query =" SELECT IdCatalogo    " 
                     +" ,IdCatalogoTipo      "
                     +" ,Nombre              "
                     +" ,Descripcion         "
                     +" ,Estado              " 
                     +" ,FechaCreacion       "
                     +" ,FechaModifica       "
                     +" FROM Catalogo        "
                     +" WHERE  Estado = 'A'   "
                     +" AND    IdCatalogoTipo = 2"
                     +" AND    IdCatalogo = " + id.toString();
        try {
            Connection        conn  = openConnection();
            Statement         stmt  = conn.createStatement();
            ResultSet         rs    = stmt.executeQuery(query);
            while (rs.next()) {
                s = new okSexoDTO(rs.getInt (1) 
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

    public Integer okgetRowCount() throws okAppException {
        String query =" SELECT COUNT(*) TotalReg " 
                     +" FROM Catalogo            "
                     +" WHERE Estado = 'A'       "
                     +" AND IdCatalogoTipo = 2";
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