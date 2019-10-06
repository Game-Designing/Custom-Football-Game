package com.google.zxing.p201d;

import com.google.zxing.C10197a;
import com.google.zxing.C10211c;
import com.google.zxing.WriterException;
import com.google.zxing.p198b.C10209b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* renamed from: com.google.zxing.d.d */
/* compiled from: Code128Writer */
public final class C10234d extends C10246o {

    /* renamed from: com.google.zxing.d.d$a */
    /* compiled from: Code128Writer */
    private enum C10235a {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    /* renamed from: a */
    public C10209b mo33488a(String contents, C10197a format, int width, int height, Map<C10211c, ?> hints) throws WriterException {
        if (format == C10197a.CODE_128) {
            return super.mo33488a(contents, format, width, height, hints);
        }
        StringBuilder sb = new StringBuilder("Can only encode CODE_128, but got ");
        sb.append(format);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public boolean[] mo33598a(String contents) {
        int patternIndex;
        int patternIndex2;
        String str = contents;
        int length = contents.length();
        int length2 = length;
        if (length <= 0 || length2 > 80) {
            StringBuilder sb = new StringBuilder("Contents length should be between 1 and 80 characters, but got ");
            sb.append(length2);
            throw new IllegalArgumentException(sb.toString());
        }
        for (int i = 0; i < length2; i++) {
            char charAt = str.charAt(i);
            char c = charAt;
            if (charAt < ' ' || c > '~') {
                switch (c) {
                    case 241:
                    case 242:
                    case 243:
                    case 244:
                        break;
                    default:
                        StringBuilder sb2 = new StringBuilder("Bad character in input: ");
                        sb2.append(c);
                        throw new IllegalArgumentException(sb2.toString());
                }
            }
        }
        Collection<int[]> patterns = new ArrayList<>();
        int checkSum = 0;
        int codeSet = 0;
        int position = 0;
        int checkWeight = 1;
        while (position < length2) {
            int a = m33365a(str, position, codeSet);
            int newCodeSet = a;
            if (a == codeSet) {
                switch (str.charAt(position)) {
                    case 241:
                        patternIndex = 102;
                        break;
                    case 242:
                        patternIndex = 97;
                        break;
                    case 243:
                        patternIndex = 96;
                        break;
                    case 244:
                        patternIndex = 100;
                        break;
                    default:
                        if (codeSet != 100) {
                            patternIndex = Integer.parseInt(str.substring(position, position + 2));
                            position++;
                            break;
                        } else {
                            patternIndex = str.charAt(position) - ' ';
                            break;
                        }
                }
                position++;
            } else {
                if (codeSet != 0) {
                    patternIndex2 = newCodeSet;
                } else if (newCodeSet == 100) {
                    patternIndex2 = 104;
                } else {
                    patternIndex2 = 105;
                }
                codeSet = newCodeSet;
            }
            patterns.add(C10233c.f31035a[patternIndex]);
            checkSum += patternIndex * checkWeight;
            if (position != 0) {
                checkWeight++;
            }
        }
        patterns.add(C10233c.f31035a[checkSum % 103]);
        patterns.add(C10233c.f31035a[106]);
        int codeWidth = 0;
        for (int[] iArr : patterns) {
            int codeWidth2 = codeWidth;
            for (int width : (int[]) r6.next()) {
                codeWidth2 += width;
            }
            codeWidth = codeWidth2;
        }
        boolean[] result = new boolean[codeWidth];
        int pos = 0;
        for (int[] pattern : patterns) {
            pos += C10246o.m33383a(result, pos, pattern, true);
        }
        return result;
    }

    /* renamed from: a */
    private static C10235a m33366a(CharSequence value, int start) {
        int last = value.length();
        if (start >= last) {
            return C10235a.UNCODABLE;
        }
        char charAt = value.charAt(start);
        char c = charAt;
        if (charAt == 241) {
            return C10235a.FNC_1;
        }
        if (c < '0' || c > '9') {
            return C10235a.UNCODABLE;
        }
        if (start + 1 >= last) {
            return C10235a.ONE_DIGIT;
        }
        char charAt2 = value.charAt(start + 1);
        char c2 = charAt2;
        if (charAt2 < '0' || c2 > '9') {
            return C10235a.ONE_DIGIT;
        }
        return C10235a.TWO_DIGITS;
    }

    /* renamed from: a */
    private static int m33365a(CharSequence value, int start, int oldCode) {
        C10235a lookahead;
        C10235a a = m33366a(value, start);
        C10235a lookahead2 = a;
        if (a == C10235a.UNCODABLE || lookahead2 == C10235a.ONE_DIGIT) {
            return 100;
        }
        if (oldCode == 99) {
            return oldCode;
        }
        if (oldCode != 100) {
            if (lookahead2 == C10235a.FNC_1) {
                lookahead2 = m33366a(value, start + 1);
            }
            if (lookahead2 == C10235a.TWO_DIGITS) {
                return 99;
            }
            return 100;
        } else if (lookahead2 == C10235a.FNC_1) {
            return oldCode;
        } else {
            C10235a a2 = m33366a(value, start + 2);
            C10235a lookahead3 = a2;
            if (a2 == C10235a.UNCODABLE || lookahead3 == C10235a.ONE_DIGIT) {
                return oldCode;
            }
            if (lookahead3 != C10235a.FNC_1) {
                int index = start + 4;
                while (true) {
                    C10235a a3 = m33366a(value, index);
                    lookahead = a3;
                    if (a3 != C10235a.TWO_DIGITS) {
                        break;
                    }
                    index += 2;
                }
                if (lookahead == C10235a.ONE_DIGIT) {
                    return 100;
                }
                return 99;
            } else if (m33366a(value, start + 3) == C10235a.TWO_DIGITS) {
                return 99;
            } else {
                return 100;
            }
        }
    }
}
