package com.google.android.exoplayer2.p183b.p187d;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8267n;
import com.google.android.exoplayer2.p183b.C8268o;
import com.google.android.exoplayer2.p183b.C8268o.C8270b;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.util.C8535t;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.b.d.k */
/* compiled from: StreamReader */
abstract class C8194k {

    /* renamed from: a */
    private final C8189f f17088a = new C8189f();

    /* renamed from: b */
    private C8272q f17089b;

    /* renamed from: c */
    private C8262i f17090c;

    /* renamed from: d */
    private C8191h f17091d;

    /* renamed from: e */
    private long f17092e;

    /* renamed from: f */
    private long f17093f;

    /* renamed from: g */
    private long f17094g;

    /* renamed from: h */
    private int f17095h;

    /* renamed from: i */
    private int f17096i;

    /* renamed from: j */
    private C8195a f17097j;

    /* renamed from: k */
    private long f17098k;

    /* renamed from: l */
    private boolean f17099l;

    /* renamed from: m */
    private boolean f17100m;

    /* renamed from: com.google.android.exoplayer2.b.d.k$a */
    /* compiled from: StreamReader */
    static class C8195a {

        /* renamed from: a */
        Format f17101a;

        /* renamed from: b */
        C8191h f17102b;

        C8195a() {
        }
    }

    /* renamed from: com.google.android.exoplayer2.b.d.k$b */
    /* compiled from: StreamReader */
    private static final class C8196b implements C8191h {
        private C8196b() {
        }

        /* renamed from: a */
        public long mo25254a(C8261h input) throws IOException, InterruptedException {
            return -1;
        }

        /* renamed from: c */
        public long mo25260c(long timeUs) {
            return 0;
        }

        /* renamed from: a */
        public C8268o mo25256a() {
            return new C8270b(-9223372036854775807L);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract long mo25262a(C8535t tVar);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo25264a(C8535t tVar, long j, C8195a aVar) throws IOException, InterruptedException;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo25277a(C8262i output, C8272q trackOutput) {
        this.f17090c = output;
        this.f17089b = trackOutput;
        mo25263a(true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25263a(boolean headerData) {
        if (headerData) {
            this.f17097j = new C8195a();
            this.f17093f = 0;
            this.f17095h = 0;
        } else {
            this.f17095h = 1;
        }
        this.f17092e = -1;
        this.f17094g = 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo25276a(long position, long timeUs) {
        this.f17088a.mo25270c();
        if (position == 0) {
            mo25263a(!this.f17099l);
        } else if (this.f17095h != 0) {
            this.f17092e = this.f17091d.mo25260c(timeUs);
            this.f17095h = 2;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final int mo25274a(C8261h input, C8267n seekPosition) throws IOException, InterruptedException {
        int i = this.f17095h;
        if (i == 0) {
            return m18849a(input);
        }
        if (i == 1) {
            input.mo25248c((int) this.f17093f);
            this.f17095h = 2;
            return 0;
        } else if (i == 2) {
            return m18850b(input, seekPosition);
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    private int m18849a(C8261h input) throws IOException, InterruptedException {
        boolean readingHeaders = true;
        while (readingHeaders) {
            if (!this.f17088a.mo25268a(input)) {
                this.f17095h = 3;
                return -1;
            }
            this.f17098k = input.getPosition() - this.f17093f;
            readingHeaders = mo25264a(this.f17088a.mo25269b(), this.f17093f, this.f17097j);
            if (readingHeaders) {
                this.f17093f = input.getPosition();
            }
        }
        C8261h hVar = input;
        Format format = this.f17097j.f17101a;
        this.f17096i = format.f16521u;
        if (!this.f17100m) {
            this.f17089b.mo25340a(format);
            this.f17100m = true;
        }
        C8191h hVar2 = this.f17097j.f17102b;
        if (hVar2 != null) {
            this.f17091d = hVar2;
            boolean z = readingHeaders;
        } else if (input.getLength() == -1) {
            this.f17091d = new C8196b();
            boolean z2 = readingHeaders;
        } else {
            C8190g firstPayloadPageHeader = this.f17088a.mo25267a();
            C8190g gVar = firstPayloadPageHeader;
            boolean z3 = readingHeaders;
            C8184c cVar = r0;
            C8184c cVar2 = new C8184c(this.f17093f, input.getLength(), this, (long) (firstPayloadPageHeader.f17081i + firstPayloadPageHeader.f17082j), firstPayloadPageHeader.f17076d, (firstPayloadPageHeader.f17075c & 4) != 0);
            this.f17091d = cVar;
        }
        this.f17097j = null;
        this.f17095h = 2;
        this.f17088a.mo25271d();
        return 0;
    }

    /* renamed from: b */
    private int m18850b(C8261h input, C8267n seekPosition) throws IOException, InterruptedException {
        C8261h hVar = input;
        long position = this.f17091d.mo25254a(hVar);
        if (position >= 0) {
            seekPosition.f17510a = position;
            return 1;
        }
        C8267n nVar = seekPosition;
        if (position < -1) {
            mo25279c(-(2 + position));
        }
        if (!this.f17099l) {
            this.f17090c.mo25352a(this.f17091d.mo25256a());
            this.f17099l = true;
        }
        if (this.f17098k > 0 || this.f17088a.mo25268a(hVar)) {
            this.f17098k = 0;
            C8535t payload = this.f17088a.mo25269b();
            long granulesInPacket = mo25262a(payload);
            if (granulesInPacket >= 0) {
                long j = this.f17094g;
                if (j + granulesInPacket >= this.f17092e) {
                    long timeUs = mo25275a(j);
                    this.f17089b.mo25341a(payload, payload.mo26115d());
                    this.f17089b.mo25339a(timeUs, 1, payload.mo26115d(), 0, null);
                    this.f17092e = -1;
                }
            }
            this.f17094g += granulesInPacket;
            return 0;
        }
        this.f17095h = 3;
        return -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public long mo25275a(long granule) {
        return (1000000 * granule) / ((long) this.f17096i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public long mo25278b(long timeUs) {
        return (((long) this.f17096i) * timeUs) / 1000000;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo25279c(long currentGranule) {
        this.f17094g = currentGranule;
    }
}
