package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.util.C8535t;

abstract class TagPayloadReader {

    /* renamed from: a */
    protected final C8272q f17571a;

    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String msg) {
            super(msg);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo25424a(C8535t tVar) throws ParserException;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo25425b(C8535t tVar, long j) throws ParserException;

    protected TagPayloadReader(C8272q output) {
        this.f17571a = output;
    }

    /* renamed from: a */
    public final void mo25423a(C8535t data, long timeUs) throws ParserException {
        if (mo25424a(data)) {
            mo25425b(data, timeUs);
        }
    }
}
