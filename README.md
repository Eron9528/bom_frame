# bom_frame
####基于微服务的网上商城

1. bom-eureka-server  服务注册

2. bom-mail   邮件服务

3. bom-message   消息服务

4. bom-order   订单服务

5. bom-pay   支付服务

6. bom-search   搜索服务

7. bom-user-centre   用户中心

#### 20-12-28
* 增加订单表、订单状态表
* 订单表基础增删改查 service 

#### 20-12-29
* 增加 bom-gateway 网关
* 解决mysql 的问题，导入不到dependencies.直接引入带版本号的
* gradle 排除依赖，通过configration的成功，另一种没有成功
* 增加 bom-pay 服务中的数据库表设计




