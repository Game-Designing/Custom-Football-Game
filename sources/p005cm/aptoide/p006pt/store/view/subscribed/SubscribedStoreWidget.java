package p005cm.aptoide.p006pt.store.view.subscribed;

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
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.store.StoreTheme;
import p005cm.aptoide.p006pt.view.FragmentProvider;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p029i.C0136c;

/* renamed from: cm.aptoide.pt.store.view.subscribed.SubscribedStoreWidget */
public class SubscribedStoreWidget extends Widget<SubscribedStoreDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ImageView storeAvatar;
    private LinearLayout storeLayout;
    private TextView storeName;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5645829691317313657L, "cm/aptoide/pt/store/view/subscribed/SubscribedStoreWidget", 30);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((SubscribedStoreDisplayable) displayable, i);
        $jacocoInit[23] = true;
    }

    public SubscribedStoreWidget(View itemView) {
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

    public void bindView(SubscribedStoreDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        Store store = (Store) displayable.getPojo();
        $jacocoInit[4] = true;
        this.storeName.setText(store.getStoreName());
        $jacocoInit[5] = true;
        this.storeLayout.setBackgroundColor(-1);
        $jacocoInit[6] = true;
        C0136c cVar = this.compositeSubscription;
        C0120S a = C13034a.m42490a(this.storeLayout);
        C5085a aVar = new C5085a(this, displayable);
        $jacocoInit[7] = true;
        C0137ja c = a.mo3646c((C0129b<? super T>) aVar);
        $jacocoInit[8] = true;
        cVar.mo3713a(c);
        $jacocoInit[9] = true;
        C0014p context = getContext();
        $jacocoInit[10] = true;
        if (store.getStoreId() == -1) {
            $jacocoInit[11] = true;
        } else if (TextUtils.isEmpty(store.getIconPath())) {
            $jacocoInit[12] = true;
        } else {
            ImageLoader with = ImageLoader.with(context);
            $jacocoInit[17] = true;
            String iconPath = store.getIconPath();
            ImageView imageView = this.storeAvatar;
            $jacocoInit[18] = true;
            StoreTheme storeTheme = StoreTheme.get(store.getTheme());
            $jacocoInit[19] = true;
            int storeHeaderColorResource = storeTheme.getStoreHeaderColorResource(context.getResources(), context.getTheme());
            $jacocoInit[20] = true;
            with.loadWithShadowCircleTransform(iconPath, imageView, storeHeaderColorResource);
            $jacocoInit[21] = true;
            $jacocoInit[22] = true;
        }
        ImageLoader with2 = ImageLoader.with(context);
        ImageView imageView2 = this.storeAvatar;
        $jacocoInit[13] = true;
        StoreTheme storeTheme2 = StoreTheme.get(store.getTheme());
        $jacocoInit[14] = true;
        int storeHeaderColorResource2 = storeTheme2.getStoreHeaderColorResource(context.getResources(), context.getTheme());
        $jacocoInit[15] = true;
        with2.loadWithShadowCircleTransform((int) C1375R.drawable.ic_avatar_apps, imageView2, storeHeaderColorResource2);
        $jacocoInit[16] = true;
        $jacocoInit[22] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16723a(SubscribedStoreDisplayable displayable, Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentProvider fragmentProvider = AptoideApplication.getFragmentProvider();
        $jacocoInit[24] = true;
        Store store = (Store) displayable.getPojo();
        $jacocoInit[25] = true;
        String storeName2 = store.getStoreName();
        Store store2 = (Store) displayable.getPojo();
        $jacocoInit[26] = true;
        String theme = store2.getTheme();
        $jacocoInit[27] = true;
        Fragment fragment = fragmentProvider.newStoreFragment(storeName2, theme);
        $jacocoInit[28] = true;
        getFragmentNavigator().navigateTo(fragment, true);
        $jacocoInit[29] = true;
    }
}
