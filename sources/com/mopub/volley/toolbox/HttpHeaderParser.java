package com.mopub.volley.toolbox;

import com.mopub.volley.Cache.Entry;
import com.mopub.volley.Header;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.VolleyLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

public class HttpHeaderParser {
    public static Entry parseCacheHeaders(NetworkResponse response) {
        long lastModified;
        long j;
        NetworkResponse networkResponse = response;
        long now = System.currentTimeMillis();
        Map<String, String> headers = networkResponse.headers;
        long serverDate = 0;
        long serverExpires = 0;
        long softExpire = 0;
        long finalExpire = 0;
        long maxAge = 0;
        long staleWhileRevalidate = 0;
        boolean mustRevalidate = false;
        boolean hasCacheControl = false;
        String headerValue = (String) headers.get("Date");
        if (headerValue != null) {
            serverDate = parseDateAsEpoch(headerValue);
        }
        String str = headerValue;
        String headerValue2 = (String) headers.get("Cache-Control");
        if (headerValue2 != null) {
            hasCacheControl = true;
            String[] tokens = headerValue2.split(",", 0);
            long staleWhileRevalidate2 = 0;
            long maxAge2 = 0;
            int i = 0;
            while (i < tokens.length) {
                String headerValue3 = headerValue2;
                String token = tokens[i].trim();
                if (token.equals("no-cache") || token.equals("no-store")) {
                    return null;
                }
                if (token.startsWith("max-age=")) {
                    try {
                        maxAge2 = Long.parseLong(token.substring(8));
                    } catch (Exception e) {
                    }
                } else if (token.startsWith("stale-while-revalidate=")) {
                    try {
                        staleWhileRevalidate2 = Long.parseLong(token.substring(23));
                    } catch (Exception e2) {
                    }
                } else if (token.equals("must-revalidate") || token.equals("proxy-revalidate")) {
                    mustRevalidate = true;
                }
                i++;
                headerValue2 = headerValue3;
            }
            maxAge = maxAge2;
            staleWhileRevalidate = staleWhileRevalidate2;
        }
        String headerValue4 = (String) headers.get("Expires");
        if (headerValue4 != null) {
            serverExpires = parseDateAsEpoch(headerValue4);
        }
        String headerValue5 = (String) headers.get("Last-Modified");
        if (headerValue5 != null) {
            lastModified = parseDateAsEpoch(headerValue5);
        } else {
            lastModified = 0;
        }
        String str2 = headerValue5;
        String serverEtag = (String) headers.get("ETag");
        if (hasCacheControl) {
            softExpire = now + (maxAge * 1000);
            if (mustRevalidate) {
                j = softExpire;
            } else {
                Long.signum(staleWhileRevalidate);
                j = softExpire + (1000 * staleWhileRevalidate);
            }
            finalExpire = j;
        } else if (serverDate > 0 && serverExpires >= serverDate) {
            softExpire = now + (serverExpires - serverDate);
            finalExpire = softExpire;
        }
        long j2 = now;
        Entry entry = new Entry();
        entry.data = networkResponse.data;
        entry.etag = serverEtag;
        entry.softTtl = softExpire;
        entry.ttl = finalExpire;
        entry.serverDate = serverDate;
        entry.lastModified = lastModified;
        entry.responseHeaders = headers;
        entry.allResponseHeaders = networkResponse.allHeaders;
        return entry;
    }

    public static long parseDateAsEpoch(String dateStr) {
        try {
            return m38637a().parse(dateStr).getTime();
        } catch (ParseException e) {
            VolleyLog.m38605e(e, "Unable to parse dateStr: %s, falling back to 0", dateStr);
            return 0;
        }
    }

    /* renamed from: a */
    static String m38636a(long epoch) {
        return m38637a().format(new Date(epoch));
    }

    /* renamed from: a */
    private static SimpleDateFormat m38637a() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        return formatter;
    }

    public static String parseCharset(Map<String, String> headers, String defaultCharset) {
        String contentType = (String) headers.get("Content-Type");
        if (contentType != null) {
            String[] params = contentType.split(";", 0);
            for (int i = 1; i < params.length; i++) {
                String[] pair = params[i].trim().split("=", 0);
                if (pair.length == 2 && pair[0].equals("charset")) {
                    return pair[1];
                }
            }
        }
        return defaultCharset;
    }

    public static String parseCharset(Map<String, String> headers) {
        return parseCharset(headers, "ISO-8859-1");
    }

    /* renamed from: a */
    static Map<String, String> m38639a(List<Header> allHeaders) {
        Map<String, String> headers = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (Header header : allHeaders) {
            headers.put(header.getName(), header.getValue());
        }
        return headers;
    }

    /* renamed from: a */
    static List<Header> m38638a(Map<String, String> headers) {
        List<Header> allHeaders = new ArrayList<>(headers.size());
        for (Map.Entry<String, String> header : headers.entrySet()) {
            allHeaders.add(new Header((String) header.getKey(), (String) header.getValue()));
        }
        return allHeaders;
    }
}
