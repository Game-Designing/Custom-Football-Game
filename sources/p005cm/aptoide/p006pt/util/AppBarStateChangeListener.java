package p005cm.aptoide.p006pt.util;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.C0227b;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.util.AppBarStateChangeListener */
public abstract class AppBarStateChangeListener implements C0227b {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private State mCurrentState = State.IDLE;

    /* renamed from: cm.aptoide.pt.util.AppBarStateChangeListener$State */
    public enum State {
        EXPANDED,
        MOVING,
        IDLE,
        COLLAPSED;

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
        boolean[] probes = Offline.getProbes(-2704251657211410555L, "cm/aptoide/pt/util/AppBarStateChangeListener", 18);
        $jacocoData = probes;
        return probes;
    }

    public abstract void onStateChanged(AppBarLayout appBarLayout, State state);

    public AppBarStateChangeListener() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
    }

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        if (i == 0) {
            State state = this.mCurrentState;
            State state2 = State.EXPANDED;
            if (state == state2) {
                $jacocoInit[1] = true;
            } else {
                $jacocoInit[2] = true;
                onStateChanged(appBarLayout, state2);
                $jacocoInit[3] = true;
            }
            this.mCurrentState = State.EXPANDED;
            $jacocoInit[4] = true;
        } else if (Math.abs(i) - appBarLayout.getTotalScrollRange() == 0) {
            State state3 = this.mCurrentState;
            State state4 = State.COLLAPSED;
            if (state3 == state4) {
                $jacocoInit[5] = true;
            } else {
                $jacocoInit[6] = true;
                onStateChanged(appBarLayout, state4);
                $jacocoInit[7] = true;
            }
            this.mCurrentState = State.COLLAPSED;
            $jacocoInit[8] = true;
        } else if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) {
            State state5 = this.mCurrentState;
            State state6 = State.MOVING;
            if (state5 == state6) {
                $jacocoInit[9] = true;
            } else {
                $jacocoInit[10] = true;
                onStateChanged(appBarLayout, state6);
                $jacocoInit[11] = true;
            }
            this.mCurrentState = State.MOVING;
            $jacocoInit[12] = true;
        } else {
            State state7 = this.mCurrentState;
            State state8 = State.IDLE;
            if (state7 == state8) {
                $jacocoInit[13] = true;
            } else {
                $jacocoInit[14] = true;
                onStateChanged(appBarLayout, state8);
                $jacocoInit[15] = true;
            }
            this.mCurrentState = State.IDLE;
            $jacocoInit[16] = true;
        }
        $jacocoInit[17] = true;
    }
}
