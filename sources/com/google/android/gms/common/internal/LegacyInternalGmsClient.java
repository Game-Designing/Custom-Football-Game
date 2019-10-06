package com.google.android.gms.common.internal;

import android.os.IInterface;
import com.google.android.gms.common.ConnectionResult;

@Deprecated
public abstract class LegacyInternalGmsClient<T extends IInterface> extends GmsClient<T> {

    /* renamed from: F */
    private final GmsClientEventManager f20114F;

    public void checkAvailabilityAndConnect() {
        this.f20114F.mo27787b();
        super.checkAvailabilityAndConnect();
    }

    public void disconnect() {
        this.f20114F.mo27781a();
        super.disconnect();
    }

    /* renamed from: a */
    public void mo27706a(T t) {
        super.mo27706a(t);
        this.f20114F.mo27783a(getConnectionHint());
    }

    /* renamed from: a */
    public void mo27702a(int i) {
        super.mo27702a(i);
        this.f20114F.mo27782a(i);
    }

    /* renamed from: a */
    public void mo27707a(ConnectionResult connectionResult) {
        super.mo27707a(connectionResult);
        this.f20114F.mo27784a(connectionResult);
    }

    public int getMinApkVersion() {
        return super.getMinApkVersion();
    }
}
