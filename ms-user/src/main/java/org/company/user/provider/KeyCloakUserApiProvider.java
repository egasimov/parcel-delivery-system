//package org.company.user.provider;
//
//import lombok.Getter;
//import lombok.Setter;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.http.HttpStatus;
//import org.company.user.model.request.CreateUserRequest;
//import org.keycloak.admin.client.Keycloak;
//import org.keycloak.admin.client.resource.UsersResource;
//import org.keycloak.models.KeycloakSession;
//import org.keycloak.models.UserModel;
//import org.keycloak.representations.idm.CredentialRepresentation;
//import org.keycloak.representations.idm.UserRepresentation;
//import org.keycloak.services.resource.RealmResourceProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.ws.rs.core.Response;
//import java.util.Collections;
//
//@Component
//public class KeyCloakUserApiProvider implements RealmResourceProvider {
//
//    private final KeycloakSession session;
//
//    @Autowired
//    @Getter
//    @Setter
//    private Keycloak keycloakInstance;
//
//    private final String currentRealmName;
//
//    public KeyCloakUserApiProvider(KeycloakSession session) {
//        this.session = session;
//        this.keycloakInstance = keycloakInstance;
//        currentRealmName = this.session.getContext().getRealm().getName();
//    }
//
//    public void close() {
//    }
//
//    public Object getResource() {
//        return this;
//    }
//
//    public boolean checkUserExist(String username) {
//
//        if (StringUtils.isBlank(username)) return false;
//
//        UserModel user = session.users().getUserByUsername(
//                username.toLowerCase(),
//                session.getContext().getRealm());
//
//        return user != null;
//    }
//
//    public boolean createUser(CreateUserRequest userRequest) {
//
//        CredentialRepresentation credentialRepresentation = this.createPasswordCredentials(userRequest.getPassword());
//
//        UserRepresentation kcUser = new UserRepresentation();
//        kcUser.setUsername(userRequest.getUsername());
//        kcUser.setCredentials(Collections.singletonList(credentialRepresentation));
//        kcUser.setFirstName(userRequest.getFirstName());
//        kcUser.setLastName(userRequest.getLastName());
//        kcUser.setEmail(userRequest.getEmail());
//        kcUser.setEnabled(true);
//        kcUser.setEmailVerified(false);
//
//        UsersResource usersResource = keycloakInstance.realm(currentRealmName).users();
//        Response response = usersResource.create(kcUser);
//        int statusCode = response.getStatusInfo().getStatusCode();
//
//        boolean isSuccess = statusCode == HttpStatus.SC_OK || statusCode == HttpStatus.SC_CREATED;
//
//        return isSuccess;
//    }
//
//    private CredentialRepresentation createPasswordCredentials(String password) {
//        CredentialRepresentation passwordCredentials = new CredentialRepresentation();
//        passwordCredentials.setTemporary(false);
//        passwordCredentials.setType(CredentialRepresentation.PASSWORD);
//        passwordCredentials.setValue(password);
//        return passwordCredentials;
//    }
//}
