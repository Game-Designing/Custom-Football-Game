package com.bumptech.glide.p099b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.p099b.C5920a.C5921a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.bumptech.glide.b.e */
/* compiled from: StandardGifDecoder */
public class C5925e implements C5920a {

    /* renamed from: a */
    private static final String f10409a = C5925e.class.getSimpleName();

    /* renamed from: b */
    private int[] f10410b;

    /* renamed from: c */
    private final int[] f10411c;

    /* renamed from: d */
    private final C5921a f10412d;

    /* renamed from: e */
    private ByteBuffer f10413e;

    /* renamed from: f */
    private byte[] f10414f;

    /* renamed from: g */
    private short[] f10415g;

    /* renamed from: h */
    private byte[] f10416h;

    /* renamed from: i */
    private byte[] f10417i;

    /* renamed from: j */
    private byte[] f10418j;

    /* renamed from: k */
    private int[] f10419k;

    /* renamed from: l */
    private int f10420l;

    /* renamed from: m */
    private C5923c f10421m;

    /* renamed from: n */
    private Bitmap f10422n;

    /* renamed from: o */
    private boolean f10423o;

    /* renamed from: p */
    private int f10424p;

    /* renamed from: q */
    private int f10425q;

    /* renamed from: r */
    private int f10426r;

    /* renamed from: s */
    private int f10427s;

    /* renamed from: t */
    private Boolean f10428t;

    /* renamed from: u */
    private Config f10429u;

    public C5925e(C5921a provider, C5923c gifHeader, ByteBuffer rawData, int sampleSize) {
        this(provider);
        mo18574a(gifHeader, rawData, sampleSize);
    }

    public C5925e(C5921a provider) {
        this.f10411c = new int[Opcodes.ACC_NATIVE];
        this.f10429u = Config.ARGB_8888;
        this.f10412d = provider;
        this.f10421m = new C5923c();
    }

    public ByteBuffer getData() {
        return this.f10413e;
    }

    public void advance() {
        this.f10420l = (this.f10420l + 1) % this.f10421m.f10394c;
    }

    /* renamed from: a */
    public int mo18573a(int n) {
        if (n < 0) {
            return -1;
        }
        C5923c cVar = this.f10421m;
        if (n < cVar.f10394c) {
            return ((C5922b) cVar.f10396e.get(n)).f10389i;
        }
        return -1;
    }

    /* renamed from: c */
    public int mo18554c() {
        if (this.f10421m.f10394c > 0) {
            int i = this.f10420l;
            if (i >= 0) {
                return mo18573a(i);
            }
        }
        return 0;
    }

    /* renamed from: b */
    public int mo18553b() {
        return this.f10421m.f10394c;
    }

    /* renamed from: e */
    public int mo18557e() {
        return this.f10420l;
    }

    /* renamed from: d */
    public void mo18556d() {
        this.f10420l = -1;
    }

    /* renamed from: f */
    public int mo18558f() {
        return this.f10413e.limit() + this.f10418j.length + (this.f10419k.length * 4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e9, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Bitmap mo18550a() {
        /*
            r8 = this;
            monitor-enter(r8)
            com.bumptech.glide.b.c r0 = r8.f10421m     // Catch:{ all -> 0x00ea }
            int r0 = r0.f10394c     // Catch:{ all -> 0x00ea }
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L_0x000d
            int r0 = r8.f10420l     // Catch:{ all -> 0x00ea }
            if (r0 >= 0) goto L_0x003b
        L_0x000d:
            java.lang.String r0 = f10409a     // Catch:{ all -> 0x00ea }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00ea }
            if (r0 == 0) goto L_0x0039
            java.lang.String r0 = f10409a     // Catch:{ all -> 0x00ea }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
            r3.<init>()     // Catch:{ all -> 0x00ea }
            java.lang.String r4 = "Unable to decode frame, frameCount="
            r3.append(r4)     // Catch:{ all -> 0x00ea }
            com.bumptech.glide.b.c r4 = r8.f10421m     // Catch:{ all -> 0x00ea }
            int r4 = r4.f10394c     // Catch:{ all -> 0x00ea }
            r3.append(r4)     // Catch:{ all -> 0x00ea }
            java.lang.String r4 = ", framePointer="
            r3.append(r4)     // Catch:{ all -> 0x00ea }
            int r4 = r8.f10420l     // Catch:{ all -> 0x00ea }
            r3.append(r4)     // Catch:{ all -> 0x00ea }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00ea }
            android.util.Log.d(r0, r3)     // Catch:{ all -> 0x00ea }
        L_0x0039:
            r8.f10424p = r2     // Catch:{ all -> 0x00ea }
        L_0x003b:
            int r0 = r8.f10424p     // Catch:{ all -> 0x00ea }
            r3 = 0
            if (r0 == r2) goto L_0x00c8
            int r0 = r8.f10424p     // Catch:{ all -> 0x00ea }
            r4 = 2
            if (r0 != r4) goto L_0x0047
            goto L_0x00c8
        L_0x0047:
            r0 = 0
            r8.f10424p = r0     // Catch:{ all -> 0x00ea }
            byte[] r4 = r8.f10414f     // Catch:{ all -> 0x00ea }
            if (r4 != 0) goto L_0x0058
            com.bumptech.glide.b.a$a r4 = r8.f10412d     // Catch:{ all -> 0x00ea }
            r5 = 255(0xff, float:3.57E-43)
            byte[] r4 = r4.mo18564a(r5)     // Catch:{ all -> 0x00ea }
            r8.f10414f = r4     // Catch:{ all -> 0x00ea }
        L_0x0058:
            com.bumptech.glide.b.c r4 = r8.f10421m     // Catch:{ all -> 0x00ea }
            java.util.List<com.bumptech.glide.b.b> r4 = r4.f10396e     // Catch:{ all -> 0x00ea }
            int r5 = r8.f10420l     // Catch:{ all -> 0x00ea }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x00ea }
            com.bumptech.glide.b.b r4 = (com.bumptech.glide.p099b.C5922b) r4     // Catch:{ all -> 0x00ea }
            r5 = 0
            int r6 = r8.f10420l     // Catch:{ all -> 0x00ea }
            int r6 = r6 - r2
            if (r6 < 0) goto L_0x0075
            com.bumptech.glide.b.c r7 = r8.f10421m     // Catch:{ all -> 0x00ea }
            java.util.List<com.bumptech.glide.b.b> r7 = r7.f10396e     // Catch:{ all -> 0x00ea }
            java.lang.Object r7 = r7.get(r6)     // Catch:{ all -> 0x00ea }
            com.bumptech.glide.b.b r7 = (com.bumptech.glide.p099b.C5922b) r7     // Catch:{ all -> 0x00ea }
            r5 = r7
        L_0x0075:
            int[] r7 = r4.f10391k     // Catch:{ all -> 0x00ea }
            if (r7 == 0) goto L_0x007c
            int[] r7 = r4.f10391k     // Catch:{ all -> 0x00ea }
            goto L_0x0080
        L_0x007c:
            com.bumptech.glide.b.c r7 = r8.f10421m     // Catch:{ all -> 0x00ea }
            int[] r7 = r7.f10392a     // Catch:{ all -> 0x00ea }
        L_0x0080:
            r8.f10410b = r7     // Catch:{ all -> 0x00ea }
            int[] r7 = r8.f10410b     // Catch:{ all -> 0x00ea }
            if (r7 != 0) goto L_0x00aa
            java.lang.String r0 = f10409a     // Catch:{ all -> 0x00ea }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00ea }
            if (r0 == 0) goto L_0x00a6
            java.lang.String r0 = f10409a     // Catch:{ all -> 0x00ea }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
            r1.<init>()     // Catch:{ all -> 0x00ea }
            java.lang.String r7 = "No valid color table found for frame #"
            r1.append(r7)     // Catch:{ all -> 0x00ea }
            int r7 = r8.f10420l     // Catch:{ all -> 0x00ea }
            r1.append(r7)     // Catch:{ all -> 0x00ea }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ea }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00ea }
        L_0x00a6:
            r8.f10424p = r2     // Catch:{ all -> 0x00ea }
            monitor-exit(r8)
            return r3
        L_0x00aa:
            boolean r1 = r4.f10386f     // Catch:{ all -> 0x00ea }
            if (r1 == 0) goto L_0x00c2
            int[] r1 = r8.f10410b     // Catch:{ all -> 0x00ea }
            int[] r2 = r8.f10411c     // Catch:{ all -> 0x00ea }
            int[] r3 = r8.f10410b     // Catch:{ all -> 0x00ea }
            int r3 = r3.length     // Catch:{ all -> 0x00ea }
            java.lang.System.arraycopy(r1, r0, r2, r0, r3)     // Catch:{ all -> 0x00ea }
            int[] r1 = r8.f10411c     // Catch:{ all -> 0x00ea }
            r8.f10410b = r1     // Catch:{ all -> 0x00ea }
            int[] r1 = r8.f10410b     // Catch:{ all -> 0x00ea }
            int r2 = r4.f10388h     // Catch:{ all -> 0x00ea }
            r1[r2] = r0     // Catch:{ all -> 0x00ea }
        L_0x00c2:
            android.graphics.Bitmap r0 = r8.m10900a(r4, r5)     // Catch:{ all -> 0x00ea }
            monitor-exit(r8)
            return r0
        L_0x00c8:
            java.lang.String r0 = f10409a     // Catch:{ all -> 0x00ea }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00ea }
            if (r0 == 0) goto L_0x00e8
            java.lang.String r0 = f10409a     // Catch:{ all -> 0x00ea }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
            r1.<init>()     // Catch:{ all -> 0x00ea }
            java.lang.String r2 = "Unable to decode frame, status="
            r1.append(r2)     // Catch:{ all -> 0x00ea }
            int r2 = r8.f10424p     // Catch:{ all -> 0x00ea }
            r1.append(r2)     // Catch:{ all -> 0x00ea }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ea }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00ea }
        L_0x00e8:
            monitor-exit(r8)
            return r3
        L_0x00ea:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.p099b.C5925e.mo18550a():android.graphics.Bitmap");
    }

    public void clear() {
        this.f10421m = null;
        byte[] bArr = this.f10418j;
        if (bArr != null) {
            this.f10412d.mo18562a(bArr);
        }
        int[] iArr = this.f10419k;
        if (iArr != null) {
            this.f10412d.mo18563a(iArr);
        }
        Bitmap bitmap = this.f10422n;
        if (bitmap != null) {
            this.f10412d.mo18561a(bitmap);
        }
        this.f10422n = null;
        this.f10413e = null;
        this.f10428t = null;
        byte[] bArr2 = this.f10414f;
        if (bArr2 != null) {
            this.f10412d.mo18562a(bArr2);
        }
    }

    /* renamed from: a */
    public synchronized void mo18574a(C5923c header, ByteBuffer buffer, int sampleSize) {
        if (sampleSize > 0) {
            int sampleSize2 = Integer.highestOneBit(sampleSize);
            this.f10424p = 0;
            this.f10421m = header;
            this.f10420l = -1;
            this.f10413e = buffer.asReadOnlyBuffer();
            this.f10413e.position(0);
            this.f10413e.order(ByteOrder.LITTLE_ENDIAN);
            this.f10423o = false;
            Iterator it = header.f10396e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((C5922b) it.next()).f10387g == 3) {
                    this.f10423o = true;
                    break;
                }
            }
            this.f10425q = sampleSize2;
            this.f10427s = header.f10397f / sampleSize2;
            this.f10426r = header.f10398g / sampleSize2;
            this.f10418j = this.f10412d.mo18564a(header.f10397f * header.f10398g);
            this.f10419k = this.f10412d.mo18565b(this.f10427s * this.f10426r);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Sample size must be >=0, not: ");
            sb.append(sampleSize);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    public void mo18551a(Config config) {
        if (config == Config.ARGB_8888 || config == Config.RGB_565) {
            this.f10429u = config;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unsupported format: ");
        sb.append(config);
        sb.append(", must be one of ");
        sb.append(Config.ARGB_8888);
        sb.append(" or ");
        sb.append(Config.RGB_565);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    private Bitmap m10900a(C5922b currentFrame, C5922b previousFrame) {
        int[] dest = this.f10419k;
        if (previousFrame == null) {
            Bitmap bitmap = this.f10422n;
            if (bitmap != null) {
                this.f10412d.mo18561a(bitmap);
            }
            this.f10422n = null;
            Arrays.fill(dest, 0);
        }
        if (previousFrame != null && previousFrame.f10387g == 3 && this.f10422n == null) {
            Arrays.fill(dest, 0);
        }
        if (previousFrame != null) {
            int i = previousFrame.f10387g;
            if (i > 0) {
                if (i == 2) {
                    int c = 0;
                    if (!currentFrame.f10386f) {
                        C5923c cVar = this.f10421m;
                        c = cVar.f10403l;
                        if (currentFrame.f10391k != null && cVar.f10401j == currentFrame.f10388h) {
                            c = 0;
                        }
                    } else if (this.f10420l == 0) {
                        this.f10428t = Boolean.valueOf(true);
                    }
                    int i2 = previousFrame.f10384d;
                    int i3 = this.f10425q;
                    int downsampledIH = i2 / i3;
                    int downsampledIY = previousFrame.f10382b / i3;
                    int downsampledIW = previousFrame.f10383c / i3;
                    int downsampledIX = previousFrame.f10381a / i3;
                    int i4 = this.f10427s;
                    int topLeft = (downsampledIY * i4) + downsampledIX;
                    int bottomLeft = (i4 * downsampledIH) + topLeft;
                    int left = topLeft;
                    while (left < bottomLeft) {
                        int right = left + downsampledIW;
                        for (int pointer = left; pointer < right; pointer++) {
                            dest[pointer] = c;
                        }
                        left += this.f10427s;
                    }
                } else if (i == 3) {
                    Bitmap bitmap2 = this.f10422n;
                    if (bitmap2 != null) {
                        int i5 = this.f10427s;
                        bitmap2.getPixels(dest, 0, i5, 0, 0, i5, this.f10426r);
                    }
                }
            }
        }
        m10903c(currentFrame);
        if (currentFrame.f10385e || this.f10425q != 1) {
            m10901a(currentFrame);
        } else {
            m10902b(currentFrame);
        }
        if (this.f10423o) {
            int i6 = currentFrame.f10387g;
            if (i6 == 0 || i6 == 1) {
                if (this.f10422n == null) {
                    this.f10422n = m10904g();
                }
                Bitmap bitmap3 = this.f10422n;
                int i7 = this.f10427s;
                bitmap3.setPixels(dest, 0, i7, 0, 0, i7, this.f10426r);
            }
        }
        Bitmap result = m10904g();
        int i8 = this.f10427s;
        result.setPixels(dest, 0, i8, 0, 0, i8, this.f10426r);
        return result;
    }

    /* renamed from: b */
    private void m10902b(C5922b currentFrame) {
        C5922b bVar = currentFrame;
        int[] dest = this.f10419k;
        int downsampledIH = bVar.f10384d;
        int downsampledIY = bVar.f10382b;
        int downsampledIW = bVar.f10383c;
        int downsampledIX = bVar.f10381a;
        boolean isFirstFrame = this.f10420l == 0;
        int width = this.f10427s;
        byte[] mainPixels = this.f10418j;
        int[] act = this.f10410b;
        int transparentColorIndex = -1;
        int i = 0;
        while (i < downsampledIH) {
            int k = (i + downsampledIY) * width;
            int dx = k + downsampledIX;
            int dlim = dx + downsampledIW;
            if (k + width < dlim) {
                dlim = k + width;
            }
            int transparentColorIndex2 = transparentColorIndex;
            int sx = bVar.f10383c * i;
            int dx2 = dx;
            while (dx2 < dlim) {
                int downsampledIH2 = downsampledIH;
                byte downsampledIH3 = mainPixels[sx];
                int downsampledIY2 = downsampledIY;
                int downsampledIY3 = downsampledIH3 & 255;
                if (downsampledIY3 != transparentColorIndex2) {
                    int color = act[downsampledIY3];
                    if (color != 0) {
                        dest[dx2] = color;
                    } else {
                        transparentColorIndex2 = downsampledIH3;
                    }
                }
                sx++;
                dx2++;
                downsampledIH = downsampledIH2;
                downsampledIY = downsampledIY2;
            }
            int i2 = downsampledIY;
            i++;
            transparentColorIndex = transparentColorIndex2;
            bVar = currentFrame;
        }
        int i3 = downsampledIY;
        this.f10428t = Boolean.valueOf(this.f10428t == null && isFirstFrame && transparentColorIndex != -1);
    }

    /* renamed from: a */
    private void m10901a(C5922b currentFrame) {
        boolean z;
        int downsampledIH;
        int downsampledIX;
        int downsampledIW;
        int downsampledIY;
        int pass;
        C5922b bVar = currentFrame;
        int[] dest = this.f10419k;
        int i = bVar.f10384d;
        int i2 = this.f10425q;
        int downsampledIH2 = i / i2;
        int downsampledIY2 = bVar.f10382b / i2;
        int downsampledIW2 = bVar.f10383c / i2;
        int downsampledIX2 = bVar.f10381a / i2;
        int iline = 0;
        boolean isFirstFrame = this.f10420l == 0;
        int sampleSize = this.f10425q;
        int downsampledWidth = this.f10427s;
        int downsampledHeight = this.f10426r;
        byte[] mainPixels = this.f10418j;
        int[] act = this.f10410b;
        int pass2 = 1;
        Boolean isFirstFrameTransparent = this.f10428t;
        int i3 = 0;
        int inc = 8;
        while (i3 < downsampledIH2) {
            int line = i3;
            Boolean isFirstFrameTransparent2 = isFirstFrameTransparent;
            if (bVar.f10385e) {
                if (iline >= downsampledIH2) {
                    pass = pass2 + 1;
                    downsampledIH = downsampledIH2;
                    if (pass == 2) {
                        iline = 4;
                    } else if (pass == 3) {
                        iline = 2;
                        inc = 4;
                    } else if (pass == 4) {
                        iline = 1;
                        inc = 2;
                    }
                } else {
                    downsampledIH = downsampledIH2;
                    pass = pass2;
                }
                line = iline;
                iline += inc;
                pass2 = pass;
            } else {
                downsampledIH = downsampledIH2;
            }
            int line2 = line + downsampledIY2;
            boolean isNotDownsampling = sampleSize == 1;
            if (line2 < downsampledHeight) {
                int k = line2 * downsampledWidth;
                int dx = k + downsampledIX2;
                int i4 = line2;
                int dlim = dx + downsampledIW2;
                downsampledIY = downsampledIY2;
                if (k + downsampledWidth < dlim) {
                    dlim = k + downsampledWidth;
                }
                downsampledIW = downsampledIW2;
                int sx = i3 * sampleSize * bVar.f10383c;
                if (isNotDownsampling) {
                    int sx2 = sx;
                    int dx2 = dx;
                    while (dx2 < dlim) {
                        int downsampledIX3 = downsampledIX2;
                        int averageColor = act[mainPixels[sx2] & 255];
                        if (averageColor != 0) {
                            dest[dx2] = averageColor;
                        } else if (isFirstFrame && isFirstFrameTransparent2 == null) {
                            isFirstFrameTransparent2 = Boolean.valueOf(true);
                        }
                        sx2 += sampleSize;
                        dx2++;
                        downsampledIX2 = downsampledIX3;
                    }
                    downsampledIX = downsampledIX2;
                    isFirstFrameTransparent = isFirstFrameTransparent2;
                } else {
                    downsampledIX = downsampledIX2;
                    int maxPositionInSource = ((dlim - dx) * sampleSize) + sx;
                    int sx3 = sx;
                    int dx3 = dx;
                    while (dx3 < dlim) {
                        int dlim2 = dlim;
                        int averageColor2 = m10899a(sx3, maxPositionInSource, bVar.f10383c);
                        if (averageColor2 != 0) {
                            dest[dx3] = averageColor2;
                        } else if (isFirstFrame && isFirstFrameTransparent2 == null) {
                            isFirstFrameTransparent2 = Boolean.valueOf(true);
                        }
                        sx3 += sampleSize;
                        dx3++;
                        dlim = dlim2;
                    }
                    isFirstFrameTransparent = isFirstFrameTransparent2;
                }
            } else {
                downsampledIY = downsampledIY2;
                downsampledIW = downsampledIW2;
                downsampledIX = downsampledIX2;
                isFirstFrameTransparent = isFirstFrameTransparent2;
            }
            i3++;
            downsampledIH2 = downsampledIH;
            downsampledIY2 = downsampledIY;
            downsampledIW2 = downsampledIW;
            downsampledIX2 = downsampledIX;
        }
        int i5 = downsampledIY2;
        int i6 = downsampledIW2;
        int i7 = downsampledIX2;
        Boolean isFirstFrameTransparent3 = isFirstFrameTransparent;
        if (this.f10428t == null) {
            if (isFirstFrameTransparent3 == null) {
                z = false;
            } else {
                z = isFirstFrameTransparent3.booleanValue();
            }
            this.f10428t = Boolean.valueOf(z);
        }
    }

    /* renamed from: a */
    private int m10899a(int positionInMainPixels, int maxPositionInMainPixels, int currentFrameIw) {
        int alphaSum = 0;
        int redSum = 0;
        int greenSum = 0;
        int blueSum = 0;
        int totalAdded = 0;
        for (int i = positionInMainPixels; i < this.f10425q + positionInMainPixels; i++) {
            byte[] bArr = this.f10418j;
            if (i >= bArr.length || i >= maxPositionInMainPixels) {
                break;
            }
            int currentColor = this.f10410b[bArr[i] & 255];
            if (currentColor != 0) {
                alphaSum += (currentColor >> 24) & 255;
                redSum += (currentColor >> 16) & 255;
                greenSum += (currentColor >> 8) & 255;
                blueSum += currentColor & 255;
                totalAdded++;
            }
        }
        for (int i2 = positionInMainPixels + currentFrameIw; i2 < positionInMainPixels + currentFrameIw + this.f10425q; i2++) {
            byte[] bArr2 = this.f10418j;
            if (i2 >= bArr2.length || i2 >= maxPositionInMainPixels) {
                break;
            }
            int currentColor2 = this.f10410b[bArr2[i2] & 255];
            if (currentColor2 != 0) {
                alphaSum += (currentColor2 >> 24) & 255;
                redSum += (currentColor2 >> 16) & 255;
                greenSum += (currentColor2 >> 8) & 255;
                blueSum += currentColor2 & 255;
                totalAdded++;
            }
        }
        if (totalAdded == 0) {
            return 0;
        }
        return ((alphaSum / totalAdded) << 24) | ((redSum / totalAdded) << 16) | ((greenSum / totalAdded) << 8) | (blueSum / totalAdded);
    }

    /* JADX WARNING: type inference failed for: r4v1, types: [short[]] */
    /* JADX WARNING: type inference failed for: r22v6 */
    /* JADX WARNING: type inference failed for: r14v7 */
    /* JADX WARNING: type inference failed for: r13v7 */
    /* JADX WARNING: type inference failed for: r24v6 */
    /* JADX WARNING: type inference failed for: r13v9 */
    /* JADX WARNING: type inference failed for: r13v10 */
    /* JADX WARNING: type inference failed for: r14v9 */
    /* JADX WARNING: type inference failed for: r13v11, types: [short] */
    /* JADX WARNING: type inference failed for: r13v12 */
    /* JADX WARNING: type inference failed for: r14v10 */
    /* JADX WARNING: type inference failed for: r14v11 */
    /* JADX WARNING: type inference failed for: r22v13 */
    /* JADX WARNING: type inference failed for: r14v12 */
    /* JADX WARNING: type inference failed for: r13v13 */
    /* JADX WARNING: type inference failed for: r13v14 */
    /* JADX WARNING: type inference failed for: r13v15 */
    /* JADX WARNING: type inference failed for: r13v16 */
    /* JADX WARNING: type inference failed for: r14v13 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=null, for r13v11, types: [short] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short[], code=null, for r4v1, types: [short[]] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r22v6
      assigns: []
      uses: []
      mth insns count: 174
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 9 */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m10903c(com.bumptech.glide.p099b.C5922b r28) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            if (r1 == 0) goto L_0x000d
            java.nio.ByteBuffer r2 = r0.f10413e
            int r3 = r1.f10390j
            r2.position(r3)
        L_0x000d:
            if (r1 != 0) goto L_0x0018
            com.bumptech.glide.b.c r2 = r0.f10421m
            int r3 = r2.f10397f
            int r2 = r2.f10398g
            int r3 = r3 * r2
            goto L_0x001e
        L_0x0018:
            int r2 = r1.f10383c
            int r3 = r1.f10384d
            int r3 = r3 * r2
        L_0x001e:
            r2 = r3
            byte[] r3 = r0.f10418j
            if (r3 == 0) goto L_0x0026
            int r3 = r3.length
            if (r3 >= r2) goto L_0x002e
        L_0x0026:
            com.bumptech.glide.b.a$a r3 = r0.f10412d
            byte[] r3 = r3.mo18564a(r2)
            r0.f10418j = r3
        L_0x002e:
            byte[] r3 = r0.f10418j
            short[] r4 = r0.f10415g
            r5 = 4096(0x1000, float:5.74E-42)
            if (r4 != 0) goto L_0x003a
            short[] r4 = new short[r5]
            r0.f10415g = r4
        L_0x003a:
            short[] r4 = r0.f10415g
            byte[] r6 = r0.f10416h
            if (r6 != 0) goto L_0x0044
            byte[] r6 = new byte[r5]
            r0.f10416h = r6
        L_0x0044:
            byte[] r6 = r0.f10416h
            byte[] r7 = r0.f10417i
            if (r7 != 0) goto L_0x0050
            r7 = 4097(0x1001, float:5.741E-42)
            byte[] r7 = new byte[r7]
            r0.f10417i = r7
        L_0x0050:
            byte[] r7 = r0.f10417i
            int r8 = r27.m10906i()
            r9 = 1
            int r10 = r9 << r8
            int r11 = r10 + 1
            int r12 = r10 + 2
            r13 = -1
            int r14 = r8 + 1
            int r15 = r9 << r14
            int r15 = r15 - r9
            r16 = 0
            r5 = r16
        L_0x0067:
            r9 = 0
            if (r5 >= r10) goto L_0x0073
            r4[r5] = r9
            byte r9 = (byte) r5
            r6[r5] = r9
            int r5 = r5 + 1
            r9 = 1
            goto L_0x0067
        L_0x0073:
            byte[] r1 = r0.f10414f
            r17 = r9
            r18 = r9
            r19 = r9
            r20 = r9
            r21 = r9
            r22 = r9
            r23 = r9
            r24 = r9
            r26 = r12
            r12 = r5
            r5 = r24
            r24 = r14
            r14 = r18
            r18 = r15
            r15 = r26
        L_0x0092:
            if (r5 >= r2) goto L_0x0168
            if (r21 != 0) goto L_0x00a3
            int r21 = r27.m10905h()
            if (r21 > 0) goto L_0x00a1
            r9 = 3
            r0.f10424p = r9
            goto L_0x0168
        L_0x00a1:
            r17 = 0
        L_0x00a3:
            byte r9 = r1[r17]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r9 = r9 << r22
            int r23 = r23 + r9
            int r22 = r22 + 8
            r9 = 1
            int r17 = r17 + 1
            r9 = -1
            int r21 = r21 + -1
            r25 = r20
            r20 = r19
            r19 = r5
            r5 = r22
            r22 = r14
            r14 = r13
            r13 = r12
            r12 = r24
        L_0x00c1:
            if (r5 < r12) goto L_0x014f
            r13 = r23 & r18
            int r23 = r23 >> r12
            int r5 = r5 - r12
            if (r13 != r10) goto L_0x00d6
            int r12 = r8 + 1
            r16 = 1
            int r24 = r16 << r12
            int r18 = r24 + -1
            int r15 = r10 + 2
            r14 = -1
            goto L_0x00c1
        L_0x00d6:
            r16 = 1
            if (r13 != r11) goto L_0x00ea
            r24 = r12
            r12 = r13
            r13 = r14
            r14 = r22
            r9 = 0
            r22 = r5
            r5 = r19
            r19 = r20
            r20 = r25
            goto L_0x0092
        L_0x00ea:
            if (r14 != r9) goto L_0x00f8
            byte r24 = r6[r13]
            r3[r22] = r24
            int r22 = r22 + 1
            int r19 = r19 + 1
            r14 = r13
            r25 = r13
            goto L_0x00c1
        L_0x00f8:
            r24 = r13
            if (r13 < r15) goto L_0x0106
            r9 = r25
            byte r0 = (byte) r9
            r7[r20] = r0
            int r20 = r20 + 1
            r0 = r14
            r13 = r0
            goto L_0x0108
        L_0x0106:
            r9 = r25
        L_0x0108:
            if (r13 < r10) goto L_0x0113
            byte r0 = r6[r13]
            r7[r20] = r0
            int r20 = r20 + 1
            short r13 = r4[r13]
            goto L_0x0108
        L_0x0113:
            byte r0 = r6[r13]
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r0
            r3[r22] = r9
            int r22 = r22 + 1
            int r19 = r19 + 1
        L_0x011e:
            if (r20 <= 0) goto L_0x012b
            int r20 = r20 + -1
            byte r9 = r7[r20]
            r3[r22] = r9
            int r22 = r22 + 1
            int r19 = r19 + 1
            goto L_0x011e
        L_0x012b:
            r9 = 4096(0x1000, float:5.74E-42)
            if (r15 >= r9) goto L_0x0146
            short r9 = (short) r14
            r4[r15] = r9
            byte r9 = (byte) r0
            r6[r15] = r9
            int r15 = r15 + 1
            r9 = r15 & r18
            if (r9 != 0) goto L_0x0144
            r9 = 4096(0x1000, float:5.74E-42)
            if (r15 >= r9) goto L_0x0146
            int r12 = r12 + 1
            int r18 = r18 + r15
            goto L_0x0146
        L_0x0144:
            r9 = 4096(0x1000, float:5.74E-42)
        L_0x0146:
            r14 = r24
            r9 = -1
            r25 = r0
            r0 = r27
            goto L_0x00c1
        L_0x014f:
            r9 = r25
            r0 = 4096(0x1000, float:5.74E-42)
            r16 = 1
            r0 = r27
            r24 = r12
            r12 = r13
            r13 = r14
            r14 = r22
            r22 = r5
            r5 = r19
            r19 = r20
            r20 = r9
            r9 = 0
            goto L_0x0092
        L_0x0168:
            r0 = 0
            java.util.Arrays.fill(r3, r14, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.p099b.C5925e.m10903c(com.bumptech.glide.b.b):void");
    }

    /* renamed from: i */
    private int m10906i() {
        return this.f10413e.get() & 255;
    }

    /* renamed from: h */
    private int m10905h() {
        int blockSize = m10906i();
        if (blockSize <= 0) {
            return blockSize;
        }
        ByteBuffer byteBuffer = this.f10413e;
        byteBuffer.get(this.f10414f, 0, Math.min(blockSize, byteBuffer.remaining()));
        return blockSize;
    }

    /* renamed from: g */
    private Bitmap m10904g() {
        Boolean bool = this.f10428t;
        Bitmap result = this.f10412d.mo18560a(this.f10427s, this.f10426r, (bool == null || bool.booleanValue()) ? Config.ARGB_8888 : this.f10429u);
        result.setHasAlpha(true);
        return result;
    }
}
