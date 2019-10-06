package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.util.DeviceUtils.ForceOrientation;
import com.mopub.mobileads.util.XmlUtils;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* renamed from: com.mopub.mobileads._a */
/* compiled from: VastXmlManager */
class C11377_a {

    /* renamed from: a */
    private Document f35190a;

    C11377_a() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37438a(String xmlString) throws ParserConfigurationException, IOException, SAXException {
        Preconditions.checkNotNull(xmlString, "xmlString cannot be null");
        String xmlString2 = xmlString.replaceFirst("<\\?.*\\?>", "");
        StringBuilder sb = new StringBuilder();
        sb.append("<MPMoVideoXMLDocRoot>");
        sb.append(xmlString2);
        sb.append("</MPMoVideoXMLDocRoot>");
        String documentString = sb.toString();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setCoalescing(true);
        this.f35190a = documentBuilderFactory.newDocumentBuilder().parse(new InputSource(new StringReader(documentString)));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public List<C11466xa> mo37437a() {
        List<VastAdXmlManager> vastAdXmlManagers = new ArrayList<>();
        Document document = this.f35190a;
        if (document == null) {
            return vastAdXmlManagers;
        }
        NodeList nodes = document.getElementsByTagName("Ad");
        for (int i = 0; i < nodes.getLength(); i++) {
            vastAdXmlManagers.add(new C11466xa(nodes.item(i)));
        }
        return vastAdXmlManagers;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public VastTracker mo37443f() {
        Document document = this.f35190a;
        if (document == null) {
            return null;
        }
        String errorTracker = XmlUtils.getFirstMatchingStringData(document, "Error");
        if (TextUtils.isEmpty(errorTracker)) {
            return null;
        }
        return new VastTracker(errorTracker);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public List<VastTracker> mo37444g() {
        List<String> trackers = XmlUtils.getStringDataAsList(this.f35190a, "MP_TRACKING_URL");
        List<VastTracker> vastTrackers = new ArrayList<>(trackers.size());
        for (String tracker : trackers) {
            vastTrackers.add(new VastTracker(tracker));
        }
        return vastTrackers;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo37440c() {
        String customCtaText = XmlUtils.getFirstMatchingStringData(this.f35190a, "MoPubCtaText");
        if (customCtaText == null || customCtaText.length() > 15) {
            return null;
        }
        return customCtaText;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public String mo37442e() {
        String customSkipText = XmlUtils.getFirstMatchingStringData(this.f35190a, "MoPubSkipText");
        if (customSkipText == null || customSkipText.length() > 8) {
            return null;
        }
        return customSkipText;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo37439b() {
        return XmlUtils.getFirstMatchingStringData(this.f35190a, "MoPubCloseIcon");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public ForceOrientation mo37441d() {
        return ForceOrientation.getForceOrientation(XmlUtils.getFirstMatchingStringData(this.f35190a, "MoPubForceOrientation"));
    }
}
