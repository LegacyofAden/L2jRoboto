package com.elfocrash.roboto.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.elfocrash.roboto.FakePlayer;
import com.elfocrash.roboto.FakePlayerManager;
import com.elfocrash.roboto.model.SupportSpell;

import javafx.util.Pair;
import net.sf.l2j.gameserver.model.ShotType;

/**
 * @author Elfocrash
 *
 */
public class SpellSignerAI extends FakePlayerAI
{
	private List<Pair<Integer,Double>> _offensiveSpells;
	
	public SpellSignerAI(FakePlayer character)
	{
		super(character);		
	}
	
	@Override
	public void thinkAndAct()
	{
		if(_fakePlayer.isDead()) {
			return;
		}
		
		applyDefaultBuffs();
		handleShots();
		
		tryTargetRandomCreatureByTypeInRadius(FakePlayer.class, 1200);	
		
		tryAttackingUsingMageOffensiveSkill();
	}
	
	@Override
	protected ShotType getShotType()
	{
		return ShotType.BLESSED_SPIRITSHOT;
	}
	
	@Override
	protected List<Pair<Integer, Double>> getOffensiveSpells()
	{
		_offensiveSpells = new ArrayList<>();
		_offensiveSpells.add(new Pair<>(1235, 25d));
		_offensiveSpells.add(new Pair<>(1340, 25d));
		_offensiveSpells.add(new Pair<>(1342, 25d));
		_offensiveSpells.add(new Pair<>(1265, 25d));
		return _offensiveSpells; 
	}
	
	@Override
	protected int[][] getBuffs()
	{
		return FakePlayerManager.INSTANCE.getMageBuffs();
	}

	@Override
	protected List<Pair<Integer, Double>> getHealingSpells()
	{		
		return Collections.emptyList();
	}
	
	@Override
	protected List<SupportSpell> getSelfSupportSpells() {
		return Collections.emptyList();
	}
}