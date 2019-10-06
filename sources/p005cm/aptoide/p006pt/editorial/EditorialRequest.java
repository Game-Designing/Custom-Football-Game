package p005cm.aptoide.p006pt.editorial;

import android.content.SharedPreferences;
import com.mopub.common.Constants;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.BuildConfig;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.EditorialCard;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.editorial.EditorialRequest */
public class EditorialRequest extends C0044V7<EditorialCard, BaseBody> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String cardId;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(9009653696856411093L, "cm/aptoide/pt/editorial/EditorialRequest", 8);
        $jacocoData = probes;
        return probes;
    }

    /* access modifiers changed from: protected */
    public /* bridge */ /* synthetic */ C0120S loadDataFromNetwork(Object obj, boolean z) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S loadDataFromNetwork = loadDataFromNetwork((Interfaces) obj, z);
        $jacocoInit[7] = true;
        return loadDataFromNetwork;
    }

    public EditorialRequest(BaseBody body, String cardId2, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        super(body, getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
        this.cardId = cardId2;
        $jacocoInit[0] = true;
    }

    public static String getHost(SharedPreferences sharedPreferences) {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        if (ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences)) {
            $jacocoInit[1] = true;
            str = Constants.HTTP;
        } else {
            $jacocoInit[2] = true;
            str = "https";
        }
        sb.append(str);
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_V7_HOST);
        sb.append("/api/7.20181019/");
        String sb2 = sb.toString();
        $jacocoInit[3] = true;
        return sb2;
    }

    /* renamed from: of */
    public static EditorialRequest m7831of(String cardId2, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        BaseBody body = new BaseBody();
        $jacocoInit[4] = true;
        EditorialRequest editorialRequest = new EditorialRequest(body, cardId2, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        $jacocoInit[5] = true;
        return editorialRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<EditorialCard> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<EditorialCard> editorial = interfaces.getEditorial(this.cardId, (BaseBody) this.body);
        $jacocoInit[6] = true;
        return editorial;
    }
}
