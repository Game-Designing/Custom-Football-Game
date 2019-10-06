package com.google.android.exoplayer2.p183b.p188e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8219d;
import com.google.android.exoplayer2.text.p190a.C8417b;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8535t;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.b.e.B */
/* compiled from: SeiReader */
final class C8207B {

    /* renamed from: a */
    private final List<Format> f17155a;

    /* renamed from: b */
    private final C8272q[] f17156b;

    public C8207B(List<Format> closedCaptionFormats) {
        this.f17155a = closedCaptionFormats;
        this.f17156b = new C8272q[closedCaptionFormats.size()];
    }

    /* renamed from: a */
    public void mo25289a(C8262i extractorOutput, C8219d idGenerator) {
        for (int i = 0; i < this.f17156b.length; i++) {
            idGenerator.mo25298a();
            C8272q output = extractorOutput.mo25351a(idGenerator.mo25300c(), 3);
            Format channelFormat = (Format) this.f17155a.get(i);
            String channelMimeType = channelFormat.f16507g;
            boolean z = "application/cea-608".equals(channelMimeType) || "application/cea-708".equals(channelMimeType);
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid closed caption mime type provided: ");
            sb.append(channelMimeType);
            C8514e.m20489a(z, sb.toString());
            String formatId = channelFormat.f16501a;
            if (formatId == null) {
                formatId = idGenerator.mo25299b();
            }
            String str = channelMimeType;
            output.mo25340a(Format.m18251a(formatId, channelMimeType, null, -1, channelFormat.f16525y, channelFormat.f16526z, channelFormat.f16499A, null, Long.MAX_VALUE, channelFormat.f16509i));
            this.f17156b[i] = output;
        }
        C8262i iVar = extractorOutput;
    }

    /* renamed from: a */
    public void mo25288a(long pesTimeUs, C8535t seiBuffer) {
        C8417b.m20012a(pesTimeUs, seiBuffer, this.f17156b);
    }
}
