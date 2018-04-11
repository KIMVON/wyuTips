# wyuTips
> 这个demo主要是对五邑大学新子系统的抓包来实现的一个课程表和成绩查询功能的web网网站，主要是对于移动端web的用户开发的，对于pc端的用户界面就不太友好了


## 用到的知识
serlvet:觉得java后端servlet才是王道，这次没有用XML来配置servlet，而是用了注解的方式，确实是方便很多

## 用到的架构MVC架构
把这个demo分了三层<br/>
--dao：model层<br>
--service：业务逻辑层<br/>
--servlet：web表现层<br/>


## 用到的web前端框架
bootstrap:主要是相应式的框架，也是我目前最熟悉的框架<br/>
swiper：这是个轮播图的框架，这个觉得做得挺好的，也是我的一次意外的发现<br/>

## 遇到的问题
### servlet线程不安全
Servlet体系是建立在java多线程的基础之上的,它的生命周期是由Tomcat
来维护的。当客户端第一次请求Servlet的时候,tomcat会根据web.xml配置文件实例化servlet，
当又有一个客户端访问该servlet的时候，不会再实例化该servlet，也就是多个线程在使用这个实例。
多线程是不共享局部变量的
 #### 变量的线程安全
 servlet线程不安全也是针对于共享资源的访问才产生的基于多线程不共享局部变量的
 特点我们可以将这类变量参数本地化。
                            
 #### 属性的线程安全                       
 #### 同步的集合类
 #### 外部对象互斥
 #### Single ThreadMode接口:效率太过低下。其再Servlet的规范中已经被废弃了。
 
 更加糟糕的是我竟然用了静态变量，怪我太天真了.........
## 参考的博客
servlet问题：<br>
https://blog.csdn.net/lcore/article/details/8974590<br>
Bootstrap框架:<br>
https://getbootstrap.com/<br/>
Swiper框架:<br>
http://www.swiper.com.cn/<br/>
主页球体:<br/>
https://hakim.se/<br/>



> PS:五邑大学大学新子系统也做得太烂了吧，感觉直接在html中可以找到接口API了，还有注释来说明...