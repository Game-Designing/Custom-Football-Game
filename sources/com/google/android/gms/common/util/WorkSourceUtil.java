package com.google.android.gms.common.util;

import android.annotation.SuppressLint;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.lang.reflect.Method;

@KeepForSdk
public class WorkSourceUtil {

    /* renamed from: a */
    private static final int f20307a = Process.myUid();

    /* renamed from: b */
    private static final Method f20308b = m22126e();

    /* renamed from: c */
    private static final Method f20309c = m22127f();

    /* renamed from: d */
    private static final Method f20310d = m22128g();

    /* renamed from: e */
    private static final Method f20311e = m22122a();

    /* renamed from: f */
    private static final Method f20312f = m22123b();

    /* renamed from: g */
    private static final Method f20313g = m22124c();

    /* renamed from: h */
    private static final Method f20314h = m22125d();

    private WorkSourceUtil() {
    }

    /* renamed from: e */
    private static Method m22126e() {
        try {
            return WorkSource.class.getMethod("add", new Class[]{Integer.TYPE});
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: f */
    private static Method m22127f() {
        if (PlatformVersion.m22111e()) {
            try {
                return WorkSource.class.getMethod("add", new Class[]{Integer.TYPE, String.class});
            } catch (Exception e) {
            }
        }
        return null;
    }

    /* renamed from: g */
    private static Method m22128g() {
        try {
            return WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    private static Method m22122a() {
        try {
            return WorkSource.class.getMethod("get", new Class[]{Integer.TYPE});
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: b */
    private static Method m22123b() {
        if (PlatformVersion.m22111e()) {
            try {
                return WorkSource.class.getMethod("getName", new Class[]{Integer.TYPE});
            } catch (Exception e) {
            }
        }
        return null;
    }

    /* renamed from: c */
    private static final Method m22124c() {
        if (PlatformVersion.m22118l()) {
            try {
                return WorkSource.class.getMethod("createWorkChain", new Class[0]);
            } catch (Exception e) {
                Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e);
            }
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    /* renamed from: d */
    private static final Method m22125d() {
        if (PlatformVersion.m22118l()) {
            try {
                return Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", new Class[]{Integer.TYPE, String.class});
            } catch (Exception e) {
                Log.w("WorkSourceUtil", "Missing WorkChain class", e);
            }
        }
        return null;
    }
}
