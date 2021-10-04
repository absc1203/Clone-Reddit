package br.com.cloneReddit.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.cloneReddit.model.Post;
import br.com.cloneReddit.model.User;
import br.com.cloneReddit.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {

	Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User correntUser);

}
