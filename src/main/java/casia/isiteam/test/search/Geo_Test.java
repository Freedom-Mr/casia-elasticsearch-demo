package casia.isiteam.test.search;

import casia.isiteam.api.elasticsearch.common.enums.FieldOccurs;
import casia.isiteam.api.elasticsearch.common.enums.GeoQueryLevel;
import casia.isiteam.api.elasticsearch.common.enums.QueriesLevel;
import casia.isiteam.api.elasticsearch.common.vo.field.search.KeyWordsBuider;
import casia.isiteam.api.elasticsearch.common.vo.field.search.KeywordsCombine;
import casia.isiteam.api.elasticsearch.common.vo.field.search.geo.GeoQueryInfo;
import casia.isiteam.api.elasticsearch.common.vo.field.search.geo.LonLat;
import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSearch;
import casia.isiteam.api.elasticsearch.util.OutInfo;

/**
 * ClassName: Geo_Test
 * Description: 经纬度-测试
 * <p>
 * Created by casia.wzy on 2020/5/27
 * Email: zhiyou_wang@foxmail.com
 */
public class Geo_Test {
    /**
     * 经纬度-测试
     * @param args
     */
    public static void main(String[] args) {
        CasiaEsSearch casiaEsSearch = new CasiaEsSearch("web");
        casiaEsSearch.setIndexName("test","test_data");

        casiaEsSearch.setQueryKeyWords(
                new KeywordsCombine( 4,
                        new KeyWordsBuider("title","肺炎", FieldOccurs.INCLUDES, QueriesLevel.Term),
                        //经纬度-重心扩展圆形区域
                        new KeyWordsBuider("lal",new GeoQueryInfo().addDistance(new LonLat(118.328635F,35.066628F),"1000km"),FieldOccurs.INCLUDES, GeoQueryLevel.Distance),

                        //经纬度-矩形区域
                        new KeyWordsBuider("lal",new GeoQueryInfo().addBox(new LonLat(114.967240F,36.8180F),new LonLat(122.486572F,32.40779F)),FieldOccurs.INCLUDES, GeoQueryLevel.Box),

                        //经纬度-多边形区域
                        new KeyWordsBuider("lal",new GeoQueryInfo().addPolygon(
                                new LonLat(114.967240F,36.8180F),
                                new LonLat(122.59643554F,37.85750F),
                                new LonLat(122.486572F,32.40779F),
                                new LonLat(112.92846F,31.128F)
                        ),FieldOccurs.INCLUDES, GeoQueryLevel.Polygon)

                )
        );

        SearchResult searchResult = casiaEsSearch.setReturnField("lal").executeQueryInfo();

        //结果打印
        //输出
        OutInfo.out(searchResult);
    }
}
