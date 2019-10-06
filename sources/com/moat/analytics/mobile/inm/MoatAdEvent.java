package com.moat.analytics.mobile.inm;

import android.support.p001v7.widget.LinearLayoutManager;
import java.util.HashMap;
import java.util.Map;

public class MoatAdEvent {
    public static final Double VOLUME_MUTED = Double.valueOf(0.0d);
    public static final Double VOLUME_UNMUTED = Double.valueOf(1.0d);

    /* renamed from: a */
    static final Integer f33401a = Integer.valueOf(LinearLayoutManager.INVALID_OFFSET);

    /* renamed from: e */
    private static final Double f33402e = Double.valueOf(Double.NaN);

    /* renamed from: b */
    Integer f33403b;

    /* renamed from: c */
    Double f33404c;

    /* renamed from: d */
    MoatAdEventType f33405d;

    /* renamed from: f */
    private final Double f33406f;

    /* renamed from: g */
    private final Long f33407g;

    public MoatAdEvent(MoatAdEventType moatAdEventType) {
        this(moatAdEventType, f33401a, f33402e);
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType, Integer num) {
        this(moatAdEventType, num, f33402e);
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType, Integer num, Double d) {
        this.f33407g = Long.valueOf(System.currentTimeMillis());
        this.f33405d = moatAdEventType;
        this.f33404c = d;
        this.f33403b = num;
        this.f33406f = Double.valueOf(C10972s.m36121a());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Map<String, Object> mo35823a() {
        HashMap hashMap = new HashMap();
        hashMap.put("adVolume", this.f33404c);
        hashMap.put("playhead", this.f33403b);
        hashMap.put("aTimeStamp", this.f33407g);
        hashMap.put("type", this.f33405d.toString());
        hashMap.put("deviceVolume", this.f33406f);
        return hashMap;
    }
}
