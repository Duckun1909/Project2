package io.aptech.Validation;

public class CategoryValidation {
    public static boolean isCategoryName(String code) {
        String regex = "^[a-zA-Z ]+$";
        return code.matches(regex);
    }
    public static boolean isAuthorDes(String code) {
        String regex = "^[a-zA-Z ][0-9]+$";
        return code.matches(regex);
    }
}
