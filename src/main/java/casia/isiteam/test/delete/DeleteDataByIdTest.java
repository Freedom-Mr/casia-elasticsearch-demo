package casia.isiteam.test.delete;

import casia.isiteam.api.elasticsearch.controller.CasiaEsDelete;

import java.util.Arrays;

/**
 * ClassName: DeleteDataByIdTest
 * Description: 通过主键删除数据
 * <p>
 * Created by casia.wzy on 2020/7/8
 * Email: zhiyou_wang@foxmail.com
 */
public class DeleteDataByIdTest {
    /**
     * 通过主键删除数据
     * @param args
     */
    public static void main(String[] args) {
        CasiaEsDelete casiaEsDelete = new CasiaEsDelete("data");
        casiaEsDelete.setIndexName("demo_test","test_data");

        //多个ID
        System.out.println(casiaEsDelete.deleteDataByIds(Arrays.asList(new String[]{"123456789","1"})));

        //单个ID
        System.out.println(casiaEsDelete.deleteDataById("2"));

    }
}
