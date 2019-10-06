package com.mopub.common.util;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.io.File;

public class Files {
    public static File createDirectory(String absolutePath) {
        if (absolutePath == null) {
            return null;
        }
        File directory = new File(absolutePath);
        if ((!directory.exists() || !directory.isDirectory()) && (!directory.mkdirs() || !directory.isDirectory())) {
            return null;
        }
        return directory;
    }

    public static int intLength(File file) {
        if (file == null) {
            return 0;
        }
        long length = file.length();
        if (length < 2147483647L) {
            return (int) length;
        }
        return MoPubClientPositioning.NO_REPEAT;
    }
}
