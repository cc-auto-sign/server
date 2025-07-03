# CC-ADMIN 敏捷开发框架

[![MySQL 5.7](https://img.shields.io/badge/MySQL-5.7-%234479A1?logo=mysql)](https://dev.mysql.com/)
[![JDK 24](https://img.shields.io/badge/JDK-24-%23038b1c?logo=openjdk)](https://openjdk.org/)
[![CentOS 7](https://img.shields.io/badge/CentOS-7-%23A30044?logo=centos)](https://www.centos.org/)
[![Redis](https://img.shields.io/badge/Redis-%23DC382D?logo=redis)](https://redis.io/)

> 基于Spring Boot的轻量化敏捷开发框架，具备RBAC权限控制、自动代码生成等核心功能
---
## 🧰 核心组件
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.3-%236DB33F?logo=springboot)](https://spring.io/projects/spring-boot)
[![Sa-Token](https://img.shields.io/badge/Sa--Token-1.44.0-%23FF6B6B?logo=java)](https://sa-token.cc/)
[![MyBatis Plus](https://img.shields.io/badge/MyBatis_Plus-3.5.12-%231a73e8?logo=mybatis)](https://baomidou.com/)

---
## 🚀 快速启动

### 前置要求
- xxx
- xxx
- xxx
### 配置指南
- xxx
- xxx
- xxx

---
## ✨ 核心特性
- **模块化架构设计**：前后端分离，支持微服务扩展
- **高效代码生成器**：一键生成Entity/DAO/Service/Controller基础代码
- **权限管理体系**：细粒度RBAC权限控制，支持按钮级别权限管理
- **监控与预警**：集成健康检查、性能监控等运维功能
- **标准化接口规范**：RESTful API设计，严格的HTTP状态码管理
---
## 📡 接口响应规范

### HTTP状态码映射表
| HTTP Status | Body Code | 说明                     | 典型场景               |
|-------------|-----------|--------------------------|-----------------------|
| 200         | 200       | 请求成功                 | 正常业务响应           |
| 400         | 400       | 参数校验失败             | JSON格式错误/必填字段缺失 |
| 401         | 401       | 身份认证失败             | Token过期/无效Token    |
| 403         | 403       | 访问权限不足             | 接口权限未授予          |
| 404         | 404       | 资源不存在               | 无效API路径           |
| 500         | 500       | 系统内部错误             | 未捕获异常/NPE错误     |

### 标准响应结构
```json
{
  "code": 200,
  "msg": "success",
  "data": {
    // 业务数据内容
  },
  "timestamp": 1751508990518
}
```
---

```mermaid
erDiagram
sys_user ||--o{ sys_user_role : "1:N"
sys_role ||--o{ sys_user_role : "1:N"
sys_role ||--o{ sys_role_menu : "1:N"
sys_menu ||--o{ sys_role_menu : "1:N"

    sys_user {
        BIGINT user_id PK "用户ID"
        VARCHAR username "登录账号"
        VARCHAR password "加密密码"
        VARCHAR nick_name "显示名称"
        TINYINT status "状态(0停用 1正常)"
        DATETIME create_time "创建时间"
    }
    
    sys_role {
        BIGINT role_id PK "角色ID"
        VARCHAR role_key "角色标识"
        VARCHAR role_name "角色名称"
        INTEGER order_num "排序号"
        DATETIME create_time "创建时间"
    }
    
    sys_user_role {
        BIGINT id PK "关联ID"
        BIGINT user_id FK "用户ID"
        BIGINT role_id FK "角色ID"
    }
    
    sys_menu {
        BIGINT menu_id PK "菜单ID"
        VARCHAR menu_name "菜单名称"
        VARCHAR permission "权限标识"
        VARCHAR component "前端组件"
        INTEGER order_num "排序号"
        BIGINT parent_id "父菜单ID"
    }
    
    sys_role_menu {
        BIGINT id PK "关联ID"
        BIGINT role_id FK "角色ID"
        BIGINT menu_id FK "菜单ID"
    }

```
## 🛠️ 二次开发
xxxxx

---
## 📄 许可证
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

Copyright (c) 2025 CC-ADMIN Team  
根据MIT许可证条款，您可以：

✅ 自由使用、修改代码  
✅ 用于商业项目  
✅ 进行再分发  

附加条件：  
📌 **必须保留原始版权声明**  
📌 **必须包含许可证文件副本**  