package org.isb.sample;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author hector
 */
public class MyService3 {
    private JdbcTemplate jdbcTemplate;

    /*
    * Public Setter Methods
    */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Returns a foo collection from database
     *
     * @return Collection of foos
     */
    public Collection<Foo> getFoosFromDatabase() {
        ArrayList<Foo> foos = new ArrayList<Foo>();
        MyResultSetExtractor extractor = new MyResultSetExtractor();
        extractor.setFoos(foos);
        jdbcTemplate.query("SELECT ID, LABEL FROM FOO_TABLE", extractor);
        return foos;
    }
}
