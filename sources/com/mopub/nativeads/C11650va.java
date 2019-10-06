package com.mopub.nativeads;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.MoPub;

/* renamed from: com.mopub.nativeads.va */
/* compiled from: NativeUrlGenerator */
class C11650va extends AdUrlGenerator {

    /* renamed from: j */
    private String f36248j;

    /* renamed from: k */
    private String f36249k;

    C11650va(Context context) {
        super(context);
    }

    public C11650va withAdUnitId(String adUnitId) {
        this.f34217d = adUnitId;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C11650va mo38191a(RequestParameters requestParameters) {
        if (requestParameters != null) {
            boolean canCollectPersonalInformation = MoPub.canCollectPersonalInformation();
            Location location = null;
            this.f34219f = canCollectPersonalInformation ? requestParameters.getUserDataKeywords() : null;
            if (canCollectPersonalInformation) {
                location = requestParameters.getLocation();
            }
            this.f34220g = location;
            this.f34218e = requestParameters.getKeywords();
            this.f36248j = requestParameters.getDesiredAssets();
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C11650va mo38190a(int sequenceNumber) {
        this.f36249k = String.valueOf(sequenceNumber);
        return this;
    }

    public String generateUrlString(String serverHostname) {
        mo36456b(serverHostname, Constants.AD_HANDLER);
        mo36404a(ClientMetadata.getInstance(this.f34216c));
        m38473j();
        m38474k();
        return mo36454b();
    }

    /* renamed from: k */
    private void m38474k() {
        if (!TextUtils.isEmpty(this.f36249k)) {
            mo36451a("MAGIC_NO", this.f36249k);
        }
    }

    /* renamed from: j */
    private void m38473j() {
        if (!TextUtils.isEmpty(this.f36248j)) {
            mo36451a("assets", this.f36248j);
        }
    }
}
