package p019d.p307j.p308a.p311c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.liulishuo.filedownloader.message.MessageSnapshot;

/* renamed from: d.j.a.c.a */
/* compiled from: IFileDownloadIPCCallback */
public interface C13097a extends IInterface {

    /* renamed from: d.j.a.c.a$a */
    /* compiled from: IFileDownloadIPCCallback */
    public static abstract class C13098a extends Binder implements C13097a {

        /* renamed from: d.j.a.c.a$a$a */
        /* compiled from: IFileDownloadIPCCallback */
        private static class C13099a implements C13097a {

            /* renamed from: a */
            private IBinder f40093a;

            C13099a(IBinder remote) {
                this.f40093a = remote;
            }

            public IBinder asBinder() {
                return this.f40093a;
            }

            /* renamed from: a */
            public void mo42070a(MessageSnapshot snapshot) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
                    if (snapshot != null) {
                        _data.writeInt(1);
                        snapshot.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.f40093a.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public C13098a() {
            attachInterface(this, "com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
        }

        /* renamed from: a */
        public static C13097a m42654a(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
            if (iin == null || !(iin instanceof C13097a)) {
                return new C13099a(obj);
            }
            return (C13097a) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            MessageSnapshot _arg0;
            String str = "com.liulishuo.filedownloader.i.IFileDownloadIPCCallback";
            if (code == 1) {
                data.enforceInterface(str);
                if (data.readInt() != 0) {
                    _arg0 = (MessageSnapshot) MessageSnapshot.CREATOR.createFromParcel(data);
                } else {
                    _arg0 = null;
                }
                mo42070a(_arg0);
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
    void mo42070a(MessageSnapshot messageSnapshot) throws RemoteException;
}
