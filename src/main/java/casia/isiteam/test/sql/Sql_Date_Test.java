package casia.isiteam.test.sql;

import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSql;
import casia.isiteam.api.elasticsearch.util.OutInfo;

/**
 * ClassName: Sql_Date_Test
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/6/12
 * Email: zhiyou_wang@foxmail.com
 */
public class Sql_Date_Test {
    public static void main(String[] args) {
        CasiaEsSql casiaEsSql = new CasiaEsSql("web");


        String sql  = "select count(id) from test order by date_histogram(field='pubtime','interval'='1d')";
//        String sql  = "select test from test order by date_histogram(field='pubtime','format'='yyyy-MM-dd' ,'2020-01-01','2020-02-01','now-8d','now-7d','now-6d','now')";



        casiaEsSql.setQuerySql(sql);
        SearchResult searchResult = casiaEsSql.executeQueryInfo();

        OutInfo.out(searchResult);
    }
}
