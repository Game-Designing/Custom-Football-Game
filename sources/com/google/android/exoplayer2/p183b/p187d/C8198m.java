package com.google.android.exoplayer2.p183b.p187d;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p183b.p187d.C8200n.C8202b;
import com.google.android.exoplayer2.p183b.p187d.C8200n.C8203c;
import com.google.android.exoplayer2.p183b.p187d.C8200n.C8204d;
import com.google.android.exoplayer2.util.C8535t;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: com.google.android.exoplayer2.b.d.m */
/* compiled from: VorbisReader */
final class C8198m extends C8194k {

    /* renamed from: n */
    private C8199a f17107n;

    /* renamed from: o */
    private int f17108o;

    /* renamed from: p */
    private boolean f17109p;

    /* renamed from: q */
    private C8204d f17110q;

    /* renamed from: r */
    private C8202b f17111r;

    /* renamed from: com.google.android.exoplayer2.b.d.m$a */
    /* compiled from: VorbisReader */
    static final class C8199a {

        /* renamed from: a */
        public final C8204d f17112a;

        /* renamed from: b */
        public final C8202b f17113b;

        /* renamed from: c */
        public final byte[] f17114c;

        /* renamed from: d */
        public final C8203c[] f17115d;

        /* renamed from: e */
        public final int f17116e;

        public C8199a(C8204d idHeader, C8202b commentHeader, byte[] setupHeaderData, C8203c[] modes, int iLogModes) {
            this.f17112a = idHeader;
            this.f17113b = commentHeader;
            this.f17114c = setupHeaderData;
            this.f17115d = modes;
            this.f17116e = iLogModes;
        }
    }

    C8198m() {
    }

    /* renamed from: c */
    public static boolean m18871c(C8535t data) {
        try {
            return C8200n.m18882a(1, data, true);
        } catch (ParserException e) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25263a(boolean headerData) {
        super.mo25263a(headerData);
        if (headerData) {
            this.f17107n = null;
            this.f17110q = null;
            this.f17111r = null;
        }
        this.f17108o = 0;
        this.f17109p = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo25279c(long currentGranule) {
        super.mo25279c(currentGranule);
        int i = 0;
        this.f17109p = currentGranule != 0;
        C8204d dVar = this.f17110q;
        if (dVar != null) {
            i = dVar.f17135g;
        }
        this.f17108o = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public long mo25262a(C8535t packet) {
        byte[] bArr = packet.f18861a;
        int samplesInPacket = 0;
        if ((bArr[0] & 1) == 1) {
            return -1;
        }
        int packetBlockSize = m18869a(bArr[0], this.f17107n);
        if (this.f17109p) {
            samplesInPacket = (this.f17108o + packetBlockSize) / 4;
        }
        m18870a(packet, (long) samplesInPacket);
        this.f17109p = true;
        this.f17108o = packetBlockSize;
        return (long) samplesInPacket;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo25264a(C8535t packet, long position, C8195a setupData) throws IOException, InterruptedException {
        if (this.f17107n != null) {
            return false;
        }
        this.f17107n = mo25284b(packet);
        if (this.f17107n == null) {
            return true;
        }
        ArrayList<byte[]> codecInitialisationData = new ArrayList<>();
        codecInitialisationData.add(this.f17107n.f17112a.f17138j);
        codecInitialisationData.add(this.f17107n.f17114c);
        C8204d dVar = this.f17107n.f17112a;
        setupData.f17101a = Format.m18250a(null, "audio/vorbis", null, dVar.f17133e, -1, dVar.f17130b, (int) dVar.f17131c, codecInitialisationData, null, 0, null);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C8199a mo25284b(C8535t scratch) throws IOException {
        if (this.f17110q == null) {
            this.f17110q = C8200n.m18884b(scratch);
            return null;
        } else if (this.f17111r == null) {
            this.f17111r = C8200n.m18880a(scratch);
            return null;
        } else {
            byte[] setupHeaderData = new byte[scratch.mo26115d()];
            System.arraycopy(scratch.f18861a, 0, setupHeaderData, 0, scratch.mo26115d());
            C8203c[] modes = C8200n.m18883a(scratch, this.f17110q.f17130b);
            C8199a aVar = new C8199a(this.f17110q, this.f17111r, setupHeaderData, modes, C8200n.m18877a(modes.length - 1));
            return aVar;
        }
    }

    /* renamed from: a */
    static int m18868a(byte src, int length, int leastSignificantBitIndex) {
        return (src >> leastSignificantBitIndex) & (255 >>> (8 - length));
    }

    /* renamed from: a */
    static void m18870a(C8535t buffer, long packetSampleCount) {
        buffer.mo26116d(buffer.mo26115d() + 4);
        buffer.f18861a[buffer.mo26115d() - 4] = (byte) ((int) (packetSampleCount & 255));
        buffer.f18861a[buffer.mo26115d() - 3] = (byte) ((int) ((packetSampleCount >>> 8) & 255));
        buffer.f18861a[buffer.mo26115d() - 2] = (byte) ((int) ((packetSampleCount >>> 16) & 255));
        buffer.f18861a[buffer.mo26115d() - 1] = (byte) ((int) (255 & (packetSampleCount >>> 24)));
    }

    /* renamed from: a */
    private static int m18869a(byte firstByteOfAudioPacket, C8199a vorbisSetup) {
        if (!vorbisSetup.f17115d[m18868a(firstByteOfAudioPacket, vorbisSetup.f17116e, 1)].f17125a) {
            return vorbisSetup.f17112a.f17135g;
        }
        return vorbisSetup.f17112a.f17136h;
    }
}
