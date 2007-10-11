package org.isb.sample;

import java.sql.*;

/**
 * @author hector
 */
public abstract class MyAbstractService {
    /**
     * Executes query
     * @param url - connection
     * @param sql - statement
     * @throws java.sql.SQLException - throw exception, catch exception? Differentiate between a sql exception and a connection exception?
     */
    public void executeQuery(String url, String sql) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqldb://localhost:1414;username=joe;password=mybirthday");
            ps = connection.prepareStatement("SELECT ID, LABEL FROM FOO_TABLE");
            rs = ps.executeQuery();
            processResultSet(rs);
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
    }

    /**
     * Do your business logic here
     *
     * @param rs - resultset
     * @throws SQLException - if problems accessing resultset
     */
    protected abstract void processResultSet(ResultSet rs) throws SQLException;
}
