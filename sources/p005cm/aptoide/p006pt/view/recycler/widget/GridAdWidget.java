package p005cm.aptoide.p006pt.view.recycler.widget;

import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.realm.MinimalAd;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p005cm.aptoide.p006pt.view.FragmentProvider;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.GridAdDisplayable;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p029i.C0136c;

/* renamed from: cm.aptoide.pt.view.recycler.widget.GridAdWidget */
public class GridAdWidget extends Widget<GridAdDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ImageView icon;
    private TextView name;
    private TextView rating;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3346697220392450456L, "cm/aptoide/pt/view/recycler/widget/GridAdWidget", 23);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((GridAdDisplayable) displayable, i);
        $jacocoInit[17] = true;
    }

    public GridAdWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.name = (TextView) itemView.findViewById(C1375R.C1376id.name);
        $jacocoInit[1] = true;
        this.icon = (ImageView) itemView.findViewById(C1375R.C1376id.icon);
        $jacocoInit[2] = true;
        this.rating = (TextView) itemView.findViewById(C1375R.C1376id.rating_label);
        $jacocoInit[3] = true;
    }

    public void bindView(GridAdDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        MinimalAd pojo = (MinimalAd) displayable.getPojo();
        $jacocoInit[4] = true;
        this.name.setText(pojo.getName());
        $jacocoInit[5] = true;
        C0014p context = getContext();
        $jacocoInit[6] = true;
        ImageLoader with = ImageLoader.with(context);
        $jacocoInit[7] = true;
        with.load(pojo.getIconPath(), this.icon);
        $jacocoInit[8] = true;
        C0136c cVar = this.compositeSubscription;
        C0120S a = C13034a.m42490a(this.itemView);
        C5377b bVar = new C5377b(this, pojo, displayable);
        C5376a aVar = C5376a.f9190a;
        $jacocoInit[9] = true;
        C0137ja a2 = a.mo3626a((C0129b<? super T>) bVar, (C0129b<Throwable>) aVar);
        $jacocoInit[10] = true;
        cVar.mo3713a(a2);
        try {
            $jacocoInit[11] = true;
            DecimalFormat oneDecimalFormatter = new DecimalFormat("0.0");
            $jacocoInit[12] = true;
            this.rating.setText(oneDecimalFormatter.format(pojo.getStars()));
            $jacocoInit[13] = true;
        } catch (Exception e) {
            $jacocoInit[14] = true;
            this.rating.setText(C1375R.string.appcardview_title_no_stars);
            $jacocoInit[15] = true;
        }
        $jacocoInit[16] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17342a(MinimalAd pojo, GridAdDisplayable displayable, Void v) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator = getFragmentNavigator();
        FragmentProvider fragmentProvider = AptoideApplication.getFragmentProvider();
        SearchAdResult searchAdResult = new SearchAdResult(pojo);
        $jacocoInit[20] = true;
        Fragment newAppViewFragment = fragmentProvider.newAppViewFragment(searchAdResult, displayable.getTag());
        $jacocoInit[21] = true;
        fragmentNavigator.navigateTo(newAppViewFragment, true);
        $jacocoInit[22] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9636a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[18] = true;
        instance.log(throwable);
        $jacocoInit[19] = true;
    }
}
