### MS-USER

<img src="./doc/MS-USER-SWAGGER-UI.PNG" width="1000" height="600"/>

### Create Customer Scenario

Request:
```
curl -X POST \
  http://localhost:9001/api/customers \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 2a2b6c65-2917-1aab-f509-bf8a26162341' \
  -d '{
  "address": "Baku, AZ",
  "birthDate": "1999-11-13",
  "email": "egasimov0@gmail.com",
  "firstName": "Elchin",
  "lastName": "Gasimov",
  "password": "egasimov",
  "phoneNumber": "99450xxxyyyzz",
  "username": "egasimov"
}'
```

To check given access token is valid, use the following endpoint get info about logged customer
```
curl -X GET \
  http://localhost:9001/api/customers/info \
  -H 'authorization: Bearer {{access_token}}' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 2d1d068b-50a3-df7d-9e6d-91acde05317a'
```

If your token get expired use the following service to refresh the token
An example token:
```
"
eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI3NVgxcVA0Rjl4QkpWbUx1ejg5MU1fRElQWWZRVEc3ZGd1dV9VYmNjWGprIn0.eyJleHAiOjE2MzcwNTI5MTUsImlhdCI6MTYzNzA1MjYxNSwianRpIjoiMjBmNzk2MDgtOTBhNy00Y2JmLWIyY2YtMmUyNTkwMGE4NmRjIiwiaXNzIjoiaHR0cDovLzE5Mi4xNjguOTkuMTAwOjgwODAvYXV0aC9yZWFsbXMvZGVsaXZlcnktc3lzdGVtLXJlYWxtIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6IjlkN2YxMDRhLWM2N2ItNDgxMy1hM2NhLWFhYTNjOWI5NTViNCIsInR5cCI6IkJlYXJlciIsImF6cCI6Im1zLXVzZXIiLCJzZXNzaW9uX3N0YXRlIjoiODdkNzBiOTItNDVmMi00NDM3LWJmZmUtMWQ3YzM4NjgwZDEyIiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwOi8vMTkyLjE2OC45OS4xOjkwMDEiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIlJPTEVfQVBQX1VTRVJfQ1VTVE9NRVIiLCJkZWZhdWx0LXJvbGVzLWRlbGl2ZXJ5LXN5c3RlbS1yZWFsbSIsIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJtcy11c2VyIjp7InJvbGVzIjpbIlJPTEVfR0VUX1NFTEZfQ1VTVE9NRVJfSU5GTyIsIlJPTEVfVVBEQVRFX1NFTEZfQ1VTVE9NRVJfSU5GTyIsIlJPTEVfUkVNT1ZFX1NFTEZfQ1VTVE9NRVIiXX0sImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoiZW1haWwgcHJvZmlsZSIsInNpZCI6Ijg3ZDcwYjkyLTQ1ZjItNDQzNy1iZmZlLTFkN2MzODY4MGQxMiIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6IkVsY2hpbiBHYXNpbW92IiwicHJlZmVycmVkX3VzZXJuYW1lIjoiZWdhc2ltb3YiLCJnaXZlbl9uYW1lIjoiRWxjaGluIiwiZmFtaWx5X25hbWUiOiJHYXNpbW92In0.JdGuHMnHOlsHVmWqSJBc46jzU3phJ7ijo-PXYnTPLySKhiXhZB4wqFD53EbSRIr24qJnP_ipX7_4N_SaTkAH8Lq-nD-rtHJuTrUk5acw2XOf-XJAGV4f4pu3zP01BuqTsCE5SPbS18Yo3InU2k7OfHfJQeThSK9XL4E2AFUNqZ52LJJeaE70nuGRCoB6I0POp6gPGZXD0oeSaudUqmamPbb1ZMjWlg_pyEyo7aglM4lAJZLgnIwAjrUAaaZoBWqnkm30tz-eNgBtOdRf4Al3UyGXg-qLmqKJwNXZafmT8FQgItjJAn3d00141He1ccbFcuWMdq_qEsSJoUKroZ1WLQ
"
```

### Login Service
Request
```
curl -X POST \
  http://192.168.99.100:8080/auth/realms/delivery-system-realm/protocol/openid-connect/token \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/x-www-form-urlencoded' \
  -H 'postman-token: 369f030f-96cf-cc9d-e6a5-bf13f5836ac2' \
  -d 'grant_type=password&client_id=ms-user&client_secret=50dba9f1-39fb-4762-86c8-eeb590a461cf&username=egasimov&password=egasimov'
```
Response
```
{
    "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI3NVgxcVA0Rjl4QkpWbUx1ejg5MU1fRElQWWZRVEc3ZGd1dV9VYmNjWGprIn0.eyJleHAiOjE2MzcwNTQzNTQsImlhdCI6MTYzNzA1NDA1NCwianRpIjoiNDhkOTc5MjAtOWEwZS00NDM5LWE1ZTUtZmI2MzM0ZGJlNzYyIiwiaXNzIjoiaHR0cDovLzE5Mi4xNjguOTkuMTAwOjgwODAvYXV0aC9yZWFsbXMvZGVsaXZlcnktc3lzdGVtLXJlYWxtIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6IjlkN2YxMDRhLWM2N2ItNDgxMy1hM2NhLWFhYTNjOWI5NTViNCIsInR5cCI6IkJlYXJlciIsImF6cCI6Im1zLXVzZXIiLCJzZXNzaW9uX3N0YXRlIjoiNGMxOTAxYTAtOGQ5MC00NzZmLWI2NGYtNTMxYjI4Zjk4NDZiIiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwOi8vMTkyLjE2OC45OS4xOjkwMDEiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIlJPTEVfQVBQX1VTRVJfQ1VTVE9NRVIiLCJkZWZhdWx0LXJvbGVzLWRlbGl2ZXJ5LXN5c3RlbS1yZWFsbSIsIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJtcy11c2VyIjp7InJvbGVzIjpbIlJPTEVfR0VUX1NFTEZfQ1VTVE9NRVJfSU5GTyIsIlJPTEVfVVBEQVRFX1NFTEZfQ1VTVE9NRVJfSU5GTyIsIlJPTEVfUkVNT1ZFX1NFTEZfQ1VTVE9NRVIiXX0sImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoiZW1haWwgcHJvZmlsZSIsInNpZCI6IjRjMTkwMWEwLThkOTAtNDc2Zi1iNjRmLTUzMWIyOGY5ODQ2YiIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6IkVsY2hpbiBHYXNpbW92IiwicHJlZmVycmVkX3VzZXJuYW1lIjoiZWdhc2ltb3YiLCJnaXZlbl9uYW1lIjoiRWxjaGluIiwiZmFtaWx5X25hbWUiOiJHYXNpbW92In0.f_bisjyqN82YdhNK9PWk-PnHg4ScFyt6bD1qMpNn1342E5PmwwbidVCok4oa3RoYnXTfkuMH-5g4xQfbuDYj9_7DKRCa69S0RtkFyRE59iqUSVp7K3N83iZs2ptC0YdmVMbl9KHTUbUJW8cTOVAWISkJbqNKTjRlQEL1rdpfmIOvHb2SlIHqEIRCIBSE8kBLL_jPtq1eiArTVlQu1Px5RdYO0_S0aBBykg84KekGkT0oudHRpPxBlj791lUVALpY48VhftKQNuzsYowyFqfyC6-6dYcdIj00eBOkvZtEchPoUQy0po7sY1eaAstrEwC3EIP-EnXZs6b6zOnsQG4qOg",
    "expires_in": 300,
    "refresh_expires_in": 1800,
    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI1YjBlYjNmNi0zNjEzLTQ0MWItYjNlMC0wMjVhYzgwMGRmNmMifQ.eyJleHAiOjE2MzcwNTU4NTQsImlhdCI6MTYzNzA1NDA1NCwianRpIjoiNDAwZmIzNzgtOGI5MS00ZGE3LWEwZTUtMzg0NDRiOGRiZWEwIiwiaXNzIjoiaHR0cDovLzE5Mi4xNjguOTkuMTAwOjgwODAvYXV0aC9yZWFsbXMvZGVsaXZlcnktc3lzdGVtLXJlYWxtIiwiYXVkIjoiaHR0cDovLzE5Mi4xNjguOTkuMTAwOjgwODAvYXV0aC9yZWFsbXMvZGVsaXZlcnktc3lzdGVtLXJlYWxtIiwic3ViIjoiOWQ3ZjEwNGEtYzY3Yi00ODEzLWEzY2EtYWFhM2M5Yjk1NWI0IiwidHlwIjoiUmVmcmVzaCIsImF6cCI6Im1zLXVzZXIiLCJzZXNzaW9uX3N0YXRlIjoiNGMxOTAxYTAtOGQ5MC00NzZmLWI2NGYtNTMxYjI4Zjk4NDZiIiwic2NvcGUiOiJlbWFpbCBwcm9maWxlIiwic2lkIjoiNGMxOTAxYTAtOGQ5MC00NzZmLWI2NGYtNTMxYjI4Zjk4NDZiIn0.K2AHPFjqb0AYBzczd339m3WS5MI158x8e8KdrKARYl8",
    "token_type": "Bearer",
    "not-before-policy": 0,
    "session_state": "4c1901a0-8d90-476f-b64f-531b28f9846b",
    "scope": "email profile"
}
```

### Refresh Token Service
Example:
Request:
```
curl -X POST \
  http://192.168.99.100:8080/auth/realms/delivery-system-realm/protocol/openid-connect/token \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/x-www-form-urlencoded' \
  -H 'postman-token: 1320d3fc-9806-b5ba-cc68-a71e285c82b4' \
  -d 'grant_type=refresh_token&client_id=ms-user&client_secret=50dba9f1-39fb-4762-86c8-eeb590a461cf&refresh_token={{refresh_token}}'
```  
  
Response:  
```
{
    "access_token": {{access_jwt_token}},
    "expires_in": 300,
    "refresh_expires_in": 1800,
    "refresh_token": {{refresh_jwt_token}},
    "token_type": "Bearer",
    "not-before-policy": 0,
    "session_state": "87d70b92-45f2-4437-bffe-1d7c38680d12",
    "scope": "email profile"
}
```

### Create Courier Scenario
Request:

```
curl -X POST \
  http://localhost:9001/api/couriers \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: f4cc74e3-40b8-7364-7d5f-bcc72c18db63' \
  -d '{
  "address": "Baku, AZ",
  "birthDate": "1994-11-13",
  "email": "courier@co.uk",
  "firstName": "Test Courier Name",
  "lastName": "Test Courier LastName",
  "location": "Baku, AZ, Nizami street 98a",
  "password": "kuryer123",
  "phoneNumber": "99470xxxyyyzzz",
  "username": "kuryer"
}'
```
Response:
```
{
    "id": "20211116125840061C100014",
    "code": 403,
    "message": "Access is denied"
}
```

The reason that Access denied Response, we only allowed Admin ROLE can create Courier :)
SO, use any token - having ROLE_CREATE_COURIER permission.
 i have created one user who has the ROLE_APP_ADMIN role which in turn brings the bunch of roles needed in behaving like admin 
 on ms-user
```
  "realm_access": {
    "roles": [
      "ROLE_APP_ADMIN",
      "default-roles-delivery-system-realm",
      "offline_access",
      "uma_authorization"
    ]
  },
  "resource_access": {
    "ms-user": {
      "roles": [
        "ROLE_UPDATE_ANY_COURIER_INFO",
        "ROLE_GET_ALL_COURIER_INFO",
        "ROLE_GET_ANY_CUSTOMER_INFO",
        "ROLE_REMOVE_ANY_CUSTOMER",
        "ROLE_GET_ALL_CUSTOMER_INFO",
        "ROLE_REMOVE_ANY_COURIER",
        "ROLE_CREATE_COURIER",
        "ROLE_GET_ANY_COURIER_INFO",
        "ROLE_UPDATE_ANY_CUSTOMER_INFO"
      ]
    }
```

and then create courier request embedded with jwt token.

Request
```
curl -X POST \
  http://localhost:9001/api/couriers \
  -H 'authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI3NVgxcVA0Rjl4QkpWbUx1ejg5MU1fRElQWWZRVEc3ZGd1dV9VYmNjWGprIn0.eyJleHAiOjE2MzcwNTM3NzksImlhdCI6MTYzNzA1MzQ3OSwianRpIjoiNjI3ZTVlMGYtYTg2OC00MzczLWJiNDQtZDIxNTlmOWVmZjU2IiwiaXNzIjoiaHR0cDovLzE5Mi4xNjguOTkuMTAwOjgwODAvYXV0aC9yZWFsbXMvZGVsaXZlcnktc3lzdGVtLXJlYWxtIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImMzNzg4ODc3LWUxYjYtNDRiOC1hZTZhLWQzOTQyMWE1YjNjNSIsInR5cCI6IkJlYXJlciIsImF6cCI6Im1zLXVzZXIiLCJzZXNzaW9uX3N0YXRlIjoiMTUxNzJjNzQtMGE5MS00YzlhLWE1YjktYjYxYzMzNTMzM2FiIiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwOi8vMTkyLjE2OC45OS4xOjkwMDEiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIlJPTEVfQVBQX0FETUlOIiwiZGVmYXVsdC1yb2xlcy1kZWxpdmVyeS1zeXN0ZW0tcmVhbG0iLCJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsibXMtdXNlciI6eyJyb2xlcyI6WyJST0xFX1VQREFURV9BTllfQ09VUklFUl9JTkZPIiwiUk9MRV9HRVRfQUxMX0NPVVJJRVJfSU5GTyIsIlJPTEVfR0VUX0FOWV9DVVNUT01FUl9JTkZPIiwiUk9MRV9SRU1PVkVfQU5ZX0NVU1RPTUVSIiwiUk9MRV9HRVRfQUxMX0NVU1RPTUVSX0lORk8iLCJST0xFX1JFTU9WRV9BTllfQ09VUklFUiIsIlJPTEVfQ1JFQVRFX0NPVVJJRVIiLCJST0xFX0dFVF9BTllfQ09VUklFUl9JTkZPIiwiUk9MRV9VUERBVEVfQU5ZX0NVU1RPTUVSX0lORk8iXX0sImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoiZW1haWwgcHJvZmlsZSIsInNpZCI6IjE1MTcyYzc0LTBhOTEtNGM5YS1hNWI5LWI2MWMzMzUzMzNhYiIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6IkFkbWluIEFkbWlubiIsInByZWZlcnJlZF91c2VybmFtZSI6ImFkbWluIiwiZ2l2ZW5fbmFtZSI6IkFkbWluIiwiZmFtaWx5X25hbWUiOiJBZG1pbm4iLCJlbWFpbCI6ImFkbWluQGNvLnVhIn0.KHqvY5mFZR5SVlcLaSWalp8wgTJ5mnsRYV_RyIsA8t_Aa_X4txxyC5Wu8oAjYLgFBkb0oQEMeVEseANykBv-WhJyleFSxfvqdmyxFXWqY2-lwZmfMBOdqT4Ty9PcNDhuLzj0OzBV6BVAISjGmWvhTlsjksV91tIKnNNJlVIUX-ypcqNHYFgWVZj-OTuRTTkPx-cIe8qe4EtcpxQxvC73gdhb2wm3pF_FfthkHTVUQk_V6tveDzW7KfI2t-8A6wL4yLhDoWSephqJdvRcVYHrTM_MrnXKcoXuWgK5PhD-8Z6zg5zp5_70tcdLN-2b9mh6OV1C0ZEyFQuuOsmKV3IkkQ' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 0aba41e6-9880-854f-fa9b-468b35ca07c4' \
  -d '{
  "address": "Baku, AZ",
  "birthDate": "1994-11-13",
  "email": "courier@co.uk",
  "firstName": "Test Courier Name",
  "lastName": "Test Courier LastName",
  "location": "Baku, AZ, Nizami street 98a",
  "password": "kuryer123",
  "phoneNumber": "99470xxxyyyzzz",
  "username": "kuryer"
}'
```
Response:
```
{
    "id": 1,
    "firstName": "Test Courier Name",
    "lastName": "Test Courier LastName",
    "birthDate": "1994-11-13",
    "address": "Baku, AZ",
    "phoneNumber": "99470xxxyyyzzz",
    "rating": 0,
    "username": "kuryer",
    "busy": false
}	
```
