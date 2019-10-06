package com.google.android.exoplayer2.p183b.p187d;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8535t;
import com.mopub.volley.DefaultRetryPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.b.d.i */
/* compiled from: OpusReader */
final class C8192i extends C8194k {

    /* renamed from: n */
    private static final int f17085n = C8509F.m20464b("Opus");

    /* renamed from: o */
    private static final byte[] f17086o = {79, 112, 117, 115, 72, 101, 97, 100};

    /* renamed from: p */
    private boolean f17087p;

    C8192i() {
    }

    /* renamed from: b */
    public static boolean m18845b(C8535t data) {
        int a = data.mo26104a();
        byte[] bArr = f17086o;
        if (a < bArr.length) {
            return false;
        }
        byte[] header = new byte[bArr.length];
        data.mo26110a(header, 0, bArr.length);
        return Arrays.equals(header, f17086o);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25263a(boolean headerData) {
        super.mo25263a(headerData);
        if (headerData) {
            this.f17087p = false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public long mo25262a(C8535t packet) {
        return mo25278b(m18843a(packet.f18861a));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo25264a(C8535t packet, long position, C8195a setupData) {
        C8535t tVar = packet;
        boolean z = true;
        if (!this.f17087p) {
            byte[] metadata = Arrays.copyOf(tVar.f18861a, packet.mo26115d());
            byte b = metadata[9] & 255;
            byte b2 = ((metadata[11] & 255) << 8) | (metadata[10] & 255);
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(metadata);
            m18844a(arrayList, b2);
            m18844a(arrayList, 3840);
            ArrayList arrayList2 = arrayList;
            byte b3 = b2;
            setupData.f17101a = Format.m18250a(null, "audio/opus", null, -1, -1, b, 48000, arrayList, null, 0, null);
            this.f17087p = true;
            return true;
        }
        C8195a aVar = setupData;
        if (packet.mo26119f() != f17085n) {
            z = false;
        }
        boolean headerPacket = z;
        tVar.mo26118e(0);
        return headerPacket;
    }

    /* renamed from: a */
    private void m18844a(List<byte[]> initializationData, int samples) {
        initializationData.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((((long) samples) * 1000000000) / 48000).array());
    }

    /* renamed from: a */
    private long m18843a(byte[] packet) {
        int frames;
        int length;
        int toc = packet[0] & 255;
        int i = toc & 3;
        if (i == 0) {
            frames = 1;
        } else if (i == 1 || i == 2) {
            frames = 2;
        } else {
            frames = packet[1] & 63;
        }
        int config = toc >> 3;
        int length2 = config & 3;
        if (config >= 16) {
            length = DefaultRetryPolicy.DEFAULT_TIMEOUT_MS << length2;
        } else if (config >= 12) {
            length = 10000 << (length2 & 1);
        } else if (length2 == 3) {
            length = 60000;
        } else {
            length = 10000 << length2;
        }
        return ((long) frames) * ((long) length);
    }
}
