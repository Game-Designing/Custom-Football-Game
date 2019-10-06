package p005cm.aptoide.p006pt.home.apps;

import android.view.View;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;

/* renamed from: cm.aptoide.pt.home.apps.InstalledHeaderViewHolder */
public class InstalledHeaderViewHolder extends AppsViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private TextView title;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3828906605578744425L, "cm/aptoide/pt/home/apps/InstalledHeaderViewHolder", 3);
        $jacocoData = probes;
        return probes;
    }

    public InstalledHeaderViewHolder(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
        this.title = (TextView) itemView.findViewById(C1375R.C1376id.apps_downloads_header_title);
        $jacocoInit[1] = true;
    }

    public void setApp(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.title.setText(C1375R.string.apps_title_installed_apps_header);
        $jacocoInit[2] = true;
    }
}
