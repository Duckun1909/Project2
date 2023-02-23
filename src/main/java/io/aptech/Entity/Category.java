package io.aptech.Entity;

public class Category {
    private int cat_id;

    private String cat_code;
    private String cat_name;
    private String cat_description;

    public Category() {
    }

    public Category(int cat_id, String cat_code, String cat_name, String cat_description) {
        this.cat_id = cat_id;
        this.cat_code = cat_code;
        this.cat_name = cat_name;
        this.cat_description = cat_description;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_code() {
        return cat_code;
    }

    public void setCat_code(String cat_code) {
        this.cat_code = cat_code;
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
        return this.getCat_name();
    }
}
