package p005cm.aptoide.p006pt.notification;

import android.content.Context;
import android.content.Intent;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.notification.ContentPuller */
public class ContentPuller {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Context context;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3931849899339616501L, "cm/aptoide/pt/notification/ContentPuller", 2);
        $jacocoData = probes;
        return probes;
    }

    public ContentPuller(Context context2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.context = context2;
        $jacocoInit[0] = true;
    }

    public void start() {
        boolean[] $jacocoInit = $jacocoInit();
        Context context2 = this.context;
        context2.startService(new Intent(context2, PullingContentService.class));
        $jacocoInit[1] = true;
    }
}
