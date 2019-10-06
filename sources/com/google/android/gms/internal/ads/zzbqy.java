package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

public class zzbqy {

    /* renamed from: a */
    private final Context f25818a;

    /* renamed from: b */
    private final zzcxv f25819b;

    /* renamed from: c */
    private final String f25820c;

    /* renamed from: d */
    private Bundle f25821d;

    public static class zza {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public Context f25822a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public zzcxv f25823b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public Bundle f25824c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public String f25825d;

        /* renamed from: a */
        public final zza mo30871a(Context context) {
            this.f25822a = context;
            return this;
        }

        /* renamed from: a */
        public final zza mo30873a(zzcxv zzcxv) {
            this.f25823b = zzcxv;
            return this;
        }

        /* renamed from: a */
        public final zza mo30872a(Bundle bundle) {
            this.f25824c = bundle;
            return this;
        }

        /* renamed from: a */
        public final zza mo30874a(String str) {
            this.f25825d = str;
            return this;
        }

        /* renamed from: a */
        public final zzbqy mo30875a() {
            return new zzbqy(this);
        }
    }

    private zzbqy(zza zza2) {
        this.f25818a = zza2.f25822a;
        this.f25819b = zza2.f25823b;
        this.f25821d = zza2.f25824c;
        this.f25820c = zza2.f25825d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final zza mo30867a() {
        return new zza().mo30871a(this.f25818a).mo30873a(this.f25819b).mo30874a(this.f25820c).mo30872a(this.f25821d);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final zzcxv mo30868b() {
        return this.f25819b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final Bundle mo30869c() {
        return this.f25821d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final String mo30870d() {
        return this.f25820c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final Context mo30866a(Context context) {
        if (this.f25820c != null) {
            return context;
        }
        return this.f25818a;
    }
}
