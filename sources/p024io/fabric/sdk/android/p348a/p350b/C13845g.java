package p024io.fabric.sdk.android.p348a.p350b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import p024io.fabric.sdk.android.C13920f;

/* renamed from: io.fabric.sdk.android.a.b.g */
/* compiled from: AdvertisingInfoServiceStrategy */
class C13845g implements C13848h {

    /* renamed from: a */
    private final Context f42023a;

    /* renamed from: io.fabric.sdk.android.a.b.g$a */
    /* compiled from: AdvertisingInfoServiceStrategy */
    private static final class C13846a implements ServiceConnection {

        /* renamed from: a */
        private boolean f42024a;

        /* renamed from: b */
        private final LinkedBlockingQueue<IBinder> f42025b;

        private C13846a() {
            this.f42024a = false;
            this.f42025b = new LinkedBlockingQueue<>(1);
        }

        public void onServiceConnected(ComponentName name, IBinder service) {
            try {
                this.f42025b.put(service);
            } catch (InterruptedException e) {
            }
        }

        public void onServiceDisconnected(ComponentName name) {
            this.f42025b.clear();
        }

        /* renamed from: a */
        public IBinder mo43230a() {
            if (this.f42024a) {
                C13920f.m44245e().mo43324b("Fabric", "getBinder already called");
            }
            this.f42024a = true;
            try {
                return (IBinder) this.f42025b.poll(200, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                return null;
            }
        }
    }

    /* renamed from: io.fabric.sdk.android.a.b.g$b */
    /* compiled from: AdvertisingInfoServiceStrategy */
    private static final class C13847b implements IInterface {

        /* renamed from: a */
        private final IBinder f42026a;

        public C13847b(IBinder binder) {
            this.f42026a = binder;
        }

        public IBinder asBinder() {
            return this.f42026a;
        }

        public String getId() throws RemoteException {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            String id = null;
            try {
                data.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f42026a.transact(1, data, reply, 0);
                reply.readException();
                id = reply.readString();
            } catch (Exception e) {
                C13920f.m44245e().mo43326c("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
            } catch (Throwable th) {
                reply.recycle();
                data.recycle();
                throw th;
            }
            reply.recycle();
            data.recycle();
            return id;
        }

        /* renamed from: a */
        public boolean mo43233a() throws RemoteException {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            boolean limitAdTracking = false;
            try {
                data.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                data.writeInt(1);
                this.f42026a.transact(2, data, reply, 0);
                reply.readException();
                if (reply.readInt() == 0) {
                    z = false;
                }
                limitAdTracking = z;
            } catch (Exception e) {
                C13920f.m44245e().mo43326c("Fabric", "Could not get parcel from Google Play Service to capture Advertising limitAdTracking");
            } catch (Throwable th) {
                reply.recycle();
                data.recycle();
                throw th;
            }
            reply.recycle();
            data.recycle();
            return limitAdTracking;
        }
    }

    public C13845g(Context context) {
        this.f42023a = context.getApplicationContext();
    }

    /* renamed from: a */
    public C13840b mo43228a() {
        String str = "Could not bind to Google Play Service to capture AdvertisingId";
        String str2 = "Fabric";
        if (Looper.myLooper() == Looper.getMainLooper()) {
            C13920f.m44245e().mo43326c(str2, "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        try {
            this.f42023a.getPackageManager().getPackageInfo("com.android.vending", 0);
            C13846a connection = new C13846a();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (this.f42023a.bindService(intent, connection, 1)) {
                    try {
                        C13847b adInterface = new C13847b(connection.mo43230a());
                        C13840b bVar = new C13840b(adInterface.getId(), adInterface.mo43233a());
                        this.f42023a.unbindService(connection);
                        return bVar;
                    } catch (Exception e) {
                        C13920f.m44245e().mo43322a(str2, "Exception in binding to Google Play Service to capture AdvertisingId", (Throwable) e);
                        this.f42023a.unbindService(connection);
                    }
                } else {
                    C13920f.m44245e().mo43326c(str2, str);
                    return null;
                }
            } catch (Throwable t) {
                C13920f.m44245e().mo43327c(str2, str, t);
            }
        } catch (NameNotFoundException e2) {
            C13920f.m44245e().mo43326c(str2, "Unable to find Google Play Services package name");
            return null;
        } catch (Exception e3) {
            C13920f.m44245e().mo43327c(str2, "Unable to determine if Google Play Services is available", e3);
            return null;
        }
    }
}
