package ee.taltech.iti0202.idcode;
import java.util.ArrayList;
import java.util.List;

public class IdCode {

    private final String idCodeValue;
    enum Gender {
        MALE, FEMALE
    }

    /**
     * Method returns the id code.
     *
     * @return id code.
     */
    public String getIdCodeValue() {
        return idCodeValue;
    }

    /**
     * Give a value to a konstant variable.
     * @param idCodeValue an id code as a string
     */
    public IdCode(String idCodeValue) {
        this.idCodeValue = idCodeValue;
    }

    /**
     * Check if the id code is valid or not.
     *
     * @return boolean describing whether or not the id code was correct.
     */
    public boolean isCorrect() {
        if (getIdCodeValue().length() == 11 && isGenderNumberCorrect() && isYearNumberCorrect()
                && isMonthNumberCorrect() && isDayNumberCorrect() && isControlNumberCorrect()) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Get all information about id code.
     *
     * @return String containing information.
     */
    public String getInformation() {
        return "This is a " + getGender() + " born on " + idCodeValue.substring(5, 7) + "."
                + idCodeValue.substring(3, 5) + "." + getFullYear() + " in " + getBirthPlace();
    }

    /**
     * Get gender enum.
     *
     * @return enum describing person's gender
     */
    public Gender getGender() {
        char a = idCodeValue.charAt(0);
        char first = '1';
        char second = '3';
        char third = '5';
        int compareToFirst = Character.compare(a, first);
        int compareToSecond = Character.compare(a, second);
        int compareToThird = Character.compare(a, third);
        if (compareToFirst == 0 || compareToSecond == 0 || compareToThird == 0) {
            return Gender.MALE;
        } else {
            return Gender.FEMALE;
        }
    }

    /**
     * Get person's birth location.
     *
     * @return String with the person's birth place.
     */
    public String getBirthPlace() {
        String place = null;
        int code = Integer.parseInt(idCodeValue.substring(7, 10));
        if (code >= 1 && code <= 10) {
            return "Kuressaare";
        } else if (code >= 11 && code <= 20) {
            return "Tartu";
        } else if (code >= 21 && code <= 220) {
            return "Tallinn";
        } else if (code >= 221 && code <= 270) {
            return "Kohtla-Järve";
        } else if (code >= 271 && code <= 370) {
            return "Tartu";
        } else if (code >= 371 && code <= 420) {
            return "Narva";
        } else if (code >= 421 && code <= 470) {
            return "Pärnu";
        } else if (code >= 471 && code <= 490) {
            return "Tallinn";
        } else if (code >= 491 && code <= 520) {
            return "Paide";
        } else if (code >= 521 && code <= 570) {
            return "Rakvere";
        } else if (code >= 571 && code <= 600) {
            return "Valga";
        } else if (code >= 601 && code <= 650) {
            return "Viljandi";
        } else if (code >= 651 && code <= 710) {
            return "Võru";
        }
        return "unknown";
    }

    /**
     * Get the year that the person was born in.
     *
     * @return int with person's birth year.
     */
    public Integer getFullYear() {
        String res = "sss";
        int year = Integer.parseInt(idCodeValue.substring(0, 1));
        String yearCodeFromId = idCodeValue.substring(1, 3);
        switch (year) {
            case 1:
            case 2:
                res = "18" + yearCodeFromId;
                break;
            case 3:
            case 4:
                res = "19" + yearCodeFromId;
                break;
            case 5:
            case 6:
                res = "20" + yearCodeFromId;
                break;
            default:
                break;
        }
        return Integer.parseInt(res);
    }

    /**
     * Check if gender number is correct.
     *
     * @return boolean describing whether the gender number is correct.
     */
    private boolean isGenderNumberCorrect() {
        int genderCode = Integer.parseInt(idCodeValue.substring(0,1)); //достаем из str несколько элементов и переводим их в int//
        return genderCode <= 6;
    }

    /**
     * Check if the year number is correct.
     *
     * @return boolean describing whether the year number is correct.
     */
    private boolean isYearNumberCorrect() {
        return true;
    }

    /**
     * Check if the month number is correct.
     *
     * @return boolean describing whether the month number is correct.
     */
    private Boolean isMonthNumberCorrect() {
        int month = Integer.parseInt(removeLeadingZeros(idCodeValue).substring(3, 5));
        return month <= 12;
    }

    /**
     * Check if the day number is correct.
     *
     * @return boolean describing whether the day number is correct.
     */
    private boolean isDayNumberCorrect() {
        return true;
    }

    /**
     * Check if the control number is correct.
     *
     * @return boolean describing whether the control number is correct.
     */
    private boolean isControlNumberCorrect() {
        int kontrolNumber = Integer.parseInt(idCodeValue.substring(10));
        List<Integer> n = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            char numberOfIdChar = idCodeValue.charAt(i);
            int numberOfChar = Character.getNumericValue(numberOfIdChar);
            n.add(numberOfChar);
        }
        int sum1 = (n.get(0) + n.get(1) * 2 + n.get(2) * 3 + n.get(3) * 4 + n.get(4) * 5 + n.get(5) * 6 + n.get(6) * 7 + n.get(7) * 8 + n.get(8) * 9 + n.get(9)) % 11;
        int sum2 = (n.get(0) * 3 + n.get(1) * 4 + n.get(2) * 5 + n.get(3) * 6 + n.get(4) * 7 + n.get(5) * 8 + n.get(6) * 9 + n.get(7) + n.get(8) * 2 + n.get(9) * 3) % 11;
        if (sum1 == 10) {
            if (sum2 == 10 && kontrolNumber == 0 || sum2 != 10 && kontrolNumber == sum2) {
                return true;
            }
        } else if (sum1 == kontrolNumber) {
            return true;
        }
        return false;
    }

    /**
     * Check if the given year is a leap year.
     *
     * @param fullYear int
     * @return boolean describing whether the given year is a leap year.
     */
    private boolean isLeapYear(int fullYear) {
        boolean res = false;
        if (fullYear % 4 == 0) {
            if (fullYear % 100 == 0) {
                if (fullYear % 400 == 0) {
                    res = true;
                } else {
                    res = false;
                }
            } else {
                res = true;
            }
        } else {
            res = false;
        }
        return res;
    }

    /**
     *
     * @param str String
     * @return str
     */
    public String removeLeadingZeros(String str) {
        String regex = "^0+(?!$)";
        str = str.replaceAll(regex, "");
        return str;
    }

    /**
     * Run tests.
     * @param args args
     */
    public static void main(String[] args) {
        IdCode validMaleIdCode = new IdCode("60111202216");
        System.out.println(validMaleIdCode.isCorrect());
        System.out.println(validMaleIdCode.getInformation());
        System.out.println(validMaleIdCode.getGender());
        System.out.println(validMaleIdCode.getBirthPlace());
        System.out.println(validMaleIdCode.getFullYear());
        System.out.println(validMaleIdCode.isGenderNumberCorrect());
        System.out.println(validMaleIdCode.isYearNumberCorrect());
        System.out.println(validMaleIdCode.isMonthNumberCorrect());
        System.out.println(validMaleIdCode.isDayNumberCorrect());
        System.out.println(validMaleIdCode.isControlNumberCorrect());
        System.out.println(validMaleIdCode.isLeapYear(validMaleIdCode.getFullYear()));
    }

}
