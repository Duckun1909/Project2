package io.aptech.Entity;

public class Book {
    private int book_id;
    private String book_name;
    private float book_price;
    private String book_description;
    private String book_image;
    private String book_status;
    private Category category;
    private Author author;
    private Publisher publisher;

    public Book() {
    }

    public Book(int book_id, String book_name, float book_price, String book_image, String book_status, String book_description) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_price = book_price;
        this.book_description = book_description;
        this.book_image = book_image;
        this.book_status = book_status;
    }

    public Book(int book_id, String book_name, Author author, Publisher publisher, float book_price, String book_image , String book_quantity, String book_description, Category category) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_price = book_price;
        this.book_description = book_description;
        this.book_image = book_image;
        this.book_status = book_quantity;
        this.category = category;
        this.author = author;
        this.publisher = publisher;
    }



    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public float getBook_price() {
        return book_price;
    }

    public void setBook_price(float book_price) {
        this.book_price = book_price;
    }

    public String getBook_description() {
        return book_description;
    }

    public void setBook_description(String book_description) {
        this.book_description = book_description;
    }

    public String getBook_image() {
        return book_image;
    }

    public void setBook_image(String book_image) {
        this.book_image = book_image;
    }

    public String getBook_quantity() {
        return book_status;
    }

    public void setBook_quantity(String book_quantity) {
        this.book_status = book_quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
