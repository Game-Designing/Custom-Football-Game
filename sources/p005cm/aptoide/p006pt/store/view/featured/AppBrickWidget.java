package p005cm.aptoide.p006pt.store.view.featured;

import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App;
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

/* renamed from: cm.aptoide.pt.store.view.featured.AppBrickWidget */
public class AppBrickWidget extends Widget<AppBrickDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ImageView graphic;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6563134052126049426L, "cm/aptoide/pt/store/view/featured/AppBrickWidget", 24);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((AppBrickDisplayable) displayable, i);
        $jacocoInit[10] = true;
    }

    public AppBrickWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.graphic = (ImageView) itemView.findViewById(C1375R.C1376id.featured_graphic);
        $jacocoInit[1] = true;
    }

    public void bindView(AppBrickDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        C0014p context = getContext();
        $jacocoInit[2] = true;
        ImageLoader with = ImageLoader.with(context);
        $jacocoInit[3] = true;
        App app = (App) displayable.getPojo();
        $jacocoInit[4] = true;
        String graphic2 = app.getGraphic();
        ImageView imageView = this.graphic;
        $jacocoInit[5] = true;
        with.load(graphic2, C1375R.drawable.placeholder_brick, imageView);
        $jacocoInit[6] = true;
        C0136c cVar = this.compositeSubscription;
        C0120S a = C13034a.m42490a(this.itemView);
        C4995d dVar = new C4995d(this, displayable);
        C4994c cVar2 = C4994c.f8665a;
        $jacocoInit[7] = true;
        C0137ja a2 = a.mo3626a((C0129b<? super T>) dVar, (C0129b<Throwable>) cVar2);
        $jacocoInit[8] = true;
        cVar.mo3713a(a2);
        $jacocoInit[9] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16637a(AppBrickDisplayable displayable, Void v) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator = getFragmentNavigator();
        FragmentProvider fragmentProvider = AptoideApplication.getFragmentProvider();
        $jacocoInit[13] = true;
        App app = (App) displayable.getPojo();
        $jacocoInit[14] = true;
        long id = app.getId();
        App app2 = (App) displayable.getPojo();
        $jacocoInit[15] = true;
        String packageName = app2.getPackageName();
        App app3 = (App) displayable.getPojo();
        $jacocoInit[16] = true;
        Store store = app3.getStore();
        $jacocoInit[17] = true;
        Appearance appearance = store.getAppearance();
        $jacocoInit[18] = true;
        String theme = appearance.getTheme();
        App app4 = (App) displayable.getPojo();
        $jacocoInit[19] = true;
        Store store2 = app4.getStore();
        $jacocoInit[20] = true;
        String name = store2.getName();
        String tag = displayable.getTag();
        String valueOf = String.valueOf(getAdapterPosition());
        $jacocoInit[21] = true;
        Fragment newAppViewFragment = fragmentProvider.newAppViewFragment(id, packageName, theme, name, tag, valueOf);
        $jacocoInit[22] = true;
        fragmentNavigator.navigateTo(newAppViewFragment, true);
        $jacocoInit[23] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9352a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[11] = true;
        instance.log(throwable);
        $jacocoInit[12] = true;
    }
}
