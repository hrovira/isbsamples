package org.isb.sample;

/**
 * @author hector
 */
public class Foo {
    private Integer id;
    private String label;

    public Foo(Integer id, String label) {
        setId(id);
        setLabel(label);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }    
}
