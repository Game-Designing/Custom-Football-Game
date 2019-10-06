package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.support.p001v7.widget.LinearLayoutManager;
import android.util.SparseArray;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads.Gs */
final class C8884Gs implements zznp, zzqj, zzqv, zzsf<C8989Ls> {

    /* renamed from: A */
    private boolean[] f21083A;

    /* renamed from: B */
    private boolean f21084B;

    /* renamed from: C */
    private long f21085C;

    /* renamed from: D */
    private long f21086D;

    /* renamed from: E */
    private long f21087E;

    /* renamed from: F */
    private int f21088F;

    /* renamed from: G */
    private boolean f21089G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public boolean f21090H;

    /* renamed from: a */
    private final Uri f21091a;

    /* renamed from: b */
    private final zzrv f21092b;

    /* renamed from: c */
    private final int f21093c;

    /* renamed from: d */
    private final Handler f21094d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final zzqi f21095e;

    /* renamed from: f */
    private final zzqm f21096f;

    /* renamed from: g */
    private final zzrt f21097g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final String f21098h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final long f21099i;

    /* renamed from: j */
    private final zzse f21100j = new zzse("Loader:ExtractorMediaPeriod");

    /* renamed from: k */
    private final C9010Ms f21101k;

    /* renamed from: l */
    private final zzsm f21102l;

    /* renamed from: m */
    private final Runnable f21103m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final Runnable f21104n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final Handler f21105o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public final SparseArray<zzqt> f21106p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public zzqk f21107q;

    /* renamed from: r */
    private zznu f21108r;

    /* renamed from: s */
    private boolean f21109s;

    /* renamed from: t */
    private boolean f21110t;

    /* renamed from: u */
    private boolean f21111u;

    /* renamed from: v */
    private boolean f21112v;

    /* renamed from: w */
    private int f21113w;

    /* renamed from: x */
    private zzrb f21114x;

    /* renamed from: y */
    private long f21115y;

    /* renamed from: z */
    private boolean[] f21116z;

    public C8884Gs(Uri uri, zzrv zzrv, zznn[] zznnArr, int i, Handler handler, zzqi zzqi, zzqm zzqm, zzrt zzrt, String str, int i2) {
        this.f21091a = uri;
        this.f21092b = zzrv;
        this.f21093c = i;
        this.f21094d = handler;
        this.f21095e = zzqi;
        this.f21096f = zzqm;
        this.f21097g = zzrt;
        this.f21098h = str;
        this.f21099i = (long) i2;
        this.f21101k = new C9010Ms(zznnArr, this);
        this.f21102l = new zzsm();
        this.f21103m = new C8905Hs(this);
        this.f21104n = new C8926Is(this);
        this.f21105o = new Handler();
        this.f21087E = -9223372036854775807L;
        this.f21106p = new SparseArray<>();
        this.f21085C = -1;
    }

    /* renamed from: g */
    public final void mo28302g() {
        this.f21100j.mo32184a((Runnable) new C8947Js(this, this.f21101k));
        this.f21105o.removeCallbacksAndMessages(null);
        this.f21090H = true;
    }

    /* renamed from: a */
    public final void mo28290a(zzqk zzqk, long j) {
        this.f21107q = zzqk;
        this.f21102l.mo32188b();
        m22616i();
    }

    /* renamed from: d */
    public final void mo28299d() throws IOException {
        this.f21100j.mo32183a((int) LinearLayoutManager.INVALID_OFFSET);
    }

    /* renamed from: e */
    public final zzrb mo28300e() {
        return this.f21114x;
    }

    /* renamed from: a */
    public final long mo28286a(zzrm[] zzrmArr, boolean[] zArr, zzqw[] zzqwArr, boolean[] zArr2, long j) {
        zzsk.m31082b(this.f21110t);
        for (int i = 0; i < zzrmArr.length; i++) {
            if (zzqwArr[i] != null && (zzrmArr[i] == null || !zArr[i])) {
                int a = zzqwArr[i].f21525a;
                zzsk.m31082b(this.f21116z[a]);
                this.f21113w--;
                this.f21116z[a] = false;
                ((zzqt) this.f21106p.valueAt(a)).mo32110a();
                zzqwArr[i] = null;
            }
        }
        boolean z = false;
        for (int i2 = 0; i2 < zzrmArr.length; i2++) {
            if (zzqwArr[i2] == null && zzrmArr[i2] != null) {
                zzrm zzrm = zzrmArr[i2];
                zzsk.m31082b(zzrm.length() == 1);
                zzsk.m31082b(zzrm.mo32150a(0) == 0);
                int a2 = this.f21114x.mo32146a(zzrm.mo32151a());
                zzsk.m31082b(!this.f21116z[a2]);
                this.f21113w++;
                this.f21116z[a2] = true;
                zzqwArr[i2] = new C9031Ns(this, a2);
                zArr2[i2] = true;
                z = true;
            }
        }
        if (!this.f21111u) {
            int size = this.f21106p.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (!this.f21116z[i3]) {
                    ((zzqt) this.f21106p.valueAt(i3)).mo32110a();
                }
            }
        }
        if (this.f21113w == 0) {
            this.f21112v = false;
            if (this.f21100j.mo32185a()) {
                this.f21100j.mo32186b();
            }
        } else if (!this.f21111u ? j != 0 : z) {
            j = mo28285a(j);
            for (int i4 = 0; i4 < zzqwArr.length; i4++) {
                if (zzqwArr[i4] != null) {
                    zArr2[i4] = true;
                }
            }
        }
        this.f21111u = true;
        return j;
    }

    /* renamed from: c */
    public final void mo28298c(long j) {
    }

    /* renamed from: b */
    public final boolean mo28296b(long j) {
        if (this.f21089G || (this.f21110t && this.f21113w == 0)) {
            return false;
        }
        boolean b = this.f21102l.mo32188b();
        if (!this.f21100j.mo32185a()) {
            m22616i();
            b = true;
        }
        return b;
    }

    /* renamed from: c */
    public final long mo28297c() {
        if (this.f21113w == 0) {
            return Long.MIN_VALUE;
        }
        return mo28294b();
    }

    /* renamed from: a */
    public final long mo28284a() {
        if (!this.f21112v) {
            return -9223372036854775807L;
        }
        this.f21112v = false;
        return this.f21086D;
    }

    /* renamed from: b */
    public final long mo28294b() {
        long j;
        if (this.f21089G) {
            return Long.MIN_VALUE;
        }
        if (m22617j()) {
            return this.f21087E;
        }
        if (this.f21084B) {
            j = Long.MAX_VALUE;
            int size = this.f21106p.size();
            for (int i = 0; i < size; i++) {
                if (this.f21083A[i]) {
                    j = Math.min(j, ((zzqt) this.f21106p.valueAt(i)).mo32114b());
                }
            }
        } else {
            j = m22620m();
        }
        if (j == Long.MIN_VALUE) {
            return this.f21086D;
        }
        return j;
    }

    /* renamed from: a */
    public final long mo28285a(long j) {
        if (!this.f21108r.mo32043c()) {
            j = 0;
        }
        this.f21086D = j;
        int size = this.f21106p.size();
        boolean z = !m22617j();
        int i = 0;
        while (z && i < size) {
            if (this.f21116z[i]) {
                z = ((zzqt) this.f21106p.valueAt(i)).mo32113a(j, false);
            }
            i++;
        }
        if (!z) {
            this.f21087E = j;
            this.f21089G = false;
            if (this.f21100j.mo32185a()) {
                this.f21100j.mo32186b();
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    ((zzqt) this.f21106p.valueAt(i2)).mo32112a(this.f21116z[i2]);
                }
            }
        }
        this.f21112v = false;
        return j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo28293a(int i) {
        return this.f21089G || (!m22617j() && ((zzqt) this.f21106p.valueAt(i)).mo32116d());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public final void mo28303h() throws IOException {
        this.f21100j.mo32183a((int) LinearLayoutManager.INVALID_OFFSET);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final int mo28282a(int i, zzlj zzlj, zznd zznd, boolean z) {
        if (this.f21112v || m22617j()) {
            return -3;
        }
        return ((zzqt) this.f21106p.valueAt(i)).mo32109a(zzlj, zznd, z, this.f21089G, this.f21086D);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28287a(int i, long j) {
        zzqt zzqt = (zzqt) this.f21106p.valueAt(i);
        if (!this.f21089G || j <= zzqt.mo32114b()) {
            zzqt.mo32113a(j, true);
        } else {
            zzqt.mo32118f();
        }
    }

    /* renamed from: b */
    public final zznw mo28295b(int i, int i2) {
        zzqt zzqt = (zzqt) this.f21106p.get(i);
        if (zzqt != null) {
            return zzqt;
        }
        zzqt zzqt2 = new zzqt(this.f21097g);
        zzqt2.mo32111a((zzqv) this);
        this.f21106p.put(i, zzqt2);
        return zzqt2;
    }

    /* renamed from: f */
    public final void mo28301f() {
        this.f21109s = true;
        this.f21105o.post(this.f21103m);
    }

    /* renamed from: a */
    public final void mo28289a(zznu zznu) {
        this.f21108r = zznu;
        this.f21105o.post(this.f21103m);
    }

    /* renamed from: a */
    public final void mo28288a(zzlh zzlh) {
        this.f21105o.post(this.f21103m);
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public final void m22618k() {
        if (!this.f21090H && !this.f21110t && this.f21108r != null && this.f21109s) {
            int size = this.f21106p.size();
            int i = 0;
            while (i < size) {
                if (((zzqt) this.f21106p.valueAt(i)).mo32117e() != null) {
                    i++;
                } else {
                    return;
                }
            }
            this.f21102l.mo32189c();
            zzra[] zzraArr = new zzra[size];
            this.f21083A = new boolean[size];
            this.f21116z = new boolean[size];
            this.f21115y = this.f21108r.mo32042b();
            int i2 = 0;
            while (true) {
                boolean z = true;
                if (i2 < size) {
                    zzlh e = ((zzqt) this.f21106p.valueAt(i2)).mo32117e();
                    zzraArr[i2] = new zzra(e);
                    String str = e.f28784f;
                    if (!zzsp.m31098b(str) && !zzsp.m31097a(str)) {
                        z = false;
                    }
                    this.f21083A[i2] = z;
                    this.f21084B = z | this.f21084B;
                    i2++;
                } else {
                    this.f21114x = new zzrb(zzraArr);
                    this.f21110t = true;
                    this.f21096f.mo28528a(new zzqz(this.f21115y, this.f21108r.mo32043c()), null);
                    this.f21107q.mo28511a(this);
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private final void m22607a(C8989Ls ls) {
        if (this.f21085C == -1) {
            this.f21085C = ls.f21462i;
        }
    }

    /* renamed from: i */
    private final void m22616i() {
        C8989Ls ls = new C8989Ls(this, this.f21091a, this.f21092b, this.f21101k, this.f21102l);
        if (this.f21110t) {
            zzsk.m31082b(m22617j());
            long j = this.f21115y;
            if (j == -9223372036854775807L || this.f21087E < j) {
                ls.mo28445a(this.f21108r.mo32041a(this.f21087E), this.f21087E);
                this.f21087E = -9223372036854775807L;
            } else {
                this.f21089G = true;
                this.f21087E = -9223372036854775807L;
                return;
            }
        }
        this.f21088F = m22619l();
        int i = this.f21093c;
        if (i == -1) {
            if (this.f21110t && this.f21085C == -1) {
                zznu zznu = this.f21108r;
                if (zznu == null || zznu.mo32042b() == -9223372036854775807L) {
                    i = 6;
                }
            }
            i = 3;
        }
        this.f21100j.mo32182a(ls, this, i);
    }

    /* renamed from: l */
    private final int m22619l() {
        int i = 0;
        for (int i2 = 0; i2 < this.f21106p.size(); i2++) {
            i += ((zzqt) this.f21106p.valueAt(i2)).mo32115c();
        }
        return i;
    }

    /* renamed from: m */
    private final long m22620m() {
        int size = this.f21106p.size();
        long j = Long.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            j = Math.max(j, ((zzqt) this.f21106p.valueAt(i)).mo32114b());
        }
        return j;
    }

    /* renamed from: j */
    private final boolean m22617j() {
        return this.f21087E != -9223372036854775807L;
    }

    /* renamed from: a */
    public final /* synthetic */ int mo28283a(zzsh zzsh, long j, long j2, IOException iOException) {
        C8989Ls ls = (C8989Ls) zzsh;
        m22607a(ls);
        Handler handler = this.f21094d;
        if (!(handler == null || this.f21095e == null)) {
            handler.post(new C8968Ks(this, iOException));
        }
        if (iOException instanceof zzrc) {
            return 3;
        }
        boolean z = m22619l() > this.f21088F;
        if (this.f21085C == -1) {
            zznu zznu = this.f21108r;
            if (zznu == null || zznu.mo32042b() == -9223372036854775807L) {
                this.f21086D = 0;
                this.f21112v = this.f21110t;
                int size = this.f21106p.size();
                for (int i = 0; i < size; i++) {
                    ((zzqt) this.f21106p.valueAt(i)).mo32112a(!this.f21110t || this.f21116z[i]);
                }
                ls.mo28445a(0, 0);
            }
        }
        this.f21088F = m22619l();
        return z ? 1 : 0;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28292a(zzsh zzsh, long j, long j2, boolean z) {
        m22607a((C8989Ls) zzsh);
        if (!z && this.f21113w > 0) {
            int size = this.f21106p.size();
            for (int i = 0; i < size; i++) {
                ((zzqt) this.f21106p.valueAt(i)).mo32112a(this.f21116z[i]);
            }
            this.f21107q.mo28512a(this);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28291a(zzsh zzsh, long j, long j2) {
        long j3;
        m22607a((C8989Ls) zzsh);
        this.f21089G = true;
        if (this.f21115y == -9223372036854775807L) {
            long m = m22620m();
            if (m == Long.MIN_VALUE) {
                j3 = 0;
            } else {
                j3 = m + 10000;
            }
            this.f21115y = j3;
            this.f21096f.mo28528a(new zzqz(this.f21115y, this.f21108r.mo32043c()), null);
        }
        this.f21107q.mo28512a(this);
    }
}
