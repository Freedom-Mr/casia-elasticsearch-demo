package casia.isiteam.test.aggregation;

import casia.isiteam.api.elasticsearch.common.enums.FieldOccurs;
import casia.isiteam.api.elasticsearch.common.enums.GeoLevel;
import casia.isiteam.api.elasticsearch.common.enums.QueriesLevel;
import casia.isiteam.api.elasticsearch.common.vo.field.aggs.AggsFieldBuider;
import casia.isiteam.api.elasticsearch.common.vo.field.aggs.GeoInfo;
import casia.isiteam.api.elasticsearch.common.vo.field.search.KeyWordsBuider;
import casia.isiteam.api.elasticsearch.common.vo.field.search.KeywordsCombine;
import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSearch;
import casia.isiteam.api.elasticsearch.util.OutInfo;

/**
 * ClassName: Geo_Aggs_Test
 * Description: 地理空间
 * <p>
 * Created by casia.wzy on 2020/5/27
 * Email: zhiyou_wang@foxmail.com
 */
public class Geo_Aggs_Test {
    /**
     * 经纬度
     * @param args
     */
    public static void main(String[] args) {
        CasiaEsSearch casiaEsSearch = new CasiaEsSearch("web");
        casiaEsSearch.setIndexName("test","test_data");

        casiaEsSearch
                .setQueryKeyWords(
                        new KeywordsCombine(1,
                                new KeyWordsBuider("domain","yahoo.com", FieldOccurs.INCLUDES, QueriesLevel.Term)
                        )
                )
                .setAggregations(
                        new AggsFieldBuider(
                                //设置
                                new GeoInfo(GeoLevel.Bounds,"lal")
                        ),
                        new AggsFieldBuider(
                                new GeoInfo(GeoLevel.Centroid,"lal")
                        )
                );


        SearchResult searchResult = casiaEsSearch.executeAggsInfo();

        //输出
        OutInfo.out(searchResult);
    }
}
