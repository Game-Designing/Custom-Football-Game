package p005cm.aptoide.p006pt.app.view;

import android.support.p000v4.app.Fragment;
import java.util.LinkedList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Layout;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListApps;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Appearance;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.Endless;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.ListAppsRequest;
import p005cm.aptoide.p006pt.home.HomeEvent.Type;
import p005cm.aptoide.p006pt.store.view.GetStoreEndlessFragment;
import p005cm.aptoide.p006pt.store.view.featured.AppBrickListDisplayable;
import p005cm.aptoide.p006pt.store.view.top.TopAppListDisplayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.app.view.ListAppsFragment */
public class ListAppsFragment extends GetStoreEndlessFragment<ListApps> {
    private static transient /* synthetic */ boolean[] $jacocoData;

    /* renamed from: cm.aptoide.pt.app.view.ListAppsFragment$1 */
    static /* synthetic */ class C18611 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Layout = new int[Layout.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(5937131432777911610L, "cm/aptoide/pt/app/view/ListAppsFragment$1", 4);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Layout[Layout.GRAPHIC.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                $jacocoInit[2] = true;
            }
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7288415362046230890L, "cm/aptoide/pt/app/view/ListAppsFragment", 34);
        $jacocoData = probes;
        return probes;
    }

    public ListAppsFragment() {
        $jacocoInit()[0] = true;
    }

    public static Fragment newInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        ListAppsFragment listAppsFragment = new ListAppsFragment();
        $jacocoInit[1] = true;
        return listAppsFragment;
    }

    /* access modifiers changed from: protected */
    public C0044V7<ListApps, ? extends Endless> buildRequest(boolean refresh, String url) {
        boolean[] $jacocoInit = $jacocoInit();
        ListAppsRequest newListAppsRequest = this.requestFactoryCdnPool.newListAppsRequest(url);
        $jacocoInit[2] = true;
        return newListAppsRequest;
    }

    /* access modifiers changed from: protected */
    public C0129b<ListApps> buildAction() {
        boolean[] $jacocoInit = $jacocoInit();
        C1988Zg zg = new C1988Zg(this);
        $jacocoInit[3] = true;
        return zg;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10772a(ListApps listApps) {
        boolean[] $jacocoInit = $jacocoInit();
        DataList dataList = listApps.getDataList();
        $jacocoInit[4] = true;
        List<App> list = dataList.getList();
        $jacocoInit[5] = true;
        List<Displayable> displayables = new LinkedList<>();
        $jacocoInit[6] = true;
        if (this.homeEventType.equals(Type.MORE_TOP)) {
            $jacocoInit[7] = true;
            $jacocoInit[8] = true;
            for (App app : list) {
                $jacocoInit[9] = true;
                Store store = app.getStore();
                Appearance appearance = new Appearance(this.storeTheme, null);
                $jacocoInit[10] = true;
                store.setAppearance(appearance);
                $jacocoInit[11] = true;
                displayables.add(new TopAppListDisplayable(app, this.tag, this.navigationTracker, this.storeContext));
                $jacocoInit[12] = true;
            }
            $jacocoInit[13] = true;
        } else {
            Layout layout = this.layout;
            if (layout != null) {
                $jacocoInit[14] = true;
                if (C18611.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Layout[layout.ordinal()] != 1) {
                    $jacocoInit[21] = true;
                    for (App app2 : list) {
                        $jacocoInit[22] = true;
                        Store store2 = app2.getStore();
                        Appearance appearance2 = new Appearance(this.storeTheme, null);
                        $jacocoInit[23] = true;
                        store2.setAppearance(appearance2);
                        $jacocoInit[24] = true;
                        displayables.add(new GridAppDisplayable(app2, this.tag, this.navigationTracker, this.storeContext));
                        $jacocoInit[25] = true;
                    }
                    $jacocoInit[26] = true;
                } else {
                    $jacocoInit[15] = true;
                    for (App app3 : list) {
                        $jacocoInit[16] = true;
                        Store store3 = app3.getStore();
                        Appearance appearance3 = new Appearance(this.storeTheme, null);
                        $jacocoInit[17] = true;
                        store3.setAppearance(appearance3);
                        $jacocoInit[18] = true;
                        displayables.add(new AppBrickListDisplayable(app3, this.tag, this.navigationTracker, this.storeContext));
                        $jacocoInit[19] = true;
                    }
                    $jacocoInit[20] = true;
                }
            } else {
                $jacocoInit[27] = true;
                for (App app4 : list) {
                    $jacocoInit[29] = true;
                    Store store4 = app4.getStore();
                    Appearance appearance4 = new Appearance(this.storeTheme, null);
                    $jacocoInit[30] = true;
                    store4.setAppearance(appearance4);
                    $jacocoInit[31] = true;
                    displayables.add(new GridAppDisplayable(app4, this.tag, this.navigationTracker, this.storeContext));
                    $jacocoInit[32] = true;
                }
                $jacocoInit[28] = true;
            }
        }
        addDisplayables(displayables);
        $jacocoInit[33] = true;
    }
}
