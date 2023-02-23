package io.aptech.Entity;

public class Publisher {
    private int pus_id;
    private String pus_name;
    private String pus_email;
    private String pus_web;
    private String pus_address;

    public Publisher() {
    }

    public Publisher( String pus_name, String pus_email, String pus_web, String pus_address) {
        this.pus_name = pus_name;
        this.pus_email = pus_email;
        this.pus_web = pus_web;
        this.pus_address = pus_address;
    }

    public int getPus_id() {
        return pus_id;
    }

    public void setPus_id(int pus_id) {
        this.pus_id = pus_id;
    }

    public String getPus_name() {
        return pus_name;
    }

    public void setPus_name(String pus_name) {
        this.pus_name = pus_name;
    }

    public String getPus_email() {
        return pus_email;
    }

    public void setPus_email(String pus_email) {
        this.pus_email = pus_email;
    }

    public String getPus_web() {
        return pus_web;
    }

    public void setPus_web(String pus_web) {
        this.pus_web = pus_web;
    }

    public String getPus_address() {
        return pus_address;
    }

    public void setPus_address(String pus_address) {
        this.pus_address = pus_address;
    }

    @Override
    public String toString() {
        return this.getPus_name();
    }
}
