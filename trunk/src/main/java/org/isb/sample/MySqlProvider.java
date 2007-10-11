package org.isb.sample;

import org.springframework.jdbc.core.SqlProvider;

/**
 * @author hector
 */
public class MySqlProvider implements SqlProvider {
    private String sqlToProvide;

    /*
     * Public Setter Methods
     */
    public void setSqlToProvide(String sqlToProvide) {
        this.sqlToProvide = sqlToProvide;
    }

    /*
    * Method Implementations: SqlProvider
    */
    public String getSql() {
        return sqlToProvide;
    }
}
