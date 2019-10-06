package p002b.p003c.p004f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.multidex.MultiDexExtractor.ExtractedDex;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.utils.MultiDexHelper;

/* renamed from: b.c.f.c */
/* compiled from: MultiDexExtractor */
final class C0026c {

    /* renamed from: b.c.f.c$a */
    /* compiled from: MultiDexExtractor */
    private static class C0027a extends File {

        /* renamed from: a */
        public long f27a = -1;

        public C0027a(File dexDir, String fileName) {
            super(dexDir, fileName);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x012e A[SYNTHETIC, Splitter:B:47:0x012e] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x014f  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.List<? extends java.io.File> m58a(android.content.Context r20, java.io.File r21, java.io.File r22, java.lang.String r23, boolean r24) throws java.io.IOException {
        /*
            r8 = r23
            r9 = r24
            java.lang.String r10 = "Failed to release lock on "
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "MultiDexExtractor.load("
            r0.append(r1)
            java.lang.String r1 = r21.getPath()
            r0.append(r1)
            java.lang.String r1 = ", "
            r0.append(r1)
            r0.append(r9)
            r0.append(r1)
            r0.append(r8)
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r11 = "MultiDex"
            android.util.Log.i(r11, r0)
            long r12 = m65b(r21)
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "MultiDex.lock"
            r14 = r22
            r0.<init>(r14, r1)
            r15 = r0
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile
            java.lang.String r1 = "rw"
            r0.<init>(r15, r1)
            r16 = r0
            r1 = 0
            r2 = 0
            r17 = 0
            r3 = 0
            java.nio.channels.FileChannel r0 = r16.getChannel()     // Catch:{ all -> 0x0125 }
            r18 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x011e }
            r0.<init>()     // Catch:{ all -> 0x011e }
            java.lang.String r1 = "Blocking on lock "
            r0.append(r1)     // Catch:{ all -> 0x011e }
            java.lang.String r1 = r15.getPath()     // Catch:{ all -> 0x011e }
            r0.append(r1)     // Catch:{ all -> 0x011e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x011e }
            android.util.Log.i(r11, r0)     // Catch:{ all -> 0x011e }
            java.nio.channels.FileLock r0 = r18.lock()     // Catch:{ all -> 0x011e }
            r19 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0119 }
            r0.<init>()     // Catch:{ all -> 0x0119 }
            java.lang.String r1 = r15.getPath()     // Catch:{ all -> 0x0119 }
            r0.append(r1)     // Catch:{ all -> 0x0119 }
            java.lang.String r1 = " locked"
            r0.append(r1)     // Catch:{ all -> 0x0119 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0119 }
            android.util.Log.i(r11, r0)     // Catch:{ all -> 0x0119 }
            if (r9 != 0) goto L_0x00b6
            r5 = r20
            r6 = r21
            boolean r0 = m64a(r5, r6, r12, r8)     // Catch:{ all -> 0x0119 }
            if (r0 != 0) goto L_0x00b6
            java.util.List r0 = m57a(r20, r21, r22, r23)     // Catch:{ IOException -> 0x009d }
            r7 = r0
            goto L_0x00cb
        L_0x009d:
            r0 = move-exception
            r1 = r0
            r0 = r1
            java.lang.String r1 = "Failed to reload existing extracted secondary dex files, falling back to fresh extraction"
            android.util.Log.w(r11, r1, r0)     // Catch:{ all -> 0x0119 }
            java.util.List r7 = m59a(r21, r22)     // Catch:{ all -> 0x0119 }
            long r3 = m55a(r21)     // Catch:{ all -> 0x0116 }
            r1 = r20
            r2 = r23
            r5 = r12
            m60a(r1, r2, r3, r5, r7)     // Catch:{ all -> 0x0116 }
            goto L_0x00cb
        L_0x00b6:
            java.lang.String r0 = "Detected that extraction must be performed."
            android.util.Log.i(r11, r0)     // Catch:{ all -> 0x0119 }
            java.util.List r7 = m59a(r21, r22)     // Catch:{ all -> 0x0119 }
            long r3 = m55a(r21)     // Catch:{ all -> 0x0116 }
            r1 = r20
            r2 = r23
            r5 = r12
            m60a(r1, r2, r3, r5, r7)     // Catch:{ all -> 0x0116 }
        L_0x00cb:
            if (r19 == 0) goto L_0x00ec
            r19.release()     // Catch:{ IOException -> 0x00d1 }
            goto L_0x00ec
        L_0x00d1:
            r0 = move-exception
            r1 = r0
            r0 = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r10)
            java.lang.String r2 = r15.getPath()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r11, r1)
            r17 = r0
        L_0x00ec:
            if (r18 == 0) goto L_0x00f1
            m61a(r18)
        L_0x00f1:
            m61a(r16)
            if (r17 != 0) goto L_0x0115
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "load found "
            r0.append(r1)
            int r1 = r7.size()
            r0.append(r1)
            java.lang.String r1 = " secondary dex files"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.i(r11, r0)
            return r7
        L_0x0115:
            throw r17
        L_0x0116:
            r0 = move-exception
            r1 = r0
            goto L_0x012c
        L_0x0119:
            r0 = move-exception
            r1 = r3
            r7 = r1
            r1 = r0
            goto L_0x012c
        L_0x011e:
            r0 = move-exception
            r1 = r3
            r7 = r1
            r19 = r2
            r1 = r0
            goto L_0x012c
        L_0x0125:
            r0 = move-exception
            r18 = r1
            r19 = r2
            r7 = r3
            r1 = r0
        L_0x012c:
            if (r19 == 0) goto L_0x014d
            r19.release()     // Catch:{ IOException -> 0x0132 }
            goto L_0x014d
        L_0x0132:
            r0 = move-exception
            r2 = r0
            r0 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r10)
            java.lang.String r3 = r15.getPath()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r11, r2)
            r17 = r0
        L_0x014d:
            if (r18 == 0) goto L_0x0152
            m61a(r18)
        L_0x0152:
            m61a(r16)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p002b.p003c.p004f.C0026c.m58a(android.content.Context, java.io.File, java.io.File, java.lang.String, boolean):java.util.List");
    }

    /* renamed from: a */
    private static List<C0027a> m57a(Context context, File sourceApk, File dexDir, String prefsKeyPrefix) throws IOException {
        String str = prefsKeyPrefix;
        Log.i("MultiDex", "loading existing secondary dex files");
        StringBuilder sb = new StringBuilder();
        sb.append(sourceApk.getName());
        sb.append(".classes");
        String extractedFilePrefix = sb.toString();
        SharedPreferences multiDexPreferences = m56a(context);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("dex.number");
        int totalDexNumber = multiDexPreferences.getInt(sb2.toString(), 1);
        List<ExtractedDex> files = new ArrayList<>(totalDexNumber - 1);
        int secondaryNumber = 2;
        while (secondaryNumber <= totalDexNumber) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(extractedFilePrefix);
            sb3.append(secondaryNumber);
            sb3.append(MultiDexHelper.EXTRACTED_SUFFIX);
            String fileName = sb3.toString();
            C0027a extractedFile = new C0027a(dexDir, fileName);
            if (extractedFile.isFile()) {
                extractedFile.f27a = m65b(extractedFile);
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append("dex.crc.");
                sb4.append(secondaryNumber);
                long expectedCrc = multiDexPreferences.getLong(sb4.toString(), -1);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append("dex.time.");
                sb5.append(secondaryNumber);
                long expectedModTime = multiDexPreferences.getLong(sb5.toString(), -1);
                long lastModified = extractedFile.lastModified();
                if (expectedModTime == lastModified) {
                    String extractedFilePrefix2 = extractedFilePrefix;
                    SharedPreferences multiDexPreferences2 = multiDexPreferences;
                    if (expectedCrc == extractedFile.f27a) {
                        files.add(extractedFile);
                        secondaryNumber++;
                        extractedFilePrefix = extractedFilePrefix2;
                        multiDexPreferences = multiDexPreferences2;
                    }
                } else {
                    SharedPreferences sharedPreferences = multiDexPreferences;
                }
                StringBuilder sb6 = new StringBuilder();
                int i = totalDexNumber;
                sb6.append("Invalid extracted dex: ");
                sb6.append(extractedFile);
                sb6.append(" (key \"");
                sb6.append(str);
                sb6.append("\"), expected modification time: ");
                sb6.append(expectedModTime);
                sb6.append(", modification time: ");
                sb6.append(lastModified);
                sb6.append(", expected crc: ");
                sb6.append(expectedCrc);
                sb6.append(", file crc: ");
                int i2 = secondaryNumber;
                String str2 = fileName;
                sb6.append(extractedFile.f27a);
                throw new IOException(sb6.toString());
            }
            SharedPreferences sharedPreferences2 = multiDexPreferences;
            int i3 = totalDexNumber;
            int totalDexNumber2 = secondaryNumber;
            String str3 = fileName;
            StringBuilder sb7 = new StringBuilder();
            sb7.append("Missing extracted secondary dex file '");
            sb7.append(extractedFile.getPath());
            sb7.append("'");
            throw new IOException(sb7.toString());
        }
        File file = dexDir;
        String str4 = extractedFilePrefix;
        SharedPreferences sharedPreferences3 = multiDexPreferences;
        int i4 = totalDexNumber;
        int totalDexNumber3 = secondaryNumber;
        return files;
    }

    /* renamed from: a */
    private static boolean m64a(Context context, File archive, long currentCrc, String prefsKeyPrefix) {
        SharedPreferences prefs = m56a(context);
        StringBuilder sb = new StringBuilder();
        sb.append(prefsKeyPrefix);
        sb.append("timestamp");
        if (prefs.getLong(sb.toString(), -1) == m55a(archive)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(prefsKeyPrefix);
            sb2.append("crc");
            if (prefs.getLong(sb2.toString(), -1) == currentCrc) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static long m55a(File archive) {
        long timeStamp = archive.lastModified();
        if (timeStamp == -1) {
            return timeStamp - 1;
        }
        return timeStamp;
    }

    /* renamed from: b */
    private static long m65b(File archive) throws IOException {
        long computedValue = C0028d.m66a(archive);
        if (computedValue == -1) {
            return computedValue - 1;
        }
        return computedValue;
    }

    /* renamed from: a */
    private static List<C0027a> m59a(File sourceApk, File dexDir) throws IOException {
        Throwable th;
        C0027a extractedFile;
        boolean isExtractionSuccessful;
        File file = dexDir;
        String str = ".dex";
        String str2 = "Failed to close resource";
        String str3 = "classes";
        String str4 = "MultiDex";
        StringBuilder sb = new StringBuilder();
        sb.append(sourceApk.getName());
        sb.append(".classes");
        String extractedFilePrefix = sb.toString();
        m62a(file, extractedFilePrefix);
        List<ExtractedDex> arrayList = new ArrayList<>();
        ZipFile apk = new ZipFile(sourceApk);
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(2);
            sb2.append(str);
            ZipEntry dexFile = apk.getEntry(sb2.toString());
            int secondaryNumber = 2;
            while (dexFile != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(extractedFilePrefix);
                sb3.append(secondaryNumber);
                sb3.append(MultiDexHelper.EXTRACTED_SUFFIX);
                extractedFile = new C0027a(file, sb3.toString());
                arrayList.add(extractedFile);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Extraction is needed for file ");
                sb4.append(extractedFile);
                Log.i(str4, sb4.toString());
                int numAttempts = 0;
                isExtractionSuccessful = false;
                while (numAttempts < 3 && !isExtractionSuccessful) {
                    int numAttempts2 = numAttempts + 1;
                    m63a(apk, dexFile, (File) extractedFile, extractedFilePrefix);
                    extractedFile.f27a = m65b(extractedFile);
                    isExtractionSuccessful = true;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Extraction ");
                    sb5.append(isExtractionSuccessful ? "succeeded" : "failed");
                    sb5.append(" - length ");
                    sb5.append(extractedFile.getAbsolutePath());
                    sb5.append(": ");
                    String extractedFilePrefix2 = extractedFilePrefix;
                    ArrayList arrayList2 = arrayList;
                    try {
                        sb5.append(extractedFile.length());
                        sb5.append(" - crc: ");
                        sb5.append(extractedFile.f27a);
                        Log.i(str4, sb5.toString());
                        if (!isExtractionSuccessful) {
                            extractedFile.delete();
                            if (extractedFile.exists()) {
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("Failed to delete corrupted secondary dex '");
                                sb6.append(extractedFile.getPath());
                                sb6.append("'");
                                Log.w(str4, sb6.toString());
                            }
                        }
                        extractedFilePrefix = extractedFilePrefix2;
                        numAttempts = numAttempts2;
                        arrayList = arrayList2;
                        File file2 = dexDir;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            apk.close();
                        } catch (IOException e) {
                            Log.w(str4, str2, e);
                        }
                        throw th;
                    }
                }
                String extractedFilePrefix3 = extractedFilePrefix;
                ArrayList arrayList3 = arrayList;
                if (isExtractionSuccessful) {
                    secondaryNumber++;
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(str3);
                    sb7.append(secondaryNumber);
                    sb7.append(str);
                    dexFile = apk.getEntry(sb7.toString());
                    extractedFilePrefix = extractedFilePrefix3;
                    arrayList = arrayList3;
                    file = dexDir;
                } else {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("Could not create zip file ");
                    sb8.append(extractedFile.getAbsolutePath());
                    sb8.append(" for secondary dex (");
                    sb8.append(secondaryNumber);
                    sb8.append(")");
                    throw new IOException(sb8.toString());
                }
            }
            String str5 = extractedFilePrefix;
            List<ExtractedDex> files = arrayList;
            try {
                apk.close();
            } catch (IOException e2) {
                Log.w(str4, str2, e2);
            }
            return files;
        } catch (IOException e3) {
            StringBuilder sb9 = new StringBuilder();
            sb9.append("Failed to read crc from ");
            sb9.append(extractedFile.getAbsolutePath());
            Log.w(str4, sb9.toString(), e3);
            isExtractionSuccessful = false;
        } catch (Throwable th3) {
            String str6 = extractedFilePrefix;
            ArrayList arrayList4 = arrayList;
            th = th3;
            apk.close();
            throw th;
        }
    }

    /* renamed from: a */
    private static void m60a(Context context, String keyPrefix, long timeStamp, long crc, List<C0027a> extractedDexes) {
        Editor edit = m56a(context).edit();
        StringBuilder sb = new StringBuilder();
        sb.append(keyPrefix);
        sb.append("timestamp");
        edit.putLong(sb.toString(), timeStamp);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(keyPrefix);
        sb2.append("crc");
        edit.putLong(sb2.toString(), crc);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(keyPrefix);
        sb3.append("dex.number");
        edit.putInt(sb3.toString(), extractedDexes.size() + 1);
        int extractedDexId = 2;
        for (C0027a dex : extractedDexes) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(keyPrefix);
            sb4.append("dex.crc.");
            sb4.append(extractedDexId);
            edit.putLong(sb4.toString(), dex.f27a);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(keyPrefix);
            sb5.append("dex.time.");
            sb5.append(extractedDexId);
            edit.putLong(sb5.toString(), dex.lastModified());
            extractedDexId++;
        }
        edit.commit();
    }

    /* renamed from: a */
    private static SharedPreferences m56a(Context context) {
        return context.getSharedPreferences("multidex.version", VERSION.SDK_INT < 11 ? 0 : 4);
    }

    /* renamed from: a */
    private static void m62a(File dexDir, String extractedFilePrefix) {
        File[] files = dexDir.listFiles(new C0025b(extractedFilePrefix));
        String str = "MultiDex";
        if (files == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to list secondary dex dir content (");
            sb.append(dexDir.getPath());
            sb.append(").");
            Log.w(str, sb.toString());
            return;
        }
        for (File oldFile : files) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Trying to delete old file ");
            sb2.append(oldFile.getPath());
            sb2.append(" of size ");
            sb2.append(oldFile.length());
            Log.i(str, sb2.toString());
            if (!oldFile.delete()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Failed to delete old file ");
                sb3.append(oldFile.getPath());
                Log.w(str, sb3.toString());
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Deleted old file ");
                sb4.append(oldFile.getPath());
                Log.i(str, sb4.toString());
            }
        }
    }

    /* renamed from: a */
    private static void m63a(ZipFile apk, ZipEntry dexFile, File extractTo, String extractedFilePrefix) throws IOException, FileNotFoundException {
        ZipOutputStream out;
        InputStream in = apk.getInputStream(dexFile);
        StringBuilder sb = new StringBuilder();
        sb.append("tmp-");
        sb.append(extractedFilePrefix);
        File tmp = File.createTempFile(sb.toString(), MultiDexHelper.EXTRACTED_SUFFIX, extractTo.getParentFile());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Extracting ");
        sb2.append(tmp.getPath());
        String str = "MultiDex";
        Log.i(str, sb2.toString());
        try {
            out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(tmp)));
            ZipEntry classesDex = new ZipEntry("classes.dex");
            classesDex.setTime(dexFile.getTime());
            out.putNextEntry(classesDex);
            byte[] buffer = new byte[Opcodes.ACC_ENUM];
            for (int length = in.read(buffer); length != -1; length = in.read(buffer)) {
                out.write(buffer, 0, length);
            }
            out.closeEntry();
            out.close();
            if (tmp.setReadOnly()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Renaming to ");
                sb3.append(extractTo.getPath());
                Log.i(str, sb3.toString());
                if (tmp.renameTo(extractTo)) {
                    m61a((Closeable) in);
                    tmp.delete();
                    return;
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Failed to rename \"");
                sb4.append(tmp.getAbsolutePath());
                sb4.append("\" to \"");
                sb4.append(extractTo.getAbsolutePath());
                sb4.append("\"");
                throw new IOException(sb4.toString());
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Failed to mark readonly \"");
            sb5.append(tmp.getAbsolutePath());
            sb5.append("\" (tmp of \"");
            sb5.append(extractTo.getAbsolutePath());
            sb5.append("\")");
            throw new IOException(sb5.toString());
        } catch (Throwable th) {
            m61a((Closeable) in);
            tmp.delete();
            throw th;
        }
    }

    /* renamed from: a */
    private static void m61a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w("MultiDex", "Failed to close resource", e);
        }
    }
}
