package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.config.C7712j;
import com.fyber.inneractive.sdk.p161c.C7680r;

public class InneractiveAdRequest extends C7680r {

    /* renamed from: a */
    private String f15391a;

    /* renamed from: b */
    private InneractiveUserConfig f15392b = new InneractiveUserConfig();

    /* renamed from: c */
    private String f15393c;

    /* renamed from: d */
    private C7712j f15394d;

    public InneractiveAdRequest(String str) {
        this.f15391a = str;
    }

    public String getSpotId() {
        return this.f15391a;
    }

    public void setUserParams(InneractiveUserConfig inneractiveUserConfig) {
        this.f15392b = inneractiveUserConfig;
    }

    public void setKeywords(String str) {
        this.f15393c = str;
    }

    public InneractiveUserConfig getUserParams() {
        return this.f15392b;
    }

    public String getKeywords() {
        return this.f15393c;
    }

    public void setSelectedUnitConfig(C7712j jVar) {
        this.f15394d = jVar;
    }

    public C7712j getSelectedUnitConfig() {
        return this.f15394d;
    }
}
