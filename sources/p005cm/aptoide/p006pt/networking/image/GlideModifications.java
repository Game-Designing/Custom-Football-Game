package p005cm.aptoide.p006pt.networking.image;

import android.content.Context;
import com.bumptech.glide.C5926c;
import com.bumptech.glide.C5949d;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.C6060b;
import com.bumptech.glide.load.engine.p120a.C6250e;
import com.bumptech.glide.load.engine.p120a.C6259k;
import com.bumptech.glide.load.engine.p121b.C6281h;
import com.bumptech.glide.load.engine.p121b.C6282i;
import com.bumptech.glide.load.engine.p121b.C6284j;
import com.bumptech.glide.load.engine.p121b.C6284j.C6285a;
import com.bumptech.glide.p101d.C5952c;
import com.bumptech.glide.p103f.C5991g;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.networking.image.GlideModifications */
public class GlideModifications implements C5952c {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1415754251491847276L, "cm/aptoide/pt/networking/image/GlideModifications", 8);
        $jacocoData = probes;
        return probes;
    }

    public GlideModifications() {
        $jacocoInit()[0] = true;
    }

    public void applyOptions(Context context, C5949d builder) {
        boolean[] $jacocoInit = $jacocoInit();
        builder.mo18639a(C5991g.m11105b(C6060b.PREFER_RGB_565));
        $jacocoInit[1] = true;
        C6284j calculator = new C6285a(context).mo19196a();
        $jacocoInit[2] = true;
        int defaultMemoryCacheSize = calculator.mo19195c();
        $jacocoInit[3] = true;
        builder.mo18641a((C6282i) new C6281h((long) defaultMemoryCacheSize));
        $jacocoInit[4] = true;
        int defaultBitmapPoolSize = calculator.mo19194b();
        $jacocoInit[5] = true;
        builder.mo18640a((C6250e) new C6259k((long) defaultBitmapPoolSize));
        $jacocoInit[6] = true;
    }

    public void registerComponents(Context context, C5926c glide, Registry registry) {
        $jacocoInit()[7] = true;
    }
}
