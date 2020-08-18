package casia.isiteam.test.sql;

import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSql;
import casia.isiteam.api.elasticsearch.util.OutInfo;

/**
 * ClassName: Sql_Versatility_Test
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/6/12
 * Email: zhiyou_wang@foxmail.com
 */
public class Sql_Versatility_Test {
    public static void main(String[] args) {
        
        CasiaEsSql casiaEsSql = new CasiaEsSql("web");


        String sql  = "select * from test limit 10";
//        String sql  = "select * from test/test_data limit 10";
//        String sql  = "select * from test/test_data,demo_test/test_data limit 10";
//        String sql  = "select * from test where eid =687 limit 10";
//        String sql  = "select * from test where eid =687 and keywords ='暴徒' ";
//        String sql  = "select eid,title from test where eid =687 and title ='香港' ";
//        String sql  = "select eid,site from test where eid =687 and site like '香港%' ";
//        String sql  = "select eid from test where eid =687 and pubtime >='2020-05-09 08:35:12' order by pubtime asc";
//        String sql  = "select count(eid) from test ";
//        String sql  = "select sum(eid),avg(eid)  from test group by eid";


        casiaEsSql.setQuerySql(sql);
        SearchResult searchResult = casiaEsSql.executeQueryInfo();

        OutInfo.out(searchResult);
    }
}
