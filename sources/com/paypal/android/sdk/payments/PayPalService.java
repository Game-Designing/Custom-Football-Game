package com.paypal.android.sdk.payments;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.util.Log;
import com.paypal.android.sdk.C11703Aa;
import com.paypal.android.sdk.C11704Ab;
import com.paypal.android.sdk.C11706B;
import com.paypal.android.sdk.C11708Bb;
import com.paypal.android.sdk.C11712Cb;
import com.paypal.android.sdk.C11716Db;
import com.paypal.android.sdk.C11720Eb;
import com.paypal.android.sdk.C11723Fa;
import com.paypal.android.sdk.C11724Fb;
import com.paypal.android.sdk.C11727Ga;
import com.paypal.android.sdk.C11728Gb;
import com.paypal.android.sdk.C11731Ha;
import com.paypal.android.sdk.C11732Hb;
import com.paypal.android.sdk.C11737Ja;
import com.paypal.android.sdk.C11738Jb;
import com.paypal.android.sdk.C11743La;
import com.paypal.android.sdk.C11747Mb;
import com.paypal.android.sdk.C11749Na;
import com.paypal.android.sdk.C11757Q;
import com.paypal.android.sdk.C11758Qa;
import com.paypal.android.sdk.C11762S;
import com.paypal.android.sdk.C11763Sa;
import com.paypal.android.sdk.C11765T;
import com.paypal.android.sdk.C11774W;
import com.paypal.android.sdk.C11788a;
import com.paypal.android.sdk.C11794bb;
import com.paypal.android.sdk.C11804dl;
import com.paypal.android.sdk.C11805ds;
import com.paypal.android.sdk.C11806dv;
import com.paypal.android.sdk.C11814eo;
import com.paypal.android.sdk.C11815eq;
import com.paypal.android.sdk.C11828hb;
import com.paypal.android.sdk.C11844lb;
import com.paypal.android.sdk.C11853nc;
import com.paypal.android.sdk.C12012ub;
import com.paypal.android.sdk.C12024xb;
import com.paypal.android.sdk.C12027ya;
import com.paypal.android.sdk.C12028yb;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

public final class PayPalService extends Service {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f37409a = PayPalService.class.getSimpleName();

    /* renamed from: b */
    private static Intent f37410b;

    /* renamed from: c */
    static final ExecutorService f37411c = C11727Ga.m38839a();

    /* renamed from: d */
    private C11706B f37412d;

    /* renamed from: e */
    private C11743La f37413e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public PayPalConfiguration f37414f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f37415g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C11912a f37416h = new C11912a();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C11912a f37417i = new C11912a();

    /* renamed from: j */
    private C11938hb f37418j = new C11935gb(this);

    /* renamed from: k */
    private String f37419k;

    /* renamed from: l */
    private C11765T f37420l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C11937ha f37421m;

    /* renamed from: n */
    private String f37422n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C11788a f37423o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public C11758Qa f37424p;

    /* renamed from: q */
    private List f37425q = new ArrayList();

    /* renamed from: r */
    private boolean f37426r = true;

    /* renamed from: s */
    private boolean f37427s = true;

    /* renamed from: t */
    private final BroadcastReceiver f37428t = new C11923da(this);

    /* renamed from: u */
    private final IBinder f37429u = new C11934ga(this);

    /* renamed from: v */
    C11805ds f37430v;

    /* renamed from: A */
    private static C11743La m39367A() {
        return new C11743La();
    }

    /* renamed from: B */
    private void m39368B() {
        mo38964a((C11937ha) new C11928ea(this), false);
    }

    /* renamed from: C */
    private static boolean m39369C() {
        return "partner".equals("general");
    }

    /* renamed from: a */
    public static void m39372a(Context context) {
        Log.w("paypal.sdk", "clearing user data");
        f37411c.submit(new C11913aa(context));
    }

    /* JADX WARNING: type inference failed for: r0v24, types: [com.paypal.android.sdk.Ob] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0140  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m39373a(android.content.Intent r15) {
        /*
            r14 = this;
            f37410b = r15
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "init:"
            r0.<init>(r1)
            java.lang.String r1 = m39385b(r15)
            r0.append(r1)
            com.paypal.android.sdk.payments.PayPalConfiguration r0 = r14.f37414f
            if (r0 != 0) goto L_0x002b
            java.lang.String r0 = "com.paypal.android.sdk.paypalConfiguration"
            android.os.Parcelable r0 = r15.getParcelableExtra(r0)
            com.paypal.android.sdk.payments.PayPalConfiguration r0 = (com.paypal.android.sdk.payments.PayPalConfiguration) r0
            r14.f37414f = r0
            com.paypal.android.sdk.payments.PayPalConfiguration r0 = r14.f37414f
            if (r0 == 0) goto L_0x0023
            goto L_0x002b
        L_0x0023:
            java.lang.RuntimeException r15 = new java.lang.RuntimeException
            java.lang.String r0 = "Missing EXTRA_PAYPAL_CONFIGURATION. To avoid this error, set EXTRA_PAYPAL_CONFIGURATION in both PayPalService, and the initializing activity."
            r15.<init>(r0)
            throw r15
        L_0x002b:
            com.paypal.android.sdk.payments.PayPalConfiguration r0 = r14.f37414f
            boolean r0 = r0.mo38903o()
            if (r0 == 0) goto L_0x01bc
            com.paypal.android.sdk.payments.PayPalConfiguration r0 = r14.f37414f
            boolean r0 = r0.mo38897i()
            if (r0 == 0) goto L_0x004a
            boolean r0 = com.paypal.android.sdk.payments.C11867Da.m39247d()
            if (r0 == 0) goto L_0x0042
            goto L_0x004a
        L_0x0042:
            java.lang.RuntimeException r15 = new java.lang.RuntimeException
            java.lang.String r0 = "Credit Cards cannot be accepted without card.io dependency. Please check the docs."
            r15.<init>(r0)
            throw r15
        L_0x004a:
            com.paypal.android.sdk.payments.PayPalConfiguration r0 = r14.f37414f
            java.lang.String r0 = r0.mo38888b()
            boolean r1 = com.paypal.android.sdk.C11757Q.m38955c(r0)
            if (r1 == 0) goto L_0x0059
            java.lang.String r1 = "https://api-m.paypal.com/v1/"
            goto L_0x007c
        L_0x0059:
            boolean r1 = com.paypal.android.sdk.C11757Q.m38954b(r0)
            if (r1 == 0) goto L_0x0062
            java.lang.String r1 = "https://api-m.sandbox.paypal.com/v1/"
            goto L_0x007c
        L_0x0062:
            boolean r1 = com.paypal.android.sdk.C11757Q.m38953a(r0)
            if (r1 == 0) goto L_0x006a
            r1 = 0
            goto L_0x007c
        L_0x006a:
            boolean r1 = m39369C()
            if (r1 == 0) goto L_0x01a8
            java.lang.String r1 = "com.paypal.android.sdk.baseEnvironmentUrl"
            boolean r2 = r15.hasExtra(r1)
            if (r2 == 0) goto L_0x01a8
            java.lang.String r1 = r15.getStringExtra(r1)
        L_0x007c:
            com.paypal.android.sdk.Qa r2 = new com.paypal.android.sdk.Qa
            com.paypal.android.sdk.a r3 = r14.f37423o
            com.paypal.android.sdk.payments.PayPalConfiguration r4 = r14.f37414f
            java.lang.String r4 = r4.mo38888b()
            r2.<init>(r3, r4)
            r14.f37424p = r2
            com.paypal.android.sdk.S r0 = m39381b(r0, r1)
            com.paypal.android.sdk.T r1 = r14.f37420l
            if (r1 != 0) goto L_0x0171
            boolean r1 = m39369C()
            r2 = 500(0x1f4, float:7.0E-43)
            if (r1 == 0) goto L_0x00a7
            java.lang.String r1 = "com.paypal.android.sdk.mockNetworkDelay"
            boolean r3 = r15.hasExtra(r1)
            if (r3 == 0) goto L_0x00a7
            int r2 = r15.getIntExtra(r1, r2)
        L_0x00a7:
            boolean r1 = m39369C()
            r3 = 0
            if (r1 == 0) goto L_0x00bb
            java.lang.String r1 = "com.paypal.android.sdk.mockEnable2fa"
            boolean r4 = r15.hasExtra(r1)
            if (r4 == 0) goto L_0x00bb
            boolean r1 = r15.getBooleanExtra(r1, r3)
            goto L_0x00bc
        L_0x00bb:
            r1 = 0
        L_0x00bc:
            boolean r4 = m39369C()
            r5 = 1
            if (r4 == 0) goto L_0x00d0
            java.lang.String r4 = "com.paypal.android.sdk.mock2faPhoneNumberCount"
            boolean r6 = r15.hasExtra(r4)
            if (r6 == 0) goto L_0x00d0
            int r4 = r15.getIntExtra(r4, r5)
            goto L_0x00d1
        L_0x00d0:
            r4 = 1
        L_0x00d1:
            r14.f37426r = r5
            boolean r6 = m39369C()
            if (r6 == 0) goto L_0x00e7
            java.lang.String r6 = "com.paypal.android.sdk.enableAuthenticator"
            boolean r7 = r15.hasExtra(r6)
            if (r7 == 0) goto L_0x00e7
            boolean r6 = r15.getBooleanExtra(r6, r5)
            r14.f37426r = r6
        L_0x00e7:
            boolean r6 = m39369C()
            if (r6 == 0) goto L_0x00fb
            java.lang.String r6 = "com.paypal.android.sdk.enableAuthenticatorSecurity"
            boolean r7 = r15.hasExtra(r6)
            if (r7 == 0) goto L_0x00fb
            boolean r6 = r15.getBooleanExtra(r6, r5)
            r14.f37427s = r6
        L_0x00fb:
            boolean r6 = m39369C()
            if (r6 == 0) goto L_0x010f
            java.lang.String r6 = "com.paypal.android.sdk.enableStageSsl"
            boolean r7 = r15.hasExtra(r6)
            if (r7 == 0) goto L_0x010f
            boolean r5 = r15.getBooleanExtra(r6, r5)
            r12 = r5
            goto L_0x0110
        L_0x010f:
            r12 = 1
        L_0x0110:
            com.paypal.android.sdk.T r5 = new com.paypal.android.sdk.T
            com.paypal.android.sdk.a r6 = r14.f37423o
            com.paypal.android.sdk.B r7 = r14.mo38956a()
            r5.<init>(r6, r0, r7)
            r14.f37420l = r5
            com.paypal.android.sdk.T r0 = r14.f37420l
            com.paypal.android.sdk.fb r5 = new com.paypal.android.sdk.fb
            com.paypal.android.sdk.payments.ja r6 = new com.paypal.android.sdk.payments.ja
            r6.<init>(r14, r3)
            r5.<init>(r6)
            r0.mo38627a(r5)
            com.paypal.android.sdk.payments.PayPalConfiguration r0 = r14.f37414f
            java.lang.String r0 = r0.mo38888b()
            boolean r0 = com.paypal.android.sdk.C11757Q.m38953a(r0)
            if (r0 == 0) goto L_0x0140
            com.paypal.android.sdk.Ob r0 = new com.paypal.android.sdk.Ob
            com.paypal.android.sdk.T r3 = r14.f37420l
            r0.<init>(r3, r2, r1, r4)
            goto L_0x0167
        L_0x0140:
            com.paypal.android.sdk.qa r0 = new com.paypal.android.sdk.qa
            com.paypal.android.sdk.a r7 = r14.f37423o
            com.paypal.android.sdk.payments.PayPalConfiguration r1 = r14.f37414f
            java.lang.String r8 = r1.mo38888b()
            com.paypal.android.sdk.B r9 = r14.mo38956a()
            com.paypal.android.sdk.T r10 = r14.f37420l
            r11 = 90
            com.paypal.android.sdk.Ma r1 = new com.paypal.android.sdk.Ma
            com.paypal.android.sdk.B r2 = r14.mo38956a()
            java.lang.String r2 = r2.mo38527c()
            r1.<init>(r2)
            java.util.List r13 = java.util.Collections.singletonList(r1)
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
        L_0x0167:
            com.paypal.android.sdk.T r1 = r14.f37420l
            com.paypal.android.sdk.wa r2 = new com.paypal.android.sdk.wa
            r2.<init>(r1, r0)
            r1.mo38628a(r2)
        L_0x0171:
            com.paypal.android.sdk.payments.PayPalConfiguration r0 = r14.f37414f
            java.lang.String r0 = r0.mo38886a()
            com.paypal.android.sdk.C11756Pb.m38951b(r0)
            com.paypal.android.sdk.La r0 = r14.f37413e
            if (r0 != 0) goto L_0x0184
            com.paypal.android.sdk.La r0 = m39367A()
            r14.f37413e = r0
        L_0x0184:
            com.paypal.android.sdk.payments.PayPalConfiguration r0 = r14.f37414f
            boolean r0 = r0.mo38898j()
            if (r0 != 0) goto L_0x0195
            com.paypal.android.sdk.a r0 = r14.f37423o
            android.content.Context r0 = r0.mo38698f()
            m39372a(r0)
        L_0x0195:
            android.content.ComponentName r15 = r15.getComponent()
            java.lang.String r15 = r15.getPackageName()
            r14.f37419k = r15
            com.paypal.android.sdk.xb r15 = com.paypal.android.sdk.C12024xb.PreConnect
            r14.mo38965a(r15)
            r14.m39368B()
            return
        L_0x01a8:
            java.lang.RuntimeException r15 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Invalid environment selected:"
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r15.<init>(r0)
            throw r15
        L_0x01bc:
            java.lang.RuntimeException r15 = new java.lang.RuntimeException
            java.lang.String r0 = "Service extras invalid.  Please check the docs."
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.sdk.payments.PayPalService.m39373a(android.content.Intent):void");
    }

    /* renamed from: a */
    private void m39374a(C11703Aa aa) {
        this.f37420l.mo38630b(aa);
    }

    /* renamed from: a */
    static /* synthetic */ void m39375a(PayPalService payPalService, C11703Aa aa) {
        payPalService.f37413e.f36742b = null;
        StringBuilder sb = new StringBuilder();
        sb.append(aa.mo38516n());
        sb.append(" request error");
        String b = aa.mo38518p().mo38700b();
        Log.e("paypal.sdk", b);
        payPalService.m39386b(C12024xb.DeviceCheck, b, aa.mo38513j());
        C11937ha haVar = payPalService.f37421m;
        if (haVar != null) {
            haVar.mo38879a(payPalService.m39383b(aa));
            payPalService.f37421m = null;
        }
        payPalService.f37415g = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39377a(C12024xb xbVar, boolean z, String str, String str2, String str3) {
        this.f37418j.mo39118a(xbVar, z, str, str2, str3);
    }

    /* renamed from: a */
    private static boolean m39378a(C11806dv dvVar) {
        return dvVar != null && dvVar.mo38702a();
    }

    /* renamed from: a */
    private C11738Jb[] m39380a(PayPalItem[] payPalItemArr) {
        if (payPalItemArr == null) {
            return null;
        }
        C11738Jb[] jbArr = new C11738Jb[payPalItemArr.length];
        int length = payPalItemArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            PayPalItem payPalItem = payPalItemArr[i];
            int i3 = i2 + 1;
            C11738Jb jb = new C11738Jb(payPalItem.mo38912b(), payPalItem.mo38914d(), payPalItem.mo38913c(), payPalItem.mo38911a(), payPalItem.mo38916e());
            jbArr[i2] = jb;
            i++;
            i2 = i3;
        }
        return jbArr;
    }

    /* renamed from: b */
    private static C11762S m39381b(String str, String str2) {
        C11762S s = new C11762S(str, str2);
        if (str2 != null) {
            if (str2.startsWith("https://")) {
                String str3 = "/";
                if (!str2.endsWith(str3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(" does not end with a slash, adding one.");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(str3);
                    str2 = sb2.toString();
                }
                for (C12027ya yaVar : C11731Ha.m38848d()) {
                    Map c = s.mo38624c();
                    String a = yaVar.mo38569a();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str2);
                    sb3.append(yaVar.mo38571c());
                    c.put(a, sb3.toString());
                }
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str2);
                sb4.append(" does not start with 'https://', ignoring ");
                sb4.append(str);
                throw new RuntimeException(sb4.toString());
            }
        }
        return s;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public C11940ia m39383b(C11703Aa aa) {
        return new C11940ia(this, aa.mo38518p().mo38700b(), aa.mo38520r(), aa.mo38518p().mo38699a());
    }

    /* renamed from: b */
    private static String m39385b(Intent intent) {
        if (intent == null) {
            return "Intent = null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Intent{");
        StringBuilder sb2 = new StringBuilder("action:");
        sb2.append(intent.getAction());
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder(", cmp:");
        sb3.append(intent.getComponent());
        sb3.append(", ");
        sb.append(sb3.toString());
        if (intent.getExtras() == null) {
            sb.append("null extras");
        } else {
            sb.append("extras:");
            for (String str : intent.getExtras().keySet()) {
                StringBuilder sb4 = new StringBuilder("(");
                sb4.append(str);
                sb4.append(":");
                sb4.append(intent.getExtras().get(str));
                sb4.append(")");
                sb.append(sb4.toString());
            }
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: b */
    private void m39386b(C12024xb xbVar, String str, String str2) {
        m39377a(xbVar, false, str, str2, (String) null);
    }

    /* renamed from: c */
    static /* synthetic */ void m39388c(PayPalService payPalService, C11703Aa aa) {
        String b = aa.mo38518p().mo38700b();
        Log.e("paypal.sdk", b);
        payPalService.m39386b(C12024xb.ConfirmPayment, b, aa.mo38513j());
        payPalService.f37417i.mo39071a(payPalService.m39383b(aa));
    }

    /* renamed from: z */
    private boolean m39393z() {
        return (this.f37414f == null || this.f37413e == null) ? false : true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final C11706B mo38956a() {
        if (this.f37412d == null) {
            this.f37412d = new C11867Da();
        }
        return this.f37412d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final String mo38957a(String str) {
        return this.f37423o.mo38695c(str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo38958a(int i) {
        C11765T t = this.f37420l;
        C11706B a = mo38956a();
        String c = this.f37420l.mo38530c();
        String k = this.f37414f.mo38899k();
        C11743La la = this.f37413e;
        C11728Gb gb = new C11728Gb(t, a, c, k, la.f36750j, (String) new ArrayList(la.f36746f.f37156a.keySet()).get(i));
        t.mo38630b(gb);
    }

    /* renamed from: a */
    public final void mo38959a(C11774W w) {
        m39374a((C11703Aa) new C11720Eb(this.f37420l, mo38956a(), C12012ub.m39749a(w)));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo38960a(C11814eo eoVar, String str, boolean z, String str2, boolean z2, String str3) {
        C11765T t = this.f37420l;
        C11732Hb hb = new C11732Hb(t, mo38956a(), this.f37420l.mo38530c(), this.f37414f.mo38899k(), eoVar, str, this.f37413e.f36750j, z, str2, z2, str3);
        t.mo38630b(hb);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo38961a(C11814eo eoVar, boolean z, String str, boolean z2, String str2) {
        C11765T t = this.f37420l;
        C11732Hb hb = new C11732Hb(t, mo38956a(), this.f37420l.mo38530c(), this.f37414f.mo38899k(), eoVar, z, str, z2, str2);
        t.mo38630b(hb);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo38962a(C11815eq eqVar, Map map, PayPalItem[] payPalItemArr, String str, boolean z, String str2, String str3, boolean z2, String str4, String str5, String str6, boolean z3, String str7) {
        C11765T t = this.f37420l;
        C11708Bb bb = r1;
        C11765T t2 = t;
        C11708Bb bb2 = new C11708Bb(t, mo38956a(), this.f37413e.f36747g.mo38703b(), this.f37413e.mo38591b(), null, eqVar, map, m39380a(payPalItemArr), str, z, str2, this.f37422n, str3, z2);
        C11708Bb bb3 = bb;
        bb3.mo38534d(str4);
        bb3.mo38535e(str5);
        bb3.mo38536f(str6);
        bb3.mo38533a(z3);
        bb3.mo38537g(str7);
        t2.mo38630b(bb3);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo38963a(C11931fa faVar) {
        this.f37416h.mo39070a(faVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo38964a(C11937ha haVar, boolean z) {
        if (z) {
            this.f37413e.f36742b = null;
        }
        this.f37421m = haVar;
        if (!this.f37415g && !this.f37413e.mo38592c()) {
            this.f37415g = true;
            mo38965a(C12024xb.DeviceCheck);
            this.f37420l.mo38630b(new C11747Mb(this.f37414f.mo38888b(), this.f37420l, mo38956a(), this.f37414f.mo38899k()));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo38965a(C12024xb xbVar) {
        m39377a(xbVar, false, (String) null, (String) null, (String) null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo38966a(C12024xb xbVar, Boolean bool) {
        m39377a(xbVar, bool.booleanValue(), (String) null, (String) null, (String) null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo38967a(C12024xb xbVar, Boolean bool, String str) {
        m39377a(xbVar, bool.booleanValue(), (String) null, str, (String) null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo38968a(C12024xb xbVar, String str) {
        m39377a(xbVar, false, (String) null, str, (String) null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo38969a(C12024xb xbVar, String str, String str2) {
        m39377a(xbVar, false, (String) null, str, str2);
    }

    /* renamed from: a */
    public final void mo38970a(String str, String str2) {
        m39374a((C11703Aa) new C11716Db(this.f37420l, mo38956a(), str, str2));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo38971a(String str, String str2, C11815eq eqVar, Map map, PayPalItem[] payPalItemArr, String str3, boolean z, String str4, String str5, String str6, String str7, String str8, String str9) {
        C11765T t = this.f37420l;
        C11706B a = mo38956a();
        String b = this.f37413e.f36742b.mo38703b();
        C11738Jb[] a2 = m39380a(payPalItemArr);
        String str10 = this.f37422n;
        C11712Cb cb = r1;
        C11765T t2 = t;
        C11712Cb cb2 = new C11712Cb(t, a, b, str, str2, str4, eqVar, map, a2, str3, z, str5, str10, str6);
        cb.mo38552d(str7);
        cb.mo38553e(str8);
        cb.mo38554f(str9);
        t2.mo38630b(cb);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo38972a(String str, String str2, String str3, String str4, int i, int i2, C11815eq eqVar, Map map, PayPalItem[] payPalItemArr, String str5, boolean z, String str6, String str7, String str8, String str9, String str10) {
        String str11 = str3;
        String str12 = (!str11.equalsIgnoreCase("4111111111111111") || !C11757Q.m38954b(this.f37414f.mo38888b())) ? str11 : "4444333322221111";
        C11765T t = this.f37420l;
        C11712Cb cb = r2;
        C11712Cb cb2 = new C11712Cb(t, mo38956a(), this.f37413e.f36742b.mo38703b(), str, str2, str12, str4, i, i2, null, eqVar, map, m39380a(payPalItemArr), str5, z, str6, this.f37422n, str7);
        C11712Cb cb3 = cb;
        cb3.mo38552d(str8);
        cb3.mo38553e(str9);
        cb3.mo38554f(str10);
        t.mo38630b(cb3);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo38973a(List list) {
        C11765T t = this.f37420l;
        C11704Ab ab = new C11704Ab(t, mo38956a(), this.f37420l.mo38530c(), this.f37414f.mo38899k(), this.f37413e.f36745e.mo38740a(), this.f37413e.f36750j, list);
        t.mo38630b(ab);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo38974a(boolean z, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, String str3) {
        C11765T t = this.f37420l;
        C12028yb ybVar = new C12028yb(t, mo38956a(), this.f37413e.f36747g.mo38703b(), this.f37413e.mo38591b(), z, str3, this.f37422n, str, str2, jSONObject, jSONObject2);
        t.mo38630b(ybVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo38975a(C11946ka kaVar) {
        if (m39393z()) {
            return true;
        }
        this.f37425q.add(kaVar);
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final C11765T mo38976b() {
        return this.f37420l;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo38977b(C11931fa faVar) {
        this.f37417i.mo39070a(faVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final C11743La mo38978c() {
        return this.f37413e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final PayPalConfiguration mo38979d() {
        return this.f37414f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final String mo38980e() {
        return this.f37414f.mo38888b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final String mo38981f() {
        return this.f37414f.mo38899k();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public final void mo38982g() {
        mo39001t();
        mo38983h();
        this.f37424p.mo38618b();
        mo39002u();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public final void mo38983h() {
        this.f37413e.f36747g = null;
        C11749Na.m38904b(this.f37414f.mo38888b());
        C11743La la = this.f37413e;
        la.f36744d = null;
        la.f36743c = null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public final boolean mo38984i() {
        return this.f37413e.mo38592c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public final boolean mo38985j() {
        C11806dv dvVar = this.f37413e.f36747g;
        return dvVar != null && dvVar.mo38702a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public final boolean mo38986k() {
        C11743La la = this.f37413e;
        return (la.f36745e == null || la.f36750j == null) ? false : true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public final void mo38987l() {
        C11804dl a = this.f37424p.mo38614a();
        if (a == null) {
            mo38983h();
            return;
        }
        C11806dv dvVar = this.f37413e.f36747g;
        C11806dv a2 = C11749Na.m38902a(this.f37414f.mo38888b());
        if (!m39378a(dvVar) && m39378a(a2)) {
            this.f37413e.f36747g = a2;
        }
        C11743La la = this.f37413e;
        String str = a.mo38723d() ? a.mo38722c().equals(C11763Sa.EMAIL) ? a.mo38721b() : a.mo38717a().mo38785a(C11737Ja.m38864a()) : null;
        la.f36743c = str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public final void mo38988m() {
        this.f37417i.mo39073b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public final void mo38989n() {
        this.f37416h.mo39073b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public final void mo38990o() {
        this.f37421m = null;
    }

    public final IBinder onBind(Intent intent) {
        StringBuilder sb = new StringBuilder("onBind(");
        sb.append(m39385b(intent));
        sb.append(")");
        if (!m39393z()) {
            Intent intent2 = f37410b;
            if (intent2 == null) {
                m39373a(intent);
            } else {
                m39373a(intent2);
            }
        }
        return this.f37429u;
    }

    public final void onCreate() {
        StringBuilder sb = new StringBuilder();
        sb.append(PayPalService.class.getSimpleName());
        sb.append(" created. API:");
        sb.append(VERSION.SDK_INT);
        sb.append(" ");
        sb.append(mo38956a().mo38526b());
        Log.w("paypal.sdk", sb.toString());
        new C11867Da();
        this.f37423o = new C11788a(this, "AndroidBasePrefs", new C11723Fa());
        C11828hb.m39168a(this.f37423o);
        C11844lb.m39199a(this.f37423o);
        this.f37422n = C11794bb.m39061a(f37411c, this, this.f37423o.mo38697e(), "2.15.0", null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.paypal.android.sdk.clearAllUserData");
        C11919c.m39521a((Context) this).mo39082a(this.f37428t, intentFilter);
    }

    public final void onDestroy() {
        C11765T t = this.f37420l;
        if (t != null) {
            t.mo38626a();
            this.f37420l.mo38629b();
            this.f37420l = null;
        }
        try {
            C11919c.m39521a((Context) this).mo39081a(this.f37428t);
        } catch (Throwable th) {
            new StringBuilder("ignoring:").append(th.getMessage());
        }
        new StringBuilder("service destroyed: ").append(this);
    }

    public final void onRebind(Intent intent) {
        super.onRebind(intent);
        StringBuilder sb = new StringBuilder("onRebind(");
        sb.append(m39385b(intent));
        sb.append(")");
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        StringBuilder sb = new StringBuilder("onStartCommand(");
        sb.append(m39385b(intent));
        String str = ", ";
        sb.append(str);
        sb.append(i);
        sb.append(str);
        sb.append(i2);
        sb.append(")");
        if (!m39393z()) {
            new C11853nc(this).mo38825a();
            if (intent == null || intent.getExtras() == null) {
                throw new RuntimeException("Service extras required. Please see the docs.");
            }
            m39373a(intent);
        }
        if (this.f37425q.size() > 0) {
            for (C11946ka a : this.f37425q) {
                a.mo38837a();
            }
            this.f37425q.clear();
        }
        return 3;
    }

    public final boolean onUnbind(Intent intent) {
        StringBuilder sb = new StringBuilder("onUnbind(");
        sb.append(m39385b(intent));
        sb.append(")");
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: p */
    public final void mo38997p() {
        C11765T t = this.f37420l;
        C11724Fb fb = new C11724Fb(t, mo38956a(), this.f37420l.mo38530c(), this.f37413e.f36742b.mo38703b(), this.f37414f.mo38899k());
        t.mo38630b(fb);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public final C11804dl mo38998q() {
        return this.f37424p.mo38614a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public final String mo38999r() {
        return this.f37413e.f36743c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: s */
    public final C11805ds mo39000s() {
        return this.f37424p.mo38615a(this.f37414f.mo38899k());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: t */
    public final void mo39001t() {
        this.f37430v = mo39000s();
        this.f37424p.mo38619c();
        if (this.f37430v != null) {
            C11806dv dvVar = this.f37413e.f36742b;
            if (dvVar != null) {
                mo38970a(dvVar.mo38703b(), this.f37430v.mo38730e());
                this.f37430v = null;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: u */
    public final void mo39002u() {
        PayPalConfiguration payPalConfiguration = this.f37414f;
        if (payPalConfiguration != null && payPalConfiguration.mo38903o()) {
            this.f37413e = m39367A();
            m39368B();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public final String mo39003v() {
        return this.f37419k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: w */
    public final boolean mo39004w() {
        return this.f37426r;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: x */
    public final boolean mo39005x() {
        return this.f37427s;
    }
}
