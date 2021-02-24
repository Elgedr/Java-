package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Optional;

public class SpaceOven extends Oven {
    private int orbsMadeBySpaceOven;
    private static int spaceOvenOrbsCounter = 1;

    public SpaceOven(String name, ResourceStorage resourceStorage) {
        super(name, resourceStorage);
        this.orbsMadeBySpaceOven = spaceOvenOrbsCounter;
        spaceOvenOrbsCounter++;
        if (this.orbsMadeBySpaceOven <= 25){
            this.isSpace = true;
        }
    }

    @Override
    public boolean isBroken() {
        if (this.orbsMadeBySpaceOven >= 25) {
            return true;
        }
        return false;
    }

    @Override
    public Optional<Orb> craftOrb() {
        if (!isBroken() && resourceStorage.hasEnoughResource("meteorite stone", 1)
                && resourceStorage.hasEnoughResource("star fragment", 15)) {
            Orb newObject = new Orb(this.name);
            resourceStorage.takeResource("meteorite stone", 1);
            resourceStorage.takeResource("star fragment", 15);
            super.allOrbs.add(newObject);
            return Optional.of(newObject);
        }
        return super.craftOrb();
    }
}
