package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.p000v4.content.C0515e;
import com.facebook.internal.C6725m;

public class CustomTabMainActivity extends Activity {

    /* renamed from: a */
    public static final String f11763a;

    /* renamed from: b */
    public static final String f11764b;

    /* renamed from: c */
    public static final String f11765c;

    /* renamed from: d */
    public static final String f11766d;

    /* renamed from: e */
    private boolean f11767e = true;

    /* renamed from: f */
    private BroadcastReceiver f11768f;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(CustomTabMainActivity.class.getSimpleName());
        sb.append(".extra_params");
        f11763a = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(CustomTabMainActivity.class.getSimpleName());
        sb2.append(".extra_chromePackage");
        f11764b = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(CustomTabMainActivity.class.getSimpleName());
        sb3.append(".extra_url");
        f11765c = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(CustomTabMainActivity.class.getSimpleName());
        sb4.append(".action_refresh");
        f11766d = sb4.toString();
    }

    /* renamed from: a */
    public static final String m12845a() {
        StringBuilder sb = new StringBuilder();
        sb.append("fb");
        sb.append(C6787r.m13816f());
        sb.append("://authorize");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (CustomTabActivity.f11760a.equals(getIntent().getAction())) {
            setResult(0);
            finish();
            return;
        }
        if (savedInstanceState == null) {
            Bundle parameters = getIntent().getBundleExtra(f11763a);
            new C6725m("oauth", parameters).mo19967a(this, getIntent().getStringExtra(f11764b));
            this.f11767e = false;
            this.f11768f = new C6741k(this);
            C0515e.m2597a((Context) this).mo5313a(this.f11768f, new IntentFilter(CustomTabActivity.f11760a));
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (f11766d.equals(intent.getAction())) {
            C0515e.m2597a((Context) this).mo5314a(new Intent(CustomTabActivity.f11761b));
            m12846a(-1, intent);
        } else if (CustomTabActivity.f11760a.equals(intent.getAction())) {
            m12846a(-1, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f11767e) {
            m12846a(0, null);
        }
        this.f11767e = true;
    }

    /* renamed from: a */
    private void m12846a(int resultCode, Intent resultIntent) {
        C0515e.m2597a((Context) this).mo5312a(this.f11768f);
        if (resultIntent != null) {
            setResult(resultCode, resultIntent);
        } else {
            setResult(resultCode);
        }
        finish();
    }
}
