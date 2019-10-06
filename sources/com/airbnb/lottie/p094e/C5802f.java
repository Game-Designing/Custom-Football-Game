package com.airbnb.lottie.p094e;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.e.f */
/* compiled from: ColorParser */
public class C5802f implements C5796K<Integer> {

    /* renamed from: a */
    public static final C5802f f10082a = new C5802f();

    private C5802f() {
    }

    /* renamed from: a */
    public Integer m10447a(JsonReader reader, float scale) throws IOException {
        boolean isArray = reader.peek() == JsonToken.BEGIN_ARRAY;
        if (isArray) {
            reader.beginArray();
        }
        double r = reader.nextDouble();
        double g = reader.nextDouble();
        double b = reader.nextDouble();
        double a = reader.nextDouble();
        if (isArray) {
            reader.endArray();
        }
        if (r <= 1.0d && g <= 1.0d && b <= 1.0d && a <= 1.0d) {
            r *= 255.0d;
            g *= 255.0d;
            b *= 255.0d;
            a *= 255.0d;
        }
        return Integer.valueOf(Color.argb((int) a, (int) r, (int) g, (int) b));
    }
}
