package com.vungle.warren.utility;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipUtility {
    private static final int BUFFER_SIZE = 4096;

    public static void unzip(String zipFilePath, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
        for (ZipEntry entry = zipIn.getNextEntry(); entry != null; entry = zipIn.getNextEntry()) {
            StringBuilder sb = new StringBuilder();
            sb.append(destDirectory);
            sb.append(File.separator);
            sb.append(entry.getName());
            String filePath = sb.toString();
            if (entry.isDirectory()) {
                File dir = new File(filePath);
                if (!dir.exists()) {
                    dir.mkdir();
                }
            } else {
                extractFile(zipIn, filePath);
            }
            zipIn.closeEntry();
        }
        zipIn.close();
    }

    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(filePath));
            byte[] bytesIn = new byte[4096];
            while (true) {
                int read = zipIn.read(bytesIn);
                int read2 = read;
                if (read == -1) {
                    break;
                }
                bos.write(bytesIn, 0, read2);
            }
        } catch (FileNotFoundException e) {
            File dest = new File(filePath);
            if (!dest.getParentFile().exists()) {
                for (File folder = dest.getParentFile(); !folder.mkdir(); folder = folder.getParentFile()) {
                }
                extractFile(zipIn, filePath);
            }
        } catch (Throwable th) {
            FileUtility.closeQuietly(null);
            throw th;
        }
        FileUtility.closeQuietly(bos);
    }
}
