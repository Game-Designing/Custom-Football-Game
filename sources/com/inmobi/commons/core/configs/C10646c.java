package com.inmobi.commons.core.configs;

import com.inmobi.commons.core.p221d.C10657c;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.configs.c */
/* compiled from: ConfigDao */
public final class C10646c {

    /* renamed from: a */
    C10657c f32455a = C10657c.m34974b("config_store");

    /* renamed from: a */
    public final void mo34458a(C10639a aVar) {
        C10657c cVar = this.f32455a;
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.mo33671a());
        sb.append("_config");
        String c = cVar.mo34483c(sb.toString());
        if (c != null) {
            try {
                aVar.mo33672a(new JSONObject(c));
            } catch (JSONException e) {
            }
        }
    }

    /* renamed from: a */
    public final boolean mo34460a(String str) {
        C10657c cVar = this.f32455a;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_config");
        return cVar.mo34483c(sb.toString()) != null;
    }

    /* renamed from: b */
    public final long mo34461b(String str) {
        C10657c cVar = this.f32455a;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_config_update_ts");
        return cVar.mo34481b(sb.toString(), 0);
    }

    /* renamed from: a */
    public final void mo34459a(String str, long j) {
        C10657c cVar = this.f32455a;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_config_update_ts");
        cVar.mo34478a(sb.toString(), j);
    }
}
