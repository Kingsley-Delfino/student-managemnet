# 张纪跃-20212010070-课程实践02

## 一、学生信息管理系统简介

###1、添加学生

URL Path：/api/vi/student

Http Method：POST

功能描述：在Request Body中以json的格式发送学生的具体信息，以向系统中添加学生，其中信息包括：学号（studentId）、姓名（name）、院系（department）和专业（major）。

响应结果：若学号发生重复，则添加失败。

###2、查看学生

URL Path：/api/vi/student

Http Method：GET

功能描述：用List格式，返回当前系统中的所有学生信息。

###3、修改学生信息

URL Path：/api/vi/student

Http Method：PUT

功能描述：用json格式，修改系统中某位学生的具体信息（以学号为学生判断依据，学号相同视为同一学生）。

响应结果：若学号不存在，则修改失败。

###4、删除学生信息

URL Path：/api/vi/student

Http Method：DELETE

功能描述：用json格式，删除系统中某位学生。

响应结果：若学号不存在，则删除失败。

##二、项目容器化

###1、生成jar包

通过Maven将项目打包为jar包，并更名为：student-management.jar

###2、修改docker镜像源

docker默认的下载镜像源为国外官方源，下载速度较慢，可改为国内的镜像源进行加速，避免进程因速度过慢而被终止。

本处采用了阿里云的镜像源，阿里云镜像获取地址：https://cr.console.aliyun.com/cn-hangzhou/instances/mirrors

登陆后在左侧菜单栏中选择“镜像加速器”即可看到自己的专属地址，复制该地址，进入服务器的/etc/docker目录下，打开daemon.json文件（没有则新建），将地址以如下形式填写进去：{"registry-mirrors":["复制的地址"]}

![Image text](https://raw.githubusercontent.com/Kingsley-Delfino/student-managemnet/master/src/main/resources/static/img/20201007151928.png)

注：本方法仅适用于服务器上的systemd系统

###3、创建Dockerfile文件

新建文件，名为Dockerfile，无后缀名，内容如下

![Image text](https://raw.githubusercontent.com/Kingsley-Delfino/student-managemnet/master/src/main/resources/static/img/20201007162627.png)

将Dockerfile文件与第一步生成的student-management.jar放在同一目录下。

![Image text](https://raw.githubusercontent.com/Kingsley-Delfino/student-managemnet/master/src/main/resources/static/img/20201007165549.png)

###4、启动docker

在该目录下打开终端，注意管理员权限

![Image text](https://raw.githubusercontent.com/Kingsley-Delfino/student-managemnet/master/src/main/resources/static/img/20201007165252.png)

重新启动docker的命令为：systemctl restart docker

因为第二步中更改了daemon.json文件，所以在启动docker之前需要先重新加载daemon.json文件，输入命令为：systemctl daemon-reload

![Image text](https://raw.githubusercontent.com/Kingsley-Delfino/student-managemnet/master/src/main/resources/static/img/20201007165403.png)

###5、生成docker镜像

输入命令：docker build -t student-management.jar:0.0.1 .

![Image text](https://raw.githubusercontent.com/Kingsley-Delfino/student-managemnet/master/src/main/resources/static/img/20201007165457.png)

###6、查看镜像

输入命令：docker images

![Image text](https://raw.githubusercontent.com/Kingsley-Delfino/student-managemnet/master/src/main/resources/static/img/20201007171735.png)

###7、运行镜像

输入命令：docker run -p 8010:8080 student-management.jar:0.0.1

![Image text](https://raw.githubusercontent.com/Kingsley-Delfino/student-managemnet/master/src/main/resources/static/img/20201007171942.png)

##三、程序运行

###1、访问页面

在本地浏览器中输入地址：10.176.34.83：8010

![Image text](https://raw.githubusercontent.com/Kingsley-Delfino/student-managemnet/master/src/main/resources/static/img/20201007172202.png)

###2、添加学生信息

点击“添加学生信息”按钮，页面跳转到“添加”页面

![Image text](https://raw.githubusercontent.com/Kingsley-Delfino/student-managemnet/master/src/main/resources/static/img/20201007175149.png)

填入学生信息，点击“添加学生信息”按钮，页面通过URL：“/api/vi/student“向系统中添加该位学生，页面伴随有”添加成功！“或”添加失败！“的提示框。

![Image text](https://raw.githubusercontent.com/Kingsley-Delfino/student-managemnet/master/src/main/resources/static/img/20201007172920.png)

可在”查看“页面检查添加结果

![Image text](https://raw.githubusercontent.com/Kingsley-Delfino/student-managemnet/master/src/main/resources/static/img/20201007173002.png)

###3、查看学生信息

点击“查看学生信息”按钮，页面跳转到“查看”页面，页面通过URL：“/api/vi/student“列出当前系统内所有学生的信息

![Image text](https://raw.githubusercontent.com/Kingsley-Delfino/student-managemnet/master/src/main/resources/static/img/20201007173002.png)

###4、修改学生信息

点击“修改学生信息”按钮，页面跳转到“修改”页面

![Image text](https://raw.githubusercontent.com/Kingsley-Delfino/student-managemnet/master/src/main/resources/static/img/20201007174046.png)

填入需要修改的学生的学号，并填入更新的学生信息，点击“修改学生信息”按钮，页面通过URL：“/api/vi/student“对系统中的该位学生进行信息修改，页面伴随有”修改成功！“或”修改失败！“的提示框。

![Image text](https://raw.githubusercontent.com/Kingsley-Delfino/student-managemnet/master/src/main/resources/static/img/20201007174117.png)

可在”查看“页面检查修改结果

![Image text](https://raw.githubusercontent.com/Kingsley-Delfino/student-managemnet/master/src/main/resources/static/img/20201007174136.png)

###5、删除学生信息

点击“删除学生信息”按钮，页面跳转到“删除”页面

![Image text](https://raw.githubusercontent.com/Kingsley-Delfino/student-managemnet/master/src/main/resources/static/img/20201007174154.png)

填入需要删除的学生的学号，点击“删除学生信息”按钮，页面通过URL：“/api/vi/student“对系统中的该位学生进行删除，页面伴随有”删除成功！“或”删除失败！“的提示框。

![Image text](https://raw.githubusercontent.com/Kingsley-Delfino/student-managemnet/master/src/main/resources/static/img/20201007175616.png)

可在”查看“页面检查删除结果

![Image text](https://raw.githubusercontent.com/Kingsley-Delfino/student-managemnet/master/src/main/resources/static/img/20201007174233.png)
