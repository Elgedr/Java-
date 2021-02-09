package ee.taltech.iti0202.lotr;

public class Person {
    private String race;
    private String name;
    private Ring ring;

    public Person(String race, String name, Ring ring){
        this.race = race;
        this.name = name;
        this.ring = ring;
    } //конструктор. При создании нового объекта этого класса прийдется указывать эти данные.

    public Person(String race, String name){
        this.race = race;
        this.name = name;
    } //конструтор на тот случай, если при создании объекта не написали кольцо. его мы присвоим герою в отдельном методе

    public void setRing(Ring ring){
        this.ring = ring;
    } //присваиваем кольцо герою. или же меняем старое кольцо на новое

    public String isSauron(){
        return null;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public Ring getRing() {
        return ring;
    }
}
