package org.isb.sample;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.SqlProvider;

import java.util.ArrayList;
import java.util.Collection;

import com.mits.common.factories.ReferenceInstanceFactory;

/**
 * @author hector
 */
public class MyService4 {
    private JdbcTemplate jdbcTemplate;
    private SqlProvider sqlProvider;
    private PreparedStatementSetter preparedStatementSetter;
    private ReferenceInstanceFactory<ResultSetExtractor, Collection<Foo>> foosResultSetExtractor;

    /*
    * Public Setter Methods
    */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setSqlProvider(SqlProvider sqlProvider) {
        this.sqlProvider = sqlProvider;
    }

    public void setPreparedStatementSetter(PreparedStatementSetter preparedStatementSetter) {
        this.preparedStatementSetter = preparedStatementSetter;
    }

    public void setFoosResultSetExtractor(ReferenceInstanceFactory<ResultSetExtractor, Collection<Foo>> foosResultSetExtractor) {
        this.foosResultSetExtractor = foosResultSetExtractor;
    }

    /**
     * Returns a foo collection from database
     *
     * @return Collection of foos
     * @throws Exception (instantiation of resultsetextractor)
     */
    public Collection<Foo> getFoosFromDatabase() throws Exception {
        ArrayList<Foo> foos = new ArrayList<Foo>();
        ResultSetExtractor resultSetExtractor = foosResultSetExtractor.getInstance(foos);
        jdbcTemplate.query(sqlProvider.getSql(), preparedStatementSetter, resultSetExtractor);
        return foos;
    }
}
