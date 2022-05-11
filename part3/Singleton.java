package part3;

public class Singleton {
    private static Singleton instance = null;
    /* A private Constructor prevents any other
    * class from instantiating.*/
    private Singleton(){ }
    /* Static 'instance' method */
    public static Singleton getInstance( ){
    if(instance == null)
        instance = new Singleton();
    return instance;
    }

    public static void set(){
		if(instance!=null){
			instance=null;
		}
	}

    // public static Singleton get()
	// {
	// 	return Singleton.instance;
	// }
}
