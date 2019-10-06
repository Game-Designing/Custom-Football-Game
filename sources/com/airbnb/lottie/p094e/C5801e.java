package com.airbnb.lottie.p094e;

import android.graphics.PointF;
import android.util.JsonReader;
import com.airbnb.lottie.C5830g;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.p089c.p090a.C5725f;
import com.airbnb.lottie.p089c.p091b.C5735a;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.e.e */
/* compiled from: CircleShapeParser */
class C5801e {
    /* renamed from: a */
    static C5735a m10445a(JsonReader reader, C5830g composition, int d) throws IOException {
        String name = null;
        AnimatableValue<PointF, PointF> position = null;
        C5725f size = null;
        boolean reversed = d == 3;
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 100) {
                if (hashCode != 112) {
                    if (hashCode != 115) {
                        if (hashCode == 3519 && nextName.equals("nm")) {
                            c = 0;
                        }
                    } else if (nextName.equals("s")) {
                        c = 2;
                    }
                } else if (nextName.equals("p")) {
                    c = 1;
                }
            } else if (nextName.equals("d")) {
                c = 3;
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
                reversed = reader.nextInt() == 3;
            }
        }
        return new C5735a(name, position, size, reversed);
    }
}
