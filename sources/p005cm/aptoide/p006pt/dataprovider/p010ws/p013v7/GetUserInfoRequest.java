package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetUserInfo;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.GetUserInfoRequest */
public class GetUserInfoRequest extends C0044V7<GetUserInfo, Body> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.GetUserInfoRequest$Body */
    public static class Body extends BaseBody {
        private List<String> nodes;

        public Body(List<String> nodes2) {
            this.nodes = nodes2;
        }

        public List<String> getNodes() {
            return this.nodes;
        }

        public void setNodes(List<String> nodes2) {
            this.nodes = nodes2;
        }
    }

    protected GetUserInfoRequest(Body body, String baseHost, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator) {
        super(body, baseHost, httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    public static String getHost() {
        return "https://ws75.aptoide.com/api/7/";
    }

    /* renamed from: of */
    public static GetUserInfoRequest m7467of(OkHttpClient httpClient, Factory converterFactory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator) {
        List<String> nodes = new ArrayList<>();
        nodes.add("meta");
        nodes.add("settings");
        GetUserInfoRequest getUserInfoRequest = new GetUserInfoRequest(new Body(nodes), getHost(), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
        return getUserInfoRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<GetUserInfo> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        ((Body) this.body).setRefresh(bypassCache);
        return interfaces.getUserInfo((Body) this.body, bypassCache);
    }
}
