import java.io.IOException;

public class Print {

		
		 
		public static void printHand() {
		   System.err.printf(" _   _                 _ \n"
		    + "| | | |               | |\n"
		    + "| |_| | __ _ _ __   __| |\n"
		    + "|  _  |/ _` | '_ \\ / _` |\n"
		    + "| | | | (_| | | | | (_| |\n"
		    + "\\_| |_/\\__,_|_| |_|\\__,_|\n");


		 }

		public static void bustprint() {
		  System.err.printf("______           _   _ _ _ _ \n"
		    + "| ___ \\         | | | | | | |\n"
		    + "| |_/ /_   _ ___| |_| | | | |\n"
		    + "| ___ \\ | | / __| __| | | | |\n"
		    + "| |_/ / |_| \\__ \\ |_|_|_|_|_|\n"
		    + "\\____/ \\__,_|___/\\__(_|_|_|_)\n");

		 }

		public static void dividers() {
		  System.out.printf("***********************************************************************************\n");

		 }

		public static void printSum() {
		   System.err.printf(" _____                 \n"
		    + "/  ___|                \n"
		    +"\\ `--. _   _ _ __ ___  \n"
		    + " `--. \\ | | | '_ ` _ \\ \n"
		    + "/\\__/ / |_| | | | | | |\n"
		    + "\\____/ \\__,_|_| |_| |_|\n");

		 }

		public static void printdealerHand() {
		  System.err.printf("______           _             _   _                 _ \n"
		    + "|  _  \\         | |           | | | |               | |\n"
		    + "| | | |___  __ _| | ___ _ __  | |_| | __ _ _ __   __| |\n"
		    + "| | | / _ \\/ _` | |/ _ \\ '__| |  _  |/ _` | '_ \\ / _` |\n"
		    + "| |/ /  __/ (_| | |  __/ |    | | | | (_| | | | | (_| |\n"
		    + "|___/ \\___|\\__,_|_|\\___|_|    \\_| |_/\\__,_|_| |_|\\__,_|\n");

		 }

		public static void printWiningscore(int cARDGAMENUM) {
		  System.out.printf(" _    _ _             _               _   _                 _ \n"
		    + "| |  | (_)           (_)             | | | |               | |\n"
		    + "| |  | |_ _ __  _ __  _ _ __   __ _  | |_| | __ _ _ __   __| |\n"
		    + "| |/\\| | | '_ \\| '_ \\| | '_ \\ / _` | |  _  |/ _` | '_ \\ / _` |\n"
		    + "\\  /\\  / | | | | | | | | | | | (_| | | | | | (_| | | | | (_| |\n"
		    + " \\/  \\/|_|_| |_|_| |_|_|_| |_|\\__, | \\_| |_/\\__,_|_| |_|\\__,_|\n"
		    + "                               __/ |                          \n"
		    + "                              |___/                           \n");
		  dividers();
		  NumberPrinter(cARDGAMENUM);
		  dividers();
		 }

		public static void NumberPrinter(int cARDGAMENUM) {
		  /////////////////////////////////////////////////////////////////////////////
		  int countStart = 1;
		  int lines = 6;
		  for(int i = 0; i < lines; i++) {
		   System.out.printf("");
		   if(String.valueOf(cARDGAMENUM).startsWith("1")) {
		    if(countStart == 1) {
		     System.out.printf("  __ ");
		    }
		    if(countStart == 2) {
		     System.out.printf(" /_ |");
		    }
		    if(countStart == 3) {
		     System.out.printf("  | |");
		    }
		    if(countStart == 4) {
		     System.out.printf("  | |");
		    }
		    if(countStart == 5) {
		     System.out.printf("  | |");
		    }
		    if(countStart == 6) {
		     System.out.printf("  |_|");
		    }
		   }
		   if(String.valueOf(cARDGAMENUM).startsWith("2")) {
		    if(countStart == 1) {
		     System.out.printf("  ___  ");
		    }
		    if(countStart == 2) {
		     System.out.printf(" |__ \\ ");
		    }
		    if(countStart == 3) {
		     System.out.printf("    ) |");
		    }
		    if(countStart == 4) {
		     System.out.printf("   / / ");
		    }
		    if(countStart == 5) {
		     System.out.printf("  / /_ ");
		    }
		    if(countStart == 6) {
		     System.out.printf(" |____|");
		    }
		   }
		   if(String.valueOf(cARDGAMENUM).startsWith("3")) {
		    if(countStart == 1) {
		     System.out.printf("  ____  ");
		    }
		    if(countStart == 2) {
		     System.out.printf(" |___ \\ ");
		    }
		    if(countStart == 3) {
		     System.out.printf("   __) |");
		    }
		    if(countStart == 4) {
		     System.out.printf("  |__ < ");
		    }
		    if(countStart == 5) {
		     System.out.printf("  ___) |");
		    }
		    if(countStart == 6) {
		     System.out.printf(" |____/ ");
		    }
		   }
		   if(String.valueOf(cARDGAMENUM).startsWith("4")) {
		    if(countStart == 1) {
		     System.out.printf("  _  _   ");
		    }
		    if(countStart == 2) {
		     System.out.printf(" | || |  ");
		    }
		    if(countStart == 3) {
		     System.out.printf(" | || |_ ");
		    }
		    if(countStart == 4) {
		     System.out.printf(" |__   _|");
		    }
		    if(countStart == 5) {
		     System.out.printf("    | |  ");
		    }
		    if(countStart == 6) {
		     System.out.printf("    |_|  ");
		    }
		   }
		   if(String.valueOf(cARDGAMENUM).startsWith("5")) {
		    if(countStart == 1) {
		     System.out.printf("  _____ ");
		    }
		    if(countStart == 2) {
		     System.out.printf(" | ____|");
		    }
		    if(countStart == 3) {
		     System.out.printf(" | |__  ");
		    }
		    if(countStart == 4) {
		     System.out.printf(" |___ \\ ");
		    }
		    if(countStart == 5) {
		     System.out.printf("  ___) |");
		    }
		    if(countStart == 6) {
		     System.out.printf(" |____/ ");
		    }
		   }
		   if(String.valueOf(cARDGAMENUM).startsWith("6")) {
		    if(countStart == 1) {
		     System.out.printf("    __  ");
		    }
		    if(countStart == 2) {
		     System.out.printf("   / /  ");
		    }
		    if(countStart == 3) {
		     System.out.printf("  / /_  ");
		    }
		    if(countStart == 4) {
		     System.out.printf(" | '_ \\ ");
		    }
		    if(countStart == 5) {
		     System.out.printf(" | (_) |");
		    }
		    if(countStart == 6) {
		     System.out.printf("  \\___/ ");
		    }
		   }
		   if(String.valueOf(cARDGAMENUM).startsWith("7")) {
		    if(countStart == 1) {
		     System.out.printf("  ______ ");
		    }
		    if(countStart == 2) {
		     System.out.printf(" |____  |");
		    }
		    if(countStart == 3) {
		     System.out.printf("     / / ");
		    }
		    if(countStart == 4) {
		     System.out.printf("    / /  ");
		    }
		    if(countStart == 5) {
		     System.out.printf("   / /   ");
		    }
		    if(countStart == 6) {
		     System.out.printf("  /_/    ");
		    }
		   }
		   if(String.valueOf(cARDGAMENUM).startsWith("8")) {
		    if(countStart == 1) {
		     System.out.printf("   ___  ");
		    }
		    if(countStart == 2) {
		     System.out.printf("  / _ \\ ");
		    }
		    if(countStart == 3) {
		     System.out.printf(" | (_) |");
		    }
		    if(countStart == 4) {
		     System.out.printf("  > _ < ");
		    }
		    if(countStart == 5) {
		     System.out.printf(" | (_) |");
		    }
		    if(countStart == 6) {
		     System.out.printf("  \\___/ ");
		    }
		   }
		   if(String.valueOf(cARDGAMENUM).startsWith("9")) {
		    if(countStart == 1) {
		     System.out.printf("   ___  ");
		    }
		    if(countStart == 2) {
		     System.out.printf("  / _ \\ ");
		    }
		    if(countStart == 3) {
		     System.out.printf(" | (_) |");
		    }
		    if(countStart == 4) {
		     System.out.printf("  \\__, |");
		    }
		    if(countStart == 5) {
		     System.out.printf("    / / ");
		    }
		    if(countStart == 6) {
		     System.out.printf("   /_/  ");
		    }
		   }
		   if(String.valueOf(cARDGAMENUM).startsWith("0")) {
		    if(countStart == 1) {
		     System.out.printf("   ___  ");
		    }
		    if(countStart == 2) {
		     System.out.printf("  / _ \\ ");
		    }
		    if(countStart == 3) {
		     System.out.printf(" | | | |");
		    }
		    if(countStart == 4) {
		     System.out.printf(" | | | |");
		    }
		    if(countStart == 5) {
		     System.out.printf(" | |_| |");
		    }
		    if(countStart == 6) {
		     System.out.printf("  \\___/ ");
		    }
		   }
		   /////////////////////////////////////////////////////////////////////////
		   if(String.valueOf(cARDGAMENUM).endsWith("1")) {
		    if(countStart == 1) {
		     System.out.printf("  __ ");
		    }
		    if(countStart == 2) {
		     System.out.printf(" /_ |");
		    }
		    if(countStart == 3) {
		     System.out.printf("  | |");
		    }
		    if(countStart == 4) {
		     System.out.printf("  | |");
		    }
		    if(countStart == 5) {
		     System.out.printf("  | |");
		    }
		    if(countStart == 6) {
		     System.out.printf("  |_|");
		    }
		   }
		   if(String.valueOf(cARDGAMENUM).endsWith("2")) {
		    if(countStart == 1) {
		     System.out.printf("  ___  ");
		    }
		    if(countStart == 2) {
		     System.out.printf(" |__ \\ ");
		    }
		    if(countStart == 3) {
		     System.out.printf("    ) |");
		    }
		    if(countStart == 4) {
		     System.out.printf("   / / ");
		    }
		    if(countStart == 5) {
		     System.out.printf("  / /_ ");
		    }
		    if(countStart == 6) {
		     System.out.printf(" |____|");
		    }
		   }
		   if(String.valueOf(cARDGAMENUM).endsWith("3")) {
		    if(countStart == 1) {
		     System.out.printf("  ____  ");
		    }
		    if(countStart == 2) {
		     System.out.printf(" |___ \\ ");
		    }
		    if(countStart == 3) {
		     System.out.printf("   __) |");
		    }
		    if(countStart == 4) {
		     System.out.printf("  |__ < ");
		    }
		    if(countStart == 5) {
		     System.out.printf("  ___) |");
		    }
		    if(countStart == 6) {
		     System.out.printf(" |____/ ");
		    }
		   }
		   if(String.valueOf(cARDGAMENUM).endsWith("4")) {
		    if(countStart == 1) {
		     System.out.printf("  _  _   ");
		    }
		    if(countStart == 2) {
		     System.out.printf(" | || |  ");
		    }
		    if(countStart == 3) {
		     System.out.printf(" | || |_ ");
		    }
		    if(countStart == 4) {
		     System.out.printf(" |__   _|");
		    }
		    if(countStart == 5) {
		     System.out.printf("    | |  ");
		    }
		    if(countStart == 6) {
		     System.out.printf("    |_|  ");
		    }

		   }
		   if(String.valueOf(cARDGAMENUM).endsWith("5")) {
		    if(countStart == 1) {
		     System.out.printf("  _____ ");
		    }
		    if(countStart == 2) {
		     System.out.printf(" | ____|");
		    }
		    if(countStart == 3) {
		     System.out.printf(" | |__  ");
		    }
		    if(countStart == 4) {
		     System.out.printf(" |___ \\ ");
		    }
		    if(countStart == 5) {
		     System.out.printf("  ___) |");
		    }
		    if(countStart == 6) {
		     System.out.printf(" |____/ ");
		    }
		   }
		   if(String.valueOf(cARDGAMENUM).endsWith("6")) {
		    if(countStart == 1) {
		     System.out.printf("    __  ");
		    }
		    if(countStart == 2) {
		     System.out.printf("   / /  ");
		    }
		    if(countStart == 3) {
		     System.out.printf("  / /_  ");
		    }
		    if(countStart == 4) {
		     System.out.printf(" | '_ \\ ");
		    }
		    if(countStart == 5) {
		     System.out.printf(" | (_) |");
		    }
		    if(countStart == 6) {
		     System.out.printf("  \\___/ ");
		    }
		   }
		   if(String.valueOf(cARDGAMENUM).endsWith("7")) {
		    if(countStart == 1) {
		     System.out.printf("  ______ ");
		    }
		    if(countStart == 2) {
		     System.out.printf(" |____  |");
		    }
		    if(countStart == 3) {
		     System.out.printf("     / / ");
		    }
		    if(countStart == 4) {
		     System.out.printf("    / /  ");
		    }
		    if(countStart == 5) {
		     System.out.printf("   / /   ");
		    }
		    if(countStart == 6) {
		     System.out.printf("  /_/    ");
		    }
		   }
		   if(String.valueOf(cARDGAMENUM).endsWith("8")) {
		    if(countStart == 1) {
		     System.out.printf("   ___  ");
		    }
		    if(countStart == 2) {
		     System.out.printf("  / _ \\ ");
		    }
		    if(countStart == 3) {
		     System.out.printf(" | (_) |");
		    }
		    if(countStart == 4) {
		     System.out.printf("  > _ < ");
		    }
		    if(countStart == 5) {
		     System.out.printf(" | (_) |");
		    }
		    if(countStart == 6) {
		     System.out.printf("  \\___/ ");
		    }
		   }
		   if(String.valueOf(cARDGAMENUM).endsWith("9")) {
		    if(countStart == 1) {
		     System.out.printf("   ___  ");
		    }
		    if(countStart == 2) {
		     System.out.printf("  / _ \\ ");
		    }
		    if(countStart == 3) {
		     System.out.printf(" | (_) |");
		    }
		    if(countStart == 4) {
		     System.out.printf("  \\__, |");
		    }
		    if(countStart == 5) {
		     System.out.printf("    / / ");
		    }
		    if(countStart == 6) {
		     System.out.printf("   /_/  ");
		    }
		   }
		   if(String.valueOf(cARDGAMENUM).endsWith("0")) {
		    if(countStart == 1) {
		     System.out.printf("   ___  ");
		    }
		    if(countStart == 2) {
		     System.out.printf("  / _ \\ ");
		    }
		    if(countStart == 3) {
		     System.out.printf(" | | | |");
		    }
		    if(countStart == 4) {
		     System.out.printf(" | | | |");
		    }
		    if(countStart == 5) {
		     System.out.printf(" | |_| |");
		    }
		    if(countStart == 6) {
		     System.out.printf("  \\___/ ");
		    }
		   }
		   System.out.println("");
		   countStart++; 
		  }
		 }


		public static void dealerBust() {
		  System.out.printf("______           _            ______           _   _ _ _ _ _ _ \n"
		    + "|  _  \\         | |           | ___ \\         | | | | | | | | |\n"
		    + "| | | |___  __ _| | ___ _ __  | |_/ /_   _ ___| |_| | | | | | |\n"
		    + "| | | / _ \\/ _` | |/ _ \\ '__| | ___ \\ | | / __| __| | | | | | |\n"
		    + "| |/ /  __/ (_| | |  __/ |    | |_/ / |_| \\__ \\ |_|_|_|_|_|_|_|\n"
		    + "|___/ \\___|\\__,_|_|\\___|_|    \\____/ \\__,_|___/\\__(_|_|_|_|_|_)\n"
		    + "");

		 }

		public static void printDealerwin() {
		  System.out.printf("______           _             _    _             \n"
		    + "|  _  \\         | |           | |  | |            \n"
		    + "| | | |___  __ _| | ___ _ __  | |  | | ___  _ __  \n"
		    + "| | | / _ \\/ _` | |/ _ \\ '__| | |/\\| |/ _ \\| '_ \\ \n"
		    + "| |/ /  __/ (_| | |  __/ |    \\  /\\  / (_) | | | |\n"
		    + "|___/ \\___|\\__,_|_|\\___|_|     \\/  \\/ \\___/|_| |_|\n");

		 }

		public static void WinningPrints() {
		  int i = 1;
		  i = IR4.getRandomNumber(1, 3);
		  if (i == 1) {
		   System.out.printf("         _________ _        _        _______  _______ \n|\\     /|\\__   __/( (    /|( (    /|(  ____ \\(  ____ )\n"
		     + "| )   ( |   ) (   |  \\  ( ||  \\  ( || (    \\/| (    )|\n| | _ | |   | |   |   \\ | ||   \\ | || (__    | (____)|\n"
		     + "| |( )| |   | |   | (\\ \\) || (\\ \\) ||  __)   |     __)\n"
		     + "| || || |   | |   | | \\   || | \\   || (      | (\\ (   \n"
		     + "| () () |___) (___| )  \\  || )  \\  || (____/\\| ) \\ \\__\n"
		     + "(_______)\\_______/|/    )_)|/    )_)(_______/|/   \\__/\n");
		  }
		  if (i == 2) {
		   System.out.printf("      ___                       ___           ___           ___           ___     \n"
		     + "     /\\__\\          ___        /\\__\\         /\\__\\         /\\  \\         /\\  \\    \n"
		     + "    /:/ _/_        /\\  \\      /::|  |       /::|  |       /::\\  \\       /::\\  \\   \n"
		     + "   /:/ /\\__\\       \\:\\  \\    /:|:|  |      /:|:|  |      /:/\\:\\  \\     /:/\\:\\  \\  \n"
		     + "  /:/ /:/ _/_      /::\\__\\  /:/|:|  |__   /:/|:|  |__   /::\\~\\:\\  \\   /::\\~\\:\\  \\ \n"
		     + " /:/_/:/ /\\__\\  __/:/\\/__/ /:/ |:| /\\__\\ /:/ |:| /\\__\\ /:/\\:\\ \\:\\__\\ /:/\\:\\ \\:\\__\\\n"
		     + " \\:\\/:/ /:/  / /\\/:/  /    \\/__|:|/:/  / \\/__|:|/:/  / \\:\\~\\:\\ \\/__/ \\/_|::\\/:/  /\n"
		     + "  \\::/_/:/  /  \\::/__/         |:/:/  /      |:/:/  /   \\:\\ \\:\\__\\      |:|::/  / \n"
		     + "   \\:\\/:/  /    \\:\\__\\         |::/  /       |::/  /     \\:\\ \\/__/      |:|\\/__/  \n"
		     + "    \\::/  /      \\/__/         /:/  /        /:/  /       \\:\\__\\        |:|  |    \n"
		     + "     \\/__/                     \\/__/         \\/__/         \\/__/         \\|__|    \n");

		  }
		  if (i == 3) {
		   System.out.printf(".------..------..------..------..------..------.\n"
		     + "|W.--. ||I.--. ||N.--. ||N.--. ||E.--. ||R.--. |\n"
		     + "| :/\\: || (\\/) || :(): || :(): || (\\/) || :(): \n"
		     + "| :\\/: || :\\/: || ()() || ()() || :\\/: || ()() |\n"
		     + "| '--'W|| '--'I|| '--'N|| '--'N|| '--'E|| '--'R|\n"
		     + "`------'`------'`------'`------'`------'`------'\n");

		  }
		  /////////////////////////////////////////  

		 }

		public static void Draw() {
			System.out.printf("______                    \n"
					+ "|  _  \\                   \n"
					+ "| | | |_ __ __ ___      __\n"
					+ "| | | | '__/ _` \\ \\ /\\ / /\n"
					+ "| |/ /| | | (_| |\\ V  V / \n"
					+ "|___/ |_|  \\__,_| \\_/\\_/  \n");
			
		}

		
		}

