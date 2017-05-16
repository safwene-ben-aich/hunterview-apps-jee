package tn.hunterViews.business;

import java.util.List;

import javax.ejb.Remote;

import tn.hunterViews.domain.Skill;

@Remote
public interface SkillBusinessRemote {
	public List<Skill> getSkills();

	public int createSkill(Skill sk);

	public int  updateSkill(int id, Skill sk);

	public int  deleteSkill(int id);

	//public Skill findSkillById(int id);
}
