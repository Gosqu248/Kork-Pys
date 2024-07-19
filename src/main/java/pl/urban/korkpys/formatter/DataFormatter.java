package pl.urban.korkpys.formatter;

public class DataFormatter {

    public static String formatNameOrCity(String input) {
        if (input == null || input.isEmpty()) return input;
        if (input.contains("&") || input.split("\\s+").length != countUpperCaseWords(input)) {
            return input;
        }
        return capitalizeWords(input.toLowerCase());
    }

    public static String formatStreet(String input) {
        if (input == null || input.isEmpty()) return input;
        input = input.trim();

        // Normalize "ul." prefix to be case-insensitive
        if (input.matches("(?i)^ul\\.\\S.*")) {
            input = "ul. " + capitalizeWords(input.substring(3).trim().toLowerCase());
        } else {
            input = capitalizeWords(input.toLowerCase());
        }

        // Remove apartment/unit numbers and ensure building numbers are correctly formatted
        input = input.replaceAll("\\s+[A-Za-z]/.*", ""); // Remove trailing apartment/unit numbers
        input = input.replaceAll("(\\d+)\\s+([A-Za-z])", "$1$2"); // Format building numbers like "104 A" to "104A"

        return input;
    }

    private static String capitalizeWords(String input) {
        char[] chars = input.toCharArray();
        boolean capitalizeNext = true;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isWhitespace(c) || c == '.') {
                capitalizeNext = true;
            } else if (capitalizeNext) {
                chars[i] = Character.toUpperCase(c);
                capitalizeNext = false;
            }
        }
        return new String(chars);
    }

    private static int countUpperCaseWords(String input) {
        int count = 0;
        for (String word : input.split("\\s+")) {
            if (Character.isUpperCase(word.charAt(0))) {
                count++;
            }
        }
        return count;
    }
}