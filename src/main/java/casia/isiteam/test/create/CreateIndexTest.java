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
    public static void main(String[] args) {
        //读取mapping信息
        String mapping = CasiaFileUtil.readAllBytes("mapping/test_mapping.txt");

        //读取索引地址配置
        CasiaEsCreate casiaEsCreate = new CasiaEsCreate("data");
        //或者直接传参初始化索引地址
//        CasiaEsCreate casiaEsCreate = new CasiaEsCreate(Arrays.asList("192.168.5.103:9200","192.168.5.104:9200"),"username","password");

        //创建索引
        boolean result = casiaEsCreate.createIndex("test2", mapping);
        System.out.println(result);
    }
}
