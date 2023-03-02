package io.aptech.Entity;

import java.sql.Date;

public class BorrowDetail {
    private int id;
    private Borrow borrow;
    private Book book;
    private Date borrowDate;
    private Date returnDate;
    private String note;
    private String status;

    public BorrowDetail() {
    }

    public BorrowDetail(int id, Borrow borrow, Book book, Date borrowDate, Date returnDate, String note, String status) {
        this.id = id;
        this.borrow = borrow;
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.note = note;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getBorowDate() {
        return borrowDate;
    }

    public void setBorowDate(Date borowDate) {
        this.borrowDate = borowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BorrowDetail{" +
                "id=" + id +
                ", borrow=" + borrow +
                ", book=" + book +
                ", borowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", returnStatus='" + note + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
