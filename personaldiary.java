import java.util.*;
class DiaryPersonalEntry 
{
    String personalDate;
	String mood, personalContent;
    List<String> personalTasks;

	// Constructor to initialize a personal diary entry
    DiaryPersonalEntry(String personalDate, String mood, String personalContent) 
	{
        this.personalDate = personalDate;
        this.mood = mood;
        this.personalContent = personalContent;
        this.personalTasks = new ArrayList<>();
    }

	// Method to add a personal task to the entry
    void addpersonalTasks(String personalTask) 
	{
        personalTasks.add(personalTask);
    }

	// Method to mark a personal task as completed
    void completePersonalTask(String personalTask) 
	{
        if (personalTasks.remove(personalTask)) 
            System.out.println("\nPersonal task marked as completed: " + personalTask);
		else
            System.out.println("\nPersonal task not found.");
    }
	
	// Method to display the remaining personal tasks
    void displayRemainingPersonalTasks() 
	{
        if (personalTasks.isEmpty()) 
            System.out.println("\nNo remaining personal tasks.");
        else 
		{
			System.out.println("\n========================================");
            System.out.println("Remaining Personal Tasks: " + personalTasks);	
			System.out.println("========================================");			
			
        }
    }
	
	// Method to display the entire personal diary entry
    void displayPersonalEntry() 
	{
		System.out.println("\n==============================");
        System.out.println("        PERSONAL ENTRIES");
        System.out.println("==============================");
        System.out.println("Date: " + personalDate);
        System.out.println("Mood: " + mood);
        System.out.println("Content: " + personalContent);
        System.out.println("Tasks: " + personalTasks);
		System.out.println("==============================");
    }	
}

class DiaryHealthEntry
{
	String healthDate;
	String bp, diabetes;
    int steps;
	List<String> healthTasks;
	
	// Constructor to initialize a health diary entry
	DiaryHealthEntry(String healthDate, String bp, String diabetes, int steps)
	{
        this.healthDate = healthDate;
        this.bp = bp;
        this.diabetes = diabetes;
        this.steps = steps;
        this.healthTasks = new ArrayList<>();
    } 
	
	// Method to add a health task to the entry
    void addhealthTasks(String healthTask) 
	{
        healthTasks.add(healthTask);
    }
	
	// Method to mark a health task as completed
    void completeHealthTask(String healthTask) 
	{
        if (healthTasks.remove(healthTask)) 
            System.out.println("\nHealth task marked as completed: " + healthTask);
		else
            System.out.println("\nHealth task not found.");
    }
	
	// Method to display the remaining health tasks
    void displayRemainingHealthTasks() 
	{
        if (healthTasks.isEmpty()) 
            System.out.println("\nNo remaining health tasks.");
        else 
		{
			System.out.println("\n=========================================");
            System.out.println("Remaining Health Tasks: " + healthTasks);
			System.out.println("=========================================");
			
        }
    }
	
	// Method to display the entire health diary entry
	void displayHealthEntry() 
	{
		System.out.println("\n==============================");
        System.out.println("        HEALTH ENTRIES");
        System.out.println("==============================");
        System.out.println("Date: " + healthDate);
        System.out.println("BP: " + bp);
        System.out.println("Diabetes: " + diabetes);
        System.out.println("Steps Count: " + steps);
        System.out.println("Tasks: " + healthTasks);
		System.out.println("==============================");
    } 
}

class DiaryWorkEntry
{
	String workDate;
	String workContent;
	List<String> workTasks;
	
    // Constructor to initialize a work diary entry
	DiaryWorkEntry(String workDate, String workContent) 
	{
        this.workDate = workDate;
        this.workContent = workContent;
        this.workTasks = new ArrayList<>();
    }
	
    // Method to add a work task to the entry
    void addworkTasks(String workTask) 
	{
        workTasks.add(workTask);
    }
	
    // Method to mark a work task as completed
    void completeWorkTask(String workTask) 
	{
        if (workTasks.remove(workTask)) 
            System.out.println("\nWork task marked as completed: " + workTask);
		else
            System.out.println("\nWork task not found.");
    }
	
    // Method to display the remaining work tasks
    void displayRemainingWorkTasks() 
	{
        if (workTasks.isEmpty()) 
            System.out.println("\nNo remaining work tasks.");
        else 
		{
			System.out.println("\n========================================");
            System.out.println("Remaining Work Tasks: " + workTasks);
			System.out.println("========================================");
			
        }
    }
	
    // Method to display the entire work diary entry
	void displayWorkEntry() 
	{
		System.out.println("\n==============================");
        System.out.println("        WORK ENTRIES");
        System.out.println("==============================");
		System.out.println("Date: " + workDate);
        System.out.println("Work Content: " + workContent);
		System.out.println("Tasks: " + workTasks);
		System.out.println("==============================");
    }
}

class Diary 
{
    List<DiaryPersonalEntry> personalEntries;
    List<DiaryHealthEntry> healthEntries;
    List<DiaryWorkEntry> workEntries;
    String password;
	Scanner sc = new Scanner(System.in);
	
    // Constructor to initialize the Diary object
    Diary(String password) 
	{
        this.personalEntries = new ArrayList<>();
        this.healthEntries = new ArrayList<>();
        this.workEntries = new ArrayList<>();
        this.password = password;
    }

    // Method to check if the entered password matches the diary's password
    boolean checkPassword(String inputPassword) 
	{
        return this.password.equals(inputPassword);
    }

    // Method to get a valid date from the user (yyyy-MM-dd format)
	String getValidDate()
	{
		while(true)
		{
			System.out.print("\nEnter date (yyyy-MM-dd): ");
			String date = sc.nextLine();
			if (date.length() != 10 && date.charAt(4) != '-' && date.charAt(7) != '-' && 
			!Character.isDigit(date.charAt(0)) &&
			!Character.isDigit(date.charAt(1)) &&
			!Character.isDigit(date.charAt(2)) &&
			!Character.isDigit(date.charAt(3)) &&
			!Character.isDigit(date.charAt(5)) &&
			!Character.isDigit(date.charAt(6)) &&
			!Character.isDigit(date.charAt(8)) &&
			!Character.isDigit(date.charAt(9)) )
			{
				System.out.println("\nInvalid date format. Please enter the date in yyyy-MM-dd format.");
				continue;
			}
			
			String[] parts = date.split("-");
			int year = Integer.parseInt(parts[0]);
			int month = Integer.parseInt(parts[1]);
			int day = Integer.parseInt(parts[2]);

			// Check valid month (1-12)
			if (month < 1 || month > 12) 
			{
				System.out.println("\nInvalid month.");
				continue;
			}

			// Days per month (index 0 is unused)
			int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

			// Check leap year for February
			if (month == 2 && isLeapYear(year))
			{
				daysInMonth[2] = 29;
			}

			// Validate day in the given month
			if(day >= 1 && day <= daysInMonth[month])
			{
				return date;
			}
			else
			{
				System.out.println("\nInvalid date.");
				continue;
			}
		}
	}
	
	boolean isLeapYear(int year)
	{
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
	
    // Method to get a mood from the user from a predefined list
	String getMoodFromUser() 
	{
        String[] moods = {"Happy", "Sad", "Excited", "Angry", "Calm", "Anxious", "Neutral"};
        while (true) 
		{
            System.out.println("\nSelect a mood:");
            for (int i = 0; i < moods.length; i++)
			{
                System.out.println((i + 1) + ". " + moods[i]);
            }
			int input;
			while(true)
			{
				System.out.print("\nEnter choice (1-" + moods.length + "): ");
				String choice=sc.nextLine();
				if(!choice.matches("\\d+"))
				{
					System.out.println("Enter valid numeric choice number");
					continue;
				}
				input = Integer.parseInt(choice);
				break;
			}
            
            boolean isValid = false;
            if((input>=1)&&(input<=moods.length))
			{
				isValid=true;
			}
            if (isValid) 
			{
                return moods[input - 1];
            }
			else
				System.out.println("Invalid selection. Please choose a number from the list.");
        }
    }
	
    // Method to add a new diary entry (personal, health, or work)
    void addEntry() 
	{
		int choice;
		while(true)
		{
			System.out.println("\nSelect category: 1. Personal  2. Health  3. Work");
			String tempChoice=sc.nextLine();
			if(!tempChoice.matches("\\d+"))
			{
				System.out.println("Enter valid numeric choice number");
				continue;
			}
			choice = Integer.parseInt(tempChoice);
			break;
		}
		
		switch(choice)
		{
			case 1:String personalDate= getValidDate();
				String mood = getMoodFromUser();
				System.out.print("\nEnter personal content: ");
				String personalContent = sc.nextLine();
				DiaryPersonalEntry personalEntry = new DiaryPersonalEntry(personalDate, mood, personalContent);
				personalEntries.add(personalEntry);
				break;
			case 2:String healthDate= getValidDate();
				System.out.print("\nEnter bp: ");
				String bp = sc.nextLine();
				System.out.print("\nEnter Diabetes Level: ");
				String diabetes = sc.nextLine();
				int steps;
				while(true)
				{
					System.out.print("\nEnter Steps Count: ");
					String tempSteps = sc.nextLine();
					if(!tempSteps.matches("\\d+"))
					{
						System.out.println("Enter valid numeric steps number");
						continue;
					}
					steps = Integer.parseInt(tempSteps);
					break;
				}
				DiaryHealthEntry healthEntry = new DiaryHealthEntry(healthDate, bp, diabetes, steps);
				healthEntries.add(healthEntry);
				break;
			case 3:String workDate= getValidDate();
				System.out.print("\nEnter Work Content: ");
				String workContent = sc.nextLine();
				DiaryWorkEntry workEntry = new DiaryWorkEntry(workDate, workContent);
				workEntries.add(workEntry);
				break;
			default:System.out.println("Invalid option. Please enter a number between 1 and 3..");
		}
        System.out.println("\nEntry added successfully!");
    }

    // Method to display diary entries (personal, health, or work)
    void displayEntries() 
	{
		int choice;
		while(true)
		{
			System.out.println("\nSelect category: 1. Personal  2. Health  3. Work");
			String tempChoice=sc.nextLine();
			if(!tempChoice.matches("\\d+"))
			{
				System.out.println("Enter valid numeric choice number");
				continue;
			}
			choice = Integer.parseInt(tempChoice);
			break;
		}
			
		switch(choice)
		{
			case 1: if (personalEntries.isEmpty()) 
					System.out.println("\nNo entries found.");
				else
				{
					for (DiaryPersonalEntry entry : personalEntries)
					{
						entry.displayPersonalEntry();
					}
				}
				break;
			case 2: if (healthEntries.isEmpty()) 
					System.out.println("\nNo entries found.");
				else
				{
					for (DiaryHealthEntry entry : healthEntries)
					{
						entry.displayHealthEntry();
					}
				}
				break;
			case 3: if (workEntries.isEmpty()) 
					System.out.println("\nNo entries found.");
				else
				{
					for (DiaryWorkEntry entry : workEntries)
					{
						entry.displayWorkEntry();
					}
				}
				break;
			default:System.out.println("Invalid option. Please enter a number between 1 and 3..");
        }
    }

    // Method to search entries by date
    void searchEntriesByDate() 
	{     
		int choice;
		while(true)
		{
			System.out.println("\nSelect category: 1. Personal  2. Health  3. Work");
			String tempChoice=sc.nextLine();
			if(!tempChoice.matches("\\d+"))
			{
				System.out.println("Enter valid numeric choice number");
				continue;
			}
			choice = Integer.parseInt(tempChoice);
			break;
		}
		
		switch(choice)
		{
			case 1:if (personalEntries.isEmpty()) 
					System.out.println("\nNo entries found.");
				else
				{
					String personalDate0 = getValidDate();
					boolean b = true;
					for (DiaryPersonalEntry entry : personalEntries) 
					{
						if (entry.personalDate.equals(personalDate0)) 
						{
							entry.displayPersonalEntry();
							b = false;
						}
					}
					if (b) 
						System.out.println("\nNo entries found for this date."); 
				}
				break;
			case 2:if (healthEntries.isEmpty()) 
					System.out.println("\nNo entries found.");
				else
				{
					String healthDate0 = getValidDate();
					boolean b = true;
					for (DiaryHealthEntry entry : healthEntries) 
					{
						if (entry.healthDate.equals(healthDate0)) 
						{
							entry.displayHealthEntry();
							b = false;
						}
					}
					if (b) 
						System.out.println("\nNo entries found for this date."); 
				}
				break;
			case 3:if (workEntries.isEmpty()) 
					System.out.println("\nNo entries found.");
				else
				{
					String workDate0 = getValidDate();
					boolean b = true;
					for (DiaryWorkEntry entry : workEntries) 
					{
						if (entry.workDate.equals(workDate0)) 
						{
							entry.displayWorkEntry();
							b = false;
						}
					}
					if (b) 
						System.out.println("\nNo entries found for this date."); 
				}
				break;
			default:System.out.println("Invalid option. Please enter a number between 1 and 3..");
		}
    }
	
	// Method to edit an existing diary entry
	void editEntry()
	{	   
		int choice;
		while(true)
		{
			System.out.println("\nSelect category: 1. Personal  2. Health  3. Work");
			String tempChoice=sc.nextLine();
			if(!tempChoice.matches("\\d+"))
			{
				System.out.println("Enter valid numeric choice number");
				continue;
			}
			choice = Integer.parseInt(tempChoice);
			break;
		}
		
		switch(choice)
		{
			case 1:if (personalEntries.isEmpty()) 
					System.out.println("\nNo entries found.");
				else
				{
					String personalDate0 = getValidDate();
					boolean b = true;
					for (DiaryPersonalEntry entry : personalEntries) 
					{
						if (entry.personalDate.equals(personalDate0)) 
						{
							entry.mood = getMoodFromUser();
							sc.nextLine();
							System.out.print("\nEnter new content: ");
							entry.personalContent = sc.nextLine();
							System.out.println("\nEntry updated successfully!");
							b = false;
						}
					}
					if (b) 
						System.out.println("\nNo entries found for this date."); 
				}
				break;
			case 2:if (healthEntries.isEmpty()) 
					System.out.println("\nNo entries found.");
				else
				{
					String healthDate0 = getValidDate();
					boolean b = true;
					for (DiaryHealthEntry entry : healthEntries) 
					{
						if (entry.healthDate.equals(healthDate0)) 
						{
							System.out.print("\nEnter bp: ");
							entry.bp = sc.nextLine();
							System.out.print("\nEnter Diabetes Level: ");
							entry.diabetes = sc.nextLine();
							int steps;
							while(true)
							{
								System.out.print("\nEnter Steps Count: ");
								String tempSteps = sc.nextLine();
								if(!tempSteps.matches("\\d+"))
								{
									System.out.println("Enter valid numeric steps number");
									continue;
								}
								steps = Integer.parseInt(tempSteps);
								break;
							}
							System.out.println("\nEntry updated successfully!");
							b = false;
						}
					}
					if (b) 
						System.out.println("\nNo entries found for this date."); 
				}
				break;
			case 3:if (workEntries.isEmpty()) 
					System.out.println("\nNo entries found.");
				else
				{
					String workDate0 = getValidDate();
					boolean b = true;
					for (DiaryWorkEntry entry : workEntries) 
					{
						if (entry.workDate.equals(workDate0)) 
						{
							System.out.print("\nEnter Work Content: ");
							entry.workContent = sc.nextLine();
							System.out.println("\nEntry updated successfully!");
							b = false;
						}
					}
					if (b) 
						System.out.println("\nNo entries found for this date."); 
				}
				break;
			default:System.out.println("Invalid option. Please enter a number between 1 and 3..");
        }
    }

	// Method to edit an existing diary entry
    void displayMoodTracker() 
	{
        if (personalEntries.isEmpty()) 
		{
            System.out.println("\nNo entries available for mood tracking.");
            return;
        }
        System.out.println("\nMood Tracker:");
        for (DiaryPersonalEntry entry : personalEntries) 
		{
            System.out.println("\nDate: " + entry.personalDate+ " - Mood: " + entry.mood);
        }
    }
	
	// Method to add a task to an entry (personal, health, or work)
	void addTaskToEntry()
	{
		sc.nextLine();
		int choice;
		while(true)
		{
			System.out.println("\nSelect category: 1. Personal  2. Health  3. Work");
			String tempChoice=sc.nextLine();
			if(!tempChoice.matches("\\d+"))
			{
				System.out.println("Enter valid numeric choice number");
				continue;
			}
			choice = Integer.parseInt(tempChoice);
			break;
		}
		switch(choice)
		{
			case 1:String personalDate0 = getValidDate();
				for (DiaryPersonalEntry entry : personalEntries) 
				{
					if (entry.personalDate.equals(personalDate0)) 
					{
						System.out.print("\nEnter personal task: ");
						String personalTask = sc.nextLine();
						entry.addpersonalTasks(personalTask);
						System.out.println("\nPersonal task added successfully!");
						return;
					}
				}
				System.out.println("\nNo existing entry found for the given date. Creating a new personal task list.");
				DiaryPersonalEntry newPersonalEntry = new DiaryPersonalEntry(personalDate0, "", "");
				personalEntries.add(newPersonalEntry);
				System.out.print("\nEnter personal task: ");
				String personalTask= sc.nextLine();
				newPersonalEntry.addpersonalTasks(personalTask);
				System.out.println("\nNew personal task added!");
				break;
			case 2:String healthDate0 = getValidDate();
				for (DiaryHealthEntry entry : healthEntries) 
				{
					if (entry.healthDate.equals(healthDate0)) 
					{
						System.out.print("\nEnter health task: ");
						String healthTask = sc.nextLine();
						entry.addhealthTasks(healthTask);
						System.out.println("\nhealth task added successfully!");
						return;
					}
				}
				System.out.println("\nNo existing entry found for the given date. Creating a new personal task list.");
				DiaryHealthEntry newHealthEntry = new DiaryHealthEntry(healthDate0, "", "",0);
				healthEntries.add(newHealthEntry);
				System.out.print("\nEnter health task: ");
				String healthTask= sc.nextLine();
				newHealthEntry.addhealthTasks(healthTask);
				System.out.println("\nNew health task added!");
				break;
			case 3:String workDate0 = getValidDate();
				for (DiaryWorkEntry entry : workEntries) 
				{
					if (entry.workDate.equals(workDate0)) 
					{
						System.out.print("\nEnter work task: ");
						String workTask = sc.nextLine();
						entry.addworkTasks(workTask);
						System.out.println("\nwork task added successfully!");
						return;
					}
				}
				System.out.println("\nNo existing entry found for the given date. Creating a new personal task list.");
				DiaryWorkEntry newWorkEntry = new DiaryWorkEntry(workDate0, "");
				workEntries.add(newWorkEntry);
				System.out.print("\nEnter work task: ");
				String workTask= sc.nextLine();
				newWorkEntry.addworkTasks(workTask);
				System.out.println("\nNew work task added!");
				break;
			default:System.out.println("Invalid option. Please enter a number between 1 and 3..");
		}
    }

	// Method to mark a task as completed (personal, health, or work)
    void completeTask() 
	{
		int choice;
		while(true)
		{
			System.out.println("\nSelect category: 1. Personal  2. Health  3. Work");
			String tempChoice=sc.nextLine();
			if(!tempChoice.matches("\\d+"))
			{
				System.out.println("Enter valid numeric choice number");
				continue;
			}
			choice = Integer.parseInt(tempChoice);
			break;
		}
		
		switch(choice)
		{
			case 1:System.out.print("\nEnter date of entry to mark personal task as completed: ");
				String personalDate0= sc.nextLine();
				for (DiaryPersonalEntry entry : personalEntries) 
				{
					if (entry.personalDate.equals(personalDate0)) 
					{
						System.out.print("\nEnter personal task to mark as completed: ");
						String personalTask = sc.nextLine();
						entry.completePersonalTask(personalTask);
						return;
					}
				}
				System.out.println("\nNo entry found for the given date.");
				break;
			case 2:System.out.print("\nEnter date of entry to mark health task as completed: ");
				String healthDate0= sc.nextLine();
				for (DiaryHealthEntry entry : healthEntries) 
				{
					if (entry.healthDate.equals(healthDate0)) 
					{
						System.out.print("\nEnter health task to mark as completed: ");
						String healthTask = sc.nextLine();
						entry.completeHealthTask(healthTask);
						return;
					}
				}
				System.out.println("\nNo entry found for the given date."); 
				break;
			case 3:System.out.print("\nEnter date of entry to mark work task as completed: ");
				String workDate0= sc.nextLine();
				for (DiaryWorkEntry entry : workEntries) 
				{
					if (entry.workDate.equals(workDate0)) 
					{
						System.out.print("\nEnter work task to mark as completed: ");
						String workTask = sc.nextLine();
						entry.completeWorkTask(workTask);
						return;
					}
				}
				System.out.println("\nNo entry found for the given date.");
				break;
			default:System.out.println("Invalid option. Please enter a number between 1 and 3..");
		}
    }

	// Method to display remaining tasks (personal, health, or work)
    void displayRemainingTasks() 
	{
		int choice;
		while(true)
		{
			System.out.println("\nSelect category: 1. Personal  2. Health  3. Work");
			String tempChoice=sc.nextLine();
			if(!tempChoice.matches("\\d+"))
			{
				System.out.println("Enter valid numeric choice number");
				continue;
			}
			choice = Integer.parseInt(tempChoice);
			break;
		}
			
		switch(choice)
		{
			case 1:System.out.print("\nEnter date of entry to display remaining personal tasks: ");
				String personalDate0= sc.nextLine();
				for (DiaryPersonalEntry entry : personalEntries) 
				{
					if (entry.personalDate.equals(personalDate0)) 
					{
						entry.displayRemainingPersonalTasks();
						return;
					}
				}
				System.out.println("\nNo entry found for the given date.");
				break;
			case 2:System.out.print("\nEnter date of entry to display remaining health tasks: ");
				String healthDate0 = sc.nextLine();
				for (DiaryHealthEntry entry : healthEntries) 
				{
					if (entry.healthDate.equals(healthDate0)) 
					{
						entry.displayRemainingHealthTasks();
						return;
					}
				}
				System.out.println("\nNo entry found for the given date.");
				break;
			case 3:System.out.print("\nEnter date of entry to display remaining work tasks: ");
				String workDate0 = sc.nextLine();
				for (DiaryWorkEntry entry : workEntries) 
				{
					if (entry.workDate.equals(workDate0)) 
					{
						entry.displayRemainingWorkTasks();
						return;
					}
				}
				System.out.println("\nNo entry found for the given date.");
				break;
			default:System.out.println("Invalid option. Please enter a number between 1 and 3..");
		}
    }
	
}

class Main
{
    public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
        String password;
		
		System.out.print("Enter your name :");
		String diaryOwner = sc.nextLine(); // Get the diary owner's name
		
			System.out.println("\n=================================================================");
			System.out.println("==================== "+diaryOwner.toUpperCase()+"'s PERSONAL DIARY ====================");
			System.out.println("=================================================================");
        // Password setting loop with validation
		while(true)
		{
			System.out.println("\nSet a password for your diary:");
			System.out.println("\nThe password must meet these criteria:");
			System.out.println("-At least 8 characters long");
			System.out.println("-Contains at least one digit");
			System.out.println("-Contains at least one special character (@#$%^*&+=!)");
			System.out.print("\nEnter Password : ");
			String tempPassword = sc.nextLine();
			char passwordArr[] = tempPassword.toCharArray(); //Convert password to character array
			boolean hasDigit = false; // Flag to check for digit
			boolean hasSpecial = false; // Flag to check for special character
			
			// Check if password has digit and special character
			for(char ch : passwordArr)
			{
				if(Character.isDigit(ch))
				{
					hasDigit = true;
				}
				if((ch=='!')||(ch=='@')||(ch=='#')||(ch=='$')||(ch=='%')||(ch=='^')||(ch=='&')||(ch=='*')||(ch=='+')||(ch=='='))
				{
					hasSpecial = true;
				}
			}
			
			// Check if password meets all criteria
			if((tempPassword.length()==8)&&(hasDigit)&&(hasSpecial))
			{
				password = tempPassword;
				break;
			}
			else
				System.out.println("\nInvalid password! Please follow criteria.");
		}
        Diary diary = new Diary(password); // Create a new Diary object with the set password
		
        System.out.println("\nDiary created successfully!");
		
		boolean b=true; // Flag for main diary loop
        while (b) 
		{
            System.out.print("\nEnter your diary password: ");
            String inputPassword = sc.nextLine(); // Get password input from the user

            if (diary.checkPassword(inputPassword)) // Check if the entered password is correct
			{
                System.out.println("\nAccess granted!");
				boolean b2=true; // Flag for inner diary menu loop
				while (b2) 
				{	// Display the diary menu
					System.out.println("\n============================== Diary Menu ==============================");
					System.out.println("\n1. Add a new entry - Enter date, mood, bp, diabetes, steps and content to create a new note.");
					System.out.println("2. View all diary entries - Display all saved diary notes with details.");
					System.out.println("3. Search for an entry by date - Find and view a specific diary note using date.");
					System.out.println("4. Edit an existing entry - Edit mood and content by date.");
					System.out.println("5. Add a task to an existing entry - Attach a to-do item to a diary note.");
					System.out.println("6. Mark a task as completed - Mark an attached task as done.");
					System.out.println("7. View remaining tasks - Display unfinished tasks in a diary note.");
					System.out.println("8.  View mood tracker - Show a summary of moods recorded in diary entries.");
					System.out.println("9. Logout - Close the diary application.");
					int choice;
					
					// Input validation loop for menu choice
					while(true)
					{
					System.out.print("Choose an option: ");
						String tempChoice=sc.nextLine();
						if(!tempChoice.matches("\\d+"))
						{
							System.out.println("Enter valid numeric choice number");
							continue;
						}
						choice = Integer.parseInt(tempChoice);
						break;
					}
					
					// Switch case for menu options
					switch (choice)
					{
						case 1:
							diary.addEntry();break;
						case 2:
							diary.displayEntries();break;
						case 3:
							diary.searchEntriesByDate();break;
						case 4:
							diary.editEntry();break;
						case 5:
							diary.addTaskToEntry();break;
						case 6:
							diary.completeTask();break;
						case 7:
							diary.displayRemainingTasks();break;
						case 8:
							diary.displayMoodTracker();break;
						case 9:
							System.out.println("Logging out... Goodbye!");b2=false;break;
						default:
							System.out.println("Invalid option. Please enter a number between 1 and 11..");
					}
					b=false;
				}
            } 
			else 
                System.out.println("Incorrect password. Try again.");
        }
    }
}