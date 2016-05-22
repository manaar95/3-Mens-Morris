/***********************************/
/*	
	Name: Manaar Hyder (hyderm2)
	Student #: 1323089

	Name: Katrine Rachitsky (rachitk)
	Student #: 1306314

	Name: Navleen Singh (singhn8)
	Student #: 1302228
*/
/***********************************/

public class AgentAgatha extends Thread {
    private Assignment2 objA2;

    public AgentAgatha(Assignment2 objA2) {//Pass in Assignment2 object so you can call functions from Assignment2
		this.objA2 = objA2;
    }

    public void run() { //Agatha Thread
		objA2.placeItemOnTable();
    }
}