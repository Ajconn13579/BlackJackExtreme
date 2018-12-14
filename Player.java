public class Player {
    
    private String name;
    private String password; 
    private int wins; 
    private int loses;
    private int rounds;
	private int bJCount;
	private int credits;
	private int creditsEarned;
    private int creditsLost;
    private int highestCredits;
    private int bankRuptcies;
    private String currency; 
   
    public Player() { 
        //no-arg constructor        
    }
   
    public Player(String name, String password, int wins, int loses, int rounds, 
			int bJCount, int credits, int creditsEarned, int creditsLost, int highestCredits,
			int bankRuptcies, String currency) {
		
		this.name = name;
		this.password = password;
		this.wins = wins; 
		this.loses = loses;
		this.rounds = rounds;
		this.bJCount = bJCount;
		this.credits = credits;
		this.creditsEarned = creditsEarned;
		this.creditsLost = creditsLost;
		this.highestCredits = highestCredits;
		this.bankRuptcies = bankRuptcies;
		this.currency = currency; 
	}

	public void setRounds(int rounds) {
		this.rounds = rounds;
	}

	public int getRounds() {
		return rounds;
	}

	public void setCredits(int credits) {
		this.credits = credits;	
	}

	public int getCredits() {
		return credits;
	}

	public int getLoses() {
		return loses;
	}

	public void setLoses(int loses) {
		this.loses = loses;
	}

	public String getPassword() {
		return password;
	}

	public String getName(){
       		 return name;
   	}

	public int getbJCount() {
		return bJCount;
	}

	public int getCreditsEarned() {
		return creditsEarned;
	}

	public int getCreditsLost() {
		return creditsLost;
	}

	public int getHighestCredits() {
		return highestCredits;
	}

	public int getBankRuptcies() {
		return bankRuptcies;
	}
	
	public int getWins() {
		return wins;
	}

	public String getCurrency() {
		return currency;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public void setbJCount(int bJCount) {
		this.bJCount = bJCount;
	}

	public void setCreditsEarned(int creditsEarned) {
		this.creditsEarned = creditsEarned;
	}

	public void setCreditsLost(int creditsLost) {
		this.creditsLost = creditsLost;
	}

	public void setHighestCredits(int highestCredits) {
		this.highestCredits = highestCredits;
	}

	public void setBankRuptcies(int bankRuptcies) {
		this.bankRuptcies = bankRuptcies;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
