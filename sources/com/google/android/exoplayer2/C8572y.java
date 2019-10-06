package com.google.android.exoplayer2;

import com.google.android.exoplayer2.C8569x.C8571b;
import com.google.android.exoplayer2.source.C8408v;
import com.google.android.exoplayer2.util.C8528p;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.y */
/* compiled from: Renderer */
public interface C8572y extends C8571b {
    /* renamed from: a */
    void mo25508a(float f) throws ExoPlaybackException;

    /* renamed from: a */
    void mo25367a(long j) throws ExoPlaybackException;

    /* renamed from: a */
    void mo25509a(long j, long j2) throws ExoPlaybackException;

    /* renamed from: a */
    void mo25368a(C8095A a, Format[] formatArr, C8408v vVar, long j, boolean z, long j2) throws ExoPlaybackException;

    /* renamed from: a */
    void mo25369a(Format[] formatArr, C8408v vVar, long j) throws ExoPlaybackException;

    /* renamed from: b */
    boolean mo25162b();

    /* renamed from: c */
    void mo25371c();

    /* renamed from: d */
    int mo25372d();

    /* renamed from: f */
    boolean mo25373f();

    /* renamed from: g */
    void mo25374g();

    int getState();

    /* renamed from: h */
    void mo25376h() throws IOException;

    /* renamed from: i */
    boolean mo25377i();

    boolean isReady();

    /* renamed from: j */
    C8573z mo25378j();

    /* renamed from: k */
    C8408v mo25379k();

    /* renamed from: l */
    C8528p mo25166l();

    void setIndex(int i);

    void start() throws ExoPlaybackException;

    void stop() throws ExoPlaybackException;
}
