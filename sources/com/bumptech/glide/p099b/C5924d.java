package com.bumptech.glide.p099b;

import android.util.Log;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.bumptech.glide.b.d */
/* compiled from: GifHeaderParser */
public class C5924d {

    /* renamed from: a */
    private final byte[] f10405a = new byte[Opcodes.ACC_NATIVE];

    /* renamed from: b */
    private ByteBuffer f10406b;

    /* renamed from: c */
    private C5923c f10407c;

    /* renamed from: d */
    private int f10408d = 0;

    /* renamed from: a */
    public C5924d mo18570a(ByteBuffer data) {
        m10893m();
        this.f10406b = data.asReadOnlyBuffer();
        this.f10406b.position(0);
        this.f10406b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    /* renamed from: a */
    public void mo18571a() {
        this.f10406b = null;
        this.f10407c = null;
    }

    /* renamed from: m */
    private void m10893m() {
        this.f10406b = null;
        Arrays.fill(this.f10405a, 0);
        this.f10407c = new C5923c();
        this.f10408d = 0;
    }

    /* renamed from: b */
    public C5923c mo18572b() {
        if (this.f10406b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (m10883c()) {
            return this.f10407c;
        } else {
            m10889i();
            if (!m10883c()) {
                m10887g();
                C5923c cVar = this.f10407c;
                if (cVar.f10394c < 0) {
                    cVar.f10393b = 1;
                }
            }
            return this.f10407c;
        }
    }

    /* renamed from: g */
    private void m10887g() {
        m10882b(MoPubClientPositioning.NO_REPEAT);
    }

    /* renamed from: b */
    private void m10882b(int maxFrames) {
        boolean done = false;
        while (!done && !m10883c() && this.f10407c.f10394c <= maxFrames) {
            int code = m10884d();
            if (code == 33) {
                int extensionLabel = m10884d();
                if (extensionLabel == 1) {
                    m10894n();
                } else if (extensionLabel == 249) {
                    this.f10407c.f10395d = new C5922b();
                    m10888h();
                } else if (extensionLabel == 254) {
                    m10894n();
                } else if (extensionLabel != 255) {
                    m10894n();
                } else {
                    m10886f();
                    StringBuilder app = new StringBuilder();
                    for (int i = 0; i < 11; i++) {
                        app.append((char) this.f10405a[i]);
                    }
                    if (app.toString().equals("NETSCAPE2.0")) {
                        m10891k();
                    } else {
                        m10894n();
                    }
                }
            } else if (code == 44) {
                C5923c cVar = this.f10407c;
                if (cVar.f10395d == null) {
                    cVar.f10395d = new C5922b();
                }
                m10885e();
            } else if (code != 59) {
                this.f10407c.f10393b = 1;
            } else {
                done = true;
            }
        }
    }

    /* renamed from: h */
    private void m10888h() {
        m10884d();
        int packed = m10884d();
        C5922b bVar = this.f10407c.f10395d;
        bVar.f10387g = (packed & 28) >> 2;
        boolean z = true;
        if (bVar.f10387g == 0) {
            bVar.f10387g = 1;
        }
        C5922b bVar2 = this.f10407c.f10395d;
        if ((packed & 1) == 0) {
            z = false;
        }
        bVar2.f10386f = z;
        int delayInHundredthsOfASecond = m10892l();
        if (delayInHundredthsOfASecond < 2) {
            delayInHundredthsOfASecond = 10;
        }
        C5922b bVar3 = this.f10407c.f10395d;
        bVar3.f10389i = delayInHundredthsOfASecond * 10;
        bVar3.f10388h = m10884d();
        m10884d();
    }

    /* renamed from: e */
    private void m10885e() {
        this.f10407c.f10395d.f10381a = m10892l();
        this.f10407c.f10395d.f10382b = m10892l();
        this.f10407c.f10395d.f10383c = m10892l();
        this.f10407c.f10395d.f10384d = m10892l();
        int packed = m10884d();
        boolean z = false;
        boolean lctFlag = (packed & 128) != 0;
        int lctSize = (int) Math.pow(2.0d, (double) ((packed & 7) + 1));
        C5922b bVar = this.f10407c.f10395d;
        if ((packed & 64) != 0) {
            z = true;
        }
        bVar.f10385e = z;
        if (lctFlag) {
            this.f10407c.f10395d.f10391k = m10881a(lctSize);
        } else {
            this.f10407c.f10395d.f10391k = null;
        }
        this.f10407c.f10395d.f10390j = this.f10406b.position();
        m10895o();
        if (!m10883c()) {
            C5923c cVar = this.f10407c;
            cVar.f10394c++;
            cVar.f10396e.add(cVar.f10395d);
        }
    }

    /* renamed from: k */
    private void m10891k() {
        do {
            m10886f();
            byte[] bArr = this.f10405a;
            if (bArr[0] == 1) {
                this.f10407c.f10404m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f10408d <= 0) {
                return;
            }
        } while (!m10883c());
    }

    /* renamed from: i */
    private void m10889i() {
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            id.append((char) m10884d());
        }
        if (!id.toString().startsWith("GIF")) {
            this.f10407c.f10393b = 1;
            return;
        }
        m10890j();
        if (this.f10407c.f10399h && !m10883c()) {
            C5923c cVar = this.f10407c;
            cVar.f10392a = m10881a(cVar.f10400i);
            C5923c cVar2 = this.f10407c;
            cVar2.f10403l = cVar2.f10392a[cVar2.f10401j];
        }
    }

    /* renamed from: j */
    private void m10890j() {
        this.f10407c.f10397f = m10892l();
        this.f10407c.f10398g = m10892l();
        int packed = m10884d();
        this.f10407c.f10399h = (packed & 128) != 0;
        this.f10407c.f10400i = (int) Math.pow(2.0d, (double) ((packed & 7) + 1));
        this.f10407c.f10401j = m10884d();
        this.f10407c.f10402k = m10884d();
    }

    /* renamed from: a */
    private int[] m10881a(int nColors) {
        int[] tab = null;
        byte[] c = new byte[(nColors * 3)];
        try {
            this.f10406b.get(c);
            tab = new int[Opcodes.ACC_NATIVE];
            int i = 0;
            int r = 0;
            while (i < nColors) {
                int j = r + 1;
                int j2 = j + 1;
                int j3 = j2 + 1;
                int i2 = i + 1;
                tab[i] = -16777216 | ((c[r] & 255) << 16) | ((c[j] & 255) << 8) | (c[j2] & 255);
                r = j3;
                i = i2;
            }
        } catch (BufferUnderflowException e) {
            String str = "GifHeaderParser";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Format Error Reading Color Table", e);
            }
            this.f10407c.f10393b = 1;
        }
        return tab;
    }

    /* renamed from: o */
    private void m10895o() {
        m10884d();
        m10894n();
    }

    /* renamed from: n */
    private void m10894n() {
        int blockSize;
        do {
            blockSize = m10884d();
            this.f10406b.position(Math.min(this.f10406b.position() + blockSize, this.f10406b.limit()));
        } while (blockSize > 0);
    }

    /* renamed from: f */
    private void m10886f() {
        this.f10408d = m10884d();
        int n = 0;
        if (this.f10408d > 0) {
            int count = 0;
            while (n < this.f10408d) {
                try {
                    count = this.f10408d - n;
                    this.f10406b.get(this.f10405a, n, count);
                    n += count;
                } catch (Exception e) {
                    String str = "GifHeaderParser";
                    if (Log.isLoggable(str, 3)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Error Reading Block n: ");
                        sb.append(n);
                        sb.append(" count: ");
                        sb.append(count);
                        sb.append(" blockSize: ");
                        sb.append(this.f10408d);
                        Log.d(str, sb.toString(), e);
                    }
                    this.f10407c.f10393b = 1;
                    return;
                }
            }
        }
    }

    /* renamed from: d */
    private int m10884d() {
        try {
            return this.f10406b.get() & 255;
        } catch (Exception e) {
            this.f10407c.f10393b = 1;
            return 0;
        }
    }

    /* renamed from: l */
    private int m10892l() {
        return this.f10406b.getShort();
    }

    /* renamed from: c */
    private boolean m10883c() {
        return this.f10407c.f10393b != 0;
    }
}
