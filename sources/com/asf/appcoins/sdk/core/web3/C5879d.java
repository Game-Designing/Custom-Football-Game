package com.asf.appcoins.sdk.core.web3;

import java.util.concurrent.Callable;
import org.web3j.abi.datatypes.Address;

/* renamed from: com.asf.appcoins.sdk.core.web3.d */
/* compiled from: lambda */
public final /* synthetic */ class C5879d implements Callable {

    /* renamed from: a */
    private final /* synthetic */ AsfWeb3jImpl f10222a;

    /* renamed from: b */
    private final /* synthetic */ Address f10223b;

    public /* synthetic */ C5879d(AsfWeb3jImpl asfWeb3jImpl, Address address) {
        this.f10222a = asfWeb3jImpl;
        this.f10223b = address;
    }

    public final Object call() {
        return this.f10222a.mo18364a(this.f10223b);
    }
}
