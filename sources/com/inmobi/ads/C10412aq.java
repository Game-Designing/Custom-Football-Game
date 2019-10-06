package com.inmobi.ads;

import android.os.Build.VERSION;
import com.inmobi.ads.cache.C10513a;
import com.inmobi.ads.cache.C10517d;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.inmobi.ads.aq */
/* compiled from: NativeGifAsset */
class C10412aq extends C10400ak {

    /* renamed from: A */
    private static final String f31695A = C10412aq.class.getSimpleName();

    /* renamed from: z */
    C10598t f31696z;

    C10412aq(String str, String str2, C10401al alVar, String str3, int i, JSONObject jSONObject) {
        this(str, str2, alVar, str3, new LinkedList(), i, jSONObject);
    }

    C10412aq(String str, String str2, C10401al alVar, String str3, List<NativeTracker> list, int i, JSONObject jSONObject) {
        super(str, str2, "GIF", alVar, list);
        C10517d.m34431a();
        C10513a b = C10517d.m34433b(str3);
        this.f31612e = b == null ? null : b.f32049e;
        if (b != null) {
            try {
                String str4 = b.f32049e;
                this.f31696z = VERSION.SDK_INT < 28 ? new C10600u(str4) : new C10581l(str4);
            } catch (Exception e) {
                new StringBuilder("Exception in decoding GIF : ").append(e.getMessage());
                this.f31696z = null;
                C10621a.m34854a().mo34423a(new C10658a(e));
            }
        }
        if (jSONObject != null) {
            this.f31616i = i;
            this.f31613f = jSONObject;
        }
    }
}
