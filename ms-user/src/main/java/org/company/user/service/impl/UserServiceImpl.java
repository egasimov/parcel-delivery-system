package org.company.user.service.impl;

import org.apache.http.HttpStatus;
import org.company.user.mapper.UserMapper;
import org.company.user.model.dto.UserDto;
import org.company.user.model.request.CreateUserRequest;
import org.company.user.service.UserService;
import org.company.user.util.KeycloakUtils;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final Keycloak keycloak;

    private String realm;
    private String appName;

    private final KeycloakUtils keycloakUtils;

    public UserServiceImpl(Keycloak keycloak,
                           @Value("${keycloak.realm}") String realm,
                           @Value("${spring.application.name}") String appName,
                           KeycloakUtils keycloakUtils) {
        this.keycloak = keycloak;
        this.realm = realm;
        this.keycloakUtils = keycloakUtils;
        this.appName = appName;
    }

    @Override
    public boolean checkUserExist(String username) {
        return keycloak.realm(realm)
                .users()
                .search(username).size() > 0;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return keycloak.realm(realm)
                .users()
                .list()
                .stream()
                .map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public void removeUser(String username) {
        List<UserRepresentation> searchResult = keycloak.realm(realm)
                .users()
                .search(username);
        if (searchResult.size() > 0) {
            keycloak.realm(realm)
                    .users()
                    .delete(searchResult.get(0).getId());
        }
    }

    @Override
    public String currentLoggedUser() {
        return keycloakUtils.extractUsernameFromToken();
    }

    @Override
    public void createUser(CreateUserRequest userRequest) {

        var credentialRepresentation = this.createPasswordCredentials(userRequest.getPassword());

        var kcUser = new UserRepresentation();
        kcUser.setUsername(userRequest.getUsername());
        kcUser.setCredentials(Collections.singletonList(credentialRepresentation));
        kcUser.setFirstName(userRequest.getFirstName());
        kcUser.setLastName(userRequest.getLastName());
        kcUser.setEmail(userRequest.getEmail());
        kcUser.setEnabled(true);
        kcUser.setEmailVerified(false);
        kcUser.setClientRoles(Map.of(appName, userRequest.getUserClientRoles()));
        kcUser.setRealmRoles(userRequest.getUserRealmRoles());

        UsersResource usersResource = keycloak.realm(realm).users();
        Response response = usersResource.create(kcUser);
        int statusCode = response.getStatusInfo().getStatusCode();

        boolean isSuccess = statusCode == HttpStatus.SC_OK || statusCode == HttpStatus.SC_CREATED;

    }

    private CredentialRepresentation createPasswordCredentials(String password) {
        CredentialRepresentation passwordCredentials = new CredentialRepresentation();
        passwordCredentials.setTemporary(false);
        passwordCredentials.setType(CredentialRepresentation.PASSWORD);
        passwordCredentials.setValue(password);
        return passwordCredentials;
    }
}
