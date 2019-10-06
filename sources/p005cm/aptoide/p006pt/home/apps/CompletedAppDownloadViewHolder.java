package p005cm.aptoide.p006pt.home.apps;

import android.support.p001v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.apps.CompletedAppDownloadViewHolder */
class CompletedAppDownloadViewHolder extends AppsViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ImageView appIcon;
    private TextView appName;
    private CardView card;
    private C14963c<AppClick> installApp;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-665575863268468244L, "cm/aptoide/pt/home/apps/CompletedAppDownloadViewHolder", 11);
        $jacocoData = probes;
        return probes;
    }

    public CompletedAppDownloadViewHolder(View itemView, C14963c<AppClick> installApp2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
        this.appName = (TextView) itemView.findViewById(C1375R.C1376id.apps_downloads_app_name);
        $jacocoInit[1] = true;
        this.appIcon = (ImageView) itemView.findViewById(C1375R.C1376id.apps_downloads_icon);
        $jacocoInit[2] = true;
        this.card = (CardView) itemView.findViewById(C1375R.C1376id.app_completed_download_card);
        this.installApp = installApp2;
        $jacocoInit[3] = true;
    }

    public void setApp(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(this.itemView.getContext());
        DownloadApp downloadApp = (DownloadApp) app;
        $jacocoInit[4] = true;
        with.load(downloadApp.getIcon(), this.appIcon);
        $jacocoInit[5] = true;
        this.appName.setText(((DownloadApp) app).getName());
        $jacocoInit[6] = true;
        this.itemView.setOnClickListener(new C3817yd(this, app));
        $jacocoInit[7] = true;
        this.card.setOnClickListener(new C3811xd(this, app));
        $jacocoInit[8] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14809a(App app, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installApp.onNext(new AppClick(app, ClickType.CARD_CLICK));
        $jacocoInit[10] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14810b(App app, View install) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installApp.onNext(new AppClick(app, ClickType.INSTALL_APP));
        $jacocoInit[9] = true;
    }
}
