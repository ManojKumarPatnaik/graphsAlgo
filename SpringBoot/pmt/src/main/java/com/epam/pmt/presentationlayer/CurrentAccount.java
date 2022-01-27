package com.epam.pmt.presentationlayer;

import com.epam.pmt.entity.MasterUser;

public class CurrentAccount {
	protected MasterUser currentUser=null;
	private static  CurrentAccount singleton=null;
    private CurrentAccount(){

    }
    public static CurrentAccount getInstance(){
        if(singleton==null){
            singleton=new CurrentAccount();

        }
        return  singleton;
    }
	
    public MasterUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(MasterUser currentUser) {
        this.currentUser = currentUser;
    }
    
}
