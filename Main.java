import java.util.*;

public class Main {
	
	static List<String> list = new ArrayList<>();
	static int count;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int c;
		do {
			System.out.println("\n [1]. Add, [2]. Display, [3]. Permutation, [4]. Exit");
			c = scan.nextInt();
			if (c == 1) {
				System.out.println("How many? ");
                for (int n = scan.nextInt(); n-- > 0; ) list.add(scan.next());
              }else if (c == 2){
				System.out.println(list.isEmpty() ? "Queue is empty" : "Queue" + list );
		      }else if (c == 3 || c == 4){
			 	 System.out.println("Enter r: ");
				 int r = scan.nextInt();
                 if (list.isEmpty() || r < 0 || r > list.size()) { System.out.println("INVALID!"); continue; }
                 count = 0;
                 generate("", new ArrayList<>(list), r, c == 3);
                 System.out.println("Total" + count);
                }
             } while(c != 5);
		  }
	  static void generate(String cur, List<String> rest, int r, boolean perm) {
		  if(r == 0) { System.out.println(cur); count++; return; }
		  for(int i = 0; i < rest.size(); i++) {
			  List<String> next = new ArrayList(perm ? rest : rest.subList(i + 1, rest.size()));
			  if (perm) next.remove(i);
			  generate(cur + rest.get(i), next, r - 1, perm);
		  }
		}
      }
