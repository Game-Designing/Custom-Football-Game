package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.BiUtmAnalyticsRequest */
public class BiUtmAnalyticsRequest extends C0044V7<BaseV7Response, BiUtmAnalyticsRequestBody> {
    private final String action;
    private final String context;
    private final String name;

    private BiUtmAnalyticsRequest(String action2, String name2, String context2, BiUtmAnalyticsRequestBody body, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor bodyInterceptor, SharedPreferences sharedPreferences, TokenInvalidator tokenInvalidator) {
        super(body, C0044V7.getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
        this.action = action2;
        this.name = name2;
        this.context = context2;
    }

    /* renamed from: of */
    public static BiUtmAnalyticsRequest m7457of(String action2, String eventName, String context2, BiUtmAnalyticsRequestBody body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, SharedPreferences sharedPreferences, TokenInvalidator tokenInvalidator) {
        BiUtmAnalyticsRequest biUtmAnalyticsRequest = new BiUtmAnalyticsRequest(action2, eventName, context2, body, httpClient, converterFactory, bodyInterceptor, sharedPreferences, tokenInvalidator);
        return biUtmAnalyticsRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<BaseV7Response> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.addEvent(this.name, this.action, this.context, (BiUtmAnalyticsRequestBody) this.body);
    }
}
