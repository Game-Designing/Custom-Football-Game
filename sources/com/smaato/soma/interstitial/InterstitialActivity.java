package com.smaato.soma.interstitial;

import android.content.Intent;
import android.os.Bundle;
import com.smaato.soma.C12056Ja;
import com.smaato.soma.C12369fa;
import com.smaato.soma.C12514ua;
import com.smaato.soma.p260i.C12402c;

public class InterstitialActivity extends C12412d implements C12514ua {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final String f38761c = InterstitialActivity.class.getSimpleName();

    /* renamed from: d */
    private boolean f38762d = true;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C12428r f38763e;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new C12423m(this).execute();
    }

    public void onWillOpenLandingPage(C12369fa sender) {
        if (this.f38763e.getInterstitialAdDispatcher() != null) {
            this.f38763e.getInterstitialAdDispatcher().mo39485e();
        }
    }

    public void onWillCloseLandingPage(C12369fa sender) {
        if (this.f38762d && this.f38763e.getInterstitialAdDispatcher() != null) {
            this.f38763e.getInterstitialAdDispatcher().mo39483c();
            this.f38762d = false;
        }
        finish();
    }

    /* renamed from: a */
    public void mo39904a() {
        if (this.f38763e.getInterstitialAdDispatcher() != null) {
            this.f38763e.getInterstitialAdDispatcher().mo39484d();
        }
    }

    public void onBackPressed() {
        if (this.f38762d && this.f38763e.getInterstitialAdDispatcher() != null) {
            this.f38763e.getInterstitialAdDispatcher().mo39483c();
            this.f38762d = false;
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        C12428r rVar = this.f38763e;
        if (rVar != null) {
            rVar.mo39229n();
            if (this.f38762d && this.f38763e.getInterstitialAdDispatcher() != null) {
                this.f38763e.getInterstitialAdDispatcher().mo39483c();
                this.f38762d = false;
            }
        }
        super.onDestroy();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (this.f38763e.getInterstitialAdDispatcher() != null) {
            this.f38763e.getInterstitialAdDispatcher().mo39483c();
            this.f38762d = false;
        }
    }

    /* renamed from: a */
    public void mo39905a(boolean isVisible) {
        C12402c cVar = this.f38768b;
        if (cVar != null) {
            cVar.setImageResource(isVisible ? C12056Ja.ic_browser_close_40dp : 17170445);
        }
    }
}
