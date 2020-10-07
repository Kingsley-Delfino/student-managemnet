## 张纪跃-20212010070-课程实践02

### 一、学生信息管理系统简介

####1、添加学生

URL Path：/api/vi/student

Http Method：POST

功能描述：在Request Body中以json的格式发送学生的具体信息，以向系统中添加学生，其中信息包括：学号（studentId）、姓名（name）、院系（department）和专业（major）。

响应结果：若学号发生重复，则添加失败。

####2、查看学生

URL Path：/api/vi/student

Http Method：GET

功能描述：用List格式，返回当前系统中的所有学生信息。

####3、修改学生信息

URL Path：/api/vi/student

Http Method：PUT

功能描述：用json格式，修改系统中某位学生的具体信息（以学号为学生判断依据，学号相同视为同一学生）。

响应结果：若学号不存在，则修改失败。

####4、删除学生信息

URL Path：/api/vi/student

Http Method：DELETE

功能描述：用json格式，删除系统中某位学生。

响应结果：若学号不存在，则删除失败。

###二、项目容器化

####1、生成jar包

通过Maven将项目打包为jar包，并更名为：student-management.jar

####2、修改docker镜像源

docker默认的下载镜像源为国外官方源，下载速度较慢，可改为国内的镜像源进行加速，避免进程因速度过慢而被终止。

本处采用了阿里云的镜像源，阿里云镜像获取地址：https://cr.console.aliyun.com/cn-hangzhou/instances/mirrors

登陆后在左侧菜单栏中选择“镜像加速器”即可看到自己的专属地址，复制该地址，进入服务器的/etc/docker目录下，打开daemon.json文件（没有则新建），将地址以如下形式填写进去：{"registry-mirrors":["复制的地址"]}

注：本方法仅适用于服务器上的systemd系统

![Image text](https://codeup.aliyun.com/5f66233b5fd102f22f6bf80d/student-management/blob/master/src/main/resources/static/img/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20201007151928.png)
####3、
####一、学生信息管理系统设置了前端页面

