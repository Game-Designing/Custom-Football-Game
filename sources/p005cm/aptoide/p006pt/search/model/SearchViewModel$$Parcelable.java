package p005cm.aptoide.p006pt.search.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.parceler.C14432a;
import org.parceler.C14448c;
import org.parceler.C14474z;
import org.parceler.ParcelerRuntimeException;

/* renamed from: cm.aptoide.pt.search.model.SearchViewModel$$Parcelable */
public class SearchViewModel$$Parcelable implements Parcelable, C14474z<SearchViewModel> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    public static final Creator<SearchViewModel$$Parcelable> CREATOR = new Creator<SearchViewModel$$Parcelable>() {
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-2919675007268553136L, "cm/aptoide/pt/search/model/SearchViewModel$$Parcelable$1", 5);
            $jacocoData = probes;
            return probes;
        }

        {
            $jacocoInit()[0] = true;
        }

        public SearchViewModel$$Parcelable createFromParcel(Parcel parcel$$2) {
            boolean[] $jacocoInit = $jacocoInit();
            SearchViewModel$$Parcelable searchViewModel$$Parcelable = new SearchViewModel$$Parcelable(SearchViewModel$$Parcelable.read(parcel$$2, new C14432a()));
            $jacocoInit[1] = true;
            return searchViewModel$$Parcelable;
        }

        public SearchViewModel$$Parcelable[] newArray(int size) {
            SearchViewModel$$Parcelable[] searchViewModel$$ParcelableArr = new SearchViewModel$$Parcelable[size];
            $jacocoInit()[2] = true;
            return searchViewModel$$ParcelableArr;
        }
    };
    private SearchViewModel searchViewModel$$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7099293484709267516L, "cm/aptoide/pt/search/model/SearchViewModel$$Parcelable", 112);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[111] = true;
    }

    public SearchViewModel$$Parcelable(SearchViewModel searchViewModel$$2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.searchViewModel$$0 = searchViewModel$$2;
        $jacocoInit[0] = true;
    }

    public void writeToParcel(Parcel parcel$$0, int flags) {
        boolean[] $jacocoInit = $jacocoInit();
        write(this.searchViewModel$$0, parcel$$0, flags, new C14432a());
        $jacocoInit[1] = true;
    }

    public static void write(SearchViewModel searchViewModel$$1, Parcel parcel$$1, int flags$$0, C14432a identityMap$$0) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean[] $jacocoInit = $jacocoInit();
        int identity$$0 = identityMap$$0.mo45528a((Object) searchViewModel$$1);
        if (identity$$0 != -1) {
            $jacocoInit[2] = true;
            parcel$$1.writeInt(identity$$0);
            $jacocoInit[3] = true;
        } else {
            parcel$$1.writeInt(identityMap$$0.mo45531b((Object) searchViewModel$$1));
            $jacocoInit[4] = true;
            parcel$$1.writeInt(searchViewModel$$1.allStoresOffset);
            $jacocoInit[5] = true;
            parcel$$1.writeString(searchViewModel$$1.currentQuery);
            $jacocoInit[6] = true;
            int i5 = 0;
            if (searchViewModel$$1.loadedAds) {
                $jacocoInit[7] = true;
                i = 1;
            } else {
                $jacocoInit[8] = true;
                i = 0;
            }
            parcel$$1.writeInt(i);
            List<SearchAdResult> list = searchViewModel$$1.followedStoresSearchAdResults;
            if (list == null) {
                $jacocoInit[9] = true;
                parcel$$1.writeInt(-1);
                $jacocoInit[10] = true;
            } else {
                parcel$$1.writeInt(list.size());
                $jacocoInit[11] = true;
                $jacocoInit[12] = true;
                for (SearchAdResult searchAdResult$$0 : searchViewModel$$1.followedStoresSearchAdResults) {
                    $jacocoInit[14] = true;
                    SearchAdResult$$Parcelable.write(searchAdResult$$0, parcel$$1, flags$$0, identityMap$$0);
                    $jacocoInit[15] = true;
                }
                $jacocoInit[13] = true;
            }
            if (searchViewModel$$1.reachedBottomAllStores) {
                $jacocoInit[16] = true;
                i2 = 1;
            } else {
                $jacocoInit[17] = true;
                i2 = 0;
            }
            parcel$$1.writeInt(i2);
            List<SearchAppResult> list2 = searchViewModel$$1.followedStoresSearchAppResults;
            if (list2 == null) {
                $jacocoInit[18] = true;
                parcel$$1.writeInt(-1);
                $jacocoInit[19] = true;
            } else {
                parcel$$1.writeInt(list2.size());
                $jacocoInit[20] = true;
                $jacocoInit[21] = true;
                for (SearchAppResult searchAppResult$$0 : searchViewModel$$1.followedStoresSearchAppResults) {
                    $jacocoInit[23] = true;
                    SearchAppResult$$Parcelable.write(searchAppResult$$0, parcel$$1, flags$$0, identityMap$$0);
                    $jacocoInit[24] = true;
                }
                $jacocoInit[22] = true;
            }
            if (searchViewModel$$1.reachedBottomFollowedStores) {
                $jacocoInit[25] = true;
                i3 = 1;
            } else {
                $jacocoInit[26] = true;
                i3 = 0;
            }
            parcel$$1.writeInt(i3);
            $jacocoInit[27] = true;
            parcel$$1.writeString(searchViewModel$$1.storeName);
            $jacocoInit[28] = true;
            if (searchViewModel$$1.onlyTrustedApps) {
                $jacocoInit[29] = true;
                i4 = 1;
            } else {
                $jacocoInit[30] = true;
                i4 = 0;
            }
            parcel$$1.writeInt(i4);
            $jacocoInit[31] = true;
            parcel$$1.writeString((String) C14448c.m46062a(String.class, SearchViewModel.class, (Object) searchViewModel$$1, "storeTheme"));
            $jacocoInit[32] = true;
            if (searchViewModel$$1.allStoresSelected) {
                $jacocoInit[33] = true;
                i5 = 1;
            } else {
                $jacocoInit[34] = true;
            }
            parcel$$1.writeInt(i5);
            List<SearchAdResult> list3 = searchViewModel$$1.allStoresSearchAdResults;
            if (list3 == null) {
                $jacocoInit[35] = true;
                parcel$$1.writeInt(-1);
                $jacocoInit[36] = true;
            } else {
                parcel$$1.writeInt(list3.size());
                $jacocoInit[37] = true;
                $jacocoInit[38] = true;
                for (SearchAdResult searchAdResult$$1 : searchViewModel$$1.allStoresSearchAdResults) {
                    $jacocoInit[40] = true;
                    SearchAdResult$$Parcelable.write(searchAdResult$$1, parcel$$1, flags$$0, identityMap$$0);
                    $jacocoInit[41] = true;
                }
                $jacocoInit[39] = true;
            }
            List<SearchAppResult> list4 = searchViewModel$$1.allStoresSearchAppResults;
            if (list4 == null) {
                $jacocoInit[42] = true;
                parcel$$1.writeInt(-1);
                $jacocoInit[43] = true;
            } else {
                parcel$$1.writeInt(list4.size());
                $jacocoInit[44] = true;
                $jacocoInit[45] = true;
                for (SearchAppResult searchAppResult$$1 : searchViewModel$$1.allStoresSearchAppResults) {
                    $jacocoInit[47] = true;
                    SearchAppResult$$Parcelable.write(searchAppResult$$1, parcel$$1, flags$$0, identityMap$$0);
                    $jacocoInit[48] = true;
                }
                $jacocoInit[46] = true;
            }
            parcel$$1.writeInt(searchViewModel$$1.followedStoresOffset);
            $jacocoInit[49] = true;
        }
        $jacocoInit[50] = true;
    }

    public int describeContents() {
        $jacocoInit()[51] = true;
        return 0;
    }

    public SearchViewModel getParcel() {
        boolean[] $jacocoInit = $jacocoInit();
        SearchViewModel searchViewModel = this.searchViewModel$$0;
        $jacocoInit[52] = true;
        return searchViewModel;
    }

    public static SearchViewModel read(Parcel parcel$$3, C14432a identityMap$$1) {
        boolean z;
        ArrayList arrayList;
        boolean z2;
        ArrayList arrayList2;
        boolean z3;
        boolean z4;
        ArrayList arrayList3;
        ArrayList arrayList4;
        C14432a aVar = identityMap$$1;
        boolean[] $jacocoInit = $jacocoInit();
        int identity$$1 = parcel$$3.readInt();
        $jacocoInit[53] = true;
        if (aVar.mo45530a(identity$$1)) {
            $jacocoInit[54] = true;
            if (!aVar.mo45533c(identity$$1)) {
                SearchViewModel searchViewModel = (SearchViewModel) aVar.mo45532b(identity$$1);
                $jacocoInit[57] = true;
                return searchViewModel;
            }
            $jacocoInit[55] = true;
            ParcelerRuntimeException parcelerRuntimeException = new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            $jacocoInit[56] = true;
            throw parcelerRuntimeException;
        }
        int reservation$$0 = identityMap$$1.mo45527a();
        $jacocoInit[58] = true;
        SearchViewModel searchViewModel$$4 = new SearchViewModel();
        $jacocoInit[59] = true;
        aVar.mo45529a(reservation$$0, searchViewModel$$4);
        $jacocoInit[60] = true;
        searchViewModel$$4.allStoresOffset = parcel$$3.readInt();
        $jacocoInit[61] = true;
        searchViewModel$$4.currentQuery = parcel$$3.readString();
        $jacocoInit[62] = true;
        boolean z5 = false;
        if (parcel$$3.readInt() == 1) {
            $jacocoInit[63] = true;
            z = true;
        } else {
            $jacocoInit[64] = true;
            z = false;
        }
        searchViewModel$$4.loadedAds = z;
        $jacocoInit[65] = true;
        int int$$0 = parcel$$3.readInt();
        if (int$$0 < 0) {
            $jacocoInit[66] = true;
            arrayList = null;
        } else {
            ArrayList<SearchAdResult> list$$0 = new ArrayList<>(int$$0);
            int int$$1 = 0;
            $jacocoInit[67] = true;
            while (int$$1 < int$$0) {
                $jacocoInit[69] = true;
                SearchAdResult searchAdResult$$2 = SearchAdResult$$Parcelable.read(parcel$$3, identityMap$$1);
                $jacocoInit[70] = true;
                list$$0.add(searchAdResult$$2);
                int$$1++;
                $jacocoInit[71] = true;
            }
            $jacocoInit[68] = true;
            arrayList = list$$0;
        }
        searchViewModel$$4.followedStoresSearchAdResults = arrayList;
        $jacocoInit[72] = true;
        if (parcel$$3.readInt() == 1) {
            $jacocoInit[73] = true;
            z2 = true;
        } else {
            $jacocoInit[74] = true;
            z2 = false;
        }
        searchViewModel$$4.reachedBottomAllStores = z2;
        $jacocoInit[75] = true;
        int int$$2 = parcel$$3.readInt();
        if (int$$2 < 0) {
            $jacocoInit[76] = true;
            arrayList2 = null;
        } else {
            ArrayList arrayList5 = new ArrayList(int$$2);
            int int$$3 = 0;
            $jacocoInit[77] = true;
            while (int$$3 < int$$2) {
                $jacocoInit[79] = true;
                SearchAppResult searchAppResult$$2 = SearchAppResult$$Parcelable.read(parcel$$3, identityMap$$1);
                $jacocoInit[80] = true;
                arrayList5.add(searchAppResult$$2);
                int$$3++;
                $jacocoInit[81] = true;
            }
            $jacocoInit[78] = true;
            arrayList2 = arrayList5;
        }
        searchViewModel$$4.followedStoresSearchAppResults = arrayList2;
        $jacocoInit[82] = true;
        if (parcel$$3.readInt() == 1) {
            $jacocoInit[83] = true;
            z3 = true;
        } else {
            $jacocoInit[84] = true;
            z3 = false;
        }
        searchViewModel$$4.reachedBottomFollowedStores = z3;
        $jacocoInit[85] = true;
        searchViewModel$$4.storeName = parcel$$3.readString();
        $jacocoInit[86] = true;
        if (parcel$$3.readInt() == 1) {
            $jacocoInit[87] = true;
            z4 = true;
        } else {
            $jacocoInit[88] = true;
            z4 = false;
        }
        searchViewModel$$4.onlyTrustedApps = z4;
        $jacocoInit[89] = true;
        C14448c.m46063a(SearchViewModel.class, (Object) searchViewModel$$4, "storeTheme", (Object) parcel$$3.readString());
        $jacocoInit[90] = true;
        if (parcel$$3.readInt() == 1) {
            $jacocoInit[91] = true;
            z5 = true;
        } else {
            $jacocoInit[92] = true;
        }
        searchViewModel$$4.allStoresSelected = z5;
        $jacocoInit[93] = true;
        int int$$4 = parcel$$3.readInt();
        if (int$$4 < 0) {
            $jacocoInit[94] = true;
            arrayList3 = null;
        } else {
            ArrayList arrayList6 = new ArrayList(int$$4);
            int int$$5 = 0;
            $jacocoInit[95] = true;
            while (int$$5 < int$$4) {
                $jacocoInit[97] = true;
                SearchAdResult searchAdResult$$3 = SearchAdResult$$Parcelable.read(parcel$$3, identityMap$$1);
                $jacocoInit[98] = true;
                arrayList6.add(searchAdResult$$3);
                int$$5++;
                $jacocoInit[99] = true;
            }
            $jacocoInit[96] = true;
            arrayList3 = arrayList6;
        }
        searchViewModel$$4.allStoresSearchAdResults = arrayList3;
        $jacocoInit[100] = true;
        int int$$6 = parcel$$3.readInt();
        if (int$$6 < 0) {
            $jacocoInit[101] = true;
            arrayList4 = null;
        } else {
            arrayList4 = new ArrayList(int$$6);
            int int$$7 = 0;
            $jacocoInit[102] = true;
            while (int$$7 < int$$6) {
                $jacocoInit[104] = true;
                SearchAppResult searchAppResult$$3 = SearchAppResult$$Parcelable.read(parcel$$3, identityMap$$1);
                $jacocoInit[105] = true;
                arrayList4.add(searchAppResult$$3);
                int$$7++;
                $jacocoInit[106] = true;
            }
            $jacocoInit[103] = true;
        }
        searchViewModel$$4.allStoresSearchAppResults = arrayList4;
        $jacocoInit[107] = true;
        searchViewModel$$4.followedStoresOffset = parcel$$3.readInt();
        $jacocoInit[108] = true;
        SearchViewModel searchViewModel$$3 = searchViewModel$$4;
        aVar.mo45529a(identity$$1, searchViewModel$$3);
        $jacocoInit[109] = true;
        return searchViewModel$$3;
    }
}
