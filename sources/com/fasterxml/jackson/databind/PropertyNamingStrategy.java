package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import java.io.Serializable;

public class PropertyNamingStrategy implements Serializable {
    @Deprecated
    public static final PropertyNamingStrategy CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES = SNAKE_CASE;
    public static final PropertyNamingStrategy KEBAB_CASE = new KebabCaseStrategy();
    public static final PropertyNamingStrategy LOWER_CAMEL_CASE = new PropertyNamingStrategy();
    public static final PropertyNamingStrategy LOWER_CASE = new LowerCaseStrategy();
    @Deprecated
    public static final PropertyNamingStrategy PASCAL_CASE_TO_CAMEL_CASE = UPPER_CAMEL_CASE;
    public static final PropertyNamingStrategy SNAKE_CASE = new SnakeCaseStrategy();
    public static final PropertyNamingStrategy UPPER_CAMEL_CASE = new UpperCamelCaseStrategy();

    public static class KebabCaseStrategy extends PropertyNamingStrategyBase {
        public String translate(String input) {
            if (input == null) {
                return input;
            }
            int length = input.length();
            if (length == 0) {
                return input;
            }
            StringBuilder result = new StringBuilder((length >> 1) + length);
            int upperCount = 0;
            for (int i = 0; i < length; i++) {
                char ch = input.charAt(i);
                char lc = Character.toLowerCase(ch);
                if (lc == ch) {
                    if (upperCount > 1) {
                        result.insert(result.length() - 1, '-');
                    }
                    upperCount = 0;
                } else {
                    if (upperCount == 0 && i > 0) {
                        result.append('-');
                    }
                    upperCount++;
                }
                result.append(lc);
            }
            return result.toString();
        }
    }

    public static class LowerCaseStrategy extends PropertyNamingStrategyBase {
        public String translate(String input) {
            return input.toLowerCase();
        }
    }

    public static abstract class PropertyNamingStrategyBase extends PropertyNamingStrategy {
        public abstract String translate(String str);

        public String nameForField(MapperConfig<?> mapperConfig, AnnotatedField field, String defaultName) {
            return translate(defaultName);
        }

        public String nameForGetterMethod(MapperConfig<?> mapperConfig, AnnotatedMethod method, String defaultName) {
            return translate(defaultName);
        }

        public String nameForSetterMethod(MapperConfig<?> mapperConfig, AnnotatedMethod method, String defaultName) {
            return translate(defaultName);
        }

        public String nameForConstructorParameter(MapperConfig<?> mapperConfig, AnnotatedParameter ctorParam, String defaultName) {
            return translate(defaultName);
        }
    }

    public static class SnakeCaseStrategy extends PropertyNamingStrategyBase {
        public String translate(String input) {
            if (input == null) {
                return input;
            }
            int length = input.length();
            StringBuilder result = new StringBuilder(length * 2);
            int resultLength = 0;
            boolean wasPrevTranslated = false;
            for (int i = 0; i < length; i++) {
                char c = input.charAt(i);
                if (i > 0 || c != '_') {
                    if (Character.isUpperCase(c)) {
                        if (!wasPrevTranslated && resultLength > 0 && result.charAt(resultLength - 1) != '_') {
                            result.append('_');
                            resultLength++;
                        }
                        c = Character.toLowerCase(c);
                        wasPrevTranslated = true;
                    } else {
                        wasPrevTranslated = false;
                    }
                    result.append(c);
                    resultLength++;
                }
            }
            return resultLength > 0 ? result.toString() : input;
        }
    }

    public static class UpperCamelCaseStrategy extends PropertyNamingStrategyBase {
        public String translate(String input) {
            if (input == null || input.length() == 0) {
                return input;
            }
            char c = input.charAt(0);
            char uc = Character.toUpperCase(c);
            if (c == uc) {
                return input;
            }
            StringBuilder sb = new StringBuilder(input);
            sb.setCharAt(0, uc);
            return sb.toString();
        }
    }

    public String nameForField(MapperConfig<?> mapperConfig, AnnotatedField field, String defaultName) {
        return defaultName;
    }

    public String nameForGetterMethod(MapperConfig<?> mapperConfig, AnnotatedMethod method, String defaultName) {
        return defaultName;
    }

    public String nameForSetterMethod(MapperConfig<?> mapperConfig, AnnotatedMethod method, String defaultName) {
        return defaultName;
    }

    public String nameForConstructorParameter(MapperConfig<?> mapperConfig, AnnotatedParameter ctorParam, String defaultName) {
        return defaultName;
    }
}
