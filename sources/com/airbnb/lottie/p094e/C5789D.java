package com.airbnb.lottie.p094e;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.p096g.C5834d;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.e.D */
/* compiled from: ScaleXYParser */
public class C5789D implements C5796K<C5834d> {

    /* renamed from: a */
    public static final C5789D f10080a = new C5789D();

    private C5789D() {
    }

    /* renamed from: a */
    public C5834d m10420a(JsonReader reader, float scale) throws IOException {
        boolean isArray = reader.peek() == JsonToken.BEGIN_ARRAY;
        if (isArray) {
            reader.beginArray();
        }
        float sx = (float) reader.nextDouble();
        float sy = (float) reader.nextDouble();
        while (reader.hasNext()) {
            reader.skipValue();
        }
        if (isArray) {
            reader.endArray();
        }
        return new C5834d((sx / 100.0f) * scale, (sy / 100.0f) * scale);
    }
}
