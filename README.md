# Turms

Turms是一款完全免费开源、易于集群部署、健壮、方便拓展、运作高效且业务独立的Java即时通信服务端程序。

- 下述**beta**版本项目已开源，总体完成度约90%。在业务功能上，beta版本已支持所有✔的业务功能点，并且Turms已经攻破了设计上与技术上的难点，架构已定型，后期仅需添砖加瓦即可稳步前进。但由于beta版本并仅经过简单的测试，因此近期主要的工作还是查漏补缺（主要是补全给管理员用的数据统计与小部分标记为TODO的功能点）、完善逻辑与修补bug。欢迎各开发者在Issues区域咨询诸如业务实现、架构设计、关键功能设计与new features相关的提单。
- 大部分bug和小的新feature会在一至二个自然日之内解决或提供，复杂的bug会在一至十四个自然日内解决。

1. turms服务端 v0.8.0-beta：已发布源码、发布包与基础文档
2. [turms-client-js v0.8.0-beta](https://github.com/turms-im/turms-client-js)：已发布源码与基础文档
3. turms-admin v0.8.0-beta：由于许多新业务功能点不在原开发计划内，为了保证turms-admin的早期设计与新增的功能点保持一致的逻辑，因此跳票。turms-admin会在与Turms服务端联调后于19年12月中旬发布。
4. ~~turms-client-dart v0.8.0：暂时取消，原因看下表。~~
5. ~~turms-client-flutter-demo v0.8.0：暂时取消，原因看下表。~~

## 配套组合

| 范围        | 类别                     | 功能描述                                                     | 名称                                                         |
| ----------- | ------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Turms服务端 | 自定义插件实现接口       | 事件（如用户上下线事件、消息接收与转发事件等）触发的时候，对应的自定义插件将被触发以实现各种各样定制功能 | [turms-plugin](https://github.com/turms-im/turms-plugin)     |
| Turms服务端 | CMS                      | 为Turms服务端集群提供：运营数据统计、内容管理、集群配置等功能 | [turms-admin](https://github.com/turms-im/turms-admin)       |
| Turms客户端 | 通讯能力库               | 除了实现显而易见的业务功能外，关键还实现了与Turms服务端的交互逻辑（如路由跳转、消息去重、心跳检查等），对调用者透明。您在使用该库时，无需关系背后的逻辑 | [turms-client-js](https://github.com/turms-im/turms-client-js) |
| Turms客户端 | UI组件模板（不依赖框架） | （提醒：您完全可以不使用该UI组件模板，而是自定义UI组件）基于turms-client-js实现，各UI组件结合了HTML5+JS+CSS，实现了，同时也作为demo来展示常见场景下，界面与功能的常见调用关系 |                                                              |
| Turms客户端 | 通讯能力库               | 考虑到当前大环境下Flutter的市场份额与有限的开发时间与精力，Turms希望将有限的时间与精力放到刀刃上（Turms服务端）。因此，关于Turms是否要专门为Flutter平台开发客户端的问题，后期将由Turms社区投票表决。如果Turms社区对Flutter平台需求迫切，那么Turms将尽可能自行开发（但代价是Turms服务端的更新就会慢下来），否则可能就要交由第三方团队进行开发。 | ~~[turms-client-dart](https://github.com/turms-im/turms-client-dart)~~ |
| Turms客户端 | UI组件(Unplanned)        | ——同上                                                       | ~~[turms-client-ui-flutter](https://github.com/turms-im/turms-client-ui-flutter)~~ |
| Turms客户端 | Demo                     | ——同上                                                       | ~~[turms-client-flutter-demo](https://github.com/turms-im/turms-client-flutter-demo)~~ |

注意：出于对开发成本与维护成本的考虑，Turms暂不提供在Android（Java/Kotlin）与iOS（Swift/Objective-C）平台中Turms客户端的原生实现，而是提供了基于具有跨平台能力的JavaScript~~与Dart~~语言的客户端实现。

额外补充：关于Demo这块的计划。出于Turms解决方案的定位，Turms并不打算在近期提供带UI与具体业务逻辑的客户端Demo。
因为一方面，在业务层面，Turms已经足够简单易用了，若您仅是想自行测试Turms的业务功能，您甚至无需敲一行代码，即可运行Turms服务端。仅需十来行代码就可以实现客户端的登陆、发送消息、发送好友请求等等多种业务操作，修改下业务相关配置，即可定制各种业务。
另一方面，Demo的设计与实现与具体业务场景、具体的编程语言、具体的技术架构、具体的运行平台都密切相关。而Turms解决方案一直是致力于高效地满足各种复杂多变的即时通讯业务场景，不希望因为Demo限制了开发者的想象力。并且开发与维护Demo也非常地费时费力，会拖慢Turms服务端的工作进度。因此，近期不打算做具体业务场景相关的Demo。

## 关于二次开发

Turms基于Apache V2协议，深入贯彻开源精神与宗旨。既欢迎其他开发者或团队的借鉴，也不担心抄袭。因为Turms有且只有一个目标：致力于构建全球范围内最为卓越开源即时通讯解决方案。对于任何二次开发者或团队，Turms后期都会不加保留为其逐步开放各种相关架构设计、技术选型、代码视图设计等文档，甚至为二次开发者提供响应式编程水平测试（如果无法通过这些基础测试，那就无法基于Turms进行二次开发）。
不管任何开发者或团队是借鉴还是抄袭，Turms对其提出的issues都将一视同仁，对有价值的问题都将予以热心的答复。
Turms的目标很简单：致力于构建全球范围内最为卓越开源即时通讯解决方案。

## 设计与编码理念

Community > Performance >= Convenience > Convention > Configuration

## 主要特性

Turms在业务功能配置全面且灵活的同时，不失性能。在部署简易的同时，不失配置的可定制性与灵活性。

1. 业务功能完善性。Turms支持几乎所有商用即时通信产品所支持的即时通信相关功能（甚至还有更多的业务功能），并且无任何增值功能收费，无需提交工单以申请功能，无业务功能限制。
2. 功能拓展性。Turms同时支持两种拓展模式。配置参数；自定义Plugin插件（0.9.0）。当然您也完全可以对源码进行修改。未来接入ElasticSearch集群部分就将基于Plugin实现。
3. 配置灵活性。Turms提供了上百个配置参数供用户定制，以满足各种即时通信场景。并且大部分配置都可以在集群运作时，进行集群级别的同步动态更新，并且不损失性能。
4. 部署简易性。Turms集群中仅有Turms服务端节点，默认无需为第三方服务端部署服务器。您甚至可以在不输入一行代码、一行配置的情况下，完成Turms集群的部署。
5. 部署灵活性（可定制性）。配合Turms客户端，Turms服务端自带了基本的负载均衡与集群查找功能（0.9.0），您甚至可以无需配置部署NginX或是其他相关LB服务端。另一方面，Turms采用MongoDB作为数据库服务端，高级开发者有100%的自主权去自定义MongoDB的配置与其集群设计，以支撑不同规模的业务场景（如Replica Set部署、Sharded Cluster部署、Replica Set + Sharded Cluster部署、多个mongos对应多个MongoDB服务端部署等部署方案）
6. 集群健壮性（高可用性）。Turms服务端通过虚拟哈希槽策略、Hazelcast的Bully算法选举并结合Quorum概念（补充：可动态配置），来保证在部分集群节点宕机的情况下，即便出现脑裂问题，Turms集群仍能保证状态的一致性，以正常运作。
7. 运作高效性。在业务设计上，Turms同时兼顾了消息与通知的实时性与资源消耗，在保证可实时动态更新且定制参数的同时，还通过版本控制，保证服务器的资源消耗最低。在代码上，Turms服务端所有代码均采用“响应式编程”模式，是目前对响应式编程实践最为深刻的开源项目，尤其值得一提的是Turms的数据库访问操作均是异步无阻塞的。同时Turms服务端与Turms客户端间的所有通信数据均为Protobuf二进制数据。并且各功能模块充分利用内存，通过本地缓存高效运作。
8. 集群独立性。一方面，Turms集群独立于您的业务逻辑服务端，您可以很方便的插拔Turms集群。另一方面，对于Turms集群内部使用的Hazelcast与MongoDB集群，您可以自行进行各种定制化配置运维部署，Turms服务端集群可与其分开维护，保障各界的高级开发者不受束缚。

## Quick Start

- 下载并解压[Turms服务端](https://github.com/turms-im/turms/releases)压缩包。

- 下载并安装[MongoDB v4.2.0](https://www.mongodb.com/download-center/community)，并将数据库的URI、账号与密码配置到config/application.yaml中（提醒：您也可以直接在此处配置多个MongoDB地址，Turms会自动接入MongoDB集群）。

  （具体可参考：https://docs.mongodb.com/manual/reference/connection-string/）

- 运行MongoDB数据库。运行bin/mongo-quick-start-run-primary与bin/mongo-quick-start-run-secondary，约几秒后会提示“waiting for connections on port 29510”。则再运行bin/mongo-quick-start-init（或者自行搭建MongoDB集群）
  请确保运行正确，否则Turms会抛出MongoSocketOpenException、MongoNotPrimaryException等异常。

- （可跳过，保持默认）根据您的需求配置config/hazelcast.yaml、config/jvm.options、config/application.yaml（您可以在此处配置Turms自定义的配置参数）。

- 在所有需要运行Turms服务端的系统上，运行bin/turms脚本。若您保留默认的config/hazelcast.yml配置，Turms服务端会自动寻找其他Turms服务端节点，由此Turms集群开始运作。

提醒：上述操作主要用于您初次体验Turms集群使用，若您需将Turms部署在生产环境当中，请务必查阅Wiki手册，了解各种配置参数的意义，以最小的资源消耗，来定制属于您自己的业务需求与业务组合。

Turms服务端会自动检测Turms集群中是否已存在至少一个Root Admin账号。如果不存在，则Turms会自动随机生成一个Root Admin账号，并打印在日志中：如：

2019-10-13 00:00:00.000  INFO 14152 --- [tLoopGroup-2-20] im.turms.turms.common.TurmsLogger:
Root admin: {
  "Account" : "WjAuPfclpyJjvhtl",
  "Raw Password" : "4CWBq&z&BdLDe@77q+]g +MHLV#Vx~[i"
}

## 业务功能列表

1. 在业务功能列表处，有部分功能标注了“✍”，该图标用于表明“是否执行该业务功能点的判定逻辑，需由开发者结合自身业务应用场景，自行判断并调用相关API。Turms自身无法判定当前Context是否满足触发该功能点的条件”。
2. 此功能列表参考了：网易云信、环信、融云、LeanCloud、腾讯云通讯等商用即时通信服务。Turms提供了几乎所有这些商业服务所提供的业务功能，并在很多方面更上一层楼。
3. 本功能列表仅为上层业务功能列表，若您希望从底层开发者角度了解业务功能点的实现原理，请在Wiki中（TODO）查阅具体实现的参数配置、完整方案与原理。
4. Turms的功能配置参数极其自由，您甚至可以配置一个群组上限成员数量为10,000，单个消息上限100MB，关闭大部分业务功能等等的配置，拓展将消息转发给所有的用户等等的功能，Turms服务端不会干涉您满足任何的业务场景。
   Turms只是为您提供了最通用的配置，如默认一个群的上限人数为500，单个消息最大可为1MB等等。
5. 如果您未在此列表中找到您所需要的功能，请先检查是否您的需求仅需配置Turms参数即可实现。确认无法通过Turms配置参数实现后，请再在Issue区域提出。Turms会根据“性价比”进行评估，并尽可能满足您的需求。
6. 关于“实现版本”。此处所述的实现版本号均为保守评估的功能实现版本号，实际情况通常是<提前完成并提前引入>。并且Turms的版本号设计并不完全遵循 [Semantic Versioning](https://github.com/semver/semver/blob/master/semver.md)，Turms的大版本号主要由关键功能的引入而推动。在涉及Breaking Changes的部分会单独提出。

特别注意：对于一些功能点，Turms服务端或是客户端本身并**不直接**提供一些业务功能点。以“阅后即焚”功能为例，Turms实际做的事情仅仅是在消息的基础上，多传递了一个burnAfter的参数，阅后怎么“焚”，什么时间点“焚”，要不要用户的本地数据库里的消息也给“焚”了等等，这都是上层应用实现者考虑的事情，Turms不予干预。

### 多端登录类型

提醒：Turms允许您通过参数来自己定制哪些设备能同时登陆，哪些设备不能同时登陆。以下仅是常见的多端登陆类型搭配，供您快速挑选实现。

“设备类型”指的是：Android、iOS、Desktop、Browser、Unknown、Others

| **常见类型**                                                 | **功能描述** | **相关配置** | **实现版本** |
| :----------------------------------------------------------- | ------------ | ------------ | :----------- |
| 允许每种设备类型的一个设备都能同时在线                       |              |              | 0.8.0 ✔      |
| 仅允许一个设备类型的一个设备同时在线                         |              |              | 0.8.0 ✔      |
| 允许Desktop端的一个设备与手机端的一个设备同时在线                 |              |              | 0.8.0 ✔      |
| 允许Desktop端或者Browser端的一个设备，与手机端的一个设备同时在线      |              |              | 0.8.0 ✔      |
| 允许Desktop端的一个设备，与Browser端的一个设备，与手机端的一个设备同时在线 |              |              | 0.8.0 ✔      |
| 允许Desktop端或手机端的一个设备同时在线                           |              |              | 0.8.0 ✔      |
| 允许Desktop端或手机端或Browser端的一个设备同时在线                     |              |              | 0.8.0 ✔      |

注意：

- 任何多端登陆类型都不允许一个用户账号在一种设备上有多个同时登陆的设备
- 当用户登陆设备的类型有Unkown或Others情况时，需进行额外配置：允许Unkown/Others设备与其他已知设备同时登陆、不允许Unkown/Others设备与其他已知设备同时登陆

### 多端登陆冲突解决策略

| **类型**           | **功能描述**                                       | **相关配置** | **实现版本** |
| :----------------- | -------------------------------------------------- | ------------ | :----------- |
| 已上线设备掉线     | 已上线的设备掉线                                   |              | 0.8.0 ✔      |
| 请求已上线设备确认 | 已上线的一方获得通知，同意或拒绝预上线设备上线请求 |              | 0.9.0 ❓      |
| 预上线设备上线失败 | 准备上线的一方直接上线失败                         |              | 0.8.0 ✔      |

### 业务消息类型

提醒：虽然Turms服务端默认支持传递与存储图片、视频、文件等数据，但极其不推荐使用此实现方案。
推荐的实现方案是使用CDN技术。客户端向您的服务服务端程序请求CDN许可Token，由客户端将带着这个Token找到CDN并上传文件到CDN上，并拿着从CDN那返回的文件URL传递给Turms服务端，由Turms保存这个URL文本，而不保留文件的二进制数据。或是采用未来Turms提供的小文件管理集群，或是实现Turms插件（0.9.0）来自主定制与部署文件管理服务端集群。

#### 基础内容类消息类型

| **消息类型** | **功能描述**                                                 | **相关配置** | **实现版本** |
| :----------- | :----------------------------------------------------------- | ------------ | :----------- |
| 文本消息     | 消息内容为普通文本                                           |              | 0.8.0 ✔      |
| 图片消息     | 消息内容为描述部分（可选）：图片 URL 地址、尺寸、图片大小<br />图片数据（可选） |              | 0.8.0 ✔      |
| 语音消息     | 消息内容为描述部分（可选）：语音文件的 URL 地址、时长、大小、格式<br />语音数据（可选）<br /> |              | 0.8.0 ✔      |
| 视频消息     | 消息内容为描述部分（可选）：视频文件的 URL 地址、时长、大小、格式<br />视频数据（可选）<br /> |              | 0.8.0 ✔      |
| 文件消息     | 消息内容为描述部分（可选）：文件的 URL 地址、大小、格式<br />文件数据（可选）<br />默认最大支持 16 MB |              | 0.8.0 ✔      |
| 地理位置消息 | 消息内容为地理位置标题、地址、经度、纬度信息                 |              | 0.8.0 ✔      |

#### 其他消息类型

| **消息类型**   | **功能描述**                                                 | **相关配置** | **实现版本** |
| :------------- | :----------------------------------------------------------- | ------------ | :----------- |
| 组合内容类消息 | 消息内容为文本信息与任意个数的其他任意内容类消息类型的消息（如一条消息既包含了文本，也包含了图片与音频） |              | 0.8.0 ✔      |
| 通知消息       | 自身并不携带消息内容的通知类消息。主要用于如添加好友、群组邀请、撤回消息、已读回执等的通知 |              | 0.8.0 ✔      |
| 自定义消息     | 开发者通过“组合内容类消息”自定义的消息类型，例如红包消息、石头剪子布等形式的消息 |              | 0.8.0 ✔      |
| 系统消息       | 基础内容类消息类型与组合内容类消息均可作为系统消息           |              | 0.9.0 ❓      |

### 消息功能

| **消息功能** | **功能描述**                                                 | **相关配置** | **实现版本** |
| :----------- | :----------------------------------------------------------- | ------------ | :----------- |
| 离线消息     | 实现思路：您可以在Turms客户端每次登陆时，都<主动>向Turms服务端请求关于<该用户在离线状态时，收到的所有私聊与群聊各自具体的离线消息数量，以及各自具体的最后N条消息（默认为1条）>的数据，以此同时兼顾消息的实时性与服务的性能。 默认情况下，Turms服务端<不会>定时删除寄存在Turms服务端的任何离线消息 |              | 0.8.0 ✔      |
| 漫游消息     | ✍在新设备登录时，由开发者自行调用Turms客户端的消息查询接口，指定数量与时段等条件，向Turms服务端请求漫游消息。<br />漫游消息的实现本质与“历史消息”的实现一样<br />（✍原因：Turms无法自行判断什么是“新设备登陆”） |              | 0.8.0 ✔      |
| 多端同步     | 当一名用户有多客户端同时在线时，Turms服务端会将消息下发给该用户所有在线的客户端 |              | 0.8.0 ✔      |
| 历史消息     | 支持查询用户的历史消息。默认Turms永久存储消息（包括用户消息或系统消息）<br />历史消息的实现本质与“漫游消息”的实现一样 |              | 0.8.0 ✔      |
| 消息撤回     | 撤回投递成功的消息，默认允许发信人撤回距投递成功时间 2 分钟内的消息 |              | 0.8.0 ✔      |
| 消息编辑     | 编辑已发送成功的消息                                         |              | 0.8.0 ✔      |
| 阅后即焚     | 收信人接收到发信人的消息后，收信人客户端会根据发信人预先设定（或默认）的时间按时自动销毁 |              | 0.8.0 ✔      |
| 已读回执     | ✍通知私聊对象或群组成员中，当前用户已读某条消息<br />查看私聊、群组会话中对方的已读/未读状态<br />（✍原因：Turms无法得知您的用户在什么情况下算是“已读某条消息”。开发者需要自行调用turmsClient.messageService.readMessage()来告知对方，当前用户已读某条消息） |              | 0.8.0 ✔      |
| 消息转发     | 将消息转发给其他用户或群组                                   |              | 0.9.0 ❓      |
| @某人        | 用于特别提醒某用户。如果Turms客户端检测到已接收的消息中被@的用户为当前登陆中的用户，Turms客户端则会触发@回调函数。开发者可自行实现后续相关业务逻辑。常用于给被@的用户提醒通知。<br />群内 @ 消息与普通消息没有本质区别，仅是在被 @ 的人在收到消息时，需要做特殊处理（触发回调函数） |              | 0.8.0 ❓      |
| 正在输入     | ✍当通信中的一方正在键入文本时，告知收信人（一名或多名用户），该用户正在输入消息<br />（✍原因：Turms无法得知您的用户是否正在键入文本） |              | 0.8.0 ✔      |

### 用户资料功能

| **功能**             | **功能描述**                                                 | **相关配置** | 实现版本 |
| :------------------- | :----------------------------------------------------------- | ------------ | -------- |
| 设置用户资料         | 用户设置自己的昵称、介绍、头像URL                            |              | 0.8.0 ✔  |
| 获取用户资料         | 用户查看自己或其他用户的资料                                 |              | 0.8.0 ✔  |
| 设置用户资料访问权限 | 用户可以针对个人的每项资料设置访问权限。访问权限有：所有人可见、好友可见、仅自己可见 |              | 0.8.0 ✔  |

### 用户关系托管

概念：

（早期设计中，有一个“联系人”（Contacts）概念，现在已将该概念移除。直接原因是现在Turms限制所有关系必须存在于一个关系人分组当中。间接原因是“联系人”与“关系人”概念容易混淆，不利于理解）

关系：关系分为单向关系与双向关系。单向关系指的是：关系的Owner（关系拥有者）对Related User（关系人）具有某种具体的关系，如“单向好友”（允许对方发消息、好友请求过来）或是“拉黑用户”（禁止对方发消息、好友请求过来等）。单向关系的建立不需要进行权限认证。双向关系指的是：用户A对用户B有一个单向关系，用户B对用户A也有一个单向关系。如用户A屏蔽了用户B，而用户B可以指明不屏蔽用户A。

关系人（Related Users）：指的是具有单向或双向关系（指明对方为好友或拉黑用户）的用户。如果两名用户不具有任意一种关系，则其为Strangers。

关系人分组：关系人分组由分组名与一组关系人组成，每个关系必然存在于至少一个关系人分组当中。如果客户端在创建关系时，未对该关系进行分组操作，则该关系会被放进该用户的默认关系组当中。因此要特别注意的就是：在“一个关系人分组”里即可以有好友，也可以有拉黑用户。当然您可以通过业务限制，只允许一个分组有某一类关系人。

额外补充：实际上，在Turms领域模型中并没有“好友/拉黑用户”这样的概念，其实质是一个叫“isBlocked”的bool。

| **功能**                     | **功能描述**                                                 | **相关配置** | **实现版本** |
| :--------------------------- | :----------------------------------------------------------- | ------------ | :----------- |
| 获取关系                     | 根据可选的过滤（如指定用户ID、“是否是联系人”、“是否是好友/拉黑用户”等）与分组条件，获取当前用户所拥有的关系 |              | 0.8.0 ✔      |
| 添加关系人(+发起好友请求)    | ①若是添加关系为“好友”的关系人，则根据您自定义的Turms服务端配置，用户既可直接添加"好友"，也可以先发起好友请求，待获得批准后，才可执行添加操作。<br />②若是添加关系为“拉黑用户”的关系人，则直接生效，无需批准。用户将不再收到拉黑用户发来的任何消息或者请求。 |              | 0.8.0 ✔      |
| 通过/拒绝好友请求            | 用户可以通过或者拒绝好友请求。若同意好友请求，则二者将建立双向的“好友”关系 |              | 0.8.0 ✔      |
| 删除关系人                   | 根据可选删除条件（如“是/不是关系人”、“是好友/拉黑用户”），删除某类关系人或指定关系人。 |              | 0.8.0 ✔      |
| 修改与关系人的关系           | 修改用户关系（好友/拉黑用户）信息。在修改关系为“好友”时，默认需要先发送好友请求（您可以取消此步骤） |              | 0.8.0 ✔      |
| 创建关系人分组               | 创建分组时，可以同时指定分组名与被添加的关系人。同一关系人可以被添加到多个分组 |              | 0.8.0 ✔      |
| 删除关系人分组               | 删除关系人分组，同时可以可选是否转移被删除关系人分组中的关系人到其他分组（若不指定，则默认分配到“默认分组”） |              | 0.8.0 ✔      |
| 重命名关系人分组             | 重命名关系人分组                                             |              | 0.8.0 ✔      |
| 获取用户自己的关系人分组信息 | 获取用户自己的关系人分组信息                                 |              | 0.8.0 ✔      |
| 添加关系人到某分组           | 将关系人添加到/移到关系人分组。若分组不存在，则操作失败      |              | 0.8.0 ✔      |
| 从某分组中删除关系人         | 将关系人从关系人分组中删除                                   |              | 0.8.0 ✔      |

### 用户其他功能

| **功能** | 实现概要                                                     | **功能描述**                       | **相关配置** | **实现版本** |
| -------- | ------------------------------------------------------------ | ---------------------------------- | ------------ | ------------ |
| 附近的人 | 各Turms服务端基于R*-tree算法（Experimental）管理与自身连接的在线用户的地理坐标 | 根据当前实时坐标搜寻附近的其他用户 |              | 0.8.0 ✔      |

### 群组功能

在群组配置方面，Turms使用的是“群组类型”这一概念。默认情况下，Turms提供了一种通用的群组类型，同时您也可以通过对“群组类型”做增删改查操作，以满足您定制化的群组类型需求。

#### 群组类型配置

| **功能**           | **功能描述**                                                 | **相关配置** | **实现版本** |
| :----------------- | :----------------------------------------------------------- | ------------ | :----------- |
| 群成员上限人数     | 默认情况下，一个群组的上限人数为 500 人（您可随意调节上限人数） |              | 0.8.0 ✔      |
| 邀请入群策略       | 支持配置：①仅群主可邀请；②群主+管理员可邀请；③群主+管理员与群成员可邀请；④所有人可邀请 |              | 0.8.0 ✔      |
| 被邀请人同意模式   | 支持配置：①需要被邀请人同意；②不需要被邀请人同意             |              | 0.8.0 ✔      |
| 入群策略           | 支持配置：①群主与管理员审批入群请求；②入群请求者回答问题正确后加入；③允许任何人加入；④不允许任何人加入 |              | 0.8.0 ✔      |
| 群信息更新策略     | 支持配置：①仅群主可修改；②群主+管理员可修改；③群主+管理员+群成员可修改；④所有人可修改 |              | 0.8.0 ✔      |
| 群成员信息更新策略 | 群主可以修改所有人的在群组内的成员信息，管理员只能修改群组中普通成员的成员信息 |              | 0.8.0 ✔      |
| 群成员修改自身信息 | 可禁止、可允许                                               |              | 0.8.0 ✔      |
| 群消息已读回执     | 可开启、可关闭                                               |              |              |

#### 群组功能

群成员类型包括：群主、管理员、普通成员、游客、匿名游客

| **功能**             | **功能描述**                                                 | **相关配置** | **实现版本**         |
| :------------------- | :----------------------------------------------------------- | ------------ | :------------------- |
| 新建群组             | 新建群组                                                     |              |                      |
| 群主解散群           | 群主可以解散群                                               |              | 0.8.0 ✔              |
| 主动退群             | 除群主外，其他用户均可以主动退群。群主需先将群转让给其他群成员才可以进行退群操作 |              | 0.8.0 ✔              |
| 群主转让群           | 群主可以将群的拥有者权限转给群内的其他成员，转移后， 被转让者变为新的群主，原群主变为普通成员。群主还可以选择在转让的同时，直接退出该群 |              | 0.8.0 ✔              |
| 修改群组资料         | 支持群组名，群组头像，群组介绍，群组通知，群组类型等字段     |              | 0.8.0 ✔              |
| 群组禁言             | 群组普通成员在禁言时段无法发送消息，仅有群主与管理员能发送消息 |              | 0.8.0 ✔              |
| 获取群组信息         | 根据过滤条件（如群组ID），查找群组<br />（补充：由于通过昵称来查找群组功能的高效实现较复杂，因此放到0.9.0版本实现，预计采用AC自动机算法） |              | 0.8.0 ✔<br />0.9.0 ❓ |
| 增加群组成员         | 增加群组成员                                                 |              | 0.8.0 ✔              |
| 发送入群邀请         | 拥有邀请权限角色的群组成员可向指定用户发送入群邀请           |              | 0.8.0 ✔              |
| 撤销入群邀请         | 群主、管理员与入群邀请发起者可撤销入群邀请                   |              | 0.8.0 ✔              |
| 发送入群请求         |                                                              |              | 0.8.0 ✔              |
| 撤销入群请求         |                                                              |              | 0.8.0 ✔              |
| 设置入群问题         | 对于入群策略为“入群请求者回答问题正确后加入”的群组，群主与管理员可以设置入群问题。入群问题可以有多个，一个问题可以多个答案 |              | 0.8.0 ✔<br />0.9.0 ❓ |
| 删除入群问题         | 删除入群问题                                                 |              | 0.8.0 ✔              |
| 移除群组成员         | 群主和管理员可以移除群组成员，且管理员不能移除群主和其他管理员 |              | 0.8.0 ✔              |
| 更新群组成员信息     | 根据对应的“群组类型”，指定角色的群组成员可以修改其他群组成员的成员信息（如：群主为群组成员赋予管理员角色） |              | 0.8.0 ✔              |
| 群组成员禁言         | 禁言用户可以在群组内，但无法发送消息                         |              | 0.8.0 ✔              |
| 群组成员坐标实时共享 | 群组成员可以将自己的坐标实时地分享给其他群组成员             |              | 0.9.0 ❓              |
| 群组黑名单           | 用户被拉黑后，将无法再进入群组。如果被拉黑用户在被拉黑之前是当前群组成员，则在拉黑后该用户会自动在群组成员列表中移除 |              | 0.8.0 ✔              |

## 管理功能列表

此表所述功能主要供：①您的后端程序发出HTTP请求进行调用；②同时作为内容统计管理系统与集群监控管理系统的turms-admin使用。具体API接口文档，请查阅[Turms服务端集成开发文档]()

**注意：**

- **此表所述接口仅供管理员使用，而不应该被用户使用**。因为这些操作不在业务层上做逻辑/用户间权限判断，如场景：假设今天是2018年12月1号，但管理员仍可以修改“消息”的“发送时间”为2020年10月13号
- Turms面向管理员使用的API接口并不是完全按照RESTful风格设计的，Turms的API接口的设计原则是“接口的规范性要以开发者使用便捷为前提”，而不是“为了接口规范，需要开发者进行多余的繁琐操作”

### 管理员权限管理

每个Turms集群默认存在一个userId为“turms”，password为“turms”的超级管理员

| **功能**       | **功能说明**                               | **URL**        | **实现版本** |
| :------------- | :----------------------------------------- | -------------- | ------------ |
| 管理员身份校验 | 告知请求发起者，其发送的管理员信息是否存在 | HEAD /admins   | 0.8.0 ✔      |
| 获取管理员名单 |                                            | GET /admins    | 0.8.0 ✔      |
| 新建管理员     |                                            | POST /admins   | 0.8.0 ✔      |
| 删除管理员     |                                            | DELETE /admins | 0.8.0 ✔      |
| 修改管理员信息 | 包括修改管理员的权限                       | PUT /admins    | 0.8.0 ✔      |

### 消息管理

| **功能**     | **功能说明**                                               | **URL**          | **实现版本** |
| :----------- | :--------------------------------------------------------- | ---------------- | ------------ |
| 获取消息     | 根据自定义的过滤条件，获取消息                             | GET /messages    | 0.8.0 ✔      |
| 消息全文检索 | （Planned）预计基于hanLP与CoreNLP分词实现                  | GET /messages    | 1.x ❓        |
| 发送消息     | 可发送的消息类型同“业务功能列表”中的消息类型               | POST /messages   | 0.9.0 ❓      |
| 删除消息     | 删除消息                                                   | DELETE /messages | 0.8.0 ✔      |
| 修改消息     | 可修改消息的所有字段信息，并在修改消息后可选是否重发此消息 | PUT /messages    | 0.9.0 ❓      |

### 用户管理

| **功能**           | **功能说明**                                                 | **URL**                 | **实现版本** |
| :----------------- | :----------------------------------------------------------- | ----------------------- | ------------ |
| 获取用户信息       | 根据用户ID或分页信息，获取用户的非敏感信息或完整信息。<br />注意：此处获取的用户密码既可以是密文（默认salt+SHA256），也可以是明文。由您配置的参数决定（默认密文） | GET /users              | 0.8.0 ✔      |
| 添加用户账号       | 添加用户账号                                                 | POST /users             | 0.8.0 ✔      |
| 删除用户账号       | 删除用户账号。可指定是否同时删除，用户的联系人列表与被联系人列表 | DELETE /users           | 0.8.0 ✔      |
| 修改用户信息       | 可修改用户所有字段信息。包括禁用/解禁用户                    | PUT /users              | 0.8.0 ✔      |
| 获取用户在线信息   | 获取用户在线信息，包括用户在线状态、用户位置（如果客户端有提供此数据）、用户在线设备类型与用户在线设备登陆时间 | GET /users/statuses     | 0.8.0 ✔      |
| 修改用户在线状态   | 修改用户在线状态，可用于强制用户下线。不可修改下线用户的在线状态 | PUT /users/statuses     | 0.8.0 ✔      |
| 获取用户附近的人   | 根据该用户的最新坐标，获取其附近的其他用户的ID（主要：此服务要求此用户客户端有提供用户坐标数据） | GET /users/users-nearby | 0.8.0 ✔      |
| 获取用户的历史坐标 | 获取用户的所有历史坐标，每个坐标信息由必有的具体坐标、时间戳，以及可能为空的地址与地点名称组成 | GET /users/locations    | 0.8.0 ✔      |

### 用户关系管理

| **功能**           | **描述**                                                     | **URL**                           | **实现版本** |
| :----------------- | :----------------------------------------------------------- | :-------------------------------- | ------------ |
| 获取用户关系人名单 | 根据可选的过滤（如“是否是联系人”、“是否是好友/拉黑用户”等）与分组条件，获取用户的关系人名单 | GET /users/relationships          | 0.8.0 ✔      |
| 移除关系人         | 根据可选的过滤条件（如“是否是联系人”、“是否是好友/拉黑用户”等），移除用户关系人列表中的某类用户或指定用户 | DELETE /users/relationships       | 0.8.0 ✔      |
| 修改关系人信息     | 修改与关系人的关系。如设定“是否是联系人”、转变具体关系为“好友”或“拉黑用户” | PUT /users/relationships          | 0.8.0 ✔      |
| 新建关系人分组     |                                                              | POST /users/relationships-group   | 0.8.0 ✔      |
| 修改关系人分组     |                                                              | PUT /users/relationships-group    | 0.8.0 ✔      |
| 删除关系人分组     |                                                              | DELETE /users/relationships-group | 0.8.0 ✔      |
| 获取关系人所在分组 |                                                              | GET /users/relationships/group    | 0.8.0 ✔      |
| 添加关系人至分组   |                                                              | POST /users/relationships/group   | 0.8.0 ✔      |
| 将关系人移除分组   |                                                              | DELETE /users/relationships/group | 0.8.0 ✔      |

### 群组管理

| **功能**                   | **描述**                                                     | **URL**           | **实现版本** |
| :------------------------- | :----------------------------------------------------------- | :---------------- | ------------ |
| 获取群组信息（可分页）     | 根据过滤条件，获取全部或指定的群组信息                       | GET /groups       | 0.8.0 ✔      |
| 获取一个用户参与的所有群组 | 根据用户 ID 获取此用户加入的全部群组信息                     | GET /users/groups | 0.8.0 ✔      |
| 创建群组                   | 创建新群组                                                   | POST /groups      | 0.8.0 ✔      |
| 修改群组信息               | 修改群组的信息。包括转让群主身份、修改群组类型、修改群组禁言状态等操作 | PUT /groups       | 0.8.0 ✔      |
| 删除群组                   | 根据过滤条件，删除群组                                       | DELETE /groups    | 0.8.0 ✔      |

### 群组成员管理

| **功能**         | **描述**                                                     | **URL**                | **实现版本** |
| :--------------- | :----------------------------------------------------------- | :--------------------- | ------------ |
| 获取群组成员     | 根据过滤条件（如“被禁言用户”、“某身份”），获取一个群组的群成员列表 | GET /groups/members    | 0.8.0 ✔      |
| 添加群组成员     | 添加用户至群组成员列表。可添加指定身份的成员                 | POST /groups/members   | 0.8.0 ✔      |
| 移除群组成员     | 根据过滤条件（如“被禁言用户”、“某身份”），从群组成员列表中移除用户 | DELETE /groups/members | 0.8.0 ✔      |
| 修改群组成员信息 | 根据过滤条件（如“被禁言用户”、“某身份”），修改群组成员信息   | PUT /groups/members    | 0.8.0 ✔      |

提醒：群组的禁言状态是指在某个时间段整个群组成员无法进行发言操作（群创建者Creator这个身份也是无权发言的，只有群所有者Owner与群管理员Managers在群禁言期间能发言）；群组成员的禁言状态是指在某个时间段某个群组成员无法进行发言操作，但其他未被禁言的成员仍可以发言。

### 群组黑名单管理

| **功能**                 | **描述**                     | **URL**                   | **实现版本** |
| ------------------------ | ---------------------------- | ------------------------- | ------------ |
| 查询群组黑名单           | 查看群组的黑名单列表         | GET /groups/blacklists    | 0.8.0 ✔      |
| 添加单个用户至群组黑名单 | 将用户添加至群组的黑名单列表 | POST /groups/blacklists   | 0.8.0 ✔      |
| 批量从群组黑名单移除用户 | 将用户从黑名单列表中移除     | DELETE /groups/blacklists | 0.8.0 ✔      |

### 群组类型管理

| **功能**           | **描述**                                                     | **URL**              | **实现版本** |
| ------------------ | ------------------------------------------------------------ | -------------------- | ------------ |
| 查询已有群组类型   | 查询已有群组类型。默认数据库中包括一个名为“GROUP”类型的群组类型 | GET /groups/types    | 0.8.0 ✔      |
| 增加自定义群组类型 | 新增自定义的群组类型，来对群组做各种各样的定制化配置         | POST /groups/types   | 0.8.0 ✔      |
| 删除群组类型       | 删除群组类型                                                 | DELETE /groups/types | 0.8.0 ✔      |
| 修改群组类型的配置 | 修改已存在群组类型的配置                                     | PUT /groups/types    | 0.8.0 ✔      |

## 集群管理

| **功能**                 | **描述**                                                     | **URL**             | **实现版本** |
| ------------------------ | ------------------------------------------------------------ | ------------------- | ------------ |
| 获取当前集群服务节点信息 |                                                              | GET /cluster        | 0.8.0 ✔      |
| 获取当前配置             | 获取当前集群中服务节点的统一配置。<br />通过/cluster/config?mutable=true可仅获取可动态修改的配置项 | GET /cluster/config | 0.8.0 ✔      |
| 修改配置                 | 动态修改集群节点的配置<br />（长期采用的过渡方案）基于Hazelcast的2PC协议与Hazelcast的ReplicatedMap实现 | PUT /cluster/config | 0.8.0 ✔      |

## RoadMap：

| **功能**             | **实现概要**                                                 | **说明**                                       | **实现版本** |
| :------------------- | ------------------------------------------------------------ | :--------------------------------------------- | :----------- |
| 支持插件             | 用户实现TurmsPlugin抽象类的子类，并生成jar包。Turms读取用户自定义jar包以使自定义插件生效 | 支持插件                                       | 0.9.0 ❓      |
| 服务端用户消息查询   | 基于TurmsClientMessagePlugin类，引入ElasticSearch集群实现    | 开发者通过这套接口来快速查询数据库中的用户消息 | 1.x ❓        |
| 垃圾信息与敏感词过滤 | 预计基于AC自动机算法实现（待定）                             | 垃圾信息与敏感词过滤                           | 1.x ❓        |
| 消息推送             | 特别注意：消息推送的实现关键点在于：在手机端上，用户的手机系统允许您的应用后台运行，否则后台消息推送功能是无法实现的 |                                                | 1.x ❓        |
| 对话机器人           |                                                              | 对话机器人                                     | 1.x ❓        |
| 文件集群管理         | （插件）基于TurmsClientMessagePlugin类，引入seaweedfs（待定）集群实现 | 文件集群管理                                   | 2.x ❓        |
| 音频通话             | 引入SRS集群（待定）实现                                      | 音频通话                                       | 3.x ❓        |
| 视频通话             | 引入SRS集群（待定）实现                                      | 视频通话                                       | 3.x ❓        |
| 语音识别             |                                                              | 语音识别                                       | 4.x ❓        |
| 跨集群通信           |                                                              | 跨集群通信                                     | x.x ❓        |
