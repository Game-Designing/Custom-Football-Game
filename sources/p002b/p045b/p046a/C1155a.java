package p002b.p045b.p046a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: b.b.a.a */
/* compiled from: IPackageInstallObserver */
public interface C1155a extends IInterface {

    /* renamed from: b.b.a.a$a */
    /* compiled from: IPackageInstallObserver */
    public static abstract class C1156a extends Binder implements C1155a {
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(6524541942218465695L, "android/content/pm/IPackageInstallObserver$Stub", 5);
            $jacocoData = probes;
            return probes;
        }

        public abstract void packageInstalled(String str, int i) throws RemoteException;

        public C1156a() {
            boolean[] $jacocoInit = $jacocoInit();
            $jacocoInit[0] = true;
            RuntimeException runtimeException = new RuntimeException("Stub!");
            $jacocoInit[1] = true;
            throw runtimeException;
        }

        public static C1155a asInterface(IBinder obj) {
            boolean[] $jacocoInit = $jacocoInit();
            RuntimeException runtimeException = new RuntimeException("Stub!");
            $jacocoInit[2] = true;
            throw runtimeException;
        }

        public IBinder asBinder() {
            boolean[] $jacocoInit = $jacocoInit();
            RuntimeException runtimeException = new RuntimeException("Stub!");
            $jacocoInit[3] = true;
            throw runtimeException;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean[] $jacocoInit = $jacocoInit();
            RuntimeException runtimeException = new RuntimeException("Stub!");
            $jacocoInit[4] = true;
            throw runtimeException;
        }
    }
}
