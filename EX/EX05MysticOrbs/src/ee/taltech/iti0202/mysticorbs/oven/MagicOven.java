package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Optional;

public class MagicOven extends Oven {
    private int orbIndex;
    private static int magicOrbIndexCounter = 1;

    public MagicOven(String name, ResourceStorage resourceStorage) {
        super(name, resourceStorage);
        this.orbIndex = magicOrbIndexCounter;
        magicOrbIndexCounter++;
        if (orbIndex == 2 || orbIndex == 4) {
            super.isMagic = true;
        }
    }

    @Override
    public boolean isBroken() {
        if (this.orbIndex >= 5) {
            return true;
        }
        return false;
    }

    @Override
    public Optional<Orb> craftOrb() {
        if (!isBroken() && resourceStorage.hasEnoughResource("gold", 1)
                && resourceStorage.hasEnoughResource("dust", 3)) {
            Orb newObject = new Orb(this.name);
            newObject.charge("gold", 1);
            newObject.charge("dust", 3);
            resourceStorage.takeResource("gold", 1);
            resourceStorage.takeResource("dust", 3);
            super.allOrbs.add(newObject);
            return Optional.of(newObject);
        }
        return Optional.empty();
    }
}
