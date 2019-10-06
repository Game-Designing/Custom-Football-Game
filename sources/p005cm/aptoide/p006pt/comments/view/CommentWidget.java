package p005cm.aptoide.p006pt.comments.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.design.widget.Snackbar;
import android.support.p000v4.app.C0014p;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Date;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.comments.ComplexComment;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Comment;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Comment.User;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.utils.AptoideUtils.DateTimeU;
import p005cm.aptoide.p006pt.utils.AptoideUtils.ScreenU;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p029i.C0136c;

/* renamed from: cm.aptoide.pt.comments.view.CommentWidget */
public class CommentWidget extends Widget<CommentDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int MARGIN_IN_DIP = 15;
    private static final String TAG = CommentWidget.class.getName();
    private TextView comment;
    private TextView datePos1;
    private TextView datePos2;
    private View outerLayout;
    private View replyLayout;
    private ImageView userAvatar;
    private TextView userName;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6289346555421970897L, "cm/aptoide/pt/comments/view/CommentWidget", 73);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((CommentDisplayable) displayable, i);
        $jacocoInit[60] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[72] = true;
    }

    public CommentWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.userAvatar = (ImageView) itemView.findViewById(C1375R.C1376id.user_icon);
        $jacocoInit[1] = true;
        this.outerLayout = itemView.findViewById(C1375R.C1376id.outer_layout);
        $jacocoInit[2] = true;
        this.userName = (TextView) itemView.findViewById(C1375R.C1376id.user_name);
        $jacocoInit[3] = true;
        this.datePos1 = (TextView) itemView.findViewById(C1375R.C1376id.added_date_pos1);
        $jacocoInit[4] = true;
        this.datePos2 = (TextView) itemView.findViewById(C1375R.C1376id.added_date_pos2);
        $jacocoInit[5] = true;
        this.comment = (TextView) itemView.findViewById(C1375R.C1376id.comment);
        $jacocoInit[6] = true;
        this.replyLayout = itemView.findViewById(C1375R.C1376id.reply_layout);
        $jacocoInit[7] = true;
    }

    public void bindView(CommentDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        Comment comment2 = displayable.getComment();
        $jacocoInit[8] = true;
        C0014p context = getContext();
        $jacocoInit[9] = true;
        ImageLoader with = ImageLoader.with(context);
        $jacocoInit[10] = true;
        User user = comment2.getUser();
        $jacocoInit[11] = true;
        String avatar = user.getAvatar();
        ImageView imageView = this.userAvatar;
        $jacocoInit[12] = true;
        with.loadWithCircleTransformAndPlaceHolderAvatarSize(avatar, imageView, C1375R.drawable.layer_1);
        $jacocoInit[13] = true;
        TextView textView = this.userName;
        User user2 = comment2.getUser();
        $jacocoInit[14] = true;
        String name = user2.getName();
        $jacocoInit[15] = true;
        textView.setText(name);
        $jacocoInit[16] = true;
        DateTimeU instance = DateTimeU.getInstance(getContext());
        $jacocoInit[17] = true;
        Date added = comment2.getAdded();
        $jacocoInit[18] = true;
        long time = added.getTime();
        Resources resources = getContext().getResources();
        $jacocoInit[19] = true;
        String date = instance.getTimeDiffString((Context) context, time, resources);
        $jacocoInit[20] = true;
        this.datePos1.setText(date);
        $jacocoInit[21] = true;
        this.datePos2.setText(date);
        $jacocoInit[22] = true;
        this.comment.setText(comment2.getBody());
        $jacocoInit[23] = true;
        if (ComplexComment.class.isAssignableFrom(comment2.getClass())) {
            $jacocoInit[24] = true;
            this.datePos2.setVisibility(0);
            $jacocoInit[25] = true;
            bindComplexComment((ComplexComment) comment2);
            $jacocoInit[26] = true;
        } else {
            this.datePos1.setVisibility(0);
            $jacocoInit[27] = true;
        }
        C0136c cVar = this.compositeSubscription;
        C0120S a = C13034a.m42490a(this.itemView);
        C2713w wVar = new C2713w(this, displayable);
        $jacocoInit[28] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) wVar);
        C2654B b2 = C2654B.f5818a;
        C2712v vVar = C2712v.f5912a;
        $jacocoInit[29] = true;
        C0137ja a2 = b.mo3626a((C0129b<? super T>) b2, (C0129b<Throwable>) vVar);
        $jacocoInit[30] = true;
        cVar.mo3713a(a2);
        $jacocoInit[31] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11599a(CommentDisplayable displayable, Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        displayable.itemClicked(this.itemView);
        $jacocoInit[71] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m7341a(Void __) {
        $jacocoInit()[70] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m7342b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[68] = true;
        instance.log(throwable);
        $jacocoInit[69] = true;
    }

    private void bindComplexComment(ComplexComment comment2) {
        int bgColor;
        int color;
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[32] = true;
        ComplexComment complexComment = comment2;
        if (complexComment.getLevel() == 1) {
            bgColor = C1375R.color.white;
            $jacocoInit[33] = true;
        } else {
            bgColor = C1375R.color.comment_gray;
            $jacocoInit[34] = true;
        }
        $jacocoInit[35] = true;
        C0014p context = getContext();
        if (VERSION.SDK_INT >= 23) {
            $jacocoInit[36] = true;
            color = context.getColor(bgColor);
            $jacocoInit[37] = true;
        } else {
            Resources resources = context.getResources();
            $jacocoInit[38] = true;
            color = resources.getColor(bgColor);
            $jacocoInit[39] = true;
        }
        this.outerLayout.setBackgroundColor(color);
        $jacocoInit[40] = true;
        setLayoutLeftPadding(complexComment);
        $jacocoInit[41] = true;
        if (complexComment.getLevel() == 1) {
            $jacocoInit[42] = true;
            this.replyLayout.setVisibility(0);
            $jacocoInit[43] = true;
            C0136c cVar = this.compositeSubscription;
            C0120S a = C13034a.m42490a(this.replyLayout);
            C2714x xVar = new C2714x(this, complexComment);
            $jacocoInit[44] = true;
            C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) xVar);
            $jacocoInit[45] = true;
            C0120S g = f.mo3662g();
            C2653A a2 = C2653A.f5817a;
            C2715y yVar = C2715y.f5917a;
            $jacocoInit[46] = true;
            C0137ja a3 = g.mo3626a((C0129b<? super T>) a2, (C0129b<Throwable>) yVar);
            $jacocoInit[47] = true;
            cVar.mo3713a(a3);
            $jacocoInit[48] = true;
        } else {
            this.replyLayout.setVisibility(8);
            $jacocoInit[49] = true;
            this.userAvatar.setScaleX(0.7f);
            $jacocoInit[50] = true;
            this.userAvatar.setScaleY(0.7f);
            $jacocoInit[51] = true;
        }
        $jacocoInit[52] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo11598a(ComplexComment complexComment, Void aVoid) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M observeReplySubmission = complexComment.observeReplySubmission();
        C2716z zVar = new C2716z(this);
        $jacocoInit[64] = true;
        C0117M a = observeReplySubmission.mo3583a((C0129b<? super Throwable>) zVar);
        $jacocoInit[65] = true;
        C0120S f = a.mo3604f();
        $jacocoInit[66] = true;
        return f;
    }

    /* renamed from: c */
    public /* synthetic */ void mo11601c(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        Snackbar.m1623a((View) this.userAvatar, (int) C1375R.string.error_occured, -1);
        $jacocoInit[67] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m7339a(Object aVoid) {
        $jacocoInit()[63] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m7340a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[61] = true;
        instance.log(err);
        $jacocoInit[62] = true;
    }

    private void setLayoutLeftPadding(ComplexComment complexComment) {
        int leftMargin;
        boolean[] $jacocoInit = $jacocoInit();
        int level = complexComment.getLevel();
        $jacocoInit[53] = true;
        int baseMargin = ScreenU.getPixelsForDip(15, getContext().getResources());
        if (level < 2) {
            $jacocoInit[54] = true;
            leftMargin = baseMargin;
        } else {
            leftMargin = baseMargin * level;
            $jacocoInit[55] = true;
        }
        $jacocoInit[56] = true;
        View view = this.outerLayout;
        int paddingTop = view.getPaddingTop();
        View view2 = this.outerLayout;
        $jacocoInit[57] = true;
        int paddingBottom = view2.getPaddingBottom();
        $jacocoInit[58] = true;
        view.setPadding(leftMargin, paddingTop, baseMargin, paddingBottom);
        $jacocoInit[59] = true;
    }
}
