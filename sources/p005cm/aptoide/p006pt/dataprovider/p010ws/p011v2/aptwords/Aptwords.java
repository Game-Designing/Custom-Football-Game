package p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords;

import android.content.SharedPreferences;
import com.mopub.common.Constants;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.BuildConfig;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords.RegisterAdRefererRequest.DefaultResponse;
import p005cm.aptoide.p006pt.dataprovider.util.HashMapNotNull;
import p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager;
import p026rx.C0120S;
import retrofit2.Converter.Factory;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v2.aptwords.Aptwords */
abstract class Aptwords<U> extends WebService<Interfaces, U> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v2.aptwords.Aptwords$Interfaces */
    interface Interfaces {
        @FormUrlEncoded
        @POST("getAds")
        C0120S<GetAdsResponse> getAds(@FieldMap HashMapNotNull<String, String> hashMapNotNull, @Header("X-Bypass-Cache") boolean z);

        @FormUrlEncoded
        @POST("registerAdReferer")
        C0120S<DefaultResponse> load(@FieldMap HashMapNotNull<String, String> hashMapNotNull);
    }

    Aptwords(OkHttpClient httpClient, Factory converterFactory, SharedPreferences sharedPreferences) {
        super(Interfaces.class, httpClient, converterFactory, getHost(sharedPreferences));
    }

    public static String getHost(SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? Constants.HTTP : "https");
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_APTWORDS_HOST);
        sb.append("/api/2/");
        return sb.toString();
    }
}
