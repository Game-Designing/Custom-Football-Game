package android.support.p000v4.media.session;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: android.support.v4.media.session.b */
/* compiled from: IMediaSession */
public interface C0544b extends IInterface {

    /* renamed from: android.support.v4.media.session.b$a */
    /* compiled from: IMediaSession */
    public static abstract class C0545a extends Binder implements C0544b {

        /* renamed from: android.support.v4.media.session.b$a$a */
        /* compiled from: IMediaSession */
        private static class C0546a implements C0544b {

            /* renamed from: a */
            private IBinder f1774a;

            C0546a(IBinder remote) {
                this.f1774a = remote;
            }

            public IBinder asBinder() {
                return this.f1774a;
            }

            /* renamed from: a */
            public void mo5399a(C0542a cb) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    _data.writeStrongBinder(cb != null ? cb.asBinder() : null);
                    this.f1774a.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        /* renamed from: a */
        public static C0544b m2688a(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            if (iin == null || !(iin instanceof C0544b)) {
                return new C0546a(obj);
            }
            return (C0544b) iin;
        }
    }

    /* renamed from: a */
    void mo5399a(C0542a aVar) throws RemoteException;
}
