package com.facebook.p131b.p132a;

import android.net.nsd.NsdManager.RegistrationListener;
import android.net.nsd.NsdServiceInfo;

/* renamed from: com.facebook.b.a.a */
/* compiled from: DeviceRequestsHelper */
class C6651a implements RegistrationListener {

    /* renamed from: a */
    final /* synthetic */ String f12119a;

    /* renamed from: b */
    final /* synthetic */ String f12120b;

    C6651a(String str, String str2) {
        this.f12119a = str;
        this.f12120b = str2;
    }

    public void onServiceRegistered(NsdServiceInfo NsdServiceInfo) {
        if (!this.f12119a.equals(NsdServiceInfo.getServiceName())) {
            C6652b.m13274a(this.f12120b);
        }
    }

    public void onServiceUnregistered(NsdServiceInfo serviceInfo) {
    }

    public void onRegistrationFailed(NsdServiceInfo serviceInfo, int errorCode) {
        C6652b.m13274a(this.f12120b);
    }

    public void onUnregistrationFailed(NsdServiceInfo serviceInfo, int errorCode) {
    }
}
