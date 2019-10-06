package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.facebook.C6787r;
import com.facebook.FacebookException;
import com.mopub.common.GpsHelper;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.internal.b */
/* compiled from: AttributionIdentifiers */
public class C6709b {

    /* renamed from: a */
    private static final String f12267a = C6709b.class.getCanonicalName();

    /* renamed from: b */
    private static C6709b f12268b;

    /* renamed from: c */
    private String f12269c;

    /* renamed from: d */
    private String f12270d;

    /* renamed from: e */
    private String f12271e;

    /* renamed from: f */
    private boolean f12272f;

    /* renamed from: g */
    private long f12273g;

    /* renamed from: com.facebook.internal.b$a */
    /* compiled from: AttributionIdentifiers */
    private static final class C6710a implements IInterface {

        /* renamed from: a */
        private IBinder f12274a;

        C6710a(IBinder binder) {
            this.f12274a = binder;
        }

        public IBinder asBinder() {
            return this.f12274a;
        }

        /* renamed from: a */
        public String mo19954a() throws RemoteException {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f12274a.transact(1, data, reply, 0);
                reply.readException();
                return reply.readString();
            } finally {
                reply.recycle();
                data.recycle();
            }
        }

        /* renamed from: b */
        public boolean mo19956b() throws RemoteException {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean limitAdTracking = true;
                data.writeInt(1);
                this.f12274a.transact(2, data, reply, 0);
                reply.readException();
                if (reply.readInt() == 0) {
                    limitAdTracking = false;
                }
                return limitAdTracking;
            } finally {
                reply.recycle();
                data.recycle();
            }
        }
    }

    /* renamed from: com.facebook.internal.b$b */
    /* compiled from: AttributionIdentifiers */
    private static final class C6711b implements ServiceConnection {

        /* renamed from: a */
        private AtomicBoolean f12275a;

        /* renamed from: b */
        private final BlockingQueue<IBinder> f12276b;

        private C6711b() {
            this.f12275a = new AtomicBoolean(false);
            this.f12276b = new LinkedBlockingDeque();
        }

        public void onServiceConnected(ComponentName name, IBinder service) {
            if (service != null) {
                try {
                    this.f12276b.put(service);
                } catch (InterruptedException e) {
                }
            }
        }

        public void onServiceDisconnected(ComponentName name) {
        }

        /* renamed from: a */
        public IBinder mo19957a() throws InterruptedException {
            if (!this.f12275a.compareAndSet(true, true)) {
                return (IBinder) this.f12276b.take();
            }
            throw new IllegalStateException("Binder already consumed");
        }
    }

    /* renamed from: b */
    private static C6709b m13510b(Context context) {
        C6709b identifiers = m13511c(context);
        if (identifiers != null) {
            return identifiers;
        }
        C6709b identifiers2 = m13512d(context);
        if (identifiers2 == null) {
            return new C6709b();
        }
        return identifiers2;
    }

    /* renamed from: c */
    private static C6709b m13511c(Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new FacebookException("getAndroidId cannot be called on the main thread.");
            } else if (!m13514f(context)) {
                return null;
            } else {
                Method getAdvertisingIdInfo = C6694S.m13408a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", (Class<?>[]) new Class[]{Context.class});
                if (getAdvertisingIdInfo == null) {
                    return null;
                }
                Object advertisingInfo = C6694S.m13399a((Object) null, getAdvertisingIdInfo, context);
                if (advertisingInfo == null) {
                    return null;
                }
                Method getId = C6694S.m13407a(advertisingInfo.getClass(), "getId", (Class<?>[]) new Class[0]);
                Method isLimitAdTrackingEnabled = C6694S.m13407a(advertisingInfo.getClass(), GpsHelper.IS_LIMIT_AD_TRACKING_ENABLED_KEY, (Class<?>[]) new Class[0]);
                if (getId != null) {
                    if (isLimitAdTrackingEnabled != null) {
                        C6709b identifiers = new C6709b();
                        identifiers.f12270d = (String) C6694S.m13399a(advertisingInfo, getId, new Object[0]);
                        identifiers.f12272f = ((Boolean) C6694S.m13399a(advertisingInfo, isLimitAdTrackingEnabled, new Object[0])).booleanValue();
                        return identifiers;
                    }
                }
                return null;
            }
        } catch (Exception e) {
            C6694S.m13422a("android_id", e);
            return null;
        }
    }

    /* renamed from: f */
    private static boolean m13514f(Context context) {
        Method method = C6694S.m13408a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
        if (method == null) {
            return false;
        }
        Object connectionResult = C6694S.m13399a((Object) null, method, context);
        return (connectionResult instanceof Integer) && ((Integer) connectionResult).intValue() == 0;
    }

    /* renamed from: d */
    private static C6709b m13512d(Context context) {
        if (!m13514f(context)) {
            return null;
        }
        C6711b connection = new C6711b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, connection, 1)) {
            try {
                C6710a adInfo = new C6710a(connection.mo19957a());
                C6709b identifiers = new C6709b();
                identifiers.f12270d = adInfo.mo19954a();
                identifiers.f12272f = adInfo.mo19956b();
                return identifiers;
            } catch (Exception exception) {
                C6694S.m13422a("android_id", exception);
            } finally {
                context.unbindService(connection);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C6709b m13508a(Context context) {
        Uri providerUri;
        String str = "limit_tracking";
        String str2 = "androidid";
        String str3 = "aid";
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.e(f12267a, "getAttributionIdentifiers should not be called from the main thread");
        }
        if (f12268b != null) {
            long currentTimeMillis = System.currentTimeMillis();
            C6709b bVar = f12268b;
            if (currentTimeMillis - bVar.f12273g < 3600000) {
                return bVar;
            }
        }
        C6709b identifiers = m13510b(context);
        Cursor c = null;
        try {
            String[] projection = {str3, str2, str};
            if (context.getPackageManager().resolveContentProvider("com.facebook.katana.provider.AttributionIdProvider", 0) != null) {
                providerUri = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
            } else if (context.getPackageManager().resolveContentProvider("com.facebook.wakizashi.provider.AttributionIdProvider", 0) != null) {
                providerUri = Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider");
            } else {
                providerUri = null;
            }
            String installerPackageName = m13513e(context);
            if (installerPackageName != null) {
                identifiers.f12271e = installerPackageName;
            }
            if (providerUri == null) {
                m13509a(identifiers);
                if (c != null) {
                    c.close();
                }
                return identifiers;
            }
            c = context.getContentResolver().query(providerUri, projection, null, null, null);
            if (c != null) {
                if (c.moveToFirst()) {
                    int attributionColumnIndex = c.getColumnIndex(str3);
                    int androidIdColumnIndex = c.getColumnIndex(str2);
                    int limitTrackingColumnIndex = c.getColumnIndex(str);
                    identifiers.f12269c = c.getString(attributionColumnIndex);
                    if (androidIdColumnIndex > 0 && limitTrackingColumnIndex > 0 && identifiers.mo19950a() == null) {
                        identifiers.f12270d = c.getString(androidIdColumnIndex);
                        identifiers.f12272f = Boolean.parseBoolean(c.getString(limitTrackingColumnIndex));
                    }
                    if (c != null) {
                        c.close();
                    }
                    m13509a(identifiers);
                    return identifiers;
                }
            }
            m13509a(identifiers);
            if (c != null) {
                c.close();
            }
            return identifiers;
        } catch (Exception e) {
            String str4 = f12267a;
            StringBuilder sb = new StringBuilder();
            sb.append("Caught unexpected exception in getAttributionId(): ");
            sb.append(e.toString());
            C6694S.m13433b(str4, sb.toString());
            if (c != null) {
                c.close();
            }
            return null;
        } catch (Throwable th) {
            if (c != null) {
                c.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static C6709b m13509a(C6709b identifiers) {
        identifiers.f12273g = System.currentTimeMillis();
        f12268b = identifiers;
        return identifiers;
    }

    /* renamed from: c */
    public String mo19952c() {
        return this.f12269c;
    }

    /* renamed from: a */
    public String mo19950a() {
        if (!C6787r.m13829s() || !C6787r.m13814d()) {
            return null;
        }
        return this.f12270d;
    }

    /* renamed from: b */
    public String mo19951b() {
        return this.f12271e;
    }

    /* renamed from: d */
    public boolean mo19953d() {
        return this.f12272f;
    }

    /* renamed from: e */
    private static String m13513e(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            return packageManager.getInstallerPackageName(context.getPackageName());
        }
        return null;
    }
}
