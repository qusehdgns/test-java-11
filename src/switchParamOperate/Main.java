package switchParamOperate;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        String a = null;

        switch (test(a)) {
            case "A":
            case "B":
            case "C":
            case "D":
                break;
            case "E":
                break;
            default:
                break;
        }
    }

    public static String test(String temp) {
        System.out.println("TEST");
        return Optional.ofNullable(temp).orElse("").toUpperCase();
    }
}
