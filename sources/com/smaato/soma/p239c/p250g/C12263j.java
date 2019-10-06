package com.smaato.soma.p239c.p250g;

import android.webkit.MimeTypeMap;
import com.mopub.mobileads.VastResourceXmlManager;
import com.smaato.soma.C12064Na;
import com.smaato.soma.C12408ia;
import com.smaato.soma.C12431j;
import com.smaato.soma.exception.ParserException;
import com.smaato.soma.internal.extensions.Extension;
import com.smaato.soma.internal.vast.CompanionAd;
import com.smaato.soma.p236a.p237a.C12111b;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.C12203d;
import com.smaato.soma.p239c.p243d.C12204a;
import com.smaato.soma.p239c.p246f.C12252w;
import com.smaato.soma.p239c.p252i.C12280f;
import com.smaato.soma.p239c.p253j.C12282a;
import com.smaato.soma.p239c.p253j.C12285d;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* renamed from: com.smaato.soma.c.g.j */
/* compiled from: ReceivedXmlBodyParser */
public class C12263j {

    /* renamed from: a */
    private static final String f38392a = C12263j.class.getSimpleName();

    /* renamed from: b */
    private static final List<String> f38393b = Arrays.asList(new String[]{"video/mp4", "video/3gpp", "video/3gp", "video/m4v", "video/mov"});

    /* renamed from: c */
    private static final List<String> f38394c = Arrays.asList(new String[]{"mp4", "3gpp", "3gp", "m4v", "mov"});

    /* renamed from: a */
    public C12064Na mo39637a(InputStream in) throws ParserException {
        return m40341a(in, (C12285d) null);
    }

    /* renamed from: a */
    private C12064Na m40341a(InputStream in, C12285d vastAd) throws ParserException {
        try {
            return m40348b(in, vastAd);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new ParserException("Error during the XML parsing.", e2);
        }
    }

    /* renamed from: b */
    private C12064Na m40348b(InputStream in, C12285d vastAd) throws ParserConfigurationException, IOException, SAXException, ParserException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setCoalescing(true);
        Element entry = null;
        Document dom = dbf.newDocumentBuilder().parse(in);
        if (dom != null) {
            entry = dom.getDocumentElement();
        }
        if (entry != null) {
            C12203d banner = new C12203d();
            if ("VAST".equals(entry.getNodeName())) {
                return m40343a(entry, vastAd, banner);
            }
            m40342a(entry, banner);
            return banner;
        }
        String str = "Error during the XML parsing. Can't find the response tag.";
        C12146d.m39965a(new C12147e(f38392a, str, 1, C12143a.WARNING));
        throw new ParserException(str);
    }

    /* renamed from: a */
    private C12064Na m40342a(Element entry, C12203d banner) {
        NodeList mErrorCodeList = entry.getElementsByTagName("code");
        if (mErrorCodeList.getLength() > 0) {
            Element mErrorCode = (Element) mErrorCodeList.item(0);
            if (mErrorCode.getFirstChild() != null) {
                banner.mo39280a(C12408ia.m40800a(mErrorCode.getFirstChild().getNodeValue()));
            }
        }
        NodeList mErrorMessageList = entry.getElementsByTagName("desc");
        if (mErrorMessageList.getLength() > 0) {
            Element mErrorMessage = (Element) mErrorMessageList.item(0);
            if (mErrorMessage.getFirstChild() != null) {
                banner.mo39506d(mErrorMessage.getFirstChild().getNodeValue());
            }
        }
        return banner;
    }

    /* renamed from: a */
    private C12064Na m40343a(Element entry, C12285d vastAd, C12203d banner) {
        HttpURLConnection connection;
        if (vastAd == null) {
            vastAd = new C12285d();
        }
        vastAd.mo39698b(m40346a(entry, "Impression"));
        vastAd.mo39695a(m40346a(entry, "Error"));
        vastAd.mo39697b(m40345a(m40347a("Duration", entry)));
        for (Entry<String, String> e : m40353f(entry)) {
            vastAd.mo39694a((String) e.getKey(), (String) e.getValue());
        }
        vastAd.mo39700c(m40345a(m40347a("ClickThrough", entry)));
        vastAd.mo39701c(m40346a(entry, "ClickTracking"));
        String mediaFileUrl = m40352e(entry);
        if (mediaFileUrl != null) {
            vastAd.mo39703d(mediaFileUrl);
            banner.mo39280a(C12408ia.NO_ERROR);
            banner.mo39278a(C12111b.f37994b);
        } else {
            banner.mo39280a(C12408ia.NO_AD_AVAILABLE);
        }
        List<CompanionAd> companionAds = m40349b(entry);
        if (!companionAds.isEmpty()) {
            vastAd.mo39693a((C12282a) companionAds.get(companionAds.size() - 1));
        }
        String vastAdTagUrl = m40354g(entry);
        if (vastAdTagUrl != null) {
            try {
                URL url = new URL(vastAdTagUrl);
                if (C12252w.m40307b().mo39627c() == null) {
                    connection = (HttpURLConnection) url.openConnection();
                } else {
                    connection = (HttpURLConnection) url.openConnection(C12252w.m40307b().mo39627c());
                }
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                connection.setRequestProperty("User-Agent", C12252w.m40307b().mo39629e());
                connection.connect();
                return m40341a(connection.getInputStream(), vastAd);
            } catch (Exception e2) {
            }
        }
        List<Extension> extensions = m40351d(entry);
        vastAd.mo39704d(extensions);
        banner.mo39504b(extensions);
        banner.mo39500a(vastAd);
        banner.mo39501a(C12431j.f38814h);
        return banner;
    }

    /* renamed from: a */
    private static Node m40347a(String tagName, Element parent) {
        if (parent != null) {
            return parent.getElementsByTagName(tagName).item(0);
        }
        return null;
    }

    /* renamed from: a */
    private static String m40345a(Node element) {
        if (!(element == null || element.getFirstChild() == null)) {
            String result = element.getFirstChild().getNodeValue();
            if (result != null) {
                return C12280f.m40426a(result);
            }
        }
        return null;
    }

    /* renamed from: d */
    private static List<C12204a> m40351d(Element entry) {
        List<Extension> result = new ArrayList<>();
        NodeList extensionsElements = entry.getElementsByTagName("Extension");
        for (int i = 0; i < extensionsElements.getLength(); i++) {
            Element extensionElement = (Element) extensionsElements.item(i);
            if ("smaato".equals(extensionElement.getAttribute("AdServer"))) {
                result.add(m40350c(extensionElement));
            }
        }
        return result;
    }

    /* renamed from: c */
    private static C12204a m40350c(Element entry) {
        String name = m40345a((Node) (Element) m40347a("Name", entry));
        String script = null;
        Map<String, String> conf = new HashMap<>();
        Element scriptElement = (Element) m40347a("Script", entry);
        if (scriptElement != null) {
            script = m40345a((Node) scriptElement);
        }
        Element confElement = (Element) m40347a("Conf", entry);
        if (confElement != null) {
            for (int j = 0; j < confElement.getChildNodes().getLength(); j++) {
                Node child = confElement.getChildNodes().item(j);
                if (child.getNodeType() == 1) {
                    Element confItem = (Element) child;
                    conf.put(confItem.getTagName(), m40345a((Node) confItem));
                }
            }
        }
        return new C12204a(name, script, conf);
    }

    /* renamed from: g */
    private static String m40354g(Element entry) {
        Element wrapper = (Element) m40347a("Wrapper", entry);
        if (wrapper != null) {
            return m40345a(m40347a("VASTAdTagURI", wrapper));
        }
        return null;
    }

    /* renamed from: b */
    private static List<C12282a> m40349b(Element entry) {
        List<CompanionAd> result = new ArrayList<>();
        NodeList mCompanionList = entry.getElementsByTagName("Companion");
        for (int i = 0; i < mCompanionList.getLength(); i++) {
            result.add(m40344a((Element) mCompanionList.item(i)));
        }
        return result;
    }

    /* renamed from: a */
    private static C12282a m40344a(Element companion) {
        C12282a companionAd = new C12282a();
        companionAd.mo39683b(Integer.parseInt(companion.getAttribute("width")));
        companionAd.mo39679a(Integer.parseInt(companion.getAttribute("height")));
        Element htmlResourceElement = (Element) m40347a(VastResourceXmlManager.HTML_RESOURCE, companion);
        Element staticResourceElement = (Element) m40347a(VastResourceXmlManager.STATIC_RESOURCE, companion);
        if (staticResourceElement != null && staticResourceElement.getAttribute(VastResourceXmlManager.CREATIVE_TYPE).contains("image/")) {
            companionAd.mo39686c(m40345a((Node) staticResourceElement));
        } else if (htmlResourceElement != null) {
            companionAd.mo39684b(m40345a((Node) htmlResourceElement));
        }
        NodeList elementTrackingEvents = companion.getElementsByTagName("Tracking");
        for (int j = 0; j < elementTrackingEvents.getLength(); j++) {
            Element tracking = (Element) elementTrackingEvents.item(j);
            String trackingUrl = m40345a((Node) tracking);
            if (trackingUrl != null) {
                if ("creativeView".equals(tracking.getAttribute("event"))) {
                    companionAd.mo39685c().add(trackingUrl);
                }
            }
        }
        companionAd.mo39680a(m40345a(m40347a("CompanionClickThrough", companion)));
        companionAd.mo39681a(new Vector<>(m40346a(companion, "CompanionClickTracking")));
        return companionAd;
    }

    /* renamed from: a */
    private static List<String> m40346a(Element entry, String tagName) {
        List<String> result = new ArrayList<>();
        NodeList nodeList = entry.getElementsByTagName(tagName);
        for (int i = 0; i < nodeList.getLength(); i++) {
            String url = m40345a(nodeList.item(i));
            if (url != null) {
                result.add(url);
            }
        }
        return result;
    }

    /* renamed from: f */
    private static List<Entry<String, String>> m40353f(Element entry) {
        List<Entry<String, String>> result = new ArrayList<>();
        NodeList mTrackingList = entry.getElementsByTagName("Tracking");
        for (int i = 0; i < mTrackingList.getLength(); i++) {
            Element element = (Element) mTrackingList.item(i);
            String event = element.getAttribute("event");
            String url = m40345a((Node) element);
            if (url != null && !event.isEmpty()) {
                result.add(new SimpleEntry(event, url));
            }
        }
        return result;
    }

    /* renamed from: e */
    private static String m40352e(Element entry) {
        NodeList mediaFileList = entry.getElementsByTagName("MediaFile");
        for (int i = 0; i < mediaFileList.getLength(); i++) {
            Element element = (Element) mediaFileList.item(i);
            String url = m40345a((Node) element);
            if (f38393b.contains(element.getAttribute("type")) || f38394c.contains(MimeTypeMap.getFileExtensionFromUrl(url))) {
                return url;
            }
        }
        return null;
    }
}
