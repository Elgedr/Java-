package ee.taltech.iti0202.shelter.shelter;

import ee.taltech.iti0202.shelter.animal.Animal;
import ee.taltech.iti0202.shelter.animalprovider.AnimalProvider;

import java.util.ArrayList;
import java.util.List;

public class AnimalShelter {
    public AnimalProvider animalProvider;

    public AnimalShelter(AnimalProvider animalProvider) {
        this.animalProvider = animalProvider;
    }

    /**
     * Gets a list of up to {count} animals with the given {type} and {color}.
     * This method should use animal provider which is set in constructor.
     * As the provider only can filter by type, you have to filter by color yourself.
     * Also, the number of results from provider is not defined, you have to call the provider
     * multiple times to get all the results (but not more than required).
     * The results should come in the order provided by the provider.
     * Also, provider can return duplicate animals. You should return only unique animals.
     * If the provider returns an empty list, stop calling it
     * and return whatever you have by that point.
     *
     * @param animalType Type.
     * @param color      Color used when filtering.
     * @param count      Maximum number of result to return.
     * @return Maximum {count} number of animals with the given type and color.
     */
    public List<Animal> getAnimals(Animal.Type animalType, String color, int count) {
        List<Animal> finalRes = new ArrayList<>();
        List<Animal> returnedFromProvider = new ArrayList<>();
        while (finalRes.size() < count) {
            returnedFromProvider = animalProvider.provide(animalType);
            if (returnedFromProvider.size() == 0) {
                return finalRes;
            }
            for (Animal animal: returnedFromProvider){
                if (animal.getColor().equals(color) && !finalRes.contains(animal) && ((finalRes.size() +1) <= count)){
                    finalRes.add(animal);
                }
            }
        }
        return finalRes;
    }
}
