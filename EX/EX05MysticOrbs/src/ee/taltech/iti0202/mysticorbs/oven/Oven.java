package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.exceptions.CannotFixException;
import ee.taltech.iti0202.mysticorbs.factory.OrbFactory;
import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.LinkedList;
import java.util.Optional;


public class Oven implements Comparable<Oven> {
    public static final int FIFTEEN = 15;
    public String name;
    public ResourceStorage resourceStorage;
    public Boolean isMagic = false;
    public Boolean isSpace = false;
    private int orbsMadeInOven = 0;
    public static LinkedList<Orb> allOrbs = new LinkedList<>();

    /**
     * @param name            .
     * @param resourceStorage .
     */
    public Oven(String name, ResourceStorage resourceStorage) {
        this.name = name;
        this.resourceStorage = resourceStorage;
    }

    /**
     * @return .
     */
    public String getName() {
        return name;
    }

    /**
     * @return .
     */
    public ResourceStorage getResourceStorage() {
        return resourceStorage;
    }

    /**
     * @return .
     */
    public int getCreatedOrbsAmount() {
        return orbsMadeInOven;
    }

    /**
     * @return .
     */
    public boolean isBroken() {
        return orbsMadeInOven >= FIFTEEN;
    }

    /**
     * @return .
     */
    public Optional<Orb> craftOrb() {
        if (!isBroken() && resourceStorage.hasEnoughResource("pearl", 1)
                && resourceStorage.hasEnoughResource("silver", 1)) {
            Orb newObject = new Orb(this.name);
            newObject.charge("pearl", 1);
            newObject.charge("silver", 1);
            resourceStorage.takeResource("pearl", 1);
            resourceStorage.takeResource("silver", 1);
            allOrbs.add(newObject);
            orbsMadeInOven++;
            return Optional.of(newObject);
        }
        return Optional.empty();
    }

//    @Override
//    public int compareTo(Oven o) {
//        if (this.isBroken() && !o.isBroken()) {
//            return -1;
//        } else if (!this.isBroken() && o.isBroken()) {
//            return 1;
//        } else if (this.isBroken() && o.isBroken() || !this.isBroken() && !o.isBroken()) {
//            if (this instanceof SpaceOven) {
//                return 1;
//            } else if (o instanceof SpaceOven) {
//                return -1;
//            } else if (this instanceof MagicOven) {
//                return 1;
//            } else if (o instanceof MagicOven) {
//                return -1;
//            }
//        } else if (this instanceof MagicOven && o instanceof MagicOven) {
//            if (((MagicOven) this).orbsMadeByMagicOven + 1 == 2 || ((MagicOven) this).orbsMadeByMagicOven + 1 == 4) {
//                return 1;
//            } else if (((MagicOven) o).orbsMadeByMagicOven + 1 == 2 || ((MagicOven) o).orbsMadeByMagicOven + 1 == 4) {
//                return -1;
//            }
//        } else if (this instanceof MagicOven && o instanceof InfinityMagicOven && ((MagicOven) this).orbsMadeByMagicOven == ((InfinityMagicOven) o).orbsMadeByInfinityMagicOven) {
//            return -1;
//        } else if (this instanceof InfinityMagicOven && o instanceof MagicOven && ((MagicOven) this).orbsMadeByMagicOven == ((InfinityMagicOven) o).orbsMadeByInfinityMagicOven){
//            return 1;
//        }
//    }


    public void fix() throws CannotFixException {
    }

    @Override
    public int compareTo(Oven o) {
        return 0;
    }
}
