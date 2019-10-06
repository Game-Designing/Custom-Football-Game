package p005cm.aptoide.p006pt.editorialList;

import java.util.Iterator;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.reactions.ReactionsManager;
import p005cm.aptoide.p006pt.reactions.network.LoadReactionModel;
import p005cm.aptoide.p006pt.reactions.network.ReactionsResponse;
import p026rx.Single;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.editorialList.EditorialListManager */
public class EditorialListManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final EditorialListRepository editorialListRepository;
    private final ReactionsManager reactionsManager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6542736696353377985L, "cm/aptoide/pt/editorialList/EditorialListManager", 26);
        $jacocoData = probes;
        return probes;
    }

    public EditorialListManager(EditorialListRepository editorialListRepository2, ReactionsManager reactionsManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.editorialListRepository = editorialListRepository2;
        this.reactionsManager = reactionsManager2;
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: 0000 */
    public Single<EditorialListViewModel> loadEditorialListViewModel(boolean loadMore, boolean invalidateCache) {
        boolean[] $jacocoInit = $jacocoInit();
        if (loadMore) {
            $jacocoInit[1] = true;
            Single<EditorialListViewModel> loadMoreCurationCards = loadMoreCurationCards();
            $jacocoInit[2] = true;
            return loadMoreCurationCards;
        }
        Single<EditorialListViewModel> loadEditorialListViewModel = this.editorialListRepository.loadEditorialListViewModel(invalidateCache);
        $jacocoInit[3] = true;
        return loadEditorialListViewModel;
    }

    public boolean hasMore() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean hasMore = this.editorialListRepository.hasMore();
        $jacocoInit[4] = true;
        return hasMore;
    }

    private Single<EditorialListViewModel> loadMoreCurationCards() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<EditorialListViewModel> loadMoreCurationCards = this.editorialListRepository.loadMoreCurationCards();
        $jacocoInit[5] = true;
        return loadMoreCurationCards;
    }

    public Single<CurationCard> loadReactionModel(String cardId, String groupId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadReactionModel = this.reactionsManager.loadReactionModel(cardId, groupId);
        C3306p pVar = new C3306p(this, cardId);
        $jacocoInit[6] = true;
        Single<CurationCard> a = loadReactionModel.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) pVar);
        $jacocoInit[7] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo14090a(String cardId, LoadReactionModel loadReactionModel) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadEditorialListViewModel = this.editorialListRepository.loadEditorialListViewModel(false);
        C3304o oVar = new C3304o(this, loadReactionModel, cardId);
        $jacocoInit[23] = true;
        Single a = loadEditorialListViewModel.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) oVar);
        $jacocoInit[24] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo14089a(LoadReactionModel loadReactionModel, String cardId, EditorialListViewModel editorialListViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        Single updatedCards = getUpdatedCards(editorialListViewModel, loadReactionModel, cardId);
        $jacocoInit[25] = true;
        return updatedCards;
    }

    private Single<CurationCard> getUpdatedCards(EditorialListViewModel editorialViewModel, LoadReactionModel loadReactionModel, String cardId) {
        boolean[] $jacocoInit = $jacocoInit();
        List<CurationCard> curationCards = editorialViewModel.getCurationCards();
        CurationCard changedCurationCard = null;
        $jacocoInit[8] = true;
        Iterator it = curationCards.iterator();
        $jacocoInit[9] = true;
        while (true) {
            if (!it.hasNext()) {
                $jacocoInit[10] = true;
                break;
            }
            CurationCard curationCard = (CurationCard) it.next();
            $jacocoInit[11] = true;
            String id = curationCard.getId();
            $jacocoInit[12] = true;
            if (id.equals(cardId)) {
                $jacocoInit[13] = true;
                curationCard.setReactions(loadReactionModel.getTopReactionList());
                $jacocoInit[14] = true;
                curationCard.setNumberOfReactions(loadReactionModel.getTotal());
                $jacocoInit[15] = true;
                curationCard.setUserReaction(loadReactionModel.getMyReaction());
                changedCurationCard = curationCard;
                $jacocoInit[16] = true;
                break;
            }
            $jacocoInit[17] = true;
        }
        this.editorialListRepository.updateCache(editorialViewModel, curationCards);
        $jacocoInit[18] = true;
        Single<CurationCard> a = Single.m734a(changedCurationCard);
        $jacocoInit[19] = true;
        return a;
    }

    public Single<ReactionsResponse> setReaction(String cardId, String groupId, String reaction) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<ReactionsResponse> reaction2 = this.reactionsManager.setReaction(cardId, groupId, reaction);
        $jacocoInit[20] = true;
        return reaction2;
    }

    public Single<ReactionsResponse> deleteReaction(String cardId, String groupId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<ReactionsResponse> deleteReaction = this.reactionsManager.deleteReaction(cardId, groupId);
        $jacocoInit[21] = true;
        return deleteReaction;
    }

    public Single<Boolean> isFirstReaction(String cardId, String groupId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> isFirstReaction = this.reactionsManager.isFirstReaction(cardId, groupId);
        $jacocoInit[22] = true;
        return isFirstReaction;
    }
}
