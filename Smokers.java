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

public class Smokers extends Thread {

    private String item, smoker;
    private Assignment2 objA2;

    public Smokers(Assignment2 objA2, String item, String smoker) { //Pass in item, A2 object, and Smoker
		this.item = item;
		this.objA2 = objA2;
		this.smoker = smoker;
    }

    public void run() { //Smoker Thread
		while (true) {
		    objA2.smokerWaitingForItem(item, smoker); //Select which item this smoker will recive 
		    try {
				Thread.sleep(1000);//Wait one second between turns
		    }catch (InterruptedException e) {
		    }
		    objA2.smokerFinishedSmoking(smoker);//Show if the smoker is done smoking
		}
    }
}