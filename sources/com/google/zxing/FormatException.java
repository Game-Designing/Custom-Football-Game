package com.google.zxing;

public final class FormatException extends ReaderException {

    /* renamed from: c */
    private static final FormatException f30879c;

    static {
        FormatException formatException = new FormatException();
        f30879c = formatException;
        formatException.setStackTrace(ReaderException.f30882b);
    }

    private FormatException() {
    }

    /* renamed from: a */
    public static FormatException m33193a() {
        return ReaderException.f30881a ? new FormatException() : f30879c;
    }
}
