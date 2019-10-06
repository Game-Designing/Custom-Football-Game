package com.getkeepsafe.relinker;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.getkeepsafe.relinker.d */
/* compiled from: ReLinkerInstance */
class C8071d implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ String f16435a;

    /* renamed from: b */
    final /* synthetic */ C8072e f16436b;

    C8071d(C8072e this$0, String str) {
        this.f16436b = this$0;
        this.f16435a = str;
    }

    public boolean accept(File dir, String filename) {
        return filename.startsWith(this.f16435a);
    }
}
