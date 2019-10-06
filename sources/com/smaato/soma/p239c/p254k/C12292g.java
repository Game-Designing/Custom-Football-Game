package com.smaato.soma.p239c.p254k;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import com.smaato.soma.C12398ha;

/* renamed from: com.smaato.soma.c.k.g */
/* compiled from: CustomWebView */
class C12292g extends C12398ha<Uri> {

    /* renamed from: a */
    final /* synthetic */ C12301p f38463a;

    C12292g(C12301p this$0) {
        this.f38463a = this$0;
    }

    public Uri process() throws Exception {
        Bitmap image = Bitmap.createBitmap(this.f38463a.getWidth(), (int) (((float) this.f38463a.getContentHeight()) * this.f38463a.getScale()), Config.ARGB_8888);
        this.f38463a.draw(new Canvas(image));
        ContentResolver contentResolver = this.f38463a.getContext().getContentResolver();
        StringBuilder sb = new StringBuilder();
        sb.append("sBitmapDrawableBitmapDrawablecreenshot");
        sb.append(System.currentTimeMillis());
        return Uri.parse(Media.insertImage(contentResolver, image, sb.toString(), null));
    }
}
