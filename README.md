## pickle

## 资料
[Spring 文档](https://spring.io/guides)  
[Bootstrap——前端页面](https://v3.bootcss.com/getting-started/)  
[Github OAuth——github授权应用](https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/)  
[OKHttp——post、get请求](https://square.github.io/okhttp/)  
[菜鸟教程——sql语句](https://www.runoob.com/mysql/mysql-tutorial.html)  
[thymeleaf——模板引擎](https://www.thymeleaf.org/)

## 工具
[Git](https://git-scm.com/downloads)  
[Lombok](https://projectlombok.org/)  



## 脚本
```sql
CREATE TABLE USER(
id INT AUTO_INCREMENT PRIMARY KEY,
account_id VARCHAR(100),
`name` VARCHAR(50),
token CHAR(36),
gmt_created BIGINT,
gmt_modified BIGINT
);

ALTER TABLE USER ADD bio VARCHAR(256);

CREATE TABLE question(
id INT AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(50),
description TEXT,
gmt_create BIGINT,
gmt_modified BIGINT,
creator INT,
comment_count INT DEFAULT 0,
view_count INT DEFAULT 0,
like_count INT DEFAULT 0,
tag VARCHAR(256)
);

ALTER TABLE USER ADD avatar_url VARCHAR(100);
```