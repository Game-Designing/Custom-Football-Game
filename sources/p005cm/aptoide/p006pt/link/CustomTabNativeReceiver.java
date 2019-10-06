package p005cm.aptoide.p006pt.link;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.link.CustomTabNativeReceiver */
public class CustomTabNativeReceiver extends BroadcastReceiver {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String MOCKUP_URL = "http://www.example.com";
    private static final String REFERER_ATTRIBUTE = "Referer";
    private static final String REFERER_VALUE = "http://m.aptoide.com";

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2745570297047188289L, "cm/aptoide/pt/link/CustomTabNativeReceiver", 30);
        $jacocoData = probes;
        return probes;
    }

    public CustomTabNativeReceiver() {
        $jacocoInit()[0] = true;
    }

    public void onReceive(Context context, Intent intent) {
        boolean[] $jacocoInit = $jacocoInit();
        String url = intent.getDataString();
        if (url == null) {
            $jacocoInit[1] = true;
        } else {
            $jacocoInit[2] = true;
            Set<String> listOfPackagesThatResolveUri = getNativeAppPackage(context, Uri.parse(url));
            String availableNativeAppPackageName = null;
            $jacocoInit[3] = true;
            Iterator it = listOfPackagesThatResolveUri.iterator();
            $jacocoInit[4] = true;
            if (!it.hasNext()) {
                $jacocoInit[5] = true;
            } else {
                $jacocoInit[6] = true;
                Iterator it2 = listOfPackagesThatResolveUri.iterator();
                $jacocoInit[7] = true;
                availableNativeAppPackageName = (String) it2.next();
                $jacocoInit[8] = true;
            }
            if (availableNativeAppPackageName != null) {
                $jacocoInit[9] = true;
                Intent launchIntent = new Intent("android.intent.action.VIEW", Uri.parse(url));
                $jacocoInit[10] = true;
                Bundle httpHeaders = new Bundle();
                $jacocoInit[11] = true;
                httpHeaders.putString(REFERER_ATTRIBUTE, REFERER_VALUE);
                $jacocoInit[12] = true;
                launchIntent.putExtra("com.android.browser.headers", httpHeaders);
                $jacocoInit[13] = true;
                launchIntent.setFlags(268435456);
                $jacocoInit[14] = true;
                context.startActivity(launchIntent);
                $jacocoInit[15] = true;
            } else {
                Toast makeText = Toast.makeText(context, "No application to open.", 0);
                $jacocoInit[16] = true;
                makeText.show();
                $jacocoInit[17] = true;
            }
        }
        $jacocoInit[18] = true;
    }

    private Set<String> getNativeAppPackage(Context context, Uri uri) {
        boolean[] $jacocoInit = $jacocoInit();
        PackageManager pm = context.getPackageManager();
        $jacocoInit[19] = true;
        String str = "android.intent.action.VIEW";
        Intent browserActivityIntent = new Intent(str, Uri.parse(MOCKUP_URL));
        $jacocoInit[20] = true;
        Set<String> genericResolvedList = extractPackagenames(pm.queryIntentActivities(browserActivityIntent, 0));
        $jacocoInit[21] = true;
        Intent specializedActivityIntent = new Intent(str, uri);
        $jacocoInit[22] = true;
        Set<String> resolvedSpecializedList = extractPackagenames(pm.queryIntentActivities(specializedActivityIntent, 0));
        $jacocoInit[23] = true;
        resolvedSpecializedList.removeAll(genericResolvedList);
        $jacocoInit[24] = true;
        return resolvedSpecializedList;
    }

    private Set<String> extractPackagenames(List<ResolveInfo> resolveInfos) {
        boolean[] $jacocoInit = $jacocoInit();
        Set<String> packageNameSet = new HashSet<>();
        $jacocoInit[25] = true;
        $jacocoInit[26] = true;
        for (ResolveInfo ri : resolveInfos) {
            $jacocoInit[27] = true;
            packageNameSet.add(ri.activityInfo.packageName);
            $jacocoInit[28] = true;
        }
        $jacocoInit[29] = true;
        return packageNameSet;
    }
}
