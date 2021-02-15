package ee.taltech.iti0202.bookshelf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Book {
    private static int globalid = -1; //ид должен начинаться с -1. так как при создании делаем +1,
    // как раз первый ид будет 0. эта переменная статическая т.е глобальная и она не сбрасывается
    // при создании нового объекта. статичные переменные не привязаны к объекту
    private static List<Book> booksOf = new ArrayList<>();
    private static HashMap<String, Book> authorAndBook = new HashMap<>();
    private static String previousAuthor;
    private static int previousYear = -100;

    private String title;
    private String author;
    private int yearOfPublishing;
    private int price;
    private int id;
    private Person owner;

    /**
     *
     * @param title book's title
     * @param author book's author
     * @param yearOfPublishing book's year of publishing
     * @param price book's price
     */
    public Book(String title, String author, int yearOfPublishing, int price) {
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.price = price;
        globalid += 1; //при создании новой книги у нее будет новый ид. на 1 больше
        this.id = globalid;
        authorAndBook.put(author.toLowerCase(), this);

    }

    /**
     *
     * @return book's title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     *
     * @return book's author
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     *
     * @return year og publishing
     */
    public int getYearOfPublishing() {
        return this.yearOfPublishing;
    }

    /**
     *
     * @return book's price
     */
    public int getPrice() {
        return this.price;
    }

    /**
     *
     * @return book's id
     */
    public int getId() {
        return this.id;
    }

    /**
     *
     * @param owner set book's new owner
     */
    public void setOwner(Person owner) {
        this.owner = owner;
    }

    /**
     *
     * @return get a current book's owner
     */
    public Person getOwner() {
        if (this.owner != null) {
            return this.owner;
        }
        return null;
    }

    /**
     *
     * @param buyer buyer object
     * @return if book was bought or not
     */
    public boolean buy(Person buyer) {
        if (this.owner == null && buyer != null) {
            buyer.buyBook(this);
        } else if (this.owner != null && buyer == null) {
            this.owner.sellBook(this);
            return true;
        } else if (this.owner == buyer || buyer.getMoney() <= this.price) {
            return false;
        } else {
            this.owner.sellBook(this);
            buyer.buyBook(this);
        }
        return true;
    }

    /**
     *
     * @return id of a future book
     */
    public static int getAndIncrementNextId() {
        globalid += 1;
        return globalid;
    }

    /**
     *
     * @param title book's title
     * @param author book's author credentials
     * @param yearOfPublishing book's year of publishing
     * @param price book's price
     * @return book object
     */
    public static Book of(String title, String author, int yearOfPublishing, int price) {
        if (booksOf.size() > 0) {
            for (Book book:booksOf) {
                if (book.title.equals(title) && book.author.equals(author) && book.yearOfPublishing
                        == yearOfPublishing && book.price == price) {
                    return book;
                }
            }
        }
        Book newBook = new Book(title, author, yearOfPublishing, price);
        previousAuthor = author;
        previousYear = yearOfPublishing;
        booksOf.add(newBook);
        authorAndBook.put(author.toLowerCase(), newBook);

        return newBook;
    }

    /**
     *
     * @param title book's title
     * @param price book's price
     * @return book object
     */
    public static Book of(String title, int price) {
        if (previousYear == -100 && previousAuthor == null){
            return null;
        } else {
            Book newBook = new Book(title, previousAuthor, previousYear, price);
            authorAndBook.put(previousAuthor.toLowerCase(), newBook);
            booksOf.add(newBook);
            return newBook;
        }
    }

    /**
     *
     * @param owner person object
     * @return list of books by owner
     */
    public static List<Book> getBooksByOwner(Person owner) {
        return owner.getBooks();
    }

    /**
     *
     * @param book book object
     * @return bool
     */
    public static boolean removeBook(Book book) {
        if (book == null || !booksOf.contains(book)){
            return false;
        } if (book.getOwner() != null) {
            book.getOwner().sellBook(book);
            booksOf.remove(book);
            authorAndBook.remove(book.getAuthor(), book);
        } else {
            booksOf.remove(book);
            authorAndBook.remove(book.getAuthor(), book);
        }
        return true;
    }

    /**
     *
     * @param author author's credentials
     * @return list of books by author
     */
    public static List<Book> getBooksByAuthor(String author) {
        List<Book> res = new ArrayList<>();
        HashMap<String, Book> copy = new HashMap<>(authorAndBook);
        while (copy.containsKey(author.toLowerCase())){
            res.add(copy.get(author.toLowerCase()));
            copy.remove(author.toLowerCase());
        }
        return res;
    }


}
