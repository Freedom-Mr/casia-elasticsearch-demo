package casia.isiteam.test.sql;

import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSql;
import casia.isiteam.api.elasticsearch.util.OutInfo;

/**
 * ClassName: Sql_Geo_Test
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/6/12
 * Email: zhiyou_wang@foxmail.com
 */
public class Sql_Geo_Test {
    public static void main(String[] args) {
        CasiaEsSql casiaEsSql = new CasiaEsSql("web");

        //GEO_BOUNDING_BOX(fieldName,topLeftLongitude,topLeftLatitude,bottomRightLongitude,bottomRightLatitude)
        String sql  = "select * from test where GEO_BOUNDING_BOX(lal, 112.967240, 28.211238, 111.967240, 26.211238) LIMIT 3";
        //GEO_DISTANCE(fieldName,distance,fromLongitude,fromLatitude)
//        String sql  = "select * from test where GEO_DISTANCE(lal,'1km', 112.967240, 28.211238) LIMIT 3";
//        String sql  = "select * from test where GEO_DISTANCE_RANGE(lal,'1km','10km', 112.967240, 28.211238) LIMIT 3";
//        String sql  = "select * from test where GEO_POLYGON(lal,'1km','10km', 112.967240, 28.211238) LIMIT 3";
//        String sql  = "select * from test where GEO_POLYGON(lal, 112.967240 ,28.211238 , 115.967240, 28.211238, 116.967240,30.211238) LIMIT 3";


        casiaEsSql.setQuerySql(sql);
        SearchResult searchResult = casiaEsSql.executeQueryInfo();

        OutInfo.out(searchResult);
    }
}
