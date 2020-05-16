package casia.isiteam.test.search;

import casia.isiteam.api.elasticsearch.common.enums.FieldOccurs;
import casia.isiteam.api.elasticsearch.common.enums.QueriesLevel;
import casia.isiteam.api.elasticsearch.common.vo.SearchResult;
import casia.isiteam.api.elasticsearch.common.vo.field.KeyWordsBuider;
import casia.isiteam.api.elasticsearch.common.vo.field.KeywordsCombine;
import casia.isiteam.api.elasticsearch.common.vo.field.RangeField;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSearch;

/**
 * ClassName: ExecuteQueryTotalTest
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/5/16
 * Email: zhiyou_wang@foxmail.com
 */
public class ExecuteQueryTotalTest {
    public static void main(String[] args) {
        CasiaEsSearch casiaEsSearch = new CasiaEsSearch("web");

        casiaEsSearch.setIndexName("test","test_data");
        SearchResult searchResult = casiaEsSearch.
                setFrom(0).
                setSize(20).
                setRange(
                    new RangeField(FieldOccurs.INCLUDES,"id",32174657,33677173)
                ).
                        setQueryKeyWords(
                                new KeywordsCombine(4,
                                        new KeyWordsBuider("title","肺炎",FieldOccurs.INCLUDES, QueriesLevel.Phrase),
                                        new KeyWordsBuider("title","病毒",FieldOccurs.EXCLUDES, QueriesLevel.Phrase),
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
                        setExistsFilter("content","title").
                        setMissingFilter("it").
//                openProfile().
        setMinScore(0.1F).
                        setHighlight(null,null,"title").
                        setReturnField("i*","site","pubtime","title").
                        setReturnField(true).
                        setReturnField(FieldOccurs.EXCLUDES,"ip").
                        executeQueryTotal();

        System.out.println("total："+searchResult.getTotal());
    }
}
