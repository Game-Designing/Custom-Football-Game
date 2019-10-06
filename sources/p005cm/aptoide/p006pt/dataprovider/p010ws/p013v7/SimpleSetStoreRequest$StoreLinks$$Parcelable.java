package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.C14432a;
import org.parceler.C14474z;
import org.parceler.ParcelerRuntimeException;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.SocialChannelType;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.SimpleSetStoreRequest.StoreLinks;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.SimpleSetStoreRequest$StoreLinks$$Parcelable */
public class SimpleSetStoreRequest$StoreLinks$$Parcelable implements Parcelable, C14474z<StoreLinks> {
    public static final Creator<SimpleSetStoreRequest$StoreLinks$$Parcelable> CREATOR = new Creator<SimpleSetStoreRequest$StoreLinks$$Parcelable>() {
        public SimpleSetStoreRequest$StoreLinks$$Parcelable createFromParcel(Parcel parcel$$2) {
            return new SimpleSetStoreRequest$StoreLinks$$Parcelable(SimpleSetStoreRequest$StoreLinks$$Parcelable.read(parcel$$2, new C14432a()));
        }

        public SimpleSetStoreRequest$StoreLinks$$Parcelable[] newArray(int size) {
            return new SimpleSetStoreRequest$StoreLinks$$Parcelable[size];
        }
    };
    private StoreLinks storeLinks$$0;

    public SimpleSetStoreRequest$StoreLinks$$Parcelable(StoreLinks storeLinks$$2) {
        this.storeLinks$$0 = storeLinks$$2;
    }

    public void writeToParcel(Parcel parcel$$0, int flags) {
        write(this.storeLinks$$0, parcel$$0, flags, new C14432a());
    }

    public static void write(StoreLinks storeLinks$$1, Parcel parcel$$1, int flags$$0, C14432a identityMap$$0) {
        int identity$$0 = identityMap$$0.mo45528a((Object) storeLinks$$1);
        if (identity$$0 != -1) {
            parcel$$1.writeInt(identity$$0);
            return;
        }
        parcel$$1.writeInt(identityMap$$0.mo45531b((Object) storeLinks$$1));
        SocialChannelType socialChannelType$$0 = storeLinks$$1.type;
        parcel$$1.writeString(socialChannelType$$0 == null ? null : socialChannelType$$0.name());
        parcel$$1.writeString(storeLinks$$1.url);
    }

    public int describeContents() {
        return 0;
    }

    public StoreLinks getParcel() {
        return this.storeLinks$$0;
    }

    public static StoreLinks read(Parcel parcel$$3, C14432a identityMap$$1) {
        int identity$$1 = parcel$$3.readInt();
        if (!identityMap$$1.mo45530a(identity$$1)) {
            int reservation$$0 = identityMap$$1.mo45527a();
            StoreLinks storeLinks$$4 = new StoreLinks();
            identityMap$$1.mo45529a(reservation$$0, storeLinks$$4);
            String socialChannelType$$1 = parcel$$3.readString();
            storeLinks$$4.type = socialChannelType$$1 == null ? null : (SocialChannelType) Enum.valueOf(SocialChannelType.class, socialChannelType$$1);
            storeLinks$$4.url = parcel$$3.readString();
            StoreLinks storeLinks$$3 = storeLinks$$4;
            identityMap$$1.mo45529a(identity$$1, storeLinks$$3);
            return storeLinks$$3;
        } else if (!identityMap$$1.mo45533c(identity$$1)) {
            return (StoreLinks) identityMap$$1.mo45532b(identity$$1);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
