package p005cm.aptoide.p006pt.install.installer;

import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.support.p000v4.app.C0448aa.C0449a;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.install.installer.RootInstallErrorNotification */
public class RootInstallErrorNotification {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final C0449a action;
    private final PendingIntent deleteAction;
    private final Bitmap icon;
    private final String message;
    public final int notificationId;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1936346034793566550L, "cm/aptoide/pt/install/installer/RootInstallErrorNotification", 6);
        $jacocoData = probes;
        return probes;
    }

    public RootInstallErrorNotification(int notificationId2, Bitmap icon2, String message2, C0449a action2, PendingIntent deleteAction2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.notificationId = notificationId2;
        this.icon = icon2;
        this.message = message2;
        this.action = action2;
        this.deleteAction = deleteAction2;
        $jacocoInit[0] = true;
    }

    public Bitmap getIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        Bitmap bitmap = this.icon;
        $jacocoInit[1] = true;
        return bitmap;
    }

    public String getMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.message;
        $jacocoInit[2] = true;
        return str;
    }

    public int getNotificationId() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.notificationId;
        $jacocoInit[3] = true;
        return i;
    }

    public C0449a getAction() {
        boolean[] $jacocoInit = $jacocoInit();
        C0449a aVar = this.action;
        $jacocoInit[4] = true;
        return aVar;
    }

    public PendingIntent getDeleteAction() {
        boolean[] $jacocoInit = $jacocoInit();
        PendingIntent pendingIntent = this.deleteAction;
        $jacocoInit[5] = true;
        return pendingIntent;
    }
}
