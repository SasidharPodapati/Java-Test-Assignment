import java.util.*;
import java.lang.*;

public class Solution {
	public static int randInt(int min, int max) {
		Random rand = null;
		int randomNum = 0;
		randomNum = min + (int) (Math.random() * ((max - min) + 1));
		return randomNum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your animal or stop to exit");
		ArrayList<String> animalArray = new ArrayList<String>();
		/* Generated an arraylist of animals */
		ArrayList<Animal> animals = new ArrayList<Animal>();
		/* Generated an arraylist of animals */
		String animal = sc.nextLine();
		while (!animal.equalsIgnoreCase("stop")) {
			animalArray.add(animal);
			// System.out.println("The animal entered is "+animal);
			if (animal.split(" ")[0].equalsIgnoreCase("Dog")) {
				Dog dog = new Dog();
				dog.setName(animal);
				System.out.println("Enter the dog's favourite food");
				String favouriteFood = sc.nextLine();
				dog.setFavouriteFood(favouriteFood);
				System.out.println("Enter the dog's type");
				String dogType = sc.nextLine();
				dog.setDogType(dogType);
				animals.add(dog);
			} else if (animal.split(" ")[0].equalsIgnoreCase("Parrot")) {

				Parrot parrot = new Parrot();
				parrot.setName(animal);
				System.out.println("Enter the parrots's favourite food");
				String favouriteFood = sc.nextLine();
				parrot.setFavouriteFood(favouriteFood);
				System.out.println("Can the parrot speak, type yes or no");
				String isSpeaking = sc.nextLine();
				if (isSpeaking.equalsIgnoreCase("yes")) {
					parrot.setSpeak(true);
				} else if (isSpeaking.equalsIgnoreCase("no")) {
					parrot.setSpeak(false);
				}
				System.out.println("Enter the parrot's wingspan");
				float wingSpan;
				try {
					wingSpan = Float.valueOf(sc.nextLine());
					parrot.setWingSpan(wingSpan);
				} catch (Exception e) {
					e.printStackTrace();
				}
				animals.add(parrot);
				// System.out.println(parrot.isSpeak());

			} else if (animal.split(" ")[0].equalsIgnoreCase("Chicken")) {
				Chicken chicken = new Chicken();
				chicken.setName(animal);
				System.out.println("Enter the chicken's favourite food");
				String favouriteFood = sc.nextLine();
				chicken.setFavouriteFood(favouriteFood);
				System.out.println("Is the chicken a broiler? Type yes or no");
				String isBroiler = sc.nextLine();
				if (isBroiler.equalsIgnoreCase("yes")) {
					chicken.setBroiler(true);
				} else if (isBroiler.equalsIgnoreCase("no")) {
					chicken.setBroiler(false);
				}
				System.out.println("Enter the chicken's wingspan");
				float wingSpan;
				try {
					wingSpan = Float.valueOf(sc.nextLine());
					chicken.setWingSpan(wingSpan);
				} catch (Exception e) {
					e.printStackTrace();
				}

				animals.add(chicken);
			}

			System.out.println("Enter another animal or stop to exit");
			animal = sc.nextLine();
			boolean flag = false;
			for (int i = 0; i < animals.size(); i++) {
				if (animals.get(i).getName().equalsIgnoreCase(animal)) {
					flag = true;
				}
			}
			if (flag) {
				System.out.println("The animal already exists. Enter another animal or stop to exit");
				animal = sc.nextLine();
			}
		}
		// testing
		// Test Case
		/*
		 * Dog d1 = new Dog(); d1.setName("dog one");
		 * d1.setFavouriteFood("meat"); d1.setDogType("hunting dog");
		 * animals.add(d1); Dog d2 = new Dog(); d2.setName("dog two");
		 * d2.setFavouriteFood(" fresh meat"); d2.setDogType("assisting dog");
		 * animals.add(d2); Dog d3 = new Dog(); d3.setName("dog three");
		 * d3.setFavouriteFood("pedigree"); d3.setDogType("racing dog");
		 * animals.add(d3); Parrot p1=new Parrot(); p1.setName("Parrot One");
		 * p1.setFavouriteFood("Corn"); p1.setWingSpan((float) 0.75);
		 * p1.setSpeak(true); animals.add(p1); Parrot p2=new Parrot();
		 * p2.setName("Parrot Two"); p2.setFavouriteFood("Corn");
		 * p2.setWingSpan((float) 0.25); p2.setSpeak(false); animals.add(p2);
		 * Chicken c1=new Chicken(); c1.setName("Chicken One");
		 * c1.setFavouriteFood("Corn"); c1.setBroiler(true);
		 * c1.setWingSpan((float)0.75); animals.add(c1); Chicken c2=new
		 * Chicken(); c2.setName("Chicken Two"); c2.setFavouriteFood("Corn");
		 * c2.setBroiler(false); c2.setWingSpan((float)0.5); animals.add(c2);
		 */
		// testing
		/* Code for creating the friends list */
		HashMap<Animal, ArrayList<Animal>> friendsMap = new HashMap<Animal, ArrayList<Animal>>();
		for (int i = 0; i < animals.size(); i++) {
			ArrayList<Animal> animalList = new ArrayList<Animal>();
			friendsMap.put(animals.get(i), animalList);
		}

		/* Code for creating the friends list */
		System.out.println("Choose an option - list (Lists animal props)/ listfriends (Lists Friends)  ");
		System.out.println("/ liveoneday (Live One Day) / exit");
		String option = sc.nextLine();
		while (!option.equalsIgnoreCase("exit")) {
			if (option.equalsIgnoreCase("list")) {
				System.out.println("Your animals are:");

				for (int i = 0; i < animals.size(); i++) {
					System.out.println("___" + animals.get(i).getClass().getName() + "___");
					System.out.println("Name:" + animals.get(i).getName());
					if (animals.get(i).getClass().getName().equalsIgnoreCase("dog")) {
						Dog dog = (Dog) animals.get(i);
						System.out.println("Dog Type:" + dog.getDogType());
						System.out.println("Favourite Food:" + dog.getFavouriteFood());
						/* Friends */
						listfriends(animals, friendsMap, i);
						/* Friends */
					} else if (animals.get(i).getClass().getName().equalsIgnoreCase("chicken")) {
						Chicken chicken = (Chicken) animals.get(i);
						if (chicken.isBroiler()) {
							System.out.println("Is Broiler");
						} else {
							System.out.println("Is Not Broiler");
						}
						System.out.println("Favourite Food:" + chicken.getFavouriteFood());
						System.out.println("Wingspan:" + chicken.getWingSpan());
						/* Friends */
						listfriends(animals, friendsMap, i);
						/* Friends */
					} else if (animals.get(i).getClass().getName().equalsIgnoreCase("parrot")) {
						Parrot parrot = (Parrot) animals.get(i);
						if (parrot.isSpeak()) {
							System.out.println("Can Speak");
						} else {
							System.out.println("Cannot Speak");
						}
						System.out.println("Favourite Food:" + parrot.getFavouriteFood());
						System.out.println("Wingspan:" + parrot.getWingSpan());
						/* Friends */
						listfriends(animals, friendsMap, i);
						/* Friends */
					}
				}

			}

			else if (option.equalsIgnoreCase("listfriends")) {
				for (int i = 0; i < animals.size(); i++) {
					if (friendsMap.get(animals.get(i)).size() == 0) {
						System.out.println(animals.get(i).getName() + " has no friends");
					} else {
						System.out.print(animals.get(i).getName() + " has ");
						for (int j = 0; j < friendsMap.get(animals.get(i)).size(); j++) {
							if (j == friendsMap.get(animals.get(i)).size() - 1) {
								System.out.print(friendsMap.get(animals.get(i)).get(j).getName() + " ");
							} else {
								System.out.print(friendsMap.get(animals.get(i)).get(j).getName() + ", ");
							}
						}
						System.out.println("as a friend");
					}
				}
			}

			else if (option.equalsIgnoreCase("liveoneday")) {
				boolean startCondition = true;
				HashMap<Integer, Animal> lostFriends = new HashMap<Integer, Animal>();
				HashMap<Integer, Animal> gainedFriends = new HashMap<Integer, Animal>();
				Random randomizer = new Random();

				for (int i = 0; i < animals.size(); i++) {

					if (friendsMap.get(animals.get(i)).size() != 0) {
						startCondition = false;
					}
				}

				// System.out.println("start"+startCondition);

				if (startCondition && animals.size() > 2) {
					// If there are no friends for any animal - start condition
					for (int i = 0; i < animals.size(); i++) {
						if (gainedFriends.get(i) != null && friendsMap.get(animals.get(i)).size() == 1) {
							continue;
						} else {
							int count = 0;
							for (int l = 0; l < animals.size(); l++) {
								if (gainedFriends.get(l) != null) {
									count++;
								}
							}
							if (count == animals.size() - 1) {
								break;
							}
							// The process of gaining a friend
							boolean keyStone = false;
							if (friendsMap.get(animals.get(i)).size() == 1) {
								continue;
							} else {
								Animal randomAnimalFriendGained = animals.get(randomizer.nextInt(animals.size()));
								// System.out.println(randomAnimalFriendGained.getName());
								/*
								 * String key=sc.next();
								 * while(!key.equalsIgnoreCase("p")) {
								 * 
								 * }
								 */
								for (int m = 0; m < animals.size(); m++) {
									if (gainedFriends.get(m) != null && gainedFriends.get(m).getName()
											.equalsIgnoreCase(randomAnimalFriendGained.getName())) {
										keyStone = true;
									}
								}
								if (randomAnimalFriendGained.getName().equalsIgnoreCase(animals.get(i).getName())) {
									keyStone = true;
									/* System.out.println("This is true"); */
								}
								while (keyStone == true) {
									randomAnimalFriendGained = animals.get(randomizer.nextInt(animals.size()));
									// System.out.println(randomAnimalFriendGained.getName());
									keyStone = false;
									for (int m = 0; m < animals.size(); m++) {
										if (gainedFriends.get(m) != null && gainedFriends.get(m).getName()
												.equalsIgnoreCase(randomAnimalFriendGained.getName())) {
											keyStone = true;
										}
									}
									if (randomAnimalFriendGained.getName().equalsIgnoreCase(animals.get(i).getName())) {
										keyStone = true;
									}

								}

								gainedFriends.put(i, randomAnimalFriendGained);
								friendsMap.get(animals.get(i)).add(randomAnimalFriendGained);
								// System.out.println(animals.get(i).getName()+"
								// has established friendship with
								// "+randomAnimalFriendGained.getName());
								int j;
								for (j = 0; j < animals.size(); j++) {
									if (randomAnimalFriendGained.getName().equalsIgnoreCase(animals.get(j).getName())) {
										break;
									}
								}
								friendsMap.get(randomAnimalFriendGained).add(animals.get(i));
								gainedFriends.put(j, animals.get(i));
								// System.out.println(randomAnimalFriendGained.getName()+"
								// has established friendship with
								// "+animals.get(i).getName());

							}

						}

					}

				} else if (animals.size() == 1) {
					System.out.println("No further friendships are possible for one animal.");
					System.out.println("Please exist and re-enter animals");
				} else if (animals.size() == 2) {
					if (startCondition) {
						friendsMap.get(animals.get(0)).add(animals.get(1));
						gainedFriends.put(0, animals.get(1));
						friendsMap.get(animals.get(1)).add(animals.get(0));
						gainedFriends.put(1, animals.get(0));

					} else {
						friendsMap.get(animals.get(0)).remove(0);
						lostFriends.put(0, animals.get(1));
						friendsMap.get(animals.get(1)).remove(0);
						lostFriends.put(1, animals.get(0));
					}
				} else if (startCondition == false && animals.size() > 2) {
					lostFriends = new HashMap<Integer, Animal>();
					gainedFriends = new HashMap<Integer, Animal>();
					randomizer = new Random();
					for (int i = 0; i < animals.size(); i++) {
						if (lostFriends.get(i) == null) {
							if (friendsMap.get(animals.get(i)) != null && friendsMap.get(animals.get(i)).size() > 0) {
								lostFriends.put(i, friendsMap.get(animals.get(i)).get(0));
								int j;
								for (j = 0; j < animals.size(); j++) {
									if (friendsMap.get(animals.get(i)).get(0).getName()
											.equalsIgnoreCase(animals.get(j).getName())) {
										break;
									}
								}
								lostFriends.put(j, animals.get(i));
								// System.out.println(animals.get(i).getName()+"has
								// lost friend "+animals.get(j).getName());
								// System.out.println(animals.get(j).getName()+"has
								// lost friend "+animals.get(i).getName());
								friendsMap.get(animals.get(j)).remove(0);
								friendsMap.get(animals.get(i)).remove(0);
							}
						}

					}
					for (int i = 0; i < animals.size(); i++) {
						if (gainedFriends.get(i) != null && friendsMap.get(animals.get(i)).size() == 1) {
							continue;
						} else {
							int count = 0;
							for (int l = 0; l < animals.size(); l++) {
								if (gainedFriends.get(l) != null) {
									count++;
								}
							}
							if (count == animals.size() - 1) {
								break;
							}
							boolean keyStone = false;
							Animal randomAnimalFriendGained = animals.get(randomizer.nextInt(animals.size()));
							// System.out.println(randomAnimalFriendGained.getName());
							/*
							 * String key=sc.next();
							 * while(!key.equalsIgnoreCase("p")) {
							 * 
							 * }
							 */
							if (lostFriends.get(i) == null) {
								continue;
							}
							for (int m = 0; m < animals.size(); m++) {
								if (gainedFriends.get(m) != null && gainedFriends.get(m).getName()
										.equalsIgnoreCase(randomAnimalFriendGained.getName())) {
									keyStone = true;
								}
							}
							if (randomAnimalFriendGained.getName().equalsIgnoreCase(animals.get(i).getName())
									|| (lostFriends.get(i) != null && randomAnimalFriendGained.getName()
											.equalsIgnoreCase(lostFriends.get(i).getName()))) {
								keyStone = true;
								/* System.out.println("This is true"); */
							}
							while (keyStone == true) {
								randomAnimalFriendGained = animals.get(randomizer.nextInt(animals.size()));
								// System.out.println(randomAnimalFriendGained.getName());
								keyStone = false;
								for (int m = 0; m < animals.size(); m++) {
									if (gainedFriends.get(m) != null && gainedFriends.get(m).getName()
											.equalsIgnoreCase(randomAnimalFriendGained.getName())) {
										keyStone = true;
									}
								}
								if (randomAnimalFriendGained.getName().equalsIgnoreCase(animals.get(i).getName())
										|| (lostFriends.get(i) != null && randomAnimalFriendGained.getName()
												.equalsIgnoreCase(lostFriends.get(i).getName()))) {
									keyStone = true;
								}

							}

							gainedFriends.put(i, randomAnimalFriendGained);
							friendsMap.get(animals.get(i)).add(randomAnimalFriendGained);
							// System.out.println(animals.get(i).getName()+" has
							// established friendship with
							// "+randomAnimalFriendGained.getName());
							int j;
							for (j = 0; j < animals.size(); j++) {
								if (randomAnimalFriendGained.getName().equalsIgnoreCase(animals.get(j).getName())) {
									break;
								}
							}
							friendsMap.get(randomAnimalFriendGained).add(animals.get(i));
							gainedFriends.put(j, animals.get(i));
							// System.out.println(randomAnimalFriendGained.getName()+"
							// has established friendship with
							// "+animals.get(i).getName());
						}

					}

				}
				for (int i = 0; i < animals.size(); i++) {
					if (lostFriends.get(i) == null) {
						System.out.println(animals.get(i).getName() + " has lost friendship with none.");
					} else {
						System.out.println(animals.get(i).getName() + " has lost friendship with "
								+ lostFriends.get(i).getName() + ".");
					}
					if (gainedFriends.get(i) == null) {
						System.out.println(animals.get(i).getName() + " has established friendship with none.");
					} else {
						System.out.println(animals.get(i).getName() + " has established friendship with "
								+ gainedFriends.get(i).getName() + ".");
					}
				}

			} else {
				System.out.println("Invalid Option");
			}

			System.out.println("Choose an option - list (Lists animals)/ listfriends (Lists Friends)  ");
			System.out.println("/ liveoneday (Live One Day) / exit");
			option = sc.nextLine();

		}
		System.out.println("Thank You");
	}

	private static void listfriends(ArrayList<Animal> animals, HashMap<Animal, ArrayList<Animal>> friendsMap,
			Integer i) {
		// TODO Auto-generated method stub
		/* hELLO */

		if (friendsMap.get(animals.get(i)).size() == 0) {
			System.out.println(animals.get(i).getName() + " has no friends");
		} else {
			System.out.print(animals.get(i).getName() + " has ");
			for (int j = 0; j < friendsMap.get(animals.get(i)).size(); j++) {
				if (j == friendsMap.get(animals.get(i)).size() - 1) {
					System.out.print(friendsMap.get(animals.get(i)).get(j).getName() + " ");
				} else {
					System.out.print(friendsMap.get(animals.get(i)).get(j).getName() + ", ");
				}
			}
			System.out.println("as a friend");
		}

		/* HELLO */
	}

}
