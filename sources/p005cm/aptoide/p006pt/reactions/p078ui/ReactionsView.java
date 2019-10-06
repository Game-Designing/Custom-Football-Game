package p005cm.aptoide.p006pt.reactions.p078ui;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.LinearLayout;
import java.util.Arrays;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.reactions.data.ReactionType;

/* renamed from: cm.aptoide.pt.reactions.ui.ReactionsView */
public class ReactionsView extends LinearLayout {
    private static transient /* synthetic */ boolean[] $jacocoData;
    public static int HEIGHT_REACTIONS = 0;
    public static int REACTIONS_PADDING = 0;
    public static int WIDTH_REACTIONS = 0;
    private List<Reaction> reactions;

    /* renamed from: cm.aptoide.pt.reactions.ui.ReactionsView$Callback */
    public interface Callback {
        void onReactionItemClicked(ReactionType reactionType);
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5885234531238804805L, "cm/aptoide/pt/reactions/ui/ReactionsView", 39);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[38] = true;
    }

    public ReactionsView(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context);
        $jacocoInit[0] = true;
        init();
        $jacocoInit[1] = true;
    }

    public ReactionsView(Context context, AttributeSet attrs) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context, attrs);
        $jacocoInit[2] = true;
        init();
        $jacocoInit[3] = true;
    }

    public ReactionsView(Context context, AttributeSet attrs, int defStyleAttr) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context, attrs, defStyleAttr);
        $jacocoInit[4] = true;
        init();
        $jacocoInit[5] = true;
    }

    private void init() {
        boolean[] $jacocoInit = $jacocoInit();
        setReactionOrientation();
        $jacocoInit[6] = true;
        ReactionType reactionType = ReactionType.LAUGH;
        int i = REACTIONS_PADDING;
        $jacocoInit[7] = true;
        ReactionType reactionType2 = ReactionType.LOVE;
        int i2 = REACTIONS_PADDING;
        $jacocoInit[8] = true;
        ReactionType reactionType3 = ReactionType.THUG;
        int i3 = REACTIONS_PADDING;
        $jacocoInit[9] = true;
        ReactionType reactionType4 = ReactionType.DOWN;
        int i4 = REACTIONS_PADDING;
        $jacocoInit[10] = true;
        Reaction[] reactionArr = {new Reaction(ReactionType.LIKE, REACTIONS_PADDING, getContext()), new Reaction(reactionType, i, getContext()), new Reaction(reactionType2, i2, getContext()), new Reaction(reactionType3, i3, getContext()), new Reaction(reactionType4, i4, getContext())};
        $jacocoInit[11] = true;
        this.reactions = Arrays.asList(reactionArr);
        $jacocoInit[12] = true;
        setOrientation(0);
        $jacocoInit[13] = true;
        LayoutParams reactionParams = new LayoutParams(WIDTH_REACTIONS, HEIGHT_REACTIONS);
        $jacocoInit[14] = true;
        $jacocoInit[15] = true;
        for (Reaction reaction : this.reactions) {
            $jacocoInit[16] = true;
            reaction.setReactionParams(reactionParams);
            $jacocoInit[17] = true;
            addView(reaction.getView());
            $jacocoInit[18] = true;
            reaction.play();
            $jacocoInit[19] = true;
        }
        $jacocoInit[20] = true;
    }

    public void setReactionOrientation() {
        boolean[] $jacocoInit = $jacocoInit();
        int orientation = getResources().getConfiguration().orientation;
        $jacocoInit[21] = true;
        WindowManager wm = (WindowManager) getContext().getSystemService("window");
        $jacocoInit[22] = true;
        Display display = wm.getDefaultDisplay();
        $jacocoInit[23] = true;
        Point size = new Point();
        $jacocoInit[24] = true;
        display.getSize(size);
        if (orientation == 1) {
            $jacocoInit[25] = true;
            WIDTH_REACTIONS = Math.round((float) (size.x / 5));
            $jacocoInit[26] = true;
            HEIGHT_REACTIONS = Math.round((float) (size.x / 5));
            $jacocoInit[27] = true;
            REACTIONS_PADDING = Math.round((float) ((WIDTH_REACTIONS / 100) * 7));
            $jacocoInit[28] = true;
        } else {
            WIDTH_REACTIONS = Math.round((float) ((size.x / 2) / 5));
            $jacocoInit[29] = true;
            HEIGHT_REACTIONS = Math.round((float) ((size.x / 2) / 5));
            $jacocoInit[30] = true;
            REACTIONS_PADDING = Math.round((float) ((WIDTH_REACTIONS / 100) * 7));
            $jacocoInit[31] = true;
        }
        $jacocoInit[32] = true;
    }

    public int getReactionsViewHeight() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = REACTIONS_PADDING;
        int i2 = i + i + HEIGHT_REACTIONS;
        $jacocoInit[33] = true;
        return i2;
    }

    public void setCallback(Callback callback) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[34] = true;
        for (Reaction reaction : this.reactions) {
            $jacocoInit[35] = true;
            reaction.setCallback(callback);
            $jacocoInit[36] = true;
        }
        $jacocoInit[37] = true;
    }
}
