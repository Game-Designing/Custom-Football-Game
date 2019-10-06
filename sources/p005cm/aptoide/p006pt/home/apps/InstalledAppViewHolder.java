package p005cm.aptoide.p006pt.home.apps;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;

/* renamed from: cm.aptoide.pt.home.apps.InstalledAppViewHolder */
class InstalledAppViewHolder extends AppsViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ImageView appIcon;
    private TextView appName;
    private TextView appVersion;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5087897103835708558L, "cm/aptoide/pt/home/apps/InstalledAppViewHolder", 8);
        $jacocoData = probes;
        return probes;
    }

    public InstalledAppViewHolder(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
        this.appVersion = (TextView) itemView.findViewById(C1375R.C1376id.apps_installed_app_version);
        $jacocoInit[1] = true;
        this.appName = (TextView) itemView.findViewById(C1375R.C1376id.apps_installed_app_name);
        $jacocoInit[2] = true;
        this.appIcon = (ImageView) itemView.findViewById(C1375R.C1376id.apps_installed_icon);
        $jacocoInit[3] = true;
    }

    public void setApp(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(this.itemView.getContext());
        InstalledApp installedApp = (InstalledApp) app;
        $jacocoInit[4] = true;
        with.load(installedApp.getIcon(), this.appIcon);
        $jacocoInit[5] = true;
        this.appName.setText(((InstalledApp) app).getAppName());
        $jacocoInit[6] = true;
        this.appVersion.setText(((InstalledApp) app).getVersion());
        $jacocoInit[7] = true;
    }
}
