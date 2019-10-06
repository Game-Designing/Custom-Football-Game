package p005cm.aptoide.p006pt.editorial;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.DownloadModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.app.DownloadModel.DownloadState;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Pay;

/* renamed from: cm.aptoide.pt.editorial.EditorialDownloadModel */
public class EditorialDownloadModel extends DownloadModel {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final int position;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-449729204542653353L, "cm/aptoide/pt/editorial/EditorialDownloadModel", 2);
        $jacocoData = probes;
        return probes;
    }

    public EditorialDownloadModel(Action action, int progress, DownloadState downloadState, Pay pay, int position2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(action, progress, downloadState, pay);
        this.position = position2;
        $jacocoInit[0] = true;
    }

    public int getPosition() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.position;
        $jacocoInit[1] = true;
        return i;
    }
}
