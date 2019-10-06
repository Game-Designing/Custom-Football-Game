package p005cm.aptoide.p006pt.iab;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.iab.AptoideInAppBillingService */
public interface AptoideInAppBillingService extends IInterface {

    /* renamed from: cm.aptoide.pt.iab.AptoideInAppBillingService$Stub */
    public static abstract class Stub extends Binder implements AptoideInAppBillingService {
        private static transient /* synthetic */ boolean[] $jacocoData = null;
        private static final String DESCRIPTOR = "cm.aptoide.pt.iab.AptoideInAppBillingService";
        static final int TRANSACTION_consumePurchase = 5;
        static final int TRANSACTION_getBuyIntent = 3;
        static final int TRANSACTION_getPurchases = 4;
        static final int TRANSACTION_getSkuDetails = 2;
        static final int TRANSACTION_isBillingSupported = 1;

        /* renamed from: cm.aptoide.pt.iab.AptoideInAppBillingService$Stub$Proxy */
        private static class Proxy implements AptoideInAppBillingService {
            private static transient /* synthetic */ boolean[] $jacocoData;
            private IBinder mRemote;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-3349603985096399047L, "cm/aptoide/pt/iab/AptoideInAppBillingService$Stub$Proxy", 80);
                $jacocoData = probes;
                return probes;
            }

            Proxy(IBinder remote) {
                boolean[] $jacocoInit = $jacocoInit();
                this.mRemote = remote;
                $jacocoInit[0] = true;
            }

            public IBinder asBinder() {
                boolean[] $jacocoInit = $jacocoInit();
                IBinder iBinder = this.mRemote;
                $jacocoInit[1] = true;
                return iBinder;
            }

            public String getInterfaceDescriptor() {
                $jacocoInit()[2] = true;
                return Stub.DESCRIPTOR;
            }

            public int isBillingSupported(int apiVersion, String packageName, String type) throws RemoteException {
                boolean[] $jacocoInit = $jacocoInit();
                Parcel _data = Parcel.obtain();
                $jacocoInit[3] = true;
                Parcel _reply = Parcel.obtain();
                try {
                    $jacocoInit[4] = true;
                    try {
                        _data.writeInterfaceToken(Stub.DESCRIPTOR);
                        $jacocoInit[5] = true;
                        _data.writeInt(apiVersion);
                        $jacocoInit[6] = true;
                        _data.writeString(packageName);
                        $jacocoInit[7] = true;
                        _data.writeString(type);
                        $jacocoInit[8] = true;
                        this.mRemote.transact(1, _data, _reply, 0);
                        $jacocoInit[9] = true;
                        _reply.readException();
                        $jacocoInit[10] = true;
                        int _result = _reply.readInt();
                        $jacocoInit[11] = true;
                        _reply.recycle();
                        $jacocoInit[12] = true;
                        _data.recycle();
                        $jacocoInit[15] = true;
                        return _result;
                    } catch (Throwable th) {
                        th = th;
                        _reply.recycle();
                        $jacocoInit[13] = true;
                        _data.recycle();
                        $jacocoInit[14] = true;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    _reply.recycle();
                    $jacocoInit[13] = true;
                    _data.recycle();
                    $jacocoInit[14] = true;
                    throw th;
                }
            }

            public Bundle getSkuDetails(int apiVersion, String packageName, String type, Bundle skusBundle) throws RemoteException {
                Bundle _result;
                boolean[] $jacocoInit = $jacocoInit();
                Parcel _data = Parcel.obtain();
                $jacocoInit[16] = true;
                Parcel _reply = Parcel.obtain();
                try {
                    $jacocoInit[17] = true;
                    try {
                        _data.writeInterfaceToken(Stub.DESCRIPTOR);
                        $jacocoInit[18] = true;
                        _data.writeInt(apiVersion);
                        $jacocoInit[19] = true;
                        _data.writeString(packageName);
                        $jacocoInit[20] = true;
                        _data.writeString(type);
                        if (skusBundle != null) {
                            $jacocoInit[21] = true;
                            _data.writeInt(1);
                            $jacocoInit[22] = true;
                            skusBundle.writeToParcel(_data, 0);
                            $jacocoInit[23] = true;
                        } else {
                            _data.writeInt(0);
                            $jacocoInit[24] = true;
                        }
                        this.mRemote.transact(2, _data, _reply, 0);
                        $jacocoInit[25] = true;
                        _reply.readException();
                        $jacocoInit[26] = true;
                        if (_reply.readInt() != 0) {
                            $jacocoInit[27] = true;
                            _result = (Bundle) Bundle.CREATOR.createFromParcel(_reply);
                            $jacocoInit[28] = true;
                        } else {
                            _result = null;
                            $jacocoInit[29] = true;
                        }
                        _reply.recycle();
                        $jacocoInit[30] = true;
                        _data.recycle();
                        $jacocoInit[33] = true;
                        return _result;
                    } catch (Throwable th) {
                        th = th;
                        _reply.recycle();
                        $jacocoInit[31] = true;
                        _data.recycle();
                        $jacocoInit[32] = true;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    _reply.recycle();
                    $jacocoInit[31] = true;
                    _data.recycle();
                    $jacocoInit[32] = true;
                    throw th;
                }
            }

            public Bundle getBuyIntent(int apiVersion, String packageName, String sku, String type, String developerPayload) throws RemoteException {
                Bundle _result;
                boolean[] $jacocoInit = $jacocoInit();
                Parcel _data = Parcel.obtain();
                $jacocoInit[34] = true;
                Parcel _reply = Parcel.obtain();
                try {
                    $jacocoInit[35] = true;
                    try {
                        _data.writeInterfaceToken(Stub.DESCRIPTOR);
                        $jacocoInit[36] = true;
                        _data.writeInt(apiVersion);
                        $jacocoInit[37] = true;
                        _data.writeString(packageName);
                        $jacocoInit[38] = true;
                        _data.writeString(sku);
                        $jacocoInit[39] = true;
                        _data.writeString(type);
                        $jacocoInit[40] = true;
                        _data.writeString(developerPayload);
                        $jacocoInit[41] = true;
                        this.mRemote.transact(3, _data, _reply, 0);
                        $jacocoInit[42] = true;
                        _reply.readException();
                        $jacocoInit[43] = true;
                        if (_reply.readInt() != 0) {
                            $jacocoInit[44] = true;
                            _result = (Bundle) Bundle.CREATOR.createFromParcel(_reply);
                            $jacocoInit[45] = true;
                        } else {
                            _result = null;
                            $jacocoInit[46] = true;
                        }
                        _reply.recycle();
                        $jacocoInit[47] = true;
                        _data.recycle();
                        $jacocoInit[50] = true;
                        return _result;
                    } catch (Throwable th) {
                        th = th;
                        _reply.recycle();
                        $jacocoInit[48] = true;
                        _data.recycle();
                        $jacocoInit[49] = true;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    _reply.recycle();
                    $jacocoInit[48] = true;
                    _data.recycle();
                    $jacocoInit[49] = true;
                    throw th;
                }
            }

            public Bundle getPurchases(int apiVersion, String packageName, String type, String continuationToken) throws RemoteException {
                Bundle _result;
                boolean[] $jacocoInit = $jacocoInit();
                Parcel _data = Parcel.obtain();
                $jacocoInit[51] = true;
                Parcel _reply = Parcel.obtain();
                try {
                    $jacocoInit[52] = true;
                    try {
                        _data.writeInterfaceToken(Stub.DESCRIPTOR);
                        $jacocoInit[53] = true;
                        _data.writeInt(apiVersion);
                        $jacocoInit[54] = true;
                        _data.writeString(packageName);
                        $jacocoInit[55] = true;
                        _data.writeString(type);
                        $jacocoInit[56] = true;
                        _data.writeString(continuationToken);
                        $jacocoInit[57] = true;
                        this.mRemote.transact(4, _data, _reply, 0);
                        $jacocoInit[58] = true;
                        _reply.readException();
                        $jacocoInit[59] = true;
                        if (_reply.readInt() != 0) {
                            $jacocoInit[60] = true;
                            _result = (Bundle) Bundle.CREATOR.createFromParcel(_reply);
                            $jacocoInit[61] = true;
                        } else {
                            _result = null;
                            $jacocoInit[62] = true;
                        }
                        _reply.recycle();
                        $jacocoInit[63] = true;
                        _data.recycle();
                        $jacocoInit[66] = true;
                        return _result;
                    } catch (Throwable th) {
                        th = th;
                        _reply.recycle();
                        $jacocoInit[64] = true;
                        _data.recycle();
                        $jacocoInit[65] = true;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    _reply.recycle();
                    $jacocoInit[64] = true;
                    _data.recycle();
                    $jacocoInit[65] = true;
                    throw th;
                }
            }

            public int consumePurchase(int apiVersion, String packageName, String purchaseToken) throws RemoteException {
                boolean[] $jacocoInit = $jacocoInit();
                Parcel _data = Parcel.obtain();
                $jacocoInit[67] = true;
                Parcel _reply = Parcel.obtain();
                try {
                    $jacocoInit[68] = true;
                    try {
                        _data.writeInterfaceToken(Stub.DESCRIPTOR);
                        $jacocoInit[69] = true;
                        _data.writeInt(apiVersion);
                        $jacocoInit[70] = true;
                        _data.writeString(packageName);
                        $jacocoInit[71] = true;
                        _data.writeString(purchaseToken);
                        $jacocoInit[72] = true;
                        this.mRemote.transact(5, _data, _reply, 0);
                        $jacocoInit[73] = true;
                        _reply.readException();
                        $jacocoInit[74] = true;
                        int _result = _reply.readInt();
                        $jacocoInit[75] = true;
                        _reply.recycle();
                        $jacocoInit[76] = true;
                        _data.recycle();
                        $jacocoInit[79] = true;
                        return _result;
                    } catch (Throwable th) {
                        th = th;
                        _reply.recycle();
                        $jacocoInit[77] = true;
                        _data.recycle();
                        $jacocoInit[78] = true;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    _reply.recycle();
                    $jacocoInit[77] = true;
                    _data.recycle();
                    $jacocoInit[78] = true;
                    throw th;
                }
            }
        }

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(4440814591030410988L, "cm/aptoide/pt/iab/AptoideInAppBillingService$Stub", 60);
            $jacocoData = probes;
            return probes;
        }

        public Stub() {
            boolean[] $jacocoInit = $jacocoInit();
            $jacocoInit[0] = true;
            attachInterface(this, DESCRIPTOR);
            $jacocoInit[1] = true;
        }

        public static AptoideInAppBillingService asInterface(IBinder obj) {
            boolean[] $jacocoInit = $jacocoInit();
            if (obj == null) {
                $jacocoInit[2] = true;
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null) {
                $jacocoInit[3] = true;
            } else if (!(iin instanceof AptoideInAppBillingService)) {
                $jacocoInit[4] = true;
            } else {
                AptoideInAppBillingService aptoideInAppBillingService = (AptoideInAppBillingService) iin;
                $jacocoInit[5] = true;
                return aptoideInAppBillingService;
            }
            Proxy proxy = new Proxy(obj);
            $jacocoInit[6] = true;
            return proxy;
        }

        public IBinder asBinder() {
            $jacocoInit()[7] = true;
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Bundle _arg3;
            int i = code;
            Parcel parcel = data;
            Parcel parcel2 = reply;
            boolean[] $jacocoInit = $jacocoInit();
            String descriptor = DESCRIPTOR;
            if (i == 1) {
                parcel.enforceInterface(descriptor);
                $jacocoInit[9] = true;
                int _arg0 = data.readInt();
                $jacocoInit[10] = true;
                String _arg1 = data.readString();
                $jacocoInit[11] = true;
                String _arg2 = data.readString();
                $jacocoInit[12] = true;
                int _result = isBillingSupported(_arg0, _arg1, _arg2);
                $jacocoInit[13] = true;
                reply.writeNoException();
                $jacocoInit[14] = true;
                parcel2.writeInt(_result);
                $jacocoInit[15] = true;
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(descriptor);
                $jacocoInit[16] = true;
                int _arg02 = data.readInt();
                $jacocoInit[17] = true;
                String _arg12 = data.readString();
                $jacocoInit[18] = true;
                String _arg22 = data.readString();
                $jacocoInit[19] = true;
                if (data.readInt() != 0) {
                    $jacocoInit[20] = true;
                    _arg3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    $jacocoInit[21] = true;
                } else {
                    _arg3 = null;
                    $jacocoInit[22] = true;
                }
                Bundle _result2 = getSkuDetails(_arg02, _arg12, _arg22, _arg3);
                $jacocoInit[23] = true;
                reply.writeNoException();
                if (_result2 != null) {
                    $jacocoInit[24] = true;
                    parcel2.writeInt(1);
                    $jacocoInit[25] = true;
                    _result2.writeToParcel(parcel2, 1);
                    $jacocoInit[26] = true;
                } else {
                    parcel2.writeInt(0);
                    $jacocoInit[27] = true;
                }
                $jacocoInit[28] = true;
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(descriptor);
                $jacocoInit[29] = true;
                int _arg03 = data.readInt();
                $jacocoInit[30] = true;
                String _arg13 = data.readString();
                $jacocoInit[31] = true;
                String _arg23 = data.readString();
                $jacocoInit[32] = true;
                String _arg32 = data.readString();
                $jacocoInit[33] = true;
                String _arg4 = data.readString();
                $jacocoInit[34] = true;
                Bundle _result3 = getBuyIntent(_arg03, _arg13, _arg23, _arg32, _arg4);
                $jacocoInit[35] = true;
                reply.writeNoException();
                if (_result3 != null) {
                    $jacocoInit[36] = true;
                    parcel2.writeInt(1);
                    $jacocoInit[37] = true;
                    _result3.writeToParcel(parcel2, 1);
                    $jacocoInit[38] = true;
                } else {
                    parcel2.writeInt(0);
                    $jacocoInit[39] = true;
                }
                $jacocoInit[40] = true;
                return true;
            } else if (i == 4) {
                parcel.enforceInterface(descriptor);
                $jacocoInit[41] = true;
                int _arg04 = data.readInt();
                $jacocoInit[42] = true;
                String _arg14 = data.readString();
                $jacocoInit[43] = true;
                String _arg24 = data.readString();
                $jacocoInit[44] = true;
                String _arg33 = data.readString();
                $jacocoInit[45] = true;
                Bundle _result4 = getPurchases(_arg04, _arg14, _arg24, _arg33);
                $jacocoInit[46] = true;
                reply.writeNoException();
                if (_result4 != null) {
                    $jacocoInit[47] = true;
                    parcel2.writeInt(1);
                    $jacocoInit[48] = true;
                    _result4.writeToParcel(parcel2, 1);
                    $jacocoInit[49] = true;
                } else {
                    parcel2.writeInt(0);
                    $jacocoInit[50] = true;
                }
                $jacocoInit[51] = true;
                return true;
            } else if (i == 5) {
                parcel.enforceInterface(descriptor);
                $jacocoInit[52] = true;
                int _arg05 = data.readInt();
                $jacocoInit[53] = true;
                String _arg15 = data.readString();
                $jacocoInit[54] = true;
                String _arg25 = data.readString();
                $jacocoInit[55] = true;
                int _result5 = consumePurchase(_arg05, _arg15, _arg25);
                $jacocoInit[56] = true;
                reply.writeNoException();
                $jacocoInit[57] = true;
                parcel2.writeInt(_result5);
                $jacocoInit[58] = true;
                return true;
            } else if (i != 1598968902) {
                boolean onTransact = super.onTransact(code, data, reply, flags);
                $jacocoInit[59] = true;
                return onTransact;
            } else {
                parcel2.writeString(descriptor);
                $jacocoInit[8] = true;
                return true;
            }
        }
    }

    int consumePurchase(int i, String str, String str2) throws RemoteException;

    Bundle getBuyIntent(int i, String str, String str2, String str3, String str4) throws RemoteException;

    Bundle getPurchases(int i, String str, String str2, String str3) throws RemoteException;

    Bundle getSkuDetails(int i, String str, String str2, Bundle bundle) throws RemoteException;

    int isBillingSupported(int i, String str, String str2) throws RemoteException;
}
