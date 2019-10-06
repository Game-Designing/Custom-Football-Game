package p005cm.aptoide.p006pt.app.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Date;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.utils.AptoideUtils.DateTimeU;
import p005cm.aptoide.p006pt.view.FragmentProvider;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p029i.C0136c;

/* renamed from: cm.aptoide.pt.app.view.GridAppListWidget */
public class GridAppListWidget extends Widget<GridAppListDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    public ImageView icon;
    public TextView name;
    private TextView tvStoreName;
    private TextView tvTimeSinceModified;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2527006607073976457L, "cm/aptoide/pt/app/view/GridAppListWidget", 32);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((GridAppListDisplayable) displayable, i);
        $jacocoInit[26] = true;
    }

    public GridAppListWidget(View itemView) {
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
        this.tvTimeSinceModified = (TextView) itemView.findViewById(C1375R.C1376id.timeSinceModified);
        $jacocoInit[3] = true;
        this.tvStoreName = (TextView) itemView.findViewById(C1375R.C1376id.storeName);
        $jacocoInit[4] = true;
    }

    public void bindView(GridAppListDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        App app = (App) displayable.getPojo();
        $jacocoInit[5] = true;
        this.name.setText(app.getName());
        $jacocoInit[6] = true;
        Date modified = app.getUpdated();
        if (modified == null) {
            $jacocoInit[7] = true;
        } else {
            $jacocoInit[8] = true;
            TextView textView = this.tvTimeSinceModified;
            DateTimeU instance = DateTimeU.getInstance(this.itemView.getContext());
            View view = this.itemView;
            $jacocoInit[9] = true;
            Context context = view.getContext();
            long time = modified.getTime();
            $jacocoInit[10] = true;
            Resources resources = getContext().getResources();
            $jacocoInit[11] = true;
            String timeDiffString = instance.getTimeDiffString(context, time, resources);
            $jacocoInit[12] = true;
            textView.setText(timeDiffString);
            $jacocoInit[13] = true;
        }
        this.name.setText(app.getName());
        $jacocoInit[14] = true;
        this.name.setTypeface(null, 1);
        $jacocoInit[15] = true;
        TextView textView2 = this.tvStoreName;
        Store store = app.getStore();
        $jacocoInit[16] = true;
        String name2 = store.getName();
        $jacocoInit[17] = true;
        textView2.setText(name2);
        $jacocoInit[18] = true;
        this.tvStoreName.setTypeface(null, 1);
        $jacocoInit[19] = true;
        C0014p context2 = getContext();
        $jacocoInit[20] = true;
        C0136c cVar = this.compositeSubscription;
        C0120S a = C13034a.m42490a(this.itemView);
        C1961Wg wg = new C1961Wg(this, app, displayable);
        C1952Vg vg = C1952Vg.f4976a;
        $jacocoInit[21] = true;
        C0137ja a2 = a.mo3626a((C0129b<? super T>) wg, (C0129b<Throwable>) vg);
        $jacocoInit[22] = true;
        cVar.mo3713a(a2);
        $jacocoInit[23] = true;
        ImageLoader with = ImageLoader.with(context2);
        $jacocoInit[24] = true;
        with.load(app.getIcon(), this.icon);
        $jacocoInit[25] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10763a(App app, GridAppListDisplayable displayable, Void v) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator = getFragmentNavigator();
        FragmentProvider fragmentProvider = AptoideApplication.getFragmentProvider();
        $jacocoInit[29] = true;
        Fragment newAppViewFragment = fragmentProvider.newAppViewFragment(app.getId(), app.getPackageName(), displayable.getTag());
        $jacocoInit[30] = true;
        fragmentNavigator.navigateTo(newAppViewFragment, true);
        $jacocoInit[31] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6893a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[27] = true;
        instance.log(throwable);
        $jacocoInit[28] = true;
    }
}
