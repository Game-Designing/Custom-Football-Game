package com.ironsource.sdk.controller;

import java.util.ArrayList;

/* renamed from: com.ironsource.sdk.controller.c */
/* compiled from: CommandExecutor */
public class C10841c {

    /* renamed from: a */
    private C10842a f33083a = C10842a.NOT_READY;

    /* renamed from: b */
    private ArrayList f33084b = new ArrayList();

    /* renamed from: com.ironsource.sdk.controller.c$a */
    /* compiled from: CommandExecutor */
    enum C10842a {
        NOT_READY,
        READY
    }

    /* renamed from: b */
    public synchronized void mo35417b() {
        this.f33083a = C10842a.READY;
    }

    /* renamed from: a */
    public synchronized void mo35416a(Runnable runnable) {
        if (this.f33083a != C10842a.READY) {
            this.f33084b.add(runnable);
        } else {
            runnable.run();
        }
    }

    /* renamed from: a */
    public synchronized void mo35415a() {
        Object[] commands = this.f33084b.toArray();
        for (int index = 0; index < commands.length; index++) {
            ((Runnable) commands[index]).run();
            commands[index] = null;
        }
        this.f33084b.clear();
    }
}
