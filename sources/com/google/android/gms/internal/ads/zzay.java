package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzay implements zzba {

    /* renamed from: a */
    private static Logger f24969a = Logger.getLogger(zzay.class.getName());

    /* renamed from: b */
    private ThreadLocal<ByteBuffer> f24970b = new C9830yc(this);

    /* renamed from: a */
    public abstract zzbd mo29198a(String str, byte[] bArr, String str2);

    /* renamed from: a */
    public final zzbd mo30261a(zzdsw zzdsw, zzbe zzbe) throws IOException {
        int read;
        long j;
        long j2;
        zzdsw zzdsw2 = zzdsw;
        zzbe zzbe2 = zzbe;
        long position = zzdsw.position();
        ((ByteBuffer) this.f24970b.get()).rewind().limit(8);
        do {
            read = zzdsw2.read((ByteBuffer) this.f24970b.get());
            if (read == 8) {
                ((ByteBuffer) this.f24970b.get()).rewind();
                long a = zzbc.m26411a((ByteBuffer) this.f24970b.get());
                byte[] bArr = null;
                if (a >= 8 || a <= 1) {
                    String f = zzbc.m26416f((ByteBuffer) this.f24970b.get());
                    if (a == 1) {
                        ((ByteBuffer) this.f24970b.get()).limit(16);
                        zzdsw2.read((ByteBuffer) this.f24970b.get());
                        ((ByteBuffer) this.f24970b.get()).position(8);
                        j = zzbc.m26413c((ByteBuffer) this.f24970b.get()) - 16;
                    } else if (a == 0) {
                        j = zzdsw.size() - zzdsw.position();
                    } else {
                        j = a - 8;
                    }
                    if ("uuid".equals(f)) {
                        ((ByteBuffer) this.f24970b.get()).limit(((ByteBuffer) this.f24970b.get()).limit() + 16);
                        zzdsw2.read((ByteBuffer) this.f24970b.get());
                        bArr = new byte[16];
                        for (int position2 = ((ByteBuffer) this.f24970b.get()).position() - 16; position2 < ((ByteBuffer) this.f24970b.get()).position(); position2++) {
                            bArr[position2 - (((ByteBuffer) this.f24970b.get()).position() - 16)] = ((ByteBuffer) this.f24970b.get()).get(position2);
                        }
                        j2 = j - 16;
                    } else {
                        j2 = j;
                    }
                    zzbd a2 = mo29198a(f, bArr, zzbe2 instanceof zzbd ? ((zzbd) zzbe2).getType() : "");
                    a2.mo30419a(zzbe2);
                    ((ByteBuffer) this.f24970b.get()).rewind();
                    a2.mo30420a(zzdsw, (ByteBuffer) this.f24970b.get(), j2, this);
                    return a2;
                }
                Logger logger = f24969a;
                Level level = Level.SEVERE;
                StringBuilder sb = new StringBuilder(80);
                sb.append("Plausibility check failed: size < 8 (size = ");
                sb.append(a);
                sb.append("). Stop parsing!");
                logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                return null;
            }
        } while (read >= 0);
        zzdsw2.mo29175g(position);
        throw new EOFException();
    }
}
