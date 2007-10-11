package org.isb.sample;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * @author hector
 */
public class MyResultSetExtractor implements ResultSetExtractor {
    private Collection<Foo> foos;

    /*
     * Public Setter Methods
     */
    public void setFoos(Collection<Foo> foos) {
        this.foos = foos;
    }

    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        while (resultSet.next()) {
            Integer id = resultSet.getInt("ID");
            String label = resultSet.getString("LABEL");
            foos.add(new Foo(id, label));
        }
        return null;
    }

}
