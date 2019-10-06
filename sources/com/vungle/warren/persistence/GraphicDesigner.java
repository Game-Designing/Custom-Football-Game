package com.vungle.warren.persistence;

import android.util.Log;
import com.vungle.warren.utility.FileUtility;
import java.io.File;
import java.io.IOException;

public class GraphicDesigner implements Designer {
    private static final String FOLDER_NAME = "vungle";
    private static final String TAG = GraphicDesigner.class.getSimpleName();
    private File cacheDir;

    public GraphicDesigner(File cacheDir2) {
        this.cacheDir = cacheDir2;
        FileUtility.printDirectoryTree(getCacheDirectory());
    }

    public boolean hasAssetsFor(String identifier, int numOfAllDownloadedFiles) throws IllegalStateException {
        File[] files = getCacheDirectory().listFiles();
        boolean z = false;
        if (files == null) {
            return false;
        }
        int length = files.length;
        int i = 0;
        while (i < length) {
            File f = files[i];
            if (!f.isDirectory() || !f.getName().equals(identifier)) {
                i++;
            } else {
                if (f.list().length >= numOfAllDownloadedFiles) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }

    public File getAssetDirectory(String identifier) throws IllegalStateException {
        StringBuilder sb = new StringBuilder();
        sb.append(getCacheDirectory().getPath());
        sb.append(File.separator);
        sb.append(identifier);
        File assetDir = new File(sb.toString());
        if (!assetDir.exists()) {
            assetDir.mkdir();
        }
        return assetDir;
    }

    public void deleteAssets(String identifier) throws IOException, IllegalStateException {
        File[] files = getCacheDirectory().listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory() && f.getName().equals(identifier)) {
                    FileUtility.delete(f);
                }
            }
        }
    }

    public File getCacheDirectory() throws IllegalStateException {
        if (this.cacheDir != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.cacheDir.getPath());
            sb.append(File.separator);
            sb.append("vungle");
            File dir = new File(sb.toString());
            if (!dir.exists()) {
                dir.mkdir();
            }
            return dir;
        }
        throw new IllegalStateException("Context has expired, cannot continue.");
    }

    public void clearCache() {
        if (this.cacheDir != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.cacheDir.getPath());
            sb.append(File.separator);
            sb.append("vungle");
            File dir = new File(sb.toString());
            if (dir.exists()) {
                try {
                    FileUtility.delete(dir);
                } catch (IOException e) {
                    String str = TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to delete cached files. Reason: ");
                    sb2.append(e.getLocalizedMessage());
                    Log.e(str, sb2.toString());
                }
            }
            if (!dir.exists()) {
                dir.mkdir();
            }
        }
    }
}
