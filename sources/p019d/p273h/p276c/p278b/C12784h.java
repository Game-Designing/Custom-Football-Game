package p019d.p273h.p276c.p278b;

import com.vungle.warren.p267ui.VungleActivity;
import p019d.p273h.p275b.C12733b;
import p019d.p273h.p276c.p284h.C12919m;

/* renamed from: d.h.c.b.h */
/* compiled from: InterstitialEventsManager */
public class C12784h extends C12781f {

    /* renamed from: H */
    private static C12784h f39335H;

    /* renamed from: I */
    private String f39336I = "";

    private C12784h() {
    }

    /* renamed from: g */
    public static synchronized C12784h m41502g() {
        C12784h hVar;
        synchronized (C12784h.class) {
            if (f39335H == null) {
                f39335H = new C12784h();
                f39335H.mo41370e();
            }
            hVar = f39335H;
        }
        return hVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public boolean mo41373f(C12733b event) {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public boolean mo41374g(C12733b event) {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo41366c(C12733b currentEvent) {
        return currentEvent.mo41158c() == 2204 || currentEvent.mo41158c() == 2005 || currentEvent.mo41158c() == 3005 || currentEvent.mo41158c() == 3015;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo41347a(C12733b event) {
        return C12919m.m42012a().mo41701a(event.mo41158c() >= 3000 && event.mo41158c() < 4000 ? 3 : 2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo41363b(C12733b event) {
        if (event.mo41158c() == 2204) {
            C12919m.m42012a().mo41702b(2);
        } else if (event.mo41158c() == 3305) {
            C12919m.m42012a().mo41702b(3);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo41371e(C12733b event) {
        this.f39336I = event.mo41157b().optString(VungleActivity.PLACEMENT_EXTRA);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo41349a(int eventId) {
        return this.f39336I;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo41367d() {
        this.f39302C.add(Integer.valueOf(2001));
        this.f39302C.add(Integer.valueOf(2002));
    }
}
