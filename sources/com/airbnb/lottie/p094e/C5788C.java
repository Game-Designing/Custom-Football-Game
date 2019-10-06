package com.airbnb.lottie.p094e;

import android.util.JsonReader;
import com.airbnb.lottie.C5830g;
import com.airbnb.lottie.p089c.p090a.C5721b;
import com.airbnb.lottie.p089c.p090a.C5731l;
import com.airbnb.lottie.p089c.p091b.C5748k;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.e.C */
/* compiled from: RepeaterParser */
class C5788C {
    /* renamed from: a */
    static C5748k m10418a(JsonReader reader, C5830g composition) throws IOException {
        String name = null;
        C5721b copies = null;
        C5721b offset = null;
        C5731l transform = null;
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 99) {
                if (hashCode != 111) {
                    if (hashCode != 3519) {
                        if (hashCode == 3710 && nextName.equals("tr")) {
                            c = 3;
                        }
                    } else if (nextName.equals("nm")) {
                        c = 0;
                    }
                } else if (nextName.equals("o")) {
                    c = 2;
                }
            } else if (nextName.equals("c")) {
                c = 1;
            }
            if (c == 0) {
                name = reader.nextString();
            } else if (c == 1) {
                copies = C5800d.m10435a(reader, composition, false);
            } else if (c == 2) {
                offset = C5800d.m10435a(reader, composition, false);
            } else if (c != 3) {
                reader.skipValue();
            } else {
                transform = C5799c.m10433a(reader, composition);
            }
        }
        return new C5748k(name, copies, offset, transform);
    }
}
