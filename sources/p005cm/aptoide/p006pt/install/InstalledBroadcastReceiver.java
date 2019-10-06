package p005cm.aptoide.p006pt.install;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.install.InstalledBroadcastReceiver */
public class InstalledBroadcastReceiver extends BroadcastReceiver {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5783477404650710465L, "cm/aptoide/pt/install/InstalledBroadcastReceiver", 4);
        $jacocoData = probes;
        return probes;
    }

    public InstalledBroadcastReceiver() {
        $jacocoInit()[0] = true;
    }

    public void onReceive(Context context, Intent intent) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent callService = new Intent(intent);
        $jacocoInit[1] = true;
        callService.setClassName(context, InstalledIntentService.class.getName());
        $jacocoInit[2] = true;
        context.startService(callService);
        $jacocoInit[3] = true;
    }
}
