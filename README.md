# iotx-gateway
gateway 智能网关一体机（智能网关+通讯管理机）

项目愿景：
1. 通讯管理机：
   2. 物理接口管理：RS485（常用于 modbus tcp），RJ45接口(以太网接口（Ethernet，狭义来说就是RJ45）（常用于104协议，can卡通过转换器也用这个物理口）)，无线wifi，无线SPI接口（Serial Peripheral Interface）（lora），无线蓝牙，
    无线UART接口（Universal Asynchronous Receiver/Transmitter）（zigbee）
   3. 支持mudbus（使用j2mod插件）：modbus tcp接入、modbus rtu接入、modbus tcp透传、modbus rtu透传
      4. 轮询读取
      5. 轮询写入
   3. 支持其他通讯：电力104协议
   4. 通讯协议插件管理：常用为modbus、104，其他基本都可以，但是需要自己实现插件
2. 智能网关：
   3. 使用sqllite3数据库存储网关配置和历史数据
   3. 云平台配置管理：：选择协议 mqtt(http)，netty(tcp) 104 协议
   4. 支持云端对网关历史数据召唤
   4. 支持云端对网关配置的修改：包括设备/测点管理，场景管理，版本管理，ssh调试，常量管理
   5. 设备/测点管理：管理通讯协议下的设备/测点，并支持实时值查看和命令下发
   6. 场景管理：使用js和python方式定制控制本地设备中测点的执行
      7. 充放电策略场景：设备，设备测点，时间，功率，SOC限制值
      8. 其他场景：
   7. 版本管理
   8. ssh调试：如果是内网，可以直接通过内网ip进行ssh调试，但是如果是外网，需要把内网ip映射到外网ip，然后通过外网ip进行ssh调试
   9. 常量管理：
   10. 

项目实际：
1. 通讯管理机
   2. 支持modbus-只和本电脑的模拟 modbus 软件进行沟通  2025/03/29
      3. 轮询读取 待定
      4. 轮询写入 待定
3. 智能网关
   4. 云平台配置管理：选择协议 mqtt 待定