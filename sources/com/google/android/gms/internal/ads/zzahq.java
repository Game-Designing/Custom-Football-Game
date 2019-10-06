package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

@zzard
public final class zzahq implements zzaho<Object> {

    /* renamed from: a */
    private final Context f24339a;

    public zzahq(Context context) {
        this.f24339a = context;
    }

    /* renamed from: a */
    public final void mo27996a(Object obj, Map<String, String> map) {
        if (zzk.zzme().mo30134f(this.f24339a)) {
            String str = (String) map.get("eventName");
            String str2 = (String) map.get("eventId");
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 94399) {
                if (hashCode != 94401) {
                    if (hashCode == 94407 && str.equals("_ai")) {
                        c = 1;
                    }
                } else if (str.equals("_ac")) {
                    c = 0;
                }
            } else if (str.equals("_aa")) {
                c = 2;
            }
            if (c == 0) {
                zzk.zzme().mo30130d(this.f24339a, str2);
            } else if (c == 1) {
                zzk.zzme().mo30132e(this.f24339a, str2);
            } else if (c != 2) {
                zzbad.m26355b("logScionEvent gmsg contained unsupported eventName");
            } else {
                zzk.zzme().mo30136g(this.f24339a, str2);
            }
        }
    }
}
