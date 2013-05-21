package Reader;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Reader {

  private Scanner scan;
	
	String filename = "Model3.java";

	public void openFile()
	{
		try
		{
			scan = new Scanner(new File(filename));
		}
		catch(Exception e)
		{
			System.out.println("Error 404: \"" + filename + "\" not found, creating \"" + filename + "\", \n" + "Please try again");
			File file = new File(filename);
			try {
				//file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException e1) {
				System.out.println("Error, could not create \"" + filename + "\" \n");
				e1.printStackTrace();
			}

		}
	}


	public float addbox1;
	public float addbox2;
	public float addbox3;

	public float rotate1;
	public float rotate2;
	public float rotate3;

	public float out1;
	public float out2;
	public float out3;

	public float fivedoto = 5.0F;
	public float twodoto = 2.0F;
	public float zerodoto = 0.0F;

	public int models;

	String Name,Name1,subD,subE,subF;

	public void readFile()
	{
		while(scan.hasNext())
		{
			String a = scan.nextLine();

			if(a.contains("setRotationPoint"))
			{
				//String b = a.replaceAll(".*\\.addBox", "addBox"); 

				String h = a.replaceAll("[(] ", " ");

				String i = h.replaceAll("[,]", "");
				String j = i.replaceAll("[);]", "");
				Scanner scan2 = new Scanner(j);

				while(scan2.hasNext())
				{

					Name1 = "        " + scan2.next();
					String subA1 = scan2.next();
					String subB2 = scan2.next();
					String subC3 = scan2.next();

					rotate1 = Float.valueOf(subA1);
					rotate2 = Float.valueOf(subB2);
					rotate3 = Float.valueOf(subC3);


					if(rotate1 > 5.0F)
					{
						out1 = rotate1 - 5.0F;
						rotate1 = fivedoto;
						addbox1 = addbox1 + out1;
					}
					else if(rotate1 < 5.0F)
					{
						out1 = 5.0F - rotate1;
						rotate1 = fivedoto;
						addbox1 = addbox1 - out1;
					}

					if(rotate2 > 2.0F)
					{
						out2 = rotate2 - 2.0F;
						rotate2 = twodoto;
						addbox2 = addbox2 + out2;
					}
					else if(rotate2 < 2.0F)
					{
						out2 = 2.0F - rotate2;
						rotate2 = twodoto;
						addbox2 = addbox2 - out2;
					}

					if(rotate3 > 0.0F)
					{
						out3 = rotate3 - 0.0F;
						rotate3 = zerodoto;
						addbox3 = addbox3 + out3;
					}
					else if(rotate3 < 0.0F)
					{
						out3 = 0.0F - rotate3;
						rotate3 = zerodoto;
						addbox3 = addbox3 - out3;
					}
					models++;

					//System.out.println(models);

					System.out.println(Name + "(" + addbox1 + "F, " + addbox2 + "F, " + addbox3 + "F, " + subD + ", " + subE + ", " + subF + ");");	
					System.out.println(Name1 + "( " + rotate1 + "F, " + rotate2 + "F, " + rotate3 + "F);");


				}

			}
			else if(a.contains("addBox"))
			{
				//String b = a.replaceAll(".*\\.addBox", "addBox"); 

				String c = a.replaceAll("[(] ", " ");
				String d = c.replaceAll("[,]", "");
				String e = d.replaceAll("[);]", "");
				Scanner scan1 = new Scanner(e);

				while(scan1.hasNext())
				{
					Name = "        " + scan1.next();
					String subA = scan1.next();
					String subB = scan1.next();
					String subC = scan1.next();


					subD = scan1.next();
					subE = scan1.next();
					subF = scan1.next();

					addbox1 = Float.valueOf(subA);
					addbox2 = Float.valueOf(subB);
					addbox3 = Float.valueOf(subC);



				}

			}
			else
			{
				System.out.println(a);
			}

		}
	}
	
	


	public void closeFile()
	{
		scan.close();
	}

}
