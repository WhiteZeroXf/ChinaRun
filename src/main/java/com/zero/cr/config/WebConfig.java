package com.zero.cr.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig extends WebMvcAutoConfiguration implements WebMvcConfigurer {

    /**
     * 登录校验拦截器
     *
     * @param registry 不用管
     */
 /*   @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new VerifyInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(Constant.ALLOW_URI);
    }*/

    /**
     * 跨域过滤器
     *
     * @param registry 不用管
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600);
    }

    /**
     * 异常处理
     *
     * @param request  不用管
     * @param response 不用管
     * @param handler  不用管
     * @param ex       不用管
     * @return ModelAndView
     */
/*
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        return mv;
    }


    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(createHTTPConnector());
        return tomcat;
    }

    private Connector createHTTPConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        //同时启用http（8080）、https（8443）两个端口
        connector.setScheme("http");
        connector.setSecure(false);
        connector.setPort(80);
        connector.setRedirectPort(8443);
        return connector;
    }
*/

}
