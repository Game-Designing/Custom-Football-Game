package com.facebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.C0424G;
import android.support.p000v4.app.C0486t;
import android.support.p000v4.app.Fragment;
import com.facebook.common.C6656b;
import com.facebook.common.C6657c;
import com.facebook.internal.C6678J;
import com.facebook.internal.C6694S;
import com.facebook.internal.C6728p;
import com.facebook.login.C6779x;
import com.facebook.share.internal.DeviceShareDialogFragment;
import com.facebook.share.model.ShareContent;

public class FacebookActivity extends C0014p {
    private static final String TAG = FacebookActivity.class.getName();

    /* renamed from: a */
    public static String f11770a = "PassThrough";

    /* renamed from: b */
    private static String f11771b = "SingleFragment";

    /* renamed from: c */
    private Fragment f11772c;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (!C6787r.m13829s()) {
            C6694S.m13433b(TAG, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
            C6787r.m13813c(getApplicationContext());
        }
        setContentView(C6657c.com_facebook_activity_layout);
        if (f11770a.equals(intent.getAction())) {
            m12852c();
        } else {
            this.f11772c = mo19657b();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Fragment mo19657b() {
        Intent intent = getIntent();
        C0486t manager = getSupportFragmentManager();
        Fragment fragment = manager.mo4908a(f11771b);
        if (fragment != null) {
            return fragment;
        }
        if ("FacebookDialogFragment".equals(intent.getAction())) {
            C6728p dialogFragment = new C6728p();
            dialogFragment.setRetainInstance(true);
            dialogFragment.show(manager, f11771b);
            return dialogFragment;
        }
        if ("DeviceShareDialogFragment".equals(intent.getAction())) {
            DeviceShareDialogFragment dialogFragment2 = new DeviceShareDialogFragment();
            dialogFragment2.setRetainInstance(true);
            dialogFragment2.mo20142a((ShareContent) intent.getParcelableExtra("content"));
            dialogFragment2.show(manager, f11771b);
            return dialogFragment2;
        }
        Fragment fragment2 = new C6779x();
        fragment2.setRetainInstance(true);
        C0424G a = manager.mo4909a();
        a.mo5035a(C6656b.com_facebook_fragment_container, fragment2, f11771b);
        a.mo5032a();
        return fragment2;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Fragment fragment = this.f11772c;
        if (fragment != null) {
            fragment.onConfigurationChanged(newConfig);
        }
    }

    /* renamed from: a */
    public Fragment mo19656a() {
        return this.f11772c;
    }

    /* renamed from: c */
    private void m12852c() {
        setResult(0, C6678J.m13338a(getIntent(), (Bundle) null, C6678J.m13341a(C6678J.m13349b(getIntent()))));
        finish();
    }
}
