package com.adyen.p081ui.activities;

import android.os.Bundle;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.C0424G;
import com.adyen.p081ui.p083b.C5611n;

/* renamed from: com.adyen.ui.activities.TranslucentLoadingScreenActivity */
public class TranslucentLoadingScreenActivity extends C0014p {
    private static final String TAG = TranslucentLoadingScreenActivity.class.getSimpleName();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        C5611n loadingScreenFragment = new C5611n();
        C0424G ft = getSupportFragmentManager().mo4909a();
        ft.mo5040b(16908290, loadingScreenFragment);
        ft.mo5032a();
    }
}
