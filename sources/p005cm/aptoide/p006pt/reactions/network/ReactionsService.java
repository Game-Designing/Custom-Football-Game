package p005cm.aptoide.p006pt.reactions.network;

import p026rx.Single;

/* renamed from: cm.aptoide.pt.reactions.network.ReactionsService */
public interface ReactionsService {
    Single<ReactionsResponse> deleteReaction(String str);

    Single<LoadReactionModel> loadReactionModel(String str, String str2);

    Single<ReactionsResponse> setReaction(String str, String str2, String str3);

    Single<ReactionsResponse> setSecondReaction(String str, String str2);
}
