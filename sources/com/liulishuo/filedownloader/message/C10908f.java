package com.liulishuo.filedownloader.message;

import com.liulishuo.filedownloader.message.C10909g.C10910a;

/* renamed from: com.liulishuo.filedownloader.message.f */
/* compiled from: MessageSnapshotThreadPool */
class C10908f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ MessageSnapshot f33329a;

    /* renamed from: b */
    final /* synthetic */ C10910a f33330b;

    C10908f(C10910a this$1, MessageSnapshot messageSnapshot) {
        this.f33330b = this$1;
        this.f33329a = messageSnapshot;
    }

    public void run() {
        C10909g.this.f33332b.mo35707a(this.f33329a);
        this.f33330b.f33333a.remove(Integer.valueOf(this.f33329a.mo35701e()));
    }
}
