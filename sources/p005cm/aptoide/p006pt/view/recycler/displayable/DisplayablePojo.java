package p005cm.aptoide.p006pt.view.recycler.displayable;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.recycler.displayable.DisplayablePojo */
public abstract class DisplayablePojo<T> extends Displayable {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private T pojo;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(9066223282866329669L, "cm/aptoide/pt/view/recycler/displayable/DisplayablePojo", 4);
        $jacocoData = probes;
        return probes;
    }

    public DisplayablePojo() {
        $jacocoInit()[0] = true;
    }

    public DisplayablePojo(T pojo2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.pojo = pojo2;
        $jacocoInit[1] = true;
    }

    public T getPojo() {
        boolean[] $jacocoInit = $jacocoInit();
        T t = this.pojo;
        $jacocoInit[2] = true;
        return t;
    }

    public DisplayablePojo<T> setPojo(T pojo2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.pojo = pojo2;
        $jacocoInit[3] = true;
        return this;
    }
}
