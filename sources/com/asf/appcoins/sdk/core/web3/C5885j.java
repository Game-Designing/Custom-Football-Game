package com.asf.appcoins.sdk.core.web3;

import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import p320f.p321a.p326c.C13212n;

/* renamed from: com.asf.appcoins.sdk.core.web3.j */
/* compiled from: lambda */
public final /* synthetic */ class C5885j implements C13212n {

    /* renamed from: a */
    private final /* synthetic */ AsfWeb3jImpl f10230a;

    /* renamed from: b */
    private final /* synthetic */ String f10231b;

    public /* synthetic */ C5885j(AsfWeb3jImpl asfWeb3jImpl, String str) {
        this.f10230a = asfWeb3jImpl;
        this.f10231b = str;
    }

    public final Object apply(Object obj) {
        return this.f10230a.mo18361a(this.f10231b, (EthGetTransactionReceipt) obj);
    }
}
