package br.com.cloneReddit.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cloneReddit.dto.SubredditDto;
import br.com.cloneReddit.model.Subreddit;
import br.com.cloneReddit.repository.SubredditRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static java.util.stream.Collectors.toList;

import java.util.List;

import static java.time.Instant.now;

@Service
@Slf4j
@AllArgsConstructor
public class SubredditService {
	
	private final SubredditRepository subRedditRepository;

	@Transactional
	public SubredditDto save(SubredditDto subredditDto) {
		Subreddit save = subRedditRepository.save(mapSubredditDto(subredditDto));
		subredditDto.setId(save.getId());
		return subredditDto;

	}
	
	@Transactional(readOnly = true)
	public List<SubredditDto> getAll() {
		return subRedditRepository.findAll().stream().map(this::mapToDto).collect(toList());
		
	}
	
	private SubredditDto mapToDto(Subreddit subreddit) {
		return SubredditDto.builder().name(subreddit.getName())
				.id(subreddit.getId()).numberOfPosts(subreddit.getPosts().size()).build();
	}

	private Subreddit mapSubredditDto(SubredditDto subredditDto) {
		return Subreddit.builder().name(subredditDto.getName())
				.description(subredditDto.getDescription()).build();
	}

	



	

}
