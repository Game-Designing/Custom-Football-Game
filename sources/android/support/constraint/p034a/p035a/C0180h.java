package android.support.constraint.p034a.p035a;

import android.support.constraint.p034a.C0195b;
import android.support.constraint.p034a.C0196c;
import android.support.constraint.p034a.C0198e;
import android.support.constraint.p034a.C0200f;
import android.support.constraint.p034a.C0203i;
import android.support.constraint.p034a.p035a.C0175f.C0177b;
import android.support.constraint.p034a.p035a.C0175f.C0178c;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.ArrayList;

/* renamed from: android.support.constraint.a.a.h */
/* compiled from: ConstraintWidget */
public class C0180h {

    /* renamed from: a */
    public static float f380a = 0.5f;

    /* renamed from: A */
    C0175f f381A = new C0175f(this, C0178c.CENTER_X);

    /* renamed from: B */
    C0175f f382B = new C0175f(this, C0178c.CENTER_Y);

    /* renamed from: C */
    C0175f f383C = new C0175f(this, C0178c.CENTER);

    /* renamed from: D */
    protected C0175f[] f384D = {this.f448v, this.f450x, this.f449w, this.f451y, this.f452z, this.f383C};

    /* renamed from: E */
    protected ArrayList<C0175f> f385E = new ArrayList<>();

    /* renamed from: F */
    protected C0181a[] f386F;

    /* renamed from: G */
    C0180h f387G;

    /* renamed from: H */
    int f388H;

    /* renamed from: I */
    int f389I;

    /* renamed from: J */
    protected float f390J;

    /* renamed from: K */
    protected int f391K;

    /* renamed from: L */
    protected int f392L;

    /* renamed from: M */
    protected int f393M;

    /* renamed from: N */
    int f394N;

    /* renamed from: O */
    int f395O;

    /* renamed from: P */
    private int f396P;

    /* renamed from: Q */
    private int f397Q;

    /* renamed from: R */
    private int f398R;

    /* renamed from: S */
    private int f399S;

    /* renamed from: T */
    protected int f400T;

    /* renamed from: U */
    protected int f401U;

    /* renamed from: V */
    int f402V;

    /* renamed from: W */
    protected int f403W;

    /* renamed from: X */
    protected int f404X;

    /* renamed from: Y */
    private int f405Y;

    /* renamed from: Z */
    private int f406Z;

    /* renamed from: aa */
    float f407aa;

    /* renamed from: b */
    public int f408b = -1;

    /* renamed from: ba */
    float f409ba;

    /* renamed from: c */
    public int f410c = -1;

    /* renamed from: ca */
    private Object f411ca;

    /* renamed from: d */
    C0190q f412d;

    /* renamed from: da */
    private int f413da;

    /* renamed from: e */
    C0190q f414e;

    /* renamed from: ea */
    private int f415ea;

    /* renamed from: f */
    int f416f = 0;

    /* renamed from: fa */
    private String f417fa;

    /* renamed from: g */
    int f418g = 0;

    /* renamed from: ga */
    private String f419ga;

    /* renamed from: h */
    int[] f420h = new int[2];

    /* renamed from: ha */
    boolean f421ha;

    /* renamed from: i */
    int f422i = 0;

    /* renamed from: ia */
    boolean f423ia;

    /* renamed from: j */
    int f424j = 0;

    /* renamed from: ja */
    boolean f425ja;

    /* renamed from: k */
    float f426k = 1.0f;

    /* renamed from: ka */
    boolean f427ka;

    /* renamed from: l */
    int f428l = 0;

    /* renamed from: la */
    boolean f429la;

    /* renamed from: m */
    int f430m = 0;

    /* renamed from: ma */
    int f431ma;

    /* renamed from: n */
    float f432n = 1.0f;

    /* renamed from: na */
    int f433na;

    /* renamed from: o */
    boolean f434o;

    /* renamed from: oa */
    boolean f435oa;

    /* renamed from: p */
    boolean f436p;

    /* renamed from: pa */
    boolean f437pa;

    /* renamed from: q */
    int f438q = -1;

    /* renamed from: qa */
    float[] f439qa;

    /* renamed from: r */
    float f440r = 1.0f;

    /* renamed from: ra */
    protected C0180h[] f441ra;

    /* renamed from: s */
    C0183j f442s = null;

    /* renamed from: sa */
    protected C0180h[] f443sa;

    /* renamed from: t */
    private int[] f444t = {MoPubClientPositioning.NO_REPEAT, MoPubClientPositioning.NO_REPEAT};

    /* renamed from: ta */
    C0180h f445ta;

    /* renamed from: u */
    private float f446u = 0.0f;

    /* renamed from: ua */
    C0180h f447ua;

    /* renamed from: v */
    C0175f f448v = new C0175f(this, C0178c.LEFT);

    /* renamed from: w */
    C0175f f449w = new C0175f(this, C0178c.TOP);

    /* renamed from: x */
    C0175f f450x = new C0175f(this, C0178c.RIGHT);

    /* renamed from: y */
    C0175f f451y = new C0175f(this, C0178c.BOTTOM);

    /* renamed from: z */
    C0175f f452z = new C0175f(this, C0178c.BASELINE);

    /* renamed from: android.support.constraint.a.a.h$a */
    /* compiled from: ConstraintWidget */
    public enum C0181a {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    /* renamed from: j */
    public void mo3903j(int maxWidth) {
        this.f444t[0] = maxWidth;
    }

    /* renamed from: i */
    public void mo3901i(int maxHeight) {
        this.f444t[1] = maxHeight;
    }

    /* renamed from: C */
    public boolean mo3853C() {
        return this.f416f == 0 && this.f390J == 0.0f && this.f422i == 0 && this.f424j == 0 && this.f386F[0] == C0181a.MATCH_CONSTRAINT;
    }

    /* renamed from: B */
    public boolean mo3852B() {
        return this.f418g == 0 && this.f390J == 0.0f && this.f428l == 0 && this.f430m == 0 && this.f386F[1] == C0181a.MATCH_CONSTRAINT;
    }

    /* renamed from: D */
    public void mo3854D() {
        this.f448v.mo3849j();
        this.f449w.mo3849j();
        this.f450x.mo3849j();
        this.f451y.mo3849j();
        this.f452z.mo3849j();
        this.f381A.mo3849j();
        this.f382B.mo3849j();
        this.f383C.mo3849j();
        this.f387G = null;
        this.f446u = 0.0f;
        this.f388H = 0;
        this.f389I = 0;
        this.f390J = 0.0f;
        this.f391K = -1;
        this.f392L = 0;
        this.f393M = 0;
        this.f396P = 0;
        this.f397Q = 0;
        this.f398R = 0;
        this.f399S = 0;
        this.f400T = 0;
        this.f401U = 0;
        this.f402V = 0;
        this.f403W = 0;
        this.f404X = 0;
        this.f405Y = 0;
        this.f406Z = 0;
        float f = f380a;
        this.f407aa = f;
        this.f409ba = f;
        C0181a[] aVarArr = this.f386F;
        C0181a aVar = C0181a.FIXED;
        aVarArr[0] = aVar;
        aVarArr[1] = aVar;
        this.f411ca = null;
        this.f413da = 0;
        this.f415ea = 0;
        this.f419ga = null;
        this.f421ha = false;
        this.f423ia = false;
        this.f431ma = 0;
        this.f433na = 0;
        this.f435oa = false;
        this.f437pa = false;
        float[] fArr = this.f439qa;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f408b = -1;
        this.f410c = -1;
        int[] iArr = this.f444t;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f416f = 0;
        this.f418g = 0;
        this.f426k = 1.0f;
        this.f432n = 1.0f;
        this.f424j = MoPubClientPositioning.NO_REPEAT;
        this.f430m = MoPubClientPositioning.NO_REPEAT;
        this.f422i = 0;
        this.f428l = 0;
        this.f438q = -1;
        this.f440r = 1.0f;
        C0190q qVar = this.f412d;
        if (qVar != null) {
            qVar.mo3965d();
        }
        C0190q qVar2 = this.f414e;
        if (qVar2 != null) {
            qVar2.mo3965d();
        }
        this.f442s = null;
        this.f425ja = false;
        this.f427ka = false;
        this.f429la = false;
    }

    /* renamed from: F */
    public void mo3828F() {
        for (int i = 0; i < 6; i++) {
            this.f384D[i].mo3843d().mo3965d();
        }
    }

    /* renamed from: I */
    public void mo3857I() {
        for (int i = 0; i < 6; i++) {
            this.f384D[i].mo3843d().mo3968g();
        }
    }

    /* renamed from: a */
    public void mo3830a(int optimizationLevel) {
        C0187n.m1080a(optimizationLevel, this);
    }

    /* renamed from: G */
    public void mo3829G() {
    }

    /* renamed from: y */
    public boolean mo3928y() {
        if (this.f448v.mo3843d().f519b == 1 && this.f450x.mo3843d().f519b == 1 && this.f449w.mo3843d().f519b == 1 && this.f451y.mo3843d().f519b == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: m */
    public C0190q mo3908m() {
        if (this.f412d == null) {
            this.f412d = new C0190q();
        }
        return this.f412d;
    }

    /* renamed from: l */
    public C0190q mo3906l() {
        if (this.f414e == null) {
            this.f414e = new C0190q();
        }
        return this.f414e;
    }

    public C0180h() {
        C0181a aVar = C0181a.FIXED;
        this.f386F = new C0181a[]{aVar, aVar};
        this.f387G = null;
        this.f388H = 0;
        this.f389I = 0;
        this.f390J = 0.0f;
        this.f391K = -1;
        this.f392L = 0;
        this.f393M = 0;
        this.f394N = 0;
        this.f395O = 0;
        this.f396P = 0;
        this.f397Q = 0;
        this.f398R = 0;
        this.f399S = 0;
        this.f400T = 0;
        this.f401U = 0;
        this.f402V = 0;
        float f = f380a;
        this.f407aa = f;
        this.f409ba = f;
        this.f413da = 0;
        this.f415ea = 0;
        this.f417fa = null;
        this.f419ga = null;
        this.f425ja = false;
        this.f427ka = false;
        this.f429la = false;
        this.f431ma = 0;
        this.f433na = 0;
        this.f439qa = new float[]{-1.0f, -1.0f};
        this.f441ra = new C0180h[]{null, null};
        this.f443sa = new C0180h[]{null, null};
        this.f445ta = null;
        this.f447ua = null;
        mo3951J();
    }

    /* renamed from: a */
    public void mo3868a(C0196c cache) {
        this.f448v.mo3837a(cache);
        this.f449w.mo3837a(cache);
        this.f450x.mo3837a(cache);
        this.f451y.mo3837a(cache);
        this.f452z.mo3837a(cache);
        this.f383C.mo3837a(cache);
        this.f381A.mo3837a(cache);
        this.f382B.mo3837a(cache);
    }

    /* renamed from: J */
    private void mo3951J() {
        this.f385E.add(this.f448v);
        this.f385E.add(this.f449w);
        this.f385E.add(this.f450x);
        this.f385E.add(this.f451y);
        this.f385E.add(this.f381A);
        this.f385E.add(this.f382B);
        this.f385E.add(this.f383C);
        this.f385E.add(this.f452z);
    }

    /* renamed from: k */
    public C0180h mo3904k() {
        return this.f387G;
    }

    /* renamed from: a */
    public void mo3866a(C0180h widget) {
        this.f387G = widget;
    }

    /* renamed from: b */
    public void mo3881b(boolean widthWrapContent) {
        this.f434o = widthWrapContent;
    }

    /* renamed from: a */
    public void mo3871a(boolean heightWrapContent) {
        this.f436p = heightWrapContent;
    }

    /* renamed from: a */
    public void mo3867a(C0180h target, float angle, int radius) {
        C0178c cVar = C0178c.CENTER;
        mo3864a(cVar, target, cVar, radius, 0);
        this.f446u = angle;
    }

    /* renamed from: n */
    public void mo3911n(int visibility) {
        this.f415ea = visibility;
    }

    /* renamed from: r */
    public int mo3918r() {
        return this.f415ea;
    }

    /* renamed from: f */
    public String mo3894f() {
        return this.f417fa;
    }

    /* renamed from: a */
    public void mo3870a(String name) {
        this.f417fa = name;
    }

    /* renamed from: b */
    public void mo3879b(C0198e system) {
        C0203i a = system.mo4013a((Object) this.f448v);
        C0203i a2 = system.mo4013a((Object) this.f449w);
        C0203i a3 = system.mo4013a((Object) this.f450x);
        C0203i a4 = system.mo4013a((Object) this.f451y);
        if (this.f402V > 0) {
            system.mo4013a((Object) this.f452z);
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = " ";
        String str3 = "";
        if (this.f419ga != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("type: ");
            sb2.append(this.f419ga);
            sb2.append(str2);
            str = sb2.toString();
        } else {
            str = str3;
        }
        sb.append(str);
        if (this.f417fa != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("id: ");
            sb3.append(this.f417fa);
            sb3.append(str2);
            str3 = sb3.toString();
        }
        sb.append(str3);
        sb.append("(");
        sb.append(this.f392L);
        sb.append(", ");
        sb.append(this.f393M);
        sb.append(") - (");
        sb.append(this.f388H);
        String str4 = " x ";
        sb.append(str4);
        sb.append(this.f389I);
        sb.append(") wrap: (");
        sb.append(this.f405Y);
        sb.append(str4);
        sb.append(this.f406Z);
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: v */
    public int mo3925v() {
        return this.f392L;
    }

    /* renamed from: w */
    public int mo3926w() {
        return this.f393M;
    }

    /* renamed from: s */
    public int mo3920s() {
        if (this.f415ea == 8) {
            return 0;
        }
        return this.f388H;
    }

    /* renamed from: u */
    public int mo3924u() {
        return this.f405Y;
    }

    /* renamed from: i */
    public int mo3900i() {
        if (this.f415ea == 8) {
            return 0;
        }
        return this.f389I;
    }

    /* renamed from: t */
    public int mo3922t() {
        return this.f406Z;
    }

    /* renamed from: d */
    public int mo3888d(int orientation) {
        if (orientation == 0) {
            return mo3920s();
        }
        if (orientation == 1) {
            return mo3900i();
        }
        return 0;
    }

    /* renamed from: g */
    public int mo3896g() {
        return this.f396P + this.f400T;
    }

    /* renamed from: h */
    public int mo3898h() {
        return this.f397Q + this.f401U;
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public int mo3912o() {
        return this.f392L + this.f400T;
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public int mo3914p() {
        return this.f393M + this.f401U;
    }

    /* renamed from: n */
    public int mo3910n() {
        return mo3925v() + this.f388H;
    }

    /* renamed from: d */
    public int mo3887d() {
        return mo3926w() + this.f389I;
    }

    /* renamed from: b */
    public float mo3873b(int orientation) {
        if (orientation == 0) {
            return this.f407aa;
        }
        if (orientation == 1) {
            return this.f409ba;
        }
        return -1.0f;
    }

    /* renamed from: x */
    public boolean mo3927x() {
        return this.f402V > 0;
    }

    /* renamed from: c */
    public int mo3882c() {
        return this.f402V;
    }

    /* renamed from: e */
    public Object mo3892e() {
        return this.f411ca;
    }

    /* renamed from: b */
    public ArrayList<C0175f> mo3874b() {
        return this.f385E;
    }

    /* renamed from: r */
    public void mo3919r(int x) {
        this.f392L = x;
    }

    /* renamed from: s */
    public void mo3921s(int y) {
        this.f393M = y;
    }

    /* renamed from: c */
    public void mo3885c(int x, int y) {
        this.f392L = x;
        this.f393M = y;
    }

    /* renamed from: b */
    public void mo3876b(int x, int y) {
        this.f400T = x;
        this.f401U = y;
    }

    /* renamed from: H */
    public void mo3856H() {
        int left = this.f392L;
        int top = this.f393M;
        int right = this.f392L + this.f388H;
        int bottom = this.f393M + this.f389I;
        this.f396P = left;
        this.f397Q = top;
        this.f398R = right - left;
        this.f399S = bottom - top;
    }

    /* renamed from: o */
    public void mo3913o(int w) {
        this.f388H = w;
        int i = this.f388H;
        int i2 = this.f403W;
        if (i < i2) {
            this.f388H = i2;
        }
    }

    /* renamed from: g */
    public void mo3897g(int h) {
        this.f389I = h;
        int i = this.f389I;
        int i2 = this.f404X;
        if (i < i2) {
            this.f389I = i2;
        }
    }

    /* renamed from: a */
    public void mo3862a(int horizontalMatchStyle, int min, int max, float percent) {
        this.f416f = horizontalMatchStyle;
        this.f422i = min;
        this.f424j = max;
        this.f426k = percent;
        if (percent < 1.0f && this.f416f == 0) {
            this.f416f = 2;
        }
    }

    /* renamed from: b */
    public void mo3877b(int verticalMatchStyle, int min, int max, float percent) {
        this.f418g = verticalMatchStyle;
        this.f428l = min;
        this.f430m = max;
        this.f432n = percent;
        if (percent < 1.0f && this.f418g == 0) {
            this.f418g = 2;
        }
    }

    /* renamed from: b */
    public void mo3880b(String ratio) {
        int commaIndex;
        if (ratio == null || ratio.length() == 0) {
            this.f390J = 0.0f;
            return;
        }
        int dimensionRatioSide = -1;
        float dimensionRatio = 0.0f;
        int len = ratio.length();
        int commaIndex2 = ratio.indexOf(44);
        if (commaIndex2 <= 0 || commaIndex2 >= len - 1) {
            commaIndex = 0;
        } else {
            String dimension = ratio.substring(0, commaIndex2);
            if (dimension.equalsIgnoreCase("W")) {
                dimensionRatioSide = 0;
            } else if (dimension.equalsIgnoreCase("H")) {
                dimensionRatioSide = 1;
            }
            commaIndex = commaIndex2 + 1;
        }
        int colonIndex = ratio.indexOf(58);
        if (colonIndex < 0 || colonIndex >= len - 1) {
            String r = ratio.substring(commaIndex);
            if (r.length() > 0) {
                try {
                    dimensionRatio = Float.parseFloat(r);
                } catch (NumberFormatException e) {
                }
            }
        } else {
            String nominator = ratio.substring(commaIndex, colonIndex);
            String denominator = ratio.substring(colonIndex + 1);
            if (nominator.length() > 0 && denominator.length() > 0) {
                try {
                    float nominatorValue = Float.parseFloat(nominator);
                    float denominatorValue = Float.parseFloat(denominator);
                    if (nominatorValue > 0.0f && denominatorValue > 0.0f) {
                        dimensionRatio = dimensionRatioSide == 1 ? Math.abs(denominatorValue / nominatorValue) : Math.abs(nominatorValue / denominatorValue);
                    }
                } catch (NumberFormatException e2) {
                }
            }
        }
        if (dimensionRatio > 0.0f) {
            this.f390J = dimensionRatio;
            this.f391K = dimensionRatioSide;
        }
    }

    /* renamed from: a */
    public void mo3859a(float horizontalBiasPercent) {
        this.f407aa = horizontalBiasPercent;
    }

    /* renamed from: c */
    public void mo3884c(float verticalBiasPercent) {
        this.f409ba = verticalBiasPercent;
    }

    /* renamed from: l */
    public void mo3907l(int w) {
        if (w < 0) {
            this.f403W = 0;
        } else {
            this.f403W = w;
        }
    }

    /* renamed from: k */
    public void mo3905k(int h) {
        if (h < 0) {
            this.f404X = 0;
        } else {
            this.f404X = h;
        }
    }

    /* renamed from: q */
    public void mo3917q(int w) {
        this.f405Y = w;
    }

    /* renamed from: p */
    public void mo3915p(int h) {
        this.f406Z = h;
    }

    /* renamed from: a */
    public void mo3863a(int left, int top, int right, int bottom) {
        int w = right - left;
        int h = bottom - top;
        this.f392L = left;
        this.f393M = top;
        if (this.f415ea == 8) {
            this.f388H = 0;
            this.f389I = 0;
            return;
        }
        if (this.f386F[0] == C0181a.FIXED && w < this.f388H) {
            w = this.f388H;
        }
        if (this.f386F[1] == C0181a.FIXED && h < this.f389I) {
            h = this.f389I;
        }
        this.f388H = w;
        this.f389I = h;
        int i = this.f389I;
        int i2 = this.f404X;
        if (i < i2) {
            this.f389I = i2;
        }
        int i3 = this.f388H;
        int i4 = this.f403W;
        if (i3 < i4) {
            this.f388H = i4;
        }
        this.f427ka = true;
    }

    /* renamed from: a */
    public void mo3861a(int start, int end, int orientation) {
        if (orientation == 0) {
            mo3860a(start, end);
        } else if (orientation == 1) {
            mo3893e(start, end);
        }
        this.f427ka = true;
    }

    /* renamed from: a */
    public void mo3860a(int left, int right) {
        this.f392L = left;
        this.f388H = right - left;
        int i = this.f388H;
        int i2 = this.f403W;
        if (i < i2) {
            this.f388H = i2;
        }
    }

    /* renamed from: e */
    public void mo3893e(int top, int bottom) {
        this.f393M = top;
        this.f389I = bottom - top;
        int i = this.f389I;
        int i2 = this.f404X;
        if (i < i2) {
            this.f389I = i2;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public int mo3891e(int orientation) {
        if (orientation == 0) {
            return this.f394N;
        }
        if (orientation == 1) {
            return this.f395O;
        }
        return 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo3890d(int offset, int orientation) {
        if (orientation == 0) {
            this.f394N = offset;
        } else if (orientation == 1) {
            this.f395O = offset;
        }
    }

    /* renamed from: f */
    public void mo3895f(int baseline) {
        this.f402V = baseline;
    }

    /* renamed from: a */
    public void mo3869a(Object companion) {
        this.f411ca = companion;
    }

    /* renamed from: b */
    public void mo3875b(float horizontalWeight) {
        this.f439qa[0] = horizontalWeight;
    }

    /* renamed from: d */
    public void mo3889d(float verticalWeight) {
        this.f439qa[1] = verticalWeight;
    }

    /* renamed from: h */
    public void mo3899h(int horizontalChainStyle) {
        this.f431ma = horizontalChainStyle;
    }

    /* renamed from: m */
    public void mo3909m(int verticalChainStyle) {
        this.f433na = verticalChainStyle;
    }

    /* renamed from: a */
    public boolean mo3832a() {
        return this.f415ea != 8;
    }

    /* renamed from: a */
    public void mo3864a(C0178c startType, C0180h target, C0178c endType, int margin, int goneMargin) {
        C0175f startAnchor = mo3858a(startType);
        startAnchor.mo3839a(target.mo3858a(endType), margin, goneMargin, C0177b.STRONG, 0, true);
    }

    /* renamed from: E */
    public void mo3855E() {
        C0180h parent = mo3904k();
        if (parent == null || !(parent instanceof C0182i) || !((C0182i) mo3904k()).mo3932N()) {
            int mAnchorsSize = this.f385E.size();
            for (int i = 0; i < mAnchorsSize; i++) {
                ((C0175f) this.f385E.get(i)).mo3849j();
            }
        }
    }

    /* renamed from: a */
    public C0175f mo3858a(C0178c anchorType) {
        switch (C0179g.f378a[anchorType.ordinal()]) {
            case 1:
                return this.f448v;
            case 2:
                return this.f449w;
            case 3:
                return this.f450x;
            case 4:
                return this.f451y;
            case 5:
                return this.f452z;
            case 6:
                return this.f383C;
            case 7:
                return this.f381A;
            case 8:
                return this.f382B;
            case 9:
                return null;
            default:
                throw new AssertionError(anchorType.name());
        }
    }

    /* renamed from: j */
    public C0181a mo3902j() {
        return this.f386F[0];
    }

    /* renamed from: q */
    public C0181a mo3916q() {
        return this.f386F[1];
    }

    /* renamed from: c */
    public C0181a mo3883c(int orientation) {
        if (orientation == 0) {
            return mo3902j();
        }
        if (orientation == 1) {
            return mo3916q();
        }
        return null;
    }

    /* renamed from: a */
    public void mo3865a(C0181a behaviour) {
        this.f386F[0] = behaviour;
        if (behaviour == C0181a.WRAP_CONTENT) {
            mo3913o(this.f405Y);
        }
    }

    /* renamed from: b */
    public void mo3878b(C0181a behaviour) {
        this.f386F[1] = behaviour;
        if (behaviour == C0181a.WRAP_CONTENT) {
            mo3897g(this.f406Z);
        }
    }

    /* renamed from: z */
    public boolean mo3929z() {
        C0175f fVar = this.f448v;
        C0175f fVar2 = fVar.f354d;
        if (fVar2 == null || fVar2.f354d != fVar) {
            C0175f fVar3 = this.f450x;
            C0175f fVar4 = fVar3.f354d;
            if (fVar4 == null || fVar4.f354d != fVar3) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: A */
    public boolean mo3851A() {
        C0175f fVar = this.f449w;
        C0175f fVar2 = fVar.f354d;
        if (fVar2 == null || fVar2.f354d != fVar) {
            C0175f fVar3 = this.f451y;
            C0175f fVar4 = fVar3.f354d;
            if (fVar4 == null || fVar4.f354d != fVar3) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: t */
    private boolean mo3834t(int orientation) {
        int offset = orientation * 2;
        C0175f[] fVarArr = this.f384D;
        return (fVarArr[offset].f354d == null || fVarArr[offset].f354d.f354d == fVarArr[offset] || fVarArr[offset + 1].f354d == null || fVarArr[offset + 1].f354d.f354d != fVarArr[offset + 1]) ? false : true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01c5, code lost:
        if (r0 == -1) goto L_0x01c9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0270 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02ce  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02e9  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02f2  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x035b  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01c0  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3831a(android.support.constraint.p034a.C0198e r53) {
        /*
            r52 = this;
            r15 = r52
            r10 = r53
            android.support.constraint.a.a.f r0 = r15.f448v
            android.support.constraint.a.i r36 = r10.mo4013a(r0)
            android.support.constraint.a.a.f r0 = r15.f450x
            android.support.constraint.a.i r2 = r10.mo4013a(r0)
            android.support.constraint.a.a.f r0 = r15.f449w
            android.support.constraint.a.i r1 = r10.mo4013a(r0)
            android.support.constraint.a.a.f r0 = r15.f451y
            android.support.constraint.a.i r0 = r10.mo4013a(r0)
            android.support.constraint.a.a.f r3 = r15.f452z
            android.support.constraint.a.i r13 = r10.mo4013a(r3)
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.support.constraint.a.a.h r7 = r15.f387G
            r8 = 8
            r12 = 0
            r11 = 1
            if (r7 == 0) goto L_0x00b7
            if (r7 == 0) goto L_0x003a
            android.support.constraint.a.a.h$a[] r7 = r7.f386F
            r7 = r7[r12]
            android.support.constraint.a.a.h$a r9 = android.support.constraint.p034a.p035a.C0180h.C0181a.WRAP_CONTENT
            if (r7 != r9) goto L_0x003a
            r7 = 1
            goto L_0x003b
        L_0x003a:
            r7 = 0
        L_0x003b:
            r5 = r7
            android.support.constraint.a.a.h r7 = r15.f387G
            if (r7 == 0) goto L_0x004a
            android.support.constraint.a.a.h$a[] r7 = r7.f386F
            r7 = r7[r11]
            android.support.constraint.a.a.h$a r9 = android.support.constraint.p034a.p035a.C0180h.C0181a.WRAP_CONTENT
            if (r7 != r9) goto L_0x004a
            r7 = 1
            goto L_0x004b
        L_0x004a:
            r7 = 0
        L_0x004b:
            r6 = r7
            boolean r7 = r15.mo3834t(r12)
            if (r7 == 0) goto L_0x005b
            android.support.constraint.a.a.h r7 = r15.f387G
            android.support.constraint.a.a.i r7 = (android.support.constraint.p034a.p035a.C0182i) r7
            r7.mo3940a(r15, r12)
            r3 = 1
            goto L_0x005f
        L_0x005b:
            boolean r3 = r52.mo3929z()
        L_0x005f:
            boolean r7 = r15.mo3834t(r11)
            if (r7 == 0) goto L_0x006e
            android.support.constraint.a.a.h r7 = r15.f387G
            android.support.constraint.a.a.i r7 = (android.support.constraint.p034a.p035a.C0182i) r7
            r7.mo3940a(r15, r11)
            r4 = 1
            goto L_0x0072
        L_0x006e:
            boolean r4 = r52.mo3851A()
        L_0x0072:
            if (r5 == 0) goto L_0x008f
            int r7 = r15.f415ea
            if (r7 == r8) goto L_0x008f
            android.support.constraint.a.a.f r7 = r15.f448v
            android.support.constraint.a.a.f r7 = r7.f354d
            if (r7 != 0) goto L_0x008f
            android.support.constraint.a.a.f r7 = r15.f450x
            android.support.constraint.a.a.f r7 = r7.f354d
            if (r7 != 0) goto L_0x008f
            android.support.constraint.a.a.h r7 = r15.f387G
            android.support.constraint.a.a.f r7 = r7.f450x
            android.support.constraint.a.i r7 = r10.mo4013a(r7)
            r10.mo4024b(r7, r2, r12, r11)
        L_0x008f:
            if (r6 == 0) goto L_0x00b0
            int r7 = r15.f415ea
            if (r7 == r8) goto L_0x00b0
            android.support.constraint.a.a.f r7 = r15.f449w
            android.support.constraint.a.a.f r7 = r7.f354d
            if (r7 != 0) goto L_0x00b0
            android.support.constraint.a.a.f r7 = r15.f451y
            android.support.constraint.a.a.f r7 = r7.f354d
            if (r7 != 0) goto L_0x00b0
            android.support.constraint.a.a.f r7 = r15.f452z
            if (r7 != 0) goto L_0x00b0
            android.support.constraint.a.a.h r7 = r15.f387G
            android.support.constraint.a.a.f r7 = r7.f451y
            android.support.constraint.a.i r7 = r10.mo4013a(r7)
            r10.mo4024b(r7, r0, r12, r11)
        L_0x00b0:
            r37 = r3
            r38 = r4
            r9 = r5
            r7 = r6
            goto L_0x00bd
        L_0x00b7:
            r37 = r3
            r38 = r4
            r9 = r5
            r7 = r6
        L_0x00bd:
            int r3 = r15.f388H
            int r4 = r15.f403W
            if (r3 >= r4) goto L_0x00c5
            int r3 = r15.f403W
        L_0x00c5:
            int r4 = r15.f389I
            int r5 = r15.f404X
            if (r4 >= r5) goto L_0x00cd
            int r4 = r15.f404X
        L_0x00cd:
            android.support.constraint.a.a.h$a[] r5 = r15.f386F
            r5 = r5[r12]
            android.support.constraint.a.a.h$a r6 = android.support.constraint.p034a.p035a.C0180h.C0181a.MATCH_CONSTRAINT
            if (r5 == r6) goto L_0x00d7
            r5 = 1
            goto L_0x00d8
        L_0x00d7:
            r5 = 0
        L_0x00d8:
            android.support.constraint.a.a.h$a[] r6 = r15.f386F
            r6 = r6[r11]
            android.support.constraint.a.a.h$a r14 = android.support.constraint.p034a.p035a.C0180h.C0181a.MATCH_CONSTRAINT
            if (r6 == r14) goto L_0x00e2
            r6 = 1
            goto L_0x00e3
        L_0x00e2:
            r6 = 0
        L_0x00e3:
            r14 = 0
            int r11 = r15.f391K
            r15.f438q = r11
            float r11 = r15.f390J
            r15.f440r = r11
            int r12 = r15.f416f
            int r8 = r15.f418g
            r19 = 0
            r20 = r2
            int r11 = (r11 > r19 ? 1 : (r11 == r19 ? 0 : -1))
            if (r11 <= 0) goto L_0x01a8
            int r11 = r15.f415ea
            r2 = 8
            if (r11 == r2) goto L_0x01a8
            r14 = 1
            android.support.constraint.a.a.h$a[] r2 = r15.f386F
            r11 = 0
            r2 = r2[r11]
            android.support.constraint.a.a.h$a r11 = android.support.constraint.p034a.p035a.C0180h.C0181a.MATCH_CONSTRAINT
            if (r2 != r11) goto L_0x010b
            if (r12 != 0) goto L_0x010b
            r12 = 3
        L_0x010b:
            android.support.constraint.a.a.h$a[] r2 = r15.f386F
            r11 = 1
            r2 = r2[r11]
            android.support.constraint.a.a.h$a r11 = android.support.constraint.p034a.p035a.C0180h.C0181a.MATCH_CONSTRAINT
            if (r2 != r11) goto L_0x0117
            if (r8 != 0) goto L_0x0117
            r8 = 3
        L_0x0117:
            android.support.constraint.a.a.h$a[] r2 = r15.f386F
            r22 = r0
            r11 = 0
            r0 = r2[r11]
            android.support.constraint.a.a.h$a r11 = android.support.constraint.p034a.p035a.C0180h.C0181a.MATCH_CONSTRAINT
            r23 = r1
            r1 = 3
            if (r0 != r11) goto L_0x0133
            r0 = 1
            r2 = r2[r0]
            if (r2 != r11) goto L_0x0133
            if (r12 != r1) goto L_0x0133
            if (r8 != r1) goto L_0x0133
            r15.mo3872a(r9, r7, r5, r6)
            goto L_0x01ac
        L_0x0133:
            android.support.constraint.a.a.h$a[] r0 = r15.f386F
            r2 = 0
            r11 = r0[r2]
            android.support.constraint.a.a.h$a r2 = android.support.constraint.p034a.p035a.C0180h.C0181a.MATCH_CONSTRAINT
            if (r11 != r2) goto L_0x0166
            if (r12 != r1) goto L_0x0166
            r1 = 0
            r15.f438q = r1
            float r1 = r15.f440r
            int r11 = r15.f389I
            float r11 = (float) r11
            float r1 = r1 * r11
            int r1 = (int) r1
            r3 = 1
            r0 = r0[r3]
            if (r0 == r2) goto L_0x015b
            r0 = 4
            r14 = 0
            r39 = r0
            r42 = r1
            r43 = r4
            r40 = r8
            r41 = r14
            goto L_0x01b6
        L_0x015b:
            r42 = r1
            r43 = r4
            r40 = r8
            r39 = r12
            r41 = r14
            goto L_0x01b6
        L_0x0166:
            android.support.constraint.a.a.h$a[] r0 = r15.f386F
            r2 = 1
            r0 = r0[r2]
            android.support.constraint.a.a.h$a r11 = android.support.constraint.p034a.p035a.C0180h.C0181a.MATCH_CONSTRAINT
            if (r0 != r11) goto L_0x01ac
            if (r8 != r1) goto L_0x01ac
            r15.f438q = r2
            int r0 = r15.f391K
            r1 = -1
            if (r0 != r1) goto L_0x017f
            r0 = 1065353216(0x3f800000, float:1.0)
            float r1 = r15.f440r
            float r0 = r0 / r1
            r15.f440r = r0
        L_0x017f:
            float r0 = r15.f440r
            int r1 = r15.f388H
            float r1 = (float) r1
            float r0 = r0 * r1
            int r0 = (int) r0
            android.support.constraint.a.a.h$a[] r1 = r15.f386F
            r2 = 0
            r1 = r1[r2]
            android.support.constraint.a.a.h$a r2 = android.support.constraint.p034a.p035a.C0180h.C0181a.MATCH_CONSTRAINT
            if (r1 == r2) goto L_0x019d
            r1 = 4
            r14 = 0
            r43 = r0
            r40 = r1
            r42 = r3
            r39 = r12
            r41 = r14
            goto L_0x01b6
        L_0x019d:
            r43 = r0
            r42 = r3
            r40 = r8
            r39 = r12
            r41 = r14
            goto L_0x01b6
        L_0x01a8:
            r22 = r0
            r23 = r1
        L_0x01ac:
            r42 = r3
            r43 = r4
            r40 = r8
            r39 = r12
            r41 = r14
        L_0x01b6:
            int[] r0 = r15.f420h
            r1 = 0
            r0[r1] = r39
            r1 = 1
            r0[r1] = r40
            if (r41 == 0) goto L_0x01cb
            int r0 = r15.f438q
            if (r0 == 0) goto L_0x01c8
            r2 = -1
            if (r0 != r2) goto L_0x01cc
            goto L_0x01c9
        L_0x01c8:
            r2 = -1
        L_0x01c9:
            r14 = 1
            goto L_0x01cd
        L_0x01cb:
            r2 = -1
        L_0x01cc:
            r14 = 0
        L_0x01cd:
            android.support.constraint.a.a.h$a[] r0 = r15.f386F
            r3 = 0
            r0 = r0[r3]
            android.support.constraint.a.a.h$a r3 = android.support.constraint.p034a.p035a.C0180h.C0181a.WRAP_CONTENT
            if (r0 != r3) goto L_0x01dc
            boolean r0 = r15 instanceof android.support.constraint.p034a.p035a.C0182i
            if (r0 == 0) goto L_0x01dc
            r0 = 1
            goto L_0x01dd
        L_0x01dc:
            r0 = 0
        L_0x01dd:
            r44 = r6
            r6 = r0
            r0 = 1
            android.support.constraint.a.a.f r3 = r15.f383C
            boolean r3 = r3.mo3848i()
            if (r3 == 0) goto L_0x01ed
            r0 = 0
            r24 = r0
            goto L_0x01ef
        L_0x01ed:
            r24 = r0
        L_0x01ef:
            int r0 = r15.f408b
            r12 = 2
            r25 = 0
            if (r0 == r12) goto L_0x0259
            android.support.constraint.a.a.h r0 = r15.f387G
            if (r0 == 0) goto L_0x0202
            android.support.constraint.a.a.f r0 = r0.f450x
            android.support.constraint.a.i r0 = r10.mo4013a(r0)
            r4 = r0
            goto L_0x0204
        L_0x0202:
            r4 = r25
        L_0x0204:
            android.support.constraint.a.a.h r0 = r15.f387G
            if (r0 == 0) goto L_0x0210
            android.support.constraint.a.a.f r0 = r0.f448v
            android.support.constraint.a.i r0 = r10.mo4013a(r0)
            r3 = r0
            goto L_0x0212
        L_0x0210:
            r3 = r25
        L_0x0212:
            android.support.constraint.a.a.h$a[] r0 = r15.f386F
            r16 = 0
            r0 = r0[r16]
            r45 = r5
            r5 = r0
            android.support.constraint.a.a.f r0 = r15.f448v
            r46 = r7
            r7 = r0
            android.support.constraint.a.a.f r8 = r15.f450x
            int r0 = r15.f392L
            r47 = r9
            r9 = r0
            int r11 = r15.f403W
            int[] r0 = r15.f444t
            r0 = r0[r16]
            r26 = 0
            r12 = r0
            float r0 = r15.f407aa
            r48 = r13
            r13 = r0
            int r0 = r15.f422i
            r17 = r0
            int r0 = r15.f424j
            r18 = r0
            float r0 = r15.f426k
            r19 = r0
            r49 = r22
            r0 = r52
            r50 = r23
            r1 = r53
            r51 = r20
            r2 = r47
            r10 = r42
            r15 = r37
            r16 = r39
            r20 = r24
            r0.m953a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            goto L_0x0269
        L_0x0259:
            r45 = r5
            r46 = r7
            r47 = r9
            r48 = r13
            r51 = r20
            r49 = r22
            r50 = r23
            r26 = 0
        L_0x0269:
            r7 = r52
            int r0 = r7.f410c
            r1 = 2
            if (r0 != r1) goto L_0x0271
            return
        L_0x0271:
            android.support.constraint.a.a.h$a[] r0 = r7.f386F
            r1 = 1
            r0 = r0[r1]
            android.support.constraint.a.a.h$a r2 = android.support.constraint.p034a.p035a.C0180h.C0181a.WRAP_CONTENT
            if (r0 != r2) goto L_0x0281
            boolean r0 = r7 instanceof android.support.constraint.p034a.p035a.C0182i
            if (r0 == 0) goto L_0x0281
            r21 = 1
            goto L_0x0283
        L_0x0281:
            r21 = 0
        L_0x0283:
            if (r41 == 0) goto L_0x028f
            int r0 = r7.f438q
            if (r0 == r1) goto L_0x028c
            r2 = -1
            if (r0 != r2) goto L_0x028f
        L_0x028c:
            r29 = 1
            goto L_0x0291
        L_0x028f:
            r29 = 0
        L_0x0291:
            int r0 = r7.f402V
            if (r0 <= 0) goto L_0x02ce
            android.support.constraint.a.a.f r0 = r7.f452z
            android.support.constraint.a.a.p r0 = r0.mo3843d()
            int r0 = r0.f519b
            if (r0 != r1) goto L_0x02af
            android.support.constraint.a.a.f r0 = r7.f452z
            android.support.constraint.a.a.p r0 = r0.mo3843d()
            r8 = r53
            r0.mo3961a(r8)
            r10 = r48
            r9 = r50
            goto L_0x02d4
        L_0x02af:
            r8 = r53
            int r0 = r52.mo3882c()
            r2 = 6
            r10 = r48
            r9 = r50
            r8.mo4010a(r10, r9, r0, r2)
            android.support.constraint.a.a.f r0 = r7.f452z
            android.support.constraint.a.a.f r0 = r0.f354d
            if (r0 == 0) goto L_0x02d4
            android.support.constraint.a.i r0 = r8.mo4013a(r0)
            r3 = 0
            r8.mo4010a(r10, r0, r3, r2)
            r2 = 0
            r11 = r2
            goto L_0x02d6
        L_0x02ce:
            r8 = r53
            r10 = r48
            r9 = r50
        L_0x02d4:
            r11 = r24
        L_0x02d6:
            android.support.constraint.a.a.h r0 = r7.f387G
            if (r0 == 0) goto L_0x02e3
            android.support.constraint.a.a.f r0 = r0.f451y
            android.support.constraint.a.i r0 = r8.mo4013a(r0)
            r19 = r0
            goto L_0x02e5
        L_0x02e3:
            r19 = r25
        L_0x02e5:
            android.support.constraint.a.a.h r0 = r7.f387G
            if (r0 == 0) goto L_0x02f2
            android.support.constraint.a.a.f r0 = r0.f449w
            android.support.constraint.a.i r0 = r8.mo4013a(r0)
            r18 = r0
            goto L_0x02f4
        L_0x02f2:
            r18 = r25
        L_0x02f4:
            android.support.constraint.a.a.h$a[] r0 = r7.f386F
            r20 = r0[r1]
            android.support.constraint.a.a.f r0 = r7.f449w
            r22 = r0
            android.support.constraint.a.a.f r0 = r7.f451y
            r23 = r0
            int r0 = r7.f393M
            r24 = r0
            int r0 = r7.f404X
            r26 = r0
            int[] r0 = r7.f444t
            r27 = r0[r1]
            float r0 = r7.f409ba
            r28 = r0
            int r0 = r7.f428l
            r32 = r0
            int r0 = r7.f430m
            r33 = r0
            float r0 = r7.f432n
            r34 = r0
            r15 = r52
            r16 = r53
            r17 = r46
            r25 = r43
            r30 = r38
            r31 = r40
            r35 = r11
            r15.m953a(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35)
            if (r41 == 0) goto L_0x0353
            r12 = 6
            int r0 = r7.f438q
            if (r0 != r1) goto L_0x0344
            float r5 = r7.f440r
            r0 = r53
            r1 = r49
            r2 = r9
            r3 = r51
            r4 = r36
            r6 = r12
            r0.mo4020a(r1, r2, r3, r4, r5, r6)
            goto L_0x0353
        L_0x0344:
            float r5 = r7.f440r
            r0 = r53
            r1 = r51
            r2 = r36
            r3 = r49
            r4 = r9
            r6 = r12
            r0.mo4020a(r1, r2, r3, r4, r5, r6)
        L_0x0353:
            android.support.constraint.a.a.f r0 = r7.f383C
            boolean r0 = r0.mo3848i()
            if (r0 == 0) goto L_0x0379
            android.support.constraint.a.a.f r0 = r7.f383C
            android.support.constraint.a.a.f r0 = r0.mo3846g()
            android.support.constraint.a.a.h r0 = r0.mo3842c()
            float r1 = r7.f446u
            r2 = 1119092736(0x42b40000, float:90.0)
            float r1 = r1 + r2
            double r1 = (double) r1
            double r1 = java.lang.Math.toRadians(r1)
            float r1 = (float) r1
            android.support.constraint.a.a.f r2 = r7.f383C
            int r2 = r2.mo3841b()
            r8.mo4014a(r7, r0, r1, r2)
        L_0x0379:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.p034a.p035a.C0180h.mo3831a(android.support.constraint.a.e):void");
    }

    /* renamed from: a */
    public void mo3872a(boolean hparentWrapContent, boolean vparentWrapContent, boolean horizontalDimensionFixed, boolean verticalDimensionFixed) {
        if (this.f438q == -1) {
            if (horizontalDimensionFixed && !verticalDimensionFixed) {
                this.f438q = 0;
            } else if (!horizontalDimensionFixed && verticalDimensionFixed) {
                this.f438q = 1;
                if (this.f391K == -1) {
                    this.f440r = 1.0f / this.f440r;
                }
            }
        }
        if (this.f438q == 0 && (!this.f449w.mo3848i() || !this.f451y.mo3848i())) {
            this.f438q = 1;
        } else if (this.f438q == 1 && (!this.f448v.mo3848i() || !this.f450x.mo3848i())) {
            this.f438q = 0;
        }
        if (this.f438q == -1 && (!this.f449w.mo3848i() || !this.f451y.mo3848i() || !this.f448v.mo3848i() || !this.f450x.mo3848i())) {
            if (this.f449w.mo3848i() && this.f451y.mo3848i()) {
                this.f438q = 0;
            } else if (this.f448v.mo3848i() && this.f450x.mo3848i()) {
                this.f440r = 1.0f / this.f440r;
                this.f438q = 1;
            }
        }
        if (this.f438q == -1) {
            if (hparentWrapContent && !vparentWrapContent) {
                this.f438q = 0;
            } else if (!hparentWrapContent && vparentWrapContent) {
                this.f440r = 1.0f / this.f440r;
                this.f438q = 1;
            }
        }
        if (this.f438q == -1) {
            if (this.f422i > 0 && this.f428l == 0) {
                this.f438q = 0;
            } else if (this.f422i == 0 && this.f428l > 0) {
                this.f440r = 1.0f / this.f440r;
                this.f438q = 1;
            }
        }
        if (this.f438q == -1 && hparentWrapContent && vparentWrapContent) {
            this.f440r = 1.0f / this.f440r;
            this.f438q = 1;
        }
    }

    /* renamed from: a */
    private void m953a(C0198e system, boolean parentWrapContent, C0203i parentMin, C0203i parentMax, C0181a dimensionBehaviour, boolean wrapContent, C0175f beginAnchor, C0175f endAnchor, int beginPosition, int dimension, int minDimension, int maxDimension, float bias, boolean useRatio, boolean inChain, int matchConstraintDefault, int matchMinDimension, int matchMaxDimension, float matchPercentDimension, boolean applyPosition) {
        int matchConstraintDefault2;
        boolean variableSize;
        boolean variableSize2;
        int dimension2;
        C0203i beginTarget;
        int matchConstraintDefault3;
        C0203i endTarget;
        int matchMaxDimension2;
        int numConnections;
        int matchMaxDimension3;
        int matchMinDimension2;
        int matchMaxDimension4;
        C0203i begin;
        C0203i iVar;
        int numConnections2;
        int matchMaxDimension5;
        int i;
        int numConnections3;
        boolean applyBoundsCheck;
        int centeringStrength;
        boolean applyCentering;
        int matchConstraintDefault4;
        C0203i beginTarget2;
        C0203i end;
        C0203i begin2;
        C0203i iVar2;
        int endStrength;
        int startStrength;
        boolean applyBoundsCheck2;
        int strength;
        int i2;
        int matchMaxDimension6;
        int dimension3;
        int matchMinDimension3;
        C0203i percentEnd;
        C0203i percentEnd2;
        int i3;
        C0198e eVar = system;
        C0203i iVar3 = parentMin;
        C0203i iVar4 = parentMax;
        C0175f fVar = endAnchor;
        int i4 = minDimension;
        int i5 = maxDimension;
        C0203i begin3 = eVar.mo4013a((Object) beginAnchor);
        C0203i end2 = eVar.mo4013a((Object) fVar);
        C0203i beginTarget3 = eVar.mo4013a((Object) beginAnchor.mo3846g());
        C0203i endTarget2 = eVar.mo4013a((Object) endAnchor.mo3846g());
        if (eVar.f547i && beginAnchor.mo3843d().f519b == 1 && endAnchor.mo3843d().f519b == 1) {
            if (C0198e.m1152e() != null) {
                C0200f e = C0198e.m1152e();
                e.f575r++;
            }
            beginAnchor.mo3843d().mo3961a(eVar);
            endAnchor.mo3843d().mo3961a(eVar);
            if (!inChain && parentWrapContent) {
                eVar.mo4024b(iVar4, end2, 0, 6);
            }
            return;
        }
        if (C0198e.m1152e() != null) {
            C0200f e2 = C0198e.m1152e();
            e2.f583z++;
        }
        boolean isBeginConnected = beginAnchor.mo3848i();
        boolean isEndConnected = endAnchor.mo3848i();
        boolean isCenterConnected = this.f383C.mo3848i();
        int numConnections4 = 0;
        if (isBeginConnected) {
            numConnections4 = 0 + 1;
        }
        if (isEndConnected) {
            numConnections4++;
        }
        if (isCenterConnected) {
            numConnections4++;
        }
        int numConnections5 = numConnections4;
        if (useRatio) {
            matchConstraintDefault2 = 3;
        } else {
            matchConstraintDefault2 = matchConstraintDefault;
        }
        int i6 = C0179g.f379b[dimensionBehaviour.ordinal()];
        int numConnections6 = numConnections5;
        if (i6 == 1) {
            variableSize = false;
        } else if (i6 == 2) {
            variableSize = false;
        } else if (i6 == 3) {
            variableSize = false;
        } else if (i6 != 4) {
            variableSize = false;
        } else if (matchConstraintDefault2 == 4) {
            variableSize = false;
        } else {
            variableSize = true;
        }
        if (this.f415ea == 8) {
            dimension2 = 0;
            variableSize2 = false;
        } else {
            dimension2 = dimension;
            variableSize2 = variableSize;
        }
        if (applyPosition) {
            if (isBeginConnected || isEndConnected || isCenterConnected) {
                int i7 = beginPosition;
                if (isBeginConnected && !isEndConnected) {
                    eVar.mo4010a(begin3, beginTarget3, beginAnchor.mo3841b(), 6);
                }
            } else {
                eVar.mo4018a(begin3, beginPosition);
            }
        }
        if (!variableSize2) {
            if (wrapContent) {
                eVar.mo4010a(end2, begin3, 0, 3);
                if (i4 > 0) {
                    i3 = 6;
                    eVar.mo4024b(end2, begin3, i4, 6);
                } else {
                    i3 = 6;
                }
                if (i5 < Integer.MAX_VALUE) {
                    eVar.mo4027c(end2, begin3, i5, i3);
                }
            } else {
                eVar.mo4010a(end2, begin3, dimension2, 6);
            }
            matchMaxDimension3 = matchMinDimension;
            matchMaxDimension2 = matchMaxDimension;
            matchMinDimension2 = dimension2;
            matchConstraintDefault3 = matchConstraintDefault2;
            endTarget = endTarget2;
            beginTarget = beginTarget3;
            numConnections = numConnections6;
        } else {
            int matchMinDimension4 = matchMinDimension;
            if (matchMinDimension4 == -2) {
                matchMinDimension4 = dimension2;
            }
            C0203i endTarget3 = endTarget2;
            int matchMaxDimension7 = matchMaxDimension;
            if (matchMaxDimension7 == -2) {
                matchMaxDimension7 = dimension2;
            }
            if (matchMinDimension4 > 0) {
                i2 = 6;
                eVar.mo4024b(end2, begin3, matchMinDimension4, 6);
                dimension2 = Math.max(dimension2, matchMinDimension4);
            } else {
                i2 = 6;
            }
            if (matchMaxDimension7 > 0) {
                eVar.mo4027c(end2, begin3, matchMaxDimension7, i2);
                dimension2 = Math.min(dimension2, matchMaxDimension7);
            }
            if (matchConstraintDefault2 == 1) {
                if (parentWrapContent) {
                    eVar.mo4010a(end2, begin3, dimension2, 6);
                    dimension3 = dimension2;
                    matchConstraintDefault3 = matchConstraintDefault2;
                    matchMinDimension3 = matchMinDimension4;
                    matchMaxDimension6 = matchMaxDimension7;
                    beginTarget = beginTarget3;
                    numConnections = numConnections6;
                    endTarget = endTarget3;
                } else if (inChain) {
                    eVar.mo4010a(end2, begin3, dimension2, 4);
                    dimension3 = dimension2;
                    matchConstraintDefault3 = matchConstraintDefault2;
                    matchMinDimension3 = matchMinDimension4;
                    matchMaxDimension6 = matchMaxDimension7;
                    beginTarget = beginTarget3;
                    numConnections = numConnections6;
                    endTarget = endTarget3;
                } else {
                    eVar.mo4010a(end2, begin3, dimension2, 1);
                    dimension3 = dimension2;
                    matchConstraintDefault3 = matchConstraintDefault2;
                    matchMinDimension3 = matchMinDimension4;
                    matchMaxDimension6 = matchMaxDimension7;
                    beginTarget = beginTarget3;
                    numConnections = numConnections6;
                    endTarget = endTarget3;
                }
            } else if (matchConstraintDefault2 == 2) {
                int dimension4 = dimension2;
                if (beginAnchor.mo3847h() == C0178c.TOP || beginAnchor.mo3847h() == C0178c.BOTTOM) {
                    percentEnd = eVar.mo4013a((Object) this.f387G.mo3858a(C0178c.TOP));
                    percentEnd2 = eVar.mo4013a((Object) this.f387G.mo3858a(C0178c.BOTTOM));
                } else {
                    percentEnd = eVar.mo4013a((Object) this.f387G.mo3858a(C0178c.LEFT));
                    percentEnd2 = eVar.mo4013a((Object) this.f387G.mo3858a(C0178c.RIGHT));
                }
                C0195b b = system.mo4023b();
                dimension3 = dimension4;
                matchConstraintDefault3 = matchConstraintDefault2;
                C0195b bVar = b;
                numConnections = numConnections6;
                matchMinDimension3 = matchMinDimension4;
                matchMaxDimension6 = matchMaxDimension7;
                endTarget = endTarget3;
                beginTarget = beginTarget3;
                b.mo3990a(end2, begin3, percentEnd2, percentEnd, matchPercentDimension);
                eVar.mo4015a(bVar);
                variableSize2 = false;
            } else {
                dimension3 = dimension2;
                matchConstraintDefault3 = matchConstraintDefault2;
                matchMinDimension3 = matchMinDimension4;
                matchMaxDimension6 = matchMaxDimension7;
                beginTarget = beginTarget3;
                numConnections = numConnections6;
                endTarget = endTarget3;
            }
            if (!variableSize2 || numConnections == 2 || useRatio) {
                matchMaxDimension2 = matchMaxDimension6;
                matchMaxDimension3 = matchMinDimension3;
                matchMinDimension2 = dimension3;
            } else {
                variableSize2 = false;
                int d = Math.max(matchMinDimension3, dimension3);
                if (matchMaxDimension6 > 0) {
                    d = Math.min(matchMaxDimension6, d);
                }
                eVar.mo4010a(end2, begin3, d, 6);
                matchMaxDimension2 = matchMaxDimension6;
                matchMaxDimension3 = matchMinDimension3;
                matchMinDimension2 = dimension3;
            }
        }
        if (!applyPosition) {
            C0175f fVar2 = beginAnchor;
            C0175f fVar3 = endAnchor;
            int i8 = matchMinDimension2;
            int i9 = matchMaxDimension3;
            numConnections2 = numConnections;
            int i10 = matchMaxDimension2;
            C0203i iVar5 = beginTarget;
            matchMaxDimension4 = 0;
            iVar = parentMin;
            begin = begin3;
        } else if (inChain) {
            C0175f fVar4 = beginAnchor;
            C0175f fVar5 = endAnchor;
            int i11 = matchMinDimension2;
            int i12 = matchMaxDimension3;
            numConnections2 = numConnections;
            int i13 = matchMaxDimension2;
            C0203i iVar6 = beginTarget;
            matchMaxDimension4 = 0;
            iVar = parentMin;
            begin = begin3;
        } else {
            if (isBeginConnected || isEndConnected || isCenterConnected) {
                if (!isBeginConnected || isEndConnected) {
                    if (isBeginConnected || !isEndConnected) {
                        C0203i iVar7 = parentMin;
                        if (!isBeginConnected || !isEndConnected) {
                            C0175f fVar6 = beginAnchor;
                            C0175f fVar7 = endAnchor;
                            int i14 = matchMinDimension2;
                            int i15 = matchMaxDimension3;
                            int i16 = numConnections;
                            int i17 = matchMaxDimension2;
                            C0203i iVar8 = beginTarget;
                            matchMaxDimension5 = 0;
                            C0203i iVar9 = iVar7;
                            C0203i iVar10 = begin3;
                            i = 6;
                        } else {
                            boolean applyCentering2 = false;
                            if (variableSize2) {
                                if (parentWrapContent && minDimension == 0) {
                                    eVar.mo4024b(end2, begin3, 0, 6);
                                }
                                matchConstraintDefault4 = matchConstraintDefault3;
                                if (matchConstraintDefault4 == 0) {
                                    if (matchMaxDimension2 > 0 || matchMaxDimension3 > 0) {
                                        applyBoundsCheck2 = true;
                                        strength = 4;
                                    } else {
                                        applyBoundsCheck2 = false;
                                        strength = 6;
                                    }
                                    int i18 = matchMinDimension2;
                                    beginTarget2 = beginTarget;
                                    eVar.mo4010a(begin3, beginTarget2, beginAnchor.mo3841b(), strength);
                                    eVar.mo4010a(end2, endTarget, -endAnchor.mo3841b(), strength);
                                    if (matchMaxDimension2 > 0 || matchMaxDimension3 > 0) {
                                        applyCentering2 = true;
                                    }
                                    int i19 = matchMaxDimension3;
                                    numConnections3 = numConnections;
                                    applyBoundsCheck = applyBoundsCheck2;
                                    applyCentering = applyCentering2;
                                    centeringStrength = 5;
                                } else {
                                    int dimension5 = matchMinDimension2;
                                    beginTarget2 = beginTarget;
                                    if (matchConstraintDefault4 == 1) {
                                        applyBoundsCheck = true;
                                        centeringStrength = 6;
                                        int i20 = matchMaxDimension3;
                                        numConnections3 = numConnections;
                                        applyCentering = true;
                                    } else if (matchConstraintDefault4 == 3) {
                                        int strength2 = 4;
                                        if (!useRatio) {
                                            int i21 = matchMaxDimension3;
                                            numConnections3 = numConnections;
                                            if (this.f438q != -1 && matchMaxDimension2 <= 0) {
                                                strength2 = 6;
                                            }
                                        } else {
                                            int matchMinDimension5 = matchMaxDimension3;
                                            numConnections3 = numConnections;
                                        }
                                        eVar.mo4010a(begin3, beginTarget2, beginAnchor.mo3841b(), strength2);
                                        eVar.mo4010a(end2, endTarget, -endAnchor.mo3841b(), strength2);
                                        applyBoundsCheck = true;
                                        applyCentering = true;
                                        centeringStrength = 5;
                                    } else {
                                        int matchMinDimension6 = matchMaxDimension3;
                                        numConnections3 = numConnections;
                                        applyBoundsCheck = false;
                                        applyCentering = false;
                                        centeringStrength = 5;
                                    }
                                }
                            } else {
                                int dimension6 = matchMinDimension2;
                                int i22 = matchMaxDimension3;
                                numConnections3 = numConnections;
                                matchConstraintDefault4 = matchConstraintDefault3;
                                beginTarget2 = beginTarget;
                                applyBoundsCheck = false;
                                applyCentering = true;
                                centeringStrength = 5;
                            }
                            int startStrength2 = 5;
                            int endStrength2 = 5;
                            boolean applyStartConstraint = parentWrapContent;
                            boolean applyEndConstraint = parentWrapContent;
                            if (applyCentering) {
                                int i23 = matchConstraintDefault4;
                                iVar2 = iVar7;
                                end = end2;
                                boolean z = applyCentering;
                                begin2 = begin3;
                                int i24 = matchMaxDimension2;
                                matchMaxDimension5 = 0;
                                system.mo4019a(begin3, beginTarget2, beginAnchor.mo3841b(), bias, endTarget, end2, endAnchor.mo3841b(), centeringStrength);
                                int i25 = numConnections3;
                                boolean isBeginAnchorBarrier = beginAnchor.f354d.f352b instanceof C0171b;
                                boolean isEndAnchorBarrier = endAnchor.f354d.f352b instanceof C0171b;
                                if (isBeginAnchorBarrier && !isEndAnchorBarrier) {
                                    endStrength2 = 6;
                                    applyEndConstraint = true;
                                } else if (!isBeginAnchorBarrier && isEndAnchorBarrier) {
                                    startStrength2 = 6;
                                    applyStartConstraint = true;
                                }
                            } else {
                                C0175f fVar8 = beginAnchor;
                                C0175f fVar9 = endAnchor;
                                int i26 = matchConstraintDefault4;
                                iVar2 = iVar7;
                                end = end2;
                                boolean z2 = applyCentering;
                                int i27 = matchMaxDimension2;
                                int i28 = numConnections3;
                                matchMaxDimension5 = 0;
                                begin2 = begin3;
                            }
                            if (applyBoundsCheck) {
                                startStrength = 6;
                                endStrength = 6;
                            } else {
                                startStrength = startStrength2;
                                endStrength = endStrength2;
                            }
                            if ((!variableSize2 && applyStartConstraint) || applyBoundsCheck) {
                                eVar.mo4024b(begin2, beginTarget2, beginAnchor.mo3841b(), startStrength);
                            }
                            if ((variableSize2 || !applyEndConstraint) && !applyBoundsCheck) {
                                end2 = end;
                            } else {
                                end2 = end;
                                eVar.mo4027c(end2, endTarget, -endAnchor.mo3841b(), endStrength);
                            }
                            if (parentWrapContent) {
                                i = 6;
                                eVar.mo4024b(begin2, iVar2, matchMaxDimension5, 6);
                            } else {
                                i = 6;
                            }
                        }
                    } else {
                        eVar.mo4010a(end2, endTarget, -endAnchor.mo3841b(), 6);
                        if (parentWrapContent) {
                            C0203i iVar11 = parentMin;
                            eVar.mo4024b(begin3, iVar11, 0, 5);
                            C0175f fVar10 = beginAnchor;
                            C0175f fVar11 = endAnchor;
                            int i29 = matchMinDimension2;
                            int i30 = matchMaxDimension3;
                            int i31 = numConnections;
                            int i32 = matchMaxDimension2;
                            C0203i iVar12 = beginTarget;
                            matchMaxDimension5 = 0;
                            C0203i iVar13 = iVar11;
                            C0203i iVar14 = begin3;
                            i = 6;
                        } else {
                            C0175f fVar12 = beginAnchor;
                            C0175f fVar13 = endAnchor;
                            int i33 = matchMinDimension2;
                            int i34 = matchMaxDimension3;
                            int i35 = numConnections;
                            int i36 = matchMaxDimension2;
                            C0203i iVar15 = beginTarget;
                            matchMaxDimension5 = 0;
                            C0203i iVar16 = parentMin;
                            C0203i iVar17 = begin3;
                            i = 6;
                        }
                    }
                } else if (parentWrapContent) {
                    eVar.mo4024b(iVar4, end2, 0, 5);
                    C0175f fVar14 = beginAnchor;
                    C0175f fVar15 = endAnchor;
                    int i37 = matchMinDimension2;
                    int i38 = matchMaxDimension3;
                    int i39 = numConnections;
                    int i40 = matchMaxDimension2;
                    C0203i iVar18 = beginTarget;
                    i = 6;
                    matchMaxDimension5 = 0;
                    C0203i iVar19 = parentMin;
                    C0203i iVar20 = begin3;
                } else {
                    C0175f fVar16 = beginAnchor;
                    C0175f fVar17 = endAnchor;
                    int i41 = matchMinDimension2;
                    int i42 = matchMaxDimension3;
                    int i43 = numConnections;
                    int i44 = matchMaxDimension2;
                    C0203i iVar21 = beginTarget;
                    i = 6;
                    matchMaxDimension5 = 0;
                    C0203i iVar22 = parentMin;
                    C0203i iVar23 = begin3;
                }
            } else if (parentWrapContent) {
                eVar.mo4024b(iVar4, end2, 0, 5);
                C0175f fVar18 = beginAnchor;
                C0175f fVar19 = endAnchor;
                int i45 = matchMinDimension2;
                int i46 = matchMaxDimension3;
                int i47 = numConnections;
                int i48 = matchMaxDimension2;
                C0203i iVar24 = beginTarget;
                i = 6;
                matchMaxDimension5 = 0;
                C0203i iVar25 = parentMin;
                C0203i iVar26 = begin3;
            } else {
                C0175f fVar20 = beginAnchor;
                C0175f fVar21 = endAnchor;
                int i49 = matchMinDimension2;
                int i50 = matchMaxDimension3;
                int i51 = numConnections;
                int i52 = matchMaxDimension2;
                C0203i iVar27 = beginTarget;
                i = 6;
                matchMaxDimension5 = 0;
                C0203i iVar28 = parentMin;
                C0203i iVar29 = begin3;
            }
            if (parentWrapContent) {
                eVar.mo4024b(iVar4, end2, matchMaxDimension5, i);
            }
            return;
        }
        if (numConnections2 < 2 && parentWrapContent) {
            eVar.mo4024b(begin, iVar, matchMaxDimension4, 6);
            eVar.mo4024b(iVar4, end2, matchMaxDimension4, 6);
        }
    }

    /* renamed from: c */
    public void mo3886c(C0198e system) {
        int left = system.mo4022b((Object) this.f448v);
        int top = system.mo4022b((Object) this.f449w);
        int right = system.mo4022b((Object) this.f450x);
        int bottom = system.mo4022b((Object) this.f451y);
        int h = bottom - top;
        if (right - left < 0 || h < 0 || left == Integer.MIN_VALUE || left == Integer.MAX_VALUE || top == Integer.MIN_VALUE || top == Integer.MAX_VALUE || right == Integer.MIN_VALUE || right == Integer.MAX_VALUE || bottom == Integer.MIN_VALUE || bottom == Integer.MAX_VALUE) {
            left = 0;
            top = 0;
            right = 0;
            bottom = 0;
        }
        mo3863a(left, top, right, bottom);
    }
}
