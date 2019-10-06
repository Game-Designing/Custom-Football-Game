package p005cm.aptoide.p006pt.bottomNavigation;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;

/* renamed from: cm.aptoide.pt.bottomNavigation.BottomNavigationMapper */
public class BottomNavigationMapper {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final int APPS_POSITION = 4;
    static final int CURATION_POSITION = 1;
    static final int HOME_POSITION = 0;
    static final int SEARCH_POSITION = 2;
    static final int STORES_POSITION = 3;

    /* renamed from: cm.aptoide.pt.bottomNavigation.BottomNavigationMapper$1 */
    static /* synthetic */ class C26471 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$bottomNavigation$BottomNavigationItem = new int[BottomNavigationItem.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-7338388382062555970L, "cm/aptoide/pt/bottomNavigation/BottomNavigationMapper$1", 12);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$bottomNavigation$BottomNavigationItem[BottomNavigationItem.HOME.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        try {
                            $jacocoInit[6] = true;
                        } catch (NoSuchFieldError e4) {
                            try {
                                $jacocoInit[8] = true;
                            } catch (NoSuchFieldError e5) {
                                $jacocoInit[10] = true;
                            }
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$bottomNavigation$BottomNavigationItem[BottomNavigationItem.CURATION.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$cm$aptoide$pt$bottomNavigation$BottomNavigationItem[BottomNavigationItem.SEARCH.ordinal()] = 3;
            $jacocoInit[5] = true;
            $SwitchMap$cm$aptoide$pt$bottomNavigation$BottomNavigationItem[BottomNavigationItem.STORES.ordinal()] = 4;
            $jacocoInit[7] = true;
            $SwitchMap$cm$aptoide$pt$bottomNavigation$BottomNavigationItem[BottomNavigationItem.APPS.ordinal()] = 5;
            $jacocoInit[9] = true;
            $jacocoInit[11] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5467747383226786141L, "cm/aptoide/pt/bottomNavigation/BottomNavigationMapper", 22);
        $jacocoData = probes;
        return probes;
    }

    public BottomNavigationMapper() {
        $jacocoInit()[0] = true;
    }

    public BottomNavigationItem mapItemClicked(Integer menuItemId) {
        BottomNavigationItem bottomNavigationItem;
        boolean[] $jacocoInit = $jacocoInit();
        switch (menuItemId.intValue()) {
            case C1375R.C1376id.action_apps /*2131296271*/:
                bottomNavigationItem = BottomNavigationItem.APPS;
                $jacocoInit[5] = true;
                break;
            case C1375R.C1376id.action_curation /*2131296283*/:
                bottomNavigationItem = BottomNavigationItem.CURATION;
                $jacocoInit[2] = true;
                break;
            case C1375R.C1376id.action_home /*2131296285*/:
                bottomNavigationItem = BottomNavigationItem.HOME;
                $jacocoInit[1] = true;
                break;
            case C1375R.C1376id.action_search /*2131296294*/:
                bottomNavigationItem = BottomNavigationItem.SEARCH;
                $jacocoInit[3] = true;
                break;
            case C1375R.C1376id.action_stores /*2131296295*/:
                bottomNavigationItem = BottomNavigationItem.STORES;
                $jacocoInit[4] = true;
                break;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("The selected menuItem is not supported");
                $jacocoInit[6] = true;
                throw illegalStateException;
        }
        $jacocoInit[7] = true;
        return bottomNavigationItem;
    }

    public int mapToBottomNavigationPosition(BottomNavigationItem bottomNavigationItem) {
        int bottomNavigationPosition;
        boolean[] $jacocoInit = $jacocoInit();
        int i = C26471.$SwitchMap$cm$aptoide$pt$bottomNavigation$BottomNavigationItem[bottomNavigationItem.ordinal()];
        if (i == 1) {
            bottomNavigationPosition = 0;
            $jacocoInit[8] = true;
        } else if (i == 2) {
            bottomNavigationPosition = 1;
            $jacocoInit[9] = true;
        } else if (i == 3) {
            bottomNavigationPosition = 2;
            $jacocoInit[10] = true;
        } else if (i == 4) {
            bottomNavigationPosition = 3;
            $jacocoInit[11] = true;
        } else if (i == 5) {
            bottomNavigationPosition = 4;
            $jacocoInit[12] = true;
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("The selected bottomNavigationItem is not supported");
            $jacocoInit[13] = true;
            throw illegalStateException;
        }
        $jacocoInit[14] = true;
        return bottomNavigationPosition;
    }

    public int mapToBottomNavigationPosition(Integer menuItemId) {
        int bottomNavigationPosition;
        boolean[] $jacocoInit = $jacocoInit();
        switch (menuItemId.intValue()) {
            case C1375R.C1376id.action_apps /*2131296271*/:
                bottomNavigationPosition = 4;
                $jacocoInit[19] = true;
                break;
            case C1375R.C1376id.action_curation /*2131296283*/:
                bottomNavigationPosition = 1;
                $jacocoInit[16] = true;
                break;
            case C1375R.C1376id.action_home /*2131296285*/:
                bottomNavigationPosition = 0;
                $jacocoInit[15] = true;
                break;
            case C1375R.C1376id.action_search /*2131296294*/:
                bottomNavigationPosition = 2;
                $jacocoInit[17] = true;
                break;
            case C1375R.C1376id.action_stores /*2131296295*/:
                bottomNavigationPosition = 3;
                $jacocoInit[18] = true;
                break;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("The selected menuItem is not supported");
                $jacocoInit[20] = true;
                throw illegalStateException;
        }
        $jacocoInit[21] = true;
        return bottomNavigationPosition;
    }
}
