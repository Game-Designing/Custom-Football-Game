package com.mopub.volley.toolbox;

import java.util.Comparator;

/* renamed from: com.mopub.volley.toolbox.a */
/* compiled from: ByteArrayPool */
class C11694a implements Comparator<byte[]> {
    C11694a() {
    }

    public int compare(byte[] lhs, byte[] rhs) {
        return lhs.length - rhs.length;
    }
}
