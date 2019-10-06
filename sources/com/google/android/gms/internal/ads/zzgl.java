package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

@TargetApi(16)
@Deprecated
public final class zzgl implements zzhn {

    /* renamed from: a */
    private final Context f28435a;

    /* renamed from: b */
    private final Uri f28436b;

    /* renamed from: c */
    private final Map<String, String> f28437c;

    /* renamed from: d */
    private final FileDescriptor f28438d;

    /* renamed from: e */
    private final long f28439e;

    /* renamed from: f */
    private final long f28440f;

    /* renamed from: g */
    private MediaExtractor f28441g;

    /* renamed from: h */
    private zzho[] f28442h;

    /* renamed from: i */
    private boolean f28443i;

    /* renamed from: j */
    private int f28444j;

    /* renamed from: k */
    private int[] f28445k;

    /* renamed from: l */
    private boolean[] f28446l;

    /* renamed from: m */
    private long f28447m;

    public zzgl(Context context, Uri uri, Map<String, String> map, int i) {
        zzkh.m30537b(zzkq.f28747a >= 16);
        this.f28444j = 2;
        zzkh.m30534a(context);
        this.f28435a = context;
        zzkh.m30534a(uri);
        this.f28436b = uri;
        this.f28437c = null;
        this.f28438d = null;
        this.f28439e = 0;
        this.f28440f = 0;
    }

    /* renamed from: b */
    public final boolean mo31774b(long j) throws IOException {
        if (!this.f28443i) {
            this.f28441g = new MediaExtractor();
            Context context = this.f28435a;
            if (context != null) {
                this.f28441g.setDataSource(context, this.f28436b, null);
            } else {
                this.f28441g.setDataSource(null, 0, 0);
            }
            this.f28445k = new int[this.f28441g.getTrackCount()];
            int[] iArr = this.f28445k;
            this.f28446l = new boolean[iArr.length];
            this.f28442h = new zzho[iArr.length];
            for (int i = 0; i < this.f28445k.length; i++) {
                MediaFormat trackFormat = this.f28441g.getTrackFormat(i);
                String str = "durationUs";
                this.f28442h[i] = new zzho(trackFormat.getString("mime"), trackFormat.containsKey(str) ? trackFormat.getLong(str) : -1);
            }
            this.f28443i = true;
        }
        return true;
    }

    /* renamed from: c */
    public final int mo31775c() {
        zzkh.m30537b(this.f28443i);
        return this.f28445k.length;
    }

    /* renamed from: a */
    public final zzho mo31769a(int i) {
        zzkh.m30537b(this.f28443i);
        return this.f28442h[i];
    }

    /* renamed from: c */
    public final void mo31776c(int i, long j) {
        zzkh.m30537b(this.f28443i);
        boolean z = false;
        zzkh.m30537b(this.f28445k[i] == 0);
        this.f28445k[i] = 1;
        this.f28441g.selectTrack(i);
        if (j != 0) {
            z = true;
        }
        m30263a(j, z);
    }

    /* renamed from: c */
    public final boolean mo31777c(long j) {
        return true;
    }

    /* renamed from: a */
    public final int mo31768a(int i, long j, zzhk zzhk, zzhm zzhm, boolean z) {
        zzkh.m30537b(this.f28443i);
        zzkh.m30537b(this.f28445k[i] != 0);
        boolean[] zArr = this.f28446l;
        if (zArr[i]) {
            zArr[i] = false;
            return -5;
        } else if (z) {
            return -2;
        } else {
            if (this.f28445k[i] != 2) {
                zzhk.f28522a = zzhj.m30355a(this.f28441g.getTrackFormat(i));
                zzhx zzhx = null;
                if (zzkq.f28747a >= 18) {
                    Map psshInfo = this.f28441g.getPsshInfo();
                    if (psshInfo != null && !psshInfo.isEmpty()) {
                        zzhx = new zzhx("video/mp4");
                        zzhx.mo31831a(psshInfo);
                    }
                }
                zzhk.f28523b = zzhx;
                this.f28445k[i] = 2;
                return -4;
            }
            int sampleTrackIndex = this.f28441g.getSampleTrackIndex();
            if (sampleTrackIndex == i) {
                ByteBuffer byteBuffer = zzhm.f28525b;
                if (byteBuffer != null) {
                    int position = byteBuffer.position();
                    zzhm.f28526c = this.f28441g.readSampleData(zzhm.f28525b, position);
                    zzhm.f28525b.position(position + zzhm.f28526c);
                } else {
                    zzhm.f28526c = 0;
                }
                zzhm.f28528e = this.f28441g.getSampleTime();
                zzhm.f28527d = this.f28441g.getSampleFlags() & 3;
                if (zzhm.mo31810a()) {
                    zzhm.f28524a.mo31766a(this.f28441g);
                }
                this.f28447m = -1;
                this.f28441g.advance();
                return -3;
            } else if (sampleTrackIndex < 0) {
                return -1;
            } else {
                return -2;
            }
        }
    }

    /* renamed from: b */
    public final void mo31773b(int i) {
        zzkh.m30537b(this.f28443i);
        zzkh.m30537b(this.f28445k[i] != 0);
        this.f28441g.unselectTrack(i);
        this.f28446l[i] = false;
        this.f28445k[i] = 0;
    }

    /* renamed from: a */
    public final void mo31771a(long j) {
        zzkh.m30537b(this.f28443i);
        m30263a(j, false);
    }

    /* renamed from: b */
    public final long mo31772b() {
        zzkh.m30537b(this.f28443i);
        long cachedDuration = this.f28441g.getCachedDuration();
        if (cachedDuration == -1) {
            return -1;
        }
        long sampleTime = this.f28441g.getSampleTime();
        if (sampleTime == -1) {
            return -3;
        }
        return sampleTime + cachedDuration;
    }

    /* renamed from: a */
    public final void mo31770a() {
        zzkh.m30537b(this.f28444j > 0);
        int i = this.f28444j - 1;
        this.f28444j = i;
        if (i == 0) {
            MediaExtractor mediaExtractor = this.f28441g;
            if (mediaExtractor != null) {
                mediaExtractor.release();
                this.f28441g = null;
            }
        }
    }

    /* renamed from: a */
    private final void m30263a(long j, boolean z) {
        if (z || this.f28447m != j) {
            this.f28447m = j;
            int i = 0;
            this.f28441g.seekTo(j, 0);
            while (true) {
                int[] iArr = this.f28445k;
                if (i < iArr.length) {
                    if (iArr[i] != 0) {
                        this.f28446l[i] = true;
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
