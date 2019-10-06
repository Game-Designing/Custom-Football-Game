package p019d.p307j.p308a;

/* renamed from: d.j.a.i */
/* compiled from: FileDownloadLargeFileListener */
public abstract class C13126i extends C13130l {
    /* access modifiers changed from: protected */
    public abstract void paused(C13079a aVar, long j, long j2);

    /* access modifiers changed from: protected */
    public abstract void pending(C13079a aVar, long j, long j2);

    /* access modifiers changed from: protected */
    public abstract void progress(C13079a aVar, long j, long j2);

    public C13126i() {
    }

    public C13126i(int priority) {
        super(priority);
    }

    /* access modifiers changed from: protected */
    public void pending(C13079a task, int soFarBytes, int totalBytes) {
    }

    /* access modifiers changed from: protected */
    public void connected(C13079a task, String etag, boolean isContinue, long soFarBytes, long totalBytes) {
    }

    /* access modifiers changed from: protected */
    public void connected(C13079a task, String etag, boolean isContinue, int soFarBytes, int totalBytes) {
    }

    /* access modifiers changed from: protected */
    public void progress(C13079a task, int soFarBytes, int totalBytes) {
    }

    /* access modifiers changed from: protected */
    public void retry(C13079a task, Throwable ex, int retryingTimes, long soFarBytes) {
    }

    /* access modifiers changed from: protected */
    public void retry(C13079a task, Throwable ex, int retryingTimes, int soFarBytes) {
    }

    /* access modifiers changed from: protected */
    public void paused(C13079a task, int soFarBytes, int totalBytes) {
    }
}
