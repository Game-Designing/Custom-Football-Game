package p005cm.aptoide.p006pt.share;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.Drawable;
import android.support.p001v7.app.C0774m;
import android.support.p001v7.app.C0774m.C0775a;
import com.bumptech.glide.p103f.p104a.C5974g;
import com.bumptech.glide.p103f.p105b.C5983b;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p029i.C14978f;

/* renamed from: cm.aptoide.pt.share.ShareDialogs */
public class ShareDialogs {
    private static transient /* synthetic */ boolean[] $jacocoData;

    /* renamed from: cm.aptoide.pt.share.ShareDialogs$ShareResponse */
    public enum ShareResponse {
        USING;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2447089177571360861L, "cm/aptoide/pt/share/ShareDialogs", 15);
        $jacocoData = probes;
        return probes;
    }

    public ShareDialogs() {
        $jacocoInit()[0] = true;
    }

    public static C0120S<ShareResponse> createStoreShareDialog(Context context, String title, String storeIcon) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<ShareResponse> a = C0120S.m634a((C0122a<T>) new C4924b<T>(context, title, storeIcon));
        $jacocoInit[1] = true;
        return a;
    }

    /* renamed from: a */
    static /* synthetic */ void m9259a(Context context, String title, String storeIcon, C14980ia subscriber) {
        boolean[] $jacocoInit = $jacocoInit();
        C0775a aVar = new C0775a(context);
        aVar.mo6236b((CharSequence) title);
        C4926d dVar = new C4926d(subscriber);
        $jacocoInit[2] = true;
        aVar.mo6220a((int) C1375R.array.store_share_options_array, (OnClickListener) dVar);
        $jacocoInit[3] = true;
        final C0774m alertDialog = aVar.mo6231a();
        $jacocoInit[4] = true;
        ImageLoader with = ImageLoader.with(context);
        C49221 r4 = new C5974g<Drawable>() {
            private static transient /* synthetic */ boolean[] $jacocoData;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(8197758642365337587L, "cm/aptoide/pt/share/ShareDialogs$1", 3);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                $jacocoInit[0] = true;
            }

            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, C5983b bVar) {
                boolean[] $jacocoInit = $jacocoInit();
                onResourceReady((Drawable) obj, bVar);
                $jacocoInit[2] = true;
            }

            public void onResourceReady(Drawable resource, C5983b<? super Drawable> glideAnimation) {
                boolean[] $jacocoInit = $jacocoInit();
                alertDialog.mo6216a(resource);
                $jacocoInit[1] = true;
            }
        };
        $jacocoInit[5] = true;
        with.loadIntoTarget(storeIcon, r4);
        $jacocoInit[6] = true;
        subscriber.add(C14978f.m46781a(new C4925c(alertDialog)));
        $jacocoInit[7] = true;
        alertDialog.show();
        $jacocoInit[8] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9261a(C14980ia subscriber, DialogInterface dialogInterface, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        if (subscriber.isUnsubscribed()) {
            $jacocoInit[10] = true;
        } else if (i != 0) {
            $jacocoInit[11] = true;
        } else {
            subscriber.onNext(ShareResponse.USING);
            $jacocoInit[12] = true;
            subscriber.onCompleted();
            $jacocoInit[13] = true;
        }
        $jacocoInit[14] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9260a(C0774m alertDialog) {
        boolean[] $jacocoInit = $jacocoInit();
        alertDialog.dismiss();
        $jacocoInit[9] = true;
    }
}
