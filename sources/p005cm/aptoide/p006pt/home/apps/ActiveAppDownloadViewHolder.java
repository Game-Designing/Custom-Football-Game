package p005cm.aptoide.p006pt.home.apps;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.apps.ActiveAppDownloadViewHolder */
class ActiveAppDownloadViewHolder extends AppsViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ImageView appIcon;
    private TextView appName;
    private TextView downloadProgress;
    private ImageView pauseButton;
    private C14963c<AppClick> pauseDownload;
    private ProgressBar progressBar;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7733462950912421956L, "cm/aptoide/pt/home/apps/ActiveAppDownloadViewHolder", 16);
        $jacocoData = probes;
        return probes;
    }

    public ActiveAppDownloadViewHolder(View itemView, C14963c<AppClick> pauseDownload2) {
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
        this.pauseButton = (ImageView) itemView.findViewById(C1375R.C1376id.apps_download_pause_button);
        this.pauseDownload = pauseDownload2;
        $jacocoInit[5] = true;
    }

    public void setApp(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(this.itemView.getContext());
        DownloadApp downloadApp = (DownloadApp) app;
        $jacocoInit[6] = true;
        with.load(downloadApp.getIcon(), this.appIcon);
        $jacocoInit[7] = true;
        this.appName.setText(((DownloadApp) app).getName());
        $jacocoInit[8] = true;
        this.progressBar.setProgress(((DownloadApp) app).getProgress());
        $jacocoInit[9] = true;
        this.downloadProgress.setText(String.format("%d%%", new Object[]{Integer.valueOf(((DownloadApp) app).getProgress())}));
        $jacocoInit[10] = true;
        this.progressBar.setIndeterminate(((DownloadApp) app).isIndeterminate());
        $jacocoInit[11] = true;
        this.itemView.setOnClickListener(new C3660b(this, app));
        $jacocoInit[12] = true;
        this.pauseButton.setOnClickListener(new C3653a(this, app));
        $jacocoInit[13] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14573a(App app, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.pauseDownload.onNext(new AppClick(app, ClickType.CARD_CLICK));
        $jacocoInit[15] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14574b(App app, View pause) {
        boolean[] $jacocoInit = $jacocoInit();
        this.pauseDownload.onNext(new AppClick(app, ClickType.PAUSE_DOWNLOAD));
        $jacocoInit[14] = true;
    }
}
