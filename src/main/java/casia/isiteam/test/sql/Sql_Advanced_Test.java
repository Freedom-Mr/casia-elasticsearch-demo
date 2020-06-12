package casia.isiteam.test.sql;

import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSql;
import casia.isiteam.api.elasticsearch.util.OutInfo;

/**
 * ClassName: Sql_Advanced_Test
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/6/12
 * Email: zhiyou_wang@foxmail.com
 */
public class Sql_Advanced_Test {
    public static void main(String[] args) {
        CasiaEsSql casiaEsSql = new CasiaEsSql("web");

        String sql  = " select title from test where title = matchQuery('香港 抗议') order by _score DESC LIMIT 3";


        casiaEsSql.setQuerySql(sql);
        SearchResult searchResult = casiaEsSql.executeQueryInfo();

        OutInfo.out(searchResult);
    }
}
