package casia.isiteam.test.search;

import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSearch;
import casia.isiteam.api.elasticsearch.util.OutInfo;

/**
 * ClassName: Page_Test
 * Description: 分页条件设置-测试
 * <p>
 * Created by casia.wzy on 2020/5/27
 * Email: zhiyou_wang@foxmail.com
 */
public class Page_Test {
    /**
     * 分页条件-测试
     * @param args
     */
    public static void main(String[] args) {

        CasiaEsSearch casiaEsSearch = new CasiaEsSearch("web");
        casiaEsSearch.setIndexName("test","test_data");
        //分页
        casiaEsSearch.setFrom(0).setSize(20);

        SearchResult searchResult = casiaEsSearch.executeQueryInfo();

        //结果打印
        OutInfo.out(searchResult);
    }
}
