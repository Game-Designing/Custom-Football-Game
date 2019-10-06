package p026rx.p400f;

import p026rx.exceptions.C14927a;

/* renamed from: rx.f.b */
/* compiled from: RxJavaErrorHandler */
public abstract class C14931b {
    @Deprecated
    /* renamed from: a */
    public void mo46139a(Throwable e) {
    }

    /* renamed from: a */
    public final String mo46138a(Object item) {
        try {
            return mo46140b(item);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            StringBuilder sb = new StringBuilder();
            sb.append(item.getClass().getName());
            sb.append(".errorRendering");
            return sb.toString();
        } catch (Throwable t) {
            C14927a.m46678c(t);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(item.getClass().getName());
            sb2.append(".errorRendering");
            return sb2.toString();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo46140b(Object item) throws InterruptedException {
        return null;
    }
}
