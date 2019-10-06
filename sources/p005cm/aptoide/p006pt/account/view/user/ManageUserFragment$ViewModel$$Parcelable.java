package p005cm.aptoide.p006pt.account.view.user;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.parceler.C14432a;
import org.parceler.C14448c;
import org.parceler.C14474z;
import org.parceler.ParcelerRuntimeException;

/* renamed from: cm.aptoide.pt.account.view.user.ManageUserFragment$ViewModel$$Parcelable */
public class ManageUserFragment$ViewModel$$Parcelable implements Parcelable, C14474z<ViewModel> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    public static final Creator<ManageUserFragment$ViewModel$$Parcelable> CREATOR = new Creator<ManageUserFragment$ViewModel$$Parcelable>() {
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-8825763794224969582L, "cm/aptoide/pt/account/view/user/ManageUserFragment$ViewModel$$Parcelable$1", 5);
            $jacocoData = probes;
            return probes;
        }

        {
            $jacocoInit()[0] = true;
        }

        public ManageUserFragment$ViewModel$$Parcelable createFromParcel(Parcel parcel$$2) {
            boolean[] $jacocoInit = $jacocoInit();
            ManageUserFragment$ViewModel$$Parcelable manageUserFragment$ViewModel$$Parcelable = new ManageUserFragment$ViewModel$$Parcelable(ManageUserFragment$ViewModel$$Parcelable.read(parcel$$2, new C14432a()));
            $jacocoInit[1] = true;
            return manageUserFragment$ViewModel$$Parcelable;
        }

        public ManageUserFragment$ViewModel$$Parcelable[] newArray(int size) {
            ManageUserFragment$ViewModel$$Parcelable[] manageUserFragment$ViewModel$$ParcelableArr = new ManageUserFragment$ViewModel$$Parcelable[size];
            $jacocoInit()[2] = true;
            return manageUserFragment$ViewModel$$ParcelableArr;
        }
    };
    private ViewModel viewModel$$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4848549180729101948L, "cm/aptoide/pt/account/view/user/ManageUserFragment$ViewModel$$Parcelable", 51);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[50] = true;
    }

    public ManageUserFragment$ViewModel$$Parcelable(ViewModel viewModel$$2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.viewModel$$0 = viewModel$$2;
        $jacocoInit[0] = true;
    }

    public void writeToParcel(Parcel parcel$$0, int flags) {
        boolean[] $jacocoInit = $jacocoInit();
        write(this.viewModel$$0, parcel$$0, flags, new C14432a());
        $jacocoInit[1] = true;
    }

    public static void write(ViewModel viewModel$$1, Parcel parcel$$1, int flags$$0, C14432a identityMap$$0) {
        int i;
        int i2;
        boolean[] $jacocoInit = $jacocoInit();
        int identity$$0 = identityMap$$0.mo45528a((Object) viewModel$$1);
        if (identity$$0 != -1) {
            $jacocoInit[2] = true;
            parcel$$1.writeInt(identity$$0);
            $jacocoInit[3] = true;
        } else {
            parcel$$1.writeInt(identityMap$$0.mo45531b((Object) viewModel$$1));
            $jacocoInit[4] = true;
            parcel$$1.writeString(viewModel$$1.date);
            $jacocoInit[5] = true;
            int i3 = 0;
            if (viewModel$$1.hasNewPicture) {
                $jacocoInit[6] = true;
                i = 1;
            } else {
                $jacocoInit[7] = true;
                i = 0;
            }
            parcel$$1.writeInt(i);
            $jacocoInit[8] = true;
            parcel$$1.writeInt(((Integer) C14448c.m46062a(Integer.TYPE, ViewModel.class, (Object) viewModel$$1, "month")).intValue());
            $jacocoInit[9] = true;
            parcel$$1.writeInt(((Integer) C14448c.m46062a(Integer.TYPE, ViewModel.class, (Object) viewModel$$1, "year")).intValue());
            $jacocoInit[10] = true;
            if (viewModel$$1.hasNewsletterSubscribe) {
                $jacocoInit[11] = true;
                i2 = 1;
            } else {
                $jacocoInit[12] = true;
                i2 = 0;
            }
            parcel$$1.writeInt(i2);
            $jacocoInit[13] = true;
            parcel$$1.writeString(viewModel$$1.name);
            $jacocoInit[14] = true;
            parcel$$1.writeString(viewModel$$1.pictureUri);
            $jacocoInit[15] = true;
            parcel$$1.writeString(viewModel$$1.requestDate);
            $jacocoInit[16] = true;
            parcel$$1.writeInt(((Integer) C14448c.m46062a(Integer.TYPE, ViewModel.class, (Object) viewModel$$1, "day")).intValue());
            $jacocoInit[17] = true;
            if (viewModel$$1.hasDateError) {
                $jacocoInit[18] = true;
                i3 = 1;
            } else {
                $jacocoInit[19] = true;
            }
            parcel$$1.writeInt(i3);
            $jacocoInit[20] = true;
        }
        $jacocoInit[21] = true;
    }

    public int describeContents() {
        $jacocoInit()[22] = true;
        return 0;
    }

    public ViewModel getParcel() {
        boolean[] $jacocoInit = $jacocoInit();
        ViewModel viewModel = this.viewModel$$0;
        $jacocoInit[23] = true;
        return viewModel;
    }

    public static ViewModel read(Parcel parcel$$3, C14432a identityMap$$1) {
        boolean z;
        boolean z2;
        boolean[] $jacocoInit = $jacocoInit();
        int identity$$1 = parcel$$3.readInt();
        $jacocoInit[24] = true;
        if (identityMap$$1.mo45530a(identity$$1)) {
            $jacocoInit[25] = true;
            if (!identityMap$$1.mo45533c(identity$$1)) {
                ViewModel viewModel = (ViewModel) identityMap$$1.mo45532b(identity$$1);
                $jacocoInit[28] = true;
                return viewModel;
            }
            $jacocoInit[26] = true;
            ParcelerRuntimeException parcelerRuntimeException = new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            $jacocoInit[27] = true;
            throw parcelerRuntimeException;
        }
        int reservation$$0 = identityMap$$1.mo45527a();
        $jacocoInit[29] = true;
        ViewModel viewModel$$4 = new ViewModel();
        $jacocoInit[30] = true;
        identityMap$$1.mo45529a(reservation$$0, viewModel$$4);
        $jacocoInit[31] = true;
        viewModel$$4.date = parcel$$3.readString();
        $jacocoInit[32] = true;
        boolean z3 = false;
        if (parcel$$3.readInt() == 1) {
            $jacocoInit[33] = true;
            z = true;
        } else {
            $jacocoInit[34] = true;
            z = false;
        }
        viewModel$$4.hasNewPicture = z;
        $jacocoInit[35] = true;
        C14448c.m46063a(ViewModel.class, (Object) viewModel$$4, "month", (Object) Integer.valueOf(parcel$$3.readInt()));
        $jacocoInit[36] = true;
        C14448c.m46063a(ViewModel.class, (Object) viewModel$$4, "year", (Object) Integer.valueOf(parcel$$3.readInt()));
        $jacocoInit[37] = true;
        if (parcel$$3.readInt() == 1) {
            $jacocoInit[38] = true;
            z2 = true;
        } else {
            $jacocoInit[39] = true;
            z2 = false;
        }
        viewModel$$4.hasNewsletterSubscribe = z2;
        $jacocoInit[40] = true;
        viewModel$$4.name = parcel$$3.readString();
        $jacocoInit[41] = true;
        viewModel$$4.pictureUri = parcel$$3.readString();
        $jacocoInit[42] = true;
        viewModel$$4.requestDate = parcel$$3.readString();
        $jacocoInit[43] = true;
        C14448c.m46063a(ViewModel.class, (Object) viewModel$$4, "day", (Object) Integer.valueOf(parcel$$3.readInt()));
        $jacocoInit[44] = true;
        if (parcel$$3.readInt() == 1) {
            $jacocoInit[45] = true;
            z3 = true;
        } else {
            $jacocoInit[46] = true;
        }
        viewModel$$4.hasDateError = z3;
        $jacocoInit[47] = true;
        ViewModel viewModel$$3 = viewModel$$4;
        identityMap$$1.mo45529a(identity$$1, viewModel$$3);
        $jacocoInit[48] = true;
        return viewModel$$3;
    }
}
