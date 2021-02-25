package ee.taltech.iti0202.tk1.art;

import java.util.ArrayList;
import java.util.List;

public class Collector {
    List<Painting> res = new ArrayList<>();

    boolean addPainting(Painting painting) {
        if (!res.contains(painting)) {
            for (Painting paint : res) {
                if (paint.title.equals(painting.title)) {
                    return false;
                }
            }
            res.add(painting);
            return true;
        }
        return false;
    }

    boolean sellPainting(Painting painting, Collector fellowCollector) {
        if (addPainting(painting) && fellowCollector != this && res.contains(painting)){
           return true;
        }
        return false;
    }

    List<Painting> getPaintings() {
        return res;
    }

}
