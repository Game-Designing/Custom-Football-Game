package com.moat.analytics.mobile.vng;

import android.support.p001v7.widget.LinearLayoutManager;
import java.util.HashMap;
import java.util.Map;

public class MoatAdEvent {
    public static final Double VOLUME_MUTED = Double.valueOf(0.0d);
    public static final Double VOLUME_UNMUTED = Double.valueOf(1.0d);

    /* renamed from: a */
    static final Integer f34022a = Integer.valueOf(LinearLayoutManager.INVALID_OFFSET);

    /* renamed from: e */
    private static final Double f34023e = Double.valueOf(Double.NaN);

    /* renamed from: b */
    Integer f34024b;

    /* renamed from: c */
    Double f34025c;

    /* renamed from: d */
    MoatAdEventType f34026d;

    /* renamed from: f */
    private final Long f34027f;

    public MoatAdEvent(MoatAdEventType moatAdEventType) {
        this(moatAdEventType, f34022a, f34023e);
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType, Integer num) {
        this(moatAdEventType, num, f34023e);
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType, Integer num, Double d) {
        this.f34027f = Long.valueOf(System.currentTimeMillis());
        this.f34026d = moatAdEventType;
        this.f34025c = d;
        this.f34024b = num;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Map<String, Object> mo36264a() {
        HashMap hashMap = new HashMap();
        hashMap.put("adVolume", this.f34025c);
        hashMap.put("playhead", this.f34024b);
        hashMap.put("aTimeStamp", this.f34027f);
        hashMap.put("type", this.f34026d.toString());
        return hashMap;
    }
}
