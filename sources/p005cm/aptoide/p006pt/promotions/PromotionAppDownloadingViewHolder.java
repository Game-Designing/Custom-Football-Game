package p005cm.aptoide.p006pt.promotions;

import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.text.DecimalFormat;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.app.DownloadModel;
import p005cm.aptoide.p006pt.app.DownloadModel.DownloadState;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.promotions.PromotionAppDownloadingViewHolder */
class PromotionAppDownloadingViewHolder extends C1000w {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private TextView appDescription;
    private ImageView appIcon;
    private TextView appName;
    private TextView appSize;
    private ImageView cancelDownload;
    private final DecimalFormat decimalFormat;
    private LinearLayout downloadControlsLayout;
    private ProgressBar downloadProgressBar;
    private TextView downloadProgressValue;
    private TextView numberOfDownloads;
    private ImageView pauseDownload;
    private final C14963c<PromotionAppClick> promotionAppClick;
    private TextView rating;
    private ImageView resumeDownload;

    /* renamed from: cm.aptoide.pt.promotions.PromotionAppDownloadingViewHolder$1 */
    static /* synthetic */ class C44721 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState = new int[DownloadState.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-880855787732520137L, "cm/aptoide/pt/promotions/PromotionAppDownloadingViewHolder$1", 14);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.ACTIVE.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        try {
                            $jacocoInit[6] = true;
                        } catch (NoSuchFieldError e4) {
                            try {
                                $jacocoInit[8] = true;
                            } catch (NoSuchFieldError e5) {
                                try {
                                    $jacocoInit[10] = true;
                                } catch (NoSuchFieldError e6) {
                                    $jacocoInit[12] = true;
                                }
                            }
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.INDETERMINATE.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.PAUSE.ordinal()] = 3;
            $jacocoInit[5] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.ERROR.ordinal()] = 4;
            $jacocoInit[7] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.NOT_ENOUGH_STORAGE_ERROR.ordinal()] = 5;
            $jacocoInit[9] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.COMPLETE.ordinal()] = 6;
            $jacocoInit[11] = true;
            $jacocoInit[13] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3047397452262124967L, "cm/aptoide/pt/promotions/PromotionAppDownloadingViewHolder", 66);
        $jacocoData = probes;
        return probes;
    }

    public PromotionAppDownloadingViewHolder(View itemView, C14963c<PromotionAppClick> promotionAppClick2, DecimalFormat decimalFormat2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
        this.appIcon = (ImageView) itemView.findViewById(C1375R.C1376id.app_icon);
        $jacocoInit[1] = true;
        this.appName = (TextView) itemView.findViewById(C1375R.C1376id.app_name);
        $jacocoInit[2] = true;
        this.appDescription = (TextView) itemView.findViewById(C1375R.C1376id.app_description);
        $jacocoInit[3] = true;
        this.numberOfDownloads = (TextView) itemView.findViewById(C1375R.C1376id.number_of_downloads);
        $jacocoInit[4] = true;
        this.appSize = (TextView) itemView.findViewById(C1375R.C1376id.app_size);
        $jacocoInit[5] = true;
        this.rating = (TextView) itemView.findViewById(C1375R.C1376id.rating);
        $jacocoInit[6] = true;
        this.downloadProgressBar = (ProgressBar) itemView.findViewById(C1375R.C1376id.promotions_download_progress_bar);
        $jacocoInit[7] = true;
        this.downloadProgressValue = (TextView) itemView.findViewById(C1375R.C1376id.promotions_download_progress_number);
        $jacocoInit[8] = true;
        this.pauseDownload = (ImageView) itemView.findViewById(C1375R.C1376id.promotions_download_pause_download);
        $jacocoInit[9] = true;
        this.cancelDownload = (ImageView) itemView.findViewById(C1375R.C1376id.promotions_download_cancel_button);
        $jacocoInit[10] = true;
        this.resumeDownload = (ImageView) itemView.findViewById(C1375R.C1376id.promotions_download_resume_download);
        $jacocoInit[11] = true;
        this.downloadControlsLayout = (LinearLayout) itemView.findViewById(C1375R.C1376id.install_controls_layout);
        this.promotionAppClick = promotionAppClick2;
        this.decimalFormat = decimalFormat2;
        $jacocoInit[12] = true;
    }

    public void setApp(PromotionViewApp app) {
        boolean[] $jacocoInit = $jacocoInit();
        setAppCardHeader(app);
        $jacocoInit[13] = true;
        DownloadModel downloadModel = app.getDownloadModel();
        $jacocoInit[14] = true;
        int progress = downloadModel.getProgress();
        $jacocoInit[15] = true;
        setDownloadState(progress, app);
        $jacocoInit[16] = true;
    }

    private void setAppCardHeader(PromotionViewApp app) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(this.itemView.getContext());
        $jacocoInit[17] = true;
        with.load(app.getAppIcon(), this.appIcon);
        $jacocoInit[18] = true;
        this.appName.setText(app.getName());
        $jacocoInit[19] = true;
        this.appDescription.setText(app.getDescription());
        $jacocoInit[20] = true;
        this.appSize.setText(StringU.formatBytes(app.getSize(), false));
        $jacocoInit[21] = true;
        if (app.getRating() == 0.0f) {
            $jacocoInit[22] = true;
            this.rating.setText(C1375R.string.appcardview_title_no_stars);
            $jacocoInit[23] = true;
        } else {
            this.rating.setText(this.decimalFormat.format((double) app.getRating()));
            $jacocoInit[24] = true;
        }
        this.numberOfDownloads.setText(String.valueOf(app.getNumberOfDownloads()));
        $jacocoInit[25] = true;
    }

    private void setDownloadState(int progress, PromotionViewApp promotionViewApp) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadModel downloadModel = promotionViewApp.getDownloadModel();
        $jacocoInit[26] = true;
        DownloadState downloadState = downloadModel.getDownloadState();
        $jacocoInit[27] = true;
        LayoutParams pauseShowing = new LayoutParams(-1, -1, 4.0f);
        $jacocoInit[28] = true;
        LayoutParams layoutParams = new LayoutParams(-1, -1, 2.0f);
        $jacocoInit[29] = true;
        LayoutParams pauseHidden = layoutParams;
        String str = "%";
        switch (C44721.$SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[downloadState.ordinal()]) {
            case 1:
                this.downloadProgressBar.setIndeterminate(false);
                $jacocoInit[31] = true;
                this.downloadProgressBar.setProgress(progress);
                $jacocoInit[32] = true;
                TextView textView = this.downloadProgressValue;
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(progress));
                sb.append(str);
                textView.setText(sb.toString());
                $jacocoInit[33] = true;
                this.pauseDownload.setVisibility(0);
                $jacocoInit[34] = true;
                this.pauseDownload.setOnClickListener(new C4528fa(this, promotionViewApp));
                $jacocoInit[35] = true;
                this.cancelDownload.setVisibility(8);
                $jacocoInit[36] = true;
                this.resumeDownload.setVisibility(8);
                $jacocoInit[37] = true;
                this.downloadControlsLayout.setLayoutParams(pauseShowing);
                $jacocoInit[38] = true;
                break;
            case 2:
                this.downloadProgressBar.setIndeterminate(true);
                $jacocoInit[39] = true;
                this.pauseDownload.setVisibility(0);
                $jacocoInit[40] = true;
                this.pauseDownload.setOnClickListener(new C4540ia(this, promotionViewApp));
                $jacocoInit[41] = true;
                this.cancelDownload.setVisibility(8);
                $jacocoInit[42] = true;
                this.resumeDownload.setVisibility(8);
                $jacocoInit[43] = true;
                this.downloadControlsLayout.setLayoutParams(pauseShowing);
                $jacocoInit[44] = true;
                break;
            case 3:
                this.downloadProgressBar.setIndeterminate(false);
                $jacocoInit[45] = true;
                this.downloadProgressBar.setProgress(progress);
                $jacocoInit[46] = true;
                TextView textView2 = this.downloadProgressValue;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(String.valueOf(progress));
                sb2.append(str);
                textView2.setText(sb2.toString());
                $jacocoInit[47] = true;
                this.pauseDownload.setVisibility(8);
                $jacocoInit[48] = true;
                this.cancelDownload.setVisibility(0);
                $jacocoInit[49] = true;
                this.cancelDownload.setOnClickListener(new C4536ha(this, promotionViewApp));
                $jacocoInit[50] = true;
                this.resumeDownload.setVisibility(0);
                $jacocoInit[51] = true;
                this.resumeDownload.setOnClickListener(new C4532ga(this, promotionViewApp));
                $jacocoInit[52] = true;
                this.downloadControlsLayout.setLayoutParams(pauseHidden);
                $jacocoInit[53] = true;
                break;
            case 4:
            case 5:
            case 6:
                this.downloadProgressBar.setIndeterminate(true);
                $jacocoInit[54] = true;
                this.pauseDownload.setVisibility(0);
                $jacocoInit[55] = true;
                this.pauseDownload.setOnClickListener(new C4524ea(this, promotionViewApp));
                $jacocoInit[56] = true;
                this.cancelDownload.setVisibility(8);
                $jacocoInit[57] = true;
                this.resumeDownload.setVisibility(8);
                $jacocoInit[58] = true;
                this.downloadControlsLayout.setLayoutParams(pauseShowing);
                $jacocoInit[59] = true;
                break;
            default:
                $jacocoInit[30] = true;
                break;
        }
        $jacocoInit[60] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15615a(PromotionViewApp promotionViewApp, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionAppClick.onNext(new PromotionAppClick(promotionViewApp, ClickType.PAUSE_DOWNLOAD));
        $jacocoInit[65] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo15616b(PromotionViewApp promotionViewApp, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionAppClick.onNext(new PromotionAppClick(promotionViewApp, ClickType.PAUSE_DOWNLOAD));
        $jacocoInit[64] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo15617c(PromotionViewApp promotionViewApp, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionAppClick.onNext(new PromotionAppClick(promotionViewApp, ClickType.CANCEL_DOWNLOAD));
        $jacocoInit[63] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo15618d(PromotionViewApp promotionViewApp, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionAppClick.onNext(new PromotionAppClick(promotionViewApp, ClickType.RESUME_DOWNLOAD));
        $jacocoInit[62] = true;
    }

    /* renamed from: e */
    public /* synthetic */ void mo15619e(PromotionViewApp promotionViewApp, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionAppClick.onNext(new PromotionAppClick(promotionViewApp, ClickType.PAUSE_DOWNLOAD));
        $jacocoInit[61] = true;
    }
}
