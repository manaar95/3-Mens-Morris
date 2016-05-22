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

public class Assignment2 {

	private Semaphore objSemaphore;
	private int statusOfTable;
	private String item1, item2;

	public Assignment2() {
		statusOfTable = 3; //Set the default state to empty

		objSemaphore = new Semaphore(1); //Setup Semaphore object

		Thread[] objThread = new Thread[4];//Define arraies of object threads

		objThread[0] = new AgentAgatha(this);

		/*Set which smoker owns which product of a cigirate*/
		objThread[1] = new Smokers(this, "Paper", "Arthur");
		objThread[2] = new Smokers(this, "Tabacco", "Horacio");
		objThread[3] = new Smokers(this, "Matches", "Edgar");

		for (int i = 0; i < 4; i++)
			objThread[i].start();//Start all 4 threads
	}

	public void placeItemOnTable() {
		//Checks which item is not on the table
		int itemNotOnTable;

		//Set which items Agatha will place on the table
		while (true) {
			objSemaphore.Release();
			if (statusOfTable == 3) {
				//Select random smoker that will recive the items first
				itemNotOnTable = 1 + (int)(Math.random() * 3.0);
				if (itemNotOnTable == 1) {
				//If Arthur recives the items set the two items he will recive
					item1 = "Tabacco";
					item2 = "Matches";
				}else if (itemNotOnTable == 2) {
				//If Horacio recives the items set the two items he will recive
					item1 = "Paper";
					item2 = "Matches";
				}else {
				//If Edgar recives the items set the two items he will recive
					item1 = "Paper";
					item2 = "Tabacco";
				}
				//Print to the screen what Agatha put on the table
				System.out.println("Agatha put " + item1 + " and " + item2 + " on table.");
				//Reset smokers turn
				statusOfTable = 1;
			}
			objSemaphore.Take();
			Thread.yield(); 
		}
	}

	public void smokerWaitingForItem(String itemWithUser, String smoker) {
		boolean smokerRecivedItem = false;

		//Print what smoker is waiting for what item
		if(item1 != null || item2 != null)
			System.out.println(smoker + " is waiting " + item1 +" and " + item2 +".");
		else
			System.out.println(smoker + " is waiting for the missing items.");

		while (!smokerRecivedItem) {
			objSemaphore.Release();
			if (statusOfTable == 1 && (item1 != itemWithUser && item2 != itemWithUser)) {
				statusOfTable = 2;
				smokerRecivedItem = true;
			}
			objSemaphore.Take();
			Thread.yield();
		}

		//Print what items recived by what smoker
		if(item1 != null || item2 != null)
			System.out.println(smoker + " recived " + item1 +" and " + item2 +" and starts smoking.");
		else
			System.out.println(smoker + " recived the missing items and strats smoking.");
	}

	public void smokerFinishedSmoking(String smoker) {
		//Print if the smoker finished smoking 
		System.out.println(smoker + " stubs out.");
		objSemaphore.Release();
		statusOfTable = 3;
		objSemaphore.Take();
	}

	public static void main(String[] args) {
		Assignment2 objAssignemnt2 = new Assignment2();
	}
}