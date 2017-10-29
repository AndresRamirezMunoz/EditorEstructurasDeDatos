package uniquindio.listas.cola;



public class Run {

	public static void main(String[] args) {
		 Cola<Integer> c = new Cola<Integer>();
		
		 for (int i =0 ; i < 10; i++) {
		 c.add(i);
		 }
		
		 System.out.println(c);
		
		 for (Object object : c) {
		 System.out.println(object);
		 }
		

		

	}

}
