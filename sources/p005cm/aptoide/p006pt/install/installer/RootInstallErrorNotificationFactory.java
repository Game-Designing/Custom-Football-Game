package p005cm.aptoide.p006pt.install.installer;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.p000v4.app.C0448aa.C0449a;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.install.Install;

/* renamed from: cm.aptoide.pt.install.installer.RootInstallErrorNotificationFactory */
public class RootInstallErrorNotificationFactory {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final PendingIntent dismissAction;
    private final Bitmap icon;
    private final C0449a notificationAction;
    private final int notificationId;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8842459581901464465L, "cm/aptoide/pt/install/installer/RootInstallErrorNotificationFactory", 9);
        $jacocoData = probes;
        return probes;
    }

    public RootInstallErrorNotificationFactory(int notificationId2, Bitmap icon2, C0449a notificationAction2, PendingIntent dismissAction2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.notificationId = notificationId2;
        this.icon = icon2;
        this.notificationAction = notificationAction2;
        this.dismissAction = dismissAction2;
        $jacocoInit[0] = true;
    }

    public RootInstallErrorNotification create(Context context, List<Install> installs) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.notificationId;
        Bitmap bitmap = this.icon;
        $jacocoInit[1] = true;
        RootInstallErrorNotification rootInstallErrorNotification = new RootInstallErrorNotification(i, bitmap, getNotificationTitle(context, installs), this.notificationAction, this.dismissAction);
        $jacocoInit[2] = true;
        return rootInstallErrorNotification;
    }

    private String getNotificationTitle(Context context, List<Install> installs) {
        String title;
        boolean[] $jacocoInit = $jacocoInit();
        if (installs.size() == 1) {
            $jacocoInit[3] = true;
            title = context.getString(C1375R.string.f4265xaa2d1690);
            $jacocoInit[4] = true;
        } else {
            $jacocoInit[5] = true;
            Object[] objArr = {Integer.valueOf(installs.size())};
            $jacocoInit[6] = true;
            title = context.getString(C1375R.string.generalscreen_short_root_install_timeout_error_message, objArr);
            $jacocoInit[7] = true;
        }
        $jacocoInit[8] = true;
        return title;
    }
}
