package p005cm.aptoide.p006pt.search;

import com.mopub.common.Constants;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.search.SearchHostProvider */
public class SearchHostProvider {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String aptoideWebServicesScheme;
    private final String aptoideWebServicesSearchHost;
    private final String aptoideWebServicesSearchSslHost;
    private final boolean isToolboxEnableHttpScheme;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5403488787232627808L, "cm/aptoide/pt/search/SearchHostProvider", 7);
        $jacocoData = probes;
        return probes;
    }

    public SearchHostProvider(boolean isToolboxEnableHttpScheme2, String aptoideWebServicesScheme2, String aptoideWebServicesSearchHost2, String aptoideWebServicesSearchSslHost2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.isToolboxEnableHttpScheme = isToolboxEnableHttpScheme2;
        this.aptoideWebServicesScheme = aptoideWebServicesScheme2;
        this.aptoideWebServicesSearchHost = aptoideWebServicesSearchHost2;
        this.aptoideWebServicesSearchSslHost = aptoideWebServicesSearchSslHost2;
        $jacocoInit[0] = true;
    }

    public String getSearchHost() {
        String scheme;
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isToolboxEnableHttpScheme;
        String str2 = Constants.HTTP;
        if (z) {
            $jacocoInit[1] = true;
            scheme = str2;
        } else {
            scheme = this.aptoideWebServicesScheme;
            $jacocoInit[2] = true;
        }
        $jacocoInit[3] = true;
        String str3 = "/v1/";
        String str4 = "://";
        if (str2.equals(scheme)) {
            StringBuilder sb = new StringBuilder();
            sb.append(scheme);
            sb.append(str4);
            sb.append(this.aptoideWebServicesSearchHost);
            sb.append(str3);
            str = sb.toString();
            $jacocoInit[4] = true;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(scheme);
            sb2.append(str4);
            sb2.append(this.aptoideWebServicesSearchSslHost);
            sb2.append(str3);
            str = sb2.toString();
            $jacocoInit[5] = true;
        }
        $jacocoInit[6] = true;
        return str;
    }
}
