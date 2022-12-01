import java.util.*;
import java.lang.Thread;

class Main {
	public static void main(String[] args) {
		Game game = new Game();
		try {
			game.run();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Game {
	List<Account> list_of_accounts;
	Map<Cell.CellEnum, List<String>> game_map;
	
	public Game() {
		list_of_accounts= new ArrayList<>();
		game_map = new HashMap<>();
		
		if (game_map.containsKey(Cell.CellEnum.EMPTY)) {
			List<String> story = new ArrayList<>();
			game_map.put(Cell.CellEnum.EMPTY, story);
		}
	}
	
	public void move(Grid game_map) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Choose your next move on the board(S, N, E, W): ");
		String next_move = scanner.nextLine();
		
		if (next_move.equals("S")) {
			game_map.goSouth(game_map);
		} else if (next_move.equals("N")) {
			game_map.goNorth(game_map);
		} else if (next_move.equals("E")) {
			game_map.goEast(game_map);
		} else if (next_move.equals("W")) {
			game_map.goWest(game_map);
		} else {
			System.out.println("Invalid move!!!");
		}
		
		game_map.print_game_map(game_map);
	}
	
	public void run() throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		Account account_1 = new Account(1);
		account_1.player_information = account_1.new Information("Bogdan Andrei Sprincenatu", "Motru, Gorj, Romania");
		
		account_1.player_information.favorite_games.add("God Of War: Ragnarok");
		account_1.player_information.favorite_games.add("Elden Ring");
		account_1.player_information.favorite_games.add("Bloodborne");
		
		account_1.player_information.credentials = new Credentials("danelu99", "harder_please");
		
		Account account_2 = new Account(1);
		account_2.player_information = account_2.new Information("Marshall Mathers", "Detroit, Michigan, USA");
		
		account_2.player_information.favorite_games.add("God Of War: Ragnarok");
		account_2.player_information.favorite_games.add("Dark Souls");
		
		account_2.player_information.credentials = new Credentials("slim_shady1", "ken_keniff");
		
		Account account_3 = new Account(1);
		account_3.player_information = account_3.new Information("Bogdan Ionut Pastaca", "Bucharest, Romania");
		
		account_3.player_information.favorite_games.add("GTA V");
		account_3.player_information.favorite_games.add("RDR2: Ultimate Edition");
		account_3.player_information.favorite_games.add("Final Fantasy VII: REMAKE");
		
		account_3.player_information.credentials = new Credentials("betiv", "muiere_garda");
		
		list_of_accounts.add(account_1);
		list_of_accounts.add(account_2);
		list_of_accounts.add(account_3);
		
	BIGGEST:
		while (true) {
			System.out.println("--------------------- ACCOUNTS ---------------------");
			System.out.println();
			
			for (int i = 0; i < list_of_accounts.size(); i++) {
				System.out.println(i + 1 + ") " + list_of_accounts.get(i).player_information.player_name);
			}
			System.out.println("4) Shut down");
			
			System.out.println();
			System.out.print("Choose your account_number(1, 2, 3, 4): ");
			int account_number = scanner.nextInt();
			
			while (true) {
				if (account_number == 1) {
					break;
				} else if (account_number == 2) {
					break;
				} else if (account_number == 3) {
					break;
				} else if (account_number == 4) {
					System.out.print("Shutting down...");
					Thread.sleep(3000);
					break BIGGEST;
				} else {
					System.out.print("Please enter a valid account_number: ");
					account_number = scanner.nextInt();
				}
			}
			
			System.out.println();
			
			System.out.println("--------------------- LOGIN PAGE ---------------------");
			System.out.println();
			
			while (true) {
				System.out.print("Enter your user_name: ");
				String user = scanner.next();
				if (!list_of_accounts.get(account_number - 1).player_information.credentials.getEmail().equals(user)) {
					System.out.println("The user_name you entered seems to be wrong! Please try again.");
				} else {
					break;
				}
			}
			
			while (true) {
				System.out.print("Enter your password: ");
				String password = scanner.next();
				if (!list_of_accounts.get(account_number - 1).player_information.credentials.getPassword().equals(password)) {
					System.out.println("The password you entered doesn't match your actual password! Please try again.");
				} else {
					break;
				}
			}
			System.out.println();
			System.out.print("Logging in...");
			Thread.sleep(3000);
			System.out.println();
			System.out.println();
			
		SMALLER1:
			while (true) {
				System.out.println("--------------------- YOUR ACCOUNT ---------------------");
				System.out.println();
			
				System.out.println("Welcome to your account " + list_of_accounts.get(account_number - 1).
						player_information.credentials.getEmail() + ". You have the following options:");
				System.out.println("1) Play game");
				System.out.println("2) Account informations");
				System.out.println("3) Log out");
				System.out.print("Choose what you wish to do(1, 2, 3): ");
				int option = scanner.nextInt();
				System.out.println();
				
				if (option == 1) {
					System.out.print("Launching game...");
					Thread.sleep(3000);
					System.out.println();
				} else if (option == 2) {
					System.out.println("--------------------- ACCOUNT INFORMATIONS ---------------------");
					System.out.println();
					System.out.println("-> Player's name: " + list_of_accounts.get(account_number - 1).player_information.player_name);
					System.out.println("-> Player's origins: " + list_of_accounts.get(account_number - 1).player_information.player_origins);
					System.out.println("-> Favorite games:");
					Iterator<String> it = list_of_accounts.get(account_number - 1).player_information.favorite_games.iterator();
					while (it.hasNext()) {
						System.out.println("- " + it.next());
					}
					System.out.println();
					
					while (true) {
						System.out.print("Go back to the main menu?(Y, N): ");
						String choose = scanner.next();
					
						if (choose.equals("Y")) {
							System.out.println();
							continue SMALLER1;
						} else if (choose.equals("N")) {
							Thread.sleep(3000);
						}
					}
				} else if (option == 3) {
					System.out.print("Logging out...");
					Thread.sleep(3000);
					continue BIGGEST;
				}
			
			System.out.println();
			
			System.out.println("------------ Welcome to the Middle Earth! We hope you'll have fun trying to cross the dark realm of Mordor -----------");
			System.out.println();
			
			System.out.print("Choose your character(Warrior, Mage, Rogue): ");
			String type = scanner.next();
			
			System.out.print("Insert Character's name: ");
			String name = scanner.next();
			
			System.out.print("Current experience: ");
			int experience_points = scanner.nextInt();
			
			System.out.print("Current level: ");
			int level = scanner.nextInt();
			
			CharacterSpawn selected_character = new CharacterSpawn();
			Character character = null;
			
			if (type.equals("Warrior")) {
				character = selected_character.getCharacter(type, name, experience_points, level);
			}
			
			if (type.equals("Mage")) {
				character = selected_character.getCharacter(type, name, experience_points, level);
			}
			
			if (type.equals("Rogue")) {
				character = selected_character.getCharacter(type, name, experience_points, level);
			}
			
			System.out.print("Insert length of the board: ");
			int length = scanner.nextInt();
			
			System.out.print("Insert width of the board: ");
			int width = scanner.nextInt();
			System.out.println();
			
			Grid grid = new Grid(length, width, character);
			
			List<String> list = new ArrayList<>();
			list.add("N");
			list.add("E");
			list.add("S");
			list.add("F");
			
			LinkedHashMap<Position, Cell.CellEnum> map = new LinkedHashMap<>();
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < width; j++) {
					String random_element = list.get(random.nextInt(list.size() - 1));
					if (random_element.equals("N")) {
						map.put(new Position(i, j), Cell.CellEnum.EMPTY);
					} else if (random_element.equals("E")) {
						map.put(new Position(i, j), Cell.CellEnum.ENEMY);
					} else if (random_element.equals("S")) {
						map.put(new Position(i, j), Cell.CellEnum.SHOP);
					} else if (random_element.equals("F")) {
						map.put(new Position(i, j), Cell.CellEnum.FINISH);
					}
				}
			}
			map.put(new Position(0, 0), Cell.CellEnum.EMPTY);
			map.put(new Position(length - 1, width -  1), Cell.CellEnum.FINISH);
			
			System.out.println("Start game:");
			System.out.println();
			
			Grid game_map_aux = grid.generateMap(length, width, character, map);
			game_map_aux.print_game_map(game_map_aux);
			System.out.println(game_map_aux.current_cell.cell_type);
			System.out.println(character.character_inventory);
			
			while (character.current_life != 0) {
				move(game_map_aux);
				System.out.println(game_map_aux.current_cell.cell_type);
				System.out.println(character.character_inventory);
				
				if (game_map_aux.current_cell.cell_type.equals(Cell.CellEnum.EMPTY)) {
					System.out.print("Nothing happens. Do you want to continue?(Y/N): ");
					String answer = scanner.next();
					
					if (answer.equals("N")) {
						continue;
					}
				}
				
				if (game_map_aux.current_cell.cell_type.equals(Cell.CellEnum.SHOP)) {
					System.out.print("Welcome to the shop! Do you want to to buy something?(Y/N): ");
					String response = scanner.next();
					
					if (response.equals("N")) {
						continue;
					} else if (response.equals("Y")) {
						Shop shop = new Shop();
					
						int number_of_things_to_buy = shop.list_of_potions.size();
						System.out.println("You have to buy " + number_of_things_to_buy + " items");
						System.out.println(shop);
					
						while (number_of_things_to_buy > 0) {
							System.out.print("What kind of potion you'd like to buy(MANA, HEALTH): ");
							String potion_type = scanner.next();
							System.out.println();
							if (potion_type.equals("MANA")) {
								ManaPotion mana_potion = new ManaPotion();
								character.buy_potion(mana_potion);
								shop.list_of_potions.remove(mana_potion);
								System.out.println(shop);
							} else if (potion_type.equals("HEALTH")) {
								HealthPotion health_potion = new HealthPotion();
								character.buy_potion(health_potion);
								shop.list_of_potions.remove(health_potion);
								System.out.println(shop);
							} else {
								System.out.println("It that seems we're out of what you're looking for!");
							}
							System.out.println(character.character_inventory);
							number_of_things_to_buy--;
						}
						game_map_aux.print_game_map(game_map_aux);
						System.out.println();
					}
				}
				
				if (game_map_aux.current_cell.cell_type.equals(Cell.CellEnum.ENEMY)) {
					System.out.println("You've encountered an enemy! It seems that you're in danger! Try to fight your way out of this!!!");
					System.out.println();
					Enemy enemy = new Enemy();
					System.out.println(enemy);
					System.out.println("Your life is " + character.current_life);
					System.out.print("First move(C, E)...");
					Thread.sleep(2000);
					System.out.println();
					boolean first_move = random.nextBoolean();
					
					while (enemy.current_life > 0 && character.current_life > 0) {
						if (first_move) {
							System.out.print("Your turn...");
							Thread.sleep(2000);
							System.out.println();
							System.out.println("You have 2 options:");
							System.out.println("1) Drink a potion.");
							System.out.println("2) Attack.");
							System.out.print("And one choice! So choose wisely(A, D): ");
							String choice = scanner.next();
							
							while (true) {
								if (choice.equals("A")) {
									System.out.print("You chose to attack! Choose your way to attack(N, S): ");
									String attack = scanner.next();
									System.out.println();
								
									if (attack.equals("N")) {
										System.out.print("Using a normal attack...");
										Thread.sleep(2000);
										System.out.println();
										enemy.receive_damage(character.get_damage());
										System.out.println(enemy);
										break;
									} else if (attack.equals("S")) {
										if (character.current_mana > 0) {
											if (type.equals("Warrior")) {
												if (!enemy.fire_protection) {
													System.out.print("Casting a spell...");
													Thread.sleep(2000);
													System.out.println();
													character.use_abbility(new Fire(), enemy);
													System.out.println(enemy);
													break;
												} else {
													System.out.println("It seems that your enemy is immune to fire");
													break;
												}
											} else if (type.equals("Mage")) {
												if (!enemy.ice_protection) {
													System.out.print("Casting a spell...");
													Thread.sleep(2000);
													System.out.println();
													character.use_abbility(new Ice(), enemy);
													System.out.println(enemy);
													break;
												} else {
													System.out.println("It seems that your enemy is immune to ice");
													break;
												}
											} else if (type.equals("Rogue")) {
												if (!enemy.earth_protection) {
													System.out.print("Casting a spell...");
													Thread.sleep(2000);
													System.out.println();
													character.use_abbility(new Earth(), enemy);
													System.out.println(enemy);
													break;
												}
											} else {
												System.out.println("It seems that your enemy is immune to earth");
												break;
											}
										} else {
											System.out.println("You don't have enough mana to cast this spell!");
										}
									}
								} else if (choice.equals("D")) {
									System.out.print("You chose to drink a potion. Choose the potion you wish to consume(M, H): ");
									String choose_again = scanner.next();
									System.out.println();
								
									if (choose_again.equals("M")) {
										System.out.println(character.character_inventory);
										Potion mana_potion = new ManaPotion();
										if (character.character_inventory.list_of_potions.contains(mana_potion)) {
											mana_potion.use_potion(character);
											character.character_inventory.remove_potion(mana_potion);
										} else {
											System.out.println("It seems that you don't have this potion in inventory");
										}
										break;
									
									} else if (choose_again.equals("H")) {
										System.out.println(character.character_inventory);
										Potion health_potion = new HealthPotion();
										if (character.character_inventory.list_of_potions.contains(health_potion)) {
											health_potion.use_potion(character);
											character.character_inventory.remove_potion(health_potion);
										} else {
											System.out.println("It seems that you don't have this potion in inventory");
										}
										break;
									}
									
								} else {
									System.out.print("Please enter a valid command: ");
									choice = scanner.next();
								}
							}
						}
						
						if (enemy.current_life == 0) {
							System.out.println("Enemy's dead. You may continue your journey.");
							System.out.println();
							game_map_aux.print_game_map(game_map_aux);
							break;
						}
		
						System.out.print("Enemy's turn...");
						Thread.sleep(2000);
						System.out.println();
						enemy.enemy_attack(character);
						first_move = true;
						System.out.println("Your life decreased to " + character.current_life);
						System.out.println("Your mana decreased to " + character.current_mana);
						System.out.println();
						
						if (character.current_life <= 0) {
							System.out.println("You died! Your journey ends here...that's a shame.");
							System.out.print("Redirecting you to your account...");
							Thread.sleep(3000);
							continue SMALLER1;
						}
					}
				}
				
				if (game_map_aux.current_cell.cell_type.equals(Cell.CellEnum.FINISH)) {
					System.out.println();
					System.out.println("*********CONGRATULATIONS!!! YOU'VE JUST FINISHED THE GAME HERO!*********");
				INNER:
					while (true) {
						System.out.println("1) Ready for another adventure!:)");
						System.out.println("2) Quit game");
						System.out.print("Choose from the next options: ");
						int number = scanner.nextInt();
						if (number == 1) {
							System.out.print("Redirecting you to your account...");
							Thread.sleep(3000);
							continue SMALLER1;
						} else if (number == 2) {
							System.out.print("Are you sure you want to quit the game?(Y, N): ");
							String again = scanner.next();
							if (again.equals("Y")) {
								System.out.print("Leaving the game...");
								Thread.sleep(3000);
								System.out.println();
								System.out.println();
								continue SMALLER1;
							} else if (again.equals("N")) {
								System.out.println();
								continue INNER;
							}
						}
					}
				}
			}
		}
		}
	}
}

class Account {
	Information player_information;
	List<Character> list_of_players;
	int number_of_game_trials;
	
	public Account(int nogt) {
		this.number_of_game_trials = nogt;
		list_of_players = new ArrayList<>();
	}
	
	class Information {
		Credentials credentials;
		Collection<String> favorite_games;
		String player_name;
		String player_origins;
		
		public Information(String pn, String po) {
			this.player_name = pn;
			this.player_origins = po;
			favorite_games = new TreeSet<String>();
		}
	}
}

class Credentials {
	private String user_email;
	private String user_password;
	
	public Credentials(String user_email, String user_password) {
		this.user_email = user_email;
		this.user_password = user_password;
	}
	
	public Credentials() {
		this(null, null);
	}
	
	public String getEmail() {
		return user_email;
	}
	
	public String getPassword() {
		return user_password;
	}
	
	public void setEmail(String email) {
		user_email = email;
	}
	
	public void setPassword(String password) {
		user_password = password;
	}
	
	public String toString() {
		String ans = "";
		ans += "User has " + user_email + " and the password " + user_password;
		return ans;
	}
}

@SuppressWarnings({ "hiding", "rawtypes" })
class Grid extends ArrayList {
	private static final long serialVersionUID = 1L;
	public int grid_length;
	public int grid_width;
	public Character current_character;
	public Cell current_cell;
	
	public Grid(int gl, int gw, Character character) {
		this.grid_length = gl;
		this.grid_width = gw;
		this.current_character = character;
		current_cell = new Cell(0, 0, Cell.CellEnum.EMPTY);
		current_cell.check_cell_disponibility = true;
	}
	
	@SuppressWarnings("unchecked")
	public Grid generateMap(int length, int width, Character character, LinkedHashMap<Position, Cell.CellEnum> cells_map) {
		Grid game_map = new Grid(length, width, character);
		
		for (int i = 0; i < game_map.grid_length; i++) {
			ArrayList<Cell> line = new ArrayList<>();
			for (int j = 0; j < game_map.grid_width; j++) {
				Cell.CellEnum cell_type = Cell.CellEnum.EMPTY;
				
				if (cells_map.get(new Position(i, j)) != null) {
					cell_type = cells_map.get(new Position(i, j));
				}
				
				Cell cell = new Cell(i, j, cell_type);
				line.add(cell);
			}
			game_map.add(line);
		}
		((ArrayList<Cell>) game_map.get(0)).get(0).check_cell_disponibility = true;
		return game_map;
	}
	
	@SuppressWarnings("unchecked")
	public void goNorth(Grid game_map) {
		if (game_map.current_cell.x_coordinate == 0) {
			System.out.println("Impossible!");
			return;
		}
		
		((ArrayList<Cell>) game_map.get(game_map.current_cell.x_coordinate - 1)).
		get(game_map.current_cell.y_coordinate).check_cell_disponibility = true;
		
		game_map.current_cell = ((ArrayList<Cell>) game_map.get(game_map.current_cell.x_coordinate - 1)).
				get(game_map.current_cell.y_coordinate);
	}
	
	@SuppressWarnings("unchecked")
	public void goSouth(Grid game_map) {
		if (game_map.current_cell.x_coordinate == game_map.grid_length - 1) {
			System.out.println("Impossible!");
			return;
		}
		
		((ArrayList<Cell>) game_map.get(game_map.current_cell.x_coordinate + 1)).
		get(game_map.current_cell.y_coordinate).check_cell_disponibility = true;
		
		game_map.current_cell = ((ArrayList<Cell>) game_map.get(game_map.current_cell.x_coordinate + 1)).
				get(game_map.current_cell.y_coordinate);
	}
	
	@SuppressWarnings("unchecked")
	public void goWest(Grid game_map) {
		if (game_map.current_cell.y_coordinate == 0) {
			System.out.println("Impossible!");
			return;
		}
		
		((ArrayList<Cell>) game_map.get(game_map.current_cell.x_coordinate)).
		get(game_map.current_cell.y_coordinate - 1).check_cell_disponibility = true;
		
		game_map.current_cell = ((ArrayList<Cell>) game_map.get(current_cell.x_coordinate)).
				get(game_map.current_cell.y_coordinate - 1);
	}
	
	@SuppressWarnings("unchecked")
	public void goEast(Grid game_map) {
		if (game_map.current_cell.y_coordinate == game_map.grid_width - 1) {
			System.out.println("Impossible");
			return;
		}
		
		((ArrayList<Cell>) game_map.get(game_map.current_cell.x_coordinate)).
		get(game_map.current_cell.y_coordinate + 1).check_cell_disponibility = true;
		
		game_map.current_cell = ((ArrayList<Cell>) game_map.get(current_cell.x_coordinate)).
				get(game_map.current_cell.y_coordinate + 1);
	}
	
	@SuppressWarnings("unchecked")
	public void print_game_map(Grid game_map) {
		for (int i = 0; i < game_map.grid_length; i++) {
			for (int j = 0; j < game_map.grid_width; j++) {
				if (((ArrayList<Cell>) game_map.get(i)).get(j).check_cell_disponibility) {
					if (game_map.current_cell.x_coordinate == i &&
							game_map.current_cell.y_coordinate == j) {
						System.out.print("P");
					}
					
					if ((game_map.current_cell.x_coordinate != i ||
							game_map.current_cell.y_coordinate != j) ||
							!(((ArrayList<Cell>) game_map.get(i)).get(j).cell_type).
							equals(Cell.CellEnum.EMPTY)) {
						System.out.print(((ArrayList<Cell>) game_map.get(i)).get(j) + " ");
					}
				} else {
					System.out.print("? ");
				}
			}
			System.out.println();
		}
	}
}

class Position {
    public int xCoordinate;
    public int yCoordinate;
    private int hashCode;

    public Position(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.hashCode = Objects.hash(xCoordinate, yCoordinate);
    }

    public String toString() {
        return this.xCoordinate + " " + this.yCoordinate;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;

        if (object == null)
            return false;

        if (this.getClass() != object.getClass())
            return false;

        Position positionObject = (Position) object;
        if (this.xCoordinate != positionObject.xCoordinate ||
                this.yCoordinate != positionObject.yCoordinate)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }
}
	
class Cell {
	int x_coordinate;
	int y_coordinate;

	Cell_Element type;
	boolean check_cell_disponibility;
	CellEnum cell_type;
	
	enum CellEnum {
		EMPTY,
		ENEMY,
		SHOP,
		FINISH;
	}

	
	@SuppressWarnings("unlikely-arg-type")
	public Cell(int x, int y, CellEnum ce) {
		this.x_coordinate = x;
		this.y_coordinate = y;
		this.cell_type = ce;
		check_cell_disponibility = false;
		
		if (ce.equals(CellEnum.SHOP)) {
			type = new Shop();
		}
		
		if (ce.equals(CellEnum.ENEMY)) {
			type = new Enemy();
		}
	}
	
	public String toString() {
		switch (cell_type) {
			case EMPTY:
				return "N";
			case FINISH:
				return "F";
			case ENEMY:
				return "E";
			case SHOP:
				return "S";
		default:
			break;
		}
		return type.toCharacter();
	}
}

interface Cell_Element {
	public String toCharacter();
}



@SuppressWarnings("rawtypes")
abstract class Entity {
	List<Spell> list_of_abbilities;
	int current_life;
	int max_life;
	int current_mana;
	int max_mana;
	boolean fire_protection;
	boolean ice_protection;
	boolean earth_protection;
	
	public Entity(int cl, int ml, int cm, int mm, boolean fp, boolean ip, boolean ep) {
		this.current_life = cl;
		this.current_mana = cm;
		this.max_life = ml;
		this.max_mana = mm;
		this.fire_protection = fp;
		this.earth_protection = ep;
		this.ice_protection = ip;
		list_of_abbilities = new ArrayList<>();
	}
	
	public void life_regenerate(int life_points) {
		if (current_life + life_points < max_life) {
			current_life += life_points;
		} else {
			return;
		}
	}
	
	public void mana_regenerate(int mana_points) {
		if (current_mana + mana_points < max_mana) {
			current_mana += mana_points;
		} else {
			return;
		}
	}
	
	public void use_abbility(Spell abbility, Enemy e) {
		if (current_mana < abbility.mana_cost) {
			return;
		}
		
		current_mana = current_mana - abbility.mana_cost;
		
		if (e.current_life < abbility.damage_cost) {
			e.current_life = 0;
			return;
		}
		
		e.current_life = e.current_life - abbility.damage_cost;
	}
	
	abstract void receive_damage(int damage);
	abstract int get_damage();
}

class CharacterSpawn {
	public Character getCharacter(String type, String name, int experience, int level) {
		if (type == null) {
			return null;
		}
		
		if (type.equals("Warrior")) {
			return new Warrior(name, level, experience);
		}
		
		if (type.equals("Mage")) {
			return new Mage(name, level, experience);
		}
		
		if (type.equals("Rogue")) {
			return new Rogue(name, level, experience);
		}
		
		return null;
	}
}

abstract class Character extends Entity {
	String name;
	int current_x_coordinate;
	int current_y_coordinate;
	Inventory character_inventory;
	int current_experience;
	int current_level;
	int strength;
	int charisma;
	int dexterity;
	
	public Character(String n, int s, int d, int ch, int x, int y, int ce, int currl, int cl, int ml, int cm, int mm, boolean fp, boolean ip, boolean ep) {
		super(cl, ml, cm, mm, fp, ip, ep);
		this.name = n;
		this.current_experience = ce;
		this.current_level = currl;
		this.current_x_coordinate = x;
		this.current_y_coordinate = y;
		this.charisma = ch;
		this.strength = s;
		this.dexterity = d;
	}
	
	public void buy_potion(Potion potion) {
		if (character_inventory.number_of_coins < potion.get_price_for_potion()) {
			System.out.println("You don't have enough money to buy this potion");
			return;
		}
		
		if (character_inventory.get_new_weight() < potion.get_potion_weight()) {
			System.out.println("You don't have enough space in your inventory");
			return;
		}
		
		if (potion instanceof ManaPotion) {
			System.out.println("You just bought a MANA potion with " + potion.get_price_for_potion() + " coins");
		} else if (potion instanceof HealthPotion) {
			System.out.println("You just bought a HEALTH potion with " + potion.get_price_for_potion() + " coins");
		}
		
		character_inventory.list_of_potions.add(potion);
		character_inventory.number_of_coins = character_inventory.number_of_coins - potion.get_price_for_potion();
		System.out.println("You have " + character_inventory.number_of_coins + " remaining coins in your inventory");
		int remaining_capacity = character_inventory.get_new_weight();
		System.out.println("Inventory current capacity " + remaining_capacity);
	}
}

class Warrior extends Character {
	public Warrior(String n, int s, int d, int ch, int x, int y, int ce, int currl, int cl, int ml, int cm, int mm,
			boolean fp, boolean ip, boolean ep) {
		super(n, s, d, ch, x, y, ce, currl, cl, ml, cm, mm, true, ip, ep);
	}
	
	public Warrior(String name, int current_level, int current_experience) {
		this(name, current_level * 2 + 5, current_level + 5, current_level + 3, 0, 0,
				current_experience, current_level, 50 * current_level + 50, 1000,
				25 * current_level + 25, 500, true, false, false);
		list_of_abbilities.add(new Fire());
		character_inventory = new Inventory(1000, 400);
	}

	@Override
	public void receive_damage(int damage) {
		current_life = current_life - Math.max(damage - (int)(charisma + dexterity) / 5, 0);
		if (current_life < 0) {
			current_life = 0;
		}
	}

	@Override
	public int get_damage() {
		return 2 * strength + dexterity - charisma;
	}
}

class Mage extends Character {

	public Mage(String n, int s, int d, int ch, int x, int y, int ce, int currl, int cl, int ml, int cm, int mm,
			boolean fp, boolean ip, boolean ep) {
		super(n, s, d, ch, x, y, ce, currl, cl, ml, cm, mm, fp, true, ep);
	}
	
	public Mage(String name, int current_level, int current_experience) {
		this(name, current_level + 3, current_level + 5, 2 * current_level + 5,
				0, 0, current_experience, current_level, 40 * current_level + 40, 800,
				40 * current_level + 40, 800, false, false, true);
		list_of_abbilities.add(new Ice());
		character_inventory = new Inventory(1000, 200);
	}

	@Override
	public void receive_damage(int damage) {
		current_life = current_life - Math.max(damage - (int)(dexterity + strength) / 5, 0);
	}

	@Override
	public int get_damage() {
		return 2 * charisma - strength + 3;
	}
}

class Rogue extends Character {

	public Rogue(String n, int s, int d, int ch, int x, int y, int ce, int currl, int cl, int ml, int cm, int mm,
			boolean fp, boolean ip, boolean ep) {
		super(n, s, d, ch, x, y, ce, currl, cl, ml, cm, mm, fp, ip, true);
	}
	
	public Rogue(String name, int current_level, int current_experience) {
		this(name, current_level + 5, current_level * 2 + 5, current_level + 3,
				0, 0, current_experience, current_level, 45 * current_level + 45, 900,
				30 * current_level + 30, 600, false, true, false);
		list_of_abbilities.add(new Earth());
		character_inventory = new Inventory(1000, 300);
	}

	@Override
	public void receive_damage(int damage) {
		current_life = current_life - Math.max(damage - (int)(charisma + strength) / 5, 0);
	}

	@Override
	public int get_damage() {
		return 3 * dexterity; 
	}
}

@SuppressWarnings("rawtypes")
abstract class Spell {
	int damage_cost;
	int mana_cost;
	
	public Spell(int dc, int mc) {
		this.damage_cost = dc;
		this.mana_cost = mc;
	}
}

class Ice extends Spell {
	public Ice(int dc, int mc) {
		super(15, 10);
	}
	
	public Ice() {
		this(15, 10);
	}
}

class Fire extends Spell {
	public Fire(int dc, int mc) {
		super(30, 20);
	}
	
	public Fire() {
		this(30, 20);
	}
}

class Earth extends Spell {
	public Earth(int dc, int mc) {
		super(10, 5);
	}
	
	public Earth() {
		this(10, 5);
	}
}

class Enemy extends Entity implements Cell_Element {
	static Random random = new Random();
	private final int enemy_damage = 10;

	public Enemy(int cl, int ml, int cm, int mm, boolean fp, boolean ip, boolean ep) {
		super(random.nextInt(80), ml, random.nextInt(50), mm, random.nextBoolean(), random.nextBoolean(), random.nextBoolean());
	}
	
	public Enemy() {
		this(random.nextInt(100), 100, random.nextInt(50), 75, random.nextBoolean(), random.nextBoolean(), random.nextBoolean());
		int number_of_spells = random.nextInt(3) + 2;
		
		for (int i = 0; i < number_of_spells; i++) {
			final int spell_type = random.nextInt(3);
			
			switch(spell_type) {
				case 0:
					list_of_abbilities.add(new Fire());
					break;
				case 1:
					list_of_abbilities.add(new Ice());
					break;
				case 2:
					list_of_abbilities.add(new Earth());
					break;
			}
		}
	}

	@Override
	public void receive_damage(int damage) {
		boolean check = random.nextBoolean();
		if (check) {
			if (current_life >= damage) {
				current_life = current_life - damage;
			} else {
				current_life = 0;
			}
		} else {
			System.out.println("The enemy avoided your attack!");
		}
	}

	@Override
	public int get_damage() {
		boolean chance_for_double = random.nextBoolean();
		
		if (chance_for_double) {
			return 2 * enemy_damage;
		}
		return enemy_damage;
	}

	@Override
	public String toCharacter() {
		// TODO Auto-generated method stub
		return "E";
	}
	
	public void enemy_attack(Character character) {
		int next_attack = random.nextInt(4);
		
		if (next_attack == 0 && list_of_abbilities.size() > 0) {
			for (int i = 0; i < list_of_abbilities.size(); i++) {
				if (current_mana > list_of_abbilities.get(i).mana_cost) {
					System.out.println("The enemy is using a spell!");
					
					character.receive_damage(list_of_abbilities.get(i).damage_cost);
					current_mana = current_mana - list_of_abbilities.get(i).mana_cost;
					list_of_abbilities.remove(i);
				}
			}
		}
		
		System.out.println("The enemy is using a normal attack");
		character.receive_damage(get_damage());
	}
	
	public String toString() {
		String ans = "";
		ans += "Enemy's current life is " + current_life;
		return ans;
	}
}

class Inventory {
	List<Potion> list_of_potions;
	int max_inventory_weight;
	int number_of_coins;
	
	public Inventory(int noc, int miw) {
		this.max_inventory_weight = miw;
		this.number_of_coins = noc;
		list_of_potions = new ArrayList<>();
	}
	
	public void add_potion(Potion p) {
		list_of_potions.add(p);
		number_of_coins = number_of_coins - p.get_price_for_potion();
	}
	
	public void remove_potion(Potion p) {
		list_of_potions.remove(p);
	}
	
	public int get_new_weight() {
		int total_weight = 0;
		for (int i = 0; i < list_of_potions.size(); i++) {
			total_weight += list_of_potions.get(i).get_potion_weight();
		}
		
		return max_inventory_weight - total_weight;
	}
	
	public String toString() {
		String ans = "Inventory contains\n";
		int count1 = 0;
		int count2 = 0;
		
		for (int i = 0; i < list_of_potions.size(); i++) {
			if (list_of_potions.get(i) instanceof ManaPotion) {
				count1++;
			} else if (list_of_potions.get(i) instanceof HealthPotion) {
				count2++;
			}
		}
		
		ans += "->" + count1 + " MANA potions;\n";
		ans += "->" + count2 + " HEALTH potions;\n";
		ans += "->" + number_of_coins + " coins.\n";
		
		return ans;
	}
}

interface Potion {
	public void use_potion(Character ch);
	public int get_price_for_potion();
	public int regenerate();
	public int get_potion_weight();
}

class HealthPotion implements Potion {
	int health_potion_price;
	int health_potion_weight;
	int health_regenerate_points;
	
	public HealthPotion(int hpp, int hpw, int hrp) {
		this.health_potion_price = hpp;
		this.health_potion_weight = hpw;
		this.health_regenerate_points = hrp;
	}
	
	public HealthPotion() {
		this(50, 15, 400);
	}

	public void use_potion(Character character) {
		character.current_life = character.current_life + health_regenerate_points;
		System.out.println("Your life regenerated with " + health_regenerate_points);
		
		if (character.current_life > character.max_life) {
			character.current_life = character.max_life;
		}
	}

	@Override
	public int get_price_for_potion() {
		return health_potion_price;
	}

	@Override
	public int regenerate() {
		return health_regenerate_points;
	}

	@Override
	public int get_potion_weight() {
		return health_potion_weight;
	}
	
	public String toString() {
		String ans = "";
		ans = "Health Potion";
		return ans;
	}
}

class ManaPotion implements Potion {
	int mana_potion_price;
	int mana_potion_weight;
	int mana_regenerate_points;
	
	public ManaPotion(int mpp, int mpw, int mrp) {
		this.mana_potion_price = mpp;
		this.mana_potion_weight = mpw;
		this.mana_regenerate_points = mrp;
	}
	
	public ManaPotion() {
		this(100, 200, 10);
	}
	
	public void use_potion(Character character) {
		character.current_mana = character.current_mana + mana_regenerate_points;
		
		if (character.current_mana > character.max_mana) {
			character.current_mana = character.max_mana;
		}
	}

	@Override
	public int get_price_for_potion() {
		return mana_potion_price;
	}

	@Override
	public int regenerate() {
		return mana_regenerate_points;
	}

	@Override
	public int get_potion_weight() {
		return mana_regenerate_points;
	}
	
	public String toString() {
		String ans = "";
		ans += "Mana Potion";
		return ans;
	}
}

class Shop implements Cell_Element {
	List<Potion> list_of_potions;
	Random random;
	
	public Shop() {
		random = new Random();
		int size = random.nextInt(4) + 2;
		list_of_potions = new ArrayList<>();
		
		for (int i = 0; i < size; i++) {
			int type = random.nextInt(2);
			
			switch(type) {
			case 0:
				list_of_potions.add(new ManaPotion());
				break;
			case 1:
				list_of_potions.add(new HealthPotion());
			}
		}
	}
	
	public Potion getPotion(int index) {
		Potion potion = list_of_potions.get(index);
		list_of_potions.remove(index);
		return potion;
	}
	
	public String toCharacter() {
		return "S";
	}
	
	public String toString() {
		String ans = "Shop contains\n";
		int count1 = 0;
		int count2 = 0;
		
		for (int i = 0; i < list_of_potions.size(); i++) {
			if (list_of_potions.get(i) instanceof ManaPotion) {
				count1++;
			} else if (list_of_potions.get(i) instanceof HealthPotion) {
				count2++;
			}
		}
		
		ans += "->" + count1 + " MANA potions;\n";
		ans += "->" + count2 + " HEALTH potions.\n";
		
		return ans;
	}
}