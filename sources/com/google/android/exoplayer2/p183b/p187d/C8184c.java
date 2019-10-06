package com.google.android.exoplayer2.p183b.p187d;

import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.p183b.C8268o;
import com.google.android.exoplayer2.p183b.C8268o.C8269a;
import com.google.android.exoplayer2.p183b.C8271p;
import com.google.android.exoplayer2.util.C8514e;
import java.io.EOFException;
import java.io.IOException;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.b.d.c */
/* compiled from: DefaultOggSeeker */
final class C8184c implements C8191h {

    /* renamed from: a */
    private final C8190g f17044a = new C8190g();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final long f17045b;

    /* renamed from: c */
    private final long f17046c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C8194k f17047d;

    /* renamed from: e */
    private int f17048e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f17049f;

    /* renamed from: g */
    private long f17050g;

    /* renamed from: h */
    private long f17051h;

    /* renamed from: i */
    private long f17052i;

    /* renamed from: j */
    private long f17053j;

    /* renamed from: k */
    private long f17054k;

    /* renamed from: l */
    private long f17055l;

    /* renamed from: com.google.android.exoplayer2.b.d.c$a */
    /* compiled from: DefaultOggSeeker */
    private class C8185a implements C8268o {
        private C8185a() {
        }

        /* renamed from: d */
        public boolean mo25195d() {
            return true;
        }

        /* renamed from: a */
        public C8269a mo25192a(long timeUs) {
            if (timeUs == 0) {
                return new C8269a(new C8271p(0, C8184c.this.f17045b));
            }
            long granule = C8184c.this.f17047d.mo25278b(timeUs);
            C8184c cVar = C8184c.this;
            return new C8269a(new C8271p(timeUs, cVar.m18791a(cVar.f17045b, granule, 30000)));
        }

        /* renamed from: b */
        public long mo25193b() {
            return C8184c.this.f17047d.mo25275a(C8184c.this.f17049f);
        }
    }

    public C8184c(long startPosition, long endPosition, C8194k streamReader, long firstPayloadPageSize, long firstPayloadPageGranulePosition, boolean firstPayloadPageIsLastPage) {
        C8514e.m20488a(startPosition >= 0 && endPosition > startPosition);
        this.f17047d = streamReader;
        this.f17045b = startPosition;
        this.f17046c = endPosition;
        if (firstPayloadPageSize == endPosition - startPosition || firstPayloadPageIsLastPage) {
            this.f17049f = firstPayloadPageGranulePosition;
            this.f17048e = 3;
            return;
        }
        this.f17048e = 0;
    }

    /* renamed from: a */
    public long mo25254a(C8261h input) throws IOException, InterruptedException {
        long position;
        int i = this.f17048e;
        if (i == 0) {
            this.f17050g = input.getPosition();
            this.f17048e = 1;
            long lastPageSearchPosition = this.f17046c - 65307;
            if (lastPageSearchPosition > this.f17050g) {
                return lastPageSearchPosition;
            }
        } else if (i != 1) {
            if (i == 2) {
                long currentGranule = this.f17051h;
                if (currentGranule == 0) {
                    position = 0;
                } else {
                    long position2 = mo25253a(currentGranule, input);
                    if (position2 >= 0) {
                        return position2;
                    }
                    position = mo25255a(input, this.f17051h, -(position2 + 2));
                }
                this.f17048e = 3;
                return -(2 + position);
            } else if (i == 3) {
                return -1;
            } else {
                throw new IllegalStateException();
            }
        }
        this.f17049f = mo25258b(input);
        this.f17048e = 3;
        return this.f17050g;
    }

    /* renamed from: c */
    public long mo25260c(long timeUs) {
        int i = this.f17048e;
        C8514e.m20488a(i == 3 || i == 2);
        long j = 0;
        if (timeUs != 0) {
            j = this.f17047d.mo25278b(timeUs);
        }
        this.f17051h = j;
        this.f17048e = 2;
        mo25259b();
        return this.f17051h;
    }

    /* renamed from: a */
    public C8185a m18800a() {
        if (this.f17049f != 0) {
            return new C8185a();
        }
        return null;
    }

    /* renamed from: b */
    public void mo25259b() {
        this.f17052i = this.f17045b;
        this.f17053j = this.f17046c;
        this.f17054k = 0;
        this.f17055l = this.f17049f;
    }

    /* renamed from: a */
    public long mo25253a(long targetGranule, C8261h input) throws IOException, InterruptedException {
        C8261h hVar = input;
        long j = 2;
        if (this.f17052i == this.f17053j) {
            return -(this.f17054k + 2);
        }
        long initialPosition = input.getPosition();
        if (!mo25257a(hVar, this.f17053j)) {
            long j2 = this.f17052i;
            if (j2 != initialPosition) {
                return j2;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f17044a.mo25273a(hVar, false);
        input.mo25239a();
        C8190g gVar = this.f17044a;
        long granuleDistance = targetGranule - gVar.f17076d;
        int pageSize = gVar.f17081i + gVar.f17082j;
        if (granuleDistance < 0 || granuleDistance > 72000) {
            if (granuleDistance < 0) {
                this.f17053j = initialPosition;
                this.f17055l = this.f17044a.f17076d;
            } else {
                this.f17052i = input.getPosition() + ((long) pageSize);
                this.f17054k = this.f17044a.f17076d;
                if ((this.f17053j - this.f17052i) + ((long) pageSize) < 100000) {
                    hVar.mo25248c(pageSize);
                    return -(this.f17054k + 2);
                }
            }
            long j3 = this.f17053j;
            long j4 = this.f17052i;
            if (j3 - j4 < 100000) {
                this.f17053j = j4;
                return j4;
            }
            long j5 = (long) pageSize;
            if (granuleDistance > 0) {
                j = 1;
            }
            long position = input.getPosition() - (j5 * j);
            long j6 = this.f17053j;
            long j7 = this.f17052i;
            long j8 = initialPosition;
            return Math.min(Math.max(position + (((j6 - j7) * granuleDistance) / (this.f17055l - this.f17054k)), j7), this.f17053j - 1);
        }
        hVar.mo25248c(pageSize);
        return -(this.f17044a.f17076d + 2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public long m18791a(long position, long granuleDistance, long offset) {
        long j = this.f17046c;
        long j2 = this.f17045b;
        long position2 = position + ((((j - j2) * granuleDistance) / this.f17049f) - offset);
        if (position2 < j2) {
            position2 = this.f17045b;
        }
        long j3 = this.f17046c;
        if (position2 >= j3) {
            return j3 - 1;
        }
        return position2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo25261c(C8261h input) throws IOException, InterruptedException {
        if (!mo25257a(input, this.f17046c)) {
            throw new EOFException();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo25257a(C8261h input, long limit) throws IOException, InterruptedException {
        long limit2 = Math.min(3 + limit, this.f17046c);
        byte[] buffer = new byte[Opcodes.ACC_STRICT];
        int peekLength = buffer.length;
        while (true) {
            if (input.getPosition() + ((long) peekLength) > limit2) {
                peekLength = (int) (limit2 - input.getPosition());
                if (peekLength < 4) {
                    return false;
                }
            }
            input.mo25243a(buffer, 0, peekLength, false);
            for (int i = 0; i < peekLength - 3; i++) {
                if (buffer[i] == 79 && buffer[i + 1] == 103 && buffer[i + 2] == 103 && buffer[i + 3] == 83) {
                    input.mo25248c(i);
                    return true;
                }
            }
            input.mo25248c(peekLength - 3);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public long mo25258b(C8261h input) throws IOException, InterruptedException {
        mo25261c(input);
        this.f17044a.mo25272a();
        while ((this.f17044a.f17075c & 4) != 4 && input.getPosition() < this.f17046c) {
            this.f17044a.mo25273a(input, false);
            C8190g gVar = this.f17044a;
            input.mo25248c(gVar.f17081i + gVar.f17082j);
        }
        return this.f17044a.f17076d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public long mo25255a(C8261h input, long targetGranule, long currentGranule) throws IOException, InterruptedException {
        this.f17044a.mo25273a(input, false);
        while (true) {
            C8190g gVar = this.f17044a;
            if (gVar.f17076d < targetGranule) {
                input.mo25248c(gVar.f17081i + gVar.f17082j);
                C8190g gVar2 = this.f17044a;
                currentGranule = gVar2.f17076d;
                gVar2.mo25273a(input, false);
            } else {
                input.mo25239a();
                return currentGranule;
            }
        }
    }
}
