package com.asf.appcoins.sdk.core.web3;

import java.util.concurrent.Callable;
import org.web3j.protocol.core.methods.request.Transaction;

/* renamed from: com.asf.appcoins.sdk.core.web3.b */
/* compiled from: lambda */
public final /* synthetic */ class C5877b implements Callable {

    /* renamed from: a */
    private final /* synthetic */ AsfWeb3jImpl f10219a;

    /* renamed from: b */
    private final /* synthetic */ Transaction f10220b;

    public /* synthetic */ C5877b(AsfWeb3jImpl asfWeb3jImpl, Transaction transaction) {
        this.f10219a = asfWeb3jImpl;
        this.f10220b = transaction;
    }

    public final Object call() {
        return this.f10219a.mo18362a(this.f10220b);
    }
}
