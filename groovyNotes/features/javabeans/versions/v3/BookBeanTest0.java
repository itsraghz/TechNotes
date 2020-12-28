public class BookBeanTest
{
    public static void main(String... args)
    {
    	BookBean bean = new BookBean();
    	//BookBean bean = new BookBean("Head First Java");
    	System.out.println("Bean object is :  " + bean);
    	System.out.println("Bean object is :  " + bean.getTitle());
    }
}
