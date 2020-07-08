package casia.isiteam.test.delete;

import casia.isiteam.api.elasticsearch.common.enums.FieldOccurs;
import casia.isiteam.api.elasticsearch.common.enums.QueriesLevel;
import casia.isiteam.api.elasticsearch.common.vo.field.RangeField;
import casia.isiteam.api.elasticsearch.common.vo.field.search.KeyWordsBuider;
import casia.isiteam.api.elasticsearch.common.vo.field.search.KeywordsCombine;
import casia.isiteam.api.elasticsearch.controller.CasiaEsDelete;
import casia.isiteam.api.elasticsearch.controller.api.CasiaEsApi;

/**
 * ClassName: DeleteDataByQueryTest
 * Description: 通过检索条件删除数据
 * <p>
 * Created by casia.wzy on 2020/7/8
 * Email: zhiyou_wang@foxmail.com
 */
public class DeleteDataByQueryTest {
    /**
     * 通过检索条件删除数据
     * @param args
     */
    public static void main(String[] args) {

        CasiaEsApi casiaEsApi = new CasiaEsApi("data");
        casiaEsApi.delete().setIndexName("demo_test","test_data");

        //设置条件
        casiaEsApi.delete().setRange(
                new RangeField(FieldOccurs.INCLUDES,"pubtime","2020-05-09 07:36:00",null)
        );
        casiaEsApi.delete().setQueryKeyWords(
                new KeywordsCombine(2,
                        new KeyWordsBuider("title","肺炎", FieldOccurs.INCLUDES, QueriesLevel.Term),
                        new KeyWordsBuider("title","病毒",FieldOccurs.INCLUDES, QueriesLevel.Term))
        );

        //开始删除
        int deleteTotal= casiaEsApi.delete().deleteDataByQuery();
        System.out.println(deleteTotal);
    }
}
