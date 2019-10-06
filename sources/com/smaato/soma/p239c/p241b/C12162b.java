package com.smaato.soma.p239c.p241b;

/* renamed from: com.smaato.soma.c.b.b */
/* compiled from: CustomClosePosition */
enum C12162b {
    TOP_LEFT("top-left", 51),
    TOP_RIGHT("top-right", 53),
    TOP_CENTER("top-center", 49),
    CENTER("center", 17),
    BOTTOM_LEFT("bottom-left", 83),
    BOTTOM_RIGHT("bottom-right", 85),
    BOTTOM_CENTER("bottom-center", 81);
    

    /* renamed from: i */
    private final String f38136i;

    /* renamed from: j */
    private final int f38137j;

    private C12162b(String customClosePosition, int customCloseGravity) {
        this.f38136i = customClosePosition;
        this.f38137j = customCloseGravity;
    }

    /* renamed from: a */
    static C12162b m39999a(String customClosePosition) {
        for (C12162b value : values()) {
            if (value.f38136i.equalsIgnoreCase(customClosePosition)) {
                return value;
            }
        }
        return TOP_RIGHT;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public int mo39407e() {
        return this.f38137j;
    }
}
