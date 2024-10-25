package dev.danvega;

import gg.jte.Content;
import gg.jte.TemplateOutput;
import org.springframework.security.web.csrf.CsrfToken;

public class CsrfHiddenInput implements Content {

    private final CsrfToken csrfToken;

    public CsrfHiddenInput(CsrfToken csrfToken) {
        this.csrfToken = csrfToken;
    }

    @Override
    public void writeTo(TemplateOutput templateOutput) {
        if (this.csrfToken != null) {
            templateOutput.writeContent("<input type=\"hidden\" name=\"%s\" value=\"%s\">"
                    .formatted(csrfToken.getParameterName(), csrfToken.getToken()));
        }
    }
}
