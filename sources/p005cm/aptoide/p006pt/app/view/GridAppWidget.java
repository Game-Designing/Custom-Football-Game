package p005cm.aptoide.p006pt.app.view;

import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.app.view.GridAppDisplayable;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App.Stats;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App.Stats.Rating;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Appearance;
import p005cm.aptoide.p006pt.home.AppSecondaryInfoViewHolder;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.view.FragmentProvider;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p029i.C0136c;

/* renamed from: cm.aptoide.pt.app.view.GridAppWidget */
public class GridAppWidget<T extends GridAppDisplayable> extends Widget<T> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private AppSecondaryInfoViewHolder appInfoViewHolder;
    private ImageView icon;
    private TextView name;
    private String storeName;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3815561478447558647L, "cm/aptoide/pt/app/view/GridAppWidget", 29);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((T) (GridAppDisplayable) displayable, i);
        $jacocoInit[20] = true;
    }

    public GridAppWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        this.name = (TextView) this.itemView.findViewById(C1375R.C1376id.name);
        $jacocoInit[1] = true;
        this.icon = (ImageView) this.itemView.findViewById(C1375R.C1376id.icon);
        $jacocoInit[2] = true;
        this.appInfoViewHolder = new AppSecondaryInfoViewHolder(this.itemView, new DecimalFormat("0.0"));
        $jacocoInit[3] = true;
    }

    public void bindView(T displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        App pojo = (App) displayable.getPojo();
        $jacocoInit[4] = true;
        long appId = pojo.getId();
        $jacocoInit[5] = true;
        C0014p context = getContext();
        $jacocoInit[6] = true;
        ImageLoader with = ImageLoader.with(context);
        $jacocoInit[7] = true;
        with.load(pojo.getIcon(), this.icon);
        $jacocoInit[8] = true;
        this.name.setText(pojo.getName());
        $jacocoInit[9] = true;
        AppSecondaryInfoViewHolder appSecondaryInfoViewHolder = this.appInfoViewHolder;
        boolean hasBilling = pojo.hasBilling();
        Stats stats = pojo.getStats();
        $jacocoInit[10] = true;
        Rating rating = stats.getRating();
        $jacocoInit[11] = true;
        float avg = rating.getAvg();
        $jacocoInit[12] = true;
        appSecondaryInfoViewHolder.setInfo(hasBilling, avg, true, false);
        $jacocoInit[13] = true;
        Store store = pojo.getStore();
        $jacocoInit[14] = true;
        this.storeName = store.getName();
        $jacocoInit[15] = true;
        C0136c cVar = this.compositeSubscription;
        C0120S a = C13034a.m42490a(this.itemView);
        $jacocoInit[16] = true;
        C0137ja a2 = a.mo3626a(newOnClickListener(displayable, pojo, appId), (C0129b<Throwable>) C1979Yg.f5011a);
        $jacocoInit[17] = true;
        cVar.mo3713a(a2);
        $jacocoInit[18] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6895a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[27] = true;
        instance.log(throwable);
        $jacocoInit[28] = true;
    }

    /* access modifiers changed from: protected */
    public C0129b<Void> newOnClickListener(T displayable, App pojo, long appId) {
        boolean[] $jacocoInit = $jacocoInit();
        C1970Xg xg = new C1970Xg(this, appId, pojo, displayable);
        $jacocoInit[19] = true;
        return xg;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10767a(long appId, App pojo, GridAppDisplayable displayable, Void v) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator = getFragmentNavigator();
        FragmentProvider fragmentProvider = AptoideApplication.getFragmentProvider();
        $jacocoInit[21] = true;
        String packageName = pojo.getPackageName();
        Store store = pojo.getStore();
        $jacocoInit[22] = true;
        Appearance appearance = store.getAppearance();
        $jacocoInit[23] = true;
        String theme = appearance.getTheme();
        String str = this.storeName;
        String tag = displayable.getTag();
        $jacocoInit[24] = true;
        Fragment newAppViewFragment = fragmentProvider.newAppViewFragment(appId, packageName, theme, str, tag);
        $jacocoInit[25] = true;
        fragmentNavigator.navigateTo(newAppViewFragment, true);
        $jacocoInit[26] = true;
    }
}
