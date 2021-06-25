package lanqiao.five.mvc;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.net.URISyntaxException;
import java.util.Map;

@WebListener()
public class ContextConfigListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {


    public ContextConfigListener() {
    }


    public void contextInitialized(ServletContextEvent sce) {
        try {
            /*
            加载工厂类，注入Bean
             */
            Class.forName("lanqiao.five.ioc.BeanFactory");

            Map<String, ControllerMapping> controllerMapping = new Configuration().config();
            /*
            服务端给网页（jsp）传数据，把数据放入某个作用域：request、session、application
             */
            sce.getServletContext().setAttribute("lanqiao.five.controller", controllerMapping);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void contextDestroyed(ServletContextEvent sce) {

    }


    public void sessionCreated(HttpSessionEvent se) {

    }

    public void sessionDestroyed(HttpSessionEvent se) {

    }


    public void attributeAdded(HttpSessionBindingEvent sbe) {

    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {

    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {

    }
}
