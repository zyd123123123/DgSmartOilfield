 

如何运行该系统？
---

*   保证各服务模块使用的端口未被占用
*   根据表模型创建库（如cloud-ida）、表，并插入相应的测试数据
* 1.配置各模块设置数据库的url、用户名和密码，可通过全局搜索"jdbc:postgresql",替换成自己的配置
* 2.启动顺序：sc-zc->sc-wg->sc-yz->md-sys->md-yw1 
* 3.各模块使用springboot创建，找到个服务对用的application,运行main函数即可，如cloud-ida-zuul的application为CloudDockerZuulApplication
*   启动vue前端，切换到vue-front目录下，运行cnpm run dev(事先安装node.js、cnpm、vue)


系统体验
---

*   后台管理系统：http://localhost:9000/index 用户名/密码：admin/123456
*   前端系统： http://localhost:9521 用户名/密码：admin/123456

 
---

 




