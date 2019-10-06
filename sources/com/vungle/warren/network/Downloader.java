package com.vungle.warren.network;

import java.io.File;
import java.io.IOException;

public interface Downloader {

    public interface Listener {
        void onComplete(File file);

        void onError(long j, Throwable th);

        void onProgress(int i, int i2);
    }

    boolean download(String str, File file, Listener listener) throws IOException, IllegalArgumentException, IllegalStateException;

    void pause();

    void resume();

    void retry(long j);
}
