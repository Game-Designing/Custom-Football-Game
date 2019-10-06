package org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime;

import java.util.regex.Pattern;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.runtime.WildcardMatcher */
public class WildcardMatcher {
    private final Pattern pattern;

    public WildcardMatcher(String expression) {
        String[] arr$;
        String[] parts = expression.split("\\:");
        StringBuilder regex = new StringBuilder(expression.length() * 2);
        boolean next = false;
        for (String part : parts) {
            if (next) {
                regex.append('|');
            }
            regex.append('(');
            regex.append(toRegex(part));
            regex.append(')');
            next = true;
        }
        this.pattern = Pattern.compile(regex.toString());
    }

    private static CharSequence toRegex(String expression) {
        char[] arr$;
        StringBuilder regex = new StringBuilder(expression.length() * 2);
        for (char c : expression.toCharArray()) {
            if (c == '*') {
                regex.append(".*");
            } else if (c != '?') {
                regex.append(Pattern.quote(String.valueOf(c)));
            } else {
                regex.append(".?");
            }
        }
        return regex;
    }

    public boolean matches(String s) {
        return this.pattern.matcher(s).matches();
    }
}
