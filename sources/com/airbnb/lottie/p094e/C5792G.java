package com.airbnb.lottie.p094e;

import android.util.JsonReader;
import com.airbnb.lottie.C5830g;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.p089c.p091b.C5736b;
import com.airbnb.lottie.p089c.p091b.C5751n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.e.G */
/* compiled from: ShapeGroupParser */
class C5792G {
    /* renamed from: a */
    static C5751n m10424a(JsonReader reader, C5830g composition) throws IOException {
        String name = null;
        List<ContentModel> items = new ArrayList<>();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 3371) {
                if (hashCode == 3519 && nextName.equals("nm")) {
                    c = 0;
                }
            } else if (nextName.equals("it")) {
                c = 1;
            }
            if (c == 0) {
                name = reader.nextString();
            } else if (c != 1) {
                reader.skipValue();
            } else {
                reader.beginArray();
                while (reader.hasNext()) {
                    C5736b newItem = C5803g.m10448a(reader, composition);
                    if (newItem != null) {
                        items.add(newItem);
                    }
                }
                reader.endArray();
            }
        }
        return new C5751n(name, items);
    }
}
