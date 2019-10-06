package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.BulletSpan;
import android.text.style.URLSpan;
import android.util.Log;
import android.widget.TextView;
import com.paypal.android.sdk.C11723Fa;
import com.paypal.android.sdk.C11724Fb;
import com.paypal.android.sdk.C11752Oa;
import com.paypal.android.sdk.C11756Pb;
import com.paypal.android.sdk.C11761Rb;
import com.paypal.android.sdk.C11764Sb;
import com.paypal.android.sdk.C11769Ua;
import com.paypal.android.sdk.C11772Va;
import com.paypal.android.sdk.C11775Wa;
import com.paypal.android.sdk.C11842l;
import com.paypal.android.sdk.C12024xb;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* renamed from: com.paypal.android.sdk.payments.lb */
abstract class C11950lb extends Activity {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f37577a = C11950lb.class.getSimpleName();

    /* renamed from: b */
    private static final Map f37578b = new C11956nb();

    /* renamed from: c */
    protected PayPalService f37579c;

    /* renamed from: d */
    private boolean f37580d;

    /* renamed from: e */
    protected PayPalOAuthScopes f37581e;

    /* renamed from: f */
    private C11941ib f37582f;

    /* renamed from: g */
    protected C11764Sb f37583g;

    /* renamed from: h */
    private boolean f37584h;

    /* renamed from: i */
    private boolean f37585i;

    /* renamed from: j */
    private boolean f37586j;

    /* renamed from: k */
    private C11925du f37587k;

    /* renamed from: l */
    private final ServiceConnection f37588l = new C11974tb(this);

    C11950lb() {
    }

    /* renamed from: a */
    private void m39600a(int i, PayPalAuthorization payPalAuthorization) {
        Intent intent = new Intent();
        intent.putExtra("com.paypal.android.sdk.authorization", payPalAuthorization);
        setResult(i, intent);
    }

    /* renamed from: a */
    private void m39601a(int i, String str, String str2, C11939i iVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(str);
        SpannableString spannableString = new SpannableString(Html.fromHtml(sb.toString()));
        if (iVar != null) {
            URLSpan[] uRLSpanArr = (URLSpan[]) spannableString.getSpans(0, spannableString.length(), URLSpan.class);
            if (uRLSpanArr.length > 0) {
                URLSpan uRLSpan = uRLSpanArr[0];
                C11915b bVar = new C11915b(uRLSpan, this, FuturePaymentInfoActivity.class, new C11953mb(this), iVar);
                spannableString.setSpan(bVar, spannableString.getSpanStart(uRLSpan), spannableString.getSpanEnd(uRLSpan), 33);
                spannableString.removeSpan(uRLSpan);
            }
        } else {
            m39602a(spannableString);
        }
        spannableString.setSpan(new BulletSpan(15), 0, spannableString.length(), 0);
        this.f37583g.f37018d[i].setVisibility(0);
        this.f37583g.f37018d[i].setFocusable(true);
        int i2 = i + 100;
        this.f37583g.f37018d[i].setNextFocusLeftId(i2 - 1);
        this.f37583g.f37018d[i].setNextFocusRightId(i2 + 1);
        this.f37583g.f37018d[i].setText(spannableString);
    }

    /* renamed from: a */
    private void m39602a(SpannableString spannableString) {
        URLSpan[] uRLSpanArr;
        for (URLSpan uRLSpan : (URLSpan[]) spannableString.getSpans(0, spannableString.length(), URLSpan.class)) {
            spannableString.setSpan(new C11929eb(uRLSpan, new C11959ob(this)), spannableString.getSpanStart(uRLSpan), spannableString.getSpanEnd(uRLSpan), 33);
            spannableString.removeSpan(uRLSpan);
        }
    }

    /* renamed from: a */
    private void m39603a(C11941ib ibVar) {
        this.f37579c.mo38978c().f36750j = ibVar.f37561a;
        this.f37579c.mo38978c().f36745e = ibVar.f37562b;
        this.f37579c.mo38978c().f36743c = ibVar.f37563c;
        m39621j();
    }

    /* renamed from: a */
    static /* synthetic */ void m39605a(C11950lb lbVar, C11724Fb fb) {
        lbVar.f37587k = new C11925du(fb);
        lbVar.getIntent().putExtra("com.paypal.android.sdk.payments.ppAppInfo", lbVar.f37587k);
        lbVar.m39616f();
        lbVar.m39622k();
    }

    /* renamed from: b */
    private void m39608b(SpannableString spannableString) {
        URLSpan[] uRLSpanArr;
        for (URLSpan uRLSpan : (URLSpan[]) spannableString.getSpans(0, spannableString.length(), URLSpan.class)) {
            spannableString.setSpan(new C11929eb(uRLSpan, new C11962pb(this)), spannableString.getSpanStart(uRLSpan), spannableString.getSpanEnd(uRLSpan), 33);
            spannableString.removeSpan(uRLSpan);
        }
    }

    /* renamed from: c */
    private void m39610c() {
        if (this.f37579c != null) {
            showDialog(2);
            if (!this.f37579c.mo38984i()) {
                new StringBuilder("token is expired, get new one. AccessToken: ").append(this.f37579c.mo38978c().f36742b);
                this.f37579c.mo38964a((C11937ha) new C11965qb(this), true);
                return;
            }
            this.f37579c.mo38997p();
        }
    }

    /* renamed from: d */
    private void m39612d() {
        this.f37580d = bindService(C11867Da.m39245b((Activity) this), this.f37588l, 1);
    }

    /* renamed from: d */
    static /* synthetic */ void m39613d(C11950lb lbVar) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        sb.append(f37577a);
        sb.append(".postBindSetup()");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f37577a);
        sb2.append(".startLoginIfNeeded (access token: ");
        sb2.append(lbVar.f37579c.mo38978c().f36747g);
        sb2.append(")");
        if (lbVar.f37579c.mo38985j() || lbVar.f37585i) {
            z = false;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(f37577a);
            sb3.append(" -- doing the login...");
            lbVar.f37585i = true;
            lbVar.m39614e();
            z = true;
        }
        C11764Sb sb4 = lbVar.f37583g;
        if (lbVar.f37586j) {
            lbVar.f37586j = false;
            lbVar.m39621j();
        }
        if (!lbVar.f37584h) {
            lbVar.f37584h = true;
            lbVar.f37579c.mo38965a(C12024xb.ConsentWindow);
        }
        C11867Da.m39242a(sb4.f37021g.f37036c, lbVar.f37579c.mo38980e());
        lbVar.f37579c.mo38977b((C11931fa) new C11968rb(lbVar));
        lbVar.m39616f();
        if (!z && lbVar.f37587k == null) {
            lbVar.m39610c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m39614e() {
        StringBuilder sb = new StringBuilder();
        sb.append(f37577a);
        sb.append(".doLogin");
        if (C11944jb.m39590a(this, this.f37579c)) {
            Intent a = new C11769Ua().mo38633a(this.f37579c.mo38979d().mo38899k(), C11772Va.PROMPT_LOGIN, C11775Wa.code, this.f37579c.mo38976b().mo38531d().mo38697e());
            StringBuilder sb2 = new StringBuilder("startActivityForResult(");
            sb2.append(a);
            sb2.append(", 2");
            sb2.append(")");
            Log.w("paypal.sdk", "requesting code with scope=null from Authenticator.");
            startActivityForResult(a, 2);
            return;
        }
        LoginActivity.m39261a(this, 1, null, true, false, this.f37581e.mo38923b(), this.f37579c.mo38979d());
    }

    /* renamed from: e */
    static /* synthetic */ void m39615e(C11950lb lbVar) {
        lbVar.f37579c.mo38965a(C12024xb.ConsentCancel);
        lbVar.finish();
    }

    /* renamed from: f */
    private void m39616f() {
        int i;
        if (!(this.f37581e == null || this.f37587k == null)) {
            PayPalService payPalService = this.f37579c;
            if (payPalService != null) {
                String l = payPalService.mo38979d().mo38900l();
                if (this.f37587k.mo39091d() != null) {
                    l = this.f37587k.mo39091d();
                }
                String uri = this.f37579c.mo38979d().mo38901m().toString();
                if (this.f37587k.mo39089b() != null) {
                    uri = this.f37587k.mo39089b();
                }
                String uri2 = this.f37579c.mo38979d().mo38902n().toString();
                if (this.f37587k.mo39090c() != null) {
                    uri2 = this.f37587k.mo39090c();
                }
                String a = C11756Pb.m38949a(C11761Rb.CONSENT_AGREEMENT_INTRO);
                String str = "<b>";
                StringBuilder sb = new StringBuilder(str);
                sb.append(l);
                String str2 = "</b>";
                sb.append(str2);
                String format = String.format(a, new Object[]{sb.toString()});
                String str3 = "";
                String str4 = C11756Pb.f36876a ? "‏" : str3;
                TextView textView = this.f37583g.f37018d[0];
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str4);
                sb2.append(format);
                textView.setText(Html.fromHtml(sb2.toString()));
                if (C11756Pb.f36876a) {
                    this.f37583g.f37018d[0].setGravity(5);
                }
                this.f37583g.f37018d[0].setVisibility(0);
                List a2 = this.f37581e.mo38922a();
                if (a2.contains(C11842l.FUTURE_PAYMENTS.mo38820a()) || a2.contains(C11752Oa.PAYMENT_CODE.mo38610a()) || a2.contains(C11752Oa.MIS_CUSTOMER.mo38610a())) {
                    String a3 = C11756Pb.m38949a(C11761Rb.CONSENT_AGREEMENT_FUTURE_PAYMENTS);
                    StringBuilder sb3 = new StringBuilder(str);
                    sb3.append(l);
                    sb3.append(str2);
                    StringBuilder sb4 = new StringBuilder(str);
                    sb4.append(l);
                    sb4.append(str2);
                    m39601a(1, String.format(a3, new Object[]{"future-payment-consent", sb3.toString(), sb4.toString()}), str4, C11939i.FUTURE_PAYMENTS);
                    i = 2;
                } else {
                    i = 1;
                }
                if (a2.contains(C11752Oa.GET_FUNDING_OPTIONS.mo38610a())) {
                    m39601a(i, C11756Pb.m38949a(C11761Rb.CONSENT_AGREEMENT_FUNDING_OPTIONS), str4, null);
                    i++;
                }
                if (a2.contains(C11752Oa.FINANCIAL_INSTRUMENTS.mo38610a())) {
                    m39601a(i, C11756Pb.m38949a(C11761Rb.CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS), str4, C11939i.FINANCIAL_INSTRUMENTS);
                    i++;
                }
                if (a2.contains(C11752Oa.SEND_MONEY.mo38610a())) {
                    m39601a(i, String.format(C11756Pb.m38949a(C11761Rb.CONSENT_AGREEMENT_SEND_MONEY), new Object[]{str3, l}), str4, C11939i.SEND_MONEY);
                    i++;
                }
                if (a2.contains(C11752Oa.REQUEST_MONEY.mo38610a())) {
                    m39601a(i, String.format(C11756Pb.m38949a(C11761Rb.CONSENT_AGREEMENT_REQUEST_MONEY), new Object[]{str3, l}), str4, C11939i.REQUEST_MONEY);
                    i++;
                }
                if (a2.contains(C11752Oa.LOYALTY.mo38610a())) {
                    m39601a(i, C11756Pb.m38949a(C11761Rb.CONSENT_AGREEMENT_LOYALTY_CARD), str4, null);
                    i++;
                }
                if (a2.contains(C11752Oa.EXPRESS_CHECKOUT.mo38610a())) {
                    m39601a(i, C11756Pb.m38949a(C11761Rb.CONSENT_AGREEMENT_EXPRESS_CHECKOUT), str4, null);
                    i++;
                }
                if (!Collections.disjoint(a2, C11842l.f37266h)) {
                    if (m39618g().size() > 0) {
                        m39601a(i, String.format(C11756Pb.m38949a(C11761Rb.CONSENT_AGREEMENT_ATTRIBUTES), new Object[]{m39619h()}), str4, null);
                        i++;
                    }
                }
                String a4 = C11756Pb.m38949a(C11761Rb.CONSENT_AGREEMENT_MERCHANT_PRIVACY_POLICY);
                StringBuilder sb5 = new StringBuilder(str);
                sb5.append(l);
                sb5.append(str2);
                m39601a(i, String.format(a4, new Object[]{sb5.toString(), uri, uri2}), str4, null);
                this.f37583g.f37018d[i].setNextFocusRightId(2);
                int i2 = i + 1;
                String a5 = C11756Pb.m38949a(C11761Rb.PRIVACY);
                Object[] objArr = new Object[1];
                String lowerCase = Locale.getDefault().getCountry().toLowerCase(Locale.US);
                if (C11723Fa.m38818a((CharSequence) lowerCase)) {
                    lowerCase = "us";
                }
                objArr[0] = String.format("https://www.paypal.com/%s/cgi-bin/webscr?cmd=p/gen/ua/policy_privacy-outside", new Object[]{lowerCase});
                String format2 = String.format(a5, objArr);
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str4);
                sb6.append(format2);
                SpannableString spannableString = new SpannableString(Html.fromHtml(sb6.toString()));
                m39608b(spannableString);
                this.f37583g.f37019e.setText(spannableString);
                this.f37583g.f37019e.setMovementMethod(LinkMovementMethod.getInstance());
                this.f37583g.f37019e.setNextFocusLeftId((i2 + 100) - 1);
                this.f37583g.f37019e.setNextFocusRightId(1);
                SpannableString b = C11723Fa.m38820b(this.f37579c.mo38979d().mo38886a());
                if (b != null) {
                    this.f37583g.f37020f.setText(b);
                    this.f37583g.f37020f.setVisibility(0);
                }
                this.f37583g.f37025k.setText(C11756Pb.m38949a(C11761Rb.CONSENT_AGREEMENT_AGREE));
                this.f37583g.f37022h.setOnClickListener(new C11980vb(this));
                this.f37583g.f37024j.setOnClickListener(new C11983wb(this));
                this.f37583g.f37024j.setEnabled(true);
                C11941ib ibVar = this.f37582f;
                if (ibVar != null) {
                    m39603a(ibVar);
                    this.f37582f = null;
                }
            }
        }
    }

    /* renamed from: f */
    static /* synthetic */ void m39617f(C11950lb lbVar) {
        lbVar.f37579c.mo38965a(C12024xb.ConsentAgree);
        if (!lbVar.f37579c.mo38986k()) {
            StringBuilder sb = new StringBuilder("code/nonce invalid.  code:");
            sb.append(lbVar.f37579c.mo38978c().f36745e);
            sb.append(", nonce:");
            sb.append(lbVar.f37579c.mo38978c().f36750j);
            C11867Da.m39241a((Activity) lbVar, C11756Pb.m38949a(C11761Rb.SESSION_EXPIRED_MESSAGE), 4);
            return;
        }
        lbVar.showDialog(2);
        lbVar.f37579c.mo38973a(lbVar.f37581e.mo38922a());
    }

    /* renamed from: g */
    private Set m39618g() {
        C11986xb[] values;
        String str;
        C11761Rb rb;
        List a = this.f37581e.mo38922a();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (C11986xb xbVar : C11986xb.values()) {
            if (this.f37587k.mo39088a().contains(xbVar.name()) && a.contains(((C11842l) f37578b.get(xbVar)).mo38820a())) {
                if (xbVar == C11986xb.openid_connect) {
                    str = null;
                } else {
                    if (xbVar == C11986xb.oauth_account_creation_date) {
                        rb = C11761Rb.CONSENT_AGREEMENT_ATTRIBUTE_ACCOUNT_CREATION_DATE;
                    } else if (xbVar == C11986xb.oauth_account_verified) {
                        rb = C11761Rb.CONSENT_AGREEMENT_ATTRIBUTE_ACCOUNT_STATUS;
                    } else if (xbVar == C11986xb.oauth_account_type) {
                        rb = C11761Rb.CONSENT_AGREEMENT_ATTRIBUTE_ACCOUNT_TYPE;
                    } else if (xbVar == C11986xb.oauth_street_address1 || xbVar == C11986xb.oauth_street_address2 || xbVar == C11986xb.oauth_city || xbVar == C11986xb.oauth_state || xbVar == C11986xb.oauth_country || xbVar == C11986xb.oauth_zip) {
                        rb = C11761Rb.CONSENT_AGREEMENT_ATTRIBUTE_ADDRESS;
                    } else if (xbVar == C11986xb.oauth_age_range) {
                        rb = C11761Rb.CONSENT_AGREEMENT_ATTRIBUTE_AGE_RANGE;
                    } else if (xbVar == C11986xb.oauth_date_of_birth) {
                        rb = C11761Rb.CONSENT_AGREEMENT_ATTRIBUTE_DATE_OF_BIRTH;
                    } else if (xbVar == C11986xb.oauth_email) {
                        rb = C11761Rb.CONSENT_AGREEMENT_ATTRIBUTE_EMAIL_ADDRESS;
                    } else if (xbVar == C11986xb.oauth_fullname) {
                        rb = C11761Rb.CONSENT_AGREEMENT_ATTRIBUTE_FULL_NAME;
                    } else if (xbVar == C11986xb.oauth_gender) {
                        rb = C11761Rb.CONSENT_AGREEMENT_ATTRIBUTE_GENDER;
                    } else if (xbVar == C11986xb.oauth_language) {
                        rb = C11761Rb.CONSENT_AGREEMENT_ATTRIBUTE_LANGUAGE;
                    } else if (xbVar == C11986xb.oauth_locale) {
                        rb = C11761Rb.CONSENT_AGREEMENT_ATTRIBUTE_LOCALE;
                    } else if (xbVar == C11986xb.oauth_phone_number) {
                        rb = C11761Rb.CONSENT_AGREEMENT_ATTRIBUTE_PHONE;
                    } else if (xbVar == C11986xb.oauth_timezone) {
                        rb = C11761Rb.CONSENT_AGREEMENT_ATTRIBUTE_TIME_ZONE;
                    } else {
                        str = xbVar.name();
                    }
                    str = C11756Pb.m38949a(rb);
                }
                if (str != null) {
                    linkedHashSet.add(str);
                }
            }
        }
        return linkedHashSet;
    }

    /* renamed from: h */
    private String m39619h() {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : m39618g()) {
            if (!z) {
                sb.append(", ");
            } else {
                z = false;
            }
            sb.append(str);
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m39620i() {
        m39600a(-1, new PayPalAuthorization(this.f37579c.mo38980e(), this.f37579c.mo38978c().f36745e.mo38740a(), this.f37579c.mo38978c().f36743c));
        finish();
    }

    /* renamed from: j */
    private void m39621j() {
        String b = this.f37579c.mo38978c().f36745e.mo38741b();
        if (b == null || !Arrays.asList(b.split(" ")).containsAll(this.f37581e.mo38922a())) {
            m39610c();
        } else {
            m39620i();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m39622k() {
        try {
            dismissDialog(2);
        } catch (IllegalArgumentException e) {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo38849a();

    public void finish() {
        super.finish();
        StringBuilder sb = new StringBuilder();
        sb.append(f37577a);
        sb.append(".finish");
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        StringBuilder sb = new StringBuilder();
        sb.append(f37577a);
        sb.append(".onActivityResult(");
        sb.append(i);
        String str = ",";
        sb.append(str);
        sb.append(i2);
        sb.append(str);
        sb.append(intent);
        sb.append(")");
        if (i != 1) {
            if (i != 2) {
                String str2 = f37577a;
                StringBuilder sb2 = new StringBuilder("unhandled requestCode ");
                sb2.append(i);
                Log.e(str2, sb2.toString());
            } else if (i2 == -1) {
                C11941ib a = C11947kb.m39592a(intent.getExtras());
                if (this.f37579c == null) {
                    this.f37582f = a;
                } else {
                    m39603a(a);
                    return;
                }
            }
            return;
        } else if (i2 == -1) {
            if (this.f37579c == null) {
                this.f37586j = true;
                return;
            } else {
                m39621j();
                return;
            }
        }
        m39600a(i2, (PayPalAuthorization) null);
        finish();
    }

    public void onBackPressed() {
        this.f37579c.mo38965a(C12024xb.ConsentCancel);
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StringBuilder sb = new StringBuilder();
        sb.append(f37577a);
        sb.append(".onCreate");
        if (bundle == null) {
            if (!C11867Da.m39243a((Activity) this)) {
                finish();
            }
            this.f37584h = false;
        } else {
            this.f37584h = bundle.getBoolean("pageTrackingSent");
            this.f37585i = bundle.getBoolean("isLoginActivityStarted");
        }
        mo38849a();
        this.f37587k = (C11925du) getIntent().getParcelableExtra("com.paypal.android.sdk.payments.ppAppInfo");
        m39612d();
        setTheme(16973934);
        requestWindowFeature(8);
        this.f37583g = new C11764Sb(this);
        setContentView(this.f37583g.f37015a);
        C11867Da.m39239a((Activity) this, this.f37583g.f37017c, (C11761Rb) null);
        this.f37583g.f37022h.setText(C11756Pb.m38949a(C11761Rb.CANCEL));
        this.f37583g.f37022h.setVisibility(0);
        m39616f();
    }

    /* access modifiers changed from: protected */
    public Dialog onCreateDialog(int i, Bundle bundle) {
        if (i == 1) {
            return C11867Da.m39228a((Activity) this, C11761Rb.CONSENT_FAILED_ALERT_TITLE, bundle);
        }
        if (i == 2) {
            return C11867Da.m39231a((Context) this, C11761Rb.PROCESSING, C11761Rb.ONE_MOMENT);
        }
        if (i == 3) {
            return C11867Da.m39229a((Activity) this, C11761Rb.INTERNAL_ERROR, bundle, i);
        }
        if (i != 4) {
            return null;
        }
        return C11867Da.m39230a((Activity) this, C11761Rb.SESSION_EXPIRED_TITLE, bundle, (OnClickListener) new C11971sb(this));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        StringBuilder sb = new StringBuilder();
        sb.append(f37577a);
        sb.append(".onDestroy");
        PayPalService payPalService = this.f37579c;
        if (payPalService != null) {
            payPalService.mo38988m();
        }
        if (this.f37580d) {
            unbindService(this.f37588l);
            this.f37580d = false;
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        m39612d();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        StringBuilder sb = new StringBuilder();
        sb.append(f37577a);
        sb.append(".onResume");
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("pageTrackingSent", this.f37584h);
        bundle.putBoolean("isLoginActivityStarted", this.f37585i);
    }
}
