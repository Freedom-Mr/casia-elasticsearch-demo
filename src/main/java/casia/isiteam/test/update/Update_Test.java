package casia.isiteam.test.update;

import casia.isiteam.api.elasticsearch.common.enums.FieldOccurs;
import casia.isiteam.api.elasticsearch.common.enums.QueriesLevel;
import casia.isiteam.api.elasticsearch.common.vo.field.search.KeyWordsBuider;
import casia.isiteam.api.elasticsearch.common.vo.field.search.KeywordsCombine;
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
     * 根据文档ID修改字段内容
     * @param args
     */
    public static void main(String[] args) {

        CasiaEsUpate casiaEsUpate = new CasiaEsUpate("data");
        casiaEsUpate.setIndexName("test","test_data");

        Map< String, Object> map = new HashMap<>();
        map.put("lal", "61.12,61.01");

        boolean rs = casiaEsUpate .updateParameterById("1",map);
    }
    /**
     * 根据检索条件，批量修改字段内容
     * @param args
     */
    /*public static void main(String[] args) {
        CasiaEsUpate casiaEsQuery = new CasiaEsUpate("data");
        casiaEsQuery.setIndexName("demo_test","test_data");
        casiaEsQuery.setQueryKeyWords(
                new KeywordsCombine( 1,
                        new KeyWordsBuider("id","32669280", FieldOccurs.INCLUDES, QueriesLevel.Term)
                )
        );
        casiaEsQuery.setExistsFilter("title");

        Map<String,Object> rs = casiaEsQuery.updateParameterByQuery("eid",14);
        rs.forEach((k,v)->{
            System.out.println(k+"\t"+v);
        });
    }*/
}
