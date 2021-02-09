package ee.taltech.iti0202.lotr;

public class Ring {
    private String name;
    private Type type;
    private Material material;

    enum Type { THE_ONE, GOLDEN, NENYA, OTHER }
    enum Material { GOLD, SILVER, BRONZE, PLASTIC, DIAMOND }

    /**
     *
     * @param type type of ring from enum
     * @param material material of ring from enum
     */
    public Ring(Type type, Material material) {
        this.type = type;
        this.material = material;
    }

    /**
     *
     * @return type of ring
     */
    public Type getType() {
        return this.type;
    }

    /**
     *
     * @return material of ring
     */
    public Material getMaterial() {
        return this.material;
    }

}
