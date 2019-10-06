package p005cm.aptoide.p006pt.search.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.parceler.C14432a;
import org.parceler.C14448c;
import org.parceler.C14474z;
import org.parceler.ParcelerRuntimeException;

/* renamed from: cm.aptoide.pt.search.model.SearchAppResultWrapper$$Parcelable */
public class SearchAppResultWrapper$$Parcelable implements Parcelable, C14474z<SearchAppResultWrapper> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    public static final Creator<SearchAppResultWrapper$$Parcelable> CREATOR = new Creator<SearchAppResultWrapper$$Parcelable>() {
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(6501694437885326328L, "cm/aptoide/pt/search/model/SearchAppResultWrapper$$Parcelable$1", 5);
            $jacocoData = probes;
            return probes;
        }

        {
            $jacocoInit()[0] = true;
        }

        public SearchAppResultWrapper$$Parcelable createFromParcel(Parcel parcel$$2) {
            boolean[] $jacocoInit = $jacocoInit();
            SearchAppResultWrapper$$Parcelable searchAppResultWrapper$$Parcelable = new SearchAppResultWrapper$$Parcelable(SearchAppResultWrapper$$Parcelable.read(parcel$$2, new C14432a()));
            $jacocoInit[1] = true;
            return searchAppResultWrapper$$Parcelable;
        }

        public SearchAppResultWrapper$$Parcelable[] newArray(int size) {
            SearchAppResultWrapper$$Parcelable[] searchAppResultWrapper$$ParcelableArr = new SearchAppResultWrapper$$Parcelable[size];
            $jacocoInit()[2] = true;
            return searchAppResultWrapper$$ParcelableArr;
        }
    };
    private SearchAppResultWrapper searchAppResultWrapper$$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3921497337677288002L, "cm/aptoide/pt/search/model/SearchAppResultWrapper$$Parcelable", 26);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[25] = true;
    }

    public SearchAppResultWrapper$$Parcelable(SearchAppResultWrapper searchAppResultWrapper$$2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.searchAppResultWrapper$$0 = searchAppResultWrapper$$2;
        $jacocoInit[0] = true;
    }

    public void writeToParcel(Parcel parcel$$0, int flags) {
        boolean[] $jacocoInit = $jacocoInit();
        write(this.searchAppResultWrapper$$0, parcel$$0, flags, new C14432a());
        $jacocoInit[1] = true;
    }

    public static void write(SearchAppResultWrapper searchAppResultWrapper$$1, Parcel parcel$$1, int flags$$0, C14432a identityMap$$0) {
        boolean[] $jacocoInit = $jacocoInit();
        int identity$$0 = identityMap$$0.mo45528a((Object) searchAppResultWrapper$$1);
        if (identity$$0 != -1) {
            $jacocoInit[2] = true;
            parcel$$1.writeInt(identity$$0);
            $jacocoInit[3] = true;
        } else {
            parcel$$1.writeInt(identityMap$$0.mo45531b((Object) searchAppResultWrapper$$1));
            $jacocoInit[4] = true;
            parcel$$1.writeString((String) C14448c.m46062a(String.class, SearchAppResultWrapper.class, (Object) searchAppResultWrapper$$1, "query"));
            $jacocoInit[5] = true;
            parcel$$1.writeInt(((Integer) C14448c.m46062a(Integer.TYPE, SearchAppResultWrapper.class, (Object) searchAppResultWrapper$$1, "position")).intValue());
            $jacocoInit[6] = true;
            SearchAppResult$$Parcelable.write((SearchAppResult) C14448c.m46062a(SearchAppResult.class, SearchAppResultWrapper.class, (Object) searchAppResultWrapper$$1, "searchAppResult"), parcel$$1, flags$$0, identityMap$$0);
            $jacocoInit[7] = true;
        }
        $jacocoInit[8] = true;
    }

    public int describeContents() {
        $jacocoInit()[9] = true;
        return 0;
    }

    public SearchAppResultWrapper getParcel() {
        boolean[] $jacocoInit = $jacocoInit();
        SearchAppResultWrapper searchAppResultWrapper = this.searchAppResultWrapper$$0;
        $jacocoInit[10] = true;
        return searchAppResultWrapper;
    }

    public static SearchAppResultWrapper read(Parcel parcel$$3, C14432a identityMap$$1) {
        boolean[] $jacocoInit = $jacocoInit();
        int identity$$1 = parcel$$3.readInt();
        $jacocoInit[11] = true;
        if (identityMap$$1.mo45530a(identity$$1)) {
            $jacocoInit[12] = true;
            if (!identityMap$$1.mo45533c(identity$$1)) {
                SearchAppResultWrapper searchAppResultWrapper = (SearchAppResultWrapper) identityMap$$1.mo45532b(identity$$1);
                $jacocoInit[15] = true;
                return searchAppResultWrapper;
            }
            $jacocoInit[13] = true;
            ParcelerRuntimeException parcelerRuntimeException = new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            $jacocoInit[14] = true;
            throw parcelerRuntimeException;
        }
        int reservation$$0 = identityMap$$1.mo45527a();
        $jacocoInit[16] = true;
        SearchAppResultWrapper searchAppResultWrapper$$4 = new SearchAppResultWrapper();
        $jacocoInit[17] = true;
        identityMap$$1.mo45529a(reservation$$0, searchAppResultWrapper$$4);
        $jacocoInit[18] = true;
        C14448c.m46063a(SearchAppResultWrapper.class, (Object) searchAppResultWrapper$$4, "query", (Object) parcel$$3.readString());
        $jacocoInit[19] = true;
        C14448c.m46063a(SearchAppResultWrapper.class, (Object) searchAppResultWrapper$$4, "position", (Object) Integer.valueOf(parcel$$3.readInt()));
        $jacocoInit[20] = true;
        SearchAppResult searchAppResult$$0 = SearchAppResult$$Parcelable.read(parcel$$3, identityMap$$1);
        $jacocoInit[21] = true;
        C14448c.m46063a(SearchAppResultWrapper.class, (Object) searchAppResultWrapper$$4, "searchAppResult", (Object) searchAppResult$$0);
        $jacocoInit[22] = true;
        SearchAppResultWrapper searchAppResultWrapper$$3 = searchAppResultWrapper$$4;
        identityMap$$1.mo45529a(identity$$1, searchAppResultWrapper$$3);
        $jacocoInit[23] = true;
        return searchAppResultWrapper$$3;
    }
}
