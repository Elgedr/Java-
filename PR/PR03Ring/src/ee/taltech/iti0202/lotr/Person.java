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

    /**
     *
     * @param ring ring type to set
     */
    public void setRing(Ring ring) {
        this.ring = ring;
    } //присваиваем кольцо герою. или же меняем старое кольцо на новое

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return race
     */
    public String getRace() {
        return race;
    }

    /**
     *
     * @return ring object
     */
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
}
