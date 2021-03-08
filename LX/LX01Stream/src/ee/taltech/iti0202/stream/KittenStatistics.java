package ee.taltech.iti0202.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class KittenStatistics {

    private List<Kitten> kittens;

    public void setKittens(List<Kitten> kittens) {
        this.kittens = kittens;
    }

    public OptionalDouble findKittensAverageAge() {
        return kittens.stream().mapToInt(Kitten::getAge).average();
    }

    public Optional<Kitten> findOldestKitten() {
        return Optional.of(kittens.stream().max(Comparator.comparingInt(Kitten::getAge)).get());
    }

    public List<Kitten> findYoungestKittens() {
         Kitten kitten_youngest = kittens.stream().min(Comparator.comparingInt(Kitten::getAge)).get();
        return kittens.stream().filter(kitten -> kitten.getAge() == kitten_youngest.getAge()).collect(Collectors.toList());
    }

    public List<Kitten> findKittensAccordingToGender(Kitten.Gender gender) {
        return kittens.stream().filter(kitten -> kitten.getGender().equals(gender)).collect(Collectors.toList());
    }

    public List<Kitten> findKittensBetweenAges(int minAge, int maxAge) {
        return kittens.stream().filter(kitten -> kitten.getAge() >= minAge && kitten.getAge() <= maxAge).collect(Collectors.toList());
    }

    public Optional<Kitten> findFirstKittenWithGivenName(String givenName) {
        return Optional.of(kittens.stream().filter(kitten -> kitten.getName().equals(givenName)).findFirst().get());
    }

    public List<Kitten> kittensSortedByAgeYoungerFirst() {
        return kittens.stream().sorted(Comparator.comparingInt(Kitten::getAge)).collect(Collectors.toList());
    }

    public List<Kitten> kittensSortedByAgeOlderFirst() {
        return kittens.stream().sorted(Comparator.comparingInt(Kitten::getAge).reversed()).collect(Collectors.toList());
    }

}