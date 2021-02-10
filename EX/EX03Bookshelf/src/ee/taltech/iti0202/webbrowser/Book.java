package ee.taltech.iti0202.webbrowser;

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

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public int getYearOfPublishing(){
        return this.yearOfPublishing;
    }

    public int getPrice(){
        return this.price;
    }

    public int getId(){
        return this.id;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Person getOwner(){
        return this.owner;
    }

    public boolean buy(Person buyer){
        if (this.owner == buyer || buyer.getMoney() < this.price || !buyer.buyBook(this)
                || !this.owner.sellBook(this)){
            return false;
        } else {
            this.owner.sellBook(this);
            buyer.buyBook(this);
            return true;
        }
    }

    public static int getAndIncrementNextId(){
        return futureid;
    }

}
