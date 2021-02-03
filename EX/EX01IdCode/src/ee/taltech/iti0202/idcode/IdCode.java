package ee.taltech.iti0202.idcode;
import java.util.ArrayList;
import java.util.List;

public class IdCode {

    /**
     *Описание к задекларированной переменной seven
     */ /*Чтобы увидеть описание наводим мышь на переменную и CTRL + Q*/
    public static final int SEVEN = 7; /*большими буквами потому что статичная и можно звать во всем коде*/
    public static final int TWELVE = 12; /*CTRL + ALT + C . Наводим на число и нажимаем комбинацию*/
    public static final int FOURHUNDRED = 400; /*CTRL + F6 . Поменять название*/
    public static final int EIGHT = 8; /*Если меняем тут цыфру, то поменяется во всем коде */
    public static final int SIX = 6; /*psfi - сокращенная команда*/
    public static final int ELEVEN = 11;
    public static final int NINE = 9;
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
        if (!this.isCorrect()) {
            throw new IllegalArgumentException(); /*Выкидываем ошибку в конструкторе*/
        }
    }

    /**
     * Check if the id code is valid or not.
     *
     * @return boolean describing whether or not the id code was correct.
     */
    public boolean isCorrect() {
        if (getIdCodeValue().length() == ELEVEN && isGenderNumberCorrect() && isYearNumberCorrect()
                && isMonthNumberCorrect() && isDayNumberCorrect() && isControlNumberCorrect()) {
            return true;
        }
        return false;
    }

    /**
     * Get all information about id code.
     *
     * @return String containing information.
     */
    public String getInformation() {
        return "This is a " + getGender() + " born on " + idCodeValue.substring(5, SEVEN) + "."
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
        int code = Integer.parseInt(idCodeValue.substring(SEVEN, 10));
        final int tarSt = 11, tarEn = 20; /* должны писаться большими буквами*/
        final int tlnSt = 21, tlnEn = 220;
        final int kjSt = 221, kjEn = 270;
        final int tar2St = 271, tar2En = 370;
        final int narSt = 371, narEn = 420;
        final int parSt = 421, parEn = 470;
        final int tln2St = 471, tln2En = 490;
        final int paiSt = 491, paiEn = 520;
        final int rakSt = 521, rakEn = 570;
        final int valSt = 571, valEn = 600;
        final int vilSt = 601, vilEn = 650;
        final int vorSt = 551, vorEn = 710;

        if (code >= 1 && code <= 10) {
            return "Kuressaare";
        } else if (code >= tarSt && code <= tarEn) {
            return "Tartu";
        } else if (code >= tlnSt && code <= tlnEn) {
            return "Tallinn";
        } else if (code >= kjSt && code <= kjEn) {
            return "Kohtla-Järve";
        } else if (code >= tar2St && code <= tar2En) {
            return "Tartu";
        } else if (code >= narSt && code <= narEn) {
            return "Narva";
        } else if (code >= parSt && code <= parEn) {
            return "Pärnu";
        } else if (code >= tln2St && code <= tln2En) {
            return "Tallinn";
        } else if (code >= paiSt && code <= paiEn) {
            return "Paide";
        } else if (code >= rakSt && code <= rakEn) {
            return "Rakvere";
        } else if (code >= valSt && code <= valEn) {
            return "Valga";
        } else if (code >= vilSt && code <= vilEn) {
            return "Viljandi";
        } else if (code >= vorSt && code <= vorEn) {
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
        String res = "";
        String lastTwo = idCodeValue.substring(1, 3);
        int firstInt = Integer.parseInt(idCodeValue.substring(0, 1));
        if (firstInt == 1 || firstInt == 2) {
            res = "18" + lastTwo;
        } else if (firstInt == 3 || firstInt == 4) {
            res = "19" + lastTwo;
        } else if (firstInt == 5 || firstInt == SIX) {
            res = "20" + lastTwo;
        }
        return Integer.parseInt(res);
//        String res = "sss";
//        int year = Integer.parseInt(idCodeValue.substring(0, 1));
//        String yearCodeFromId = idCodeValue.substring(1, 3);
//        switch (year) {
//            case 1:
//            case 2:
//                res = "18" + yearCodeFromId;
//                break;
//            case 3:
//            case 4:
//                res = "19" + yearCodeFromId;
//                break;
//            case 5:
//            case 6:
//                res = "20" + yearCodeFromId;
//                break;
//            default:
//                break;
//        }
//        return Integer.parseInt(res);
    }

    /**
     * Check if gender number is correct.
     *
     * @return boolean describing whether the gender number is correct.
     */
    private boolean isGenderNumberCorrect() {
        int genderCode = Integer.parseInt(idCodeValue.substring(0, 1)); //достаем из str несколько элементов и
        // переводим их в int//
        return genderCode <= SIX;
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
        final int maxMonth = 12;
        int month = Integer.parseInt(idCodeValue.substring(3, 5));
        System.out.println(month);
        return month <= maxMonth;
    }

    /**
     * Check if the day number is correct.
     *
     * @return boolean describing whether the day number is correct.
     */
    private boolean isDayNumberCorrect() {
        final int maxDayForLeapYearFeb = 29;
        final int maxDayForNotLeapYearFeb = 28;
        final int maxDayForNotLeapYear = 30;
        final int maxDayForLeapYear = 31;

        int month = Integer.parseInt(idCodeValue.substring(3, 5)); //если в str 01, то в int будет 1
        int day = Integer.parseInt(idCodeValue.substring(5, SEVEN));
        List<Integer> bigMonth = new ArrayList<>();
        List<Integer> smallMonth = new ArrayList<>();
        smallMonth.add(4);
        smallMonth.add(SIX);
        smallMonth.add(NINE);
        smallMonth.add(ELEVEN);
        bigMonth.add(1);
        bigMonth.add(3);
        bigMonth.add(5);
        bigMonth.add(SEVEN);
        bigMonth.add(EIGHT);
        bigMonth.add(10);
        bigMonth.add(TWELVE);
        if (month == 2 && isLeapYear(getFullYear()) && day <= maxDayForLeapYearFeb) {
            return true;
        } else if (month == 2 && !isLeapYear(getFullYear()) && day <= maxDayForNotLeapYearFeb) {
            return true;
        } else if (bigMonth.contains(month) && day <= maxDayForLeapYear) {
            return true;
        } else if (smallMonth.contains(month) && day <= maxDayForNotLeapYear) {
            return true;
        }
        return false;
    }

    /**
     * Check if the control number is correct.
     *
     * @return boolean describing whether the control number is correct.
     */
    private boolean isControlNumberCorrect() {
        int kontrolNumber = Integer.parseInt(idCodeValue.substring(10));
        List<Integer> n = new ArrayList<>();
        for (int i = 0; i < ELEVEN; i++) {
            char numberOfIdChar = idCodeValue.charAt(i);
            int numberOfChar = Character.getNumericValue(numberOfIdChar);
            n.add(numberOfChar);
        }
        int sum1 = (n.get(0) + n.get(1) * 2 + n.get(2) * 3 + n.get(3) * 4 + n.get(4) * 5 + n.get(5) * SIX
                + n.get(SIX) * SEVEN + n.get(SEVEN) * EIGHT + n.get(EIGHT) * IdCode.NINE + n.get(IdCode.NINE)) % ELEVEN;
        int sum2 = (n.get(0) * 3 + n.get(1) * 4 + n.get(2) * 5 + n.get(3) * SIX + n.get(4) * SEVEN + n.get(5) * EIGHT
                + n.get(SIX) * IdCode.NINE + n.get(SEVEN) + n.get(EIGHT) * 2 + n.get(IdCode.NINE) * 3) % ELEVEN;
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
                if (fullYear % FOURHUNDRED == 0) {
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

//    /**
//     *
//     * @param str String
//     * @return str
//     */
//    public String removeLeadingZeros(String str) {
//        String regex = "^0+(?!$)";
//        str = str.replaceAll(regex, "");
//        return str;
//    }

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
