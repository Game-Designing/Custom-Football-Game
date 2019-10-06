package com.airbnb.lottie.p088b;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable.Callback;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.C5715b;
import com.airbnb.lottie.C5853y;
import com.airbnb.lottie.LottieImageAsset;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.airbnb.lottie.b.b */
/* compiled from: ImageAssetManager */
public class C5717b {

    /* renamed from: a */
    private static final Object f9814a = new Object();

    /* renamed from: b */
    private final Context f9815b;

    /* renamed from: c */
    private String f9816c;

    /* renamed from: d */
    private C5715b f9817d;

    /* renamed from: e */
    private final Map<String, C5853y> f9818e;

    public C5717b(Callback callback, String imagesFolder, C5715b delegate, Map<String, C5853y> imageAssets) {
        this.f9816c = imagesFolder;
        if (!TextUtils.isEmpty(imagesFolder)) {
            String str = this.f9816c;
            if (str.charAt(str.length() - 1) != '/') {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f9816c);
                sb.append('/');
                this.f9816c = sb.toString();
            }
        }
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.f9818e = new HashMap();
            this.f9815b = null;
            return;
        }
        this.f9815b = ((View) callback).getContext();
        this.f9818e = imageAssets;
        mo17976a(delegate);
    }

    /* renamed from: a */
    public void mo17976a(C5715b assetDelegate) {
        this.f9817d = assetDelegate;
    }

    /* renamed from: a */
    public Bitmap mo17974a(String id) {
        C5853y asset = (C5853y) this.f9818e.get(id);
        if (asset == null) {
            return null;
        }
        Bitmap bitmap = asset.mo18278a();
        if (bitmap != null) {
            return bitmap;
        }
        C5715b bVar = this.f9817d;
        if (bVar != null) {
            Bitmap bitmap2 = bVar.mo17971a(asset);
            if (bitmap2 != null) {
                m10171a(id, bitmap2);
            }
            return bitmap2;
        }
        String filename = asset.mo18280b();
        Options opts = new Options();
        opts.inScaled = true;
        opts.inDensity = Opcodes.IF_ICMPNE;
        String str = "LOTTIE";
        if (!filename.startsWith("data:") || filename.indexOf("base64,") <= 0) {
            try {
                if (!TextUtils.isEmpty(this.f9816c)) {
                    AssetManager assets = this.f9815b.getAssets();
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f9816c);
                    sb.append(filename);
                    Bitmap bitmap3 = BitmapFactory.decodeStream(assets.open(sb.toString()), null, opts);
                    m10171a(id, bitmap3);
                    return bitmap3;
                }
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            } catch (IOException e) {
                Log.w(str, "Unable to open asset.", e);
                return null;
            }
        } else {
            try {
                byte[] data = Base64.decode(filename.substring(filename.indexOf(44) + 1), 0);
                Bitmap bitmap4 = BitmapFactory.decodeByteArray(data, 0, data.length, opts);
                m10171a(id, bitmap4);
                return bitmap4;
            } catch (IllegalArgumentException e2) {
                Log.w(str, "data URL did not have correct base64 format.", e2);
                return null;
            }
        }
    }

    /* renamed from: a */
    public void mo17975a() {
        synchronized (f9814a) {
            for (Entry<String, LottieImageAsset> entry : this.f9818e.entrySet()) {
                C5853y asset = (C5853y) entry.getValue();
                Bitmap bitmap = asset.mo18278a();
                if (bitmap != null) {
                    bitmap.recycle();
                    asset.mo18279a(null);
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo17977a(Context context) {
        return (context == null && this.f9815b == null) || this.f9815b.equals(context);
    }

    /* renamed from: a */
    private Bitmap m10171a(String key, Bitmap bitmap) {
        synchronized (f9814a) {
            ((C5853y) this.f9818e.get(key)).mo18279a(bitmap);
        }
        return bitmap;
    }
}
