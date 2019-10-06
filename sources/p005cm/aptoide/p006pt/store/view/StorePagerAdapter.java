package p005cm.aptoide.p006pt.store.view;

import android.content.Context;
import android.os.Bundle;
import android.support.p000v4.app.C0423F;
import android.support.p000v4.app.C0486t;
import android.support.p000v4.app.Fragment;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.NavigationTrackerPagerAdapterHelper;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event.Name;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event.Type;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreTabs.Tab;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.view.FragmentProvider;
import p005cm.aptoide.p006pt.view.Translator;
import p005cm.aptoide.p006pt.view.fragment.NavigationTrackFragment;

/* renamed from: cm.aptoide.pt.store.view.StorePagerAdapter */
public class StorePagerAdapter extends C0423F implements NavigationTrackerPagerAdapterHelper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final EnumMap<Name, Integer> availableEventsMap = new EnumMap<>(Name.class);
    private Context context;
    private final String marketName;
    private final StoreContext storeContext;
    private Long storeId;
    private String storeTheme;
    private final List<Tab> tabs;

    /* renamed from: cm.aptoide.pt.store.view.StorePagerAdapter$1 */
    static /* synthetic */ class C49701 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Event$Name = new int[Name.values().length];
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Event$Type = new int[Type.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-2487734614100316286L, "cm/aptoide/pt/store/view/StorePagerAdapter$1", 13);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Event$Name[Name.myStores.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    $jacocoInit[4] = true;
                }
            }
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Event$Name[Name.getReviews.ordinal()] = 2;
            $jacocoInit[3] = true;
            try {
                $jacocoInit[5] = true;
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Event$Type[Type.API.ordinal()] = 1;
                $jacocoInit[6] = true;
            } catch (NoSuchFieldError e3) {
                try {
                    $jacocoInit[7] = true;
                } catch (NoSuchFieldError e4) {
                    try {
                        $jacocoInit[9] = true;
                    } catch (NoSuchFieldError e5) {
                        $jacocoInit[11] = true;
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Event$Type[Type.CLIENT.ordinal()] = 2;
            $jacocoInit[8] = true;
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Event$Type[Type.v3.ordinal()] = 3;
            $jacocoInit[10] = true;
            $jacocoInit[12] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6710923614845782288L, "cm/aptoide/pt/store/view/StorePagerAdapter", 68);
        $jacocoData = probes;
        return probes;
    }

    public StorePagerAdapter(C0486t fm, List<Tab> tabs2, StoreContext storeContext2, Long storeId2, String storeTheme2, Context context2, String marketName2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(fm);
        $jacocoInit[0] = true;
        this.storeId = storeId2;
        $jacocoInit[1] = true;
        if (storeId2 == null) {
            $jacocoInit[2] = true;
        } else if (storeId2.longValue() == 15) {
            $jacocoInit[3] = true;
        } else {
            this.storeTheme = storeTheme2;
            $jacocoInit[4] = true;
        }
        this.tabs = tabs2;
        this.storeContext = storeContext2;
        this.context = context2;
        this.marketName = marketName2;
        $jacocoInit[5] = true;
        translateTabs(this.tabs);
        $jacocoInit[6] = true;
        validateGetStore();
        $jacocoInit[7] = true;
        fillAvailableEventsMap(tabs2);
        $jacocoInit[8] = true;
    }

    private void translateTabs(List<Tab> tabs2) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[9] = true;
        for (Tab t : tabs2) {
            $jacocoInit[10] = true;
            t.setLabel(Translator.translate(t.getLabel(), this.context, this.marketName));
            $jacocoInit[11] = true;
        }
        $jacocoInit[12] = true;
    }

    private void validateGetStore() {
        boolean[] $jacocoInit = $jacocoInit();
        Iterator<Tab> iterator = this.tabs.iterator();
        $jacocoInit[13] = true;
        while (iterator.hasNext()) {
            $jacocoInit[14] = true;
            Tab next = (Tab) iterator.next();
            $jacocoInit[15] = true;
            Event event = next.getEvent();
            $jacocoInit[16] = true;
            if (event.getName() == null) {
                $jacocoInit[17] = true;
            } else {
                $jacocoInit[18] = true;
                Event event2 = next.getEvent();
                $jacocoInit[19] = true;
                if (event2.getType() != null) {
                    $jacocoInit[20] = true;
                    $jacocoInit[23] = true;
                } else {
                    $jacocoInit[21] = true;
                }
            }
            iterator.remove();
            $jacocoInit[22] = true;
            $jacocoInit[23] = true;
        }
        $jacocoInit[24] = true;
    }

    private void fillAvailableEventsMap(List<Tab> list) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = 0;
        $jacocoInit[25] = true;
        while (i < list.size()) {
            $jacocoInit[26] = true;
            Tab tab = (Tab) list.get(i);
            $jacocoInit[27] = true;
            Event event = tab.getEvent();
            $jacocoInit[28] = true;
            if (containsEventName(event.getName())) {
                $jacocoInit[29] = true;
            } else {
                $jacocoInit[30] = true;
                this.availableEventsMap.put(event.getName(), Integer.valueOf(i));
                $jacocoInit[31] = true;
            }
            i++;
            $jacocoInit[32] = true;
        }
        $jacocoInit[33] = true;
    }

    public boolean containsEventName(Name name) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean containsKey = this.availableEventsMap.containsKey(name);
        $jacocoInit[34] = true;
        return containsKey;
    }

    public Fragment getItem(int position) {
        Fragment fragment;
        boolean[] $jacocoInit = $jacocoInit();
        Tab tab = (Tab) this.tabs.get(position);
        $jacocoInit[35] = true;
        Event event = tab.getEvent();
        $jacocoInit[36] = true;
        int i = C49701.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Event$Type[event.getType().ordinal()];
        if (i == 1) {
            fragment = caseAPI(tab, isHomeFragment(position));
            $jacocoInit[37] = true;
        } else if (i == 2) {
            fragment = caseClient(event, tab);
            $jacocoInit[38] = true;
        } else if (i == 3) {
            fragment = caseV3(event);
            $jacocoInit[39] = true;
        } else {
            RuntimeException runtimeException = new RuntimeException("Fragment type not implemented!");
            $jacocoInit[40] = true;
            throw runtimeException;
        }
        Fragment fragment2 = setFragmentLogFlag(fragment);
        $jacocoInit[41] = true;
        return fragment2;
    }

    private boolean isHomeFragment(int position) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (position == 0) {
            $jacocoInit[42] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[43] = true;
        }
        $jacocoInit[44] = true;
        return z;
    }

    private Fragment caseAPI(Tab tab, boolean addAdultFilter) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentProvider fragmentProvider = AptoideApplication.getFragmentProvider();
        $jacocoInit[45] = true;
        Fragment newStoreTabGridRecyclerFragment = fragmentProvider.newStoreTabGridRecyclerFragment(tab.getEvent(), this.storeTheme, tab.getTag(), this.storeContext, addAdultFilter);
        $jacocoInit[46] = true;
        return newStoreTabGridRecyclerFragment;
    }

    private Fragment caseClient(Event event, Tab tab) {
        boolean[] $jacocoInit = $jacocoInit();
        if (C49701.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Event$Name[event.getName().ordinal()] == 1) {
            FragmentProvider fragmentProvider = AptoideApplication.getFragmentProvider();
            String str = this.storeTheme;
            $jacocoInit[47] = true;
            Fragment newSubscribedStoresFragment = fragmentProvider.newSubscribedStoresFragment(event, str, tab.getTag(), this.storeContext);
            $jacocoInit[48] = true;
            return newSubscribedStoresFragment;
        }
        RuntimeException runtimeException = new RuntimeException("Fragment type not implemented!");
        $jacocoInit[49] = true;
        throw runtimeException;
    }

    private Fragment caseV3(Event event) {
        boolean[] $jacocoInit = $jacocoInit();
        if (C49701.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Event$Name[event.getName().ordinal()] == 2) {
            FragmentProvider fragmentProvider = AptoideApplication.getFragmentProvider();
            Long l = this.storeId;
            $jacocoInit[50] = true;
            Fragment newLatestReviewsFragment = fragmentProvider.newLatestReviewsFragment(l.longValue(), this.storeContext);
            $jacocoInit[51] = true;
            return newLatestReviewsFragment;
        }
        RuntimeException runtimeException = new RuntimeException("Fragment type not implemented!");
        $jacocoInit[52] = true;
        throw runtimeException;
    }

    public int getEventNamePosition(Name name) {
        boolean[] $jacocoInit = $jacocoInit();
        Integer integer = (Integer) this.availableEventsMap.get(name);
        if (integer == null) {
            $jacocoInit[53] = true;
            return -1;
        }
        int intValue = integer.intValue();
        $jacocoInit[54] = true;
        return intValue;
    }

    public int getCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int size = this.tabs.size();
        $jacocoInit[55] = true;
        return size;
    }

    public CharSequence getPageTitle(int position) {
        boolean[] $jacocoInit = $jacocoInit();
        Tab tab = (Tab) this.tabs.get(position);
        $jacocoInit[56] = true;
        String label = tab.getLabel();
        $jacocoInit[57] = true;
        return label;
    }

    private Fragment setFragmentLogFlag(Fragment fragment) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = fragment.getArguments();
        if (bundle != null) {
            $jacocoInit[58] = true;
        } else {
            $jacocoInit[59] = true;
            bundle = new Bundle();
            $jacocoInit[60] = true;
        }
        bundle.putBoolean(NavigationTrackFragment.SHOULD_REGISTER_VIEW, false);
        $jacocoInit[61] = true;
        fragment.setArguments(bundle);
        $jacocoInit[62] = true;
        return fragment;
    }

    public String getItemName(int position) {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getItem(position).getClass();
        $jacocoInit[63] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[64] = true;
        return simpleName;
    }

    public String getItemTag(int position) {
        boolean[] $jacocoInit = $jacocoInit();
        Tab tab = (Tab) this.tabs.get(position);
        $jacocoInit[65] = true;
        String label = tab.getLabel();
        $jacocoInit[66] = true;
        return label;
    }

    public StoreContext getItemStore() {
        boolean[] $jacocoInit = $jacocoInit();
        StoreContext storeContext2 = this.storeContext;
        $jacocoInit[67] = true;
        return storeContext2;
    }
}
