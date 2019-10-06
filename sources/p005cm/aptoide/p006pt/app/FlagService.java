package p005cm.aptoide.p006pt.app;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.GenericResponseV2;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.AddApkFlagRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody;
import p026rx.C0120S;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.app.FlagService */
public class FlagService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BodyInterceptor<BaseBody> bodyInterceptorV3;
    private final OkHttpClient okHttpClient;
    private final SharedPreferences sharedPreferences;
    private final TokenInvalidator tokenInvalidator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4776638917059821766L, "cm/aptoide/pt/app/FlagService", 4);
        $jacocoData = probes;
        return probes;
    }

    public FlagService(BodyInterceptor<BaseBody> bodyInterceptorV32, OkHttpClient okHttpClient2, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bodyInterceptorV3 = bodyInterceptorV32;
        this.okHttpClient = okHttpClient2;
        this.tokenInvalidator = tokenInvalidator2;
        this.sharedPreferences = sharedPreferences2;
        $jacocoInit[0] = true;
    }

    public Single<GenericResponseV2> doApkFlagRequest(String storeName, String md5, String flag) {
        boolean[] $jacocoInit = $jacocoInit();
        AddApkFlagRequest of = AddApkFlagRequest.m7442of(storeName, md5, flag, this.bodyInterceptorV3, this.okHttpClient, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[1] = true;
        C0120S observe = of.observe(true);
        $jacocoInit[2] = true;
        Single<GenericResponseV2> n = observe.mo3678n();
        $jacocoInit[3] = true;
        return n;
    }
}
