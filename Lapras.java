import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;

/**
 * Programed by Devyn Desrosiers
 * lol 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lapras extends Creature
{
     /**
     * Lapras defines the creature "Lapras"
     * 
     * @param info about"Lapras"
     * @return Nothing is returned
     */
    public Lapras( World w)
    {
        super(900, false, "Water");
        getImage().scale(150, 100);
        w.addObject( getHealthBar(), 100, 50 );
        getHealthBar().getImage().setTransparency(0);
    }
    
     /**
     * attack allows creatures to damage each other
     * 
     * @param enemy is hte opposing creature
     * @param enemyType checks the type of the enemy
     * 
     * @return Nothing is returned
     */
    public void attack( int idx )
    {
        CreatureWorld world = (CreatureWorld)getWorld();
        
        Creature enemy = world.getPlayerOne();
        String enemyType = enemy.getType();
        
        attackAnimation();
        if( idx == 0 )
        {
            enemy.getHealthBar().add( -30 );
        }
        else
        {
            if( enemyType.equalsIgnoreCase("Rock") )
            {
                enemy.getHealthBar().add( -100*2 );
                getWorld().showText("Hyper Kill!!!", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
                Greenfoot.delay(30);
            }
            else if( enemyType.equalsIgnoreCase("Fire") )
            {
                enemy.getHealthBar().add( -100*2 );
                getWorld().showText("Your Winning, Broken!!", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
                Greenfoot.delay(30);
            }
            else if(enemyType.equalsIgnoreCase("Grass"))
            {
                enemy.getHealthBar().add( -100/2 );
                getWorld().showText("(Insert Insulting Comment here)!", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
                Greenfoot.delay(30);
            }
            else
            {
                enemy.getHealthBar().add( -100 );
            }
        }
        
        world.changeTurn(true);
    }
    
     /**
     * attackAnimation animates the attack of the creature
     * 
     * @param originalX returns the X value the creature started at
     * @param originalY returns the Y value the creature started at
     * 
     * @return Nothing is returned
     */
    private void attackAnimation()
    {
        int originalX = getX();
        int originalY = getY();
        for (int i = 0; i <= 14; i++)
        {
            setLocation( getX() - 1, getY() + 2);
            Greenfoot.delay(2);
        }
        setLocation( originalX, originalY);
    }
    
     /**
     * attack allows creatures to which out with other creatures
     * 
     * @param switchCreature is defined as which creature is being sent out
     * 
     * @return Nothing is returned
     */
    public void switchCreature( int idx )
    {
        CreatureWorld world = (CreatureWorld)getWorld();
        Creature switchCreature;
        if(idx == 0)
        {
            switchCreature = world.getNewTwoCreature(0);
        }
        else
        {
            switchCreature = world.getNewTwoCreature(2);
        }
        
        if(switchCreature.getHealthBar().getCurrent() <= 0  )
        {
            JOptionPane.showMessageDialog( null, "This creature has fainted! Please select a different creature." );
        }
        else
        {
            while(getX() < getWorld().getWidth() - 1)
            {
                setLocation(getX() + 5, getY());
                Greenfoot.delay(2);
            }
            getImage().setTransparency(0);
            getHealthBar().getImage().setTransparency(0);
            if(idx == 0 )
            {
                world.changePlayerTwo("Pikachu");
            }
            else
            {
                world.changePlayerTwo("Pidgeot");
            }
            switchCreature.switchedIn();
            world.changeTurn(true);
        }
    }
    
     /**
     * switchedIn changes the opacity of the creature switched effectively changing the current creature
     * 
     * @param there are no parameters
     * 
     * @return Nothing is returned
     */
    public void switchedIn()
    {
        getImage().setTransparency(255);
        getHealthBar().getImage().setTransparency(255);
        
        while(getX() > 325)
        {
            setLocation(getX() - 5, getY() );
            Greenfoot.delay(2);
        }
    }
    
    /**
     * Act - do whatever the Lapras wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        CreatureWorld playerWorld = (CreatureWorld)getWorld();
        
        if (getHealthBar().getCurrent() <= 0)
        {
            getWorld().showText("Lapras has fainted…", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
            Greenfoot.delay(30);
            if(playerWorld.getNewTwoCreature(0).getHealthBar().getCurrent() > 0 )
            {
                switchCreature(2);
                playerWorld.changeTurn(false);
                playerWorld.showText("", playerWorld.getWidth(), playerWorld.getHeight() + 26);
                playerWorld.removeObject(this);
            }
            else if(playerWorld.getNewTwoCreature(2).getHealthBar().getCurrent() > 0 )
            {
                switchCreature(0);
                playerWorld.changeTurn(false);
                playerWorld.showText("", playerWorld.getWidth(), playerWorld.getHeight() + 26);
                playerWorld.removeObject(this);
            }
        }
    }    
}