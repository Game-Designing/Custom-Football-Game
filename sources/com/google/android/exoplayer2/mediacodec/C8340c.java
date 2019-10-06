package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.mediacodec.c */
/* compiled from: MediaCodecSelector */
class C8340c implements C8341d {
    C8340c() {
    }

    /* renamed from: a */
    public List<C8338a> mo25540a(String mimeType, boolean requiresSecureDecoder) throws DecoderQueryException {
        return MediaCodecUtil.m19628b(mimeType, requiresSecureDecoder);
    }

    /* renamed from: a */
    public C8338a mo25539a() throws DecoderQueryException {
        return MediaCodecUtil.m19621a();
    }
}
