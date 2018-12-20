
/**
 * 单例模式 练习
 * @author ZXL
 * 饿汉
 */
public class SingleTonClass1 {
	
	private static SingleTonClass1 instance = new SingleTonClass1();
	public static  SingleTonClass1 getInstance(){
		return instance;
	}
	private SingleTonClass1(){
		//dosomething
		
	}
}
