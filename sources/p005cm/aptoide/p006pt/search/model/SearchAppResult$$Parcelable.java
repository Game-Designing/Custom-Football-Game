package p005cm.aptoide.p006pt.search.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.parceler.C14432a;
import org.parceler.C14448c;
import org.parceler.C14474z;
import org.parceler.ParcelerRuntimeException;

/* renamed from: cm.aptoide.pt.search.model.SearchAppResult$$Parcelable */
public class SearchAppResult$$Parcelable implements Parcelable, C14474z<SearchAppResult> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    public static final Creator<SearchAppResult$$Parcelable> CREATOR = new Creator<SearchAppResult$$Parcelable>() {
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(3464281679959486127L, "cm/aptoide/pt/search/model/SearchAppResult$$Parcelable$1", 5);
            $jacocoData = probes;
            return probes;
        }

        {
            $jacocoInit()[0] = true;
        }

        public SearchAppResult$$Parcelable createFromParcel(Parcel parcel$$2) {
            boolean[] $jacocoInit = $jacocoInit();
            SearchAppResult$$Parcelable searchAppResult$$Parcelable = new SearchAppResult$$Parcelable(SearchAppResult$$Parcelable.read(parcel$$2, new C14432a()));
            $jacocoInit[1] = true;
            return searchAppResult$$Parcelable;
        }

        public SearchAppResult$$Parcelable[] newArray(int size) {
            SearchAppResult$$Parcelable[] searchAppResult$$ParcelableArr = new SearchAppResult$$Parcelable[size];
            $jacocoInit()[2] = true;
            return searchAppResult$$ParcelableArr;
        }
    };
    private SearchAppResult searchAppResult$$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7654852532862519842L, "cm/aptoide/pt/search/model/SearchAppResult$$Parcelable", 57);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[56] = true;
    }

    public SearchAppResult$$Parcelable(SearchAppResult searchAppResult$$2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.searchAppResult$$0 = searchAppResult$$2;
        $jacocoInit[0] = true;
    }

    public void writeToParcel(Parcel parcel$$0, int flags) {
        boolean[] $jacocoInit = $jacocoInit();
        write(this.searchAppResult$$0, parcel$$0, flags, new C14432a());
        $jacocoInit[1] = true;
    }

    public static void write(SearchAppResult searchAppResult$$1, Parcel parcel$$1, int flags$$0, C14432a identityMap$$0) {
        int i;
        int i2;
        boolean[] $jacocoInit = $jacocoInit();
        int identity$$0 = identityMap$$0.mo45528a((Object) searchAppResult$$1);
        if (identity$$0 != -1) {
            $jacocoInit[2] = true;
            parcel$$1.writeInt(identity$$0);
            $jacocoInit[3] = true;
        } else {
            parcel$$1.writeInt(identityMap$$0.mo45531b((Object) searchAppResult$$1));
            $jacocoInit[4] = true;
            int i3 = 0;
            if (((Boolean) C14448c.m46062a(Boolean.TYPE, SearchAppResult.class, (Object) searchAppResult$$1, "appcBilling")).booleanValue()) {
                $jacocoInit[5] = true;
                i = 1;
            } else {
                $jacocoInit[6] = true;
                i = 0;
            }
            parcel$$1.writeInt(i);
            $jacocoInit[7] = true;
            parcel$$1.writeLong(searchAppResult$$1.totalDownloads);
            $jacocoInit[8] = true;
            parcel$$1.writeString(searchAppResult$$1.appName);
            $jacocoInit[9] = true;
            parcel$$1.writeString(searchAppResult$$1.icon);
            $jacocoInit[10] = true;
            if (searchAppResult$$1.hasOtherVersions) {
                $jacocoInit[11] = true;
                i2 = 1;
            } else {
                $jacocoInit[12] = true;
                i2 = 0;
            }
            parcel$$1.writeInt(i2);
            $jacocoInit[13] = true;
            if (((Boolean) C14448c.m46062a(Boolean.TYPE, SearchAppResult.class, (Object) searchAppResult$$1, "appcAdvertising")).booleanValue()) {
                $jacocoInit[14] = true;
                i3 = 1;
            } else {
                $jacocoInit[15] = true;
            }
            parcel$$1.writeInt(i3);
            $jacocoInit[16] = true;
            parcel$$1.writeFloat(searchAppResult$$1.averageRating);
            $jacocoInit[17] = true;
            parcel$$1.writeLong(searchAppResult$$1.appId);
            $jacocoInit[18] = true;
            parcel$$1.writeLong(searchAppResult$$1.modifiedDate);
            $jacocoInit[19] = true;
            parcel$$1.writeInt(searchAppResult$$1.rank);
            $jacocoInit[20] = true;
            parcel$$1.writeString(searchAppResult$$1.storeName);
            $jacocoInit[21] = true;
            parcel$$1.writeString(searchAppResult$$1.storeTheme);
            $jacocoInit[22] = true;
            parcel$$1.writeString(searchAppResult$$1.packageName);
            $jacocoInit[23] = true;
        }
        $jacocoInit[24] = true;
    }

    public int describeContents() {
        $jacocoInit()[25] = true;
        return 0;
    }

    public SearchAppResult getParcel() {
        boolean[] $jacocoInit = $jacocoInit();
        SearchAppResult searchAppResult = this.searchAppResult$$0;
        $jacocoInit[26] = true;
        return searchAppResult;
    }

    public static SearchAppResult read(Parcel parcel$$3, C14432a identityMap$$1) {
        boolean z;
        boolean z2;
        boolean[] $jacocoInit = $jacocoInit();
        int identity$$1 = parcel$$3.readInt();
        $jacocoInit[27] = true;
        if (identityMap$$1.mo45530a(identity$$1)) {
            $jacocoInit[28] = true;
            if (!identityMap$$1.mo45533c(identity$$1)) {
                SearchAppResult searchAppResult = (SearchAppResult) identityMap$$1.mo45532b(identity$$1);
                $jacocoInit[31] = true;
                return searchAppResult;
            }
            $jacocoInit[29] = true;
            ParcelerRuntimeException parcelerRuntimeException = new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            $jacocoInit[30] = true;
            throw parcelerRuntimeException;
        }
        int reservation$$0 = identityMap$$1.mo45527a();
        $jacocoInit[32] = true;
        SearchAppResult searchAppResult$$4 = new SearchAppResult();
        $jacocoInit[33] = true;
        identityMap$$1.mo45529a(reservation$$0, searchAppResult$$4);
        $jacocoInit[34] = true;
        Class<SearchAppResult> cls = SearchAppResult.class;
        boolean z3 = false;
        if (parcel$$3.readInt() == 1) {
            $jacocoInit[35] = true;
            z = true;
        } else {
            $jacocoInit[36] = true;
            z = false;
        }
        C14448c.m46063a(cls, (Object) searchAppResult$$4, "appcBilling", (Object) Boolean.valueOf(z));
        $jacocoInit[37] = true;
        searchAppResult$$4.totalDownloads = parcel$$3.readLong();
        $jacocoInit[38] = true;
        searchAppResult$$4.appName = parcel$$3.readString();
        $jacocoInit[39] = true;
        searchAppResult$$4.icon = parcel$$3.readString();
        $jacocoInit[40] = true;
        if (parcel$$3.readInt() == 1) {
            $jacocoInit[41] = true;
            z2 = true;
        } else {
            $jacocoInit[42] = true;
            z2 = false;
        }
        searchAppResult$$4.hasOtherVersions = z2;
        $jacocoInit[43] = true;
        Class<SearchAppResult> cls2 = SearchAppResult.class;
        if (parcel$$3.readInt() == 1) {
            $jacocoInit[44] = true;
            z3 = true;
        } else {
            $jacocoInit[45] = true;
        }
        C14448c.m46063a(cls2, (Object) searchAppResult$$4, "appcAdvertising", (Object) Boolean.valueOf(z3));
        $jacocoInit[46] = true;
        searchAppResult$$4.averageRating = parcel$$3.readFloat();
        $jacocoInit[47] = true;
        searchAppResult$$4.appId = parcel$$3.readLong();
        $jacocoInit[48] = true;
        searchAppResult$$4.modifiedDate = parcel$$3.readLong();
        $jacocoInit[49] = true;
        searchAppResult$$4.rank = parcel$$3.readInt();
        $jacocoInit[50] = true;
        searchAppResult$$4.storeName = parcel$$3.readString();
        $jacocoInit[51] = true;
        searchAppResult$$4.storeTheme = parcel$$3.readString();
        $jacocoInit[52] = true;
        searchAppResult$$4.packageName = parcel$$3.readString();
        $jacocoInit[53] = true;
        SearchAppResult searchAppResult$$3 = searchAppResult$$4;
        identityMap$$1.mo45529a(identity$$1, searchAppResult$$3);
        $jacocoInit[54] = true;
        return searchAppResult$$3;
    }
}
