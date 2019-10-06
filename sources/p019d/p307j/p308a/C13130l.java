package p019d.p307j.p308a;

import p019d.p307j.p308a.p313e.C13117d;

/* renamed from: d.j.a.l */
/* compiled from: FileDownloadListener */
public abstract class C13130l {
    /* access modifiers changed from: protected */
    public abstract void completed(C13079a aVar);

    /* access modifiers changed from: protected */
    public abstract void connected(C13079a aVar, String str, boolean z, int i, int i2);

    /* access modifiers changed from: protected */
    public abstract void error(C13079a aVar, Throwable th);

    /* access modifiers changed from: protected */
    public abstract void paused(C13079a aVar, int i, int i2);

    /* access modifiers changed from: protected */
    public abstract void pending(C13079a aVar, int i, int i2);

    /* access modifiers changed from: protected */
    public abstract void progress(C13079a aVar, int i, int i2);

    /* access modifiers changed from: protected */
    public abstract void retry(C13079a aVar, Throwable th, int i, int i2);

    /* access modifiers changed from: protected */
    public abstract void warn(C13079a aVar);

    public C13130l() {
    }

    public C13130l(int priority) {
        C13117d.m42783e(this, "not handle priority any more", new Object[0]);
    }

    /* access modifiers changed from: protected */
    public boolean isInvalid() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void started(C13079a task) {
    }

    /* access modifiers changed from: protected */
    public void blockComplete(C13079a task) throws Throwable {
    }
}
