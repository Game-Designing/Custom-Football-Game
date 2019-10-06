package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract class GmsClientSupervisor {

    /* renamed from: a */
    private static final Object f20101a = new Object();

    /* renamed from: b */
    private static GmsClientSupervisor f20102b;

    protected static final class zza {

        /* renamed from: a */
        private final String f20103a;

        /* renamed from: b */
        private final String f20104b;

        /* renamed from: c */
        private final ComponentName f20105c = null;

        /* renamed from: d */
        private final int f20106d;

        public zza(String str, String str2, int i) {
            Preconditions.m21866b(str);
            this.f20103a = str;
            Preconditions.m21866b(str2);
            this.f20104b = str2;
            this.f20106d = i;
        }

        public final String toString() {
            String str = this.f20103a;
            return str == null ? this.f20105c.flattenToString() : str;
        }

        /* renamed from: b */
        public final String mo27795b() {
            return this.f20104b;
        }

        /* renamed from: a */
        public final ComponentName mo27793a() {
            return this.f20105c;
        }

        /* renamed from: c */
        public final int mo27796c() {
            return this.f20106d;
        }

        /* renamed from: a */
        public final Intent mo27794a(Context context) {
            String str = this.f20103a;
            if (str != null) {
                return new Intent(str).setPackage(this.f20104b);
            }
            return new Intent().setComponent(this.f20105c);
        }

        public final int hashCode() {
            return Objects.m21849a(this.f20103a, this.f20104b, this.f20105c, Integer.valueOf(this.f20106d));
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (!Objects.m21851a(this.f20103a, zza.f20103a) || !Objects.m21851a(this.f20104b, zza.f20104b) || !Objects.m21851a(this.f20105c, zza.f20105c) || this.f20106d != zza.f20106d) {
                return false;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo27791a(zza zza2, ServiceConnection serviceConnection, String str);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo27792b(zza zza2, ServiceConnection serviceConnection, String str);

    @KeepForSdk
    /* renamed from: a */
    public static GmsClientSupervisor m21825a(Context context) {
        synchronized (f20101a) {
            if (f20102b == null) {
                f20102b = new C8709j(context.getApplicationContext());
            }
        }
        return f20102b;
    }

    /* renamed from: a */
    public final void mo27790a(String str, String str2, int i, ServiceConnection serviceConnection, String str3) {
        mo27792b(new zza(str, str2, i), serviceConnection, str3);
    }
}
