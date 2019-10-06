package com.bumptech.glide.load.p109a;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.a.o */
/* compiled from: StreamLocalUriFetcher */
public class C6059o extends C6057m<InputStream> {

    /* renamed from: d */
    private static final UriMatcher f10736d = new UriMatcher(-1);

    static {
        String str = "com.android.contacts";
        f10736d.addURI(str, "contacts/lookup/*/#", 1);
        f10736d.addURI(str, "contacts/lookup/*", 1);
        f10736d.addURI(str, "contacts/#/photo", 2);
        f10736d.addURI(str, "contacts/#", 3);
        f10736d.addURI(str, "contacts/#/display_photo", 4);
        f10736d.addURI(str, "phone_lookup/*", 5);
    }

    public C6059o(ContentResolver resolver, Uri uri) {
        super(resolver, uri);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public InputStream m11401a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream inputStream = m11398b(uri, contentResolver);
        if (inputStream != null) {
            return inputStream;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("InputStream is null for ");
        sb.append(uri);
        throw new FileNotFoundException(sb.toString());
    }

    /* renamed from: b */
    private InputStream m11398b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int match = f10736d.match(uri);
        if (match != 1) {
            if (match == 3) {
                return m11397a(contentResolver, uri);
            }
            if (match != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        Uri uri2 = Contacts.lookupContact(contentResolver, uri);
        if (uri2 != null) {
            return m11397a(contentResolver, uri2);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    /* renamed from: a */
    private InputStream m11397a(ContentResolver contentResolver, Uri contactUri) {
        return Contacts.openContactPhotoInputStream(contentResolver, contactUri, true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo18849a(InputStream data) throws IOException {
        data.close();
    }

    /* renamed from: a */
    public Class<InputStream> mo18847a() {
        return InputStream.class;
    }
}
