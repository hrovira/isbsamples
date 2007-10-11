package org.isb.sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author hector
 */
public class MyService1 {
    /**
     * Returns a foo collection from database
     *
     * @return Collection of foos
     * @throws SQLException - throw exception, catch exception? Differentiate between a sql exception and a connection exception?
     */
    public Collection<Foo> getFoosFromDatabase() throws SQLException {
        ArrayList<Foo> foos = new ArrayList<Foo>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqldb://localhost:1414;username=joe;password=mybirthday");
            ps = connection.prepareStatement("SELECT ID, LABEL FROM FOO_TABLE");
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("ID");
                String label = rs.getString("LABEL");
                foos.add(new Foo(id, label));
            }
        } catch (SQLException ex) {
            // TODO: throw exception, catch exception?
            ex.printStackTrace();
            throw ex;
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                // TODO: throw exception, catch exception?
                e.printStackTrace();
            }
        }
        return foos;
    }
}
