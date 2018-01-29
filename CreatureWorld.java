import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.JOptionPane;
import java.util.List;

/**
 * Desrosiers, Devyn
 * CS20S
 * Mr.Hardman 
 * Lab#1, Program#1
 * Date Last Modified 12/14/2017
 */
public class CreatureWorld extends World
{
    private String playerOneCreature;
    private String playerTwoCreature;
    
    private Creature[] playerOneCreatures;
    private Creature[] playerTwoCreatures;
    
    private String playerOneName;
    private String playerTwoName;
    
    private Menu oneFightMenu;
    private Menu oneSwitchMenu;
    private Menu twoFightMenu;
    private Menu twoSwitchMenu;
    
    private boolean start;
    private boolean playerOneTurn;
    private boolean playerOneMenusAdded;
    private boolean playerTwoMenusAdded;
    
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
        
        start = true;
        
        playerOneCreature = "Charmander";
        playerTwoCreature = "Pikachu";
        //What, I need to fix this... 2c ii
        
        playerOneTurn = false;
        
        playerOneCreatures = new Creature[]{ new Charmander(this), new Golem(this), new Ivysaur(this)};
        playerTwoCreatures = new Creature[]{ new Pikachu(this), new Lapras(this), new Pidgeot(this)};
        
        
        prepareCreatures();
        
        playerOneTurn = false;
        Greenfoot.start();
    }
    
    /**
     * prepareCreatures makes all creatures and adds them to the world
     * 
     * @param There are no parameters
     * @return an object of class MyWorld
     */
    public void prepareCreatures()
    {
        for(int i = 0; i < playerOneCreatures.length; i++ )
        {
            if( i == 0)
            {
                addObject(playerOneCreatures[i], playerOneCreatures[i].getImage().getWidth()/2, getHeight() - playerOneCreatures[i].getImage().getHeight()/2);
            }
            else
            {
                playerOneCreatures[i].getImage().setTransparency(0);
                addObject(playerOneCreatures[i], 0, getHeight() - playerOneCreatures[i].getImage().getHeight()/2);
            }
        }
        for(int j = 0; j < playerTwoCreatures.length; j++ )
        {
            if( j == 0)
            {
                addObject(playerTwoCreatures[j], getWidth() - playerTwoCreatures[j].getImage().getWidth()/2, playerTwoCreatures[j].getImage().getHeight()/2);
                
            }
            else
            {
                playerTwoCreatures[j].getImage().setTransparency(0);
                addObject(playerTwoCreatures[j], getWidth(), playerTwoCreatures[j].getImage().getHeight()/2);
            }
        }
    }
    
    /**
     * getPlayerOne gets current playerOneCreature and returns it
     * 
     * @param There are no parameters
     * @return a playerOneCreature object
     */
    public Creature getPlayerOne()
    {
        Creature currentPlayerOne;
        if(playerOneCreature.equalsIgnoreCase("Charmander"))
        {
            currentPlayerOne = playerOneCreatures[0];
        }
        else if(playerOneCreature.equalsIgnoreCase("Golem"))
        {
            currentPlayerOne = playerOneCreatures[1];
        }
        else
        {
            currentPlayerOne = playerOneCreatures[2];
        }
        return currentPlayerOne;
    }
    
    /**
     * getPlayerOne gets current playerTwoCreature and returns it
     * 
     * @param There are no parameters
     * @return a playerTwoCreature object
     */
    public Creature getPlayerTwo()
    {
        Creature currentPlayerTwo;
        if(playerTwoCreature.equalsIgnoreCase("Pikachu"))
        {
            currentPlayerTwo = playerTwoCreatures[0];
        }
        else if(playerTwoCreature.equalsIgnoreCase("Lapras"))
        {
            currentPlayerTwo = playerTwoCreatures[1];
        }
        else
        {
            currentPlayerTwo = playerTwoCreatures[2];
        }
        return currentPlayerTwo;
    }
    
    /**
     * playerOneTurn returns whos turn it is
     * 
     * @param There are no parameters
     * @return who's turn it is
     */
    public boolean playerOneTurn()
    {
        return playerOneTurn;
    }
    
    /**
     * gdjytrytjrytjtytjretrdtd
     * 
     * what?
     */
    public String currentCreature()
    {
        return playerTwoCreature;
    }
    
    /**
     * changePlayerOne adds in new menus when the current creature 
     * for playerOne has changed
     * 
     * @param a playeOne creatures Name (string)
     * @return nothing
     */
    public void changePlayerOne( String creature )
    {
        playerOneCreature = creature;
        
        removeObject(oneFightMenu);
        removeObject(oneSwitchMenu);
        
        playerOneMenusAdded = false;
    }
    
     /**
     * changePlayerTwo adds in new menus when the current creature 
     * for playerTwo has changed
     * 
     * @param a playeTwo creatures Name (string)
     * @return nothing
     */
    public void changePlayerTwo( String creature )
    {
        playerTwoCreature = creature;
        
        removeObject(twoFightMenu);
        removeObject(twoSwitchMenu);
        
        playerTwoMenusAdded = false;
    }
    
     /**
     * changeTurn checks whether or not it is player one's turn
     * 
     * @param boolean is it player ones turn
     * @return nothing
     */
    public void changeTurn( boolean isPlayerOne )
    {
        playerOneTurn = isPlayerOne;
    }
    
     /**
     * getNewOneCreature checks and returns creatures from the playerOneCreatures index
     * 
     * @param a number index 
     * @return playerOneCreatures index
     */
    public Creature getNewOneCreature( int index )
    {
        return playerOneCreatures[index];
    }
    
     /**
     * getNewOneCreature checks and returns creatures from the playerTwoCreatures index
     * 
     * @param There are no parameters
     * @return playerTwoCreatures index
     */
    public Creature getNewTwoCreature( int index )
    {
        return playerTwoCreatures[index];
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
        boolean playerOneLose = true;
        boolean playerTwoLose = true;
        
        if ( start == true )
        {
            playerOneName = JOptionPane.showInputDialog( "Player One, please enter your name:", null );
            playerTwoName = JOptionPane.showInputDialog( "Player Two, please enter your name:", null );

            start = false;
            playerOneTurn = true;
        }
        else if( playerOneTurn == true ) 
        {
            showText( playerOneName + ", Your Turn.", getWidth() / 2 , getHeight() / 2 + 26);
        }
        else
        {
            showText( playerTwoName + ", Your Turn.", getWidth() / 2 , getHeight() / 2 + 26);
        }
            
        if( playerOneMenusAdded == false )
        {
            if( playerOneCreature.equalsIgnoreCase("Charmander"))
            {
                oneFightMenu = new Menu( " Fight ", " Scratch \n Flamethrower ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                
                oneSwitchMenu = new Menu(" Switch ", " Golem \n Ivysaur ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            else if(playerOneCreature.equalsIgnoreCase("Golem"))
            {
                oneFightMenu = new Menu( " Fight ", " tackle \n Earthquake ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                
                oneSwitchMenu = new Menu(" Switch ", " Charmander \n Ivysaur ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            else if( playerOneCreature.equalsIgnoreCase("Ivysaur"))
            {
                oneFightMenu = new Menu( " Fight ", " Quick Attack \n Razor Leaf ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
               
                oneSwitchMenu = new Menu(" Switch ", " Charmander \n Golem ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            addObject( oneFightMenu, 177, getHeight() - 100 );
            addObject( oneSwitchMenu, 241, getHeight() - 100 );

            playerOneMenusAdded = true;
        }
        
        if( playerTwoMenusAdded == false )
        {
            if( playerTwoCreature.equalsIgnoreCase("Pikachu"))
            {
                twoFightMenu = new Menu( " Fight ", " Tackle \n ThunderBolt ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());

                twoSwitchMenu = new Menu(" Switch ", " Lapras \n Pidgeot ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            else if( playerTwoCreature.equalsIgnoreCase("Lapras"))
            {
                twoFightMenu = new Menu( " Fight ", " Tackle \n Hydro Pump ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());

                twoSwitchMenu = new Menu(" Switch ", " Pikachu \n Pidgeot ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            else if( playerTwoCreature.equalsIgnoreCase("Pidgeot"))
            {
                twoFightMenu = new Menu( " Fight ", " Tackle \n Wing Attack ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());

                twoSwitchMenu = new Menu(" Switch ", " Pikachu \n Lapras ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            addObject( twoFightMenu, 135,  75 );
            addObject( twoSwitchMenu, 199, 75 );

            playerTwoMenusAdded = true;
        }
        
        for( int i = 0; playerOneLose == true && i < playerOneCreatures.length; i++ )
        {
            if(playerOneCreatures[i].getHealthBar().getCurrent() > 0 )
            {
                playerOneLose = false;
            }
        }

        for( int j = 0; playerTwoLose == true && j < playerTwoCreatures.length; j++ )
        {
            if(playerTwoCreatures[j].getHealthBar().getCurrent() > 0 )
            {
                playerTwoLose = false;
            }
        }
        
        if ( playerOneLose == true)
        {
            removeObjects(allObjects);
           
            showText("player Two has Won", getWidth()/2, getHeight()/2 + 26);
            
            Greenfoot.stop();
        }
        
        if ( playerTwoLose == true)
        {
            //Should have removeObjects line
            showText("player One has Won", getWidth()/2, getHeight()/2 + 26);
                
            Greenfoot.stop();
        }
        
    }
}
