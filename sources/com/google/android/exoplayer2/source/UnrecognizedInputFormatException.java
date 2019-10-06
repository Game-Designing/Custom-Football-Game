package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;

public class UnrecognizedInputFormatException extends ParserException {

    /* renamed from: a */
    public final Uri f18158a;

    public UnrecognizedInputFormatException(String message, Uri uri) {
        super(message);
        this.f18158a = uri;
    }
}
