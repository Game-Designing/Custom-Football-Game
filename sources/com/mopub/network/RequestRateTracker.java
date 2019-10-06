package com.mopub.network;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RequestRateTracker {

    /* renamed from: a */
    private Map<String, TimeRecord> f36381a = Collections.synchronizedMap(new HashMap());

    public static class TimeRecord {

        /* renamed from: a */
        final long f36382a = RequestRateTracker.m38556b();
        public final int mBlockIntervalMs;
        public final String mReason;

        TimeRecord(int interval, String reason) {
            this.mBlockIntervalMs = interval;
            this.mReason = reason == null ? "unknown" : reason;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public long mo38326a() {
            return this.f36382a + ((long) this.mBlockIntervalMs);
        }
    }

    /* renamed from: com.mopub.network.RequestRateTracker$a */
    private static class C11666a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static RequestRateTracker f36383a = new RequestRateTracker();
    }

    RequestRateTracker() {
    }

    public static RequestRateTracker getInstance() {
        return C11666a.f36383a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo38323a(String adUnit, Integer blockIntervalMs, String reason) {
        if (!TextUtils.isEmpty(adUnit)) {
            if (blockIntervalMs == null || blockIntervalMs.intValue() <= 0) {
                this.f36381a.remove(adUnit);
            } else {
                this.f36381a.put(adUnit, new TimeRecord(blockIntervalMs.intValue(), reason));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo38324a(String adUnitId) {
        return m38557b(adUnitId) > 0;
    }

    public TimeRecord getRecordForAdUnit(String adUnitId) {
        return (TimeRecord) this.f36381a.get(adUnitId);
    }

    /* renamed from: b */
    private long m38557b(String adUnitId) {
        TimeRecord record = (TimeRecord) this.f36381a.get(adUnitId);
        if (record == null) {
            return 0;
        }
        return record.mo38326a() - m38556b();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static long m38556b() {
        return SystemClock.elapsedRealtime();
    }
}
