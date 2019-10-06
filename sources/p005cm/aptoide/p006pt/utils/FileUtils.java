package p005cm.aptoide.p006pt.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.logger.Logger;
import p026rx.C0120S;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.utils.FileUtils */
public class FileUtils {
    public static final String COPY = "Copy";
    public static final String MOVE = "Move";
    private static final String TAG = FileUtils.class.getSimpleName();
    private C0129b<String> sendFileMoveEvent;

    public static boolean removeFile(String filePAth) {
        if (!TextUtils.isEmpty(filePAth)) {
            return new File(filePAth).delete();
        }
        return false;
    }

    public static void createDir(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public static boolean saveBitmapToFile(File dir, String fileName, Bitmap bm, CompressFormat format, int quality) {
        File imageFile = new File(dir, fileName);
        FileOutputStream fos = null;
        try {
            dir.mkdirs();
            fos = new FileOutputStream(imageFile);
            bm.compress(format, quality, fos);
            fos.close();
            return true;
        } catch (IOException e) {
            Logger.getInstance().mo2140e(TAG, e.getMessage());
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    Logger.getInstance().mo2140e(TAG, e1.getMessage());
                }
            }
            return false;
        }
    }

    public static boolean fileExists(String path) {
        return !TextUtils.isEmpty(path) && new File(path).exists();
    }

    public long deleteDir(File dir) {
        if (dir != null) {
            long size = 0;
            if (dir.isDirectory()) {
                for (File child : dir.listFiles() == null ? new File[0] : dir.listFiles()) {
                    size += deleteDir(child);
                }
            }
            long size2 = size + dir.length();
            if (!dir.exists() || dir.delete()) {
                return size2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Something went wrong while deleting the file ");
            sb.append(dir.getPath());
            sb.append(" (if the is the file a directory, is it empty?");
            throw new RuntimeException(sb.toString());
        }
        throw new RuntimeException("The file to be deleted can't be null");
    }

    public long dirSize(File dir) {
        long j;
        long result = 0;
        if (dir.exists()) {
            File[] fileList = dir.listFiles();
            if (fileList != null) {
                for (int i = 0; i < fileList.length; i++) {
                    if (fileList[i].isDirectory()) {
                        j = dirSize(fileList[i]);
                    } else {
                        j = fileList[i].length();
                    }
                    result += j;
                }
            }
        }
        return result;
    }

    public void copyFile(String inputPath, String outputPath, String fileName) {
        if (!inputPath.equals(outputPath)) {
            StringBuilder sb = new StringBuilder();
            sb.append(inputPath);
            sb.append(fileName);
            if (fileExists(sb.toString())) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(inputPath);
                sb2.append(fileName);
                File file = new File(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(outputPath);
                sb3.append(fileName);
                if (!file.renameTo(new File(sb3.toString()))) {
                    cloneFile(inputPath, outputPath, fileName);
                    return;
                }
                return;
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Input file(");
            sb4.append(inputPath);
            sb4.append(fileName);
            sb4.append(") doesn't exists");
            throw new RuntimeException(sb4.toString());
        }
    }

    public void cloneFile(String inputPath, String outputPath, String fileName) {
        String str = "/";
        try {
            File dir = new File(outputPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(inputPath);
            sb.append(str);
            sb.append(fileName);
            FileInputStream fileInputStream = new FileInputStream(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(outputPath);
            sb2.append(str);
            sb2.append(fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(sb2.toString());
            byte[] buffer = new byte[Opcodes.ACC_ABSTRACT];
            while (true) {
                int read = fileInputStream.read(buffer);
                int read2 = read;
                if (read != -1) {
                    fileOutputStream.write(buffer, 0, read2);
                } else {
                    fileInputStream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(inputPath);
                    sb3.append(fileName);
                    new File(sb3.toString()).delete();
                    return;
                }
            }
        } catch (Exception e) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(inputPath);
            sb4.append(str);
            sb4.append(fileName);
            File inputFile = new File(sb4.toString());
            if (inputFile.exists()) {
                inputFile.delete();
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(outputPath);
            sb5.append(str);
            sb5.append(fileName);
            File outputFile = new File(sb5.toString());
            if (outputFile.exists()) {
                outputFile.delete();
            }
            Logger.getInstance().mo2140e(TAG, e.getMessage());
            throw new RuntimeException(e);
        } catch (Throwable th) {
            throw th;
        }
    }

    public C0120S<Long> deleteFolder(File... folders) {
        return C0120S.m644a((T[]) folders).mo3616a(Schedulers.m776io()).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C5192h<Object,Object>(this)).mo3675m().mo3669j(C5191g.f8950a);
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo2393a(File filePath) {
        return C0120S.m633a((Callable<? extends T>) new C5193i<Object>(this, filePath)).mo3671k(C5194j.f8954a);
    }

    /* renamed from: b */
    public /* synthetic */ Long mo2394b(File filePath) throws Exception {
        long size = deleteDir(filePath);
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("deleting folder ");
        sb.append(filePath.getPath());
        sb.append(" size: ");
        sb.append(size);
        instance.mo2136d(str, sb.toString());
        return Long.valueOf(size);
    }

    /* renamed from: a */
    static /* synthetic */ Long m531a(List deletedSizes) {
        long size = 0;
        for (int i = 0; i < deletedSizes.size(); i++) {
            size += ((Long) deletedSizes.get(i)).longValue();
        }
        return Long.valueOf(size);
    }

    public C0120S<Long> deleteFolder(String... folders) {
        File[] files = new File[folders.length];
        for (int i = 0; i < folders.length; i++) {
            files[i] = new File(folders[i]);
        }
        return deleteFolder(files);
    }
}
