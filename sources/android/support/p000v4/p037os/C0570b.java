package android.support.p000v4.p037os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: android.support.v4.os.b */
/* compiled from: IResultReceiver */
public interface C0570b extends IInterface {

    /* renamed from: android.support.v4.os.b$a */
    /* compiled from: IResultReceiver */
    public static abstract class C0571a extends Binder implements C0570b {

        /* renamed from: android.support.v4.os.b$a$a */
        /* compiled from: IResultReceiver */
        private static class C0572a implements C0570b {

            /* renamed from: a */
            private IBinder f1790a;

            C0572a(IBinder remote) {
                this.f1790a = remote;
            }

            public IBinder asBinder() {
                return this.f1790a;
            }

            /* renamed from: a */
            public void mo5443a(int resultCode, Bundle resultData) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("android.support.v4.os.IResultReceiver");
                    _data.writeInt(resultCode);
                    if (resultData != null) {
                        _data.writeInt(1);
                        resultData.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.f1790a.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public C0571a() {
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        /* renamed from: a */
        public static C0570b m2752a(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface("android.support.v4.os.IResultReceiver");
            if (iin == null || !(iin instanceof C0570b)) {
                return new C0572a(obj);
            }
            return (C0570b) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Bundle _arg1;
            String str = "android.support.v4.os.IResultReceiver";
            if (code == 1) {
                data.enforceInterface(str);
                int _arg0 = data.readInt();
                if (data.readInt() != 0) {
                    _arg1 = (Bundle) Bundle.CREATOR.createFromParcel(data);
                } else {
                    _arg1 = null;
                }
                mo5443a(_arg0, _arg1);
                return true;
            } else if (code != 1598968902) {
                return super.onTransact(code, data, reply, flags);
            } else {
                reply.writeString(str);
                return true;
            }
        }
    }

    /* renamed from: a */
    void mo5443a(int i, Bundle bundle) throws RemoteException;
}
