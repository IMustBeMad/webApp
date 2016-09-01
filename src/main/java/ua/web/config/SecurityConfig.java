package ua.web.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ua.web.spring.component.Http401UnauthorizedEntryPoint;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public Http401UnauthorizedEntryPoint unauthorizedEntryPoint;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("kos").password("1234").roles("USER");
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/js/lib/*");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
            .and()
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedEntryPoint)
            .and()
                .csrf()
                .disable().headers()
            .and()
                .authorizeRequests()
                    .antMatchers("/index.html", "/login.html", "/", "/test").permitAll()
                    .anyRequest().authenticated()
            .and()
                .formLogin()
                .permitAll()
                .loginPage("/login.html");
//                .authorizeRequests()
//                .antMatchers(
//                        "/index",
//                        "/login"
//                )
//                .permitAll().anyRequest().fullyAuthenticated()
//                    .and()
//                .formLogin().loginProcessingUrl("/login").passwordParameter("password").usernameParameter("username").permitAll()
//                    .and()
//                .logout().logoutUrl("/logout").invalidateHttpSession(true).logoutSuccessUrl("/").permitAll()
//                    .and()
//                .sessionManagement().maximumSessions(5).expiredUrl("/").maxSessionsPreventsLogin(false);

 /*       http.exceptionHandling()
                .authenticationEntryPoint(unauthorizedEntryPoint)
                    .and()
                .authorizeRequests()
                .antMatchers("/index", "/login").permitAll()
                    .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .usernameParameter("name")
                .passwordParameter("pass");*/
    }
}
