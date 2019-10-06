package com.facebook.p127a.p128a.p129a;

import android.util.Log;

/* renamed from: com.facebook.a.a.a.e */
/* compiled from: UnityReflection */
public class C6573e {

    /* renamed from: a */
    private static final String f11920a = C6573e.class.getCanonicalName();

    /* renamed from: b */
    private static Class<?> f11921b;

    /* renamed from: a */
    public static void m13019a(String unityObject, String unityMethod, String message) {
        try {
            if (f11921b == null) {
                f11921b = Class.forName("com.unity3d.player.UnityPlayer");
            }
            f11921b.getMethod("UnitySendMessage", new Class[]{String.class, String.class, String.class}).invoke(f11921b, new Object[]{unityObject, unityMethod, message});
        } catch (Exception e) {
            Log.e(f11920a, "Failed to send message to Unity", e);
        }
    }

    /* renamed from: a */
    public static void m13017a() {
        m13019a("UnityFacebookSDKPlugin", "CaptureViewHierarchy", "");
    }

    /* renamed from: a */
    public static void m13018a(String eventMapping) {
        m13019a("UnityFacebookSDKPlugin", "OnReceiveMapping", eventMapping);
    }
}
