package p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.dataprovider.interfaces.ErrorRequestListener;
import p005cm.aptoide.p006pt.dataprovider.interfaces.SuccessRequestListener;
import p005cm.aptoide.p006pt.dataprovider.util.HashMapNotNull;
import p005cm.aptoide.p006pt.install.installer.RootCommandOnSubscribe;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v2.aptwords.RegisterAdRefererRequest */
public class RegisterAdRefererRequest extends Aptwords<DefaultResponse> {
    private long adId;
    private long appId;

    /* renamed from: q */
    private final String f6094q;
    private String success;
    private String tracker;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v2.aptwords.RegisterAdRefererRequest$DefaultResponse */
    public static class DefaultResponse {
        private String status;

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status2) {
            this.status = status2;
        }
    }

    private RegisterAdRefererRequest(long adId2, long appId2, String clickUrl, boolean success2, OkHttpClient httpClient, Factory converterFactory, String q, SharedPreferences sharedPreferences) {
        super(httpClient, converterFactory, sharedPreferences);
        this.f6094q = q;
        this.adId = adId2;
        this.appId = appId2;
        this.success = success2 ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID;
        extractAndSetTracker(clickUrl);
    }

    /* renamed from: of */
    public static RegisterAdRefererRequest m7441of(long adId2, long appId2, String clickUrl, boolean success2, OkHttpClient httpClient, Factory converterFactory, String q, SharedPreferences sharedPreferences) {
        RegisterAdRefererRequest registerAdRefererRequest = new RegisterAdRefererRequest(adId2, appId2, clickUrl, success2, httpClient, converterFactory, q, sharedPreferences);
        return registerAdRefererRequest;
    }

    private void extractAndSetTracker(String clickUrl) {
        this.tracker = clickUrl.substring(0, clickUrl.indexOf("/", clickUrl.indexOf("//") + 2));
    }

    public void execute() {
        super.execute((SuccessRequestListener<U>) C2845c.f6099a, (ErrorRequestListener) C2846d.f6100a);
    }

    /* renamed from: a */
    static /* synthetic */ void m7439a(DefaultResponse defaultResponse) {
    }

    /* renamed from: b */
    static /* synthetic */ void m7440b(Throwable e) {
    }

    /* access modifiers changed from: protected */
    public C0120S<DefaultResponse> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        HashMapNotNull<String, String> map = new HashMapNotNull<>();
        map.put(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION, this.success);
        map.put("adid", Long.toString(this.adId));
        map.put("appid", Long.toString(this.appId));
        map.put("q", this.f6094q);
        map.put("androidversion", VERSION.RELEASE);
        map.put("tracker", this.tracker);
        return interfaces.load(map);
    }
}
