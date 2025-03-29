package com.example.iotxgateway.service;

import com.ghgande.j2mod.modbus.facade.ModbusTCPMaster;
import com.ghgande.j2mod.modbus.util.BitVector;


public class ModbusTCPExample {


//    private static final ModbusLogger logger = ModbusLogger.getLogger(Test.class);

    public static void main(String[] args) {

        // 官网基础示例
        ModbusTCPMaster master = null;
        try {
            master = new ModbusTCPMaster("127.0.0.1");
            master.connect();
            System.out.printf("读取 coil 1 status [127.0.0.1:502] - %b", master.readCoils(0, 1).getBit(0));


//            // 读取保持寄存器的值
//            int startAddress = 0; // 保持寄存器的起始地址
//            int numRegisters = 5; // 要读取的保持寄存器的数量
//            Register[] registers = master.readMultipleRegisters(startAddress, numRegisters);
//
//            // 处理读取到的数据
//            for (int i = 0; i < numRegisters; i++) {
//                int value = registers[i].getValue();
//                System.out.printf("保持寄存器 %d 的值为 %d%n", startAddress + i, value);
//            }

//            读取多个线圈寄存器的值
            int startAddress = 0; // 起始地址
            int numRegisters = 8; // 要读取的数量/位置
            BitVector registers = master.readCoils(startAddress, numRegisters);

            // 处理读取到的数据
            for (int i = 0; i < numRegisters; i++) {
                int value = (registers.getBit(i) == true? 1 : 0);
                System.out.printf("线圈寄存器 %d 的值为 %s%n", startAddress + i, value);
            }

        } catch (Exception e) {
            System.out.printf("无法Cannot initialise tests - %s", e.getMessage());
        } finally {
            if (master != null) {
                System.out.printf("关闭");
                master.disconnect();
            }
        }

        // TODO:后续有时间增加轮询读取和轮询写入功能




//        try {
//            // 设置Modbus通信参数
//            ModbusCoupler.getReference().setPort(502);
//            ModbusCoupler.getReference().setHost("localhost");
//            ModbusCoupler.getReference().setUnitId(1);
//            ModbusCoupler.getReference().setTransport(Modbus.TRANSPORT_TCP);
//
//            // 创建Modbus主站
//            ModbusTCPMaster master = new ModbusTCPMaster(ModbusCoupler.getReference());
//
//            // 连接Modbus从站设备
//            master.connect();
//
//            // 读取保持寄存器的值
//            int startAddress = 0; // 保持寄存器的起始地址
//            int numRegisters = 5; // 要读取的保持寄存器的数量
//            int[] registers = master.readMultipleRegisters(startAddress, numRegisters);
//
//            // 处理读取到的数据
//            for (int i = 0; i < numRegisters; i++) {
//                int value = registers[i];
//                System.out.printf("保持寄存器 %d 的值为 %d%n", startAddress + i, value);
//            }
//
//            // 断开Modbus连接
//            master.disconnect();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }


}
