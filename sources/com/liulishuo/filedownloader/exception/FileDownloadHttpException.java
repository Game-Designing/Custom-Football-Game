package com.liulishuo.filedownloader.exception;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import p019d.p307j.p308a.p313e.C13121g;

public class FileDownloadHttpException extends RuntimeException {

    /* renamed from: a */
    private final int f33293a;

    /* renamed from: b */
    private final Map<String, List<String>> f33294b;

    /* renamed from: c */
    private final Map<String, List<String>> f33295c;

    public FileDownloadHttpException(int code, Map<String, List<String>> requestHeaderMap, Map<String, List<String>> responseHeaderMap) {
        super(C13121g.m42792a("response code error: %d, \n request headers: %s \n response headers: %s", Integer.valueOf(code), requestHeaderMap, responseHeaderMap));
        this.f33293a = code;
        this.f33294b = m35689a(requestHeaderMap);
        this.f33295c = m35689a(requestHeaderMap);
    }

    /* renamed from: a */
    public int mo35685a() {
        return this.f33293a;
    }

    /* renamed from: a */
    private static Map<String, List<String>> m35689a(Map<String, List<String>> originMap) {
        Map<String, List<String>> serialMap = new HashMap<>();
        for (Entry<String, List<String>> entry : originMap.entrySet()) {
            serialMap.put((String) entry.getKey(), new ArrayList<>((Collection) entry.getValue()));
        }
        return serialMap;
    }
}
