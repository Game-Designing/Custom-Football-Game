package p005cm.aptoide.p006pt.view.recycler.widget;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.home.GridAppCoinsRewardAppsDisplayable;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.view.app.Application;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p029i.C0136c;

/* renamed from: cm.aptoide.pt.view.recycler.widget.GridAppCoinsRewardAppsWidget */
public class GridAppCoinsRewardAppsWidget extends Widget<GridAppCoinsRewardAppsDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ImageView appIcon;
    private TextView appName;
    private TextView appReward;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6797978892375746587L, "cm/aptoide/pt/view/recycler/widget/GridAppCoinsRewardAppsWidget", 19);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((GridAppCoinsRewardAppsDisplayable) displayable, i);
        $jacocoInit[15] = true;
    }

    public GridAppCoinsRewardAppsWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appIcon = (ImageView) itemView.findViewById(C1375R.C1376id.icon);
        $jacocoInit[1] = true;
        this.appName = (TextView) itemView.findViewById(C1375R.C1376id.name);
        $jacocoInit[2] = true;
        this.appReward = (TextView) itemView.findViewById(C1375R.C1376id.appc_text);
        $jacocoInit[3] = true;
    }

    public void unbindView() {
        boolean[] $jacocoInit = $jacocoInit();
        super.unbindView();
        $jacocoInit[4] = true;
    }

    public void bindView(GridAppCoinsRewardAppsDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        Application app = (Application) displayable.getPojo();
        $jacocoInit[5] = true;
        ImageLoader with = ImageLoader.with(this.itemView.getContext());
        $jacocoInit[6] = true;
        with.loadWithRoundCorners(app.getIcon(), 8, this.appIcon, (int) C1375R.drawable.placeholder_square);
        $jacocoInit[7] = true;
        this.appName.setText(app.getName());
        $jacocoInit[8] = true;
        TextView textView = this.appReward;
        Resources resources = this.itemView.getResources();
        $jacocoInit[9] = true;
        String string = resources.getString(C1375R.string.appc_card_short);
        $jacocoInit[10] = true;
        textView.setText(string);
        $jacocoInit[11] = true;
        C0136c cVar = this.compositeSubscription;
        C0120S a = C13034a.m42490a(this.itemView);
        C5378c cVar2 = new C5378c(displayable);
        C5379d dVar = C5379d.f9195a;
        $jacocoInit[12] = true;
        C0137ja a2 = a.mo3626a((C0129b<? super T>) cVar2, (C0129b<Throwable>) dVar);
        $jacocoInit[13] = true;
        cVar.mo3713a(a2);
        $jacocoInit[14] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9638a(GridAppCoinsRewardAppsDisplayable displayable, Void v) {
        boolean[] $jacocoInit = $jacocoInit();
        displayable.openAppView();
        $jacocoInit[18] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9639a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[16] = true;
        instance.log(throwable);
        $jacocoInit[17] = true;
    }
}
