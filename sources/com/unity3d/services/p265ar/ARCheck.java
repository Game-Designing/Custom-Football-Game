package com.unity3d.services.p265ar;

/* renamed from: com.unity3d.services.ar.ARCheck */
public class ARCheck {
    public static boolean isFrameworkPresent() {
        try {
            Class cls = Class.forName("com.google.ar.core.Session");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
