package casia.isiteam.test.aggregation;

import casia.isiteam.api.elasticsearch.common.enums.OperationLevel;
import casia.isiteam.api.elasticsearch.common.vo.field.aggs.AggsFieldBuider;
import casia.isiteam.api.elasticsearch.common.vo.field.aggs.OperationInfo;
import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSearch;
import casia.isiteam.api.elasticsearch.util.OutInfo;

/**
 * ClassName: Operation_Aggs_Test
 * Description: 维度运算
 * <p>
 * Created by casia.wzy on 2020/5/27
 * Email: zhiyou_wang@foxmail.com
 */
public class Operation_Aggs_Test {
    public static void main(String[] args) {
        CasiaEsSearch casiaEsSearch = new CasiaEsSearch("web");
        casiaEsSearch.setIndexName("test","test_data");


        SearchResult searchResult = casiaEsSearch.setAggregations(
                new AggsFieldBuider(
                        //和、平均值、最大值、最小值运算
                        new OperationInfo(OperationLevel.Sum,"eid"),
                        new OperationInfo(OperationLevel.Avg,"eid"),
                        new OperationInfo(OperationLevel.Max,"eid"),
                        new OperationInfo(OperationLevel.Min,"eid")
                )
        ).executeAggsInfo();


        //输出
        OutInfo.out(searchResult);
    }
}
