package cr.ac.ucenfotec.dl;

import java.sql.*;

public class AccesoBD {

    private Connection conexion;
    private Statement statement;
    private ResultSet rs;

    public AccesoBD(String address, String user, String pw) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexion = DriverManager.getConnection(address, user, pw);
        statement = conexion.createStatement();
    }

    public void ejecutarStatement(String statement) throws SQLException {
        this.statement = conexion.createStatement();
        this.statement.executeUpdate(statement);
    }

    public ResultSet ejecutarQuery(String query) throws SQLException{
        rs = statement.executeQuery(query);
        return rs;
    }

}