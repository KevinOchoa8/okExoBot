package okDataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import okDataAccess.okDTO.okEstadoCivilDTO;
import okFramework.okException;

public class okEstadoCivilDAO extends okDataHelperSQLite implements okIDAO<okEstadoCivilDTO> {

    @Override
    public boolean okcreate(okEstadoCivilDTO entity) throws Exception {
        // 3              ,'Soltero'         ,'tipos de estado civil ecuatoriano'         
        String query = "INSERT INTO Catalogo (idCatalogoTipo, nombre, descripcion) VALUES (?, ?, ?)";
        try {
            Connection         conn  = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 3);
            pstmt.setString(2, entity.getNombre());
            pstmt.setString(3, entity.getDescripcion());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            throw new okException(e.getMessage(), getClass().getName(), "okcreate()");
        }
    }

    @Override
    public List<okEstadoCivilDTO> okreadAll() throws Exception {
        List <okEstadoCivilDTO> Lst = new ArrayList<>();
        String query =" SELECT IdCatalogo    " 
                     +" ,IdCatalogoTipo      "
                     +" ,Nombre              "
                     +" ,Descripcion         "
                     +" ,Estado              " 
                     +" ,FechaCreacion       "
                     +" ,FechaModifica       "
                     +" FROM Catalogo        "
                     +" WHERE Estado = 'A'   "
                     +" AND IdCatalogoTipo = 3";
        try {
            Connection        conn  = openConnection();
            Statement         stmt  = conn.createStatement();
            ResultSet         rs    = stmt.executeQuery(query);
            while (rs.next()) {
                okEstadoCivilDTO s = new okEstadoCivilDTO(rs.getInt (1) 
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
            throw new okException(e.getMessage(), getClass().getName(), "okreadAll()");
        }
        return Lst;
   }

    @Override
    public boolean okupdate(okEstadoCivilDTO entity) throws Exception {
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
            throw new okException(e.getMessage(), getClass().getName(), "okupdate()");
        }
    }

    @Override
    public boolean okdelete(Integer id) throws Exception {
        String query = "UPDATE Catalogo SET estado = 'I' WHERE idCatalogo = ?";
        try {
            Connection         conn  = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            throw new okException(e.getMessage(), getClass().getName(), "okdelete()");
        }
    }

    @Override
    public okEstadoCivilDTO okreadBy(Integer id) throws Exception {
        okEstadoCivilDTO s = new okEstadoCivilDTO();
        String query =" SELECT IdCatalogo    " 
                     +" ,IdCatalogoTipo      "
                     +" ,Nombre              "
                     +" ,Descripcion         "
                     +" ,Estado              " 
                     +" ,FechaCreacion       "
                     +" ,FechaModifica       "
                     +" FROM Catalogo        "
                     +" WHERE  Estado = 'A'   "
                     +" AND    IdCatalogoTipo = 3"
                     +" AND    IdCatalogo = " + id.toString();
        try {
            Connection        conn  = openConnection();
            Statement         stmt  = conn.createStatement();
            ResultSet         rs    = stmt.executeQuery(query);
            while (rs.next()) {
                s = new okEstadoCivilDTO(rs.getInt (1) 
                                           ,rs.getInt (2)
                                           ,rs.getString (3)
                                           ,rs.getString (4)
                                           ,rs.getString (5)
                                           ,rs.getString (6)
                                           ,rs.getString (7));
              
            }
        }
        catch (SQLException e) {
            throw new okException(e.getMessage(), getClass().getName(), "okreadBy()");
        }
        return s;
        
    }

    public Integer okgetRowCount() throws Exception {
        String query =" SELECT COUNT(*) TotalReg " 
                     +" FROM Catalogo            "
                     +" WHERE Estado = 'A'       "
                     +" AND IdCatalogoTipo = 3";
        try {
            Connection        conn  = openConnection(); 
            Statement         stmt  = conn.createStatement();
            ResultSet         rs    = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1);         //TotalReg
            }
        }
        catch (SQLException e) {
            throw new okException(e.getMessage(), getClass().getName(), "okgetRowCount()");
        }
        return 0;
    }

}


