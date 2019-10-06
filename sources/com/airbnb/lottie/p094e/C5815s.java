package com.airbnb.lottie.p094e;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.C5830g;
import com.airbnb.lottie.p096g.C5831a;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.e.s */
/* compiled from: KeyframesParser */
class C5815s {
    /* renamed from: a */
    static <T> List<C5831a<T>> m10476a(JsonReader reader, C5830g composition, float scale, C5796K<T> valueParser) throws IOException {
        List<Keyframe<T>> keyframes = new ArrayList<>();
        if (reader.peek() == JsonToken.STRING) {
            composition.mo18189a("Lottie doesn't support expressions.");
            return keyframes;
        }
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            char c = 65535;
            if (nextName.hashCode() == 107 && nextName.equals("k")) {
                c = 0;
            }
            if (c != 0) {
                reader.skipValue();
            } else if (reader.peek() == JsonToken.BEGIN_ARRAY) {
                reader.beginArray();
                if (reader.peek() == JsonToken.NUMBER) {
                    keyframes.add(C5814r.m10472a(reader, composition, scale, valueParser, false));
                } else {
                    while (reader.hasNext()) {
                        keyframes.add(C5814r.m10472a(reader, composition, scale, valueParser, true));
                    }
                }
                reader.endArray();
            } else {
                keyframes.add(C5814r.m10472a(reader, composition, scale, valueParser, false));
            }
        }
        reader.endObject();
        m10477a(keyframes);
        return keyframes;
    }

    /* renamed from: a */
    public static void m10477a(List<? extends C5831a<?>> keyframes) {
        int size = keyframes.size();
        for (int i = 0; i < size - 1; i++) {
            ((C5831a) keyframes.get(i)).f10128f = Float.valueOf(((C5831a) keyframes.get(i + 1)).f10127e);
        }
        Keyframe<?> lastKeyframe = (C5831a) keyframes.get(size - 1);
        if (lastKeyframe.f10124b == null) {
            keyframes.remove(lastKeyframe);
        }
    }
}
