package com.fyber.inneractive.sdk.p178k;

import android.os.Build.VERSION;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.fyber.inneractive.sdk.external.InneractiveMediationName;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig.Gender;
import com.fyber.inneractive.sdk.p160b.C7658d.C7659a;
import com.fyber.inneractive.sdk.p174i.C7903b;
import com.fyber.inneractive.sdk.util.C8016n;
import com.fyber.inneractive.sdk.util.IAlog;

/* renamed from: com.fyber.inneractive.sdk.k.c */
public class C7921c implements C7659a {
    /* renamed from: a */
    public boolean mo24091a(InneractiveAdRequest inneractiveAdRequest) {
        if (inneractiveAdRequest.getSelectedUnitConfig() == null) {
            return true ^ IAConfigManager.m16987c(inneractiveAdRequest.getSpotId());
        }
        if (inneractiveAdRequest.getSelectedUnitConfig().mo24208d() == null) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public C7920b mo24092b(InneractiveAdRequest inneractiveAdRequest) {
        C7920b a = mo24731a();
        String C = IAConfigManager.m16952C();
        String l = IAConfigManager.m16998l();
        if (l == null) {
            l = inneractiveAdRequest.getSelectedUnitConfig() == null ? null : inneractiveAdRequest.getSelectedUnitConfig().mo24204a();
        }
        a.f16127h = inneractiveAdRequest.getSpotId();
        a.f16130k = l;
        a.f16128i = C;
        a.f16123d = inneractiveAdRequest.getKeywords();
        int age = inneractiveAdRequest.getUserParams().getAge();
        if (age != -1) {
            a.f16125f = Integer.toString(age);
        } else {
            a.f16125f = "";
        }
        Gender gender = inneractiveAdRequest.getUserParams().getGender();
        if (Gender.MALE.equals(gender)) {
            a.f16124e = InneractiveMediationDefs.GENDER_MALE;
        } else if (Gender.FEMALE.equals(gender)) {
            a.f16124e = InneractiveMediationDefs.GENDER_FEMALE;
        }
        a.f16126g = inneractiveAdRequest.getUserParams().getZipCode();
        InneractiveMediationName mediationName = inneractiveAdRequest.getMediationName();
        if (mediationName != null) {
            a.f16129j = mediationName.getKey();
        }
        if ((!C8016n.m18093a()) || IAConfigManager.m16957H()) {
            a.f16131l = true;
        } else {
            a.f16131l = false;
        }
        StringBuilder sb = new StringBuilder("url creator - Including secure mode: ");
        sb.append(a.f16131l);
        IAlog.m18021b(sb.toString());
        if (C7653a.f15185a.mo24083a(C7903b.RETURNED_ADTYPE_VAST)) {
            a.f16120a = true;
            if (mo24732b()) {
                a.f16121b = true;
            }
        }
        if (C7653a.f15185a.mo24083a(C7903b.RETURNED_ADTYPE_MRAID) || C7653a.f15185a.mo24083a(C7903b.RETURNED_ADTYPE_HTML)) {
            a.f16122c = true;
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo24732b() {
        return VERSION.SDK_INT >= 19;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C7920b mo24731a() {
        return new C7920b(IAConfigManager.m17008v());
    }
}
