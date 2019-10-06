package com.google.android.exoplayer2.p183b;

import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.b.h */
/* compiled from: ExtractorInput */
public interface C8261h {
    /* renamed from: a */
    void mo25239a();

    /* renamed from: a */
    void mo25240a(int i) throws IOException, InterruptedException;

    /* renamed from: a */
    void mo25241a(byte[] bArr, int i, int i2) throws IOException, InterruptedException;

    /* renamed from: a */
    boolean mo25242a(int i, boolean z) throws IOException, InterruptedException;

    /* renamed from: a */
    boolean mo25243a(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException;

    /* renamed from: b */
    int mo25244b(int i) throws IOException, InterruptedException;

    /* renamed from: b */
    long mo25245b();

    /* renamed from: b */
    boolean mo25247b(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException;

    /* renamed from: c */
    void mo25248c(int i) throws IOException, InterruptedException;

    long getLength();

    long getPosition();

    int read(byte[] bArr, int i, int i2) throws IOException, InterruptedException;

    void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException;
}
