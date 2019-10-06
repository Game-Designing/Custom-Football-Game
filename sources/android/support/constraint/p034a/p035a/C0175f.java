package android.support.constraint.p034a.p035a;

import android.support.constraint.p034a.C0196c;
import android.support.constraint.p034a.C0203i;
import android.support.constraint.p034a.C0203i.C0204a;

/* renamed from: android.support.constraint.a.a.f */
/* compiled from: ConstraintAnchor */
public class C0175f {

    /* renamed from: a */
    private C0189p f351a = new C0189p(this);

    /* renamed from: b */
    final C0180h f352b;

    /* renamed from: c */
    final C0178c f353c;

    /* renamed from: d */
    C0175f f354d;

    /* renamed from: e */
    public int f355e = 0;

    /* renamed from: f */
    int f356f = -1;

    /* renamed from: g */
    private C0177b f357g = C0177b.NONE;

    /* renamed from: h */
    private C0176a f358h = C0176a.RELAXED;

    /* renamed from: i */
    private int f359i = 0;

    /* renamed from: j */
    C0203i f360j;

    /* renamed from: android.support.constraint.a.a.f$a */
    /* compiled from: ConstraintAnchor */
    public enum C0176a {
        RELAXED,
        STRICT
    }

    /* renamed from: android.support.constraint.a.a.f$b */
    /* compiled from: ConstraintAnchor */
    public enum C0177b {
        NONE,
        STRONG,
        WEAK
    }

    /* renamed from: android.support.constraint.a.a.f$c */
    /* compiled from: ConstraintAnchor */
    public enum C0178c {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    /* renamed from: d */
    public C0189p mo3843d() {
        return this.f351a;
    }

    public C0175f(C0180h owner, C0178c type) {
        this.f352b = owner;
        this.f353c = type;
    }

    /* renamed from: e */
    public C0203i mo3844e() {
        return this.f360j;
    }

    /* renamed from: a */
    public void mo3837a(C0196c cache) {
        C0203i iVar = this.f360j;
        if (iVar == null) {
            this.f360j = new C0203i(C0204a.UNRESTRICTED, null);
        } else {
            iVar.mo4036b();
        }
    }

    /* renamed from: c */
    public C0180h mo3842c() {
        return this.f352b;
    }

    /* renamed from: h */
    public C0178c mo3847h() {
        return this.f353c;
    }

    /* renamed from: b */
    public int mo3841b() {
        if (this.f352b.mo3918r() == 8) {
            return 0;
        }
        if (this.f356f > -1) {
            C0175f fVar = this.f354d;
            if (fVar != null && fVar.f352b.mo3918r() == 8) {
                return this.f356f;
            }
        }
        return this.f355e;
    }

    /* renamed from: f */
    public C0177b mo3845f() {
        return this.f357g;
    }

    /* renamed from: g */
    public C0175f mo3846g() {
        return this.f354d;
    }

    /* renamed from: a */
    public int mo3836a() {
        return this.f359i;
    }

    /* renamed from: j */
    public void mo3849j() {
        this.f354d = null;
        this.f355e = 0;
        this.f356f = -1;
        this.f357g = C0177b.STRONG;
        this.f359i = 0;
        this.f358h = C0176a.RELAXED;
        this.f351a.mo3965d();
    }

    /* renamed from: a */
    public boolean mo3840a(C0175f toAnchor, int margin, C0177b strength, int creator) {
        return mo3839a(toAnchor, margin, -1, strength, creator, false);
    }

    /* renamed from: a */
    public boolean mo3839a(C0175f toAnchor, int margin, int goneMargin, C0177b strength, int creator, boolean forceConnection) {
        if (toAnchor == null) {
            this.f354d = null;
            this.f355e = 0;
            this.f356f = -1;
            this.f357g = C0177b.NONE;
            this.f359i = 2;
            return true;
        } else if (!forceConnection && !mo3838a(toAnchor)) {
            return false;
        } else {
            this.f354d = toAnchor;
            if (margin > 0) {
                this.f355e = margin;
            } else {
                this.f355e = 0;
            }
            this.f356f = goneMargin;
            this.f357g = strength;
            this.f359i = creator;
            return true;
        }
    }

    /* renamed from: i */
    public boolean mo3848i() {
        return this.f354d != null;
    }

    /* renamed from: a */
    public boolean mo3838a(C0175f anchor) {
        boolean z = false;
        if (anchor == null) {
            return false;
        }
        C0178c target = anchor.mo3847h();
        C0178c cVar = this.f353c;
        if (target != cVar) {
            switch (C0174e.f350a[cVar.ordinal()]) {
                case 1:
                    if (!(target == C0178c.BASELINE || target == C0178c.CENTER_X || target == C0178c.CENTER_Y)) {
                        z = true;
                    }
                    return z;
                case 2:
                case 3:
                    boolean isCompatible = target == C0178c.LEFT || target == C0178c.RIGHT;
                    if (anchor.mo3842c() instanceof C0185l) {
                        if (isCompatible || target == C0178c.CENTER_X) {
                            z = true;
                        }
                        isCompatible = z;
                    }
                    return isCompatible;
                case 4:
                case 5:
                    boolean isCompatible2 = target == C0178c.TOP || target == C0178c.BOTTOM;
                    if (anchor.mo3842c() instanceof C0185l) {
                        if (isCompatible2 || target == C0178c.CENTER_Y) {
                            z = true;
                        }
                        isCompatible2 = z;
                    }
                    return isCompatible2;
                case 6:
                case 7:
                case 8:
                case 9:
                    return false;
                default:
                    throw new AssertionError(this.f353c.name());
            }
        } else if (cVar != C0178c.BASELINE || (anchor.mo3842c().mo3927x() && mo3842c().mo3927x())) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f352b.mo3894f());
        sb.append(":");
        sb.append(this.f353c.toString());
        return sb.toString();
    }
}
