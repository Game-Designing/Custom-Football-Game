package com.smaato.soma.p236a;

import com.smaato.soma.C12064Na;
import com.smaato.soma.p236a.p237a.C12110a;

/* renamed from: com.smaato.soma.a.y */
/* compiled from: ImageBanner */
public class C12138y extends C12125n {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final String mo39339a(C12064Na imageBanner, int width, int height, boolean isFullScreen) {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html><html lang='en' style='height:100%;'>  <head>    <meta name='viewport' content='width=device-width,height=device-height,initial-scale=1.0'/>    <script>      var clicked = false;      function isClicked() {        if(!clicked) { clicked = true; return false; }        return clicked;      }      window.onclick = function() {        if(!isClicked()) { window.location='");
        sb.append(imageBanner.mo39297l());
        sb.append("'; }      };    </script>  </head>  <body style='margin: 0; padding: 0; background:black; min-height:100%; ");
        sb.append(C12110a.m39907a());
        sb.append("' >    <div id='smaato-ad-container'>      <img style='display: inline; height: auto; max-width: 100%;' src='");
        sb.append(imageBanner.mo39296k());
        sb.append("'/>");
        sb.append(C12125n.m39912a(imageBanner));
        sb.append("    </div>  </body></html>");
        return sb.toString();
    }
}
