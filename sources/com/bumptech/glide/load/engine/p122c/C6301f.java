package com.bumptech.glide.load.engine.p122c;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* renamed from: com.bumptech.glide.load.engine.c.f */
/* compiled from: RuntimeCompat */
class C6301f implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ Pattern f11153a;

    C6301f(Pattern pattern) {
        this.f11153a = pattern;
    }

    public boolean accept(File file, String s) {
        return this.f11153a.matcher(s).matches();
    }
}
