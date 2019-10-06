package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions;

import android.content.SharedPreferences;
import com.mopub.common.Constants;
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

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.promotions.ClaimPromotionRequest */
public class ClaimPromotionRequest extends C0044V7<BaseV7Response, Body> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.promotions.ClaimPromotionRequest$Body */
    public static class Body extends BaseBody {
        private final String captcha;
        private final String packageName;
        private final String promotionId;
        private final String walletAddress;

        public Body(String walletAddress2, String packageName2, String captcha2, String promotionId2) {
            this.walletAddress = walletAddress2;
            this.packageName = packageName2;
            this.captcha = captcha2;
            this.promotionId = promotionId2;
        }

        public String getWalletAddress() {
            return this.walletAddress;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public String getCaptcha() {
            return this.captcha;
        }

        public String getPromotionId() {
            return this.promotionId;
        }
    }

    public ClaimPromotionRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    public static String getHost(SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? Constants.HTTP : "https");
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_WRITE_V7_HOST);
        sb.append("/api/7/");
        return sb.toString();
    }

    /* renamed from: of */
    public static ClaimPromotionRequest m7573of(String walletAddress, String packageName, String captcha, String promotionId, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        String str = walletAddress;
        String str2 = packageName;
        String str3 = captcha;
        String str4 = promotionId;
        ClaimPromotionRequest claimPromotionRequest = new ClaimPromotionRequest(new Body(walletAddress, packageName, captcha, promotionId), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return claimPromotionRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<BaseV7Response> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.claimPromotion((Body) this.body, true);
    }
}
