package com.facebook.share.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.facebook.AccessToken;
import com.facebook.C6534A;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.C6545b;
import com.facebook.GraphRequest.ParcelableResourceWithMimeType;
import com.facebook.internal.C6694S;
import com.facebook.share.internal.C6794e.C6795a;
import com.facebook.share.model.ShareOpenGraphContent;
import java.io.File;
import java.io.FileNotFoundException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.share.internal.g */
/* compiled from: ShareInternalUtility */
public final class C6797g {
    /* renamed from: a */
    public static JSONObject m13859a(ShareOpenGraphContent shareOpenGraphContent) throws JSONException {
        return C6794e.m13851a(shareOpenGraphContent.mo20172c(), (C6795a) new C6796f());
    }

    /* renamed from: a */
    public static JSONArray m13858a(JSONArray jsonArray, boolean requireNamespace) throws JSONException {
        JSONArray newArray = new JSONArray();
        for (int i = 0; i < jsonArray.length(); i++) {
            Object value = jsonArray.get(i);
            if (value instanceof JSONArray) {
                value = m13858a((JSONArray) value, requireNamespace);
            } else if (value instanceof JSONObject) {
                value = m13860a((JSONObject) value, requireNamespace);
            }
            newArray.put(value);
        }
        return newArray;
    }

    /* renamed from: a */
    public static JSONObject m13860a(JSONObject jsonObject, boolean requireNamespace) {
        if (jsonObject == null) {
            return null;
        }
        try {
            JSONObject newJsonObject = new JSONObject();
            JSONObject data = new JSONObject();
            JSONArray names = jsonObject.names();
            for (int i = 0; i < names.length(); i++) {
                String key = names.getString(i);
                Object value = jsonObject.get(key);
                if (value instanceof JSONObject) {
                    value = m13860a((JSONObject) value, true);
                } else if (value instanceof JSONArray) {
                    value = m13858a((JSONArray) value, true);
                }
                Pair<String, String> fieldNameAndNamespace = m13855a(key);
                String namespace = (String) fieldNameAndNamespace.first;
                String fieldName = (String) fieldNameAndNamespace.second;
                if (requireNamespace) {
                    if (namespace == null || !namespace.equals("fbsdk")) {
                        if (namespace != null) {
                            if (!namespace.equals("og")) {
                                data.put(fieldName, value);
                            }
                        }
                        newJsonObject.put(fieldName, value);
                    } else {
                        newJsonObject.put(key, value);
                    }
                } else if (namespace == null || !namespace.equals("fb")) {
                    newJsonObject.put(fieldName, value);
                } else {
                    newJsonObject.put(key, value);
                }
            }
            if (data.length() > 0) {
                newJsonObject.put("data", data);
            }
            return newJsonObject;
        } catch (JSONException e) {
            throw new FacebookException("Failed to create json object from share content");
        }
    }

    /* renamed from: a */
    public static Pair<String, String> m13855a(String fullName) {
        String fieldName;
        String namespace = null;
        int index = fullName.indexOf(58);
        if (index == -1 || fullName.length() <= index + 1) {
            fieldName = fullName;
        } else {
            namespace = fullName.substring(0, index);
            fieldName = fullName.substring(index + 1);
        }
        return new Pair<>(namespace, fieldName);
    }

    /* renamed from: a */
    public static GraphRequest m13857a(AccessToken accessToken, File file, C6545b callback) throws FileNotFoundException {
        ParcelableResourceWithMimeType<ParcelFileDescriptor> resourceWithMimeType = new ParcelableResourceWithMimeType<>(ParcelFileDescriptor.open(file, 268435456), "image/png");
        Bundle parameters = new Bundle(1);
        parameters.putParcelable("file", resourceWithMimeType);
        AccessToken accessToken2 = accessToken;
        GraphRequest graphRequest = new GraphRequest(accessToken2, "me/staging_resources", parameters, C6534A.POST, callback);
        return graphRequest;
    }

    /* renamed from: a */
    public static GraphRequest m13856a(AccessToken accessToken, Uri imageUri, C6545b callback) throws FileNotFoundException {
        if (C6694S.m13441c(imageUri)) {
            return m13857a(accessToken, new File(imageUri.getPath()), callback);
        }
        if (C6694S.m13435b(imageUri)) {
            ParcelableResourceWithMimeType<Uri> resourceWithMimeType = new ParcelableResourceWithMimeType<>(imageUri, "image/png");
            Bundle parameters = new Bundle(1);
            parameters.putParcelable("file", resourceWithMimeType);
            AccessToken accessToken2 = accessToken;
            GraphRequest graphRequest = new GraphRequest(accessToken2, "me/staging_resources", parameters, C6534A.POST, callback);
            return graphRequest;
        }
        throw new FacebookException("The image Uri must be either a file:// or content:// Uri");
    }
}
