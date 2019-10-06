package com.moat.analytics.mobile.sma;

import android.support.p001v7.widget.LinearLayoutManager;
import java.util.HashMap;
import java.util.Map;

public class MoatAdEvent {
    public static final Double VOLUME_MUTED = Double.valueOf(0.0d);
    public static final Double VOLUME_UNMUTED = Double.valueOf(1.0d);

    /* renamed from: a */
    static final Integer f33837a = Integer.valueOf(LinearLayoutManager.INVALID_OFFSET);

    /* renamed from: f */
    private static final Double f33838f = Double.valueOf(Double.NaN);

    /* renamed from: b */
    Integer f33839b;

    /* renamed from: c */
    Double f33840c;

    /* renamed from: d */
    Double f33841d;

    /* renamed from: e */
    MoatAdEventType f33842e;

    /* renamed from: g */
    private final Long f33843g;

    public MoatAdEvent(MoatAdEventType moatAdEventType) {
        this(moatAdEventType, f33837a, f33838f);
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType, Integer num) {
        this(moatAdEventType, num, f33838f);
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType, Integer num, Double d) {
        this.f33843g = Long.valueOf(System.currentTimeMillis());
        this.f33842e = moatAdEventType;
        this.f33840c = d;
        this.f33839b = num;
        this.f33841d = Double.valueOf(C11113s.m36583a());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Map<String, Object> mo36134a() {
        HashMap hashMap = new HashMap();
        hashMap.put("adVolume", this.f33840c);
        hashMap.put("playhead", this.f33839b);
        hashMap.put("aTimeStamp", this.f33843g);
        hashMap.put("type", this.f33842e.toString());
        hashMap.put("deviceVolume", this.f33841d);
        return hashMap;
    }
}
