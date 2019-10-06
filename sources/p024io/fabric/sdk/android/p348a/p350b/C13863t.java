package p024io.fabric.sdk.android.p348a.p350b;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;

/* renamed from: io.fabric.sdk.android.a.b.t */
/* compiled from: ExecutorUtils */
class C13863t extends C13850j {

    /* renamed from: a */
    final /* synthetic */ String f42062a;

    /* renamed from: b */
    final /* synthetic */ ExecutorService f42063b;

    /* renamed from: c */
    final /* synthetic */ long f42064c;

    /* renamed from: d */
    final /* synthetic */ TimeUnit f42065d;

    C13863t(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        this.f42062a = str;
        this.f42063b = executorService;
        this.f42064c = j;
        this.f42065d = timeUnit;
    }

    /* renamed from: a */
    public void mo19461a() {
        String str = "Fabric";
        try {
            C13929o e = C13920f.m44245e();
            StringBuilder sb = new StringBuilder();
            sb.append("Executing shutdown hook for ");
            sb.append(this.f42062a);
            e.mo43326c(str, sb.toString());
            this.f42063b.shutdown();
            if (!this.f42063b.awaitTermination(this.f42064c, this.f42065d)) {
                C13929o e2 = C13920f.m44245e();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f42062a);
                sb2.append(" did not shut down in the allocated time. Requesting immediate shutdown.");
                e2.mo43326c(str, sb2.toString());
                this.f42063b.shutdownNow();
            }
        } catch (InterruptedException e3) {
            C13920f.m44245e().mo43326c(str, String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{this.f42062a}));
            this.f42063b.shutdownNow();
        }
    }
}
