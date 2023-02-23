package io.aptech.Validation;

public class BookValidation {
    public static boolean isBookPrice(String code) {
        String regex = "^[0-9]+$";
        return code.matches(regex);
    }
    public static boolean isBookName(String code) {
        String regex = "^[a-zA-Z ]+$";
        return code.matches(regex);
    }
    public static boolean isBookDes(String code) {
        String regex = "^[a-zA-Z ][0-9 ]+$";
        return code.matches(regex);
    }

}
