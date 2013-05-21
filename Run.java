package Reader;

  class Run{
		public static void main(String[] args) {

			Reader read = new Reader();
			
			read.openFile();
			read.readFile();
			read.closeFile();
			
			
		}	
}
