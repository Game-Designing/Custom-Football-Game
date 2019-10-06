package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import com.google.android.gms.internal.base.zam;
import java.util.concurrent.ExecutorService;

public final class zabh {

    /* renamed from: a */
    private static final ExecutorService f19854a = zam.m31711a().mo32450a(2, new NumberedThreadFactory("GAC_Executor"), 9);

    /* renamed from: a */
    public static ExecutorService m21543a() {
        return f19854a;
    }
}
