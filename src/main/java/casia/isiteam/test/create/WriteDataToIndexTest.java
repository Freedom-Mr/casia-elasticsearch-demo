package casia.isiteam.test.create;

import casia.isiteam.api.elasticsearch.controller.CasiaEsCreate;
import casia.isiteam.api.toolutil.file.CasiaFileUtil;
import com.alibaba.fastjson.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: WriteDataToIndexTest
 * Description: 写入数据到test2索引
 * <p>
 * Created by casia.wzy on 2020/5/15
 * Email: zhiyou_wang@foxmail.com
 */
public class WriteDataToIndexTest {
    public static void main(String[] args) {

        //读取数据列表
        List<String> list = CasiaFileUtil.readAllLines("datas/test_data_list.d", StandardCharsets.UTF_8);
        //转换数据格式
        List<JSONObject> datas = list.stream().map(x -> JSONObject.parseObject(x)).collect( Collectors.toList());

        //读取索引地址配置
        CasiaEsCreate casiaEsCreate = new CasiaEsCreate("data");
        //设置索引名称及其索引类型
        casiaEsCreate.setIndexName("demo_test","test_data");
        //设置 数据列表、主键，写入到索引
        boolean result = casiaEsCreate.writeData(datas,"id");
        System.out.println(result);
    }
}
