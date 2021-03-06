package ee.taltech.iti0202.files.morse;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MorseTranslator {
    public Map<String, String> translations = new HashMap<>();
    public List<String> translatedToMorse = new ArrayList<>();
    public List<String> translatedFromMorse = new ArrayList<>();

    /**
     *
     * @param lines .
     * @return .
     */
    public Map<String, String> addMorseCodes(List<String> lines) {
        for (String translation : lines) {
            String[] splitted = translation.split(" ");
            translations.put(splitted[0].toLowerCase(), splitted[1]);
        }
        return translations;
    }

    /**
     *
     * @param lines .
     * @return .
     */
    public List<String> translateLinesToMorse(List<String> lines) {
        for (String str : lines) {
            translateLineToMorse(str);
            translatedToMorse.add(translateLineToMorse(str));
        }
        return translatedToMorse;
    }

    /**
     *
     * @param lines .
     * @return .
     */
    public List<String> translateLinesFromMorse(List<String> lines) {
        for (String line : lines) {
            translateLineFromMorse(line);
            translatedFromMorse.add(translateLineFromMorse(line));
        }
        return translatedFromMorse;
    }

    /**
     *
     * @param line .
     * @return .
     */
    private String translateLineToMorse(String line) {
        String translatedToMorseString = "";
        for (int i = 0; i < line.length(); i++) {
            Character charAtIndex = line.charAt(i);
            String charToString = String.valueOf(charAtIndex).toLowerCase();
            if (!charToString.equals(" ")) {
                translatedToMorseString += translations.get(charToString) + " ";
            } else {
                translatedToMorseString = translatedToMorseString.substring(0, translatedToMorseString.length() - 1);
                translatedToMorseString += "\t";
            }
        }
        return translatedToMorseString.substring(0, translatedToMorseString.length() - 1);

    }

    /**
     *
     * @param line .
     * @return .
     */
    private String translateLineFromMorse(String line) {
        String translatedFromMorseString = "";
        String[] splittedWords = line.split("\t");
        for (String morseWord : splittedWords) {
            String[] splittedLetter = morseWord.split(" ");
            for (String letter : splittedLetter) {
                for (String key : translations.keySet()) {
                    if (translations.get(key).equals(letter)) {
                        translatedFromMorseString += key;
                    }
                }
            }
            translatedFromMorseString += " ";
        }
        return translatedFromMorseString.substring(0, translatedFromMorseString.length() - 1);
    }
}
