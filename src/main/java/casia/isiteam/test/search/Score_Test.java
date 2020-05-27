package casia.isiteam.test.search;

import casia.isiteam.api.elasticsearch.common.enums.FieldOccurs;
import casia.isiteam.api.elasticsearch.common.vo.field.RangeField;
import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSearch;
import casia.isiteam.util.ResultPrint;

/**
 * ClassName: Score_Test
 * Description: 最小相关度
 * <p>
 * Created by casia.wzy on 2020/5/27
 * Email: zhiyou_wang@foxmail.com
 */
public class Score_Test {
    /**
     * 最小相关度-测试
     * @param args
     */
    public static void main(String[] args) {

        CasiaEsSearch casiaEsSearch = new CasiaEsSearch("web");
        casiaEsSearch.setIndexName("test","test_data");
        //最小相关度
        casiaEsSearch.setMinScore(0.1F);

        SearchResult searchResult = casiaEsSearch.executeQueryInfo();

        //结果打印
        System.out.println("total_doc："+searchResult.getTotal_Doc());
        ResultPrint.outQueryInfo(searchResult.getQueryInfos());
    }
}
