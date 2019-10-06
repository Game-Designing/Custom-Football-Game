package com.fyber.inneractive.sdk.p174i;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.fyber.inneractive.sdk.i.o */
public final class C7915o {

    /* renamed from: c */
    private static final Map<String, C7916a> f16078c = new HashMap();

    /* renamed from: a */
    C7916a f16079a;

    /* renamed from: b */
    String f16080b;

    /* renamed from: com.fyber.inneractive.sdk.i.o$a */
    public enum C7916a {
        EVENT_FINAL_RETURN("finalReturn"),
        EVENT_IMPRESSION("impression"),
        EVENT_START("start"),
        EVENT_FIRSTQ("firstQuartile"),
        EVENT_MID("midpoint"),
        EVENT_THIRDQ("thirdQuartile"),
        EVENT_COMPLETE("complete"),
        EVENT_MUTE("mute"),
        EVENT_UNMUTE("unmute"),
        EVENT_PAUSE("pause"),
        EVENT_RESUME("resume"),
        EVENT_FULLSCREEN("fullscreen"),
        EVENT_EXIT_FULLSCREEN("exitFullscreen"),
        EVENT_CREATIVE_VIEW("creativeView"),
        EVENT_CLICK("click"),
        EVENT_ERROR("error"),
        EVENT_REWIND("rewind"),
        EVENT_CLOSE("close"),
        EVENT_EXPAND("expand"),
        EVENT_COLLAPSE("collapse"),
        EVENT_CLOSE_LINEAR("closeLinear"),
        UNKNOWN("UnkownEvent");
        

        /* renamed from: w */
        public final String f16104w;

        private C7916a(String str) {
            this.f16104w = str;
        }
    }

    C7915o(String str, String str2) {
        this.f16079a = f16078c.get(str) != null ? (C7916a) f16078c.get(str) : C7916a.UNKNOWN;
        this.f16080b = str2;
    }

    static {
        C7916a[] values;
        for (C7916a aVar : C7916a.values()) {
            f16078c.put(aVar.f16104w, aVar);
        }
    }
}
