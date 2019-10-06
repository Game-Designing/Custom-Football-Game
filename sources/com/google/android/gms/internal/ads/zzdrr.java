package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrr;
import java.io.IOException;

public class zzdrr<M extends zzdrr<M>> extends zzdrw {

    /* renamed from: b */
    protected zzdrt f28156b = null;

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo31672c() {
        if (this.f28156b != null) {
            for (int i = 0; i < this.f28156b.mo31676a(); i++) {
                this.f28156b.mo31677a(i).mo28974a();
            }
        }
        return 0;
    }

    /* renamed from: a */
    public void mo31670a(zzdrp zzdrp) throws IOException {
        if (this.f28156b != null) {
            for (int i = 0; i < this.f28156b.mo31676a(); i++) {
                this.f28156b.mo31677a(i).mo28975a(zzdrp);
            }
        }
    }

    /* renamed from: b */
    public final /* synthetic */ zzdrw mo31671b() throws CloneNotSupportedException {
        return (zzdrr) clone();
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzdrr zzdrr = (zzdrr) super.clone();
        zzdrv.m30018a(this, zzdrr);
        return zzdrr;
    }
}
