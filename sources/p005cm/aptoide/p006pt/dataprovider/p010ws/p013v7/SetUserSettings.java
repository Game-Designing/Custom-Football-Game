package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.SetUserSettings */
public class SetUserSettings extends C0044V7<BaseV7Response, Body> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.SetUserSettings$Body */
    public static class Body extends BaseBody {
        public boolean mature;

        public Body(boolean mature2) {
            this.mature = mature2;
        }

        public boolean isMature() {
            return this.mature;
        }

        public void setMature(boolean mature2) {
            this.mature = mature2;
        }
    }

    protected SetUserSettings(Body body, String baseHost, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator) {
        super(body, baseHost, httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    public static String getHost() {
        return "https://ws75-primary.aptoide.com/api/7/";
    }

    /* renamed from: of */
    public static SetUserSettings m7488of(boolean adultContentEnabled, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator) {
        Body body = new Body(adultContentEnabled);
        body.setMature(adultContentEnabled);
        SetUserSettings setUserSettings = new SetUserSettings(body, getHost(), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
        return setUserSettings;
    }

    /* access modifiers changed from: protected */
    public C0120S<BaseV7Response> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.setUserSettings((Body) this.body);
    }
}
