package com.airbnb.lottie.p094e;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.e.z */
/* compiled from: PointFParser */
public class C5822z implements C5796K<PointF> {

    /* renamed from: a */
    public static final C5822z f10091a = new C5822z();

    private C5822z() {
    }

    /* renamed from: a */
    public PointF m10491a(JsonReader reader, float scale) throws IOException {
        JsonToken token = reader.peek();
        if (token == JsonToken.BEGIN_ARRAY) {
            return C5813q.m10464a(reader, scale);
        }
        if (token == JsonToken.BEGIN_OBJECT) {
            return C5813q.m10464a(reader, scale);
        }
        if (token == JsonToken.NUMBER) {
            PointF point = new PointF(((float) reader.nextDouble()) * scale, ((float) reader.nextDouble()) * scale);
            while (reader.hasNext()) {
                reader.skipValue();
            }
            return point;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot convert json to point. Next token is ");
        sb.append(token);
        throw new IllegalArgumentException(sb.toString());
    }
}
