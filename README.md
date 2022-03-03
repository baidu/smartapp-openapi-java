## 说明
百度智能小程序服务端 OpenAPI SDK 旨在降低开发者开发成本，提升开发智能小程序的开发体验。
* 使用 OpenAPI SDK 服务端模块前，首先需要在 [百度智能小程序平台](https://smartprogram.baidu.com/developer/index.html) 注册成为百度智能小程序开发者以便获取 AppKey
和 AppSecret。
* 使用 SDK 第三方平台模块前，首先需要在 [百度智能小程序第三方平台](https://smartprogram.baidu.com/developer/tpindex.html) 注册成为百度智能小程序第三方平台合作方。


该 SDK 可能存在一些我们未预料到的问题，欢迎开发者通过以下方式进行使用咨询和反馈：
- 社区发帖

  前往[发帖 - 智能小程序开发者社区](https://smartprogram.baidu.com/forum/topic/add)发帖并填写咨询反馈内容。

- 如流群（社区沟通及时性可能比较差，因此我们推荐开发者通过如流群和我们进行沟通）
   1. 前往[如流](http://infoflow.baidu.com/mainpage/#/)或者在各大应用市场搜索如流并下载如流
   2. 搜索群号：**5702992**（百度智能小程序 OpenAPI SDK 咨询反馈群）申请加入该群
   3. 反馈问题。我们建议问题详情尽量详细，或者和社区发帖内容类似，这样方便我们尽快解决问题


## 安装与使用

### Maven
在项目的pom.xml的dependencies中加入以下内容:

```xml
<dependency>
    <groupId>com.baidu.mapp</groupId>
    <artifactId>smartapp-api-sdk</artifactId>
    <version>1.1.0-SNAPSHOT</version>
</dependency>
```

### Gradle
```
implementation 'com.baidu.mapp:smartapp-api-sdk:1.1.0-SNAPSHOT'
```

### 下载jar

点击以下链接，下载`smartapp-api-sdk:-X.X.X.jar`即可：

- [Maven中央库](https://oss.sonatype.org/content/repositories/snapshots/com/baidu/mapp/smartapp-api-sdk/1.1.0-SNAPSHOT/)

> 🔔️注意
>1.x支持JDK8+，对Android平台没有测试。

### 服务端 OpenAPI SDK 使用示例

```java
// 本示例基于百度智能小程序服务端开发者 OpenAPI-SDK-Java
// 使用该示例需要首先下载该 SDK，使用引导见：https://smartprogram.baidu.com/docs/develop/serverapi/introduction_for_openapi_sdk/
package com.baidu.mapp.developer.login;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.developer.bean.login.UnionId;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppGetUnionIdDemo {
  public static void main(String[] args) {
    SmartAppClient smartAppClient = new SmartAppClient();
    // 开发者在此设置请求参数，实际参数请参考文档说明填写
    // 如果开发者不想传非必需参数，可以将设置该参数的行注释
    String accessToken = "24.3b9506c35ba3a2c995d2adc7f3954fdb.2592000.1642731700.282335-24976143";
    String openId = "k04HERDeW-PAGpFWF611R6Vg";
    try {
      UnionId unionId = smartAppClient.getLoginService().getUnionId(accessToken, openId);
      System.out.println(unionId.getUnionid());
    } catch (SmartAppErrorException | OpenAPIErrorException e) {
      e.printStackTrace();
    }
  }
}
```

### 第三方平台 SDK 使用示例

```java
// 本示例基于百度智能小程序第三方平台开发者 ThirdPartyAPI-SDK-Java
// 使用该示例需要首先下载该 SDK，使用引导见：https://smartprogram.baidu.com/docs/third/introduction_for_thirdparty_sdk/
package com.baidu.mapp.tp.demo.login;

import com.baidu.mapp.tp.SmartAppThirdPartyClient;
import com.baidu.mapp.tp.bean.login.UnionId;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppGetUnionIdDemo {
  public static void main(String[] args) {
    SmartAppThirdPartyClient smartAppThirdPartyClient = new SmartAppThirdPartyClient();
    // 开发者在此设置请求参数，实际参数请参考文档说明填写
    // 如果开发者不想传非必需参数，可以将设置该参数的行注释
    String accessToken = "xxx";
    String openId = "xxx";
    try {
      UnionId unionId = smartAppThirdPartyClient.getAppLoginService().getUnionId(accessToken, openId);
    } catch (SmartAppErrorException | OpenAPIErrorException e) {
      e.printStackTrace();
    }
  }
}
```
