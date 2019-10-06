package com.google.android.exoplayer2.p183b.p188e;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8219d;
import com.google.android.exoplayer2.util.C8531r;
import com.google.android.exoplayer2.util.C8535t;
import java.util.Arrays;
import java.util.Collections;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ExecutionDataWriter;

/* renamed from: com.google.android.exoplayer2.b.e.m */
/* compiled from: H262Reader */
public final class C8234m implements C8233l {

    /* renamed from: a */
    private static final double[] f17292a = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: b */
    private String f17293b;

    /* renamed from: c */
    private C8272q f17294c;

    /* renamed from: d */
    private boolean f17295d;

    /* renamed from: e */
    private long f17296e;

    /* renamed from: f */
    private final C8221I f17297f;

    /* renamed from: g */
    private final C8535t f17298g;

    /* renamed from: h */
    private final boolean[] f17299h;

    /* renamed from: i */
    private final C8235a f17300i;

    /* renamed from: j */
    private final C8245t f17301j;

    /* renamed from: k */
    private long f17302k;

    /* renamed from: l */
    private boolean f17303l;

    /* renamed from: m */
    private long f17304m;

    /* renamed from: n */
    private long f17305n;

    /* renamed from: o */
    private long f17306o;

    /* renamed from: p */
    private boolean f17307p;

    /* renamed from: q */
    private boolean f17308q;

    /* renamed from: com.google.android.exoplayer2.b.e.m$a */
    /* compiled from: H262Reader */
    private static final class C8235a {

        /* renamed from: a */
        private static final byte[] f17309a = {0, 0, 1};

        /* renamed from: b */
        private boolean f17310b;

        /* renamed from: c */
        public int f17311c;

        /* renamed from: d */
        public int f17312d;

        /* renamed from: e */
        public byte[] f17313e;

        public C8235a(int initialCapacity) {
            this.f17313e = new byte[initialCapacity];
        }

        /* renamed from: a */
        public void mo25309a() {
            this.f17310b = false;
            this.f17311c = 0;
            this.f17312d = 0;
        }

        /* renamed from: a */
        public boolean mo25311a(int startCodeValue, int bytesAlreadyPassed) {
            if (this.f17310b) {
                this.f17311c -= bytesAlreadyPassed;
                if (this.f17312d == 0 && startCodeValue == 181) {
                    this.f17312d = this.f17311c;
                } else {
                    this.f17310b = false;
                    return true;
                }
            } else if (startCodeValue == 179) {
                this.f17310b = true;
            }
            byte[] bArr = f17309a;
            mo25310a(bArr, 0, bArr.length);
            return false;
        }

        /* renamed from: a */
        public void mo25310a(byte[] newData, int offset, int limit) {
            if (this.f17310b) {
                int readLength = limit - offset;
                byte[] bArr = this.f17313e;
                int length = bArr.length;
                int i = this.f17311c;
                if (length < i + readLength) {
                    this.f17313e = Arrays.copyOf(bArr, (i + readLength) * 2);
                }
                System.arraycopy(newData, offset, this.f17313e, this.f17311c, readLength);
                this.f17311c += readLength;
            }
        }
    }

    public C8234m() {
        this(null);
    }

    public C8234m(C8221I userDataReader) {
        this.f17297f = userDataReader;
        this.f17299h = new boolean[4];
        this.f17300i = new C8235a(128);
        if (userDataReader != null) {
            this.f17301j = new C8245t(Opcodes.GETSTATIC, 128);
            this.f17298g = new C8535t();
            return;
        }
        this.f17301j = null;
        this.f17298g = null;
    }

    /* renamed from: a */
    public void mo25303a() {
        C8531r.m20558a(this.f17299h);
        this.f17300i.mo25309a();
        if (this.f17297f != null) {
            this.f17301j.mo25330b();
        }
        this.f17302k = 0;
        this.f17303l = false;
    }

    /* renamed from: a */
    public void mo25305a(C8262i extractorOutput, C8219d idGenerator) {
        idGenerator.mo25298a();
        this.f17293b = idGenerator.mo25299b();
        this.f17294c = extractorOutput.mo25351a(idGenerator.mo25300c(), 2);
        C8221I i = this.f17297f;
        if (i != null) {
            i.mo25302a(extractorOutput, idGenerator);
        }
    }

    /* renamed from: a */
    public void mo25304a(long pesTimeUs, int flags) {
        this.f17304m = pesTimeUs;
    }

    /* renamed from: a */
    public void mo25306a(C8535t data) {
        boolean z;
        C8535t tVar = data;
        int offset = data.mo26113c();
        int limit = data.mo26115d();
        byte[] dataArray = tVar.f18861a;
        this.f17302k += (long) data.mo26104a();
        this.f17294c.mo25341a(tVar, data.mo26104a());
        while (true) {
            int startCodeOffset = C8531r.m20554a(dataArray, offset, limit, this.f17299h);
            if (startCodeOffset == limit) {
                break;
            }
            int startCodeValue = tVar.f18861a[startCodeOffset + 3] & 255;
            int lengthToStartCode = startCodeOffset - offset;
            if (!this.f17295d) {
                if (lengthToStartCode > 0) {
                    this.f17300i.mo25310a(dataArray, offset, startCodeOffset);
                }
                if (this.f17300i.mo25311a(startCodeValue, lengthToStartCode < 0 ? -lengthToStartCode : 0)) {
                    Pair<Format, Long> result = m19027a(this.f17300i, this.f17293b);
                    this.f17294c.mo25340a((Format) result.first);
                    this.f17296e = ((Long) result.second).longValue();
                    this.f17295d = true;
                }
            }
            if (this.f17297f != null) {
                int bytesAlreadyPassed = 0;
                if (lengthToStartCode > 0) {
                    this.f17301j.mo25327a(dataArray, offset, startCodeOffset);
                } else {
                    bytesAlreadyPassed = -lengthToStartCode;
                }
                if (this.f17301j.mo25329a(bytesAlreadyPassed)) {
                    C8245t tVar2 = this.f17301j;
                    this.f17298g.mo26109a(this.f17301j.f17431d, C8531r.m20562c(tVar2.f17431d, tVar2.f17432e));
                    this.f17297f.mo25301a(this.f17306o, this.f17298g);
                }
                if (startCodeValue == 178 && tVar.f18861a[startCodeOffset + 2] == 1) {
                    this.f17301j.mo25331b(startCodeValue);
                }
            }
            if (startCodeValue == 0 || startCodeValue == 179) {
                int bytesWrittenPastStartCode = limit - startCodeOffset;
                if (this.f17303l && this.f17308q && this.f17295d) {
                    this.f17294c.mo25339a(this.f17306o, (int) this.f17307p, ((int) (this.f17302k - this.f17305n)) - bytesWrittenPastStartCode, bytesWrittenPastStartCode, null);
                }
                if (this.f17303l == 0 || this.f17308q) {
                    this.f17305n = this.f17302k - ((long) bytesWrittenPastStartCode);
                    long j = this.f17304m;
                    if (j == -9223372036854775807L) {
                        j = this.f17303l ? this.f17306o + this.f17296e : 0;
                    }
                    this.f17306o = j;
                    z = false;
                    this.f17307p = false;
                    this.f17304m = -9223372036854775807L;
                    this.f17303l = true;
                } else {
                    z = false;
                }
                if (startCodeValue == 0) {
                    z = true;
                }
                this.f17308q = z;
            } else if (startCodeValue == 184) {
                this.f17307p = true;
            }
            offset = startCodeOffset + 3;
        }
        if (!this.f17295d) {
            this.f17300i.mo25310a(dataArray, offset, limit);
        }
        if (this.f17297f != null) {
            this.f17301j.mo25327a(dataArray, offset, limit);
        }
    }

    /* renamed from: b */
    public void mo25307b() {
    }

    /* renamed from: a */
    private static Pair<Format, Long> m19027a(C8235a csdBuffer, String formatId) {
        float pixelWidthHeightRatio;
        C8235a aVar = csdBuffer;
        byte[] csdData = Arrays.copyOf(aVar.f17313e, aVar.f17311c);
        byte b = csdData[4] & 255;
        int secondByte = csdData[5] & 255;
        int width = (b << 4) | (secondByte >> 4);
        int height = ((secondByte & 15) << 8) | (csdData[6] & 255);
        int aspectRatioCode = (csdData[7] & 240) >> 4;
        if (aspectRatioCode == 2) {
            pixelWidthHeightRatio = ((float) (height * 4)) / ((float) (width * 3));
        } else if (aspectRatioCode == 3) {
            pixelWidthHeightRatio = ((float) (height * ExecutionDataWriter.BLOCK_SESSIONINFO)) / ((float) (width * 9));
        } else if (aspectRatioCode != 4) {
            pixelWidthHeightRatio = 1.0f;
        } else {
            pixelWidthHeightRatio = ((float) (height * 121)) / ((float) (width * 100));
        }
        String str = formatId;
        int i = aspectRatioCode;
        Format format = Format.m18246a(str, "video/mpeg2", (String) null, -1, -1, width, height, -1.0f, Collections.singletonList(csdData), -1, pixelWidthHeightRatio, (DrmInitData) null);
        long frameDurationUs = 0;
        int frameRateCodeMinusOne = (csdData[7] & 15) - 1;
        if (frameRateCodeMinusOne >= 0) {
            double[] dArr = f17292a;
            if (frameRateCodeMinusOne < dArr.length) {
                double frameRate = dArr[frameRateCodeMinusOne];
                int sequenceExtensionPosition = aVar.f17312d;
                int frameRateExtensionN = (csdData[sequenceExtensionPosition + 9] & 96) >> 5;
                int frameRateExtensionD = csdData[sequenceExtensionPosition + 9] & 31;
                if (frameRateExtensionN != frameRateExtensionD) {
                    byte[] bArr = csdData;
                    float f = pixelWidthHeightRatio;
                    double d = (double) frameRateExtensionN;
                    Double.isNaN(d);
                    double d2 = d + 1.0d;
                    byte b2 = b;
                    int i2 = frameRateExtensionN;
                    double d3 = (double) (frameRateExtensionD + 1);
                    Double.isNaN(d3);
                    frameRate *= d2 / d3;
                } else {
                    float f2 = pixelWidthHeightRatio;
                    byte b3 = b;
                    int i3 = frameRateExtensionN;
                }
                frameDurationUs = (long) (1000000.0d / frameRate);
                return Pair.create(format, Long.valueOf(frameDurationUs));
            }
        }
        float f3 = pixelWidthHeightRatio;
        byte b4 = b;
        return Pair.create(format, Long.valueOf(frameDurationUs));
    }
}
