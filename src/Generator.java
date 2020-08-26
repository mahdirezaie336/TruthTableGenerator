
public class Generator 
{
	private int size;
	private String output;
	private Function function;
	
	public Generator(int n, Function f) throws Exception
	{
		if(n <= 0) throw new Exception("Invalid number of bits");
		size = n;
		output = "";
		function = f;
	}
	
	public String generate()
	{
		generate(size, null);
		return output;
	}
	
	private void generate(int a, boolean...args)
	{
		if(a == 0)
		{
			print(args);
			return;
		}
		generate(a-1,Function.combine(false,args));
		generate(a-1,Function.combine(true,args));
	}
	
	public void print(boolean... args)
	{
		for(boolean member : args)
		{
			output += (member?1:0) + " ";
		}
		output += "  " + (function.f(args)?1:0) + "   " + Function.toInt(args) + "\n";
	}
	
	public String getOutput()
	{
		return output;
	}
}
