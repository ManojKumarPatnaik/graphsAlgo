package com.buildappswithpaulo.com;


class Login<T> {
    private T name,  password;


    public void Login(){

    }
    public Login(T name, T password){
        this.name = name;
        this.password = password;

    }
}

public class Ball { // Outer class
    private String ballName;
    private int ballSize;

    public void setUpBall() {

        Login<String> login = new Login("name", "password");


         new OrangeBall().setUpOrangeBall();

    }

    //Inner class
    class OrangeBall{
        public void setUpOrangeBall() {
            ballName = "Inside Inner Class Ball";
            ballSize = 23;

            System.out.println(ballName + ", " + ballSize);
        }

    }
}
