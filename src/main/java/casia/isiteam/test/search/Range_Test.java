package casia.isiteam.test.search;

import casia.isiteam.api.elasticsearch.common.enums.FieldOccurs;
import casia.isiteam.api.elasticsearch.common.vo.field.RangeField;
import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.elasticsearch.controller.CasiaEsSearch;
import casia.isiteam.api.elasticsearch.controller.api.CasiaEsApi;
import casia.isiteam.api.elasticsearch.util.OutInfo;

/**
 * ClassName: Range_Test
 * Description: 数据范围-测试
 * <p>
 * Created by casia.wzy on 2020/5/27
 * Email: zhiyou_wang@foxmail.com
 */
public class Range_Test {
    /**
     * 数据范围-测试
     * @param args
     */
    public static void main(String[] args) {

        CasiaEsApi casiaEsApi = new CasiaEsApi("web");
        casiaEsApi.search().setIndexName("test","test_data");
        //数据范围
        casiaEsApi.search().setRange(
                new RangeField(FieldOccurs.INCLUDES,"id",32174657,33677173),
                new RangeField(FieldOccurs.EXCLUDES,"pubtime","2020-01-09 07:36:00",null)
        );

        SearchResult searchResult = casiaEsApi.search().executeQueryInfo();

        //结果打印
        OutInfo.out(searchResult);
    }
}
