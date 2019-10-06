package com.airbnb.lottie.p094e;

import android.util.JsonReader;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.e.o */
/* compiled from: IntegerParser */
public class C5811o implements C5796K<Integer> {

    /* renamed from: a */
    public static final C5811o f10086a = new C5811o();

    private C5811o() {
    }

    /* renamed from: a */
    public Integer m10462a(JsonReader reader, float scale) throws IOException {
        return Integer.valueOf(Math.round(C5813q.m10465b(reader) * scale));
    }
}
