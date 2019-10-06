package com.inmobi.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.inmobi.ads.C10478c.C10481c;
import com.inmobi.ads.C10478c.C10489k;
import com.inmobi.commons.core.network.C10676c;
import com.inmobi.commons.core.network.C10677d;
import com.inmobi.commons.core.network.C10678e;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.utilities.C10700d;
import com.inmobi.p207a.C10299n;
import com.inmobi.rendering.p226a.C10738c;
import com.mopub.mobileads.VastResourceXmlManager;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* renamed from: com.inmobi.ads.bu */
/* compiled from: VastHelper */
public class C10470bu {

    /* renamed from: a */
    private static final String f31848a = C10470bu.class.getSimpleName();

    /* renamed from: d */
    private static final Map<String, TrackerEventType> f31849d;

    /* renamed from: b */
    private C10489k f31850b;

    /* renamed from: c */
    private final String f31851c = "Progressive";

    /* renamed from: e */
    private int f31852e = 0;

    /* renamed from: f */
    private C10475bx f31853f;

    static {
        HashMap hashMap = new HashMap();
        f31849d = hashMap;
        hashMap.put("Error", TrackerEventType.TRACKER_EVENT_TYPE_ERROR);
        f31849d.put("Impression", TrackerEventType.TRACKER_EVENT_TYPE_RENDER);
        f31849d.put("ClickTracking", TrackerEventType.TRACKER_EVENT_TYPE_CLICK);
        f31849d.put("creativeView", TrackerEventType.TRACKER_EVENT_TYPE_CREATIVE_VIEW);
        f31849d.put("start", TrackerEventType.TRACKER_EVENT_TYPE_PLAY);
        f31849d.put("firstQuartile", TrackerEventType.TRACKER_EVENT_TYPE_Q1);
        f31849d.put("midpoint", TrackerEventType.TRACKER_EVENT_TYPE_Q2);
        f31849d.put("thirdQuartile", TrackerEventType.TRACKER_EVENT_TYPE_Q3);
        f31849d.put("complete", TrackerEventType.TRACKER_EVENT_TYPE_Q4);
        f31849d.put("mute", TrackerEventType.TRACKER_EVENT_TYPE_MUTE);
        f31849d.put("unmute", TrackerEventType.TRACKER_EVENT_TYPE_UNMUTE);
        f31849d.put("pause", TrackerEventType.TRACKER_EVENT_TYPE_PAUSE);
        f31849d.put("resume", TrackerEventType.TRACKER_EVENT_TYPE_RESUME);
        f31849d.put("fullscreen", TrackerEventType.TRACKER_EVENT_TYPE_FULLSCREEN);
        f31849d.put("exitFullscreen", TrackerEventType.TRACKER_EVENT_TYPE_EXIT_FULLSCREEN);
    }

    public C10470bu(C10489k kVar) {
        this.f31850b = kVar;
        this.f31853f = new C10475bx(this.f31850b);
    }

    /* renamed from: b */
    private static C10677d m34272b(String str) {
        C10676c cVar = new C10676c("GET", str);
        cVar.f32583u = false;
        cVar.f32569A = false;
        cVar.f32582t = true;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C10677d a = new C10678e(cVar).mo34514a();
        try {
            C10299n.m33566a().mo33663a(cVar.mo34509g());
            C10299n.m33566a().mo33664b(a.mo34513c());
            C10299n.m33566a().mo33665c(SystemClock.elapsedRealtime() - elapsedRealtime);
        } catch (Exception e) {
            new StringBuilder("Error in setting request-response data size. ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
        return a;
    }

    /* renamed from: c */
    private static int m34276c(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
            return 0;
        }
    }

    /* renamed from: a */
    static Node m34266a(Node node, String str) {
        List b = m34273b(node, str);
        if (b.size() > 0) {
            return (Node) b.get(0);
        }
        return null;
    }

    /* renamed from: b */
    private static List<Node> m34273b(Node node, String str) {
        ArrayList arrayList = new ArrayList();
        if (node == null || str == null) {
            return arrayList;
        }
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1 && str.equals(item.getNodeName())) {
                arrayList.add(item);
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    private static String m34277c(Node node, String str) {
        return m34263a(m34266a(node, str));
    }

    /* renamed from: a */
    private static Node m34265a(List<Node> list, String str) {
        Node node = null;
        if (list == null) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            node = m34266a((Node) list.get(i), str);
            if (node != null) {
                break;
            }
        }
        return node;
    }

    /* renamed from: a */
    static List<Node> m34264a(Document document, String str) {
        if (document == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        NodeList elementsByTagName = document.getElementsByTagName(str);
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            arrayList.add(elementsByTagName.item(i));
        }
        if (elementsByTagName.getLength() == 0) {
            return null;
        }
        return arrayList;
    }

    /* renamed from: a */
    static String m34263a(Node node) {
        String str;
        if (node == null) {
            return null;
        }
        try {
            str = node.getTextContent();
        } catch (DOMException e) {
            new StringBuilder("Error getting node value; ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            return str.trim();
        }
        return null;
    }

    /* renamed from: a */
    public final C10475bx mo34190a(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Iterator it;
        Iterator it2;
        String str7 = str;
        if (str7 == null || str.isEmpty()) {
            m34267a(303);
            return this.f31853f;
        }
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(str7)));
            Node a = m34266a((Node) parse, "VAST");
            if (a == null) {
                m34267a(101);
                return this.f31853f;
            }
            Node a2 = m34266a(a, "Ad");
            if (a2 == null) {
                m34267a(303);
                return this.f31853f;
            }
            Node a3 = m34266a(a2, "Wrapper");
            String str8 = "ClickTracking";
            String str9 = "Tracking";
            String str10 = "TrackingEvents";
            if (a3 != null) {
                this.f31852e++;
                if (this.f31852e > this.f31850b.f31959a) {
                    m34267a(302);
                    return this.f31853f;
                } else if (!m34275b(a3)) {
                    m34267a(101);
                    return this.f31853f;
                } else {
                    List a4 = m34264a(parse, str10);
                    if (a4 != null) {
                        m34268a(m34273b((Node) a4.get(0), str9));
                    }
                    C10607x.m34799a(parse, this.f31853f);
                    C10379ag.m33917a(parse, this.f31853f);
                    m34270a(TrackerEventType.TRACKER_EVENT_TYPE_CLICK, m34264a(parse, str8));
                    String c = m34277c(a3, "VASTAdTagURI");
                    if (c == null) {
                        m34267a(101);
                        return this.f31853f;
                    } else if (c == null || c.isEmpty()) {
                        m34267a(300);
                    } else {
                        C10677d b = m34272b(c);
                        if (b.mo34510a()) {
                            m34267a(301);
                        } else {
                            mo34190a(b.mo34511b());
                        }
                    }
                }
            } else {
                Node a5 = m34266a(a2, "InLine");
                if (a5 == null) {
                    m34267a(101);
                    return this.f31853f;
                } else if (!m34275b(a5)) {
                    m34267a(101);
                    return this.f31853f;
                } else {
                    Node a6 = m34266a(a5, "Creatives");
                    if (a6 == null) {
                        m34267a(101);
                        return this.f31853f;
                    }
                    String str11 = "Creative";
                    List b2 = m34273b(a6, str11);
                    if (b2.isEmpty()) {
                        m34267a(101);
                        return this.f31853f;
                    }
                    Node a7 = m34265a(b2, "Linear");
                    if (a7 == null) {
                        m34267a(201);
                        return this.f31853f;
                    }
                    List b3 = m34273b(a7, "Duration");
                    if (b3.isEmpty()) {
                        m34267a(101);
                        return this.f31853f;
                    }
                    String a8 = m34263a((Node) b3.get(0));
                    if (a8 == null || a8.isEmpty() || !a8.matches("\\d*:[0-5][0-9]:[0-5][0-9](:[0-9][0-9][0-9])?")) {
                        m34267a(101);
                        return this.f31853f;
                    }
                    this.f31853f.f31873b = a8;
                    Node a9 = m34266a(a7, "MediaFiles");
                    if (a9 == null) {
                        m34267a(101);
                        return this.f31853f;
                    }
                    Node a10 = m34266a(a7, "VideoClicks");
                    this.f31853f.f31874c = m34277c(a10, "ClickThrough");
                    m34270a(TrackerEventType.TRACKER_EVENT_TYPE_CLICK, m34273b(a10, str8));
                    m34268a(m34273b(m34266a(a7, str10), str9));
                    C10607x.m34799a(parse, this.f31853f);
                    C10379ag.m33917a(parse, this.f31853f);
                    List b4 = m34273b(a9, "MediaFile");
                    if (b4.isEmpty()) {
                        m34267a(401);
                        return this.f31853f;
                    }
                    C10481c cVar = this.f31850b.f31962d;
                    for (int i = 0; i < b4.size(); i++) {
                        Element element = (Element) b4.get(i);
                        String a11 = m34263a((Node) element);
                        if (URLUtil.isValidUrl(a11)) {
                            String attribute = element.getAttribute("delivery");
                            String attribute2 = element.getAttribute("type");
                            int c2 = m34276c(element.getAttribute("bitrate"));
                            if ((!cVar.f31921a || c2 > 0) && attribute != null && attribute.trim().equalsIgnoreCase("Progressive")) {
                                ArrayList<String> arrayList = this.f31850b.f31963e;
                                if (attribute2 != null) {
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 >= arrayList.size()) {
                                            break;
                                        } else if (attribute2.equalsIgnoreCase((String) arrayList.get(i2))) {
                                            this.f31853f.f31872a.add(new C10471bv(a11, attribute, attribute2, c2));
                                            break;
                                        } else {
                                            i2++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (this.f31853f.f31872a.isEmpty()) {
                        m34267a(403);
                    }
                    List b5 = m34273b(a6, str11);
                    if (b5.isEmpty()) {
                        m34267a(101);
                        return this.f31853f;
                    }
                    Node a12 = m34265a(b5, "CompanionAds");
                    if (a12 == null) {
                        return this.f31853f;
                    }
                    List a13 = m34264a(parse, "CompanionAdTracking");
                    HashMap hashMap = new HashMap();
                    String str12 = "; Discarding this tracker";
                    String str13 = "Malformed URL: ";
                    String str14 = "event";
                    String str15 = "id";
                    if (a13 != null) {
                        Iterator it3 = a13.iterator();
                        while (it3.hasNext()) {
                            Iterator it4 = m34273b((Node) it3.next(), str10).iterator();
                            while (it4.hasNext()) {
                                Node node = (Node) it4.next();
                                NamedNodeMap attributes = node.getAttributes();
                                Node namedItem = (attributes == null || attributes.getLength() <= 0) ? null : attributes.getNamedItem(str15);
                                if (namedItem != null) {
                                    String nodeValue = namedItem.getNodeValue();
                                    for (Node node2 : m34273b(node, str9)) {
                                        if ("closeEndCard".equals(((Element) node2).getAttribute(str14))) {
                                            String a14 = m34263a(node2);
                                            if (!URLUtil.isValidUrl(a14)) {
                                                StringBuilder sb = new StringBuilder(str13);
                                                sb.append(a14);
                                                sb.append(str12);
                                            } else {
                                                it2 = it3;
                                                it = it4;
                                                hashMap.put(nodeValue, new NativeTracker(a14, 0, TrackerEventType.TRACKER_EVENT_TYPE_END_CARD_CLOSE, null));
                                            }
                                        } else {
                                            it2 = it3;
                                            it = it4;
                                        }
                                        it3 = it2;
                                        it4 = it;
                                    }
                                }
                                it3 = it3;
                                it4 = it4;
                            }
                            Iterator it5 = it3;
                        }
                    }
                    List b6 = m34273b(a12, "Companion");
                    int i3 = 0;
                    boolean z = false;
                    while (i3 < b6.size()) {
                        Element element2 = (Element) b6.get(i3);
                        int c3 = m34276c(element2.getAttribute("width"));
                        int c4 = m34276c(element2.getAttribute("height"));
                        if (c3 == 0 || c4 == 0) {
                            str2 = str12;
                            str4 = str13;
                            str3 = str15;
                        } else {
                            String c5 = m34277c(element2, "CompanionClickThrough");
                            if (!URLUtil.isValidUrl(c5)) {
                                c5 = null;
                            }
                            String attribute3 = element2.hasAttribute(str15) ? element2.getAttribute(str15) : null;
                            str3 = str15;
                            C10468bt btVar = new C10468bt(c3, c4, c5, attribute3);
                            Node a15 = m34266a((Node) element2, VastResourceXmlManager.STATIC_RESOURCE);
                            if (a15 != null) {
                                String a16 = m34263a(a15);
                                String attribute4 = ((Element) a15).getAttribute(VastResourceXmlManager.CREATIVE_TYPE);
                                if (attribute4 != null && !attribute4.trim().isEmpty()) {
                                    if (m34278d(attribute4)) {
                                        btVar.mo34187a(new C10469a(1, a16));
                                    } else {
                                        z = true;
                                    }
                                }
                            }
                            Node a17 = m34266a((Node) element2, VastResourceXmlManager.HTML_RESOURCE);
                            if (a17 != null) {
                                btVar.mo34187a(new C10469a(2, m34263a(a17)));
                            }
                            Node a18 = m34266a((Node) element2, VastResourceXmlManager.IFRAME_RESOURCE);
                            if (a18 != null) {
                                btVar.mo34187a(new C10469a(3, m34263a(a18)));
                            }
                            List<C10469a> list = btVar.f31841c;
                            if (list == null || list.size() == 0) {
                                str2 = str12;
                                str4 = str13;
                            } else {
                                m34269a(m34273b(element2, "CompanionClickTracking"), btVar);
                                for (Node node3 : m34273b(m34266a((Node) element2, str10), str9)) {
                                    String attribute5 = ((Element) node3).getAttribute(str14);
                                    if (f31849d.containsKey(attribute5)) {
                                        String a19 = m34263a(node3);
                                        if (!URLUtil.isValidUrl(a19)) {
                                            StringBuilder sb2 = new StringBuilder(str13);
                                            sb2.append(a19);
                                            sb2.append(str12);
                                        } else {
                                            str5 = str12;
                                            str6 = str13;
                                            btVar.mo34186a(new NativeTracker(a19, 0, (TrackerEventType) f31849d.get(attribute5), null));
                                        }
                                    } else {
                                        str5 = str12;
                                        str6 = str13;
                                    }
                                    str13 = str6;
                                    str12 = str5;
                                }
                                str2 = str12;
                                str4 = str13;
                                if (attribute3 != null && hashMap.containsKey(attribute3)) {
                                    btVar.mo34186a((NativeTracker) hashMap.get(attribute3));
                                }
                                this.f31853f.f31876e.add(btVar);
                            }
                        }
                        i3++;
                        str13 = str4;
                        str15 = str3;
                        str12 = str2;
                    }
                    int size = this.f31853f.f31876e.size();
                    if (size == 0 && z) {
                        m34274b(604);
                    } else if (b6.size() > 0 && size == 0) {
                        m34274b(600);
                    }
                }
            }
            return this.f31853f;
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            m34267a(100);
            C10621a.m34854a().mo34423a(new C10658a(e));
            return this.f31853f;
        }
    }

    /* renamed from: d */
    private static boolean m34278d(String str) {
        int size = C10468bt.f31837f.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase((String) C10468bt.f31837f.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static void m34269a(List<Node> list, C10468bt btVar) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Node node = (Node) list.get(i);
                if (1 == node.getNodeType()) {
                    String a = m34263a(node);
                    if (!URLUtil.isValidUrl(a)) {
                        StringBuilder sb = new StringBuilder("Malformed URL: ");
                        sb.append(a);
                        sb.append("; Discarding this tracker");
                    } else {
                        btVar.mo34186a(new NativeTracker(a, 0, TrackerEventType.TRACKER_EVENT_TYPE_CLICK, null));
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private boolean m34275b(Node node) {
        if (node == null) {
            return false;
        }
        m34270a(TrackerEventType.TRACKER_EVENT_TYPE_ERROR, m34273b(node, "Error"));
        List b = m34273b(node, "Impression");
        if (b.isEmpty()) {
            return false;
        }
        return m34270a(TrackerEventType.TRACKER_EVENT_TYPE_RENDER, b);
    }

    /* renamed from: a */
    private void m34268a(List<Node> list) {
        if (list != null && list.size() != 0) {
            for (Node node : list) {
                String attribute = ((Element) node).getAttribute("event");
                if (f31849d.containsKey(attribute)) {
                    m34271a((TrackerEventType) f31849d.get(attribute), node);
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m34270a(TrackerEventType trackerEventType, List<Node> list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Node node = (Node) list.get(i);
                if (node.getNodeType() == 1 && !m34271a(trackerEventType, node)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m34271a(TrackerEventType trackerEventType, Node node) {
        String a = m34263a(node);
        if (!URLUtil.isValidUrl(a)) {
            StringBuilder sb = new StringBuilder("Malformed URL ");
            sb.append(a);
            sb.append(" Discarding this tracker");
            return trackerEventType != TrackerEventType.TRACKER_EVENT_TYPE_RENDER;
        }
        this.f31853f.mo34196a(new NativeTracker(a, 0, trackerEventType, null));
        return true;
    }

    /* renamed from: a */
    private void m34267a(int i) {
        this.f31853f.f31877f = i;
        m34274b(i);
    }

    /* renamed from: b */
    private void m34274b(int i) {
        C10738c a = C10738c.m35282a();
        HashMap hashMap = new HashMap();
        hashMap.put("[ERRORCODE]", String.valueOf(i));
        for (NativeTracker nativeTracker : this.f31853f.f31875d) {
            if (nativeTracker.f31378b == TrackerEventType.TRACKER_EVENT_TYPE_ERROR) {
                a.mo34653a(C10700d.m35142a(nativeTracker.f31377a, (Map<String, String>) hashMap), nativeTracker.f31379c);
            }
        }
    }
}
