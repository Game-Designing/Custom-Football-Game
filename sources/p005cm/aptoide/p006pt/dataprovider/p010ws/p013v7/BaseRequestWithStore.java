package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBodyWithStore;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.BaseRequestWithStore */
public abstract class BaseRequestWithStore<U, B extends BaseBodyWithStore> extends C0044V7<U, B> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.BaseRequestWithStore$StoreCredentials */
    public static class StoreCredentials {

        /* renamed from: id */
        private final Long f58id;
        private final String name;
        private final String passwordSha1;
        private final String username;

        public StoreCredentials() {
            this.name = null;
            this.f58id = null;
            this.username = null;
            this.passwordSha1 = null;
        }

        public StoreCredentials(long id, String username2, String passwordSha12) {
            this.name = null;
            this.f58id = Long.valueOf(id);
            this.username = username2;
            this.passwordSha1 = passwordSha12;
        }

        public StoreCredentials(String name2, String username2, String passwordSha12) {
            this.f58id = null;
            this.name = name2;
            this.username = username2;
            this.passwordSha1 = passwordSha12;
        }

        public StoreCredentials(long id, String name2, String username2, String passwordSha12) {
            this.f58id = Long.valueOf(id);
            this.name = name2;
            this.username = username2;
            this.passwordSha1 = passwordSha12;
        }

        public Long getId() {
            return this.f58id;
        }

        public String getName() {
            return this.name;
        }

        public String getUsername() {
            return this.username;
        }

        public String getPasswordSha1() {
            return this.passwordSha1;
        }
    }

    public BaseRequestWithStore(B body, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor<BaseBody> bodyInterceptor, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, C0044V7.getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }
}
