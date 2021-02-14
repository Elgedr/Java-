package ee.taltech.iti0202.bookshelf;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int money;
    private Book hisBook;
    private List<Book> personBooks = new ArrayList<>();

    /**
     * Constructor
     * @param name person's name
     * @param money person's current money
     */
    public Person(String name, int money) {
        this.name = name;
        this.money = money;
    }

    /**
     *
     * @return person's name
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return person's money
     */
    public int getMoney() {
        return this.money;
    }

    /**
     *
     * @param book book object
     * @return if it is possible to buy a book or not
     */
    public boolean buyBook(Book book) {
        if (book == null || this.money < book.getPrice() || book.getOwner() != null) {
            return false;
        } else {
            this.money -= book.getPrice();
            book.setOwner(this);
            personBooks.add(book);
            return true;
        }
    }

    /**
     *
     * @param book book object
     * @return if it is possible to sell a book or not
     */
    public boolean sellBook(Book book) {
        if (book != null && book.getOwner() == this) {
            this.money += book.getPrice();
            this.hisBook = null;
            personBooks.remove(book);
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return List of books
     */
    public List<Book> getBooks() {
        return personBooks;
    }
}
