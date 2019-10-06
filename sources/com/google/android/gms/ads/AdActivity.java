package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaqg;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzyt;

@KeepForSdkWithMembers
public class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";

    /* renamed from: a */
    private zzaqg f19008a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19008a = zzyt.m31533b().mo32389a((Activity) this);
        zzaqg zzaqg = this.f19008a;
        String str = "#007 Could not call remote method.";
        if (zzaqg == null) {
            zzbad.m26360d(str, null);
            finish();
            return;
        }
        try {
            zzaqg.onCreate(bundle);
        } catch (RemoteException e) {
            zzbad.m26360d(str, e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        try {
            if (this.f19008a != null) {
                this.f19008a.onRestart();
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        try {
            if (this.f19008a != null) {
                this.f19008a.onStart();
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        try {
            if (this.f19008a != null) {
                this.f19008a.onResume();
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        try {
            if (this.f19008a != null) {
                this.f19008a.onPause();
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.f19008a != null) {
                this.f19008a.onSaveInstanceState(bundle);
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        try {
            if (this.f19008a != null) {
                this.f19008a.onStop();
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            if (this.f19008a != null) {
                this.f19008a.onDestroy();
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    /* renamed from: a */
    private final void m20792a() {
        zzaqg zzaqg = this.f19008a;
        if (zzaqg != null) {
            try {
                zzaqg.zzdd();
            } catch (RemoteException e) {
                zzbad.m26360d("#007 Could not call remote method.", e);
            }
        }
    }

    public void setContentView(int i) {
        super.setContentView(i);
        m20792a();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        m20792a();
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        m20792a();
    }

    public void onBackPressed() {
        boolean z = true;
        try {
            if (this.f19008a != null) {
                z = this.f19008a.zztg();
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.f19008a.onActivityResult(i, i2, intent);
        } catch (Exception e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.f19008a.zzac(ObjectWrapper.m22188a(configuration));
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }
}
