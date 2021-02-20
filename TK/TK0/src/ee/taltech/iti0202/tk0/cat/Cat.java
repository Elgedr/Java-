package ee.taltech.iti0202.tk0.cat;

public class Cat {
    private Integer age;
    private String name;
    private String colour;

    public Cat(String name){
        this.name = name;
    }

    public Cat(String name,int age, String colour){
        this.colour = colour;
        this.age = age;
        this.name = name;

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

    public String getColor() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        if (this.getColor() != null && this.getName() != null && age != null) {
            return colour + " " + name + " (" + age + ")";
        }
        return name;
    }
}
