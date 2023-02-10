package io.aptech.Entity;

import java.text.DateFormat;
import java.time.LocalDateTime;

public class Borrow {
    private int borrow_id;
    private Reader reader;
    private LocalDateTime borrow_date;
    private LocalDateTime return_date;
    private String return_status;

    public Borrow() {
    }

    public Borrow(Reader reader, LocalDateTime borrow_date, LocalDateTime return_date, String return_status) {
        this.reader = reader;
        this.borrow_date = borrow_date;
        this.return_date = return_date;
        this.return_status = return_status;
    }

    public int getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(int borrow_id) {
        this.borrow_id = borrow_id;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public LocalDateTime getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(LocalDateTime borrow_date) {
        this.borrow_date = borrow_date;
    }

    public LocalDateTime getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDateTime return_date) {
        this.return_date = return_date;
    }

    public String getReturn_status() {
        return return_status;
    }

    public void setReturn_status(String return_status) {
        this.return_status = return_status;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "borrow_id=" + borrow_id +
                ", reader=" + reader +
                ", borrow_date=" + borrow_date +
                ", return_date=" + return_date +
                ", return_status='" + return_status + '\'' +
                '}';
    }
}
