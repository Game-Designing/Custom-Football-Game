package com.google.android.exoplayer2;

import java.io.IOException;

public final class ExoPlaybackException extends Exception {

    /* renamed from: a */
    public final int f16496a;

    /* renamed from: b */
    public final int f16497b;

    /* renamed from: c */
    private final Throwable f16498c;

    /* renamed from: a */
    public static ExoPlaybackException m18240a(IOException cause) {
        return new ExoPlaybackException(0, cause, -1);
    }

    /* renamed from: a */
    public static ExoPlaybackException m18241a(Exception cause, int rendererIndex) {
        return new ExoPlaybackException(1, cause, rendererIndex);
    }

    /* renamed from: a */
    static ExoPlaybackException m18242a(RuntimeException cause) {
        return new ExoPlaybackException(2, cause, -1);
    }

    private ExoPlaybackException(int type, Throwable cause, int rendererIndex) {
        super(cause);
        this.f16496a = type;
        this.f16498c = cause;
        this.f16497b = rendererIndex;
    }
}
