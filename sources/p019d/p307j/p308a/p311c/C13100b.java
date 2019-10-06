package p019d.p307j.p308a.p311c;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import p019d.p307j.p308a.p311c.C13097a.C13098a;

/* renamed from: d.j.a.c.b */
/* compiled from: IFileDownloadIPCService */
public interface C13100b extends IInterface {

    /* renamed from: d.j.a.c.b$a */
    /* compiled from: IFileDownloadIPCService */
    public static abstract class C13101a extends Binder implements C13100b {

        /* renamed from: d.j.a.c.b$a$a */
        /* compiled from: IFileDownloadIPCService */
        private static class C13102a implements C13100b {

            /* renamed from: a */
            private IBinder f40094a;

            C13102a(IBinder remote) {
                this.f40094a = remote;
            }

            public IBinder asBinder() {
                return this.f40094a;
            }

            /* renamed from: b */
            public void mo35785b(C13097a callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    _data.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    this.f40094a.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            /* renamed from: a */
            public void mo35781a(C13097a callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    _data.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    this.f40094a.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            /* renamed from: a */
            public void mo35782a(String url, String path, boolean pathAsDirectory, int callbackProgressTimes, int callbackProgressMinIntervalMillis, int autoRetryTimes, boolean forceReDownload, FileDownloadHeader header, boolean isWifiRequired) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    _data.writeString(url);
                    _data.writeString(path);
                    int i = 1;
                    _data.writeInt(pathAsDirectory ? 1 : 0);
                    _data.writeInt(callbackProgressTimes);
                    _data.writeInt(callbackProgressMinIntervalMillis);
                    _data.writeInt(autoRetryTimes);
                    _data.writeInt(forceReDownload ? 1 : 0);
                    if (header != null) {
                        _data.writeInt(1);
                        header.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if (!isWifiRequired) {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.f40094a.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /* renamed from: b */
            public boolean mo35786b(int downloadId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                boolean _result = false;
                try {
                    _data.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    _data.writeInt(downloadId);
                    this.f40094a.transact(5, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = true;
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /* renamed from: k */
            public void mo35791k() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    this.f40094a.transact(6, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /* renamed from: a */
            public byte mo35777a(int downloadId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    _data.writeInt(downloadId);
                    this.f40094a.transact(10, _data, _reply, 0);
                    _reply.readException();
                    return _reply.readByte();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /* renamed from: c */
            public boolean mo35787c(int id) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                boolean _result = false;
                try {
                    _data.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    _data.writeInt(id);
                    this.f40094a.transact(14, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = true;
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public C13101a() {
            attachInterface(this, "com.liulishuo.filedownloader.i.IFileDownloadIPCService");
        }

        /* renamed from: a */
        public static C13100b m42671a(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
            if (iin == null || !(iin instanceof C13100b)) {
                return new C13102a(obj);
            }
            return (C13100b) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            FileDownloadHeader _arg7;
            Notification _arg1;
            int i = code;
            Parcel parcel = data;
            Parcel parcel2 = reply;
            String _arg0 = "com.liulishuo.filedownloader.i.IFileDownloadIPCService";
            if (i != 1598968902) {
                boolean _arg02 = false;
                switch (i) {
                    case 1:
                        parcel.enforceInterface(_arg0);
                        mo35785b(C13098a.m42654a(data.readStrongBinder()));
                        return true;
                    case 2:
                        parcel.enforceInterface(_arg0);
                        mo35781a(C13098a.m42654a(data.readStrongBinder()));
                        return true;
                    case 3:
                        parcel.enforceInterface(_arg0);
                        boolean _result = mo35784a(data.readString(), data.readString());
                        reply.writeNoException();
                        if (_result) {
                            _arg02 = true;
                        }
                        parcel2.writeInt(_arg02 ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface(_arg0);
                        String _arg03 = data.readString();
                        String _arg12 = data.readString();
                        boolean _arg2 = data.readInt() != 0;
                        int _arg3 = data.readInt();
                        int _arg4 = data.readInt();
                        int _arg5 = data.readInt();
                        boolean _arg6 = data.readInt() != 0;
                        if (data.readInt() != 0) {
                            _arg7 = (FileDownloadHeader) FileDownloadHeader.CREATOR.createFromParcel(parcel);
                        } else {
                            _arg7 = null;
                        }
                        mo35782a(_arg03, _arg12, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, data.readInt() != 0);
                        reply.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(_arg0);
                        boolean _result2 = mo35786b(data.readInt());
                        reply.writeNoException();
                        if (_result2) {
                            _arg02 = true;
                        }
                        parcel2.writeInt(_arg02 ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface(_arg0);
                        mo35791k();
                        reply.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface(_arg0);
                        boolean _result3 = mo35789f(data.readInt());
                        reply.writeNoException();
                        if (_result3) {
                            _arg02 = true;
                        }
                        parcel2.writeInt(_arg02 ? 1 : 0);
                        return true;
                    case 8:
                        parcel.enforceInterface(_arg0);
                        long _result4 = mo35790g(data.readInt());
                        reply.writeNoException();
                        parcel2.writeLong(_result4);
                        return true;
                    case 9:
                        parcel.enforceInterface(_arg0);
                        long _result5 = mo35788e(data.readInt());
                        reply.writeNoException();
                        parcel2.writeLong(_result5);
                        return true;
                    case 10:
                        parcel.enforceInterface(_arg0);
                        byte _result6 = mo35777a(data.readInt());
                        reply.writeNoException();
                        parcel2.writeByte(_result6);
                        return true;
                    case 11:
                        parcel.enforceInterface(_arg0);
                        boolean _result7 = mo35776D();
                        reply.writeNoException();
                        if (_result7) {
                            _arg02 = true;
                        }
                        parcel2.writeInt(_arg02 ? 1 : 0);
                        return true;
                    case 12:
                        parcel.enforceInterface(_arg0);
                        int _arg04 = data.readInt();
                        if (data.readInt() != 0) {
                            _arg1 = (Notification) Notification.CREATOR.createFromParcel(parcel);
                        } else {
                            _arg1 = null;
                        }
                        mo35779a(_arg04, _arg1);
                        return true;
                    case 13:
                        parcel.enforceInterface(_arg0);
                        if (data.readInt() != 0) {
                            _arg02 = true;
                        }
                        mo35783a(_arg02);
                        return true;
                    case 14:
                        parcel.enforceInterface(_arg0);
                        boolean _result8 = mo35787c(data.readInt());
                        reply.writeNoException();
                        if (_result8) {
                            _arg02 = true;
                        }
                        parcel2.writeInt(_arg02 ? 1 : 0);
                        return true;
                    case 15:
                        parcel.enforceInterface(_arg0);
                        mo35793z();
                        reply.writeNoException();
                        return true;
                    default:
                        return super.onTransact(code, data, reply, flags);
                }
            } else {
                parcel2.writeString(_arg0);
                return true;
            }
        }
    }

    /* renamed from: D */
    boolean mo35776D() throws RemoteException;

    /* renamed from: a */
    byte mo35777a(int i) throws RemoteException;

    /* renamed from: a */
    void mo35779a(int i, Notification notification) throws RemoteException;

    /* renamed from: a */
    void mo35781a(C13097a aVar) throws RemoteException;

    /* renamed from: a */
    void mo35782a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3) throws RemoteException;

    /* renamed from: a */
    void mo35783a(boolean z) throws RemoteException;

    /* renamed from: a */
    boolean mo35784a(String str, String str2) throws RemoteException;

    /* renamed from: b */
    void mo35785b(C13097a aVar) throws RemoteException;

    /* renamed from: b */
    boolean mo35786b(int i) throws RemoteException;

    /* renamed from: c */
    boolean mo35787c(int i) throws RemoteException;

    /* renamed from: e */
    long mo35788e(int i) throws RemoteException;

    /* renamed from: f */
    boolean mo35789f(int i) throws RemoteException;

    /* renamed from: g */
    long mo35790g(int i) throws RemoteException;

    /* renamed from: k */
    void mo35791k() throws RemoteException;

    /* renamed from: z */
    void mo35793z() throws RemoteException;
}
