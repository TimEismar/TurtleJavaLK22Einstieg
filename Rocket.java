import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Turtle
{
    
    private double diste;
    private double startX;
    private double startY;
    private double x;
    private double y;
    private boolean penDown;
    private double direction;
    
    double rot = getRotation();
    
    //Variabeln noLoop
        boolean start = false;
        boolean ende = false;
        int eins = 0;
        int zwei = 0;
        
        private int t ;
        
    
    
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void Neck(int laenge, int n) 
    {
       
        setLocation(400 - laenge / n, 50);
        penDown();
        double winkel = 360 / n;
        for (int i=0; i < n; i++) {
            move(laenge / n);
            turn(winkel);
        }
        
    
    }    
    
    public void test(){
        int rot1 = getRotation();
        System.out.println(rot1);
        turn(180);
         int rot2 = getRotation();
        System.out.println(rot2);
        Greenfoot.delay(10);
        move(10);
    }
    
    
    
    public void Rekursion(double abc){
        //Zielangabe
        double ende1 = abc + startX;
        
        //Stift-Aktivierung
        penDown();
        
        //Grundwerte werden gespeichert
        if(start == false){
            startX = getX();/*Start X-Wert wird gespeichert*/
            startY = getY();/*Start Y-Wert wird gespeichert*/
            move(1);/*Es wird sich eins vom Start wegbewegt*/
            start = true; /*Start If-Bedingung wird umgangen*/
            diste = abc; /*Gewünschte Distanz wird gespeichert*/
        }
        
        //Hinweg
        if (getX() != ende1 && eins == 0){
            setColor("yellow");/*Stiftfarbe wird geändert*/
            move(1);/*Bewegen um 1*/
            Greenfoot.delay(2);/*Delay von 2*/
            Rekursion(diste);/*Rekursion der Methode "Rekursion"*/
        }
        
        //Rückweg
        else{
            if(getX() != startX){
            eins = 1; /*Hinweg wird au?er Kraft gesetzt*/
            setColor("red");/*Stiftfarbe wird geändert*/
            if(getX() == ende1){turn(180);}/*Umdrehen*/
            move(1);/*Bewegen um 1*/
            Greenfoot.delay(2);/*Delay von 2*/
            Rekursion(diste);/*Rekursion der Methode "Rekursion"*/
        }
        }
        
        //Endausrichtung
        if(getX() == startX && ende == false){
            turn(180);/*Ausgangsrotation wird eingenommen*/
            Greenfoot.delay(15);/*Delay von 15*/
            System.out.println("Es wurden " + diste + " Schritte hin und zurück gegangen =)");/*Satz zum Ende*/
            ende = true;/*Ende wird auser Kraft gesetzt*/
        }
        }
        
        public void RichtigeRekursion (int t){
        
            if (t != 0) {
                move(1);
                RichtigeRekursion(t - 1);
                move(1);
            }
            else{ turn(180);}
        }
       
    }
    
