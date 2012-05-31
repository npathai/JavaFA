import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		
		System.out.println("************Welcome to Autometa*************");
		System.out.println("Enter input one by one. Enter # to stop and find whether the input is accepted");
		
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String input = scanner.next();
			char[] inputs = input.toCharArray();
			Autometa1.States presentState = Autometa1.startState;
			for(int i = 0; i < inputs.length ; i++){
				presentState = Autometa1.getNextState(presentState, inputs[i]);
				if(presentState == null){
					break;
				}
			}
			if(presentState == null || !Autometa1.finalStates.contains(presentState)){
				System.out.println("Input: " + input + " is not accepted.");
			}else{
				System.out.println("Input: " + input + " is accepted.");
			}
		}
		
	}
}
