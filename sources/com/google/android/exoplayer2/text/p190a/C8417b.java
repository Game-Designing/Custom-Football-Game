package com.google.android.exoplayer2.text.p190a;

import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8526n;
import com.google.android.exoplayer2.util.C8535t;

/* renamed from: com.google.android.exoplayer2.text.a.b */
/* compiled from: CeaUtil */
public final class C8417b {

    /* renamed from: a */
    public static final int f18385a = C8509F.m20464b("GA94");

    /* renamed from: a */
    public static void m20012a(long presentationTimeUs, C8535t seiBuffer, C8272q[] outputs) {
        while (true) {
            boolean z = true;
            if (seiBuffer.mo26104a() > 1) {
                int payloadType = m20011a(seiBuffer);
                int payloadSize = m20011a(seiBuffer);
                int nextPayloadPosition = seiBuffer.mo26113c() + payloadSize;
                if (payloadSize == -1 || payloadSize > seiBuffer.mo26104a()) {
                    C8526n.m20534d("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                    nextPayloadPosition = seiBuffer.mo26115d();
                } else if (payloadType == 4 && payloadSize >= 8) {
                    int countryCode = seiBuffer.mo26131q();
                    int providerCode = seiBuffer.mo26137w();
                    int userIdentifier = 0;
                    if (providerCode == 49) {
                        userIdentifier = seiBuffer.mo26119f();
                    }
                    int userDataTypeCode = seiBuffer.mo26131q();
                    if (providerCode == 47) {
                        seiBuffer.mo26120f(1);
                    }
                    boolean messageIsSupportedCeaCaption = countryCode == 181 && (providerCode == 49 || providerCode == 47) && userDataTypeCode == 3;
                    if (providerCode == 49) {
                        if (userIdentifier != f18385a) {
                            z = false;
                        }
                        messageIsSupportedCeaCaption &= z;
                    }
                    if (messageIsSupportedCeaCaption) {
                        m20013b(presentationTimeUs, seiBuffer, outputs);
                    }
                }
                seiBuffer.mo26118e(nextPayloadPosition);
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    public static void m20013b(long presentationTimeUs, C8535t ccDataBuffer, C8272q[] outputs) {
        C8535t tVar = ccDataBuffer;
        C8272q[] qVarArr = outputs;
        int firstByte = ccDataBuffer.mo26131q();
        if ((firstByte & 64) != 0) {
            int ccCount = firstByte & 31;
            tVar.mo26120f(1);
            int sampleLength = ccCount * 3;
            int sampleStartPosition = ccDataBuffer.mo26113c();
            for (C8272q output : qVarArr) {
                tVar.mo26118e(sampleStartPosition);
                output.mo25341a(tVar, sampleLength);
                C8272q qVar = output;
                output.mo25339a(presentationTimeUs, 1, sampleLength, 0, null);
            }
        }
    }

    /* renamed from: a */
    private static int m20011a(C8535t buffer) {
        int value = 0;
        while (buffer.mo26104a() != 0) {
            int b = buffer.mo26131q();
            value += b;
            if (b != 255) {
                return value;
            }
        }
        return -1;
    }
}
