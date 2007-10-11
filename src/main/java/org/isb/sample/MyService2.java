package org.isb.sample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author hector
 */
public class MyService2 extends MyAbstractService {
    private ArrayList<Foo> foos = new ArrayList<Foo>();

    /**
     * Returns a foo collection from database
     *
     * @return Collection of foos
     * @throws SQLException - throw exception, catch exception? Differentiate between a sql exception and a connection exception?
     */
    public Collection<Foo> getFoosFromDatabase() throws SQLException {
        String connection = "jdbc:sqldb://localhost:1414;username=joe;password=mybirthday";
        String sql = "SELECT ID, LABEL FROM FOO_TABLE";
        super.executeQuery(connection, sql);
        return foos;
    }

    /*
    * Method Implementations: MyAbstractService
    */
    protected void processResultSet(ResultSet rs) throws SQLException {
        while (rs.next()) {
            Integer id = rs.getInt("ID");
            String label = rs.getString("LABEL");
            foos.add(new Foo(id, label));
        }
    }
}
