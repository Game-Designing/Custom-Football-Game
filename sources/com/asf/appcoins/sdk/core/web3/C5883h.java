package com.asf.appcoins.sdk.core.web3;

import org.web3j.protocol.core.methods.response.EthSendTransaction;
import p320f.p321a.p326c.C13212n;

/* renamed from: com.asf.appcoins.sdk.core.web3.h */
/* compiled from: lambda */
public final /* synthetic */ class C5883h implements C13212n {

    /* renamed from: a */
    private final /* synthetic */ AsfWeb3jImpl f10228a;

    public /* synthetic */ C5883h(AsfWeb3jImpl asfWeb3jImpl) {
        this.f10228a = asfWeb3jImpl;
    }

    public final Object apply(Object obj) {
        return this.f10228a.successOrThrow((EthSendTransaction) obj);
    }
}
