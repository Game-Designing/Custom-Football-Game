package com.airbnb.lottie.p094e;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.C5830g;
import com.airbnb.lottie.p089c.p090a.C5721b;
import com.airbnb.lottie.p089c.p090a.C5724e;
import com.airbnb.lottie.p089c.p090a.C5728i;
import com.airbnb.lottie.p089c.p090a.C5732m;
import com.airbnb.lottie.p095f.C5829f;
import com.airbnb.lottie.p096g.C5831a;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.e.a */
/* compiled from: AnimatablePathValueParser */
public class C5797a {
    /* renamed from: a */
    public static C5724e m10429a(JsonReader reader, C5830g composition) throws IOException {
        List<Keyframe<PointF>> keyframes = new ArrayList<>();
        if (reader.peek() == JsonToken.BEGIN_ARRAY) {
            reader.beginArray();
            while (reader.hasNext()) {
                keyframes.add(C5820x.m10487a(reader, composition));
            }
            reader.endArray();
            C5815s.m10477a(keyframes);
        } else {
            keyframes.add(new C5831a(C5813q.m10464a(reader, C5829f.m10534a())));
        }
        return new C5724e(keyframes);
    }

    /* renamed from: b */
    static C5732m<PointF, PointF> m10430b(JsonReader reader, C5830g composition) throws IOException {
        C5724e pathAnimation = null;
        C5721b xAnimation = null;
        C5721b yAnimation = null;
        boolean hasExpressions = false;
        reader.beginObject();
        while (reader.peek() != JsonToken.END_OBJECT) {
            String nextName = reader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 107) {
                if (hashCode != 120) {
                    if (hashCode == 121 && nextName.equals("y")) {
                        c = 2;
                    }
                } else if (nextName.equals("x")) {
                    c = 1;
                }
            } else if (nextName.equals("k")) {
                c = 0;
            }
            if (c == 0) {
                pathAnimation = m10429a(reader, composition);
            } else if (c != 1) {
                if (c != 2) {
                    reader.skipValue();
                } else if (reader.peek() == JsonToken.STRING) {
                    hasExpressions = true;
                    reader.skipValue();
                } else {
                    yAnimation = C5800d.m10440c(reader, composition);
                }
            } else if (reader.peek() == JsonToken.STRING) {
                hasExpressions = true;
                reader.skipValue();
            } else {
                xAnimation = C5800d.m10440c(reader, composition);
            }
        }
        reader.endObject();
        if (hasExpressions) {
            composition.mo18189a("Lottie doesn't support expressions.");
        }
        if (pathAnimation != null) {
            return pathAnimation;
        }
        return new C5728i(xAnimation, yAnimation);
    }
}
