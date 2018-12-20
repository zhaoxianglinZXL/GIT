
/**
 * 单例模式 练习
 * @author ZXL
 * 饿汉
 */
public class SingleTonClass2 {
	
	private static volatile SingleTonClass2 instance = null;
	public static  SingleTonClass2 getInstance(){
		if(instance == null){
			synchronized(SingleTonClass2.class){
				if(instance == null){
					instance = new SingleTonClass2();
				}
			}
		}
		return instance;
	}
	private SingleTonClass2(){
		//dosomething
		
	}
}
