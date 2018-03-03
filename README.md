## 项目简介
* 1权限管理系统-权限维护系统 authmanager
    * 核心模块管理:系统字典,组织,用户,应用系统,角色,权限,菜单,功能

* 2权限管理系统-单点登录系统 authsso
    * 验证管理用户权限,生成有效验证标识存储缓存,返回到发起访问子应用系统带上有效验证标识。

* 3权限管理系统-权限接口系统 authserviceapi
    * 操作子应用系统时后台根据有效验证标识获取用户子应用系统权限,权限控制。 
* 设计目标是开发迅速、代码量少、学习简单、功能强大、轻量级、易扩展、支持多套系统权限统一配置。
* 各子系统支持横向/纵向拆分

## 技术选型
* 核心框架：Spring Framework
* 持久层框架：MyBatis
* 缓存框架：Redis
* 日志管理：SLF4J、Log4j2
* 前端框架：Bootstrap + Jquery

## 系统结构图
![系统结构图](/doc/functionchart.jpg)

## 系统流程图
![系统流程图](/doc/flowchart.jpg)

## UI效果图

![登录](/doc/show_login.jpg)

![列表](/doc/show_list.jpg)

![编辑选择对象](/doc/show_select.jpg)

## 使用说明

## 问题反馈
