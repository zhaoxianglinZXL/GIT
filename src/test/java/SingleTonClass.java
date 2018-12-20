
/**
 * 单例模式 练习
 * @author ZXL
 *懒汉
 */
public class SingleTonClass {
	
	private static SingleTonClass instance = null;
	public static synchronized SingleTonClass getInstance(){
		if(instance == null){
			instance = new SingleTonClass();
		}
		return instance;
	}
	private SingleTonClass(){
		//dosomething
		
	}
}
