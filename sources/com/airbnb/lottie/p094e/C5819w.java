package com.airbnb.lottie.p094e;

import android.util.JsonReader;
import com.airbnb.lottie.p089c.p091b.C5743h;
import com.airbnb.lottie.p089c.p091b.C5743h.C5744a;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.e.w */
/* compiled from: MergePathsParser */
class C5819w {
    /* renamed from: a */
    static C5743h m10486a(JsonReader reader) throws IOException {
        String name = null;
        C5744a mode = null;
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 3488) {
                if (hashCode == 3519 && nextName.equals("nm")) {
                    c = 0;
                }
            } else if (nextName.equals("mm")) {
                c = 1;
            }
            if (c == 0) {
                name = reader.nextString();
            } else if (c != 1) {
                reader.skipValue();
            } else {
                mode = C5744a.m10244a(reader.nextInt());
            }
        }
        return new C5743h(name, mode);
    }
}
