package com.moat.analytics.mobile.iro;

import android.os.Build.VERSION;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.json.JSONArray;
import org.json.JSONObject;
import p019d.p154d.p155a.C7289a;

/* renamed from: com.moat.analytics.mobile.iro.i */
final class C11030i {

    /* renamed from: ʻ */
    private static char[] f33720 = {'s', 'a', '2', 'b', 'c', '3', '4', '1', '8', '9', 'f', '0', '6', 'd', 'e', '5', 'o', 'n', 'i', 'p', 'l', 't', 'u', 'v', 'w'};

    /* renamed from: ʽ */
    private static char f33721 = 5;

    /* renamed from: ˊॱ */
    private static int f33722 = 1;

    /* renamed from: ᐝ */
    private static int f33723 = 0;

    /* renamed from: ˊ */
    private boolean f33724 = false;

    /* renamed from: ˋ */
    private int f33725 = 10;

    /* renamed from: ˎ */
    private int f33726 = 200;

    /* renamed from: ˏ */
    private boolean f33727 = false;

    /* renamed from: ॱ */
    private boolean f33728 = false;

    C11030i(String str) {
        m36309(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0075, code lost:
        if (r10 != 20) goto L_0x0078;
     */
    /* renamed from: ˊ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m36309(java.lang.String r12) {
        /*
            r11 = this;
            java.lang.String r0 = "\n\u0004"
            java.lang.String r1 = "\u0013\u0012"
            if (r12 != 0) goto L_0x0007
            return
        L_0x0007:
            r2 = 0
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0161 }
            r3.<init>(r12)     // Catch:{ Exception -> 0x0161 }
            java.lang.String r12 = "\u0001\u0002"
            r4 = 59
            r5 = 2
            java.lang.String r12 = m36311(r5, r12, r4)     // Catch:{ Exception -> 0x0161 }
            java.lang.String r12 = r12.intern()     // Catch:{ Exception -> 0x0161 }
            java.lang.String r12 = r3.getString(r12)     // Catch:{ Exception -> 0x0161 }
            java.lang.String r6 = "\u0003\u0004\u0000\t\u0007\b\r\b\u0005\u0006\u000b\f\f\u0011\u0007\r\u000e\u0000\b\u0012\t\f\u0004\r\u0004\u0000\u0001\u000e\u0007\u000b\u0005\u0007\n\u0011\b\t\u0007\f\u0004\u0003"
            r7 = 66
            r8 = 40
            java.lang.String r6 = m36311(r8, r6, r7)     // Catch:{ Exception -> 0x0161 }
            java.lang.String r6 = r6.intern()     // Catch:{ Exception -> 0x0161 }
            boolean r6 = r12.equals(r6)     // Catch:{ Exception -> 0x0161 }
            java.lang.String r9 = "\u0005\r\b\f\r\u0006\u0002\u0003\u000e\r\u0007\u0005\u0011\f\u0005\b\u0000\u0010\r\u0004\u0004\u000b\u0005\r\n\u0010\u0006\u000e\u000f\u0014\b\u0006\f\u0004\u0011\f\u0005\u0007\t\u0005"
            r10 = 43
            java.lang.String r8 = m36311(r8, r9, r10)     // Catch:{ Exception -> 0x0161 }
            java.lang.String r8 = r8.intern()     // Catch:{ Exception -> 0x0161 }
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x0161 }
            java.lang.String r9 = "\u0011\u0012"
            r10 = 121(0x79, float:1.7E-43)
            java.lang.String r9 = m36311(r5, r9, r10)     // Catch:{ Exception -> 0x0161 }
            java.lang.String r9 = r9.intern()     // Catch:{ Exception -> 0x0161 }
            boolean r12 = r12.equals(r9)     // Catch:{ Exception -> 0x0161 }
            r9 = 1
            if (r12 != 0) goto L_0x0055
            r12 = 0
            goto L_0x0056
        L_0x0055:
            r12 = 1
        L_0x0056:
            if (r12 == 0) goto L_0x0059
        L_0x0058:
            goto L_0x0078
        L_0x0059:
            int r12 = f33723
            int r12 = r12 + 91
            int r10 = r12 % 128
            f33722 = r10
            int r12 = r12 % r5
            if (r12 != 0) goto L_0x0064
        L_0x0064:
            if (r6 != 0) goto L_0x0068
            r12 = 1
            goto L_0x0069
        L_0x0068:
            r12 = 0
        L_0x0069:
            if (r12 == r9) goto L_0x006c
            goto L_0x0058
        L_0x006c:
            r12 = 20
            if (r8 == 0) goto L_0x0073
            r10 = 34
            goto L_0x0075
        L_0x0073:
            r10 = 20
        L_0x0075:
            if (r10 == r12) goto L_0x00ae
            goto L_0x0058
        L_0x0078:
            boolean r12 = m36310(r3)     // Catch:{ Exception -> 0x0161 }
            if (r12 != 0) goto L_0x0080
            r12 = 1
            goto L_0x0081
        L_0x0080:
            r12 = 0
        L_0x0081:
            if (r12 == 0) goto L_0x00ae
            boolean r12 = m36313(r3)     // Catch:{ Exception -> 0x0161 }
            r10 = 74
            if (r12 != 0) goto L_0x008e
            r12 = 48
            goto L_0x0090
        L_0x008e:
            r12 = 74
        L_0x0090:
            if (r12 == r10) goto L_0x00ae
            r11.f33724 = r9     // Catch:{ Exception -> 0x0161 }
            r11.f33727 = r6     // Catch:{ Exception -> 0x0161 }
            r11.f33728 = r8     // Catch:{ Exception -> 0x0161 }
            boolean r12 = r11.f33728     // Catch:{ Exception -> 0x0161 }
            if (r12 == 0) goto L_0x009e
            r12 = 0
            goto L_0x009f
        L_0x009e:
            r12 = 1
        L_0x009f:
            if (r12 == r9) goto L_0x00ae
            int r12 = f33722
            int r12 = r12 + 51
            int r6 = r12 % 128
            f33723 = r6
            int r12 = r12 % r5
            if (r12 == 0) goto L_0x00ac
        L_0x00ac:
            r11.f33727 = r9     // Catch:{ Exception -> 0x0161 }
        L_0x00ae:
            r12 = 25
            java.lang.String r6 = m36311(r5, r1, r12)     // Catch:{ Exception -> 0x0161 }
            java.lang.String r6 = r6.intern()     // Catch:{ Exception -> 0x0161 }
            boolean r6 = r3.has(r6)     // Catch:{ Exception -> 0x0161 }
            if (r6 == 0) goto L_0x00c0
            r6 = 1
            goto L_0x00c1
        L_0x00c0:
            r6 = 0
        L_0x00c1:
            if (r6 == 0) goto L_0x0101
            java.lang.String r12 = m36311(r5, r1, r12)     // Catch:{ Exception -> 0x0161 }
            java.lang.String r12 = r12.intern()     // Catch:{ Exception -> 0x0161 }
            int r12 = r3.getInt(r12)     // Catch:{ Exception -> 0x0161 }
            r1 = 100
            r6 = 56
            if (r12 < r1) goto L_0x00d8
            r7 = 56
            goto L_0x00d9
        L_0x00d8:
        L_0x00d9:
            if (r7 == r6) goto L_0x00dc
            goto L_0x0101
        L_0x00dc:
            int r1 = f33723
            int r1 = r1 + 117
            int r6 = r1 % 128
            f33722 = r6
            int r1 = r1 % r5
            if (r1 != 0) goto L_0x00e7
        L_0x00e7:
            r1 = 1000(0x3e8, float:1.401E-42)
            if (r12 > r1) goto L_0x00ee
            r1 = 75
            goto L_0x00f0
        L_0x00ee:
            r1 = 52
        L_0x00f0:
            r6 = 75
            if (r1 == r6) goto L_0x00f5
            goto L_0x0101
        L_0x00f5:
            int r1 = f33722
            int r1 = r1 + r4
            int r4 = r1 % 128
            f33723 = r4
            int r1 = r1 % r5
            if (r1 == 0) goto L_0x00ff
        L_0x00ff:
            r11.f33726 = r12     // Catch:{ Exception -> 0x0161 }
        L_0x0101:
            r12 = 24
            java.lang.String r1 = m36311(r5, r0, r12)     // Catch:{ Exception -> 0x0161 }
            java.lang.String r1 = r1.intern()     // Catch:{ Exception -> 0x0161 }
            boolean r1 = r3.has(r1)     // Catch:{ Exception -> 0x0161 }
            if (r1 == 0) goto L_0x0113
            r1 = 0
            goto L_0x0114
        L_0x0113:
            r1 = 1
        L_0x0114:
            if (r1 == r9) goto L_0x012f
            int r1 = f33723
            int r1 = r1 + 55
            int r4 = r1 % 128
            f33722 = r4
            int r1 = r1 % r5
            if (r1 != 0) goto L_0x0121
        L_0x0121:
            java.lang.String r12 = m36311(r5, r0, r12)     // Catch:{ Exception -> 0x0161 }
            java.lang.String r12 = r12.intern()     // Catch:{ Exception -> 0x0161 }
            int r12 = r3.getInt(r12)     // Catch:{ Exception -> 0x0161 }
            r11.f33725 = r12     // Catch:{ Exception -> 0x0161 }
        L_0x012f:
            boolean r12 = m36312(r3)     // Catch:{ Exception -> 0x0161 }
            r0 = 71
            if (r12 == 0) goto L_0x013a
            r12 = 71
            goto L_0x013b
        L_0x013a:
            r12 = 1
        L_0x013b:
            if (r12 == r0) goto L_0x013e
        L_0x013d:
            goto L_0x0157
        L_0x013e:
            int r12 = f33723
            int r12 = r12 + 69
            int r0 = r12 % 128
            f33722 = r0
            int r12 = r12 % r5
            if (r12 != 0) goto L_0x014b
            r12 = 1
            goto L_0x014c
        L_0x014b:
            r12 = 0
        L_0x014c:
            if (r12 == r9) goto L_0x0158
            com.moat.analytics.mobile.iro.MoatAnalytics r12 = com.moat.analytics.mobile.iro.MoatAnalytics.getInstance()     // Catch:{ Exception -> 0x0161 }
            com.moat.analytics.mobile.iro.j r12 = (com.moat.analytics.mobile.iro.C11031j) r12     // Catch:{ Exception -> 0x0161 }
            r12.f33734 = r9     // Catch:{ Exception -> 0x0161 }
            goto L_0x013d
        L_0x0157:
            return
        L_0x0158:
            com.moat.analytics.mobile.iro.MoatAnalytics r12 = com.moat.analytics.mobile.iro.MoatAnalytics.getInstance()     // Catch:{ Exception -> 0x0161 }
            com.moat.analytics.mobile.iro.j r12 = (com.moat.analytics.mobile.iro.C11031j) r12     // Catch:{ Exception -> 0x0161 }
            r12.f33734 = r9     // Catch:{ Exception -> 0x0161 }
            return
        L_0x0161:
            r12 = move-exception
            r11.f33724 = r2
            r11.f33727 = r2
            r0 = 200(0xc8, float:2.8E-43)
            r11.f33726 = r0
            com.moat.analytics.mobile.iro.C11043o.m36351(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moat.analytics.mobile.iro.C11030i.m36309(java.lang.String):void");
    }

    /* renamed from: ˊ */
    private static boolean m36310(JSONObject jSONObject) {
        boolean z;
        String str = "\u0012\u0001";
        try {
            if (16 > VERSION.SDK_INT) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                int i = f33723 + 69;
                f33722 = i % 128;
                if ((i % 2 == 0 ? '?' : '\'') != '?') {
                }
                return true;
            }
            if ((jSONObject.has(m36311(2, str, 62).intern()) ? 'M' : 'V') != 'V') {
                JSONArray jSONArray = jSONObject.getJSONArray(m36311(2, str, 62).intern());
                int length = jSONArray.length();
                int i2 = 0;
                while (true) {
                    if ((i2 < length ? '<' : 'G') != '<') {
                        break;
                    }
                    if ((jSONArray.getInt(i2) == VERSION.SDK_INT ? (char) 14 : 26) == 14) {
                        return true;
                    }
                    i2++;
                }
            }
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    /* renamed from: ˏ */
    private static boolean m36313(JSONObject jSONObject) {
        boolean z;
        char c;
        boolean z2;
        String str = "\u0004\u0010";
        try {
            if (jSONObject.has(m36311(2, str, 47).intern())) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                String r4 = C11044p.m36358().mo36121();
                JSONArray jSONArray = jSONObject.getJSONArray(m36311(2, str, 47).intern());
                int length = jSONArray.length();
                int i = 0;
                while (true) {
                    if (i < length) {
                        c = '\"';
                    } else {
                        c = '8';
                    }
                    if (c != '\"') {
                        break;
                    }
                    int i2 = f33722 + 115;
                    f33723 = i2 % 128;
                    if (i2 % 2 != 0) {
                    }
                    if (jSONArray.getString(i).contentEquals(r4)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        int i3 = f33722 + 47;
                        f33723 = i3 % 128;
                        if (i3 % 2 != 0) {
                        }
                        return true;
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            C11043o.m36351(e);
        }
        return false;
    }

    /* renamed from: ˎ */
    private static boolean m36312(JSONObject jSONObject) {
        char c;
        boolean z;
        boolean z2;
        String str = "\u0000\u0015";
        try {
            if (jSONObject.has(m36311(2, str, 3).intern())) {
                c = 23;
            } else {
                c = '7';
            }
            if (c == 23) {
                int i = f33723 + 73;
                f33722 = i % 128;
                if (i % 2 == 0) {
                }
                String r4 = C11044p.m36358().mo36121();
                JSONArray jSONArray = jSONObject.getJSONArray(m36311(2, str, 3).intern());
                int length = jSONArray.length();
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        break;
                    }
                    if (jSONArray.getString(i2).contentEquals(r4)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        return true;
                    }
                    i2++;
                }
            }
        } catch (Exception e) {
            C11043o.m36351(e);
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊ */
    public final boolean mo36102() {
        return this.f33727;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˎ */
    public final boolean mo36104() {
        return this.f33728;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˋ */
    public final int mo36103() {
        return this.f33726;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱ */
    public final int mo36106() {
        return this.f33725;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ */
    public final int mo36105() {
        return this.f33724 ? C11060c.f33811 : C11060c.f33810;
    }

    /* renamed from: ˎ */
    private static String m36311(int i, String str, byte b) {
        boolean z;
        boolean z2;
        boolean z3;
        char c;
        int i2 = i;
        char[] charArray = str.toCharArray();
        char[] cArr = f33720;
        char c2 = f33721;
        char[] cArr2 = new char[i2];
        if (i2 % 2 != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            int i3 = f33722 + 99;
            f33723 = i3 % 128;
            if (i3 % 2 != 0) {
            }
            i2--;
            cArr2[i2] = (char) (charArray[i2] - b);
        }
        if (i2 > 1) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            int i4 = f33722 + Opcodes.LUSHR;
            f33723 = i4 % 128;
            if (i4 % 2 != 0) {
            }
            int i5 = 0;
            while (true) {
                if ((i5 < i2 ? 'c' : 'U') == 'U') {
                    break;
                }
                char c3 = charArray[i5];
                int i6 = i5 + 1;
                char c4 = charArray[i6];
                if ((c3 == c4 ? 24 : '#') != '#') {
                    cArr2[i5] = (char) (c3 - b);
                    cArr2[i6] = (char) (c4 - b);
                } else {
                    int b2 = C7289a.m15852b(c3, c2);
                    int c5 = C7289a.m15853c(c3, c2);
                    int b3 = C7289a.m15852b(c4, c2);
                    int c6 = C7289a.m15853c(c4, c2);
                    if (c5 == c6) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (!z3) {
                        int a = C7289a.m15850a(b2, c2);
                        int a2 = C7289a.m15850a(b3, c2);
                        int a3 = C7289a.m15851a(a, c5, c2);
                        int a4 = C7289a.m15851a(a2, c6, c2);
                        cArr2[i5] = cArr[a3];
                        cArr2[i6] = cArr[a4];
                    } else {
                        if (b2 == b3) {
                            c = '.';
                        } else {
                            c = '1';
                        }
                        if (c != '1') {
                            int a5 = C7289a.m15850a(c5, c2);
                            int a6 = C7289a.m15850a(c6, c2);
                            int a7 = C7289a.m15851a(b2, a5, c2);
                            int a8 = C7289a.m15851a(b3, a6, c2);
                            cArr2[i5] = cArr[a7];
                            cArr2[i6] = cArr[a8];
                        } else {
                            int a9 = C7289a.m15851a(b2, c6, c2);
                            int a10 = C7289a.m15851a(b3, c5, c2);
                            cArr2[i5] = cArr[a9];
                            cArr2[i6] = cArr[a10];
                        }
                    }
                }
                i5 += 2;
            }
        }
        return new String(cArr2);
    }
}
