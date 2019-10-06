package p005cm.aptoide.accountmanager;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.C14432a;
import org.parceler.C14474z;
import org.parceler.ParcelerRuntimeException;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.SocialChannelType;

/* renamed from: cm.aptoide.accountmanager.SocialLink$$Parcelable */
public class SocialLink$$Parcelable implements Parcelable, C14474z<SocialLink> {
    public static final Creator<SocialLink$$Parcelable> CREATOR = new Creator<SocialLink$$Parcelable>() {
        public SocialLink$$Parcelable createFromParcel(Parcel parcel$$2) {
            return new SocialLink$$Parcelable(SocialLink$$Parcelable.read(parcel$$2, new C14432a()));
        }

        public SocialLink$$Parcelable[] newArray(int size) {
            return new SocialLink$$Parcelable[size];
        }
    };
    private SocialLink socialLink$$0;

    public SocialLink$$Parcelable(SocialLink socialLink$$2) {
        this.socialLink$$0 = socialLink$$2;
    }

    public void writeToParcel(Parcel parcel$$0, int flags) {
        write(this.socialLink$$0, parcel$$0, flags, new C14432a());
    }

    public static void write(SocialLink socialLink$$1, Parcel parcel$$1, int flags$$0, C14432a identityMap$$0) {
        int identity$$0 = identityMap$$0.mo45528a((Object) socialLink$$1);
        if (identity$$0 != -1) {
            parcel$$1.writeInt(identity$$0);
            return;
        }
        parcel$$1.writeInt(identityMap$$0.mo45531b((Object) socialLink$$1));
        SocialChannelType socialChannelType$$0 = socialLink$$1.type;
        parcel$$1.writeString(socialChannelType$$0 == null ? null : socialChannelType$$0.name());
        parcel$$1.writeString(socialLink$$1.url);
    }

    public int describeContents() {
        return 0;
    }

    public SocialLink getParcel() {
        return this.socialLink$$0;
    }

    public static SocialLink read(Parcel parcel$$3, C14432a identityMap$$1) {
        int identity$$1 = parcel$$3.readInt();
        if (!identityMap$$1.mo45530a(identity$$1)) {
            int reservation$$0 = identityMap$$1.mo45527a();
            SocialLink socialLink$$4 = new SocialLink();
            identityMap$$1.mo45529a(reservation$$0, socialLink$$4);
            String socialChannelType$$1 = parcel$$3.readString();
            socialLink$$4.type = socialChannelType$$1 == null ? null : (SocialChannelType) Enum.valueOf(SocialChannelType.class, socialChannelType$$1);
            socialLink$$4.url = parcel$$3.readString();
            SocialLink socialLink$$3 = socialLink$$4;
            identityMap$$1.mo45529a(identity$$1, socialLink$$3);
            return socialLink$$3;
        } else if (!identityMap$$1.mo45533c(identity$$1)) {
            return (SocialLink) identityMap$$1.mo45532b(identity$$1);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
