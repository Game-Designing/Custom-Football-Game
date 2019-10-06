package p005cm.aptoide.p006pt.autoupdate;

import p026rx.C0120S;
import retrofit2.http.GET;
import retrofit2.http.Path;

/* renamed from: cm.aptoide.pt.autoupdate.Service */
/* compiled from: AutoUpdateService.kt */
public interface Service {
    @GET("latest_version_{storeName}.json")
    C0120S<AutoUpdateJsonResponse> getJsonResponse(@Path("storeName") String str);
}
