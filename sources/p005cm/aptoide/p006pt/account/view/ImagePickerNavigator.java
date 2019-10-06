package p005cm.aptoide.p006pt.account.view;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.navigator.ActivityNavigator;
import p005cm.aptoide.p006pt.navigator.Result;
import p026rx.C0120S;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.account.view.ImagePickerNavigator */
public class ImagePickerNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ActivityNavigator activityNavigator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7288326396598268784L, "cm/aptoide/pt/account/view/ImagePickerNavigator", 17);
        $jacocoData = probes;
        return probes;
    }

    public ImagePickerNavigator(ActivityNavigator activityNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.activityNavigator = activityNavigator2;
        $jacocoInit[0] = true;
    }

    public C0120S<String> navigateToGalleryForImageUri(int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S navigateForResult = this.activityNavigator.navigateForResult("android.intent.action.PICK", Media.EXTERNAL_CONTENT_URI, requestCode);
        C1499i iVar = C1499i.f4422a;
        $jacocoInit[1] = true;
        C0120S d = navigateForResult.mo3653d((C0132p<? super T, Boolean>) iVar);
        C1495g gVar = C1495g.f4418a;
        $jacocoInit[2] = true;
        C0120S<String> j = d.mo3669j(gVar);
        $jacocoInit[3] = true;
        return j;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m6230c(Result result) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (result.getResultCode() == -1) {
            $jacocoInit[14] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[15] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[16] = true;
        return valueOf;
    }

    /* renamed from: d */
    static /* synthetic */ String m6231d(Result result) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent data = result.getData();
        $jacocoInit[11] = true;
        Uri data2 = data.getData();
        $jacocoInit[12] = true;
        String uri = data2.toString();
        $jacocoInit[13] = true;
        return uri;
    }

    public C0120S<Void> navigateToCameraWithImageUri(int requestCode, Uri fileName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S navigateForResultWithOutput = this.activityNavigator.navigateForResultWithOutput("android.media.action.IMAGE_CAPTURE", fileName, requestCode);
        C1497h hVar = C1497h.f4420a;
        $jacocoInit[4] = true;
        C0120S d = navigateForResultWithOutput.mo3653d((C0132p<? super T, Boolean>) hVar);
        C1493f fVar = C1493f.f4416a;
        $jacocoInit[5] = true;
        C0120S<Void> j = d.mo3669j(fVar);
        $jacocoInit[6] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6228a(Result result) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (result.getResultCode() == -1) {
            $jacocoInit[8] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[9] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[10] = true;
        return valueOf;
    }

    /* renamed from: b */
    static /* synthetic */ Void m6229b(Result result) {
        $jacocoInit()[7] = true;
        return null;
    }
}
