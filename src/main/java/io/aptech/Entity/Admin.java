package io.aptech.Entity;

public class Admin {
    private int adm_id;
    private String adm_name;
    private String adm_pass;
    private String adm_fullname;

    public Admin() {
    }

    public Admin(int adm_id, String adm_name, String adm_pass, String adm_fullname) {
        this.adm_id = adm_id;
        this.adm_name = adm_name;
        this.adm_pass = adm_pass;
        this.adm_fullname = adm_fullname;
    }

    public int getAdm_id() {
        return adm_id;
    }

    public void setAdm_id(int id) {
        this.adm_id = id;
    }

    public String getAdm_name() {
        return adm_name;
    }

    public void setAdm_name(String adm_name) {
        this.adm_name = adm_name;
    }

    public String getAdm_pass() {
        return adm_pass;
    }

    public void setAdm_pass(String adm_pass) {
        this.adm_pass = adm_pass;
    }

    public String getAdm_fullname() {
        return adm_fullname;
    }

    public void setAdm_fullname(String adm_fullname) {
        this.adm_fullname = adm_fullname;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + adm_id +
                ", adm_name='" + adm_name + '\'' +
                ", adm_pass='" + adm_pass + '\'' +
                ", adm_fullname='" + adm_fullname + '\'' +
                '}';
    }
}
