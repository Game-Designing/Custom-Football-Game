package p005cm.aptoide.p006pt.store.view.featured;

import android.support.p000v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App.Stats;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App.Stats.Rating;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Appearance;
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

/* renamed from: cm.aptoide.pt.store.view.featured.AppBrickListWidget */
public class AppBrickListWidget extends Widget<AppBrickListDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ImageView appIcon;
    private ImageView graphic;
    private TextView name;
    private DecimalFormat oneDecimalFormatter = new DecimalFormat("0.0");
    private TextView rating;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2862902791944316154L, "cm/aptoide/pt/store/view/featured/AppBrickListWidget", 30);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((AppBrickListDisplayable) displayable, i);
        $jacocoInit[20] = true;
    }

    public AppBrickListWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appIcon = (ImageView) itemView.findViewById(C1375R.C1376id.app_icon);
        $jacocoInit[2] = true;
        this.name = (TextView) itemView.findViewById(C1375R.C1376id.app_name);
        $jacocoInit[3] = true;
        this.graphic = (ImageView) itemView.findViewById(C1375R.C1376id.featured_graphic);
        $jacocoInit[4] = true;
        this.rating = (TextView) itemView.findViewById(C1375R.C1376id.rating_label);
        $jacocoInit[5] = true;
    }

    public void bindView(AppBrickListDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        App app = (App) displayable.getPojo();
        $jacocoInit[6] = true;
        ImageLoader with = ImageLoader.with(getContext());
        $jacocoInit[7] = true;
        with.load(app.getIcon(), C1375R.drawable.placeholder_square, this.appIcon);
        $jacocoInit[8] = true;
        ImageLoader with2 = ImageLoader.with(getContext());
        $jacocoInit[9] = true;
        with2.load(app.getGraphic(), C1375R.drawable.placeholder_brick, this.graphic);
        $jacocoInit[10] = true;
        this.name.setText(app.getName());
        $jacocoInit[11] = true;
        Stats stats = app.getStats();
        $jacocoInit[12] = true;
        Rating rating2 = stats.getRating();
        $jacocoInit[13] = true;
        float rating3 = rating2.getAvg();
        if (rating3 == 0.0f) {
            $jacocoInit[14] = true;
            this.rating.setText(C1375R.string.appcardview_title_no_stars);
            $jacocoInit[15] = true;
        } else {
            this.rating.setText(this.oneDecimalFormatter.format((double) rating3));
            $jacocoInit[16] = true;
        }
        C0136c cVar = this.compositeSubscription;
        C0120S a = C13034a.m42490a(this.itemView);
        C4993b bVar = new C4993b(this, app, displayable);
        C4992a aVar = C4992a.f8661a;
        $jacocoInit[17] = true;
        C0137ja a2 = a.mo3626a((C0129b<? super T>) bVar, (C0129b<Throwable>) aVar);
        $jacocoInit[18] = true;
        cVar.mo3713a(a2);
        $jacocoInit[19] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16635a(App app, AppBrickListDisplayable displayable, Void v) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator = getFragmentNavigator();
        FragmentProvider fragmentProvider = AptoideApplication.getFragmentProvider();
        $jacocoInit[23] = true;
        long id = app.getId();
        String packageName = app.getPackageName();
        Store store = app.getStore();
        $jacocoInit[24] = true;
        Appearance appearance = store.getAppearance();
        $jacocoInit[25] = true;
        String theme = appearance.getTheme();
        Store store2 = app.getStore();
        $jacocoInit[26] = true;
        String name2 = store2.getName();
        String tag = displayable.getTag();
        String valueOf = String.valueOf(getAdapterPosition());
        $jacocoInit[27] = true;
        Fragment newAppViewFragment = fragmentProvider.newAppViewFragment(id, packageName, theme, name2, tag, valueOf);
        $jacocoInit[28] = true;
        fragmentNavigator.navigateTo(newAppViewFragment, true);
        $jacocoInit[29] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9350a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[21] = true;
        instance.log(throwable);
        $jacocoInit[22] = true;
    }
}
