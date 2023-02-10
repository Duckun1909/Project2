package io.aptech.Entity;

public class Category {
    private int cat_id;
    private String cat_name;
    private String cat_description;

    public Category() {
    }

    public Category(int id, String cat_name, String cat_description) {
        this.cat_id = id;
        this.cat_name = cat_name;
        this.cat_description = cat_description;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int id) {
        this.cat_id = id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getCat_description() {
        return cat_description;
    }

    public void setCat_description(String cat_description) {
        this.cat_description = cat_description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + cat_id +
                ", cat_name='" + cat_name + '\'' +
                ", cat_description='" + cat_description + '\'' +
                '}';
    }
}
