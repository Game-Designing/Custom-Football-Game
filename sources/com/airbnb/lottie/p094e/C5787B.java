package com.airbnb.lottie.p094e;

import android.graphics.PointF;
import android.util.JsonReader;
import com.airbnb.lottie.C5830g;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.p089c.p090a.C5721b;
import com.airbnb.lottie.p089c.p090a.C5725f;
import com.airbnb.lottie.p089c.p091b.C5747j;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.e.B */
/* compiled from: RectangleShapeParser */
class C5787B {
    /* renamed from: a */
    static C5747j m10417a(JsonReader reader, C5830g composition) throws IOException {
        String name = null;
        AnimatableValue<PointF, PointF> position = null;
        C5725f size = null;
        C5721b roundedness = null;
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 112) {
                if (hashCode != 3519) {
                    if (hashCode != 114) {
                        if (hashCode == 115 && nextName.equals("s")) {
                            c = 2;
                        }
                    } else if (nextName.equals("r")) {
                        c = 3;
                    }
                } else if (nextName.equals("nm")) {
                    c = 0;
                }
            } else if (nextName.equals("p")) {
                c = 1;
            }
            if (c == 0) {
                name = reader.nextString();
            } else if (c == 1) {
                position = C5797a.m10430b(reader, composition);
            } else if (c == 2) {
                size = C5800d.m10442e(reader, composition);
            } else if (c != 3) {
                reader.skipValue();
            } else {
                roundedness = C5800d.m10440c(reader, composition);
            }
        }
        return new C5747j(name, position, size, roundedness);
    }
}
