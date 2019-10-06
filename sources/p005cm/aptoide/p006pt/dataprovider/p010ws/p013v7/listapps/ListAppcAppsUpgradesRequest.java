package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.listapps;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.ListAppsUpdates;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBodyWithAlphaBetaKey;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.listapps.ListAppsUpdatesRequest.ApksData;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.listapps.ListAppcAppsUpgradesRequest */
public class ListAppcAppsUpgradesRequest extends C0044V7<ListAppsUpdates, Body> {
    private static final int SPLIT_SIZE = 100;
    private final SharedPreferences sharedPreferences;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.listapps.ListAppcAppsUpgradesRequest$Body */
    public static class Body extends BaseBodyWithAlphaBetaKey {
        private String aaid;
        private List<ApksData> apksData;
        private String notPackageTags;

        public Body(List<ApksData> apksData2, String aaid2, SharedPreferences sharedPreferences) {
            super(sharedPreferences);
            this.apksData = apksData2;
            this.aaid = aaid2;
            setSystemAppsUpdates(sharedPreferences);
        }

        public Body(Body body, SharedPreferences sharedPreferences) {
            super(sharedPreferences);
            this.apksData = body.getApksData();
            setQ(body.getQ());
            setCountry(body.getCountry());
            setAptoideVercode(body.getAptoideVercode());
            this.aaid = body.getAaid();
            setAptoideId(body.getAptoideId());
            this.notPackageTags = body.getNotPackageTags();
            setAptoideMd5sum(body.getAptoideMd5sum());
            setAptoidePackage(body.getAptoidePackage());
            setLang(body.getLang());
            setCdn(body.getCdn());
            setMature(body.isMature());
        }

        public String getNotPackageTags() {
            return this.notPackageTags;
        }

        public List<ApksData> getApksData() {
            return this.apksData;
        }

        public void setApksData(List<ApksData> apksData2) {
            this.apksData = apksData2;
        }

        public String getAaid() {
            return this.aaid;
        }

        public void setAaid(String aaid2) {
            this.aaid = aaid2;
        }

        private void setSystemAppsUpdates(SharedPreferences sharedPreferences) {
            if (!ManagerPreferences.getUpdatesSystemAppsKey(sharedPreferences)) {
                this.notPackageTags = "system";
            }
        }
    }

    private ListAppcAppsUpgradesRequest(Body body, String baseHost, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences2) {
        super(body, baseHost, httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
        this.sharedPreferences = sharedPreferences2;
    }

    /* renamed from: of */
    public static ListAppcAppsUpgradesRequest m7560of(String clientUniqueId, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences2, PackageManager packageManager) {
        ListAppcAppsUpgradesRequest listAppcAppsUpgradesRequest = new ListAppcAppsUpgradesRequest(new Body(ListAppsUpdatesRequest.getInstalledApks(packageManager), clientUniqueId, sharedPreferences2), C0044V7.getHost(sharedPreferences2), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences2);
        return listAppcAppsUpgradesRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<ListAppsUpdates> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return C0120S.m652c(Integer.valueOf(((Body) this.body).getApksData().size())).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2892a<Object,Object>(this, interfaces, bypassCache));
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo13422a(Interfaces interfaces, boolean bypassCache, Integer bodySize) {
        if (bodySize.intValue() <= 100) {
            return interfaces.listAppcAppssUpgrades((Body) this.body, bypassCache);
        }
        List<ApksData> apksData = ((Body) this.body).getApksData();
        ArrayList<Body> bodies = new ArrayList<>();
        for (int n = 0; n < apksData.size(); n += 100) {
            bodies.add(getBody(apksData, n, this.sharedPreferences));
        }
        return C0120S.m629a((Iterable<? extends T>) bodies).mo3616a(Schedulers.m776io()).mo3669j(new C2893b(interfaces, bypassCache)).mo3675m().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) C2898g.f6171a).mo3675m().mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) C2896e.f6169a).mo3669j(C2895d.f6168a).mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) C2894c.f6167a).mo3675m().mo3669j(C2897f.f6170a);
    }

    /* renamed from: b */
    static /* synthetic */ Iterable m7557b(List responses) {
        return responses;
    }

    /* renamed from: c */
    static /* synthetic */ Iterable m7558c(List responseList) {
        return responseList;
    }

    /* renamed from: d */
    static /* synthetic */ ListAppsUpdates m7559d(List listAppUpdates) {
        ListAppsUpdates resultListAppsUpdates = new ListAppsUpdates();
        resultListAppsUpdates.setList(listAppUpdates);
        return resultListAppsUpdates;
    }

    private Body getBody(List<ApksData> apksData, int n, SharedPreferences sharedPreferences2) {
        Body resultBody = new Body((Body) this.body, sharedPreferences2);
        resultBody.setApksData(apksData.subList(n, n + 100 > apksData.size() ? (apksData.size() % 100) + n : n + 100));
        return resultBody;
    }
}
