package com.unity3d.services.core.device;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.unity3d.services.core.log.DeviceLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@TargetApi(9)
public class AdvertisingId {
    private static final String ADVERTISING_ID_SERVICE_NAME = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";
    private static AdvertisingId instance = null;
    private String advertisingIdentifier = null;
    private boolean limitedAdvertisingTracking = false;

    private interface GoogleAdvertisingInfo extends IInterface {

        public static abstract class GoogleAdvertisingInfoBinder extends Binder implements GoogleAdvertisingInfo {

            private static class GoogleAdvertisingInfoImplementation implements GoogleAdvertisingInfo {
                private final IBinder _binder;

                GoogleAdvertisingInfoImplementation(IBinder binder) {
                    this._binder = binder;
                }

                public IBinder asBinder() {
                    return this._binder;
                }

                public String getId() throws RemoteException {
                    Parcel localParcel1 = Parcel.obtain();
                    Parcel localParcel2 = Parcel.obtain();
                    try {
                        localParcel1.writeInterfaceToken(AdvertisingId.ADVERTISING_ID_SERVICE_NAME);
                        this._binder.transact(1, localParcel1, localParcel2, 0);
                        localParcel2.readException();
                        return localParcel2.readString();
                    } finally {
                        localParcel2.recycle();
                        localParcel1.recycle();
                    }
                }

                public boolean getEnabled(boolean paramBoolean) throws RemoteException {
                    Parcel localParcel1 = Parcel.obtain();
                    Parcel localParcel2 = Parcel.obtain();
                    try {
                        localParcel1.writeInterfaceToken(AdvertisingId.ADVERTISING_ID_SERVICE_NAME);
                        boolean bool = true;
                        localParcel1.writeInt(paramBoolean ? 1 : 0);
                        this._binder.transact(2, localParcel1, localParcel2, 0);
                        localParcel2.readException();
                        if (localParcel2.readInt() == 0) {
                            bool = false;
                        }
                        return bool;
                    } finally {
                        localParcel2.recycle();
                        localParcel1.recycle();
                    }
                }
            }

            public static GoogleAdvertisingInfo create(IBinder binder) {
                if (binder == null) {
                    return null;
                }
                IInterface localIInterface = binder.queryLocalInterface(AdvertisingId.ADVERTISING_ID_SERVICE_NAME);
                if (localIInterface == null || !(localIInterface instanceof GoogleAdvertisingInfo)) {
                    return new GoogleAdvertisingInfoImplementation(binder);
                }
                return (GoogleAdvertisingInfo) localIInterface;
            }

            public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
                String str = AdvertisingId.ADVERTISING_ID_SERVICE_NAME;
                if (code == 1) {
                    data.enforceInterface(str);
                    String str1 = getId();
                    reply.writeNoException();
                    reply.writeString(str1);
                    return true;
                } else if (code != 2) {
                    return super.onTransact(code, data, reply, flags);
                } else {
                    data.enforceInterface(str);
                    int i = 0;
                    boolean bool2 = getEnabled(data.readInt() != 0);
                    reply.writeNoException();
                    if (bool2) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                }
            }
        }

        boolean getEnabled(boolean z) throws RemoteException;

        String getId() throws RemoteException;
    }

    private class GoogleAdvertisingServiceConnection implements ServiceConnection {
        private final BlockingQueue<IBinder> _binderQueue;
        boolean _consumed;

        private GoogleAdvertisingServiceConnection() {
            this._consumed = false;
            this._binderQueue = new LinkedBlockingQueue();
        }

        public void onServiceConnected(ComponentName name, IBinder service) {
            try {
                this._binderQueue.put(service);
            } catch (InterruptedException e) {
                DeviceLog.debug("Couldn't put service to binder que");
            }
        }

        public void onServiceDisconnected(ComponentName name) {
        }

        public IBinder getBinder() throws InterruptedException {
            if (!this._consumed) {
                this._consumed = true;
                return (IBinder) this._binderQueue.take();
            }
            throw new IllegalStateException();
        }
    }

    private static AdvertisingId getInstance() {
        if (instance == null) {
            instance = new AdvertisingId();
        }
        return instance;
    }

    public static void init(Context context) {
        getInstance().fetchAdvertisingId(context);
    }

    public static String getAdvertisingTrackingId() {
        return getInstance().advertisingIdentifier;
    }

    public static boolean getLimitedAdTracking() {
        return getInstance().limitedAdvertisingTracking;
    }

    private void fetchAdvertisingId(Context context) {
        GoogleAdvertisingServiceConnection connection = new GoogleAdvertisingServiceConnection();
        Intent localIntent = new Intent("com.google.android.gms.ads.identifier.service.START");
        localIntent.setPackage("com.google.android.gms");
        boolean didBind = false;
        try {
            didBind = context.bindService(localIntent, connection, 1);
        } catch (Exception e) {
            DeviceLog.exception("Couldn't bind to identifier service intent", e);
        }
        if (didBind) {
            try {
                GoogleAdvertisingInfo advertisingInfo = GoogleAdvertisingInfoBinder.create(connection.getBinder());
                this.advertisingIdentifier = advertisingInfo.getId();
                this.limitedAdvertisingTracking = advertisingInfo.getEnabled(true);
            } catch (Exception e2) {
                DeviceLog.exception("Couldn't get advertising info", e2);
                if (!didBind) {
                    return;
                }
            } catch (Throwable th) {
                if (didBind) {
                    context.unbindService(connection);
                }
                throw th;
            }
        }
        if (!didBind) {
            return;
        }
        context.unbindService(connection);
    }
}
