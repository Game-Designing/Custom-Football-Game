package p005cm.aptoide.p006pt.search.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.parceler.C14432a;
import org.parceler.C14474z;
import org.parceler.ParcelerRuntimeException;

/* renamed from: cm.aptoide.pt.search.model.SearchAdResult$$Parcelable */
public class SearchAdResult$$Parcelable implements Parcelable, C14474z<SearchAdResult> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    public static final Creator<SearchAdResult$$Parcelable> CREATOR = new Creator<SearchAdResult$$Parcelable>() {
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-8841176027042243962L, "cm/aptoide/pt/search/model/SearchAdResult$$Parcelable$1", 5);
            $jacocoData = probes;
            return probes;
        }

        {
            $jacocoInit()[0] = true;
        }

        public SearchAdResult$$Parcelable createFromParcel(Parcel parcel$$2) {
            boolean[] $jacocoInit = $jacocoInit();
            SearchAdResult$$Parcelable searchAdResult$$Parcelable = new SearchAdResult$$Parcelable(SearchAdResult$$Parcelable.read(parcel$$2, new C14432a()));
            $jacocoInit[1] = true;
            return searchAdResult$$Parcelable;
        }

        public SearchAdResult$$Parcelable[] newArray(int size) {
            SearchAdResult$$Parcelable[] searchAdResult$$ParcelableArr = new SearchAdResult$$Parcelable[size];
            $jacocoInit()[2] = true;
            return searchAdResult$$ParcelableArr;
        }
    };
    private SearchAdResult searchAdResult$$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8574389585857956693L, "cm/aptoide/pt/search/model/SearchAdResult$$Parcelable", 45);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[44] = true;
    }

    public SearchAdResult$$Parcelable(SearchAdResult searchAdResult$$2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.searchAdResult$$0 = searchAdResult$$2;
        $jacocoInit[0] = true;
    }

    public void writeToParcel(Parcel parcel$$0, int flags) {
        boolean[] $jacocoInit = $jacocoInit();
        write(this.searchAdResult$$0, parcel$$0, flags, new C14432a());
        $jacocoInit[1] = true;
    }

    public static void write(SearchAdResult searchAdResult$$1, Parcel parcel$$1, int flags$$0, C14432a identityMap$$0) {
        boolean[] $jacocoInit = $jacocoInit();
        int identity$$0 = identityMap$$0.mo45528a((Object) searchAdResult$$1);
        if (identity$$0 != -1) {
            $jacocoInit[2] = true;
            parcel$$1.writeInt(identity$$0);
            $jacocoInit[3] = true;
        } else {
            parcel$$1.writeInt(identityMap$$0.mo45531b((Object) searchAdResult$$1));
            $jacocoInit[4] = true;
            parcel$$1.writeString(searchAdResult$$1.clickUrl);
            $jacocoInit[5] = true;
            parcel$$1.writeLong(searchAdResult$$1.totalDownloads);
            $jacocoInit[6] = true;
            parcel$$1.writeString(searchAdResult$$1.appName);
            $jacocoInit[7] = true;
            parcel$$1.writeString(searchAdResult$$1.icon);
            $jacocoInit[8] = true;
            parcel$$1.writeString(searchAdResult$$1.cpcUrl);
            $jacocoInit[9] = true;
            parcel$$1.writeLong(searchAdResult$$1.adId);
            $jacocoInit[10] = true;
            parcel$$1.writeLong(searchAdResult$$1.appId);
            $jacocoInit[11] = true;
            parcel$$1.writeLong(searchAdResult$$1.modifiedDate);
            $jacocoInit[12] = true;
            parcel$$1.writeLong(searchAdResult$$1.networkId);
            $jacocoInit[13] = true;
            parcel$$1.writeString(searchAdResult$$1.packageName);
            $jacocoInit[14] = true;
            parcel$$1.writeString(searchAdResult$$1.clickPerInstallUrl);
            $jacocoInit[15] = true;
            parcel$$1.writeFloat(searchAdResult$$1.starRating);
            $jacocoInit[16] = true;
            parcel$$1.writeString(searchAdResult$$1.clickPerDownloadUrl);
            $jacocoInit[17] = true;
        }
        $jacocoInit[18] = true;
    }

    public int describeContents() {
        $jacocoInit()[19] = true;
        return 0;
    }

    public SearchAdResult getParcel() {
        boolean[] $jacocoInit = $jacocoInit();
        SearchAdResult searchAdResult = this.searchAdResult$$0;
        $jacocoInit[20] = true;
        return searchAdResult;
    }

    public static SearchAdResult read(Parcel parcel$$3, C14432a identityMap$$1) {
        boolean[] $jacocoInit = $jacocoInit();
        int identity$$1 = parcel$$3.readInt();
        $jacocoInit[21] = true;
        if (identityMap$$1.mo45530a(identity$$1)) {
            $jacocoInit[22] = true;
            if (!identityMap$$1.mo45533c(identity$$1)) {
                SearchAdResult searchAdResult = (SearchAdResult) identityMap$$1.mo45532b(identity$$1);
                $jacocoInit[25] = true;
                return searchAdResult;
            }
            $jacocoInit[23] = true;
            ParcelerRuntimeException parcelerRuntimeException = new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            $jacocoInit[24] = true;
            throw parcelerRuntimeException;
        }
        int reservation$$0 = identityMap$$1.mo45527a();
        $jacocoInit[26] = true;
        SearchAdResult searchAdResult$$4 = new SearchAdResult();
        $jacocoInit[27] = true;
        identityMap$$1.mo45529a(reservation$$0, searchAdResult$$4);
        $jacocoInit[28] = true;
        searchAdResult$$4.clickUrl = parcel$$3.readString();
        $jacocoInit[29] = true;
        searchAdResult$$4.totalDownloads = parcel$$3.readLong();
        $jacocoInit[30] = true;
        searchAdResult$$4.appName = parcel$$3.readString();
        $jacocoInit[31] = true;
        searchAdResult$$4.icon = parcel$$3.readString();
        $jacocoInit[32] = true;
        searchAdResult$$4.cpcUrl = parcel$$3.readString();
        $jacocoInit[33] = true;
        searchAdResult$$4.adId = parcel$$3.readLong();
        $jacocoInit[34] = true;
        searchAdResult$$4.appId = parcel$$3.readLong();
        $jacocoInit[35] = true;
        searchAdResult$$4.modifiedDate = parcel$$3.readLong();
        $jacocoInit[36] = true;
        searchAdResult$$4.networkId = parcel$$3.readLong();
        $jacocoInit[37] = true;
        searchAdResult$$4.packageName = parcel$$3.readString();
        $jacocoInit[38] = true;
        searchAdResult$$4.clickPerInstallUrl = parcel$$3.readString();
        $jacocoInit[39] = true;
        searchAdResult$$4.starRating = parcel$$3.readFloat();
        $jacocoInit[40] = true;
        searchAdResult$$4.clickPerDownloadUrl = parcel$$3.readString();
        $jacocoInit[41] = true;
        SearchAdResult searchAdResult$$3 = searchAdResult$$4;
        identityMap$$1.mo45529a(identity$$1, searchAdResult$$3);
        $jacocoInit[42] = true;
        return searchAdResult$$3;
    }
}
