package p005cm.aptoide.p006pt.dataprovider.cache;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.logger.Logger;

/* renamed from: cm.aptoide.pt.dataprovider.cache.L2Cache */
public class L2Cache extends StringBaseCache<Request, Response> {
    private static final String CACHE_CONTROL_HEADER = "Cache-Control";
    private static final int MAX_COUNT = 15;
    private static final String TAG = L2Cache.class.getName();
    private ConcurrentHashMap<String, ResponseCacheEntry> cache;
    private final File cacheFile;
    private volatile boolean isPersisting = false;
    private final Pattern pattern = Pattern.compile("\\d+");
    private AtomicInteger persistenceCounter = new AtomicInteger(0);

    public L2Cache(KeyAlgorithm<Request, String> keyAlgorithm, File cacheFile2) {
        super(keyAlgorithm);
        this.cacheFile = cacheFile2;
        this.cache = new ConcurrentHashMap<>(60);
        try {
            load();
        } catch (IOException e) {
        }
    }

    private void load() throws IOException {
        this.cache = (ConcurrentHashMap) new ObjectMapper().readValue(this.cacheFile, (TypeReference) new TypeReference<ConcurrentHashMap<String, ResponseCacheEntry>>() {
        });
        Logger.getInstance().mo2136d(TAG, "Loaded cache file");
    }

    public void destroy() {
        persist();
        this.cache.clear();
    }

    private void persist() {
        this.isPersisting = true;
        removeInvalid();
        try {
            store();
        } catch (IOException e) {
            CrashReport.getInstance().log(e);
        }
        do {
        } while (!this.persistenceCounter.compareAndSet(this.persistenceCounter.get(), 0));
        this.isPersisting = false;
    }

    private void removeInvalid() {
        for (Entry<String, ResponseCacheEntry> cacheEntry : this.cache.entrySet()) {
            if (!((ResponseCacheEntry) cacheEntry.getValue()).isValid()) {
                this.cache.remove(cacheEntry.getKey());
            }
        }
    }

    private void store() throws IOException {
        new ObjectMapper().writeValue(this.cacheFile, (Object) this.cache);
        Logger.getInstance().mo2136d(TAG, "Stored cache file");
    }

    public void put(String key, Response response) {
        int seconds = shouldCacheUntil(response);
        if (seconds >= 1) {
            this.cache.put(key, new ResponseCacheEntry(response, seconds));
        }
    }

    public Response get(String key, Request request) {
        ResponseCacheEntry response = (ResponseCacheEntry) this.cache.get(key);
        if (this.persistenceCounter.incrementAndGet() >= 15 && response != null && !this.isPersisting) {
            persist();
        }
        return response.getResponse(request);
    }

    public boolean contains(String key) {
        return this.cache.containsKey(key);
    }

    public boolean isValid(String key) {
        ResponseCacheEntry cachedResponse = contains(key) ? (ResponseCacheEntry) this.cache.get(key) : null;
        if (cachedResponse != null) {
            return cachedResponse.isValid();
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void remove(String key) {
        if (contains(key)) {
            this.cache.remove(key);
        }
    }

    private int shouldCacheUntil(Response response) {
        try {
            Headers headers = response.headers();
            if (headers.size() <= 0) {
                Logger.getInstance().mo2136d(TAG, "not caching the response due to empty headers");
                return 0;
            }
            List<String> cacheControlHeaders = headers.values(CACHE_CONTROL_HEADER);
            if (cacheControlHeaders.size() <= 0) {
                Logger.getInstance().mo2136d(TAG, "not caching the response due to empty Cache-Control header");
                return 0;
            }
            for (String headerValue : cacheControlHeaders) {
                if (!headerValue.startsWith("max-age")) {
                    if (headerValue.startsWith("s-maxage")) {
                    }
                }
                return extractNumber(headerValue);
            }
            return 0;
        } catch (Exception e) {
            CrashReport.getInstance().log(e);
        }
    }

    private int extractNumber(String value) {
        Matcher matcher = this.pattern.matcher(value);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(matcher.groupCount()));
        }
        return 0;
    }

    public void clean() {
        ConcurrentHashMap<String, ResponseCacheEntry> concurrentHashMap = this.cache;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            this.cache.clear();
        }
    }
}
