package org.jason.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author:Jason
 * @Description: 记录访问量的Filter,@Order注解是执行过滤顺序,越小越先执行
 * 使用@WebFilter标志这是一个过滤器
 * 需要继承Filter(javax.servlet.Filter)
 * @Date:Created in 19:19 2017/12/27
 * @Modified By:
 */
@Order(1)
@WebFilter(filterName = "countFilter", urlPatterns = "/*")
public class CountFilter implements Filter {

    private ExecutorService executorService= Executors.newSingleThreadExecutor();
    private Properties downloadLog;
    private File logFile;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取站点根目录
        String addPath = System.getProperty("user.dir");
        logFile = new File(addPath + "/logs/visitorCount.txt");
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        downloadLog = new Properties();
        try {
            downloadLog.load(new FileReader(logFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        final String uri=req.getRequestURI();
        final int lastDocIndex = uri.lastIndexOf(".");
        boolean flag=lastDocIndex==-1?false:true;
        if (flag) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    String value = downloadLog.getProperty(uri);
                    if (value == null) {
                        downloadLog.setProperty(uri, "1");
                    } else {
                        int count = Integer.parseInt(value);
                        downloadLog.setProperty(uri, String.valueOf(++count));
                    }
                    try {
                        downloadLog.store(new FileWriter(logFile), "");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        executorService.shutdown();
    }
}
