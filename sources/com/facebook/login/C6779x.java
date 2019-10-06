package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.C6656b;
import com.facebook.common.C6657c;
import com.facebook.login.LoginClient.C6754b;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;

/* renamed from: com.facebook.login.x */
/* compiled from: LoginFragment */
public class C6779x extends Fragment {

    /* renamed from: a */
    private String f12456a;

    /* renamed from: b */
    private LoginClient f12457b;

    /* renamed from: c */
    private Request f12458c;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            this.f12457b = (LoginClient) savedInstanceState.getParcelable("loginClient");
            this.f12457b.mo20039a((Fragment) this);
        } else {
            this.f12457b = mo20124b();
        }
        this.f12457b.mo20043a((C6754b) new C6777v(this));
        Activity activity = getActivity();
        if (activity != null) {
            m13787a(activity);
            Intent intent = activity.getIntent();
            if (intent != null) {
                Bundle bundle = intent.getBundleExtra("com.facebook.LoginFragment:Request");
                if (bundle != null) {
                    this.f12458c = (Request) bundle.getParcelable("request");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public LoginClient mo20124b() {
        return new LoginClient((Fragment) this);
    }

    public void onDestroy() {
        this.f12457b.mo20038a();
        super.onDestroy();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(mo20125c(), container, false);
        this.f12457b.mo20042a((C6753a) new C6778w(this, view.findViewById(C6656b.com_facebook_login_fragment_progress_bar)));
        return view;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo20125c() {
        return C6657c.com_facebook_login_fragment;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13788a(Result outcome) {
        this.f12458c = null;
        int resultCode = outcome.f12393a == C6752a.CANCEL ? 0 : -1;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.facebook.LoginFragment:Result", outcome);
        Intent resultIntent = new Intent();
        resultIntent.putExtras(bundle);
        if (isAdded()) {
            getActivity().setResult(resultCode, resultIntent);
            getActivity().finish();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f12456a == null) {
            Log.e("LoginFragment", "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.");
            getActivity().finish();
            return;
        }
        this.f12457b.mo20049c(this.f12458c);
    }

    public void onPause() {
        View progressBar;
        super.onPause();
        if (getView() == null) {
            progressBar = null;
        } else {
            progressBar = getView().findViewById(C6656b.com_facebook_login_fragment_progress_bar);
        }
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.f12457b.mo20044a(requestCode, resultCode, data);
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("loginClient", this.f12457b);
    }

    /* renamed from: a */
    private void m13787a(Activity activity) {
        ComponentName componentName = activity.getCallingActivity();
        if (componentName != null) {
            this.f12456a = componentName.getPackageName();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public LoginClient mo20126d() {
        return this.f12457b;
    }
}
