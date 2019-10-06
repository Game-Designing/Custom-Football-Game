package p024io.fabric.sdk.android;

import java.util.concurrent.CountDownLatch;

/* renamed from: io.fabric.sdk.android.e */
/* compiled from: Fabric */
class C13919e implements C13925j {

    /* renamed from: a */
    final CountDownLatch f42217a = new CountDownLatch(this.f42218b);

    /* renamed from: b */
    final /* synthetic */ int f42218b;

    /* renamed from: c */
    final /* synthetic */ C13920f f42219c;

    C13919e(C13920f this$0, int i) {
        this.f42219c = this$0;
        this.f42218b = i;
    }

    /* renamed from: a */
    public void mo43333a(Object o) {
        this.f42217a.countDown();
        if (this.f42217a.getCount() == 0) {
            this.f42219c.f42231l.set(true);
            this.f42219c.f42226g.mo43333a(this.f42219c);
        }
    }

    /* renamed from: a */
    public void mo43332a(Exception exception) {
        this.f42219c.f42226g.mo43332a(exception);
    }
}
