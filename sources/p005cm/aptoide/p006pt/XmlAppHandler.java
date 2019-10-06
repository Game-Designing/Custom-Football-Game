package p005cm.aptoide.p006pt;

import java.util.ArrayList;
import java.util.HashMap;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* renamed from: cm.aptoide.pt.XmlAppHandler */
public class XmlAppHandler extends DefaultHandler {
    private static transient /* synthetic */ boolean[] $jacocoData;
    HashMap<String, String> app;

    /* renamed from: sb */
    StringBuilder f4274sb;
    ArrayList<String> servers = new ArrayList<>();

    /* renamed from: cm.aptoide.pt.XmlAppHandler$1 */
    static /* synthetic */ class C13781 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$XmlAppHandler$Elements = new int[Elements.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(5001665117055872522L, "cm/aptoide/pt/XmlAppHandler$1", 40);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$XmlAppHandler$Elements[Elements.GETAPP.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        try {
                            $jacocoInit[6] = true;
                        } catch (NoSuchFieldError e4) {
                            try {
                                $jacocoInit[8] = true;
                            } catch (NoSuchFieldError e5) {
                                try {
                                    $jacocoInit[10] = true;
                                } catch (NoSuchFieldError e6) {
                                    try {
                                        $jacocoInit[12] = true;
                                    } catch (NoSuchFieldError e7) {
                                        try {
                                            $jacocoInit[14] = true;
                                        } catch (NoSuchFieldError e8) {
                                            try {
                                                $jacocoInit[16] = true;
                                            } catch (NoSuchFieldError e9) {
                                                try {
                                                    $jacocoInit[18] = true;
                                                } catch (NoSuchFieldError e10) {
                                                    try {
                                                        $jacocoInit[20] = true;
                                                    } catch (NoSuchFieldError e11) {
                                                        try {
                                                            $jacocoInit[22] = true;
                                                        } catch (NoSuchFieldError e12) {
                                                            try {
                                                                $jacocoInit[24] = true;
                                                            } catch (NoSuchFieldError e13) {
                                                                try {
                                                                    $jacocoInit[26] = true;
                                                                } catch (NoSuchFieldError e14) {
                                                                    try {
                                                                        $jacocoInit[28] = true;
                                                                    } catch (NoSuchFieldError e15) {
                                                                        try {
                                                                            $jacocoInit[30] = true;
                                                                        } catch (NoSuchFieldError e16) {
                                                                            try {
                                                                                $jacocoInit[32] = true;
                                                                            } catch (NoSuchFieldError e17) {
                                                                                try {
                                                                                    $jacocoInit[34] = true;
                                                                                } catch (NoSuchFieldError e18) {
                                                                                    try {
                                                                                        $jacocoInit[36] = true;
                                                                                    } catch (NoSuchFieldError e19) {
                                                                                        $jacocoInit[38] = true;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$XmlAppHandler$Elements[Elements.NEWSERVER.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$cm$aptoide$pt$XmlAppHandler$Elements[Elements.GET.ordinal()] = 3;
            $jacocoInit[5] = true;
            $SwitchMap$cm$aptoide$pt$XmlAppHandler$Elements[Elements.INTSIZE.ordinal()] = 4;
            $jacocoInit[7] = true;
            $SwitchMap$cm$aptoide$pt$XmlAppHandler$Elements[Elements.MD5SUM.ordinal()] = 5;
            $jacocoInit[9] = true;
            $SwitchMap$cm$aptoide$pt$XmlAppHandler$Elements[Elements.MYAPP.ordinal()] = 6;
            $jacocoInit[11] = true;
            $SwitchMap$cm$aptoide$pt$XmlAppHandler$Elements[Elements.NAME.ordinal()] = 7;
            $jacocoInit[13] = true;
            $SwitchMap$cm$aptoide$pt$XmlAppHandler$Elements[Elements.NOTFOUND.ordinal()] = 8;
            $jacocoInit[15] = true;
            $SwitchMap$cm$aptoide$pt$XmlAppHandler$Elements[Elements.PNAME.ordinal()] = 9;
            $jacocoInit[17] = true;
            $SwitchMap$cm$aptoide$pt$XmlAppHandler$Elements[Elements.SERVER.ordinal()] = 10;
            $jacocoInit[19] = true;
            $SwitchMap$cm$aptoide$pt$XmlAppHandler$Elements[Elements.OBB.ordinal()] = 11;
            $jacocoInit[21] = true;
            $SwitchMap$cm$aptoide$pt$XmlAppHandler$Elements[Elements.MAIN_PATH.ordinal()] = 12;
            $jacocoInit[23] = true;
            $SwitchMap$cm$aptoide$pt$XmlAppHandler$Elements[Elements.MAIN_MD5SUM.ordinal()] = 13;
            $jacocoInit[25] = true;
            $SwitchMap$cm$aptoide$pt$XmlAppHandler$Elements[Elements.MAIN_FILESIZE.ordinal()] = 14;
            $jacocoInit[27] = true;
            $SwitchMap$cm$aptoide$pt$XmlAppHandler$Elements[Elements.MAIN_FILENAME.ordinal()] = 15;
            $jacocoInit[29] = true;
            $SwitchMap$cm$aptoide$pt$XmlAppHandler$Elements[Elements.PATCH_PATH.ordinal()] = 16;
            $jacocoInit[31] = true;
            $SwitchMap$cm$aptoide$pt$XmlAppHandler$Elements[Elements.PATCH_MD5SUM.ordinal()] = 17;
            $jacocoInit[33] = true;
            $SwitchMap$cm$aptoide$pt$XmlAppHandler$Elements[Elements.PATCH_FILESIZE.ordinal()] = 18;
            $jacocoInit[35] = true;
            $SwitchMap$cm$aptoide$pt$XmlAppHandler$Elements[Elements.PATCH_FILENAME.ordinal()] = 19;
            $jacocoInit[37] = true;
            $jacocoInit[39] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.XmlAppHandler$Elements */
    enum Elements {
        MYAPP,
        GETAPP,
        NAME,
        PNAME,
        MD5SUM,
        INTSIZE,
        NEWSERVER,
        SERVER,
        NOTFOUND,
        GET,
        OBB,
        MAIN_PATH,
        MAIN_MD5SUM,
        MAIN_FILESIZE,
        MAIN_FILENAME,
        PATCH_PATH,
        PATCH_MD5SUM,
        PATCH_FILESIZE,
        PATCH_FILENAME;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[5] = true;
        }

        public static Elements lookup(String element) {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                Elements valueOf = valueOf(element);
                $jacocoInit[3] = true;
                return valueOf;
            } catch (Exception e) {
                Elements elements = NOTFOUND;
                $jacocoInit[4] = true;
                return elements;
            }
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-456520729683529494L, "cm/aptoide/pt/XmlAppHandler", 38);
        $jacocoData = probes;
        return probes;
    }

    public XmlAppHandler() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
        this.f4274sb = new StringBuilder();
        $jacocoInit[2] = true;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        boolean[] $jacocoInit = $jacocoInit();
        super.startElement(uri, localName, qName, attributes);
        $jacocoInit[3] = true;
        this.f4274sb.setLength(0);
        $jacocoInit[4] = true;
        int[] iArr = C13781.$SwitchMap$cm$aptoide$pt$XmlAppHandler$Elements;
        String upperCase = localName.toUpperCase();
        $jacocoInit[5] = true;
        String trim = upperCase.trim();
        $jacocoInit[6] = true;
        int i = iArr[Elements.lookup(trim).ordinal()];
        if (i == 1) {
            this.app = new HashMap<>();
            $jacocoInit[8] = true;
        } else if (i != 2) {
            $jacocoInit[7] = true;
        } else {
            $jacocoInit[9] = true;
        }
        $jacocoInit[10] = true;
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        boolean[] $jacocoInit = $jacocoInit();
        int[] iArr = C13781.$SwitchMap$cm$aptoide$pt$XmlAppHandler$Elements;
        String upperCase = localName.toUpperCase();
        $jacocoInit[11] = true;
        String trim = upperCase.trim();
        $jacocoInit[12] = true;
        switch (iArr[Elements.lookup(trim).ordinal()]) {
            case 1:
                $jacocoInit[15] = true;
                break;
            case 2:
                $jacocoInit[20] = true;
                break;
            case 3:
                this.app.put("path", this.f4274sb.toString());
                $jacocoInit[14] = true;
                break;
            case 4:
                this.app.put("size", this.f4274sb.toString());
                $jacocoInit[16] = true;
                break;
            case 5:
                this.app.put("md5sum", this.f4274sb.toString());
                $jacocoInit[17] = true;
                break;
            case 6:
                $jacocoInit[18] = true;
                break;
            case 7:
                this.app.put("name", this.f4274sb.toString());
                $jacocoInit[19] = true;
                break;
            case 8:
                $jacocoInit[21] = true;
                break;
            case 9:
                this.app.put("apkid", this.f4274sb.toString());
                $jacocoInit[22] = true;
                break;
            case 10:
                this.servers.add(this.f4274sb.toString());
                $jacocoInit[23] = true;
                break;
            case 11:
                $jacocoInit[24] = true;
                break;
            case 12:
                this.app.put("main_path", this.f4274sb.toString());
                $jacocoInit[25] = true;
                break;
            case 13:
                this.app.put("main_md5sum", this.f4274sb.toString());
                $jacocoInit[26] = true;
                break;
            case 14:
                this.app.put("main_filesize", this.f4274sb.toString());
                $jacocoInit[27] = true;
                break;
            case 15:
                this.app.put("main_filename", this.f4274sb.toString());
                $jacocoInit[28] = true;
                break;
            case 16:
                this.app.put("patch_path", this.f4274sb.toString());
                $jacocoInit[29] = true;
                break;
            case 17:
                this.app.put("patch_md5sum", this.f4274sb.toString());
                $jacocoInit[30] = true;
                break;
            case 18:
                this.app.put("patch_filesize", this.f4274sb.toString());
                $jacocoInit[31] = true;
                break;
            case 19:
                this.app.put("patch_filename", this.f4274sb.toString());
                $jacocoInit[32] = true;
                break;
            default:
                $jacocoInit[13] = true;
                break;
        }
        super.endElement(uri, localName, qName);
        $jacocoInit[33] = true;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        boolean[] $jacocoInit = $jacocoInit();
        super.characters(ch, start, length);
        $jacocoInit[34] = true;
        this.f4274sb.append(ch, start, length);
        $jacocoInit[35] = true;
    }

    public HashMap<String, String> getApp() {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap<String, String> hashMap = this.app;
        $jacocoInit[36] = true;
        return hashMap;
    }

    public ArrayList<String> getServers() {
        boolean[] $jacocoInit = $jacocoInit();
        ArrayList<String> arrayList = this.servers;
        $jacocoInit[37] = true;
        return arrayList;
    }
}
