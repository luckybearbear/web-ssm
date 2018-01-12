package ssm.blog.listener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import ssm.blog.entity.BlogType;
import ssm.blog.service.BlogTypeService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

@Component
/**
 * @Author xp
 * @Description 监听程序初始化
 * @Date 2017/4/23 21:48
 */
public class InitBloggerData implements ServletContextListener, ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public void contextInitialized(ServletContextEvent sce) {
        //先获取servlet上下文
        ServletContext application = sce.getServletContext();
        //同上，获取博客类别信息service
        BlogTypeService blogTypeService = applicationContext.getBean(BlogTypeService.class);
        List<BlogType> blogTypeList = blogTypeService.getBlogTypeData();
        application.setAttribute("blogTypeList", blogTypeList);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub

    }

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        InitBloggerData.applicationContext = applicationContext;
    }

}