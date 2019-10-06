package p005cm.aptoide.p006pt.editorialList;

import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.editorial.CaptionBackgroundPainter;
import p005cm.aptoide.p006pt.home.EditorialBundleViewHolder;
import p005cm.aptoide.p006pt.home.HomeEvent;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.editorialList.LoadingViewHolder */
class LoadingViewHolder extends EditorialBundleViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8615812180906346924L, "cm/aptoide/pt/editorialList/LoadingViewHolder", 1);
        $jacocoData = probes;
        return probes;
    }

    public LoadingViewHolder(View inflate, C14963c<HomeEvent> uiEventsListener, CaptionBackgroundPainter captionBackgroundPainter) {
        boolean[] $jacocoInit = $jacocoInit();
        super(inflate, uiEventsListener, captionBackgroundPainter);
        $jacocoInit[0] = true;
    }
}
