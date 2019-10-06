package p019d.p273h.p276c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.vungle.warren.p267ui.VungleActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.account.AndroidAccountManagerPersistence;
import p019d.p273h.p274a.C12725c;
import p019d.p273h.p275b.C12733b;
import p019d.p273h.p276c.C12741D.C12742a;
import p019d.p273h.p276c.p277a.C12773b;
import p019d.p273h.p276c.p278b.C12784h;
import p019d.p273h.p276c.p278b.C12787k;
import p019d.p273h.p276c.p278b.C12788l;
import p019d.p273h.p276c.p280d.C12799b;
import p019d.p273h.p276c.p280d.C12800c;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p280d.C12805g;
import p019d.p273h.p276c.p281e.C12811c;
import p019d.p273h.p276c.p281e.C12814f;
import p019d.p273h.p276c.p281e.C12817i;
import p019d.p273h.p276c.p281e.C12820l;
import p019d.p273h.p276c.p281e.C12826q;
import p019d.p273h.p276c.p282f.C12858Z;
import p019d.p273h.p276c.p282f.C12869ea;
import p019d.p273h.p276c.p282f.C12872g;
import p019d.p273h.p276c.p282f.C12874h;
import p019d.p273h.p276c.p282f.C12878j;
import p019d.p273h.p276c.p282f.C12879ja;
import p019d.p273h.p276c.p282f.C12881ka;
import p019d.p273h.p276c.p282f.C12884m;
import p019d.p273h.p276c.p282f.C12890q;
import p019d.p273h.p276c.p283g.C12902a;
import p019d.p273h.p276c.p283g.C12903b;
import p019d.p273h.p276c.p284h.C12908c;
import p019d.p273h.p276c.p284h.C12908c.C12909a;
import p019d.p273h.p276c.p284h.C12913g;
import p019d.p273h.p276c.p284h.C12914h;
import p019d.p273h.p276c.p284h.C12915i;
import p019d.p273h.p276c.p284h.C12916j;
import p019d.p273h.p276c.p284h.C12917k;

/* renamed from: d.h.c.I */
/* compiled from: IronSourceObject */
public class C12747I implements C12890q, C12756c {

    /* renamed from: a */
    private static C12747I f39094a;

    /* renamed from: A */
    private boolean f39095A = false;

    /* renamed from: B */
    private List<C12742a> f39096B;

    /* renamed from: C */
    private String f39097C = null;

    /* renamed from: D */
    private Activity f39098D;

    /* renamed from: E */
    private Set<C12742a> f39099E;

    /* renamed from: F */
    private Set<C12742a> f39100F;

    /* renamed from: G */
    private boolean f39101G = true;

    /* renamed from: H */
    private C12749J f39102H;

    /* renamed from: I */
    private final String f39103I = "sessionDepth";

    /* renamed from: J */
    private int f39104J;

    /* renamed from: K */
    private boolean f39105K;

    /* renamed from: L */
    private boolean f39106L;

    /* renamed from: M */
    private boolean f39107M;

    /* renamed from: N */
    private boolean f39108N;

    /* renamed from: O */
    private boolean f39109O;

    /* renamed from: P */
    private boolean f39110P;

    /* renamed from: Q */
    private C12745G f39111Q;

    /* renamed from: R */
    private String f39112R;

    /* renamed from: S */
    private Boolean f39113S = null;

    /* renamed from: T */
    private C12769Z f39114T;

    /* renamed from: U */
    private C12761T f39115U;

    /* renamed from: V */
    private boolean f39116V;

    /* renamed from: W */
    private boolean f39117W;

    /* renamed from: X */
    private boolean f39118X;

    /* renamed from: b */
    private final String f39119b = getClass().getName();

    /* renamed from: c */
    private final String f39120c = "!SDK-VERSION-STRING!:com.ironsource:mediationsdk:​6.8.3";

    /* renamed from: d */
    private ArrayList<C12775b> f39121d;

    /* renamed from: e */
    private ArrayList<C12775b> f39122e;

    /* renamed from: f */
    private ArrayList<C12775b> f39123f;

    /* renamed from: g */
    private C12775b f39124g;

    /* renamed from: h */
    private C12934na f39125h;

    /* renamed from: i */
    private C12952z f39126i;

    /* renamed from: j */
    private C12758P f39127j;

    /* renamed from: k */
    private C12927l f39128k;

    /* renamed from: l */
    private C12802d f39129l;

    /* renamed from: m */
    private C12858Z f39130m;

    /* renamed from: n */
    private C12805g f39131n;

    /* renamed from: o */
    private AtomicBoolean f39132o;

    /* renamed from: p */
    private final Object f39133p = new Object();

    /* renamed from: q */
    private C12917k f39134q = null;

    /* renamed from: r */
    private String f39135r = null;

    /* renamed from: s */
    private String f39136s = null;

    /* renamed from: t */
    private Integer f39137t = null;

    /* renamed from: u */
    private String f39138u = null;

    /* renamed from: v */
    private String f39139v = null;

    /* renamed from: w */
    private String f39140w = null;

    /* renamed from: x */
    private Map<String, String> f39141x = null;

    /* renamed from: y */
    private String f39142y = null;

    /* renamed from: z */
    private AtomicBoolean f39143z;

    /* renamed from: d.h.c.I$a */
    /* compiled from: IronSourceObject */
    public interface C12748a {
        /* renamed from: a */
        void mo41240a(String str);
    }

    /* renamed from: g */
    public static synchronized C12747I m41186g() {
        C12747I i;
        synchronized (C12747I.class) {
            if (f39094a == null) {
                f39094a = new C12747I();
            }
            i = f39094a;
        }
        return i;
    }

    private C12747I() {
        m41191n();
        this.f39132o = new AtomicBoolean();
        this.f39121d = new ArrayList<>();
        this.f39122e = new ArrayList<>();
        this.f39123f = new ArrayList<>();
        this.f39099E = new HashSet();
        this.f39100F = new HashSet();
        this.f39106L = false;
        this.f39105K = false;
        this.f39143z = new AtomicBoolean(true);
        this.f39104J = 0;
        this.f39107M = false;
        this.f39108N = false;
        this.f39109O = false;
        this.f39097C = UUID.randomUUID().toString();
        this.f39110P = false;
        this.f39118X = false;
        this.f39112R = null;
        this.f39114T = null;
        this.f39115U = null;
        this.f39116V = false;
        this.f39117W = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0146, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007e A[Catch:{ Exception -> 0x00c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008a A[SYNTHETIC, Splitter:B:31:0x008a] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo41206a(android.app.Activity r9, java.lang.String r10, boolean r11, p019d.p273h.p276c.C12741D.C12742a... r12) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f39143z     // Catch:{ all -> 0x0147 }
            if (r0 == 0) goto L_0x0135
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f39143z     // Catch:{ all -> 0x0147 }
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r2, r1)     // Catch:{ all -> 0x0147 }
            if (r0 == 0) goto L_0x0135
            if (r12 == 0) goto L_0x0046
            int r0 = r12.length     // Catch:{ all -> 0x0147 }
            if (r0 != 0) goto L_0x0015
            goto L_0x0046
        L_0x0015:
            int r0 = r12.length     // Catch:{ all -> 0x0147 }
            r3 = 0
        L_0x0017:
            if (r3 >= r0) goto L_0x005f
            r4 = r12[r3]     // Catch:{ all -> 0x0147 }
            java.util.Set<d.h.c.D$a> r5 = r8.f39099E     // Catch:{ all -> 0x0147 }
            r5.add(r4)     // Catch:{ all -> 0x0147 }
            java.util.Set<d.h.c.D$a> r5 = r8.f39100F     // Catch:{ all -> 0x0147 }
            r5.add(r4)     // Catch:{ all -> 0x0147 }
            d.h.c.D$a r5 = p019d.p273h.p276c.C12741D.C12742a.INTERSTITIAL     // Catch:{ all -> 0x0147 }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x0147 }
            if (r5 == 0) goto L_0x002f
            r8.f39108N = r2     // Catch:{ all -> 0x0147 }
        L_0x002f:
            d.h.c.D$a r5 = p019d.p273h.p276c.C12741D.C12742a.BANNER     // Catch:{ all -> 0x0147 }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x0147 }
            if (r5 == 0) goto L_0x0039
            r8.f39109O = r2     // Catch:{ all -> 0x0147 }
        L_0x0039:
            d.h.c.D$a r5 = p019d.p273h.p276c.C12741D.C12742a.REWARDED_VIDEO     // Catch:{ all -> 0x0147 }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x0147 }
            if (r5 == 0) goto L_0x0043
            r8.f39107M = r2     // Catch:{ all -> 0x0147 }
        L_0x0043:
            int r3 = r3 + 1
            goto L_0x0017
        L_0x0046:
            d.h.c.D$a[] r0 = p019d.p273h.p276c.C12741D.C12742a.values()     // Catch:{ all -> 0x0147 }
            int r3 = r0.length     // Catch:{ all -> 0x0147 }
            r4 = 0
        L_0x004c:
            if (r4 >= r3) goto L_0x0059
            r5 = r0[r4]     // Catch:{ all -> 0x0147 }
            java.util.Set<d.h.c.D$a> r6 = r8.f39099E     // Catch:{ all -> 0x0147 }
            r6.add(r5)     // Catch:{ all -> 0x0147 }
            int r4 = r4 + 1
            goto L_0x004c
        L_0x0059:
            r8.f39107M = r2     // Catch:{ all -> 0x0147 }
            r8.f39108N = r2     // Catch:{ all -> 0x0147 }
            r8.f39109O = r2     // Catch:{ all -> 0x0147 }
        L_0x005f:
            d.h.c.d.d r0 = r8.f39129l     // Catch:{ all -> 0x0147 }
            d.h.c.d.c$a r3 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ all -> 0x0147 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0147 }
            r4.<init>()     // Catch:{ all -> 0x0147 }
            java.lang.String r5 = "init(appKey:"
            r4.append(r5)     // Catch:{ all -> 0x0147 }
            r4.append(r10)     // Catch:{ all -> 0x0147 }
            java.lang.String r5 = ")"
            r4.append(r5)     // Catch:{ all -> 0x0147 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0147 }
            r0.mo41427b(r3, r4, r2)     // Catch:{ all -> 0x0147 }
            if (r9 != 0) goto L_0x008a
            d.h.c.d.d r0 = r8.f39129l     // Catch:{ all -> 0x0147 }
            d.h.c.d.c$a r1 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ all -> 0x0147 }
            java.lang.String r2 = "Init Fail - provided activity is null"
            r3 = 2
            r0.mo41427b(r1, r2, r3)     // Catch:{ all -> 0x0147 }
            monitor-exit(r8)
            return
        L_0x008a:
            r8.f39098D = r9     // Catch:{ all -> 0x0147 }
            r8.m41185c(r9)     // Catch:{ all -> 0x0147 }
            d.h.c.a.b r0 = r8.m41193o(r10)     // Catch:{ all -> 0x0147 }
            boolean r3 = r0.mo41315b()     // Catch:{ all -> 0x0147 }
            if (r3 == 0) goto L_0x00f9
            r8.f39135r = r10     // Catch:{ all -> 0x0147 }
            boolean r3 = r8.f39101G     // Catch:{ all -> 0x0147 }
            if (r3 == 0) goto L_0x00d5
            org.json.JSONObject r3 = p019d.p273h.p276c.p284h.C12916j.m41965a(r11)     // Catch:{ all -> 0x0147 }
            if (r12 == 0) goto L_0x00b6
            int r4 = r12.length     // Catch:{ Exception -> 0x00c1 }
            r5 = 0
        L_0x00a7:
            if (r5 >= r4) goto L_0x00b6
            r6 = r12[r5]     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r7 = r6.toString()     // Catch:{ Exception -> 0x00c1 }
            r3.put(r7, r2)     // Catch:{ Exception -> 0x00c1 }
            int r5 = r5 + 1
            goto L_0x00a7
        L_0x00b6:
            java.lang.String r4 = "sessionDepth"
            int r5 = r8.f39104J     // Catch:{ Exception -> 0x00c1 }
            int r5 = r5 + r2
            r8.f39104J = r5     // Catch:{ Exception -> 0x00c1 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00c1 }
            goto L_0x00c5
        L_0x00c1:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x0147 }
        L_0x00c5:
            d.h.b.b r2 = new d.h.b.b     // Catch:{ all -> 0x0147 }
            r4 = 14
            r2.<init>(r4, r3)     // Catch:{ all -> 0x0147 }
            d.h.c.b.k r4 = p019d.p273h.p276c.p278b.C12787k.m41517g()     // Catch:{ all -> 0x0147 }
            r4.mo41369d(r2)     // Catch:{ all -> 0x0147 }
            r8.f39101G = r1     // Catch:{ all -> 0x0147 }
        L_0x00d5:
            java.util.Set<d.h.c.D$a> r1 = r8.f39099E     // Catch:{ all -> 0x0147 }
            d.h.c.D$a r2 = p019d.p273h.p276c.C12741D.C12742a.INTERSTITIAL     // Catch:{ all -> 0x0147 }
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0147 }
            if (r1 == 0) goto L_0x00e8
            d.h.c.N r1 = p019d.p273h.p276c.C12753N.m41255b()     // Catch:{ all -> 0x0147 }
            d.h.c.z r2 = r8.f39126i     // Catch:{ all -> 0x0147 }
            r1.mo41249a(r2)     // Catch:{ all -> 0x0147 }
        L_0x00e8:
            d.h.c.N r1 = p019d.p273h.p276c.C12753N.m41255b()     // Catch:{ all -> 0x0147 }
            r1.mo41249a(r8)     // Catch:{ all -> 0x0147 }
            d.h.c.N r1 = p019d.p273h.p276c.C12753N.m41255b()     // Catch:{ all -> 0x0147 }
            java.lang.String r2 = r8.f39136s     // Catch:{ all -> 0x0147 }
            r1.mo41248a(r9, r10, r2, r12)     // Catch:{ all -> 0x0147 }
            goto L_0x0145
        L_0x00f9:
            d.h.c.N r3 = p019d.p273h.p276c.C12753N.m41255b()     // Catch:{ all -> 0x0147 }
            r3.mo41251d()     // Catch:{ all -> 0x0147 }
            java.util.Set<d.h.c.D$a> r3 = r8.f39099E     // Catch:{ all -> 0x0147 }
            d.h.c.D$a r4 = p019d.p273h.p276c.C12741D.C12742a.REWARDED_VIDEO     // Catch:{ all -> 0x0147 }
            boolean r3 = r3.contains(r4)     // Catch:{ all -> 0x0147 }
            if (r3 == 0) goto L_0x010f
            d.h.c.f.Z r3 = r8.f39130m     // Catch:{ all -> 0x0147 }
            r3.mo41616a(r1)     // Catch:{ all -> 0x0147 }
        L_0x010f:
            java.util.Set<d.h.c.D$a> r3 = r8.f39099E     // Catch:{ all -> 0x0147 }
            d.h.c.D$a r4 = p019d.p273h.p276c.C12741D.C12742a.OFFERWALL     // Catch:{ all -> 0x0147 }
            boolean r3 = r3.contains(r4)     // Catch:{ all -> 0x0147 }
            if (r3 == 0) goto L_0x0122
            d.h.c.f.Z r3 = r8.f39130m     // Catch:{ all -> 0x0147 }
            d.h.c.d.b r4 = r0.mo41313a()     // Catch:{ all -> 0x0147 }
            r3.mo41254a(r1, r4)     // Catch:{ all -> 0x0147 }
        L_0x0122:
            d.h.c.d.d r1 = p019d.p273h.p276c.p280d.C12802d.m41613c()     // Catch:{ all -> 0x0147 }
            d.h.c.d.c$a r3 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ all -> 0x0147 }
            d.h.c.d.b r4 = r0.mo41313a()     // Catch:{ all -> 0x0147 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0147 }
            r1.mo41427b(r3, r4, r2)     // Catch:{ all -> 0x0147 }
            monitor-exit(r8)
            return
        L_0x0135:
            if (r12 == 0) goto L_0x013b
            r8.m41180a(r11, r12)     // Catch:{ all -> 0x0147 }
            goto L_0x0145
        L_0x013b:
            d.h.c.d.d r0 = r8.f39129l     // Catch:{ all -> 0x0147 }
            d.h.c.d.c$a r1 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ all -> 0x0147 }
            java.lang.String r2 = "Multiple calls to init without ad units are not allowed"
            r3 = 3
            r0.mo41427b(r1, r2, r3)     // Catch:{ all -> 0x0147 }
        L_0x0145:
            monitor-exit(r8)
            return
        L_0x0147:
            r9 = move-exception
            monitor-exit(r8)
            goto L_0x014b
        L_0x014a:
            throw r9
        L_0x014b:
            goto L_0x014a
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12747I.mo41206a(android.app.Activity, java.lang.String, boolean, d.h.c.D$a[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00db, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo41207a(android.app.Activity r11, java.lang.String r12, p019d.p273h.p276c.C12741D.C12742a... r13) {
        /*
            r10 = this;
            monitor-enter(r10)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00dc }
            r0.<init>()     // Catch:{ all -> 0x00dc }
            r1 = 3
            if (r13 != 0) goto L_0x0014
            d.h.c.d.d r2 = r10.f39129l     // Catch:{ all -> 0x00dc }
            d.h.c.d.c$a r3 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = "Cannot initialized demand only mode: No ad units selected"
            r2.mo41427b(r3, r4, r1)     // Catch:{ all -> 0x00dc }
            monitor-exit(r10)
            return
        L_0x0014:
            int r2 = r13.length     // Catch:{ all -> 0x00dc }
            if (r2 > 0) goto L_0x0022
            d.h.c.d.d r2 = r10.f39129l     // Catch:{ all -> 0x00dc }
            d.h.c.d.c$a r3 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = "Cannot initialized demand only mode: No ad units selected"
            r2.mo41427b(r3, r4, r1)     // Catch:{ all -> 0x00dc }
            monitor-exit(r10)
            return
        L_0x0022:
            int r2 = r13.length     // Catch:{ all -> 0x00dc }
            r3 = 0
        L_0x0024:
            r4 = 1
            if (r3 >= r2) goto L_0x00c4
            r5 = r13[r3]     // Catch:{ all -> 0x00dc }
            d.h.c.D$a r6 = p019d.p273h.p276c.C12741D.C12742a.BANNER     // Catch:{ all -> 0x00dc }
            boolean r6 = r5.equals(r6)     // Catch:{ all -> 0x00dc }
            if (r6 != 0) goto L_0x00a7
            d.h.c.D$a r6 = p019d.p273h.p276c.C12741D.C12742a.OFFERWALL     // Catch:{ all -> 0x00dc }
            boolean r6 = r5.equals(r6)     // Catch:{ all -> 0x00dc }
            if (r6 == 0) goto L_0x003a
            goto L_0x00a7
        L_0x003a:
            d.h.c.D$a r6 = p019d.p273h.p276c.C12741D.C12742a.INTERSTITIAL     // Catch:{ all -> 0x00dc }
            boolean r6 = r5.equals(r6)     // Catch:{ all -> 0x00dc }
            if (r6 == 0) goto L_0x0070
            boolean r6 = r10.f39108N     // Catch:{ all -> 0x00dc }
            if (r6 == 0) goto L_0x005f
            d.h.c.d.d r6 = r10.f39129l     // Catch:{ all -> 0x00dc }
            d.h.c.d.c$a r7 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ all -> 0x00dc }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dc }
            r8.<init>()     // Catch:{ all -> 0x00dc }
            r8.append(r5)     // Catch:{ all -> 0x00dc }
            java.lang.String r9 = " ad unit has already been initialized"
            r8.append(r9)     // Catch:{ all -> 0x00dc }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00dc }
            r6.mo41427b(r7, r8, r1)     // Catch:{ all -> 0x00dc }
            goto L_0x0070
        L_0x005f:
            r10.f39108N = r4     // Catch:{ all -> 0x00dc }
            r10.f39106L = r4     // Catch:{ all -> 0x00dc }
            d.h.c.z r6 = r10.f39126i     // Catch:{ all -> 0x00dc }
            r6.f39276v = r4     // Catch:{ all -> 0x00dc }
            boolean r6 = r0.contains(r5)     // Catch:{ all -> 0x00dc }
            if (r6 != 0) goto L_0x0070
            r0.add(r5)     // Catch:{ all -> 0x00dc }
        L_0x0070:
            d.h.c.D$a r6 = p019d.p273h.p276c.C12741D.C12742a.REWARDED_VIDEO     // Catch:{ all -> 0x00dc }
            boolean r6 = r5.equals(r6)     // Catch:{ all -> 0x00dc }
            if (r6 == 0) goto L_0x00c0
            boolean r6 = r10.f39107M     // Catch:{ all -> 0x00dc }
            if (r6 == 0) goto L_0x0095
            d.h.c.d.d r4 = r10.f39129l     // Catch:{ all -> 0x00dc }
            d.h.c.d.c$a r6 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ all -> 0x00dc }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dc }
            r7.<init>()     // Catch:{ all -> 0x00dc }
            r7.append(r5)     // Catch:{ all -> 0x00dc }
            java.lang.String r8 = " ad unit has already been initialized"
            r7.append(r8)     // Catch:{ all -> 0x00dc }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00dc }
            r4.mo41427b(r6, r7, r1)     // Catch:{ all -> 0x00dc }
            goto L_0x00c0
        L_0x0095:
            r10.f39107M = r4     // Catch:{ all -> 0x00dc }
            r10.f39105K = r4     // Catch:{ all -> 0x00dc }
            d.h.c.na r6 = r10.f39125h     // Catch:{ all -> 0x00dc }
            r6.f39276v = r4     // Catch:{ all -> 0x00dc }
            boolean r4 = r0.contains(r5)     // Catch:{ all -> 0x00dc }
            if (r4 != 0) goto L_0x00c0
            r0.add(r5)     // Catch:{ all -> 0x00dc }
            goto L_0x00c0
        L_0x00a7:
            d.h.c.d.d r4 = r10.f39129l     // Catch:{ all -> 0x00dc }
            d.h.c.d.c$a r6 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ all -> 0x00dc }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dc }
            r7.<init>()     // Catch:{ all -> 0x00dc }
            r7.append(r5)     // Catch:{ all -> 0x00dc }
            java.lang.String r8 = " ad unit cannot be initialized in demand only mode"
            r7.append(r8)     // Catch:{ all -> 0x00dc }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00dc }
            r4.mo41427b(r6, r7, r1)     // Catch:{ all -> 0x00dc }
        L_0x00c0:
            int r3 = r3 + 1
            goto L_0x0024
        L_0x00c4:
            int r1 = r0.size()     // Catch:{ all -> 0x00dc }
            if (r1 <= 0) goto L_0x00da
            int r1 = r0.size()     // Catch:{ all -> 0x00dc }
            d.h.c.D$a[] r1 = new p019d.p273h.p276c.C12741D.C12742a[r1]     // Catch:{ all -> 0x00dc }
            java.lang.Object[] r2 = r0.toArray(r1)     // Catch:{ all -> 0x00dc }
            d.h.c.D$a[] r2 = (p019d.p273h.p276c.C12741D.C12742a[]) r2     // Catch:{ all -> 0x00dc }
            r1 = r2
            r10.mo41206a(r11, r12, r4, r1)     // Catch:{ all -> 0x00dc }
        L_0x00da:
            monitor-exit(r10)
            return
        L_0x00dc:
            r11 = move-exception
            monitor-exit(r10)
            goto L_0x00e0
        L_0x00df:
            throw r11
        L_0x00e0:
            goto L_0x00df
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12747I.mo41207a(android.app.Activity, java.lang.String, d.h.c.D$a[]):void");
    }

    /* renamed from: a */
    private synchronized void m41180a(boolean isDemandOnlyInit, C12742a... adUnits) {
        int i = 0;
        for (C12742a adUnit : adUnits) {
            if (adUnit.equals(C12742a.INTERSTITIAL)) {
                this.f39108N = true;
            } else if (adUnit.equals(C12742a.BANNER)) {
                this.f39109O = true;
            }
        }
        if (C12753N.m41255b().mo41247a() == C12754a.INIT_FAILED) {
            try {
                if (this.f39130m != null) {
                    int length = adUnits.length;
                    while (i < length) {
                        C12742a adUnit2 = adUnits[i];
                        if (!this.f39099E.contains(adUnit2)) {
                            m41177a(adUnit2, true);
                        }
                        i++;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (!this.f39095A) {
            JSONObject data = C12916j.m41965a(isDemandOnlyInit);
            boolean shouldSentInstanceEvent = false;
            int length2 = adUnits.length;
            while (i < length2) {
                C12742a adUnit3 = adUnits[i];
                if (!this.f39099E.contains(adUnit3)) {
                    shouldSentInstanceEvent = true;
                    this.f39099E.add(adUnit3);
                    this.f39100F.add(adUnit3);
                    try {
                        data.put(adUnit3.toString(), true);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    C12802d dVar = this.f39129l;
                    C12801a aVar = C12801a.API;
                    StringBuilder sb = new StringBuilder();
                    sb.append(adUnit3);
                    sb.append(" ad unit has started initializing.");
                    dVar.mo41427b(aVar, sb.toString(), 3);
                }
                i++;
            }
            if (shouldSentInstanceEvent) {
                String str = "sessionDepth";
                try {
                    int i2 = this.f39104J + 1;
                    this.f39104J = i2;
                    data.put(str, i2);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                C12787k.m41517g().mo41369d(new C12733b(14, data));
            }
        } else if (this.f39096B != null) {
            JSONObject data2 = C12916j.m41965a(isDemandOnlyInit);
            boolean shouldSentInstanceEvent2 = false;
            for (C12742a adUnit4 : adUnits) {
                if (!this.f39099E.contains(adUnit4)) {
                    shouldSentInstanceEvent2 = true;
                    this.f39099E.add(adUnit4);
                    this.f39100F.add(adUnit4);
                    try {
                        data2.put(adUnit4.toString(), true);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    if (this.f39096B == null || !this.f39096B.contains(adUnit4)) {
                        m41177a(adUnit4, false);
                    } else {
                        m41176a(adUnit4);
                    }
                } else {
                    C12802d dVar2 = this.f39129l;
                    C12801a aVar2 = C12801a.API;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(adUnit4);
                    sb2.append(" ad unit has already been initialized");
                    dVar2.mo41427b(aVar2, sb2.toString(), 3);
                }
            }
            if (shouldSentInstanceEvent2) {
                String str2 = "sessionDepth";
                try {
                    int i3 = this.f39104J + 1;
                    this.f39104J = i3;
                    data2.put(str2, i3);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                C12787k.m41517g().mo41369d(new C12733b(14, data2));
            }
        }
    }

    /* renamed from: a */
    public void mo41214a(List<C12742a> adUnits, boolean revived) {
        C12742a[] values;
        try {
            this.f39096B = adUnits;
            this.f39095A = true;
            this.f39129l.mo41427b(C12801a.API, "onInitSuccess()", 1);
            C12916j.m41981c("init success");
            if (revived) {
                JSONObject data = C12916j.m41965a(false);
                try {
                    data.put("revived", true);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                C12787k.m41517g().mo41369d(new C12733b(114, data));
            }
            C12784h.m41502g().mo41372f();
            C12787k.m41517g().mo41372f();
            for (C12742a adUnit : C12742a.values()) {
                if (this.f39099E.contains(adUnit)) {
                    if (adUnits.contains(adUnit)) {
                        m41176a(adUnit);
                    } else {
                        m41177a(adUnit, false);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m41176a(C12742a adUnit) {
        int i = C12746H.f39092a[adUnit.ordinal()];
        if (i == 1) {
            m41202w();
        } else if (i == 2) {
            m41199t();
        } else if (i == 3) {
            this.f39127j.mo41252a(this.f39098D, mo41232h(), mo41234i());
        } else if (i == 4) {
            m41198s();
        }
    }

    /* renamed from: v */
    private void m41201v() {
        this.f39129l.mo41427b(C12801a.INTERNAL, "Rewarded Video started in programmatic mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f39134q.mo41694c().mo41528e().size(); i++) {
            String provider = (String) this.f39134q.mo41694c().mo41528e().get(i);
            if (!TextUtils.isEmpty(provider)) {
                arrayList.add(this.f39134q.mo41695d().mo41560b(provider));
            }
        }
        if (arrayList.size() > 0) {
            C12769Z z = new C12769Z(this.f39098D, arrayList, this.f39134q.mo41692a().mo41482e(), mo41232h(), mo41234i());
            this.f39114T = z;
            return;
        }
        m41177a(C12742a.REWARDED_VIDEO, false);
    }

    /* renamed from: w */
    private void m41202w() {
        if (this.f39116V) {
            m41201v();
            return;
        }
        if (this.f39105K) {
            this.f39129l.mo41427b(C12801a.INTERNAL, "Rewarded Video started in Demand Only mode", 0);
        }
        int rewardedVideoTimeout = this.f39134q.mo41692a().mo41482e().mo41570f();
        for (int i = 0; i < this.f39134q.mo41694c().mo41528e().size(); i++) {
            String provider = (String) this.f39134q.mo41694c().mo41528e().get(i);
            if (!TextUtils.isEmpty(provider)) {
                C12826q providerSettings = this.f39134q.mo41695d().mo41560b(provider);
                if (providerSettings != null) {
                    C12938pa smash = new C12938pa(providerSettings, rewardedVideoTimeout);
                    if (m41181a((C12791c) smash)) {
                        smash.mo41757a((C12881ka) this.f39125h);
                        smash.mo41391b(i + 1);
                        this.f39125h.mo41299a((C12791c) smash);
                    }
                }
            }
        }
        if (this.f39125h.f39263i.size() > 0) {
            this.f39125h.mo41743c(this.f39134q.mo41692a().mo41482e().mo41572h().mo41469h());
            this.f39125h.mo41297a(this.f39134q.mo41692a().mo41482e().mo41569e());
            this.f39125h.mo41741b(this.f39134q.mo41692a().mo41482e().mo41566c());
            String backfillProvider = this.f39134q.mo41696e();
            if (!TextUtils.isEmpty(backfillProvider)) {
                C12826q providerSettings2 = this.f39134q.mo41695d().mo41560b(backfillProvider);
                if (providerSettings2 != null) {
                    C12938pa backfillSmash = new C12938pa(providerSettings2, rewardedVideoTimeout);
                    if (m41181a((C12791c) backfillSmash)) {
                        backfillSmash.mo41757a((C12881ka) this.f39125h);
                        this.f39125h.mo41303c(backfillSmash);
                    }
                }
            }
            String premiumProvider = this.f39134q.mo41697f();
            if (!TextUtils.isEmpty(premiumProvider)) {
                C12826q providerSettings3 = this.f39134q.mo41695d().mo41560b(premiumProvider);
                if (providerSettings3 != null) {
                    C12938pa premiumSmash = new C12938pa(providerSettings3, rewardedVideoTimeout);
                    if (m41181a((C12791c) premiumSmash)) {
                        premiumSmash.mo41757a((C12881ka) this.f39125h);
                        this.f39125h.mo41308e(premiumSmash);
                    }
                }
            }
            this.f39125h.mo41736a(this.f39098D, mo41232h(), mo41234i());
        } else {
            m41177a(C12742a.REWARDED_VIDEO, false);
        }
    }

    /* renamed from: u */
    private void m41200u() {
        this.f39129l.mo41427b(C12801a.INTERNAL, "Interstitial started in programmatic mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f39134q.mo41694c().mo41522b().size(); i++) {
            String provider = (String) this.f39134q.mo41694c().mo41522b().get(i);
            if (!TextUtils.isEmpty(provider)) {
                arrayList.add(this.f39134q.mo41695d().mo41560b(provider));
            }
        }
        if (arrayList.size() > 0) {
            C12761T t = new C12761T(this.f39098D, arrayList, this.f39134q.mo41692a().mo41480c(), mo41232h(), mo41234i());
            this.f39115U = t;
            if (this.f39118X) {
                this.f39118X = false;
                this.f39115U.mo41263a();
                return;
            }
            return;
        }
        m41177a(C12742a.INTERSTITIAL, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c8, code lost:
        return;
     */
    /* renamed from: t */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m41199t() {
        /*
            r7 = this;
            monitor-enter(r7)
            d.h.c.h.k r0 = r7.f39134q     // Catch:{ all -> 0x00c9 }
            d.h.c.e.g r0 = r0.mo41692a()     // Catch:{ all -> 0x00c9 }
            d.h.c.e.h r0 = r0.mo41480c()     // Catch:{ all -> 0x00c9 }
            d.h.c.h.a r0 = r0.mo41491e()     // Catch:{ all -> 0x00c9 }
            boolean r0 = r0.mo41680d()     // Catch:{ all -> 0x00c9 }
            r7.f39117W = r0     // Catch:{ all -> 0x00c9 }
            boolean r0 = r7.f39117W     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x001e
            r7.m41200u()     // Catch:{ all -> 0x00c9 }
            monitor-exit(r7)
            return
        L_0x001e:
            boolean r0 = r7.f39106L     // Catch:{ all -> 0x00c9 }
            r1 = 0
            if (r0 == 0) goto L_0x002c
            d.h.c.d.d r0 = r7.f39129l     // Catch:{ all -> 0x00c9 }
            d.h.c.d.c$a r2 = p019d.p273h.p276c.p280d.C12800c.C12801a.INTERNAL     // Catch:{ all -> 0x00c9 }
            java.lang.String r3 = "Interstitial started in Demand Only mode"
            r0.mo41427b(r2, r3, r1)     // Catch:{ all -> 0x00c9 }
        L_0x002c:
            d.h.c.h.k r0 = r7.f39134q     // Catch:{ all -> 0x00c9 }
            d.h.c.e.g r0 = r0.mo41692a()     // Catch:{ all -> 0x00c9 }
            d.h.c.e.h r0 = r0.mo41480c()     // Catch:{ all -> 0x00c9 }
            int r0 = r0.mo41490d()     // Catch:{ all -> 0x00c9 }
            r2 = r1
        L_0x003b:
            d.h.c.h.k r3 = r7.f39134q     // Catch:{ all -> 0x00c9 }
            d.h.c.e.p r3 = r3.mo41694c()     // Catch:{ all -> 0x00c9 }
            java.util.ArrayList r3 = r3.mo41522b()     // Catch:{ all -> 0x00c9 }
            int r3 = r3.size()     // Catch:{ all -> 0x00c9 }
            if (r2 >= r3) goto L_0x008a
            d.h.c.h.k r3 = r7.f39134q     // Catch:{ all -> 0x00c9 }
            d.h.c.e.p r3 = r3.mo41694c()     // Catch:{ all -> 0x00c9 }
            java.util.ArrayList r3 = r3.mo41522b()     // Catch:{ all -> 0x00c9 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x00c9 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00c9 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00c9 }
            if (r4 != 0) goto L_0x0087
            d.h.c.h.k r4 = r7.f39134q     // Catch:{ all -> 0x00c9 }
            d.h.c.e.r r4 = r4.mo41695d()     // Catch:{ all -> 0x00c9 }
            d.h.c.e.q r4 = r4.mo41560b(r3)     // Catch:{ all -> 0x00c9 }
            if (r4 == 0) goto L_0x0087
            d.h.c.C r5 = new d.h.c.C     // Catch:{ all -> 0x00c9 }
            r5.<init>(r4, r0)     // Catch:{ all -> 0x00c9 }
            boolean r6 = r7.m41181a(r5)     // Catch:{ all -> 0x00c9 }
            if (r6 == 0) goto L_0x0087
            d.h.c.z r6 = r7.f39126i     // Catch:{ all -> 0x00c9 }
            r5.mo41175a(r6)     // Catch:{ all -> 0x00c9 }
            int r6 = r2 + 1
            r5.mo41391b(r6)     // Catch:{ all -> 0x00c9 }
            d.h.c.z r6 = r7.f39126i     // Catch:{ all -> 0x00c9 }
            r6.mo41299a(r5)     // Catch:{ all -> 0x00c9 }
        L_0x0087:
            int r2 = r2 + 1
            goto L_0x003b
        L_0x008a:
            d.h.c.z r2 = r7.f39126i     // Catch:{ all -> 0x00c9 }
            java.util.concurrent.CopyOnWriteArrayList<d.h.c.c> r2 = r2.f39263i     // Catch:{ all -> 0x00c9 }
            int r2 = r2.size()     // Catch:{ all -> 0x00c9 }
            if (r2 <= 0) goto L_0x00c2
            d.h.c.h.k r2 = r7.f39134q     // Catch:{ all -> 0x00c9 }
            d.h.c.e.g r2 = r2.mo41692a()     // Catch:{ all -> 0x00c9 }
            d.h.c.e.h r2 = r2.mo41480c()     // Catch:{ all -> 0x00c9 }
            int r2 = r2.mo41488c()     // Catch:{ all -> 0x00c9 }
            d.h.c.z r3 = r7.f39126i     // Catch:{ all -> 0x00c9 }
            r3.mo41297a(r2)     // Catch:{ all -> 0x00c9 }
            d.h.c.z r3 = r7.f39126i     // Catch:{ all -> 0x00c9 }
            android.app.Activity r4 = r7.f39098D     // Catch:{ all -> 0x00c9 }
            java.lang.String r5 = r7.mo41232h()     // Catch:{ all -> 0x00c9 }
            java.lang.String r6 = r7.mo41234i()     // Catch:{ all -> 0x00c9 }
            r3.mo41778a(r4, r5, r6)     // Catch:{ all -> 0x00c9 }
            boolean r3 = r7.f39118X     // Catch:{ all -> 0x00c9 }
            if (r3 == 0) goto L_0x00c1
            r7.f39118X = r1     // Catch:{ all -> 0x00c9 }
            d.h.c.z r1 = r7.f39126i     // Catch:{ all -> 0x00c9 }
            r1.mo41787g()     // Catch:{ all -> 0x00c9 }
        L_0x00c1:
            goto L_0x00c7
        L_0x00c2:
            d.h.c.D$a r2 = p019d.p273h.p276c.C12741D.C12742a.INTERSTITIAL     // Catch:{ all -> 0x00c9 }
            r7.m41177a(r2, r1)     // Catch:{ all -> 0x00c9 }
        L_0x00c7:
            monitor-exit(r7)
            return
        L_0x00c9:
            r0 = move-exception
            monitor-exit(r7)
            goto L_0x00cd
        L_0x00cc:
            throw r0
        L_0x00cd:
            goto L_0x00cc
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12747I.m41199t():void");
    }

    /* renamed from: s */
    private void m41198s() {
        long bannerTimeout = this.f39134q.mo41692a().mo41479b().mo41472a();
        int bannerInterval = this.f39134q.mo41692a().mo41479b().mo41476c();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f39134q.mo41694c().mo41520a().size(); i++) {
            String provider = (String) this.f39134q.mo41694c().mo41520a().get(i);
            if (!TextUtils.isEmpty(provider)) {
                C12826q providerSettings = this.f39134q.mo41695d().mo41560b(provider);
                if (providerSettings != null) {
                    arrayList.add(providerSettings);
                }
            }
        }
        this.f39128k.mo41713a(arrayList, this.f39098D, mo41232h(), mo41234i(), bannerTimeout, bannerInterval);
        if (this.f39110P) {
            this.f39110P = false;
            mo41208a(this.f39111Q, this.f39112R);
            this.f39111Q = null;
            this.f39112R = null;
        }
    }

    /* renamed from: a */
    private boolean m41181a(C12791c smash) {
        return smash.mo41400q() >= 1 && smash.mo41401r() >= 1;
    }

    /* renamed from: a */
    public void mo41212a(String reason) {
        try {
            C12802d dVar = this.f39129l;
            C12801a aVar = C12801a.API;
            StringBuilder sb = new StringBuilder();
            sb.append("onInitFailed(reason:");
            sb.append(reason);
            sb.append(")");
            dVar.mo41427b(aVar, sb.toString(), 1);
            if (this.f39130m != null) {
                for (C12742a adUnit : this.f39099E) {
                    m41177a(adUnit, true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo41204a() {
        if (this.f39110P) {
            this.f39110P = false;
            C12923j.m42015a().mo41706a(this.f39111Q, new C12799b(603, "init had failed"));
            this.f39111Q = null;
            this.f39112R = null;
        }
        if (this.f39118X) {
            this.f39118X = false;
            C12937p.m42122a().mo41746a(C12913g.m41923b("init() had failed", "Interstitial"));
        }
    }

    /* renamed from: a */
    private void m41177a(C12742a adUnit, boolean isInitFailed) {
        int i = C12746H.f39092a[adUnit.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4 && this.f39110P) {
                        this.f39110P = false;
                        C12923j.m42015a().mo41706a(this.f39111Q, new C12799b(602, "Init had failed"));
                        this.f39111Q = null;
                        this.f39112R = null;
                    }
                } else if (isInitFailed || m41196q() || this.f39100F.contains(adUnit)) {
                    this.f39130m.mo41256b(false);
                }
            } else if (this.f39118X) {
                this.f39118X = false;
                C12937p.m42122a().mo41746a(C12913g.m41923b("init() had failed", "Interstitial"));
            }
        } else if (isInitFailed || m41197r() || this.f39100F.contains(adUnit)) {
            this.f39130m.mo41616a(false);
        }
    }

    /* renamed from: c */
    private void m41185c(Activity activity) {
        AtomicBoolean atomicBoolean = this.f39132o;
        if (atomicBoolean != null && atomicBoolean.compareAndSet(false, true)) {
            C12788l.m41526a().mo41377a(new C12914h(activity.getApplicationContext()));
            C12784h.m41502g().mo41350a(activity.getApplicationContext(), this.f39102H);
            C12787k.m41517g().mo41350a(activity.getApplicationContext(), this.f39102H);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public synchronized void mo41225d(C12775b adapter) {
        if (!(this.f39121d == null || adapter == null || this.f39121d.contains(adapter))) {
            this.f39121d.add(adapter);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public synchronized void mo41222c(C12775b adapter) {
        if (!(this.f39122e == null || adapter == null || this.f39122e.contains(adapter))) {
            this.f39122e.add(adapter);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public synchronized void mo41219b(C12775b adapter) {
        if (!(this.f39123f == null || adapter == null || this.f39123f.contains(adapter))) {
            this.f39123f.add(adapter);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo41209a(C12775b adapter) {
        this.f39124g = adapter;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public synchronized C12775b mo41216b(String providerName) {
        if (this.f39121d != null) {
            Iterator it = this.f39121d.iterator();
            while (it.hasNext()) {
                C12775b adapter = (C12775b) it.next();
                if (adapter.getProviderName().equals(providerName)) {
                    return adapter;
                }
            }
        }
        try {
            if (this.f39122e != null) {
                Iterator it2 = this.f39122e.iterator();
                while (it2.hasNext()) {
                    C12775b adapter2 = (C12775b) it2.next();
                    if (adapter2.getProviderName().equals(providerName)) {
                        return adapter2;
                    }
                }
            }
            if (this.f39123f != null) {
                Iterator it3 = this.f39123f.iterator();
                while (it3.hasNext()) {
                    C12775b adapter3 = (C12775b) it3.next();
                    if (adapter3.getProviderName().equals(providerName)) {
                        return adapter3;
                    }
                }
            }
            if (this.f39124g != null && this.f39124g.getProviderName().equals(providerName)) {
                return this.f39124g;
            }
        } catch (Exception e) {
            C12802d dVar = this.f39129l;
            C12801a aVar = C12801a.INTERNAL;
            StringBuilder sb = new StringBuilder();
            sb.append("getExistingAdapter exception: ");
            sb.append(e);
            dVar.mo41427b(aVar, sb.toString(), 1);
        }
        return null;
    }

    /* renamed from: n */
    private void m41191n() {
        this.f39129l = C12802d.m41612b(0);
        this.f39131n = new C12805g(null, 1);
        this.f39129l.mo41436a((C12800c) this.f39131n);
        this.f39130m = new C12858Z();
        this.f39125h = new C12934na();
        this.f39125h.mo41739a((C12879ja) this.f39130m);
        this.f39125h.mo41738a((C12874h) this.f39130m);
        this.f39126i = new C12952z();
        this.f39126i.mo41782a((C12884m) this.f39130m);
        this.f39126i.mo41780a((C12869ea) this.f39130m);
        this.f39126i.mo41781a((C12872g) this.f39130m);
        this.f39127j = new C12758P();
        this.f39127j.mo41253a((C12878j) this.f39130m);
        this.f39128k = new C12927l();
    }

    /* renamed from: b */
    public void mo41218b(Activity activity) {
        String logMessage = "onResume()";
        try {
            this.f39098D = activity;
            this.f39129l.mo41427b(C12801a.API, logMessage, 1);
            if (this.f39125h != null) {
                this.f39125h.mo41301b(activity);
            }
            if (this.f39126i != null) {
                this.f39126i.mo41301b(activity);
            }
            if (this.f39128k != null) {
                this.f39128k.mo41715b(activity);
            }
            if (this.f39114T != null) {
                this.f39114T.mo41293b(activity);
            }
            if (this.f39115U != null) {
                this.f39115U.mo41270b(activity);
            }
        } catch (Throwable e) {
            this.f39129l.mo41426a(C12801a.API, logMessage, e);
        }
    }

    /* renamed from: a */
    public void mo41205a(Activity activity) {
        String logMessage = "onPause()";
        try {
            this.f39129l.mo41427b(C12801a.API, logMessage, 1);
            if (this.f39125h != null) {
                this.f39125h.mo41298a(activity);
            }
            if (this.f39126i != null) {
                this.f39126i.mo41298a(activity);
            }
            if (this.f39128k != null) {
                this.f39128k.mo41711a(activity);
            }
            if (this.f39114T != null) {
                this.f39114T.mo41286a(activity);
            }
            if (this.f39115U != null) {
                this.f39115U.mo41264a(activity);
            }
        } catch (Throwable e) {
            this.f39129l.mo41426a(C12801a.API, logMessage, e);
        }
    }

    /* renamed from: g */
    public void mo41231g(String mediationType) {
        String str = ")";
        String str2 = ":setMediationType(mediationType:";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f39119b);
            sb.append(str2);
            sb.append(mediationType);
            sb.append(str);
            this.f39129l.mo41427b(C12801a.INTERNAL, sb.toString(), 1);
            if (!m41182a(mediationType, 1, 64) || !m41192n(mediationType)) {
                this.f39129l.mo41427b(C12801a.INTERNAL, " mediationType value is invalid - should be alphanumeric and 1-64 chars in length", 1);
                return;
            }
            this.f39142y = mediationType;
        } catch (Exception e) {
            C12802d dVar = this.f39129l;
            C12801a aVar = C12801a.API;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f39119b);
            sb2.append(str2);
            sb2.append(mediationType);
            sb2.append(str);
            dVar.mo41426a(aVar, sb2.toString(), (Throwable) e);
        }
    }

    /* renamed from: b */
    public synchronized Integer mo41217b() {
        return this.f39137t;
    }

    /* renamed from: f */
    public synchronized String mo41229f() {
        return this.f39138u;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public synchronized String mo41236j() {
        return this.f39139v;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public synchronized String mo41227e() {
        return this.f39140w;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public synchronized Map<String, String> mo41238l() {
        return this.f39141x;
    }

    /* renamed from: k */
    public synchronized String mo41237k() {
        return this.f39142y;
    }

    /* renamed from: i */
    public void mo41235i(String instanceId) {
        String str = "Rewarded Video";
        String str2 = "showISDemandOnlyRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully";
        StringBuilder sb = new StringBuilder();
        sb.append("showISDemandOnlyRewardedVideo(");
        sb.append(instanceId);
        sb.append(")");
        String logMessage = sb.toString();
        this.f39129l.mo41427b(C12801a.API, logMessage, 1);
        try {
            if (!this.f39105K) {
                this.f39129l.mo41427b(C12801a.API, "Rewarded Video was initialized in mediation mode. Use showRewardedVideo instead", 3);
            } else if (!m41197r()) {
                this.f39130m.onRewardedVideoAdShowFailed(instanceId, C12913g.m41923b(str2, str));
            } else {
                C12820l defaultPlacement = this.f39134q.mo41692a().mo41482e().mo41564b();
                if (defaultPlacement != null) {
                    mo41220b(instanceId, defaultPlacement.mo41504c());
                }
            }
        } catch (Exception e) {
            this.f39129l.mo41426a(C12801a.API, logMessage, (Throwable) e);
            this.f39130m.onRewardedVideoAdShowFailed(instanceId, C12913g.m41923b(str2, str));
        }
    }

    /* renamed from: b */
    public void mo41220b(String instanceId, String placementName) {
        String str = "Rewarded Video";
        String str2 = "showISDemandOnlyRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully";
        StringBuilder sb = new StringBuilder();
        sb.append("showISDemandOnlyRewardedVideo(");
        sb.append(instanceId);
        String str3 = ")";
        if (placementName != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" , ");
            sb2.append(placementName);
            sb2.append(str3);
            str3 = sb2.toString();
        }
        sb.append(str3);
        String logMessage = sb.toString();
        this.f39129l.mo41427b(C12801a.API, logMessage, 1);
        try {
            if (!this.f39105K) {
                this.f39129l.mo41427b(C12801a.API, "Rewarded Video was initialized in mediation mode. Use showRewardedVideo instead", 3);
            } else if (!m41197r()) {
                this.f39130m.onRewardedVideoAdShowFailed(instanceId, C12913g.m41923b(str2, str));
            } else {
                C12820l placement = m41190m(placementName);
                if (placement != null) {
                    JSONObject data = C12916j.m41965a(true);
                    try {
                        data.put(VungleActivity.PLACEMENT_EXTRA, placement.mo41504c());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    C12787k.m41517g().mo41369d(new C12733b(2, data));
                    this.f39125h.mo41737a(placement);
                    this.f39125h.mo41740a(instanceId, placement.mo41504c());
                }
            }
        } catch (Exception e2) {
            this.f39129l.mo41426a(C12801a.API, logMessage, (Throwable) e2);
            this.f39130m.onRewardedVideoAdShowFailed(instanceId, C12913g.m41923b(str2, str));
        }
    }

    /* renamed from: d */
    public boolean mo41226d(String instanceId) {
        String str = "isISDemandOnlyRewardedVideoAvailable():";
        boolean isAvailable = false;
        try {
            if (!this.f39105K) {
                this.f39129l.mo41427b(C12801a.API, "Rewarded Video was initialized in mediation mode. Use isRewardedVideoAvailable instead", 3);
                return false;
            }
            isAvailable = this.f39125h.mo41742b(instanceId);
            JSONObject data = C12916j.m41965a(true);
            data.put("status", String.valueOf(isAvailable));
            C12787k.m41517g().mo41369d(new C12733b(18, data));
            C12802d dVar = this.f39129l;
            C12801a aVar = C12801a.API;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(isAvailable);
            dVar.mo41427b(aVar, sb.toString(), 1);
            return isAvailable;
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Throwable e2) {
            C12802d dVar2 = this.f39129l;
            C12801a aVar2 = C12801a.API;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(isAvailable);
            dVar2.mo41427b(aVar2, sb2.toString(), 1);
            this.f39129l.mo41426a(C12801a.API, "isISDemandOnlyRewardedVideoAvailable()", e2);
            isAvailable = false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41211a(C12874h listener) {
        if (listener == null) {
            this.f39129l.mo41427b(C12801a.API, "setISDemandOnlyRewardedVideoListener(ISDemandOnlyRewardedVideoListener:null)", 1);
        } else {
            this.f39129l.mo41427b(C12801a.API, "setISDemandOnlyRewardedVideoListener(ISDemandOnlyRewardedVideoListener)", 1);
        }
        this.f39130m.mo41614a(listener);
    }

    /* renamed from: r */
    private boolean m41197r() {
        C12917k kVar = this.f39134q;
        return (kVar == null || kVar.mo41692a() == null || this.f39134q.mo41692a().mo41482e() == null) ? false : true;
    }

    /* renamed from: m */
    private C12820l m41190m(String placementName) {
        C12820l placement = this.f39134q.mo41692a().mo41482e().mo41561a(placementName);
        if (placement == null) {
            this.f39129l.mo41427b(C12801a.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 3);
            placement = this.f39134q.mo41692a().mo41482e().mo41564b();
            if (placement == null) {
                this.f39129l.mo41427b(C12801a.API, "Default placement was not found, please make sure you are using the right placements.", 3);
                return null;
            }
        }
        String cappedMessage = mo41203a(placement.mo41504c(), C12908c.m41899c((Context) this.f39098D, placement));
        if (TextUtils.isEmpty(cappedMessage)) {
            return placement;
        }
        this.f39129l.mo41427b(C12801a.API, cappedMessage, 1);
        this.f39130m.mo41621c(C12913g.m41920a("Rewarded Video", cappedMessage));
        return null;
    }

    /* renamed from: e */
    public void mo41228e(String instanceId) {
        StringBuilder sb = new StringBuilder();
        sb.append("loadISDemandOnlyInterstitial(");
        sb.append(instanceId);
        sb.append(")");
        String logMessage = sb.toString();
        this.f39129l.mo41427b(C12801a.API, logMessage, 1);
        try {
            if (!this.f39106L) {
                this.f39129l.mo41427b(C12801a.API, "Interstitial was initialized in mediation mode. Use loadInterstitial instead", 3);
            } else if (!this.f39108N) {
                this.f39129l.mo41427b(C12801a.API, "init() must be called before loadInterstitial()", 3);
            } else {
                this.f39126i.mo41785c(instanceId);
            }
        } catch (Throwable e) {
            this.f39129l.mo41426a(C12801a.API, logMessage, e);
        }
    }

    /* renamed from: h */
    public void mo41233h(String instanceId) {
        String str = "Interstitial";
        String str2 = "showISDemandOnlyInterstitial can't be called before the Interstitial ad unit initialization completed successfully";
        StringBuilder sb = new StringBuilder();
        sb.append("showISDemandOnlyInterstitial(");
        sb.append(instanceId);
        sb.append(")");
        String logMessage = sb.toString();
        this.f39129l.mo41427b(C12801a.API, logMessage, 1);
        try {
            if (!this.f39106L) {
                this.f39129l.mo41427b(C12801a.API, "Interstitial was initialized in mediation mode. Use showInterstitial instead", 3);
            } else if (!m41195p()) {
                this.f39130m.onInterstitialAdShowFailed(instanceId, C12913g.m41923b(str2, str));
            } else {
                C12817i defaultPlacement = this.f39134q.mo41692a().mo41480c().mo41486b();
                if (defaultPlacement != null) {
                    mo41213a(instanceId, defaultPlacement.mo41496c());
                }
            }
        } catch (Exception e) {
            this.f39129l.mo41426a(C12801a.API, logMessage, (Throwable) e);
            this.f39130m.onInterstitialAdShowFailed(instanceId, C12913g.m41923b(str2, str));
        }
    }

    /* renamed from: a */
    public void mo41213a(String instanceId, String placementName) {
        String str = "Interstitial";
        String str2 = "showISDemandOnlyInterstitial can't be called before the Interstitial ad unit initialization completed successfully";
        StringBuilder sb = new StringBuilder();
        sb.append("showISDemandOnlyInterstitial(");
        sb.append(instanceId);
        String str3 = ")";
        if (placementName != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" , ");
            sb2.append(placementName);
            sb2.append(str3);
            str3 = sb2.toString();
        }
        sb.append(str3);
        String logMessage = sb.toString();
        this.f39129l.mo41427b(C12801a.API, logMessage, 1);
        try {
            if (!this.f39106L) {
                this.f39129l.mo41427b(C12801a.API, "Interstitial was initialized in mediation mode. Use showInterstitial instead", 3);
            } else if (!m41195p()) {
                this.f39130m.onInterstitialAdShowFailed(instanceId, C12913g.m41923b(str2, str));
            } else {
                C12817i placement = m41189l(placementName);
                if (placement != null) {
                    C12784h.m41502g().mo41369d(new C12733b(2100, C12916j.m41965a(true)));
                    this.f39126i.mo41779a(placement);
                    this.f39126i.mo41783a(instanceId, placement.mo41496c());
                }
            }
        } catch (Exception e) {
            this.f39129l.mo41426a(C12801a.API, logMessage, (Throwable) e);
            this.f39130m.onInterstitialAdShowFailed(instanceId, C12913g.m41923b(str2, str));
        }
    }

    /* renamed from: c */
    public boolean mo41223c(String instanceId) {
        boolean isReady;
        String str = "):";
        String str2 = "isISDemandOnlyInterstitialReady(instanceId: ";
        try {
            if (!this.f39106L) {
                this.f39129l.mo41427b(C12801a.API, "Interstitial was initialized in mediation mode. Use isInterstitialReady instead", 3);
                return false;
            }
            isReady = this.f39126i.mo41784b(instanceId);
            C12784h.m41502g().mo41369d(new C12733b(isReady ? 2101 : 2102, C12916j.m41965a(true)));
            C12802d dVar = this.f39129l;
            C12801a aVar = C12801a.API;
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(instanceId);
            sb.append(str);
            sb.append(isReady);
            dVar.mo41427b(aVar, sb.toString(), 1);
            return isReady;
        } catch (Throwable e) {
            C12802d dVar2 = this.f39129l;
            C12801a aVar2 = C12801a.API;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(instanceId);
            sb2.append(str);
            sb2.append(false);
            dVar2.mo41427b(aVar2, sb2.toString(), 1);
            C12802d dVar3 = this.f39129l;
            C12801a aVar3 = C12801a.API;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str2);
            sb3.append(instanceId);
            sb3.append(")");
            dVar3.mo41426a(aVar3, sb3.toString(), e);
            isReady = false;
        }
    }

    /* renamed from: a */
    public void mo41210a(C12872g listener) {
        if (listener == null) {
            this.f39129l.mo41427b(C12801a.API, "setISDemandOnlyInterstitialListener(ISDemandOnlyInterstitialListener:null)", 1);
        } else {
            this.f39129l.mo41427b(C12801a.API, "setISDemandOnlyInterstitialListener(ISDemandOnlyInterstitialListener)", 1);
        }
        this.f39130m.mo41613a(listener);
    }

    /* renamed from: p */
    private boolean m41195p() {
        C12917k kVar = this.f39134q;
        return (kVar == null || kVar.mo41692a() == null || this.f39134q.mo41692a().mo41480c() == null) ? false : true;
    }

    /* renamed from: l */
    private C12817i m41189l(String placementName) {
        C12817i placement = this.f39134q.mo41692a().mo41480c().mo41483a(placementName);
        if (placement == null) {
            this.f39129l.mo41427b(C12801a.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 3);
            placement = this.f39134q.mo41692a().mo41480c().mo41486b();
            if (placement == null) {
                this.f39129l.mo41427b(C12801a.API, "Default placement was not found, please make sure you are using the right placements.", 3);
                return null;
            }
        }
        String cappedMessage = mo41203a(placement.mo41496c(), m41188k(placement.mo41496c()));
        if (TextUtils.isEmpty(cappedMessage)) {
            return placement;
        }
        this.f39129l.mo41427b(C12801a.API, cappedMessage, 1);
        this.f39130m.mo41611a(placement);
        this.f39130m.mo41618b(C12913g.m41920a("Interstitial", cappedMessage));
        return null;
    }

    /* renamed from: q */
    private boolean m41196q() {
        C12917k kVar = this.f39134q;
        return (kVar == null || kVar.mo41692a() == null || this.f39134q.mo41692a().mo41481d() == null) ? false : true;
    }

    /* renamed from: o */
    private boolean m41194o() {
        C12917k kVar = this.f39134q;
        return (kVar == null || kVar.mo41692a() == null || this.f39134q.mo41692a().mo41479b() == null) ? false : true;
    }

    /* renamed from: a */
    public void mo41208a(C12745G banner, String placementName) {
        C12802d dVar = this.f39129l;
        C12801a aVar = C12801a.API;
        StringBuilder sb = new StringBuilder();
        sb.append("loadBanner(");
        sb.append(placementName);
        sb.append(")");
        dVar.mo41427b(aVar, sb.toString(), 1);
        if (banner == null) {
            this.f39129l.mo41427b(C12801a.API, "loadBanner can't be called with a null parameter", 1);
        } else if (!this.f39109O) {
            this.f39129l.mo41427b(C12801a.API, "init() must be called before loadBanner()", 3);
        } else if (!banner.getSize().mo41758a().equals("CUSTOM") || (banner.getSize().mo41760c() > 0 && banner.getSize().mo41759b() > 0)) {
            C12754a initStatus = C12753N.m41255b().mo41247a();
            String str = "init() had failed";
            if (initStatus == C12754a.INIT_FAILED) {
                this.f39129l.mo41427b(C12801a.API, str, 3);
                C12923j.m42015a().mo41706a(banner, new C12799b(600, "Init() had failed"));
            } else if (initStatus == C12754a.INIT_IN_PROGRESS) {
                if (C12753N.m41255b().mo41250c()) {
                    this.f39129l.mo41427b(C12801a.API, str, 3);
                    C12923j.m42015a().mo41706a(banner, new C12799b(601, "Init had failed"));
                } else {
                    this.f39111Q = banner;
                    this.f39110P = true;
                    this.f39112R = placementName;
                }
            } else {
                C12917k kVar = this.f39134q;
                if (kVar == null || kVar.mo41692a() == null || this.f39134q.mo41692a().mo41479b() == null) {
                    String str2 = "No banner configurations found";
                    this.f39129l.mo41427b(C12801a.API, str2, 3);
                    C12923j.m42015a().mo41706a(banner, new C12799b(615, str2));
                    return;
                }
                this.f39128k.mo41712a(banner, m41187j(placementName));
            }
        } else {
            this.f39129l.mo41427b(C12801a.API, "loadBanner: Unsupported banner size. Height and width must be bigger than 0", 3);
            C12923j.m42015a().mo41706a(banner, C12913g.m41929f(""));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C12917k mo41201a(Context context, String userId, C12748a listener) {
        synchronized (this.f39133p) {
            if (this.f39134q != null) {
                C12917k kVar = new C12917k(this.f39134q);
                return kVar;
            }
            C12917k response = m41183b(context, userId, listener);
            if (response == null || !response.mo41698g()) {
                C12802d.m41613c().mo41427b(C12801a.INTERNAL, "Null or invalid response. Trying to get cached response", 0);
                response = m41175a(context, userId);
            }
            if (response != null) {
                this.f39134q = response;
                C12916j.m41975b(context, response.toString());
                m41184b(this.f39134q, context);
            }
            C12784h.m41502g().mo41356a(true);
            C12787k.m41517g().mo41356a(true);
            return response;
        }
    }

    /* renamed from: a */
    private C12917k m41175a(Context context, String userId) {
        JSONObject cachedJsonObject;
        try {
            cachedJsonObject = new JSONObject(C12916j.m41972b(context));
        } catch (JSONException e) {
            cachedJsonObject = new JSONObject();
        }
        String cachedAppKey = cachedJsonObject.optString("appKey");
        String cachedUserId = cachedJsonObject.optString(AndroidAccountManagerPersistence.ACCOUNT_ID);
        String cachedSettings = cachedJsonObject.optString("response");
        if (TextUtils.isEmpty(cachedAppKey) || TextUtils.isEmpty(cachedUserId) || TextUtils.isEmpty(cachedSettings) || mo41232h() == null || !cachedAppKey.equals(mo41232h()) || !cachedUserId.equals(userId)) {
            return null;
        }
        C12917k response = new C12917k(context, cachedAppKey, cachedUserId, cachedSettings);
        C12799b sse = C12913g.m41927d(cachedAppKey, cachedUserId);
        this.f39129l.mo41427b(C12801a.INTERNAL, sse.toString(), 1);
        C12802d dVar = this.f39129l;
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(sse.toString());
        sb.append(": ");
        sb.append(response.toString());
        dVar.mo41427b(aVar, sb.toString(), 1);
        C12787k.m41517g().mo41369d(new C12733b(Opcodes.F2L, C12916j.m41965a(false)));
        return response;
    }

    /* renamed from: b */
    private C12917k m41183b(Context context, String userId, C12748a listener) {
        if (!C12916j.m41982c(context)) {
            return null;
        }
        C12917k response = null;
        try {
            String gaid = mo41202a(context);
            if (TextUtils.isEmpty(gaid)) {
                try {
                    gaid = C12725c.m41105j(context);
                    C12802d.m41613c().mo41427b(C12801a.INTERNAL, "using custom identifier", 1);
                } catch (Exception e) {
                    e = e;
                }
            }
            if (this.f39102H == null) {
                Context context2 = context;
                String serverResponseString = C12902a.m41871a(C12903b.m41872a(context2, mo41232h(), userId, gaid, mo41237k(), null), listener);
                if (serverResponseString == null) {
                    return null;
                }
                if (C12916j.m41979c() == 1) {
                    String encryptedResponse = new JSONObject(serverResponseString).optString("response", null);
                    if (TextUtils.isEmpty(encryptedResponse)) {
                        return null;
                    }
                    serverResponseString = C12915i.m41952a("C38FB23A402222A0C17D34A92F971D1F", encryptedResponse);
                }
                response = new C12917k(context, mo41232h(), userId, serverResponseString);
                if (!response.mo41698g()) {
                    return null;
                }
                return response;
            }
            this.f39102H.mo41242b();
            throw null;
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return response;
        }
    }

    /* renamed from: b */
    private void m41184b(C12917k response, Context context) {
        m41178a(response);
        m41179a(response, context);
    }

    /* renamed from: a */
    private void m41179a(C12917k response, Context context) {
        boolean isRVEventsEnabled = false;
        if (m41197r()) {
            isRVEventsEnabled = response.mo41692a().mo41482e().mo41572h().mo41468g();
        }
        boolean isISEventsEnabled = false;
        if (m41195p()) {
            isISEventsEnabled = response.mo41692a().mo41480c().mo41492f().mo41468g();
        }
        boolean isBNEventsEnabled = false;
        if (m41194o()) {
            isBNEventsEnabled = response.mo41692a().mo41479b().mo41475b().mo41468g();
        }
        if (isRVEventsEnabled) {
            C12787k.m41517g().mo41360b(response.mo41692a().mo41482e().mo41572h().mo41463b(), context);
            C12787k.m41517g().mo41354a(response.mo41692a().mo41482e().mo41572h().mo41464c(), context);
            C12787k.m41517g().mo41368d(response.mo41692a().mo41482e().mo41572h().mo41466e());
            C12787k.m41517g().mo41365c(response.mo41692a().mo41482e().mo41572h().mo41465d());
            C12787k.m41517g().mo41359b(response.mo41692a().mo41482e().mo41572h().mo41462a());
            C12787k.m41517g().mo41357a(response.mo41692a().mo41482e().mo41572h().mo41467f(), context);
            C12787k.m41517g().mo41352a(response.mo41692a().mo41478a().mo41461c());
        } else {
            C12787k.m41517g().mo41362b(false);
        }
        if (isISEventsEnabled) {
            C12784h.m41502g().mo41360b(response.mo41692a().mo41480c().mo41492f().mo41463b(), context);
            C12784h.m41502g().mo41354a(response.mo41692a().mo41480c().mo41492f().mo41464c(), context);
            C12784h.m41502g().mo41368d(response.mo41692a().mo41480c().mo41492f().mo41466e());
            C12784h.m41502g().mo41365c(response.mo41692a().mo41480c().mo41492f().mo41465d());
            C12784h.m41502g().mo41359b(response.mo41692a().mo41480c().mo41492f().mo41462a());
            C12784h.m41502g().mo41357a(response.mo41692a().mo41480c().mo41492f().mo41467f(), context);
            C12784h.m41502g().mo41352a(response.mo41692a().mo41478a().mo41461c());
        } else if (isBNEventsEnabled) {
            C12811c config = response.mo41692a().mo41479b().mo41475b();
            C12784h.m41502g().mo41360b(config.mo41463b(), context);
            C12784h.m41502g().mo41354a(config.mo41464c(), context);
            C12784h.m41502g().mo41368d(config.mo41466e());
            C12784h.m41502g().mo41365c(config.mo41465d());
            C12784h.m41502g().mo41359b(config.mo41462a());
            C12784h.m41502g().mo41357a(config.mo41467f(), context);
            C12784h.m41502g().mo41352a(response.mo41692a().mo41478a().mo41461c());
        } else {
            C12784h.m41502g().mo41362b(false);
        }
    }

    /* renamed from: a */
    private void m41178a(C12917k response) {
        this.f39131n.mo41432a(response.mo41692a().mo41478a().mo41460b().mo41471b());
        this.f39129l.mo41437a("console", response.mo41692a().mo41478a().mo41460b().mo41470a());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public synchronized void mo41230f(String userId) {
        this.f39136s = userId;
    }

    /* renamed from: h */
    public synchronized String mo41232h() {
        return this.f39135r;
    }

    /* renamed from: i */
    public synchronized String mo41234i() {
        return this.f39136s;
    }

    /* renamed from: o */
    private C12773b m41193o(String appKey) {
        C12773b result = new C12773b();
        if (appKey != null) {
            String str = "appKey";
            if (!m41182a(appKey, 5, 10)) {
                result.mo41314a(C12913g.m41921a(str, appKey, "length should be between 5-10 characters"));
            } else if (!m41192n(appKey)) {
                result.mo41314a(C12913g.m41921a(str, appKey, "should contain only english characters and numbers"));
            }
        } else {
            result.mo41314a(new C12799b(506, "Init Fail - appKey is missing"));
        }
        return result;
    }

    /* renamed from: a */
    private boolean m41182a(String key, int minLength, int maxLength) {
        return key != null && key.length() >= minLength && key.length() <= maxLength;
    }

    /* renamed from: n */
    private boolean m41192n(String key) {
        if (key == null) {
            return false;
        }
        return key.matches("^[a-zA-Z0-9]*$");
    }

    /* renamed from: a */
    public String mo41202a(Context context) {
        String str = "";
        try {
            String[] deviceInfo = C12725c.m41090b(context);
            if (deviceInfo.length <= 0 || deviceInfo[0] == null) {
                return str;
            }
            return deviceInfo[0];
        } catch (Exception e) {
            return str;
        }
    }

    /* renamed from: k */
    private C12909a m41188k(String placementName) {
        C12917k kVar = this.f39134q;
        if (kVar == null || kVar.mo41692a() == null || this.f39134q.mo41692a().mo41480c() == null) {
            return C12909a.NOT_CAPPED;
        }
        C12817i placement = null;
        try {
            placement = this.f39134q.mo41692a().mo41480c().mo41483a(placementName);
            if (placement == null) {
                placement = this.f39134q.mo41692a().mo41480c().mo41486b();
                if (placement == null) {
                    this.f39129l.mo41427b(C12801a.API, "Default placement was not found", 3);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (placement == null) {
            return C12909a.NOT_CAPPED;
        }
        return C12908c.m41898c((Context) this.f39098D, placement);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo41203a(String placementName, C12909a cappingStatus) {
        if (cappingStatus == null) {
            return null;
        }
        int i = C12746H.f39093b[cappingStatus.ordinal()];
        String str = "Placement ";
        if (i == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(placementName);
            sb.append(" is capped by disabled delivery");
            return sb.toString();
        } else if (i == 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(placementName);
            sb2.append(" has reached its capping limit");
            return sb2.toString();
        } else if (i != 3) {
            return null;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(placementName);
            sb3.append(" has reached its limit as defined per pace");
            return sb3.toString();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public C12917k mo41224d() {
        return this.f39134q;
    }

    /* renamed from: j */
    private C12814f m41187j(String placementName) {
        if (TextUtils.isEmpty(placementName)) {
            return this.f39134q.mo41692a().mo41479b().mo41477d();
        }
        C12814f placement = this.f39134q.mo41692a().mo41479b().mo41473a(placementName);
        if (placement != null) {
            return placement;
        }
        return this.f39134q.mo41692a().mo41479b().mo41477d();
    }

    /* renamed from: m */
    public synchronized String mo41239m() {
        return this.f39097C;
    }

    /* renamed from: a */
    public void mo41215a(boolean consent) {
        this.f39113S = Boolean.valueOf(consent);
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.API;
        StringBuilder sb = new StringBuilder();
        sb.append("setConsent : ");
        sb.append(consent);
        c.mo41427b(aVar, sb.toString(), 1);
        C12934na naVar = this.f39125h;
        if (naVar != null) {
            naVar.mo41302b(consent);
        }
        C12952z zVar = this.f39126i;
        if (zVar != null) {
            zVar.mo41302b(consent);
        }
        C12927l lVar = this.f39128k;
        if (lVar != null) {
            lVar.mo41714a(consent);
        }
        if (this.f39124g != null) {
            C12802d dVar = this.f39129l;
            C12801a aVar2 = C12801a.ADAPTER_API;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Offerwall | setConsent(consent:");
            sb2.append(consent);
            sb2.append(")");
            dVar.mo41427b(aVar2, sb2.toString(), 1);
            this.f39124g.setConsent(consent);
        }
        C12769Z z = this.f39114T;
        if (z != null) {
            z.mo41291a(consent);
        }
        C12761T t = this.f39115U;
        if (t != null) {
            t.mo41269a(consent);
        }
        int code = 40;
        if (!consent) {
            code = 41;
        }
        C12787k.m41517g().mo41369d(new C12733b(code, C12916j.m41965a(false)));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Boolean mo41221c() {
        return this.f39113S;
    }
}
