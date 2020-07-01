package casia.isiteam.test.aggregation;

import casia.isiteam.api.elasticsearch.common.enums.FieldOccurs;
import casia.isiteam.api.elasticsearch.common.enums.QueriesLevel;
import casia.isiteam.api.elasticsearch.common.vo.field.aggs.AggsFieldBuider;
import casia.isiteam.api.elasticsearch.common.vo.field.aggs.DateInfo;
import casia.isiteam.api.elasticsearch.common.vo.field.aggs.TopData;
import casia.isiteam.api.elasticsearch.common.vo.field.search.KeyWordsBuider;
import casia.isiteam.api.elasticsearch.common.vo.field.search.KeywordsCombine;
import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSearch;
import casia.isiteam.api.elasticsearch.util.OutInfo;

/**
 * ClassName: Keyword_Aggs_Test
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/6/30
 * Email: zhiyou_wang@foxmail.com
 */
public class Keyword_Aggs_Test {
    /**
     * 关键词检索统计文档
     * @param args
     */
    public static void main(String[] args) {

        CasiaEsSearch casiaEsSearch = new CasiaEsSearch("web");
        casiaEsSearch.setIndexName("test","test_data");

        /**** KeyWords ***/
        SearchResult searchResult = casiaEsSearch
                .setAggregations(
                        new AggsFieldBuider(
                                new KeywordsCombine(2,
                                        new KeyWordsBuider("domain","ifeng.com",FieldOccurs.INCLUDES, QueriesLevel.Term),
                                        new KeyWordsBuider().setKeywordsCombines(
                                                new KeywordsCombine(1,
                                                        new KeyWordsBuider("domain","hkbtv.cn",FieldOccurs.INCLUDES, QueriesLevel.Term),
                                                        new KeyWordsBuider("domain","tt.cn",FieldOccurs.INCLUDES, QueriesLevel.Term)
                                                )
                                        )
                                ),
                                new KeywordsCombine(1,
                                        new KeyWordsBuider("domain","hkbtv.cn",FieldOccurs.INCLUDES, QueriesLevel.Term),
                                        new KeyWordsBuider("domain","epochtimes.com",FieldOccurs.INCLUDES, QueriesLevel.Term)
                                ).setAggsFieldBuider(
                                        new AggsFieldBuider(
                                                new DateInfo("pubtime","yyyy-MM","1M",1L).setAlias("pub")
                                        )
                                )
                        )
                ).executeAggsInfo();

        //输出
        OutInfo.out(searchResult);
    }
}
