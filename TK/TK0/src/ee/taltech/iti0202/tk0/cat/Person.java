package ee.taltech.iti0202.tk0.cat;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<Cat> catsList = new ArrayList<>();

    private boolean addCat(Cat cat){
        if (!catsList.contains(cat)){
            catsList.add(cat);
            return true;
        }
        return false;
    }

    public List<Cat> getCats() {
        return catsList;
    }

    public boolean sellCat(Person sellTo, Cat cat){
        if (catsList.contains(cat) && !(sellTo == this)){
            sellTo.addCat(cat);
            this.catsList.remove(cat);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Cat cat = new Cat("Mati");
        System.out.println(cat);
        Cat muri = new Cat("Muri", 3, "White");
        System.out.println(muri);

        Person malle = new Person();
        Person kalle = new Person();
        System.out.println(malle.addCat(cat)); // true
        System.out.println(malle.addCat(cat)); // false

        malle.sellCat(kalle, cat); // true
        System.out.println(malle.getCats()); // []
        System.out.println(kalle.getCats()); // [Mati]
    }
}


