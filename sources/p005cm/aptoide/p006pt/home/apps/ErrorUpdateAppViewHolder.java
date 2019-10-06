package p005cm.aptoide.p006pt.home.apps;

import android.graphics.drawable.Drawable;
import android.support.p000v4.content.C0510b;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.apps.ErrorUpdateAppViewHolder */
class ErrorUpdateAppViewHolder extends AppsViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ImageView appIcon;
    private TextView appName;
    private boolean isAppcUpgrade;
    private ImageView retryButton;
    private C14963c<AppClick> retryUpdate;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5897090654592759515L, "cm/aptoide/pt/home/apps/ErrorUpdateAppViewHolder", 18);
        $jacocoData = probes;
        return probes;
    }

    public ErrorUpdateAppViewHolder(View itemView, C14963c<AppClick> retryUpdate2) {
        boolean[] $jacocoInit = $jacocoInit();
        this(itemView, retryUpdate2, false);
        $jacocoInit[0] = true;
    }

    public ErrorUpdateAppViewHolder(View itemView, C14963c<AppClick> retryUpdate2, boolean isAppcUpgrade2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[1] = true;
        this.appName = (TextView) itemView.findViewById(C1375R.C1376id.apps_updates_app_name);
        $jacocoInit[2] = true;
        this.appIcon = (ImageView) itemView.findViewById(C1375R.C1376id.apps_updates_app_icon);
        $jacocoInit[3] = true;
        this.retryButton = (ImageView) itemView.findViewById(C1375R.C1376id.apps_updates_retry_button);
        if (!isAppcUpgrade2) {
            $jacocoInit[4] = true;
        } else {
            ImageView imageView = this.retryButton;
            $jacocoInit[5] = true;
            Drawable c = C0510b.m2572c(itemView.getContext(), C1375R.drawable.ic_refresh_appc);
            $jacocoInit[6] = true;
            imageView.setImageDrawable(c);
            $jacocoInit[7] = true;
        }
        this.retryUpdate = retryUpdate2;
        this.isAppcUpgrade = isAppcUpgrade2;
        $jacocoInit[8] = true;
    }

    public void setApp(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(this.itemView.getContext());
        UpdateApp updateApp = (UpdateApp) app;
        $jacocoInit[9] = true;
        with.load(updateApp.getIcon(), this.appIcon);
        $jacocoInit[10] = true;
        this.appName.setText(((UpdateApp) app).getName());
        $jacocoInit[11] = true;
        this.itemView.setOnClickListener(new C3503Bd(this, app));
        $jacocoInit[12] = true;
        this.retryButton.setOnClickListener(new C3509Cd(this, app));
        $jacocoInit[13] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14825a(App app, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.retryUpdate.onNext(new AppClick(app, ClickType.CARD_CLICK));
        $jacocoInit[17] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14826b(App app, View install) {
        ClickType clickType;
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<AppClick> cVar = this.retryUpdate;
        if (this.isAppcUpgrade) {
            clickType = ClickType.APPC_UPGRADE_RETRY;
            $jacocoInit[14] = true;
        } else {
            clickType = ClickType.RETRY_UPDATE;
            $jacocoInit[15] = true;
        }
        cVar.onNext(new AppClick(app, clickType));
        $jacocoInit[16] = true;
    }
}
