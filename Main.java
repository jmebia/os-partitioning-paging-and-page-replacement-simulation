import java.util.*;

public class Main {
	
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
	
		// main program loop
		while(true) {
			System.out.print("Choose operation: \n"+
				"[1] Size Partitioning \n"+
				"[2] Page Replacement \n"+
				"Choice: ");
				
			switch( in.nextInt() ) {
				
				case 1: partitioning();	
					break;
				case 2: replacement();
					break;
				default: System.out.println("Terminating program");
					System.exit(0);
					
			}	
		}	
	}
	
	/**-------------------- PARTITIONING ---------------------**/
	// method that simulates memory partioning
	private static void partitioning() {
		
		System.out.print("______               _    _  _    _                _               "+
		+"| ___ \             | |  (_)| |  (_)              (_)              "+
		+"| |_/ /  __ _  _ __ | |_  _ | |_  _   ___   _ __   _  _ __    __ _ "+
		+"|  __/  / _` || '__|| __|| || __|| | / _ \ | '_ \ | || '_ \  / _` |"+
		+"| |    | (_| || |   | |_ | || |_ | || (_) || | | || || | | || (_| |"+
		+"\_|     \__,_||_|    \__||_| \__||_| \___/ |_| |_||_||_| |_| \__, |"+
		+"                                                              __/ |"+
		+"                                                             |___/"
		);
		
		// declare variables
		int[] memories;
		int[] partitions;
		int[] allocatedMemory;
		
		int countMemory = 0;
		int countPartition = 0;
		
		int internalFragmentation = 0;
		int externalFragmentation = 0;
		
		System.out.print("Enter partition count: ");
		countPartition = in.nextInt();
		
		System.out.print("Enter memory count: ");
		countMemory = in.nextInt();
		
		// 
		memories = new int[countMemory];
		partitions = new int[countPartition];
		allocatedMemory = new int[countPartition];
		
		// get memory sizes
		for(int i = 0; i < memories.length; i++) {
			System.out.print("Memory #" + i + " : ");
			memories[i] = in.nextInt();
		}
		
		// get partition sizes
		for(int i = 0; i < memories.length; i++) {
			System.out.print("Partition #" + i + " : ");
			partitions[i] = in.nextInt();
		}
		
		// set allocated memories
		for(int i = 0; i < memories.length; i++) {
			allocatedMemory[i] = 0;
		}
			
		System.out.println("Performing FIRST FIT partitioning algorithm...");
	
		// perform First Fit algorithm
		// iterates over every memory size in the array
		for(int i = 0; i < memories.length; i++) {
			
			// iterates over the partitions
			for(int j = 0; j < partitions.length; j++) {
				
				// checks whether the current memory fits the first partition it encounters
				if( allocatedMemory[j] == 0 && memories[i] <= partitions[j]) {
					
					// allocate the memory to the partition location
					allocatedMemory[j] = memories[i];
					memories[i] = -1;
					break;
					
				} 	
			}
		}
		
		// print final out put for first fit
		System.out.println("First Fit");
		for(int i = 0; i < partitions.length; i++) {
			System.out.print("[ " + allocatedMemory[i] + "kb ]");
		}
		
		// computes for and displays the internal fragmentation value
		for(int i = 0; i < partitions.length; i++) {
			internalFragmentation += partitions[i] - allocatedMemory[i];
		}
		
		// check whether to perform external fragmentation or not
		for(int i = 0; i < memories.length; i++) {
			// perform 
			if (memories[i] > -1) {
				for(int j = 0; j < partitions.length; j++) {
					externalFragmentation += (allocatedMemory[j] == 0? partitions[j] : 0);	
				}
				break;
			}
		}
		
		
		System.out.println("\nInternal Fragmentation = " + internalFragmentation + "kb");
		System.out.println("External Fragmentation = " + (externalFragmentation == 0? "none" : externalFragmentation + "kb\n\n"));
		
	}
	
	/**-------------------- PAGE REPLACEMENT---------------------**/
	// method that simulates page replacement
	private static void replacement() {
		
		
			
	}
	
	/**-- PAGING 
	// method that simulates paging
	private static void paging() {
		
		
			
	} ----**/
	
}
