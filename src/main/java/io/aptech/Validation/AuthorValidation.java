package io.aptech.Validation;

public class AuthorValidation {
    public static boolean isAuthorName(String code) {
        String regex = "^[a-zA-Z ]+$";
        return code.matches(regex);
    }
    public static boolean isAuthorDes(String code) {
        String regex = "^[a-zA-Z ][0-9]+$";
        return code.matches(regex);
    }
}
