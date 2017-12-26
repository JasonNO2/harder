#Spring Boot
本例子在
**Spring Boot**下配置了**druid**  and  **mybatis**
  
   
1. **Application.java**作为启动窗口应该注意它的放置位置！  
要将Application放在最外层，也就是要包含所有子包。  
2. demo添加了Druid监控,使用Spring Boot的注解实现,**DruidDataSourceConfiguration**实例化数据源  
**DruidStatFilter** 是Druid过滤器,DruidStatViewServlet是Druid Servlet

