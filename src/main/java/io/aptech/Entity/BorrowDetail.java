package io.aptech.Entity;

public class BorrowDetail {
    private int borrowDetail_id;
    private Borrow borrow;
    private Book book;
    private float payment;

    public BorrowDetail() {
    }

    public BorrowDetail(int borrowDetail_id,Borrow borrow, Book book, float payment) {
        this.borrowDetail_id = borrowDetail_id;
        this.borrow = borrow;
        this.book = book;
        this.payment = payment;
    }

    public int getBorrowDetail_id() {
        return borrowDetail_id;
    }

    public void setBorrowDetail_id(int borrowDetail_id) {
        this.borrowDetail_id = borrowDetail_id;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "BorrowDetail{" +
                "borrowDetail_id=" + borrowDetail_id +
                ", borrow=" + borrow +
                ", book=" + book +
                ", payment=" + payment +
                '}';
    }
}
