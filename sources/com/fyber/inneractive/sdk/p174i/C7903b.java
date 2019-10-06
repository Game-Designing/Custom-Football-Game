package com.fyber.inneractive.sdk.p174i;

/* renamed from: com.fyber.inneractive.sdk.i.b */
public enum C7903b {
    RETURNED_ADTYPE_HTML(4),
    RETURNED_ADTYPE_MRAID(6),
    RETURNED_ADTYPE_VAST(8),
    RETURNED_ADTYPE_HTML5_VIDEO(9),
    RETURNED_ADTYPE_NATIVE(10),
    RETURNED_ADTYPE_PMN(13);
    

    /* renamed from: g */
    private int f16015g;

    private C7903b(int i) {
        this.f16015g = i;
    }

    /* renamed from: a */
    public static C7903b m17817a(int i) {
        C7903b[] values;
        for (C7903b bVar : values()) {
            if (bVar.f16015g == i) {
                return bVar;
            }
        }
        return null;
    }
}
