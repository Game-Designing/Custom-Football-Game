package com.liulishuo.filedownloader.message;

/* renamed from: com.liulishuo.filedownloader.message.d */
/* compiled from: MessageSnapshotFlow */
public class C10904d {

    /* renamed from: a */
    private volatile C10909g f33326a;

    /* renamed from: b */
    private volatile C10906b f33327b;

    /* renamed from: com.liulishuo.filedownloader.message.d$a */
    /* compiled from: MessageSnapshotFlow */
    public static final class C10905a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final C10904d f33328a = new C10904d();
    }

    /* renamed from: com.liulishuo.filedownloader.message.d$b */
    /* compiled from: MessageSnapshotFlow */
    public interface C10906b {
        /* renamed from: a */
        void mo35707a(MessageSnapshot messageSnapshot);
    }

    /* renamed from: a */
    public static C10904d m35756a() {
        return C10905a.f33328a;
    }

    /* renamed from: a */
    public void mo35706a(C10906b receiver) {
        this.f33327b = receiver;
        if (receiver == null) {
            this.f33326a = null;
        } else {
            this.f33326a = new C10909g(5, receiver);
        }
    }

    /* renamed from: a */
    public void mo35705a(MessageSnapshot snapshot) {
        if (snapshot instanceof C10901a) {
            if (this.f33327b != null) {
                this.f33327b.mo35707a(snapshot);
            }
        } else if (this.f33326a != null) {
            this.f33326a.mo35709a(snapshot);
        }
    }
}
