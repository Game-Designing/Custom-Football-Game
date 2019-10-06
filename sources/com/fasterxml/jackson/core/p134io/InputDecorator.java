package com.fasterxml.jackson.core.p134io;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;

/* renamed from: com.fasterxml.jackson.core.io.InputDecorator */
public abstract class InputDecorator implements Serializable {
    public abstract InputStream decorate(IOContext iOContext, InputStream inputStream) throws IOException;

    public abstract Reader decorate(IOContext iOContext, Reader reader) throws IOException;
}
