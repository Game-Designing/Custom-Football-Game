package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.p183b.C8272q.C8273a;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8526n;

/* renamed from: com.google.android.exoplayer2.extractor.mp4.o */
/* compiled from: TrackEncryptionBox */
public final class C8315o {

    /* renamed from: a */
    public final boolean f17873a;

    /* renamed from: b */
    public final String f17874b;

    /* renamed from: c */
    public final C8273a f17875c;

    /* renamed from: d */
    public final int f17876d;

    /* renamed from: e */
    public final byte[] f17877e;

    public C8315o(boolean isEncrypted, String schemeType, int perSampleIvSize, byte[] keyId, int defaultEncryptedBlocks, int defaultClearBlocks, byte[] defaultInitializationVector) {
        boolean z = true;
        boolean z2 = perSampleIvSize == 0;
        if (defaultInitializationVector != null) {
            z = false;
        }
        C8514e.m20488a(z ^ z2);
        this.f17873a = isEncrypted;
        this.f17874b = schemeType;
        this.f17876d = perSampleIvSize;
        this.f17877e = defaultInitializationVector;
        this.f17875c = new C8273a(m19426a(schemeType), keyId, defaultEncryptedBlocks, defaultClearBlocks);
    }

    /* renamed from: a */
    private static int m19426a(String schemeType) {
        if (schemeType == null) {
            return 1;
        }
        char c = 65535;
        switch (schemeType.hashCode()) {
            case 3046605:
                if (schemeType.equals("cbc1")) {
                    c = 2;
                    break;
                }
                break;
            case 3046671:
                if (schemeType.equals("cbcs")) {
                    c = 3;
                    break;
                }
                break;
            case 3049879:
                if (schemeType.equals("cenc")) {
                    c = 0;
                    break;
                }
                break;
            case 3049895:
                if (schemeType.equals("cens")) {
                    c = 1;
                    break;
                }
                break;
        }
        if (c == 0 || c == 1) {
            return 1;
        }
        if (c == 2 || c == 3) {
            return 2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unsupported protection scheme type '");
        sb.append(schemeType);
        sb.append("'. Assuming AES-CTR crypto mode.");
        C8526n.m20534d("TrackEncryptionBox", sb.toString());
        return 1;
    }
}
