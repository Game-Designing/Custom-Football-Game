package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.mediacodec.b */
/* compiled from: MediaCodecSelector */
class C8339b implements C8341d {
    C8339b() {
    }

    /* renamed from: a */
    public List<C8338a> mo25540a(String mimeType, boolean requiresSecureDecoder) throws DecoderQueryException {
        List<MediaCodecInfo> decoderInfos = MediaCodecUtil.m19628b(mimeType, requiresSecureDecoder);
        if (decoderInfos.isEmpty()) {
            return Collections.emptyList();
        }
        return Collections.singletonList(decoderInfos.get(0));
    }

    /* renamed from: a */
    public C8338a mo25539a() throws DecoderQueryException {
        return MediaCodecUtil.m19621a();
    }
}
