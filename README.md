今年从.NET转向JAVA方向，个人认为要想真正的熟悉起来，最好的方式就是动手写起来~~于是乎，最近计划着手开发一个CMS项目。在这里先简要记录一下，后续进行中也可能会有所调整。
# 一、主要模块
- 1.CMS后台管理系统
- ……

# 二、CMS后台
## 1.项目结构
- CathyCMS-common 项目通用工具类
- CathyCMS-data 数据层
- CathyCMS-service 服务层
- CathyCMS-adminsite 后台管理站点

## 2.功能列表
- 权限管理
- 菜单列表（完成）
- 角色列表（完成）
- 用户列表（完成）
- 频道列表 (完成)
- 文章列表 （开发中）
- ……

## 2.技术点
- 数据层采用 mybatis + mysql
- 站点采用 spring mvc
- 视图采用 thymeleaf
- bootstrap 布局
- 表单校验采用 jquery validation 插件
- ztree 展现菜单树形结构
- 登录和权限控制集成了 shiro
- 使用 POI 导出excel
- 时间控件采用 My97DatePicker
- 文件上传使用 jquery.uploadify
- ……


# 三、详细技术点相关文章：
- [解决thymeleaf layout布局不生效](http://www.cnblogs.com/janes/p/7524941.html)
- [jquery.form.js+jquery.validation.js实现表单校验和提交](http://www.cnblogs.com/janes/p/7553137.html)
- [shiro入门示例](http://www.cnblogs.com/janes/p/7553198.html)
- [使用ztree展示树形菜单结构](http://www.cnblogs.com/janes/p/7567300.html)
- [JAVA POI导出excel](http://www.cnblogs.com/janes/p/7596637.html)
- [jquery.uploadify+spring mvc实现上传图片](http://www.cnblogs.com/janes/p/7611980.html)
- ……

# 四、声明
本项目仅用于本人学习， 禁止用于商业用途。




