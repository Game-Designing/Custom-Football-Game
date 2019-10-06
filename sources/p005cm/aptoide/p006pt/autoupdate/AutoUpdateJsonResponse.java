package p005cm.aptoide.p006pt.autoupdate;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.autoupdate.AutoUpdateJsonResponse */
public class AutoUpdateJsonResponse {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String md5;
    @JsonProperty("minSdk")
    private String minSdk;
    private String uri;
    private int versioncode;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8327764830662620631L, "cm/aptoide/pt/autoupdate/AutoUpdateJsonResponse", 9);
        $jacocoData = probes;
        return probes;
    }

    public AutoUpdateJsonResponse() {
        $jacocoInit()[0] = true;
    }

    public int getVersioncode() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.versioncode;
        $jacocoInit[1] = true;
        return i;
    }

    public void setVersioncode(int versioncode2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.versioncode = versioncode2;
        $jacocoInit[2] = true;
    }

    public String getUri() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.uri;
        $jacocoInit[3] = true;
        return str;
    }

    public void setUri(String uri2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.uri = uri2;
        $jacocoInit[4] = true;
    }

    public String getMd5() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.md5;
        $jacocoInit[5] = true;
        return str;
    }

    public void setMd5(String md52) {
        boolean[] $jacocoInit = $jacocoInit();
        this.md5 = md52;
        $jacocoInit[6] = true;
    }

    public String getMinSdk() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.minSdk;
        $jacocoInit[7] = true;
        return str;
    }

    public void setMinSdk(String minSdk2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.minSdk = minSdk2;
        $jacocoInit[8] = true;
    }
}
