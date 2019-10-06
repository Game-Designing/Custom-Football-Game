package com.bumptech.glide.load;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.g */
/* compiled from: Key */
public interface C6344g {

    /* renamed from: a */
    public static final Charset f11318a = Charset.forName("UTF-8");

    boolean equals(Object obj);

    int hashCode();

    void updateDiskCacheKey(MessageDigest messageDigest);
}
