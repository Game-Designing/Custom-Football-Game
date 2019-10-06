package com.airbnb.lottie.p094e;

import android.util.JsonReader;
import com.airbnb.lottie.C5830g;
import com.airbnb.lottie.p089c.p090a.C5721b;
import com.airbnb.lottie.p089c.p091b.C5757r;
import com.airbnb.lottie.p089c.p091b.C5757r.C5758a;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.e.J */
/* compiled from: ShapeTrimPathParser */
class C5795J {
    /* renamed from: a */
    static C5757r m10427a(JsonReader reader, C5830g composition) throws IOException {
        String name = null;
        C5758a type = null;
        C5721b start = null;
        C5721b end = null;
        C5721b offset = null;
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 101) {
                if (hashCode != 109) {
                    if (hashCode != 111) {
                        if (hashCode != 115) {
                            if (hashCode == 3519 && nextName.equals("nm")) {
                                c = 3;
                            }
                        } else if (nextName.equals("s")) {
                            c = 0;
                        }
                    } else if (nextName.equals("o")) {
                        c = 2;
                    }
                } else if (nextName.equals(InneractiveMediationDefs.GENDER_MALE)) {
                    c = 4;
                }
            } else if (nextName.equals("e")) {
                c = 1;
            }
            if (c == 0) {
                start = C5800d.m10435a(reader, composition, false);
            } else if (c == 1) {
                end = C5800d.m10435a(reader, composition, false);
            } else if (c == 2) {
                offset = C5800d.m10435a(reader, composition, false);
            } else if (c == 3) {
                name = reader.nextString();
            } else if (c != 4) {
                reader.skipValue();
            } else {
                type = C5758a.m10300a(reader.nextInt());
            }
        }
        C5757r rVar = new C5757r(name, type, start, end, offset);
        return rVar;
    }
}
