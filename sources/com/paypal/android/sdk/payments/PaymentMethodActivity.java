package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import com.paypal.android.sdk.C11715Da;
import com.paypal.android.sdk.C11756Pb;
import com.paypal.android.sdk.C11761Rb;
import com.paypal.android.sdk.C11791ac;
import com.paypal.android.sdk.C11805ds;
import com.paypal.android.sdk.C12024xb;
import java.util.Timer;

public final class PaymentMethodActivity extends Activity {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f37454a = PaymentMethodActivity.class.getSimpleName();

    /* renamed from: b */
    private Timer f37455b;

    /* renamed from: c */
    private boolean f37456c;

    /* renamed from: d */
    private boolean f37457d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f37458e;

    /* renamed from: f */
    private boolean f37459f;

    /* renamed from: g */
    private C11791ac f37460g;

    /* renamed from: h */
    private C11970sa f37461h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public PayPalService f37462i;

    /* renamed from: j */
    private final ServiceConnection f37463j = new C11900Ua(this);

    /* renamed from: k */
    private boolean f37464k;

    /* renamed from: a */
    static void m39488a(Activity activity, int i, PayPalConfiguration payPalConfiguration) {
        Intent intent = new Intent(activity, PaymentMethodActivity.class);
        intent.putExtras(activity.getIntent());
        intent.putExtra("com.paypal.android.sdk.paypalConfiguration", payPalConfiguration);
        activity.startActivityForResult(intent, 1);
    }

    /* renamed from: a */
    static /* synthetic */ void m39489a(PaymentMethodActivity paymentMethodActivity) {
        paymentMethodActivity.f37462i.mo38965a(C12024xb.SelectPayPalPayment);
        PaymentConfirmActivity.m39454a(paymentMethodActivity, 2, C11883La.PayPal, null, paymentMethodActivity.f37462i.mo38979d(), true);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m39491b() {
        if (this.f37458e && !this.f37457d) {
            this.f37460g.f37133n.setImageBitmap(C11715Da.m38792c("iVBORw0KGgoAAAANSUhEUgAAADcAAAAsCAYAAADByiAeAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAohJREFUeNrcWYGRgjAQJMwXQAl0IFbwWMFrBS8VvHYAFagVoBVIB2IFaAV8B08H/GUm/GA+CUouBL2ZTByEwCZ3m70LcRCsrusQutDBswranhBSOTYNgC1rM1ZA82yD+6nN2Urn21xNYAF0Jmf33Ro45DhDH9+1ObN3mMe84yVXTusd7ojjTds7iIzeoZtAU7mE1/E/5p536fj/yvbFb+VmDK2sn9c27b2RcKuVOs9vdJVnVN0QBsyHrjAQQ9RNMmhn5j5tC1g8zQ0A3AK4dbNqKbJ7nJjevIeYKN3HBpSOjy2h6DjznuxLQR4xpZvbYj4MX5+CO2S9aJvGCCEL+LnGEgBv2EEsWRXqIj4HJpeA3ML9FRq5IbhioEiHCsVz6V9s/H9WlwdiDHArSfycHpicpWSM0ia4UvJRRY+xlsiJcKwrnBPBtbSnLEt594b427O9cvisgL2cr6XobMobwbWdDXAitvvUTW8E5JTbAHcWXMOQUiHnHRcb4CrBXoYhBiYSjTooOH5GfSRB4I8BnI/xAV0eoTNxaOCUWfBjdh0DOFFsZAjgMkGtZnBCCTH3pIb2BewY2gDn8bkbU/q5xpgJ5t6pK7++BNcWHdUqmUV8GsQUj72irGD1KNvNHgQY8VJOIccGz+c8ybhxR9pyVOSCsW4+11S/asOZeMCIwWvdnyvuxygzJhgrh3pYiHiYqZ3P8XXI4t6SniTJ3WAWhjHBNUripKqNKNyQFoVXmB+DFXOqWDyw/tLEGItBCv6DpUkmTouSBlyJqOrHYlHjlocXA0Y9JGvAbSWpxrPajoaAy6mKVwBIDyHjG7ZkanyqKXxtu+IacEQ3bCmgZt8gixlhZdEBzK8AAwBIvuGtI5K/kgAAAABJRU5ErkJggg==", (Context) this));
            this.f37460g.f37133n.setVisibility(0);
            this.f37460g.f37133n.setContentDescription(C11756Pb.m38949a(C11761Rb.SCAN_CARD_ICON_DESCRIPTION));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x013e  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m39493c() {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = f37454a
            r0.append(r1)
            java.lang.String r1 = ".refreshPayment"
            r0.append(r1)
            com.paypal.android.sdk.payments.PayPalService r0 = r8.f37462i
            boolean r0 = com.paypal.android.sdk.payments.C11944jb.m39590a(r8, r0)
            if (r0 == 0) goto L_0x001c
            com.paypal.android.sdk.payments.PayPalService r0 = r8.f37462i
            r0.mo38983h()
        L_0x001c:
            com.paypal.android.sdk.payments.sa r0 = r8.f37461h
            com.paypal.android.sdk.payments.PayPalPayment r0 = r0.mo39150a()
            com.paypal.android.sdk.Ja r1 = com.paypal.android.sdk.C11737Ja.m38864a()
            java.util.Locale r2 = java.util.Locale.getDefault()
            com.paypal.android.sdk.eh r1 = r1.mo38577c()
            java.lang.String r3 = r1.mo38767a()
            java.math.BigDecimal r1 = r0.mo38927a()
            double r4 = r1.doubleValue()
            java.lang.String r6 = r0.mo38930d()
            r7 = 1
            java.lang.String r1 = com.paypal.android.sdk.C11836jb.m39182a(r2, r3, r4, r6, r7)
            com.paypal.android.sdk.ac r2 = r8.f37460g
            com.paypal.android.sdk.fc r2 = r2.f37122c
            android.widget.TextView r2 = r2.f37208d
            java.lang.String r0 = r0.mo38928b()
            r2.setText(r0)
            com.paypal.android.sdk.ac r0 = r8.f37460g
            com.paypal.android.sdk.fc r0 = r0.f37122c
            android.widget.TextView r0 = r0.f37207c
            r0.setText(r1)
            com.paypal.android.sdk.payments.PayPalService r0 = r8.f37462i
            boolean r0 = r0.mo38985j()
            r1 = 0
            r2 = 8
            if (r0 == 0) goto L_0x0094
            com.paypal.android.sdk.payments.PayPalService r0 = r8.f37462i
            com.paypal.android.sdk.La r0 = r0.mo38978c()
            com.paypal.android.sdk.dv r0 = r0.f36747g
            boolean r0 = r0.mo38736c()
            if (r0 == 0) goto L_0x0094
            com.paypal.android.sdk.payments.PayPalService r0 = r8.f37462i
            java.lang.String r0 = r0.mo38999r()
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x0094
            com.paypal.android.sdk.ac r3 = r8.f37460g
            android.widget.TextView r3 = r3.f37123d
            r3.setText(r0)
            com.paypal.android.sdk.ac r0 = r8.f37460g
            android.widget.TextView r0 = r0.f37123d
            r0.setVisibility(r1)
            com.paypal.android.sdk.ac r0 = r8.f37460g
            android.widget.Button r0 = r0.f37121b
            r0.setVisibility(r1)
            goto L_0x00a2
        L_0x0094:
            com.paypal.android.sdk.ac r0 = r8.f37460g
            android.widget.TextView r0 = r0.f37123d
            r0.setVisibility(r2)
            com.paypal.android.sdk.ac r0 = r8.f37460g
            android.widget.Button r0 = r0.f37121b
            r0.setVisibility(r2)
        L_0x00a2:
            com.paypal.android.sdk.payments.PayPalService r0 = r8.f37462i
            com.paypal.android.sdk.payments.PayPalConfiguration r0 = r0.mo38979d()
            boolean r0 = r0.mo38897i()
            if (r0 == 0) goto L_0x013e
            com.paypal.android.sdk.payments.Wa r0 = new com.paypal.android.sdk.payments.Wa
            r0.<init>(r8, r1)
            java.lang.Void[] r3 = new java.lang.Void[r1]
            r0.execute(r3)
            com.paypal.android.sdk.payments.PayPalService r0 = r8.f37462i
            com.paypal.android.sdk.ds r0 = r0.mo39000s()
            if (r0 == 0) goto L_0x011f
            boolean r3 = r0.mo38726b()
            if (r3 == 0) goto L_0x011f
            r3 = 1
            r8.f37457d = r3
            com.paypal.android.sdk.ac r3 = r8.f37460g
            android.widget.ImageView r3 = r3.f37133n
            r3.setVisibility(r2)
            com.paypal.android.sdk.ac r2 = r8.f37460g
            android.widget.TextView r2 = r2.f37125f
            java.lang.String r3 = r0.mo38728d()
            r2.setText(r3)
            java.lang.Enum r0 = com.paypal.android.sdk.payments.C11867Da.m39234a(r0)
            com.paypal.android.sdk.ac r2 = r8.f37460g
            android.widget.ImageView r2 = r2.f37127h
            android.graphics.Bitmap r3 = com.paypal.android.sdk.payments.C11867Da.m39232a(r8, r0)
            r2.setImageBitmap(r3)
            com.paypal.android.sdk.ac r2 = r8.f37460g
            android.widget.ImageView r2 = r2.f37127h
            java.lang.String r0 = r0.toString()
            r2.setContentDescription(r0)
            com.paypal.android.sdk.ac r0 = r8.f37460g
            android.widget.ImageView r0 = r0.f37127h
            r0.setVisibility(r1)
            com.paypal.android.sdk.Rb r0 = com.paypal.android.sdk.C11761Rb.CLEAR_CREDIT_CARD_INFO
            java.lang.String r0 = com.paypal.android.sdk.C11756Pb.m38949a(r0)
            com.paypal.android.sdk.ac r2 = r8.f37460g
            android.widget.Button r2 = r2.f37131l
            r2.setText(r0)
            com.paypal.android.sdk.ac r0 = r8.f37460g
            android.widget.Button r0 = r0.f37131l
            r0.setVisibility(r1)
            com.paypal.android.sdk.ac r0 = r8.f37460g
            android.widget.LinearLayout r0 = r0.f37128i
            r0.setVisibility(r1)
            com.paypal.android.sdk.ac r0 = r8.f37460g
            android.widget.Button r0 = r0.f37131l
            r0.setVisibility(r1)
            goto L_0x013a
        L_0x011f:
            com.paypal.android.sdk.ac r0 = r8.f37460g
            android.widget.ImageView r0 = r0.f37127h
            r0.setVisibility(r2)
            com.paypal.android.sdk.ac r0 = r8.f37460g
            android.widget.TextView r0 = r0.f37125f
            com.paypal.android.sdk.Rb r1 = com.paypal.android.sdk.C11761Rb.PAY_WITH_CARD
            java.lang.String r1 = com.paypal.android.sdk.C11756Pb.m38949a(r1)
            r0.setText(r1)
            com.paypal.android.sdk.ac r0 = r8.f37460g
            android.widget.Button r0 = r0.f37131l
            r0.setVisibility(r2)
        L_0x013a:
            r8.m39491b()
            goto L_0x014c
        L_0x013e:
            com.paypal.android.sdk.ac r0 = r8.f37460g
            android.widget.LinearLayout r0 = r0.f37128i
            r0.setVisibility(r2)
            com.paypal.android.sdk.ac r0 = r8.f37460g
            android.widget.Button r0 = r0.f37131l
            r0.setVisibility(r2)
        L_0x014c:
            com.paypal.android.sdk.ac r0 = r8.f37460g
            com.paypal.android.sdk.Tb r0 = r0.f37129j
            android.widget.TextView r0 = r0.f37036c
            com.paypal.android.sdk.payments.PayPalService r1 = r8.f37462i
            com.paypal.android.sdk.payments.PayPalConfiguration r1 = r1.mo38979d()
            java.lang.String r1 = r1.mo38888b()
            com.paypal.android.sdk.payments.C11867Da.m39242a(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.sdk.payments.PaymentMethodActivity.m39493c():void");
    }

    /* renamed from: c */
    static /* synthetic */ void m39494c(PaymentMethodActivity paymentMethodActivity) {
        paymentMethodActivity.f37462i.mo38965a(C12024xb.SelectCreditCardPayment);
        C11805ds s = paymentMethodActivity.f37462i.mo39000s();
        if (s == null || !s.mo38726b()) {
            String a = paymentMethodActivity.f37462i.mo38979d().mo38886a();
            String str = "io.card.payment.CardIOActivity";
            Intent intent = new Intent(paymentMethodActivity, C11867Da.m39233a(str));
            intent.putExtra(C11867Da.m39238a(str, "EXTRA_LANGUAGE_OR_LOCALE"), a);
            intent.putExtra(C11867Da.m39238a(str, "EXTRA_REQUIRE_EXPIRY"), true);
            intent.putExtra(C11867Da.m39238a(str, "EXTRA_REQUIRE_CVV"), true);
            StringBuilder sb = new StringBuilder("startActivityForResult(");
            sb.append(intent);
            sb.append(", 1");
            sb.append(")");
            paymentMethodActivity.startActivityForResult(intent, 1);
            return;
        }
        PaymentConfirmActivity.m39453a(paymentMethodActivity, 2, C11883La.CreditCardToken, null, paymentMethodActivity.f37462i.mo38979d());
    }

    /* renamed from: d */
    private void m39495d() {
        this.f37464k = bindService(C11867Da.m39245b((Activity) this), this.f37463j, 1);
    }

    /* renamed from: i */
    static /* synthetic */ void m39501i(PaymentMethodActivity paymentMethodActivity) {
        if (!paymentMethodActivity.f37459f) {
            paymentMethodActivity.f37459f = true;
            paymentMethodActivity.f37462i.mo38965a(C12024xb.PaymentMethodWindow);
        }
        boolean z = !paymentMethodActivity.f37456c && (!paymentMethodActivity.f37462i.mo38979d().mo38897i() || paymentMethodActivity.f37462i.mo39000s() == null);
        new StringBuilder("autoAdvanceToPayPalConfirmIfLoggedIn: ").append(z);
        if (!C11944jb.m39590a(paymentMethodActivity, paymentMethodActivity.f37462i) && ((!paymentMethodActivity.f37462i.mo38979d().mo38897i() && !paymentMethodActivity.f37456c) || (z && paymentMethodActivity.f37462i.mo38985j() && paymentMethodActivity.f37462i.mo38978c().f36747g.mo38736c()))) {
            paymentMethodActivity.showDialog(3);
            paymentMethodActivity.f37456c = true;
            paymentMethodActivity.f37455b = new Timer();
            paymentMethodActivity.f37455b.schedule(new C11894Ra(paymentMethodActivity), 1000);
            paymentMethodActivity.f37456c = true;
        }
        paymentMethodActivity.m39493c();
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        StringBuilder sb = new StringBuilder();
        sb.append(f37454a);
        sb.append(".onActivityResult (requestCode: ");
        sb.append(i);
        sb.append(", resultCode: ");
        sb.append(i2);
        sb.append(")");
        if (i != 1) {
            if (i == 2) {
                if (i2 == -1) {
                    String str = "com.paypal.android.sdk.paymentConfirmation";
                    PaymentConfirmation paymentConfirmation = (PaymentConfirmation) intent.getParcelableExtra(str);
                    Intent intent2 = new Intent();
                    intent2.putExtra(str, paymentConfirmation);
                    setResult(i2, intent2);
                    finish();
                } else if (i2 == 0) {
                    this.f37456c = true;
                }
            }
        } else if (intent != null) {
            String str2 = "EXTRA_SCAN_RESULT";
            String str3 = "io.card.payment.CardIOActivity";
            if (intent.hasExtra(C11867Da.m39238a(str3, str2))) {
                PaymentConfirmActivity.m39454a(this, 2, C11883La.CreditCard, intent.getParcelableExtra(C11867Da.m39238a(str3, str2)), (PayPalConfiguration) getIntent().getParcelableExtra("com.paypal.android.sdk.paypalConfiguration"), true);
            }
        }
    }

    public final void onBackPressed() {
        StringBuilder sb = new StringBuilder();
        sb.append(f37454a);
        sb.append(".onBackPressed");
        PayPalService payPalService = this.f37462i;
        if (payPalService != null) {
            payPalService.mo38965a(C12024xb.PaymentMethodCancel);
        }
        Timer timer = this.f37455b;
        if (timer != null) {
            timer.cancel();
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        StringBuilder sb = new StringBuilder();
        sb.append(f37454a);
        sb.append(".onCreate");
        setTheme(16973934);
        requestWindowFeature(8);
        m39495d();
        this.f37460g = new C11791ac(this);
        this.f37461h = new C11970sa(getIntent());
        setContentView(this.f37460g.f37120a);
        C11867Da.m39239a((Activity) this, this.f37460g.f37132m, C11761Rb.YOUR_ORDER);
        this.f37460g.f37126g.setText(C11756Pb.m38949a(C11761Rb.PAY_WITH));
        this.f37460g.f37121b.setText(C11756Pb.m38949a(C11761Rb.LOG_OUT_BUTTON));
        this.f37460g.f37130k.setOnClickListener(new C11887Na(this));
        this.f37460g.f37121b.setOnClickListener(new C11889Oa(this));
        this.f37460g.f37128i.setOnClickListener(new C11891Pa(this));
        this.f37460g.f37131l.setOnClickListener(new C11893Qa(this));
        if (bundle == null) {
            if (!C11867Da.m39243a((Activity) this)) {
                finish();
            }
            z = false;
        } else {
            this.f37456c = bundle.getBoolean("PP_PreventAutoLogin");
            z = bundle.getBoolean("PP_PageTrackingSent");
        }
        this.f37459f = z;
        this.f37455b = null;
    }

    /* access modifiers changed from: protected */
    public final Dialog onCreateDialog(int i, Bundle bundle) {
        if (i == 1) {
            return C11867Da.m39225a((Activity) this, C11761Rb.LOG_OUT, C11761Rb.CONFIRM_LOG_OUT, (OnClickListener) new C11896Sa(this));
        }
        if (i == 2) {
            return C11867Da.m39225a((Activity) this, C11761Rb.CLEAR_CC_ALERT_TITLE, C11761Rb.CONFIRM_CLEAR_CREDIT_CARD_INFO, (OnClickListener) new C11898Ta(this));
        }
        if (i != 3) {
            return null;
        }
        return C11867Da.m39231a((Context) this, C11761Rb.AUTHENTICATING, C11761Rb.ONE_MOMENT);
    }

    /* access modifiers changed from: protected */
    public final void onDestroy() {
        StringBuilder sb = new StringBuilder();
        sb.append(f37454a);
        sb.append(".onDestroy");
        if (this.f37464k) {
            unbindService(this.f37463j);
            this.f37464k = false;
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public final void onRestart() {
        super.onRestart();
        m39495d();
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        StringBuilder sb = new StringBuilder();
        sb.append(f37454a);
        sb.append(".onResume");
        if (this.f37462i != null) {
            m39493c();
        }
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        StringBuilder sb = new StringBuilder();
        sb.append(f37454a);
        sb.append(".onSaveInstanceState");
        bundle.putBoolean("PP_PreventAutoLogin", this.f37456c);
        bundle.putBoolean("PP_PageTrackingSent", this.f37459f);
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f37460g.f37122c.mo38792a();
    }
}
