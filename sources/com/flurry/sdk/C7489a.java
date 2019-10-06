package com.flurry.sdk;

import com.flurry.sdk.C7470Wa.C7471a;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

/* renamed from: com.flurry.sdk.a */
public final class C7489a {

    /* renamed from: a */
    private static final String f14737a = C7489a.class.getSimpleName();

    /* renamed from: a */
    public static C7470Wa m16573a(File file) {
        DataInputStream dataInputStream;
        FileInputStream fileInputStream;
        C7470Wa wa = null;
        if (file == null || !file.exists()) {
            return null;
        }
        C7471a aVar = new C7471a();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                dataInputStream = new DataInputStream(fileInputStream);
                try {
                    if (dataInputStream.readUnsignedShort() != 46586) {
                        C7513ec.m16639a(3, f14737a, "Unexpected file type");
                    } else {
                        int readUnsignedShort = dataInputStream.readUnsignedShort();
                        if (readUnsignedShort != 2) {
                            C7513ec.m16639a(6, f14737a, "Unknown agent file version: ".concat(String.valueOf(readUnsignedShort)));
                        } else {
                            C7470Wa wa2 = (C7470Wa) aVar.mo23855a(dataInputStream);
                            C7354Ad.m16261a((Closeable) dataInputStream);
                            C7354Ad.m16261a((Closeable) fileInputStream);
                            wa = wa2;
                            return wa;
                        }
                    }
                    C7354Ad.m16261a((Closeable) dataInputStream);
                    C7354Ad.m16261a((Closeable) fileInputStream);
                    return null;
                } catch (Exception e) {
                    e = e;
                    try {
                        C7513ec.m16640a(3, f14737a, "Error loading legacy agent data.", e);
                        C7354Ad.m16261a((Closeable) dataInputStream);
                        C7354Ad.m16261a((Closeable) fileInputStream);
                        return wa;
                    } catch (Throwable th) {
                        th = th;
                        C7354Ad.m16261a((Closeable) dataInputStream);
                        C7354Ad.m16261a((Closeable) fileInputStream);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                dataInputStream = null;
                C7513ec.m16640a(3, f14737a, "Error loading legacy agent data.", e);
                C7354Ad.m16261a((Closeable) dataInputStream);
                C7354Ad.m16261a((Closeable) fileInputStream);
                return wa;
            } catch (Throwable th2) {
                th = th2;
                dataInputStream = null;
                C7354Ad.m16261a((Closeable) dataInputStream);
                C7354Ad.m16261a((Closeable) fileInputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            dataInputStream = null;
            fileInputStream = null;
            C7513ec.m16640a(3, f14737a, "Error loading legacy agent data.", e);
            C7354Ad.m16261a((Closeable) dataInputStream);
            C7354Ad.m16261a((Closeable) fileInputStream);
            return wa;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            dataInputStream = null;
            C7354Ad.m16261a((Closeable) dataInputStream);
            C7354Ad.m16261a((Closeable) fileInputStream);
            throw th;
        }
    }
}
