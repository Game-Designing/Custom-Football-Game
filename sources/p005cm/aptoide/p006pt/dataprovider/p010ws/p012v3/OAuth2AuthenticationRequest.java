package p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3;

import android.content.SharedPreferences;
import android.text.TextUtils;
import okhttp3.OkHttpClient;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.account.FacebookSignUpAdapter;
import p005cm.aptoide.p006pt.account.GoogleSignUpAdapter;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.OAuth;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v3.OAuth2AuthenticationRequest */
public class OAuth2AuthenticationRequest extends C2847V3<OAuth> {
    public OAuth2AuthenticationRequest(BaseBody baseBody, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(baseBody, httpClient, converterFactory, bodyInterceptor, tokenInvalidator, sharedPreferences);
    }

    /* renamed from: of */
    public static OAuth2AuthenticationRequest m7452of(String username, String password, String mode, String nameForGoogle, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, String extraId, String authMode) {
        String str = username;
        String str2 = password;
        String str3 = mode;
        String str4 = nameForGoogle;
        String str5 = authMode;
        BaseBody body = new BaseBody();
        String str6 = Repo.COLUMN_PASSWORD;
        body.put("grant_type", str6);
        body.put("client_id", BuildConfig.MARKET_NAME);
        body.put("mode", "json");
        if (str3 != null) {
            char c = 65535;
            switch (mode.hashCode()) {
                case -71469216:
                    if (str3.equals(AptoideAccountManager.APTOIDE_SIGN_UP_TYPE)) {
                        c = 0;
                        break;
                    }
                    break;
                case 2001934:
                    if (str3.equals("ABAN")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1279756998:
                    if (str3.equals(FacebookSignUpAdapter.TYPE)) {
                        c = 2;
                        break;
                    }
                    break;
                case 2108052025:
                    if (str3.equals(GoogleSignUpAdapter.TYPE)) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c != 0) {
                String str7 = "oauthUserName";
                String str8 = "oauthToken";
                String str9 = "authMode";
                if (c == 1) {
                    body.put(str9, str5);
                    body.put(str7, str4);
                    body.put(str8, str2);
                } else if (c == 2) {
                    body.put(str9, str5);
                    body.put(str8, str2);
                } else if (c == 3) {
                    body.put(str7, username);
                    body.put(str8, str2);
                    body.put(str9, str5);
                    body.put("oauthUser", str4);
                }
            } else {
                body.put("username", username);
                body.put(str6, str2);
            }
        }
        if (!TextUtils.isEmpty(extraId)) {
            body.put("oem_id", extraId);
        } else {
            String str10 = extraId;
        }
        OAuth2AuthenticationRequest oAuth2AuthenticationRequest = new OAuth2AuthenticationRequest(body, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return oAuth2AuthenticationRequest;
    }

    /* renamed from: of */
    public static OAuth2AuthenticationRequest m7451of(String refreshToken, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, String extraId) {
        BaseBody body = new BaseBody();
        String str = AuthenticationPersistence.ACCOUNT_REFRESH_TOKEN;
        body.put("grant_type", str);
        body.put("client_id", BuildConfig.MARKET_NAME);
        body.put("mode", "json");
        if (!TextUtils.isEmpty(extraId)) {
            body.put("oem_id", extraId);
        }
        body.put(str, refreshToken);
        OAuth2AuthenticationRequest oAuth2AuthenticationRequest = new OAuth2AuthenticationRequest(body, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return oAuth2AuthenticationRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<OAuth> loadDataFromNetwork(Service service, boolean bypassCache) {
        return service.oauth2Authentication(this.map, bypassCache);
    }
}
