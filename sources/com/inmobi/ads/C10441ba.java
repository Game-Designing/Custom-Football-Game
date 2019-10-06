package com.inmobi.ads;

import android.media.MediaMetadataRetriever;

/* renamed from: com.inmobi.ads.ba */
/* compiled from: NativeTimer */
public final class C10441ba {

    /* renamed from: a */
    C10442a f31760a;

    /* renamed from: b */
    C10442a f31761b;

    /* renamed from: com.inmobi.ads.ba$a */
    /* compiled from: NativeTimer */
    public static class C10442a {

        /* renamed from: a */
        private long f31762a;

        /* renamed from: b */
        private long f31763b;

        /* renamed from: c */
        private String f31764c;

        /* renamed from: d */
        private C10406ao f31765d;

        public C10442a(long j, long j2, String str, C10406ao aoVar) {
            this.f31762a = j;
            this.f31763b = j2;
            this.f31764c = str;
            this.f31765d = aoVar;
        }

        /* renamed from: a */
        public final long mo34144a() {
            long j = this.f31762a;
            C10400ak b = this.f31765d.mo34106b(this.f31764c);
            if (b != null && (b instanceof C10449be)) {
                C10449be beVar = (C10449be) b;
                if (beVar != null) {
                    String b2 = beVar.mo34158b().mo34198b();
                    if (b2 != null) {
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        mediaMetadataRetriever.setDataSource(b2);
                        long intValue = (long) Integer.valueOf(mediaMetadataRetriever.extractMetadata(9)).intValue();
                        double d = (double) j;
                        double d2 = (double) this.f31763b;
                        Double.isNaN(d2);
                        double d3 = (d2 * 1.0d) / 100.0d;
                        double d4 = (double) (intValue / 1000);
                        Double.isNaN(d4);
                        double d5 = d3 * d4;
                        Double.isNaN(d);
                        j = (long) (d + d5);
                        mediaMetadataRetriever.release();
                    }
                }
            }
            if (j >= 0) {
                return j;
            }
            return 0;
        }
    }

    public C10441ba(C10442a aVar, C10442a aVar2) {
        this.f31760a = aVar;
        this.f31761b = aVar2;
    }
}
