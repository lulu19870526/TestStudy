package base.xiangyuan;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式
 * 维秘秀（维多利亚的秘密）是最高等级的秀场，全世界的超模也以能登上维秘秀舞台为傲。
 * 对于每一套造型（对象）来说，包含模特（对象的内部状态）和服装（对象的外部状态）。
 * 能使用的模特是有限的，但是要展示的服装却要远远超出这个数量，所以在展示每一套服装的时候，
 * 需要对模特进行复用。导演要展示一个造型，只需要从目前可用的模特人群（缓存）中喊一个过来，
 * 穿上对应的服装，即可走上T台。那么如果目前没有可用的模特怎么办呢？那就招个模特进来，
 * 实在不行导演自己上咯。
 *
 *
 * 优点：对象复用，降低内存消耗
 * 缺点：无法做到线程 安全，
 * 如果一个线程正在复用，修改其外部状态，而另外一个线程正在进行使用，就会造成问题
 */
public class ModelFactory {
    private static Map<String, Show> models = new HashMap<String, Show>();

    public static Show getShow(String name)
    {
        Model model = (Model)models.get(name);
        if (model == null)
        {
            model = new Model(name);
            models.put(name,model);
        }
        return model;
    }

}
