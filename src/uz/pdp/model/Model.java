package uz.pdp.model;

public abstract class Model {
    private long id;
    private String sortProperty;
    private String name;

    public Model(Model model1) {
        this.id = System.currentTimeMillis();
    }

    public Model(String sortProperty, String name) {
        this.id=System.currentTimeMillis();
        this.sortProperty = sortProperty;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getSortProperty() {
        return sortProperty;
    }

    public void setSortProperty(String sortProperty) {
        this.sortProperty = sortProperty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
