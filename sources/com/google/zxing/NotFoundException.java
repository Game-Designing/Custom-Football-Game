package com.google.zxing;

public final class NotFoundException extends ReaderException {

    /* renamed from: c */
    private static final NotFoundException f30880c;

    static {
        NotFoundException notFoundException = new NotFoundException();
        f30880c = notFoundException;
        notFoundException.setStackTrace(ReaderException.f30882b);
    }

    private NotFoundException() {
    }
}
