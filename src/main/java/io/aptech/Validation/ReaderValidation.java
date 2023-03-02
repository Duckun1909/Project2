package io.aptech.Validation;

public class ReaderValidation {
    public static boolean isReaderName(String code) {
        String regex = "/^[a-zA-Z ]+$/";
        return code.matches(regex);
    }
    public static boolean isReaderPhone(String code) {
        String regex = "/^[0-9]+$/";
        return code.matches(regex);
    }
    public static boolean isReaderCid(String code) {
        String regex = "^[0-9]{9,12}$";
        return code.matches(regex);
    }
}
