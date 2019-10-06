package p005cm.aptoide.p006pt.view.recycler.displayable;

import android.os.Bundle;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.view.LifecycleSchim;

/* renamed from: cm.aptoide.pt.view.recycler.displayable.Displayables */
public class Displayables implements LifecycleSchim {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final List<Displayable> displayables;
    private final Queue<Displayable> temporaryDisplayables = new LinkedList();

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7576137170631837331L, "cm/aptoide/pt/view/recycler/displayable/Displayables", 91);
        $jacocoData = probes;
        return probes;
    }

    public Displayables() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
        this.displayables = new LinkedList();
        $jacocoInit[2] = true;
    }

    public void add(int position, List<? extends Displayable> displayables2) {
        boolean[] $jacocoInit = $jacocoInit();
        Collections.reverse(displayables2);
        $jacocoInit[3] = true;
        $jacocoInit[4] = true;
        for (Displayable displayable : displayables2) {
            $jacocoInit[5] = true;
            add(position, displayable);
            $jacocoInit[6] = true;
        }
        $jacocoInit[7] = true;
    }

    public void add(int position, Displayable displayable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (shouldIgnore(displayable)) {
            $jacocoInit[8] = true;
            return;
        }
        if (displayable instanceof DisplayableGroup) {
            $jacocoInit[9] = true;
            addDisplayableGroup(position, (DisplayableGroup) displayable);
            $jacocoInit[10] = true;
        } else {
            this.displayables.add(position, displayable);
            $jacocoInit[11] = true;
        }
        $jacocoInit[12] = true;
    }

    private boolean shouldIgnore(Displayable displayable) {
        boolean z = displayable instanceof EmptyDisplayable;
        $jacocoInit()[13] = true;
        return z;
    }

    private void addDisplayableGroup(int position, DisplayableGroup displayable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.temporaryDisplayables.clear();
        $jacocoInit[14] = true;
        this.temporaryDisplayables.addAll(displayable.getChildren());
        $jacocoInit[15] = true;
        LinkedList<Displayable> temp = new LinkedList<>();
        $jacocoInit[16] = true;
        while (!this.temporaryDisplayables.isEmpty()) {
            $jacocoInit[17] = true;
            Displayable innerDisplayable = (Displayable) this.temporaryDisplayables.poll();
            if (innerDisplayable instanceof DisplayableGroup) {
                $jacocoInit[18] = true;
                this.temporaryDisplayables.addAll(((DisplayableGroup) innerDisplayable).getChildren());
                $jacocoInit[19] = true;
            } else {
                temp.add(innerDisplayable);
                $jacocoInit[20] = true;
            }
            $jacocoInit[21] = true;
        }
        Collections.reverse(temp);
        $jacocoInit[22] = true;
        this.displayables.addAll(position, temp);
        $jacocoInit[23] = true;
    }

    public void add(List<? extends Displayable> displayables2) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[24] = true;
        for (Displayable displayable : displayables2) {
            $jacocoInit[25] = true;
            add(displayable);
            $jacocoInit[26] = true;
        }
        $jacocoInit[27] = true;
    }

    public void add(Displayable displayable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (shouldIgnore(displayable)) {
            $jacocoInit[28] = true;
            return;
        }
        if (displayable instanceof DisplayableGroup) {
            $jacocoInit[29] = true;
            addDisplayableGroup((DisplayableGroup) displayable);
            $jacocoInit[30] = true;
        } else {
            this.displayables.add(displayable);
            $jacocoInit[31] = true;
        }
        $jacocoInit[32] = true;
    }

    private void addDisplayableGroup(DisplayableGroup displayable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.temporaryDisplayables.clear();
        $jacocoInit[33] = true;
        this.temporaryDisplayables.addAll(displayable.getChildren());
        $jacocoInit[34] = true;
        while (!this.temporaryDisplayables.isEmpty()) {
            $jacocoInit[35] = true;
            Displayable innerDisplayable = (Displayable) this.temporaryDisplayables.poll();
            if (innerDisplayable instanceof DisplayableGroup) {
                $jacocoInit[36] = true;
                this.temporaryDisplayables.addAll(((DisplayableGroup) innerDisplayable).getChildren());
                $jacocoInit[37] = true;
            } else {
                this.displayables.add(innerDisplayable);
                $jacocoInit[38] = true;
            }
            $jacocoInit[39] = true;
        }
        $jacocoInit[40] = true;
    }

    public Displayable pop() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.displayables.size() > 0) {
            $jacocoInit[41] = true;
            List<Displayable> list = this.displayables;
            Displayable displayable = (Displayable) list.remove(list.size() - 1);
            $jacocoInit[42] = true;
            return displayable;
        }
        $jacocoInit[43] = true;
        return null;
    }

    public Displayable get(Integer position) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.displayables.size() > position.intValue()) {
            $jacocoInit[44] = true;
            Displayable displayable = (Displayable) this.displayables.get(position.intValue());
            $jacocoInit[45] = true;
            return displayable;
        }
        $jacocoInit[46] = true;
        return null;
    }

    public int remove(int startPos, int endPos) {
        boolean[] $jacocoInit = $jacocoInit();
        if (startPos < 0) {
            $jacocoInit[47] = true;
        } else if (startPos >= size()) {
            $jacocoInit[48] = true;
        } else if (endPos < startPos) {
            $jacocoInit[49] = true;
        } else if (endPos > size()) {
            $jacocoInit[50] = true;
        } else {
            int numberLoops = (endPos + 1) - startPos;
            if (numberLoops == 0) {
                $jacocoInit[51] = true;
                remove(startPos);
                $jacocoInit[52] = true;
                return 1;
            }
            int i = 0;
            $jacocoInit[53] = true;
            while (i < numberLoops) {
                $jacocoInit[54] = true;
                this.displayables.remove(startPos);
                i++;
                $jacocoInit[55] = true;
            }
            $jacocoInit[56] = true;
            return numberLoops;
        }
        $jacocoInit[57] = true;
        return 0;
    }

    public int size() {
        boolean[] $jacocoInit = $jacocoInit();
        int size = this.displayables.size();
        $jacocoInit[58] = true;
        return size;
    }

    public void remove(int pos) {
        boolean[] $jacocoInit = $jacocoInit();
        if (pos < 0) {
            $jacocoInit[59] = true;
        } else if (pos >= this.displayables.size()) {
            $jacocoInit[60] = true;
        } else {
            $jacocoInit[61] = true;
            this.displayables.remove(pos);
            $jacocoInit[62] = true;
        }
        $jacocoInit[63] = true;
    }

    public void remove(Displayable displayable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.displayables.remove(displayable);
        $jacocoInit[64] = true;
    }

    public int getPosition(Displayable displayable) {
        boolean[] $jacocoInit = $jacocoInit();
        int indexOf = this.displayables.indexOf(displayable);
        $jacocoInit[65] = true;
        return indexOf;
    }

    public void clear() {
        boolean[] $jacocoInit = $jacocoInit();
        this.displayables.clear();
        $jacocoInit[66] = true;
    }

    public void onResume() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[67] = true;
        for (Displayable displayable : this.displayables) {
            $jacocoInit[68] = true;
            displayable.onResume();
            $jacocoInit[69] = true;
        }
        $jacocoInit[70] = true;
    }

    public void onPause() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[71] = true;
        for (Displayable displayable : this.displayables) {
            $jacocoInit[72] = true;
            displayable.onPause();
            $jacocoInit[73] = true;
        }
        $jacocoInit[74] = true;
    }

    public void onViewCreated() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[75] = true;
        for (Displayable displayable : this.displayables) {
            $jacocoInit[76] = true;
            displayable.onViewCreated();
            $jacocoInit[77] = true;
        }
        $jacocoInit[78] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[79] = true;
        for (Displayable displayable : this.displayables) {
            $jacocoInit[80] = true;
            displayable.onDestroyView();
            $jacocoInit[81] = true;
        }
        $jacocoInit[82] = true;
    }

    public void onSaveInstanceState(Bundle outState) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[83] = true;
        for (Displayable displayable : this.displayables) {
            $jacocoInit[84] = true;
            displayable.onSaveInstanceState(outState);
            $jacocoInit[85] = true;
        }
        $jacocoInit[86] = true;
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[87] = true;
        for (Displayable displayable : this.displayables) {
            $jacocoInit[88] = true;
            displayable.onViewStateRestored(savedInstanceState);
            $jacocoInit[89] = true;
        }
        $jacocoInit[90] = true;
    }
}
