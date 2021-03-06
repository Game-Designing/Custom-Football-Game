package com.squareup.picasso;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Contacts;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.RequestHandler.Result;
import java.io.IOException;
import java.io.InputStream;

class ContactsPhotoRequestHandler extends RequestHandler {
    private static final int ID_CONTACT = 3;
    private static final int ID_DISPLAY_PHOTO = 4;
    private static final int ID_LOOKUP = 1;
    private static final int ID_THUMBNAIL = 2;
    private static final UriMatcher matcher = new UriMatcher(-1);
    private final Context context;

    @TargetApi(14)
    private static class ContactPhotoStreamIcs {
        private ContactPhotoStreamIcs() {
        }

        static InputStream get(ContentResolver contentResolver, Uri uri) {
            return Contacts.openContactPhotoInputStream(contentResolver, uri, true);
        }
    }

    static {
        String str = "com.android.contacts";
        matcher.addURI(str, "contacts/lookup/*/#", 1);
        matcher.addURI(str, "contacts/lookup/*", 1);
        matcher.addURI(str, "contacts/#/photo", 2);
        matcher.addURI(str, "contacts/#", 3);
        matcher.addURI(str, "display_photo/#", 4);
    }

    ContactsPhotoRequestHandler(Context context2) {
        this.context = context2;
    }

    public boolean canHandleRequest(Request data) {
        Uri uri = data.uri;
        return "content".equals(uri.getScheme()) && Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && matcher.match(data.uri) != -1;
    }

    public Result load(Request request, int networkPolicy) throws IOException {
        InputStream is = getInputStream(request);
        if (is != null) {
            return new Result(is, LoadedFrom.DISK);
        }
        return null;
    }

    private InputStream getInputStream(Request data) throws IOException {
        ContentResolver contentResolver = this.context.getContentResolver();
        Uri uri = data.uri;
        int match = matcher.match(uri);
        if (match != 1) {
            if (match != 2) {
                if (match != 3) {
                    if (match != 4) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Invalid uri: ");
                        sb.append(uri);
                        throw new IllegalStateException(sb.toString());
                    }
                }
            }
            return contentResolver.openInputStream(uri);
        }
        uri = Contacts.lookupContact(contentResolver, uri);
        if (uri == null) {
            return null;
        }
        if (VERSION.SDK_INT < 14) {
            return Contacts.openContactPhotoInputStream(contentResolver, uri);
        }
        return ContactPhotoStreamIcs.get(contentResolver, uri);
    }
}
