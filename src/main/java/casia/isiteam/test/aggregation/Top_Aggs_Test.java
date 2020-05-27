package casia.isiteam.test.aggregation;

import casia.isiteam.api.elasticsearch.common.enums.FieldOccurs;
import casia.isiteam.api.elasticsearch.common.vo.field.aggs.AggsFieldBuider;
import casia.isiteam.api.elasticsearch.common.vo.field.aggs.TopData;
import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSearch;
import casia.isiteam.util.ResultPrint;

/**
 * ClassName: Top_Aggs_Test
 * Description: 聚合返回TOP文档
 * <p>
 * Created by casia.wzy on 2020/5/27
 * Email: zhiyou_wang@foxmail.com
 */
public class Top_Aggs_Test {
    /**
     * 聚合返回TOP文档
     * @param args
     */
    public static void main(String[] args) {

        CasiaEsSearch casiaEsSearch = new CasiaEsSearch("web");
        casiaEsSearch.setIndexName("test","test_data");
        SearchResult searchResult = casiaEsSearch
                .setAggregations(
                        new AggsFieldBuider(
                                new TopData(2).setReturnField(FieldOccurs.INCLUDES,"eid","site")
                        )
                ).executeAggsInfo();

        //输出
        System.out.println(searchResult.getTotal_Doc());
        System.out.println(searchResult.getScrollId());
        ResultPrint.outAggsInfo(searchResult.getAggsInfos(),0);
    }
}
