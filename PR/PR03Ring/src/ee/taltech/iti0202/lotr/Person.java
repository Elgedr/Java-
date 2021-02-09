package ee.taltech.iti0202.lotr;

public class Person {
    private final String race;
    private final String name;
    private Ring ring;

    /**
     * Firt constructor
     * @param race race of hero
     * @param name name of hero
     * @param ring Ring object
     */
    public Person(String race, String name, Ring ring) {
        this.race = race;
        this.name = name;
        this.ring = ring;
    } //конструктор. При создании нового объекта этого класса прийдется указывать эти данные.

    /**
     * Second constructor
     * @param race set race to object
     * @param name set name to onject
     */
    public Person(String race, String name) {
        this.race = race;
        this.name = name;
    } //конструтор на тот случай,если при создании объекта не написали кольцо. его мы присвоим герою в отдельном методе

    public void setRing(Ring ring) {
        this.ring = ring;
    } //присваиваем кольцо герою. или же меняем старое кольцо на новое

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public Ring getRing() {
        return ring;
    }

    /**
     *
     * @return message if the sauron is real
     */
    public String isSauron() {
        if (getName().equals("Sauron") && this.ring == null) {
            return "No, but he's claiming to be";
        } else if (!(getName().equals("Sauron")) && this.ring == null) {
            return "No";
        } else if (getName().equals("Sauron") && getRing().getType().equals(Ring.Type.THE_ONE)
                && getRing().getMaterial() == Ring.Material.GOLD) {
            return "Affirmative";
        } else if (getName().equals("Sauron") && getRing().getType().equals(Ring.Type.THE_ONE)
                && !(getRing().getMaterial() == Ring.Material.GOLD)) {
            return "No, the ring is fake!";
        } else if (!(getName().equals("Sauron")) && getRing().getType().equals(Ring.Type.THE_ONE)
                && getRing().getMaterial() == Ring.Material.GOLD) {
            return "No, he just stole the ring";
        } else if (getName().equals("Sauron") && !(getRing().getType().equals(Ring.Type.THE_ONE))) {
            return "No, but he's claiming to be";
        } else {
            return "No";
        }
    }

    public static void main(String[] args) {
        // LOTR simplified play through
        Ring theRing = new Ring(Ring.Type.THE_ONE, Ring.Material.GOLD);
        Person sauron = new Person("Maiar", "Sauron");
        sauron.setRing(theRing);
// after some 4000 years, Gollum got the ring
        Person gollum = new Person("Hobbit", "Gollum");
// let's remove ring from Sauron
        sauron.setRing(null);
        gollum.setRing(theRing);
// after about 500 years, Bilbo got the ring
        Person bilbo = new Person("Hobbit", "Bilbo Baggins");
        gollum.setRing(null);
        bilbo.setRing(theRing);
// after 60 years, Frodo got the ring
        Person frodo = new Person("Hobbit", "Frodo Baggins");
        bilbo.setRing(null);
        frodo.setRing(theRing);

// check Sauron
        Ring fakeOne = new Ring(Ring.Type.THE_ONE, Ring.Material.PLASTIC);
        sauron.setRing(fakeOne);
        System.out.println(sauron.isSauron()); // No, the ring is fake!
        System.out.println(frodo.isSauron()); // No, he just stole the ring
        Ring nenya = new Ring(Ring.Type.NENYA, Ring.Material.DIAMOND);
        sauron.setRing(nenya);
        System.out.println(sauron.isSauron()); // No, but he's claiming to be
        frodo.setRing(nenya);
        System.out.println(frodo.isSauron()); // No
        sauron.setRing(theRing);
        System.out.println(sauron.isSauron()); // Affirmative
    }
}
