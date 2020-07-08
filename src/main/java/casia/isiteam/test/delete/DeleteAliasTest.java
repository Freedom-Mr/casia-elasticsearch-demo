package casia.isiteam.test.delete;

import casia.isiteam.api.elasticsearch.controller.CasiaEsDelete;

/**
 * ClassName: DeleteAliasTest
 * Description: 删除别名
 * <p>
 * Created by casia.wzy on 2020/7/8
 * Email: zhiyou_wang@foxmail.com
 */
public class DeleteAliasTest {
    //删除别名
    public static void main(String[] args) {
        CasiaEsDelete casiaEsDelete = new CasiaEsDelete("data");
        casiaEsDelete.setIndexName("demo_test");

        //删除别名
        Boolean rs= casiaEsDelete.deleteIndexAlias("a1");
        System.out.println(rs);
    }
}
