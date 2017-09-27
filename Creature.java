import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Creature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creature extends Actor
{
    
    private int playerOwnership;
    private HealthBar creatureBar;
    private int HealthNumber;
    
    /**
     * Default constructor for objects of the Creature class
     * 
     * @param There are no parameters
     * @return an object of the Creature class
     */
    public Creature()
    {
        HealthNumber = 500;
        playerOwnership = 0;
        creatureBar = new HealthBar( HealthNumber, HealthNumber, 10);

    }

    /**
     * Constructor that allows customization o f objects of the Creature class
     * 
     * @param health is the amount of health the Creature object will have
     * @param whichPlayer discusses whether the creature belongs to player 1 or player 2
     * @return an object of the Creature class
     */
    public Creature( int health, int whichPlayer )
    
    
    
    {
        HealthNumber = health;
        playerOwnership = whichPlayer;
        creatureBar = new HealthBar( HealthNumber, HealthNumber, 10);
    }
    
    protected HealthBar getHealthBar()
    {
        return creatureBar;
    }
    
    public int getPlayerOwnership()
    {
        return playerOwnership;
    }

   /**
     * attack is the code that is run when the Creature attacks its enemy
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void attack()
    {
        //empty method that will get overriden in subclasses
    }

    /**
     * act will complete actions that the Creature object should
     * accomplish while the scenario is running
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act() 
    {
        //empty method that will get overriden in subclasses
    }   

}
