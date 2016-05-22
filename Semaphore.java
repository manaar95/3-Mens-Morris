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

public class Semaphore {

    private int value = 0;

    public Semaphore(int value) {
		this.value = value;
    }

    public synchronized void Release() {//If the value is less than 0 then thread waits till it is less than 0
		while (value <= 0) {
		    try {
				wait();
		    }catch (InterruptedException e) {
		    }
		}

		value--;
    }

    public synchronized void Take() {//Increments value by one than it notifys the function that called it
		value++;
		notify();
    }
}