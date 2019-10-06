package p005cm.aptoide.p006pt.reactions.network;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import retrofit2.Response;

/* renamed from: cm.aptoide.pt.reactions.network.ReactionsResponse */
public class ReactionsResponse {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ReactionResponseMessage reactionResponseMessage;

    /* renamed from: cm.aptoide.pt.reactions.network.ReactionsResponse$ReactionResponseMapper */
    public static class ReactionResponseMapper {
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-7623293772072086763L, "cm/aptoide/pt/reactions/network/ReactionsResponse$ReactionResponseMapper", 7);
            $jacocoData = probes;
            return probes;
        }

        public ReactionResponseMapper() {
            $jacocoInit()[0] = true;
        }

        public static ReactionResponseMessage mapReactionResponse(Response httpResponse) {
            boolean[] $jacocoInit = $jacocoInit();
            ReactionResponseMessage reactionResponseMessage = ReactionResponseMessage.GENERAL_ERROR;
            $jacocoInit[1] = true;
            int code = httpResponse.code();
            if (code == 200 || code == 201 || code == 204) {
                reactionResponseMessage = ReactionResponseMessage.SUCCESS;
                $jacocoInit[3] = true;
            } else {
                if (code != 403) {
                    if (code == 429) {
                        reactionResponseMessage = ReactionResponseMessage.REACTIONS_EXCEEDED;
                        $jacocoInit[4] = true;
                    } else if (!(code == 500 || code == 400 || code == 401 || code == 405 || code == 406)) {
                        $jacocoInit[2] = true;
                    }
                }
                reactionResponseMessage = ReactionResponseMessage.GENERAL_ERROR;
                $jacocoInit[5] = true;
            }
            $jacocoInit[6] = true;
            return reactionResponseMessage;
        }
    }

    /* renamed from: cm.aptoide.pt.reactions.network.ReactionsResponse$ReactionResponseMessage */
    public enum ReactionResponseMessage {
        SUCCESS,
        GENERAL_ERROR,
        REACTIONS_EXCEEDED,
        SAME_REACTION,
        NETWORK_ERROR;

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
        boolean[] probes = Offline.getProbes(-7291828774807768532L, "cm/aptoide/pt/reactions/network/ReactionsResponse", 16);
        $jacocoData = probes;
        return probes;
    }

    public ReactionsResponse(ReactionResponseMessage reactionResponseMessage2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.reactionResponseMessage = reactionResponseMessage2;
        $jacocoInit[0] = true;
    }

    public boolean wasSuccess() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.reactionResponseMessage == ReactionResponseMessage.SUCCESS) {
            $jacocoInit[1] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[2] = true;
        }
        $jacocoInit[3] = true;
        return z;
    }

    public boolean reactionsExceeded() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.reactionResponseMessage == ReactionResponseMessage.REACTIONS_EXCEEDED) {
            $jacocoInit[4] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[5] = true;
        }
        $jacocoInit[6] = true;
        return z;
    }

    public boolean differentReaction() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.reactionResponseMessage != ReactionResponseMessage.SAME_REACTION) {
            $jacocoInit[7] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[8] = true;
        }
        $jacocoInit[9] = true;
        return z;
    }

    public boolean wasGeneralError() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.reactionResponseMessage == ReactionResponseMessage.GENERAL_ERROR) {
            $jacocoInit[10] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[11] = true;
        }
        $jacocoInit[12] = true;
        return z;
    }

    public boolean wasNetworkError() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.reactionResponseMessage == ReactionResponseMessage.NETWORK_ERROR) {
            $jacocoInit[13] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[14] = true;
        }
        $jacocoInit[15] = true;
        return z;
    }
}
