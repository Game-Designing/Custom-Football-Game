package com.google.gson;

/* renamed from: com.google.gson.i */
/* compiled from: FieldNamingPolicy */
public enum C10178i implements FieldNamingStrategy {
    IDENTITY,
    UPPER_CAMEL_CASE,
    UPPER_CAMEL_CASE_WITH_SPACES,
    LOWER_CASE_WITH_UNDERSCORES,
    LOWER_CASE_WITH_DASHES;

    /* renamed from: a */
    static String m33126a(String name, String separator) {
        StringBuilder translation = new StringBuilder();
        int length = name.length();
        for (int i = 0; i < length; i++) {
            char character = name.charAt(i);
            if (Character.isUpperCase(character) && translation.length() != 0) {
                translation.append(separator);
            }
            translation.append(character);
        }
        return translation.toString();
    }

    /* renamed from: a */
    static String m33125a(String name) {
        StringBuilder fieldNameBuilder = new StringBuilder();
        int index = 0;
        char firstCharacter = name.charAt(0);
        int length = name.length();
        while (index < length - 1 && !Character.isLetter(firstCharacter)) {
            fieldNameBuilder.append(firstCharacter);
            index++;
            firstCharacter = name.charAt(index);
        }
        if (Character.isUpperCase(firstCharacter)) {
            return name;
        }
        fieldNameBuilder.append(m33124a(Character.toUpperCase(firstCharacter), name, index + 1));
        return fieldNameBuilder.toString();
    }

    /* renamed from: a */
    private static String m33124a(char firstCharacter, String srcString, int indexOfSubstring) {
        if (indexOfSubstring >= srcString.length()) {
            return String.valueOf(firstCharacter);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(firstCharacter);
        sb.append(srcString.substring(indexOfSubstring));
        return sb.toString();
    }
}
