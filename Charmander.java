import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;

/**
 * Programed by Devyn Desrosiers
 * lol 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Charmander extends Creature
{
     /**
     * Charmander defines the creature "Charmander"
     * 
     * @param info about"Charmander"
     * @return Nothing is returned
     */
    public Charmander( World w)
    {
        super(700, true, "Fire");
        getImage().scale(150, 100);
        w.addObject( getHealthBar(), 300, w.getHeight() - 50 );

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
        
        Creature enemy = world.getPlayerTwo();
        
        String enemyType = enemy.getType();
        attackAnimation();
        if( idx == 0 )
        {
            enemy.getHealthBar().add( -25 );
        }
        else
        {
            if( enemyType.equalsIgnoreCase("Water") )
            {
                enemy.getHealthBar().add( -70/2 );
                getWorld().showText("Wrong Pokemon Bro!!!", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
                Greenfoot.delay(30);
            }
            else
            {
                enemy.getHealthBar().add( -70 );
                Greenfoot.delay(30);
            }
        }
        world.changeTurn(false);
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
            switchCreature = world.getNewOneCreature(1);
        }
        else
        {
            switchCreature = world.getNewOneCreature(2);
        }
        
        if(switchCreature.getHealthBar().getCurrent() <= 0  )
        {
            JOptionPane.showMessageDialog( null, "This creature has fainted! Please select a different creature." );
        }
        else
        {
            while(getX() > 0)
            {
                setLocation(getX() - 5, getY());
                Greenfoot.delay(2);
            }
            getImage().setTransparency(0);
            getHealthBar().getImage().setTransparency(0);
            
            if(idx == 0 )
            {
                world.changePlayerOne("Golem");
            }
            else
            {
                world.changePlayerOne("Ivysaur");
            }
            switchCreature.switchedIn();
            world.changeTurn(false);
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
        
        while(getX() < 75)
        {
            setLocation(getX() + 5, getY());
            Greenfoot.delay(2);
        }
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
            setLocation( getX() + 1, getY() - 2);
            Greenfoot.delay(2);
        }
        setLocation( originalX, originalY);
    }
    
    /**
     * Act - do whatever the Charmander wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        CreatureWorld playerWorld = (CreatureWorld)getWorld();
        
        if (getHealthBar().getCurrent() <= 0)
        {
            getWorld().showText("Charmander has fainted…", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
            Greenfoot.delay(30);
            if(playerWorld.getNewOneCreature(1).getHealthBar().getCurrent() > 0 )
            {
                switchCreature(0);
                playerWorld.changeTurn(true);
                playerWorld.showText("", playerWorld.getWidth(), playerWorld.getHeight() + 26);
                playerWorld.removeObject(this);
            }
            else if(playerWorld.getNewOneCreature(2).getHealthBar().getCurrent() > 0 )
            {
                switchCreature(1);
                playerWorld.changeTurn(true);
                playerWorld.showText("", playerWorld.getWidth(), playerWorld.getHeight() + 26);
                playerWorld.removeObject(this);
            }
        }
    }    
}
