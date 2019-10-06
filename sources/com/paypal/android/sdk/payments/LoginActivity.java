package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.paypal.android.sdk.C11737Ja;
import com.paypal.android.sdk.C11756Pb;
import com.paypal.android.sdk.C11757Q;
import com.paypal.android.sdk.C11761Rb;
import com.paypal.android.sdk.C11785Zb;
import com.paypal.android.sdk.C11799cc;
import com.paypal.android.sdk.C11804dl;
import com.paypal.android.sdk.C11812eh;
import com.paypal.android.sdk.C11814eo;
import com.paypal.android.sdk.C11816eu;
import com.paypal.android.sdk.C11992pb;
import com.paypal.android.sdk.C12024xb;
import java.util.ArrayList;
import java.util.Locale;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public final class LoginActivity extends Activity {

    /* renamed from: a */
    private final String f37321a = LoginActivity.class.getSimpleName();

    /* renamed from: b */
    private C11918bg f37322b;

    /* renamed from: c */
    private String f37323c;

    /* renamed from: d */
    private String f37324d;

    /* renamed from: e */
    private String f37325e;

    /* renamed from: f */
    private String f37326f;

    /* renamed from: g */
    private String f37327g;

    /* renamed from: h */
    private String f37328h;

    /* renamed from: i */
    private C11814eo f37329i;

    /* renamed from: j */
    private String f37330j;

    /* renamed from: k */
    private boolean f37331k;

    /* renamed from: l */
    private boolean f37332l;

    /* renamed from: m */
    private boolean f37333m;

    /* renamed from: n */
    private boolean f37334n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f37335o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public C11785Zb f37336p;

    /* renamed from: q */
    private boolean f37337q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public PayPalService f37338r;

    /* renamed from: s */
    private final ServiceConnection f37339s = new C11966r(this);

    /* renamed from: a */
    private C11814eo m39259a(C11918bg bgVar) {
        m39284g();
        if (bgVar != C11918bg.PIN) {
            return bgVar == C11918bg.EMAIL ? new C11814eo(this.f37323c, this.f37324d) : this.f37329i;
        }
        C11737Ja a = C11737Ja.m38864a();
        String str = this.f37326f;
        return new C11814eo(str == null ? new C11816eu(a, this.f37325e) : new C11816eu(a, new C11812eh(str), this.f37325e), this.f37327g);
    }

    /* renamed from: a */
    static void m39261a(Activity activity, int i, C11804dl dlVar, boolean z, boolean z2, String str, PayPalConfiguration payPalConfiguration) {
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.putExtras(activity.getIntent());
        intent.putExtra("com.paypal.android.sdk.payments.persistedLogin", dlVar);
        intent.putExtra("com.paypal.android.sdk.payments.useResponseTypeCode", z);
        intent.putExtra("com.paypal.android.sdk.payments.forceLogin", z2);
        intent.putExtra("com.paypal.android.sdk.payments.requestedScopes", str);
        intent.putExtra("com.paypal.android.sdk.paypalConfiguration", payPalConfiguration);
        activity.startActivityForResult(intent, 1);
    }

    /* renamed from: a */
    static /* synthetic */ void m39263a(LoginActivity loginActivity, View view) {
        C11918bg bgVar;
        C11814eo a = loginActivity.m39259a(loginActivity.f37322b);
        if (loginActivity.f37322b == C11918bg.PIN) {
            loginActivity.f37329i = new C11814eo(a.mo38775d(), (String) null);
            bgVar = C11918bg.PIN_LOGIN_IN_PROGRESS;
        } else {
            loginActivity.f37329i = new C11814eo(a.mo38773b(), (String) null);
            bgVar = C11918bg.EMAIL_LOGIN_IN_PROGRESS;
        }
        loginActivity.m39271b(bgVar);
        loginActivity.f37338r.mo38961a(a, loginActivity.f37332l, loginActivity.m39267b(), loginActivity.m39274c(), loginActivity.f37330j);
    }

    /* renamed from: a */
    static /* synthetic */ void m39265a(LoginActivity loginActivity, C11940ia iaVar) {
        if (iaVar.mo39121b()) {
            loginActivity.m39275d();
            return;
        }
        if (iaVar.mo39120a() && iaVar.f37560b.equals("invalid_user")) {
            loginActivity.m39294o();
            C11867Da.m39241a((Activity) loginActivity, C11756Pb.m38949a(C11761Rb.TWO_FACTOR_AUTH_INVALID_ONE_TIME_PASSWORD), 3);
        } else if (iaVar.mo39122c()) {
            loginActivity.m39294o();
            C11867Da.m39241a((Activity) loginActivity, C11756Pb.m38950a(iaVar.f37560b), 3);
        } else {
            if ("invalid_nonce".equals(iaVar.f37560b)) {
                loginActivity.f37328h = null;
                loginActivity.m39294o();
                C11867Da.m39241a((Activity) loginActivity, C11756Pb.m38949a(C11761Rb.SESSION_EXPIRED_MESSAGE), 5);
                return;
            }
            loginActivity.f37328h = null;
            loginActivity.m39294o();
            C11867Da.m39241a((Activity) loginActivity, C11756Pb.m38950a(iaVar.f37560b), 4);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m39266a(LoginActivity loginActivity, String str) {
        loginActivity.f37324d = null;
        loginActivity.f37327g = null;
        loginActivity.m39294o();
        C11867Da.m39241a((Activity) loginActivity, C11756Pb.m38950a(str), 1);
    }

    /* renamed from: b */
    private String m39267b() {
        return m39274c() ? "code" : "token";
    }

    /* renamed from: b */
    static /* synthetic */ void m39269b(LoginActivity loginActivity, View view) {
        loginActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(C11933g.m39554a())));
        loginActivity.f37338r.mo38966a(C12024xb.LoginForgotPassword, Boolean.valueOf(loginActivity.f37332l));
    }

    /* renamed from: b */
    static /* synthetic */ void m39270b(LoginActivity loginActivity, String str) {
        String a;
        int i;
        loginActivity.m39294o();
        if ("invalid_nonce".equals(str)) {
            a = C11756Pb.m38949a(C11761Rb.SESSION_EXPIRED_MESSAGE);
            i = 5;
        } else {
            a = C11756Pb.m38950a(str);
            i = 2;
        }
        C11867Da.m39241a((Activity) loginActivity, a, i);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x009b, code lost:
        r7.f37336p.f37082c.setEnabled(true);
        r7.f37336p.f37084e.setEnabled(true);
        m39286h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00b5, code lost:
        m39291l();
        m39290k();
        r7.f37336p.f37097r.f37163g.setText(com.paypal.android.sdk.C11756Pb.m38949a(com.paypal.android.sdk.C11761Rb.TWO_FACTOR_AUTH_SEND_SMS_AGAIN));
        r7.f37336p.f37094o.setEnabled(false);
        r7.f37336p.f37094o.setVisibility(0);
        r7.f37336p.f37095p.setEnabled(false);
        r7.f37336p.f37095p.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00f8, code lost:
        r8.setText(com.paypal.android.sdk.C11756Pb.m38949a(r0));
        r7.f37336p.f37094o.setEnabled(false);
        r7.f37336p.f37094o.setVisibility(8);
        r7.f37336p.f37095p.setEnabled(false);
        r7.f37336p.f37095p.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x011f, code lost:
        m39289j();
        m39293n();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0129, code lost:
        m39289j();
        m39292m();
        r7.f37336p.f37082c.setEnabled(false);
        r7.f37336p.f37084e.setEnabled(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x013d, code lost:
        r7.f37336p.f37089j.setEnabled(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0144, code lost:
        r8 = com.paypal.android.sdk.payments.C11860A.f37290a[r7.f37322b.ordinal()];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x014e, code lost:
        if (r8 == 1) goto L_0x0173;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0151, code lost:
        if (r8 == 2) goto L_0x0173;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0154, code lost:
        if (r8 == 3) goto L_0x0168;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0157, code lost:
        if (r8 == 4) goto L_0x0168;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x015a, code lost:
        if (r8 == 5) goto L_0x015d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x015d, code lost:
        r7.f37338r.mo38963a((com.paypal.android.sdk.payments.C11931fa) new com.paypal.android.sdk.payments.C11954n(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0167, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0168, code lost:
        r8 = r7.f37338r;
        r0 = new com.paypal.android.sdk.payments.C11951m(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x016f, code lost:
        r8.mo38963a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0172, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0173, code lost:
        r8 = r7.f37338r;
        r0 = new com.paypal.android.sdk.payments.C11874H(r7);
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m39271b(com.paypal.android.sdk.payments.C11918bg r8) {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "changeLoginState:"
            r0.<init>(r1)
            r0.append(r8)
            if (r8 == 0) goto L_0x000f
            r7.f37322b = r8
            goto L_0x001b
        L_0x000f:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "null loginState, refreshing:"
            r8.<init>(r0)
            com.paypal.android.sdk.payments.bg r0 = r7.f37322b
            r8.append(r0)
        L_0x001b:
            r8 = 21
            r0 = 20
            r7.dismissDialog(r0)     // Catch:{ IllegalArgumentException -> 0x0026 }
            r7.dismissDialog(r8)     // Catch:{ IllegalArgumentException -> 0x0026 }
            goto L_0x0027
        L_0x0026:
            r1 = move-exception
        L_0x0027:
            int[] r1 = com.paypal.android.sdk.payments.C11860A.f37290a
            com.paypal.android.sdk.payments.bg r2 = r7.f37322b
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 8
            r3 = 1
            r4 = 0
            switch(r1) {
                case 1: goto L_0x0126;
                case 2: goto L_0x011c;
                case 3: goto L_0x00e7;
                case 4: goto L_0x00b2;
                case 5: goto L_0x00ae;
                case 6: goto L_0x0095;
                case 7: goto L_0x008e;
                case 8: goto L_0x0129;
                case 9: goto L_0x011f;
                case 10: goto L_0x007f;
                case 11: goto L_0x00b5;
                case 12: goto L_0x003a;
                case 13: goto L_0x00b5;
                default: goto L_0x0038;
            }
        L_0x0038:
            goto L_0x0144
        L_0x003a:
            r7.m39291l()
            r7.m39290k()
            com.paypal.android.sdk.Zb r8 = r7.f37336p
            com.paypal.android.sdk.dc r8 = r8.f37097r
            android.widget.Button r8 = r8.f37163g
            com.paypal.android.sdk.Rb r0 = com.paypal.android.sdk.C11761Rb.TWO_FACTOR_AUTH_SEND_SMS_AGAIN
            java.lang.String r0 = com.paypal.android.sdk.C11756Pb.m38949a(r0)
            r8.setText(r0)
            com.paypal.android.sdk.Zb r8 = r7.f37336p
            android.widget.EditText r8 = r8.f37094o
            r8.setEnabled(r3)
            com.paypal.android.sdk.Zb r8 = r7.f37336p
            android.widget.EditText r8 = r8.f37094o
            r8.setVisibility(r4)
            com.paypal.android.sdk.Zb r8 = r7.f37336p
            android.widget.EditText r8 = r8.f37094o
            r8.requestFocus()
            android.os.Handler r0 = new android.os.Handler
            r0.<init>()
            com.paypal.android.sdk.payments.o r1 = new com.paypal.android.sdk.payments.o
            r1.<init>(r7, r8)
            r5 = 200(0xc8, double:9.9E-322)
            r0.postDelayed(r1, r5)
            com.paypal.android.sdk.Zb r8 = r7.f37336p
            android.widget.LinearLayout r8 = r8.f37095p
            r8.setVisibility(r4)
            r7.m39288i()
            goto L_0x0144
        L_0x007f:
            r7.m39291l()
            r7.m39290k()
            com.paypal.android.sdk.Zb r8 = r7.f37336p
            com.paypal.android.sdk.dc r8 = r8.f37097r
            android.widget.Button r8 = r8.f37163g
            com.paypal.android.sdk.Rb r0 = com.paypal.android.sdk.C11761Rb.TWO_FACTOR_AUTH_SEND_SMS
            goto L_0x00f8
        L_0x008e:
            r7.m39289j()
            r7.m39293n()
            goto L_0x009b
        L_0x0095:
            r7.m39289j()
            r7.m39292m()
        L_0x009b:
            com.paypal.android.sdk.Zb r8 = r7.f37336p
            android.widget.EditText r8 = r8.f37082c
            r8.setEnabled(r3)
            com.paypal.android.sdk.Zb r8 = r7.f37336p
            android.widget.EditText r8 = r8.f37084e
            r8.setEnabled(r3)
            r7.m39286h()
            goto L_0x0144
        L_0x00ae:
            r7.showDialog(r0)
            goto L_0x00b5
        L_0x00b2:
            r7.showDialog(r8)
        L_0x00b5:
            r7.m39291l()
            r7.m39290k()
            com.paypal.android.sdk.Zb r8 = r7.f37336p
            com.paypal.android.sdk.dc r8 = r8.f37097r
            android.widget.Button r8 = r8.f37163g
            com.paypal.android.sdk.Rb r0 = com.paypal.android.sdk.C11761Rb.TWO_FACTOR_AUTH_SEND_SMS_AGAIN
            java.lang.String r0 = com.paypal.android.sdk.C11756Pb.m38949a(r0)
            r8.setText(r0)
            com.paypal.android.sdk.Zb r8 = r7.f37336p
            android.widget.EditText r8 = r8.f37094o
            r8.setEnabled(r4)
            com.paypal.android.sdk.Zb r8 = r7.f37336p
            android.widget.EditText r8 = r8.f37094o
            r8.setVisibility(r4)
            com.paypal.android.sdk.Zb r8 = r7.f37336p
            android.widget.LinearLayout r8 = r8.f37095p
            r8.setEnabled(r4)
            com.paypal.android.sdk.Zb r8 = r7.f37336p
            android.widget.LinearLayout r8 = r8.f37095p
            r8.setVisibility(r4)
            goto L_0x0144
        L_0x00e7:
            r7.showDialog(r8)
            r7.m39291l()
            r7.m39290k()
            com.paypal.android.sdk.Zb r8 = r7.f37336p
            com.paypal.android.sdk.dc r8 = r8.f37097r
            android.widget.Button r8 = r8.f37163g
            com.paypal.android.sdk.Rb r0 = com.paypal.android.sdk.C11761Rb.TWO_FACTOR_AUTH_SEND_SMS_AGAIN
        L_0x00f8:
            java.lang.String r0 = com.paypal.android.sdk.C11756Pb.m38949a(r0)
            r8.setText(r0)
            com.paypal.android.sdk.Zb r8 = r7.f37336p
            android.widget.EditText r8 = r8.f37094o
            r8.setEnabled(r4)
            com.paypal.android.sdk.Zb r8 = r7.f37336p
            android.widget.EditText r8 = r8.f37094o
            r8.setVisibility(r2)
            com.paypal.android.sdk.Zb r8 = r7.f37336p
            android.widget.LinearLayout r8 = r8.f37095p
            r8.setEnabled(r4)
            com.paypal.android.sdk.Zb r8 = r7.f37336p
            android.widget.LinearLayout r8 = r8.f37095p
            r8.setVisibility(r2)
            goto L_0x0144
        L_0x011c:
            r7.showDialog(r0)
        L_0x011f:
            r7.m39289j()
            r7.m39293n()
            goto L_0x013d
        L_0x0126:
            r7.showDialog(r0)
        L_0x0129:
            r7.m39289j()
            r7.m39292m()
            com.paypal.android.sdk.Zb r8 = r7.f37336p
            android.widget.EditText r8 = r8.f37082c
            r8.setEnabled(r4)
            com.paypal.android.sdk.Zb r8 = r7.f37336p
            android.widget.EditText r8 = r8.f37084e
            r8.setEnabled(r4)
        L_0x013d:
            com.paypal.android.sdk.Zb r8 = r7.f37336p
            android.widget.LinearLayout r8 = r8.f37089j
            r8.setEnabled(r4)
        L_0x0144:
            int[] r8 = com.paypal.android.sdk.payments.C11860A.f37290a
            com.paypal.android.sdk.payments.bg r0 = r7.f37322b
            int r0 = r0.ordinal()
            r8 = r8[r0]
            if (r8 == r3) goto L_0x0173
            r0 = 2
            if (r8 == r0) goto L_0x0173
            r0 = 3
            if (r8 == r0) goto L_0x0168
            r0 = 4
            if (r8 == r0) goto L_0x0168
            r0 = 5
            if (r8 == r0) goto L_0x015d
            goto L_0x0167
        L_0x015d:
            com.paypal.android.sdk.payments.PayPalService r8 = r7.f37338r
            com.paypal.android.sdk.payments.n r0 = new com.paypal.android.sdk.payments.n
            r0.<init>(r7)
            r8.mo38963a(r0)
        L_0x0167:
            return
        L_0x0168:
            com.paypal.android.sdk.payments.PayPalService r8 = r7.f37338r
            com.paypal.android.sdk.payments.m r0 = new com.paypal.android.sdk.payments.m
            r0.<init>(r7)
        L_0x016f:
            r8.mo38963a(r0)
            return
        L_0x0173:
            com.paypal.android.sdk.payments.PayPalService r8 = r7.f37338r
            com.paypal.android.sdk.payments.H r0 = new com.paypal.android.sdk.payments.H
            r0.<init>(r7)
            goto L_0x016f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.sdk.payments.LoginActivity.m39271b(com.paypal.android.sdk.payments.bg):void");
    }

    /* renamed from: c */
    static /* synthetic */ void m39273c(LoginActivity loginActivity, View view) {
        loginActivity.m39284g();
        C11918bg bgVar = loginActivity.f37322b;
        C11918bg bgVar2 = C11918bg.PIN;
        if (bgVar == bgVar2) {
            loginActivity.m39271b(C11918bg.EMAIL);
        } else {
            loginActivity.m39271b(bgVar2);
        }
        loginActivity.m39282f();
        loginActivity.f37336p.mo38668a(loginActivity.f37322b == C11918bg.EMAIL);
    }

    /* renamed from: c */
    private boolean m39274c() {
        return getIntent().getBooleanExtra("com.paypal.android.sdk.payments.useResponseTypeCode", false);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m39275d() {
        if (this.f37338r.mo38978c().f36746f.f37156a.isEmpty()) {
            m39294o();
            C11867Da.m39241a((Activity) this, C11756Pb.m38949a(C11761Rb.TWO_FACTOR_AUTH_NO_ACTIVE_TOKENS_ERROR), 10);
            return;
        }
        m39271b(C11918bg.TWO_FA_SEND_FIRST_SMS);
    }

    /* renamed from: d */
    static /* synthetic */ void m39277d(LoginActivity loginActivity, View view) {
        loginActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(C11921cb.m39527a())));
        loginActivity.f37338r.mo38966a(C12024xb.SignUp, Boolean.valueOf(loginActivity.f37332l));
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m39279e() {
        setResult(-1);
        finish();
    }

    /* renamed from: e */
    static /* synthetic */ void m39280e(LoginActivity loginActivity, View view) {
        loginActivity.m39271b(loginActivity.f37322b == C11918bg.TWO_FA_ENTER_OTP ? C11918bg.TWO_FA_SEND_ANOTHER_SMS_IN_PROGRESS : C11918bg.TWO_FA_SEND_FIRST_SMS_IN_PROGRESS);
        loginActivity.f37336p.f37094o.setText("");
        loginActivity.f37338r.mo38958a(loginActivity.f37335o);
    }

    /* renamed from: f */
    private void m39282f() {
        C11867Da.m39242a(this.f37336p.f37083d.f37036c, this.f37338r.mo38980e());
        m39271b((C11918bg) null);
    }

    /* renamed from: f */
    static /* synthetic */ void m39283f(LoginActivity loginActivity, View view) {
        loginActivity.m39271b(C11918bg.TWO_FA_LOGIN_OTP_IN_PROGRESS);
        loginActivity.f37338r.mo38960a(loginActivity.m39259a(loginActivity.f37322b), loginActivity.f37336p.f37094o.getText().toString(), loginActivity.f37332l, loginActivity.m39267b(), loginActivity.m39274c(), loginActivity.f37330j);
    }

    /* renamed from: g */
    private void m39284g() {
        if (this.f37322b == C11918bg.PIN) {
            this.f37325e = this.f37336p.f37082c.getText().toString();
            this.f37327g = this.f37336p.f37084e.getText().toString();
            return;
        }
        this.f37323c = this.f37336p.f37082c.getText().toString();
        this.f37324d = this.f37336p.f37084e.getText().toString();
    }

    /* renamed from: g */
    static /* synthetic */ void m39285g(LoginActivity loginActivity) {
        int i = C11860A.f37290a[loginActivity.f37322b.ordinal()];
        if (i == 8) {
            loginActivity.m39271b(C11918bg.EMAIL);
        } else if (i == 9) {
            loginActivity.m39271b(C11918bg.PIN);
        } else if (i == 11) {
            loginActivity.m39271b(C11918bg.TWO_FA_ENTER_OTP);
        } else if (i != 13) {
            StringBuilder sb = new StringBuilder();
            sb.append(loginActivity.f37322b);
            sb.append(" case not handled");
        } else {
            loginActivity.m39271b(C11918bg.TWO_FA_ENTER_OTP);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m39286h() {
        String obj = this.f37336p.f37082c.getText().toString();
        String obj2 = this.f37336p.f37084e.getText().toString();
        boolean z = true;
        if (this.f37322b != C11918bg.PIN ? !C11992pb.m39649a(obj) || !C11992pb.m39651c(obj2) : !C11992pb.m39652d(obj) || !C11992pb.m39650b(obj2)) {
            z = false;
        }
        this.f37336p.f37089j.setEnabled(z);
        this.f37336p.f37089j.setFocusable(z);
    }

    /* renamed from: h */
    static /* synthetic */ void m39287h(LoginActivity loginActivity) {
        loginActivity.m39271b(loginActivity.f37329i.mo38772a() ? C11918bg.EMAIL : C11918bg.PIN);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m39288i() {
        this.f37336p.f37095p.setEnabled(6 == this.f37336p.f37094o.getText().toString().length());
    }

    /* renamed from: j */
    private void m39289j() {
        this.f37336p.f37097r.f37157a.setVisibility(8);
        this.f37336p.f37093n.setEnabled(false);
        this.f37336p.f37093n.setVisibility(8);
        this.f37336p.f37097r.f37163g.setVisibility(8);
        this.f37336p.f37095p.setEnabled(false);
        this.f37336p.f37095p.setVisibility(8);
        this.f37336p.f37094o.setEnabled(false);
        this.f37336p.f37094o.setVisibility(8);
    }

    /* renamed from: k */
    private void m39290k() {
        C11867Da.m39239a((Activity) this, (TextView) null, C11761Rb.TWO_FACTOR_AUTH_TITLE);
        this.f37336p.f37093n.setEnabled(true);
        this.f37336p.f37093n.setVisibility(0);
        new StringBuilder("phone numbers: ").append(this.f37338r.mo38978c().f36746f.f37156a);
        ArrayList arrayList = new ArrayList(this.f37338r.mo38978c().f36746f.f37156a.values());
        this.f37336p.f37097r.mo38714a((String) arrayList.get(this.f37335o));
        this.f37336p.f37097r.f37157a.setVisibility(0);
        if (arrayList.size() > 1) {
            this.f37336p.f37097r.mo38715a(true);
            C11799cc ccVar = new C11799cc(this, arrayList, this.f37335o);
            new ListView(this).setAdapter(ccVar);
            this.f37336p.f37097r.f37159c.setOnClickListener(new C11960p(this, ccVar, arrayList));
        } else {
            this.f37336p.f37097r.mo38715a(false);
        }
        this.f37336p.f37097r.f37163g.setVisibility(0);
    }

    /* renamed from: l */
    private void m39291l() {
        this.f37336p.f37089j.setEnabled(false);
        this.f37336p.f37089j.setVisibility(8);
        this.f37336p.f37082c.setEnabled(false);
        this.f37336p.f37082c.setVisibility(8);
        this.f37336p.f37084e.setEnabled(false);
        this.f37336p.f37084e.setVisibility(8);
        this.f37336p.f37085f.setEnabled(false);
        this.f37336p.f37085f.setVisibility(8);
    }

    /* renamed from: m */
    private void m39292m() {
        C11867Da.m39239a((Activity) this, (TextView) null, C11761Rb.LOG_IN_TO_PAYPAL);
        this.f37336p.f37082c.setVisibility(0);
        this.f37336p.f37082c.setText(this.f37323c);
        this.f37336p.f37082c.setHint(C11756Pb.m38949a(C11761Rb.EMAIL));
        this.f37336p.f37082c.setInputType(33);
        this.f37336p.f37084e.setVisibility(0);
        this.f37336p.f37084e.setText(this.f37324d);
        this.f37336p.f37084e.setHint(C11756Pb.m38949a(C11761Rb.PASSWORD));
        this.f37336p.f37084e.setInputType(Opcodes.LOR);
        if (this.f37336p.f37082c.getText().length() > 0 && this.f37336p.f37084e.getText().length() == 0) {
            this.f37336p.f37084e.requestFocus();
        }
        this.f37336p.f37082c.setContentDescription("Email");
        this.f37336p.f37084e.setContentDescription("Password");
        this.f37336p.f37089j.setVisibility(0);
        this.f37336p.f37085f.setVisibility(0);
        this.f37336p.f37086g.setVisibility(0);
        this.f37336p.f37087h.setVisibility(0);
        this.f37336p.f37092m.setText(C11756Pb.m38949a(C11761Rb.LOGIN_WITH_PHONE));
    }

    /* renamed from: n */
    private void m39293n() {
        C11867Da.m39239a((Activity) this, (TextView) null, C11761Rb.LOG_IN_TO_PAYPAL);
        this.f37336p.f37082c.setVisibility(0);
        this.f37336p.f37082c.setText(this.f37325e);
        this.f37336p.f37082c.setHint(C11756Pb.m38949a(C11761Rb.PHONE));
        this.f37336p.f37082c.setInputType(3);
        this.f37336p.f37084e.setVisibility(0);
        this.f37336p.f37084e.setText(this.f37327g);
        this.f37336p.f37084e.setHint(C11756Pb.m38949a(C11761Rb.PIN));
        this.f37336p.f37084e.setInputType(18);
        if (this.f37336p.f37082c.getText().length() > 0 && this.f37336p.f37084e.getText().length() == 0) {
            this.f37336p.f37084e.requestFocus();
        }
        this.f37336p.f37082c.setContentDescription("Phone");
        this.f37336p.f37084e.setContentDescription("Pin");
        this.f37336p.f37089j.setVisibility(0);
        this.f37336p.f37085f.setVisibility(0);
        this.f37336p.f37086g.setVisibility(0);
        this.f37336p.f37087h.setVisibility(4);
        this.f37336p.f37092m.setText(C11756Pb.m38949a(C11761Rb.LOGIN_WITH_EMAIL));
    }

    /* renamed from: o */
    private void m39294o() {
        int i = C11860A.f37290a[this.f37322b.ordinal()];
        if (i == 1) {
            m39271b(C11918bg.EMAIL_LOGIN_FAILED);
        } else if (i == 2) {
            m39271b(C11918bg.PIN_LOGIN_FAILED);
        } else if (i == 3 || i == 4) {
            m39271b(C11918bg.TWO_FA_SEND_SMS_FAILED);
        } else if (i != 5) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f37322b);
            sb.append(" case not handled");
        } else {
            m39271b(C11918bg.TWO_FA_LOGIN_OTP_FAILED);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo38866a() {
        C11918bg bgVar;
        PayPalConfiguration d = this.f37338r.mo38979d();
        if (C11756Pb.f36876a) {
            this.f37336p.f37084e.setGravity(5);
            this.f37336p.f37082c.setGravity(5);
            this.f37336p.f37094o.setGravity(5);
        }
        if (!C11992pb.m39654f(Locale.getDefault().getCountry().toLowerCase(Locale.US)) || !this.f37338r.mo38978c().f36749i) {
            this.f37336p.f37092m.setVisibility(4);
        }
        if (this.f37333m) {
            this.f37333m = false;
            this.f37323c = d.mo38890c();
            String d2 = d.mo38891d();
            if (d2 != null) {
                this.f37325e = d2;
            }
            String e = d.mo38893e();
            if (e != null) {
                this.f37326f = e;
            }
            if (d.mo38894f() && !C11757Q.m38955c(d.mo38888b())) {
                this.f37324d = d.mo38895g();
                this.f37327g = d.mo38896h();
            }
        }
        if (getIntent().getBooleanExtra("com.paypal.android.sdk.payments.forceLogin", false) && !this.f37334n) {
            this.f37334n = true;
            this.f37338r.mo38983h();
        }
        if (!this.f37338r.mo38985j()) {
            if (!this.f37331k) {
                this.f37331k = true;
                this.f37338r.mo38966a(C12024xb.LoginWindow, Boolean.valueOf(this.f37332l));
            }
            if (this.f37322b == null) {
                C11804dl dlVar = (C11804dl) getIntent().getParcelableExtra("com.paypal.android.sdk.payments.persistedLogin");
                if (dlVar != null) {
                    this.f37332l = true;
                    if (TextUtils.isEmpty(this.f37323c) && !TextUtils.isEmpty(dlVar.mo38721b())) {
                        this.f37323c = dlVar.mo38721b();
                    }
                    if (this.f37325e == null && dlVar.mo38717a() != null) {
                        this.f37325e = dlVar.mo38717a().mo38785a(C11737Ja.m38864a());
                    }
                    int i = C11860A.f37291b[dlVar.mo38722c().ordinal()];
                    if (i != 1) {
                        if (i == 2) {
                            bgVar = C11918bg.PIN;
                            m39271b(bgVar);
                        }
                    }
                }
                bgVar = C11918bg.EMAIL;
                m39271b(bgVar);
            }
            m39282f();
            return;
        }
        m39279e();
    }

    public final void onBackPressed() {
        this.f37338r.mo38966a(C12024xb.LoginCancel, Boolean.valueOf(this.f37332l));
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StringBuilder sb = new StringBuilder();
        sb.append(LoginActivity.class.getSimpleName());
        sb.append(".onCreate");
        this.f37330j = getIntent().getExtras().getString("com.paypal.android.sdk.payments.requestedScopes");
        this.f37337q = bindService(C11867Da.m39245b((Activity) this), this.f37339s, 1);
        setTheme(16973934);
        requestWindowFeature(8);
        this.f37336p = new C11785Zb(this);
        setContentView(this.f37336p.f37080a);
        this.f37336p.f37086g.setText(C11756Pb.m38949a(C11761Rb.SIGN_UP));
        this.f37336p.f37087h.setText(C11756Pb.m38949a(C11761Rb.FORGOT_PASSWORD));
        this.f37336p.f37090k.setText(C11756Pb.m38949a(C11761Rb.LOG_IN));
        this.f37336p.f37090k.setHint(C11756Pb.m38949a(C11761Rb.LOG_IN));
        this.f37336p.f37093n.setText(C11756Pb.m38949a(C11761Rb.TWO_FACTOR_AUTH_SUBTITLE));
        this.f37336p.f37094o.setHint(C11756Pb.m38949a(C11761Rb.TWO_FACTOR_AUTH_ENTER_SECURITY_CODE));
        this.f37336p.f37096q.setText(C11756Pb.m38949a(C11761Rb.LOG_IN));
        this.f37336p.f37097r.mo38716b(C11756Pb.m38949a(C11761Rb.TWO_FACTOR_AUTH_ENTER_MOBILE_NUMBER));
        C11948l lVar = new C11948l(this);
        this.f37336p.f37082c.addTextChangedListener(lVar);
        this.f37336p.f37084e.addTextChangedListener(lVar);
        this.f37336p.f37089j.setOnClickListener(new C11987y(this));
        this.f37336p.f37087h.setOnClickListener(new C11862B(this));
        this.f37336p.f37092m.setOnClickListener(new C11864C(this));
        this.f37336p.f37086g.setOnClickListener(new C11866D(this));
        this.f37336p.f37097r.f37163g.setOnClickListener(new C11868E(this));
        this.f37336p.f37094o.addTextChangedListener(new C11870F(this));
        this.f37336p.f37095p.setOnClickListener(new C11872G(this));
        if (bundle == null) {
            this.f37331k = false;
            this.f37333m = true;
        } else {
            this.f37333m = false;
            this.f37331k = bundle.getBoolean("PP_PageTrackingSent");
            this.f37322b = (C11918bg) bundle.getParcelable("PP_LoginType");
            this.f37323c = bundle.getString("PP_SavedEmail");
            this.f37325e = bundle.getString("PP_SavedPhone");
            this.f37326f = bundle.getString("PP_savedPhoneCountryCode");
            this.f37324d = bundle.getString("PP_SavedPassword");
            this.f37327g = bundle.getString("PP_SavedPIN");
            this.f37332l = bundle.getBoolean("PP_IsReturningUser");
            this.f37334n = bundle.getBoolean("PP_IsClearedLogin");
            this.f37330j = bundle.getString("PP_RequestedScopes");
            this.f37328h = bundle.getString("PP_SavedOTP");
            this.f37329i = (C11814eo) bundle.getParcelable("PP_OriginalLoginData");
            this.f37335o = bundle.getInt("PP_TwoFaSelectedPhoneNumberIndex");
        }
        this.f37336p.f37094o.setText(this.f37328h);
    }

    /* access modifiers changed from: protected */
    public final Dialog onCreateDialog(int i, Bundle bundle) {
        if (i == 1) {
            return C11867Da.m39230a((Activity) this, C11761Rb.LOGIN_FAILED_ALERT_TITLE, bundle, (OnClickListener) new C11972t(this));
        }
        if (i == 2) {
            return C11867Da.m39230a((Activity) this, C11761Rb.WE_ARE_SORRY, bundle, (OnClickListener) new C11975u(this));
        }
        if (i == 3) {
            return C11867Da.m39230a((Activity) this, C11761Rb.LOGIN_FAILED_ALERT_TITLE, bundle, (OnClickListener) new C11978v(this));
        }
        if (i == 4) {
            return C11867Da.m39230a((Activity) this, C11761Rb.LOGIN_FAILED_ALERT_TITLE, bundle, (OnClickListener) new C11981w(this));
        }
        if (i == 5) {
            return C11867Da.m39230a((Activity) this, C11761Rb.SESSION_EXPIRED_TITLE, bundle, (OnClickListener) new C11984x(this));
        }
        if (i == 10) {
            return C11867Da.m39230a((Activity) this, C11761Rb.LOGIN_FAILED_ALERT_TITLE, bundle, (OnClickListener) new C11990z(this));
        }
        if (i == 20) {
            return C11867Da.m39231a((Context) this, C11761Rb.AUTHENTICATING, C11761Rb.ONE_MOMENT);
        }
        if (i != 21) {
            return null;
        }
        return C11867Da.m39231a((Context) this, C11761Rb.TWO_FACTOR_AUTH_SENDING_DIALOG, C11761Rb.ONE_MOMENT);
    }

    /* access modifiers changed from: protected */
    public final void onDestroy() {
        StringBuilder sb = new StringBuilder();
        sb.append(LoginActivity.class.getSimpleName());
        sb.append(".onDestroy");
        PayPalService payPalService = this.f37338r;
        if (payPalService != null) {
            payPalService.mo38989n();
        }
        if (this.f37337q) {
            unbindService(this.f37339s);
            this.f37337q = false;
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        StringBuilder sb = new StringBuilder();
        sb.append(LoginActivity.class.getSimpleName());
        sb.append(".onResume");
        if (this.f37338r != null) {
            m39282f();
        }
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m39284g();
        bundle.putParcelable("PP_LoginType", this.f37322b);
        bundle.putString("PP_SavedEmail", this.f37323c);
        bundle.putString("PP_SavedPhone", this.f37325e);
        bundle.putString("PP_savedPhoneCountryCode", this.f37326f);
        bundle.putString("PP_SavedPassword", this.f37324d);
        bundle.putString("PP_SavedPIN", this.f37327g);
        bundle.putBoolean("PP_IsReturningUser", this.f37332l);
        bundle.putBoolean("PP_PageTrackingSent", this.f37331k);
        bundle.putBoolean("PP_IsClearedLogin", this.f37334n);
        bundle.putString("PP_RequestedScopes", this.f37330j);
        bundle.putString("PP_SavedOTP", this.f37328h);
        bundle.putParcelable("PP_OriginalLoginData", this.f37329i);
        bundle.putInt("PP_TwoFaSelectedPhoneNumberIndex", this.f37335o);
    }
}
