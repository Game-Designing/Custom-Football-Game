package com.facebook;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: com.facebook.v */
/* compiled from: GraphRequest */
class C6811v implements C6547d {

    /* renamed from: a */
    final /* synthetic */ ArrayList f12527a;

    /* renamed from: b */
    final /* synthetic */ GraphRequest f12528b;

    C6811v(GraphRequest this$0, ArrayList arrayList) {
        this.f12528b = this$0;
        this.f12527a = arrayList;
    }

    /* renamed from: a */
    public void mo19701a(String key, String value) throws IOException {
        this.f12527a.add(String.format(Locale.US, "%s=%s", new Object[]{key, URLEncoder.encode(value, "UTF-8")}));
    }
}
