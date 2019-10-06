package com.inmobi.ads;

/* renamed from: com.inmobi.ads.br */
/* compiled from: Utils */
public final class C10466br {
    /* renamed from: a */
    public static String m34254a(String str) {
        if (str.equalsIgnoreCase("window.mraidview")) {
            return "mraidview";
        }
        if (str.equalsIgnoreCase("window.imraidview")) {
            return "imraidview";
        }
        if (str.equalsIgnoreCase("window.imaiview")) {
            return "imaiview";
        }
        StringBuilder sb = new StringBuilder("NA_ERROR_");
        sb.append(str);
        return sb.toString();
    }
}
