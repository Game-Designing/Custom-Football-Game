package com.airbnb.lottie.p094e;

import android.util.JsonReader;
import com.airbnb.lottie.C5830g;
import com.airbnb.lottie.p089c.p090a.C5727h;
import com.airbnb.lottie.p089c.p091b.C5752o;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.e.H */
/* compiled from: ShapePathParser */
class C5793H {
    /* renamed from: a */
    static C5752o m10425a(JsonReader reader, C5830g composition) throws IOException {
        String name = null;
        int ind = 0;
        C5727h shape = null;
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 3432) {
                if (hashCode != 3519) {
                    if (hashCode == 104415 && nextName.equals("ind")) {
                        c = 1;
                    }
                } else if (nextName.equals("nm")) {
                    c = 0;
                }
            } else if (nextName.equals("ks")) {
                c = 2;
            }
            if (c == 0) {
                name = reader.nextString();
            } else if (c == 1) {
                ind = reader.nextInt();
            } else if (c != 2) {
                reader.skipValue();
            } else {
                shape = C5800d.m10444g(reader, composition);
            }
        }
        return new C5752o(name, ind, shape);
    }
}
