package ua.train.project_logistics_servlets.service.utility;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.ResourceBundle;

import static ua.train.project_logistics_servlets.constant.RegexConstant.REGEX_BUNDLE;
import static ua.train.project_logistics_servlets.constant.WebConstant.*;

public class GetRegexBundleUtility {

    public ResourceBundle getBundle(HttpServletRequest request) {

        if(request.getSession().getAttribute(LANGUAGE_ATTRIBUTE) == null ||
                request.getSession().getAttribute(LANGUAGE_ATTRIBUTE).equals(EN_LANGUAGE)) {

            return ResourceBundle.getBundle(REGEX_BUNDLE);

        }else {
            return ResourceBundle.getBundle(REGEX_BUNDLE, Locale.forLanguageTag(UA_LANGUAGE));
        }
    }
}
