public class BookBeanTest
{
    public static void main(String... args)
    {
    	BookBean bean = new BookBean();
    	System.out.println("Bean object is :  " + bean);
      // An attemmpt to invoke a method, which we do NOT have in the class
      System.out.println("Bean object is :  " + bean.getTitle());// ERROR
    }
}
