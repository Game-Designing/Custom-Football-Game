package com.flurry.sdk;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.flurry.sdk.db */
class C7507db implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ C7517fb f14797a;

    C7507db(C7517fb fbVar) {
        this.f14797a = fbVar;
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(".flurryagent.");
    }
}
