package com.thecolonel63.tadditions.command.helpers;

public class StringHelper {
    public static boolean isHexadecimalUUID(String s) {
        if(!(s.length() == 36 || s.length() == 32)) return false;
        return s.replace("-","").matches("-?[0-9a-f]+");
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
