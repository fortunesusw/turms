### Turms 是什么

Turms是一套全球范围内最为先进且全能的开源即时通讯解决方案。

[文档地址：https://turms-im.github.io/turms/](https://turms-im.github.io/turms/)

### 组合

| 名称                                                        | 描述                                                         |
| ----------------------------------------------------------- | ------------------------------------------------------------ |
| <span style="white-space:nowrap;">turms</span>              | Turms服务端。本质是一个易于集群部署、健壮、方便拓展、运作高效且业务独立的Java即时通信服务端程序 |
| <span style="white-space:nowrap;">turms-client-js</span>    | 除了实现显而易见的业务功能外，关键还实现了与Turms服务端的交互逻辑（如路由跳转、消息去重、心跳检查等），对调用者透明。您在使用该库时，无需关系背后的逻辑 |
| <span style="white-space:nowrap;">turms-client-java</span>  | 同上                                                         |
| <span style="white-space:nowrap;">turms-admin</span>        | 为Turms服务端集群提供：运营数据统计、内容管理、集群配置等功能 |
| <span style="white-space:nowrap;">turms-apm</span>          | 为Turms服务端集群提供监控功能                                |
| <span style="white-space:nowrap;">turms-plugin</span>       | 事件（如用户上下线事件、消息接收与转发事件等）触发的时候，对应的自定义插件将被触发以实现各种各样定制功能 |
| <span style="white-space:nowrap;">turms-client-swift</span> | 尚未提供，将于2020年完成开发                                 |

### 关于Demo

出于Turms解决方案的定位，Turms并不打算在近期提供带UI与具体业务逻辑的客户端Demo。

一方面，在业务层面，Turms已经足够简单易用了，若您仅是想自行测试Turms的业务功能，您甚至无需敲一行代码，即可运行Turms服务端。仅需十来行代码就可以实现客户端的登陆、发送消息、发送好友请求等等多种业务操作，修改下业务相关配置，即可定制各种业务。

另一方面，Demo的设计与实现与具体业务场景、具体的编程语言、具体的技术架构、具体的运行平台都密切相关。而Turms解决方案一直是致力于高效地满足各种复杂多变的即时通讯业务场景，不希望因为Demo限制了开发者的想象力。并且开发与维护Demo也非常地费时费力，会拖慢Turms服务端的工作进度。

因此，近期不打算做具体业务场景相关的Demo。