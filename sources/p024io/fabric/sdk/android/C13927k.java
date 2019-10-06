package p024io.fabric.sdk.android;

import p024io.fabric.sdk.android.p348a.p350b.C13838F;
import p024io.fabric.sdk.android.services.concurrency.C13950k;
import p024io.fabric.sdk.android.services.concurrency.C13952m;
import p024io.fabric.sdk.android.services.concurrency.UnmetDependencyException;

/* renamed from: io.fabric.sdk.android.k */
/* compiled from: InitializationTask */
class C13927k<Result> extends C13952m<Void, Void, Result> {

    /* renamed from: p */
    final C0102l<Result> f42247p;

    public C13927k(C0102l<Result> kit) {
        this.f42247p = kit;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo43360f() {
        super.mo43360f();
        C13838F timingMetric = m44269a("onPreExecute");
        try {
            boolean result = this.f42247p.mo3314z();
            timingMetric.mo43218b();
            if (result) {
                return;
            }
        } catch (UnmetDependencyException ex) {
            throw ex;
        } catch (Exception ex2) {
            C13920f.m44245e().mo43325b("Fabric", "Failure onPreExecute()", ex2);
            timingMetric.mo43218b();
            if (0 != 0) {
                return;
            }
        } catch (Throwable th) {
            timingMetric.mo43218b();
            if (0 == 0) {
                mo43374b(true);
            }
            throw th;
        }
        mo43374b(true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Result mo43356a(Void... voids) {
        C13838F timingMetric = m44269a("doInBackground");
        Result result = null;
        if (!mo43376e()) {
            result = this.f42247p.mo2534g();
        }
        timingMetric.mo43218b();
        return result;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo43359c(Result result) {
        this.f42247p.mo3304b(result);
        this.f42247p.f146d.mo43333a(result);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo43358b(Result result) {
        this.f42247p.mo3303a(result);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f42247p.mo2535u());
        sb.append(" Initialization was cancelled");
        this.f42247p.f146d.mo43332a((Exception) new InitializationException(sb.toString()));
    }

    public C13950k getPriority() {
        return C13950k.HIGH;
    }

    /* renamed from: a */
    private C13838F m44269a(String event) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f42247p.mo2535u());
        sb.append(".");
        sb.append(event);
        C13838F timingMetric = new C13838F(sb.toString(), "KitInitialization");
        timingMetric.mo43217a();
        return timingMetric;
    }
}
