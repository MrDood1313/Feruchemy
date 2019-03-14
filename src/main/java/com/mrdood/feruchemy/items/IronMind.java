package com.mrdood.feruchemy.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;

public class IronMind extends ModItemSuper{
	private int isTappingActive = 0;
	private int isStoringActive = 0;
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack){
		NBTTagCompound nbt;
	    if (stack.hasTagCompound()){
	        nbt = stack.getTagCompound();
	    }
	    else{
	        nbt = new NBTTagCompound();
	    }
		if(nbt.getBoolean("isStoring") || nbt.getBoolean("isTapping")){
			return true;
		}
	    return false;
	}
	
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity player, int pInt, boolean b){
		NBTTagCompound nbt;
	    if (stack.hasTagCompound()){
	        nbt = stack.getTagCompound();
	    }
	    else{
	        nbt = new NBTTagCompound();
	    }
	    if(((EntityPlayer) player).getDisplayName().equals(nbt.getString("mindOwner"))){
	    	if(nbt.getInteger("stored") < 1000 && nbt.getBoolean("isStoring")){
	    		nbt.setInteger("stored", nbt.getInteger("stored") + 1);
				//System.out.println("storing"+player);
				((EntityPlayer) player).addPotionEffect(new PotionEffect(Potion.jump.getId(),20,2));
		    }
		    if(nbt.getInteger("stored") > 0 && nbt.getBoolean("isTapping")){
		    	nbt.setInteger("stored", nbt.getInteger("stored") - 1);
				//System.out.println("tapping"+player);
				if(player.motionY < 0){
					player.motionY *= 2;
				}
				((EntityPlayer) player).addPotionEffect(new PotionEffect(new PotionEffect(Potion.moveSlowdown.getId(),20,2)));
		    }
		    
		    
	    }
	    
	}
	
	@Override
	public void onCreated(ItemStack stack,World world,EntityPlayer player){
		NBTTagCompound nbt;
	    if (stack.hasTagCompound()){
	        nbt = stack.getTagCompound();
	    }
	    else{
	        nbt = new NBTTagCompound();
	    }
	    if(!nbt.hasKey("mindOwner")){
	    	nbt.setString("mindOwner", player.getDisplayName());
	    }
	    if(!nbt.hasKey("stored")){
	    	nbt.setInteger("stored",0);
	    }
	    if(!nbt.hasKey("isStoring")){
	    	nbt.setBoolean("isStoring", false);
	    }
	    if(!nbt.hasKey("isTapping")){
	    	nbt.setBoolean("isTapping", false);
	    }
	    
	    stack.setTagCompound(nbt);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		if(!world.isRemote){
			NBTTagCompound nbt;
			if (stack.hasTagCompound()){
				nbt = stack.getTagCompound();
			}
			else{
				nbt = new NBTTagCompound();
			}
			if(!nbt.hasKey("mindOwner")){
				nbt.setString("mindOwner", player.getDisplayName());
			}
			if(!nbt.hasKey("stored")){
		    	nbt.setInteger("stored",0);
		    }
			if(!nbt.hasKey("isStoring")){
		    	nbt.setBoolean("isStoring", false);
		    }
		    if(!nbt.hasKey("isTapping")){
		    	nbt.setBoolean("isTapping", false);
		    }
		    stack.setTagCompound(nbt);
			if(player.isSneaking() && isStoringActive == 0 && isTappingActive == 0 && nbt.getInteger("stored") < 1000 && player.getDisplayName().equals(nbt.getString("mindOwner"))){//storing
				isStoringActive = 1;
				isTappingActive = 0;
				nbt.setBoolean("isStoring", true);
				nbt.setBoolean("isTapping", false);
			}else if(!player.isSneaking() && isStoringActive == 0 && isTappingActive == 0 && nbt.getInteger("stored") > 0 && player.getDisplayName().equals(nbt.getString("mindOwner"))){//tapping
				isStoringActive = 0;
				isTappingActive = 1;
				nbt.setBoolean("isStoring", false);
				nbt.setBoolean("isTapping", true);
			}else if(player.getDisplayName().equals(nbt.getString("mindOwner"))){
				isStoringActive = 0;
				isTappingActive = 0;
				nbt.setBoolean("isStoring", false);
				nbt.setBoolean("isTapping", false);
				player.clearActivePotions();
			}else{
				chat(player);
			}
			
		}
		return stack;
	}
	
	@SideOnly(Side.CLIENT)
	public void chat(EntityPlayer player){
		player.addChatMessage(new ChatComponentText("You cannot access another person's metalminds!"));
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	@Override
	public void addInformation(ItemStack stack,EntityPlayer player,List lores,boolean b){
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("mindOwner")){
			lores.add("Owner: "+stack.getTagCompound().getString("mindOwner"));
			lores.add("Weight Stored: "+(stack.getTagCompound().getInteger("stored")/10.0)+"%");
			
		}
	}
	
	
	@Override
    public boolean showDurabilityBar(ItemStack itemStack)
    {
        return true;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack itemStack)
    {
        if (itemStack.getTagCompound() == null || !itemStack.getTagCompound().hasKey("stored"))
        {
            itemStack.stackTagCompound = new NBTTagCompound();
            itemStack.getTagCompound().setInteger("stored", 0);
        }

        return (1000 - itemStack.getTagCompound().getInteger("stored")) / 1000.0;
    }
    
}
