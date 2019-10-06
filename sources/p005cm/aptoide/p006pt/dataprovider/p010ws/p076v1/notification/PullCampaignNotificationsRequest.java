package p005cm.aptoide.p006pt.dataprovider.p010ws.p076v1.notification;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.model.p075v1.GetPullNotificationsResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p076v1.PnpV1WebService;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p076v1.Service;
import p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v1.notification.PullCampaignNotificationsRequest */
public class PullCampaignNotificationsRequest extends PnpV1WebService<List<GetPullNotificationsResponse>> {

    /* renamed from: id */
    private final String f6092id;
    private final Map<String, String> options;

    protected PullCampaignNotificationsRequest(String id, Map<String, String> options2, OkHttpClient httpClient, Factory converterFactory, SharedPreferences sharedPreferences) {
        super(httpClient, converterFactory, sharedPreferences);
        this.options = options2;
        this.f6092id = id;
    }

    /* renamed from: of */
    public static PullCampaignNotificationsRequest m7434of(String aptoideClientUuid, String versionName, String appId, OkHttpClient httpClient, Factory converterFactory, String extraId, SharedPreferences sharedPreferences, Resources resources) {
        HashMap hashMap = new HashMap();
        hashMap.put("language", SystemU.getCountryCode(resources));
        String str = versionName;
        hashMap.put("aptoide_version", versionName);
        String oemid = extraId;
        if (!TextUtils.isEmpty(oemid)) {
            hashMap.put("oem_id", oemid);
        }
        String str2 = appId;
        hashMap.put("aptoide_package", appId);
        if (ToolboxManager.isDebug(sharedPreferences)) {
            hashMap.put("debug", "true");
        }
        PullCampaignNotificationsRequest pullCampaignNotificationsRequest = new PullCampaignNotificationsRequest(aptoideClientUuid, hashMap, httpClient, converterFactory, sharedPreferences);
        return pullCampaignNotificationsRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<List<GetPullNotificationsResponse>> loadDataFromNetwork(Service interfaces, boolean bypassCache) {
        return interfaces.getPullCampaignNotifications(this.f6092id, this.options, true);
    }
}
