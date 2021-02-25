package ee.taltech.iti0202.tk1.art;

import java.util.ArrayList;
import java.util.List;

public class Collector {
    List<Painting> res = new ArrayList<>();

    /**
     *
     * @param painting painting.
     * @return boolean.
     */
    public boolean addPainting(Painting painting) {
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

    /**
     *
     * @param painting painting.
     * @param fellowCollector fellowcollector.
     * @return boolean.
     */
    public boolean sellPainting(Painting painting, Collector fellowCollector) {
        if (fellowCollector.addPainting(painting) && fellowCollector != this && res.contains(painting)) {
            return true;
        }
        return false;
    }

    public List<Painting> getPaintings() {
        return res;
    }

}
