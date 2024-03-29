package casia.isiteam.test.aggregation;

import casia.isiteam.api.elasticsearch.common.vo.field.aggs.AggsFieldBuider;
import casia.isiteam.api.elasticsearch.common.vo.field.aggs.GridInfo;
import casia.isiteam.api.elasticsearch.common.vo.field.aggs.IpRangeInfo;
import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSearch;
import casia.isiteam.api.elasticsearch.util.OutInfo;

/**
 * ClassName: Grid_Aggs_Test
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/6/25
 * Email: zhiyou_wang@foxmail.com
 */
public class Grid_Aggs_Test {
    /**
     * IP范围文档数
     * @param args
     */
    public static void main(String[] args) {
        CasiaEsSearch casiaEsSearch = new CasiaEsSearch("web");
        casiaEsSearch.setIndexName("test","test_data");

        casiaEsSearch
                .setAggregations(
                        new AggsFieldBuider(
                                new GridInfo("lal",3)
                        )
                );


        SearchResult searchResult = casiaEsSearch.executeAggsInfo();

        //输出
        OutInfo.out(searchResult);
    }
}
