package casia.isiteam.test.create;

import casia.isiteam.api.elasticsearch.controller.CasiaEsCreate;

import java.util.Map;

/**
 * ClassName: ReIndexTest
 * Description: 迁移索引
 * <p>
 * Created by casia.wzy on 2020/7/8
 * Email: zhiyou_wang@foxmail.com
 */
public class ReIndexTest {
    /**
     * 迁移索引
     * @param args
     */
    public static void main(String[] args) {
        //读取索引地址配置
        CasiaEsCreate casiaEsCreate = new CasiaEsCreate("data");

        //把“demo_test”索引数据复制到 “demo_test2” 索引
        Map<String,Object> map = casiaEsCreate.reIndex("demo_test","demo_test2");
        map.forEach((k,v)->{
            System.out.println(k+":"+v);
        });

    }
}
