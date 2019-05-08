package pl.b2bnet.api.service;

import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.representations.idm.authorization.AuthorizationRequest;
import org.keycloak.representations.idm.authorization.AuthorizationResponse;
import org.springframework.stereotype.Service;
import pl.b2bnet.api.Model.LoginDto;
import pl.b2bnet.api.exception.NoSuchTagException;

@Service
public class LoginService {
    public String login(LoginDto loginDto) throws NoSuchTagException{
        AuthzClient authzClient = AuthzClient.create();
        AuthorizationRequest request = new AuthorizationRequest();
        AuthorizationResponse response;
        response = authzClient.authorization(loginDto.getLogin(), loginDto.getPassword()).authorize(request);
        return response.getToken();
    }

}
