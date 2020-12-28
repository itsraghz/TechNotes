public class BookBean
{
    private String title;

    public BookBean()
    {
	this.title="Default Title";
	System.out.println("BookBean instantiated");
    }

    @Override
    public String toString()
    {
	return "[Book] hashcode=" + this.hashCode() + ", title="+this.title;
    }
}
