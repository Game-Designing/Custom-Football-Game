package com.flurry.sdk;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* renamed from: com.flurry.sdk.yd */
class C7629yd implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ Pattern f15143a;

    C7629yd(Pattern pattern) {
        this.f15143a = pattern;
    }

    public final boolean accept(File file, String str) {
        return this.f15143a.matcher(str).matches();
    }
}
