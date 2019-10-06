package com.airbnb.lottie.p094e;

import android.util.JsonReader;
import com.airbnb.lottie.C5830g;
import com.airbnb.lottie.p089c.p090a.C5720a;
import com.airbnb.lottie.p089c.p090a.C5721b;
import com.airbnb.lottie.p089c.p090a.C5730k;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.e.b */
/* compiled from: AnimatableTextPropertiesParser */
public class C5798b {
    /* renamed from: a */
    public static C5730k m10431a(JsonReader reader, C5830g composition) throws IOException {
        C5730k anim = null;
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            char c = 65535;
            if (nextName.hashCode() == 97 && nextName.equals("a")) {
                c = 0;
            }
            if (c != 0) {
                reader.skipValue();
            } else {
                anim = m10432b(reader, composition);
            }
        }
        reader.endObject();
        if (anim == null) {
            return new C5730k(null, null, null, null);
        }
        return anim;
    }

    /* renamed from: b */
    private static C5730k m10432b(JsonReader reader, C5830g composition) throws IOException {
        C5720a color = null;
        C5720a stroke = null;
        C5721b strokeWidth = null;
        C5721b tracking = null;
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 116) {
                if (hashCode != 3261) {
                    if (hashCode != 3664) {
                        if (hashCode == 3684 && nextName.equals("sw")) {
                            c = 2;
                        }
                    } else if (nextName.equals("sc")) {
                        c = 1;
                    }
                } else if (nextName.equals("fc")) {
                    c = 0;
                }
            } else if (nextName.equals("t")) {
                c = 3;
            }
            if (c == 0) {
                color = C5800d.m10434a(reader, composition);
            } else if (c == 1) {
                stroke = C5800d.m10434a(reader, composition);
            } else if (c == 2) {
                strokeWidth = C5800d.m10440c(reader, composition);
            } else if (c != 3) {
                reader.skipValue();
            } else {
                tracking = C5800d.m10440c(reader, composition);
            }
        }
        reader.endObject();
        return new C5730k(color, stroke, strokeWidth, tracking);
    }
}
