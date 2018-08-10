import com.alibaba.fastjson.JSON;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengqx on 2017/12/23.
 */
public class TestReflectParam {

    public static void main(String[] args){
        try {
            Class cls = Class.forName("Example");

            List<String> list1 = new ArrayList<String>();
            list1.add("北京");
            list1.add("上海");
            Example example = new Example(list1);


            Method[] methods = cls.getDeclaredMethods();
            if(methods != null && methods.length > 0){
                for(int i=0;i<methods.length;i++){
                    Method tempMethod = methods[i];

                    if(tempMethod.getName().equals("getList")){
                        List<String> getList = (List<String>)tempMethod.invoke(example,null);
                        if(getList != null && getList.size()>0){
                            for(int j=0;j<getList.size();j++){
                                System.out.println("getList中,getList的第"+j+"个元素的值是"+ getList.get(j));
                            }
                        }
                    }

                    if(tempMethod.getName().equals("getParam")){

                        Class<?>[] clsArray = tempMethod.getParameterTypes();
                        Type[] typeArray = tempMethod.getGenericParameterTypes();
                        if(clsArray != null && clsArray.length>0){
                            for(int k=0;k<clsArray.length;k++){
                                System.out.println("getParameterTypes()中,第"+k+"个元素值:"+clsArray[k]);
                                System.out.println("getGenericParameterTypes()中,第"+k+"个元素值:"+typeArray[k]);
                            }
                        }
                        getParamNames(cls,"getParam");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getParamNames(Class<?> clazz,String methodName){
        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass ctClass = pool.get(clazz.getName());
            CtMethod ctMethod = ctClass.getDeclaredMethod(methodName);

            // 使用javassist的反射方法的参数名
            MethodInfo methodInfo = ctMethod.getMethodInfo();
            CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
            LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute
                    .getAttribute(LocalVariableAttribute.tag);
            if (attr != null) {
                int len = ctMethod.getParameterTypes().length;
                // 非静态的成员函数的第一个参数是this
                int pos = Modifier.isStatic(ctMethod.getModifiers()) ? 0 : 1;
                System.out.println("pos="+pos+";len="+len);
                for (int i = 0; i < len+pos; i++) {
                    System.out.println("第" + i + "个参数名称为:" + attr.variableName(i + pos));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Example{
    private List<String> list;

    public Example(List<String> list){
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void getParam(List<String> listParam,int aParam,Integer bParam){
        this.list = listParam;
        if(listParam != null && listParam.size() >0){
            for(int i=0;i<listParam.size();i++){
                System.out.println("getParam()中,listParam的第"+i+"个元素的值是"+listParam.get(i));
            }
        }
        System.out.println("getParam()中,aParam="+aParam+";bParam="+bParam);
    }
}
