package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.C0478k;
import com.facebook.C6787r;
import com.facebook.FacebookException;
import com.facebook.internal.C6702Y.C6703a;
import com.facebook.internal.C6702Y.C6705c;

/* renamed from: com.facebook.internal.p */
/* compiled from: FacebookDialogFragment */
public class C6728p extends C0478k {

    /* renamed from: a */
    private Dialog f12297a;

    /* renamed from: a */
    public void mo19968a(Dialog dialog) {
        this.f12297a = dialog;
    }

    public void onCreate(Bundle savedInstanceState) {
        C6702Y webDialog;
        super.onCreate(savedInstanceState);
        if (this.f12297a == null) {
            C0014p activity = getActivity();
            Bundle params = C6678J.m13349b(activity.getIntent());
            String str = "FacebookDialogFragment";
            if (!params.getBoolean("is_fallback", false)) {
                String actionName = params.getString("action");
                Bundle webParams = params.getBundle("params");
                if (C6694S.m13436b(actionName)) {
                    C6694S.m13433b(str, "Cannot start a WebDialog with an empty/missing 'actionName'");
                    activity.finish();
                    return;
                }
                C6703a aVar = new C6703a(activity, actionName, webParams);
                aVar.mo19933a(new C6726n(this));
                webDialog = aVar.mo19934a();
            } else {
                String url = params.getString("url");
                if (C6694S.m13436b(url)) {
                    C6694S.m13433b(str, "Cannot start a fallback WebDialog with an empty/missing 'url'");
                    activity.finish();
                    return;
                }
                C6702Y webDialog2 = C6735w.m13565a(activity, url, String.format("fb%s://bridge/", new Object[]{C6787r.m13816f()}));
                webDialog2.mo19917a((C6705c) new C6727o(this));
                webDialog = webDialog2;
            }
            this.f12297a = webDialog;
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (this.f12297a == null) {
            m13553a((Bundle) null, (FacebookException) null);
            setShowsDialog(false);
        }
        return this.f12297a;
    }

    public void onResume() {
        super.onResume();
        Dialog dialog = this.f12297a;
        if (dialog instanceof C6702Y) {
            ((C6702Y) dialog).mo19925e();
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if ((this.f12297a instanceof C6702Y) && isResumed()) {
            ((C6702Y) this.f12297a).mo19925e();
        }
    }

    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13553a(Bundle values, FacebookException error) {
        C0014p fragmentActivity = getActivity();
        fragmentActivity.setResult(error == null ? -1 : 0, C6678J.m13338a(fragmentActivity.getIntent(), values, error));
        fragmentActivity.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13552a(Bundle values) {
        C0014p fragmentActivity = getActivity();
        Intent resultIntent = new Intent();
        resultIntent.putExtras(values == null ? new Bundle() : values);
        fragmentActivity.setResult(-1, resultIntent);
        fragmentActivity.finish();
    }
}
