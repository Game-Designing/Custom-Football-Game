package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.os.Handler;
import android.util.SparseArray;
import com.google.android.exoplayer2.upstream.C8482e.C8483a;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8517g;
import com.google.android.exoplayer2.util.C8521k;
import com.google.android.exoplayer2.util.C8521k.C8522a;
import com.google.android.exoplayer2.util.C8540y;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.upstream.m */
/* compiled from: DefaultBandwidthMeter */
public final class C8492m implements C8482e, C8502v {

    /* renamed from: a */
    public static final Map<String, int[]> f18731a = m20349c();

    /* renamed from: b */
    public static final long[] f18732b = {5700000, 3400000, 1900000, 1000000, 400000};

    /* renamed from: c */
    public static final long[] f18733c = {169000, 129000, 114000, 102000, 87000};

    /* renamed from: d */
    public static final long[] f18734d = {2100000, 1300000, 950000, 700000, 400000};

    /* renamed from: e */
    public static final long[] f18735e = {6900000, 4300000, 2700000, 1600000, 450000};

    /* renamed from: f */
    private final C8521k<C8483a> f18736f;

    /* renamed from: g */
    private final C8540y f18737g;

    /* renamed from: h */
    private final C8517g f18738h;

    /* renamed from: i */
    private int f18739i;

    /* renamed from: j */
    private long f18740j;

    /* renamed from: k */
    private long f18741k;

    /* renamed from: l */
    private long f18742l;

    /* renamed from: m */
    private long f18743m;

    /* renamed from: n */
    private long f18744n;

    /* renamed from: com.google.android.exoplayer2.upstream.m$a */
    /* compiled from: DefaultBandwidthMeter */
    public static final class C8493a {

        /* renamed from: a */
        private final Context f18745a;

        /* renamed from: b */
        private Handler f18746b;

        /* renamed from: c */
        private C8483a f18747c;

        /* renamed from: d */
        private SparseArray<Long> f18748d;

        /* renamed from: e */
        private int f18749e;

        /* renamed from: f */
        private C8517g f18750f;

        @Deprecated
        public C8493a() {
            this(null);
        }

        public C8493a(Context context) {
            this.f18745a = context == null ? null : context.getApplicationContext();
            this.f18748d = m20358b(C8509F.m20444a(context));
            this.f18749e = 2000;
            this.f18750f = C8517g.f18812a;
        }

        /* renamed from: a */
        public C8492m mo26029a() {
            Long initialBitrateEstimate = (Long) this.f18748d.get(C8509F.m20463b(this.f18745a));
            if (initialBitrateEstimate == null) {
                initialBitrateEstimate = (Long) this.f18748d.get(0);
            }
            C8492m bandwidthMeter = new C8492m(initialBitrateEstimate.longValue(), this.f18749e, this.f18750f);
            Handler handler = this.f18746b;
            if (handler != null) {
                C8483a aVar = this.f18747c;
                if (aVar != null) {
                    bandwidthMeter.mo26024a(handler, aVar);
                }
            }
            return bandwidthMeter;
        }

        /* renamed from: b */
        private static SparseArray<Long> m20358b(String countryCode) {
            int[] groupIndices = m20357a(countryCode);
            SparseArray<Long> result = new SparseArray<>(6);
            result.append(0, Long.valueOf(1000000));
            result.append(2, Long.valueOf(C8492m.f18732b[groupIndices[0]]));
            result.append(3, Long.valueOf(C8492m.f18733c[groupIndices[1]]));
            result.append(4, Long.valueOf(C8492m.f18734d[groupIndices[2]]));
            result.append(5, Long.valueOf(C8492m.f18735e[groupIndices[3]]));
            result.append(7, Long.valueOf(C8492m.f18732b[groupIndices[0]]));
            return result;
        }

        /* renamed from: a */
        private static int[] m20357a(String countryCode) {
            int[] groupIndices = (int[]) C8492m.f18731a.get(countryCode);
            return groupIndices == null ? new int[]{2, 2, 2, 2} : groupIndices;
        }
    }

    private C8492m(long initialBitrateEstimate, int maxWeight, C8517g clock) {
        this.f18736f = new C8521k<>();
        this.f18737g = new C8540y(maxWeight);
        this.f18738h = clock;
        this.f18744n = initialBitrateEstimate;
    }

    /* renamed from: b */
    public synchronized long mo26010b() {
        return this.f18744n;
    }

    /* renamed from: a */
    public C8502v mo26009a() {
        return this;
    }

    /* renamed from: a */
    public void mo26024a(Handler eventHandler, C8483a eventListener) {
        this.f18736f.mo26080a(eventHandler, eventListener);
    }

    /* renamed from: c */
    public void mo26028c(C8487i source, C8489j dataSpec, boolean isNetwork) {
    }

    /* renamed from: b */
    public synchronized void mo26027b(C8487i source, C8489j dataSpec, boolean isNetwork) {
        if (isNetwork) {
            if (this.f18739i == 0) {
                this.f18740j = this.f18738h.mo26036a();
            }
            this.f18739i++;
        }
    }

    /* renamed from: a */
    public synchronized void mo26026a(C8487i source, C8489j dataSpec, boolean isNetwork, int bytes) {
        if (isNetwork) {
            this.f18741k += (long) bytes;
        }
    }

    /* renamed from: a */
    public synchronized void mo26025a(C8487i source, C8489j dataSpec, boolean isNetwork) {
        if (isNetwork) {
            C8514e.m20490b(this.f18739i > 0);
            long nowMs = this.f18738h.mo26036a();
            int sampleElapsedTimeMs = (int) (nowMs - this.f18740j);
            this.f18742l += (long) sampleElapsedTimeMs;
            this.f18743m += this.f18741k;
            if (sampleElapsedTimeMs > 0) {
                this.f18737g.mo26152a((int) Math.sqrt((double) this.f18741k), (float) ((this.f18741k * 8000) / ((long) sampleElapsedTimeMs)));
                if (this.f18742l >= 2000 || this.f18743m >= 524288) {
                    this.f18744n = (long) this.f18737g.mo26151a(0.5f);
                }
            }
            m20347a(sampleElapsedTimeMs, this.f18741k, this.f18744n);
            int i = this.f18739i - 1;
            this.f18739i = i;
            if (i > 0) {
                this.f18740j = nowMs;
            }
            this.f18741k = 0;
        }
    }

    /* renamed from: a */
    private void m20347a(int elapsedMs, long bytes, long bitrate) {
        C8521k<C8483a> kVar = this.f18736f;
        C8460a aVar = new C8460a(elapsedMs, bytes, bitrate);
        kVar.mo26081a((C8522a<T>) aVar);
    }

    /* renamed from: c */
    private static Map<String, int[]> m20349c() {
        HashMap<String, int[]> countryGroupAssignment = new HashMap<>();
        countryGroupAssignment.put("AD", new int[]{1, 0, 0, 0});
        countryGroupAssignment.put("AE", new int[]{1, 3, 4, 4});
        countryGroupAssignment.put("AF", new int[]{4, 4, 3, 2});
        countryGroupAssignment.put("AG", new int[]{3, 2, 1, 2});
        countryGroupAssignment.put("AI", new int[]{1, 0, 0, 2});
        countryGroupAssignment.put("AL", new int[]{1, 1, 1, 1});
        countryGroupAssignment.put("AM", new int[]{2, 2, 4, 3});
        countryGroupAssignment.put("AO", new int[]{2, 4, 2, 0});
        countryGroupAssignment.put("AR", new int[]{2, 3, 2, 3});
        countryGroupAssignment.put("AS", new int[]{3, 4, 4, 1});
        countryGroupAssignment.put("AT", new int[]{0, 1, 0, 0});
        countryGroupAssignment.put("AU", new int[]{0, 3, 0, 0});
        countryGroupAssignment.put("AW", new int[]{1, 1, 0, 4});
        countryGroupAssignment.put("AX", new int[]{0, 1, 0, 0});
        countryGroupAssignment.put("AZ", new int[]{3, 3, 2, 2});
        countryGroupAssignment.put("BA", new int[]{1, 1, 1, 2});
        countryGroupAssignment.put("BB", new int[]{0, 1, 0, 0});
        countryGroupAssignment.put("BD", new int[]{2, 1, 3, 2});
        countryGroupAssignment.put("BE", new int[]{0, 0, 0, 0});
        countryGroupAssignment.put("BF", new int[]{4, 4, 4, 1});
        countryGroupAssignment.put("BG", new int[]{0, 0, 0, 1});
        countryGroupAssignment.put("BH", new int[]{2, 1, 3, 4});
        countryGroupAssignment.put("BI", new int[]{4, 3, 4, 4});
        countryGroupAssignment.put("BJ", new int[]{4, 3, 4, 3});
        countryGroupAssignment.put("BL", new int[]{1, 0, 1, 2});
        countryGroupAssignment.put("BM", new int[]{1, 0, 0, 0});
        countryGroupAssignment.put("BN", new int[]{4, 3, 3, 3});
        countryGroupAssignment.put("BO", new int[]{2, 2, 1, 2});
        countryGroupAssignment.put("BQ", new int[]{1, 1, 2, 4});
        countryGroupAssignment.put("BR", new int[]{2, 3, 2, 2});
        countryGroupAssignment.put("BS", new int[]{1, 1, 0, 2});
        countryGroupAssignment.put("BT", new int[]{3, 0, 2, 1});
        countryGroupAssignment.put("BW", new int[]{4, 4, 2, 3});
        countryGroupAssignment.put("BY", new int[]{1, 1, 1, 1});
        countryGroupAssignment.put("BZ", new int[]{2, 3, 3, 1});
        countryGroupAssignment.put("CA", new int[]{0, 2, 2, 3});
        countryGroupAssignment.put("CD", new int[]{4, 4, 2, 1});
        countryGroupAssignment.put("CF", new int[]{4, 4, 3, 3});
        countryGroupAssignment.put("CG", new int[]{4, 4, 4, 4});
        countryGroupAssignment.put("CH", new int[]{0, 0, 0, 0});
        countryGroupAssignment.put("CI", new int[]{4, 4, 4, 4});
        countryGroupAssignment.put("CK", new int[]{2, 4, 2, 0});
        countryGroupAssignment.put("CL", new int[]{2, 2, 2, 3});
        countryGroupAssignment.put("CM", new int[]{3, 4, 3, 1});
        countryGroupAssignment.put("CN", new int[]{2, 0, 1, 2});
        countryGroupAssignment.put("CO", new int[]{2, 3, 2, 1});
        countryGroupAssignment.put("CR", new int[]{2, 2, 4, 4});
        countryGroupAssignment.put("CU", new int[]{4, 4, 4, 1});
        countryGroupAssignment.put("CV", new int[]{2, 2, 2, 4});
        countryGroupAssignment.put("CW", new int[]{1, 1, 0, 0});
        countryGroupAssignment.put("CX", new int[]{1, 2, 2, 2});
        countryGroupAssignment.put("CY", new int[]{1, 1, 0, 0});
        countryGroupAssignment.put("CZ", new int[]{0, 1, 0, 0});
        countryGroupAssignment.put("DE", new int[]{0, 2, 2, 2});
        countryGroupAssignment.put("DJ", new int[]{3, 4, 4, 0});
        countryGroupAssignment.put("DK", new int[]{0, 0, 0, 0});
        countryGroupAssignment.put("DM", new int[]{2, 0, 3, 4});
        countryGroupAssignment.put("DO", new int[]{3, 3, 4, 4});
        countryGroupAssignment.put("DZ", new int[]{3, 3, 4, 4});
        countryGroupAssignment.put("EC", new int[]{2, 3, 3, 1});
        countryGroupAssignment.put("EE", new int[]{0, 0, 0, 0});
        countryGroupAssignment.put("EG", new int[]{3, 3, 1, 1});
        countryGroupAssignment.put("EH", new int[]{2, 0, 2, 3});
        countryGroupAssignment.put("ER", new int[]{4, 2, 2, 2});
        countryGroupAssignment.put("ES", new int[]{0, 0, 1, 1});
        countryGroupAssignment.put("ET", new int[]{4, 4, 4, 0});
        countryGroupAssignment.put("FI", new int[]{0, 0, 1, 0});
        countryGroupAssignment.put("FJ", new int[]{3, 2, 3, 3});
        countryGroupAssignment.put("FK", new int[]{3, 4, 2, 1});
        countryGroupAssignment.put("FM", new int[]{4, 2, 4, 0});
        countryGroupAssignment.put("FO", new int[]{0, 0, 0, 1});
        countryGroupAssignment.put("FR", new int[]{1, 0, 2, 1});
        countryGroupAssignment.put("GA", new int[]{3, 3, 2, 1});
        countryGroupAssignment.put("GB", new int[]{0, 1, 3, 2});
        countryGroupAssignment.put("GD", new int[]{2, 0, 3, 0});
        countryGroupAssignment.put("GE", new int[]{1, 1, 0, 3});
        countryGroupAssignment.put("GF", new int[]{1, 2, 4, 4});
        countryGroupAssignment.put("GG", new int[]{0, 1, 0, 0});
        countryGroupAssignment.put("GH", new int[]{3, 2, 2, 2});
        countryGroupAssignment.put("GI", new int[]{0, 0, 0, 1});
        countryGroupAssignment.put("GL", new int[]{2, 4, 1, 4});
        countryGroupAssignment.put("GM", new int[]{4, 3, 3, 0});
        countryGroupAssignment.put("GN", new int[]{4, 4, 3, 4});
        countryGroupAssignment.put("GP", new int[]{2, 2, 1, 3});
        countryGroupAssignment.put("GQ", new int[]{4, 4, 3, 1});
        countryGroupAssignment.put("GR", new int[]{1, 1, 0, 1});
        countryGroupAssignment.put("GT", new int[]{3, 2, 3, 4});
        countryGroupAssignment.put("GU", new int[]{1, 0, 4, 4});
        countryGroupAssignment.put("GW", new int[]{4, 4, 4, 0});
        countryGroupAssignment.put("GY", new int[]{3, 4, 1, 0});
        countryGroupAssignment.put("HK", new int[]{0, 2, 3, 4});
        countryGroupAssignment.put("HN", new int[]{3, 3, 2, 2});
        countryGroupAssignment.put("HR", new int[]{1, 0, 0, 2});
        countryGroupAssignment.put("HT", new int[]{3, 3, 3, 3});
        countryGroupAssignment.put("HU", new int[]{0, 0, 1, 0});
        countryGroupAssignment.put("ID", new int[]{2, 3, 3, 4});
        countryGroupAssignment.put("IE", new int[]{0, 0, 1, 1});
        countryGroupAssignment.put("IL", new int[]{0, 1, 1, 3});
        countryGroupAssignment.put("IM", new int[]{0, 1, 0, 1});
        countryGroupAssignment.put("IN", new int[]{2, 3, 3, 4});
        countryGroupAssignment.put("IO", new int[]{4, 2, 2, 2});
        countryGroupAssignment.put("IQ", new int[]{3, 3, 4, 3});
        countryGroupAssignment.put("IR", new int[]{3, 2, 4, 4});
        countryGroupAssignment.put("IS", new int[]{0, 0, 0, 0});
        countryGroupAssignment.put("IT", new int[]{1, 0, 1, 3});
        countryGroupAssignment.put("JE", new int[]{0, 0, 0, 1});
        countryGroupAssignment.put("JM", new int[]{3, 3, 3, 2});
        countryGroupAssignment.put("JO", new int[]{1, 1, 1, 2});
        countryGroupAssignment.put("JP", new int[]{0, 1, 1, 2});
        countryGroupAssignment.put("KE", new int[]{3, 3, 3, 3});
        countryGroupAssignment.put("KG", new int[]{2, 2, 3, 3});
        countryGroupAssignment.put("KH", new int[]{1, 0, 4, 4});
        countryGroupAssignment.put("KI", new int[]{4, 4, 4, 4});
        countryGroupAssignment.put("KM", new int[]{4, 4, 2, 2});
        countryGroupAssignment.put("KN", new int[]{1, 0, 1, 3});
        countryGroupAssignment.put("KP", new int[]{1, 2, 2, 2});
        countryGroupAssignment.put("KR", new int[]{0, 4, 0, 2});
        countryGroupAssignment.put("KW", new int[]{1, 2, 1, 2});
        countryGroupAssignment.put("KY", new int[]{1, 1, 0, 2});
        countryGroupAssignment.put("KZ", new int[]{1, 2, 2, 3});
        countryGroupAssignment.put("LA", new int[]{3, 2, 2, 2});
        countryGroupAssignment.put("LB", new int[]{3, 2, 0, 0});
        countryGroupAssignment.put("LC", new int[]{2, 2, 1, 0});
        countryGroupAssignment.put("LI", new int[]{0, 0, 1, 2});
        countryGroupAssignment.put("LK", new int[]{1, 1, 2, 2});
        countryGroupAssignment.put("LR", new int[]{3, 4, 3, 1});
        countryGroupAssignment.put("LS", new int[]{3, 3, 2, 0});
        countryGroupAssignment.put("LT", new int[]{0, 0, 0, 1});
        countryGroupAssignment.put("LU", new int[]{0, 0, 1, 0});
        countryGroupAssignment.put("LV", new int[]{0, 0, 0, 0});
        countryGroupAssignment.put("LY", new int[]{4, 4, 4, 4});
        countryGroupAssignment.put("MA", new int[]{2, 1, 2, 2});
        countryGroupAssignment.put("MC", new int[]{1, 0, 1, 0});
        countryGroupAssignment.put("MD", new int[]{1, 1, 0, 0});
        countryGroupAssignment.put("ME", new int[]{1, 2, 2, 3});
        countryGroupAssignment.put("MF", new int[]{1, 4, 3, 3});
        countryGroupAssignment.put("MG", new int[]{3, 4, 1, 2});
        countryGroupAssignment.put("MH", new int[]{4, 0, 2, 3});
        countryGroupAssignment.put("MK", new int[]{1, 0, 0, 1});
        countryGroupAssignment.put("ML", new int[]{4, 4, 4, 4});
        countryGroupAssignment.put("MM", new int[]{2, 3, 1, 2});
        countryGroupAssignment.put("MN", new int[]{2, 2, 2, 4});
        countryGroupAssignment.put("MO", new int[]{0, 1, 4, 4});
        countryGroupAssignment.put("MP", new int[]{0, 0, 4, 4});
        countryGroupAssignment.put("MQ", new int[]{1, 1, 1, 3});
        countryGroupAssignment.put("MR", new int[]{4, 2, 4, 2});
        countryGroupAssignment.put("MS", new int[]{1, 2, 1, 2});
        countryGroupAssignment.put("MT", new int[]{0, 0, 0, 0});
        countryGroupAssignment.put("MU", new int[]{2, 2, 4, 4});
        countryGroupAssignment.put("MV", new int[]{4, 2, 0, 1});
        countryGroupAssignment.put("MW", new int[]{3, 2, 1, 1});
        countryGroupAssignment.put("MX", new int[]{2, 4, 3, 1});
        countryGroupAssignment.put("MY", new int[]{2, 3, 3, 3});
        countryGroupAssignment.put("MZ", new int[]{3, 3, 2, 4});
        countryGroupAssignment.put("NA", new int[]{4, 2, 1, 1});
        countryGroupAssignment.put("NC", new int[]{2, 1, 3, 3});
        countryGroupAssignment.put("NE", new int[]{4, 4, 4, 4});
        countryGroupAssignment.put("NF", new int[]{0, 2, 2, 2});
        countryGroupAssignment.put("NG", new int[]{3, 4, 2, 2});
        countryGroupAssignment.put("NI", new int[]{3, 4, 3, 3});
        countryGroupAssignment.put("NL", new int[]{0, 1, 3, 2});
        countryGroupAssignment.put("NO", new int[]{0, 0, 1, 0});
        countryGroupAssignment.put("NP", new int[]{2, 3, 2, 2});
        countryGroupAssignment.put("NR", new int[]{4, 3, 4, 1});
        countryGroupAssignment.put("NU", new int[]{4, 2, 2, 2});
        countryGroupAssignment.put("NZ", new int[]{0, 0, 0, 1});
        countryGroupAssignment.put("OM", new int[]{2, 2, 1, 3});
        countryGroupAssignment.put("PA", new int[]{1, 3, 2, 3});
        countryGroupAssignment.put("PE", new int[]{2, 2, 4, 4});
        countryGroupAssignment.put("PF", new int[]{2, 2, 0, 1});
        countryGroupAssignment.put("PG", new int[]{4, 4, 4, 4});
        countryGroupAssignment.put("PH", new int[]{3, 0, 4, 4});
        countryGroupAssignment.put("PK", new int[]{3, 3, 3, 3});
        countryGroupAssignment.put("PL", new int[]{1, 0, 1, 3});
        countryGroupAssignment.put("PM", new int[]{0, 2, 2, 3});
        countryGroupAssignment.put("PR", new int[]{2, 3, 4, 3});
        countryGroupAssignment.put("PS", new int[]{2, 3, 0, 4});
        countryGroupAssignment.put("PT", new int[]{1, 1, 1, 1});
        countryGroupAssignment.put("PW", new int[]{3, 2, 3, 0});
        countryGroupAssignment.put("PY", new int[]{2, 1, 3, 3});
        countryGroupAssignment.put("QA", new int[]{2, 3, 1, 2});
        countryGroupAssignment.put("RE", new int[]{1, 1, 2, 2});
        countryGroupAssignment.put("RO", new int[]{0, 1, 1, 3});
        countryGroupAssignment.put("RS", new int[]{1, 1, 0, 0});
        countryGroupAssignment.put("RU", new int[]{0, 1, 1, 1});
        countryGroupAssignment.put("RW", new int[]{3, 4, 3, 1});
        countryGroupAssignment.put("SA", new int[]{3, 2, 2, 3});
        countryGroupAssignment.put("SB", new int[]{4, 4, 3, 0});
        countryGroupAssignment.put("SC", new int[]{4, 2, 0, 1});
        countryGroupAssignment.put("SD", new int[]{3, 4, 4, 4});
        countryGroupAssignment.put("SE", new int[]{0, 0, 0, 0});
        countryGroupAssignment.put("SG", new int[]{1, 2, 3, 3});
        countryGroupAssignment.put("SH", new int[]{4, 2, 2, 2});
        countryGroupAssignment.put("SI", new int[]{0, 1, 0, 0});
        countryGroupAssignment.put("SJ", new int[]{3, 2, 0, 2});
        countryGroupAssignment.put("SK", new int[]{0, 1, 0, 1});
        countryGroupAssignment.put("SL", new int[]{4, 3, 2, 4});
        countryGroupAssignment.put("SM", new int[]{1, 0, 1, 1});
        countryGroupAssignment.put("SN", new int[]{4, 4, 4, 2});
        countryGroupAssignment.put("SO", new int[]{4, 4, 4, 3});
        countryGroupAssignment.put("SR", new int[]{3, 2, 2, 3});
        countryGroupAssignment.put("SS", new int[]{4, 3, 4, 2});
        countryGroupAssignment.put("ST", new int[]{3, 2, 2, 2});
        countryGroupAssignment.put("SV", new int[]{2, 3, 2, 3});
        countryGroupAssignment.put("SX", new int[]{2, 4, 2, 0});
        countryGroupAssignment.put("SY", new int[]{4, 4, 2, 0});
        countryGroupAssignment.put("SZ", new int[]{3, 4, 1, 1});
        countryGroupAssignment.put("TC", new int[]{2, 1, 2, 1});
        countryGroupAssignment.put("TD", new int[]{4, 4, 4, 3});
        countryGroupAssignment.put("TG", new int[]{3, 2, 2, 0});
        countryGroupAssignment.put("TH", new int[]{1, 3, 4, 4});
        countryGroupAssignment.put("TJ", new int[]{4, 4, 4, 4});
        countryGroupAssignment.put("TL", new int[]{4, 2, 4, 4});
        countryGroupAssignment.put("TM", new int[]{4, 1, 3, 3});
        countryGroupAssignment.put("TN", new int[]{2, 2, 1, 2});
        countryGroupAssignment.put("TO", new int[]{2, 3, 3, 1});
        countryGroupAssignment.put("TR", new int[]{1, 2, 0, 2});
        countryGroupAssignment.put("TT", new int[]{2, 1, 1, 0});
        countryGroupAssignment.put("TV", new int[]{4, 2, 2, 4});
        countryGroupAssignment.put("TW", new int[]{0, 0, 0, 1});
        countryGroupAssignment.put("TZ", new int[]{3, 3, 3, 2});
        countryGroupAssignment.put("UA", new int[]{0, 2, 1, 3});
        countryGroupAssignment.put("UG", new int[]{4, 3, 2, 2});
        countryGroupAssignment.put("US", new int[]{0, 1, 3, 3});
        countryGroupAssignment.put("UY", new int[]{2, 1, 2, 2});
        countryGroupAssignment.put("UZ", new int[]{4, 3, 2, 4});
        countryGroupAssignment.put("VA", new int[]{1, 2, 2, 2});
        countryGroupAssignment.put("VC", new int[]{2, 0, 3, 2});
        countryGroupAssignment.put("VE", new int[]{3, 4, 4, 3});
        countryGroupAssignment.put("VG", new int[]{3, 1, 3, 4});
        countryGroupAssignment.put("VI", new int[]{1, 0, 2, 4});
        countryGroupAssignment.put("VN", new int[]{0, 2, 4, 4});
        countryGroupAssignment.put("VU", new int[]{4, 1, 3, 2});
        countryGroupAssignment.put("WS", new int[]{3, 2, 3, 0});
        countryGroupAssignment.put("XK", new int[]{1, 2, 1, 0});
        countryGroupAssignment.put("YE", new int[]{4, 4, 4, 2});
        countryGroupAssignment.put("YT", new int[]{3, 1, 1, 2});
        countryGroupAssignment.put("ZA", new int[]{2, 3, 1, 2});
        countryGroupAssignment.put("ZM", new int[]{3, 3, 3, 1});
        countryGroupAssignment.put("ZW", new int[]{3, 3, 2, 1});
        return Collections.unmodifiableMap(countryGroupAssignment);
    }
}
