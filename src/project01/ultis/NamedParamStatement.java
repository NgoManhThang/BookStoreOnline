package project01.ultis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NamedParamStatement {
	private PreparedStatement prepStmt;
    private List<String> fields = new ArrayList<String>();
    
    public PreparedStatement getPreparedStatement() {
        return prepStmt;
    }
    public ResultSet executeQuery() throws SQLException {
        return prepStmt.executeQuery();
    }
    
    public int executeUpdate() throws SQLException{
    	return prepStmt.executeUpdate();
    }
    
    public void close() throws SQLException {
        prepStmt.close();
    }

    public void setInt(String name, int value) throws SQLException {        
        prepStmt.setInt(getIndex(name), value);
    }
    
    public void setString(String name, String value) throws SQLException {        
        prepStmt.setString(getIndex(name), value);
    }
    
    public void setDouble(String name, Double value) throws SQLException {        
        prepStmt.setDouble(getIndex(name), value);
    }

    private int getIndex(String name) {
        return fields.indexOf(name)+1;
    }
    
    public NamedParamStatement(Connection conn, String sql) throws SQLException {
        int pos;
        while((pos = sql.indexOf(":")) != -1) {
            int end = sql.substring(pos).indexOf(" ");
            if (end == -1)
                end = sql.length();
            else
                end += pos;
            fields.add(sql.substring(pos+1,end));
            sql = sql.substring(0, pos) + "?" + sql.substring(end);
        }       
        prepStmt = conn.prepareStatement(sql);
    }
}
