package com.inmobi.rendering.mraid;

import com.inmobi.commons.core.p221d.C10657c;

/* renamed from: com.inmobi.rendering.mraid.d */
/* compiled from: MraidJsDao */
public final class C10780d {

    /* renamed from: a */
    public C10657c f32940a = C10657c.m34974b("mraid_js_store");

    /* renamed from: a */
    public final void mo34784a(String str) {
        this.f32940a.mo34479a("mraid_js_string", str);
        this.f32940a.mo34478a("last_updated_ts", System.currentTimeMillis() / 1000);
    }
}
