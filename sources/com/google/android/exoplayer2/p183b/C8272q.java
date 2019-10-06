package com.google.android.exoplayer2.p183b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.C8535t;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.b.q */
/* compiled from: TrackOutput */
public interface C8272q {

    /* renamed from: com.google.android.exoplayer2.b.q$a */
    /* compiled from: TrackOutput */
    public static final class C8273a {

        /* renamed from: a */
        public final int f17518a;

        /* renamed from: b */
        public final byte[] f17519b;

        /* renamed from: c */
        public final int f17520c;

        /* renamed from: d */
        public final int f17521d;

        public C8273a(int cryptoMode, byte[] encryptionKey, int encryptedBlocks, int clearBlocks) {
            this.f17518a = cryptoMode;
            this.f17519b = encryptionKey;
            this.f17520c = encryptedBlocks;
            this.f17521d = clearBlocks;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C8273a other = (C8273a) obj;
            if (!(this.f17518a == other.f17518a && this.f17520c == other.f17520c && this.f17521d == other.f17521d && Arrays.equals(this.f17519b, other.f17519b))) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return (((((this.f17518a * 31) + Arrays.hashCode(this.f17519b)) * 31) + this.f17520c) * 31) + this.f17521d;
        }
    }

    /* renamed from: a */
    int mo25338a(C8261h hVar, int i, boolean z) throws IOException, InterruptedException;

    /* renamed from: a */
    void mo25339a(long j, int i, int i2, int i3, C8273a aVar);

    /* renamed from: a */
    void mo25340a(Format format);

    /* renamed from: a */
    void mo25341a(C8535t tVar, int i);
}
