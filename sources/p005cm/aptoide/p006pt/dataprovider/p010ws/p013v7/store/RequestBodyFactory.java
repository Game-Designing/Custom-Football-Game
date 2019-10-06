package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store;

import java.io.File;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.RequestBodyFactory */
public class RequestBodyFactory {
    public RequestBody createBodyPartFromLong(long longValue) {
        return RequestBody.create(MediaType.parse("multipart/form-data"), String.valueOf(longValue));
    }

    public RequestBody createBodyPartFromString(String string) {
        if (string == null) {
            string = "";
        }
        return RequestBody.create(MediaType.parse("multipart/form-data"), string);
    }

    public Part createBodyPartFromFile(String key, File file) {
        return Part.createFormData(key, file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
    }
}
