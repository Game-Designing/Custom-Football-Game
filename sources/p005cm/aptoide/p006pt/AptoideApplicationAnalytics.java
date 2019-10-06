package p005cm.aptoide.p006pt;

import android.os.Bundle;
import com.facebook.C6817z;
import com.facebook.GraphRequest.C6545b;
import com.facebook.p127a.C6638q;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.logger.Logger;
import p019d.p020e.p021a.C7294e;

/* renamed from: cm.aptoide.pt.AptoideApplicationAnalytics */
public class AptoideApplicationAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4910735567103568808L, "cm/aptoide/pt/AptoideApplicationAnalytics", 23);
        $jacocoData = probes;
        return probes;
    }

    public AptoideApplicationAnalytics() {
        $jacocoInit()[0] = true;
    }

    public void updateDimension(boolean isLoggedIn) {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[1] = true;
        String str2 = "Not Logged In";
        String str3 = "Logged In";
        if (isLoggedIn) {
            $jacocoInit[2] = true;
            str = str3;
        } else {
            $jacocoInit[3] = true;
            str = str2;
        }
        bundle.putString(str3, str);
        $jacocoInit[4] = true;
        C6638q.m13217a(bundle, (C6545b) C1366E.f4258a);
        $jacocoInit[5] = true;
        if (isLoggedIn) {
            $jacocoInit[6] = true;
            str2 = str3;
        } else {
            $jacocoInit[7] = true;
        }
        C7294e.m15866a(str3, str2);
        $jacocoInit[8] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m118c(C6817z response) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[21] = true;
        instance.mo2136d("Facebook Analytics: ", response.toString());
        $jacocoInit[22] = true;
    }

    public void setPackageDimension(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[9] = true;
        String str = "aptoide_package";
        bundle.putString(str, packageName);
        $jacocoInit[10] = true;
        C6638q.m13217a(bundle, (C6545b) C1371G.f4260a);
        $jacocoInit[11] = true;
        C7294e.m15866a(str, packageName);
        $jacocoInit[12] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m116a(C6817z response) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[19] = true;
        instance.mo2136d("Facebook Analytics: ", response.toString());
        $jacocoInit[20] = true;
    }

    public void setVersionCodeDimension(String versionCode) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[13] = true;
        String str = "version code";
        bundle.putString(str, versionCode);
        $jacocoInit[14] = true;
        C6638q.m13217a(bundle, (C6545b) C1367F.f4259a);
        $jacocoInit[15] = true;
        C7294e.m15866a(str, versionCode);
        $jacocoInit[16] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m117b(C6817z response) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[17] = true;
        instance.mo2136d("Facebook Analytics: ", response.toString());
        $jacocoInit[18] = true;
    }
}
