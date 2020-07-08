package casia.isiteam.test.create;

import casia.isiteam.api.elasticsearch.controller.CasiaEsCreate;
import casia.isiteam.api.toolutil.file.CasiaFileUtil;

import java.util.Arrays;

/**
 * ClassName: CreateIndexTest
 * Description: 创建索引
 * <p>
 * Created by casia.wzy on 2020/5/15
 * Email: zhiyou_wang@foxmail.com
 */
public class CreateIndexTest {
    /**
     * 创建索引
     * @param args
     */
    public static void main(String[] args) {
        //读取mapping信息
        String mapping = CasiaFileUtil.readAllBytes("mapping/test_mapping.txt");

        //读取索引地址配置
        CasiaEsCreate casiaEsCreate = new CasiaEsCreate("data");
        //或者直接传参初始化索引地址
//        CasiaEsCreate casiaEsCreate = new CasiaEsCreate(Arrays.asList("106.75.137.175:61231"),"username","password");

        //创建索引
        boolean result = casiaEsCreate.createIndex("demo_test", mapping);
        System.out.println(result);
    }
}
