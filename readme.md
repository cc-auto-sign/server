# cc-auto-sign-server cc-auto-sign的后端服务

一个基于React 19和Ant Design 5构建的现代化签到管理系统，使用Vite作为构建工具。

## 写在前面
目前还没有完成，只是把页面实现了，agent写完了，这个页面的服务端还在写。

## 目前的想法
### 架构图
```mermaid
graph TD
    subgraph 应用商店端
        A[插件市场] --> B[插件审核]
        A --> C[版本管理]
    end

    subgraph 客户端
        D[插件管理] --> E[账号配置]
        F[任务调度中心] -->|分发任务| G[Agent1]
        F -->|分发任务| H[Agent2]
        I[日志中心] --> J[日志聚合]
    end

    subgraph Agent端
        G --> K[接收任务]
        K --> L[执行脚本]
        H --> M[接收任务]
        M --> N[执行脚本]
        L -->|结果| J
        N -->|结果| J
    end

    L -->|访问| O[目标平台]
    N -->|访问| O
```

### 任务下发时序图
```mermaid
sequenceDiagram
    participant 客户端
    participant Agent
    participant 目标平台

    客户端->>Agent: 直接下发任务（含插件脚本和参数）
    activate Agent
    Agent->>目标平台: 执行签到（调用插件脚本）
    activate 目标平台
    目标平台-->>Agent: 返回签到结果
    deactivate 目标平台
    Agent-->>客户端: 上报日志和状态
    deactivate Agent
```

## 项目概述

突发奇想打算做一个插件化的自动签到系统，由开发者维护插件商店，其他人可自行上传写好的签到插件，又多个node节点去执行签到任务（需自行部署node节点），这样不同签到任务可以用不同地区的服务器来签到。

## 主要功能

### 仪表盘
![仪表盘截图](https://raw.githubusercontent.com/cc-auto-sign/front-end/refs/heads/master/docs/home.png)

### 插件商店
![插件商店截图](https://raw.githubusercontent.com/cc-auto-sign/front-end/refs/heads/master/docs/store.png)

### 任务管理
![任务管理截图](https://raw.githubusercontent.com/cc-auto-sign/front-end/refs/heads/master/docs/task.png)
![任务管理截图](https://raw.githubusercontent.com/cc-auto-sign/front-end/refs/heads/master/docs/task2.png)

### 节点管理
![节点管理截图](https://raw.githubusercontent.com/cc-auto-sign/front-end/refs/heads/master/docs/node.png)

### 日志查看
![日志查看](https://raw.githubusercontent.com/cc-auto-sign/front-end/refs/heads/master/docs/log.png)