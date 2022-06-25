1、minio 安装
http://192.168.159.130:33806/
minioadmin
minioadmin
vmware centos7虚拟机
文件目录：/root
minio
nohup ./minio server --console-address :33806 --address 0.0.0.0:9666 /home/minio_bark/data &

-----------------------------------------------------------------------------------------------------------------------------------------
参考文件：
1、centos搭建minio
https://blog.csdn.net/wdy0078/article/details/121902940
2、springboot整合minio
https://www.jianshu.com/p/d8552e5050eb
3、springboot整合minio
https://www.jianshu.com/p/403eaf7d401c

-----------------------------------------------------------------------------------------------------------------------------------------


下载方法路由：
http://localhost:8080/api/minio/downloadFile?bucketName=tdms&filePath=/view.png&originalName=view.png

-----------------------------------------------------------------------------------------------------------------------------------------
minio 设置时区
The difference between the request time and the server’s time is too large.

查看系统时间
date
查看硬件时间
hwclock
设置服务器时间
安装utpdate工具
yum -y install utp ntpdate
设置系统时间与网络时间同步
ntpdate cn.pool.ntp.org
将系统时间写入硬件时间
hwclock --systohc
服务器时区设置（设置系统时区为上海）
timedatectl set-timezone Asia/Shanghai
