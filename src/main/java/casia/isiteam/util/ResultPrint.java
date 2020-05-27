package casia.isiteam.util;

import casia.isiteam.api.elasticsearch.common.vo.result.AggsInfo;
import casia.isiteam.api.elasticsearch.common.vo.result.LonLatInfo;
import casia.isiteam.api.elasticsearch.common.vo.result.QueryInfo;
import casia.isiteam.api.elasticsearch.common.vo.result.SearchResult;
import casia.isiteam.api.toolutil.Validator;
import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * ClassName: ResultPrint
 * Description: 结果打印
 * <p>
 * Created by casia.wzy on 2020/5/27
 * Email: zhiyou_wang@foxmail.com
 */
public class ResultPrint {
    public static void outQueryInfo( List<QueryInfo> queryInfos){
        queryInfos.forEach(s->{
            System.out.println(JSON.toJSONString(s));
        });
    }
    public static void outInfo(List<AggsInfo> aggsInfos, int childrens){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<childrens;i++ ){
            sb.append("\t");
        }
        for(AggsInfo s:aggsInfos){
            System.out.print(sb+"{field："+s.getField());
            System.out.print("}，{type："+s.getType());
            System.out.print("}，{total_doc："+s.getTotal_Doc());
            System.out.print("}，{total_Operation："+s.getTotal_Operation());
            System.out.println("}");
            if(Validator.check(s.getChildren())){
                outInfo(s.getChildren(),childrens+1);
            }
            if( Validator.check(s.getQueryInfos()) ){
                outInfo( childrens+1,s.getQueryInfos());
            }if( Validator.check(s.getLonLatInfos()) ){
                outLaLInfo( childrens+1,s.getLonLatInfos());
            }
        }
    }
    public static void outInfo(int childrens, List<QueryInfo> aggsInfos){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<childrens;i++ ){
            sb.append("\t");
        }
        aggsInfos.forEach(s->{
            System.out.print(sb+"{id："+s.getId());
            System.out.print("}，{index_name："+s.getIndexName());
            System.out.print("}，{index_type："+s.getIndexType());
            System.out.print("}，{score："+s.getScore());
            System.out.print("}，{Total_Type："+s.getTotal_Operation());
            System.out.print("}，{field："+s.getField());
            System.out.println("}");
        });
    }
    public static void outLaLInfo( int childrens,List<LonLatInfo> aggsInfos){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<childrens;i++ ){
            sb.append("\t");
        }
        aggsInfos.forEach(s->{
            System.out.print(sb+"{field："+s.getField());
            System.out.print("}，{type："+s.getType());
            System.out.print("}，{lon："+s.getLon());
            System.out.print("}，{lat："+s.getLat());
            System.out.println("}");
        });
    }
}
