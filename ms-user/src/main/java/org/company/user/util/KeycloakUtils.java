package org.company.user.util;

import lombok.extern.slf4j.Slf4j;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KeycloakUtils {

    public String extractUsernameFromToken() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return "undefined";
        }
        if (auth.getPrincipal() instanceof KeycloakPrincipal) {
            KeycloakPrincipal<KeycloakSecurityContext> kp = (KeycloakPrincipal<KeycloakSecurityContext>) auth.getPrincipal();
            String userName = kp.getKeycloakSecurityContext().getToken().getPreferredUsername();
            return userName;
        }
        return null;
    }
}
