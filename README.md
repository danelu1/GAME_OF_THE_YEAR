# GAME_OF_THE_YEAR
Implementation of a platform containing a game and informations about the player.

The project consists in a simple game in which all you have to do, bassically, is to move on a board, which is the actual game_world, and try to finish it by reaching the last cell on the grid.
It was fully developed using Java.

The classes I used in implementation:
-> The "Game" class, which models the entire application. The class consists of two methods:
    - void move(Grid) , which helps the player on the games's map;
    - void run(), which is the function responsible for runnig the entire application. This method starts with the creation of three main accounts which can be accessed by introducing the correpsonding user_names and passwords. After this the selected account will appear and so you can start playing the actual game, log out or see informations about the player and his preferences. After launching the game and choosing the preferred class to play with, the grid will be exposed, with the player "P" in the upper left corner and any other cell hidden, marked with "?", to discover by yourself the insides of the game. The player can move only in four directions: south, north, west, east, any other move being considered invalid. Every cell can represent an empty place, an enemy, a shop, or the finish line(reserved only for the downer right corner). An empty cell(represented through "N") represents a story and doesn't influence the player's life or mana. The "SHOP" cell(represented through "S") is for buying potions which may help you in your journey(mana potion or health potion). The enemy cell(represented through "E") is an encounter with an enemy which you'll have to defeat through various methods and choices.

-> The "Account" class, which implements the account of an user and lets the user perform more trials before leaving the game back to the account background. It contains the internal class "Information" responsible for informations like the user's origins, his/her name, favorite games(sorted alphabetically).

-> The "Credentials" class, which contains the user_name an password for an account. It is created respecting the encapsulation principle of OOP.

-> The "Grid" class, which models the entire map of the game. It contains a reference to the character you've chosen and a reference to the current_cell of the player. The class provides the methods:
    - Grid generateMap(int, int, Character, LinkedHashMap<Position, Cell.CellEnum>), which generates a map of specified length and width, with all the cells marked as EMPTY("N");
    - void goNorth(Grid), which moves the player one cell upper on the grid(as long as this move is possible);
    - void goSouth(Grid), which moves the playes one cell downer on the grid(as long as this move is possible);
    - void goEast(Grid), which moves the player one cell on his/her right(as long as this move is possible);
    - void goWest(Grid), which moves the player one cell on his/her left(as long as this move is possible);
    - void print_game_map(Grid), which prints the game's map for each move taken on the grid.

-> The "Position" class, which represents the position of the player on the map through the "x" and "y" coordinates.

-> The "Cell" class, which instantiates the corresponding cell according to its notation, and prints the character of the respective cell.

-> The "Cell_Element" interface, whith the method:
    - String toCharacter(), which is going to be implemented in the "Shop" and "Enemy" class, to get the character for our cell.

-> The "Entity" abstract class, used to describe an entity for our game. It contains fields like current life, max life, current mana, max mana for our entity which is going to be described better through the "Character" and "Enemy" classes. It contains the methods:
    - void life_regenerate(int), used for regenerating life back;
    - void mana mana_regenerate(), used for regenerating mana back;
    - void use_abbility(Spell, Enemy), used for casting a spell upon an enemy;
    - abstract void receive_damage(int), implemented in the "Enemy" and "Character" classes, is a method that substracts "damage" points of life from the entity current life;
    - abstract int get_damage(), implemented in the "Entity" and "Character" classes, is a method that returns the damage dealt by the correpsonding entity.

-> The "CharacterSpawn" class, implemented using the "Factory" Design Pattern, contains the method:
    - Character getCharacter(String, String, int, int), which instantiate a character with the corresponding attributes.

-> The "Character" abstract class, which modelates a hero. It contains attributes like strength, charisma and dexterity(which will be calculated different for every type of hero), and also an "Inventory" field used to store all the potions and coins that character holds. It contains the methods:
    - void buy_potion(Potion), which receives a "Potion" as parameter and adds it in the character's inventory, substracting also the amount of money that this cost.

-> The "Warrior", "Mage" and "Rogue" classes, which are implemented using the inheritance OOP concept, these ones being "Child" classes of "Character" abstract class.


-> The "Spell" abstract class, used to implement a "spell" casted by an entity.

-> The "Fire", "Ice" and "Earth" classes, which are implemented using the inheritance OOP concept, these ones being derived from the "Spell" abstract class.

-> The "Enemy" class, which describes an enemy using inheritance through the "Entity" class, and implements "Cell_Element" at the same time. An enemy has the chance of avoiding a hero attack. It contains the undiscussed method:
    - void enemy_attack(Character), which describes the way an enemy may attack a hero, using one or more spells or a normal attack.

-> The "Inventory" class, which describes the items of the character and the capacity that he can sustain. It contains the methods:
    - void add_potion(Potion), which adds a potion to the inventory;
    - void remove_potion(Potion), which removes a potion from the inventory;
    - int get_new_weight(), which returns the current cappacity of the inventory.

-> The "Potion" interface, which has the following methods:
    - void use_potion(Character), which applies the effects of the potion to the corresponding character;
    - int get_price_for_potion(), which returns the standard price of a potion;
    - int regenerate(), which return the regenerating points for the potion;
    - int get_potion_weight(), which returns the weight of a potion.

-> The "ManaPotion" and "HealthPotion" classes implements the "Potion" interface, each one describing the actual potion you choose to buy from the "Shop";

-> The "Shop" class, which implements a shop correpsonding to a cell. It contains the method:
    - Potion getPotion(int), which removes a potion from the list of potions the shop has, for a certain index.
