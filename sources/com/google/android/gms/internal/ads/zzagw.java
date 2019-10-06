package com.google.android.gms.internal.ads;

import java.util.Map;

@zzard
public final class zzagw implements zzaho<Object> {

    /* renamed from: a */
    private final zzagx f24320a;

    public zzagw(zzagx zzagx) {
        this.f24320a = zzagx;
    }

    /* renamed from: a */
    public final void mo27996a(Object obj, Map<String, String> map) {
        String str = (String) map.get("name");
        if (str == null) {
            zzbad.m26359d("App event with no name parameter.");
        } else {
            this.f24320a.onAppEvent(str, (String) map.get("info"));
        }
    }
}
