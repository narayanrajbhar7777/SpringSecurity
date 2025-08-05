package com.companyproducts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
//@EnableWebSecurity
public class SystemConfig {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    WebClient getWebClientBuilder() {
        return WebClient.builder().build();
    }

//    private final UserDetailsService userDetailsService;

//    public SystemConfig(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }

//    @Bean
//    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(request->request
//                        .requestMatchers("company","login")
//                        .permitAll()
//                        .anyRequest()
//                        .authenticated()
//                )
//                .httpBasic(Customizer.withDefaults())
//                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .build();
//    }

//    @Bean
//    public AuthenticationProvider getAuthenticationProvider(){
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
//        provider.setUserDetailsService(userDetailsService);
//        return provider;
//    }

//    @Bean
//    AuthenticationManager getAuthenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//    }
}
