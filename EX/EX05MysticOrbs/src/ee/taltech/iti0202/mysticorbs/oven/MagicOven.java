package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.exceptions.CannotFixException;
import ee.taltech.iti0202.mysticorbs.orb.MagicOrb;
import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Optional;

public class MagicOven extends Oven implements Fixable {
    private int orbsMadeByMagicOven = 0;

    /**
     *
     * @param name .
     * @param resourceStorage .
     */
    public MagicOven(String name, ResourceStorage resourceStorage) {
        super(name, resourceStorage);
    }

    @Override
    public boolean isBroken() {
        return orbsMadeByMagicOven >= 5;
    }

    @Override
    public Optional<Orb> craftOrb() {
        if (!isBroken() && resourceStorage.hasEnoughResource("gold", 1)
                && resourceStorage.hasEnoughResource("dust", 3)) {
            Orb newObject;
            if (orbsMadeByMagicOven + 1 % 2 == 0) {
                newObject = new MagicOrb(this.name);
            } else {
                newObject = new Orb(this.name);
            }
            newObject.charge("gold", 1);
            newObject.charge("dust", 3);
            resourceStorage.takeResource("gold", 1);
            resourceStorage.takeResource("dust", 3);
            allOrbs.add(newObject);
            orbsMadeByMagicOven++;
            return Optional.of(newObject);
        }
        return Optional.empty();
    }

    @Override
    public void fix() throws CannotFixException {
        //TODO
    }

    @Override
    public int getTimesFixed() {
        //TODO
        return 0;
    }
}
