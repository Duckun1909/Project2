package io.aptech.Model;

public class Random {
    public static String randomCode(String name){
        String code = "";
        String[] tu = name.split(" ");
        for (String s : tu) {
            if (!s.equals("") && !s.equals(null)) {
                code += String.valueOf(s.charAt(0));
            }
        }
        code += String.valueOf((int)(Math.random() * (9999 - 1000 + 1) + 1000));
        return name.equals("")?name:code;
    }
}