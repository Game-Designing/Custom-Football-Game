package p005cm.aptoide.p006pt.networking.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.bumptech.glide.C5926c;
import com.bumptech.glide.C6029k;
import com.bumptech.glide.C6354n;
import com.bumptech.glide.load.C6060b;
import com.bumptech.glide.load.C6352n;
import com.bumptech.glide.load.engine.C6326q;
import com.bumptech.glide.load.p113c.p114a.C6153g;
import com.bumptech.glide.p103f.C5980b;
import com.bumptech.glide.p103f.C5991g;
import com.bumptech.glide.p103f.p104a.C5973f;
import com.bumptech.glide.p103f.p104a.C5974g;
import com.bumptech.glide.p103f.p104a.C5976i;
import com.bumptech.glide.p103f.p104a.C5977j;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.networking.image.RoundedCornersTransform.CornerType;
import p005cm.aptoide.p006pt.utils.AptoideUtils.IconSizeU;

/* renamed from: cm.aptoide.pt.networking.image.ImageLoader */
public class ImageLoader {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = ImageLoader.class.getName();
    private final Resources resources;
    private final WeakReference<Context> weakContext;
    private final WindowManager windowManager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3111933322184624082L, "cm/aptoide/pt/networking/image/ImageLoader", 220);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[219] = true;
    }

    private ImageLoader(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        this.weakContext = new WeakReference<>(context);
        $jacocoInit[1] = true;
        this.resources = context.getResources();
        $jacocoInit[2] = true;
        this.windowManager = (WindowManager) context.getSystemService("window");
        $jacocoInit[3] = true;
    }

    public static ImageLoader with(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader imageLoader = new ImageLoader(context);
        $jacocoInit[4] = true;
        return imageLoader;
    }

    public static void cancel(Context context, View target) {
        boolean[] $jacocoInit = $jacocoInit();
        C6354n b = C5926c.m10920b(context);
        $jacocoInit[5] = true;
        b.mo19319a(target);
        $jacocoInit[6] = true;
    }

    public static <R> void cancel(Context context, C5980b<R> target) {
        boolean[] $jacocoInit = $jacocoInit();
        C6354n b = C5926c.m10920b(context);
        $jacocoInit[7] = true;
        b.mo19320a((C5976i<?>) target);
        $jacocoInit[8] = true;
    }

    public static <R> void cancel(Context context, C5976i<R> target) {
        boolean[] $jacocoInit = $jacocoInit();
        C6354n b = C5926c.m10920b(context);
        $jacocoInit[9] = true;
        b.mo19320a(target);
        $jacocoInit[10] = true;
    }

    public Bitmap loadBitmap(String uri) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context != null) {
            try {
                $jacocoInit[11] = true;
                $jacocoInit[12] = true;
                C6354n b = C5926c.m10920b(context);
                $jacocoInit[13] = true;
                C6029k a = b.mo19314a();
                $jacocoInit[14] = true;
                a.mo18841a(uri);
                $jacocoInit[15] = true;
                a.mo18838a(getRequestOptions());
                $jacocoInit[16] = true;
                C5980b a2 = a.mo18835a(-1, -1);
                $jacocoInit[17] = true;
                Bitmap bitmap = (Bitmap) a2.get();
                $jacocoInit[18] = true;
                return bitmap;
            } catch (InterruptedException e) {
                $jacocoInit[19] = true;
                e.printStackTrace();
                $jacocoInit[20] = true;
            } catch (ExecutionException e2) {
                $jacocoInit[21] = true;
                e2.printStackTrace();
                $jacocoInit[22] = true;
            }
        } else {
            Log.e(TAG, "::loadBitmap() Context is null");
            $jacocoInit[23] = true;
            $jacocoInit[24] = true;
            return null;
        }
    }

    public C5976i<Drawable> loadWithCircleTransformAndPlaceHolderAvatarSize(String url, ImageView imageView, int placeHolderDrawableId) {
        boolean[] $jacocoInit = $jacocoInit();
        Resources resources2 = this.resources;
        WindowManager windowManager2 = this.windowManager;
        $jacocoInit[25] = true;
        String generateStringAvatar = IconSizeU.generateStringAvatar(url, resources2, windowManager2);
        $jacocoInit[26] = true;
        C5976i<Drawable> loadWithCircleTransformAndPlaceHolder = loadWithCircleTransformAndPlaceHolder(generateStringAvatar, imageView, placeHolderDrawableId);
        $jacocoInit[27] = true;
        return loadWithCircleTransformAndPlaceHolder;
    }

    public C5976i<Drawable> loadWithCircleTransformAndPlaceHolder(String url, ImageView imageView, int placeHolderDrawableId) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context != null) {
            $jacocoInit[28] = true;
            C6354n b = C5926c.m10920b(context);
            $jacocoInit[29] = true;
            C6029k a = b.mo19318a(url);
            $jacocoInit[30] = true;
            C5991g a2 = getRequestOptions().mo18747a((C6352n<Bitmap>) new CircleTransform<Bitmap>());
            $jacocoInit[31] = true;
            C5991g a3 = a2.mo18737a(placeHolderDrawableId);
            $jacocoInit[32] = true;
            a.mo18838a(a3);
            $jacocoInit[33] = true;
            C5977j a4 = a.mo18834a(imageView);
            $jacocoInit[34] = true;
            return a4;
        }
        Log.e(TAG, "::loadWithCircleTransformAndPlaceHolder() Context is null");
        $jacocoInit[35] = true;
        return null;
    }

    public C5976i<Drawable> loadWithCircleTransform(int drawableId, ImageView imageView) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context != null) {
            $jacocoInit[36] = true;
            C6354n b = C5926c.m10920b(context);
            $jacocoInit[37] = true;
            C6029k a = b.mo19317a(Integer.valueOf(drawableId));
            $jacocoInit[38] = true;
            a.mo18838a(getRequestOptions().mo18747a((C6352n<Bitmap>) new CircleTransform<Bitmap>()));
            $jacocoInit[39] = true;
            C5977j a2 = a.mo18834a(imageView);
            $jacocoInit[40] = true;
            return a2;
        }
        Log.e(TAG, "::loadWithShadowCircleTransform() Context is null");
        $jacocoInit[41] = true;
        return null;
    }

    public C5976i<Drawable> loadWithShadowCircleTransform(String url, ImageView imageView) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context != null) {
            $jacocoInit[42] = true;
            C6354n b = C5926c.m10920b(context);
            $jacocoInit[43] = true;
            C6029k a = b.mo19318a(url);
            $jacocoInit[44] = true;
            a.mo18838a(getRequestOptions().mo18747a((C6352n<Bitmap>) new ShadowCircleTransformation<Bitmap>(context, imageView)));
            $jacocoInit[45] = true;
            C5977j a2 = a.mo18834a(imageView);
            $jacocoInit[46] = true;
            return a2;
        }
        Log.e(TAG, "::loadWithShadowCircleTransform() Context is null");
        $jacocoInit[47] = true;
        return null;
    }

    public C5976i<Drawable> loadWithShadowCircleTransformWithPlaceholder(String url, ImageView imageView, int drawable) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context != null) {
            $jacocoInit[48] = true;
            C6354n b = C5926c.m10920b(context);
            $jacocoInit[49] = true;
            C6029k a = b.mo19318a(url);
            $jacocoInit[50] = true;
            C5991g a2 = getRequestOptions().mo18747a((C6352n<Bitmap>) new ShadowCircleTransformation<Bitmap>(context));
            $jacocoInit[51] = true;
            C5991g a3 = a2.mo18737a(drawable);
            $jacocoInit[52] = true;
            a.mo18838a(a3);
            $jacocoInit[53] = true;
            C5977j a4 = a.mo18834a(imageView);
            $jacocoInit[54] = true;
            return a4;
        }
        Log.e(TAG, "::loadWithShadowCircleTransform() Context is null");
        $jacocoInit[55] = true;
        return null;
    }

    public C5976i<Drawable> loadWithShadowCircleTransform(String url, ImageView imageView, int color, float spaceBetween, float strokeSize) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context != null) {
            $jacocoInit[56] = true;
            C6354n b = C5926c.m10920b(context);
            $jacocoInit[57] = true;
            String str = url;
            C6029k a = b.mo19318a(url);
            $jacocoInit[58] = true;
            C5991g requestOptions = getRequestOptions();
            ShadowCircleTransformation shadowCircleTransformation = new ShadowCircleTransformation(context, imageView, color, spaceBetween, strokeSize);
            a.mo18838a(requestOptions.mo18747a((C6352n<Bitmap>) shadowCircleTransformation));
            $jacocoInit[59] = true;
            C5977j a2 = a.mo18834a(imageView);
            $jacocoInit[60] = true;
            return a2;
        }
        String str2 = url;
        ImageView imageView2 = imageView;
        Log.e(TAG, "::loadWithShadowCircleTransform() Context is null");
        $jacocoInit[61] = true;
        return null;
    }

    public C5976i<Drawable> loadWithShadowCircleTransform(int drawableId, ImageView imageView) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context != null) {
            $jacocoInit[62] = true;
            C6354n b = C5926c.m10920b(context);
            $jacocoInit[63] = true;
            C6029k a = b.mo19317a(Integer.valueOf(drawableId));
            $jacocoInit[64] = true;
            a.mo18838a(getRequestOptions().mo18747a((C6352n<Bitmap>) new ShadowCircleTransformation<Bitmap>(context, imageView)));
            $jacocoInit[65] = true;
            C5977j a2 = a.mo18834a(imageView);
            $jacocoInit[66] = true;
            return a2;
        }
        Log.e(TAG, "::loadWithShadowCircleTransform() Context is null");
        $jacocoInit[67] = true;
        return null;
    }

    public C5976i<Drawable> loadWithShadowCircleTransform(String url, ImageView imageView, int shadowColor) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context != null) {
            $jacocoInit[68] = true;
            C6354n b = C5926c.m10920b(context);
            Resources resources2 = this.resources;
            WindowManager windowManager2 = this.windowManager;
            $jacocoInit[69] = true;
            C6029k a = b.mo19318a(IconSizeU.generateSizeStoreString(url, resources2, windowManager2));
            $jacocoInit[70] = true;
            a.mo18838a(getRequestOptions().mo18747a((C6352n<Bitmap>) new ShadowCircleTransformation<Bitmap>(context, (View) imageView, shadowColor)));
            $jacocoInit[71] = true;
            C5977j a2 = a.mo18834a(imageView);
            $jacocoInit[72] = true;
            return a2;
        }
        Log.e(TAG, "::loadWithShadowCircleTransform() Context is null");
        $jacocoInit[73] = true;
        return null;
    }

    public C5976i<Drawable> loadWithShadowCircleTransform(String url, ImageView imageView, float strokeSize) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context != null) {
            $jacocoInit[74] = true;
            C6354n b = C5926c.m10920b(context);
            Resources resources2 = this.resources;
            WindowManager windowManager2 = this.windowManager;
            $jacocoInit[75] = true;
            C6029k a = b.mo19318a(IconSizeU.generateSizeStoreString(url, resources2, windowManager2));
            $jacocoInit[76] = true;
            a.mo18838a(getRequestOptions().mo18747a((C6352n<Bitmap>) new ShadowCircleTransformation<Bitmap>(context, (View) imageView, strokeSize)));
            $jacocoInit[77] = true;
            C5977j a2 = a.mo18834a(imageView);
            $jacocoInit[78] = true;
            return a2;
        }
        Log.e(TAG, "::loadWithShadowCircleTransform() Context is null");
        $jacocoInit[79] = true;
        return null;
    }

    public C5976i<Drawable> loadWithShadowCircleTransformWithPlaceholder(String url, ImageView imageView, float strokeSize, int drawable) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context != null) {
            $jacocoInit[80] = true;
            C6354n b = C5926c.m10920b(context);
            Resources resources2 = this.resources;
            WindowManager windowManager2 = this.windowManager;
            $jacocoInit[81] = true;
            C6029k a = b.mo19318a(IconSizeU.generateSizeStoreString(url, resources2, windowManager2));
            $jacocoInit[82] = true;
            C5991g a2 = getRequestOptions().mo18747a((C6352n<Bitmap>) new ShadowCircleTransformation<Bitmap>(context, (View) imageView, strokeSize));
            $jacocoInit[83] = true;
            C5991g a3 = a2.mo18737a(drawable);
            $jacocoInit[84] = true;
            a.mo18838a(a3);
            $jacocoInit[85] = true;
            C5977j a4 = a.mo18834a(imageView);
            $jacocoInit[86] = true;
            return a4;
        }
        Log.e(TAG, "::loadWithShadowCircleTransform() Context is null");
        $jacocoInit[87] = true;
        return null;
    }

    public C5976i<Drawable> loadWithShadowCircleTransform(int drawableId, ImageView imageView, int shadowColor) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context != null) {
            $jacocoInit[88] = true;
            C6354n b = C5926c.m10920b(context);
            $jacocoInit[89] = true;
            C6029k a = b.mo19317a(Integer.valueOf(drawableId));
            $jacocoInit[90] = true;
            a.mo18838a(getRequestOptions().mo18747a((C6352n<Bitmap>) new ShadowCircleTransformation<Bitmap>(context, (View) imageView, shadowColor)));
            $jacocoInit[91] = true;
            C5977j a2 = a.mo18834a(imageView);
            $jacocoInit[92] = true;
            return a2;
        }
        Log.e(TAG, "::loadWithShadowCircleTransform() Context is null");
        $jacocoInit[93] = true;
        return null;
    }

    public C5973f loadImageToNotification(C5973f notificationTarget, String url) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context != null) {
            $jacocoInit[94] = true;
            C6354n b = C5926c.m10920b(context.getApplicationContext());
            $jacocoInit[95] = true;
            C6029k a = b.mo19314a();
            $jacocoInit[96] = true;
            a.mo18841a(url);
            $jacocoInit[97] = true;
            a.mo18838a(getRequestOptions());
            $jacocoInit[98] = true;
            a.mo18832a(notificationTarget);
            C5973f fVar = notificationTarget;
            $jacocoInit[99] = true;
            return fVar;
        }
        Log.e(TAG, "::loadImageToNotification() Context is null");
        $jacocoInit[100] = true;
        return notificationTarget;
    }

    public C5976i<Drawable> load(int drawableId, ImageView imageView) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context != null) {
            $jacocoInit[101] = true;
            C6354n b = C5926c.m10920b(context);
            $jacocoInit[102] = true;
            C6029k a = b.mo19317a(Integer.valueOf(drawableId));
            $jacocoInit[103] = true;
            a.mo18838a(getRequestOptions());
            $jacocoInit[104] = true;
            C5977j a2 = a.mo18834a(imageView);
            $jacocoInit[105] = true;
            return a2;
        }
        Log.e(TAG, "::load() Context is null");
        $jacocoInit[106] = true;
        return null;
    }

    public C5976i<Drawable> loadScreenshotToThumb(String url, String orientation, int loadingPlaceHolder, ImageView imageView) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context != null) {
            $jacocoInit[107] = true;
            C6354n b = C5926c.m10920b(context);
            WindowManager windowManager2 = this.windowManager;
            Resources resources2 = this.resources;
            $jacocoInit[108] = true;
            String screenshotToThumb = IconSizeU.screenshotToThumb(url, orientation, windowManager2, resources2);
            $jacocoInit[109] = true;
            C6029k a = b.mo19318a(screenshotToThumb);
            $jacocoInit[110] = true;
            a.mo18838a(getRequestOptions().mo18737a(loadingPlaceHolder));
            $jacocoInit[111] = true;
            C5977j a2 = a.mo18834a(imageView);
            $jacocoInit[112] = true;
            return a2;
        }
        Log.e(TAG, "::loadScreenshotToThumb() Context is null");
        $jacocoInit[113] = true;
        return null;
    }

    public C5976i<Drawable> load(String url, int loadingPlaceHolder, ImageView imageView) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context != null) {
            $jacocoInit[114] = true;
            C6354n b = C5926c.m10920b(context);
            $jacocoInit[115] = true;
            C6029k a = b.mo19318a(url);
            $jacocoInit[116] = true;
            a.mo18838a(getRequestOptions().mo18737a(loadingPlaceHolder));
            $jacocoInit[117] = true;
            C5977j a2 = a.mo18834a(imageView);
            $jacocoInit[118] = true;
            return a2;
        }
        Log.e(TAG, "::load() Context is null");
        $jacocoInit[119] = true;
        return null;
    }

    public C5976i<Drawable> load(String url, ImageView imageView) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context != null) {
            $jacocoInit[120] = true;
            String newImageUrl = IconSizeU.getNewImageUrl(url, this.resources, this.windowManager);
            if (newImageUrl != null) {
                $jacocoInit[121] = true;
                Uri uri = Uri.parse(newImageUrl);
                $jacocoInit[122] = true;
                C6354n b = C5926c.m10920b(context);
                $jacocoInit[123] = true;
                C6029k a = b.mo19315a(uri);
                $jacocoInit[124] = true;
                a.mo18838a(getRequestOptions());
                $jacocoInit[125] = true;
                C5977j a2 = a.mo18834a(imageView);
                $jacocoInit[126] = true;
                return a2;
            }
            Log.e(TAG, "newImageUrl is null");
            $jacocoInit[127] = true;
        } else {
            Log.e(TAG, "::load() Context is null");
            $jacocoInit[128] = true;
        }
        $jacocoInit[129] = true;
        return null;
    }

    public C5976i<Drawable> loadWithCenterCrop(String url, ImageView imageView) {
        boolean[] $jacocoInit = $jacocoInit();
        Resources resources2 = this.resources;
        WindowManager windowManager2 = this.windowManager;
        $jacocoInit[130] = true;
        String newImageUrl = IconSizeU.getNewImageUrl(url, resources2, windowManager2);
        $jacocoInit[131] = true;
        C5976i<Drawable> loadWithoutResizeCenterCrop = loadWithoutResizeCenterCrop(newImageUrl, imageView);
        $jacocoInit[132] = true;
        return loadWithoutResizeCenterCrop;
    }

    public C5976i<Drawable> loadWithoutResizeCenterCrop(String url, ImageView imageView) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context != null) {
            $jacocoInit[133] = true;
            C6354n b = C5926c.m10920b(context);
            $jacocoInit[134] = true;
            C6029k a = b.mo19318a(url);
            $jacocoInit[135] = true;
            a.mo18838a(getRequestOptions().mo18751b());
            $jacocoInit[136] = true;
            C5977j a2 = a.mo18834a(imageView);
            $jacocoInit[137] = true;
            return a2;
        }
        Log.e(TAG, "::load() Context is null");
        $jacocoInit[138] = true;
        return null;
    }

    public Drawable load(int drawableId) {
        boolean[] $jacocoInit = $jacocoInit();
        if (drawableId == 0) {
            $jacocoInit[139] = true;
            return null;
        }
        Context context = (Context) this.weakContext.get();
        if (context == null) {
            Log.e(TAG, "::load() Context is null");
            $jacocoInit[145] = true;
            return null;
        } else if (VERSION.SDK_INT >= 21) {
            $jacocoInit[140] = true;
            Resources resources2 = context.getResources();
            $jacocoInit[141] = true;
            Drawable drawable = resources2.getDrawable(drawableId, context.getTheme());
            $jacocoInit[142] = true;
            return drawable;
        } else {
            Resources resources3 = context.getResources();
            $jacocoInit[143] = true;
            Drawable drawable2 = resources3.getDrawable(drawableId);
            $jacocoInit[144] = true;
            return drawable2;
        }
    }

    public Bitmap load(String apkIconPath) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context != null) {
            try {
                $jacocoInit[146] = true;
                $jacocoInit[147] = true;
                C6354n b = C5926c.m10920b(context);
                $jacocoInit[148] = true;
                C6029k a = b.mo19314a();
                $jacocoInit[149] = true;
                a.mo18841a(apkIconPath);
                $jacocoInit[150] = true;
                a.mo18838a(getRequestOptions());
                $jacocoInit[151] = true;
                C5980b a2 = a.mo18835a(-1, -1);
                $jacocoInit[152] = true;
                Bitmap bitmap = (Bitmap) a2.get();
                $jacocoInit[153] = true;
                return bitmap;
            } catch (InterruptedException e) {
                $jacocoInit[154] = true;
                e.printStackTrace();
                $jacocoInit[155] = true;
            } catch (ExecutionException e2) {
                $jacocoInit[156] = true;
                e2.printStackTrace();
                $jacocoInit[157] = true;
            }
        } else {
            Log.e(TAG, "::load() Context is null");
            $jacocoInit[158] = true;
            $jacocoInit[159] = true;
            return null;
        }
    }

    public C5976i<Drawable> loadUsingCircleTransform(int drawableId, ImageView imageView) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context != null) {
            $jacocoInit[160] = true;
            C6354n b = C5926c.m10920b(context);
            $jacocoInit[161] = true;
            C6029k a = b.mo19317a(Integer.valueOf(drawableId));
            $jacocoInit[162] = true;
            a.mo18838a(getRequestOptions().mo18747a((C6352n<Bitmap>) new CircleTransform<Bitmap>()));
            $jacocoInit[163] = true;
            C5977j a2 = a.mo18834a(imageView);
            $jacocoInit[164] = true;
            return a2;
        }
        Log.e(TAG, "::loadUsingCircleTransform() Context is null");
        $jacocoInit[165] = true;
        return null;
    }

    public C5976i<Drawable> loadUsingCircleTransform(String url, ImageView imageView) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context != null) {
            $jacocoInit[166] = true;
            C6354n b = C5926c.m10920b(context);
            $jacocoInit[167] = true;
            C6029k a = b.mo19318a(url);
            $jacocoInit[168] = true;
            a.mo18838a(getRequestOptions().mo18747a((C6352n<Bitmap>) new CircleTransform<Bitmap>()));
            $jacocoInit[169] = true;
            C5977j a2 = a.mo18834a(imageView);
            $jacocoInit[170] = true;
            return a2;
        }
        Log.e(TAG, "::loadUsingCircleTransform() Context is null");
        $jacocoInit[171] = true;
        return null;
    }

    public C5976i<Drawable> loadUsingCircleTransformAndPlaceholder(String url, ImageView imageView, int defaultImagePlaceholder) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context != null) {
            $jacocoInit[172] = true;
            C6354n b = C5926c.m10920b(context);
            $jacocoInit[173] = true;
            C6029k a = b.mo19318a(url);
            $jacocoInit[174] = true;
            C5991g a2 = getRequestOptions().mo18747a((C6352n<Bitmap>) new CircleTransform<Bitmap>());
            $jacocoInit[175] = true;
            C5991g a3 = a2.mo18737a(defaultImagePlaceholder);
            $jacocoInit[176] = true;
            a.mo18838a(a3);
            $jacocoInit[177] = true;
            C5977j a4 = a.mo18834a(imageView);
            $jacocoInit[178] = true;
            return a4;
        }
        Log.e(TAG, "::loadUsingCircleTransformAndPlaceholder() Context is null");
        $jacocoInit[179] = true;
        return null;
    }

    public void loadWithRoundCorners(String image, int radius, int margin, ImageView previewImage) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context == null) {
            $jacocoInit[180] = true;
        } else {
            $jacocoInit[181] = true;
            C6354n b = C5926c.m10920b(context);
            $jacocoInit[182] = true;
            C6029k a = b.mo19318a(image);
            $jacocoInit[183] = true;
            a.mo18838a(getRequestOptions().mo18750a((C6352n<Bitmap>[]) new C6352n[]{new C6153g(), new RoundedCornersTransform(context, radius, margin, CornerType.LEFT)}));
            $jacocoInit[184] = true;
            a.mo18834a(previewImage);
            $jacocoInit[185] = true;
        }
        $jacocoInit[186] = true;
    }

    public void loadWithRoundCorners(String image, int radius, ImageView previewImage, int placeHolderDrawableId) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context == null) {
            $jacocoInit[187] = true;
        } else {
            $jacocoInit[188] = true;
            C6354n b = C5926c.m10920b(context);
            $jacocoInit[189] = true;
            C6029k a = b.mo19318a(image);
            $jacocoInit[190] = true;
            C5991g b2 = getRequestOptions().mo18751b();
            $jacocoInit[191] = true;
            C5991g a2 = b2.mo18737a(placeHolderDrawableId);
            C6352n[] nVarArr = {new C6153g(), new RoundedCornersTransform(context, radius, 0, CornerType.ALL)};
            $jacocoInit[192] = true;
            C5991g a3 = a2.mo18750a((C6352n<Bitmap>[]) nVarArr);
            $jacocoInit[193] = true;
            a.mo18838a(a3);
            $jacocoInit[194] = true;
            a.mo18834a(previewImage);
            $jacocoInit[195] = true;
        }
        $jacocoInit[196] = true;
    }

    public void loadWithRoundCornersWithoutCacheAndPlaceholder(String image, int radius, ImageView previewImage) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context == null) {
            $jacocoInit[197] = true;
        } else {
            $jacocoInit[198] = true;
            C6354n b = C5926c.m10920b(context);
            $jacocoInit[199] = true;
            C6029k a = b.mo19318a(image);
            $jacocoInit[200] = true;
            C5991g b2 = getRequestOptions().mo18751b();
            C6326q qVar = C6326q.f11249b;
            $jacocoInit[201] = true;
            C5991g a2 = b2.mo18744a(qVar);
            C6352n[] nVarArr = {new C6153g(), new RoundedCornersTransform(context, radius, 0, CornerType.ALL)};
            $jacocoInit[202] = true;
            C5991g a3 = a2.mo18750a((C6352n<Bitmap>[]) nVarArr);
            $jacocoInit[203] = true;
            a.mo18838a(a3);
            $jacocoInit[204] = true;
            a.mo18834a(previewImage);
            $jacocoInit[205] = true;
        }
        $jacocoInit[206] = true;
    }

    public void loadIntoTarget(String imageUrl, C5974g<Drawable> simpleTarget) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = (Context) this.weakContext.get();
        if (context == null) {
            $jacocoInit[207] = true;
        } else {
            $jacocoInit[208] = true;
            C6354n b = C5926c.m10920b(context);
            $jacocoInit[209] = true;
            C6029k a = b.mo19318a(imageUrl);
            $jacocoInit[210] = true;
            a.mo18838a(getRequestOptions());
            $jacocoInit[211] = true;
            a.mo18832a(simpleTarget);
            $jacocoInit[212] = true;
        }
        $jacocoInit[213] = true;
    }

    @SuppressLint({"CheckResult"})
    private C5991g getRequestOptions() {
        C6060b decodeFormat;
        boolean[] $jacocoInit = $jacocoInit();
        C5991g requestOptions = new C5991g();
        if (VERSION.SDK_INT >= 26) {
            decodeFormat = C6060b.PREFER_ARGB_8888;
            $jacocoInit[214] = true;
            requestOptions.mo18754c();
            $jacocoInit[215] = true;
        } else {
            decodeFormat = C6060b.PREFER_RGB_565;
            $jacocoInit[216] = true;
        }
        C5991g a = requestOptions.mo18741a(decodeFormat);
        C6326q qVar = C6326q.f11251d;
        $jacocoInit[217] = true;
        C5991g a2 = a.mo18744a(qVar);
        $jacocoInit[218] = true;
        return a2;
    }
}
