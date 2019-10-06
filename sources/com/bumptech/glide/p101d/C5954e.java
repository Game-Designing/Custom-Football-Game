package com.bumptech.glide.p101d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.bumptech.glide.module.GlideModule;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* renamed from: com.bumptech.glide.d.e */
/* compiled from: ManifestParser */
public final class C5954e {

    /* renamed from: a */
    private final Context f10494a;

    public C5954e(Context context) {
        this.f10494a = context;
    }

    /* renamed from: a */
    public List<C5952c> mo18646a() {
        String str = "ManifestParser";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "Loading Glide modules");
        }
        List<GlideModule> modules = new ArrayList<>();
        try {
            ApplicationInfo appInfo = this.f10494a.getPackageManager().getApplicationInfo(this.f10494a.getPackageName(), 128);
            if (appInfo.metaData == null) {
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Got null app info metadata");
                }
                return modules;
            }
            if (Log.isLoggable(str, 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Got app info metadata: ");
                sb.append(appInfo.metaData);
                Log.v(str, sb.toString());
            }
            for (String key : appInfo.metaData.keySet()) {
                if ("GlideModule".equals(appInfo.metaData.get(key))) {
                    modules.add(m11004a(key));
                    if (Log.isLoggable(str, 3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Loaded Glide module: ");
                        sb2.append(key);
                        Log.d(str, sb2.toString());
                    }
                }
            }
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Finished loading Glide modules");
            }
            return modules;
        } catch (NameNotFoundException e) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
        }
    }

    /* renamed from: a */
    private static C5952c m11004a(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            try {
                Object module = clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (module instanceof C5952c) {
                    return (C5952c) module;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Expected instanceof GlideModule, but found: ");
                sb.append(module);
                throw new RuntimeException(sb.toString());
            } catch (InstantiationException e) {
                m11005a(clazz, e);
                throw null;
            } catch (IllegalAccessException e2) {
                m11005a(clazz, e2);
                throw null;
            } catch (NoSuchMethodException e3) {
                m11005a(clazz, e3);
                throw null;
            } catch (InvocationTargetException e4) {
                m11005a(clazz, e4);
                throw null;
            }
        } catch (ClassNotFoundException e5) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e5);
        }
    }

    /* renamed from: a */
    private static void m11005a(Class<?> clazz, Exception e) {
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to instantiate GlideModule implementation for ");
        sb.append(clazz);
        throw new RuntimeException(sb.toString(), e);
    }
}
