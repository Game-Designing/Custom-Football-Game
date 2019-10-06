package p005cm.aptoide.p006pt.dataprovider.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailability;
import java.io.IOException;
import java.util.Date;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.Response;
import p005cm.aptoide.p006pt.dataprovider.model.MinimalAdInterface;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse.C2842Ad;

/* renamed from: cm.aptoide.pt.dataprovider.ads.AdNetworkUtils */
public class AdNetworkUtils {
    public static void knock(String url) {
        if (url != null) {
            new OkHttpClient().newCall(new Builder().url(url).build()).enqueue(new Callback() {
                public void onFailure(Call call, IOException e) {
                }

                public void onResponse(Call call, Response response) throws IOException {
                    response.body().close();
                }
            });
        }
    }

    public static String parseMacros(String clickUrl, String androidId, String uniqueIdentifier, String advertisingId) {
        if (!TextUtils.isEmpty(androidId)) {
            clickUrl = clickUrl.replace("[USER_ANDROID_ID]", androidId);
        }
        return clickUrl.replace("[USER_UDID]", uniqueIdentifier).replace("[USER_AAID]", advertisingId).replace("[TIME_STAMP]", String.valueOf(new Date().getTime()));
    }

    public static boolean isGooglePlayServicesAvailable(Context context) {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0;
    }

    public static void knockCpc(MinimalAdInterface minimalAd) {
        knock(minimalAd.getCpcUrl());
    }

    public static void knockCpd(MinimalAdInterface minimalAd) {
        knock(minimalAd.getCpdUrl());
    }

    public static void knockCpi(MinimalAdInterface minimalAd) {
        knock(minimalAd.getCpiUrl());
    }

    public static void knockImpression(C2842Ad ad) {
        if (isImpressionUrlPresent(ad)) {
            knock(ad.getPartner().getData().getImpressionUrl());
        }
    }

    private static boolean isImpressionUrlPresent(C2842Ad ad) {
        return (ad == null || ad.getPartner() == null || ad.getPartner().getData() == null || ad.getPartner().getData().getImpressionUrl() == null) ? false : true;
    }
}
