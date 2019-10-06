package com.google.zxing.p201d;

/* renamed from: com.google.zxing.d.b */
/* compiled from: CodaBarWriter */
public final class C10232b extends C10246o {

    /* renamed from: a */
    private static final char[] f31031a = {'A', 'B', 'C', 'D'};

    /* renamed from: b */
    private static final char[] f31032b = {'T', 'N', '*', 'E'};

    /* renamed from: c */
    private static final char[] f31033c = {'/', ':', '+', '.'};

    /* renamed from: d */
    private static final char f31034d = f31031a[0];

    /* renamed from: a */
    public boolean[] mo33598a(String contents) {
        if (contents.length() < 2) {
            StringBuilder sb = new StringBuilder();
            sb.append(f31034d);
            sb.append(contents);
            sb.append(f31034d);
            contents = sb.toString();
        } else {
            char firstChar = Character.toUpperCase(contents.charAt(0));
            char lastChar = Character.toUpperCase(contents.charAt(contents.length() - 1));
            boolean startsNormal = C10231a.m33363a(f31031a, firstChar);
            boolean endsNormal = C10231a.m33363a(f31031a, lastChar);
            boolean startsAlt = C10231a.m33363a(f31032b, firstChar);
            boolean endsAlt = C10231a.m33363a(f31032b, lastChar);
            String str = "Invalid start/end guards: ";
            if (startsNormal) {
                if (!endsNormal) {
                    StringBuilder sb2 = new StringBuilder(str);
                    sb2.append(contents);
                    throw new IllegalArgumentException(sb2.toString());
                }
            } else if (startsAlt) {
                if (!endsAlt) {
                    StringBuilder sb3 = new StringBuilder(str);
                    sb3.append(contents);
                    throw new IllegalArgumentException(sb3.toString());
                }
            } else if (endsNormal || endsAlt) {
                StringBuilder sb4 = new StringBuilder(str);
                sb4.append(contents);
                throw new IllegalArgumentException(sb4.toString());
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(f31034d);
                sb5.append(contents);
                sb5.append(f31034d);
                contents = sb5.toString();
            }
        }
        int resultLength = 20;
        for (int i = 1; i < contents.length() - 1; i++) {
            if (Character.isDigit(contents.charAt(i)) || contents.charAt(i) == '-' || contents.charAt(i) == '$') {
                resultLength += 9;
            } else if (C10231a.m33363a(f31033c, contents.charAt(i))) {
                resultLength += 10;
            } else {
                StringBuilder sb6 = new StringBuilder("Cannot encode : '");
                sb6.append(contents.charAt(i));
                sb6.append('\'');
                throw new IllegalArgumentException(sb6.toString());
            }
        }
        boolean[] result = new boolean[((contents.length() - 1) + resultLength)];
        int position = 0;
        for (int index = 0; index < contents.length(); index++) {
            char c = Character.toUpperCase(contents.charAt(index));
            if (index == 0 || index == contents.length() - 1) {
                if (c == '*') {
                    c = 'C';
                } else if (c == 'E') {
                    c = 'D';
                } else if (c == 'N') {
                    c = 'B';
                } else if (c == 'T') {
                    c = 'A';
                }
            }
            int code = 0;
            int i2 = 0;
            while (true) {
                char[] cArr = C10231a.f31028a;
                if (i2 >= cArr.length) {
                    break;
                } else if (c == cArr[i2]) {
                    code = C10231a.f31029b[i2];
                    break;
                } else {
                    i2++;
                }
            }
            boolean color = true;
            int counter = 0;
            int bit = 0;
            while (bit < 7) {
                result[position] = color;
                position++;
                if (((code >> (6 - bit)) & 1) == 0 || counter == 1) {
                    color = !color;
                    bit++;
                    counter = 0;
                } else {
                    counter++;
                }
            }
            if (index < contents.length() - 1) {
                result[position] = false;
                position++;
            }
        }
        return result;
    }
}
