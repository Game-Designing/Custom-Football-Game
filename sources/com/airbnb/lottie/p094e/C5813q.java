package com.airbnb.lottie.p094e;

import android.graphics.Color;
import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.e.q */
/* compiled from: JsonUtils */
class C5813q {
    /* renamed from: a */
    static int m10463a(JsonReader reader) throws IOException {
        reader.beginArray();
        int r = (int) (reader.nextDouble() * 255.0d);
        int g = (int) (reader.nextDouble() * 255.0d);
        int b = (int) (reader.nextDouble() * 255.0d);
        while (reader.hasNext()) {
            reader.skipValue();
        }
        reader.endArray();
        return Color.argb(255, r, g, b);
    }

    /* renamed from: b */
    static List<PointF> m10466b(JsonReader reader, float scale) throws IOException {
        List<PointF> points = new ArrayList<>();
        reader.beginArray();
        while (reader.peek() == JsonToken.BEGIN_ARRAY) {
            reader.beginArray();
            points.add(m10464a(reader, scale));
            reader.endArray();
        }
        reader.endArray();
        return points;
    }

    /* renamed from: a */
    static PointF m10464a(JsonReader reader, float scale) throws IOException {
        int i = C5812p.f10087a[reader.peek().ordinal()];
        if (i == 1) {
            return m10468d(reader, scale);
        }
        if (i == 2) {
            return m10467c(reader, scale);
        }
        if (i == 3) {
            return m10469e(reader, scale);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown point starts with ");
        sb.append(reader.peek());
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: d */
    private static PointF m10468d(JsonReader reader, float scale) throws IOException {
        float x = (float) reader.nextDouble();
        float y = (float) reader.nextDouble();
        while (reader.hasNext()) {
            reader.skipValue();
        }
        return new PointF(x * scale, y * scale);
    }

    /* renamed from: c */
    private static PointF m10467c(JsonReader reader, float scale) throws IOException {
        reader.beginArray();
        float x = (float) reader.nextDouble();
        float y = (float) reader.nextDouble();
        while (reader.peek() != JsonToken.END_ARRAY) {
            reader.skipValue();
        }
        reader.endArray();
        return new PointF(x * scale, y * scale);
    }

    /* renamed from: e */
    private static PointF m10469e(JsonReader reader, float scale) throws IOException {
        float x = 0.0f;
        float y = 0.0f;
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 120) {
                if (hashCode == 121 && nextName.equals("y")) {
                    c = 1;
                }
            } else if (nextName.equals("x")) {
                c = 0;
            }
            if (c == 0) {
                x = m10465b(reader);
            } else if (c != 1) {
                reader.skipValue();
            } else {
                y = m10465b(reader);
            }
        }
        reader.endObject();
        return new PointF(x * scale, y * scale);
    }

    /* renamed from: b */
    static float m10465b(JsonReader reader) throws IOException {
        JsonToken token = reader.peek();
        int i = C5812p.f10087a[token.ordinal()];
        if (i == 1) {
            return (float) reader.nextDouble();
        }
        if (i == 2) {
            reader.beginArray();
            float val = (float) reader.nextDouble();
            while (reader.hasNext()) {
                reader.skipValue();
            }
            reader.endArray();
            return val;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown value for token of type ");
        sb.append(token);
        throw new IllegalArgumentException(sb.toString());
    }
}
