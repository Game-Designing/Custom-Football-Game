package p005cm.aptoide.p006pt.home.apps;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.apps.AppcAppViewHolder */
public class AppcAppViewHolder extends AppsViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ImageView appIcon;
    private TextView appName;
    private C14963c<AppClick> updateApp;
    private ImageView updateAppButton;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8212419588423878726L, "cm/aptoide/pt/home/apps/AppcAppViewHolder", 13);
        $jacocoData = probes;
        return probes;
    }

    public AppcAppViewHolder(View itemView, C14963c<AppClick> updateApp2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        this.updateApp = updateApp2;
        $jacocoInit[0] = true;
        this.appName = (TextView) itemView.findViewById(C1375R.C1376id.apps_updates_app_name);
        $jacocoInit[1] = true;
        this.appIcon = (ImageView) itemView.findViewById(C1375R.C1376id.apps_updates_app_icon);
        $jacocoInit[2] = true;
        this.updateAppButton = (ImageView) itemView.findViewById(C1375R.C1376id.apps_updates_update_button);
        $jacocoInit[3] = true;
    }

    public void setApp(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appName.setText(((UpdateApp) app).getName());
        $jacocoInit[4] = true;
        ImageLoader with = ImageLoader.with(this.itemView.getContext());
        UpdateApp updateApp2 = (UpdateApp) app;
        $jacocoInit[5] = true;
        with.load(updateApp2.getIcon(), this.appIcon);
        $jacocoInit[6] = true;
        this.updateAppButton.setOnClickListener(new C3674d(this, app));
        $jacocoInit[7] = true;
        this.itemView.setOnClickListener(new C3681e(this, app));
        $jacocoInit[8] = true;
        this.itemView.setOnLongClickListener(new C3667c(this, app));
        $jacocoInit[9] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14586a(App app, View install) {
        boolean[] $jacocoInit = $jacocoInit();
        this.updateApp.onNext(new AppClick(app, ClickType.APPC_UPGRADE_APP));
        $jacocoInit[12] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14587b(App app, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.updateApp.onNext(new AppClick(app, ClickType.CARD_CLICK));
        $jacocoInit[11] = true;
    }

    /* renamed from: c */
    public /* synthetic */ boolean mo14588c(App app, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.updateApp.onNext(new AppClick(app, ClickType.UPDATE_CARD_LONG_CLICK));
        $jacocoInit[10] = true;
        return true;
    }
}
