package casia.isiteam.test.search;

import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSearch;
import casia.isiteam.api.elasticsearch.util.OutInfo;

/**
 * ClassName: Missing_Test
 * Description: 非空设置
 * <p>
 * Created by casia.wzy on 2020/5/27
 * Email: zhiyou_wang@foxmail.com
 */
public class Missing_Test {
    /**
     * 非空设置-测试
     * @param args
     */
    public static void main(String[] args) {

        CasiaEsSearch casiaEsSearch = new CasiaEsSearch("web");
        casiaEsSearch.setIndexName("test","test_data");
        //字段必须非空
        casiaEsSearch.setExistsFilter("content","title");
        //字段必须为空
        casiaEsSearch.setMissingFilter("lal");

        SearchResult searchResult = casiaEsSearch.executeQueryInfo();

        //结果打印
        OutInfo.out(searchResult);
    }
}
