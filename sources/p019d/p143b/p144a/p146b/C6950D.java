package p019d.p143b.p144a.p146b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.applovin.adview.C5856b;
import com.applovin.adview.C5862h;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p019d.p143b.p144a.p145a.C6925a;
import p019d.p143b.p144a.p147c.C7043Ac;
import p019d.p143b.p144a.p147c.C7052D;
import p019d.p143b.p144a.p147c.C7086Lb;
import p019d.p143b.p144a.p147c.C7135aa;
import p019d.p143b.p144a.p147c.C7142c;
import p019d.p143b.p144a.p147c.C7171ja;
import p019d.p143b.p144a.p147c.C7182m;
import p019d.p143b.p144a.p147c.C7197pc;
import p019d.p143b.p144a.p147c.C7209sc;
import p019d.p143b.p144a.p147c.C7212tb;
import p019d.p143b.p144a.p147c.C7216ub;
import p019d.p143b.p144a.p147c.C7234z;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7258h;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.b.D */
public abstract class C6950D extends Activity implements C7028u {

    /* renamed from: a */
    public static volatile C7007ja f12836a = null;

    /* renamed from: A */
    private long f12837A = 0;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public long f12838B = 0;

    /* renamed from: C */
    private int f12839C = 0;

    /* renamed from: D */
    private AtomicBoolean f12840D = new AtomicBoolean(false);

    /* renamed from: E */
    private Handler f12841E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public Handler f12842F;

    /* renamed from: G */
    private FrameLayout f12843G;

    /* renamed from: H */
    public C7023ra f12844H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public C7016o f12845I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public View f12846J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public C7016o f12847K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public View f12848L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public C7012m f12849M;

    /* renamed from: N */
    private ImageView f12850N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public WeakReference<MediaPlayer> f12851O = new WeakReference<>(null);

    /* renamed from: P */
    private C7135aa f12852P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public C7025sa f12853Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public ProgressBar f12854R;

    /* renamed from: S */
    private C7029ua f12855S;

    /* renamed from: T */
    protected C7020q f12856T;

    /* renamed from: U */
    private C7197pc f12857U;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C5856b f12858b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C7007ja f12859c;

    /* renamed from: d */
    private volatile boolean f12860d = false;

    /* renamed from: e */
    private C7086Lb f12861e;

    /* renamed from: f */
    public C7262l f12862f;

    /* renamed from: g */
    public C7212tb f12863g;

    /* renamed from: h */
    public C7142c f12864h;

    /* renamed from: i */
    public volatile C7234z f12865i;

    /* renamed from: j */
    public String f12866j;

    /* renamed from: k */
    private volatile boolean f12867k = false;

    /* renamed from: l */
    private volatile boolean f12868l = false;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public volatile boolean f12869m = false;

    /* renamed from: n */
    private volatile boolean f12870n = false;

    /* renamed from: o */
    private volatile boolean f12871o = false;

    /* renamed from: p */
    private volatile boolean f12872p = false;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public volatile boolean f12873q = false;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public volatile boolean f12874r = false;

    /* renamed from: s */
    protected volatile boolean f12875s = false;

    /* renamed from: t */
    private boolean f12876t = false;

    /* renamed from: u */
    protected volatile boolean f12877u = false;

    /* renamed from: v */
    private volatile boolean f12878v = false;

    /* renamed from: w */
    private boolean f12879w = true;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f12880x = false;

    /* renamed from: y */
    protected int f12881y = 0;

    /* renamed from: z */
    private boolean f12882z = false;

    /* access modifiers changed from: private */
    /* renamed from: A */
    public void m14238A() {
        if (!this.f12875s) {
            C7023ra raVar = this.f12844H;
            if (raVar != null && !raVar.isPlaying()) {
                this.f12844H.seekTo(((Integer) this.f12864h.mo23041a(C7216ub.f13983j, Integer.valueOf(this.f12844H.getDuration()))).intValue());
                this.f12844H.start();
                this.f12856T.mo22684a();
            }
        }
    }

    /* renamed from: B */
    private void m14239B() {
        String str = "InterActivity";
        if (!this.f12872p) {
            try {
                if (this.f12865i.mo22402c()) {
                    double e = (double) mo22498e();
                    String a = this.f12865i.mo23422a((int) e, this.f12866j, this.f12878v);
                    if (C7269s.m15819a(a)) {
                        this.f12864h.mo23078w().mo23136a(a, null);
                    } else {
                        this.f12862f.mo22916b(str, "Received invalid placement aware parameterized video completion url. No postback dispatched.");
                    }
                    m14278a((C7251a) this.f12865i, e, mo22500g());
                    if (this.f12861e != null) {
                        this.f12861e.mo22887b((long) e);
                    }
                } else if ((this.f12865i instanceof C7043Ac) && m14314t() && this.f12863g.mo23311n()) {
                    int q = m14308q();
                    C7262l lVar = this.f12862f;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Rewarded playable engaged at ");
                    sb.append(q);
                    sb.append(" percent");
                    lVar.mo22918c(str, sb.toString());
                    m14278a((C7251a) this.f12865i, (double) q, q >= this.f12865i.mo23404J());
                }
            } catch (Throwable th) {
                C7262l lVar2 = this.f12862f;
                if (lVar2 != null) {
                    lVar2.mo22917b(str, "Failed to notify end listener.", th);
                }
            }
        }
    }

    /* renamed from: C */
    private boolean m14242C() {
        int identifier = getResources().getIdentifier(this.f12863g.mo23315p(), "bool", "android");
        return identifier > 0 && getResources().getBoolean(identifier);
    }

    /* access modifiers changed from: private */
    /* renamed from: D */
    public void m14244D() {
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* renamed from: E */
    private boolean m14245E() {
        if (this.f12859c != null) {
            C7212tb tbVar = this.f12863g;
            if (tbVar == null || tbVar.mo23259A()) {
                return true;
            }
            if (!this.f12863g.mo23279U() || !this.f12873q) {
                return this.f12863g.mo23278T() && this.f12875s;
            }
            return true;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: F */
    public void m14246F() {
        if (!this.f12865i.mo22416v() || this.f12865i.mo22408ja() == null) {
            m14247G();
            m14248H();
            return;
        }
        this.f12864h.mo23049b().mo22918c("InterActivity", "Clicking through video...");
        mo22493a();
    }

    /* renamed from: G */
    private void m14247G() {
        if (this.f12863g.mo23300ha()) {
            C7012m mVar = this.f12849M;
            if (mVar != null && mVar.getVisibility() != 8) {
                m14273a((View) this.f12849M, this.f12849M.getVisibility() == 4, 750);
            }
        }
    }

    /* renamed from: H */
    private void m14248H() {
        C7021qa u = this.f12865i.mo23440u();
        if (u != null && u.mo22692e() && !this.f12875s) {
            C7025sa saVar = this.f12853Q;
            if (saVar != null) {
                m14273a((View) this.f12853Q, saVar.getVisibility() == 4, u.mo22694f());
            }
        }
    }

    /* renamed from: I */
    private void m14249I() {
        C7142c cVar = this.f12864h;
        if (cVar != null) {
            cVar.mo23052b(C7216ub.f13984k, Boolean.valueOf(false));
            this.f12864h.mo23052b(C7216ub.f13983j, Integer.valueOf(0));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: J */
    public void m14250J() {
        this.f12868l = true;
        mo22506m();
    }

    /* access modifiers changed from: private */
    /* renamed from: K */
    public boolean m14251K() {
        return ((Integer) this.f12864h.mo23041a(C7216ub.f13983j, Integer.valueOf(0))).intValue() > 0 ? this.f12877u : this.f12863g.mo23318qa() ? this.f12864h.mo23081z().mo23485d() : this.f12863g.mo23314oa();
    }

    /* renamed from: L */
    private void m14252L() {
        this.f12845I = C7016o.m14497a(this.f12864h, this, this.f12865i.mo23436na());
        this.f12845I.setVisibility(8);
        this.f12845I.setOnClickListener(new C7003ha(this));
        int a = m14267a(this.f12865i.mo23406L());
        int i = 3;
        int i2 = (this.f12865i.mo23409O() ? 3 : 5) | 48;
        if (!this.f12865i.mo23410P()) {
            i = 5;
        }
        int i3 = i | 48;
        LayoutParams layoutParams = new LayoutParams(a, a, i2 | 48);
        this.f12845I.mo22636a(a);
        int a2 = m14267a(this.f12865i.mo23407M());
        int a3 = m14267a(this.f12865i.mo23408N());
        layoutParams.setMargins(a3, a2, a3, a2);
        this.f12843G.addView(this.f12845I, layoutParams);
        this.f12847K = C7016o.m14497a(this.f12864h, this, this.f12865i.mo22764q());
        this.f12847K.setVisibility(8);
        this.f12847K.setOnClickListener(new C7005ia(this));
        LayoutParams layoutParams2 = new LayoutParams(a, a, i3);
        layoutParams2.setMargins(a3, a2, a3, a2);
        this.f12847K.mo22636a(a);
        this.f12843G.addView(this.f12847K, layoutParams2);
        this.f12847K.bringToFront();
        if (m14256P()) {
            int a4 = m14267a(new C7212tb(this.f12864h).mo23290ca());
            this.f12846J = new View(this);
            this.f12846J.setBackgroundColor(0);
            this.f12846J.setVisibility(8);
            this.f12848L = new View(this);
            this.f12848L.setBackgroundColor(0);
            this.f12848L.setVisibility(8);
            int i4 = a + a4;
            int a5 = a2 - m14267a(5);
            LayoutParams layoutParams3 = new LayoutParams(i4, i4, i2);
            layoutParams3.setMargins(a5, a5, a5, a5);
            LayoutParams layoutParams4 = new LayoutParams(i4, i4, i3);
            layoutParams4.setMargins(a5, a5, a5, a5);
            this.f12846J.setOnClickListener(new C6956G(this));
            this.f12848L.setOnClickListener(new C6958H(this));
            this.f12843G.addView(this.f12846J, layoutParams3);
            this.f12846J.bringToFront();
            this.f12843G.addView(this.f12848L, layoutParams4);
            this.f12848L.bringToFront();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: M */
    public void m14253M() {
        String str = "InterActivity";
        if (this.f12850N == null) {
            try {
                this.f12877u = m14251K();
                this.f12850N = new ImageView(this);
                if (!m14254N()) {
                    int a = m14267a(this.f12863g.mo23306ka());
                    LayoutParams layoutParams = new LayoutParams(a, a, this.f12863g.mo23308la());
                    this.f12850N.setScaleType(ScaleType.FIT_CENTER);
                    int a2 = m14267a(this.f12863g.mo23310ma());
                    layoutParams.setMargins(a2, a2, a2, a2);
                    Uri fa = this.f12877u ? this.f12865i.mo23431fa() : this.f12865i.mo23432ga();
                    if (fa != null) {
                        C7262l b = this.f12864h.mo23049b();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Added mute button with params: ");
                        sb.append(layoutParams);
                        b.mo22918c(str, sb.toString());
                        m14279a(this.f12877u);
                        this.f12850N.setClickable(true);
                        this.f12850N.setOnClickListener(new C6960I(this));
                        this.f12843G.addView(this.f12850N, layoutParams);
                        this.f12850N.bringToFront();
                        return;
                    }
                    C7262l b2 = this.f12864h.mo23049b();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Attempting to add mute button but could not find uri = ");
                    sb2.append(fa);
                    b2.mo22916b(str, sb2.toString());
                    return;
                }
                this.f12864h.mo23049b().mo22918c(str, "Mute button should be hidden");
            } catch (Exception e) {
                this.f12864h.mo23049b().mo22914a(str, "Failed to attach mute button", e);
            }
        }
    }

    /* renamed from: N */
    private boolean m14254N() {
        if (!this.f12863g.mo23302ia()) {
            return true;
        }
        if (!this.f12863g.mo23304ja() || m14251K()) {
            return false;
        }
        return !this.f12863g.mo23316pa();
    }

    /* access modifiers changed from: private */
    /* renamed from: O */
    public void m14255O() {
        runOnUiThread(new C6962J(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: P */
    public boolean m14256P() {
        return this.f12863g.mo23290ca() > 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: Q */
    public void m14257Q() {
        runOnUiThread(new C6964K(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        if (r0 != null) goto L_0x0016;
     */
    /* renamed from: R */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m14258R() {
        /*
            r3 = this;
            d.b.a.c.z r0 = r3.f12865i
            float r0 = r0.mo23434la()
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0023
            boolean r0 = r3.f12876t
            if (r0 == 0) goto L_0x0014
            d.b.a.b.o r0 = r3.f12847K
            if (r0 == 0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            d.b.a.b.o r0 = r3.f12845I
        L_0x0016:
            d.b.a.c.z r1 = r3.f12865i
            float r1 = r1.mo23434la()
            long r1 = p019d.p143b.p144a.p147c.C7209sc.m15484c(r1)
            r3.m14271a(r1, r0)
        L_0x0023:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p143b.p144a.p146b.C6950D.m14258R():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: S */
    public void m14259S() {
        boolean z = this.f12863g.mo23284Z() && m14262V() > 0;
        if (this.f12849M == null && z) {
            this.f12849M = new C7012m(this);
            int B = this.f12865i.mo23396B();
            this.f12849M.mo22644c(B);
            this.f12849M.mo22641b((float) this.f12863g.mo23283Y());
            this.f12849M.mo22646d(B);
            this.f12849M.mo22638a((float) this.f12863g.mo23282X());
            this.f12849M.mo22642b(m14262V());
            this.f12849M.mo22639a(m14262V());
            LayoutParams layoutParams = new LayoutParams(m14267a(this.f12863g.mo23281W()), m14267a(this.f12863g.mo23281W()), this.f12863g.mo23298ga());
            int a = m14267a(this.f12863g.mo23296fa());
            layoutParams.setMargins(a, a, a, a);
            this.f12843G.addView(this.f12849M, layoutParams);
            this.f12849M.bringToFront();
            this.f12849M.setVisibility(0);
            this.f12856T.mo22685a("COUNTDOWN_CLOCK", 1000, (C7024s) new C6968M(this, m14261U()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: T */
    public boolean m14260T() {
        return !this.f12880x && !this.f12875s && this.f12844H.isPlaying();
    }

    /* renamed from: U */
    private long m14261U() {
        return TimeUnit.SECONDS.toMillis((long) m14262V());
    }

    /* renamed from: V */
    private int m14262V() {
        int A = this.f12865i.mo23395A();
        if (A > 0) {
            return A;
        }
        if (this.f12863g.mo23294ea()) {
            A = this.f12881y + 1;
        }
        return A;
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: W */
    public void m14263W() {
        if (this.f12854R == null && this.f12865i.mo23402H()) {
            String str = "InterActivity";
            this.f12862f.mo22920d(str, "Attaching video progress bar...");
            this.f12854R = new ProgressBar(this, null, 16842872);
            this.f12854R.setMax(this.f12863g.mo23266H());
            this.f12854R.setPadding(0, 0, 0, 0);
            if (C7182m.m15329g()) {
                try {
                    this.f12854R.setProgressTintList(ColorStateList.valueOf(this.f12865i.mo23403I()));
                } catch (Throwable th) {
                    this.f12862f.mo22917b(str, "Unable to update progress bar color.", th);
                }
            }
            LayoutParams layoutParams = new LayoutParams(this.f12844H.getWidth(), 20, 80);
            layoutParams.setMargins(0, 0, 0, this.f12863g.mo23267I());
            this.f12843G.addView(this.f12854R, layoutParams);
            this.f12854R.bringToFront();
            String str2 = "PROGRESS_BAR";
            this.f12856T.mo22685a(str2, this.f12863g.mo23265G(), (C7024s) new C6970N(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: X */
    public void m14264X() {
        C7021qa u = this.f12865i.mo23440u();
        if (C7269s.m15819a(this.f12865i.mo23439t()) && u != null && this.f12853Q == null) {
            this.f12862f.mo22920d("InterActivity", "Attaching video button...");
            this.f12853Q = m14265Y();
            double a = (double) u.mo22688a();
            Double.isNaN(a);
            double d = a / 100.0d;
            double b = (double) u.mo22689b();
            Double.isNaN(b);
            double d2 = b / 100.0d;
            int width = this.f12844H.getWidth();
            int height = this.f12844H.getHeight();
            double d3 = (double) width;
            Double.isNaN(d3);
            int i = (int) (d * d3);
            double d4 = (double) height;
            Double.isNaN(d4);
            LayoutParams layoutParams = new LayoutParams(i, (int) (d2 * d4), u.mo22691d());
            int a2 = m14267a(u.mo22690c());
            layoutParams.setMargins(a2, a2, a2, a2);
            this.f12843G.addView(this.f12853Q, layoutParams);
            this.f12853Q.bringToFront();
            if (u.mo22698i() > 0.0f) {
                this.f12853Q.setVisibility(4);
                this.f12842F.postDelayed(new C6972O(this, u), C7209sc.m15484c(u.mo22698i()));
            }
            if (u.mo22699j() > 0.0f) {
                this.f12842F.postDelayed(new C6974P(this, u), C7209sc.m15484c(u.mo22699j()));
            }
        }
    }

    /* renamed from: Y */
    private C7025sa m14265Y() {
        C7262l lVar = this.f12862f;
        StringBuilder sb = new StringBuilder();
        sb.append("Create video button with HTML = ");
        sb.append(this.f12865i.mo23439t());
        lVar.mo22918c("InterActivity", sb.toString());
        C7027ta taVar = new C7027ta(this.f12864h);
        this.f12855S = new C6979S(this);
        taVar.mo22711a(new WeakReference(this.f12855S));
        C7025sa saVar = new C7025sa(taVar, getApplicationContext());
        saVar.mo22706a(this.f12865i.mo23439t());
        return saVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: Z */
    public void m14266Z() {
        if (m14289ba()) {
            m14324y();
            mo22502i();
            this.f12862f.mo22918c("InterActivity", "Prompting incentivized ad close warning");
            this.f12852P.mo23016b();
            return;
        }
        mo22507n();
    }

    /* renamed from: a */
    private int m14267a(int i) {
        return C7269s.m15812a((Context) this, i);
    }

    /* renamed from: a */
    private int m14268a(int i, boolean z) {
        if (z) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 9;
            }
            if (i == 2) {
                return 8;
            }
            if (i == 3) {
                return 1;
            }
        } else if (i == 0) {
            return 1;
        } else {
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 9;
            }
            if (i == 3) {
                return 8;
            }
        }
        return -1;
    }

    /* renamed from: a */
    private static int m14269a(Display display) {
        if (display.getWidth() == display.getHeight()) {
            return 3;
        }
        return display.getWidth() < display.getHeight() ? 1 : 2;
    }

    /* renamed from: a */
    private void m14271a(long j, C7016o oVar) {
        this.f12842F.postDelayed(new C6966L(this, oVar), j);
    }

    /* renamed from: a */
    private void m14272a(Uri uri) {
        this.f12844H = this.f12865i.mo23430ea() ? new C7013ma(this.f12864h, this, new C6986Y(this)) : new C6990b(this);
        if (uri != null) {
            this.f12844H.setOnPreparedListener(new C6987Z(this));
            this.f12844H.setOnCompletionListener(new C6993ca(this));
            this.f12844H.setOnErrorListener(new C6995da(this));
            ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            this.f12844H.setVideoURI(uri);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
        this.f12844H.setLayoutParams(new LayoutParams(-1, -1, 17));
        this.f12844H.setOnTouchListener(new C5862h(this, new C6999fa(this)));
        this.f12843G.addView((View) this.f12844H);
        setContentView(this.f12843G);
        m14258R();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14273a(View view, boolean z, long j) {
        float f = 0.0f;
        float f2 = z ? 0.0f : 1.0f;
        if (z) {
            f = 1.0f;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f);
        alphaAnimation.setDuration(j);
        alphaAnimation.setAnimationListener(new C6976Q(this, view, z));
        view.startAnimation(alphaAnimation);
    }

    /* renamed from: a */
    private void m14276a(C7234z zVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.f12843G = new FrameLayout(this);
        this.f12843G.setLayoutParams(layoutParams);
        this.f12843G.setBackgroundColor(zVar.mo23397C());
        this.f12842F = new Handler();
        this.f12841E = new Handler();
        this.f12856T = new C7020q(this.f12841E, this.f12864h);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14277a(C7251a aVar) {
        C7171ja.m15276a(this.f12859c.mo22621d(), aVar, (C7267q) this.f12864h);
        this.f12869m = true;
    }

    /* renamed from: a */
    private void m14278a(C7251a aVar, double d, boolean z) {
        this.f12872p = true;
        C7171ja.m15280a(this.f12859c.mo22620c(), aVar, d, z, this.f12864h);
    }

    /* renamed from: a */
    private void m14279a(boolean z) {
        Uri fa = z ? this.f12865i.mo23431fa() : this.f12865i.mo23432ga();
        int a = m14267a(this.f12863g.mo23306ka());
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        C7269s.m15815a(this.f12850N, fa, a);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* access modifiers changed from: private */
    /* renamed from: aa */
    public void m14282aa() {
        if (mo22683p()) {
            this.f12862f.mo22918c("InterActivity", "Prompting incentivized non-video ad close warning");
            this.f12852P.mo23017c();
            return;
        }
        mo22496c();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004a, code lost:
        if (r7 == 2) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005b, code lost:
        if (r7 == 1) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        if (r7 == 1) goto L_0x0020;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m14284b(int r7, boolean r8) {
        /*
            r6 = this;
            d.b.a.c.tb r0 = r6.f12863g
            boolean r0 = r0.mo23309m()
            d.b.a.b.ja r1 = r6.f12859c
            d.b.a.c.B r1 = r1.mo22623f()
            d.b.a.c.B r2 = p019d.p143b.p144a.p147c.C7044B.ACTIVITY_PORTRAIT
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 != r2) goto L_0x0034
            r1 = 9
            if (r8 == 0) goto L_0x0024
            if (r7 == r5) goto L_0x001c
            if (r7 == r3) goto L_0x001c
            goto L_0x0028
        L_0x001c:
            if (r0 == 0) goto L_0x005e
            if (r7 != r5) goto L_0x002a
        L_0x0020:
            r6.setRequestedOrientation(r1)
            goto L_0x005e
        L_0x0024:
            if (r7 == 0) goto L_0x002e
            if (r7 == r4) goto L_0x002e
        L_0x0028:
            r6.f12860d = r5
        L_0x002a:
            r6.setRequestedOrientation(r5)
            goto L_0x005e
        L_0x002e:
            if (r0 == 0) goto L_0x005e
            if (r7 != 0) goto L_0x0020
            r1 = 1
            goto L_0x0020
        L_0x0034:
            d.b.a.b.ja r1 = r6.f12859c
            d.b.a.c.B r1 = r1.mo22623f()
            d.b.a.c.B r2 = p019d.p143b.p144a.p147c.C7044B.ACTIVITY_LANDSCAPE
            if (r1 != r2) goto L_0x005e
            r1 = 8
            r2 = 0
            if (r8 == 0) goto L_0x004f
            if (r7 == 0) goto L_0x0048
            if (r7 == r4) goto L_0x0048
            goto L_0x0053
        L_0x0048:
            if (r0 == 0) goto L_0x005e
            if (r7 != r4) goto L_0x004d
            goto L_0x0020
        L_0x004d:
            r1 = 0
            goto L_0x0020
        L_0x004f:
            if (r7 == r5) goto L_0x0059
            if (r7 == r3) goto L_0x0059
        L_0x0053:
            r6.f12860d = r5
            r6.setRequestedOrientation(r2)
            goto L_0x005e
        L_0x0059:
            if (r0 == 0) goto L_0x005e
            if (r7 != r5) goto L_0x0020
            goto L_0x004d
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p143b.p144a.p146b.C6950D.m14284b(int, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m14286b(C7251a aVar) {
        mo22496c();
        m14291c(aVar);
    }

    /* renamed from: b */
    private void m14287b(boolean z) {
        this.f12877u = z;
        MediaPlayer mediaPlayer = (MediaPlayer) this.f12851O.get();
        if (mediaPlayer != null) {
            float f = (float) (z ? 0 : 1);
            try {
                mediaPlayer.setVolume(f, f);
            } catch (IllegalStateException e) {
                C7262l lVar = this.f12862f;
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to set MediaPlayer muted: ");
                sb.append(z);
                lVar.mo22917b("InterActivity", sb.toString(), e);
            }
        }
    }

    /* renamed from: ba */
    private boolean m14289ba() {
        return m14313s() && !mo22500g() && this.f12863g.mo23299h() && this.f12852P != null;
    }

    /* renamed from: c */
    private void m14291c(C7251a aVar) {
        if (!this.f12870n) {
            this.f12870n = true;
            C7007ja jaVar = this.f12859c;
            if (jaVar != null) {
                C7171ja.m15284b(jaVar.mo22621d(), aVar, this.f12864h);
            }
        }
    }

    /* renamed from: d */
    private void m14294d(C7251a aVar) {
        if (!this.f12871o) {
            this.f12871o = true;
            C7171ja.m15281a(this.f12859c.mo22620c(), aVar, (C7267q) this.f12864h);
        }
    }

    /* renamed from: p */
    private boolean mo22683p() {
        return m14314t() && !m14311r() && this.f12863g.mo23301i() && this.f12852P != null;
    }

    /* renamed from: q */
    private int m14308q() {
        if (!(this.f12865i instanceof C7043Ac)) {
            return 0;
        }
        float ra = ((C7043Ac) this.f12865i).mo22743ra();
        if (ra <= 0.0f) {
            ra = this.f12865i.mo23435ma();
        }
        double a = C7209sc.m15459a(System.currentTimeMillis() - this.f12837A);
        double d = (double) ra;
        Double.isNaN(d);
        return (int) Math.min((a / d) * 100.0d, 100.0d);
    }

    /* renamed from: r */
    private boolean m14311r() {
        return m14308q() >= this.f12865i.mo23404J();
    }

    /* renamed from: s */
    private boolean m14313s() {
        return C7258h.f14103b.equals(this.f12865i.mo22759d());
    }

    /* renamed from: t */
    private boolean m14314t() {
        return !this.f12865i.mo22402c() && m14313s();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
        if (r0 > 0) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0098, code lost:
        if (r0 > 0) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009a, code lost:
        r0 = java.util.concurrent.TimeUnit.SECONDS.toMillis((long) r0);
     */
    /* renamed from: u */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m14316u() {
        /*
            r7 = this;
            d.b.a.c.z r0 = r7.f12865i
            if (r0 == 0) goto L_0x00e6
            d.b.a.c.z r0 = r7.f12865i
            long r0 = r0.mo23413S()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0018
            d.b.a.c.z r0 = r7.f12865i
            int r0 = r0.mo23414T()
            if (r0 < 0) goto L_0x00e6
        L_0x0018:
            d.b.a.c.pc r0 = r7.f12857U
            if (r0 != 0) goto L_0x00e6
            d.b.a.c.z r0 = r7.f12865i
            long r0 = r0.mo23413S()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x002e
            d.b.a.c.z r0 = r7.f12865i
            long r0 = r0.mo23413S()
            goto L_0x00b6
        L_0x002e:
            boolean r0 = r7.mo22501h()
            if (r0 == 0) goto L_0x0069
            d.b.a.c.z r0 = r7.f12865i
            d.b.a.a.a r0 = (p019d.p143b.p144a.p145a.C6925a) r0
            d.b.a.a.o r1 = r0.mo22409oa()
            if (r1 == 0) goto L_0x0051
            int r4 = r1.mo22467b()
            if (r4 <= 0) goto L_0x0051
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS
            int r1 = r1.mo22467b()
            long r5 = (long) r1
            long r4 = r4.toMillis(r5)
            long r2 = r2 + r4
            goto L_0x005b
        L_0x0051:
            d.b.a.b.ra r1 = r7.f12844H
            int r1 = r1.getDuration()
            if (r1 <= 0) goto L_0x005b
            long r4 = (long) r1
            long r2 = r2 + r4
        L_0x005b:
            boolean r1 = r0.mo23415U()
            if (r1 == 0) goto L_0x00a2
            float r0 = r0.mo23435ma()
            int r0 = (int) r0
            if (r0 <= 0) goto L_0x00a2
            goto L_0x009a
        L_0x0069:
            d.b.a.c.z r0 = r7.f12865i
            boolean r0 = r0 instanceof p019d.p143b.p144a.p147c.C7043Ac
            if (r0 == 0) goto L_0x00a2
            d.b.a.c.z r0 = r7.f12865i
            d.b.a.c.Ac r0 = (p019d.p143b.p144a.p147c.C7043Ac) r0
            d.b.a.b.ra r1 = r7.f12844H
            int r1 = r1.getDuration()
            if (r1 <= 0) goto L_0x007d
            long r4 = (long) r1
            long r2 = r2 + r4
        L_0x007d:
            boolean r1 = r0.mo23415U()
            if (r1 == 0) goto L_0x00a2
            float r1 = r0.mo22743ra()
            int r1 = (int) r1
            if (r1 <= 0) goto L_0x0093
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
            long r4 = (long) r1
            long r0 = r0.toMillis(r4)
        L_0x0091:
            long r2 = r2 + r0
            goto L_0x00a2
        L_0x0093:
            float r0 = r0.mo23435ma()
            int r0 = (int) r0
            if (r0 <= 0) goto L_0x00a2
        L_0x009a:
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS
            long r4 = (long) r0
            long r0 = r1.toMillis(r4)
            goto L_0x0091
        L_0x00a2:
            double r0 = (double) r2
            d.b.a.c.z r2 = r7.f12865i
            int r2 = r2.mo23414T()
            double r2 = (double) r2
            r4 = 4636737291354636288(0x4059000000000000, double:100.0)
            java.lang.Double.isNaN(r2)
            double r2 = r2 / r4
            java.lang.Double.isNaN(r0)
            double r0 = r0 * r2
            long r0 = (long) r0
        L_0x00b6:
            d.b.d.l r2 = r7.f12862f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Scheduling report reward in "
            r3.append(r4)
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r4 = r4.toSeconds(r0)
            r3.append(r4)
            java.lang.String r4 = " seconds..."
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "InterActivity"
            r2.mo22918c(r4, r3)
            d.b.a.c.c r2 = r7.f12864h
            d.b.a.b.T r3 = new d.b.a.b.T
            r3.<init>(r7)
            d.b.a.c.pc r0 = p019d.p143b.p144a.p147c.C7197pc.m15387a(r0, r2, r3)
            r7.f12857U = r0
        L_0x00e6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p143b.p144a.p146b.C6950D.m14316u():void");
    }

    /* renamed from: v */
    private void m14319v() {
        String str;
        StringBuilder sb;
        C7262l lVar;
        if (!this.f12860d || this.f12882z) {
            C5856b bVar = this.f12858b;
            if (bVar != null) {
                bVar.setAdDisplayListener(new C6982U(this));
                this.f12858b.setAdClickListener(new C6983V(this));
                this.f12865i = (C7234z) this.f12859c.mo22619b();
                m14276a(this.f12865i);
                m14252L();
                if (this.f12865i.mo22845e()) {
                    this.f12878v = this.f12865i.mo22405ha();
                    String str2 = "InterActivity";
                    if (this.f12878v) {
                        lVar = this.f12862f;
                        sb = new StringBuilder();
                        str = "Preparing stream for ";
                    } else {
                        lVar = this.f12862f;
                        sb = new StringBuilder();
                        str = "Preparing cached video playback for ";
                    }
                    sb.append(str);
                    sb.append(this.f12865i.mo22407ia());
                    lVar.mo22918c(str2, sb.toString());
                    C7086Lb lb = this.f12861e;
                    if (lb != null) {
                        lb.mo22885a(this.f12878v ? 1 : 0);
                    }
                }
                Uri ia = this.f12865i.mo22407ia();
                m14272a(ia);
                if (ia == null) {
                    m14316u();
                }
                this.f12845I.bringToFront();
                if (m14256P()) {
                    View view = this.f12846J;
                    if (view != null) {
                        view.bringToFront();
                    }
                }
                C7016o oVar = this.f12847K;
                if (oVar != null) {
                    oVar.bringToFront();
                }
                if (!this.f12865i.mo23417W()) {
                    this.f12858b.mo18299a((C7251a) this.f12865i, this.f12866j);
                }
                this.f12859c.mo22618a(true);
                if (!this.f12865i.mo22402c()) {
                    if (m14314t() && this.f12863g.mo23311n()) {
                        m14294d((C7251a) this.f12865i);
                    }
                    mo22506m();
                    return;
                }
                return;
            }
            mo22494a("AdView was null");
        }
    }

    /* renamed from: w */
    private void m14320w() {
        if (this.f12844H != null) {
            this.f12839C = mo22498e();
            this.f12844H.stopPlayback();
        }
    }

    /* renamed from: x */
    private boolean m14323x() {
        return this.f12877u;
    }

    /* renamed from: y */
    private void m14324y() {
        this.f12864h.mo23052b(C7216ub.f13983j, Integer.valueOf(this.f12844H.getCurrentPosition()));
        this.f12864h.mo23052b(C7216ub.f13984k, Boolean.valueOf(true));
        try {
            this.f12856T.mo22687c();
        } catch (Throwable th) {
            this.f12862f.mo22917b("InterActivity", "Unable to pause countdown timers", th);
        }
        this.f12844H.pause();
    }

    /* renamed from: z */
    private void m14326z() {
        long max = Math.max(0, new C7212tb(this.f12864h).mo23264F());
        String str = "InterActivity";
        if (max > 0) {
            C7262l b = this.f12864h.mo23049b();
            StringBuilder sb = new StringBuilder();
            sb.append("Resuming video with delay of ");
            sb.append(max);
            b.mo22918c(str, sb.toString());
            this.f12842F.postDelayed(new C6985X(this), max);
            return;
        }
        this.f12864h.mo23049b().mo22918c(str, "Resuming video immediately");
        m14238A();
    }

    /* renamed from: a */
    public void mo22493a() {
        try {
            this.f12864h.m15057a().mo23004a(this.f12865i, this.f12866j, this.f12858b, this.f12865i.mo22408ja());
            C7171ja.m15275a(this.f12859c.mo22622e(), (C7251a) this.f12865i, (C7267q) this.f12864h);
            if (this.f12861e != null) {
                this.f12861e.mo22886b();
            }
        } catch (Throwable th) {
            this.f12864h.mo23049b().mo22917b("InterActivity", "Encountered error while clicking through video.", th);
        }
    }

    /* renamed from: a */
    public void mo22494a(String str) {
        String str2 = "InterActivity";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Initialized = ");
            sb.append(C7007ja.f13017b);
            sb.append("; CleanedUp = ");
            sb.append(C7007ja.f13018c);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Failed to properly render an Interstitial Activity, due to error: ");
            sb3.append(str);
            Log.e(str2, sb3.toString(), new Throwable(sb2));
            m14291c((C7251a) new C7052D());
        } catch (Exception e) {
            Log.e(str2, "Failed to show a video ad due to error:", e);
        }
        finish();
    }

    /* renamed from: b */
    public void mo22495b() {
        m14238A();
    }

    /* renamed from: c */
    public void mo22496c() {
        long currentTimeMillis = System.currentTimeMillis() - this.f12837A;
        C7262l lVar = this.f12862f;
        StringBuilder sb = new StringBuilder();
        sb.append("Dismissing ad after ");
        sb.append(currentTimeMillis);
        sb.append(" milliseconds elapsed");
        lVar.mo22920d("InterActivity", sb.toString());
        ((C6988a) this.f12858b.getAdViewController()).mo22584b(true);
        m14249I();
        m14239B();
        if (this.f12859c != null) {
            if (this.f12865i != null) {
                m14291c((C7251a) this.f12865i);
                C7086Lb lb = this.f12861e;
                if (lb != null) {
                    lb.mo22888c();
                    this.f12861e = null;
                }
            }
            this.f12859c.mo22618a(false);
            this.f12859c.mo22625h();
        }
        finish();
    }

    /* renamed from: d */
    public boolean mo22497d() {
        return this.f12875s;
    }

    /* renamed from: e */
    public int mo22498e() {
        if (this.f12868l) {
            return 100;
        }
        C7023ra raVar = this.f12844H;
        if (raVar != null) {
            int duration = raVar.getDuration();
            if (duration <= 0) {
                return this.f12839C;
            }
            double currentPosition = (double) this.f12844H.getCurrentPosition();
            double d = (double) duration;
            Double.isNaN(currentPosition);
            Double.isNaN(d);
            return (int) ((currentPosition / d) * 100.0d);
        }
        this.f12862f.mo22916b("InterActivity", "No video view detected on video end");
        return 0;
    }

    /* renamed from: f */
    public void mo22499f() {
        String str;
        C7262l lVar;
        String str2 = "InterActivity";
        if (this.f12840D.compareAndSet(false, true)) {
            if (this.f12863g.mo23288ba()) {
                this.f12862f.mo22916b(str2, "Handling media player error - Finishing activity...");
                finish();
            } else {
                this.f12862f.mo22916b(str2, "Handling media player error - Showing poststitial...");
                mo22506m();
            }
            lVar = this.f12862f;
            str = "Finished handling media player error.";
        } else {
            lVar = this.f12862f;
            str = "Already handled media player error. Doing nothing...";
        }
        lVar.mo22916b(str2, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public boolean mo22500g() {
        return mo22498e() >= this.f12865i.mo23404J();
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public boolean mo22501h() {
        return this.f12865i instanceof C6925a;
    }

    /* renamed from: i */
    public void mo22502i() {
        C7197pc pcVar = this.f12857U;
        if (pcVar != null) {
            pcVar.mo23229a();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void mo22503j() {
        m14294d((C7251a) this.f12865i);
        this.f12844H.start();
        this.f12856T.mo22684a();
    }

    /* renamed from: k */
    public void mo22504k() {
        C7197pc pcVar = this.f12857U;
        if (pcVar != null) {
            pcVar.mo23230b();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public boolean mo22505l() {
        return !this.f12868l && !this.f12875s;
    }

    /* renamed from: m */
    public void mo22506m() {
        long j;
        C7016o oVar;
        String str = "InterActivity";
        try {
            this.f12861e.mo22893g();
            if (!this.f12865i.mo23411Q()) {
                m14320w();
            }
            if (this.f12858b != null) {
                ViewParent parent = this.f12858b.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f12858b);
                }
                FrameLayout frameLayout = new FrameLayout(this);
                frameLayout.setLayoutParams(new LayoutParams(-1, -1));
                frameLayout.setBackgroundColor(this.f12865i.mo23398D());
                frameLayout.addView(this.f12858b);
                if (this.f12865i.mo23417W()) {
                    this.f12858b.mo18299a((C7251a) this.f12865i, this.f12866j);
                }
                if (this.f12865i.mo23411Q()) {
                    m14320w();
                }
                if (this.f12843G != null) {
                    this.f12843G.removeAllViewsInLayout();
                }
                if (m14256P() && this.f12846J != null) {
                    if (this.f12846J.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.f12846J.getParent()).removeView(this.f12846J);
                    }
                    frameLayout.addView(this.f12846J);
                    this.f12846J.bringToFront();
                }
                if (this.f12845I != null) {
                    ViewParent parent2 = this.f12845I.getParent();
                    if (parent2 instanceof ViewGroup) {
                        ((ViewGroup) parent2).removeView(this.f12845I);
                    }
                    frameLayout.addView(this.f12845I);
                    this.f12845I.bringToFront();
                }
                setContentView(frameLayout);
                if (this.f12863g.mo23305k()) {
                    this.f12858b.setVisibility(4);
                    this.f12858b.setVisibility(0);
                }
                int K = this.f12865i.mo23405K();
                if (K >= 0) {
                    this.f12842F.postDelayed(new C6984W(this), (long) K);
                }
            }
            if (!(this.f12865i instanceof C7043Ac ? ((C7043Ac) this.f12865i).mo22744sa() : false)) {
                if (this.f12865i.mo23435ma() >= 0.0f) {
                    j = C7209sc.m15484c(this.f12865i.mo23435ma());
                    oVar = this.f12845I;
                } else if (this.f12865i.mo23435ma() == -2.0f) {
                    this.f12845I.setVisibility(0);
                } else {
                    j = 0;
                    oVar = this.f12845I;
                }
                m14271a(j, oVar);
            } else {
                this.f12862f.mo22918c(str, "Skip showing of close button");
            }
            this.f12875s = true;
        } catch (Throwable th) {
            this.f12862f.mo22917b(str, "Encountered error while showing poststitial. Dismissing...", th);
            mo22496c();
        }
    }

    /* renamed from: n */
    public void mo22507n() {
        C7086Lb lb = this.f12861e;
        if (lb != null) {
            lb.mo22892f();
        }
        if (this.f12865i.mo23438s()) {
            mo22496c();
        } else {
            mo22506m();
        }
    }

    /* renamed from: o */
    public void mo22508o() {
        boolean z = !m14323x();
        try {
            m14287b(z);
            m14279a(z);
        } catch (Throwable th) {
            C7262l lVar = this.f12862f;
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to set volume to ");
            sb.append(z);
            lVar.mo22917b("InterActivity", sb.toString(), th);
        }
    }

    public void onBackPressed() {
        C7016o oVar;
        String str = "InterActivity";
        if (m14245E()) {
            this.f12862f.mo22918c(str, "Back button was pressed; forwarding to Android for handling...");
        } else {
            try {
                if (this.f12876t && this.f12847K != null && this.f12847K.getVisibility() == 0 && this.f12847K.getAlpha() > 0.0f && !this.f12873q) {
                    this.f12862f.mo22918c(str, "Back button was pressed; forwarding as a click to skip button.");
                    oVar = this.f12847K;
                } else if (this.f12845I == null || this.f12845I.getVisibility() != 0 || this.f12845I.getAlpha() <= 0.0f) {
                    this.f12862f.mo22918c(str, "Back button was pressed, but was not eligible for dismissal.");
                    return;
                } else {
                    this.f12862f.mo22918c(str, "Back button was pressed; forwarding as a click to close button.");
                    oVar = this.f12845I;
                }
                oVar.performClick();
                return;
            } catch (Exception e) {
            }
        }
        super.onBackPressed();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != 0 && (this.f12844H instanceof C7013ma) && this.f12851O.get() != null) {
            MediaPlayer mediaPlayer = (MediaPlayer) this.f12851O.get();
            this.f12844H.mo22599a(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x013c A[Catch:{ Throwable -> 0x0177, all -> 0x0175 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0192  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r8) {
        /*
            r7 = this;
            java.lang.String r0 = "InterActivity"
            super.onCreate(r8)
            r8 = 1
            r7.requestWindowFeature(r8)
            android.os.StrictMode$ThreadPolicy r1 = android.os.StrictMode.allowThreadDiskReads()
            android.content.Intent r2 = r7.getIntent()     // Catch:{ Throwable -> 0x0177 }
            java.lang.String r3 = "com.applovin.interstitial.wrapper_id"
            java.lang.String r2 = r2.getStringExtra(r3)     // Catch:{ Throwable -> 0x0177 }
            if (r2 == 0) goto L_0x0172
            boolean r3 = r2.isEmpty()     // Catch:{ Throwable -> 0x0177 }
            if (r3 != 0) goto L_0x0172
            d.b.a.b.ja r2 = p019d.p143b.p144a.p146b.C7007ja.m14432a(r2)     // Catch:{ Throwable -> 0x0177 }
            r7.f12859c = r2     // Catch:{ Throwable -> 0x0177 }
            d.b.a.b.ja r2 = r7.f12859c     // Catch:{ Throwable -> 0x0177 }
            if (r2 != 0) goto L_0x0031
            d.b.a.b.ja r2 = f12836a     // Catch:{ Throwable -> 0x0177 }
            if (r2 == 0) goto L_0x0031
            d.b.a.b.ja r2 = f12836a     // Catch:{ Throwable -> 0x0177 }
            r7.f12859c = r2     // Catch:{ Throwable -> 0x0177 }
        L_0x0031:
            d.b.a.b.ja r2 = r7.f12859c     // Catch:{ Throwable -> 0x0177 }
            if (r2 == 0) goto L_0x015a
            d.b.a.b.ja r2 = r7.f12859c     // Catch:{ Throwable -> 0x0177 }
            d.b.d.a r2 = r2.mo22619b()     // Catch:{ Throwable -> 0x0177 }
            d.b.a.b.ja r3 = r7.f12859c     // Catch:{ Throwable -> 0x0177 }
            d.b.d.q r3 = r3.mo22616a()     // Catch:{ Throwable -> 0x0177 }
            d.b.a.c.c r3 = (p019d.p143b.p144a.p147c.C7142c) r3     // Catch:{ Throwable -> 0x0177 }
            r7.f12864h = r3     // Catch:{ Throwable -> 0x0177 }
            d.b.a.b.ja r3 = r7.f12859c     // Catch:{ Throwable -> 0x0177 }
            d.b.d.q r3 = r3.mo22616a()     // Catch:{ Throwable -> 0x0177 }
            d.b.d.l r3 = r3.mo23049b()     // Catch:{ Throwable -> 0x0177 }
            r7.f12862f = r3     // Catch:{ Throwable -> 0x0177 }
            d.b.a.c.tb r3 = new d.b.a.c.tb     // Catch:{ Throwable -> 0x0177 }
            d.b.a.b.ja r4 = r7.f12859c     // Catch:{ Throwable -> 0x0177 }
            d.b.d.q r4 = r4.mo22616a()     // Catch:{ Throwable -> 0x0177 }
            r3.<init>(r4)     // Catch:{ Throwable -> 0x0177 }
            r7.f12863g = r3     // Catch:{ Throwable -> 0x0177 }
            d.b.a.b.ja r3 = r7.f12859c     // Catch:{ Throwable -> 0x0177 }
            java.lang.String r3 = r3.mo22624g()     // Catch:{ Throwable -> 0x0177 }
            r7.f12866j = r3     // Catch:{ Throwable -> 0x0177 }
            d.b.a.c.Lb r3 = new d.b.a.c.Lb     // Catch:{ Throwable -> 0x0177 }
            d.b.a.c.c r4 = r7.f12864h     // Catch:{ Throwable -> 0x0177 }
            r3.<init>(r2, r4)     // Catch:{ Throwable -> 0x0177 }
            r7.f12861e = r3     // Catch:{ Throwable -> 0x0177 }
            if (r2 == 0) goto L_0x0154
            d.b.a.c.z r2 = (p019d.p143b.p144a.p147c.C7234z) r2     // Catch:{ Throwable -> 0x0177 }
            r3 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r3 = r7.findViewById(r3)     // Catch:{ Throwable -> 0x0177 }
            if (r3 == 0) goto L_0x008f
            boolean r4 = r2.mo22402c()     // Catch:{ Throwable -> 0x0177 }
            if (r4 == 0) goto L_0x008a
            int r4 = r2.mo23397C()     // Catch:{ Throwable -> 0x0177 }
        L_0x0086:
            r3.setBackgroundColor(r4)     // Catch:{ Throwable -> 0x0177 }
            goto L_0x008f
        L_0x008a:
            int r4 = r2.mo23398D()     // Catch:{ Throwable -> 0x0177 }
            goto L_0x0086
        L_0x008f:
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x0177 }
            r7.f12837A = r3     // Catch:{ Throwable -> 0x0177 }
            boolean r3 = r2.mo23441w()     // Catch:{ Throwable -> 0x0177 }
            if (r3 == 0) goto L_0x00a4
            android.view.Window r3 = r7.getWindow()     // Catch:{ Throwable -> 0x0177 }
            r4 = 16777216(0x1000000, float:2.3509887E-38)
            r3.setFlags(r4, r4)     // Catch:{ Throwable -> 0x0177 }
        L_0x00a4:
            java.lang.String r3 = "window"
            java.lang.Object r3 = r7.getSystemService(r3)     // Catch:{ Throwable -> 0x0177 }
            android.view.WindowManager r3 = (android.view.WindowManager) r3     // Catch:{ Throwable -> 0x0177 }
            android.view.Display r3 = r3.getDefaultDisplay()     // Catch:{ Throwable -> 0x0177 }
            int r4 = m14269a(r3)     // Catch:{ Throwable -> 0x0177 }
            int r3 = r3.getRotation()     // Catch:{ Throwable -> 0x0177 }
            r5 = 0
            r6 = 2
            if (r4 != r6) goto L_0x00be
            if (r3 == 0) goto L_0x00cb
        L_0x00be:
            if (r4 != r6) goto L_0x00c2
            if (r3 == r6) goto L_0x00cb
        L_0x00c2:
            if (r4 != r8) goto L_0x00c6
            if (r3 == r8) goto L_0x00cb
        L_0x00c6:
            if (r4 != r8) goto L_0x00cd
            r4 = 3
            if (r3 != r4) goto L_0x00cd
        L_0x00cb:
            r4 = 1
            goto L_0x00ce
        L_0x00cd:
            r4 = 0
        L_0x00ce:
            boolean r2 = r2.mo23444z()     // Catch:{ Throwable -> 0x0177 }
            if (r2 == 0) goto L_0x0100
            int r2 = r7.m14268a(r3, r4)     // Catch:{ Throwable -> 0x0177 }
            r6 = -1
            if (r2 == r6) goto L_0x00f5
            d.b.d.l r3 = r7.f12862f     // Catch:{ Throwable -> 0x0177 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0177 }
            r4.<init>()     // Catch:{ Throwable -> 0x0177 }
            java.lang.String r6 = "Locking activity orientation to current orientation: "
            r4.append(r6)     // Catch:{ Throwable -> 0x0177 }
            r4.append(r2)     // Catch:{ Throwable -> 0x0177 }
            java.lang.String r4 = r4.toString()     // Catch:{ Throwable -> 0x0177 }
            r3.mo22918c(r0, r4)     // Catch:{ Throwable -> 0x0177 }
            r7.setRequestedOrientation(r2)     // Catch:{ Throwable -> 0x0177 }
            goto L_0x0108
        L_0x00f5:
            d.b.d.l r2 = r7.f12862f     // Catch:{ Throwable -> 0x0177 }
            java.lang.String r6 = "Unable to detect current orientation. Locking to targeted orientation..."
            r2.mo22916b(r0, r6)     // Catch:{ Throwable -> 0x0177 }
        L_0x00fc:
            r7.m14284b(r3, r4)     // Catch:{ Throwable -> 0x0177 }
            goto L_0x0108
        L_0x0100:
            d.b.d.l r2 = r7.f12862f     // Catch:{ Throwable -> 0x0177 }
            java.lang.String r6 = "Locking activity orientation to targeted orientation..."
            r2.mo22918c(r0, r6)     // Catch:{ Throwable -> 0x0177 }
            goto L_0x00fc
        L_0x0108:
            com.applovin.adview.b r2 = new com.applovin.adview.b     // Catch:{ Throwable -> 0x0177 }
            d.b.a.c.c r3 = r7.f12864h     // Catch:{ Throwable -> 0x0177 }
            d.b.d.g r4 = p019d.p143b.p150d.C7257g.f14096c     // Catch:{ Throwable -> 0x0177 }
            r2.<init>(r3, r4, r7)     // Catch:{ Throwable -> 0x0177 }
            r7.f12858b = r2     // Catch:{ Throwable -> 0x0177 }
            com.applovin.adview.b r2 = r7.f12858b     // Catch:{ Throwable -> 0x0177 }
            r2.setAutoDestroy(r5)     // Catch:{ Throwable -> 0x0177 }
            com.applovin.adview.b r2 = r7.f12858b     // Catch:{ Throwable -> 0x0177 }
            com.applovin.adview.a r2 = r2.getAdViewController()     // Catch:{ Throwable -> 0x0177 }
            d.b.a.b.a r2 = (p019d.p143b.p144a.p146b.C6988a) r2     // Catch:{ Throwable -> 0x0177 }
            d.b.a.c.Lb r3 = r7.f12861e     // Catch:{ Throwable -> 0x0177 }
            r2.mo22579a(r3)     // Catch:{ Throwable -> 0x0177 }
            d.b.a.b.ja r2 = r7.f12859c     // Catch:{ Throwable -> 0x0177 }
            r2.mo22617a(r7)     // Catch:{ Throwable -> 0x0177 }
            d.b.a.c.tb r2 = r7.f12863g     // Catch:{ Throwable -> 0x0177 }
            boolean r2 = r2.mo23292da()     // Catch:{ Throwable -> 0x0177 }
            r7.f12876t = r2     // Catch:{ Throwable -> 0x0177 }
            android.content.Context r2 = r7.getApplicationContext()     // Catch:{ Throwable -> 0x0177 }
            boolean r2 = p019d.p143b.p144a.p147c.C7182m.m15319a(r2)     // Catch:{ Throwable -> 0x0177 }
            if (r2 != 0) goto L_0x0148
            android.content.Context r2 = r7.getApplicationContext()     // Catch:{ Throwable -> 0x0177 }
            boolean r2 = p019d.p143b.p144a.p147c.C7182m.m15319a(r2)     // Catch:{ Throwable -> 0x0177 }
            if (r2 == 0) goto L_0x0147
            goto L_0x0148
        L_0x0147:
            r8 = 0
        L_0x0148:
            r7.f12882z = r8     // Catch:{ Throwable -> 0x0177 }
            d.b.a.c.aa r8 = new d.b.a.c.aa     // Catch:{ Throwable -> 0x0177 }
            d.b.a.c.c r2 = r7.f12864h     // Catch:{ Throwable -> 0x0177 }
            r8.<init>(r7, r2)     // Catch:{ Throwable -> 0x0177 }
            r7.f12852P = r8     // Catch:{ Throwable -> 0x0177 }
            goto L_0x0188
        L_0x0154:
            java.lang.String r8 = "No current ad found."
        L_0x0156:
            r7.mo22494a(r8)     // Catch:{ Throwable -> 0x0177 }
            goto L_0x0188
        L_0x015a:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0177 }
            r8.<init>()     // Catch:{ Throwable -> 0x0177 }
            java.lang.String r2 = "Wrapper is null; initialized state: "
            r8.append(r2)     // Catch:{ Throwable -> 0x0177 }
            boolean r2 = p019d.p143b.p144a.p146b.C7007ja.f13017b     // Catch:{ Throwable -> 0x0177 }
            java.lang.String r2 = java.lang.Boolean.toString(r2)     // Catch:{ Throwable -> 0x0177 }
            r8.append(r2)     // Catch:{ Throwable -> 0x0177 }
            java.lang.String r8 = r8.toString()     // Catch:{ Throwable -> 0x0177 }
            goto L_0x0156
        L_0x0172:
            java.lang.String r8 = "Wrapper ID is null"
            goto L_0x0156
        L_0x0175:
            r8 = move-exception
            goto L_0x0199
        L_0x0177:
            r8 = move-exception
            d.b.d.l r2 = r7.f12862f     // Catch:{ all -> 0x0175 }
            if (r2 == 0) goto L_0x0183
            d.b.d.l r2 = r7.f12862f     // Catch:{ all -> 0x0175 }
            java.lang.String r3 = "Encountered error during onCreate."
            r2.mo22917b(r0, r3, r8)     // Catch:{ all -> 0x0175 }
        L_0x0183:
            java.lang.String r8 = "An error was encountered during interstitial ad creation."
            r7.mo22494a(r8)     // Catch:{ all -> 0x0175 }
        L_0x0188:
            android.os.StrictMode.setThreadPolicy(r1)
            r7.m14249I()
            d.b.a.c.Lb r8 = r7.f12861e
            if (r8 == 0) goto L_0x0195
            r8.mo22884a()
        L_0x0195:
            r7.m14319v()
            return
        L_0x0199:
            android.os.StrictMode.setThreadPolicy(r1)
            goto L_0x019e
        L_0x019d:
            throw r8
        L_0x019e:
            goto L_0x019d
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p143b.p144a.p146b.C6950D.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004a, code lost:
        if (r4.f12865i != null) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005b, code lost:
        if (r4.f12865i == null) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005d, code lost:
        m14239B();
        m14291c((p019d.p143b.p150d.C7251a) r4.f12865i);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0065, code lost:
        super.onDestroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0068, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDestroy() {
        /*
            r4 = this;
            com.applovin.adview.b r0 = r4.f12858b     // Catch:{ Throwable -> 0x004f }
            r1 = 0
            if (r0 == 0) goto L_0x001f
            com.applovin.adview.b r0 = r4.f12858b     // Catch:{ Throwable -> 0x004f }
            android.view.ViewParent r0 = r0.getParent()     // Catch:{ Throwable -> 0x004f }
            if (r0 == 0) goto L_0x0018
            boolean r2 = r0 instanceof android.view.ViewGroup     // Catch:{ Throwable -> 0x004f }
            if (r2 == 0) goto L_0x0018
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch:{ Throwable -> 0x004f }
            com.applovin.adview.b r2 = r4.f12858b     // Catch:{ Throwable -> 0x004f }
            r0.removeView(r2)     // Catch:{ Throwable -> 0x004f }
        L_0x0018:
            com.applovin.adview.b r0 = r4.f12858b     // Catch:{ Throwable -> 0x004f }
            r0.mo18297a()     // Catch:{ Throwable -> 0x004f }
            r4.f12858b = r1     // Catch:{ Throwable -> 0x004f }
        L_0x001f:
            d.b.a.b.ra r0 = r4.f12844H     // Catch:{ Throwable -> 0x004f }
            if (r0 == 0) goto L_0x002d
            d.b.a.b.ra r0 = r4.f12844H     // Catch:{ Throwable -> 0x004f }
            r0.pause()     // Catch:{ Throwable -> 0x004f }
            d.b.a.b.ra r0 = r4.f12844H     // Catch:{ Throwable -> 0x004f }
            r0.stopPlayback()     // Catch:{ Throwable -> 0x004f }
        L_0x002d:
            d.b.a.b.q r0 = r4.f12856T     // Catch:{ Throwable -> 0x004f }
            if (r0 == 0) goto L_0x0036
            d.b.a.b.q r0 = r4.f12856T     // Catch:{ Throwable -> 0x004f }
            r0.mo22686b()     // Catch:{ Throwable -> 0x004f }
        L_0x0036:
            android.os.Handler r0 = r4.f12842F     // Catch:{ Throwable -> 0x004f }
            if (r0 == 0) goto L_0x003f
            android.os.Handler r0 = r4.f12842F     // Catch:{ Throwable -> 0x004f }
            r0.removeCallbacksAndMessages(r1)     // Catch:{ Throwable -> 0x004f }
        L_0x003f:
            android.os.Handler r0 = r4.f12841E     // Catch:{ Throwable -> 0x004f }
            if (r0 == 0) goto L_0x0048
            android.os.Handler r0 = r4.f12841E     // Catch:{ Throwable -> 0x004f }
            r0.removeCallbacksAndMessages(r1)     // Catch:{ Throwable -> 0x004f }
        L_0x0048:
            d.b.a.c.z r0 = r4.f12865i
            if (r0 == 0) goto L_0x0065
            goto L_0x005d
        L_0x004d:
            r0 = move-exception
            goto L_0x0069
        L_0x004f:
            r0 = move-exception
            d.b.d.l r1 = r4.f12862f     // Catch:{ all -> 0x004d }
            java.lang.String r2 = "InterActivity"
            java.lang.String r3 = "Unable to destroy video view"
            r1.mo22914a(r2, r3, r0)     // Catch:{ all -> 0x004d }
            d.b.a.c.z r0 = r4.f12865i
            if (r0 == 0) goto L_0x0065
        L_0x005d:
            r4.m14239B()
            d.b.a.c.z r0 = r4.f12865i
            r4.m14291c(r0)
        L_0x0065:
            super.onDestroy()
            return
        L_0x0069:
            d.b.a.c.z r1 = r4.f12865i
            if (r1 == 0) goto L_0x0075
            r4.m14239B()
            d.b.a.c.z r1 = r4.f12865i
            r4.m14291c(r1)
        L_0x0075:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p143b.p144a.p146b.C6950D.onDestroy():void");
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.f12862f.mo22918c("InterActivity", "App paused...");
        this.f12838B = System.currentTimeMillis();
        if (!this.f12867k && (this.f12882z || !this.f12860d)) {
            m14324y();
        }
        this.f12859c.mo22618a(false);
        this.f12852P.mo23015a();
        mo22502i();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0068, code lost:
        if (r0 != null) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0095, code lost:
        if (r2 == false) goto L_0x0097;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
            r5 = this;
            super.onResume()
            d.b.d.l r0 = r5.f12862f
            java.lang.String r1 = "InterActivity"
            java.lang.String r2 = "App resumed..."
            r0.mo22918c(r1, r2)
            d.b.a.b.ja r0 = r5.f12859c
            r1 = 1
            r0.mo22618a(r1)
            boolean r0 = r5.f12879w
            if (r0 != 0) goto L_0x009d
            d.b.a.c.Lb r0 = r5.f12861e
            if (r0 == 0) goto L_0x0024
            long r1 = java.lang.System.currentTimeMillis()
            long r3 = r5.f12838B
            long r1 = r1 - r3
            r0.mo22889c(r1)
        L_0x0024:
            d.b.a.c.c r0 = r5.f12864h
            d.b.a.c.ub<java.lang.Boolean> r1 = p019d.p143b.p144a.p147c.C7216ub.f13984k
            r2 = 0
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            java.lang.Object r0 = r0.mo23041a(r1, r3)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r3 = 0
            if (r0 == 0) goto L_0x006b
            d.b.a.c.aa r0 = r5.f12852P
            boolean r0 = r0.mo23018d()
            if (r0 != 0) goto L_0x006b
            boolean r0 = r5.f12875s
            if (r0 != 0) goto L_0x006b
            r5.m14326z()
            d.b.a.c.z r0 = r5.f12865i
            if (r0 == 0) goto L_0x009a
            d.b.a.c.tb r0 = r5.f12863g
            boolean r0 = r0.mo23286aa()
            if (r0 == 0) goto L_0x009a
            d.b.a.c.z r0 = r5.f12865i
            boolean r0 = r0.mo23443y()
            if (r0 != 0) goto L_0x009a
            boolean r0 = r5.f12875s
            if (r0 != 0) goto L_0x009a
            boolean r0 = r5.f12876t
            if (r0 == 0) goto L_0x009a
            d.b.a.b.o r0 = r5.f12847K
            if (r0 == 0) goto L_0x009a
            goto L_0x0097
        L_0x006b:
            d.b.a.c.z r0 = r5.f12865i
            boolean r0 = r0 instanceof p019d.p143b.p144a.p147c.C7043Ac
            if (r0 == 0) goto L_0x0079
            d.b.a.c.z r0 = r5.f12865i
            d.b.a.c.Ac r0 = (p019d.p143b.p144a.p147c.C7043Ac) r0
            boolean r2 = r0.mo22744sa()
        L_0x0079:
            d.b.a.c.z r0 = r5.f12865i
            if (r0 == 0) goto L_0x009a
            d.b.a.c.tb r0 = r5.f12863g
            boolean r0 = r0.mo23286aa()
            if (r0 == 0) goto L_0x009a
            d.b.a.c.z r0 = r5.f12865i
            boolean r0 = r0.mo23442x()
            if (r0 != 0) goto L_0x009a
            boolean r0 = r5.f12875s
            if (r0 == 0) goto L_0x009a
            d.b.a.b.o r0 = r5.f12845I
            if (r0 == 0) goto L_0x009a
            if (r2 != 0) goto L_0x009a
        L_0x0097:
            r5.m14271a(r3, r0)
        L_0x009a:
            r5.mo22504k()
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p143b.p144a.p146b.C6950D.onResume():void");
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        String str = "InterActivity";
        if (z) {
            this.f12862f.mo22918c(str, "Window gained focus");
            try {
                if (!C7182m.m15328f() || !this.f12863g.mo23297g() || !m14242C()) {
                    getWindow().setFlags(Opcodes.ACC_ABSTRACT, Opcodes.ACC_ABSTRACT);
                } else {
                    m14244D();
                    if (this.f12863g.mo23317q() > 0) {
                        this.f12842F.postDelayed(new C6954F(this), this.f12863g.mo23317q());
                    }
                }
                if (this.f12863g.mo23313o() && !this.f12875s) {
                    m14326z();
                    mo22504k();
                }
            } catch (Throwable th) {
                this.f12862f.mo22917b(str, "Setting window flags failed.", th);
            }
        } else {
            this.f12862f.mo22918c(str, "Window lost focus");
            if (this.f12863g.mo23313o() && !this.f12875s) {
                m14324y();
                mo22502i();
            }
        }
        this.f12879w = false;
    }
}
