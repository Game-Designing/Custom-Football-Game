package p005cm.aptoide.p006pt.reactions.network;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.exception.NoNetworkConnectionException;
import p005cm.aptoide.p006pt.reactions.data.TopReaction;
import p005cm.aptoide.p006pt.reactions.network.ReactionsResponse.ReactionResponseMapper;
import p005cm.aptoide.p006pt.reactions.network.ReactionsResponse.ReactionResponseMessage;
import p005cm.aptoide.p006pt.reactions.network.TopReactionsResponse.C4615My;
import p005cm.aptoide.p006pt.reactions.network.TopReactionsResponse.ReactionTypeResponse;
import p026rx.C0120S;
import p026rx.C0126V;
import p026rx.Single;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

/* renamed from: cm.aptoide.pt.reactions.network.ReactionsRemoteService */
public class ReactionsRemoteService implements ReactionsService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private C0126V ioScheduler;
    private ServiceV8 service;

    /* renamed from: cm.aptoide.pt.reactions.network.ReactionsRemoteService$Body */
    public static class Body {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private String groupUid;
        private String objectUid;
        private String type;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-3960807222584752291L, "cm/aptoide/pt/reactions/network/ReactionsRemoteService$Body", 8);
            $jacocoData = probes;
            return probes;
        }

        public Body(String cardId, String groupId, String reaction) {
            boolean[] $jacocoInit = $jacocoInit();
            this.objectUid = cardId;
            this.groupUid = groupId;
            this.type = reaction;
            $jacocoInit[0] = true;
        }

        public Body(String reaction) {
            boolean[] $jacocoInit = $jacocoInit();
            this.type = reaction;
            $jacocoInit[1] = true;
        }

        public String getObjectUid() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.objectUid;
            $jacocoInit[2] = true;
            return str;
        }

        public void setObjectUid(String objectUid2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.objectUid = objectUid2;
            $jacocoInit[3] = true;
        }

        public String getGroupUid() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.groupUid;
            $jacocoInit[4] = true;
            return str;
        }

        public void setGroupUid(String groupUid2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.groupUid = groupUid2;
            $jacocoInit[5] = true;
        }

        public String getType() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.type;
            $jacocoInit[6] = true;
            return str;
        }

        public void setType(String type2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.type = type2;
            $jacocoInit[7] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.reactions.network.ReactionsRemoteService$ServiceV8 */
    public interface ServiceV8 {
        @DELETE("echo/8.20181122/reactions/{uid}/")
        C0120S<Response<Void>> deleteReaction(@Path("uid") String str);

        @GET("echo/8.20181122/groups/{group_id}/objects/{id}/reactions/summary")
        C0120S<TopReactionsResponse> getTopReactionsResponse(@Path("group_id") String str, @Path("id") String str2);

        @POST("echo/8.20181122/reactions/")
        C0120S<Response<Void>> setFirstUserReaction(@retrofit2.http.Body Body body);

        @PATCH("echo/8.20181122/reactions/{uid}/")
        C0120S<Response<Void>> setSecondUserReaction(@Path("uid") String str, @retrofit2.http.Body Body body);
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2053778604472998774L, "cm/aptoide/pt/reactions/network/ReactionsRemoteService", 39);
        $jacocoData = probes;
        return probes;
    }

    public ReactionsRemoteService(ServiceV8 service2, C0126V ioScheduler2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.service = service2;
        this.ioScheduler = ioScheduler2;
        $jacocoInit[0] = true;
    }

    public Single<ReactionsResponse> setReaction(String cardId, String groupId, String reaction) {
        boolean[] $jacocoInit = $jacocoInit();
        Body body = new Body(cardId, groupId, reaction);
        $jacocoInit[1] = true;
        C0120S firstUserReaction = this.service.setFirstUserReaction(body);
        C4617b bVar = new C4617b(this);
        $jacocoInit[2] = true;
        C0120S j = firstUserReaction.mo3669j(bVar);
        $jacocoInit[3] = true;
        Single n = j.mo3678n();
        C0126V v = this.ioScheduler;
        $jacocoInit[4] = true;
        Single b = n.mo3694b(v);
        C4618c cVar = new C4618c(this);
        $jacocoInit[5] = true;
        Single<ReactionsResponse> f = b.mo3700f(cVar);
        $jacocoInit[6] = true;
        return f;
    }

    public Single<LoadReactionModel> loadReactionModel(String cardId, String groupId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S topReactionsResponse = this.service.getTopReactionsResponse(groupId, cardId);
        C4616a aVar = new C4616a(this);
        $jacocoInit[7] = true;
        C0120S j = topReactionsResponse.mo3669j(aVar);
        $jacocoInit[8] = true;
        Single n = j.mo3678n();
        C0126V v = this.ioScheduler;
        $jacocoInit[9] = true;
        Single<LoadReactionModel> b = n.mo3694b(v);
        $jacocoInit[10] = true;
        return b;
    }

    public Single<ReactionsResponse> setSecondReaction(String uid, String reaction) {
        boolean[] $jacocoInit = $jacocoInit();
        Body body = new Body(reaction);
        $jacocoInit[11] = true;
        C0120S secondUserReaction = this.service.setSecondUserReaction(uid, body);
        C4617b bVar = new C4617b(this);
        $jacocoInit[12] = true;
        C0120S j = secondUserReaction.mo3669j(bVar);
        $jacocoInit[13] = true;
        Single n = j.mo3678n();
        C0126V v = this.ioScheduler;
        $jacocoInit[14] = true;
        Single b = n.mo3694b(v);
        C4618c cVar = new C4618c(this);
        $jacocoInit[15] = true;
        Single<ReactionsResponse> f = b.mo3700f(cVar);
        $jacocoInit[16] = true;
        return f;
    }

    public Single<ReactionsResponse> deleteReaction(String uid) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S deleteReaction = this.service.deleteReaction(uid);
        C4617b bVar = new C4617b(this);
        $jacocoInit[17] = true;
        C0120S j = deleteReaction.mo3669j(bVar);
        $jacocoInit[18] = true;
        Single n = j.mo3678n();
        C0126V v = this.ioScheduler;
        $jacocoInit[19] = true;
        Single b = n.mo3694b(v);
        C4618c cVar = new C4618c(this);
        $jacocoInit[20] = true;
        Single<ReactionsResponse> f = b.mo3700f(cVar);
        $jacocoInit[21] = true;
        return f;
    }

    /* access modifiers changed from: private */
    public ReactionsResponse mapErrorResponse(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (throwable instanceof NoNetworkConnectionException) {
            $jacocoInit[22] = true;
        } else if (throwable instanceof ConnectException) {
            $jacocoInit[23] = true;
        } else {
            ReactionsResponse reactionsResponse = new ReactionsResponse(ReactionResponseMessage.GENERAL_ERROR);
            $jacocoInit[25] = true;
            return reactionsResponse;
        }
        ReactionsResponse reactionsResponse2 = new ReactionsResponse(ReactionResponseMessage.NETWORK_ERROR);
        $jacocoInit[24] = true;
        return reactionsResponse2;
    }

    /* access modifiers changed from: private */
    public ReactionsResponse mapResponse(Response response) {
        boolean[] $jacocoInit = $jacocoInit();
        ReactionsResponse reactionsResponse = new ReactionsResponse(ReactionResponseMapper.mapReactionResponse(response));
        $jacocoInit[26] = true;
        return reactionsResponse;
    }

    /* access modifiers changed from: private */
    public LoadReactionModel mapToTopReactionsList(TopReactionsResponse topReactionsResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        List<TopReaction> topReactionList = new ArrayList<>();
        $jacocoInit[27] = true;
        $jacocoInit[28] = true;
        for (ReactionTypeResponse reaction : topReactionsResponse.getTop()) {
            $jacocoInit[29] = true;
            topReactionList.add(new TopReaction(reaction.getType(), reaction.getTotal()));
            $jacocoInit[30] = true;
        }
        String userReaction = "";
        String userId = "";
        $jacocoInit[31] = true;
        if (topReactionsResponse.getMy() == null) {
            $jacocoInit[32] = true;
        } else {
            $jacocoInit[33] = true;
            C4615My my = topReactionsResponse.getMy();
            $jacocoInit[34] = true;
            userReaction = my.getType();
            $jacocoInit[35] = true;
            C4615My my2 = topReactionsResponse.getMy();
            $jacocoInit[36] = true;
            userId = my2.getUid();
            $jacocoInit[37] = true;
        }
        LoadReactionModel loadReactionModel = new LoadReactionModel(topReactionsResponse.getTotal(), userReaction, userId, topReactionList);
        $jacocoInit[38] = true;
        return loadReactionModel;
    }
}
