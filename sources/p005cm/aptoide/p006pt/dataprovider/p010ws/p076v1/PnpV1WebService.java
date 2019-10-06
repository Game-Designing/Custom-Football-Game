package p005cm.aptoide.p006pt.dataprovider.p010ws.p076v1;

import android.content.SharedPreferences;
import com.mopub.common.Constants;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.BuildConfig;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v1.PnpV1WebService */
public abstract class PnpV1WebService<U> extends WebService<Service, U> {
    protected PnpV1WebService(OkHttpClient httpClient, Factory converterFactory, SharedPreferences sharedPreferences) {
        super(Service.class, httpClient, converterFactory, getHost(sharedPreferences));
    }

    public static String getHost(SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? Constants.HTTP : "https");
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_NOTIFICATION_HOST);
        sb.append("/pnp/v1/");
        return sb.toString();
    }
}
