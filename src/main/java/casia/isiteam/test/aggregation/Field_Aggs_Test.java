package casia.isiteam.test.aggregation;

import casia.isiteam.api.elasticsearch.common.enums.SortOrder;
import casia.isiteam.api.elasticsearch.common.vo.field.aggs.AggsFieldBuider;
import casia.isiteam.api.elasticsearch.common.vo.field.aggs.TermInfo;
import casia.isiteam.api.elasticsearch.common.vo.field.aggs.TypeInfo;
import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSearch;
import casia.isiteam.util.ResultPrint;

/**
 * ClassName: Field_Aggs_Test
 * Description: 字段聚合-测试
 * <p>
 * Created by casia.wzy on 2020/5/27
 * Email: zhiyou_wang@foxmail.com
 */
public class Field_Aggs_Test {
    /**
     * 字段聚合-测试
     * @param args
     */
    public static void main(String[] args) {
        CasiaEsSearch casiaEsSearch = new CasiaEsSearch("web");
        casiaEsSearch.setIndexName("test","test_data");

        //单字段聚合：类型
        casiaEsSearch.setAggregations(
                new AggsFieldBuider(new TypeInfo("eid"))
        );

        //单字段聚合：返回前N个
       /* casiaEsSearch.setAggregations(
                new AggsFieldBuider( new TermInfo("eid",2, SortOrder.DESC) )
        );*/

        //子字段聚合：返回前N个，每个详情下再次聚合
        casiaEsSearch.setAggregations(
                new AggsFieldBuider(
                        new TermInfo("eid",2, 0L , SortOrder.DESC ,
                            new AggsFieldBuider( new TypeInfo("site") )
                        )
                )
        );

        SearchResult searchResult = casiaEsSearch.executeAggsInfo();

        //输出
        System.out.println(searchResult.getTotal_Doc());
        System.out.println(searchResult.getScrollId());
        ResultPrint.outAggsInfo(searchResult.getAggsInfos(),0);
    }
}
