package io.aptech.Validation;

public class PublisherValidation {
    public static boolean isPublisherName(String code) {
        String regex = "^[a-zA-Z ]+$";
        return code.matches(regex);
    }
    public static boolean isPublisherEmail(String code) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return code.matches(regex);
    }
    public static boolean isPublisherWeb(String code) {
        String regex = "\\b(https?|ftp|file)://[-A-Z0-9+&@#/%?=~_|!:,.;]*[-A-Z0-9+&@#/%=~_|]";
        return code.matches(regex);
    }
    public static boolean isPublisherAddress(String code) {
        String regex = "^[a-zA-Z0-9 ]+$";
        return code.matches(regex);
    }
}
