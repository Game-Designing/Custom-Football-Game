package p005cm.aptoide.p006pt.home.apps;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.apps.StandByAppDownloadViewHolder */
class StandByAppDownloadViewHolder extends AppsViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ImageView appIcon;
    private TextView appName;
    private ImageView cancelButton;
    private C14963c<AppClick> downloadAction;
    private LinearLayout downloadAppInfoLayout;
    private LinearLayout downloadInteractButtonsLayout;
    private TextView downloadProgress;
    private TextView downloadState;
    private ProgressBar progressBar;
    private ImageView resumeButton;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8000589282904922599L, "cm/aptoide/pt/home/apps/StandByAppDownloadViewHolder", 47);
        $jacocoData = probes;
        return probes;
    }

    public StandByAppDownloadViewHolder(View itemView, C14963c<AppClick> downloadAction2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
        this.appName = (TextView) itemView.findViewById(C1375R.C1376id.apps_downloads_app_name);
        $jacocoInit[1] = true;
        this.appIcon = (ImageView) itemView.findViewById(C1375R.C1376id.apps_downloads_icon);
        $jacocoInit[2] = true;
        this.progressBar = (ProgressBar) itemView.findViewById(C1375R.C1376id.apps_downloads_progress_bar);
        $jacocoInit[3] = true;
        this.downloadProgress = (TextView) itemView.findViewById(C1375R.C1376id.apps_download_progress_number);
        $jacocoInit[4] = true;
        this.cancelButton = (ImageView) itemView.findViewById(C1375R.C1376id.apps_download_cancel_button);
        $jacocoInit[5] = true;
        this.resumeButton = (ImageView) itemView.findViewById(C1375R.C1376id.apps_download_resume_download);
        $jacocoInit[6] = true;
        this.downloadInteractButtonsLayout = (LinearLayout) itemView.findViewById(C1375R.C1376id.apps_downloads_standby_buttons_layout);
        $jacocoInit[7] = true;
        this.downloadAppInfoLayout = (LinearLayout) itemView.findViewById(C1375R.C1376id.apps_downloads_standby_app_info_layout);
        $jacocoInit[8] = true;
        this.downloadState = (TextView) itemView.findViewById(C1375R.C1376id.apps_downloads_download_state);
        this.downloadAction = downloadAction2;
        $jacocoInit[9] = true;
    }

    public void setApp(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(this.itemView.getContext());
        DownloadApp downloadApp = (DownloadApp) app;
        $jacocoInit[10] = true;
        with.load(downloadApp.getIcon(), this.appIcon);
        $jacocoInit[11] = true;
        this.appName.setText(((DownloadApp) app).getName());
        $jacocoInit[12] = true;
        if (((DownloadApp) app).isIndeterminate()) {
            $jacocoInit[13] = true;
            this.progressBar.setIndeterminate(true);
            $jacocoInit[14] = true;
            adjustStandByDownloadAppInfoWeightAndMargin(3, 56);
            $jacocoInit[15] = true;
            adjustStandByDownloadButtonsWeight(0);
            $jacocoInit[16] = true;
            this.cancelButton.setVisibility(8);
            $jacocoInit[17] = true;
            this.resumeButton.setVisibility(8);
            $jacocoInit[18] = true;
            this.downloadProgress.setVisibility(8);
            $jacocoInit[19] = true;
            TextView textView = this.downloadState;
            Resources resources = this.itemView.getResources();
            $jacocoInit[20] = true;
            String string = resources.getString(C1375R.string.apps_short_downloading);
            $jacocoInit[21] = true;
            textView.setText(string);
            $jacocoInit[22] = true;
        } else {
            adjustStandByDownloadAppInfoWeightAndMargin(2, 8);
            $jacocoInit[23] = true;
            adjustStandByDownloadButtonsWeight(1);
            $jacocoInit[24] = true;
            this.downloadInteractButtonsLayout.setVisibility(0);
            $jacocoInit[25] = true;
            this.progressBar.setIndeterminate(false);
            $jacocoInit[26] = true;
            this.progressBar.setProgress(((DownloadApp) app).getProgress());
            $jacocoInit[27] = true;
            this.downloadProgress.setText(String.format("%d%%", new Object[]{Integer.valueOf(((DownloadApp) app).getProgress())}));
            $jacocoInit[28] = true;
            this.cancelButton.setVisibility(0);
            $jacocoInit[29] = true;
            this.resumeButton.setVisibility(0);
            $jacocoInit[30] = true;
            this.downloadProgress.setVisibility(0);
            $jacocoInit[31] = true;
            TextView textView2 = this.downloadState;
            Resources resources2 = this.itemView.getResources();
            $jacocoInit[32] = true;
            String string2 = resources2.getString(C1375R.string.apps_short_download_paused);
            $jacocoInit[33] = true;
            textView2.setText(string2);
            $jacocoInit[34] = true;
        }
        this.itemView.setOnClickListener(new C3599Re(this, app));
        $jacocoInit[35] = true;
        this.cancelButton.setOnClickListener(new C3611Te(this, app));
        $jacocoInit[36] = true;
        this.resumeButton.setOnClickListener(new C3605Se(this, app));
        $jacocoInit[37] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14901a(App app, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadAction.onNext(new AppClick(app, ClickType.CARD_CLICK));
        $jacocoInit[46] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14902b(App app, View cancel) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadAction.onNext(new AppClick(app, ClickType.CANCEL_DOWNLOAD));
        $jacocoInit[45] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo14903c(App app, View resume) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadAction.onNext(new AppClick(app, ClickType.RESUME_DOWNLOAD));
        $jacocoInit[44] = true;
    }

    private void adjustStandByDownloadAppInfoWeightAndMargin(int weight, int margin) {
        boolean[] $jacocoInit = $jacocoInit();
        LinearLayout linearLayout = this.downloadAppInfoLayout;
        $jacocoInit[38] = true;
        LayoutParams appInfoParams = (LayoutParams) linearLayout.getLayoutParams();
        appInfoParams.weight = (float) weight;
        appInfoParams.rightMargin = margin;
        $jacocoInit[39] = true;
        this.downloadAppInfoLayout.setLayoutParams(appInfoParams);
        $jacocoInit[40] = true;
    }

    private void adjustStandByDownloadButtonsWeight(int weight) {
        boolean[] $jacocoInit = $jacocoInit();
        LinearLayout linearLayout = this.downloadInteractButtonsLayout;
        $jacocoInit[41] = true;
        LayoutParams buttonsLayoutParams = (LayoutParams) linearLayout.getLayoutParams();
        buttonsLayoutParams.weight = (float) weight;
        $jacocoInit[42] = true;
        this.downloadInteractButtonsLayout.setLayoutParams(buttonsLayoutParams);
        $jacocoInit[43] = true;
    }
}
