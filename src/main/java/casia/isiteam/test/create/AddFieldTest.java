package casia.isiteam.test.create;

import casia.isiteam.api.elasticsearch.controller.CasiaEsCreate;
import casia.isiteam.api.toolutil.file.CasiaFileUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: AddFiledTest
 * Description: 新增字段
 * <p>
 * Created by casia.wzy on 2020/7/8
 * Email: zhiyou_wang@foxmail.com
 */
public class AddFieldTest {
    /**
     * 新增字段
     * @param args
     */
    public static void main(String[] args) {

        //读取索引地址配置
        CasiaEsCreate casiaEsCreate = new CasiaEsCreate("data");
        //设置索引名称及其类型
        casiaEsCreate.setIndexName("demo_test","test_data");

        //创建新字段对象
        Map<String, String> map = new HashMap<>();
        map.put("type", "keyword");
//      map.put("analyzer", "standard");
        map.put("index", "not_analyzed");
//      map.put("format", "yyyy-MM-dd HH:mm:ss");
        map.put("store", "true");

        //执行创建"topic"字段
        boolean rs = casiaEsCreate.insertField("topic",map);
    }
}
