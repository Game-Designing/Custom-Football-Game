package com.google.android.exoplayer2.p183b.p188e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8219d;
import com.google.android.exoplayer2.text.p190a.C8417b;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8535t;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.b.e.I */
/* compiled from: UserDataReader */
final class C8221I {

    /* renamed from: a */
    private final List<Format> f17212a;

    /* renamed from: b */
    private final C8272q[] f17213b;

    public C8221I(List<Format> closedCaptionFormats) {
        this.f17212a = closedCaptionFormats;
        this.f17213b = new C8272q[closedCaptionFormats.size()];
    }

    /* renamed from: a */
    public void mo25302a(C8262i extractorOutput, C8219d idGenerator) {
        for (int i = 0; i < this.f17213b.length; i++) {
            idGenerator.mo25298a();
            C8272q output = extractorOutput.mo25351a(idGenerator.mo25300c(), 3);
            Format channelFormat = (Format) this.f17212a.get(i);
            String channelMimeType = channelFormat.f16507g;
            boolean z = "application/cea-608".equals(channelMimeType) || "application/cea-708".equals(channelMimeType);
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid closed caption mime type provided: ");
            sb.append(channelMimeType);
            C8514e.m20489a(z, sb.toString());
            String str = channelMimeType;
            output.mo25340a(Format.m18251a(idGenerator.mo25299b(), channelMimeType, null, -1, channelFormat.f16525y, channelFormat.f16526z, channelFormat.f16499A, null, Long.MAX_VALUE, channelFormat.f16509i));
            this.f17213b[i] = output;
        }
        C8262i iVar = extractorOutput;
    }

    /* renamed from: a */
    public void mo25301a(long pesTimeUs, C8535t userDataPayload) {
        if (userDataPayload.mo26104a() >= 9) {
            int userDataStartCode = userDataPayload.mo26119f();
            int userDataIdentifier = userDataPayload.mo26119f();
            int userDataTypeCode = userDataPayload.mo26131q();
            if (userDataStartCode == 434 && userDataIdentifier == C8417b.f18385a && userDataTypeCode == 3) {
                C8417b.m20013b(pesTimeUs, userDataPayload, this.f17213b);
            }
        }
    }
}
