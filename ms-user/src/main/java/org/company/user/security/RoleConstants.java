package org.company.user.security;

public final class RoleConstants {

    //Microservice level roles
    public static final String ROLE_CLIENT_ADMIN ="admin";
    public static final String ROLE_CLIENT_USER_CUSTOMER ="user-customer";
    public static final String ROLE_CLIENT_USER_COURIER ="user-courier";

    //Realm level roles
    public static final String ROLE_REALM_ADMIN ="app-admin";
    public static final String ROLE_REALM_USER_CUSTOMER ="app-user-customer";
    public static final String ROLE_REALM_USER_COURIER ="app-user-courier";

    private RoleConstants() {
        throw new IllegalStateException("can not be initialized");
    }

}
