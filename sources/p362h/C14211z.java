package p362h;

import java.util.Arrays;

/* renamed from: h.z */
/* compiled from: SegmentedByteString */
final class C14211z extends C14195j {

    /* renamed from: f */
    final transient byte[][] f43118f;

    /* renamed from: g */
    final transient int[] f43119g;

    C14211z(C14191g buffer, int byteCount) {
        super(null);
        C14183E.m45554a(buffer.f43073c, 0, (long) byteCount);
        int offset = 0;
        int segmentCount = 0;
        C14209x s = buffer.f43072b;
        while (offset < byteCount) {
            int i = s.f43111c;
            int i2 = s.f43110b;
            if (i != i2) {
                offset += i - i2;
                segmentCount++;
                s = s.f43114f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f43118f = new byte[segmentCount][];
        this.f43119g = new int[(segmentCount * 2)];
        int offset2 = 0;
        int segmentCount2 = 0;
        C14209x s2 = buffer.f43072b;
        while (offset2 < byteCount) {
            this.f43118f[segmentCount2] = s2.f43109a;
            offset2 += s2.f43111c - s2.f43110b;
            if (offset2 > byteCount) {
                offset2 = byteCount;
            }
            int[] iArr = this.f43119g;
            iArr[segmentCount2] = offset2;
            iArr[this.f43118f.length + segmentCount2] = s2.f43110b;
            s2.f43112d = true;
            segmentCount2++;
            s2 = s2.f43114f;
        }
    }

    /* renamed from: v */
    public String mo44289v() {
        return m45727w().mo44289v();
    }

    /* renamed from: e */
    public String mo44278e() {
        return m45727w().mo44278e();
    }

    /* renamed from: f */
    public String mo44280f() {
        return m45727w().mo44280f();
    }

    /* renamed from: t */
    public C14195j mo44286t() {
        return m45727w().mo44286t();
    }

    /* renamed from: g */
    public C14195j mo44281g() {
        return m45727w().mo44281g();
    }

    /* renamed from: i */
    public C14195j mo44283i() {
        return m45727w().mo44283i();
    }

    /* renamed from: j */
    public C14195j mo44284j() {
        return m45727w().mo44284j();
    }

    /* renamed from: a */
    public C14195j mo44272a(int beginIndex, int endIndex) {
        return m45727w().mo44272a(beginIndex, endIndex);
    }

    /* renamed from: a */
    public byte mo44270a(int pos) {
        C14183E.m45554a((long) this.f43119g[this.f43118f.length - 1], (long) pos, 1);
        int segment = m45726b(pos);
        int segmentOffset = segment == 0 ? 0 : this.f43119g[segment - 1];
        int[] iArr = this.f43119g;
        byte[][] bArr = this.f43118f;
        return bArr[segment][(pos - segmentOffset) + iArr[bArr.length + segment]];
    }

    /* renamed from: b */
    private int m45726b(int pos) {
        int i = Arrays.binarySearch(this.f43119g, 0, this.f43118f.length, pos + 1);
        return i >= 0 ? i : i ^ -1;
    }

    /* renamed from: s */
    public int mo44285s() {
        return this.f43119g[this.f43118f.length - 1];
    }

    /* renamed from: u */
    public byte[] mo44288u() {
        int[] iArr = this.f43119g;
        byte[][] bArr = this.f43118f;
        byte[] result = new byte[iArr[bArr.length - 1]];
        int segmentOffset = 0;
        int segmentCount = bArr.length;
        for (int s = 0; s < segmentCount; s++) {
            int[] iArr2 = this.f43119g;
            int segmentPos = iArr2[segmentCount + s];
            int nextSegmentOffset = iArr2[s];
            System.arraycopy(this.f43118f[s], segmentPos, result, segmentOffset, nextSegmentOffset - segmentOffset);
            segmentOffset = nextSegmentOffset;
        }
        return result;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo44273a(C14191g buffer) {
        int segmentOffset = 0;
        int segmentCount = this.f43118f.length;
        for (int s = 0; s < segmentCount; s++) {
            int[] iArr = this.f43119g;
            int segmentPos = iArr[segmentCount + s];
            int nextSegmentOffset = iArr[s];
            C14209x segment = new C14209x(this.f43118f[s], segmentPos, (segmentPos + nextSegmentOffset) - segmentOffset, true, false);
            C14209x xVar = buffer.f43072b;
            if (xVar == null) {
                segment.f43115g = segment;
                segment.f43114f = segment;
                buffer.f43072b = segment;
            } else {
                xVar.f43115g.mo44313a(segment);
            }
            segmentOffset = nextSegmentOffset;
        }
        buffer.f43073c += (long) segmentOffset;
    }

    /* renamed from: a */
    public boolean mo44274a(int offset, C14195j other, int otherOffset, int byteCount) {
        if (offset < 0 || offset > mo44285s() - byteCount) {
            return false;
        }
        int s = m45726b(offset);
        while (byteCount > 0) {
            int segmentOffset = s == 0 ? 0 : this.f43119g[s - 1];
            int stepSize = Math.min(byteCount, (segmentOffset + (this.f43119g[s] - segmentOffset)) - offset);
            int[] iArr = this.f43119g;
            byte[][] bArr = this.f43118f;
            if (!other.mo44275a(otherOffset, bArr[s], (offset - segmentOffset) + iArr[bArr.length + s], stepSize)) {
                return false;
            }
            offset += stepSize;
            otherOffset += stepSize;
            byteCount -= stepSize;
            s++;
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo44275a(int offset, byte[] other, int otherOffset, int byteCount) {
        if (offset < 0 || offset > mo44285s() - byteCount || otherOffset < 0 || otherOffset > other.length - byteCount) {
            return false;
        }
        int s = m45726b(offset);
        while (byteCount > 0) {
            int segmentOffset = s == 0 ? 0 : this.f43119g[s - 1];
            int stepSize = Math.min(byteCount, (segmentOffset + (this.f43119g[s] - segmentOffset)) - offset);
            int[] iArr = this.f43119g;
            byte[][] bArr = this.f43118f;
            if (!C14183E.m45556a(bArr[s], (offset - segmentOffset) + iArr[bArr.length + s], other, otherOffset, stepSize)) {
                return false;
            }
            offset += stepSize;
            otherOffset += stepSize;
            byteCount -= stepSize;
            s++;
        }
        return true;
    }

    /* renamed from: w */
    private C14195j m45727w() {
        return new C14195j(mo44288u());
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (o == this) {
            return true;
        }
        if (!(o instanceof C14195j) || ((C14195j) o).mo44285s() != mo44285s() || !mo44274a(0, (C14195j) o, 0, mo44285s())) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int result = this.f43084d;
        if (result != 0) {
            return result;
        }
        int result2 = 1;
        int segmentOffset = 0;
        int segmentCount = this.f43118f.length;
        for (int s = 0; s < segmentCount; s++) {
            byte[] segment = this.f43118f[s];
            int[] iArr = this.f43119g;
            int segmentPos = iArr[segmentCount + s];
            int nextSegmentOffset = iArr[s];
            for (int i = segmentPos; i < segmentPos + (nextSegmentOffset - segmentOffset); i++) {
                result2 = (result2 * 31) + segment[i];
            }
            segmentOffset = nextSegmentOffset;
        }
        this.f43084d = result2;
        return result2;
    }

    public String toString() {
        return m45727w().toString();
    }

    private Object writeReplace() {
        return m45727w();
    }
}
