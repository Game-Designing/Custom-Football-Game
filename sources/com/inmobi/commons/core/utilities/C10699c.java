package com.inmobi.commons.core.utilities;

import android.net.Uri;
import java.io.File;

/* renamed from: com.inmobi.commons.core.utilities.c */
/* compiled from: FileUtils */
public class C10699c {

    /* renamed from: a */
    private static final String f32655a = C10699c.class.getSimpleName();

    /* renamed from: a */
    public static void m35140a(File file) {
        try {
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            m35140a(file2);
                        } else {
                            file2.delete();
                        }
                    }
                }
                file.delete();
            }
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in deleting directory; ").append(e.getMessage());
        }
    }

    /* renamed from: a */
    public static long m35139a(String str) {
        try {
            File file = new File(Uri.parse(str).getPath());
            if (file.exists()) {
                return file.length();
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }
}
