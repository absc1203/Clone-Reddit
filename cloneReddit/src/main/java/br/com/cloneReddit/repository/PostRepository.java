package br.com.cloneReddit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cloneReddit.model.Post;
import br.com.cloneReddit.model.Subreddit;
import br.com.cloneReddit.model.User;

public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findAllBySubreddit(Subreddit subreddit);

	List<Post> findByUser(User user);
}
