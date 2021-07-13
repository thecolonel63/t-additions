package com.yahoo.turkbuck.tadditions.command.helpers;

public class StringHelper {
    public static boolean isHexadecimalUUID(String s) {
        if (s.length() == 36) {
            if (s.substring(8, 9).contains("-") && s.substring(13, 14).contains("-") && s.substring(18, 19).contains("-") && s.substring(23, 24).contains("-")) {
                String part1 = s.substring(0, 7);
                String part2 = s.substring(9, 12);
                String part3 = s.substring(14, 17);
                String part4 = s.substring(19, 22);
                String part5 = s.substring(24, 36);
                String dashesRemoved = part1 + part2 + part3 + part4 + part5;
                return dashesRemoved.matches("-?[0-9a-f]+");
            }
        }
        return false;
    }

    public static boolean isIntArrayUUID(String s) {
        if ((s.startsWith("[I;")) && (s.charAt(s.length() - 1) == ']')) {
            long count = s.substring(3, s.length() - 1).chars().filter(ch -> ch == ',').count();
            if (count == 3) {
                String[] parts = s.substring(3, s.length() - 1).split(",");
                if (parts.length == 4) {
                    int partNumericalCheck = 0;
                    for (int i = 0; i < 4; i++) {
                        try {
                            int parsedInt = Integer.parseInt(parts[i]);
                        } catch (NumberFormatException e) {
                            partNumericalCheck++;
                        }
                    }
                    return partNumericalCheck == 0;
                }
            }
        }
        return false;
    }
}
