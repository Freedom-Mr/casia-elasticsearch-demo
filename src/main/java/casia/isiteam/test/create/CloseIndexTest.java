package casia.isiteam.test.create;

import casia.isiteam.api.elasticsearch.controller.CasiaEsCreate;

/**
 * ClassName: CloseIndexTest
 * Description: 关闭开启索引
 * <p>
 * Created by casia.wzy on 2020/7/8
 * Email: zhiyou_wang@foxmail.com
 */
public class CloseIndexTest {
    public static void main(String[] args) {
        //读取索引地址配置
        CasiaEsCreate casiaEsCreate = new CasiaEsCreate("data");
        casiaEsCreate.setIndexName("demo_test","test_data");

        //停用索引
        boolean rs = casiaEsCreate.closeIndex();
        System.out.println(rs);

        //启用索引
        boolean rs2 = casiaEsCreate.openIndex();
        System.out.println(rs2);
    }
}
