package io.aptech.Entity;

public class Author {
    private int au_id;
    private String au_name;
    private String au_description;

    public Author() {
    }

    public Author(int id, String au_name, String au_description) {
        this.au_id = id;
        this.au_name = au_name;
        this.au_description = au_description;
    }

    public int getAu_id() {
        return au_id;
    }

    public void setAu_id(int id) {
        this.au_id = id;
    }

    public String getAu_name() {
        return au_name;
    }

    public void setAu_name(String au_name) {
        this.au_name = au_name;
    }

    public String getAu_description() {
        return au_description;
    }

    public void setAu_description(String au_description) {
        this.au_description = au_description;
    }

    @Override
    public String toString() {
        return this.getAu_name();
    }
}
