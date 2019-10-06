package p005cm.aptoide.p006pt.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.app.AppBoughtReceiver */
public abstract class AppBoughtReceiver extends BroadcastReceiver {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String APP_BOUGHT = "APP_BOUGHT";
    public static final String APP_ID = "appId";
    public static final String APP_PATH = "APP_PATH";

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4692669369632321482L, "cm/aptoide/pt/app/AppBoughtReceiver", 10);
        $jacocoData = probes;
        return probes;
    }

    public abstract void appBought(long j, String str);

    public AppBoughtReceiver() {
        $jacocoInit()[0] = true;
    }

    public void onReceive(Context context, Intent intent) {
        boolean[] $jacocoInit = $jacocoInit();
        String action = intent.getAction();
        $jacocoInit[1] = true;
        if (!TextUtils.equals(action, APP_BOUGHT)) {
            $jacocoInit[2] = true;
        } else {
            $jacocoInit[3] = true;
            String productId = intent.getStringExtra("appId");
            $jacocoInit[4] = true;
            String appIdString = productId.replace("product", "");
            $jacocoInit[5] = true;
            Long valueOf = Long.valueOf(appIdString);
            $jacocoInit[6] = true;
            long appId = valueOf.longValue();
            $jacocoInit[7] = true;
            appBought(appId, intent.getStringExtra(APP_PATH));
            $jacocoInit[8] = true;
        }
        $jacocoInit[9] = true;
    }
}
