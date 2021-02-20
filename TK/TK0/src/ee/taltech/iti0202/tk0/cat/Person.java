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

    boolean sellCat(Person sellTo, Cat cat){
        if (catsList.contains(cat) && !(sellTo == this)){
            sellTo.addCat(cat);
            this.catsList.remove(cat);
            return true;
        }
        return false;
    }
}
