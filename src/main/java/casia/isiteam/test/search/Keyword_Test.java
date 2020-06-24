package casia.isiteam.test.search;

import casia.isiteam.api.elasticsearch.common.enums.FieldOccurs;
import casia.isiteam.api.elasticsearch.common.enums.QueriesLevel;
import casia.isiteam.api.elasticsearch.common.vo.field.search.KeyWordsBuider;
import casia.isiteam.api.elasticsearch.common.vo.field.search.KeywordsCombine;
import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSearch;
import casia.isiteam.api.elasticsearch.util.OutInfo;

/**
 * ClassName: Keyword_Test
 * Description: 关键词检索-测试
 * <p>
 * Created by casia.wzy on 2020/5/16
 * Email: zhiyou_wang@foxmail.com
 */
public class Keyword_Test {
    public static void main(String[] args) {
        CasiaEsSearch casiaEsSearch = new CasiaEsSearch("web");

        casiaEsSearch.setIndexName("test","test_data");
        SearchResult searchResult = casiaEsSearch.
                //关键词检索
                setQueryKeyWords(
                        new KeywordsCombine(4,
                                new KeyWordsBuider("title","肺炎",FieldOccurs.INCLUDES, QueriesLevel.Phrase),
                                new KeyWordsBuider("title","病毒",FieldOccurs.EXCLUDES, QueriesLevel.Phrase),
                                new KeyWordsBuider("site","新.*",FieldOccurs.INCLUDES, QueriesLevel.Regexp),
                                new KeyWordsBuider(
                                        new KeywordsCombine(3,
                                                new KeyWordsBuider("id","32677740",FieldOccurs.INCLUDES, QueriesLevel.Term),
                                                new KeyWordsBuider("title","广告",FieldOccurs.EXCLUDES, QueriesLevel.Phrase),
                                                new KeyWordsBuider(
                                                        new KeywordsCombine(1,new KeyWordsBuider("title","武汉",FieldOccurs.INCLUDES, QueriesLevel.Phrase) )
                                                )
                                        )
                                )
                        ),
                        new KeywordsCombine(1,
                                new KeyWordsBuider("title","疫情",FieldOccurs.INCLUDES, QueriesLevel.Term)
                        )
                ).
                executeQueryInfo();

        //结果打印
        OutInfo.out(searchResult);
    }
}
