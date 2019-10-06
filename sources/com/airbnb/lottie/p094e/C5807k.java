package com.airbnb.lottie.p094e;

import android.util.JsonReader;
import com.airbnb.lottie.p089c.C5759c;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.e.k */
/* compiled from: FontParser */
class C5807k {
    /* renamed from: a */
    static C5759c m10454a(JsonReader reader) throws IOException {
        String family = null;
        String name = null;
        String style = null;
        float ascent = 0.0f;
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1866931350:
                    if (nextName.equals("fFamily")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1408684838:
                    if (nextName.equals("ascent")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1294566165:
                    if (nextName.equals("fStyle")) {
                        c = 2;
                        break;
                    }
                    break;
                case 96619537:
                    if (nextName.equals("fName")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                family = reader.nextString();
            } else if (c == 1) {
                name = reader.nextString();
            } else if (c == 2) {
                style = reader.nextString();
            } else if (c != 3) {
                reader.skipValue();
            } else {
                ascent = (float) reader.nextDouble();
            }
        }
        reader.endObject();
        return new C5759c(family, name, style, ascent);
    }
}
