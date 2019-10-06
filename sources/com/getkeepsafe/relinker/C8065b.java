package com.getkeepsafe.relinker;

import android.content.Context;
import java.io.File;

/* renamed from: com.getkeepsafe.relinker.b */
/* compiled from: ReLinker */
public class C8065b {

    /* renamed from: com.getkeepsafe.relinker.b$a */
    /* compiled from: ReLinker */
    public interface C8066a {
        /* renamed from: a */
        void mo24878a(Context context, String[] strArr, String str, File file, C8072e eVar);
    }

    /* renamed from: com.getkeepsafe.relinker.b$b */
    /* compiled from: ReLinker */
    public interface C8067b {
        /* renamed from: a */
        void mo24891a(String str);

        /* renamed from: a */
        String[] mo24892a();

        /* renamed from: b */
        String mo24893b(String str);

        /* renamed from: c */
        String mo24894c(String str);

        /* renamed from: d */
        void mo24895d(String str);
    }

    /* renamed from: com.getkeepsafe.relinker.b$c */
    /* compiled from: ReLinker */
    public interface C8068c {
        /* renamed from: a */
        void mo24896a();

        /* renamed from: a */
        void mo24897a(Throwable th);
    }

    /* renamed from: com.getkeepsafe.relinker.b$d */
    /* compiled from: ReLinker */
    public interface C8069d {
        void log(String str);
    }

    /* renamed from: a */
    public static void m18168a(Context context, String library, String version) {
        m18169a(context, library, version, null);
    }

    /* renamed from: a */
    public static void m18169a(Context context, String library, String version, C8068c listener) {
        new C8072e().mo24904a(context, library, version, listener);
    }
}
