package com.facebook.internal;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* renamed from: com.facebook.internal.Q */
/* compiled from: Utility */
class C6693Q implements FilenameFilter {
    C6693Q() {
    }

    public boolean accept(File dir, String fileName) {
        return Pattern.matches("cpu[0-9]+", fileName);
    }
}
