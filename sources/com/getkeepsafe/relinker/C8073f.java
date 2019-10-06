package com.getkeepsafe.relinker;

import android.os.Build;
import android.os.Build.VERSION;
import com.getkeepsafe.relinker.C8065b.C8067b;

/* renamed from: com.getkeepsafe.relinker.f */
/* compiled from: SystemLibraryLoader */
final class C8073f implements C8067b {
    C8073f() {
    }

    /* renamed from: a */
    public void mo24891a(String libraryName) {
        System.loadLibrary(libraryName);
    }

    /* renamed from: d */
    public void mo24895d(String libraryPath) {
        System.load(libraryPath);
    }

    /* renamed from: b */
    public String mo24893b(String libraryName) {
        if (!libraryName.startsWith("lib") || !libraryName.endsWith(".so")) {
            return System.mapLibraryName(libraryName);
        }
        return libraryName;
    }

    /* renamed from: c */
    public String mo24894c(String mappedLibraryName) {
        return mappedLibraryName.substring(3, mappedLibraryName.length() - 3);
    }

    /* renamed from: a */
    public String[] mo24892a() {
        if (VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr.length > 0) {
                return strArr;
            }
        }
        if (!C8074g.m18192a(Build.CPU_ABI2)) {
            return new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        }
        return new String[]{Build.CPU_ABI};
    }
}
