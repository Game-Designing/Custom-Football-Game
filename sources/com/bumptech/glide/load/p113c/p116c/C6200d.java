package com.bumptech.glide.load.p113c.p116c;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.C6350l;
import com.bumptech.glide.load.engine.C6236E;
import java.util.List;

/* renamed from: com.bumptech.glide.load.c.c.d */
/* compiled from: ResourceDrawableDecoder */
public class C6200d implements C6350l<Uri, Drawable> {

    /* renamed from: a */
    private final Context f10931a;

    public C6200d(Context context) {
        this.f10931a = context.getApplicationContext();
    }

    /* renamed from: a */
    public boolean mo18973a(Uri source, C6349k options) {
        return source.getScheme().equals("android.resource");
    }

    /* renamed from: a */
    public C6236E<Drawable> mo18972a(Uri source, int width, int height, C6349k options) {
        int resId = m11780a(source);
        String packageName = source.getAuthority();
        return C6199c.m11776a(C6197a.m11772a(this.f10931a, packageName.equals(this.f10931a.getPackageName()) ? this.f10931a : m11781a(source, packageName), resId));
    }

    /* renamed from: a */
    private Context m11781a(Uri source, String packageName) {
        try {
            return this.f10931a.createPackageContext(packageName, 0);
        } catch (NameNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to obtain context or unrecognized Uri format for: ");
            sb.append(source);
            throw new IllegalArgumentException(sb.toString(), e);
        }
    }

    /* renamed from: a */
    private int m11780a(Uri source) {
        List<String> segments = source.getPathSegments();
        Integer result = null;
        if (segments.size() == 2) {
            String typeName = (String) segments.get(0);
            String resourceName = (String) segments.get(1);
            result = Integer.valueOf(this.f10931a.getResources().getIdentifier(resourceName, typeName, source.getAuthority()));
        } else if (segments.size() == 1) {
            try {
                result = Integer.valueOf((String) segments.get(0));
            } catch (NumberFormatException e) {
            }
        }
        if (result == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized Uri format: ");
            sb.append(source);
            throw new IllegalArgumentException(sb.toString());
        } else if (result.intValue() != 0) {
            return result.intValue();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to obtain resource id for: ");
            sb2.append(source);
            throw new IllegalArgumentException(sb2.toString());
        }
    }
}
