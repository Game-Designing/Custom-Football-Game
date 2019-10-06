package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@KeepForSdk
public class BlockingServiceConnection implements ServiceConnection {

    /* renamed from: a */
    private boolean f19508a = false;

    /* renamed from: b */
    private final BlockingQueue<IBinder> f19509b = new LinkedBlockingQueue();

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f19509b.add(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }

    @KeepForSdk
    /* renamed from: a */
    public IBinder mo27272a(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        Preconditions.m21870c("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (!this.f19508a) {
            this.f19508a = true;
            IBinder iBinder = (IBinder) this.f19509b.poll(j, timeUnit);
            if (iBinder != null) {
                return iBinder;
            }
            throw new TimeoutException("Timed out waiting for the service connection");
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }
}
