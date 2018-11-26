package zookeeper.lock;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


//redis排序
public class redisOrder {


    public static void main(String[] args){

    }

    public static String getLastOne(Jedis jedis,long groupId){
        List<Long> userIdList = getUserIdListByGroupId(groupId);
        if(userIdList != null && !userIdList.isEmpty()){
            for(int i=0 ;i<userIdList.size();i++){

                /**
                 * ZADD key score1 member1 [score2 member2]
                 * 向有序集合添加一个或多个成员，或者更新已存在成员的分数
                 *
                 * Redis Zadd 命令用于将一个或多个成员元素及其分数值加入到有序集当中。
                 */
                jedis.zadd(""+groupId,i,groupId+"_"+userIdList.get(i));
            }
        }

        /**
         * Redis Zrange 是有序集合( SortedSet ) 提供的一个命令，可以返回有序集中指定区间内的成员
         * Redis Zrange 返回有序集中，指定区间内的成员。
         * 其中成员的位置按分数值递增(从小到大)来排序。
         * 具有相同分数值的成员按字典序(lexicographical order )来排列。
         *
         * 下标参数 start 和 stop 都以 0 为底，也就是说，以 0 表示有序集第一个成员，以 1 表示有序集第二个成员，以此类推。
         * 你也可以使用负数下标，以 -1 表示最后一个成员， -2 表示倒数第二个成员，以此类推。
         */
        Set<String> sortSet= jedis.zrange(""+groupId,0,-1);
        if(sortSet != null && !sortSet.isEmpty()){
            String lastOneMember = sortSet.iterator().next();
            if(lastOneMember != null){
                return lastOneMember.replace(groupId+"_","");
            }
        }
        return null;
    }

    public static List<Long> getUserIdListByGroupId(long groupId){
        List<Long> userIdList =  new ArrayList<Long>();
        userIdList.add(1001l);
        userIdList.add(1002l);
        userIdList.add(1003l);

        return userIdList;
    }
}
