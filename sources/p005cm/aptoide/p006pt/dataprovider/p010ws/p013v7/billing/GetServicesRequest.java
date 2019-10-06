package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing;

import android.content.SharedPreferences;
import com.mopub.common.Constants;
import java.util.List;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.BuildConfig;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetServicesRequest */
public class GetServicesRequest extends C0044V7<ResponseBody, BaseBody> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetServicesRequest$ResponseBody */
    public static class ResponseBody extends BaseV7Response {
        private List<Service> list;

        /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetServicesRequest$ResponseBody$Service */
        public static class Service {
            private String description;
            private String icon;

            /* renamed from: id */
            private long f6136id;
            private String label;
            private String name;

            public long getId() {
                return this.f6136id;
            }

            public void setId(long id) {
                this.f6136id = id;
            }

            public String getName() {
                return this.name;
            }

            public void setName(String name2) {
                this.name = name2;
            }

            public String getLabel() {
                return this.label;
            }

            public void setLabel(String label2) {
                this.label = label2;
            }

            public String getIcon() {
                return this.icon;
            }

            public void setIcon(String icon2) {
                this.icon = icon2;
            }

            public String getDescription() {
                return this.description;
            }

            public void setDescription(String description2) {
                this.description = description2;
            }
        }

        public List<Service> getList() {
            return this.list;
        }

        public void setList(List<Service> list2) {
            this.list = list2;
        }
    }

    private GetServicesRequest(BaseBody body, String baseHost, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator) {
        super(body, baseHost, httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    public static String getHost(SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? Constants.HTTP : "https");
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_READ_V7_HOST);
        sb.append("/api/7/");
        return sb.toString();
    }

    /* renamed from: of */
    public static GetServicesRequest m7544of(SharedPreferences sharedPreferences, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator) {
        GetServicesRequest getServicesRequest = new GetServicesRequest(new BaseBody(), getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
        return getServicesRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<ResponseBody> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getBillingServices((BaseBody) this.body, bypassCache);
    }
}
