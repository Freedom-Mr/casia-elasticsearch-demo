package casia.isiteam.test.aggregation;

import casia.isiteam.api.elasticsearch.common.vo.field.aggs.AggsFieldBuider;
import casia.isiteam.api.elasticsearch.common.vo.field.aggs.PriceInfo;
import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSearch;
import casia.isiteam.api.elasticsearch.util.OutInfo;

/**
 * ClassName: Price_Aggs_Test
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/6/24
 * Email: zhiyou_wang@foxmail.com
 */
public class Price_Aggs_Test {
    /**
     * 区间范围文档数
     * @param args
     */
    public static void main(String[] args) {
        CasiaEsSearch casiaEsSearch = new CasiaEsSearch("web");
        casiaEsSearch.setIndexName("test","test_data");

        casiaEsSearch
                .setAggregations(
                        new AggsFieldBuider(
                                new PriceInfo("eid","*-50","50-70","100-*")
                        )
                );


        SearchResult searchResult = casiaEsSearch.executeAggsInfo();

        //输出
        OutInfo.out(searchResult);
    }
}
