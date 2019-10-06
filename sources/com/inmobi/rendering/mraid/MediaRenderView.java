package com.inmobi.rendering.mraid;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p001v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import com.inmobi.commons.p217a.C10619a;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@SuppressLint({"ViewConstructor"})
public final class MediaRenderView extends VideoView implements ActivityLifecycleCallbacks, OnCompletionListener, OnErrorListener, OnPreparedListener {
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static final String f32893l = MediaRenderView.class.getSimpleName();

    /* renamed from: a */
    public CustomMediaController f32894a;

    /* renamed from: b */
    public Bitmap f32895b;

    /* renamed from: c */
    public ViewGroup f32896c;

    /* renamed from: d */
    public C10772a f32897d;

    /* renamed from: e */
    int f32898e;

    /* renamed from: f */
    boolean f32899f;

    /* renamed from: g */
    public String f32900g;

    /* renamed from: h */
    public String f32901h;

    /* renamed from: i */
    boolean f32902i;

    /* renamed from: j */
    int f32903j;

    /* renamed from: k */
    int f32904k;

    /* renamed from: m */
    private boolean f32905m = false;

    /* renamed from: n */
    private MediaPlayer f32906n;

    /* renamed from: o */
    private WeakReference<Activity> f32907o;

    static class CustomMediaController extends MediaController {
        public CustomMediaController(Context context) {
            super(context);
        }

        public final void show(int i) {
            super.show(i);
            if (VERSION.SDK_INT < 19) {
                try {
                    Field declaredField = MediaController.class.getDeclaredField("mAnchor");
                    declaredField.setAccessible(true);
                    View view = (View) declaredField.get(this);
                    Field declaredField2 = MediaController.class.getDeclaredField("mDecor");
                    declaredField2.setAccessible(true);
                    View view2 = (View) declaredField2.get(this);
                    Field declaredField3 = MediaController.class.getDeclaredField("mDecorLayoutParams");
                    declaredField3.setAccessible(true);
                    LayoutParams layoutParams = (LayoutParams) declaredField3.get(this);
                    Field declaredField4 = MediaController.class.getDeclaredField("mWindowManager");
                    declaredField4.setAccessible(true);
                    WindowManager windowManager = (WindowManager) declaredField4.get(this);
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    view2.measure(MeasureSpec.makeMeasureSpec(view.getWidth(), LinearLayoutManager.INVALID_OFFSET), MeasureSpec.makeMeasureSpec(view.getHeight(), LinearLayoutManager.INVALID_OFFSET));
                    view2.setPadding(0, 0, 0, 0);
                    layoutParams.verticalMargin = 0.0f;
                    layoutParams.horizontalMargin = 0.0f;
                    layoutParams.width = view.getWidth();
                    layoutParams.gravity = 8388659;
                    layoutParams.x = iArr[0];
                    layoutParams.y = (iArr[1] + view.getHeight()) - view2.getMeasuredHeight();
                    windowManager.updateViewLayout(view2, layoutParams);
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: com.inmobi.rendering.mraid.MediaRenderView$a */
    interface C10772a {
        /* renamed from: a */
        void mo34774a();

        /* renamed from: a */
        void mo34775a(MediaRenderView mediaRenderView);
    }

    public MediaRenderView(Activity activity) {
        super(activity);
        setZOrderOnTop(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (VERSION.SDK_INT < 28) {
            setDrawingCacheEnabled(true);
        }
        this.f32898e = 100;
        this.f32903j = -1;
        this.f32904k = 0;
        this.f32899f = false;
        this.f32907o = new WeakReference<>(activity);
        C10619a.m34833a((Context) activity, (ActivityLifecycleCallbacks) this);
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        StringBuilder sb = new StringBuilder(">>> onWindowVisibilityChanged (");
        sb.append(i);
        sb.append(")");
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        getHolder().setSizeFromLayout();
    }

    /* access modifiers changed from: protected */
    @TargetApi(16)
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        StringBuilder sb = new StringBuilder(">>> onVisibilityChanged (");
        sb.append(i);
        sb.append(")");
        if (i == 0) {
            if (VERSION.SDK_INT >= 16) {
                Context b = C10619a.m34839b();
                if (b != null) {
                    setBackground(new BitmapDrawable(b.getResources(), this.f32895b));
                }
                return;
            }
            setBackgroundDrawable(new BitmapDrawable(this.f32895b));
        }
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb = new StringBuilder(">>> onError (");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(")");
        mo34752a();
        return false;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        this.f32906n = mediaPlayer;
        mediaPlayer.setOnVideoSizeChangedListener(new OnVideoSizeChangedListener() {
            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                MediaRenderView.f32893l;
                if (MediaRenderView.this.f32894a == null) {
                    MediaRenderView mediaRenderView = MediaRenderView.this;
                    mediaRenderView.f32894a = new CustomMediaController(mediaRenderView.getContext());
                    MediaRenderView.this.f32894a.setAnchorView(MediaRenderView.this);
                    MediaRenderView mediaRenderView2 = MediaRenderView.this;
                    mediaRenderView2.setMediaController(mediaRenderView2.f32894a);
                    MediaRenderView.this.requestLayout();
                    MediaRenderView.this.requestFocus();
                }
            }
        });
        int i = this.f32904k;
        if (i < getDuration()) {
            this.f32904k = i;
            seekTo(i);
        }
        this.f32902i = true;
        this.f32897d.mo34774a();
        start();
    }

    public final void setPlaybackData(String str) {
        this.f32901h = m35325a(str);
        this.f32900g = "anonymous";
        if (this.f32895b == null) {
            this.f32895b = Bitmap.createBitmap(24, 24, Config.ARGB_8888);
            this.f32895b = m35326b(this.f32901h);
        }
    }

    public final void start() {
        if (!this.f32905m) {
            super.start();
        }
    }

    public final void pause() {
        super.pause();
    }

    /* renamed from: a */
    public final void mo34752a() {
        stopPlayback();
        ViewGroup viewGroup = this.f32896c;
        if (viewGroup != null) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.f32896c);
            }
            ViewGroup viewGroup3 = (ViewGroup) getParent();
            if (viewGroup3 != null) {
                viewGroup3.removeView(this);
            }
            setBackgroundColor(0);
            this.f32896c = null;
        }
        super.setMediaController(null);
        this.f32894a = null;
        C10772a aVar = this.f32897d;
        if (aVar != null) {
            aVar.mo34775a(this);
        }
    }

    public final ViewGroup getViewContainer() {
        return this.f32896c;
    }

    public final void setViewContainer(ViewGroup viewGroup) {
        this.f32896c = viewGroup;
    }

    public final void setListener(C10772a aVar) {
        this.f32897d = aVar;
    }

    /* renamed from: a */
    public static String m35325a(String str) {
        byte[] bytes = str.getBytes();
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            if ((b & 128) > 0) {
                sb.append("%");
                char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
                sb.append(new String(new char[]{cArr[(b >> 4) & 15], cArr[b & 15]}));
            } else {
                sb.append((char) b);
            }
        }
        try {
            return new String(sb.toString().getBytes(), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    /* renamed from: b */
    public static Bitmap m35326b(String str) {
        try {
            return (Bitmap) Class.forName("android.media.ThumbnailUtils").getDeclaredMethod("createVideoThumbnail", new Class[]{String.class, Integer.TYPE}).invoke(null, new Object[]{str, Integer.valueOf(1)});
        } catch (ClassNotFoundException e) {
            return null;
        } catch (InvocationTargetException e2) {
            return null;
        } catch (NoSuchMethodException e3) {
            return null;
        } catch (IllegalAccessException e4) {
            return null;
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        if (this.f32907o.get() != null && ((Activity) this.f32907o.get()).equals(activity)) {
            this.f32905m = false;
            start();
        }
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
        Activity activity2 = (Activity) this.f32907o.get();
        if (activity2 != null && activity2.equals(activity)) {
            this.f32905m = true;
            if (getCurrentPosition() != 0) {
                this.f32904k = getCurrentPosition();
            }
            pause();
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        activity.getApplication().unregisterActivityLifecycleCallbacks(this);
    }
}
