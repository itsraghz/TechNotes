public class BookBean
{
    private String title;

    public BookBean(String title)
    {
	this.title=title;
	System.out.println("BookBean instantiated");
    }

    public String getTitle()
    {
	return this.title;
    }

    @Override
    public String toString()
    {
	return "[Book] hashcode=" + this.hashCode() + ", title="+this.title;
    }
}
