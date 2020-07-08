package casia.isiteam.test.delete;

import casia.isiteam.api.elasticsearch.controller.CasiaEsDelete;

/**
 * ClassName: ClaerCacheTest
 * Description: 清空缓存
 * <p>
 * Created by casia.wzy on 2020/7/8
 * Email: zhiyou_wang@foxmail.com
 */
public class ClaerCacheTest {
    /**
     * 清空缓存
     * @param args
     */
    public static void main(String[] args) {
        CasiaEsDelete casiaEsDelete = new CasiaEsDelete("data");
        casiaEsDelete.setIndexName("demo_test","test_data");

        System.out.println(casiaEsDelete.clearCache());

    }
}
