package tn.hunterViews.business;

import java.util.List;

import javax.ejb.Remote;

import tn.hunterViews.domain.Evaluations;

@Remote
public interface EvaluationBusinessRemote {

	List<Evaluations> getEvaluation();

	int createEvaluation(Evaluations evaluation);

	//Evaluations findEvaluationById(int id);

	int deleteEvaluation(int id);

	int updateEvaluation(int id, Evaluations evaluation);

}
