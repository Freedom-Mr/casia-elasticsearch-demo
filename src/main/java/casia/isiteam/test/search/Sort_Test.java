package casia.isiteam.test.search;

import casia.isiteam.api.elasticsearch.common.enums.SortOrder;
import casia.isiteam.api.elasticsearch.common.vo.field.SortField;
import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSearch;
import casia.isiteam.api.elasticsearch.util.OutInfo;

/**
 * ClassName: Sort_Test
 * Description: 字段排序-测试
 * <p>
 * Created by casia.wzy on 2020/5/27
 * Email: zhiyou_wang@foxmail.com
 */
public class Sort_Test {
    /**
     * 字段排序-测试
     * @param args
     */
    public static void main(String[] args) {

        CasiaEsSearch casiaEsSearch = new CasiaEsSearch("web");
        casiaEsSearch.setIndexName("test","test_data");
        //排序
        casiaEsSearch.addSort(
                new SortField("pubtime", SortOrder.DESC),
                new SortField("id", SortOrder.ASC)
        );

        SearchResult searchResult = casiaEsSearch.executeQueryInfo();

        //结果打印
        OutInfo.out(searchResult);
    }
}
