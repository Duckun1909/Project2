package io.aptech.Entity;

public class Book {
    private int book_id;
    private String book_name;
    private float book_price;
    private String book_description;
    private String book_image;
    private String book_status;
    private Category cat_id ;
    private Author au_id ;
    private Publisher pus_id ;
    private String book_code;

    public Book() {
    }

    public Book(String book_name, float book_price, String book_description, String book_image, String book_status, Category cat_id, Author au_id, Publisher pus_id, String book_code) {
        this.book_name = book_name;
        this.book_price = book_price;
        this.book_description = book_description;
        this.book_image = book_image;
        this.book_status = book_status;
        this.cat_id = cat_id;
        this.au_id = au_id;
        this.pus_id = pus_id;
        this.book_code = book_code;
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

    public String getBook_status() {
        return book_status;
    }

    public void setBook_status(String book_status) {
        this.book_status = book_status;
    }

    public Category getCategory() {
        return cat_id;
    }

    public void setCategory(Category category) {
        this.cat_id = category;
    }

    public void setCategory_name(String category_name){
        this.cat_id.setCat_name(category_name);
    }


    public Author getAuthor() {
        return au_id;
    }

    public void setAuthor(Author author) {
        this.au_id = author;
    }
    public void setAuthor_id(int author_id) {
        this.au_id.setAu_id(author_id);
    }
    public void setAuthor_name(String author_name) {
        this.au_id.setAu_name(author_name);
    }

    public Publisher getPublisher() {
        return pus_id;
    }

    public void setPublisher(Publisher publisher) {
        this.pus_id = publisher;
    }
    public void setPublisher_id(int publisher_id) {
        this.pus_id.setPus_id(publisher_id);
    }
    public void setPublisher_name(String publisher_name) {
        this.pus_id.setPus_name(publisher_name);
    }
    public String getBook_code() {
        return book_code;
    }

    public void setBook_code(String book_code) {
        this.book_code = book_code;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", book_price=" + book_price +
                ", book_description='" + book_description + '\'' +
                ", book_image='" + book_image + '\'' +
                ", book_status='" + book_status + '\'' +
                ", cat_id=" + cat_id +
                ", au_id=" + au_id +
                ", pus_id=" + pus_id +
                ", book_code='" + book_code + '\'' +
                '}';
    }
}
