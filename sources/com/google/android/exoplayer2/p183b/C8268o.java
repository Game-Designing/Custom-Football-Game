package com.google.android.exoplayer2.p183b;

import com.google.android.exoplayer2.util.C8514e;

/* renamed from: com.google.android.exoplayer2.b.o */
/* compiled from: SeekMap */
public interface C8268o {

    /* renamed from: com.google.android.exoplayer2.b.o$a */
    /* compiled from: SeekMap */
    public static final class C8269a {

        /* renamed from: a */
        public final C8271p f17511a;

        /* renamed from: b */
        public final C8271p f17512b;

        public C8269a(C8271p point) {
            this(point, point);
        }

        public C8269a(C8271p first, C8271p second) {
            C8514e.m20486a(first);
            this.f17511a = first;
            C8514e.m20486a(second);
            this.f17512b = second;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f17511a);
            if (this.f17511a.equals(this.f17512b)) {
                str = "";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(", ");
                sb2.append(this.f17512b);
                str = sb2.toString();
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C8269a other = (C8269a) obj;
            if (!this.f17511a.equals(other.f17511a) || !this.f17512b.equals(other.f17512b)) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return (this.f17511a.hashCode() * 31) + this.f17512b.hashCode();
        }
    }

    /* renamed from: com.google.android.exoplayer2.b.o$b */
    /* compiled from: SeekMap */
    public static final class C8270b implements C8268o {

        /* renamed from: a */
        private final long f17513a;

        /* renamed from: b */
        private final C8269a f17514b;

        public C8270b(long durationUs) {
            this(durationUs, 0);
        }

        public C8270b(long durationUs, long startPosition) {
            this.f17513a = durationUs;
            this.f17514b = new C8269a(startPosition == 0 ? C8271p.f17515a : new C8271p(0, startPosition));
        }

        /* renamed from: d */
        public boolean mo25195d() {
            return false;
        }

        /* renamed from: b */
        public long mo25193b() {
            return this.f17513a;
        }

        /* renamed from: a */
        public C8269a mo25192a(long timeUs) {
            return this.f17514b;
        }
    }

    /* renamed from: a */
    C8269a mo25192a(long j);

    /* renamed from: b */
    long mo25193b();

    /* renamed from: d */
    boolean mo25195d();
}
