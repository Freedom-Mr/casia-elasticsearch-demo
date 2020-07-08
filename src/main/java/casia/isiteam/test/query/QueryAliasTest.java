package casia.isiteam.test.query;

import casia.isiteam.api.elasticsearch.controller.CasiaEsQuery;
import casia.isiteam.api.elasticsearch.controller.api.CasiaEsApi;

/**
 * ClassName: QueryAliasTest
 * Description: 查询别名信息
 * <p>
 * Created by casia.wzy on 2020/7/8
 * Email: zhiyou_wang@foxmail.com
 */
public class QueryAliasTest {
    /**
     * 查询别名信息
     * @param args
     */
    public static void main(String[] args) {
        CasiaEsApi casiaEsApi = new CasiaEsApi("data");

        //无参数
        casiaEsApi.query().queryAlias().forEach((k,v)->{
            System.out.println(k+":"+v);
        });

        //根据通配符
        casiaEsApi.query().queryAlias("c*").forEach((k,v)->{
            System.out.println(k+":"+v);
        });

        //根据索引名称
        casiaEsApi.query().setIndexName("demo_test");
        casiaEsApi.query().queryAlias("s*").forEach((k,v)->{
            System.out.println(k+":"+v);
        });
    }
}
