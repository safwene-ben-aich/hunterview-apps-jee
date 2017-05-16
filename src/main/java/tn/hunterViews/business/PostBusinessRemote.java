package tn.hunterViews.business;

import java.util.List;

import javax.ejb.Remote;

import tn.hunterViews.domain.Post;

@Remote
public interface PostBusinessRemote {
	public List<Post> getPosts();


	public int createPost(Post ps);

	public int updatePost(int id, Post ps);

	public int deletePost(int id);

//	public Post findPostById(int id);
}
