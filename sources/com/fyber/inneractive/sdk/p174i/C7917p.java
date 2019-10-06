package com.fyber.inneractive.sdk.p174i;

import android.text.TextUtils;
import android.util.Xml;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.C8016n;
import com.fyber.inneractive.sdk.util.IAlog;
import com.mopub.mobileads.VastResourceXmlManager;
import java.io.IOException;
import java.io.StringReader;
import java.security.InvalidParameterException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.fyber.inneractive.sdk.i.p */
final class C7917p {

    /* renamed from: a */
    volatile boolean f16105a;

    /* renamed from: b */
    String f16106b;

    /* renamed from: c */
    private C7912m f16107c;

    /* renamed from: d */
    private long f16108d;

    /* renamed from: e */
    private boolean f16109e = false;

    /* renamed from: f */
    private final boolean f16110f;

    /* renamed from: com.fyber.inneractive.sdk.i.p$a */
    public class C7918a extends Exception {
        /* synthetic */ C7918a(C7917p pVar, String str, byte b) {
            this(str);
        }

        private C7918a(String str) {
            super(str);
        }
    }

    C7917p(String str, C7912m mVar, boolean z) throws Exception {
        this.f16107c = mVar;
        this.f16110f = z;
        this.f16108d = System.currentTimeMillis();
        if (mVar != null) {
            try {
                m17851a(str);
                IAlog.m18021b("VParser: Parsing finished. parser is ready");
                StringBuilder sb = new StringBuilder("VParser: Total parse time = ");
                sb.append(System.currentTimeMillis() - this.f16108d);
                sb.append(" msec");
                IAlog.m18021b(sb.toString());
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder("VParser: Error parsing VAST XML: ");
                sb2.append(e.getMessage());
                IAlog.m18024e(sb2.toString());
                throw e;
            }
        } else {
            throw new InvalidParameterException("invalid response data. can't be null");
        }
    }

    /* renamed from: a */
    private void m17851a(String str) throws XmlPullParserException, IOException, InvalidParameterException, C7918a {
        IAlog.m18021b("VParser: Start reading VAST");
        if (!TextUtils.isEmpty(str)) {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            newPullParser.setInput(new StringReader(str));
            newPullParser.nextTag();
            newPullParser.require(2, null, "VAST");
            int i = -1;
            while (i != 3 && i != 1) {
                i = newPullParser.next();
                if (newPullParser.getEventType() == 2 && newPullParser.getName().equals("Ad")) {
                    m17852a(newPullParser);
                    this.f16109e = true;
                }
            }
            if (!this.f16109e) {
                throw new XmlPullParserException("No VAST tag found!");
            }
            return;
        }
        throw new InvalidParameterException("vast data is empty");
    }

    /* renamed from: a */
    private void m17852a(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException, C7918a {
        IAlog.m18021b("VParser: Start reading Ad");
        xmlPullParser.require(2, null, "Ad");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                String str = "InLine";
                if (name.equals(str)) {
                    IAlog.m18021b("VParser: VAST file contains inline ad information.");
                    IAlog.m18021b("VParser: Start reading inline");
                    xmlPullParser.require(2, null, str);
                    while (xmlPullParser.next() != 3) {
                        if (xmlPullParser.getEventType() == 2) {
                            String name2 = xmlPullParser.getName();
                            if (name2 == null) {
                                m17862h(xmlPullParser);
                            }
                            String str2 = "Impression";
                            if (name2.equals(str2)) {
                                xmlPullParser.require(2, null, str2);
                                String i = m17863i(xmlPullParser);
                                m17850a(this.f16107c, "impression", i);
                                xmlPullParser.require(3, null, str2);
                                StringBuilder sb = new StringBuilder("VParser: Adding impression event from inline: ");
                                sb.append(i);
                                IAlog.m18021b(sb.toString());
                            } else {
                                String str3 = "AdTitle";
                                if (name2.equals(str3)) {
                                    xmlPullParser.require(2, null, str3);
                                    String i2 = m17863i(xmlPullParser);
                                    this.f16107c.f16067d = i2;
                                    StringBuilder sb2 = new StringBuilder("VParser: Adding title from inline: ");
                                    sb2.append(i2);
                                    IAlog.m18021b(sb2.toString());
                                    xmlPullParser.require(3, null, str3);
                                } else if (name2.equals("Creatives")) {
                                    m17859e(xmlPullParser);
                                } else {
                                    m17862h(xmlPullParser);
                                }
                            }
                        }
                    }
                }
                if (name.equals("Wrapper")) {
                    IAlog.m18021b("VParser: VAST file contains wrapped ad information.");
                    this.f16105a = true;
                    m17861g(xmlPullParser);
                }
            }
        }
    }

    /* renamed from: b */
    private void m17855b(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException, C7918a {
        C7900a aVar;
        boolean z;
        boolean z2;
        int i;
        boolean z3;
        String str;
        String str2;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String str3 = "delivery";
        String str4 = "";
        IAlog.m18021b("VParser: Start reading media files");
        String str5 = null;
        int i2 = 2;
        xmlPullParser2.require(2, null, "MediaFiles");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == i2) {
                String name = xmlPullParser.getName();
                if (name != null) {
                    String str6 = "MediaFile";
                    if (name.equals(str6)) {
                        xmlPullParser2.require(i2, str5, str6);
                        IAlog.m18021b("VParser: Start reading media file");
                        C7900a aVar2 = C7900a.progressive;
                        try {
                            aVar = C7900a.valueOf(xmlPullParser2.getAttributeValue(str4, str3));
                        } catch (IllegalArgumentException e) {
                            StringBuilder sb = new StringBuilder("VParser: Could not parse MediaFile delivery attribute: ");
                            sb.append(xmlPullParser2.getAttributeValue(str4, str3));
                            sb.append(" assuming progressive");
                            IAlog.m18023d(sb.toString());
                            aVar = aVar2;
                        }
                        String attributeValue = xmlPullParser2.getAttributeValue(str4, "apiFramework");
                        StringBuilder sb2 = new StringBuilder("VParser: Media File API framework: ");
                        sb2.append(attributeValue);
                        IAlog.m18021b(sb2.toString());
                        String attributeValue2 = xmlPullParser2.getAttributeValue(str4, "type");
                        StringBuilder sb3 = new StringBuilder("VParser: Media File type: ");
                        sb3.append(attributeValue2);
                        IAlog.m18021b(sb3.toString());
                        String attributeValue3 = xmlPullParser2.getAttributeValue(str4, "width");
                        int intValue = attributeValue3 == null ? 0 : Integer.valueOf(attributeValue3).intValue();
                        StringBuilder sb4 = new StringBuilder("VParser: Media File mWidth: ");
                        sb4.append(intValue);
                        IAlog.m18021b(sb4.toString());
                        String attributeValue4 = xmlPullParser2.getAttributeValue(str4, "height");
                        int intValue2 = attributeValue4 == null ? 0 : Integer.valueOf(attributeValue4).intValue();
                        StringBuilder sb5 = new StringBuilder("VParser: Media File mHeight: ");
                        sb5.append(intValue2);
                        IAlog.m18021b(sb5.toString());
                        String attributeValue5 = xmlPullParser2.getAttributeValue(str4, "scalable");
                        if (attributeValue5 != null) {
                            boolean booleanValue = Boolean.valueOf(attributeValue5).booleanValue();
                            StringBuilder sb6 = new StringBuilder("VParser: Media File scalable: ");
                            sb6.append(booleanValue);
                            IAlog.m18021b(sb6.toString());
                            z = booleanValue;
                        } else {
                            z = true;
                        }
                        String attributeValue6 = xmlPullParser2.getAttributeValue(str4, "maintainAspectRatio");
                        if (attributeValue6 != null) {
                            boolean booleanValue2 = Boolean.valueOf(attributeValue6).booleanValue();
                            StringBuilder sb7 = new StringBuilder("VParser: Media File maintainAspectRatio: ");
                            sb7.append(booleanValue2);
                            IAlog.m18021b(sb7.toString());
                            z2 = booleanValue2;
                        } else {
                            z2 = false;
                        }
                        String attributeValue7 = xmlPullParser2.getAttributeValue(str4, "bitrate");
                        if (attributeValue7 != null) {
                            int intValue3 = Integer.valueOf(attributeValue7).intValue();
                            StringBuilder sb8 = new StringBuilder("VParser: Media File Bitrate: ");
                            sb8.append(intValue3);
                            IAlog.m18021b(sb8.toString());
                            i = intValue3;
                        } else {
                            IAlog.m18021b("VParser: Media File Bitrate not defined!");
                            i = 0;
                        }
                        String i3 = m17863i(xmlPullParser);
                        StringBuilder sb9 = new StringBuilder("VParser: Media File uri: ");
                        sb9.append(i3);
                        IAlog.m18021b(sb9.toString());
                        try {
                            m17856c(i3);
                            z3 = false;
                        } catch (C7918a e2) {
                            z3 = true;
                        }
                        if (!z3) {
                            str2 = str3;
                            str = str4;
                            boolean z4 = z2;
                            C7899a aVar3 = new C7899a(i3, attributeValue2, aVar, intValue, intValue2);
                            aVar3.f15986g = z;
                            aVar3.f15985f = i;
                            aVar3.f15987h = z4;
                            aVar3.f15988i = attributeValue;
                            C7912m mVar = this.f16107c;
                            mVar.f16068e.add(aVar3);
                            String str7 = aVar3.f15988i;
                            if (!TextUtils.isEmpty(str7) && str7.equals(C7912m.f16064a)) {
                                mVar.f16074k = true;
                            }
                        } else {
                            str2 = str3;
                            str = str4;
                            String str8 = i3;
                            StringBuilder sb10 = new StringBuilder("VParser: Insecure Media File - ");
                            sb10.append(str8);
                            sb10.append(" | rejecting");
                            IAlog.m18021b(sb10.toString());
                        }
                        xmlPullParser2.require(3, null, str6);
                        str5 = null;
                        str3 = str2;
                        str4 = str;
                        i2 = 2;
                    }
                }
                String str9 = str3;
                String str10 = str4;
                String str11 = str5;
                m17862h(xmlPullParser);
                str5 = str11;
                str3 = str9;
                str4 = str10;
                i2 = 2;
            } else {
                String str12 = str3;
                String str13 = str4;
                String str14 = str5;
                str4 = str13;
                i2 = 2;
            }
        }
    }

    /* renamed from: a */
    private void m17853a(XmlPullParser xmlPullParser, C7914n nVar) throws IOException, XmlPullParserException, C7918a {
        IAlog.m18021b("VParser: Start reading events");
        xmlPullParser.require(2, null, "TrackingEvents");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null) {
                    String str = "Tracking";
                    if (name.equals(str)) {
                        String attributeValue = xmlPullParser.getAttributeValue("", "event");
                        xmlPullParser.require(2, null, str);
                        String i = m17863i(xmlPullParser);
                        m17850a(nVar, attributeValue, i);
                        StringBuilder sb = new StringBuilder("VParser: Added VAST tracking \"");
                        sb.append(attributeValue);
                        sb.append("\": ");
                        sb.append(i);
                        IAlog.m18021b(sb.toString());
                        xmlPullParser.require(3, null, str);
                    }
                }
                m17862h(xmlPullParser);
            }
        }
    }

    /* renamed from: c */
    private void m17857c(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException, C7918a {
        IAlog.m18021b("VParser: Start reading video clicks");
        xmlPullParser.require(2, null, "VideoClicks");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null) {
                    String str = "ClickThrough";
                    if (name.equals(str)) {
                        xmlPullParser.require(2, null, str);
                        String i = m17863i(xmlPullParser);
                        this.f16107c.f16065b = i;
                        StringBuilder sb = new StringBuilder("VParser: Video clickthrough url: ");
                        sb.append(i);
                        IAlog.m18021b(sb.toString());
                        xmlPullParser.require(3, null, str);
                    }
                }
                if (name != null) {
                    String str2 = "ClickTracking";
                    if (name.equals(str2)) {
                        xmlPullParser.require(2, null, str2);
                        String i2 = m17863i(xmlPullParser);
                        m17850a(this.f16107c, "click", i2);
                        StringBuilder sb2 = new StringBuilder("VParser: Video clicktracking url: ");
                        sb2.append(i2);
                        IAlog.m18021b(sb2.toString());
                        xmlPullParser.require(3, null, str2);
                    }
                }
                m17862h(xmlPullParser);
            }
        }
    }

    /* renamed from: d */
    private void m17858d(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException, C7918a {
        IAlog.m18021b("VParser: Start reading linear");
        xmlPullParser.require(2, null, "Linear");
        while (xmlPullParser.next() != 3) {
            String name = xmlPullParser.getName();
            if (xmlPullParser.getEventType() == 2) {
                if (name != null) {
                    String str = "Duration";
                    if (name.equals(str)) {
                        xmlPullParser.require(2, null, str);
                        String i = m17863i(xmlPullParser);
                        if (!TextUtils.isEmpty(i)) {
                            this.f16107c.f16066c = m17854b(i);
                        }
                        xmlPullParser.require(3, null, str);
                        StringBuilder sb = new StringBuilder("VParser: Video duration: ");
                        sb.append(i);
                        IAlog.m18021b(sb.toString());
                    }
                }
                if (name != null && name.equals("TrackingEvents")) {
                    m17853a(xmlPullParser, this.f16107c);
                } else if (name != null && name.equals("MediaFiles")) {
                    m17855b(xmlPullParser);
                } else if (name != null && name.equals("VideoClicks")) {
                    m17857c(xmlPullParser);
                } else if (name == null || !name.equals("AdTitle")) {
                    m17862h(xmlPullParser);
                } else {
                    this.f16107c.f16067d = m17863i(xmlPullParser);
                }
            }
        }
    }

    /* renamed from: b */
    private static int m17854b(String str) {
        String[] split = str.split(":");
        if (split == null || split.length > 3) {
            return 0;
        }
        if (split.length == 1) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return 0;
            }
        } else if (split.length == 2) {
            try {
                return Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            } catch (NumberFormatException e2) {
                return 0;
            }
        } else {
            try {
                return Integer.parseInt(split[2]) + (Integer.parseInt(split[1]) * 60) + (Integer.parseInt(split[0]) * 3600);
            } catch (NumberFormatException e3) {
                return 0;
            }
        }
    }

    /* renamed from: e */
    private void m17859e(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException, C7918a {
        IAlog.m18021b("VParser: Start reading creatives");
        xmlPullParser.require(2, null, "Creatives");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null) {
                    String str = "Creative";
                    if (name.equals(str)) {
                        IAlog.m18021b("VParser: Start reading creative");
                        xmlPullParser.require(2, null, str);
                        while (xmlPullParser.next() != 3) {
                            if (xmlPullParser.getEventType() == 2) {
                                String name2 = xmlPullParser.getName();
                                if (name2 == null) {
                                    m17862h(xmlPullParser);
                                } else if (name2.equals("Linear")) {
                                    String attributeValue = xmlPullParser.getAttributeValue("", "skipoffset");
                                    String str2 = ":";
                                    if (attributeValue != null && attributeValue.indexOf(str2) < 0) {
                                        int parseInt = Integer.parseInt(attributeValue.substring(0, attributeValue.length() - 1));
                                        this.f16107c.f16072i = parseInt;
                                        StringBuilder sb = new StringBuilder("VParser: Linear skipoffset is ");
                                        sb.append(parseInt);
                                        sb.append(" [%]");
                                        IAlog.m18021b(sb.toString());
                                    } else if (attributeValue != null && attributeValue.indexOf(str2) >= 0) {
                                        IAlog.m18021b("VParser: Absolute time value ignored for skipOffset in VAST xml. Only percentage values will pe parsed.");
                                    }
                                    m17858d(xmlPullParser);
                                } else if (name2.equals("CompanionAds")) {
                                    IAlog.m18021b("VParser: Found Companion ads");
                                    m17860f(xmlPullParser);
                                } else {
                                    m17862h(xmlPullParser);
                                }
                            }
                        }
                    }
                }
                m17862h(xmlPullParser);
            }
        }
    }

    /* renamed from: f */
    private void m17860f(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException, C7918a {
        xmlPullParser.require(2, null, "CompanionAds");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null) {
                    String str = "Companion";
                    if (name.equals(str)) {
                        xmlPullParser.require(2, null, str);
                        C7910l lVar = new C7910l();
                        String str2 = "";
                        lVar.f16052a = Integer.valueOf(xmlPullParser.getAttributeValue(str2, "width")).intValue();
                        lVar.f16053b = Integer.valueOf(xmlPullParser.getAttributeValue(str2, "height")).intValue();
                        while (xmlPullParser.next() != 3) {
                            if (xmlPullParser.getEventType() == 2) {
                                String name2 = xmlPullParser.getName();
                                if (name2 == null) {
                                    m17862h(xmlPullParser);
                                }
                                if (name2.equals(VastResourceXmlManager.IFRAME_RESOURCE) || name2.equals(VastResourceXmlManager.HTML_RESOURCE) || name2.equals(VastResourceXmlManager.STATIC_RESOURCE)) {
                                    lVar.f16054c = name2;
                                    lVar.f16055d = xmlPullParser.getAttributeValue(str2, VastResourceXmlManager.CREATIVE_TYPE);
                                    lVar.f16056e = m17863i(xmlPullParser);
                                } else if (name2.equals("CompanionClickThrough")) {
                                    lVar.f16057f = m17863i(xmlPullParser);
                                } else if (name2.equals("TrackingEvents")) {
                                    m17853a(xmlPullParser, lVar);
                                } else {
                                    m17862h(xmlPullParser);
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(lVar.f16056e)) {
                            this.f16107c.f16070g.add(lVar);
                            StringBuilder sb = new StringBuilder("VParser: Found companion with mWidth = ");
                            sb.append(lVar.f16052a);
                            sb.append(" mHeight = ");
                            sb.append(lVar.f16053b);
                            IAlog.m18021b(sb.toString());
                            StringBuilder sb2 = new StringBuilder("VParser: Found companion type = ");
                            sb2.append(lVar.f16054c);
                            IAlog.m18021b(sb2.toString());
                            StringBuilder sb3 = new StringBuilder("VParser: companion creative type = ");
                            sb3.append(lVar.f16055d);
                            IAlog.m18021b(sb3.toString());
                            StringBuilder sb4 = new StringBuilder("VParser: Found companion content = ");
                            sb4.append(lVar.f16056e);
                            IAlog.m18021b(sb4.toString());
                            StringBuilder sb5 = new StringBuilder("VParser: Found click through url = ");
                            sb5.append(lVar.f16057f);
                            IAlog.m18021b(sb5.toString());
                        }
                    }
                }
                m17862h(xmlPullParser);
            }
        }
    }

    /* renamed from: g */
    private void m17861g(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException, C7918a {
        xmlPullParser.require(2, null, "Wrapper");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name == null) {
                    m17862h(xmlPullParser);
                }
                String str = "Impression";
                if (name.equals(str)) {
                    xmlPullParser.require(2, null, str);
                    String i = m17863i(xmlPullParser);
                    m17850a(this.f16107c, "impression", i);
                    StringBuilder sb = new StringBuilder("VParser: Adding impression tracking url from wrapper: ");
                    sb.append(i);
                    IAlog.m18021b(sb.toString());
                    xmlPullParser.require(3, null, str);
                } else if (name.equals("Creatives")) {
                    m17859e(xmlPullParser);
                } else {
                    String str2 = "VASTAdTagURI";
                    if (name.equals(str2)) {
                        xmlPullParser.require(2, null, str2);
                        String i2 = m17863i(xmlPullParser);
                        xmlPullParser.require(3, null, str2);
                        StringBuilder sb2 = new StringBuilder("VParser: Found wrapper url: ");
                        sb2.append(i2);
                        IAlog.m18021b(sb2.toString());
                        m17856c(i2);
                        this.f16106b = i2;
                    } else {
                        String str3 = "Error";
                        if (name.equals(str3)) {
                            xmlPullParser.require(2, null, str3);
                            String i3 = m17863i(xmlPullParser);
                            m17850a(this.f16107c, "error", i3);
                            StringBuilder sb3 = new StringBuilder("VParser: Adding error tracking url from wrapper: ");
                            sb3.append(i3);
                            IAlog.m18021b(sb3.toString());
                            xmlPullParser.require(3, null, str3);
                        } else {
                            m17862h(xmlPullParser);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: h */
    private static void m17862h(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() == 2) {
            int i = 1;
            while (i != 0) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    i++;
                } else if (next == 3) {
                    i--;
                }
            }
            return;
        }
        throw new IllegalStateException();
    }

    /* renamed from: i */
    private static String m17863i(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        String str;
        if (xmlPullParser.next() == 4) {
            str = xmlPullParser.getText();
            xmlPullParser.nextTag();
        } else {
            StringBuilder sb = new StringBuilder("VParser: readText failed with no text: ");
            sb.append(xmlPullParser.getName());
            IAlog.m18021b(sb.toString());
            str = "";
        }
        return str.trim();
    }

    /* renamed from: a */
    private void m17850a(C7914n nVar, String str, String str2) throws C7918a {
        m17856c(str2);
        nVar.mo24721a(str, str2);
    }

    /* renamed from: c */
    private void m17856c(String str) throws C7918a {
        boolean z;
        if (!C8016n.m18093a() || IAConfigManager.m16957H()) {
            if (str.startsWith("http://") || str.startsWith("http%3A%2F%2F")) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                StringBuilder sb = new StringBuilder("VParser: Unsecure url detected. Aborting! - url: ");
                sb.append(str);
                throw new C7918a(this, sb.toString(), 0);
            }
        }
    }
}
