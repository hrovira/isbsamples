package org.isb.sample;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author hector
 */
public class MyService5 {
    private JdbcTemplate jdbcTemplate;
    private Integer excludedId;

    /*
    * Public Setter Methods
    */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setExcludedId(Integer excludedId) {
        this.excludedId = excludedId;
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

        String sql = "SELECT ID, LABEL FROM FOO_TABLE WHERE ID NOT IN (?)";
        jdbcTemplate.query(sql, new Object[]{excludedId}, extractor);
        return foos;
    }
}
