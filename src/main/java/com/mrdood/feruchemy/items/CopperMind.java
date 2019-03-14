package com.mrdood.feruchemy.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class CopperMind extends ModItemSuper{
	public CopperMind(){
		
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
	    stack.setTagCompound(nbt);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		if(!world.isRemote){
			//System.out.println("clicked");
			NBTTagCompound nbt;
			if (stack.hasTagCompound()){
				nbt = stack.getTagCompound();
				//System.out.println("41");
			}
			else{
				nbt = new NBTTagCompound();
				//System.out.println("44");
			}
			if(!nbt.hasKey("mindOwner")){
				nbt.setString("mindOwner", player.getDisplayName());
				//System.out.println("49");
			}
			if(!nbt.hasKey("stored")){
				nbt.setInteger("stored",0);
				//System.out.println("53");
			}
			if(player.isSneaking() && player.experienceLevel > 0 && player.getDisplayName().equals(nbt.getString("mindOwner"))){
				player.addExperienceLevel(-1);
				nbt.setInteger("stored", nbt.getInteger("stored") + 1);
				//System.out.println(player.experienceLevel);
			}else if(!player.isSneaking() && nbt.getInteger("stored") > 0 && player.getDisplayName().equals(nbt.getString("mindOwner"))){
				player.addExperienceLevel(1);
				nbt.setInteger("stored", nbt.getInteger("stored") - 1);
				//System.out.println(player.experienceLevel);
			}else if(!player.getDisplayName().equals(nbt.getString("mindOwner"))){
				chat(player);
			}
			stack.setTagCompound(nbt);
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
			lores.add("Levels Stored: "+(stack.getTagCompound().getInteger("stored")));
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
