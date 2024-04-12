package org.example.webflux.crud.repository;

import org.example.webflux.crud.domain.entity.Post;
import org.example.webflux.crud.domain.entity.User;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
@Repository
@RequiredArgsConstructor
public class PostCustomR2dbcRepositoryImpl implements PostCustomR2dbcRepository{
	private final DatabaseClient databaseClient;

	@Override
	public Flux<Post> findByUserId (Long userId) {

		// TODO 조인문 나중에 작성해놓기
		var sql = """
  					select ...  
  					from posts p LEFT JOIN users u ON p.user_id = u.id where p.user_id = :userId
  					""";
		return databaseClient.sql(sql)
			.bind("userId", userId)
			.fetch()
			.all()
			.map(row -> Post.builder()
				.id((Long) row.get("pid"))
				.userId((Long) row.get("userId"))
				.title((String) row.get("title"))
				.content((String)row.get("content"))
				.user(User.builder()
					.id( (Long) row.get("uid"))
					.name((String)row.get("name"))
					.email((String)row.get("email"))
					.createdAt(row.get("uCreateAt")))
					.build()
				)
			.build());

	}

}
