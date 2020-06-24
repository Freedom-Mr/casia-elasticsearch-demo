package casia.isiteam.test.search;

import casia.isiteam.api.elasticsearch.common.enums.FieldOccurs;
import casia.isiteam.api.elasticsearch.common.enums.QueriesLevel;
import casia.isiteam.api.elasticsearch.common.vo.field.search.KeyWordsBuider;
import casia.isiteam.api.elasticsearch.common.vo.field.search.KeywordsCombine;
import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSearch;
import casia.isiteam.api.elasticsearch.util.OutInfo;

/**
 * ClassName: Highlight_Test
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/5/27
 * Email: zhiyou_wang@foxmail.com
 */
public class Highlight_Test {
    public static void main(String[] args) {

        CasiaEsSearch casiaEsSearch = new CasiaEsSearch("web");
        casiaEsSearch.setIndexName("test","test_data");

        casiaEsSearch.setQueryKeyWords(
                new KeywordsCombine(1,
                    new KeyWordsBuider("title","肺炎", FieldOccurs.INCLUDES, QueriesLevel.Phrase)
            )
        );
        //命中关键词，结果高亮
        casiaEsSearch.setHighlight("<em>", "</em>", "title");

        SearchResult searchResult = casiaEsSearch.setReturnField("title").executeQueryInfo();

        //输出
        OutInfo.out(searchResult);
    }
}
