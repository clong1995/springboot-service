package com.example.demo.config;

import com.example.demo.service.impl.AccessDecisionManagerImpl;
import com.example.demo.service.impl.FilterInvocationSecurityMetadataSourceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //用来解决匿名用户访问无权限资源时的异常
    private final JwtAuthenticationEntryPoint unauthorizedHandler;
    //用来解决认证过的用户访问无权限资源时的异常
    private final AccessDeniedHandler accessDeniedHandler;

    private final UserDetailsService customUserDetailsService;

    private final JwtAuthenticationTokenFilter authenticationTokenFilter;


    /*@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("zoolon").password("123456").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
    }*/

    @Autowired
    public WebSecurityConfig(JwtAuthenticationEntryPoint unauthorizedHandler,
                             @Qualifier("RestAuthenticationAccessDeniedHandler") AccessDeniedHandler accessDeniedHandler,
                             @Qualifier("CustomUserDetailsService") UserDetailsService customUserDetailsService,
                             JwtAuthenticationTokenFilter authenticationTokenFilter) {
        this.unauthorizedHandler = unauthorizedHandler;
        this.accessDeniedHandler = accessDeniedHandler;
        this.customUserDetailsService = customUserDetailsService;
        this.authenticationTokenFilter = authenticationTokenFilter;
    }

    //customUserDetailsService 用于将用户权限交给 springsecurity 进行管控；
    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
                // 设置UserDetailsService
                .userDetailsService(this.customUserDetailsService)
                // 使用BCrypt进行密码的hash
                .passwordEncoder(passwordEncoder());
    }

    /**
     * 装载BCrypt密码编码器
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors().and()//跨域
                .csrf().disable()//由于使用的是JWT，我们这里不需要csrf
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()//跨域
                .antMatchers(
                        "/auth/login",
                        "/auth/sign",
                        "/error/**"
                ).permitAll()//认证相关
                .and().authorizeRequests().anyRequest().authenticated()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    public <O extends FilterSecurityInterceptor> O postProcess(O fsi) {
                        fsi.setAccessDecisionManager(accessDecisionManagerImpl());
                        fsi.setSecurityMetadataSource(securityMetadataSource());
                        return fsi;
                    }
                }).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()//基于token，所以不需要session
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()//匿名用户访问无权限资源时的异常
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);//证过的用户访问无权限资源时的异常

        // 禁用缓存
        httpSecurity.headers().cacheControl();

        // 添加JWT filter
        // 在 UsernamePasswordAuthenticationFilter 前 authenticationTokenFilter 过滤器
        httpSecurity.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers(
                        "swagger-ui.html",
                        "**/swagger-ui.html",
                        "/favicon.ico",
                        "/**/*.css",
                        "/**/*.js",
                        "/**/*.png",
                        "/**/*.gif",
                        "/swagger-resources/**",
                        "/v2/**",
                        "/**/*.ttf"
                );
        web
                .ignoring()
                .antMatchers(
                        "/v2/api-docs",
                        "/swagger-resources/configuration/ui",
                        "/swagger-resources",
                        "/swagger-resources/configuration/security",
                        "/swagger-ui.html"
                );
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Bean
    public FilterInvocationSecurityMetadataSource securityMetadataSource() {
        return new FilterInvocationSecurityMetadataSourceImpl();
    }

    @Bean
    public AccessDecisionManager accessDecisionManagerImpl() {
        return new AccessDecisionManagerImpl();
    }
}