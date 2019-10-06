package p005cm.aptoide.p006pt.comments.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.view.recycler.BaseAdapter;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;

/* renamed from: cm.aptoide.pt.comments.view.CommentsAdapter */
public class CommentsAdapter<T extends Displayable> extends BaseAdapter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Class<T> clazz;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8304805150290108166L, "cm/aptoide/pt/comments/view/CommentsAdapter", 12);
        $jacocoData = probes;
        return probes;
    }

    public CommentsAdapter() {
        boolean[] $jacocoInit = $jacocoInit();
        this.clazz = null;
        $jacocoInit[0] = true;
    }

    public CommentsAdapter(Class<T> clazz2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.clazz = clazz2;
        $jacocoInit[1] = true;
    }

    public int getItemPosition(int itemNumber) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.clazz == null) {
            $jacocoInit[2] = true;
            return -1;
        }
        int toReturn = -1;
        int itemsCounter = 0;
        $jacocoInit[3] = true;
        int i = 0;
        $jacocoInit[4] = true;
        while (true) {
            if (i >= getItemCount()) {
                $jacocoInit[5] = true;
                break;
            }
            $jacocoInit[6] = true;
            if (!this.clazz.isAssignableFrom(getDisplayable(i).getClass())) {
                $jacocoInit[7] = true;
            } else if (itemsCounter == itemNumber) {
                toReturn = i;
                $jacocoInit[8] = true;
                break;
            } else {
                itemsCounter++;
                $jacocoInit[9] = true;
            }
            i++;
            $jacocoInit[10] = true;
        }
        $jacocoInit[11] = true;
        return toReturn;
    }
}
