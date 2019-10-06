package com.paypal.android.sdk.payments;

import android.util.Log;
import com.paypal.android.sdk.C11703Aa;
import com.paypal.android.sdk.C11704Ab;
import com.paypal.android.sdk.C11708Bb;
import com.paypal.android.sdk.C11712Cb;
import com.paypal.android.sdk.C11716Db;
import com.paypal.android.sdk.C11724Fb;
import com.paypal.android.sdk.C11728Gb;
import com.paypal.android.sdk.C11732Hb;
import com.paypal.android.sdk.C11737Ja;
import com.paypal.android.sdk.C11747Mb;
import com.paypal.android.sdk.C11749Na;
import com.paypal.android.sdk.C11750Nb;
import com.paypal.android.sdk.C11763Sa;
import com.paypal.android.sdk.C11765T;
import com.paypal.android.sdk.C11802db;
import com.paypal.android.sdk.C11804dl;
import com.paypal.android.sdk.C11805ds;
import com.paypal.android.sdk.C11806dv;
import com.paypal.android.sdk.C11807dx;
import com.paypal.android.sdk.C11810eb;
import com.paypal.android.sdk.C11814eo;
import com.paypal.android.sdk.C12024xb;
import com.paypal.android.sdk.C12028yb;
import java.util.UUID;

/* renamed from: com.paypal.android.sdk.payments.ja */
final class C11943ja implements C11810eb {

    /* renamed from: a */
    private /* synthetic */ PayPalService f37570a;

    private C11943ja(PayPalService payPalService) {
        this.f37570a = payPalService;
    }

    /* synthetic */ C11943ja(PayPalService payPalService, byte b) {
        this(payPalService);
    }

    /* renamed from: a */
    private static C11806dv m39569a(String str, String str2, long j) {
        String str3 = str;
        String str4 = str2;
        C11806dv dvVar = new C11806dv(str3, str4, System.currentTimeMillis() + (j * 1000), true);
        return dvVar;
    }

    /* renamed from: a */
    public final void mo38747a() {
        PayPalService.f37409a;
    }

    /* renamed from: a */
    public final void mo38748a(C11704Ab ab) {
        String b = ab.mo38518p().mo38700b();
        PayPalService.f37409a;
        new StringBuilder("ConsentRequest Error:").append(b);
        Log.e("paypal.sdk", b);
        this.f37570a.f37417i.mo39071a(this.f37570a.m39383b((C11703Aa) ab));
    }

    /* renamed from: a */
    public final void mo38749a(C11708Bb bb) {
        String b = bb.mo38518p().mo38700b();
        PayPalService.f37409a;
        new StringBuilder("CreateSfoPaymentRequest Error: ").append(b);
        Log.e("paypal.sdk", b);
        this.f37570a.f37417i.mo39071a(this.f37570a.m39383b((C11703Aa) bb));
    }

    /* renamed from: a */
    public final void mo38750a(C11712Cb cb) {
        PayPalService.f37409a;
        this.f37570a.mo38969a(C12024xb.PaymentSuccessful, cb.mo38513j(), cb.mo38586w());
        this.f37570a.f37417i.mo39072a(C11867Da.m39235a((C11703Aa) cb));
        if (cb.mo38546C() == null || !cb.mo38583t()) {
            if (!cb.mo38583t()) {
                this.f37570a.mo39001t();
            }
            this.f37570a.f37417i.mo39069a();
            return;
        }
        String uuid = UUID.randomUUID().toString();
        C11765T b = this.f37570a.mo38976b();
        C11750Nb nb = new C11750Nb(this.f37570a.mo38976b(), this.f37570a.mo38956a(), this.f37570a.mo38978c().f36742b.mo38703b(), uuid, cb.mo38547D(), cb.mo38546C(), cb.mo38548E(), cb.mo38549F(), cb.mo38550G());
        b.mo38630b(nb);
    }

    /* renamed from: a */
    public final void mo38751a(C11716Db db) {
        String b = db.mo38518p().mo38700b();
        PayPalService.f37409a;
        new StringBuilder("DeleteCreditCardRequest Error:").append(b);
        Log.e("paypal.sdk", b);
    }

    /* renamed from: a */
    public final void mo38752a(C11724Fb fb) {
        String b = fb.mo38518p().mo38700b();
        PayPalService.f37409a;
        new StringBuilder("GetAppInfoRequest Error: ").append(b);
        Log.e("paypal.sdk", b);
        this.f37570a.f37417i.mo39071a(this.f37570a.m39383b((C11703Aa) fb));
    }

    /* renamed from: a */
    public final void mo38753a(C11728Gb gb) {
        String b = gb.mo38518p().mo38700b();
        PayPalService.f37409a;
        new StringBuilder("LoginChallengeRequest Error:").append(b);
        Log.e("paypal.sdk", b);
        this.f37570a.f37416h.mo39071a(this.f37570a.m39383b((C11703Aa) gb));
    }

    /* renamed from: a */
    public final void mo38754a(C11732Hb hb) {
        C12024xb xbVar;
        PayPalService payPalService;
        String b = hb.mo38518p().mo38700b();
        PayPalService.f37409a;
        new StringBuilder("LoginRequest Error: ").append(b);
        Log.e("paypal.sdk", b);
        this.f37570a.mo38983h();
        C11814eo eoVar = hb.f36686q;
        boolean z = hb.f36687r;
        if (eoVar.mo38772a()) {
            payPalService = this.f37570a;
            xbVar = C12024xb.LoginPassword;
        } else {
            payPalService = this.f37570a;
            xbVar = C12024xb.LoginPIN;
        }
        payPalService.m39377a(xbVar, z, b, hb.mo38513j(), (String) null);
        this.f37570a.f37424p.mo38618b();
        if (hb.f36704o) {
            this.f37570a.mo38978c().f36750j = hb.f36703n;
            this.f37570a.mo38978c().f36746f = new C11802db(hb.f36705p);
        }
        this.f37570a.f37416h.mo39071a(this.f37570a.m39383b((C11703Aa) hb));
    }

    /* renamed from: a */
    public final void mo38755a(C11747Mb mb) {
        PayPalService.m39375a(this.f37570a, (C11703Aa) mb);
    }

    /* renamed from: a */
    public final void mo38756a(C11750Nb nb) {
        String b = nb.mo38518p().mo38700b();
        PayPalService.f37409a;
        new StringBuilder("TokenizeCreditCardRequest Error:").append(b);
        Log.e("paypal.sdk", b);
        this.f37570a.f37417i.mo39069a();
    }

    /* renamed from: a */
    public final void mo38757a(C12028yb ybVar) {
        String b = ybVar.mo38518p().mo38700b();
        PayPalService.f37409a;
        new StringBuilder("ApproveAndExecuteSfoPaymentRequest Error: ").append(b);
        PayPalService.m39388c(this.f37570a, ybVar);
    }

    /* renamed from: b */
    public final void mo38758b(C11704Ab ab) {
        PayPalService.f37409a;
        this.f37570a.mo38968a(C12024xb.AuthorizationSuccessful, ab.mo38513j());
        this.f37570a.f37417i.mo39072a((Object) ab.f36574q);
        this.f37570a.f37417i.mo39069a();
    }

    /* renamed from: b */
    public final void mo38759b(C11708Bb bb) {
        PayPalService.f37409a;
        this.f37570a.f37417i.mo39072a((Object) bb);
        this.f37570a.f37417i.mo39069a();
    }

    /* renamed from: b */
    public final void mo38760b(C11712Cb cb) {
        String b = cb.mo38518p().mo38700b();
        PayPalService.f37409a;
        new StringBuilder("CreditCardPaymentRequest Error:").append(b);
        PayPalService.m39388c(this.f37570a, cb);
    }

    /* renamed from: b */
    public final void mo38761b(C11724Fb fb) {
        PayPalService.f37409a;
        this.f37570a.f37417i.mo39072a((Object) fb);
        this.f37570a.f37417i.mo39069a();
    }

    /* renamed from: b */
    public final void mo38762b(C11728Gb gb) {
        PayPalService.f37409a;
        this.f37570a.mo38978c().f36750j = gb.f36703n;
        this.f37570a.f37416h.mo39069a();
    }

    /* renamed from: b */
    public final void mo38763b(C11732Hb hb) {
        C11763Sa sa;
        C12024xb xbVar;
        PayPalService payPalService;
        PayPalService.f37409a;
        long j = hb.f36685A;
        if (j > 840) {
            j = 840;
        }
        if (hb.f36693x == null) {
            this.f37570a.mo38978c().f36747g = m39569a(hb.f36694y, hb.f36695z, j);
        } else {
            this.f37570a.mo38978c().f36750j = hb.f36703n;
            this.f37570a.mo38978c().f36745e = new C11807dx(hb.f36693x, hb.f36695z);
        }
        this.f37570a.mo38978c().f36746f = null;
        C11804dl dlVar = new C11804dl();
        if (hb.f36686q.mo38772a()) {
            dlVar.mo38720a(hb.f36686q.mo38773b());
            sa = C11763Sa.EMAIL;
        } else {
            dlVar.mo38719a(hb.f36686q.mo38775d());
            sa = C11763Sa.PHONE;
        }
        dlVar.mo38718a(sa);
        this.f37570a.mo38978c().f36744d = dlVar;
        if (hb.f36686q.mo38772a()) {
            this.f37570a.mo38978c().f36743c = hb.f36686q.mo38773b();
            payPalService = this.f37570a;
            xbVar = C12024xb.LoginPassword;
        } else {
            this.f37570a.mo38978c().f36743c = hb.f36686q.mo38775d().mo38785a(C11737Ja.m38864a());
            payPalService = this.f37570a;
            xbVar = C12024xb.LoginPIN;
        }
        payPalService.mo38967a(xbVar, Boolean.valueOf(hb.f36687r), hb.mo38513j());
        this.f37570a.f37416h.mo39069a();
    }

    /* renamed from: b */
    public final void mo38764b(C11747Mb mb) {
        PayPalService.f37409a;
        this.f37570a.mo38968a(C12024xb.DeviceCheck, mb.mo38513j());
        this.f37570a.mo38978c().f36742b = m39569a(mb.f36754q, mb.f36755r, mb.f36756s);
        this.f37570a.mo38978c().f36749i = mb.f36757t;
        this.f37570a.f37415g = false;
        if (this.f37570a.f37421m != null) {
            PayPalService.f37409a;
            this.f37570a.f37421m.mo38878a();
            this.f37570a.f37421m = null;
        }
    }

    /* renamed from: b */
    public final void mo38765b(C11750Nb nb) {
        PayPalService.f37409a;
        C11805ds dsVar = new C11805ds(this.f37570a.f37423o, nb.mo38603t(), nb.f36763m, nb.mo38605v(), nb.mo38604u(), nb.mo38606w(), nb.mo38607x(), nb.mo38608y());
        this.f37570a.f37424p.mo38617a(dsVar, this.f37570a.f37414f.mo38899k());
        this.f37570a.f37417i.mo39069a();
    }

    /* renamed from: b */
    public final void mo38766b(C12028yb ybVar) {
        PayPalService.f37409a;
        this.f37570a.mo38969a(C12024xb.PaymentSuccessful, ybVar.mo38513j(), ybVar.mo39213t());
        if (!ybVar.mo39214u() || (this.f37570a.mo38978c().f36747g != null && !this.f37570a.mo38978c().f36747g.mo38736c())) {
            this.f37570a.mo38983h();
        } else {
            C11749Na.m38903a(this.f37570a.mo38978c().f36747g, this.f37570a.mo38980e());
            if (this.f37570a.mo38978c().f36744d != null) {
                this.f37570a.f37424p.mo38616a(this.f37570a.mo38978c().f36744d);
            }
        }
        this.f37570a.f37417i.mo39072a(C11867Da.m39235a((C11703Aa) ybVar));
        this.f37570a.f37417i.mo39069a();
    }
}
