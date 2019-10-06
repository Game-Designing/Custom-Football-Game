package p019d.p273h.p276c.p278b;

import com.vungle.warren.p267ui.VungleActivity;
import p019d.p273h.p275b.C12733b;
import p019d.p273h.p276c.p284h.C12919m;

/* renamed from: d.h.c.b.k */
/* compiled from: RewardedVideoEventsManager */
public class C12787k extends C12781f {

    /* renamed from: H */
    private static C12787k f39342H;

    /* renamed from: I */
    private String f39343I;

    /* renamed from: J */
    private String f39344J;

    private C12787k() {
        String str = "";
        this.f39343I = str;
        this.f39344J = str;
    }

    /* renamed from: g */
    public static synchronized C12787k m41517g() {
        C12787k kVar;
        synchronized (C12787k.class) {
            if (f39342H == null) {
                f39342H = new C12787k();
                f39342H.mo41370e();
            }
            kVar = f39342H;
        }
        return kVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public boolean mo41373f(C12733b event) {
        return event.mo41158c() == 2 || event.mo41158c() == 10;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public boolean mo41374g(C12733b event) {
        return event.mo41158c() == 5 || event.mo41158c() == 6 || event.mo41158c() == 8 || event.mo41158c() == 9 || event.mo41158c() == 19 || event.mo41158c() == 90019 || event.mo41158c() == 20 || event.mo41158c() == 305;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo41366c(C12733b currentEvent) {
        return currentEvent.mo41158c() == 6 || currentEvent.mo41158c() == 5 || currentEvent.mo41158c() == 10 || currentEvent.mo41158c() == 14 || currentEvent.mo41158c() == 305;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo41347a(C12733b event) {
        int sessionDepth = C12919m.m42012a().mo41701a(1);
        if (event.mo41158c() == 15 || (event.mo41158c() >= 300 && event.mo41158c() < 400)) {
            return C12919m.m42012a().mo41701a(0);
        }
        return sessionDepth;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo41371e(C12733b event) {
        int c = event.mo41158c();
        String str = VungleActivity.PLACEMENT_EXTRA;
        if (c == 15 || (event.mo41158c() >= 300 && event.mo41158c() < 400)) {
            this.f39344J = event.mo41157b().optString(str);
        } else {
            this.f39343I = event.mo41157b().optString(str);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo41349a(int eventId) {
        if (eventId == 15 || (eventId >= 300 && eventId < 400)) {
            return this.f39344J;
        }
        return this.f39343I;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo41363b(C12733b event) {
        if (event.mo41158c() == 6) {
            C12919m.m42012a().mo41702b(1);
            return false;
        } else if (event.mo41158c() != 305) {
            return false;
        } else {
            C12919m.m42012a().mo41702b(0);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo41367d() {
        this.f39302C.add(Integer.valueOf(3));
        this.f39302C.add(Integer.valueOf(7));
        this.f39302C.add(Integer.valueOf(119));
        this.f39302C.add(Integer.valueOf(19));
    }
}
