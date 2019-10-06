package com.bumptech.glide.load.p111b;

import android.util.Base64;
import com.bumptech.glide.load.p111b.C6101g.C6102a;
import com.bumptech.glide.load.p111b.C6101g.C6104c;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.b.h */
/* compiled from: DataUrlLoader */
class C6105h implements C6102a<InputStream> {

    /* renamed from: a */
    final /* synthetic */ C6104c f10780a;

    C6105h(C6104c this$0) {
        this.f10780a = this$0;
    }

    public InputStream decode(String url) {
        if (url.startsWith("data:image")) {
            int commaIndex = url.indexOf(44);
            if (commaIndex == -1) {
                throw new IllegalArgumentException("Missing comma in data URL.");
            } else if (url.substring(0, commaIndex).endsWith(";base64")) {
                return new ByteArrayInputStream(Base64.decode(url.substring(commaIndex + 1), 0));
            } else {
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }
        } else {
            throw new IllegalArgumentException("Not a valid image data URL.");
        }
    }

    /* renamed from: a */
    public void mo18920a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    /* renamed from: a */
    public Class<InputStream> mo18919a() {
        return InputStream.class;
    }
}
