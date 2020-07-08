package casia.isiteam.test.create;

import casia.isiteam.api.elasticsearch.controller.CasiaEsCreate;

/**
 * ClassName: AddAliasTest
 * Description: 添加别名
 * <p>
 * Created by casia.wzy on 2020/7/8
 * Email: zhiyou_wang@foxmail.com
 */
public class AddAliasTest {
    /**
     * 新增别名
     * @param args
     */
    public static void main(String[] args) {
        //读取索引地址配置
        CasiaEsCreate casiaEsCreate = new CasiaEsCreate("data");
        casiaEsCreate.setIndexName("demo_test");

        //在索引 “demo_test” 上新建别名 “a1”
        boolean rs = casiaEsCreate.createIndexAlias("a1");
        System.out.println(rs);
    }

}
