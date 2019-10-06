package p005cm.aptoide.p006pt.reactions;

import java.util.HashMap;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.reactions.network.LoadReactionModel;
import p005cm.aptoide.p006pt.reactions.network.ReactionsResponse;
import p005cm.aptoide.p006pt.reactions.network.ReactionsResponse.ReactionResponseMessage;
import p005cm.aptoide.p006pt.reactions.network.ReactionsService;
import p026rx.Single;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.reactions.ReactionsManager */
public class ReactionsManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ReactionsService reactionsService;
    private HashMap<String, UserReaction> userReactions;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-190321237631000901L, "cm/aptoide/pt/reactions/ReactionsManager", 35);
        $jacocoData = probes;
        return probes;
    }

    public ReactionsManager(ReactionsService reactionsService2, HashMap<String, UserReaction> userReactions2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.reactionsService = reactionsService2;
        this.userReactions = userReactions2;
        $jacocoInit[0] = true;
    }

    public Single<LoadReactionModel> loadReactionModel(String cardId, String groupId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadReactionModel = this.reactionsService.loadReactionModel(cardId, groupId);
        C4612a aVar = new C4612a(this, cardId, groupId);
        $jacocoInit[1] = true;
        Single<LoadReactionModel> b = loadReactionModel.mo3695b((C0129b<? super T>) aVar);
        $jacocoInit[2] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15848a(String cardId, String groupId, LoadReactionModel loadReactionModel) {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap<String, UserReaction> hashMap = this.userReactions;
        StringBuilder sb = new StringBuilder();
        sb.append(cardId);
        sb.append(groupId);
        String sb2 = sb.toString();
        $jacocoInit[32] = true;
        UserReaction userReaction = new UserReaction(loadReactionModel.getUserId(), loadReactionModel.getMyReaction());
        $jacocoInit[33] = true;
        hashMap.put(sb2, userReaction);
        $jacocoInit[34] = true;
    }

    public Single<ReactionsResponse> setReaction(String cardId, String groupId, String reactionType) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<ReactionsResponse> a = hasNotReacted(cardId, groupId).mo3688a((C0132p<? super T, ? extends Single<? extends R>>) new C4613b<Object,Object>(this, cardId, groupId, reactionType));
        $jacocoInit[3] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo15847a(String cardId, String groupId, String reactionType, Boolean notReacted) {
        boolean[] $jacocoInit = $jacocoInit();
        if (notReacted.booleanValue()) {
            $jacocoInit[27] = true;
            Single reaction = this.reactionsService.setReaction(cardId, groupId, reactionType);
            $jacocoInit[28] = true;
            return reaction;
        } else if (!isSameReaction(cardId, groupId, reactionType)) {
            $jacocoInit[29] = true;
            ReactionsService reactionsService2 = this.reactionsService;
            StringBuilder sb = new StringBuilder();
            sb.append(cardId);
            sb.append(groupId);
            Single secondReaction = reactionsService2.setSecondReaction(getUID(sb.toString()), reactionType);
            $jacocoInit[30] = true;
            return secondReaction;
        } else {
            Single a = Single.m734a(new ReactionsResponse(ReactionResponseMessage.SAME_REACTION));
            $jacocoInit[31] = true;
            return a;
        }
    }

    private boolean isSameReaction(String cardId, String groupId, String reactionType) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        HashMap<String, UserReaction> hashMap = this.userReactions;
        StringBuilder sb = new StringBuilder();
        sb.append(cardId);
        sb.append(groupId);
        UserReaction userReaction = (UserReaction) hashMap.get(sb.toString());
        $jacocoInit[4] = true;
        if (userReaction == null) {
            $jacocoInit[5] = true;
        } else {
            String reaction = userReaction.getReaction();
            $jacocoInit[6] = true;
            if (!reaction.equals(reactionType)) {
                $jacocoInit[7] = true;
            } else {
                $jacocoInit[8] = true;
                z = true;
                $jacocoInit[10] = true;
                return z;
            }
        }
        z = false;
        $jacocoInit[9] = true;
        $jacocoInit[10] = true;
        return z;
    }

    public Single<ReactionsResponse> deleteReaction(String cardId, String groupId) {
        boolean[] $jacocoInit = $jacocoInit();
        ReactionsService reactionsService2 = this.reactionsService;
        StringBuilder sb = new StringBuilder();
        sb.append(cardId);
        sb.append(groupId);
        Single deleteReaction = reactionsService2.deleteReaction(getUID(sb.toString()));
        C4614c cVar = new C4614c(this, cardId, groupId);
        $jacocoInit[11] = true;
        Single<ReactionsResponse> b = deleteReaction.mo3695b((C0129b<? super T>) cVar);
        $jacocoInit[12] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15849a(String cardId, String groupId, ReactionsResponse reactionsResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!reactionsResponse.wasSuccess()) {
            $jacocoInit[23] = true;
        } else {
            $jacocoInit[24] = true;
            HashMap<String, UserReaction> hashMap = this.userReactions;
            StringBuilder sb = new StringBuilder();
            sb.append(cardId);
            sb.append(groupId);
            hashMap.remove(sb.toString());
            $jacocoInit[25] = true;
        }
        $jacocoInit[26] = true;
    }

    private String getUID(String identifier) {
        boolean[] $jacocoInit = $jacocoInit();
        UserReaction userReaction = (UserReaction) this.userReactions.get(identifier);
        String uid = "";
        if (userReaction == null) {
            $jacocoInit[13] = true;
        } else {
            $jacocoInit[14] = true;
            uid = userReaction.getUserId();
            $jacocoInit[15] = true;
        }
        $jacocoInit[16] = true;
        return uid;
    }

    private Single<Boolean> hasNotReacted(String cardId, String groupId) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append(cardId);
        sb.append(groupId);
        if (getUID(sb.toString()) == null) {
            $jacocoInit[17] = true;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cardId);
            sb2.append(groupId);
            if (getUID(sb2.toString()).equals("")) {
                $jacocoInit[18] = true;
            } else {
                z = false;
                $jacocoInit[20] = true;
                Single<Boolean> a = Single.m734a(Boolean.valueOf(z));
                $jacocoInit[21] = true;
                return a;
            }
        }
        $jacocoInit[19] = true;
        z = true;
        Single<Boolean> a2 = Single.m734a(Boolean.valueOf(z));
        $jacocoInit[21] = true;
        return a2;
    }

    public Single<Boolean> isFirstReaction(String cardId, String groupId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> hasNotReacted = hasNotReacted(cardId, groupId);
        $jacocoInit[22] = true;
        return hasNotReacted;
    }
}
