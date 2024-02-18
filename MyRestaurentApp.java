package vaibhav;

import java.util.*;

class Manager {
	private String mid;
	private String mpass;

	public Manager(String mid, String mpass) {
		this.mid = mid;
		this.mpass = mpass;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpass() {
		return mpass;
	}

	public void setMpass(String mpass) {
		this.mpass = mpass;
	}

}

class foodDetails {
	private String fname;
	private String fid;
	private String price;
	private String category;

	public foodDetails(String fid, String fname, String price, String category) {
		this.fname = fname;
		this.price = price;
		this.category = category;
		this.fid = fid;
	}

	public foodDetails() {

	}

	public String getFname() {
		return fname;
	}

	public String getPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}

	public String getfid() {
		return fid;
	}

}

class customer {
	private String id;
	private String cpass;
	private String cname;
	private String date;

	public customer(String id, String cpass, String cname, String date) {
		this.id = id;
		this.cpass = cpass;
		this.date = date;
		this.cname = cname;
	}

	public String getId() {
		return id;
	}

	public String getCpass() {
		return cpass;
	}

	public String getCname() {
		return cname;
	}

	public String getDate() {
		return date;
	}

}

public class MyRestaurentApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Vector v = new Vector();
		Vector fdv = new Vector();
		Vector cdv = new Vector();
		Manager m[] = new Manager[5];
		int mcount = 0;
		int ccount = 0;
		foodDetails fd[] = new foodDetails[100];
		customer cs[] = new customer[100];
		String mid;
		String mpass;
		do {

			System.out.println("Login");
			System.out.println("1:Manager");
			System.out.println("2:Coustomer");
			System.out.println("Enter your choice:");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("1:New Registration for Manager");
				System.out.println("2:You have Alredy login for manager:");

				int choice2 = sc.nextInt();
				switch (choice2) {

				case 1: {
					System.out.println("=======> Welcome Manager To Registraton <=========");
					System.out.println("Enter the new Manager id:");
					sc.nextLine();
					mid = sc.nextLine();
					System.out.println("Make a passward:");
					mpass = sc.nextLine();
					m[mcount] = new Manager(mid, mpass);
					v.add(m[mcount]);
					mcount++;
					System.out.println("Register successfully...");
					System.out.println("1:Back to login");
					int back = sc.nextInt();
					if (back == 1) {
						break;
					} else {
						System.out.println("Please press 1 for login");
					}

				}
					break;

				case 2: {

					System.out.println("=======> Welcome Manager To login <===========");
					System.out.println("Enter Manager id:");
					sc.nextLine();
					mid = sc.nextLine();
					System.out.println("Enter the passward:");
					mpass = sc.nextLine();
					boolean logIn = false;

					for (Object ob : v) {
						Manager mm = (Manager) ob;
						if (mid.equals(mm.getMid()) && mpass.equals(mm.getMpass())) {
							logIn = true;
							break;
						}
					}

					if (logIn) {

						System.out.println("=====>> Manager Login successfully <<=======");
						int foodcount = 0;
						int choice3;
						do {

							System.out.println("\n1:Add Food Details");
							System.out.println("2:Display all food details");
							System.out.println("3:Update food details by id ");
							System.out.println("4:Delete Food Details by id");
							System.out.println("5:Search food Details by food name");
							System.out.println("6:Exit");
							System.out.println("\nEnter your choice");
							choice3 = sc.nextInt();

							switch (choice3) {
							case 1:
								System.out.println("Enter the food id:");
								sc.nextLine();
								String fid = sc.nextLine();
								System.out.println("Enter the food name:");
								String fname = sc.nextLine();
								System.out.println("Enter the Price:");
								String price = sc.nextLine();
								System.out.println("Enter the food category:");
								String category = sc.nextLine();

								fd[foodcount] = new foodDetails(fid, fname, price, category);
								fdv.add(fd[foodcount]);
								foodcount++;
								break;

							case 2:
								System.out.println("==========>> All Food Details <<=========");
								System.out.println("food id" + "\t" + "Food Name" + "\t" + "Price" + "\t" + "Category");
								for (Object ob : fdv) {
									foodDetails fd1 = (foodDetails) ob;
									System.out.println(fd1.getfid() + "\t" + fd1.getFname() + "\t\t" + fd1.getPrice()
											+ "\t\t" + fd1.getCategory());

								}
								break;

							case 3:
								System.out.println("Enter the food id You Want to update food Details:");
								sc.nextLine();
								boolean flag = false;
								String foodId = sc.nextLine();
								for (Object ob : fdv) {
									foodDetails fd1 = (foodDetails) ob;
									if (foodId.equals(fd1.getfid())) {
										System.out.println("Enter new the food id:");
										// sc.nextLine();
										fid = sc.nextLine();
										System.out.println("Enter new the food name:");
										fname = sc.nextLine();
										System.out.println("Enter the new  Price:");
										price = sc.nextLine();
										System.out.println("Enter the new food category:");
										category = sc.nextLine();
										int foodIndex = fdv.indexOf(fd1);
										fd[foodIndex] = new foodDetails(fid, fname, price, category);
										fdv.set(foodIndex, fd[foodIndex]);
										flag = true;

									}

								}
								if (flag)
									System.out.println("food Details Update Successfully");
								else
									System.out.println("Invalid id");

								break;

							case 4:
								System.out.println("Enter the food id You Want to Delete food Details:");
								sc.nextLine();
								flag = false;
								foodId = sc.nextLine();
								Iterator i = fdv.iterator();
								while (i.hasNext()) {
									Object ob = i.next();
									foodDetails fd1 = (foodDetails) ob;
									if (foodId.equals(fd1.getfid())) {
										i.remove();
										flag = true;

									}
								}

								if (flag)
									System.out.println("food Details delete Successfully");
								else
									System.out.println("Invalid id");
								break;

							case 5:
								System.out.println("Enter the food name to search");
								sc.nextLine();
								fname = sc.nextLine();
								for (Object ob : fdv) {
									foodDetails fd1 = (foodDetails) ob;
									if (fname.equals(fd1.getFname())) {
										System.out.println(
												"food id" + "\t" + "Food Name" + "\t" + "Price" + "\t" + "Category");
										System.out.println(fd1.getfid() + "\t" + fd1.getFname() + "\t\t"
												+ fd1.getPrice() + "\t\t" + fd1.getCategory());
									}

								}

							}

						} while (choice3 != 6);

					}

					else {
						System.out.println("Invalid username and passward");
					}
				}

					break;

				default:
					System.out.println("Invalid choice");

				}
				break;
			// Coustomer login
			case 2:
				System.out.println("1:New Registration for customer");
				System.out.println("2:You have Alredy login customer");

				int choice4 = sc.nextInt();
				switch (choice4) {

				case 1:
					System.out.println("Enter the customer id:");
					sc.nextLine();
					String cid = sc.nextLine();
					System.out.println("Enter the customer Name:");
					String cname = sc.nextLine();
					System.out.println("Enter the date:");
					String date = sc.next();
					System.out.println("Enter the customer passward");
					sc.nextLine();
					String cpass = sc.nextLine();
					cs[ccount] = new customer(cid, cpass, cname, date);
					cdv.add(cs[ccount]);
					ccount++;
					System.out.println("Customer Registeratioin successfully...");
					System.out.println("1:Back to login");
					int back = sc.nextInt();
					if (back == 1) {
						break;
					} else {
						System.out.println("Please press 1 for login");
					}
					break;

				case 2:

					System.out.println("=======> Welcome To Customer login <===========");
					System.out.println("Enter Customer id:");
					sc.nextLine();
					cid = sc.nextLine();
					System.out.println("Enter the passward:");
					cpass = sc.nextLine();
					boolean logIn = false;

					for (Object ob : cdv) {
						customer cc = (customer) ob;
						if (cid.equals(cc.getId()) && cpass.equals(cc.getCpass())) {
							logIn = true;
							break;
						}
					}

					if (logIn) {

						System.out.println("=====>> Login successfully <<=======");
						do {
							System.out.println("\n1:Display all food details");
							System.out.println("2:Search  food details ");
							System.out.println("3:Purches food and display bill");
							System.out.println("Enter your choice");
							choice = sc.nextInt();
							switch (choice) {
							case 1:
								System.out.println("==========>> All Food Details <<=========");
								System.out.println("food id" + "\t" + "Food Name" + "\t" + "Price" + "\t" + "Category");
								for (Object ob : fdv) {
									foodDetails fd1 = (foodDetails) ob;
									System.out.println(fd1.getfid() + "\t" + fd1.getFname() + "\t\t" + fd1.getPrice()
											+ "\t\t" + fd1.getCategory());

								}
								break;

							case 2:
								System.out.println("\n1:by name");
								System.out.println("2:by price range");
								System.out.println("3:by category");
								System.out.println("Enter your choice:");
								choice = sc.nextInt();
								switch (choice) {
								case 1:
									System.out.println("Enter the food name to search");
									sc.nextLine();
									String fname = sc.nextLine();
									for (Object ob : fdv) {
										foodDetails fd1 = (foodDetails) ob;
										if (fname.equals(fd1.getFname())) {
											System.out.println("food id" + "\t" + "Food Name" + "\t" + "Price" + "\t"
													+ "Category");
											System.out.println(fd1.getfid() + "\t" + fd1.getFname() + "\t\t"
													+ fd1.getPrice() + "\t\t" + fd1.getCategory());
										}

									}

									break;

								case 2:

									System.out.println("Enter the food price range search");
									sc.nextLine();
									String price = sc.nextLine();
									for (Object ob : fdv) {
										foodDetails fd1 = (foodDetails) ob;
										int priceInt = Integer.parseInt(price);
										int getPrice = Integer.parseInt(fd1.getPrice());
										if (getPrice <= priceInt) {
											System.out.println("food id" + "\t" + "Food Name" + "\t" + "Price" + "\t"
													+ "Category");
											System.out.println(fd1.getfid() + "\t" + fd1.getFname() + "\t\t"
													+ fd1.getPrice() + "\t\t" + fd1.getCategory());
										}

									}

									break;

								case 3:
									System.out.println("Enter the food category to search");
									sc.nextLine();
									String category = sc.nextLine();
									for (Object ob : fdv) {
										foodDetails fd1 = (foodDetails) ob;
										if (category.equals(fd1.getCategory())) {
											System.out.println("food id" + "\t" + "Food Name" + "\t" + "Price" + "\t"
													+ "Category");
											System.out.println(fd1.getfid() + "\t" + fd1.getFname() + "\t\t"
													+ fd1.getPrice() + "\t\t" + fd1.getCategory());
										}

									}

									break;
								default:
									System.out.println("invaild choice");

								}
								break;

							case 3:
								System.out.println("Enter the food name to buy");
								sc.nextLine();
								String fname = sc.nextLine();
								for (Object ob : fdv) {
									foodDetails fd1 = (foodDetails) ob;
									if (fname.equals(fd1.getFname())) {
										System.out.println(
												"food id" + "\t" + "Food Name" + "\t" + "Price" + "\t" + "Category");
										System.out.println(fd1.getfid() + "\t" + fd1.getFname() + "\t\t"
												+ fd1.getPrice() + "\t\t" + fd1.getCategory());

										System.out.println("how many quantity you buy:");
										int fquantity = sc.nextInt();
										int priceInt = Integer.parseInt(fd1.getPrice());
										float bill = fquantity * priceInt;

										System.out.println("Amount:" + bill);
									}

								}

							}

						} while (choice != 4);

					}
				}

				break;

			}

		} while (true);

	}
}
