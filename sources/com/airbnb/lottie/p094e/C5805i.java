package com.airbnb.lottie.p094e;

import android.util.JsonReader;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.e.i */
/* compiled from: FloatParser */
public class C5805i implements C5796K<Float> {

    /* renamed from: a */
    public static final C5805i f10084a = new C5805i();

    private C5805i() {
    }

    /* renamed from: a */
    public Float m10452a(JsonReader reader, float scale) throws IOException {
        return Float.valueOf(C5813q.m10465b(reader) * scale);
    }
}
