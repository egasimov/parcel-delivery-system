//package org.company.user.provider;
//
//import org.keycloak.Config;
//import org.keycloak.models.KeycloakSession;
//import org.keycloak.models.KeycloakSessionFactory;
//import org.keycloak.services.resource.RealmResourceProvider;
//import org.keycloak.services.resource.RealmResourceProviderFactory;
//import org.springframework.stereotype.Component;
//
//@Component
//public class KeyCloakUserApiProviderFactory implements RealmResourceProviderFactory {
//
//    public static final String ID = "ms-user";
//
//    public RealmResourceProvider create(KeycloakSession session) {
//        return new KeyCloakUserApiProvider(session);
//    }
//
//    public void init(Config.Scope config) {
//    }
//
//    public void postInit(KeycloakSessionFactory factory) {
//    }
//
//    public void close() {
//    }
//
//    public String getId() {
//        return ID;
//    }
//}
