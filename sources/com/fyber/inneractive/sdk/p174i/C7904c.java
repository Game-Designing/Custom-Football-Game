package com.fyber.inneractive.sdk.p174i;

import android.text.TextUtils;
import android.util.Log;
import com.fyber.inneractive.sdk.config.C7711i;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.p159a.C7639a;
import com.fyber.inneractive.sdk.p165f.C7729a;
import com.fyber.inneractive.sdk.p165f.C7731c;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Map;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.fyber.inneractive.sdk.i.c */
public abstract class C7904c {

    /* renamed from: a */
    protected C7907g f16016a;

    /* renamed from: b */
    String f16017b;

    /* renamed from: c */
    private C7731c f16018c;

    /* renamed from: d */
    private boolean f16019d = true;

    /* renamed from: e */
    private boolean f16020e = true;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract C7907g mo24711a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo24713a(String str, C7711i iVar) throws Exception;

    protected C7904c() {
    }

    /* renamed from: a */
    public final void mo24712a(C7731c cVar) {
        this.f16018c = cVar;
        this.f16016a = mo24711a();
    }

    /* renamed from: b */
    public final C7907g mo24714b() throws Exception {
        this.f16020e = false;
        Map<String, String> b = this.f16018c.mo24298b();
        String a = m17818a(b, C7729a.RETURNED_AD_TYPE);
        String a2 = m17818a(b, C7729a.ERROR_CODE);
        String a3 = m17818a(b, C7729a.SESSION_ID);
        String a4 = m17818a(b, C7729a.CONTENT_ID);
        String a5 = m17818a(b, C7729a.PUBLISHER_ID);
        String a6 = m17818a(b, C7729a.WIDTH);
        String a7 = m17818a(b, C7729a.HEIGHT);
        String a8 = m17818a(b, C7729a.SDK_IMPRESSION_URL);
        String a9 = m17818a(b, C7729a.SDK_CLICK_URL);
        this.f16017b = m17818a(b, C7729a.AD_UNIT_ID);
        String a10 = m17818a(b, C7729a.AD_UNIT_TYPE);
        String a11 = m17818a(b, C7729a.AD_UNIT_DISPLAY_TYPE);
        String a12 = m17818a(b, C7729a.AD_NETWORK);
        if (mo24716d()) {
            this.f16016a.f16048q = b;
        }
        C7907g gVar = this.f16016a;
        gVar.f16032a = a3;
        gVar.f16033b = a4;
        gVar.f16034c = a5;
        gVar.f16035d = a12;
        gVar.f16040i = a2;
        if (!TextUtils.isEmpty(a)) {
            this.f16016a.f16038g = Integer.valueOf(a).intValue();
        }
        if (!TextUtils.isEmpty(a6)) {
            this.f16016a.f16036e = Integer.valueOf(a6).intValue();
        }
        if (!TextUtils.isEmpty(a7)) {
            this.f16016a.f16037f = Integer.valueOf(a7).intValue();
        }
        C7907g gVar2 = this.f16016a;
        gVar2.f16042k = a8;
        gVar2.f16043l = a9;
        gVar2.f16044m = this.f16017b;
        if (a11 != null && a11.equalsIgnoreCase("native")) {
            a11 = BuildConfig.APTOIDE_THEME;
        }
        C7907g gVar3 = this.f16016a;
        gVar3.f16045n = a10;
        try {
            gVar3.f16046o = UnitDisplayType.fromValue(a11);
        } catch (IllegalArgumentException e) {
            if (this.f16019d) {
                this.f16016a.f16046o = UnitDisplayType.INTERSTITIAL;
            } else {
                throw e;
            }
        }
        String stringBuffer = this.f16018c.mo24299c().toString();
        this.f16016a.f16039h = stringBuffer;
        C7711i a13 = IAConfigManager.m16965a(this.f16017b);
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("Got unit config for unitId: ");
        sb.append(this.f16017b);
        sb.append(" from config manager");
        IAlog.m18021b(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(IAlog.m18018a((Object) this));
        sb2.append(a13);
        IAlog.m18021b(sb2.toString());
        if (a13 == null && !this.f16019d) {
            this.f16016a.f16041j = "ErrorConfigurationMismatch";
        } else if (this.f16020e) {
            mo24713a((String) null, a13);
        } else if (mo24715c()) {
            C7909k kVar = new C7909k(stringBuffer);
            if (kVar.f16050a) {
                mo24713a(kVar.f16051b, a13);
            }
        } else {
            mo24713a(stringBuffer, a13);
        }
        return this.f16016a;
    }

    /* renamed from: a */
    private String m17818a(Map<String, String> map, C7729a aVar) {
        String str = aVar.f15434s;
        String str2 = (String) map.get(str);
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append(str);
        sb.append(" extracted from response header: ");
        sb.append(str2);
        IAlog.m18019a(sb.toString());
        if (C7640a.f15157a.f15150a) {
            String str3 = "RESPONSE_HEADER ";
            StringBuilder sb2 = new StringBuilder(str3);
            sb2.append(str);
            String str4 = " : ";
            sb2.append(str4);
            sb2.append(str2);
            Log.v("IA_CI_LOG", sb2.toString());
            C7639a a = C7640a.f15157a;
            StringBuilder sb3 = new StringBuilder(str3);
            sb3.append(str);
            sb3.append(str4);
            sb3.append(str2);
            a.mo24033b(sb3.toString());
        }
        return str2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo24715c() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo24716d() {
        return false;
    }
}
