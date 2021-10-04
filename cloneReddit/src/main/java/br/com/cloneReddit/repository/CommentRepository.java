package br.com.cloneReddit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.cloneReddit.model.Comment;
import br.com.cloneReddit.model.Post;
import br.com.cloneReddit.model.User;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByPost(Post post);

	List<Comment> findAllByUser(User user);

}
