package p005cm.aptoide.p006pt.home;

import android.content.Context;
import android.support.p001v7.widget.CardView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.editorial.CaptionBackgroundPainter;
import p005cm.aptoide.p006pt.editorial.ViewsFormatter;
import p005cm.aptoide.p006pt.editorialList.CurationCard;
import p005cm.aptoide.p006pt.home.HomeEvent.Type;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.reactions.ReactionMapper;
import p005cm.aptoide.p006pt.reactions.ReactionsHomeEvent;
import p005cm.aptoide.p006pt.reactions.TopReactionsPreview;
import p005cm.aptoide.p006pt.reactions.data.ReactionType;
import p005cm.aptoide.p006pt.reactions.data.TopReaction;
import p005cm.aptoide.p006pt.reactions.p078ui.ReactionsPopup;
import p005cm.aptoide.p006pt.reactions.p078ui.ReactionsView;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.EditorialBundleViewHolder */
public class EditorialBundleViewHolder extends AppBundleViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ImageView backgroundImage;
    private final CaptionBackgroundPainter captionBackgroundPainter;
    private final CardView curationTypeCaption;
    private final TextView curationTypeCaptionText;
    private final View editorialCard;
    private final TextView editorialDate;
    private final TextView editorialTitle;
    private final TextView editorialViews;
    private final ImageButton reactButton;
    private TopReactionsPreview topReactionsPreview = new TopReactionsPreview();
    private final C14963c<HomeEvent> uiEventsListener;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1594687680304618571L, "cm/aptoide/pt/home/EditorialBundleViewHolder", 76);
        $jacocoData = probes;
        return probes;
    }

    public EditorialBundleViewHolder(View view, C14963c<HomeEvent> uiEventsListener2, CaptionBackgroundPainter captionBackgroundPainter2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(view);
        this.uiEventsListener = uiEventsListener2;
        $jacocoInit[0] = true;
        this.editorialCard = view.findViewById(C1375R.C1376id.editorial_card);
        $jacocoInit[1] = true;
        this.editorialTitle = (TextView) view.findViewById(C1375R.C1376id.editorial_title);
        $jacocoInit[2] = true;
        this.editorialDate = (TextView) view.findViewById(C1375R.C1376id.editorial_date);
        $jacocoInit[3] = true;
        this.editorialViews = (TextView) view.findViewById(C1375R.C1376id.editorial_views);
        $jacocoInit[4] = true;
        this.backgroundImage = (ImageView) view.findViewById(C1375R.C1376id.background_image);
        $jacocoInit[5] = true;
        this.reactButton = (ImageButton) view.findViewById(C1375R.C1376id.add_reactions);
        $jacocoInit[6] = true;
        this.curationTypeCaption = (CardView) view.findViewById(C1375R.C1376id.curation_type_bubble);
        $jacocoInit[7] = true;
        this.curationTypeCaptionText = (TextView) view.findViewById(C1375R.C1376id.curation_type_bubble_text);
        this.captionBackgroundPainter = captionBackgroundPainter2;
        $jacocoInit[8] = true;
        $jacocoInit[9] = true;
        this.topReactionsPreview.initialReactionsSetup(view);
        $jacocoInit[10] = true;
    }

    public void setBundle(HomeBundle homeBundle, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        ActionBundle actionBundle = (ActionBundle) homeBundle;
        $jacocoInit[11] = true;
        ActionItem actionItem = actionBundle.getActionItem();
        $jacocoInit[12] = true;
        String icon = actionItem.getIcon();
        String title = actionItem.getTitle();
        String subTitle = actionItem.getSubTitle();
        $jacocoInit[13] = true;
        String cardId = actionItem.getCardId();
        String numberOfViews = actionItem.getNumberOfViews();
        String type = actionItem.getType();
        $jacocoInit[14] = true;
        String date = actionItem.getDate();
        int adapterPosition = getAdapterPosition();
        List reactionList = actionItem.getReactionList();
        $jacocoInit[15] = true;
        int total = actionItem.getTotal();
        String userReaction = actionItem.getUserReaction();
        String captionColor = actionItem.getCaptionColor();
        $jacocoInit[16] = true;
        setBundleInformation(icon, title, subTitle, cardId, numberOfViews, type, date, adapterPosition, homeBundle, reactionList, total, userReaction, captionColor);
        $jacocoInit[17] = true;
    }

    private void setBundleInformation(String icon, String title, String subTitle, String cardId, String numberOfViews, String type, String date, int position, HomeBundle homeBundle, List<TopReaction> reactions, int numberOfReactions, String userReaction, String captionColor) {
        boolean[] $jacocoInit = $jacocoInit();
        clearReactions();
        $jacocoInit[18] = true;
        setReactions(reactions, numberOfReactions, userReaction);
        $jacocoInit[19] = true;
        ImageLoader with = ImageLoader.with(this.itemView.getContext());
        ImageView imageView = this.backgroundImage;
        $jacocoInit[20] = true;
        with.load(icon, imageView);
        $jacocoInit[21] = true;
        this.editorialTitle.setText(title);
        $jacocoInit[22] = true;
        TextView textView = this.editorialViews;
        Context context = this.itemView.getContext();
        $jacocoInit[23] = true;
        String string = context.getString(C1375R.string.editorial_card_short_number_views);
        $jacocoInit[24] = true;
        Object[] objArr = {ViewsFormatter.formatNumberOfViews(numberOfViews)};
        $jacocoInit[25] = true;
        textView.setText(String.format(string, objArr));
        $jacocoInit[26] = true;
        this.curationTypeCaptionText.setText(subTitle);
        $jacocoInit[27] = true;
        this.captionBackgroundPainter.addColorBackgroundToCaption(this.curationTypeCaption, captionColor);
        $jacocoInit[28] = true;
        setupCalendarDateString(date);
        $jacocoInit[29] = true;
        String str = cardId;
        C3933t tVar = r0;
        String str2 = type;
        ImageButton imageButton = this.reactButton;
        HomeBundle homeBundle2 = homeBundle;
        int i = position;
        C3933t tVar2 = new C3933t(this, str, str2, homeBundle2, i);
        imageButton.setOnClickListener(tVar);
        $jacocoInit[30] = true;
        ImageButton imageButton2 = this.reactButton;
        C3915q qVar = new C3915q(this, str, str2, homeBundle2, i);
        imageButton2.setOnLongClickListener(qVar);
        $jacocoInit[31] = true;
        View view = this.editorialCard;
        C3909p pVar = new C3909p(this, str, str2, homeBundle2, i);
        view.setOnClickListener(pVar);
        $jacocoInit[32] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14257a(String cardId, String type, HomeBundle homeBundle, int position, View view) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<HomeEvent> cVar = this.uiEventsListener;
        EditorialHomeEvent editorialHomeEvent = new EditorialHomeEvent(cardId, type, homeBundle, position, Type.REACT_SINGLE_PRESS);
        cVar.onNext(editorialHomeEvent);
        $jacocoInit[75] = true;
    }

    /* renamed from: b */
    public /* synthetic */ boolean mo14258b(String cardId, String type, HomeBundle homeBundle, int position, View view) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<HomeEvent> cVar = this.uiEventsListener;
        EditorialHomeEvent editorialHomeEvent = new EditorialHomeEvent(cardId, type, homeBundle, position, Type.REACT_LONG_PRESS);
        cVar.onNext(editorialHomeEvent);
        $jacocoInit[74] = true;
        return true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo14259c(String cardId, String type, HomeBundle homeBundle, int position, View view) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<HomeEvent> cVar = this.uiEventsListener;
        EditorialHomeEvent editorialHomeEvent = new EditorialHomeEvent(cardId, type, homeBundle, position, Type.EDITORIAL);
        cVar.onNext(editorialHomeEvent);
        $jacocoInit[73] = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setupCalendarDateString(java.lang.String r13) {
        /*
            r12 = this;
            boolean[] r0 = $jacocoInit()
            java.lang.String r1 = " "
            java.lang.String[] r1 = r13.split(r1)
            r2 = 1
            r3 = 33
            r0[r3] = r2
            r3 = 0
            r3 = r1[r3]
            java.lang.String r4 = "-"
            java.lang.String r5 = "/"
            java.lang.String r3 = r3.replace(r4, r5)
            r4 = 34
            r0[r4] = r2
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat
            java.lang.String r5 = "yyyy/MM/dd"
            r4.<init>(r5)
            r5 = 35
            r6 = 0
            r0[r5] = r2     // Catch:{ ParseException -> 0x003a }
            r5 = r6
            java.util.Date r6 = r4.parse(r3)     // Catch:{ ParseException -> 0x0035 }
            r5 = r6
            r6 = 36
            r0[r6] = r2
            goto L_0x0067
        L_0x0035:
            r6 = move-exception
            r11 = r6
            r6 = r5
            r5 = r11
            goto L_0x003b
        L_0x003a:
            r5 = move-exception
        L_0x003b:
            r7 = 37
            r0[r7] = r2
            android.view.View r7 = r12.editorialCard
            android.view.View r8 = r12.itemView
            android.content.Context r8 = r8.getContext()
            r9 = 2131690504(0x7f0f0408, float:1.9010053E38)
            r10 = 38
            r0[r10] = r2
            java.lang.String r8 = r8.getString(r9)
            r9 = -1
            r10 = 39
            r0[r10] = r2
            android.support.design.widget.Snackbar r7 = android.support.design.widget.Snackbar.m1624a(r7, r8, r9)
            r8 = 40
            r0[r8] = r2
            r7.mo4690h()
            r7 = 41
            r0[r7] = r2
            r5 = r6
        L_0x0067:
            if (r5 != 0) goto L_0x006e
            r6 = 42
            r0[r6] = r2
            goto L_0x008c
        L_0x006e:
            r6 = 43
            r0[r6] = r2
            r6 = 3
            java.text.DateFormat r6 = java.text.DateFormat.getDateInstance(r6)
            r7 = 44
            r0[r7] = r2
            java.lang.String r6 = r6.format(r5)
            r7 = 45
            r0[r7] = r2
            android.widget.TextView r7 = r12.editorialDate
            r7.setText(r6)
            r7 = 46
            r0[r7] = r2
        L_0x008c:
            r6 = 47
            r0[r6] = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.home.EditorialBundleViewHolder.setupCalendarDateString(java.lang.String):void");
    }

    private void setReactions(List<TopReaction> reactions, int numberOfReactions, String userReaction) {
        boolean[] $jacocoInit = $jacocoInit();
        setUserReaction(userReaction);
        $jacocoInit[48] = true;
        this.topReactionsPreview.setReactions(reactions, numberOfReactions, this.itemView.getContext());
        $jacocoInit[49] = true;
    }

    public void setEditorialCard(CurationCard curationCard, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        String icon = curationCard.getIcon();
        String title = curationCard.getTitle();
        $jacocoInit[50] = true;
        String subTitle = curationCard.getSubTitle();
        String id = curationCard.getId();
        String views = curationCard.getViews();
        $jacocoInit[51] = true;
        String type = curationCard.getType();
        String date = curationCard.getDate();
        List reactions = curationCard.getReactions();
        $jacocoInit[52] = true;
        int numberOfReactions = curationCard.getNumberOfReactions();
        String userReaction = curationCard.getUserReaction();
        $jacocoInit[53] = true;
        String captionColor = curationCard.getCaptionColor();
        $jacocoInit[54] = true;
        setBundleInformation(icon, title, subTitle, id, views, type, date, position, null, reactions, numberOfReactions, userReaction, captionColor);
        $jacocoInit[55] = true;
    }

    public void showReactions(String cardId, String groupId, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        ReactionsPopup reactionsPopup = new ReactionsPopup(this.itemView.getContext(), this.reactButton);
        $jacocoInit[56] = true;
        reactionsPopup.show();
        $jacocoInit[57] = true;
        String str = cardId;
        String str2 = groupId;
        int i = position;
        ReactionsPopup reactionsPopup2 = reactionsPopup;
        C3921r rVar = new C3921r(this, str, str2, i, reactionsPopup2);
        reactionsPopup.setOnReactionsItemClickListener(rVar);
        $jacocoInit[58] = true;
        C3927s sVar = new C3927s(this, str, str2, i, reactionsPopup2);
        reactionsPopup.setOnDismissListener(sVar);
        $jacocoInit[59] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14255a(String cardId, String groupId, int position, ReactionsPopup reactionsPopup, ReactionType item) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<HomeEvent> cVar = this.uiEventsListener;
        Type type = Type.REACTION;
        $jacocoInit[68] = true;
        ReactionsHomeEvent reactionsHomeEvent = new ReactionsHomeEvent(cardId, groupId, null, position, type, ReactionMapper.mapUserReaction(item));
        $jacocoInit[69] = true;
        cVar.onNext(reactionsHomeEvent);
        $jacocoInit[70] = true;
        reactionsPopup.dismiss();
        $jacocoInit[71] = true;
        reactionsPopup.setOnReactionsItemClickListener(null);
        $jacocoInit[72] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14256a(String cardId, String groupId, int position, ReactionsPopup reactionsPopup, ReactionsView item) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<HomeEvent> cVar = this.uiEventsListener;
        EditorialHomeEvent editorialHomeEvent = new EditorialHomeEvent(cardId, groupId, null, position, Type.POPUP_DISMISS);
        cVar.onNext(editorialHomeEvent);
        $jacocoInit[66] = true;
        reactionsPopup.setOnDismissListener(null);
        $jacocoInit[67] = true;
    }

    private void setUserReaction(String reaction) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.topReactionsPreview.isReactionValid(reaction)) {
            $jacocoInit[60] = true;
            this.reactButton.setImageResource(ReactionMapper.mapReaction(reaction));
            $jacocoInit[61] = true;
        } else {
            this.reactButton.setImageResource(C1375R.drawable.ic_reaction_emoticon);
            $jacocoInit[62] = true;
        }
        $jacocoInit[63] = true;
    }

    private void clearReactions() {
        boolean[] $jacocoInit = $jacocoInit();
        this.reactButton.setImageResource(C1375R.drawable.ic_reaction_emoticon);
        $jacocoInit[64] = true;
        this.topReactionsPreview.clearReactions();
        $jacocoInit[65] = true;
    }
}
