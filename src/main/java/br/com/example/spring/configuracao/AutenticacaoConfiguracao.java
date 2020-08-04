package br.com.example.spring.configuracao;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import br.com.example.spring.service.impl.AutenticacaoService;

@Configuration
@EnableConfigurationProperties
public class AutenticacaoConfiguracao {


	AutenticacaoService autenticacaoService;

	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic().and()
				.sessionManagement().disable();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(this.autenticacaoService);
	}*/
}