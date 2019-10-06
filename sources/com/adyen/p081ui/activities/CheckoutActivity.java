package com.adyen.p081ui.activities;

import android.app.ActionBar;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.C0424G;
import android.support.p000v4.app.C0486t;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.content.C0515e;
import android.util.Log;
import android.widget.TextView;
import com.adyen.core.models.PaymentMethod;
import com.adyen.p081ui.C5626c;
import com.adyen.p081ui.C5631d;
import com.adyen.p081ui.p083b.C5596e;
import com.adyen.p081ui.p083b.C5596e.C5597a;
import com.adyen.p081ui.p083b.C5598f;
import com.adyen.p081ui.p083b.C5598f.C5599a;
import com.adyen.p081ui.p083b.C5603j;
import com.adyen.p081ui.p083b.C5608l.C5609a;
import com.adyen.p081ui.p083b.C5610m;
import com.adyen.p081ui.p083b.C5611n;
import com.adyen.p081ui.p083b.C5614q;
import com.adyen.p081ui.p083b.C5614q.C5617c;
import com.adyen.p081ui.p083b.C5618r;
import com.adyen.p081ui.p083b.C5623w.C5624a;
import com.adyen.p081ui.p083b.C5625x;
import java.util.ArrayList;
import java.util.List;
import p019d.p135a.p136a.p139c.C6878a;
import p019d.p135a.p136a.p139c.C6889d;

/* renamed from: com.adyen.ui.activities.CheckoutActivity */
public class CheckoutActivity extends C0014p {
    private static final String TAG = CheckoutActivity.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f9401a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f9402b;

    /* renamed from: c */
    int f9403c;

    /* renamed from: d */
    private BroadcastReceiver f9404d = new C5582a(this);

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Fragment fragment = getSupportFragmentManager().mo4908a("CREDIT_CARD_FRAGMENT");
        if (fragment instanceof C5596e) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        this.f9402b = this;
        this.f9401a = false;
        m9827b();
        m9823a(getIntent());
        C0515e.m2597a(getApplicationContext()).mo5313a(this.f9404d, new IntentFilter("com.adyen.core.ui.finish"));
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f9401a = false;
        Log.d(TAG, "onNewIntent()");
        if (!intent.getExtras().containsKey("REDIRECT_RETURN")) {
            m9823a(intent);
        } else if (this.f9403c == 1) {
            getSupportFragmentManager().mo4929a(C5614q.class.getName(), 0);
        }
    }

    public void onBackPressed() {
        if (this.f9401a) {
            Log.w(TAG, "Going back at this step is not possible.");
            return;
        }
        int backStackEntryCount = getSupportFragmentManager().mo4943c();
        if (backStackEntryCount == 0) {
            super.onBackPressed();
        } else {
            String tag = getSupportFragmentManager().mo4933b(backStackEntryCount - 1).getName();
            if (C5614q.class.getName().equals(tag) || C5611n.class.getName().equals(tag)) {
                C0515e.m2597a((Context) this).mo5314a(new Intent("com.adyen.core.ui.PaymentRequestCancelled"));
                finish();
            } else if (backStackEntryCount == 1) {
                finish();
            } else {
                getSupportFragmentManager().mo4961g();
            }
        }
    }

    /* renamed from: a */
    private void m9823a(Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle == null) {
            finish();
            return;
        }
        int fragmentId = bundle.getInt("fragment", -1);
        this.f9403c = fragmentId;
        if (fragmentId != 0) {
            String str = "PaymentMethod";
            String str2 = "amount";
            if (fragmentId == 1) {
                C5598f fVar = new C5598f();
                fVar.mo17739a((C6889d) intent.getSerializableExtra(str));
                fVar.mo17742b(intent.getStringExtra("public_key"));
                fVar.mo17740a(intent.getStringExtra("generation_time"));
                fVar.mo17738a((C6878a) intent.getSerializableExtra(str2));
                fVar.mo17743c(intent.getStringExtra("shopper_reference"));
                fVar.mo17737a(C5599a.valueOf(intent.getStringExtra("cvc_field_status")));
                fVar.mo17741a(intent.getBooleanExtra("payment_card_scan_enabled", false));
                fVar.mo17736a((C5597a) new C5584c(this));
                m9825a((Fragment) fVar.mo17735a(), "CREDIT_CARD_FRAGMENT");
            } else if (fragmentId == 2) {
                C6889d paymentMethod = (C6889d) bundle.getSerializable(str);
                C5610m mVar = new C5610m();
                mVar.mo17763a(paymentMethod);
                mVar.mo17762a((C5609a) new C5585d(this, paymentMethod));
                m9824a((Fragment) mVar.mo17761a());
            } else if (fragmentId == 3) {
                C6889d paymentMethod2 = (C6889d) bundle.getSerializable(str);
                C5625x xVar = new C5625x();
                xVar.mo17779a((C6878a) intent.getSerializableExtra(str2));
                xVar.mo17778a((C5624a) new C5586e(this, paymentMethod2));
                m9824a((Fragment) xVar.mo17777a());
            } else if (fragmentId == 4) {
                C5603j giropayFragment = new C5603j();
                Bundle giroPayBundle = new Bundle();
                giroPayBundle.putSerializable(str2, intent.getSerializableExtra(str2));
                giropayFragment.setArguments(giroPayBundle);
                m9824a((Fragment) giropayFragment);
            } else if (fragmentId == 11) {
                m9824a((Fragment) new C5611n());
            } else {
                throw new IllegalStateException("Unknown fragment selected");
            }
        } else {
            ArrayList<PaymentMethod> preferredPaymentMethods = (ArrayList) bundle.getSerializable("preferredPaymentMethods");
            ArrayList<PaymentMethod> paymentMethods = (ArrayList) bundle.getSerializable("filteredPaymentMethods");
            C5618r rVar = new C5618r();
            rVar.mo17771a((List<C6889d>) paymentMethods);
            rVar.mo17772b(preferredPaymentMethods);
            rVar.mo17770a((C5617c) new C5583b(this));
            m9824a((Fragment) rVar.mo17769a());
            hideKeyboard();
        }
    }

    /* renamed from: b */
    private void m9827b() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setCustomView(C5631d.action_bar);
            actionBar.setDisplayOptions(16);
            actionBar.getCustomView().findViewById(C5626c.action_bar_back_icon).setOnClickListener(new C5587f(this));
        }
    }

    /* renamed from: a */
    public void mo17713a(int titleId) {
        ActionBar actionBar = getActionBar();
        if (actionBar != null && actionBar.getCustomView() != null) {
            ((TextView) actionBar.getCustomView().findViewById(C5626c.action_bar_title)).setText(getString(titleId));
            actionBar.show();
        }
    }

    /* renamed from: a */
    public void mo17712a() {
        if (getActionBar() != null) {
            getActionBar().hide();
        }
    }

    private void hideKeyboard() {
        if (getWindow() != null) {
            getWindow().setSoftInputMode(3);
        }
    }

    /* renamed from: a */
    private void m9824a(Fragment fragment) {
        m9825a(fragment, (String) null);
    }

    /* renamed from: a */
    private void m9825a(Fragment fragment, String tag) {
        String backStateName = fragment.getClass().getName();
        C0486t manager = getSupportFragmentManager();
        if (!manager.mo4929a(backStateName, 0)) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Starting fragment: ");
            sb.append(backStateName);
            Log.d(str, sb.toString());
            C0424G ft = manager.mo4909a();
            ft.mo5041b(16908290, fragment, tag);
            ft.mo5038a(backStateName);
            ft.mo5032a();
            return;
        }
        Log.d(TAG, "Fragment popped back");
    }
}
