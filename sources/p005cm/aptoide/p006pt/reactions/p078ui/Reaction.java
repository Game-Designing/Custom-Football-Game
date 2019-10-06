package p005cm.aptoide.p006pt.reactions.p078ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.airbnb.lottie.LottieAnimationView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.reactions.data.ReactionType;
import p005cm.aptoide.p006pt.reactions.p078ui.ReactionsView.Callback;

/* renamed from: cm.aptoide.pt.reactions.ui.Reaction */
public class Reaction {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ReactionType reactionType;
    private final LottieAnimationView view;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7555028657514156538L, "cm/aptoide/pt/reactions/ui/Reaction", 16);
        $jacocoData = probes;
        return probes;
    }

    public Reaction(ReactionType reactionType2, int padding, Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        this.reactionType = reactionType2;
        $jacocoInit[0] = true;
        this.view = new LottieAnimationView(context);
        $jacocoInit[1] = true;
        LottieAnimationView lottieAnimationView = this.view;
        StringBuilder sb = new StringBuilder();
        String name = this.reactionType.name();
        $jacocoInit[2] = true;
        sb.append(name.toLowerCase());
        sb.append(".json");
        String sb2 = sb.toString();
        $jacocoInit[3] = true;
        lottieAnimationView.setAnimation(sb2);
        $jacocoInit[4] = true;
        this.view.mo17887b(true);
        $jacocoInit[5] = true;
        this.view.setPadding(padding, padding, padding, padding);
        $jacocoInit[6] = true;
    }

    public void setReactionParams(LayoutParams params) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.setLayoutParams(params);
        $jacocoInit[7] = true;
    }

    public void play() {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.mo17889c();
        $jacocoInit[8] = true;
    }

    public LottieAnimationView getView() {
        boolean[] $jacocoInit = $jacocoInit();
        LottieAnimationView lottieAnimationView = this.view;
        $jacocoInit[9] = true;
        return lottieAnimationView;
    }

    public void cancel() {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.mo17882a();
        $jacocoInit[10] = true;
    }

    public void setCallback(Callback callback) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.setOnClickListener(new C4619a(this, callback));
        $jacocoInit[11] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15900a(Callback callback, View view2) {
        boolean[] $jacocoInit = $jacocoInit();
        if (callback == null) {
            $jacocoInit[12] = true;
        } else {
            $jacocoInit[13] = true;
            callback.onReactionItemClicked(this.reactionType);
            $jacocoInit[14] = true;
        }
        $jacocoInit[15] = true;
    }
}
