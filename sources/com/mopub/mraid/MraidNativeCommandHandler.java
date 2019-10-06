package com.mopub.mraid;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.mopub.common.MoPubHttpUrlConnection;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Intents;
import com.mopub.common.util.ResponseHeader;
import com.mopub.common.util.Streams;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;

public class MraidNativeCommandHandler {
    public static final String ANDROID_CALENDAR_CONTENT_TYPE = "vnd.android.cursor.item/event";

    /* renamed from: a */
    private static final String[] f35533a = {"yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ"};

    @VisibleForTesting
    /* renamed from: com.mopub.mraid.MraidNativeCommandHandler$a */
    static class C11480a extends AsyncTask<String, Void, Boolean> {

        /* renamed from: a */
        private final Context f35534a;

        /* renamed from: b */
        private final C11481a f35535b;

        /* renamed from: com.mopub.mraid.MraidNativeCommandHandler$a$a */
        interface C11481a {
            void onFailure();

            void onSuccess();
        }

        public C11480a(Context context, C11481a listener) {
            this.f35534a = context.getApplicationContext();
            this.f35535b = listener;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Boolean doInBackground(String[] params) {
            Boolean valueOf = Boolean.valueOf(false);
            if (params == null || params.length == 0 || params[0] == null) {
                return valueOf;
            }
            File pictureStoragePath = m38052a();
            pictureStoragePath.mkdirs();
            String uriString = params[0];
            URI uri = URI.create(uriString);
            InputStream pictureInputStream = null;
            OutputStream pictureOutputStream = null;
            try {
                HttpURLConnection urlConnection = MoPubHttpUrlConnection.getHttpUrlConnection(uriString);
                pictureInputStream = new BufferedInputStream(urlConnection.getInputStream());
                String redirectLocation = urlConnection.getHeaderField(ResponseHeader.LOCATION.getKey());
                if (!TextUtils.isEmpty(redirectLocation)) {
                    uri = URI.create(redirectLocation);
                }
                File pictureFile = new File(pictureStoragePath, m38053a(uri, urlConnection.getHeaderFields()));
                pictureOutputStream = new FileOutputStream(pictureFile);
                Streams.copyContent(pictureInputStream, pictureOutputStream);
                m38054a(pictureFile.toString());
                return Boolean.valueOf(true);
            } catch (Exception e) {
                return valueOf;
            } finally {
                Streams.closeStream(pictureInputStream);
                Streams.closeStream(pictureOutputStream);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Boolean success) {
            if (success == null || !success.booleanValue()) {
                this.f35535b.onFailure();
            } else {
                this.f35535b.onSuccess();
            }
        }

        /* renamed from: a */
        private String m38053a(URI uri, Map<String, List<String>> headers) {
            Preconditions.checkNotNull(uri);
            String path = uri.getPath();
            if (path == null || headers == null) {
                return null;
            }
            String filename = new File(path).getName();
            List<String> mimeTypeHeaders = (List) headers.get(ResponseHeader.CONTENT_TYPE.getKey());
            if (mimeTypeHeaders != null && !mimeTypeHeaders.isEmpty()) {
                int i = 0;
                if (mimeTypeHeaders.get(0) != null) {
                    String[] fields = ((String) mimeTypeHeaders.get(0)).split(";");
                    int length = fields.length;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        String field = fields[i];
                        if (field.contains("image/")) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(".");
                            sb.append(field.split("/")[1]);
                            String extension = sb.toString();
                            if (!filename.endsWith(extension)) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(filename);
                                sb2.append(extension);
                                filename = sb2.toString();
                            }
                        } else {
                            i++;
                        }
                    }
                    return filename;
                }
            }
            return filename;
        }

        /* renamed from: a */
        private File m38052a() {
            return new File(Environment.getExternalStorageDirectory(), "Pictures");
        }

        /* renamed from: a */
        private void m38054a(String filename) {
            C11482b mediaScannerConnectionClient = new C11482b(filename, null, null);
            MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(this.f35534a, mediaScannerConnectionClient);
            mediaScannerConnectionClient.m38057a(mediaScannerConnection);
            mediaScannerConnection.connect();
        }
    }

    /* renamed from: com.mopub.mraid.MraidNativeCommandHandler$b */
    private static class C11482b implements MediaScannerConnectionClient {

        /* renamed from: a */
        private final String f35536a;

        /* renamed from: b */
        private final String f35537b;

        /* renamed from: c */
        private MediaScannerConnection f35538c;

        /* synthetic */ C11482b(String x0, String x1, C11509z x2) {
            this(x0, x1);
        }

        private C11482b(String filename, String mimeType) {
            this.f35536a = filename;
            this.f35537b = mimeType;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m38057a(MediaScannerConnection connection) {
            this.f35538c = connection;
        }

        public void onMediaScannerConnected() {
            MediaScannerConnection mediaScannerConnection = this.f35538c;
            if (mediaScannerConnection != null) {
                mediaScannerConnection.scanFile(this.f35536a, this.f35537b);
            }
        }

        public void onScanCompleted(String path, Uri uri) {
            MediaScannerConnection mediaScannerConnection = this.f35538c;
            if (mediaScannerConnection != null) {
                mediaScannerConnection.disconnect();
            }
        }
    }

    /* renamed from: com.mopub.mraid.MraidNativeCommandHandler$c */
    interface C11483c {
        void onFailure(C11493j jVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37679a(Context context, Map<String, String> params) throws C11493j {
        if (m38040a(context)) {
            try {
                Map<String, Object> calendarParams = m38043b(params);
                Intent intent = new Intent("android.intent.action.INSERT").setType(ANDROID_CALENDAR_CONTENT_TYPE);
                for (String key : calendarParams.keySet()) {
                    Object value = calendarParams.get(key);
                    if (value instanceof Long) {
                        intent.putExtra(key, ((Long) value).longValue());
                    } else if (value instanceof Integer) {
                        intent.putExtra(key, ((Integer) value).intValue());
                    } else {
                        intent.putExtra(key, (String) value);
                    }
                }
                intent.setFlags(268435456);
                context.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "no calendar app installed");
                throw new C11493j("Action is unsupported on this device - no calendar app installed");
            } catch (IllegalArgumentException e2) {
                SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("create calendar: invalid parameters ");
                sb.append(e2.getMessage());
                MoPubLog.log(sdkLogEvent, sb.toString());
                throw new C11493j((Throwable) e2);
            } catch (Exception e3) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "could not create calendar event");
                throw new C11493j((Throwable) e3);
            }
        } else {
            MoPubLog.log(SdkLogEvent.CUSTOM, "unsupported action createCalendarEvent for devices pre-ICS");
            throw new C11493j("Action is unsupported on this device (need Android version Ice Cream Sandwich or above)");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo37681b(Context context, String imageUrl, C11483c failureListener) throws C11493j {
        if (!isStorePictureSupported(context)) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Error downloading file - the device does not have an SD card mounted, or the Android permission is not granted.");
            throw new C11493j("Error downloading file  - the device does not have an SD card mounted, or the Android permission is not granted.");
        } else if (context instanceof Activity) {
            m38045c(context, imageUrl, failureListener);
        } else {
            Toast.makeText(context, "Downloading image to Picture gallery...", 0).show();
            mo37678a(context, imageUrl, failureListener);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo37683c(Context context) {
        Intent telIntent = new Intent("android.intent.action.DIAL");
        telIntent.setData(Uri.parse("tel:"));
        return Intents.deviceCanHandleIntent(context, telIntent);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo37682b(Context context) {
        Intent smsIntent = new Intent("android.intent.action.VIEW");
        smsIntent.setData(Uri.parse("sms:"));
        return Intents.deviceCanHandleIntent(context, smsIntent);
    }

    public static boolean isStorePictureSupported(Context context) {
        return "mounted".equals(Environment.getExternalStorageState()) && DeviceUtils.isPermissionGranted(context, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    /* renamed from: a */
    static boolean m38040a(Context context) {
        return Intents.deviceCanHandleIntent(context, new Intent("android.intent.action.INSERT").setType(ANDROID_CALENDAR_CONTENT_TYPE));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo37680a(Activity activity, View view) {
        boolean z = false;
        if (activity.getWindow() == null) {
            return false;
        }
        if ((16777216 & activity.getWindow().getAttributes().flags) != 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    private Map<String, Object> m38043b(Map<String, String> params) {
        Map<String, Object> validatedParamsMapping = new HashMap<>();
        String str = Repo.COLUMN_DESCRIPTION;
        if (params.containsKey(str)) {
            String str2 = "start";
            if (params.containsKey(str2)) {
                validatedParamsMapping.put("title", params.get(str));
                if (!params.containsKey(str2) || params.get(str2) == null) {
                    throw new IllegalArgumentException("Invalid calendar event: start is null.");
                }
                Date startDateTime = m38039a((String) params.get(str2));
                if (startDateTime != null) {
                    validatedParamsMapping.put("beginTime", Long.valueOf(startDateTime.getTime()));
                    String str3 = "end";
                    if (params.containsKey(str3) && params.get(str3) != null) {
                        Date endDateTime = m38039a((String) params.get(str3));
                        if (endDateTime != null) {
                            validatedParamsMapping.put("endTime", Long.valueOf(endDateTime.getTime()));
                        } else {
                            throw new IllegalArgumentException("Invalid calendar event: end time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
                        }
                    }
                    String str4 = "location";
                    if (params.containsKey(str4)) {
                        validatedParamsMapping.put("eventLocation", params.get(str4));
                    }
                    String str5 = "summary";
                    if (params.containsKey(str5)) {
                        validatedParamsMapping.put(str, params.get(str5));
                    }
                    String str6 = "transparency";
                    if (params.containsKey(str6)) {
                        validatedParamsMapping.put("availability", Integer.valueOf(((String) params.get(str6)).equals("transparent") ? 1 : 0));
                    }
                    validatedParamsMapping.put("rrule", m38038a(params));
                    return validatedParamsMapping;
                }
                throw new IllegalArgumentException("Invalid calendar event: start time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
            }
        }
        throw new IllegalArgumentException("Missing start and description fields");
    }

    /* renamed from: a */
    private Date m38039a(String dateTime) {
        Date result = null;
        String[] strArr = f35533a;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            try {
                result = new SimpleDateFormat(strArr[i], Locale.US).parse(dateTime);
                if (result != null) {
                    break;
                }
                i++;
            } catch (ParseException e) {
            }
        }
        return result;
    }

    /* renamed from: a */
    private String m38038a(Map<String, String> params) throws IllegalArgumentException {
        StringBuilder rule = new StringBuilder();
        String str = "frequency";
        if (params.containsKey(str)) {
            String frequency = (String) params.get(str);
            int interval = -1;
            String str2 = "interval";
            if (params.containsKey(str2)) {
                interval = Integer.parseInt((String) params.get(str2));
            }
            String str3 = "INTERVAL=";
            String str4 = ";";
            if ("daily".equals(frequency)) {
                rule.append("FREQ=DAILY;");
                if (interval != -1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str3);
                    sb.append(interval);
                    sb.append(str4);
                    rule.append(sb.toString());
                }
            } else if ("weekly".equals(frequency)) {
                rule.append("FREQ=WEEKLY;");
                if (interval != -1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str3);
                    sb2.append(interval);
                    sb2.append(str4);
                    rule.append(sb2.toString());
                }
                String str5 = "daysInWeek";
                if (params.containsKey(str5)) {
                    String weekdays = m38044c((String) params.get(str5));
                    if (weekdays != null) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("BYDAY=");
                        sb3.append(weekdays);
                        sb3.append(str4);
                        rule.append(sb3.toString());
                    } else {
                        throw new IllegalArgumentException("invalid ");
                    }
                }
            } else if ("monthly".equals(frequency)) {
                rule.append("FREQ=MONTHLY;");
                if (interval != -1) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str3);
                    sb4.append(interval);
                    sb4.append(str4);
                    rule.append(sb4.toString());
                }
                String str6 = "daysInMonth";
                if (params.containsKey(str6)) {
                    String monthDays = m38042b((String) params.get(str6));
                    if (monthDays != null) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("BYMONTHDAY=");
                        sb5.append(monthDays);
                        sb5.append(str4);
                        rule.append(sb5.toString());
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            } else {
                throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
            }
        }
        return rule.toString();
    }

    /* renamed from: c */
    private String m38044c(String expression) throws IllegalArgumentException {
        StringBuilder daysResult = new StringBuilder();
        boolean[] daysAlreadyCounted = new boolean[7];
        String str = ",";
        String[] days = expression.split(str);
        for (String day : days) {
            int dayNumber = Integer.parseInt(day);
            int dayNumber2 = dayNumber == 7 ? 0 : dayNumber;
            if (!daysAlreadyCounted[dayNumber2]) {
                StringBuilder sb = new StringBuilder();
                sb.append(m38041b(dayNumber2));
                sb.append(str);
                daysResult.append(sb.toString());
                daysAlreadyCounted[dayNumber2] = true;
            }
        }
        if (days.length != 0) {
            daysResult.deleteCharAt(daysResult.length() - 1);
            return daysResult.toString();
        }
        throw new IllegalArgumentException("must have at least 1 day of the week if specifying repeating weekly");
    }

    /* renamed from: b */
    private String m38042b(String expression) throws IllegalArgumentException {
        StringBuilder daysResult = new StringBuilder();
        boolean[] daysAlreadyCounted = new boolean[63];
        String str = ",";
        String[] days = expression.split(str);
        for (String day : days) {
            int dayNumber = Integer.parseInt(day);
            if (!daysAlreadyCounted[dayNumber + 31]) {
                StringBuilder sb = new StringBuilder();
                sb.append(m38037a(dayNumber));
                sb.append(str);
                daysResult.append(sb.toString());
                daysAlreadyCounted[dayNumber + 31] = true;
            }
        }
        if (days.length != 0) {
            daysResult.deleteCharAt(daysResult.length() - 1);
            return daysResult.toString();
        }
        throw new IllegalArgumentException("must have at least 1 day of the month if specifying repeating weekly");
    }

    /* renamed from: b */
    private String m38041b(int number) throws IllegalArgumentException {
        switch (number) {
            case 0:
                return "SU";
            case 1:
                return "MO";
            case 2:
                return "TU";
            case 3:
                return "WE";
            case 4:
                return "TH";
            case 5:
                return "FR";
            case 6:
                return "SA";
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("invalid day of week ");
                sb.append(number);
                throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    private String m38037a(int number) throws IllegalArgumentException {
        if (number == 0 || number < -31 || number > 31) {
            StringBuilder sb = new StringBuilder();
            sb.append("invalid day of month ");
            sb.append(number);
            throw new IllegalArgumentException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(number);
        return sb2.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37678a(Context context, String uriString, C11483c failureListener) {
        AsyncTasks.safeExecuteOnExecutor(new C11480a(context, new C11509z(this, context, failureListener)), uriString);
    }

    /* renamed from: c */
    private void m38045c(Context context, String imageUrl, C11483c failureListener) {
        new Builder(context).setTitle("Save Image").setMessage("Download image to Picture gallery?").setNegativeButton("Cancel", null).setPositiveButton("Okay", new C11471A(this, context, imageUrl, failureListener)).setCancelable(true).show();
    }
}
