package com.google.android.exoplayer2.source;

import android.support.p001v7.widget.LinearLayoutManager;
import com.google.android.exoplayer2.C8362o;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p182a.C8104c;
import com.google.android.exoplayer2.p182a.C8107e;
import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.p183b.C8272q.C8273a;
import com.google.android.exoplayer2.source.C8403t.C8404a;
import com.google.android.exoplayer2.upstream.C8462c;
import com.google.android.exoplayer2.upstream.C8481d;
import com.google.android.exoplayer2.util.C8535t;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.source.u */
/* compiled from: SampleQueue */
public class C8405u implements C8272q {

    /* renamed from: a */
    private final C8481d f18334a;

    /* renamed from: b */
    private final int f18335b;

    /* renamed from: c */
    private final C8403t f18336c = new C8403t();

    /* renamed from: d */
    private final C8404a f18337d = new C8404a();

    /* renamed from: e */
    private final C8535t f18338e = new C8535t(32);

    /* renamed from: f */
    private C8406a f18339f = new C8406a(0, this.f18335b);

    /* renamed from: g */
    private C8406a f18340g;

    /* renamed from: h */
    private C8406a f18341h;

    /* renamed from: i */
    private Format f18342i;

    /* renamed from: j */
    private boolean f18343j;

    /* renamed from: k */
    private Format f18344k;

    /* renamed from: l */
    private long f18345l;

    /* renamed from: m */
    private long f18346m;

    /* renamed from: n */
    private boolean f18347n;

    /* renamed from: o */
    private C8407b f18348o;

    /* renamed from: com.google.android.exoplayer2.source.u$a */
    /* compiled from: SampleQueue */
    private static final class C8406a {

        /* renamed from: a */
        public final long f18349a;

        /* renamed from: b */
        public final long f18350b;

        /* renamed from: c */
        public boolean f18351c;

        /* renamed from: d */
        public C8462c f18352d;

        /* renamed from: e */
        public C8406a f18353e;

        public C8406a(long startPosition, int allocationLength) {
            this.f18349a = startPosition;
            this.f18350b = ((long) allocationLength) + startPosition;
        }

        /* renamed from: a */
        public void mo25791a(C8462c allocation, C8406a next) {
            this.f18352d = allocation;
            this.f18353e = next;
            this.f18351c = true;
        }

        /* renamed from: a */
        public int mo25789a(long absolutePosition) {
            return ((int) (absolutePosition - this.f18349a)) + this.f18352d.f18632b;
        }

        /* renamed from: a */
        public C8406a mo25790a() {
            this.f18352d = null;
            C8406a temp = this.f18353e;
            this.f18353e = null;
            return temp;
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.u$b */
    /* compiled from: SampleQueue */
    public interface C8407b {
        /* renamed from: a */
        void mo25704a(Format format);
    }

    public C8405u(C8481d allocator) {
        this.f18334a = allocator;
        this.f18335b = allocator.mo26008c();
        C8406a aVar = this.f18339f;
        this.f18340g = aVar;
        this.f18341h = aVar;
    }

    /* renamed from: i */
    public void mo25787i() {
        mo25778a(false);
    }

    /* renamed from: a */
    public void mo25778a(boolean resetUpstreamFormat) {
        this.f18336c.mo25762a(resetUpstreamFormat);
        m19962a(this.f18339f);
        this.f18339f = new C8406a(0, this.f18335b);
        C8406a aVar = this.f18339f;
        this.f18340g = aVar;
        this.f18341h = aVar;
        this.f18346m = 0;
        this.f18334a.mo26007b();
    }

    /* renamed from: f */
    public int mo25784f() {
        return this.f18336c.mo25770f();
    }

    /* renamed from: g */
    public boolean mo25785g() {
        return this.f18336c.mo25771g();
    }

    /* renamed from: d */
    public int mo25782d() {
        return this.f18336c.mo25768d();
    }

    /* renamed from: e */
    public Format mo25783e() {
        return this.f18336c.mo25769e();
    }

    /* renamed from: c */
    public long mo25781c() {
        return this.f18336c.mo25767c();
    }

    /* renamed from: h */
    public boolean mo25786h() {
        return this.f18336c.mo25772h();
    }

    /* renamed from: j */
    public void mo25788j() {
        this.f18336c.mo25773i();
        this.f18340g = this.f18339f;
    }

    /* renamed from: b */
    public void mo25780b(long timeUs, boolean toKeyframe, boolean stopAtReadPosition) {
        m19964b(this.f18336c.mo25766b(timeUs, toKeyframe, stopAtReadPosition));
    }

    /* renamed from: b */
    public void mo25779b() {
        m19964b(this.f18336c.mo25765b());
    }

    /* renamed from: a */
    public int mo25774a() {
        return this.f18336c.mo25757a();
    }

    /* renamed from: a */
    public int mo25775a(long timeUs, boolean toKeyframe, boolean allowTimeBeyondBuffer) {
        return this.f18336c.mo25758a(timeUs, toKeyframe, allowTimeBeyondBuffer);
    }

    /* renamed from: a */
    public int mo25776a(C8362o formatHolder, C8107e buffer, boolean formatRequired, boolean loadingFinished, long decodeOnlyUntilUs) {
        int result = this.f18336c.mo25759a(formatHolder, buffer, formatRequired, loadingFinished, this.f18342i, this.f18337d);
        if (result == -5) {
            this.f18342i = formatHolder.f18117a;
            return -5;
        } else if (result == -4) {
            if (!buffer.mo25025c()) {
                if (buffer.f16556d < decodeOnlyUntilUs) {
                    buffer.mo25021a(LinearLayoutManager.INVALID_OFFSET);
                }
                if (buffer.mo25032f()) {
                    m19961a(buffer, this.f18337d);
                }
                buffer.mo25030d(this.f18337d.f18331a);
                C8404a aVar = this.f18337d;
                m19959a(aVar.f18332b, buffer.f16555c, aVar.f18331a);
            }
            return -4;
        } else if (result == -3) {
            return -3;
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    private void m19961a(C8107e buffer, C8404a extrasHolder) {
        int subsampleCount;
        int[] clearDataSizes;
        int[] encryptedDataSizes;
        C8107e eVar = buffer;
        C8404a aVar = extrasHolder;
        long offset = aVar.f18332b;
        boolean subsampleEncryption = true;
        this.f18338e.mo26114c(1);
        m19960a(offset, this.f18338e.f18861a, 1);
        long offset2 = offset + 1;
        byte signalByte = this.f18338e.f18861a[0];
        if ((signalByte & 128) == 0) {
            subsampleEncryption = false;
        }
        int ivSize = signalByte & Opcodes.LAND;
        C8104c cVar = eVar.f16554b;
        if (cVar.f16533a == null) {
            cVar.f16533a = new byte[16];
        }
        m19960a(offset2, eVar.f16554b.f16533a, ivSize);
        long offset3 = offset2 + ((long) ivSize);
        if (subsampleEncryption) {
            this.f18338e.mo26114c(2);
            m19960a(offset3, this.f18338e.f18861a, 2);
            offset3 += 2;
            subsampleCount = this.f18338e.mo26137w();
        } else {
            subsampleCount = 1;
        }
        int[] clearDataSizes2 = eVar.f16554b.f16536d;
        if (clearDataSizes2 == null || clearDataSizes2.length < subsampleCount) {
            clearDataSizes = new int[subsampleCount];
        } else {
            clearDataSizes = clearDataSizes2;
        }
        int[] encryptedDataSizes2 = eVar.f16554b.f16537e;
        if (encryptedDataSizes2 == null || encryptedDataSizes2.length < subsampleCount) {
            encryptedDataSizes = new int[subsampleCount];
        } else {
            encryptedDataSizes = encryptedDataSizes2;
        }
        if (subsampleEncryption) {
            int subsampleDataLength = subsampleCount * 6;
            this.f18338e.mo26114c(subsampleDataLength);
            m19960a(offset3, this.f18338e.f18861a, subsampleDataLength);
            offset3 += (long) subsampleDataLength;
            this.f18338e.mo26118e(0);
            for (int i = 0; i < subsampleCount; i++) {
                clearDataSizes[i] = this.f18338e.mo26137w();
                encryptedDataSizes[i] = this.f18338e.mo26135u();
            }
        } else {
            clearDataSizes[0] = 0;
            encryptedDataSizes[0] = aVar.f18331a - ((int) (offset3 - aVar.f18332b));
        }
        C8273a cryptoData = aVar.f18333c;
        C8104c cVar2 = eVar.f16554b;
        byte[] bArr = cryptoData.f17519b;
        byte[] bArr2 = cVar2.f16533a;
        int i2 = cryptoData.f17518a;
        int i3 = cryptoData.f17520c;
        int i4 = i3;
        int i5 = i2;
        cVar2.mo25028a(subsampleCount, clearDataSizes, encryptedDataSizes, bArr, bArr2, i5, i4, cryptoData.f17521d);
        long j = aVar.f18332b;
        int bytesRead = (int) (offset3 - j);
        aVar.f18332b = j + ((long) bytesRead);
        aVar.f18331a -= bytesRead;
    }

    /* renamed from: a */
    private void m19959a(long absolutePosition, ByteBuffer target, int length) {
        m19958a(absolutePosition);
        int remaining = length;
        while (remaining > 0) {
            int toCopy = Math.min(remaining, (int) (this.f18340g.f18350b - absolutePosition));
            C8406a aVar = this.f18340g;
            target.put(aVar.f18352d.f18631a, aVar.mo25789a(absolutePosition), toCopy);
            remaining -= toCopy;
            absolutePosition += (long) toCopy;
            C8406a aVar2 = this.f18340g;
            if (absolutePosition == aVar2.f18350b) {
                this.f18340g = aVar2.f18353e;
            }
        }
    }

    /* renamed from: a */
    private void m19960a(long absolutePosition, byte[] target, int length) {
        m19958a(absolutePosition);
        int remaining = length;
        while (remaining > 0) {
            int toCopy = Math.min(remaining, (int) (this.f18340g.f18350b - absolutePosition));
            C8406a aVar = this.f18340g;
            System.arraycopy(aVar.f18352d.f18631a, aVar.mo25789a(absolutePosition), target, length - remaining, toCopy);
            remaining -= toCopy;
            absolutePosition += (long) toCopy;
            C8406a aVar2 = this.f18340g;
            if (absolutePosition == aVar2.f18350b) {
                this.f18340g = aVar2.f18353e;
            }
        }
    }

    /* renamed from: a */
    private void m19958a(long absolutePosition) {
        while (true) {
            C8406a aVar = this.f18340g;
            if (absolutePosition >= aVar.f18350b) {
                this.f18340g = aVar.f18353e;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    private void m19964b(long absolutePosition) {
        C8406a aVar;
        if (absolutePosition != -1) {
            while (true) {
                aVar = this.f18339f;
                if (absolutePosition < aVar.f18350b) {
                    break;
                }
                this.f18334a.mo26005a(aVar.f18352d);
                this.f18339f = this.f18339f.mo25790a();
            }
            if (this.f18340g.f18349a < aVar.f18349a) {
                this.f18340g = aVar;
            }
        }
    }

    /* renamed from: a */
    public void mo25777a(C8407b listener) {
        this.f18348o = listener;
    }

    /* renamed from: a */
    public void mo25340a(Format format) {
        Format adjustedFormat = m19956a(format, this.f18345l);
        boolean formatChanged = this.f18336c.mo25764a(adjustedFormat);
        this.f18344k = format;
        this.f18343j = false;
        C8407b bVar = this.f18348o;
        if (bVar != null && formatChanged) {
            bVar.mo25704a(adjustedFormat);
        }
    }

    /* renamed from: a */
    public int mo25338a(C8261h input, int length, boolean allowEndOfInput) throws IOException, InterruptedException {
        int length2 = m19963b(length);
        C8406a aVar = this.f18341h;
        int bytesAppended = input.read(aVar.f18352d.f18631a, aVar.mo25789a(this.f18346m), length2);
        if (bytesAppended != -1) {
            m19957a(bytesAppended);
            return bytesAppended;
        } else if (allowEndOfInput) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    /* renamed from: a */
    public void mo25341a(C8535t buffer, int length) {
        while (length > 0) {
            int bytesAppended = m19963b(length);
            C8406a aVar = this.f18341h;
            buffer.mo26110a(aVar.f18352d.f18631a, aVar.mo25789a(this.f18346m), bytesAppended);
            length -= bytesAppended;
            m19957a(bytesAppended);
        }
    }

    /* renamed from: a */
    public void mo25339a(long timeUs, int flags, int size, int offset, C8273a cryptoData) {
        if (this.f18343j) {
            mo25340a(this.f18344k);
        }
        long timeUs2 = timeUs + this.f18345l;
        if (this.f18347n) {
            if ((flags & 1) != 0 && this.f18336c.mo25763a(timeUs2)) {
                this.f18347n = false;
            } else {
                return;
            }
        }
        this.f18336c.mo25761a(timeUs2, flags, (this.f18346m - ((long) size)) - ((long) offset), size, cryptoData);
    }

    /* renamed from: a */
    private void m19962a(C8406a fromNode) {
        if (fromNode.f18351c) {
            C8406a aVar = this.f18341h;
            boolean z = aVar.f18351c;
            C8462c[] allocationsToRelease = new C8462c[((z ? 1 : 0) + (((int) (aVar.f18349a - fromNode.f18349a)) / this.f18335b))];
            C8406a currentNode = fromNode;
            for (int i = 0; i < allocationsToRelease.length; i++) {
                allocationsToRelease[i] = currentNode.f18352d;
                currentNode = currentNode.mo25790a();
            }
            this.f18334a.mo26006a(allocationsToRelease);
        }
    }

    /* renamed from: b */
    private int m19963b(int length) {
        C8406a aVar = this.f18341h;
        if (!aVar.f18351c) {
            aVar.mo25791a(this.f18334a.mo26004a(), new C8406a(this.f18341h.f18350b, this.f18335b));
        }
        return Math.min(length, (int) (this.f18341h.f18350b - this.f18346m));
    }

    /* renamed from: a */
    private void m19957a(int length) {
        this.f18346m += (long) length;
        long j = this.f18346m;
        C8406a aVar = this.f18341h;
        if (j == aVar.f18350b) {
            this.f18341h = aVar.f18353e;
        }
    }

    /* renamed from: a */
    private static Format m19956a(Format format, long sampleOffsetUs) {
        if (format == null) {
            return null;
        }
        if (sampleOffsetUs != 0) {
            long j = format.f16511k;
            if (j != Long.MAX_VALUE) {
                format = format.mo25010a(j + sampleOffsetUs);
            }
        }
        return format;
    }
}
