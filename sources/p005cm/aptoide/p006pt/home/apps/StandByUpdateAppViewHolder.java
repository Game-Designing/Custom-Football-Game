package p005cm.aptoide.p006pt.home.apps;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.p000v4.content.C0510b;
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

/* renamed from: cm.aptoide.pt.home.apps.StandByUpdateAppViewHolder */
class StandByUpdateAppViewHolder extends AppsViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ImageView appIcon;
    private TextView appName;
    private ImageView cancelButton;
    private LinearLayout downloadAppInfoLayout;
    private LinearLayout downloadInteractButtonsLayout;
    private boolean isAppcUpgrade;
    private ProgressBar progressBar;
    private ImageView resumeButton;
    private C14963c<AppClick> updateAction;
    private TextView updateProgress;
    private TextView updateState;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6080344434617072822L, "cm/aptoide/pt/home/apps/StandByUpdateAppViewHolder", 57);
        $jacocoData = probes;
        return probes;
    }

    public StandByUpdateAppViewHolder(View itemView, C14963c<AppClick> updateAction2) {
        boolean[] $jacocoInit = $jacocoInit();
        this(itemView, updateAction2, false);
        $jacocoInit[0] = true;
    }

    public StandByUpdateAppViewHolder(View itemView, C14963c<AppClick> updateAction2, boolean isAppcUpgrade2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[1] = true;
        this.appName = (TextView) itemView.findViewById(C1375R.C1376id.apps_updates_app_name);
        $jacocoInit[2] = true;
        this.appIcon = (ImageView) itemView.findViewById(C1375R.C1376id.apps_updates_app_icon);
        $jacocoInit[3] = true;
        this.progressBar = (ProgressBar) itemView.findViewById(C1375R.C1376id.apps_updates_progress_bar);
        $jacocoInit[4] = true;
        this.updateProgress = (TextView) itemView.findViewById(C1375R.C1376id.apps_updates_progress_number);
        $jacocoInit[5] = true;
        this.cancelButton = (ImageView) itemView.findViewById(C1375R.C1376id.apps_updates_cancel_button);
        $jacocoInit[6] = true;
        this.resumeButton = (ImageView) itemView.findViewById(C1375R.C1376id.apps_updates_resume_download);
        $jacocoInit[7] = true;
        this.updateState = (TextView) itemView.findViewById(C1375R.C1376id.apps_updates_update_state);
        $jacocoInit[8] = true;
        this.downloadInteractButtonsLayout = (LinearLayout) itemView.findViewById(C1375R.C1376id.apps_updates_standby_buttons_layout);
        $jacocoInit[9] = true;
        this.downloadAppInfoLayout = (LinearLayout) itemView.findViewById(C1375R.C1376id.apps_updates_standby_app_info_layout);
        this.updateAction = updateAction2;
        this.isAppcUpgrade = isAppcUpgrade2;
        if (!isAppcUpgrade2) {
            $jacocoInit[10] = true;
        } else {
            ProgressBar progressBar2 = this.progressBar;
            $jacocoInit[11] = true;
            Drawable c = C0510b.m2572c(itemView.getContext(), C1375R.drawable.appc_progress);
            $jacocoInit[12] = true;
            progressBar2.setProgressDrawable(c);
            $jacocoInit[13] = true;
        }
        $jacocoInit[14] = true;
    }

    public void setApp(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(this.itemView.getContext());
        UpdateApp updateApp = (UpdateApp) app;
        $jacocoInit[15] = true;
        with.load(updateApp.getIcon(), this.appIcon);
        $jacocoInit[16] = true;
        this.appName.setText(((UpdateApp) app).getName());
        $jacocoInit[17] = true;
        if (((UpdateApp) app).isIndeterminate()) {
            $jacocoInit[18] = true;
            this.progressBar.setIndeterminate(true);
            $jacocoInit[19] = true;
            this.downloadInteractButtonsLayout.setVisibility(8);
            $jacocoInit[20] = true;
            adjustStandByDownloadAppInfoWeightAndMargin(3, 56);
            $jacocoInit[21] = true;
            adjustStandByDownloadButtonsWeight(0);
            $jacocoInit[22] = true;
            this.cancelButton.setVisibility(8);
            $jacocoInit[23] = true;
            this.resumeButton.setVisibility(8);
            $jacocoInit[24] = true;
            this.updateProgress.setVisibility(8);
            $jacocoInit[25] = true;
            TextView textView = this.updateState;
            Resources resources = this.itemView.getResources();
            $jacocoInit[26] = true;
            String string = resources.getString(C1375R.string.apps_short_updating);
            $jacocoInit[27] = true;
            textView.setText(string);
            $jacocoInit[28] = true;
        } else {
            adjustStandByDownloadAppInfoWeightAndMargin(2, 8);
            $jacocoInit[29] = true;
            adjustStandByDownloadButtonsWeight(1);
            $jacocoInit[30] = true;
            this.downloadInteractButtonsLayout.setVisibility(0);
            $jacocoInit[31] = true;
            this.progressBar.setIndeterminate(false);
            $jacocoInit[32] = true;
            this.progressBar.setProgress(((UpdateApp) app).getProgress());
            $jacocoInit[33] = true;
            this.updateProgress.setText(String.format("%d%%", new Object[]{Integer.valueOf(((UpdateApp) app).getProgress())}));
            $jacocoInit[34] = true;
            this.cancelButton.setVisibility(0);
            $jacocoInit[35] = true;
            this.resumeButton.setVisibility(0);
            $jacocoInit[36] = true;
            this.updateProgress.setVisibility(0);
            $jacocoInit[37] = true;
            TextView textView2 = this.updateState;
            Resources resources2 = this.itemView.getResources();
            $jacocoInit[38] = true;
            String string2 = resources2.getString(C1375R.string.apps_short_update_paused);
            $jacocoInit[39] = true;
            textView2.setText(string2);
            $jacocoInit[40] = true;
        }
        this.itemView.setOnClickListener(new C3629We(this, app));
        $jacocoInit[41] = true;
        this.cancelButton.setOnClickListener(new C3617Ue(this, app));
        $jacocoInit[42] = true;
        this.resumeButton.setOnClickListener(new C3623Ve(this, app));
        $jacocoInit[43] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14904a(App app, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.updateAction.onNext(new AppClick(app, ClickType.CARD_CLICK));
        $jacocoInit[56] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14905b(App app, View cancel) {
        ClickType clickType;
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<AppClick> cVar = this.updateAction;
        if (this.isAppcUpgrade) {
            clickType = ClickType.APPC_UPGRADE_CANCEL;
            $jacocoInit[53] = true;
        } else {
            clickType = ClickType.CANCEL_UPDATE;
            $jacocoInit[54] = true;
        }
        cVar.onNext(new AppClick(app, clickType));
        $jacocoInit[55] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo14906c(App app, View resume) {
        ClickType clickType;
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<AppClick> cVar = this.updateAction;
        if (this.isAppcUpgrade) {
            clickType = ClickType.APPC_UPGRADE_RESUME;
            $jacocoInit[50] = true;
        } else {
            clickType = ClickType.RESUME_UPDATE;
            $jacocoInit[51] = true;
        }
        cVar.onNext(new AppClick(app, clickType));
        $jacocoInit[52] = true;
    }

    private void adjustStandByDownloadAppInfoWeightAndMargin(int weight, int margin) {
        boolean[] $jacocoInit = $jacocoInit();
        LinearLayout linearLayout = this.downloadAppInfoLayout;
        $jacocoInit[44] = true;
        LayoutParams appInfoParams = (LayoutParams) linearLayout.getLayoutParams();
        appInfoParams.weight = (float) weight;
        appInfoParams.rightMargin = margin;
        $jacocoInit[45] = true;
        this.downloadAppInfoLayout.setLayoutParams(appInfoParams);
        $jacocoInit[46] = true;
    }

    private void adjustStandByDownloadButtonsWeight(int weight) {
        boolean[] $jacocoInit = $jacocoInit();
        LinearLayout linearLayout = this.downloadInteractButtonsLayout;
        $jacocoInit[47] = true;
        LayoutParams buttonsLayoutParams = (LayoutParams) linearLayout.getLayoutParams();
        buttonsLayoutParams.weight = (float) weight;
        $jacocoInit[48] = true;
        this.downloadInteractButtonsLayout.setLayoutParams(buttonsLayoutParams);
        $jacocoInit[49] = true;
    }
}
