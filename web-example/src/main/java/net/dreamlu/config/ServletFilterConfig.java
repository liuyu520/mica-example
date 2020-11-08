package net.dreamlu.config;

import org.apache.catalina.*;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.support.OpenSessionInViewFilter;
import org.springframework.util.ResourceUtils;

import java.net.URL;

@Configuration
public class ServletFilterConfig {


    @Bean
    public FilterRegistrationBean outLinkSecurityFilterRegister() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //注入过滤器
        registration.setFilter(new com.kunlunsoft.rewriterequest.web.filter.RequestbodyFilter());
        //拦截规则
        registration.addUrlPatterns("/*");
        //过滤器名称
        registration.setName("requestbodyFilter");
        //过滤器顺序
        registration.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE);
        return registration;
    }

    @Bean
    public CustomTomcatEmbeddedServletContainerFactory customTomcatEmbeddedServletContainerFactory() {
        return new CustomTomcatEmbeddedServletContainerFactory();
    }

    public static class CustomTomcatEmbeddedServletContainerFactory extends TomcatEmbeddedServletContainerFactory {
        //在prepareContext中被调用
        @Override
        protected void postProcessContext(Context context) {
            super.postProcessContext(context);
            //添加监听器
            context.addLifecycleListener(new LifecycleListener() {
                @Override
                public void lifecycleEvent(LifecycleEvent event) {
                    if (event.getType().equals(Lifecycle.CONFIGURE_START_EVENT)) {
                        try {
                            //!!!资源所在url
                            URL url = ResourceUtils.getURL(ResourceUtils.CLASSPATH_URL_PREFIX);
                            //!!!资源搜索路径
                            String path = "/";

                            boolean inJar = false;
                            //手动创建一个ResourceSet
                            WebResourceRoot.ResourceSetType resourceSetType = WebResourceRoot.ResourceSetType.RESOURCE_JAR;
                            if (url.getPath().endsWith("classes!/")) {
                                inJar = true;
                            }


//                            BaseLocation baseLocation = new BaseLocation(url);
                            // 不在jar中的值:"/Users/hanjun/Documents/mygit/demo/convention_springboot/target/classes/"
                            if (inJar) {//当有archivePath时肯定是jar包运行
                                //url= jar:file:/a.jar
                                //此时Tomcat再拆分出base = /a.jar archivePath= /
                                path = "/BOOT-INF/classes";
                                url = new URL(url.getPath().replace("!" + path + "!/", ""));
                            }
                            System.out.println("path :" + path + ",url:" + url.getPath() + ",resourceSetType:" + resourceSetType);

                            /*if (inJar) {
                                resourceSetType=WebResourceRoot.ResourceSetType.PRE;
                                url = ResourceUtils.getURL()
                            }*/
                            context.getResources().createWebResourceSet(
                                    resourceSetType, "/", url, path);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

}
