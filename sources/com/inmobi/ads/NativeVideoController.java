package com.inmobi.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.utilities.p225b.C10692c;
import com.inmobi.rendering.CustomView;
import java.lang.ref.WeakReference;

@TargetApi(15)
public class NativeVideoController extends FrameLayout {

    /* renamed from: b */
    private static final String f31384b = NativeVideoController.class.getSimpleName();

    /* renamed from: a */
    boolean f31385a;

    /* renamed from: c */
    private C10445bd f31386c;

    /* renamed from: d */
    private C10331a f31387d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public NativeVideoView f31388e;

    /* renamed from: f */
    private CustomView f31389f;

    /* renamed from: g */
    private CustomView f31390g;

    /* renamed from: h */
    private ProgressBar f31391h;

    /* renamed from: i */
    private RelativeLayout f31392i;

    /* renamed from: j */
    private boolean f31393j;

    /* renamed from: k */
    private float f31394k;

    /* renamed from: l */
    private final OnClickListener f31395l;

    /* renamed from: com.inmobi.ads.NativeVideoController$a */
    static final class C10331a extends Handler {

        /* renamed from: a */
        private final WeakReference<NativeVideoController> f31397a;

        C10331a(NativeVideoController nativeVideoController) {
            this.f31397a = new WeakReference<>(nativeVideoController);
        }

        public final void handleMessage(Message message) {
            if (message.what != 2) {
                super.handleMessage(message);
                return;
            }
            NativeVideoController nativeVideoController = (NativeVideoController) this.f31397a.get();
            if (nativeVideoController != null) {
                nativeVideoController.m33709e();
                if (nativeVideoController.f31385a && nativeVideoController.f31388e.isPlaying()) {
                    sendMessageDelayed(obtainMessage(2), 200);
                }
            }
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m33707c(NativeVideoController nativeVideoController) {
        NativeVideoView nativeVideoView = nativeVideoController.f31388e;
        if (nativeVideoView != null) {
            C10449be beVar = (C10449be) nativeVideoView.getTag();
            if (nativeVideoController.f31393j) {
                nativeVideoController.f31388e.mo33888e();
                nativeVideoController.f31393j = false;
                nativeVideoController.f31392i.removeView(nativeVideoController.f31390g);
                nativeVideoController.f31392i.removeView(nativeVideoController.f31389f);
                nativeVideoController.m33706c();
                if (beVar != null) {
                    C10445bd bdVar = nativeVideoController.f31386c;
                    if (bdVar != null) {
                        try {
                            bdVar.mo34152d(beVar);
                            beVar.f31784A = true;
                        } catch (Exception e) {
                            new StringBuilder("SDK encountered unexpected error in handling the onVideoUnMuted event; ").append(e.getMessage());
                            C10621a.m34854a().mo34423a(new C10658a(e));
                        }
                    }
                }
            } else {
                nativeVideoController.f31388e.mo33887d();
                nativeVideoController.f31393j = true;
                nativeVideoController.f31392i.removeView(nativeVideoController.f31389f);
                nativeVideoController.f31392i.removeView(nativeVideoController.f31390g);
                nativeVideoController.m33708d();
                if (beVar != null) {
                    C10445bd bdVar2 = nativeVideoController.f31386c;
                    if (bdVar2 != null) {
                        try {
                            bdVar2.mo34151c(beVar);
                            beVar.f31784A = false;
                        } catch (Exception e2) {
                            new StringBuilder("SDK encountered unexpected error in handling the onVideoMuted event; ").append(e2.getMessage());
                            C10621a.m34854a().mo34423a(new C10658a(e2));
                        }
                    }
                }
            }
        }
    }

    public NativeVideoController(Context context) {
        this(context, null);
    }

    public NativeVideoController(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NativeVideoController(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f31393j = false;
        this.f31395l = new OnClickListener() {
            public final void onClick(View view) {
                NativeVideoController.m33707c(NativeVideoController.this);
            }
        };
        this.f31392i = new RelativeLayout(getContext());
        addView(this.f31392i, new LayoutParams(-1, -1));
        this.f31392i.setPadding(0, 0, 0, 0);
        if (this.f31392i != null) {
            this.f31394k = C10692c.m35104a().f32629c;
            this.f31389f = new CustomView(getContext(), this.f31394k, 9);
            this.f31390g = new CustomView(getContext(), this.f31394k, 11);
            this.f31391h = new ProgressBar(getContext(), null, 16842872);
            this.f31391h.setScaleY(0.8f);
            m33706c();
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.addRule(12, -1);
            float f = C10692c.m35104a().f32629c;
            layoutParams.setMargins(0, (int) (-6.0f * f), 0, (int) (f * -8.0f));
            LayerDrawable layerDrawable = (LayerDrawable) this.f31391h.getProgressDrawable();
            if (layerDrawable != null) {
                layerDrawable.getDrawable(0).setColorFilter(-1, Mode.SRC_IN);
                layerDrawable.getDrawable(2).setColorFilter(-327674, Mode.SRC_IN);
            }
            this.f31392i.addView(this.f31391h, layoutParams);
        }
        this.f31387d = new C10331a(this);
    }

    public void setMediaPlayer(NativeVideoView nativeVideoView) {
        this.f31388e = nativeVideoView;
        C10449be beVar = (C10449be) this.f31388e.getTag();
        if (beVar != null && beVar.f31785B && !beVar.mo34157a()) {
            this.f31393j = true;
            this.f31392i.removeView(this.f31390g);
            this.f31392i.removeView(this.f31389f);
            m33708d();
        }
    }

    /* renamed from: c */
    private void m33706c() {
        float f = this.f31394k;
        LayoutParams layoutParams = new LayoutParams((int) (f * 30.0f), (int) (f * 30.0f));
        layoutParams.addRule(9, -1);
        layoutParams.addRule(12, -1);
        this.f31392i.addView(this.f31389f, layoutParams);
        this.f31389f.setOnClickListener(this.f31395l);
    }

    /* renamed from: d */
    private void m33708d() {
        float f = this.f31394k;
        LayoutParams layoutParams = new LayoutParams((int) (f * 30.0f), (int) (f * 30.0f));
        layoutParams.addRule(9, -1);
        layoutParams.addRule(12, -1);
        this.f31392i.addView(this.f31390g, layoutParams);
        this.f31390g.setOnClickListener(this.f31395l);
    }

    /* renamed from: a */
    public final void mo33869a() {
        if (!this.f31385a) {
            m33709e();
            this.f31385a = true;
            C10449be beVar = (C10449be) this.f31388e.getTag();
            if (beVar != null) {
                int i = 4;
                this.f31389f.setVisibility(beVar.f31785B ? 0 : 4);
                ProgressBar progressBar = this.f31391h;
                if (beVar.f31787D) {
                    i = 0;
                }
                progressBar.setVisibility(i);
            }
            setVisibility(0);
        }
        this.f31387d.sendEmptyMessage(2);
    }

    /* renamed from: b */
    public final void mo33870b() {
        if (this.f31385a) {
            try {
                this.f31387d.removeMessages(2);
                setVisibility(8);
            } catch (IllegalArgumentException e) {
                C10621a.m34854a().mo34423a(new C10658a(e));
            }
            this.f31385a = false;
        }
    }

    /* access modifiers changed from: private */
    @TargetApi(15)
    /* renamed from: e */
    public int m33709e() {
        NativeVideoView nativeVideoView = this.f31388e;
        if (nativeVideoView == null) {
            return 0;
        }
        int currentPosition = nativeVideoView.getCurrentPosition();
        int duration = this.f31388e.getDuration();
        ProgressBar progressBar = this.f31391h;
        if (!(progressBar == null || duration == 0)) {
            progressBar.setProgress((currentPosition * 100) / duration);
        }
        return currentPosition;
    }

    @TargetApi(15)
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (VERSION.SDK_INT >= 15) {
            NativeVideoView nativeVideoView = this.f31388e;
            if (nativeVideoView != null && nativeVideoView.mo33882b()) {
                if (this.f31385a) {
                    mo33870b();
                } else {
                    mo33869a();
                }
            }
        }
        return false;
    }

    @TargetApi(15)
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        boolean z = keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == 0;
        if (VERSION.SDK_INT >= 15) {
            if (keyCode == 79 || keyCode == 85 || keyCode == 62) {
                if (z) {
                    if (this.f31388e.isPlaying()) {
                        this.f31388e.pause();
                    } else {
                        this.f31388e.start();
                    }
                    mo33869a();
                }
                return true;
            } else if (keyCode == 126) {
                if (z && !this.f31388e.isPlaying()) {
                    this.f31388e.start();
                    mo33869a();
                }
                return true;
            } else if (keyCode == 86 || keyCode == 127) {
                if (z && this.f31388e.isPlaying()) {
                    this.f31388e.pause();
                    mo33869a();
                }
                return true;
            } else if (keyCode == 25 || keyCode == 24 || keyCode == 164 || keyCode == 27) {
                return super.dispatchKeyEvent(keyEvent);
            } else {
                mo33869a();
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(NativeVideoController.class.getName());
    }

    @TargetApi(15)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (VERSION.SDK_INT >= 15) {
            accessibilityNodeInfo.setClassName(NativeVideoController.class.getName());
        }
    }

    public void setVideoAd(C10445bd bdVar) {
        this.f31386c = bdVar;
    }
}
