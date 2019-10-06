package com.paypal.android.sdk;

import java.io.ByteArrayInputStream;
import java.util.Properties;

/* renamed from: com.paypal.android.sdk.s */
public final class C12002s {
    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public static String m39704a(String str) {
        Properties properties = new Properties();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("suFileName=/system/xbin/su\nsuperUserApk=/system/app/Superuser.apk\nemptyIp=0.0.0.0".getBytes());
        try {
            properties.load(byteArrayInputStream);
            byteArrayInputStream.close();
            return properties.getProperty(str);
        } catch (Throwable th) {
            byteArrayInputStream.close();
            throw th;
        }
    }
}
