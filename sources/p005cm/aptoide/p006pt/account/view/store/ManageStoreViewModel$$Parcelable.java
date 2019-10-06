package p005cm.aptoide.p006pt.account.view.store;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.parceler.C14432a;
import org.parceler.C14474z;
import org.parceler.ParcelerRuntimeException;
import p005cm.aptoide.accountmanager.SocialLink;
import p005cm.aptoide.accountmanager.SocialLink$$Parcelable;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.SocialChannelType;
import p005cm.aptoide.p006pt.store.StoreTheme;

/* renamed from: cm.aptoide.pt.account.view.store.ManageStoreViewModel$$Parcelable */
public class ManageStoreViewModel$$Parcelable implements Parcelable, C14474z<ManageStoreViewModel> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    public static final Creator<ManageStoreViewModel$$Parcelable> CREATOR = new Creator<ManageStoreViewModel$$Parcelable>() {
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(6172512718538551419L, "cm/aptoide/pt/account/view/store/ManageStoreViewModel$$Parcelable$1", 5);
            $jacocoData = probes;
            return probes;
        }

        {
            $jacocoInit()[0] = true;
        }

        public ManageStoreViewModel$$Parcelable createFromParcel(Parcel parcel$$2) {
            boolean[] $jacocoInit = $jacocoInit();
            ManageStoreViewModel$$Parcelable manageStoreViewModel$$Parcelable = new ManageStoreViewModel$$Parcelable(ManageStoreViewModel$$Parcelable.read(parcel$$2, new C14432a()));
            $jacocoInit[1] = true;
            return manageStoreViewModel$$Parcelable;
        }

        public ManageStoreViewModel$$Parcelable[] newArray(int size) {
            ManageStoreViewModel$$Parcelable[] manageStoreViewModel$$ParcelableArr = new ManageStoreViewModel$$Parcelable[size];
            $jacocoInit()[2] = true;
            return manageStoreViewModel$$ParcelableArr;
        }
    };
    private ManageStoreViewModel manageStoreViewModel$$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7978609324164400243L, "cm/aptoide/pt/account/view/store/ManageStoreViewModel$$Parcelable", 70);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[69] = true;
    }

    public ManageStoreViewModel$$Parcelable(ManageStoreViewModel manageStoreViewModel$$2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.manageStoreViewModel$$0 = manageStoreViewModel$$2;
        $jacocoInit[0] = true;
    }

    public void writeToParcel(Parcel parcel$$0, int flags) {
        boolean[] $jacocoInit = $jacocoInit();
        write(this.manageStoreViewModel$$0, parcel$$0, flags, new C14432a());
        $jacocoInit[1] = true;
    }

    public static void write(ManageStoreViewModel manageStoreViewModel$$1, Parcel parcel$$1, int flags$$0, C14432a identityMap$$0) {
        int i;
        String str;
        String str2;
        boolean[] $jacocoInit = $jacocoInit();
        int identity$$0 = identityMap$$0.mo45528a((Object) manageStoreViewModel$$1);
        if (identity$$0 != -1) {
            $jacocoInit[2] = true;
            parcel$$1.writeInt(identity$$0);
            $jacocoInit[3] = true;
        } else {
            parcel$$1.writeInt(identityMap$$0.mo45531b((Object) manageStoreViewModel$$1));
            $jacocoInit[4] = true;
            parcel$$1.writeString(manageStoreViewModel$$1.storeDescription);
            $jacocoInit[5] = true;
            if (manageStoreViewModel$$1.newAvatar) {
                $jacocoInit[6] = true;
                i = 1;
            } else {
                i = 0;
                $jacocoInit[7] = true;
            }
            parcel$$1.writeInt(i);
            List<SocialLink> list = manageStoreViewModel$$1.socialLinks;
            if (list == null) {
                $jacocoInit[8] = true;
                parcel$$1.writeInt(-1);
                $jacocoInit[9] = true;
            } else {
                parcel$$1.writeInt(list.size());
                $jacocoInit[10] = true;
                $jacocoInit[11] = true;
                for (SocialLink socialLink$$0 : manageStoreViewModel$$1.socialLinks) {
                    $jacocoInit[13] = true;
                    SocialLink$$Parcelable.write(socialLink$$0, parcel$$1, flags$$0, identityMap$$0);
                    $jacocoInit[14] = true;
                }
                $jacocoInit[12] = true;
            }
            parcel$$1.writeString(manageStoreViewModel$$1.pictureUri);
            $jacocoInit[15] = true;
            parcel$$1.writeString(manageStoreViewModel$$1.storeName);
            StoreTheme storeTheme$$0 = manageStoreViewModel$$1.storeTheme;
            $jacocoInit[16] = true;
            if (storeTheme$$0 == null) {
                $jacocoInit[17] = true;
                str = null;
            } else {
                str = storeTheme$$0.name();
                $jacocoInit[18] = true;
            }
            parcel$$1.writeString(str);
            $jacocoInit[19] = true;
            parcel$$1.writeLong(manageStoreViewModel$$1.storeId);
            List<SocialChannelType> list2 = manageStoreViewModel$$1.socialDelLinks;
            if (list2 == null) {
                $jacocoInit[20] = true;
                parcel$$1.writeInt(-1);
                $jacocoInit[21] = true;
            } else {
                parcel$$1.writeInt(list2.size());
                $jacocoInit[22] = true;
                $jacocoInit[23] = true;
                for (SocialChannelType socialChannelType$$0 : manageStoreViewModel$$1.socialDelLinks) {
                    $jacocoInit[25] = true;
                    SocialChannelType socialChannelType$$1 = socialChannelType$$0;
                    if (socialChannelType$$1 == null) {
                        $jacocoInit[26] = true;
                        str2 = null;
                    } else {
                        str2 = socialChannelType$$1.name();
                        $jacocoInit[27] = true;
                    }
                    parcel$$1.writeString(str2);
                    $jacocoInit[28] = true;
                }
                $jacocoInit[24] = true;
            }
        }
        $jacocoInit[29] = true;
    }

    public int describeContents() {
        $jacocoInit()[30] = true;
        return 0;
    }

    public ManageStoreViewModel getParcel() {
        boolean[] $jacocoInit = $jacocoInit();
        ManageStoreViewModel manageStoreViewModel = this.manageStoreViewModel$$0;
        $jacocoInit[31] = true;
        return manageStoreViewModel;
    }

    public static ManageStoreViewModel read(Parcel parcel$$3, C14432a identityMap$$1) {
        boolean z;
        ArrayList arrayList;
        StoreTheme storeTheme;
        ArrayList arrayList2;
        Object obj;
        C14432a aVar = identityMap$$1;
        boolean[] $jacocoInit = $jacocoInit();
        int identity$$1 = parcel$$3.readInt();
        $jacocoInit[32] = true;
        if (aVar.mo45530a(identity$$1)) {
            $jacocoInit[33] = true;
            if (!aVar.mo45533c(identity$$1)) {
                ManageStoreViewModel manageStoreViewModel = (ManageStoreViewModel) aVar.mo45532b(identity$$1);
                $jacocoInit[36] = true;
                return manageStoreViewModel;
            }
            $jacocoInit[34] = true;
            ParcelerRuntimeException parcelerRuntimeException = new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            $jacocoInit[35] = true;
            throw parcelerRuntimeException;
        }
        int reservation$$0 = identityMap$$1.mo45527a();
        $jacocoInit[37] = true;
        ManageStoreViewModel manageStoreViewModel$$4 = new ManageStoreViewModel();
        $jacocoInit[38] = true;
        aVar.mo45529a(reservation$$0, manageStoreViewModel$$4);
        $jacocoInit[39] = true;
        manageStoreViewModel$$4.storeDescription = parcel$$3.readString();
        $jacocoInit[40] = true;
        if (parcel$$3.readInt() == 1) {
            $jacocoInit[41] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[42] = true;
        }
        manageStoreViewModel$$4.newAvatar = z;
        $jacocoInit[43] = true;
        int int$$0 = parcel$$3.readInt();
        if (int$$0 < 0) {
            $jacocoInit[44] = true;
            arrayList = null;
        } else {
            ArrayList<SocialLink> list$$0 = new ArrayList<>(int$$0);
            int int$$1 = 0;
            $jacocoInit[45] = true;
            while (int$$1 < int$$0) {
                $jacocoInit[47] = true;
                SocialLink socialLink$$1 = SocialLink$$Parcelable.read(parcel$$3, identityMap$$1);
                $jacocoInit[48] = true;
                list$$0.add(socialLink$$1);
                int$$1++;
                $jacocoInit[49] = true;
            }
            $jacocoInit[46] = true;
            arrayList = list$$0;
        }
        manageStoreViewModel$$4.socialLinks = arrayList;
        $jacocoInit[50] = true;
        manageStoreViewModel$$4.pictureUri = parcel$$3.readString();
        $jacocoInit[51] = true;
        manageStoreViewModel$$4.storeName = parcel$$3.readString();
        $jacocoInit[52] = true;
        String storeTheme$$1 = parcel$$3.readString();
        $jacocoInit[53] = true;
        if (storeTheme$$1 == null) {
            $jacocoInit[54] = true;
            storeTheme = null;
        } else {
            storeTheme = (StoreTheme) Enum.valueOf(StoreTheme.class, storeTheme$$1);
            $jacocoInit[55] = true;
        }
        manageStoreViewModel$$4.storeTheme = storeTheme;
        $jacocoInit[56] = true;
        manageStoreViewModel$$4.storeId = parcel$$3.readLong();
        $jacocoInit[57] = true;
        int int$$2 = parcel$$3.readInt();
        if (int$$2 < 0) {
            arrayList2 = null;
            $jacocoInit[58] = true;
        } else {
            ArrayList arrayList3 = new ArrayList(int$$2);
            int int$$3 = 0;
            $jacocoInit[59] = true;
            while (int$$3 < int$$2) {
                $jacocoInit[61] = true;
                String socialChannelType$$2 = parcel$$3.readString();
                $jacocoInit[62] = true;
                if (socialChannelType$$2 == null) {
                    $jacocoInit[63] = true;
                    obj = null;
                } else {
                    obj = (SocialChannelType) Enum.valueOf(SocialChannelType.class, socialChannelType$$2);
                    $jacocoInit[64] = true;
                }
                arrayList3.add(obj);
                int$$3++;
                $jacocoInit[65] = true;
            }
            $jacocoInit[60] = true;
            arrayList2 = arrayList3;
        }
        manageStoreViewModel$$4.socialDelLinks = arrayList2;
        $jacocoInit[66] = true;
        ManageStoreViewModel manageStoreViewModel$$3 = manageStoreViewModel$$4;
        aVar.mo45529a(identity$$1, manageStoreViewModel$$3);
        $jacocoInit[67] = true;
        return manageStoreViewModel$$3;
    }
}
