package p005cm.aptoide.p006pt.reactions;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.reactions.data.TopReaction;

/* renamed from: cm.aptoide.pt.reactions.TopReactionsPreview */
public class TopReactionsPreview {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ImageView firstReaction;
    private ImageView[] imageView;
    private TextView numberOfReactions;
    private ImageView secondReaction;
    private ImageView thirdReaction;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6314944050587913554L, "cm/aptoide/pt/reactions/TopReactionsPreview", 36);
        $jacocoData = probes;
        return probes;
    }

    public TopReactionsPreview() {
        $jacocoInit()[0] = true;
    }

    public void initialReactionsSetup(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        this.firstReaction = (ImageView) view.findViewById(C1375R.C1376id.reaction_1);
        $jacocoInit[1] = true;
        this.secondReaction = (ImageView) view.findViewById(C1375R.C1376id.reaction_2);
        $jacocoInit[2] = true;
        this.thirdReaction = (ImageView) view.findViewById(C1375R.C1376id.reaction_3);
        $jacocoInit[3] = true;
        this.numberOfReactions = (TextView) view.findViewById(C1375R.C1376id.number_of_reactions);
        this.imageView = new ImageView[]{this.firstReaction, this.secondReaction, this.thirdReaction};
        $jacocoInit[4] = true;
    }

    public void setReactions(List<TopReaction> reactions, int numberOfReactions2, Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageView[] imageViews = {this.firstReaction, this.secondReaction, this.thirdReaction};
        int validReactions = 0;
        int i = 0;
        $jacocoInit[5] = true;
        while (i < imageViews.length) {
            $jacocoInit[6] = true;
            if (i >= reactions.size()) {
                $jacocoInit[7] = true;
            } else {
                TopReaction topReaction = (TopReaction) reactions.get(i);
                $jacocoInit[8] = true;
                String type = topReaction.getType();
                $jacocoInit[9] = true;
                if (!isReactionValid(type)) {
                    $jacocoInit[10] = true;
                } else {
                    $jacocoInit[11] = true;
                    ImageLoader with = ImageLoader.with(context);
                    $jacocoInit[12] = true;
                    TopReaction topReaction2 = (TopReaction) reactions.get(i);
                    $jacocoInit[13] = true;
                    String type2 = topReaction2.getType();
                    $jacocoInit[14] = true;
                    with.loadWithShadowCircleTransform(ReactionMapper.mapReaction(type2), imageViews[i]);
                    $jacocoInit[15] = true;
                    imageViews[i].setVisibility(0);
                    validReactions++;
                    $jacocoInit[16] = true;
                    i++;
                    $jacocoInit[18] = true;
                }
            }
            imageViews[i].setVisibility(8);
            $jacocoInit[17] = true;
            i++;
            $jacocoInit[18] = true;
        }
        if (numberOfReactions2 <= 0) {
            $jacocoInit[19] = true;
        } else if (validReactions <= 0) {
            $jacocoInit[20] = true;
        } else {
            $jacocoInit[21] = true;
            this.numberOfReactions.setText(String.valueOf(numberOfReactions2));
            $jacocoInit[22] = true;
            this.numberOfReactions.setVisibility(0);
            $jacocoInit[23] = true;
            $jacocoInit[25] = true;
        }
        this.numberOfReactions.setVisibility(8);
        $jacocoInit[24] = true;
        $jacocoInit[25] = true;
    }

    public boolean isReactionValid(String reaction) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (reaction.equals("")) {
            $jacocoInit[26] = true;
        } else if (ReactionMapper.mapReaction(reaction) == -1) {
            $jacocoInit[27] = true;
        } else {
            $jacocoInit[28] = true;
            z = true;
            $jacocoInit[30] = true;
            return z;
        }
        z = false;
        $jacocoInit[29] = true;
        $jacocoInit[30] = true;
        return z;
    }

    public void clearReactions() {
        boolean[] $jacocoInit = $jacocoInit();
        ImageView[] imageViewArr = this.imageView;
        int length = imageViewArr.length;
        $jacocoInit[31] = true;
        int i = 0;
        while (i < length) {
            ImageView imageView2 = imageViewArr[i];
            $jacocoInit[32] = true;
            imageView2.setVisibility(8);
            i++;
            $jacocoInit[33] = true;
        }
        this.numberOfReactions.setVisibility(8);
        $jacocoInit[34] = true;
    }

    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        this.firstReaction = null;
        this.secondReaction = null;
        this.thirdReaction = null;
        this.numberOfReactions = null;
        $jacocoInit[35] = true;
    }
}
