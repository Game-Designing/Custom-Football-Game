package com.fyber.inneractive.sdk.p166g;

import com.fyber.inneractive.sdk.p166g.p168b.C7799e;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* renamed from: com.fyber.inneractive.sdk.g.b */
public final class C7792b {

    /* renamed from: a */
    C7799e f15677a;

    /* renamed from: b */
    public ScheduledThreadPoolExecutor f15678b;

    /* renamed from: c */
    public Runnable f15679c;

    /* renamed from: d */
    int f15680d;

    /* renamed from: e */
    boolean f15681e = false;

    public C7792b(C7799e eVar) {
        this.f15677a = eVar;
        this.f15679c = new Runnable() {
            public final void run() {
                C7792b bVar = C7792b.this;
                IAlog.m18021b("player progress monitor: run started");
                bVar.f15677a.mo24429i();
                int h = bVar.f15677a.mo24428h();
                if (!bVar.f15681e) {
                    StringBuilder sb = new StringBuilder("run: 2 seconds passed? played for ");
                    sb.append(h - bVar.f15680d);
                    sb.append(" since last play started");
                    IAlog.m18021b(sb.toString());
                    if (h - bVar.f15680d >= 2000) {
                        IAlog.m18021b("run: setting played 2 seconds flag");
                        bVar.f15681e = true;
                    }
                }
                bVar.f15677a.mo24417a(h);
            }
        };
    }
}
