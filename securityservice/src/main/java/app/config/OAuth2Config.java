package app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {




    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception { // testing
        clients.inMemory()
                .withClient("afgan")
                .secret("password")
                .authorizedGrantTypes("refresh_token", "password", "client_credentials")
                .scopes("webclient");
    }

}
