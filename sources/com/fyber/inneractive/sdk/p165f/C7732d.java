package com.fyber.inneractive.sdk.p165f;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.fyber.inneractive.sdk.config.C7711i;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.p159a.C7639a;
import com.fyber.inneractive.sdk.p160b.C7658d;
import com.fyber.inneractive.sdk.p160b.C7658d.C7659a;
import com.fyber.inneractive.sdk.p165f.C7734e.C7736b;
import com.fyber.inneractive.sdk.p174i.C7907g;
import com.fyber.inneractive.sdk.p178k.C7920b;
import com.fyber.inneractive.sdk.util.C8006j;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Iterator;

/* renamed from: com.fyber.inneractive.sdk.f.d */
public final class C7732d implements C7736b {

    /* renamed from: a */
    InneractiveAdRequest f15442a;

    /* renamed from: b */
    C7733a f15443b;

    /* renamed from: c */
    public String f15444c;

    /* renamed from: d */
    protected boolean f15445d = false;

    /* renamed from: e */
    private C7734e f15446e;

    /* renamed from: com.fyber.inneractive.sdk.f.d$a */
    public interface C7733a {
        /* renamed from: a */
        void mo24100a(InneractiveErrorCode inneractiveErrorCode);

        /* renamed from: a */
        void mo24101a(C7907g gVar);
    }

    public C7732d(InneractiveAdRequest inneractiveAdRequest, C7733a aVar) {
        this.f15442a = inneractiveAdRequest;
        this.f15443b = aVar;
    }

    /* renamed from: a */
    public final boolean mo24304a() {
        boolean z;
        boolean z2;
        String str;
        C7920b bVar;
        String str2 = "AD_REQUEST ";
        this.f15445d = false;
        IAlog.m18021b("IARemoteAdFetcher: requestAd called");
        String str3 = "android.permission.ACCESS_NETWORK_STATE";
        if (TextUtils.isEmpty(this.f15442a.getSpotId())) {
            IAlog.m18024e("appID is null or empty. Please provide a valid appID and re-try.");
            z = false;
        } else if (!C8006j.m18073b("android.permission.INTERNET")) {
            IAlog.m18024e("INTERNET permission is missing. Please add it to the Manifest and re-try, otherwise ads will not be requested and displayed! ");
            z = false;
        } else {
            if (!C8006j.m18073b(str3)) {
                IAlog.m18024e("It is recommended to add ACCESS_NETWORK_STATE permission to the Manifest for better targetting");
            }
            if (!C8006j.m18073b("android.permission.READ_PHONE_STATE")) {
                IAlog.m18023d("It is recomended to add the READ_PHONE_STATE permission to the manifest for better targetting");
            }
            z = true;
        }
        if (!z) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) C8006j.m18075n().getSystemService("connectivity");
        if (C8006j.m18073b(str3)) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } else {
            IAlog.m18024e("Error retrieved when trying to get the network state - Perhaps you forgot to declare android.permission.ACCESS_NETWORK_STATE in your Android manifest file.");
            z2 = false;
        }
        if (!z2) {
            IAlog.m18023d("Network is not connected");
            m17148b(InneractiveErrorCode.CONNECTION_ERROR);
            return false;
        }
        C7658d dVar = C7660b.f15189a;
        InneractiveAdRequest inneractiveAdRequest = this.f15442a;
        Iterator it = dVar.f15188a.iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                StringBuilder sb = new StringBuilder("IAadRequestUrlCreatorFactory: Could not find creator factory for adRequest: ");
                sb.append(inneractiveAdRequest);
                sb.append(" Are you trying to send a native ad request, but you didn't add the native kit to your project?");
                IAlog.m18024e(sb.toString());
                bVar = null;
                break;
            }
            C7659a aVar = (C7659a) it.next();
            if (aVar.mo24091a(inneractiveAdRequest)) {
                bVar = aVar.mo24092b(inneractiveAdRequest);
                break;
            }
        }
        if (bVar != null) {
            str = bVar.mo24729a();
        }
        this.f15444c = str;
        if (TextUtils.isEmpty(this.f15444c)) {
            m17148b(InneractiveErrorCode.SDK_INTERNAL_ERROR);
            return false;
        }
        String str4 = this.f15444c;
        C7734e eVar = this.f15446e;
        if (eVar != null) {
            eVar.cancel(true);
        }
        this.f15446e = new C7734e(this);
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(IAlog.m18018a((Object) this));
            sb2.append("Executing network fetcher task");
            IAlog.m18021b(sb2.toString());
            if (C7640a.f15157a.f15150a) {
                StringBuilder sb3 = new StringBuilder(str2);
                sb3.append(str4);
                Log.v("IA_CI_LOG", sb3.toString());
                C7639a a = C7640a.f15157a;
                StringBuilder sb4 = new StringBuilder(str2);
                sb4.append(str4);
                a.mo24033b(sb4.toString());
            }
            C8006j.m18070a((AsyncTask<P, ?, ?>) this.f15446e, (P[]) new String[]{str4});
        } catch (Exception e) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(IAlog.m18018a((Object) this));
            sb5.append("Failed running network fetcher task!");
            IAlog.m18021b(sb5.toString());
            e.printStackTrace();
        }
        return true;
    }

    /* renamed from: b */
    public final void mo24305b() {
        C7734e eVar = this.f15446e;
        if (eVar != null) {
            this.f15445d = true;
            eVar.cancel(true);
            this.f15446e = null;
            this.f15443b = null;
        }
    }

    /* renamed from: b */
    private void m17148b(InneractiveErrorCode inneractiveErrorCode) {
        this.f15443b.mo24100a(inneractiveErrorCode);
    }

    /* renamed from: a */
    public final void mo24302a(InneractiveErrorCode inneractiveErrorCode) {
        if (this.f15443b != null) {
            if (this.f15445d) {
                IAlog.m18019a("IARemoteAdFetcher: ignoring response. Previous request was cancelled");
            } else {
                m17148b(inneractiveErrorCode);
            }
        }
    }

    /* renamed from: a */
    public final void mo24303a(C7907g gVar) {
        InneractiveErrorCode inneractiveErrorCode;
        if (this.f15443b != null) {
            if (this.f15445d) {
                IAlog.m18019a("IARemoteAdFetcher: ignoring response. Previous request was cancelled");
                return;
            }
            C7711i a = IAConfigManager.m16965a(gVar.f16044m);
            this.f15442a.setSelectedUnitConfig(a);
            if (a == null) {
                inneractiveErrorCode = InneractiveErrorCode.ERROR_CONFIGURATION_MISMATCH;
            } else {
                inneractiveErrorCode = gVar.mo24718a(this.f15442a);
            }
            if (inneractiveErrorCode == null) {
                this.f15443b.mo24101a(gVar);
                return;
            }
            if (a == null || inneractiveErrorCode == InneractiveErrorCode.ERROR_CONFIGURATION_MISMATCH) {
                StringBuilder sb = new StringBuilder();
                sb.append(IAlog.m18018a((Object) this));
                sb.append("Got configuration mismatch!");
                IAlog.m18024e(sb.toString());
                IAConfigManager.m16993f();
            }
            this.f15443b.mo24100a(inneractiveErrorCode);
            m17148b(inneractiveErrorCode);
        }
    }
}
