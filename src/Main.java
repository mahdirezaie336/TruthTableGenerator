
public class Main 
{
	// Driver
	public static void main(String[] args) 
	{
		int size = 3;						// Size of bits
		Function f = new Function() 		// The function
		{
			@Override
			public boolean f(boolean...args)
			{
				boolean a=false,b=false,c=false,d=false,e=false;
				
				switch(args.length)
				{
				case 5:
					e = args[4];
				case 4:
					d = args[3];
				case 3:
					c = args[2];
				case 2:
					b = args[1];
				case 1:
					a = args[0];
					break;
				}
				boolean p = a,q = b, r = c,s = d;
				boolean y1 = a, y2 = b, x = c;
				
				// TODO: Define f function here
				boolean h = !or(!p,q);
				boolean g = or(p,!s,!r);
				boolean f = JK(and(y1,x,!y2),y2,y1);
				
				return and(x,y2);
			}
		};
		
		// Display
		try {
			Generator generator = new Generator(size,f);
			generator.generate();
			System.out.println(generator.getOutput());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
