package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo.zzc;
import java.io.IOException;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.measurement.X */
final class C9940X extends C9938W<Object> {
    C9940X() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo32664a(zzvv zzvv) {
        return zzvv instanceof zzc;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final C9944Z<Object> mo32662a(Object obj) {
        return ((zzc) obj).zzbyl;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final C9944Z<Object> mo32665b(Object obj) {
        zzc zzc = (zzc) obj;
        if (zzc.zzbyl.mo32687c()) {
            zzc.zzbyl = (C9944Z) zzc.zzbyl.clone();
        }
        return zzc.zzbyl;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final void mo32666c(Object obj) {
        mo32662a(obj).mo32692f();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final int mo32661a(Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32663a(C9986lb lbVar, Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }
}
