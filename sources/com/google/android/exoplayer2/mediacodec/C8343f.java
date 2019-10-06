package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import com.google.android.exoplayer2.video.ColorInfo;
import java.nio.ByteBuffer;
import java.util.List;

@TargetApi(16)
/* renamed from: com.google.android.exoplayer2.mediacodec.f */
/* compiled from: MediaFormatUtil */
public final class C8343f {
    /* renamed from: a */
    public static void m19679a(MediaFormat format, List<byte[]> csdBuffers) {
        for (int i = 0; i < csdBuffers.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("csd-");
            sb.append(i);
            format.setByteBuffer(sb.toString(), ByteBuffer.wrap((byte[]) csdBuffers.get(i)));
        }
    }

    /* renamed from: a */
    public static void m19677a(MediaFormat format, String key, int value) {
        if (value != -1) {
            format.setInteger(key, value);
        }
    }

    /* renamed from: a */
    public static void m19676a(MediaFormat format, String key, float value) {
        if (value != -1.0f) {
            format.setFloat(key, value);
        }
    }

    /* renamed from: a */
    public static void m19678a(MediaFormat format, String key, byte[] value) {
        if (value != null) {
            format.setByteBuffer(key, ByteBuffer.wrap(value));
        }
    }

    /* renamed from: a */
    public static void m19675a(MediaFormat format, ColorInfo colorInfo) {
        if (colorInfo != null) {
            m19677a(format, "color-transfer", colorInfo.f18888c);
            m19677a(format, "color-standard", colorInfo.f18886a);
            m19677a(format, "color-range", colorInfo.f18887b);
            m19678a(format, "hdr-static-info", colorInfo.f18889d);
        }
    }
}
