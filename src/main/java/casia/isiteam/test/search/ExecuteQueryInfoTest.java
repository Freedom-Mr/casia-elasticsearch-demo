package casia.isiteam.test.search;

import casia.isiteam.api.elasticsearch.common.enums.FieldOccurs;
import casia.isiteam.api.elasticsearch.common.enums.QueriesLevel;
import casia.isiteam.api.elasticsearch.common.enums.SortOrder;
import casia.isiteam.api.elasticsearch.common.vo.SearchResult;
import casia.isiteam.api.elasticsearch.common.vo.field.KeyWordsBuider;
import casia.isiteam.api.elasticsearch.common.vo.field.KeywordsCombine;
import casia.isiteam.api.elasticsearch.common.vo.field.RangeField;
import casia.isiteam.api.elasticsearch.common.vo.field.SortField;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSearch;

/**
 * ClassName: ExecuteQueryInfoTest
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/5/16
 * Email: zhiyou_wang@foxmail.com
 */
public class ExecuteQueryInfoTest {
    public static void main(String[] args) {
        CasiaEsSearch casiaEsSearch = new CasiaEsSearch("web");

        casiaEsSearch.setIndexName("test","test_data");
        SearchResult searchResult = casiaEsSearch.
                setFrom(0).
                setSize(20).
                addSort(
                        new SortField("id", SortOrder.DESC),
                        new SortField("eid", SortOrder.ASC)
                ).
                        setRange(
                        new RangeField(FieldOccurs.INCLUDES,"id",32174657,33677173)
                //                        new RangeField(FieldOccurs.EXCLUDES,"pubtime","2020-01-09 07:36:00",null)
                ).
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
                        setExistsFilter("content","title").
                        setMissingFilter("it").
//                openProfile().
        setMinScore(0.1F).
                        setHighlight(null,null,"title").
                        setReturnField("i*","site","pubtime","title").
                        setReturnField(true).
                        setReturnField(FieldOccurs.EXCLUDES,"ip").
                        executeQueryInfo();

        System.out.println("total："+searchResult.getTotal());
        System.out.println("scrollId："+searchResult.getScrollId());
        searchResult.getDataInfos().forEach(s->{
            System.out.print("{id："+s.getId());
            System.out.print("}，{_score："+s.getScore());
            System.out.print("}，{indexName："+s.getIndexName());
            System.out.print("}，{indexType："+s.getIndexType());
            System.out.print("}，{fileds："+s.getField());
            System.out.println("}");
        });
    }
}
