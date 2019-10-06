package com.fyber.inneractive.sdk.p174i;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.p165f.C7737f;
import com.fyber.inneractive.sdk.p165f.C7739h.C7740a;
import com.fyber.inneractive.sdk.p165f.C7739h.C7741b;
import com.fyber.inneractive.sdk.util.C8031u;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.List;

/* renamed from: com.fyber.inneractive.sdk.i.j */
public class C7908j extends C7907g {

    /* renamed from: s */
    public C7912m f16049s;

    /* renamed from: a */
    public InneractiveErrorCode mo24718a(InneractiveAdRequest inneractiveAdRequest) {
        C7737f fVar;
        InneractiveErrorCode inneractiveErrorCode;
        String str = this.f16041j;
        C7741b bVar = null;
        if ("VastErrorInvalidFile".equals(str)) {
            inneractiveErrorCode = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
            fVar = C7737f.VAST_ERROR_INVALID_RESPONSE;
        } else if ("ErrorNoCompatibleMediaFile".equals(str)) {
            inneractiveErrorCode = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
            fVar = C7737f.VAST_ERROR_NO_COMPATIBLE_MEDIA_FILE;
            C7912m mVar = this.f16049s;
            if (mVar != null) {
                List<C7899a> list = mVar.f16069f;
                if (list != null && list.size() > 0) {
                    for (C7899a aVar : list) {
                        String str2 = "required_value";
                        bVar = new C7741b().mo24315a("url", aVar.f15980a).mo24315a("bitrate", Integer.valueOf(aVar.f15985f)).mo24315a("mime", TextUtils.isEmpty(aVar.f15982c) ? "na" : aVar.f15982c).mo24315a("delivery", aVar.f15981b).mo24315a("reason", Integer.valueOf(aVar.f15989j.f16001g)).mo24315a(str2, aVar.f15990k);
                    }
                }
            }
        } else if ("VastErrorTooManyWrappers".equals(str)) {
            InneractiveErrorCode inneractiveErrorCode2 = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
            C7737f fVar2 = C7737f.VAST_ERROR_TOO_MANY_WRAPPERS;
            C7741b a = new C7741b().mo24315a("max", Integer.valueOf(IAConfigManager.m17011y()));
            fVar = fVar2;
            inneractiveErrorCode = inneractiveErrorCode2;
            bVar = a;
        } else if ("ErrorNoMediaFiles".equals(str)) {
            inneractiveErrorCode = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
            fVar = C7737f.VAST_ERROR_NO_MEDIA_FILES;
        } else if ("ErrorConfigurationMismatch".equals(str)) {
            inneractiveErrorCode = InneractiveErrorCode.ERROR_CONFIGURATION_MISMATCH;
            fVar = C7737f.INTERNAL_CONFIG_MISMATCH;
        } else if ("VastErrorUnsecure".equals(str)) {
            inneractiveErrorCode = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
            fVar = C7737f.VAST_ERROR_UNSECURE_URL;
        } else {
            inneractiveErrorCode = null;
            fVar = null;
        }
        if (fVar != null) {
            C7740a aVar2 = new C7740a(fVar, inneractiveAdRequest, (C7907g) this);
            if (bVar != null) {
                aVar2.mo24311a(bVar);
            }
            aVar2.mo24314a();
        }
        return inneractiveErrorCode;
    }

    /* renamed from: a */
    public String mo24719a() {
        C7912m mVar = this.f16049s;
        if (mVar != null) {
            String str = mVar.f16065b;
            if (C8031u.m18115a(str)) {
                StringBuilder sb = new StringBuilder("getValidClickThroughUrl: Found a valid click through URL: ");
                sb.append(str);
                IAlog.m18021b(sb.toString());
                return str;
            }
            StringBuilder sb2 = new StringBuilder("getValidClickThroughUrl: Found invalid click through URL: ");
            sb2.append(str);
            IAlog.m18021b(sb2.toString());
        }
        return null;
    }
}
