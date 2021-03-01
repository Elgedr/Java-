package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.exceptions.CannotFixException;
import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.orb.SpaceOrb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Optional;

public class SpaceOven extends Oven implements Fixable {
    public static final int TWENTY_FIVE = 25;
    public static final int FIFTEEN = 15;
    private int orbsMadeBySpaceOven = 0;

    /**
     * @param name            .
     * @param resourceStorage .
     */
    public SpaceOven(String name, ResourceStorage resourceStorage) {
        super(name, resourceStorage);
    }

    @Override
    public boolean isBroken() {
        return this.orbsMadeBySpaceOven >= TWENTY_FIVE;
    }

    @Override
    public Optional<Orb> craftOrb() {
        if (!isBroken() && resourceStorage.hasEnoughResource("meteorite stone", 1)
                && resourceStorage.hasEnoughResource("star fragment", FIFTEEN)) {
            if (resourceStorage.hasEnoughResource("meteorite stone", 1)
                    && resourceStorage.hasEnoughResource("star fragment", FIFTEEN)) {
                Orb newObject = new SpaceOrb(this.name);
                resourceStorage.takeResource("meteorite stone", 1);
                resourceStorage.takeResource("star fragment", FIFTEEN);
                allOrbs.add(newObject);
                orbsMadeBySpaceOven++;
                return Optional.of(newObject);
            }
        } else if (resourceStorage.hasEnoughResource("pearl", 1)
                && resourceStorage.hasEnoughResource("silver", 1)) {
            Orb newObject = new Orb(this.name);
            resourceStorage.takeResource("pearl", 1);
            resourceStorage.takeResource("silver", 1);
            allOrbs.add(newObject);
            orbsMadeBySpaceOven++;
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
