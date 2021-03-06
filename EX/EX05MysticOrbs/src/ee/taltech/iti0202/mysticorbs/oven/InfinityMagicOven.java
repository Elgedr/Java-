package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Optional;

public class InfinityMagicOven extends MagicOven {
    public int orbsMadeByInfinityMagicOven = 0;

    /**
     *
     * @param name .
     * @param resourceStorage .
     */
    public InfinityMagicOven(String name, ResourceStorage resourceStorage) {
        super(name, resourceStorage);
    }

    @Override
    public boolean isBroken() {
        return false;
    }


    @Override
    public Optional<Orb> craftOrb() {
        if (resourceStorage.hasEnoughResource("gold", 1)
                && resourceStorage.hasEnoughResource("dust", 3)) {
            Orb newObject = new Orb(this.name);
            newObject.charge("gold", 1);
            newObject.charge("dust", 3);
            resourceStorage.takeResource("gold", 1);
            resourceStorage.takeResource("dust", 3);
            allOrbs.add(newObject);
            orbsMadeByInfinityMagicOven++;
            return Optional.of(newObject);
        }
        return Optional.empty();
    }

    @Override
    public int getCreatedOrbsAmount() {
        return orbsMadeByInfinityMagicOven;
    }
}
