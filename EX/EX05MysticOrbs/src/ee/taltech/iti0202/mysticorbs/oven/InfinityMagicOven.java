package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Optional;

public class InfinityMagicOven extends MagicOven {
    public InfinityMagicOven(String name, ResourceStorage resourceStorage) {
        super(name, resourceStorage);
        super.isMagic = true;
    }

    @Override
    public boolean isBroken() {
        return false;
    }

    @Override
    public Optional<Orb> craftOrb() {
        return super.craftOrb();
    }
}
