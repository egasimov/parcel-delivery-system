package org.company.user.security;

public interface RoleConstants {

    interface ClientApp {
        //Courier-based roles
        String ROLE_CREATE_COURIER = "ROLE_CREATE_COURIER";

        String ROLE_GET_ANY_COURIER_INFO = "ROLE_GET_ANY_COURIER_INFO";
        String ROLE_GET_ALL_COURIER_INFO = "ROLE_GET_ALL_COURIER_INFO";
        String ROLE_GET_SELF_COURIER_INFO = "ROLE_GET_SELF_COURIER_INFO";

        String ROLE_UPDATE_SELF_COURIER_INFO = "ROLE_UPDATE_SELF_COURIER_INFO";
        String ROLE_UPDATE_ANY_COURIER_INFO = "ROLE_UPDATE_ANY_COURIER_INFO";

        String ROLE_REMOVE_ANY_COURIER = "ROLE_REMOVE_ANY_COURIER";
        String ROLE_REMOVE_SELF_COURIER = "ROLE_REMOVE_SELF_COURIER";

        //Customer-based roles
        String ROLE_CREATE_CUSTOMER = "ROLE_CREATE_CUSTOMER";

        String ROLE_GET_ANY_CUSTOMER_INFO = "ROLE_GET_ANY_CUSTOMER_INFO";
        String ROLE_GET_ALL_CUSTOMER_INFO = "ROLE_GET_ALL_CUSTOMER_INFO";
        String ROLE_GET_SELF_CUSTOMER_INFO = "ROLE_GET_SELF_CUSTOMER_INFO";

        String ROLE_UPDATE_SELF_CUSTOMER_INFO = "ROLE_UPDATE_SELF_CUSTOMER_INFO";
        String ROLE_UPDATE_ANY_CUSTOMER_INFO = "ROLE_UPDATE_ANY_CUSTOMER_INFO";

        String ROLE_REMOVE_ANY_CUSTOMER = "ROLE_REMOVE_ANY_CUSTOMER";
        String ROLE_REMOVE_SELF_CUSTOMER = "ROLE_REMOVE_SELF_CUSTOMER";
    }

    interface Realm {
        String ROLE_APP_ADMIN = "ROLE_APP_ADMIN";
        String ROLE_APP_USER_CUSTOMER = "ROLE_APP_USER_CUSTOMER";
        String ROLE_APP_USER_COURIER = "ROLE_APP_USER_COURIER";
    }

    interface DefaultRoles {
        String[] CLIENT_CUSTOMER_ROLES = {
                ClientApp.ROLE_GET_SELF_CUSTOMER_INFO,
                ClientApp.ROLE_UPDATE_SELF_CUSTOMER_INFO};

        String[] CLIENT_COURIER_ROLES = {
                ClientApp.ROLE_GET_SELF_COURIER_INFO,
                ClientApp.ROLE_UPDATE_SELF_COURIER_INFO
        };

        String[] REALM_CUSTOMER_ROLES = {Realm.ROLE_APP_USER_CUSTOMER};
        String[] REALM_COURIER_ROLES = {Realm.ROLE_APP_USER_COURIER};
    }

}
