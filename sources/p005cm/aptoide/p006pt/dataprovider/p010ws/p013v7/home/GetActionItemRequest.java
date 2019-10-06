package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home;

import android.content.SharedPreferences;
import com.mopub.common.Constants;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.BuildConfig;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.home.GetActionItemRequest */
public class GetActionItemRequest extends C0044V7<ActionItemResponse, Body> {
    private final String url;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.home.GetActionItemRequest$Body */
    public static class Body extends BaseBody {
    }

    public GetActionItemRequest(String url2, Body body, SharedPreferences sharedPreferences, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator) {
        super(body, getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
        this.url = url2;
    }

    public static String getHost(SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? Constants.HTTP : "https");
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_V7_HOST);
        sb.append("/api/7.20181019/");
        return sb.toString();
    }

    public static GetActionItemRequest ofAction(String url2, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        GetActionItemRequest getActionItemRequest = new GetActionItemRequest(url2, new Body(), sharedPreferences, bodyInterceptor, httpClient, converterFactory, tokenInvalidator);
        return getActionItemRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<ActionItemResponse> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getActionItem(this.url, (Body) this.body, bypassCache);
    }
}
