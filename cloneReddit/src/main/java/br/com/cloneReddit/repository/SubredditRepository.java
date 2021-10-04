package br.com.cloneReddit.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.cloneReddit.model.Subreddit;

public interface SubredditRepository extends JpaRepository<Subreddit, Long> {

	Optional<Subreddit> findByName(String subredditName);
}
