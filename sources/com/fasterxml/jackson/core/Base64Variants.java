package com.fasterxml.jackson.core;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

public final class Base64Variants {
    public static final Base64Variant MIME;
    public static final Base64Variant MIME_NO_LINEFEEDS = new Base64Variant(MIME, "MIME-NO-LINEFEEDS", MoPubClientPositioning.NO_REPEAT);
    public static final Base64Variant MODIFIED_FOR_URL;
    public static final Base64Variant PEM;

    static {
        Base64Variant base64Variant = new Base64Variant("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        MIME = base64Variant;
        Base64Variant base64Variant2 = new Base64Variant(MIME, "PEM", true, '=', 64);
        PEM = base64Variant2;
        StringBuilder sb = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        sb.setCharAt(sb.indexOf("+"), '-');
        sb.setCharAt(sb.indexOf("/"), '_');
        Base64Variant base64Variant3 = new Base64Variant("MODIFIED-FOR-URL", sb.toString(), false, 0, (int) MoPubClientPositioning.NO_REPEAT);
        MODIFIED_FOR_URL = base64Variant3;
    }

    public static Base64Variant getDefaultVariant() {
        return MIME_NO_LINEFEEDS;
    }

    public static Base64Variant valueOf(String name) throws IllegalArgumentException {
        String name2;
        if (MIME._name.equals(name)) {
            return MIME;
        }
        if (MIME_NO_LINEFEEDS._name.equals(name)) {
            return MIME_NO_LINEFEEDS;
        }
        if (PEM._name.equals(name)) {
            return PEM;
        }
        if (MODIFIED_FOR_URL._name.equals(name)) {
            return MODIFIED_FOR_URL;
        }
        if (name == null) {
            name2 = "<null>";
        } else {
            StringBuilder sb = new StringBuilder();
            String str = "'";
            sb.append(str);
            sb.append(name);
            sb.append(str);
            name2 = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("No Base64Variant with name ");
        sb2.append(name2);
        throw new IllegalArgumentException(sb2.toString());
    }
}
