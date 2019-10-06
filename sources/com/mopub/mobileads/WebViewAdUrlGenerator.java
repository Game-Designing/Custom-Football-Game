package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.ExternalViewabilitySessionManager.ViewabilityVendor;

public class WebViewAdUrlGenerator extends AdUrlGenerator {

    /* renamed from: j */
    private final boolean f35173j;

    public WebViewAdUrlGenerator(Context context, boolean isStorePictureSupported) {
        super(context);
        this.f35173j = isStorePictureSupported;
    }

    public String generateUrlString(String serverHostname) {
        mo36456b(serverHostname, Constants.AD_HANDLER);
        mo36449a("6");
        mo36404a(ClientMetadata.getInstance(this.f34216c));
        mo36405b(true);
        mo36452a(this.f35173j);
        mo36407c(ViewabilityVendor.getEnabledVendorKey());
        return mo36454b();
    }
}
