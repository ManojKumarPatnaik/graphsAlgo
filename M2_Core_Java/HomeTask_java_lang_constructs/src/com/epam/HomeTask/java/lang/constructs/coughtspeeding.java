package com.epam.HomeTask.java.lang.constructs;

public class coughtspeeding {
	
	public int caughtSpeeding(int speed, boolean isBirthday)
    {
    if(speed<=60||(isBirthday&&speed<=65)) return 0;
    else if(speed>=61&&speed<=80||(isBirthday&&speed<=85)) return 1;
    else return 2;
    }

	public static void main(String[] args) {
		coughtspeeding obj = new coughtspeeding();
		int x;
		x=obj.caughtSpeeding(60, false);
		x=obj.caughtSpeeding(65, true);
		x=obj.caughtSpeeding(65, true);
		x=obj.caughtSpeeding(87, true);
		switch(x) {
		case 0:
			System.out.println("No ticket");
			break;
		case 1:
			System.out.println("Small ticket");
			break;
		case 2:
			System.out.println("Big ticket");
			break;
		}
	}

}