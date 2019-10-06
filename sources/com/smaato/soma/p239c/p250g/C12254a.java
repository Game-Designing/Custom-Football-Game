package com.smaato.soma.p239c.p250g;

import com.vungle.warren.model.Advertisement;

/* renamed from: com.smaato.soma.c.g.a */
/* compiled from: AdFormat */
public enum C12254a {
    IMG("img"),
    RICH_MEDIA("richmedia"),
    NATIVE("native"),
    VIDEO(Advertisement.KEY_VIDEO);
    

    /* renamed from: f */
    private final String f38388f;

    private C12254a(String type) {
        this.f38388f = type;
    }

    /* renamed from: e */
    public String mo39630e() {
        return this.f38388f;
    }

    /* renamed from: a */
    public static C12254a m40321a(String format) {
        C12254a[] values;
        if (format == null) {
            return null;
        }
        for (C12254a value : values()) {
            if (format.equalsIgnoreCase(value.mo39630e())) {
                return value;
            }
        }
        return null;
    }
}
