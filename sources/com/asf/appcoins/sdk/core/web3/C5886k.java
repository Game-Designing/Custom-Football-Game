package com.asf.appcoins.sdk.core.web3;

import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import p320f.p321a.p326c.C13212n;

/* renamed from: com.asf.appcoins.sdk.core.web3.k */
/* compiled from: lambda */
public final /* synthetic */ class C5886k implements C13212n {

    /* renamed from: a */
    public static final /* synthetic */ C5886k f10232a = new C5886k();

    private /* synthetic */ C5886k() {
    }

    public final Object apply(Object obj) {
        return Long.valueOf(((EthGetTransactionCount) obj).getTransactionCount().longValue());
    }
}
