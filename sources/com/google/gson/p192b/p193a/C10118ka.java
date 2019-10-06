package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.C10055D;
import com.google.gson.C10188s;
import com.google.gson.p016a.C0089c;
import com.google.gson.p195c.C10172a;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* renamed from: com.google.gson.b.a.ka */
/* compiled from: TypeAdapters */
public final class C10118ka {

    /* renamed from: A */
    public static final C10054C<String> f30696A = new C10072D();

    /* renamed from: B */
    public static final C10054C<BigDecimal> f30697B = new C10073E();

    /* renamed from: C */
    public static final C10054C<BigInteger> f30698C = new C10074F();

    /* renamed from: D */
    public static final C10055D f30699D = m32992a(String.class, f30696A);

    /* renamed from: E */
    public static final C10054C<StringBuilder> f30700E = new C10075G();

    /* renamed from: F */
    public static final C10055D f30701F = m32992a(StringBuilder.class, f30700E);

    /* renamed from: G */
    public static final C10054C<StringBuffer> f30702G = new C10077I();

    /* renamed from: H */
    public static final C10055D f30703H = m32992a(StringBuffer.class, f30702G);

    /* renamed from: I */
    public static final C10054C<URL> f30704I = new C10078J();

    /* renamed from: J */
    public static final C10055D f30705J = m32992a(URL.class, f30704I);

    /* renamed from: K */
    public static final C10054C<URI> f30706K = new C10079K();

    /* renamed from: L */
    public static final C10055D f30707L = m32992a(URI.class, f30706K);

    /* renamed from: M */
    public static final C10054C<InetAddress> f30708M = new C10080L();

    /* renamed from: N */
    public static final C10055D f30709N = m32994b(InetAddress.class, f30708M);

    /* renamed from: O */
    public static final C10054C<UUID> f30710O = new C10081M();

    /* renamed from: P */
    public static final C10055D f30711P = m32992a(UUID.class, f30710O);

    /* renamed from: Q */
    public static final C10054C<Currency> f30712Q = new C10082N().mo33199a();

    /* renamed from: R */
    public static final C10055D f30713R = m32992a(Currency.class, f30712Q);

    /* renamed from: S */
    public static final C10055D f30714S = new C10084P();

    /* renamed from: T */
    public static final C10054C<Calendar> f30715T = new C10085Q();

    /* renamed from: U */
    public static final C10055D f30716U = m32995b(Calendar.class, GregorianCalendar.class, f30715T);

    /* renamed from: V */
    public static final C10054C<Locale> f30717V = new C10086S();

    /* renamed from: W */
    public static final C10055D f30718W = m32992a(Locale.class, f30717V);

    /* renamed from: X */
    public static final C10054C<C10188s> f30719X = new C10087T();

    /* renamed from: Y */
    public static final C10055D f30720Y = m32994b(C10188s.class, f30719X);

    /* renamed from: Z */
    public static final C10055D f30721Z = new C10089V();

    /* renamed from: a */
    public static final C10054C<Class> f30722a = new C10076H().mo33199a();

    /* renamed from: b */
    public static final C10055D f30723b = m32992a(Class.class, f30722a);

    /* renamed from: c */
    public static final C10054C<BitSet> f30724c = new C10088U().mo33199a();

    /* renamed from: d */
    public static final C10055D f30725d = m32992a(BitSet.class, f30724c);

    /* renamed from: e */
    public static final C10054C<Boolean> f30726e = new C10103da();

    /* renamed from: f */
    public static final C10054C<Boolean> f30727f = new C10105ea();

    /* renamed from: g */
    public static final C10055D f30728g = m32993a(Boolean.TYPE, Boolean.class, f30726e);

    /* renamed from: h */
    public static final C10054C<Number> f30729h = new C10107fa();

    /* renamed from: i */
    public static final C10055D f30730i = m32993a(Byte.TYPE, Byte.class, f30729h);

    /* renamed from: j */
    public static final C10054C<Number> f30731j = new C10109ga();

    /* renamed from: k */
    public static final C10055D f30732k = m32993a(Short.TYPE, Short.class, f30731j);

    /* renamed from: l */
    public static final C10054C<Number> f30733l = new C10111ha();

    /* renamed from: m */
    public static final C10055D f30734m = m32993a(Integer.TYPE, Integer.class, f30733l);

    /* renamed from: n */
    public static final C10054C<AtomicInteger> f30735n = new C10113ia().mo33199a();

    /* renamed from: o */
    public static final C10055D f30736o = m32992a(AtomicInteger.class, f30735n);

    /* renamed from: p */
    public static final C10054C<AtomicBoolean> f30737p = new C10115ja().mo33199a();

    /* renamed from: q */
    public static final C10055D f30738q = m32992a(AtomicBoolean.class, f30737p);

    /* renamed from: r */
    public static final C10054C<AtomicIntegerArray> f30739r = new C10136x().mo33199a();

    /* renamed from: s */
    public static final C10055D f30740s = m32992a(AtomicIntegerArray.class, f30739r);

    /* renamed from: t */
    public static final C10054C<Number> f30741t = new C10137y();

    /* renamed from: u */
    public static final C10054C<Number> f30742u = new C10138z();

    /* renamed from: v */
    public static final C10054C<Number> f30743v = new C10069A();

    /* renamed from: w */
    public static final C10054C<Number> f30744w = new C10070B();

    /* renamed from: x */
    public static final C10055D f30745x = m32992a(Number.class, f30744w);

    /* renamed from: y */
    public static final C10054C<Character> f30746y = new C10071C();

    /* renamed from: z */
    public static final C10055D f30747z = m32993a(Character.TYPE, Character.class, f30746y);

    /* renamed from: com.google.gson.b.a.ka$a */
    /* compiled from: TypeAdapters */
    private static final class C10119a<T extends Enum<T>> extends C10054C<T> {

        /* renamed from: a */
        private final Map<String, T> f30748a = new HashMap();

        /* renamed from: b */
        private final Map<T, String> f30749b = new HashMap();

        public C10119a(Class<T> classOfT) {
            T[] tArr;
            try {
                for (T constant : (Enum[]) classOfT.getEnumConstants()) {
                    String name = constant.name();
                    C0089c annotation = (C0089c) classOfT.getField(name).getAnnotation(C0089c.class);
                    if (annotation != null) {
                        name = annotation.value();
                        for (String alternate : annotation.alternate()) {
                            this.f30748a.put(alternate, constant);
                        }
                    }
                    this.f30748a.put(name, constant);
                    this.f30749b.put(constant, name);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        /* renamed from: a */
        public T m32997a(JsonReader in) throws IOException {
            if (in.peek() != JsonToken.NULL) {
                return (Enum) this.f30748a.get(in.nextString());
            }
            in.nextNull();
            return null;
        }

        /* renamed from: a */
        public void mo33198a(JsonWriter out, T value) throws IOException {
            out.value(value == null ? null : (String) this.f30749b.get(value));
        }
    }

    /* renamed from: a */
    public static <TT> C10055D m32991a(C10172a<TT> type, C10054C<TT> typeAdapter) {
        return new C10090W(type, typeAdapter);
    }

    /* renamed from: a */
    public static <TT> C10055D m32992a(Class<TT> type, C10054C<TT> typeAdapter) {
        return new C10091X(type, typeAdapter);
    }

    /* renamed from: a */
    public static <TT> C10055D m32993a(Class<TT> unboxed, Class<TT> boxed, C10054C<? super TT> typeAdapter) {
        return new C10092Y(unboxed, boxed, typeAdapter);
    }

    /* renamed from: b */
    public static <TT> C10055D m32995b(Class<TT> base, Class<? extends TT> sub, C10054C<? super TT> typeAdapter) {
        return new C10093Z(base, sub, typeAdapter);
    }

    /* renamed from: b */
    public static <T1> C10055D m32994b(Class<T1> clazz, C10054C<T1> typeAdapter) {
        return new C10098ba(clazz, typeAdapter);
    }
}
