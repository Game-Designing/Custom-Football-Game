package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.paypal.android.sdk.C11708Bb;
import com.paypal.android.sdk.C11723Fa;
import com.paypal.android.sdk.C11737Ja;
import com.paypal.android.sdk.C11756Pb;
import com.paypal.android.sdk.C11761Rb;
import com.paypal.android.sdk.C11769Ua;
import com.paypal.android.sdk.C11770Ub;
import com.paypal.android.sdk.C11772Va;
import com.paypal.android.sdk.C11773Vb;
import com.paypal.android.sdk.C11775Wa;
import com.paypal.android.sdk.C11787_b;
import com.paypal.android.sdk.C11805ds;
import com.paypal.android.sdk.C11806dv;
import com.paypal.android.sdk.C11815eq;
import com.paypal.android.sdk.C11825gc;
import com.paypal.android.sdk.C11829hc;
import com.paypal.android.sdk.C11836jb;
import com.paypal.android.sdk.C12024xb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class PaymentConfirmActivity extends Activity {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f37437a = PaymentConfirmActivity.class.getSimpleName();

    /* renamed from: b */
    private C11881Ka f37438b;

    /* renamed from: c */
    private C11926dx f37439c;

    /* renamed from: d */
    private boolean f37440d;

    /* renamed from: e */
    private boolean f37441e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f37442f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C11787_b f37443g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C11970sa f37444h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C11883La f37445i;

    /* renamed from: j */
    private Parcelable f37446j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public PayPalService f37447k;

    /* renamed from: l */
    private final ServiceConnection f37448l = new C11991za(this);

    /* renamed from: m */
    private boolean f37449m;

    /* renamed from: a */
    private static C11815eq m39449a(PayPalPayment payPalPayment) {
        return new C11815eq(new BigDecimal(C11836jb.m39178a(payPalPayment.mo38927a().doubleValue(), payPalPayment.mo38930d()).trim()), payPalPayment.mo38930d());
    }

    /* renamed from: a */
    private void m39452a(int i) {
        setResult(i, new Intent());
    }

    /* renamed from: a */
    static void m39453a(Activity activity, int i, C11883La la, Parcelable parcelable, PayPalConfiguration payPalConfiguration) {
        m39454a(activity, 2, la, null, payPalConfiguration, false);
    }

    /* renamed from: a */
    static void m39454a(Activity activity, int i, C11883La la, Parcelable parcelable, PayPalConfiguration payPalConfiguration, boolean z) {
        Intent intent = new Intent(activity, PaymentConfirmActivity.class);
        intent.putExtras(activity.getIntent());
        intent.putExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_PAYMENT_KIND", la);
        intent.putExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_CREDIT_CARD", parcelable);
        intent.putExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_RESET_PP_REQUEST_ID", z);
        intent.putExtra("com.paypal.android.sdk.paypalConfiguration", payPalConfiguration);
        activity.startActivityForResult(intent, i);
    }

    /* renamed from: a */
    private void m39455a(Bundle bundle) {
        String string = bundle.getString("authAccount");
        String string2 = bundle.getString("authtoken");
        String string3 = bundle.getString("scope");
        long j = bundle.getLong("valid_until");
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj == null) {
                String.format("%s:null", new Object[]{str});
            } else {
                String.format("%s:%s (%s)", new Object[]{str, obj.toString(), obj.getClass().getName()});
            }
        }
        C11806dv dvVar = new C11806dv(string2, string3, j, false);
        if (this.f37447k == null) {
            this.f37438b = new C11881Ka(this, string, dvVar);
        } else {
            m39460a(string, dvVar);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m39457a(PaymentConfirmActivity paymentConfirmActivity, C11708Bb bb) {
        paymentConfirmActivity.f37439c = new C11926dx(bb, paymentConfirmActivity.f37444h.mo39150a().mo38935h());
        paymentConfirmActivity.getIntent().putExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_PAYMENT_INFO", paymentConfirmActivity.f37439c);
        paymentConfirmActivity.m39464b();
        paymentConfirmActivity.m39482j();
    }

    /* renamed from: a */
    static /* synthetic */ void m39458a(PaymentConfirmActivity paymentConfirmActivity, List list, int i) {
        paymentConfirmActivity.f37444h.mo39151b().mo39095a(i);
        paymentConfirmActivity.f37443g.mo38672a((Context) paymentConfirmActivity, (C11770Ub) list.get(i));
    }

    /* renamed from: a */
    private void m39459a(String str) {
        this.f37443g.mo38676a(str);
    }

    /* renamed from: a */
    private void m39460a(String str, C11806dv dvVar) {
        this.f37447k.mo38978c().f36743c = str;
        m39459a(str);
        this.f37447k.mo38978c().f36747g = dvVar;
        if (this.f37445i != C11883La.PayPal) {
            this.f37443g.mo38682b(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39461a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(f37437a);
        sb.append(".doLogin");
        if (C11944jb.m39590a(this, this.f37447k)) {
            Intent a = new C11769Ua().mo38633a(this.f37447k.mo38979d().mo38899k(), z ? C11772Va.PROMPT_LOGIN : C11772Va.USER_REQUIRED, C11775Wa.token, this.f37447k.mo38976b().mo38531d().mo38697e());
            String str = "scope";
            a.putExtra(str, "https://uri.paypal.com/services/payments/basic");
            StringBuilder sb2 = new StringBuilder("startActivityForResult(");
            sb2.append(a);
            sb2.append(", 2");
            sb2.append(")");
            StringBuilder sb3 = new StringBuilder("requesting ");
            sb3.append(a.getStringExtra("response_type"));
            sb3.append(" with scope={");
            sb3.append(a.getStringExtra(str));
            sb3.append("} from Authenticator.");
            Log.w("paypal.sdk", sb3.toString());
            startActivityForResult(a, 2);
            return;
        }
        LoginActivity.m39261a(this, 1, this.f37447k.mo38998q(), false, z, "https://uri.paypal.com/services/payments/basic", this.f37447k.mo38979d());
    }

    /* renamed from: b */
    private static Map m39463b(PayPalPayment payPalPayment) {
        if (payPalPayment != null) {
            HashMap hashMap = new HashMap();
            PayPalPaymentDetails g = payPalPayment.mo38934g();
            if (g != null) {
                if (g.mo38945a() != null) {
                    hashMap.put("shipping", C11836jb.m39178a(g.mo38945a().doubleValue(), payPalPayment.mo38930d()));
                }
                if (g.mo38946b() != null) {
                    hashMap.put("subtotal", C11836jb.m39178a(g.mo38946b().doubleValue(), payPalPayment.mo38930d()));
                }
                if (g.mo38947c() != null) {
                    hashMap.put("tax", C11836jb.m39178a(g.mo38947c().doubleValue(), payPalPayment.mo38930d()));
                }
            }
            if (!hashMap.isEmpty()) {
                return hashMap;
            }
        }
        return null;
    }

    /* renamed from: b */
    private void m39464b() {
        C11926dx dxVar = this.f37439c;
        if (dxVar != null) {
            JSONObject jSONObject = null;
            if (dxVar.mo39096b() != null) {
                jSONObject = this.f37439c.mo39096b().mo39044a();
            }
            int h = this.f37439c.mo39104h();
            ArrayList a = C11825gc.m39149a(jSONObject, this.f37439c.mo39094a(), this.f37439c.mo39105i());
            if (this.f37444h.mo39150a().mo38939l() || a == null || a.size() <= 0) {
                this.f37443g.mo38688f().setClickable(false);
                this.f37443g.mo38688f().setVisibility(8);
            } else {
                this.f37443g.mo38688f().setVisibility(0);
                this.f37443g.mo38688f().setClickable(true);
                this.f37443g.mo38673a(getApplicationContext(), (C11825gc) a.get(h));
                C11829hc hcVar = new C11829hc(this, a, h);
                new ListView(this).setAdapter(hcVar);
                this.f37443g.mo38686d(new C11869Ea(this, hcVar, a));
            }
            int g = this.f37439c.mo39103g();
            ArrayList a2 = C11770Ub.m38980a(this.f37439c.mo39098c(), this.f37439c.mo39099d());
            if (a2 == null || a2.size() <= 0) {
                this.f37443g.mo38687e().setClickable(false);
                this.f37443g.mo38687e().setVisibility(8);
            } else {
                this.f37443g.mo38687e().setVisibility(0);
                this.f37443g.mo38687e().setClickable(true);
                this.f37443g.mo38672a(getApplicationContext(), (C11770Ub) a2.get(g));
                C11773Vb vb = new C11773Vb(this, a2, g);
                new ListView(this).setAdapter(vb);
                this.f37443g.mo38684c(new C11863Ba(this, vb, a2));
            }
            this.f37443g.mo38682b(true);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m39465b(PaymentConfirmActivity paymentConfirmActivity) {
        StringBuilder sb = new StringBuilder();
        sb.append(f37437a);
        sb.append(".postBindSetup()");
        if (paymentConfirmActivity.f37445i.equals(C11883La.PayPal)) {
            paymentConfirmActivity.f37443g.mo38674a(C11723Fa.m38820b(paymentConfirmActivity.f37447k.mo38979d().mo38886a()));
        } else {
            paymentConfirmActivity.f37443g.mo38674a((SpannableString) null);
        }
        C11881Ka ka = paymentConfirmActivity.f37438b;
        if (ka != null) {
            paymentConfirmActivity.m39460a(ka.f37314a, ka.f37315b);
            paymentConfirmActivity.f37438b = null;
        }
        if (paymentConfirmActivity.getIntent().getBooleanExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_RESET_PP_REQUEST_ID", false)) {
            paymentConfirmActivity.f37447k.mo38978c().mo38590a();
        }
        boolean e = paymentConfirmActivity.m39473e();
        if (!paymentConfirmActivity.f37440d) {
            paymentConfirmActivity.f37440d = true;
            paymentConfirmActivity.f37447k.mo38965a(C12024xb.ConfirmPaymentWindow);
        }
        paymentConfirmActivity.m39474f();
        paymentConfirmActivity.f37447k.mo38977b((C11931fa) new C11873Ga(paymentConfirmActivity));
        if (C11883La.PayPal == paymentConfirmActivity.f37445i && !e && !paymentConfirmActivity.f37442f && paymentConfirmActivity.f37439c == null) {
            paymentConfirmActivity.m39481i();
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m39466b(PaymentConfirmActivity paymentConfirmActivity, List list, int i) {
        paymentConfirmActivity.f37444h.mo39151b().mo39097b(i);
        paymentConfirmActivity.f37443g.mo38673a((Context) paymentConfirmActivity, (C11825gc) list.get(i));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m39469c() {
        if (this.f37447k.mo38978c().f36747g != null && !this.f37447k.mo38978c().f36747g.mo38736c()) {
            this.f37447k.mo38978c().f36747g = null;
            this.f37447k.mo38978c().f36743c = null;
        }
    }

    /* renamed from: d */
    private void m39471d() {
        this.f37449m = bindService(C11867Da.m39245b((Activity) this), this.f37448l, 1);
    }

    /* renamed from: e */
    private boolean m39473e() {
        if (!this.f37445i.equals(C11883La.PayPal) || this.f37447k.mo38985j() || this.f37441e) {
            return false;
        }
        this.f37441e = true;
        m39461a(false);
        return true;
    }

    /* renamed from: f */
    private void m39474f() {
        Enum enumR;
        int i;
        int i2;
        String str;
        PayPalPayment a = this.f37444h.mo39150a();
        this.f37443g.mo38678a(a.mo38928b(), C11836jb.m39182a(Locale.getDefault(), C11737Ja.m38864a().mo38577c().mo38767a(), a.mo38927a().doubleValue(), a.mo38930d(), true));
        C11883La la = this.f37445i;
        if (la == C11883La.PayPal) {
            this.f37443g.mo38679a(true);
            m39459a(this.f37447k.mo38999r());
        } else if (la == C11883La.CreditCard || la == C11883La.CreditCardToken) {
            this.f37443g.mo38679a(false);
            if (this.f37445i == C11883La.CreditCard) {
                str = C11805ds.m39085a(C11867Da.m39236a(this.f37446j));
                i2 = C11867Da.m39244b(this.f37446j, "expiryMonth");
                i = C11867Da.m39244b(this.f37446j, "expiryYear");
                enumR = C11867Da.m39246b(this.f37446j);
            } else {
                C11805ds s = this.f37447k.mo39000s();
                String d = s.mo38728d();
                int f = s.mo38731f();
                int g = s.mo38732g();
                enumR = C11867Da.m39234a(s);
                str = d;
                i2 = f;
                i = g;
            }
            this.f37443g.mo38677a(str, C11867Da.m39232a((Activity) this, enumR), String.format(Locale.getDefault(), "%02d / %04d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)}));
        } else {
            String str2 = f37437a;
            StringBuilder sb = new StringBuilder("Unknown payment type: ");
            sb.append(this.f37445i.toString());
            Log.wtf(str2, sb.toString());
            C11867Da.m39241a((Activity) this, "The payment is not a valid type. Please try again.", 3);
        }
        C11867Da.m39242a(this.f37443g.mo38685d(), this.f37447k.mo38980e());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0044, code lost:
        if (m39473e() == false) goto L_0x003e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0049 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004a  */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m39477g() {
        /*
            r23 = this;
            r0 = r23
            int[] r1 = com.paypal.android.sdk.payments.C11985xa.f37623a
            com.paypal.android.sdk.payments.La r2 = r0.f37445i
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == r5) goto L_0x0040
            if (r1 == r4) goto L_0x0017
            if (r1 == r3) goto L_0x0017
            goto L_0x003e
        L_0x0017:
            com.paypal.android.sdk.payments.PayPalService r1 = r0.f37447k
            boolean r1 = r1.mo38984i()
            if (r1 != 0) goto L_0x003e
            r0.showDialog(r4)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r6 = "token is expired, get new one. AccessToken: "
            r1.<init>(r6)
            com.paypal.android.sdk.payments.PayPalService r6 = r0.f37447k
            com.paypal.android.sdk.La r6 = r6.mo38978c()
            com.paypal.android.sdk.dv r6 = r6.f36742b
            r1.append(r6)
            com.paypal.android.sdk.payments.PayPalService r1 = r0.f37447k
            com.paypal.android.sdk.payments.ha r6 = r23.m39478h()
            r1.mo38964a(r6, r5)
            goto L_0x0047
        L_0x003e:
            r2 = 1
            goto L_0x0047
        L_0x0040:
            boolean r1 = r23.m39473e()
            if (r1 != 0) goto L_0x0047
            goto L_0x003e
        L_0x0047:
            if (r2 != 0) goto L_0x004a
            return
        L_0x004a:
            r0.showDialog(r4)
            com.paypal.android.sdk.payments.sa r1 = r0.f37444h
            if (r1 == 0) goto L_0x016e
            com.paypal.android.sdk.payments.PayPalPayment r1 = r1.mo39150a()
            if (r1 == 0) goto L_0x016e
            com.paypal.android.sdk.payments.La r1 = r0.f37445i
            com.paypal.android.sdk.payments.La r2 = com.paypal.android.sdk.payments.C11883La.PayPal
            if (r1 != r2) goto L_0x0067
            com.paypal.android.sdk.payments.sa r1 = r0.f37444h
            com.paypal.android.sdk.payments.dx r1 = r1.mo39151b()
            if (r1 != 0) goto L_0x0067
            goto L_0x016e
        L_0x0067:
            com.paypal.android.sdk.payments.sa r1 = r0.f37444h
            com.paypal.android.sdk.payments.PayPalPayment r1 = r1.mo39150a()
            com.paypal.android.sdk.eq r2 = m39449a(r1)
            java.util.Map r14 = m39463b(r1)
            java.lang.String r16 = r1.mo38928b()
            com.paypal.android.sdk.payments.PayPalService r6 = r0.f37447k
            com.paypal.android.sdk.payments.PayPalConfiguration r6 = r6.mo38979d()
            boolean r17 = r6.mo38898j()
            int[] r6 = com.paypal.android.sdk.payments.C11985xa.f37623a
            com.paypal.android.sdk.payments.La r7 = r0.f37445i
            int r7 = r7.ordinal()
            r6 = r6[r7]
            if (r6 == r5) goto L_0x0139
            if (r6 == r4) goto L_0x00f0
            if (r6 == r3) goto L_0x0094
            goto L_0x00ef
        L_0x0094:
            com.paypal.android.sdk.payments.PayPalService r3 = r0.f37447k
            r6 = r3
            com.paypal.android.sdk.La r3 = r3.mo38978c()
            java.lang.String r7 = r3.mo38591b()
            android.os.Parcelable r3 = r0.f37446j
            java.lang.Enum r3 = com.paypal.android.sdk.payments.C11867Da.m39246b(r3)
            java.lang.String r3 = r3.name()
            java.util.Locale r4 = java.util.Locale.US
            java.lang.String r8 = r3.toLowerCase(r4)
            android.os.Parcelable r3 = r0.f37446j
            java.lang.String r4 = "cardNumber"
            java.lang.String r9 = com.paypal.android.sdk.payments.C11867Da.m39237a(r3, r4)
            android.os.Parcelable r3 = r0.f37446j
            java.lang.String r4 = "cvv"
            java.lang.String r10 = com.paypal.android.sdk.payments.C11867Da.m39237a(r3, r4)
            android.os.Parcelable r3 = r0.f37446j
            java.lang.String r4 = "expiryMonth"
            int r11 = com.paypal.android.sdk.payments.C11867Da.m39244b(r3, r4)
            android.os.Parcelable r3 = r0.f37446j
            java.lang.String r4 = "expiryYear"
            int r12 = com.paypal.android.sdk.payments.C11867Da.m39244b(r3, r4)
            com.paypal.android.sdk.payments.PayPalItem[] r15 = r1.mo38936i()
            java.lang.String r18 = r1.mo38932e()
            java.lang.String r3 = r1.mo38929c()
            java.lang.String r19 = r3.toString()
            java.lang.String r20 = r1.mo38937j()
            java.lang.String r21 = r1.mo38941n()
            java.lang.String r22 = r1.mo38942o()
            r13 = r2
            r6.mo38972a(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
        L_0x00ef:
            return
        L_0x00f0:
            com.paypal.android.sdk.payments.PayPalService r3 = r0.f37447k
            com.paypal.android.sdk.ds r3 = r3.mo39000s()
            com.paypal.android.sdk.payments.PayPalService r4 = r0.f37447k
            java.lang.String r5 = r3.mo38631a()
            java.lang.String r4 = r4.mo38957a(r5)
            com.paypal.android.sdk.payments.PayPalService r6 = r0.f37447k
            com.paypal.android.sdk.La r5 = r6.mo38978c()
            java.lang.String r7 = r5.mo38591b()
            java.lang.String r8 = r3.mo38730e()
            com.paypal.android.sdk.payments.PayPalItem[] r11 = r1.mo38936i()
            java.lang.String r15 = r1.mo38932e()
            java.lang.String r3 = r1.mo38929c()
            java.lang.String r3 = r3.toString()
            java.lang.String r5 = r1.mo38937j()
            java.lang.String r18 = r1.mo38941n()
            java.lang.String r19 = r1.mo38942o()
            r9 = r2
            r10 = r14
            r12 = r16
            r13 = r17
            r14 = r4
            r16 = r3
            r17 = r5
            r6.mo38971a(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return
        L_0x0139:
            com.paypal.android.sdk.payments.sa r2 = r0.f37444h
            com.paypal.android.sdk.payments.dx r2 = r2.mo39151b()
            com.paypal.android.sdk.payments.PayPalService r7 = r0.f37447k
            java.lang.String r9 = r2.mo39101e()
            java.lang.String r10 = r2.mo39102f()
            boolean r3 = r2.mo39107k()
            r4 = 0
            if (r3 == 0) goto L_0x0156
            org.json.JSONObject r3 = r2.mo39109m()
            r11 = r3
            goto L_0x0157
        L_0x0156:
            r11 = r4
        L_0x0157:
            boolean r3 = r2.mo39106j()
            if (r3 == 0) goto L_0x0163
            org.json.JSONObject r2 = r2.mo39108l()
            r12 = r2
            goto L_0x0164
        L_0x0163:
            r12 = r4
        L_0x0164:
            java.lang.String r13 = r1.mo38932e()
            r8 = r17
            r7.mo38974a(r8, r9, r10, r11, r12, r13)
            return
        L_0x016e:
            r23.onBackPressed()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.sdk.payments.PaymentConfirmActivity.m39477g():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public C11937ha m39478h() {
        return new C11982wa(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m39481i() {
        PayPalService payPalService = this.f37447k;
        if (payPalService != null && payPalService.mo38978c().f36747g != null) {
            showDialog(2);
            PayPalPayment a = this.f37444h.mo39150a();
            this.f37447k.mo38962a(m39449a(a), m39463b(a), a.mo38936i(), a.mo38928b(), this.f37447k.mo38979d().mo38898j(), a.mo38932e(), a.mo38929c().toString(), a.mo38938k(), a.mo38937j(), a.mo38941n(), a.mo38942o(), a.mo38939l(), a.mo38933f());
            this.f37442f = true;
            m39459a(this.f37447k.mo38999r());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m39482j() {
        try {
            dismissDialog(2);
        } catch (IllegalArgumentException e) {
        }
    }

    public final void finish() {
        super.finish();
        StringBuilder sb = new StringBuilder();
        sb.append(f37437a);
        sb.append(".finish");
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        StringBuilder sb = new StringBuilder();
        sb.append(f37437a);
        sb.append(".onActivityResult(requestCode:");
        sb.append(i);
        sb.append(", resultCode:");
        sb.append(i2);
        sb.append(", data:");
        sb.append(intent);
        sb.append(")");
        if (i != 1) {
            if (i != 2) {
                String str = f37437a;
                StringBuilder sb2 = new StringBuilder("unhandled requestCode ");
                sb2.append(i);
                Log.e(str, sb2.toString());
            } else {
                this.f37441e = false;
                if (i2 == -1) {
                    this.f37443g.mo38682b(true);
                    m39455a(intent.getExtras());
                    if (this.f37447k != null) {
                        m39481i();
                        return;
                    }
                }
            }
            return;
        }
        this.f37441e = false;
        if (i2 == -1) {
            C11787_b _bVar = this.f37443g;
            if (_bVar != null) {
                _bVar.mo38682b(false);
            }
            if (this.f37447k != null) {
                m39481i();
            }
            return;
        }
        m39452a(i2);
        finish();
    }

    public final void onBackPressed() {
        this.f37447k.mo38965a(C12024xb.ConfirmPaymentCancel);
        m39469c();
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StringBuilder sb = new StringBuilder();
        sb.append(f37437a);
        sb.append(".onCreate");
        m39471d();
        boolean z = false;
        if (bundle == null) {
            if (!C11867Da.m39243a((Activity) this)) {
                finish();
            }
            this.f37440d = false;
        } else {
            this.f37440d = bundle.getBoolean("pageTrackingSent");
            this.f37441e = bundle.getBoolean("isLoginActivityInProgress");
            this.f37442f = bundle.getBoolean("isSFOPaymentRequestInProgress");
        }
        if (getIntent().getExtras() == null) {
            onBackPressed();
            return;
        }
        this.f37445i = (C11883La) getIntent().getSerializableExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_PAYMENT_KIND");
        this.f37446j = getIntent().getParcelableExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_CREDIT_CARD");
        this.f37444h = new C11970sa(getIntent());
        setTheme(16973934);
        requestWindowFeature(8);
        if (this.f37445i == C11883La.PayPal) {
            z = true;
        }
        this.f37443g = new C11787_b(this, z);
        setContentView(this.f37443g.mo38671a());
        C11867Da.m39239a((Activity) this, this.f37443g.mo38680b(), C11761Rb.CONFIRM);
        this.f37443g.mo38681b((OnClickListener) new C11973ta(this));
        this.f37443g.mo38675a((OnClickListener) new C11988ya(this));
        if (C11883La.PayPal == this.f37445i) {
            this.f37439c = (C11926dx) getIntent().getParcelableExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_PAYMENT_INFO");
            m39464b();
        }
    }

    /* access modifiers changed from: protected */
    public final Dialog onCreateDialog(int i, Bundle bundle) {
        if (i == 1) {
            return C11867Da.m39228a((Activity) this, C11761Rb.PAY_FAILED_ALERT_TITLE, bundle);
        }
        if (i == 2) {
            return C11867Da.m39231a((Context) this, C11761Rb.PROCESSING, C11761Rb.ONE_MOMENT);
        }
        if (i == 3) {
            return C11867Da.m39229a((Activity) this, C11761Rb.INTERNAL_ERROR, bundle, i);
        }
        if (i == 4) {
            return C11867Da.m39230a((Activity) this, C11761Rb.SESSION_EXPIRED_TITLE, bundle, (DialogInterface.OnClickListener) new C11875Ha(this));
        }
        if (i != 5) {
            return null;
        }
        C11756Pb.m38949a(C11761Rb.UNEXPECTED_PAYMENT_FLOW);
        if (bundle != null) {
            String str = "BUNDLE_ERROR_CODE";
            if (C11723Fa.m38822b((CharSequence) bundle.getString(str))) {
                String string = bundle.getString(str);
                C11761Rb rb = C11761Rb.WE_ARE_SORRY;
                String a = C11756Pb.m38950a(string);
                C11761Rb rb2 = C11761Rb.TRY_AGAIN;
                C11761Rb rb3 = C11761Rb.CANCEL;
                C11877Ia ia = new C11877Ia(this);
                return new Builder(this).setIcon(17301543).setTitle(C11756Pb.m38949a(rb)).setMessage(a).setPositiveButton(C11756Pb.m38949a(rb2), ia).setNegativeButton(C11756Pb.m38949a(rb3), new C11879Ja(this)).create();
            }
        }
        C11761Rb rb4 = C11761Rb.WE_ARE_SORRY;
        C11761Rb rb5 = C11761Rb.UNEXPECTED_PAYMENT_FLOW;
        C11761Rb rb6 = C11761Rb.TRY_AGAIN;
        C11761Rb rb7 = C11761Rb.CANCEL;
        C11976ua uaVar = new C11976ua(this);
        return new Builder(this).setIcon(17301543).setTitle(C11756Pb.m38949a(rb4)).setMessage(C11756Pb.m38949a(rb5)).setPositiveButton(C11756Pb.m38949a(rb6), uaVar).setNegativeButton(C11756Pb.m38949a(rb7), new C11979va(this)).create();
    }

    /* access modifiers changed from: protected */
    public final void onDestroy() {
        StringBuilder sb = new StringBuilder();
        sb.append(f37437a);
        sb.append(".onDestroy");
        PayPalService payPalService = this.f37447k;
        if (payPalService != null) {
            payPalService.mo38988m();
        }
        if (this.f37449m) {
            unbindService(this.f37448l);
            this.f37449m = false;
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public final void onRestart() {
        super.onRestart();
        m39471d();
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        StringBuilder sb = new StringBuilder();
        sb.append(f37437a);
        sb.append(".onResume");
        if (this.f37447k != null) {
            m39474f();
        }
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("pageTrackingSent", this.f37440d);
        bundle.putBoolean("isLoginActivityInProgress", this.f37441e);
        bundle.putBoolean("isSFOPaymentRequestInProgress", this.f37442f);
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        StringBuilder sb = new StringBuilder();
        sb.append(f37437a);
        sb.append(".onWindowFocusChanged");
        this.f37443g.mo38683c();
    }
}
