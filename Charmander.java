import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.*;

/**
 * Programed by Devyn Desrosiers
 * lol 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Charmander extends Creature
{
    
    
    public Charmander( World w)
    {
        super(700, true, "Fire");
        getImage().scale(150, 100);
        w.addObject( getHealthBar(), 300, w.getHeight() - 50 );

    }
    
    public void attack( int idx )
    {
        CreatureWorld world = (CreatureWorld)getWorld();
        
        Creature enemy = world.getPlayerTwo();
        
        String enemyType = enemy.getType();
        attackAnimation();
        if( idx == 0 )
        {
            enemy.getHealthBar().add( -25 );
            attackAnimation();
        }
        else
        {
            if( enemyType.equalsIgnoreCase("Water") )
            {
                enemy.getHealthBar().add( -70/2 );
                getWorld().showText("Wrong Pokemon Bro!!!", world.getWidth(),  world.getHeight());
                attackAnimation();
                Greenfoot.delay(30);
            }
            else
            {
                enemy.getHealthBar().add( -70 );
                attackAnimation();
                Greenfoot.delay(30);
            }
        }
        world.changeTurn(false);
    }
    
    public void switchCreature( int idx )
    {
        CreatureWorld world = (CreatureWorld)getWorld();
        Creature switchCreature;
        if(idx == 0)
        {
            world.getNewOneCreature(1);
        }
        else
        {
            world.getNewOneCreature(2);
        }
        
        if(switchCreature.getHealthBar().getCurrent() >= 0  )
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
            switchCreature.getImage().setTransparency(0);
            getHealthBar().getImage().setTransparency(0);
        }
        
        if(idx == 0 )
        {
            world.changePlayerOne("Golem");
        }
        else
        {
            world.changePlayerOne("Ivysaur");
        }
        switchCreature.switchedIn();
        world.setTurn = false;
    }
    
    private void attackAnimation()
    {
        int originalX = getX();
        int originalY = getY();
        for (int i = 0; i >= 14; i++)
        {
            setLocation( getX() + 1, getY() - 2);
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
        }
    }    
}
