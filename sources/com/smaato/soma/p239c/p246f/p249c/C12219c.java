package com.smaato.soma.p239c.p246f.p249c;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.smaato.soma.c.f.c.c */
/* compiled from: DeviceDataCollector */
class C12219c extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12221a f38288a;

    C12219c(C12221a this$1) {
        this.f38288a = this$1;
    }

    public Void process() throws Exception {
        String str = "Please add dependency:  compile 'com.google.android.gms:play-services-ads:7.8.+' to your build.gradle!";
        String str2 = "Data_Collector";
        try {
            if (C12220d.this.f38291c == null) {
                return null;
            }
            Info adInfo = AdvertisingIdClient.getAdvertisingIdInfo(C12220d.this.f38291c);
            C12220d.this.mo39552a(adInfo.getId());
            C12220d.this.mo39554b(adInfo.isLimitAdTrackingEnabled() ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
            return null;
        } catch (NoClassDefFoundError e) {
            C12146d.m39965a(new C12147e(str2, str, 0, C12143a.ERROR));
        } catch (RuntimeException e2) {
            C12146d.m39965a(new C12147e(str2, str, 0, C12143a.ERROR));
        } catch (Exception e3) {
            C12146d.m39965a(new C12147e(str2, "Device is not having the latest gms installed for GoogleAdvertisingIdProvider.Please add dependency:  compile 'com.google.android.gms:play-services-ads:7.8.+' to your build.gradle!", 0, C12143a.ERROR));
        }
    }
}
