package p005cm.aptoide.p006pt.home;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.home.ChipManager */
public class ChipManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private Chip currentChip;

    /* renamed from: cm.aptoide.pt.home.ChipManager$Chip */
    public enum Chip {
        APPS("apps"),
        GAMES("games");
        
        private String name;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[4] = true;
        }

        private Chip(String name2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.name = name2;
            $jacocoInit[2] = true;
        }

        public String getName() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.name;
            $jacocoInit[3] = true;
            return str;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3575701966007009834L, "cm/aptoide/pt/home/ChipManager", 3);
        $jacocoData = probes;
        return probes;
    }

    public ChipManager() {
        $jacocoInit()[0] = true;
    }

    public Chip getCurrentChip() {
        boolean[] $jacocoInit = $jacocoInit();
        Chip chip = this.currentChip;
        $jacocoInit[1] = true;
        return chip;
    }

    public void setCurrentChip(Chip currentChip2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.currentChip = currentChip2;
        $jacocoInit[2] = true;
    }
}
