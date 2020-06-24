package casia.isiteam.test.aggregation;

import casia.isiteam.api.elasticsearch.common.vo.field.aggs.*;
import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSearch;
import casia.isiteam.api.elasticsearch.util.OutInfo;

/**
 * ClassName: Date_Agga_Test
 * Description: 时间聚合
 * <p>
 * Created by casia.wzy on 2020/5/27
 * Email: zhiyou_wang@foxmail.com
 */
public class Date_Agga_Test {
    /**
     * 时间聚合-测试
     * @param args
     */
    public static void main(String[] args) {
        CasiaEsSearch casiaEsSearch = new CasiaEsSearch("web");
        casiaEsSearch.setIndexName("test","test_data");

        //时间段内，统计文档数量
        casiaEsSearch.setAggregations(
                new AggsFieldBuider( new DateInfo("pubtime","yyyy-MM-dd","1d",1L) )
        );

        //时间段内，再次子聚合
       /* casiaEsSearch.setAggregations(
                new AggsFieldBuider(
                        new DateInfo("pubtime","yyyy-MM-dd","1d",3L,
                                new AggsFieldBuider(new TypeInfo("site"))
                        )
                )
        );*/

       //时间段内，再次子聚合以及返回前N条文档
       /* casiaEsSearch.setAggregations(
                new AggsFieldBuider(
                        new DateInfo("pubtime","yyyy-MM-dd","1d",3L,
                                new AggsFieldBuider().
                                        addType(new TypeInfo("site")).
                                        addTopDatas(new TopData(2).setReturnField(FieldOccurs.INCLUDES,"id","ip","keywords"))
                        )
                )
        );*/




        SearchResult searchResult = casiaEsSearch.executeAggsInfo();

        //输出
        OutInfo.out(searchResult);
    }
}
