package com.flurry.sdk;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.flurry.sdk.zb */
public final class C7633zb extends C7502cc<C7577pc> {

    /* renamed from: f */
    private static C7633zb f15147f = null;

    protected C7633zb() {
        super(C7633zb.class.getName(), TimeUnit.MILLISECONDS, new PriorityBlockingQueue(11, new C7467Vb()));
    }

    /* renamed from: a */
    public static synchronized C7633zb m16869a() {
        C7633zb zbVar;
        synchronized (C7633zb.class) {
            if (f15147f == null) {
                f15147f = new C7633zb();
            }
            zbVar = f15147f;
        }
        return zbVar;
    }
}
