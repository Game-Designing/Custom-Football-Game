package com.smaato.soma.p239c.p241b;

/* renamed from: com.smaato.soma.c.b.u */
/* compiled from: MraidOrientation */
enum C12181u {
    NONE("none", -1),
    PORTRAIT("portrait", 1),
    LANDSCAPE("landscape", 0);
    

    /* renamed from: e */
    private final String f38192e;

    /* renamed from: f */
    private final int f38193f;

    private C12181u(String screenOrientation, int screenOrientationValue) {
        this.f38192e = screenOrientation;
        this.f38193f = screenOrientationValue;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public int mo39460e() {
        return this.f38193f;
    }

    /* renamed from: a */
    static C12181u m40081a(String screenOrientation) {
        for (C12181u value : values()) {
            if (value.f38192e.equalsIgnoreCase(screenOrientation)) {
                return value;
            }
        }
        return NONE;
    }
}
