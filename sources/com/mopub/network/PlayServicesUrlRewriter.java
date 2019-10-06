package com.mopub.network;

import android.net.Uri;
import com.mopub.common.ClientMetadata;
import com.mopub.common.MoPub;
import com.mopub.common.privacy.AdvertisingId;
import com.mopub.volley.toolbox.HurlStack.UrlRewriter;
import p005cm.aptoide.p006pt.BuildConfig;

public class PlayServicesUrlRewriter implements UrlRewriter {
    public static final String DO_NOT_TRACK_TEMPLATE = "mp_tmpl_do_not_track";
    public static final String UDID_TEMPLATE = "mp_tmpl_advertising_id";

    public String rewriteUrl(String url) {
        String str = UDID_TEMPLATE;
        boolean contains = url.contains(str);
        String str2 = DO_NOT_TRACK_TEMPLATE;
        if (!contains && !url.contains(str2)) {
            return url;
        }
        ClientMetadata clientMetadata = ClientMetadata.getInstance();
        if (clientMetadata == null) {
            return url;
        }
        AdvertisingId info = clientMetadata.getMoPubIdentifier().getAdvertisingInfo();
        return url.replace(str, Uri.encode(info.getIdWithPrefix(MoPub.canCollectPersonalInformation()))).replace(str2, info.isDoNotTrack() ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
    }
}
