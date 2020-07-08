package casia.isiteam.test.query;

import casia.isiteam.api.elasticsearch.controller.CasiaEsQuery;
import com.alibaba.fastjson.JSONObject;

/**
 * ClassName: QueryIndex
 * Description: 查询索引信息
 * <p>
 * Created by casia.wzy on 2020/7/8
 * Email: zhiyou_wang@foxmail.com
 */
public class QueryIndexTest {
    /**
     * 查询索引信息
     * @param args
     */
    public static void main(String[] args) {
        CasiaEsQuery casiaEsQuery = new CasiaEsQuery("data");
        //查询所有索引名列表
        casiaEsQuery.queryIndexNames().forEach(System.out::println);


        //查询“test” 索引信息
        JSONObject info = casiaEsQuery.queryIndexByName("test");
        System.out.println(info);

    }
}
