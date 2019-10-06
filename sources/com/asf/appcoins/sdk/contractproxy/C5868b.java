package com.asf.appcoins.sdk.contractproxy;

import p320f.p321a.p326c.C13212n;

/* renamed from: com.asf.appcoins.sdk.contractproxy.b */
/* compiled from: lambda */
public final /* synthetic */ class C5868b implements C13212n {

    /* renamed from: a */
    private final /* synthetic */ ContractAddressProvider f10207a;

    /* renamed from: b */
    private final /* synthetic */ int f10208b;

    /* renamed from: c */
    private final /* synthetic */ String f10209c;

    public /* synthetic */ C5868b(ContractAddressProvider contractAddressProvider, int i, String str) {
        this.f10207a = contractAddressProvider;
        this.f10208b = i;
        this.f10209c = str;
    }

    public final Object apply(Object obj) {
        return this.f10207a.mo18332a(this.f10208b, this.f10209c, (String) obj);
    }
}
