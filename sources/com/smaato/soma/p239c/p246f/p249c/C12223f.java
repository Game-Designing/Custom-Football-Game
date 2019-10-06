package com.smaato.soma.p239c.p246f.p249c;

import android.view.View;
import com.mopub.common.AdType;
import com.smaato.soma.C12394h;
import com.smaato.soma.C12431j;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p239c.p252i.C12278d;
import com.smaato.soma.p239c.p252i.C12280f;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.smaato.soma.c.f.c.f */
/* compiled from: InternalAdSettings */
public class C12223f {

    /* renamed from: a */
    private final C12394h f38294a;

    /* renamed from: b */
    private final View f38295b;

    /* renamed from: c */
    private final boolean f38296c;

    public C12223f(C12394h adSettings, View view, boolean isTablet) {
        this.f38294a = adSettings;
        this.f38295b = view;
        this.f38296c = isTablet;
    }

    /* renamed from: a */
    public Map<String, String> mo39570a() {
        C12146d.m39966a((Object) new C12222e(this));
        Map<String, String> params = new HashMap<>();
        if (this.f38294a.mo39891g() >= 0) {
            params.put("pub", String.valueOf(this.f38294a.mo39891g()));
        }
        if (this.f38294a.mo39887c() >= 0) {
            params.put("adspace", String.valueOf(this.f38294a.mo39887c()));
        }
        params.put("mraidver", String.valueOf(2));
        params.put("secure", String.valueOf(this.f38294a.mo39892h()));
        String str = "1";
        String str2 = "format";
        if (this.f38294a.mo39885b().mo39935g()) {
            params.put("vastver", "4");
            params.put("linearity", str);
            params.put(str2, C12431j.VIDEO.mo39934f());
            String str3 = "videotype";
            if (this.f38294a.mo39885b() == C12431j.f38814h) {
                params.put(str3, AdType.INTERSTITIAL);
            } else if (this.f38294a.mo39885b() == C12431j.REWARDED) {
                params.put(str3, "rewarded");
            }
        } else {
            params.put(str2, this.f38294a.mo39885b().mo39933e());
            params.put("mediationversion", "2");
        }
        if (this.f38294a.mo39885b() == C12431j.NATIVE) {
            params.put("nver", str);
            String nsupport = this.f38294a.mo39890f();
            if (!C12280f.m40428a((CharSequence) nsupport)) {
                params.put("nsupport", nsupport);
            }
        }
        if (this.f38294a.mo39880a() == null || this.f38294a.mo39880a().mo39386a(this.f38296c).isEmpty()) {
            int width = m40222c();
            int height = m40221b();
            if (!(width == 0 || height == 0 || this.f38294a.mo39885b() == C12431j.MULTI_AD_FORMAT_INTERSTITIAL)) {
                params.put("width", String.valueOf(width));
                params.put("height", String.valueOf(height));
            }
        } else if (this.f38294a.mo39885b() != C12431j.MULTI_AD_FORMAT_INTERSTITIAL) {
            params.put("dimension", this.f38294a.mo39880a().mo39386a(this.f38296c));
        }
        return params;
    }

    /* renamed from: c */
    private int m40222c() {
        if (this.f38294a.mo39889e() > 0) {
            return this.f38294a.mo39889e();
        }
        if (this.f38295b != null) {
            return C12278d.m40415a().mo39673b(this.f38295b.getWidth());
        }
        return 0;
    }

    /* renamed from: b */
    private int m40221b() {
        if (this.f38294a.mo39888d() > 0) {
            return this.f38294a.mo39888d();
        }
        if (this.f38295b != null) {
            return C12278d.m40415a().mo39673b(this.f38295b.getHeight());
        }
        return 0;
    }
}
