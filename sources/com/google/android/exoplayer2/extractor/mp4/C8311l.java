package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.C8526n;
import com.google.android.exoplayer2.util.C8535t;
import java.util.UUID;

/* renamed from: com.google.android.exoplayer2.extractor.mp4.l */
/* compiled from: PsshAtomUtil */
public final class C8311l {

    /* renamed from: com.google.android.exoplayer2.extractor.mp4.l$a */
    /* compiled from: PsshAtomUtil */
    private static class C8312a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final UUID f17858a;

        /* renamed from: b */
        private final int f17859b;

        /* renamed from: c */
        private final byte[] f17860c;

        public C8312a(UUID uuid, int version, byte[] schemeData) {
            this.f17858a = uuid;
            this.f17859b = version;
            this.f17860c = schemeData;
        }
    }

    /* renamed from: a */
    public static UUID m19418a(byte[] atom) {
        C8312a parsedAtom = m19419b(atom);
        if (parsedAtom == null) {
            return null;
        }
        return parsedAtom.f17858a;
    }

    /* renamed from: b */
    private static C8312a m19419b(byte[] atom) {
        C8535t atomData = new C8535t(atom);
        if (atomData.mo26115d() < 32) {
            return null;
        }
        atomData.mo26118e(0);
        if (atomData.mo26119f() != atomData.mo26104a() + 4 || atomData.mo26119f() != C8290c.f17646U) {
            return null;
        }
        int atomVersion = C8290c.m19289c(atomData.mo26119f());
        if (atomVersion > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unsupported pssh version: ");
            sb.append(atomVersion);
            C8526n.m20534d("PsshAtomUtil", sb.toString());
            return null;
        }
        UUID uuid = new UUID(atomData.mo26127m(), atomData.mo26127m());
        if (atomVersion == 1) {
            atomData.mo26120f(atomData.mo26135u() * 16);
        }
        int dataSize = atomData.mo26135u();
        if (dataSize != atomData.mo26104a()) {
            return null;
        }
        byte[] data = new byte[dataSize];
        atomData.mo26110a(data, 0, dataSize);
        return new C8312a(uuid, atomVersion, data);
    }
}
