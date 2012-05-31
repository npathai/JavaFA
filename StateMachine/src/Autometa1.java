import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Autometa1 {
	
	public static States startState = States.S1;
	final static public List<States> finalStates = new ArrayList<States>();
	static{
		finalStates.add(States.S3);
	}
	
	enum States implements StateProcessor{
		S1{
			@Override
			public void process() {
				
			}
		},
		S2{
			@Override
			public void process() {
				
			}
		},
		S3{
			@Override
			public void process() {
				
			}
		};
		
		enum Transitions{
			TR1('a',S1,S2),
			TR2('b',S2,S3),
			TR3('a',S3,S3),
			TR4('b',S3,S3);
			
			
			States srcState;
			States destState;
			Character inp;
			
			private static final Map<States,Map<Character,States>> transitionMap;
			
			static{
				transitionMap = new EnumMap<Autometa1.States, Map<Character,States>>(States.class);
				for(Transitions t : values()){
					if(transitionMap.get(t.srcState) == null){
						transitionMap.put(t.srcState, new HashMap<Character, Autometa1.States>());
					}
					transitionMap.get(t.srcState).put(t.inp, t.destState);
				}
			}
			
			private Transitions(Character inp, States sourceState, States destinationState){
				this.srcState = sourceState;
				this.destState = destinationState;
				this.inp = inp;
			}
			
			public static States getNextState(States presentState, Character input){
				return transitionMap.get(presentState).get(input);
			}
		}
	}
	
	public static States getNextState(States presentState, Character input){
		return States.Transitions.getNextState(presentState, input);
	}
}
