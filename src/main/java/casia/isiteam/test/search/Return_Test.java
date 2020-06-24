package casia.isiteam.test.search;

import casia.isiteam.api.elasticsearch.common.enums.FieldOccurs;
import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSearch;
import casia.isiteam.api.elasticsearch.util.OutInfo;

/**
 * ClassName: Return_Test
 * Description: 返回字段
 * <p>
 * Created by casia.wzy on 2020/5/27
 * Email: zhiyou_wang@foxmail.com
 */
public class Return_Test {

    public static void main(String[] args) {
        CasiaEsSearch casiaEsSearch = new CasiaEsSearch("web");
        casiaEsSearch.setIndexName("test","test_data");

        //返回字段
        casiaEsSearch.setReturnField("i*","site","pubtime","title");
        //排除返回字段
        casiaEsSearch.setReturnField(FieldOccurs.EXCLUDES,"ip");

        SearchResult searchResult = casiaEsSearch.executeQueryInfo();

        //结果打印
        OutInfo.out(searchResult);
    }
}
