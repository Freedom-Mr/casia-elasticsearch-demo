package casia.isiteam.test.aggregation;

import casia.isiteam.api.elasticsearch.common.enums.FieldOccurs;
import casia.isiteam.api.elasticsearch.common.enums.QueriesLevel;
import casia.isiteam.api.elasticsearch.common.vo.field.aggs.AggsFieldBuider;
import casia.isiteam.api.elasticsearch.common.vo.field.aggs.DateInfo;
import casia.isiteam.api.elasticsearch.common.vo.field.aggs.MatrixInfo;
import casia.isiteam.api.elasticsearch.common.vo.field.search.KeyWordsBuider;
import casia.isiteam.api.elasticsearch.common.vo.field.search.KeywordsCombine;
import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSearch;
import casia.isiteam.api.elasticsearch.util.OutInfo;

/**
 * ClassName: Matrix_Aggs_Test
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/7/1
 * Email: zhiyou_wang@foxmail.com
 */
public class Matrix_Aggs_Test {

    /**
     * 矩阵统计计算
     * @param args
     */
    public static void main(String[] args) {

        CasiaEsSearch casiaEsSearch = new CasiaEsSearch("web");
        casiaEsSearch.setIndexName("test","test_data");

        SearchResult searchResult = casiaEsSearch
                .setAggregations(
                        new AggsFieldBuider(
                                new MatrixInfo("support_level","id")
                        )
                ).executeAggsInfo();

        //输出
        OutInfo.out(searchResult);
    }

}
