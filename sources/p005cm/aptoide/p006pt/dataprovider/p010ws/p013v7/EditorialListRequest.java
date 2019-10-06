package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import com.mopub.common.Constants;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.BuildConfig;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.EditorialListRequest */
public class EditorialListRequest extends C0044V7<EditorialListResponse, Body> {
    private final int limit;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.EditorialListRequest$Body */
    public static class Body extends BaseBody implements Endless {
        private int limit;
        private int offset;

        public Body(int limit2, int offset2) {
            this.limit = limit2;
            this.offset = offset2;
        }

        public int getOffset() {
            return this.offset;
        }

        public void setOffset(int offset2) {
            this.offset = offset2;
        }

        public Integer getLimit() {
            return Integer.valueOf(this.limit);
        }
    }

    protected EditorialListRequest(Body body, String baseHost, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator, int limit2) {
        super(body, baseHost, httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
        this.limit = limit2;
    }

    public static String getHost(SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? Constants.HTTP : "https");
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_V7_HOST);
        sb.append("/api/7.20181019/");
        return sb.toString();
    }

    /* renamed from: of */
    public static EditorialListRequest m7459of(BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, int limit2, int offset) {
        EditorialListRequest editorialListRequest = new EditorialListRequest(new Body(limit2, offset), getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator, limit2);
        return editorialListRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<EditorialListResponse> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getEditorialList(this.limit, (Body) this.body);
    }
}
