package ee.taltech.iti0202.bookshelf;

import java.util.List;

public class Book {
    private static int futureid;
    private String title;
    private String author;
    private int yearOfPublishing;
    private int price;
    private int id = -1; //ид должен начинаться с 0. так как при создании делаем +1, как раз первый ид будет 0
    private Person owner;

    public Book(String title, String author, int yearOfPublishing, int price){
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.price = price;
        this.id ++; //при создании новой книги у нее будет новый ид. на 1 больше
        futureid = this.id + 1;
    }

    /**
     *
     * @return book's title
     */
    public String getTitle(){
        return this.title;
    }

    /**
     *
     * @return book's author
     */
    public String getAuthor(){
        return this.author;
    }

    /**
     *
     * @return year og publishing
     */
    public int getYearOfPublishing(){
        return this.yearOfPublishing;
    }

    /**
     *
     * @return book's price
     */
    public int getPrice(){
        return this.price;
    }

    /**
     *
     * @return book's id
     */
    public int getId(){
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
     * @return ger=t a current book's owner
     */
    public Person getOwner(){
        return this.owner;
    }

    /**
     *
     * @param buyer buyer object
     * @return if book was bought or not
     */
    public boolean buy(Person buyer){
        if (this.owner == buyer || buyer.getMoney() < this.price || !buyer.buyBook(this)
                || !this.owner.sellBook(this)) {
            return false;
        } else {
            this.owner.sellBook(this);
            buyer.buyBook(this);
            return true;
        }
    }

    public static int getAndIncrementNextId() {
        return futureid;
    }

    public static Book of(String title, String author, int yearOfPublishing, int price) {
        return null;
    }

    public static Book of(String title, int price) {
        return null;
    }

    public static List<Book> getBooksByOwner(Person owner) {
        return null;
    }

    public static boolean removeBook(Book book) {
        return true;
    }

    public static List<Book> getBooksByAuthor(String author) {
        return null;
    }


}
