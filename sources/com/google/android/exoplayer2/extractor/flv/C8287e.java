package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader.UnsupportedFormatException;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.util.C8531r;
import com.google.android.exoplayer2.util.C8535t;
import com.google.android.exoplayer2.video.C8554h;

/* renamed from: com.google.android.exoplayer2.extractor.flv.e */
/* compiled from: VideoTagPayloadReader */
final class C8287e extends TagPayloadReader {

    /* renamed from: b */
    private final C8535t f17595b = new C8535t(C8531r.f18837a);

    /* renamed from: c */
    private final C8535t f17596c = new C8535t(4);

    /* renamed from: d */
    private int f17597d;

    /* renamed from: e */
    private boolean f17598e;

    /* renamed from: f */
    private int f17599f;

    public C8287e(C8272q output) {
        super(output);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo25424a(C8535t data) throws UnsupportedFormatException {
        int header = data.mo26131q();
        int frameType = (header >> 4) & 15;
        int videoCodec = header & 15;
        if (videoCodec == 7) {
            this.f17599f = frameType;
            return frameType != 5;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Video format not supported: ");
        sb.append(videoCodec);
        throw new UnsupportedFormatException(sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo25425b(C8535t data, long timeUs) throws ParserException {
        C8535t tVar = data;
        int packetType = data.mo26131q();
        long timeUs2 = timeUs + (((long) data.mo26121g()) * 1000);
        if (packetType == 0 && !this.f17598e) {
            C8535t videoSequence = new C8535t(new byte[data.mo26104a()]);
            tVar.mo26110a(videoSequence.f18861a, 0, data.mo26104a());
            C8554h avcConfig = C8554h.m20661a(videoSequence);
            this.f17597d = avcConfig.f18922b;
            this.f17571a.mo25340a(Format.m18246a((String) null, "video/avc", (String) null, -1, -1, avcConfig.f18923c, avcConfig.f18924d, -1.0f, avcConfig.f18921a, -1, avcConfig.f18925e, (DrmInitData) null));
            this.f17598e = true;
        } else if (packetType == 1 && this.f17598e) {
            byte[] nalLengthData = this.f17596c.f18861a;
            nalLengthData[0] = 0;
            nalLengthData[1] = 0;
            nalLengthData[2] = 0;
            int nalUnitLengthFieldLengthDiff = 4 - this.f17597d;
            int bytesWritten = 0;
            while (data.mo26104a() > 0) {
                tVar.mo26110a(this.f17596c.f18861a, nalUnitLengthFieldLengthDiff, this.f17597d);
                this.f17596c.mo26118e(0);
                int bytesToWrite = this.f17596c.mo26135u();
                this.f17595b.mo26118e(0);
                this.f17571a.mo25341a(this.f17595b, 4);
                int bytesWritten2 = bytesWritten + 4;
                this.f17571a.mo25341a(tVar, bytesToWrite);
                bytesWritten = bytesWritten2 + bytesToWrite;
            }
            C8272q qVar = this.f17571a;
            int i = 1;
            if (this.f17599f != 1) {
                i = 0;
            }
            qVar.mo25339a(timeUs2, i, bytesWritten, 0, null);
        }
    }
}
