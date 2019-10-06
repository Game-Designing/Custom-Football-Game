package p005cm.aptoide.p006pt.dataprovider.p010ws.p076v1;

import java.util.List;
import java.util.Map;
import p005cm.aptoide.p006pt.dataprovider.model.p075v1.GetPullNotificationsResponse;
import p026rx.C0120S;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v1.Service */
public interface Service {
    @GET("notifications/{id}/campaigns")
    C0120S<List<GetPullNotificationsResponse>> getPullCampaignNotifications(@Path("id") String str, @QueryMap Map<String, String> map, @Header("X-Bypass-Cache") boolean z);
}
