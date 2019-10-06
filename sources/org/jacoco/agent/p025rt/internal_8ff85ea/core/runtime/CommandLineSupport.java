package org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime;

import java.util.ArrayList;
import java.util.List;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.runtime.CommandLineSupport */
final class CommandLineSupport {
    private static final char BLANK = ' ';
    private static final int M_ESCAPED = 2;
    private static final int M_PARSEARGUMENT = 1;
    private static final int M_STRIPWHITESPACE = 0;
    private static final char QUOTE = '\"';
    private static final char SLASH = '\\';

    static String quote(String arg) {
        char[] arr$;
        StringBuilder escaped = new StringBuilder();
        for (char c : arg.toCharArray()) {
            if (c == '\"' || c == '\\') {
                escaped.append(SLASH);
            }
            escaped.append(c);
        }
        if (!(arg.indexOf(32) == -1 && arg.indexOf(34) == -1)) {
            escaped.insert(0, QUOTE).append(QUOTE);
        }
        return escaped.toString();
    }

    static String quote(List<String> args) {
        StringBuilder result = new StringBuilder();
        boolean seperate = false;
        for (String arg : args) {
            if (seperate) {
                result.append(BLANK);
            }
            result.append(quote(arg));
            seperate = true;
        }
        return result.toString();
    }

    static List<String> split(String commandline) {
        char[] arr$;
        if (commandline == null || commandline.length() == 0) {
            return new ArrayList();
        }
        List<String> args = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        int mode = 0;
        int endChar = 32;
        for (char c : commandline.toCharArray()) {
            if (mode != 0) {
                if (mode != 1) {
                    if (mode == 2) {
                        if (c == '\"' || c == '\\') {
                            current.setCharAt(current.length() - 1, c);
                        } else if (c == endChar) {
                            addArgument(args, current);
                        } else {
                            current.append(c);
                        }
                        mode = 1;
                    }
                } else if (c == endChar) {
                    addArgument(args, current);
                    mode = 0;
                } else if (c == '\\') {
                    current.append(SLASH);
                    mode = 2;
                } else {
                    current.append(c);
                }
            } else if (!Character.isWhitespace(c)) {
                if (c == '\"') {
                    endChar = 34;
                } else {
                    current.append(c);
                    endChar = 32;
                }
                mode = 1;
            }
        }
        addArgument(args, current);
        return args;
    }

    private static void addArgument(List<String> args, StringBuilder current) {
        if (current.length() > 0) {
            args.add(current.toString());
            current.setLength(0);
        }
    }

    private CommandLineSupport() {
    }
}
