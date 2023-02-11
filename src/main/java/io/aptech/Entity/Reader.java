package io.aptech.Entity;

public class Reader {
    private int reader_id;
    private String reader_name;
    private String reader_phone;
    private String reader_address;
    private String reader_cid;

    public Reader() {
   
    public Reader(int reader_id,String reader_name, String reader_phone, String reader_address, String reader_cid) {
    
    public Reader(int reader_id, String reader_name, String reader_phone, String reader_address, String reader_cid) {
        this.reader_id = reader_id;
        this.reader_name = reader_name;
        this.reader_phone = reader_phone;
        this.reader_address = reader_address;
        this.reader_cid = reader_cid;
    }

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public String getReader_name() {
        return reader_name;
    }

    public void setReader_name(String reader_name) {
        this.reader_name = reader_name;
    }

    public String getReader_phone() {
        return reader_phone;
    }

    public void setReader_phone(String reader_phone) {
        this.reader_phone = reader_phone;
    }

    public String getReader_address() {
        return reader_address;
    }

    public void setReader_address(String reader_address) {
        this.reader_address = reader_address;
    }

    public String getReader_cid() {
        return reader_cid;
    }

    public void setReader_cid(String reader_cid) {
        this.reader_cid = reader_cid;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "reader_id=" + reader_id +
                ", reader_name='" + reader_name + '\'' +
                ", reader_phone='" + reader_phone + '\'' +
                ", reader_address='" + reader_address + '\'' +
                ", reader_cid='" + reader_cid + '\'' +
                '}';
    }
}
