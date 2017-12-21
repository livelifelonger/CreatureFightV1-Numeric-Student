import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Creature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creature extends Actor
{
    
    private boolean playerOneCreature;
    private HealthBar creatureBar;
    private int healthNumber;
    private String type;
    
    /**
     * Default constructor for objects of the Creature class
     * 
     * @param There are no parameters
     * @return an object of the Creature class
     */
    public Creature()
    {
        healthNumber = 500;
        
        playerOneCreature = true;
        
        creatureBar = new HealthBar( healthNumber, healthNumber, 10);
    }

    /**
     * Constructor that allows customization o f objects of the Creature class
     * 
     * @param health is the amount of health the Creature object will have
     * @param whichPlayer discusses whether the creature belongs to player 1 or player 2
     * @return an object of the Creature class
     */
    public Creature( int health, boolean isPlayerOne, String creatureType )
    {
        healthNumber = health;
        
        playerOneCreature = isPlayerOne;
        
        type = creatureType;
        
        creatureBar = new HealthBar( healthNumber, healthNumber, 10);
    }
    
    public String getType()
    {
        return type;
    }

    
    protected HealthBar getHealthBar()
    {
        return creatureBar;
    }
    
    public boolean getWhetherPlayerOne()
    {
        return  playerOneCreature;
    }

    /**
     * attack is the code that is run when the Creature attacks its enemy
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void attack(int idx)
    {
        //empty method that will get overriden in subclasses
    }
    
    public void switchCreature(int idx)
    {
        //empty method that will get overriden in subclasses
    }
    
    public void switchedIn()
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
