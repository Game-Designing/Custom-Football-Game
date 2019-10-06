package com.google.android.gms.common.server.response;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Stack;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

@ShowFirstParty
@KeepForSdk
public class FastParser<T extends FastJsonResponse> {

    /* renamed from: a */
    private static final char[] f20213a = {'u', 'l', 'l'};

    /* renamed from: b */
    private static final char[] f20214b = {'r', 'u', 'e'};

    /* renamed from: c */
    private static final char[] f20215c = {'r', 'u', 'e', '\"'};

    /* renamed from: d */
    private static final char[] f20216d = {'a', 'l', 's', 'e'};

    /* renamed from: e */
    private static final char[] f20217e = {'a', 'l', 's', 'e', '\"'};

    /* renamed from: f */
    private static final char[] f20218f = {10};

    /* renamed from: g */
    private static final C8717a<Integer> f20219g = new C8718a();

    /* renamed from: h */
    private static final C8717a<Long> f20220h = new C8719b();

    /* renamed from: i */
    private static final C8717a<Float> f20221i = new C8720c();

    /* renamed from: j */
    private static final C8717a<Double> f20222j = new C8721d();

    /* renamed from: k */
    private static final C8717a<Boolean> f20223k = new C8722e();

    /* renamed from: l */
    private static final C8717a<String> f20224l = new C8723f();

    /* renamed from: m */
    private static final C8717a<BigInteger> f20225m = new C8724g();

    /* renamed from: n */
    private static final C8717a<BigDecimal> f20226n = new C8725h();

    /* renamed from: o */
    private final char[] f20227o = new char[1];

    /* renamed from: p */
    private final char[] f20228p = new char[32];

    /* renamed from: q */
    private final char[] f20229q = new char[Opcodes.ACC_ABSTRACT];

    /* renamed from: r */
    private final StringBuilder f20230r = new StringBuilder(32);

    /* renamed from: s */
    private final StringBuilder f20231s = new StringBuilder(Opcodes.ACC_ABSTRACT);

    /* renamed from: t */
    private final Stack<Integer> f20232t = new Stack<>();

    @ShowFirstParty
    @KeepForSdk
    public static class ParseException extends Exception {
    }

    /* renamed from: com.google.android.gms.common.server.response.FastParser$a */
    private interface C8717a<O> {
    }
}
