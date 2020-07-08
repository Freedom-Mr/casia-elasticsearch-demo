package casia.isiteam.test.create;

import casia.isiteam.api.elasticsearch.controller.CasiaEsCreate;

/**
 * ClassName: FlushIndexTest
 * Description: 刷新索引
 * <p>
 * Created by casia.wzy on 2020/7/8
 * Email: zhiyou_wang@foxmail.com
 */
public class FlushIndexTest {
    /**
     * 刷新索引
     * @param args
     */
    public static void main(String[] args) {

        //读取索引地址配置
        CasiaEsCreate casiaEsCreate = new CasiaEsCreate("data");
        casiaEsCreate.setIndexName("demo_test","test_data");

        boolean rs = casiaEsCreate.flushIndex();
        System.out.println(rs);

        boolean rs2 = casiaEsCreate.refreshIndex();
        System.out.println(rs2);
    }
}
