package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.lang.ref.WeakReference;

public class zzbjn {

    /* renamed from: a */
    private final zzbai f25415a;

    /* renamed from: b */
    private final Context f25416b;

    /* renamed from: c */
    private final WeakReference<Context> f25417c;

    public static class zza {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public zzbai f25418a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public Context f25419b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public WeakReference<Context> f25420c;

        /* renamed from: a */
        public final zza mo30708a(zzbai zzbai) {
            this.f25418a = zzbai;
            return this;
        }

        /* renamed from: a */
        public final zza mo30707a(Context context) {
            this.f25420c = new WeakReference<>(context);
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f25419b = context;
            return this;
        }
    }

    private zzbjn(zza zza2) {
        this.f25415a = zza2.f25418a;
        this.f25416b = zza2.f25419b;
        this.f25417c = zza2.f25420c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final Context mo30703a() {
        return this.f25416b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final Context mo30704b() {
        if (this.f25417c.get() != null) {
            return (Context) this.f25417c.get();
        }
        return this.f25416b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final zzbai mo30705c() {
        return this.f25415a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final String mo30706d() {
        return zzk.zzlg().mo30237b(this.f25416b, this.f25415a.f25057a);
    }
}
