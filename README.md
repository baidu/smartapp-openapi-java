## 说明
百度智能小程序第三方平台服务端 SDK 旨在降低第三方平台开发成本，提升第三方平台的接入效率。
使用小程序第三方平台服务端 SDK 前，首先需要在 [百度智能小程序第三方平台](https://smartprogram.baidu.com/developer/tpindex.html) 注册成为百度智能小程序第三方平台合作方。
该 SDK 可能存在一些我们未预料到的问题，欢迎开发者通过以下方式进行使用咨询和反馈：
- 社区发帖

  前往[发帖 - 智能小程序开发者社区](https://smartprogram.baidu.com/forum/topic/add)发帖并填写咨询反馈内容。

- 如流群（社区沟通及时性可能比较差，因此我们推荐开发者通过如流群和我们进行沟通）
   1. 前往[如流](http://infoflow.baidu.com/mainpage/#/)或者在各大应用市场搜索如流并下载如流
   2. 搜索群号：**5702992**（百度智能小程序 OpenAPI SDK 咨询反馈群）申请加入该群
   3. 反馈问题。我们建议问题详情尽量详细，或者和社区发帖内容类似，这样方便我们尽快解决问题

## 支持语言
|  语言  | 支持状态 |         使用说明         |
|:----:|:----:|:--------------------:|
| Java | 已支持  | 参考对应接口文档中的`Java`代码示例 |
|  C#  |      |         待上线          |
| PHP  |      |         待上线          |
|  GO  |      |         待上线          |

## 支持模块
|                                              模块                                              | Java | C#  | PHP | GO  |
|:--------------------------------------------------------------------------------------------:|:----:|:---:|:---:|:---:|
|             [授权流程](https://smartprogram.baidu.com/docs/third/auth/auth_process/)             |  ✅   |     |     |     |
|         [真实性认证](https://smartprogram.baidu.com/docs/third/advanced_auth/reference/)          |  ✅   |     |     |     |
|       [模板管理](https://smartprogram.baidu.com/docs/third/template/gettemplatedraftlist/)       |  ✅   |     |     |     |
|              [小程序包管理](https://smartprogram.baidu.com/docs/third/package/intro/)              |  ✅   |     |     |     |
| [基本信息设置](https://smartprogram.baidu.com/docs/third/info/modify_app_name_with_qualification/) |  ✅   |     |     |     |
|            [违规下线](https://smartprogram.baidu.com/docs/third/offline/updateinfo/)             |  ✅   |     |     |     |
|     [模板/订阅消息](https://smartprogram.baidu.com/docs/third/message_template/template_list/)     |  ✅   |     |     |     |
|               [图片上传](https://smartprogram.baidu.com/docs/third/image/upload/)                |  ✅   |     |     |     |
|               [小程序登录](https://smartprogram.baidu.com/docs/third/login/oauth/)                |  ✅   |     |     |     |
|        [性能优化](https://smartprogram.baidu.com/docs/third/optimization/prelink_submit/)        |  ✅   |     |     |     |
|            [获取手机号](https://smartprogram.baidu.com/docs/third/phone/apply_phone/)             |  ✅   |     |     |     |
|                 [支付服务](https://smartprogram.baidu.com/docs/third/pay/dict/)                  |  ✅   |     |     |     |
|              [订单同步](https://smartprogram.baidu.com/docs/third/order/add_order/)              |  ✅   |     |     |     |
|        [数据统计分析](https://smartprogram.baidu.com/docs/third/data/getanalysisusertrend/)        |  ✅   |     |     |     |
|             [客服消息](https://smartprogram.baidu.com/docs/third/customer/sendmsg/)              |  ✅   |     |     |     |
|           [设置第三方域名](https://smartprogram.baidu.com/docs/third/domain/set_server/)            |  ✅   |     |     |     |
|                [自然搜索](https://smartprogram.baidu.com/docs/third/search/web/)                 |  ✅   |     |     |     |
|            [信息流](https://smartprogram.baidu.com/docs/third/feed/submit_materiel/)            |  ✅   |     |     |     |
|            [消息推送](https://smartprogram.baidu.com/docs/third/push/push_reference/)            |  ✅   |     |     |     |
|             [小程序等级](https://smartprogram.baidu.com/docs/third/app_grade/grade/)              |  ✅   |     |     |     |


## 安装与使用
### Java
#### Maven
在项目的pom.xml的dependencies中加入以下内容:

```xml
<dependency>
    <groupId>com.baidu.mapp</groupId>
    <artifactId>smartapp-api-sdk</artifactId>
    <version>1.1.0-SNAPSHOT</version>
</dependency>
```

#### Gradle
```
implementation 'com.baidu.mapp:smartapp-api-sdk:1.1.0-SNAPSHOT'
```

#### 下载jar

点击以下链接，下载`smartapp-api-sdk:-X.X.X.jar`即可：

- [Maven中央库](https://oss.sonatype.org/content/repositories/snapshots/com/baidu/mapp/smartapp-api-sdk/1.1.0-SNAPSHOT/)

> 🔔️注意
>1.x支持JDK8+，对Android平台没有测试。
