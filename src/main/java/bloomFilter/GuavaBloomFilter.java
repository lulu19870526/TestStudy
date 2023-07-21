package bloomFilter;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @Author: zengqx
 * @Date: 2023/7/21 15:15
 */
public class GuavaBloomFilter {

    public static void main(String[] args) {
        /**
         * 总数和错误率
         */
        BloomFilter bloomFilter =
                BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),
                        100000, 0.01);

        bloomFilter.put("shenzhen");

        System.out.println(bloomFilter.mightContain("guangzhou"));
        System.out.println(bloomFilter.mightContain("shenzhen"));
    }
}
