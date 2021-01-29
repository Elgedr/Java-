package ee.taltech.iti0202.idcode;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

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
     * @param idCodeValue
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
        if (getIdCodeValue().length() == 11 && isGenderNumberCorrect() && isYearNumberCorrect() && isMonthNumberCorrect() && isDayNumberCorrect() && isControlNumberCorrect()) {
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
        return "This is a " + this.getGender() + " born on " +  "in " + this.getBirthPlace();
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
        int code = Integer.parseInt(removeLeadingZeros(idCodeValue).substring(7, 10));
        if (code >= 1 && code <= 10) {
            return "Kuressare";
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
        int year = idCodeValue.charAt(0);
        String yearCodeFromId = removeLeadingZeros(idCodeValue).substring(1, 3);
        switch (year) {
            case 1:
            case 2:
                res = "18" + yearCodeFromId;
                System.out.println(res);
                break;
            case 3:
            case 4:
                res = "19" + yearCodeFromId;
                System.out.println(res);
                break;
            case 5:
            case 6:
                res = "20" + yearCodeFromId;
                System.out.println(res);
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
        int genderCode = idCodeValue.charAt(0);
        if (genderCode > 6) {
            return false;
        }
        return true;
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
        if (month > 12) {
            return false;
        }
        return true;
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
        int kontrolNumber = idCodeValue.charAt(10);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            int numberOfId = idCodeValue.charAt(i);
            numbers.add(numberOfId);
        }
        int sum1 = (numbers.get(0) + numbers.get(1) * 2 + numbers.get(2) * 3 + numbers.get(3) * 4 + numbers.get(4) * 5
                + numbers.get(5) * 6 + numbers.get(6) * 7 + numbers.get(7) * 8 + numbers.get(8) * 9 + numbers.get(9)) % 11;
        int sum2 = (numbers.get(0) * 3 + numbers.get(1) * 4 + numbers.get(2) * 5 + numbers.get(3) * 6 + numbers.get(4) * 7
                + numbers.get(5) * 8 + numbers.get(6) * 9 + numbers.get(7) + numbers.get(8) * 2 + numbers.get(9)) % 11;
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
     * @param fullYear
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
     * @param str
     * @return str
     */
    public String removeLeadingZeros(String str) {
        String regex = "^0+(?!$)";
        str = str.replaceAll(regex, "");
        return str;
    }

    /**
     * Run tests.
     * @param
     */
    public static void main(String[] args) {
        IdCode validMaleIdCode = new IdCode("60111202216");
//        System.out.println(validMaleIdCode.isCorrect());
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
