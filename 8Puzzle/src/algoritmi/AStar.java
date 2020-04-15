package algoritmi;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Vector;

import euristici.Euristica;
import model.Matrix;

/*
AStar
* declaram priorityQueue (coada)
* adaugam nodul radacina la priorityQueue
* cat timp priorityQueue !=0 facem urmatoarele loopuri:
* a. recuperam si apoi stergem primul nod din coada (folosind functia poll() )
* b. verificam statusul nodului recuperat
*    daca acesta este egal cu nodul final atunci vom iesi din loop si printam solutia
*    daca nu este egal, atunci:
*      - expandam nodul recuperat
*      - evaluam folosind f(n)
*      - adaugam la coada
*      - continuam loopul
*
* f(n) = h(n) + g(n)
* n = starea curenta
* h(n) = valoarea euristicii
* g(n) = costul
*
*/


public class AStar extends SolvingStrategy{
	
	
	Euristica euristica;

	PriorityQueue<StateMatrix> queue;
	Map<Matrix,Integer> levelDepth;
	Map<Matrix,Matrix> stateHistory;

	int nodes = 0; //contor pentru generarea nodurilor
	int limit = 100; //countor pentru limita nodurilor
	int unique = -1;
	int newValue; //limita adancimii
	int h; //euristica

	Matrix currState;
	boolean solution = false;

	public AStar(Matrix init,Matrix goal,Euristica e){
		queue = new PriorityQueue <StateMatrix> ();
		levelDepth = new HashMap<Matrix, Integer>();
		stateHistory = new HashMap<Matrix,Matrix>();
		this.stareInitiala=init;
		this.stareFinala=goal;
		addToQueue(this.stareInitiala,null);
		e.setStareFinala(goal);
		this.euristica=e;
	}

	private void addToQueue (Matrix newState, Matrix oldState){
		if(!levelDepth.containsKey(newState)){
			// verificam daca starea se repeta
			newValue =( (oldState == null) ? 0 : levelDepth.get(oldState) + 1);
			unique ++;
			levelDepth.put(newState, newValue);
			h =  this.euristica.evaluate(newState) + newValue; // f(n)
			queue.add(new StateMatrix(h,newState)); //adaugam la coada
			stateHistory.put(newState, oldState);
		}
	}
	
	@Override
	public void solving(Matrix c) {
		

	}
	
	public StateMatrix expand(StateMatrix m){
		Matrix temp=m.getStateMatrix().clonare();
		Vector<Matrix> matrici=new Vector<Matrix>();
		
		for(int i=0;i<op.length;i++)
			if(op[i].valabil(temp)&& op[i].skip==false)
			{
				matrici.add(op[i].execute(temp));
			}
		
		int vmin=100;
		int pmin=-1;
		for(int i=0;i<matrici.size();i++)
			if(this.euristica.evaluate(matrici.get(i))<vmin) {
				vmin=this.euristica.evaluate(matrici.get(i));
				pmin=i;
			}
		Matrix f=matrici.get(pmin).clonare();
		StateMatrix newm=new StateMatrix(m.getPriority()+1,f);
		return newm;
	}


}
