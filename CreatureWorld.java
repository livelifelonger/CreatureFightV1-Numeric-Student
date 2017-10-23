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
    
    private int turnNumber;
    private String playerOneName;
    private String playerTwoName;
    
    private Menu oneFightMenu;
    private Menu oneSwitchMenu;
    private Menu twoFightMenu;
    private Menu twoSwitchMenu;
    
    
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
        
        turnNumber = 0;
        Greenfoot.start();
    }
    
    public void prepareCreatures()
    {
        addObject(playerOneCreature, playerOneCreature.getImage().getWidth()/2, getHeight() - playerOneCreature.getImage().getHeight()/2);
        
        
        
        addObject(playerTwoCreature, getWidth() - playerTwoCreature.getImage().getWidth()/2, playerTwoCreature.getImage().getHeight()/2);
        
        
        
    }
    
    public Creature getPlayerOne()
    {
        
        return playerOneCreature;
    }
    
    public Creature getPlayerTwo()
    {
        
        return playerTwoCreature;
        
    }
    
    public int getTurnNumber()
    {
    	  return turnNumber;

    }
        
        
        
    public void setTurnNumber( int turn )
    {
        turnNumber = turn;
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
        
        if ( turnNumber == 0)
            {
                playerOneName = JOptionPane.showInputDialog( "Player One, please enter your name:", null );
                playerTwoName = JOptionPane.showInputDialog( "Player Two, please enter your name:", null );
                oneFightMenu = new Menu( " Fight ", " Scratch \n Flamethrower ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
                
                oneSwitchMenu = new Menu( " Switch ", " Golem \n Ivysaur ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
                
                addObject( oneFightMenu, 173, getHeight() - 100 );
                addObject( oneSwitchMenu, 241, getHeight() - 100 );
                
                twoFightMenu =  new Menu( " Fight ", " Tackle \n Thunderbolt ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
                twoSwitchMenu = new Menu( " Switch ", " Lapras \n Pidgeot ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );

                addObject( twoFightMenu, 131,  75 );
                addObject( twoSwitchMenu, 199, 75 );
                
                turnNumber = 1;
            }
            else if( turnNumber >= 1 ) 
            {
                showText( playerOneName + ", Your Turn.", getWidth(), getHeight() + 26);
            }
            else
            {
                showText( playerTwoName + ", Your Turn.", getWidth(), getHeight() + 26);
            }
           
        
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
