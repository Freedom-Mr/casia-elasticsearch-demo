package casia.isiteam.test.search;

import casia.isiteam.api.elasticsearch.common.enums.FieldOccurs;
import casia.isiteam.api.elasticsearch.common.enums.QueriesLevel;
import casia.isiteam.api.elasticsearch.common.vo.field.RangeField;
import casia.isiteam.api.elasticsearch.common.vo.field.search.KeyWordsBuider;
import casia.isiteam.api.elasticsearch.common.vo.field.search.KeywordsCombine;
import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSearch;

/**
 * ClassName: Total_Test
 * Description: 文档数量-测试
 * <p>
 * Created by casia.wzy on 2020/5/16
 * Email: zhiyou_wang@foxmail.com
 */
public class Total_Test {
    public static void main(String[] args) {
        CasiaEsSearch casiaEsSearch = new CasiaEsSearch("web");

        casiaEsSearch.setIndexName("test","test_data");
        SearchResult searchResult = casiaEsSearch.
                setQueryKeyWords(
                        new KeywordsCombine(1,
                                new KeyWordsBuider("title","肺炎",FieldOccurs.INCLUDES, QueriesLevel.Phrase)
                        )
                ).
                setReturnField("i*","site","pubtime","title").

                //只查询命中文档数量
                executeQueryTotal();

        System.out.println("total："+searchResult.getTotal_Doc());
    }
}
