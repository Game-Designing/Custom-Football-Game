package p024io.realm.internal;

import io.realm.RealmModel;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import p024io.realm.C0105Y;
import p024io.realm.C0106Z;
import p024io.realm.log.RealmLog;

/* renamed from: io.realm.internal.Util */
public class Util {
    static native String nativeGetTablePrefix();

    /* renamed from: a */
    public static String m16051a() {
        return nativeGetTablePrefix();
    }

    /* renamed from: a */
    public static Class<? extends C0105Y> m16050a(Class<? extends C0105Y> clazz) {
        Class<? extends RealmModel> superclass = clazz.getSuperclass();
        if (superclass.equals(Object.class) || superclass.equals(C0106Z.class)) {
            return clazz;
        }
        return superclass;
    }

    /* renamed from: a */
    public static boolean m16052a(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m16053a(String canonicalPath, File realmFolder, String realmFileName) {
        boolean realmDeleted = true;
        String str = ".management";
        StringBuilder sb = new StringBuilder();
        sb.append(realmFileName);
        sb.append(".management");
        File managementFolder = new File(realmFolder, sb.toString());
        File[] files = managementFolder.listFiles();
        if (files != null) {
            boolean realmDeleted2 = true;
            for (File file : files) {
                realmDeleted2 = realmDeleted2 && file.delete();
            }
            realmDeleted = realmDeleted2;
        }
        if (!(realmDeleted && managementFolder.delete()) || !m16054b(canonicalPath, realmFolder, realmFileName)) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private static boolean m16054b(String canonicalPath, File rootFolder, String realmFileName) {
        AtomicBoolean realmDeleted = new AtomicBoolean(true);
        StringBuilder sb = new StringBuilder();
        sb.append(realmFileName);
        sb.append(".lock");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(realmFileName);
        sb2.append(".log_a");
        StringBuilder sb3 = new StringBuilder();
        sb3.append(realmFileName);
        sb3.append(".log_b");
        StringBuilder sb4 = new StringBuilder();
        sb4.append(realmFileName);
        sb4.append(".log");
        for (File fileToDelete : Arrays.asList(new File[]{new File(rootFolder, realmFileName), new File(rootFolder, sb.toString()), new File(rootFolder, sb2.toString()), new File(rootFolder, sb3.toString()), new File(rootFolder, sb4.toString()), new File(canonicalPath)})) {
            if (fileToDelete.exists() && !fileToDelete.delete()) {
                realmDeleted.set(false);
                RealmLog.m16238c("Could not delete the file %s", fileToDelete);
            }
        }
        return realmDeleted.get();
    }
}
