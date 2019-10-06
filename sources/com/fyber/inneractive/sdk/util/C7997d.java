package com.fyber.inneractive.sdk.util;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.fyber.inneractive.sdk.p166g.p167a.C7771e.C7780d;
import java.io.File;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.fyber.inneractive.sdk.util.d */
public final class C7997d implements C7780d {

    /* renamed from: a */
    public Bitmap f16327a;

    /* renamed from: b */
    private File f16328b;

    /* renamed from: a */
    public final void mo24404a(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(file.getPath());
            mediaMetadataRetriever.extractMetadata(Opcodes.ACC_ANNOTATION);
            this.f16327a = mediaMetadataRetriever.getFrameAtTime(1);
            if (this.f16327a != null && this.f16327a.getWidth() > 0 && this.f16327a.getHeight() > 0) {
                this.f16328b = file;
            }
            mediaMetadataRetriever.release();
        } catch (Exception e) {
            try {
                StringBuilder sb = new StringBuilder("Failed getting frame from video file");
                sb.append(C8017o.m18096a((Throwable) e));
                IAlog.m18021b(sb.toString());
                mediaMetadataRetriever.release();
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
        }
        IAlog.m18019a(String.format("FirstFrameDownloadMediaProcessor processing finished in %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}));
        return;
        throw th;
    }

    /* renamed from: b */
    public final boolean mo24405b(File file) {
        File file2 = this.f16328b;
        return (file2 == null || file == null || !file2.getAbsolutePath().equals(file.getAbsolutePath())) ? false : true;
    }
}
