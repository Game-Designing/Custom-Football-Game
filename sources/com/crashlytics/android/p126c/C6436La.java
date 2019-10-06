package com.crashlytics.android.p126c;

import android.app.ActivityManager.RunningAppProcessInfo;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import p005cm.aptoide.p006pt.BuildConfig;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.p348a.p350b.C13868y.C13869a;

/* renamed from: com.crashlytics.android.c.La */
/* compiled from: SessionProtobufHelper */
class C6436La {

    /* renamed from: a */
    private static final C6481d f11536a = C6481d.m12660a(BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);

    /* renamed from: b */
    private static final C6481d f11537b = C6481d.m12660a("Unity");

    /* renamed from: a */
    public static void m12491a(C6491h cos, String sessionId, String generator, long startedAtSeconds) throws Exception {
        cos.mo19556b(1, C6481d.m12660a(generator));
        cos.mo19556b(2, C6481d.m12660a(sessionId));
        cos.mo19555b(3, startedAtSeconds);
    }

    /* renamed from: a */
    public static void m12493a(C6491h cos, String packageName, String apiKey, String versionCode, String versionName, String installUuid, int deliveryMechanism, String unityVersion) throws Exception {
        C6491h hVar = cos;
        C6481d packageNameBytes = C6481d.m12660a(packageName);
        C6481d apiKeyBytes = C6481d.m12660a(apiKey);
        C6481d versionCodeBytes = C6481d.m12660a(versionCode);
        C6481d versionNameBytes = C6481d.m12660a(versionName);
        C6481d installIdBytes = C6481d.m12660a(installUuid);
        C6481d unityVersionBytes = unityVersion != null ? C6481d.m12660a(unityVersion) : null;
        cos.mo19564f(7, 2);
        cos.mo19572l(m12475a(packageNameBytes, apiKeyBytes, versionCodeBytes, versionNameBytes, installIdBytes, deliveryMechanism, unityVersionBytes));
        cos.mo19556b(1, packageNameBytes);
        cos.mo19556b(2, versionCodeBytes);
        cos.mo19556b(3, versionNameBytes);
        cos.mo19564f(5, 2);
        cos.mo19572l(m12497b(apiKeyBytes));
        cos.mo19556b(1, apiKeyBytes);
        cos.mo19556b(6, installIdBytes);
        if (unityVersionBytes != null) {
            cos.mo19556b(8, f11537b);
            cos.mo19556b(9, unityVersionBytes);
        }
        cos.mo19561d(10, deliveryMechanism);
    }

    /* renamed from: a */
    public static void m12494a(C6491h cos, String osRelease, String osCodeName, boolean isRooted) throws Exception {
        C6481d releaseBytes = C6481d.m12660a(osRelease);
        C6481d codeNameBytes = C6481d.m12660a(osCodeName);
        cos.mo19564f(8, 2);
        cos.mo19572l(m12476a(releaseBytes, codeNameBytes, isRooted));
        cos.mo19561d(1, 3);
        cos.mo19556b(2, releaseBytes);
        cos.mo19556b(3, codeNameBytes);
        cos.mo19557b(4, isRooted);
    }

    /* renamed from: a */
    public static void m12484a(C6491h cos, int arch, String model, int availableProcessors, long totalRam, long diskSpace, boolean isEmulator, Map<C13869a, String> ids, int state, String manufacturer, String modelClass) throws Exception {
        C6491h hVar = cos;
        C6481d modelBytes = m12482a(model);
        C6481d modelClassBytes = m12482a(modelClass);
        C6481d manufacturerBytes = m12482a(manufacturer);
        hVar.mo19564f(9, 2);
        int i = availableProcessors;
        long j = totalRam;
        long j2 = diskSpace;
        boolean z = isEmulator;
        C6481d manufacturerBytes2 = manufacturerBytes;
        hVar.mo19572l(m12468a(arch, modelBytes, i, j, j2, z, ids, state, manufacturerBytes, modelClassBytes));
        hVar.mo19561d(3, arch);
        hVar.mo19556b(4, modelBytes);
        hVar.mo19567g(5, i);
        hVar.mo19555b(6, j);
        hVar.mo19555b(7, j2);
        hVar.mo19557b(10, z);
        for (Entry<DeviceIdentifierType, String> id : ids.entrySet()) {
            hVar.mo19564f(11, 2);
            hVar.mo19572l(m12477a((C13869a) id.getKey(), (String) id.getValue()));
            hVar.mo19561d(1, ((C13869a) id.getKey()).f42090i);
            hVar.mo19556b(2, C6481d.m12660a((String) id.getValue()));
        }
        hVar.mo19567g(12, state);
        if (manufacturerBytes2 != null) {
            hVar.mo19556b(13, manufacturerBytes2);
        }
        if (modelClassBytes != null) {
            hVar.mo19556b(14, modelClassBytes);
        }
    }

    /* renamed from: a */
    public static void m12492a(C6491h cos, String id, String name, String email) throws Exception {
        C6481d idBytes = C6481d.m12660a(id == null ? "" : id);
        C6481d nameBytes = m12482a(name);
        C6481d emailBytes = m12482a(email);
        int size = 0 + C6491h.m12684a(1, idBytes);
        if (name != null) {
            size += C6491h.m12684a(2, nameBytes);
        }
        if (email != null) {
            size += C6491h.m12684a(3, emailBytes);
        }
        cos.mo19564f(6, 2);
        cos.mo19572l(size);
        cos.mo19556b(1, idBytes);
        if (name != null) {
            cos.mo19556b(2, nameBytes);
        }
        if (email != null) {
            cos.mo19556b(3, emailBytes);
        }
    }

    /* renamed from: a */
    public static void m12485a(C6491h cos, long eventTime, String eventType, C6444Pa exception, Thread exceptionThread, StackTraceElement[] exceptionStack, Thread[] otherThreads, List<StackTraceElement[]> otherStacks, Map<String, String> customAttributes, C6519ta logFileManager, RunningAppProcessInfo runningAppProcessInfo, int orientation, String packageName, String buildId, Float batteryLevel, int batteryVelocity, boolean proximityEnabled, long usedRamInBytes, long diskUsedInBytes) throws Exception {
        C6481d optionalBuildIdBytes;
        C6491h hVar = cos;
        String str = buildId;
        C6481d packageNameBytes = C6481d.m12660a(packageName);
        if (str == null) {
            optionalBuildIdBytes = null;
        } else {
            optionalBuildIdBytes = C6481d.m12660a(str.replace("-", ""));
        }
        C6481d logByteString = logFileManager.mo19611b();
        if (logByteString == null) {
            C13920f.m44245e().mo43326c("CrashlyticsCore", "No log data to include with this event.");
        }
        logFileManager.mo19606a();
        hVar.mo19564f(10, 2);
        long j = eventTime;
        hVar.mo19572l(m12469a(j, eventType, exception, exceptionThread, exceptionStack, otherThreads, otherStacks, 8, customAttributes, runningAppProcessInfo, orientation, packageNameBytes, optionalBuildIdBytes, batteryLevel, batteryVelocity, proximityEnabled, usedRamInBytes, diskUsedInBytes, logByteString));
        hVar.mo19555b(1, j);
        hVar.mo19556b(2, C6481d.m12660a(eventType));
        C6491h hVar2 = cos;
        C6481d logByteString2 = logByteString;
        m12488a(hVar2, exception, exceptionThread, exceptionStack, otherThreads, otherStacks, 8, packageNameBytes, optionalBuildIdBytes, customAttributes, runningAppProcessInfo, orientation);
        m12490a(hVar2, batteryLevel, batteryVelocity, proximityEnabled, orientation, usedRamInBytes, diskUsedInBytes);
        m12489a(hVar, logByteString2);
    }

    /* renamed from: a */
    private static void m12488a(C6491h cos, C6444Pa exception, Thread exceptionThread, StackTraceElement[] exceptionStack, Thread[] otherThreads, List<StackTraceElement[]> otherStacks, int maxChainedExceptionsDepth, C6481d packageNameBytes, C6481d optionalBuildIdBytes, Map<String, String> customAttributes, RunningAppProcessInfo runningAppProcessInfo, int orientation) throws Exception {
        cos.mo19564f(3, 2);
        cos.mo19572l(m12472a(exception, exceptionThread, exceptionStack, otherThreads, otherStacks, maxChainedExceptionsDepth, packageNameBytes, optionalBuildIdBytes, customAttributes, runningAppProcessInfo, orientation));
        m12487a(cos, exception, exceptionThread, exceptionStack, otherThreads, otherStacks, maxChainedExceptionsDepth, packageNameBytes, optionalBuildIdBytes);
        if (customAttributes != null && !customAttributes.isEmpty()) {
            m12496a(cos, customAttributes);
        }
        if (runningAppProcessInfo != null) {
            cos.mo19557b(3, runningAppProcessInfo.importance != 100);
        }
        cos.mo19567g(4, orientation);
    }

    /* renamed from: a */
    private static void m12487a(C6491h cos, C6444Pa exception, Thread exceptionThread, StackTraceElement[] exceptionStack, Thread[] otherThreads, List<StackTraceElement[]> otherStacks, int maxChainedExceptionsDepth, C6481d packageNameBytes, C6481d optionalBuildIdBytes) throws Exception {
        C6491h hVar = cos;
        Thread[] threadArr = otherThreads;
        C6481d dVar = optionalBuildIdBytes;
        hVar.mo19564f(1, 2);
        hVar.mo19572l(m12471a(exception, exceptionThread, exceptionStack, otherThreads, otherStacks, maxChainedExceptionsDepth, packageNameBytes, optionalBuildIdBytes));
        m12495a(hVar, exceptionThread, exceptionStack, 4, true);
        int len = threadArr.length;
        for (int i = 0; i < len; i++) {
            m12495a(hVar, threadArr[i], (StackTraceElement[]) otherStacks.get(i), 0, false);
        }
        List<StackTraceElement[]> list = otherStacks;
        m12486a(hVar, exception, 1, maxChainedExceptionsDepth, 2);
        hVar.mo19564f(3, 2);
        hVar.mo19572l(m12467a());
        hVar.mo19556b(1, f11536a);
        hVar.mo19556b(2, f11536a);
        hVar.mo19555b(3, 0);
        hVar.mo19564f(4, 2);
        hVar.mo19572l(m12474a(packageNameBytes, optionalBuildIdBytes));
        hVar.mo19555b(1, 0);
        hVar.mo19555b(2, 0);
        hVar.mo19556b(3, packageNameBytes);
        if (dVar != null) {
            hVar.mo19556b(4, dVar);
        }
    }

    /* renamed from: a */
    private static void m12496a(C6491h cos, Map<String, String> customAttributes) throws Exception {
        for (Entry<String, String> entry : customAttributes.entrySet()) {
            cos.mo19564f(2, 2);
            cos.mo19572l(m12480a((String) entry.getKey(), (String) entry.getValue()));
            cos.mo19556b(1, C6481d.m12660a((String) entry.getKey()));
            String value = (String) entry.getValue();
            cos.mo19556b(2, C6481d.m12660a(value == null ? "" : value));
        }
    }

    /* renamed from: a */
    private static void m12486a(C6491h cos, C6444Pa exception, int chainDepth, int maxChainedExceptionsDepth, int field) throws Exception {
        cos.mo19564f(field, 2);
        cos.mo19572l(m12470a(exception, 1, maxChainedExceptionsDepth));
        cos.mo19556b(1, C6481d.m12660a(exception.f11543b));
        String message = exception.f11542a;
        if (message != null) {
            cos.mo19556b(3, C6481d.m12660a(message));
        }
        for (StackTraceElement element : exception.f11544c) {
            m12483a(cos, 4, element, true);
        }
        C6444Pa cause = exception.f11545d;
        if (cause == null) {
            return;
        }
        if (chainDepth < maxChainedExceptionsDepth) {
            m12486a(cos, cause, chainDepth + 1, maxChainedExceptionsDepth, 6);
            return;
        }
        int overflowCount = 0;
        while (cause != null) {
            cause = cause.f11545d;
            overflowCount++;
        }
        cos.mo19567g(7, overflowCount);
    }

    /* renamed from: a */
    private static void m12495a(C6491h cos, Thread thread, StackTraceElement[] stackTraceElements, int importance, boolean isCrashedThread) throws Exception {
        cos.mo19564f(1, 2);
        cos.mo19572l(m12481a(thread, stackTraceElements, importance, isCrashedThread));
        cos.mo19556b(1, C6481d.m12660a(thread.getName()));
        cos.mo19567g(2, importance);
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            m12483a(cos, 3, stackTraceElement, isCrashedThread);
        }
    }

    /* renamed from: a */
    private static void m12483a(C6491h cos, int fieldIndex, StackTraceElement element, boolean isCrashedThread) throws Exception {
        cos.mo19564f(fieldIndex, 2);
        cos.mo19572l(m12479a(element, isCrashedThread));
        if (element.isNativeMethod()) {
            cos.mo19555b(1, (long) Math.max(element.getLineNumber(), 0));
        } else {
            cos.mo19555b(1, 0);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(element.getClassName());
        sb.append(".");
        sb.append(element.getMethodName());
        cos.mo19556b(2, C6481d.m12660a(sb.toString()));
        if (element.getFileName() != null) {
            cos.mo19556b(3, C6481d.m12660a(element.getFileName()));
        }
        int i = 4;
        if (!element.isNativeMethod() && element.getLineNumber() > 0) {
            cos.mo19555b(4, (long) element.getLineNumber());
        }
        if (!isCrashedThread) {
            i = 0;
        }
        cos.mo19567g(5, i);
    }

    /* renamed from: a */
    private static void m12490a(C6491h cos, Float batteryLevel, int batteryVelocity, boolean proximityEnabled, int orientation, long heapAllocatedSize, long diskUsed) throws Exception {
        cos.mo19564f(5, 2);
        cos.mo19572l(m12478a(batteryLevel, batteryVelocity, proximityEnabled, orientation, heapAllocatedSize, diskUsed));
        if (batteryLevel != null) {
            cos.mo19554b(1, batteryLevel.floatValue());
        }
        cos.mo19562e(2, batteryVelocity);
        cos.mo19557b(3, proximityEnabled);
        cos.mo19567g(4, orientation);
        cos.mo19555b(5, heapAllocatedSize);
        cos.mo19555b(6, diskUsed);
    }

    /* renamed from: a */
    private static void m12489a(C6491h cos, C6481d log) throws Exception {
        if (log != null) {
            cos.mo19564f(6, 2);
            cos.mo19572l(m12473a(log));
            cos.mo19556b(1, log);
        }
    }

    /* renamed from: a */
    private static int m12475a(C6481d packageName, C6481d apiKey, C6481d versionCode, C6481d versionName, C6481d installUuid, int deliveryMechanism, C6481d unityVersion) {
        int size = 0 + C6491h.m12684a(1, packageName) + C6491h.m12684a(2, versionCode) + C6491h.m12684a(3, versionName);
        int orgSize = m12497b(apiKey);
        int size2 = size + C6491h.m12698e(5) + C6491h.m12693c(orgSize) + orgSize + C6491h.m12684a(6, installUuid);
        if (unityVersion != null) {
            size2 = size2 + C6491h.m12684a(8, f11537b) + C6491h.m12684a(9, unityVersion);
        }
        return size2 + C6491h.m12682a(10, deliveryMechanism);
    }

    /* renamed from: b */
    private static int m12497b(C6481d apiKey) {
        return 0 + C6491h.m12684a(1, apiKey);
    }

    /* renamed from: a */
    private static int m12476a(C6481d release, C6481d codeName, boolean isRooted) {
        return 0 + C6491h.m12682a(1, 3) + C6491h.m12684a(2, release) + C6491h.m12684a(3, codeName) + C6491h.m12685a(4, isRooted);
    }

    /* renamed from: a */
    private static int m12477a(C13869a type, String value) {
        return C6491h.m12682a(1, type.f42090i) + C6491h.m12684a(2, C6481d.m12660a(value));
    }

    /* renamed from: a */
    private static int m12468a(int arch, C6481d model, int availableProcessors, long totalRam, long diskSpace, boolean isEmulator, Map<C13869a, String> ids, int state, C6481d manufacturer, C6481d modelClass) {
        C6481d dVar = model;
        C6481d dVar2 = manufacturer;
        C6481d dVar3 = modelClass;
        int i = 0;
        int size = 0 + C6491h.m12682a(3, arch) + (dVar == null ? 0 : C6491h.m12684a(4, dVar)) + C6491h.m12694c(5, availableProcessors) + C6491h.m12683a(6, totalRam) + C6491h.m12683a(7, diskSpace) + C6491h.m12685a(10, isEmulator);
        if (ids != null) {
            for (Entry<DeviceIdentifierType, String> id : ids.entrySet()) {
                int idSize = m12477a((C13869a) id.getKey(), (String) id.getValue());
                size += C6491h.m12698e(11) + C6491h.m12693c(idSize) + idSize;
            }
        }
        int size2 = size + C6491h.m12694c(12, state) + (dVar2 == null ? 0 : C6491h.m12684a(13, dVar2));
        if (dVar3 != null) {
            i = C6491h.m12684a(14, dVar3);
        }
        return size2 + i;
    }

    /* renamed from: a */
    private static int m12474a(C6481d packageNameBytes, C6481d optionalBuildIdBytes) {
        int size = 0 + C6491h.m12683a(1, 0) + C6491h.m12683a(2, 0) + C6491h.m12684a(3, packageNameBytes);
        if (optionalBuildIdBytes != null) {
            return size + C6491h.m12684a(4, optionalBuildIdBytes);
        }
        return size;
    }

    /* renamed from: a */
    private static int m12469a(long eventTime, String eventType, C6444Pa exception, Thread exceptionThread, StackTraceElement[] exceptionStack, Thread[] otherThreads, List<StackTraceElement[]> otherStacks, int maxChainedExceptionsDepth, Map<String, String> customAttributes, RunningAppProcessInfo runningAppProcessInfo, int orientation, C6481d packageNameBytes, C6481d optionalBuildIdBytes, Float batteryLevel, int batteryVelocity, boolean proximityEnabled, long heapAllocatedSize, long diskUsed, C6481d log) {
        int size = 0 + C6491h.m12683a(1, eventTime) + C6491h.m12684a(2, C6481d.m12660a(eventType));
        int eventAppSize = m12472a(exception, exceptionThread, exceptionStack, otherThreads, otherStacks, maxChainedExceptionsDepth, packageNameBytes, optionalBuildIdBytes, customAttributes, runningAppProcessInfo, orientation);
        int size2 = size + C6491h.m12698e(3) + C6491h.m12693c(eventAppSize) + eventAppSize;
        int eventDeviceSize = m12478a(batteryLevel, batteryVelocity, proximityEnabled, orientation, heapAllocatedSize, diskUsed);
        int size3 = size2 + C6491h.m12698e(5) + C6491h.m12693c(eventDeviceSize) + eventDeviceSize;
        if (log == null) {
            return size3;
        }
        int logSize = m12473a(log);
        return size3 + C6491h.m12698e(6) + C6491h.m12693c(logSize) + logSize;
    }

    /* renamed from: a */
    private static int m12472a(C6444Pa exception, Thread exceptionThread, StackTraceElement[] exceptionStack, Thread[] otherThreads, List<StackTraceElement[]> otherStacks, int maxChainedExceptionsDepth, C6481d packageNameBytes, C6481d optionalBuildIdBytes, Map<String, String> customAttributes, RunningAppProcessInfo runningAppProcessInfo, int orientation) {
        RunningAppProcessInfo runningAppProcessInfo2 = runningAppProcessInfo;
        int executionSize = m12471a(exception, exceptionThread, exceptionStack, otherThreads, otherStacks, maxChainedExceptionsDepth, packageNameBytes, optionalBuildIdBytes);
        boolean z = true;
        int size = 0 + C6491h.m12698e(1) + C6491h.m12693c(executionSize) + executionSize;
        if (customAttributes != null) {
            for (Entry<String, String> entry : customAttributes.entrySet()) {
                int entrySize = m12480a((String) entry.getKey(), (String) entry.getValue());
                size += C6491h.m12698e(2) + C6491h.m12693c(entrySize) + entrySize;
            }
        }
        if (runningAppProcessInfo2 != null) {
            if (runningAppProcessInfo2.importance == 100) {
                z = false;
            }
            size += C6491h.m12685a(3, z);
        }
        return size + C6491h.m12694c(4, orientation);
    }

    /* renamed from: a */
    private static int m12471a(C6444Pa exception, Thread exceptionThread, StackTraceElement[] exceptionStack, Thread[] otherThreads, List<StackTraceElement[]> otherStacks, int maxChainedExceptionDepth, C6481d packageNameBytes, C6481d optionalBuildIdBytes) {
        int threadSize = m12481a(exceptionThread, exceptionStack, 4, true);
        int size = 0 + C6491h.m12698e(1) + C6491h.m12693c(threadSize) + threadSize;
        int len = otherThreads.length;
        for (int i = 0; i < len; i++) {
            int threadSize2 = m12481a(otherThreads[i], (StackTraceElement[]) otherStacks.get(i), 0, false);
            size += C6491h.m12698e(1) + C6491h.m12693c(threadSize2) + threadSize2;
        }
        int exceptionSize = m12470a(exception, 1, maxChainedExceptionDepth);
        int size2 = size + C6491h.m12698e(2) + C6491h.m12693c(exceptionSize) + exceptionSize;
        int signalSize = m12467a();
        int size3 = size2 + C6491h.m12698e(3) + C6491h.m12693c(signalSize) + signalSize;
        int binaryImageSize = m12474a(packageNameBytes, optionalBuildIdBytes);
        return size3 + C6491h.m12698e(3) + C6491h.m12693c(binaryImageSize) + binaryImageSize;
    }

    /* renamed from: a */
    private static int m12480a(String key, String value) {
        return C6491h.m12684a(1, C6481d.m12660a(key)) + C6491h.m12684a(2, C6481d.m12660a(value == null ? "" : value));
    }

    /* renamed from: a */
    private static int m12478a(Float batteryLevel, int batteryVelocity, boolean proximityEnabled, int orientation, long heapAllocatedSize, long diskUsed) {
        int size = 0;
        if (batteryLevel != null) {
            size = 0 + C6491h.m12681a(1, batteryLevel.floatValue());
        }
        return size + C6491h.m12692b(2, batteryVelocity) + C6491h.m12685a(3, proximityEnabled) + C6491h.m12694c(4, orientation) + C6491h.m12683a(5, heapAllocatedSize) + C6491h.m12683a(6, diskUsed);
    }

    /* renamed from: a */
    private static int m12473a(C6481d log) {
        return C6491h.m12684a(1, log);
    }

    /* renamed from: a */
    private static int m12470a(C6444Pa ex, int chainDepth, int maxChainedExceptionsDepth) {
        int size = 0 + C6491h.m12684a(1, C6481d.m12660a(ex.f11543b));
        String message = ex.f11542a;
        if (message != null) {
            size += C6491h.m12684a(3, C6481d.m12660a(message));
        }
        for (StackTraceElement element : ex.f11544c) {
            int frameSize = m12479a(element, true);
            size += C6491h.m12698e(4) + C6491h.m12693c(frameSize) + frameSize;
        }
        C6444Pa cause = ex.f11545d;
        if (cause == null) {
            return size;
        }
        if (chainDepth < maxChainedExceptionsDepth) {
            int exceptionSize = m12470a(cause, chainDepth + 1, maxChainedExceptionsDepth);
            return size + C6491h.m12698e(6) + C6491h.m12693c(exceptionSize) + exceptionSize;
        }
        int overflowCount = 0;
        while (cause != null) {
            cause = cause.f11545d;
            overflowCount++;
        }
        return size + C6491h.m12694c(7, overflowCount);
    }

    /* renamed from: a */
    private static int m12467a() {
        return 0 + C6491h.m12684a(1, f11536a) + C6491h.m12684a(2, f11536a) + C6491h.m12683a(3, 0);
    }

    /* renamed from: a */
    private static int m12479a(StackTraceElement element, boolean isCrashedThread) {
        int size;
        int i = 0;
        if (element.isNativeMethod()) {
            size = 0 + C6491h.m12683a(1, (long) Math.max(element.getLineNumber(), 0));
        } else {
            size = 0 + C6491h.m12683a(1, 0);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(element.getClassName());
        sb.append(".");
        sb.append(element.getMethodName());
        int size2 = size + C6491h.m12684a(2, C6481d.m12660a(sb.toString()));
        if (element.getFileName() != null) {
            size2 += C6491h.m12684a(3, C6481d.m12660a(element.getFileName()));
        }
        if (!element.isNativeMethod() && element.getLineNumber() > 0) {
            size2 += C6491h.m12683a(4, (long) element.getLineNumber());
        }
        if (isCrashedThread) {
            i = 2;
        }
        return size2 + C6491h.m12694c(5, i);
    }

    /* renamed from: a */
    private static int m12481a(Thread thread, StackTraceElement[] stackTraceElements, int importance, boolean isCrashedThread) {
        int size = C6491h.m12684a(1, C6481d.m12660a(thread.getName())) + C6491h.m12694c(2, importance);
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            int frameSize = m12479a(stackTraceElement, isCrashedThread);
            size += C6491h.m12698e(3) + C6491h.m12693c(frameSize) + frameSize;
        }
        return size;
    }

    /* renamed from: a */
    private static C6481d m12482a(String s) {
        if (s == null) {
            return null;
        }
        return C6481d.m12660a(s);
    }
}
