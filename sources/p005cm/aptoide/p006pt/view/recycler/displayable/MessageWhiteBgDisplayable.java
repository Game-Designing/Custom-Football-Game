package p005cm.aptoide.p006pt.view.recycler.displayable;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;

/* renamed from: cm.aptoide.pt.view.recycler.displayable.MessageWhiteBgDisplayable */
public class MessageWhiteBgDisplayable extends Displayable {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String message;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1941244402464855937L, "cm/aptoide/pt/view/recycler/displayable/MessageWhiteBgDisplayable", 5);
        $jacocoData = probes;
        return probes;
    }

    public MessageWhiteBgDisplayable() {
        $jacocoInit()[0] = true;
    }

    public MessageWhiteBgDisplayable(String message2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.message = message2;
        $jacocoInit[1] = true;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 1, true);
        $jacocoInit[2] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[3] = true;
        return C1375R.layout.white_message_displayable;
    }

    public String getMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.message;
        $jacocoInit[4] = true;
        return str;
    }
}
