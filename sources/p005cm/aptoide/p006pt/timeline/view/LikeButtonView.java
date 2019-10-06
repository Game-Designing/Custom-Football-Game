package p005cm.aptoide.p006pt.timeline.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.custom.CircleView;
import p005cm.aptoide.p006pt.view.custom.DotsView;

/* renamed from: cm.aptoide.pt.timeline.view.LikeButtonView */
public class LikeButtonView extends FrameLayout {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final AccelerateDecelerateInterpolator ACCELERATE_DECELERATE_INTERPOLATOR = new AccelerateDecelerateInterpolator();
    private static final DecelerateInterpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
    private static final OvershootInterpolator OVERSHOOT_INTERPOLATOR = new OvershootInterpolator(4.0f);
    private AnimatorSet animatorSet;
    private boolean iconEnabled;
    private CircleView vCircle;
    private DotsView vDotsView;
    private ImageView vHeart;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4968819628394415999L, "cm/aptoide/pt/timeline/view/LikeButtonView", 72);
        $jacocoData = probes;
        return probes;
    }

    static /* synthetic */ CircleView access$000(LikeButtonView x0) {
        boolean[] $jacocoInit = $jacocoInit();
        CircleView circleView = x0.vCircle;
        $jacocoInit[66] = true;
        return circleView;
    }

    static /* synthetic */ DotsView access$100(LikeButtonView x0) {
        boolean[] $jacocoInit = $jacocoInit();
        DotsView dotsView = x0.vDotsView;
        $jacocoInit[67] = true;
        return dotsView;
    }

    static /* synthetic */ ImageView access$200(LikeButtonView x0) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageView imageView = x0.vHeart;
        $jacocoInit[68] = true;
        return imageView;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[69] = true;
        $jacocoInit[70] = true;
        $jacocoInit[71] = true;
    }

    public LikeButtonView(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context);
        $jacocoInit[0] = true;
        init();
        $jacocoInit[1] = true;
    }

    public LikeButtonView(Context context, AttributeSet attrs) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context, attrs);
        $jacocoInit[2] = true;
        init();
        $jacocoInit[3] = true;
    }

    public LikeButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context, attrs, defStyleAttr);
        $jacocoInit[4] = true;
        init();
        $jacocoInit[5] = true;
    }

    @TargetApi(21)
    public LikeButtonView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context, attrs, defStyleAttr, defStyleRes);
        $jacocoInit[6] = true;
        init();
        $jacocoInit[7] = true;
    }

    private void init() {
        boolean[] $jacocoInit = $jacocoInit();
        LayoutInflater from = LayoutInflater.from(getContext());
        $jacocoInit[8] = true;
        from.inflate(C1375R.layout.view_like_button, this, true);
        $jacocoInit[9] = true;
        this.vHeart = (ImageView) findViewById(C1375R.C1376id.vHeart);
        $jacocoInit[10] = true;
        this.vDotsView = (DotsView) findViewById(C1375R.C1376id.vDotsView);
        $jacocoInit[11] = true;
        this.vCircle = (CircleView) findViewById(C1375R.C1376id.vCircle);
        this.iconEnabled = false;
        $jacocoInit[12] = true;
        setupAnimation();
        $jacocoInit[13] = true;
    }

    public void setHeartState(boolean iconEnabled2) {
        boolean[] $jacocoInit = $jacocoInit();
        AnimatorSet animatorSet2 = this.animatorSet;
        if (animatorSet2 == null) {
            $jacocoInit[14] = true;
        } else if (!animatorSet2.isRunning()) {
            $jacocoInit[15] = true;
        } else {
            $jacocoInit[16] = true;
            this.animatorSet.cancel();
            $jacocoInit[17] = true;
        }
        if (iconEnabled2) {
            $jacocoInit[18] = true;
            setHeartIconOnWithAnimation();
            $jacocoInit[19] = true;
        } else {
            setHeartOffWithoutAnimation();
            $jacocoInit[20] = true;
        }
        this.iconEnabled = iconEnabled2;
        $jacocoInit[21] = true;
    }

    public void setHeartStateWithoutAnimation(boolean iconEnabled2) {
        boolean[] $jacocoInit = $jacocoInit();
        AnimatorSet animatorSet2 = this.animatorSet;
        if (animatorSet2 == null) {
            $jacocoInit[22] = true;
        } else if (!animatorSet2.isRunning()) {
            $jacocoInit[23] = true;
        } else {
            $jacocoInit[24] = true;
            this.animatorSet.cancel();
            $jacocoInit[25] = true;
        }
        if (iconEnabled2) {
            $jacocoInit[26] = true;
            setHeartIconOnWithoutAnimation();
            $jacocoInit[27] = true;
        } else {
            setHeartOffWithoutAnimation();
            $jacocoInit[28] = true;
        }
        this.iconEnabled = iconEnabled2;
        $jacocoInit[29] = true;
    }

    public boolean isIconEnabled() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.iconEnabled;
        $jacocoInit[30] = true;
        return z;
    }

    private void setHeartOffWithoutAnimation() {
        boolean[] $jacocoInit = $jacocoInit();
        this.vHeart.setImageResource(C1375R.drawable.heart_off);
        $jacocoInit[31] = true;
        this.vHeart.invalidate();
        $jacocoInit[32] = true;
    }

    private void setHeartIconOnWithoutAnimation() {
        boolean[] $jacocoInit = $jacocoInit();
        this.vHeart.setImageResource(C1375R.drawable.heart_on);
        $jacocoInit[33] = true;
        this.vHeart.invalidate();
        $jacocoInit[34] = true;
    }

    private void setHeartIconOnWithAnimation() {
        boolean[] $jacocoInit = $jacocoInit();
        this.vHeart.setImageResource(C1375R.drawable.heart_on);
        $jacocoInit[35] = true;
        ViewPropertyAnimator animate = this.vHeart.animate();
        $jacocoInit[36] = true;
        animate.cancel();
        $jacocoInit[37] = true;
        this.vHeart.setScaleX(0.0f);
        $jacocoInit[38] = true;
        this.vHeart.setScaleY(0.0f);
        $jacocoInit[39] = true;
        this.vCircle.setInnerCircleRadiusProgress(0.0f);
        $jacocoInit[40] = true;
        this.vCircle.setOuterCircleRadiusProgress(0.0f);
        $jacocoInit[41] = true;
        this.vDotsView.setCurrentProgress(0.0f);
        $jacocoInit[42] = true;
        this.animatorSet.start();
        $jacocoInit[43] = true;
    }

    private void setupAnimation() {
        boolean[] $jacocoInit = $jacocoInit();
        this.animatorSet = new AnimatorSet();
        CircleView circleView = this.vCircle;
        Property<CircleView, Float> property = CircleView.OUTER_CIRCLE_RADIUS_PROGRESS;
        float[] fArr = {0.1f, 1.0f};
        $jacocoInit[44] = true;
        ObjectAnimator outerCircleAnimator = ObjectAnimator.ofFloat(circleView, property, fArr);
        $jacocoInit[45] = true;
        outerCircleAnimator.setDuration(250);
        $jacocoInit[46] = true;
        outerCircleAnimator.setInterpolator(DECELERATE_INTERPOLATOR);
        CircleView circleView2 = this.vCircle;
        Property<CircleView, Float> property2 = CircleView.INNER_CIRCLE_RADIUS_PROGRESS;
        float[] fArr2 = {0.1f, 1.0f};
        $jacocoInit[47] = true;
        ObjectAnimator innerCircleAnimator = ObjectAnimator.ofFloat(circleView2, property2, fArr2);
        $jacocoInit[48] = true;
        innerCircleAnimator.setDuration(200);
        $jacocoInit[49] = true;
        innerCircleAnimator.setStartDelay(200);
        $jacocoInit[50] = true;
        innerCircleAnimator.setInterpolator(DECELERATE_INTERPOLATOR);
        $jacocoInit[51] = true;
        ObjectAnimator starScaleYAnimator = ObjectAnimator.ofFloat(this.vHeart, ImageView.SCALE_Y, new float[]{0.2f, 1.0f});
        $jacocoInit[52] = true;
        starScaleYAnimator.setDuration(350);
        $jacocoInit[53] = true;
        starScaleYAnimator.setStartDelay(250);
        $jacocoInit[54] = true;
        starScaleYAnimator.setInterpolator(OVERSHOOT_INTERPOLATOR);
        $jacocoInit[55] = true;
        ObjectAnimator starScaleXAnimator = ObjectAnimator.ofFloat(this.vHeart, ImageView.SCALE_X, new float[]{0.2f, 1.0f});
        $jacocoInit[56] = true;
        starScaleXAnimator.setDuration(350);
        $jacocoInit[57] = true;
        starScaleXAnimator.setStartDelay(250);
        $jacocoInit[58] = true;
        starScaleXAnimator.setInterpolator(OVERSHOOT_INTERPOLATOR);
        $jacocoInit[59] = true;
        ObjectAnimator dotsAnimator = ObjectAnimator.ofFloat(this.vDotsView, DotsView.DOTS_PROGRESS, new float[]{0.0f, 1.0f});
        $jacocoInit[60] = true;
        dotsAnimator.setDuration(900);
        $jacocoInit[61] = true;
        dotsAnimator.setStartDelay(50);
        $jacocoInit[62] = true;
        dotsAnimator.setInterpolator(ACCELERATE_DECELERATE_INTERPOLATOR);
        $jacocoInit[63] = true;
        this.animatorSet.playTogether(new Animator[]{outerCircleAnimator, innerCircleAnimator, starScaleYAnimator, starScaleXAnimator, dotsAnimator});
        $jacocoInit[64] = true;
        this.animatorSet.addListener(new AnimatorListenerAdapter(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ LikeButtonView this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(6528279088151242476L, "cm/aptoide/pt/timeline/view/LikeButtonView$1", 6);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void onAnimationCancel(Animator animation) {
                boolean[] $jacocoInit = $jacocoInit();
                LikeButtonView.access$000(this.this$0).setInnerCircleRadiusProgress(0.0f);
                $jacocoInit[1] = true;
                LikeButtonView.access$000(this.this$0).setOuterCircleRadiusProgress(0.0f);
                $jacocoInit[2] = true;
                LikeButtonView.access$100(this.this$0).setCurrentProgress(50.0f);
                $jacocoInit[3] = true;
                LikeButtonView.access$200(this.this$0).setScaleX(1.0f);
                $jacocoInit[4] = true;
                LikeButtonView.access$200(this.this$0).setScaleY(1.0f);
                $jacocoInit[5] = true;
            }
        });
        $jacocoInit[65] = true;
    }
}
