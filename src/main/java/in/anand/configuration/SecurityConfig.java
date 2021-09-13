package in.anand.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("{noop}pass").authorities("ADMIN");
		auth.inMemoryAuthentication().withUser("employee").password("{noop}pass").authorities("EMPLOYEE");
		auth.inMemoryAuthentication().withUser("manager").password("{noop}pass").authorities("MANAGER");

	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/home").permitAll()
								.antMatchers("/welcome").authenticated()
								.antMatchers("/admin").hasAuthority("ADMIN")
								.antMatchers("/employee").hasAuthority("EMPLOYEE")
								.antMatchers("/manager").hasAuthority("MANAGER")
								.antMatchers("/common").hasAnyAuthority("EMPLOYEE","ADMIN")
								
								.anyRequest().authenticated()
								
								.and()
								.formLogin()
								.defaultSuccessUrl("/welcome",true)
								
								.and()
								.logout()
								.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
								
								.and()
								.exceptionHandling()
								.accessDeniedPage("/accessDenied");
	}
	
	
}
