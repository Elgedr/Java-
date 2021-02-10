package ee.taltech.iti0202.bookshelf;

import java.util.List;

public class Person {
    private String name;
    private int money;
    private Book hisBook;

    public Person(String name, int money){
        this.name = name;
        this.money = money;
    }

    public String getName(){
        return this.name;
    }

    public int getMoney(){
        return this.money;
    }

    public boolean buyBook(Book book){
        if (book == null || this.money < book.getPrice() || book.getOwner() != null){
            return false;
        } else {
            this.money -= book.getPrice();
            book.setOwner(this);
            this.hisBook = book;
            return true;
        }
    }

    public boolean sellBook(Book book){
        if (this.hisBook != book || book.getOwner() != this || book == null){
            return false;
        } else {
            this.money += book.getPrice();
            this.hisBook = null;
            return true;
        }
    }

    public List<Book> getBooks(){
        return null;
    }
}