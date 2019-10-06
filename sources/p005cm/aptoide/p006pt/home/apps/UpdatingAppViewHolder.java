package p005cm.aptoide.p006pt.home.apps;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.apps.UpdatingAppViewHolder */
class UpdatingAppViewHolder extends AppsViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ImageView appIcon;
    private TextView appName;
    private boolean isAppcUpgrade;
    private ImageView pauseButton;
    private C14963c<AppClick> pauseUpdate;
    private ProgressBar progressBar;
    private TextView updateProgress;
    private TextView updateState;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6314683843469616407L, "cm/aptoide/pt/home/apps/UpdatingAppViewHolder", 19);
        $jacocoData = probes;
        return probes;
    }

    public UpdatingAppViewHolder(View itemView, C14963c<AppClick> pauseUpdate2) {
        boolean[] $jacocoInit = $jacocoInit();
        this(itemView, pauseUpdate2, false);
        $jacocoInit[0] = true;
    }

    public UpdatingAppViewHolder(View itemView, C14963c<AppClick> pauseUpdate2, boolean isAppcUpgrade2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[1] = true;
        this.appName = (TextView) itemView.findViewById(C1375R.C1376id.apps_updates_app_name);
        $jacocoInit[2] = true;
        this.appIcon = (ImageView) itemView.findViewById(C1375R.C1376id.apps_updates_app_icon);
        $jacocoInit[3] = true;
        this.progressBar = (ProgressBar) itemView.findViewById(C1375R.C1376id.apps_updates_progress_bar);
        $jacocoInit[4] = true;
        this.updateState = (TextView) itemView.findViewById(C1375R.C1376id.apps_updates_update_state);
        $jacocoInit[5] = true;
        this.updateProgress = (TextView) itemView.findViewById(C1375R.C1376id.apps_updates_progress_number);
        $jacocoInit[6] = true;
        this.pauseButton = (ImageView) itemView.findViewById(C1375R.C1376id.apps_updates_pause_button);
        this.pauseUpdate = pauseUpdate2;
        this.isAppcUpgrade = isAppcUpgrade2;
        $jacocoInit[7] = true;
    }

    public void setApp(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(this.itemView.getContext());
        UpdateApp updateApp = (UpdateApp) app;
        $jacocoInit[8] = true;
        with.load(updateApp.getIcon(), this.appIcon);
        $jacocoInit[9] = true;
        this.appName.setText(((UpdateApp) app).getName());
        $jacocoInit[10] = true;
        this.progressBar.setProgress(((UpdateApp) app).getProgress());
        $jacocoInit[11] = true;
        this.updateProgress.setText(String.format("%d%%", new Object[]{Integer.valueOf(((UpdateApp) app).getProgress())}));
        $jacocoInit[12] = true;
        this.itemView.setOnClickListener(new C3750nf(this, app));
        $jacocoInit[13] = true;
        this.pauseButton.setOnClickListener(new C3757of(this, app));
        $jacocoInit[14] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14932a(App app, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.pauseUpdate.onNext(new AppClick(app, ClickType.CARD_CLICK));
        $jacocoInit[18] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14933b(App app, View pause) {
        ClickType clickType;
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<AppClick> cVar = this.pauseUpdate;
        if (this.isAppcUpgrade) {
            clickType = ClickType.APPC_UPGRADE_PAUSE;
            $jacocoInit[15] = true;
        } else {
            clickType = ClickType.PAUSE_UPDATE;
            $jacocoInit[16] = true;
        }
        cVar.onNext(new AppClick(app, clickType));
        $jacocoInit[17] = true;
    }
}
