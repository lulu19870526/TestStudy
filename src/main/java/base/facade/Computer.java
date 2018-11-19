package base.facade;

//门面类（核心）
public class Computer {

    private CPU cpu;
    private Disk disk;
    private Memory memory;

    public Computer(){
        cpu = new CPU();
        disk = new Disk();
        memory = new Memory();
    }

    public void start(){
        System.out.println("computer is start ...");
        cpu.start();
        disk.start();
        memory.start();
    }

}
