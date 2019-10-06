package com.bumptech.glide.load.engine.p120a;

/* renamed from: com.bumptech.glide.load.engine.a.g */
/* compiled from: ByteArrayAdapter */
public final class C6252g implements C6244a<byte[]> {
    public String getTag() {
        return "ByteArrayPool";
    }

    /* renamed from: a */
    public int mo19124a(byte[] array) {
        return array.length;
    }

    public byte[] newArray(int length) {
        return new byte[length];
    }

    /* renamed from: a */
    public int mo19123a() {
        return 1;
    }
}
