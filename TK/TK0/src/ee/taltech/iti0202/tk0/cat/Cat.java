package ee.taltech.iti0202.tk0.cat;

public class Cat {
    private int age;
    private String name;
    private String colour;

    public Cat(String name){
        this.name = name;
    }

    public Cat(String name, String colour, int age){
        this.age = age;
        this.name = name;
        this.colour = colour;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        if (this.getColour() != null && this.getName() != null) {
            return colour + " " + name + " " + age;
        }
        return name;
    }
}
