package com.ironsource.sdk.controller;

import android.text.TextUtils;
import com.ironsource.sdk.data.C10890c;
import com.ironsource.sdk.data.C10895h;
import com.ironsource.sdk.data.DemandSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import p019d.p273h.p285d.p292f.C12981a;

/* renamed from: com.ironsource.sdk.controller.k */
/* compiled from: DemandSourceManager */
public class C10859k {

    /* renamed from: a */
    private Map<String, C10890c> f33113a = new LinkedHashMap();

    /* renamed from: b */
    private Map<String, C10890c> f33114b = new LinkedHashMap();

    /* renamed from: c */
    private Map<String, C10890c> f33115c = new LinkedHashMap();

    /* renamed from: b */
    private Map<String, C10890c> m35435b(C10895h productType) {
        if (productType.name().equalsIgnoreCase(C10895h.RewardedVideo.name())) {
            return this.f33113a;
        }
        if (productType.name().equalsIgnoreCase(C10895h.Interstitial.name())) {
            return this.f33114b;
        }
        if (productType.name().equalsIgnoreCase(C10895h.Banner.name())) {
            return this.f33115c;
        }
        return null;
    }

    /* renamed from: a */
    public Collection<C10890c> mo35439a(C10895h productType) {
        Map<String, DemandSource> productDemandMap = m35435b(productType);
        if (productDemandMap != null) {
            return productDemandMap.values();
        }
        return new ArrayList();
    }

    /* renamed from: a */
    public C10890c mo35437a(C10895h productType, String instanceId) {
        if (!TextUtils.isEmpty(instanceId)) {
            Map<String, DemandSource> productDemandMap = m35435b(productType);
            if (productDemandMap != null) {
                return (C10890c) productDemandMap.get(instanceId);
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m35434a(C10895h productType, String demandSourceId, C10890c demandSource) {
        if (!TextUtils.isEmpty(demandSourceId) && demandSource != null) {
            Map<String, DemandSource> productDemandMap = m35435b(productType);
            if (productDemandMap != null) {
                productDemandMap.put(demandSourceId, demandSource);
            }
        }
    }

    /* renamed from: a */
    public C10890c mo35438a(C10895h type, String demandSourceName, Map<String, String> demandExtParam, C12981a listener) {
        String id = demandSourceName;
        C10890c demandSource = new C10890c(id, demandSourceName, demandExtParam, listener);
        m35434a(type, id, demandSource);
        return demandSource;
    }
}
