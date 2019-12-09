package org.apache.tomcat.websocket;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

/**
 * Authenticator supporting the BASIC auth method.
 */
public class BasicAuthenticator extends Authenticator {

    public static final String schemeName = "basic";
    public static final String charsetparam = "charset";

    @Override
    public String getAuthorization(String requestUri, String WWWAuthenticate,
                                   Map<String, Object> userProperties) throws AuthenticationException {

        String userName = (String) userProperties.get(Constants.WS_AUTHENTICATION_USER_NAME);
        String password = (String) userProperties.get(Constants.WS_AUTHENTICATION_PASSWORD);

        if (userName == null || password == null) {
            throw new AuthenticationException(
                    "Failed to perform Basic authentication due to  missing user/password");
        }

        Map<String, String> wwwAuthenticate = parseWWWAuthenticateHeader(WWWAuthenticate);

        String userPass = userName + ":" + password;
        Charset charset;

        if (wwwAuthenticate.get(charsetparam) != null
                && wwwAuthenticate.get(charsetparam).equalsIgnoreCase("UTF-8")) {
            charset = StandardCharsets.UTF_8;
        } else {
            charset = StandardCharsets.ISO_8859_1;
        }

        String base64 = Base64.getEncoder().encodeToString(userPass.getBytes(charset));

        return " Basic " + base64;
    }

    @Override
    public String getSchemeName() {
        return schemeName;
    }

}
