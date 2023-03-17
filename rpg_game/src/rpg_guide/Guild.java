package rpg_guide;

import java.util.ArrayList;

public class Guild {
	private final int PARTY_SIZE = 4;
	private ArrayList<Unit> guildList = new ArrayList<>();
	private Unit[] partyList;
	private int count;
	private int log = -1;

	public void setGuild() {
		Unit temp = new Unit("파장세린", 3, 1000, 100, 10, 0);
		this.guildList.add(temp);
		temp = new Unit("오크보석", 1, 80, 7, 3, 0);
		this.guildList.add(temp);
		temp = new Unit("깍두기예지", 1, 50, 3, 1, 0);
		this.guildList.add(temp);
		temp = new Unit("딜러도하", 2, 70, 10, 2, 0);
		this.guildList.add(temp);
		temp = new Unit("탱커지은", 1, 200, 4, 8, 0);
		this.guildList.add(temp);
		temp = new Unit("힐러진경", -1, 1, 1, -1, 0);
		this.guildList.add(temp);
		for (int i = 0; i < 4; i++) {
			this.guildList.get(i).setParty(true);
		}
		this.partyList = new Unit[this.PARTY_SIZE];
		int n = 0;
		for (int i = 0; i < this.guildList.size(); i++) {
			if (this.guildList.get(i).isParty() == true) {
				this.partyList[n] = this.guildList.get(i);
				this.count++;
				n += 1;
			}
		}
	}

	public Unit getGuildUnit(int num) {
		return this.guildList.get(num);
	}

	public void printAllUnitStaus() {
		System.out.println("============= [길드원] =================");
		for (int i = 0; i < this.guildList.size(); i++) {
			System.out.println("[" + (i + 1) + "번]");
			System.out.print("[이름 : " + this.guildList.get(i).getName() + "]");
			System.out.print(" [레벨 : " + this.guildList.get(i).getLevel() + "]");
			System.out.print(" [체력 : " + this.guildList.get(i).getHp());
			System.out.println(" / " + this.guildList.get(i).getMaxHp() + "]");
			System.out.print("[공격력 : " + this.guildList.get(i).getAtt() + "]");
			System.out.print(" [방어력 : " + this.guildList.get(i).getDef() + "]");
			System.out.printf(" [파티 : %s]\n" , this.guildList.get(i).isParty() ? "O":"X");
		}
		System.out.println("======================================");
	}

	public void printUnitStaus(int num) {
		this.guildList.get(num).printStatus();
	}

	public void printUnitItem(int num) {
		this.guildList.get(num).printEquitedItem();
	}

	private void buyUnit() {
		if (Player.money < 5000)
			return;
		String[] n1 = { "강", "김", "남", "박", "임", "이", "정" };
		String[] n2 = { "상", "희", "주", "욱", "하", "지", "" };
		String[] n3 = { "욱", "진", "혁", "빈", "율", "민", "철" };

		String name = n1[MainGame.ran.nextInt(n1.length)];
		name += n2[MainGame.ran.nextInt(n1.length)];
		name += n3[MainGame.ran.nextInt(n1.length)];
		int ran = MainGame.ran.nextInt(8) + 2;
		int hp = ran * 11;
		int att = ran + 1;
		int def = ran / 2 + 1;
		Unit temp = new Unit(name, 1, hp, att, def, 0);

		System.out.println("=====================================");
		System.out.print("[이름 : " + name + "]");
		System.out.print(" [레벨 : " + 1 + "]");
		System.out.print(" [체력 : " + hp);
		System.out.println(" / " + hp + "]");
		System.out.print("[공격력 : " + att + "]");
		System.out.println(" [방어력 : " + def + "]");
		System.out.println("길드원을 추가합니다.");
		System.out.println("=====================================");

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		this.guildList.add(temp);
		Player.setMoney(Player.money - 5000);
		System.out.println("[보유골드 : " + Player.money + "]");
	}

	private void removeUnit() {
		printAllUnitStaus();
		System.out.println("삭제할 번호를 입력하세요 ");
		int sel = MainGame.scan.nextInt();
		if (sel <= 0 || sel > this.guildList.size()) {
			System.out.println("잘못된 입력입니다.");
		} else {
			if (guildList.get(sel - 1).isParty()) {
				System.out.println("파티중인 멤버는 삭제할수 없습니다.");
			} else {
				System.out.println("=================================");
				System.out.print("[이름 : " + this.guildList.get(sel - 1).getName() + "]");
				System.out.println("길드원을 삭제합니다.");
				System.out.println("=================================");
				this.guildList.remove(sel - 1);
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void printParty() {
		System.out.println("=============== [파티원] ==============");
		for (int i = 0; i < this.partyList.length; i++) {
			System.out.println("[" + (i + 1) + "번]");
			System.out.print("[이름 : " + this.partyList[i].getName() + "]");
			System.out.print(" [레벨 : " + this.partyList[i].getLevel() + "]");
			System.out.print(" [체력 : " + this.partyList[i].getHp());
			System.out.println(" / " + this.partyList[i].getMaxHp() + "]");
			System.out.print("[공격력 : " + this.partyList[i].getAtt() + "]");
			System.out.print(" [방어력 : " + this.partyList[i].getDef() + "]");
			System.out.printf(" [파티 : %s]\n" , this.guildList.get(i).isParty()? "O" : "X");
		}
		System.out.println("=====================================");
	}

	private void modifyParty() {
		System.out.println("[1.파티원교체] [2.파티원추가] [3.파티원삭제]");
		int sel = MainGame.scan.nextInt();

		if (sel == 1)
			partyChange();
		else if (sel == 2)
			addPartyUnit();
		else if (sel == 3)
			deletePartyUnit();
	}

	private void partyChange() {
		printParty();
		System.out.println("교체할 번호를 입력하세요 ");
		int partyNum = MainGame.scan.nextInt();
		printAllUnitStaus();
		System.out.println("참가할 번호를 입력하세요 ");
		int guildNum = MainGame.scan.nextInt();

		if (this.guildList.get(guildNum - 1).isParty() == false) {
			this.partyList[partyNum - 1].setParty(false);
			this.guildList.get(guildNum - 1).setParty(true);

			System.out.println("====================================");
			System.out.print("[이름 : " + this.partyList[partyNum - 1].getName() + "]");
			System.out.print("에서 ");
			System.out.print("[이름 : " + this.guildList.get(guildNum - 1).getName() + "]");
			System.out.println("으로 교체 합니다. ");
			System.out.println("====================================");

			int n = 0;
			for (int i = 0; i < this.guildList.size(); i++) {
				if (this.guildList.get(i).isParty()) {
					this.partyList[n] = this.guildList.get(i);
					n += 1;
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("이미 참여중인 파티원입니다.");
		}
	}

	private void addPartyUnit() {
		while(true) {
			if (this.partyList.length < this.PARTY_SIZE) {
				printAllUnitStaus();
				System.out.println("파티에 참여시킬 길드원 번호를 입력하세요 ");
				System.out.println(this.guildList.size());
				int guildNum = MainGame.scan.nextInt() - 1;
				if (guildNum < 0 || guildNum > this.guildList.size() - 1) {
					System.out.println("잘못된 입력입니다.");
				} else {
					if (this.guildList.get(guildNum).isParty() == false) {
						this.guildList.get(guildNum).setParty(true);
						System.out.println("====================================");
						System.out.print("[이름 : " + this.guildList.get(guildNum).getName() + "]");
						System.out.println("이 추가되었습니다. ");
						System.out.println("====================================");
						this.count++;
						this.partyList = new Unit[this.count];
						int n = 0;
						for (int i = 0; i < this.guildList.size(); i++) {
							if (this.guildList.get(i).isParty()) {
								this.partyList[n] = this.guildList.get(i);
								n += 1;
							}
						}
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("이미 참여중인 파티원입니다.");
					}
				}
			} else {
				System.out.println("파티는 최대 4인까지만 가능합니다.");
				break;
			}			
		}
	}

	private void deletePartyUnit() {
		while (true) {
			if(this.partyList.length>0) {
				printParty();
				System.out.println("삭제할 번호를 입력하세요 ");
				int sel = MainGame.scan.nextInt() - 1;
				if (sel < 0 || sel > this.partyList.length - 1) {
					System.out.println("잘못된 입력입니다.");
				} else {
					System.out.println("=================================");
					System.out.print("[이름 : " + this.partyList[sel].getName() + "]");
					System.out.println("파티원을 삭제합니다.");
					System.out.println("=================================");
					
					for (int i = 0; i < this.guildList.size(); i++) {
						if (this.guildList.get(i).getName().equals(this.partyList[sel].getName())) {
							this.guildList.get(i).setParty(false);
							this.count--;
						}
					}
					this.partyList = new Unit[this.count];
					int n = 0;
					for (int i = 0; i < this.guildList.size(); i++) {
						if (this.guildList.get(i).isParty() == true) {
							this.partyList[n] = this.guildList.get(i);
							n += 1;
						}
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					printParty();
					break;
				}				
			}
			else {
				System.out.println("삭제할 파티원이 존재하지 않습니다.");
				break;
			}
		}
	}

	private void arrayUnit() {
		System.out.println("============ [정렬] =============");
		System.out.println("[1.레벨순] [2.이름순] [3.공격력순]");
		int sel = MainGame.scan.nextInt();
		if (sel == 1)
			sortOfLevel();
		else if (sel == 2)
			sortOfName();
		else if (sel == 3)
			sortOfAtt();
	}

	private void sortOfLevel() {
		for (int i = 0; i < this.guildList.size(); i++) {
			int max = this.guildList.get(i).getLevel();
			int index = i;
			for (int j = i; j < this.guildList.size(); j++) {
				if (this.guildList.get(j).getLevel() > max) {
					max = this.guildList.get(j).getLevel();
					index = j;
				}
			}
			Unit temp = this.guildList.get(i);
			this.guildList.set(i, this.guildList.get(index));
			this.guildList.set(index, temp);
		}
		printAllUnitStaus();		
	}

	private void sortOfName() {
		for (int i = 0; i < this.guildList.size(); i++) {
			String first = this.guildList.get(i).getName();
			int idx = i;
			for (int j = i; j < this.guildList.size(); j++) {
				String name = this.guildList.get(j).getName();
				if (first.compareTo(name) > 0) {
					first = this.guildList.get(j).getName();
					first = name;
					idx = j;
				}
			}
			Unit temp = this.guildList.get(i);
			this.guildList.set(i, this.guildList.get(idx));
			this.guildList.set(idx, temp);
		}
		printAllUnitStaus();
	}

	private void sortOfAtt() {
		for (int i = 0; i < this.guildList.size(); i++) {
			int max = this.guildList.get(i).getAtt();
			int index = i;
			for (int j = i; j < this.guildList.size(); j++) {
				if (this.guildList.get(j).getAtt() > max) {
					max = this.guildList.get(j).getAtt();
					index = j;
				}
			}
			Unit temp = this.guildList.get(i);
			this.guildList.set(i, this.guildList.get(index));
			this.guildList.set(index, temp);
		}
		printAllUnitStaus();
	}

	public void guildMenu() {
		while (true) {
			System.out.println("============= [길드관리] ==============");
			System.out.println("[1.길드목록] [2.길드원추가] [3.길드원삭제]\n" + "[4.파티수정] [5.길드원정렬] [0.뒤로가기]");
			int sel = MainGame.scan.nextInt();
			if (sel == 1) {
				printAllUnitStaus();
			} else if (sel == 2) {
				buyUnit();
			} else if (sel == 3) {
				removeUnit();
			} else if (sel == 4) {
				modifyParty();
			} else if (sel == 5) {
				arrayUnit();
			} else if (sel == 0) {
				break;
			}
		}
	}

	public ArrayList<Unit> getGuildList() {
		return (ArrayList<Unit>) guildList.clone();
	}

	public void jobMenu() {
		while (true) {
			System.out.println("[1.전직] [0.뒤로가기]");
			int sel = MainGame.scan.nextInt();
			if (sel == 1)
				newJob();
			else if (sel == 0)
				break;
		}
	}

	private void newJob() {
		System.out.println("전직할 캐릭터를 선택해주세요.");
		printAllUnitStaus();
		int sel = MainGame.scan.nextInt() - 1;

	}

}