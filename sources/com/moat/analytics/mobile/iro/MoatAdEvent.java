package com.moat.analytics.mobile.iro;

import android.support.p001v7.widget.LinearLayoutManager;
import java.util.HashMap;
import java.util.Map;

public class MoatAdEvent {
    public static final Double VOLUME_MUTED = Double.valueOf(0.0d);
    public static final Double VOLUME_UNMUTED = Double.valueOf(1.0d);

    /* renamed from: ˋ */
    private static final Double f33618 = Double.valueOf(Double.NaN);

    /* renamed from: ˏ */
    static final Integer f33619 = Integer.valueOf(LinearLayoutManager.INVALID_OFFSET);

    /* renamed from: ʼ */
    private final Long f33620;

    /* renamed from: ʽ */
    private final Double f33621;

    /* renamed from: ˊ */
    Integer f33622;

    /* renamed from: ˎ */
    Double f33623;

    /* renamed from: ॱ */
    MoatAdEventType f33624;

    public MoatAdEvent(MoatAdEventType moatAdEventType, Integer num, Double d) {
        this.f33620 = Long.valueOf(System.currentTimeMillis());
        this.f33624 = moatAdEventType;
        this.f33623 = d;
        this.f33622 = num;
        this.f33621 = Double.valueOf(C11044p.m36362());
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType, Integer num) {
        this(moatAdEventType, num, f33618);
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType) {
        this(moatAdEventType, f33619, f33618);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱ */
    public final Map<String, Object> mo35986() {
        HashMap hashMap = new HashMap();
        hashMap.put("adVolume", this.f33623);
        hashMap.put("playhead", this.f33622);
        hashMap.put("aTimeStamp", this.f33620);
        hashMap.put("type", this.f33624.toString());
        hashMap.put("deviceVolume", this.f33621);
        return hashMap;
    }
}
