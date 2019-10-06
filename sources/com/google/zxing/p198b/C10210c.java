package com.google.zxing.p198b;

import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.zxing.b.c */
/* compiled from: CharacterSetECI */
public enum C10210c {
    Cp437((String) new int[]{0, 2}, (int) new String[0]),
    ISO8859_1((String) new int[]{1, 3}, (int) new String[]{"ISO-8859-1"}),
    ISO8859_2((String) 4, (int) new String[]{"ISO-8859-2"}),
    ISO8859_3((String) 5, (int) new String[]{"ISO-8859-3"}),
    ISO8859_4((String) 6, (int) new String[]{"ISO-8859-4"}),
    ISO8859_5((String) 7, (int) new String[]{"ISO-8859-5"}),
    ISO8859_6((String) 8, (int) new String[]{"ISO-8859-6"}),
    ISO8859_7((String) 9, (int) new String[]{"ISO-8859-7"}),
    ISO8859_8((String) 10, (int) new String[]{"ISO-8859-8"}),
    ISO8859_9((String) 11, (int) new String[]{"ISO-8859-9"}),
    ISO8859_10((String) 12, (int) new String[]{"ISO-8859-10"}),
    ISO8859_11((String) 13, (int) new String[]{"ISO-8859-11"}),
    ISO8859_13((String) 15, (int) new String[]{"ISO-8859-13"}),
    ISO8859_14((String) 16, (int) new String[]{"ISO-8859-14"}),
    ISO8859_15((String) 17, (int) new String[]{"ISO-8859-15"}),
    ISO8859_16((String) 18, (int) new String[]{"ISO-8859-16"}),
    SJIS((String) 20, (int) new String[]{"Shift_JIS"}),
    Cp1250((String) 21, (int) new String[]{"windows-1250"}),
    Cp1251((String) 22, (int) new String[]{"windows-1251"}),
    Cp1252((String) 23, (int) new String[]{"windows-1252"}),
    Cp1256((String) 24, (int) new String[]{"windows-1256"}),
    UnicodeBigUnmarked((String) 25, (int) new String[]{"UTF-16BE", "UnicodeBig"}),
    UTF8((String) 26, (int) new String[]{"UTF-8"}),
    ASCII((String) new int[]{27, Opcodes.TABLESWITCH}, (int) new String[]{"US-ASCII"}),
    Big5(28),
    GB18030((String) 29, (int) new String[]{"GB2312", "EUC_CN", "GBK"}),
    EUC_KR((String) 30, (int) new String[]{"EUC-KR"});
    

    /* renamed from: B */
    private static final Map<Integer, C10210c> f30934B = null;

    /* renamed from: C */
    private static final Map<String, C10210c> f30935C = null;

    /* renamed from: E */
    private final int[] f30963E;

    /* renamed from: F */
    private final String[] f30964F;

    static {
        C10210c[] values;
        f30934B = new HashMap();
        f30935C = new HashMap();
        for (C10210c cVar : values()) {
            C10210c eci = cVar;
            for (int value : cVar.f30963E) {
                f30934B.put(Integer.valueOf(value), eci);
            }
            f30935C.put(eci.name(), eci);
            for (String name : eci.f30964F) {
                f30935C.put(name, eci);
            }
        }
    }

    private C10210c(int value) {
        this(r3, r4, new int[]{value}, new String[0]);
    }

    private C10210c(int value, String... otherEncodingNames) {
        this.f30963E = new int[]{value};
        this.f30964F = otherEncodingNames;
    }

    private C10210c(int[] values, String... otherEncodingNames) {
        this.f30963E = values;
        this.f30964F = otherEncodingNames;
    }

    /* renamed from: e */
    public int mo33542e() {
        return this.f30963E[0];
    }

    /* renamed from: a */
    public static C10210c m33254a(String name) {
        return (C10210c) f30935C.get(name);
    }
}
