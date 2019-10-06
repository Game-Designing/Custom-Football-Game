package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import com.google.android.exoplayer2.util.C8514e;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.source.ads.a */
/* compiled from: AdPlaybackState */
public final class C8368a {

    /* renamed from: a */
    public static final C8368a f18160a = new C8368a(new long[0]);

    /* renamed from: b */
    public final int f18161b;

    /* renamed from: c */
    public final long[] f18162c;

    /* renamed from: d */
    public final C8369a[] f18163d;

    /* renamed from: e */
    public final long f18164e;

    /* renamed from: f */
    public final long f18165f;

    /* renamed from: com.google.android.exoplayer2.source.ads.a$a */
    /* compiled from: AdPlaybackState */
    public static final class C8369a {

        /* renamed from: a */
        public final int f18166a;

        /* renamed from: b */
        public final Uri[] f18167b;

        /* renamed from: c */
        public final int[] f18168c;

        /* renamed from: d */
        public final long[] f18169d;

        public C8369a() {
            this(-1, new int[0], new Uri[0], new long[0]);
        }

        private C8369a(int count, int[] states, Uri[] uris, long[] durationsUs) {
            C8514e.m20488a(states.length == uris.length);
            this.f18166a = count;
            this.f18168c = states;
            this.f18167b = uris;
            this.f18169d = durationsUs;
        }

        /* renamed from: a */
        public int mo25661a() {
            return mo25662a(-1);
        }

        /* renamed from: a */
        public int mo25662a(int lastPlayedAdIndex) {
            int nextAdIndexToPlay = lastPlayedAdIndex + 1;
            while (true) {
                int[] iArr = this.f18168c;
                if (nextAdIndexToPlay >= iArr.length || iArr[nextAdIndexToPlay] == 0 || iArr[nextAdIndexToPlay] == 1) {
                    return nextAdIndexToPlay;
                }
                nextAdIndexToPlay++;
            }
            return nextAdIndexToPlay;
        }

        /* renamed from: b */
        public boolean mo25663b() {
            return this.f18166a == -1 || mo25661a() < this.f18166a;
        }

        public boolean equals(Object o) {
            boolean z = true;
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            C8369a adGroup = (C8369a) o;
            if (this.f18166a != adGroup.f18166a || !Arrays.equals(this.f18167b, adGroup.f18167b) || !Arrays.equals(this.f18168c, adGroup.f18168c) || !Arrays.equals(this.f18169d, adGroup.f18169d)) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return (((((this.f18166a * 31) + Arrays.hashCode(this.f18167b)) * 31) + Arrays.hashCode(this.f18168c)) * 31) + Arrays.hashCode(this.f18169d);
        }
    }

    public C8368a(long... adGroupTimesUs) {
        int count = adGroupTimesUs.length;
        this.f18161b = count;
        this.f18162c = Arrays.copyOf(adGroupTimesUs, count);
        this.f18163d = new C8369a[count];
        for (int i = 0; i < count; i++) {
            this.f18163d[i] = new C8369a();
        }
        this.f18164e = 0;
        this.f18165f = -9223372036854775807L;
    }

    /* renamed from: b */
    public int mo25658b(long positionUs) {
        int index = this.f18162c.length - 1;
        while (index >= 0 && m19776a(positionUs, index)) {
            index--;
        }
        if (index < 0 || !this.f18163d[index].mo25663b()) {
            return -1;
        }
        return index;
    }

    /* renamed from: a */
    public int mo25657a(long positionUs) {
        int index = 0;
        while (true) {
            long[] jArr = this.f18162c;
            if (index < jArr.length && jArr[index] != Long.MIN_VALUE && (positionUs >= jArr[index] || !this.f18163d[index].mo25663b())) {
                index++;
            }
        }
        if (index < this.f18162c.length) {
            return index;
        }
        return -1;
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        C8368a that = (C8368a) o;
        if (!(this.f18161b == that.f18161b && this.f18164e == that.f18164e && this.f18165f == that.f18165f && Arrays.equals(this.f18162c, that.f18162c) && Arrays.equals(this.f18163d, that.f18163d))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((((((this.f18161b * 31) + ((int) this.f18164e)) * 31) + ((int) this.f18165f)) * 31) + Arrays.hashCode(this.f18162c)) * 31) + Arrays.hashCode(this.f18163d);
    }

    /* renamed from: a */
    private boolean m19776a(long positionUs, int adGroupIndex) {
        long adGroupPositionUs = this.f18162c[adGroupIndex];
        boolean z = true;
        if (adGroupPositionUs == Long.MIN_VALUE) {
            long j = this.f18165f;
            if (j != -9223372036854775807L && positionUs >= j) {
                z = false;
            }
            return z;
        }
        if (positionUs >= adGroupPositionUs) {
            z = false;
        }
        return z;
    }
}
