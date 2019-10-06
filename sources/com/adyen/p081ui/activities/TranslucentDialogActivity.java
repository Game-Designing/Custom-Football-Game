package com.adyen.p081ui.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.p000v4.content.C0515e;
import com.adyen.p081ui.views.C5644f;
import p019d.p135a.p136a.p139c.C6878a;
import p019d.p135a.p136a.p139c.C6889d;

/* renamed from: com.adyen.ui.activities.TranslucentDialogActivity */
public class TranslucentDialogActivity extends Activity {

    /* renamed from: a */
    private C5644f f9407a;

    /* renamed from: b */
    private BroadcastReceiver f9408b = new C5590i(this);

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        m9833a(getIntent());
        C0515e.m2597a(getApplicationContext()).mo5313a(this.f9408b, new IntentFilter("com.adyen.core.ui.finish"));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /* renamed from: a */
    private void m9833a(Intent intent) {
        C5644f fVar = this.f9407a;
        if (fVar != null && fVar.isShowing()) {
            this.f9407a.dismiss();
        }
        this.f9407a = new C5644f(this, (C6878a) intent.getSerializableExtra("amount"), (C6889d) intent.getSerializableExtra("PaymentMethod"), new C5589h(this));
        this.f9407a.show();
    }

    public void onBackPressed() {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        C5644f fVar = this.f9407a;
        if (fVar != null && fVar.isShowing()) {
            this.f9407a.dismiss();
        }
    }

    public void finish() {
        super.finish();
        C5644f fVar = this.f9407a;
        if (fVar != null && fVar.isShowing()) {
            this.f9407a.dismiss();
        }
    }
}
