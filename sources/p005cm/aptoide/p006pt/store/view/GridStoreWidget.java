package p005cm.aptoide.p006pt.store.view;

import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Appearance;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.view.FragmentProvider;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p029i.C0136c;
import rx.functions.Action1;

/* renamed from: cm.aptoide.pt.store.view.GridStoreWidget */
public class GridStoreWidget extends Widget<GridStoreDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ImageView storeAvatar;
    private LinearLayout storeLayout;
    private TextView storeName;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3762102378683180696L, "cm/aptoide/pt/store/view/GridStoreWidget", 35);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((GridStoreDisplayable) displayable, i);
        $jacocoInit[19] = true;
    }

    public GridStoreWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeAvatar = (ImageView) itemView.findViewById(C1375R.C1376id.store_avatar_row);
        $jacocoInit[1] = true;
        this.storeName = (TextView) itemView.findViewById(C1375R.C1376id.store_name_row);
        $jacocoInit[2] = true;
        this.storeLayout = (LinearLayout) itemView.findViewById(C1375R.C1376id.store_main_layout_row);
        $jacocoInit[3] = true;
    }

    public void bindView(GridStoreDisplayable gridStoreDisplayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        Store store = (Store) gridStoreDisplayable.getPojo();
        $jacocoInit[4] = true;
        this.storeName.setText(store.getName());
        $jacocoInit[5] = true;
        this.storeLayout.setBackgroundColor(-1);
        $jacocoInit[6] = true;
        Action1<Void> handleStoreClick = new C4989ea<>(this, gridStoreDisplayable, store);
        $jacocoInit[7] = true;
        C0136c cVar = this.compositeSubscription;
        C0120S a = C13034a.m42490a(this.storeLayout);
        $jacocoInit[8] = true;
        C0137ja c = a.mo3646c((C0129b<? super T>) handleStoreClick);
        $jacocoInit[9] = true;
        cVar.mo3713a(c);
        $jacocoInit[10] = true;
        C0014p context = getContext();
        $jacocoInit[11] = true;
        if (store.getId() == -1) {
            $jacocoInit[12] = true;
        } else if (TextUtils.isEmpty(store.getAvatar())) {
            $jacocoInit[13] = true;
        } else {
            ImageLoader with = ImageLoader.with(context);
            $jacocoInit[16] = true;
            with.loadUsingCircleTransform(store.getAvatar(), this.storeAvatar);
            $jacocoInit[17] = true;
            $jacocoInit[18] = true;
        }
        ImageLoader with2 = ImageLoader.with(context);
        ImageView imageView = this.storeAvatar;
        $jacocoInit[14] = true;
        with2.loadUsingCircleTransform((int) C1375R.drawable.ic_avatar_apps, imageView);
        $jacocoInit[15] = true;
        $jacocoInit[18] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16560a(GridStoreDisplayable gridStoreDisplayable, Store store, Void v) {
        boolean[] $jacocoInit = $jacocoInit();
        String origin = gridStoreDisplayable.getOrigin();
        $jacocoInit[20] = true;
        if (origin.isEmpty()) {
            $jacocoInit[21] = true;
        } else {
            $jacocoInit[22] = true;
            StoreAnalytics storeAnalytics = gridStoreDisplayable.getStoreAnalytics();
            $jacocoInit[23] = true;
            storeAnalytics.sendStoreTabInteractEvent(origin, true);
            $jacocoInit[24] = true;
            StoreAnalytics storeAnalytics2 = gridStoreDisplayable.getStoreAnalytics();
            $jacocoInit[25] = true;
            Store store2 = (Store) gridStoreDisplayable.getPojo();
            $jacocoInit[26] = true;
            String name = store2.getName();
            $jacocoInit[27] = true;
            storeAnalytics2.sendStoreOpenEvent(origin, name, true);
            $jacocoInit[28] = true;
        }
        FragmentNavigator fragmentNavigator = getFragmentNavigator();
        FragmentProvider fragmentProvider = AptoideApplication.getFragmentProvider();
        $jacocoInit[29] = true;
        Store store3 = (Store) gridStoreDisplayable.getPojo();
        $jacocoInit[30] = true;
        String name2 = store3.getName();
        Appearance appearance = store.getAppearance();
        $jacocoInit[31] = true;
        String theme = appearance.getTheme();
        $jacocoInit[32] = true;
        Fragment newStoreFragment = fragmentProvider.newStoreFragment(name2, theme);
        $jacocoInit[33] = true;
        fragmentNavigator.navigateTo(newStoreFragment, true);
        $jacocoInit[34] = true;
    }
}
