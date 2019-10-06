package com.smaato.soma.p239c.p246f.p249c;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p239c.p252i.C12280f;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.smaato.soma.c.f.c.h */
/* compiled from: InternalUserSettings */
public class C12225h {

    /* renamed from: a */
    private C12229k f38298a;

    public C12225h(C12229k userSettings) {
        this.f38298a = userSettings;
    }

    /* renamed from: a */
    public final Map<String, String> mo39571a() {
        C12146d.m39966a((Object) new C12224g(this));
        Map<String, String> params = new HashMap<>();
        params.put("coppa", String.valueOf(this.f38298a.mo39587h()));
        String genderValue = this.f38298a.mo39586g().mo39588e();
        if (!C12280f.m40428a((CharSequence) genderValue)) {
            params.put(InneractiveMediationDefs.KEY_GENDER, genderValue);
        }
        if (this.f38298a.mo39580a() > 0) {
            params.put(InneractiveMediationDefs.KEY_AGE, String.valueOf(this.f38298a.mo39580a()));
        }
        String keywords = this.f38298a.mo39581b();
        if (!C12280f.m40428a((CharSequence) keywords)) {
            params.put("kws", keywords);
        }
        String searchQuery = this.f38298a.mo39585f();
        if (!C12280f.m40428a((CharSequence) searchQuery)) {
            params.put("qs", searchQuery);
        }
        String region = this.f38298a.mo39584e();
        if (!C12280f.m40428a((CharSequence) region)) {
            params.put("region", region);
        }
        return params;
    }
}
