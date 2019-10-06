package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

@zzard
public final class zzbfl {

    /* renamed from: a */
    private long f25270a;

    /* renamed from: a */
    public final long mo30534a(ByteBuffer byteBuffer) {
        zzbg zzbg;
        zzbf zzbf;
        long j = this.f25270a;
        if (j > 0) {
            return j;
        }
        try {
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.flip();
            Iterator it = new zzbb(new C9727te(duplicate), C9748ue.f23052c).mo31687a().iterator();
            while (true) {
                zzbg = null;
                if (!it.hasNext()) {
                    zzbf = null;
                    break;
                }
                zzbd zzbd = (zzbd) it.next();
                if (zzbd instanceof zzbf) {
                    zzbf = (zzbf) zzbd;
                    break;
                }
            }
            Iterator it2 = zzbf.mo31687a().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                zzbd zzbd2 = (zzbd) it2.next();
                if (zzbd2 instanceof zzbg) {
                    zzbg = (zzbg) zzbd2;
                    break;
                }
            }
            this.f25270a = (zzbg.mo30554c() * 1000) / zzbg.mo30555d();
            return this.f25270a;
        } catch (IOException | RuntimeException e) {
            return 0;
        }
    }
}
