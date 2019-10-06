package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;

/* renamed from: com.mopub.nativeads.Fa */
/* compiled from: PositioningUrlGenerator */
class C11525Fa extends BaseUrlGenerator {

    /* renamed from: c */
    private final Context f35641c;

    /* renamed from: d */
    private String f35642d;

    public C11525Fa(Context context) {
        this.f35641c = context;
    }

    public C11525Fa withAdUnitId(String adUnitId) {
        this.f35642d = adUnitId;
        return this;
    }

    public String generateUrlString(String serverHostname) {
        mo36456b(serverHostname, Constants.POSITIONING_HANDLER);
        m38131c(this.f35642d);
        mo36449a("1");
        ClientMetadata clientMetadata = ClientMetadata.getInstance(this.f35641c);
        m38132d(clientMetadata.getSdkVersion());
        mo36453a(clientMetadata.getDeviceManufacturer(), clientMetadata.getDeviceModel(), clientMetadata.getDeviceProduct());
        mo36455b(clientMetadata.getAppVersion());
        mo36447a();
        return mo36454b();
    }

    /* renamed from: c */
    private void m38131c(String adUnitId) {
        mo36451a("id", adUnitId);
    }

    /* renamed from: d */
    private void m38132d(String sdkVersion) {
        mo36451a("nv", sdkVersion);
    }
}
