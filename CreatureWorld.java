import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.JOptionPane;
import java.util.List;

/**
 * Desrosiers, Devyn
 * CS20S
 * Mr.Hardman 
 * Lab#1, Program#1
 * Date Last Modified 9/27/2017
 */
public class CreatureWorld extends World
{
    private Creature playerOneCreature;
    private Creature playerTwoCreature;
    
    /**
     * Default constructor for objects of class MyWorld.
     * 
     * @param There are no parameters
     * @return an object of class MyWorld
     */
    public CreatureWorld()
    
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 400, 1); 
        playerOneCreature = new Charmander(this);
        playerTwoCreature = new Pikachu(this);
        
        
        prepareCreatures();
        
        
        Greenfoot.start();
    }
    
    public void prepareCreatures()
    {
        addObject(playerOneCreature, playerOneCreature.getImage().getWidth()/2, getHeight() - playerOneCreature.getImage().getHeight()/2);
        addObject(new Button(Color.RED, 50),getWidth()/2 , getHeight () -100 );
        
        
        addObject(playerTwoCreature, getWidth() - playerTwoCreature.getImage().getWidth()/2, playerTwoCreature.getImage().getHeight()/2);
        addObject(new Button(Color.RED, 50),getWidth()/2  , getHeight ()/2 - 100);
        
        
    }
    
    public Creature getPlayerOne()
    {
        
        return playerOneCreature;
    }
    
    public Creature getPlayerTwo()
    {
        return playerTwoCreature;
    }
    
    /**
     * act will complete actions that the CreatureWorld object should
     * accomplish while the scenario is running
     * ++++++
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
        List allObjects=getObjects(null);
        
        if ( playerOneCreature.getHealthBar().getCurrent() <= 0)
        {
            removeObjects(allObjects);
            showText("player Two has Won", getWidth()/2, getHeight()/2 + 26);
            Greenfoot.stop();
        }
        
        if ( playerTwoCreature.getHealthBar().getCurrent() <= 0)
        {
            showText("player One has Won", getWidth()/2, getHeight()/2 + 26);
            Greenfoot.stop();
        }
        
    }
}
