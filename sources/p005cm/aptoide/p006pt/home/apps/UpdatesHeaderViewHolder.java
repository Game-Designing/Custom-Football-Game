package p005cm.aptoide.p006pt.home.apps;

import android.view.View;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.apps.UpdatesHeaderViewHolder */
class UpdatesHeaderViewHolder extends AppsViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private TextView title;
    private C14963c<Void> updateAllApps;
    private TextView updateAllButton;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-736728969303581119L, "cm/aptoide/pt/home/apps/UpdatesHeaderViewHolder", 6);
        $jacocoData = probes;
        return probes;
    }

    public UpdatesHeaderViewHolder(View itemView, C14963c<Void> updateAllApps2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
        this.title = (TextView) itemView.findViewById(C1375R.C1376id.apps_updates_header_title);
        $jacocoInit[1] = true;
        this.updateAllButton = (TextView) itemView.findViewById(C1375R.C1376id.apps_updates_update_all_button);
        this.updateAllApps = updateAllApps2;
        $jacocoInit[2] = true;
    }

    public void setApp(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.title.setText(C1375R.string.apps_title_updates_header);
        $jacocoInit[3] = true;
        this.updateAllButton.setOnClickListener(new C3652_e(this));
        $jacocoInit[4] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14921a(View click) {
        boolean[] $jacocoInit = $jacocoInit();
        this.updateAllApps.onNext(null);
        $jacocoInit[5] = true;
    }
}
