package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.p000v4.content.C0515e;

public class CustomTabActivity extends Activity {

    /* renamed from: a */
    public static final String f11760a;

    /* renamed from: b */
    public static final String f11761b;

    /* renamed from: c */
    private BroadcastReceiver f11762c;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(CustomTabActivity.class.getSimpleName());
        sb.append(".action_customTabRedirect");
        f11760a = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(CustomTabActivity.class.getSimpleName());
        sb2.append(".action_destroy");
        f11761b = sb2.toString();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, CustomTabMainActivity.class);
        intent.setAction(f11760a);
        intent.putExtra(CustomTabMainActivity.f11765c, getIntent().getDataString());
        intent.addFlags(603979776);
        startActivityForResult(intent, 2);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 0) {
            Intent broadcast = new Intent(f11760a);
            broadcast.putExtra(CustomTabMainActivity.f11765c, getIntent().getDataString());
            C0515e.m2597a((Context) this).mo5314a(broadcast);
            this.f11762c = new C6740j(this);
            C0515e.m2597a((Context) this).mo5313a(this.f11762c, new IntentFilter(f11761b));
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        C0515e.m2597a((Context) this).mo5312a(this.f11762c);
        super.onDestroy();
    }
}
