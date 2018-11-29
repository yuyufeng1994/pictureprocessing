package top.yuyufeng.demo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import top.yuyufeng.demo.interceptor.RootInterceptor;

/**
 * @author yuyufeng
 * @date 2018/8/20.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private RootInterceptor rootInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(rootInterceptor).addPathPatterns("/**");

    }
}
