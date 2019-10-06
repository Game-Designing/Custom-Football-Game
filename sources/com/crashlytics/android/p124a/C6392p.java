package com.crashlytics.android.p124a;

import java.io.File;
import java.util.List;
import p024io.fabric.sdk.android.p348a.p351c.C13878g;
import p024io.fabric.sdk.android.services.concurrency.p354a.C13933b;
import p024io.fabric.sdk.android.services.concurrency.p354a.C13934c;
import p024io.fabric.sdk.android.services.concurrency.p354a.C13936e;

/* renamed from: com.crashlytics.android.a.p */
/* compiled from: AnswersRetryFilesSender */
class C6392p implements C13878g {

    /* renamed from: a */
    private final C6367I f11431a;

    /* renamed from: b */
    private final C6363E f11432b;

    /* renamed from: a */
    public static C6392p m12379a(C6367I filesSender) {
        return new C6392p(filesSender, new C6363E(new C13936e(new C6362D(new C13934c(1000, 8), 0.1d), new C13933b(5))));
    }

    C6392p(C6367I filesSender, C6363E retryManager) {
        this.f11431a = filesSender;
        this.f11432b = retryManager;
    }

    /* renamed from: a */
    public boolean mo19351a(List<File> files) {
        long currentNanoTime = System.nanoTime();
        if (!this.f11432b.mo19345a(currentNanoTime)) {
            return false;
        }
        if (this.f11431a.mo19351a(files)) {
            this.f11432b.mo19344a();
            return true;
        }
        this.f11432b.mo19346b(currentNanoTime);
        return false;
    }
}
