package p005cm.aptoide.p006pt.reactions.p078ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.reactions.data.ReactionType;

/* renamed from: cm.aptoide.pt.reactions.ui.ReactionsPopup */
public class ReactionsPopup {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final View anchorView;
    private int gravity = 8388659;
    private OnDismissListener onDismissListener;
    private final PopupWindow popup;
    private OnReactionClickListener reactionClickListener;
    private final ReactionsView reactionsView;

    /* renamed from: cm.aptoide.pt.reactions.ui.ReactionsPopup$OnDismissListener */
    public interface OnDismissListener {
        void onDismiss(ReactionsView reactionsView);
    }

    /* renamed from: cm.aptoide.pt.reactions.ui.ReactionsPopup$OnReactionClickListener */
    public interface OnReactionClickListener {
        void onReactionItemClick(ReactionType reactionType);
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6820434614905368891L, "cm/aptoide/pt/reactions/ui/ReactionsPopup", 37);
        $jacocoData = probes;
        return probes;
    }

    public ReactionsPopup(Context context, View anchor) {
        boolean[] $jacocoInit = $jacocoInit();
        this.anchorView = anchor;
        $jacocoInit[0] = true;
        this.popup = new PopupWindow();
        $jacocoInit[1] = true;
        this.popup.setWindowLayoutMode(-2, -2);
        $jacocoInit[2] = true;
        this.reactionsView = new ReactionsView(context);
        $jacocoInit[3] = true;
        this.reactionsView.setVisibility(0);
        $jacocoInit[4] = true;
        this.popup.setContentView(this.reactionsView);
        $jacocoInit[5] = true;
        this.popup.setFocusable(true);
        $jacocoInit[6] = true;
        this.popup.setClippingEnabled(true);
        $jacocoInit[7] = true;
        PopupWindow popupWindow = this.popup;
        Resources resources = context.getResources();
        $jacocoInit[8] = true;
        Drawable drawable = resources.getDrawable(C1375R.drawable.rounded_corners_white);
        $jacocoInit[9] = true;
        popupWindow.setBackgroundDrawable(drawable);
        if (VERSION.SDK_INT < 21) {
            $jacocoInit[10] = true;
        } else {
            $jacocoInit[11] = true;
            this.popup.setElevation(10.0f);
            $jacocoInit[12] = true;
        }
        this.reactionsView.setCallback(new C4620b(this));
        $jacocoInit[13] = true;
        this.popup.setOnDismissListener(new C4621c(this));
        $jacocoInit[14] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15907a(ReactionType reactionType) {
        boolean[] $jacocoInit = $jacocoInit();
        OnReactionClickListener onReactionClickListener = this.reactionClickListener;
        if (onReactionClickListener == null) {
            $jacocoInit[33] = true;
        } else {
            $jacocoInit[34] = true;
            onReactionClickListener.onReactionItemClick(reactionType);
            $jacocoInit[35] = true;
        }
        $jacocoInit[36] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15906a() {
        boolean[] $jacocoInit = $jacocoInit();
        OnDismissListener onDismissListener2 = this.onDismissListener;
        if (onDismissListener2 == null) {
            $jacocoInit[29] = true;
        } else {
            $jacocoInit[30] = true;
            onDismissListener2.onDismiss(this.reactionsView);
            $jacocoInit[31] = true;
        }
        $jacocoInit[32] = true;
    }

    public void show() {
        boolean[] $jacocoInit = $jacocoInit();
        if (VERSION.SDK_INT >= 19) {
            $jacocoInit[15] = true;
            PopupWindow popupWindow = this.popup;
            View view = this.anchorView;
            int x = (int) view.getX();
            View view2 = this.anchorView;
            $jacocoInit[16] = true;
            int y = (((int) view2.getY()) - this.anchorView.getHeight()) - this.reactionsView.getReactionsViewHeight();
            int i = this.gravity;
            $jacocoInit[17] = true;
            popupWindow.showAsDropDown(view, x, y, i);
            $jacocoInit[18] = true;
        } else {
            PopupWindow popupWindow2 = this.popup;
            View view3 = this.anchorView;
            int x2 = (int) view3.getX();
            int y2 = (int) this.anchorView.getY();
            View view4 = this.anchorView;
            $jacocoInit[19] = true;
            int height = y2 - view4.getHeight();
            ReactionsView reactionsView2 = this.reactionsView;
            $jacocoInit[20] = true;
            int reactionsViewHeight = height - reactionsView2.getReactionsViewHeight();
            $jacocoInit[21] = true;
            popupWindow2.showAsDropDown(view3, x2, reactionsViewHeight);
            $jacocoInit[22] = true;
        }
        $jacocoInit[23] = true;
    }

    public void dismiss() {
        boolean[] $jacocoInit = $jacocoInit();
        this.popup.dismiss();
        $jacocoInit[24] = true;
    }

    public void setOnReactionsItemClickListener(OnReactionClickListener listener) {
        boolean[] $jacocoInit = $jacocoInit();
        this.reactionClickListener = listener;
        $jacocoInit[25] = true;
    }

    public int getGravity() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.gravity;
        $jacocoInit[26] = true;
        return i;
    }

    public void setGravity(int gravity2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.gravity = gravity2;
        $jacocoInit[27] = true;
    }

    public void setOnDismissListener(OnDismissListener listener) {
        boolean[] $jacocoInit = $jacocoInit();
        this.onDismissListener = listener;
        $jacocoInit[28] = true;
    }
}
