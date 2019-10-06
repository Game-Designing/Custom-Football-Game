package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.analyticsbody.DownloadInstallAnalyticsBaseBody;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.DownloadAnalyticsRequest */
public class DownloadAnalyticsRequest extends C0044V7<BaseV7Response, DownloadInstallAnalyticsBaseBody> {
    private String action;
    private String context;
    private String name;

    protected DownloadAnalyticsRequest(DownloadInstallAnalyticsBaseBody body, String action2, String name2, String context2, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, C0044V7.getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
        this.action = action2;
        this.name = name2;
        this.context = context2;
    }

    /* renamed from: of */
    public static DownloadAnalyticsRequest m7458of(DownloadInstallAnalyticsBaseBody body, String action2, String name2, String context2, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        DownloadAnalyticsRequest downloadAnalyticsRequest = new DownloadAnalyticsRequest(body, action2, name2, context2, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return downloadAnalyticsRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<BaseV7Response> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.addEvent(this.name, this.action, this.context, (DownloadInstallAnalyticsBaseBody) this.body);
    }
}
