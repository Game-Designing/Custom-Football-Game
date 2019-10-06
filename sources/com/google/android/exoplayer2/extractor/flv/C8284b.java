package com.google.android.exoplayer2.extractor.flv;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader.UnsupportedFormatException;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.util.C8518h;
import com.google.android.exoplayer2.util.C8535t;
import java.util.Collections;

/* renamed from: com.google.android.exoplayer2.extractor.flv.b */
/* compiled from: AudioTagPayloadReader */
final class C8284b extends TagPayloadReader {

    /* renamed from: b */
    private static final int[] f17573b = {5512, 11025, 22050, 44100};

    /* renamed from: c */
    private boolean f17574c;

    /* renamed from: d */
    private boolean f17575d;

    /* renamed from: e */
    private int f17576e;

    public C8284b(C8272q output) {
        super(output);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo25424a(C8535t data) throws UnsupportedFormatException {
        if (!this.f17574c) {
            int header = data.mo26131q();
            this.f17576e = (header >> 4) & 15;
            int i = this.f17576e;
            if (i == 2) {
                this.f17571a.mo25340a(Format.m18250a(null, "audio/mpeg", null, -1, -1, 1, f17573b[(header >> 2) & 3], null, null, 0, null));
                this.f17575d = true;
            } else if (i == 7 || i == 8) {
                this.f17571a.mo25340a(Format.m18249a((String) null, this.f17576e == 7 ? "audio/g711-alaw" : "audio/g711-mlaw", (String) null, -1, -1, 1, 8000, (header & 1) == 1 ? 2 : 3, null, (DrmInitData) null, 0, (String) null));
                this.f17575d = true;
            } else if (i != 10) {
                StringBuilder sb = new StringBuilder();
                sb.append("Audio format not supported: ");
                sb.append(this.f17576e);
                throw new UnsupportedFormatException(sb.toString());
            }
            this.f17574c = true;
            C8535t tVar = data;
        } else {
            data.mo26120f(1);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo25425b(C8535t data, long timeUs) throws ParserException {
        C8535t tVar = data;
        if (this.f17576e == 2) {
            int sampleSize = data.mo26104a();
            this.f17571a.mo25341a(tVar, sampleSize);
            this.f17571a.mo25339a(timeUs, 1, sampleSize, 0, null);
            return;
        }
        int packetType = data.mo26131q();
        if (packetType == 0 && !this.f17575d) {
            byte[] audioSpecificConfig = new byte[data.mo26104a()];
            tVar.mo26110a(audioSpecificConfig, 0, audioSpecificConfig.length);
            Pair<Integer, Integer> audioParams = C8518h.m20502a(audioSpecificConfig);
            this.f17571a.mo25340a(Format.m18250a(null, "audio/mp4a-latm", null, -1, -1, ((Integer) audioParams.second).intValue(), ((Integer) audioParams.first).intValue(), Collections.singletonList(audioSpecificConfig), null, 0, null));
            this.f17575d = true;
        } else if (this.f17576e != 10 || packetType == 1) {
            int sampleSize2 = data.mo26104a();
            this.f17571a.mo25341a(tVar, sampleSize2);
            this.f17571a.mo25339a(timeUs, 1, sampleSize2, 0, null);
        }
    }
}
