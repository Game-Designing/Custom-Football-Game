package p005cm.aptoide.p006pt.home.apps;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;

/* renamed from: cm.aptoide.pt.home.apps.InstallingAppViewHolder */
class InstallingAppViewHolder extends AppsViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ImageView appIcon;
    private TextView appName = ((TextView) this.itemView.findViewById(C1375R.C1376id.apps_installing_app_name));

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6984981848667698896L, "cm/aptoide/pt/home/apps/InstallingAppViewHolder", 11);
        $jacocoData = probes;
        return probes;
    }

    InstallingAppViewHolder(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        super(view);
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
        this.appIcon = (ImageView) this.itemView.findViewById(C1375R.C1376id.apps_installing_icon);
        $jacocoInit[2] = true;
    }

    public void setApp(App app) {
        String appName2;
        String icon;
        boolean[] $jacocoInit = $jacocoInit();
        if (app instanceof UpdateApp) {
            $jacocoInit[3] = true;
            icon = ((UpdateApp) app).getIcon();
            $jacocoInit[4] = true;
            appName2 = ((UpdateApp) app).getName();
            $jacocoInit[5] = true;
        } else {
            icon = ((DownloadApp) app).getIcon();
            $jacocoInit[6] = true;
            appName2 = ((DownloadApp) app).getName();
            $jacocoInit[7] = true;
        }
        ImageLoader with = ImageLoader.with(this.itemView.getContext());
        ImageView imageView = this.appIcon;
        $jacocoInit[8] = true;
        with.load(icon, imageView);
        $jacocoInit[9] = true;
        this.appName.setText(appName2);
        $jacocoInit[10] = true;
    }
}
