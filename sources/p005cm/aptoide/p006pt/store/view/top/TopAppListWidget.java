package p005cm.aptoide.p006pt.store.view.top;

import android.content.Context;
import android.content.res.Resources;
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
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.AppCoinsInfo;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Appearance;
import p005cm.aptoide.p006pt.home.AppSecondaryInfoViewHolder;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.view.FragmentProvider;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p029i.C0136c;

/* renamed from: cm.aptoide.pt.store.view.top.TopAppListWidget */
public class TopAppListWidget extends Widget<TopAppListDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ImageView appIcon;
    private AppSecondaryInfoViewHolder appInfoViewHolder;
    private TextView downloadNumber;
    private TextView name;
    private DecimalFormat oneDecimalFormatter;
    private TextView topNumber;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1019455394274879446L, "cm/aptoide/pt/store/view/top/TopAppListWidget", 39);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((TopAppListDisplayable) displayable, i);
        $jacocoInit[29] = true;
    }

    public TopAppListWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.topNumber = (TextView) itemView.findViewById(C1375R.C1376id.top_number);
        $jacocoInit[1] = true;
        this.appIcon = (ImageView) itemView.findViewById(C1375R.C1376id.icon);
        $jacocoInit[2] = true;
        this.name = (TextView) itemView.findViewById(C1375R.C1376id.name_label);
        $jacocoInit[3] = true;
        this.downloadNumber = (TextView) itemView.findViewById(C1375R.C1376id.download_number_label);
        $jacocoInit[4] = true;
        this.oneDecimalFormatter = new DecimalFormat("0.0");
        $jacocoInit[5] = true;
        this.appInfoViewHolder = new AppSecondaryInfoViewHolder(itemView, this.oneDecimalFormatter);
        $jacocoInit[6] = true;
        TextView rating = (TextView) itemView.findViewById(C1375R.C1376id.rating_label);
        $jacocoInit[7] = true;
        rating.setTextAppearance(itemView.getContext(), C1375R.style.Aptoide_TextView_Medium_XXS_Black);
        $jacocoInit[8] = true;
    }

    public void bindView(TopAppListDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        App app = (App) displayable.getPojo();
        $jacocoInit[9] = true;
        ImageLoader with = ImageLoader.with(this.itemView.getContext());
        $jacocoInit[10] = true;
        with.loadWithRoundCorners(app.getIcon(), 8, this.appIcon, (int) C1375R.drawable.placeholder_square);
        $jacocoInit[11] = true;
        this.name.setText(app.getName());
        $jacocoInit[12] = true;
        this.topNumber.setText(String.valueOf(position + 1));
        $jacocoInit[13] = true;
        AppSecondaryInfoViewHolder appSecondaryInfoViewHolder = this.appInfoViewHolder;
        AppCoinsInfo appcoins = app.getAppcoins();
        $jacocoInit[14] = true;
        boolean hasBilling = appcoins.hasBilling();
        Stats stats = app.getStats();
        $jacocoInit[15] = true;
        Rating rating = stats.getRating();
        $jacocoInit[16] = true;
        float avg = rating.getAvg();
        $jacocoInit[17] = true;
        appSecondaryInfoViewHolder.setInfo(hasBilling, avg, true, true);
        $jacocoInit[18] = true;
        TextView textView = this.downloadNumber;
        Stats stats2 = app.getStats();
        $jacocoInit[19] = true;
        long downloads = (long) stats2.getDownloads();
        $jacocoInit[20] = true;
        View view = this.itemView;
        $jacocoInit[21] = true;
        Context context = view.getContext();
        $jacocoInit[22] = true;
        Resources resources = context.getResources();
        $jacocoInit[23] = true;
        Object[] objArr = {StringU.withSuffix(downloads), resources.getString(C1375R.string.downloads)};
        $jacocoInit[24] = true;
        textView.setText(String.format("%s %s", objArr));
        $jacocoInit[25] = true;
        C0136c cVar = this.compositeSubscription;
        C0120S a = C13034a.m42490a(this.itemView);
        C5088a aVar = new C5088a(this, app, displayable);
        C5089b bVar = C5089b.f8791a;
        $jacocoInit[26] = true;
        C0137ja a2 = a.mo3626a((C0129b<? super T>) aVar, (C0129b<Throwable>) bVar);
        $jacocoInit[27] = true;
        cVar.mo3713a(a2);
        $jacocoInit[28] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16729a(App app, TopAppListDisplayable displayable, Void v) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator = getFragmentNavigator();
        FragmentProvider fragmentProvider = AptoideApplication.getFragmentProvider();
        $jacocoInit[32] = true;
        long id = app.getId();
        String packageName = app.getPackageName();
        Store store = app.getStore();
        $jacocoInit[33] = true;
        Appearance appearance = store.getAppearance();
        $jacocoInit[34] = true;
        String theme = appearance.getTheme();
        Store store2 = app.getStore();
        $jacocoInit[35] = true;
        String name2 = store2.getName();
        String tag = displayable.getTag();
        String valueOf = String.valueOf(getAdapterPosition());
        $jacocoInit[36] = true;
        Fragment newAppViewFragment = fragmentProvider.newAppViewFragment(id, packageName, theme, name2, tag, valueOf);
        $jacocoInit[37] = true;
        fragmentNavigator.navigateTo(newAppViewFragment, true);
        $jacocoInit[38] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9417a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[30] = true;
        instance.log(throwable);
        $jacocoInit[31] = true;
    }
}
