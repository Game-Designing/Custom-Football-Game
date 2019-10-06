package com.crashlytics.android.p126c;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

/* renamed from: com.crashlytics.android.c.Ta */
/* compiled from: Utils */
final class C6451Ta {

    /* renamed from: a */
    private static final FilenameFilter f11563a = new C6449Sa();

    /* renamed from: a */
    static int m12507a(File directory, int maxAllowed, Comparator<File> sortComparator) {
        return m12508a(directory, f11563a, maxAllowed, sortComparator);
    }

    /* renamed from: a */
    static int m12508a(File directory, FilenameFilter filter, int maxAllowed, Comparator<File> sortComparator) {
        File[] sessionFiles = directory.listFiles(filter);
        if (sessionFiles == null) {
            return 0;
        }
        int numRetained = sessionFiles.length;
        Arrays.sort(sessionFiles, sortComparator);
        for (File file : sessionFiles) {
            if (numRetained <= maxAllowed) {
                return numRetained;
            }
            file.delete();
            numRetained--;
        }
        return numRetained;
    }
}
