package javaStudy.unsafe;

import sun.misc.Unsafe;

public class ObjectInHeap {

    private long address = 0;

    // 让对象占用堆内存,触发[Full GC
    private byte[] bytes = null;

    private Unsafe unsafe = GetUsafeInstance.getUnsafeInstance();

    public ObjectInHeap()
    {
        address = unsafe.allocateMemory(2 * 1024 * 1024);
        bytes = new byte[1024 * 1024];
    }

    @Override
    protected void finalize() throws Throwable
    {
        super.finalize();
        System.out.println("finalize." + bytes.length);
        unsafe.freeMemory(address);
    }

    // Exception in thread "main" java.lang.OutOfMemoryError
    public static void main(String[] args)
    {
        while (true)
        {
            ObjectInHeap heap = new ObjectInHeap();
            System.out.println("memory address=" + heap.address);
        }
    }
}
