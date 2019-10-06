package p005cm.aptoide.p006pt.share;

import android.content.Context;
import android.content.Intent;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.share.ShareDialogs.ShareResponse;
import p005cm.aptoide.p006pt.util.MarketResourceFormatter;
import p026rx.p027b.C0129b;
import rx.Observable;

/* renamed from: cm.aptoide.pt.share.ShareStoreHelper */
public class ShareStoreHelper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Context context;
    private final MarketResourceFormatter marketResourceFormatter;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6155930974499636988L, "cm/aptoide/pt/share/ShareStoreHelper", 15);
        $jacocoData = probes;
        return probes;
    }

    public ShareStoreHelper(Context context2, MarketResourceFormatter marketResourceFormatter2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.context = context2;
        this.marketResourceFormatter = marketResourceFormatter2;
        $jacocoInit[0] = true;
    }

    public void shareStore(String storeUrl, String storeIconPath) {
        boolean[] $jacocoInit = $jacocoInit();
        String title = this.context.getString(C1375R.string.share_store);
        Context context2 = this.context;
        $jacocoInit[1] = true;
        Observable<ShareResponse> storeShareDialog = ShareDialogs.createStoreShareDialog(context2, title, storeIconPath);
        $jacocoInit[2] = true;
        C4927e eVar = new C4927e(this, storeUrl);
        $jacocoInit[3] = true;
        CrashReport instance = CrashReport.getInstance();
        instance.getClass();
        C4923a aVar = new C4923a(instance);
        $jacocoInit[4] = true;
        storeShareDialog.mo3626a((C0129b<? super T>) eVar, (C0129b<Throwable>) aVar);
        $jacocoInit[5] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16417a(String storeUrl, ShareResponse eResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        if (ShareResponse.USING != eResponse) {
            $jacocoInit[11] = true;
        } else {
            $jacocoInit[12] = true;
            caseDefaultShare(storeUrl);
            $jacocoInit[13] = true;
        }
        $jacocoInit[14] = true;
    }

    private void caseDefaultShare(String storeUrl) {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append(this.marketResourceFormatter.formatString(this.context, C1375R.string.hello_follow_me_on_aptoide, new String[0]));
        sb.append(" ");
        sb.append(storeUrl);
        String msg = sb.toString();
        $jacocoInit[6] = true;
        Intent sharingIntent = new Intent("android.intent.action.SEND");
        $jacocoInit[7] = true;
        sharingIntent.setType("text/plain");
        $jacocoInit[8] = true;
        sharingIntent.putExtra("android.intent.extra.TEXT", msg);
        $jacocoInit[9] = true;
        Context context2 = this.context;
        context2.startActivity(Intent.createChooser(sharingIntent, context2.getString(C1375R.string.share)));
        $jacocoInit[10] = true;
    }
}
