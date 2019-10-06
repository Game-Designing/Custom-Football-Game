package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.util.C8514e;
import java.util.Arrays;
import java.util.Comparator;

/* renamed from: com.google.android.exoplayer2.trackselection.c */
/* compiled from: BaseTrackSelection */
public abstract class C8425c implements C8432h {

    /* renamed from: a */
    protected final TrackGroup f18457a;

    /* renamed from: b */
    protected final int f18458b;

    /* renamed from: c */
    protected final int[] f18459c;

    /* renamed from: d */
    private final Format[] f18460d;

    /* renamed from: e */
    private final long[] f18461e;

    /* renamed from: f */
    private int f18462f;

    /* renamed from: com.google.android.exoplayer2.trackselection.c$a */
    /* compiled from: BaseTrackSelection */
    private static final class C8426a implements Comparator<Format> {
        private C8426a() {
        }

        /* renamed from: a */
        public int compare(Format a, Format b) {
            return b.f16503c - a.f16503c;
        }
    }

    public C8425c(TrackGroup group, int... tracks) {
        C8514e.m20490b(tracks.length > 0);
        C8514e.m20486a(group);
        this.f18457a = group;
        this.f18458b = tracks.length;
        this.f18460d = new Format[this.f18458b];
        for (int i = 0; i < tracks.length; i++) {
            this.f18460d[i] = group.mo25645a(tracks[i]);
        }
        Arrays.sort(this.f18460d, new C8426a());
        this.f18459c = new int[this.f18458b];
        int i2 = 0;
        while (true) {
            int i3 = this.f18458b;
            if (i2 < i3) {
                this.f18459c[i2] = group.mo25644a(this.f18460d[i2]);
                i2++;
            } else {
                this.f18461e = new long[i3];
                return;
            }
        }
    }

    /* renamed from: d */
    public void mo25829d() {
    }

    /* renamed from: c */
    public void mo25835c() {
    }

    /* renamed from: b */
    public final TrackGroup mo25834b() {
        return this.f18457a;
    }

    public final int length() {
        return this.f18459c.length;
    }

    /* renamed from: a */
    public final Format mo25831a(int index) {
        return this.f18460d[index];
    }

    /* renamed from: b */
    public final int mo25833b(int index) {
        return this.f18459c[index];
    }

    /* renamed from: e */
    public final Format mo25836e() {
        return this.f18460d[mo25827a()];
    }

    /* renamed from: a */
    public void mo25828a(float playbackSpeed) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo25832a(int index, long nowMs) {
        return this.f18461e[index] > nowMs;
    }

    public int hashCode() {
        if (this.f18462f == 0) {
            this.f18462f = (System.identityHashCode(this.f18457a) * 31) + Arrays.hashCode(this.f18459c);
        }
        return this.f18462f;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C8425c other = (C8425c) obj;
        if (this.f18457a != other.f18457a || !Arrays.equals(this.f18459c, other.f18459c)) {
            z = false;
        }
        return z;
    }
}
