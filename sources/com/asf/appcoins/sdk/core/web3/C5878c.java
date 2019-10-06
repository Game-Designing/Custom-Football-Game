package com.asf.appcoins.sdk.core.web3;

import org.web3j.protocol.core.methods.response.EthGasPrice;
import p320f.p321a.p326c.C13212n;

/* renamed from: com.asf.appcoins.sdk.core.web3.c */
/* compiled from: lambda */
public final /* synthetic */ class C5878c implements C13212n {

    /* renamed from: a */
    public static final /* synthetic */ C5878c f10221a = new C5878c();

    private /* synthetic */ C5878c() {
    }

    public final Object apply(Object obj) {
        return Long.valueOf(((EthGasPrice) obj).getGasPrice().longValue());
    }
}
