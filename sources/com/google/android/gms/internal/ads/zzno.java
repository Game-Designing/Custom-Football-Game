package com.google.android.gms.internal.ads;

import java.io.IOException;

public interface zzno {
    /* renamed from: a */
    void mo32044a();

    /* renamed from: a */
    void mo32045a(int i) throws IOException, InterruptedException;

    /* renamed from: a */
    void mo32046a(byte[] bArr, int i, int i2) throws IOException, InterruptedException;

    /* renamed from: a */
    boolean mo32047a(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException;

    /* renamed from: b */
    int mo32048b(int i) throws IOException, InterruptedException;

    /* renamed from: c */
    void mo32049c(int i) throws IOException, InterruptedException;

    long getLength();

    long getPosition();

    int read(byte[] bArr, int i, int i2) throws IOException, InterruptedException;

    void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException;
}
