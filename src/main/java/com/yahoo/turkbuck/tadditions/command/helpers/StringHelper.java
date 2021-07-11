package com.yahoo.turkbuck.tadditions.command.helpers;

public class StringHelper {
    public static boolean isUUID(String s) {
        if (s.length() == 36) {
            if (s.substring(8, 9).contains("-") && s.substring(13, 14).contains("-") && s.substring(18, 19).contains("-") && s.substring(23, 24).contains("-")) {
                String part1 = s.substring(0, 7);
                String part2 = s.substring(9, 12);
                String part3 = s.substring(14, 17);
                String part4 = s.substring(19, 22);
                String part5 = s.substring(24, 36);
                String dashesRemoved = part1+part2+part3+part4+part5;
                if (dashesRemoved.matches("-?[0-9a-f]+")) {
                    return true;
                } else return false;
            } else return false;
        } else return false;
    }
}
