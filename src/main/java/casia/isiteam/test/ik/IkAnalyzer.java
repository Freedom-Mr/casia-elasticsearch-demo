package casia.isiteam.test.ik;

import casia.isiteam.api.elasticsearch.controller.CasiaIkAnalyzer;

import java.util.Map;

/**
 * ClassName: IkAnalyzer
 * Description: ik 分词
 * <p>
 * Created by casia.wzy on 2020/8/18
 * Email: zhiyou_wang@foxmail.com
 */
public class IkAnalyzer {
    /**
     * ik 分词
     * @param args
     */
    public static void main(String[] args) {
        String text = "7月6日，山东一名22岁打工小伙在工地演奏古筝的视频火了，众人纷纷惊叹不已。据悉，小伙通过网上视频自学古筝4年，背着琴走南闯北，每到一处都不忘在工棚里练琴，学会了很多高难度曲目，他最大的愿望就是成为一名古筝老师。" +
                "最近感染了新冠，在家休养，新冠肺炎严重的影响了他的生活。";

//        Map<String,Integer> rs = CasiaIkAnalyzer.minAnalyzer(text);
        Map<String,Integer> rs = CasiaIkAnalyzer.maxAnalyzer(text,-1,1,2);
        System.out.println("共计："+rs.size());
        rs.forEach((k,v)->{
            System.out.println(k+":"+v);
        });

    }
}
