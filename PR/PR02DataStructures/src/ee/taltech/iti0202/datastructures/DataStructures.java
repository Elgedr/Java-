package ee.taltech.iti0202.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataStructures {
    private final Map<String, Integer> resultWithStudentsAndGrades = new HashMap<>();

    /**
     * Given String is a sentence with some words.
     * There are only single whitespace between every word and no punctuation marks.
     * Also there are no capital letters in input string.
     * <p>
     * Return the longest word from the input sentence.
     * <p>
     * If there are more than one word with the same length then return the word which comes alphabetically first.
     * <p>
     * Hints:
     * You can split words into an array using "str.split()"
     * Sorting the list with the longest words can definitely help you to find the word which comes alphabeticlly first.
     *
     * @param sentence input String to find the longest words
     * @return the longest String from input
     */
    public static String findLongestWord(String sentence) {
        String[] arrayOfSplittedString = sentence.split(" "); /*создаем array с разделенными именами*/
        List<String> sortedList = Arrays.stream(arrayOfSplittedString).sorted().collect(Collectors.toList());
        /*переводим список в стрим.сортируем список по умолчанию по алфавиту.превращаем обратно в список*/
        int lengthh = 0;
        String biggestWord = "";
        for (String word: sortedList) {
            if (word.length() > lengthh) {
                lengthh = word.length();
                biggestWord = word;
            }
        }
        return biggestWord;
    }

    /**
     * Classic count the words exercise.
     * <p>
     * From input count all the words and collect results to map.
     *
     * @param sentence array of strings, can't be null.
     * @return map containing all word to count mappings.
     */
    public static Map<String, Integer> wordCount(String[] sentence) {
        Map<String, Integer> result = new HashMap<>(); /*создаем новый словарь*/
        for (String word: sentence) {
            if (!result.containsKey(word)) { /*если в словаре нет такого ключа, то добавляем*/
                result.put(word, 1);
            } else {
                result.put(word, result.get(word) + 1); /*если такой ключ уже есть, то прибавляем к значению +1 */
            }
        }
        return result;
    }

    /**
     * Loop over the given list of strings to build a resulting list of string like this:
     * when a string appears the 2nd, 4th, 6th, etc. time in the list, append the string to the result.
     * <p>
     * Return the empty list if no string appears a 2nd time.
     * <p>
     * Use map to count times that the string has appeared.
     *
     * @param words input list to filter
     * @return list of strings matching criteria
     */
    public static List<String> onlyEvenWords(List<String> words) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> countAppearance = new HashMap<>();
        for (String word: words) {
            if (!countAppearance.containsKey(word)) {
                countAppearance.put(word, 1);
            } else {
                countAppearance.put(word, countAppearance.get(word) + 1);
            }
        }
        for (String key: countAppearance.keySet()) { /*чтобы итерировать через ключи словаря*/
            int appearance = countAppearance.get(key); /*получаем значение. кол-во раз, сколько слово встречалось*/
            if (appearance >= 2) {
                for (int i = 0; i < (appearance / 2); i++) { //делениe с "/" дает целую часть.если 3.9, то получим 3
                    result.add(key);
                }
            }
        }
        return result;
    }

    /**
     * Method to save student and student's grade(you should use a Map here).
     * Only add student if his/hers grade is in the range of 0-5.
     *
     * @param studentInfo String with a pattern (name:grade)
     */
    public void addStudent(String studentInfo) {
        String[] arrayWithNameGrade = studentInfo.split(":");
        int grade = Integer.parseInt(arrayWithNameGrade[1]);
        if (grade >= 0 && grade <= 5) {
            resultWithStudentsAndGrades.put(arrayWithNameGrade[0], grade);
        }
    }

    /**
     * Method to get student's grade.
     * Return the student's grade by his/hers name.
     * You can assume that the user is already added(previous function with student's info already called).
     *
     * @param name String students name
     * @return int student's grade.
     */
    public int getStudentGrade(String name) {
        int ifNoSuchStudent = -1;
        return resultWithStudentsAndGrades.getOrDefault(name, ifNoSuchStudent);
    }

    /**
     * Main.
     * @param args Commend line arguments.
     */
    public static void main(String[] args) {
        System.out.println(findLongestWord("nimi on salastatud"));  // "salastatud"
        System.out.println(findLongestWord("aaa bbbbb"));  // "bbbbb"
        System.out.println(findLongestWord("hello ahllo")); // "ahllo"

        System.out.println(wordCount(new String[]{})); // empty
        System.out.println(wordCount(new String[]{"eggs", "SPAM", "eggs", "bacon", "SPAM", "bacon", "SPAM"}));
        // {bacon=2, eggs=2, SPAM=3}

        System.out.println(onlyEvenWords(Arrays.asList("foo", "bar", "baz", "baz", "bar", "foo"))); // [baz, bar, foo]
        System.out.println(onlyEvenWords(Arrays.asList("a", "b", "b", "a"))); // [b, a]
        System.out.println(onlyEvenWords(Arrays.asList("eggs", "bacon", "SPAM", "ham", "SPAM", "SPAM"))); // [SPAM]

        DataStructures dataStructures = new DataStructures();

        dataStructures.addStudent("Ago:5");
        dataStructures.addStudent("Martin:0");
        dataStructures.addStudent("Margo:3");
        dataStructures.addStudent("Cheater:6");

        System.out.println(dataStructures.getStudentGrade("Ago")); // 5
        System.out.println(dataStructures.getStudentGrade("Martin")); // 0
        System.out.println(dataStructures.getStudentGrade("Margo")); // 3
        System.out.println(dataStructures.getStudentGrade("Cheater")); // -1
    }
}
