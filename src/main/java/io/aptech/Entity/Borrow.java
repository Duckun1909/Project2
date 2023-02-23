package io.aptech.Entity;

import java.text.DateFormat;
import java.time.LocalDateTime;

public class Borrow {
    private int borrow_id;
    private float payment;
    private Reader reader;

    public Borrow() {
    }

    public Borrow(int borrow_id,Reader reader, float payment){
        this.payment = payment;
        this.reader = reader;
    }

    public int getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(int borrow_id) {
        this.borrow_id = borrow_id;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "borrow_id=" + borrow_id +
                ", payment=" + payment +
                ", reader=" + reader +
                '}';
    }
}
