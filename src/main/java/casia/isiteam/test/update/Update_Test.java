package casia.isiteam.test.update;

import casia.isiteam.api.elasticsearch.controller.CasiaEsUpate;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Update_Test
 * Description: 修改文档内容
 * <p>
 * Created by casia.wzy on 2020/5/27
 * Email: zhiyou_wang@foxmail.com
 */
public class Update_Test {
    /**
     * 修改文档内容
     * @param args
     */
    public static void main(String[] args) {

        CasiaEsUpate casiaEsUpate = new CasiaEsUpate("data");
        casiaEsUpate.setIndexName("test","test_data");

        Map< String, Object> map = new HashMap<>();
        map.put("lal", "61.12,61.01");

        boolean rs = casiaEsUpate .updateParameterById("1",map);
    }
}
