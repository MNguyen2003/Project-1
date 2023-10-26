package test;


public class aOrderedList {
	private static final int SIZEINCREMENTS = 20;
	private Car[] oList;
	private int listSize;
	private int numObjects;

	public aOrderedList() {
		numObjects = 0;
		listSize = SIZEINCREMENTS;
		oList = new Car[listSize];
	}

	public void add(Car newCar) {
	    if (numObjects >= listSize) {
	        listSize += SIZEINCREMENTS;
	        Car[] newList = new Car[listSize];
	        System.arraycopy(oList, 0, newList, 0, numObjects);
	        oList = newList;
	    }

	    
	    int index = 0;
	    while (index < numObjects && newCar.compareTo(oList[index]) > 0) {
	        index++;
	    }

	    
	    for (int i = numObjects; i > index; i--) {
	        oList[i] = oList[i - 1];
	    }

	    oList[index] = newCar;
	    numObjects++;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("[");
		for (int i = 0; i<numObjects; i++) {
			result.append(oList[i].toString());
			if (i < numObjects - 1) {
				result.append(", ");
			}
		}
		result.append("]");
		return result.toString();
	}

	public static int size() {
		// TODO Auto-generated method stub
		return aOrderedList.size();
	}

	public Car get(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}