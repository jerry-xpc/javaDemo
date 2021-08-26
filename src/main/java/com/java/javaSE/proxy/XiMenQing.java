package com.java.javaSE.proxy;

/**
 * 虽然都是通过WangPo在执行，但实际是传入的对象在执行，这就是代理模式
 * WangPo其实就是一个中间人，比如王婆介绍潘金莲与西门庆认识，其实最终做事的就是潘金莲与西门庆
 */
public class XiMenQing {
    public static void main(String[] args) {
        WangPo wangPo = new WangPo();
        wangPo.makeEyesWithMen();
        wangPo.playWithMen();

        WangPo wangPo1 = new WangPo(new JiaShi());
        wangPo1.playWithMen();
        wangPo.makeEyesWithMen();
    }
}
