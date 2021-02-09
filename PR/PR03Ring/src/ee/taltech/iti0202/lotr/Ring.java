package ee.taltech.iti0202.lotr;

public class Ring {
    private String name;
    private Type type;
    private Material material;

    enum Type{THE_ONE, GOLDEN, NENYA, OTHER}
    enum Material{GOLD, SILVER, BRONZE, PLASTIC, DIAMOND}

    public Ring(Type type, Material material){
        this.type = type;
        this.material = material;
    }

    public Type getType(){
        return this.type;
    }

    public Material getMaterial(){
        return this.material;
    }

}
