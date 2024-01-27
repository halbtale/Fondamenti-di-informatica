public class Coppia 
{
	  String chiave;
  	int attributo;
  	
  	public Coppia(String x, int y)
  	{
      chiave = x;
  	  attributo = y;
  	}

  	public String toString () 
  	{
  		return chiave + ':' + attributo; 
  	}
  	  	
  	public String getChiave()
  	{
  		return chiave;
  	}

  	public int getAttributo()
  	{
  		return attributo;
  	}
}
